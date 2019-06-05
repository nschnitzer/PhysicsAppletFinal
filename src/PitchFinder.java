

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.jvm.JVMAudioInputStream;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;
import be.tarsos.dsp.util.fft.FFT;

public class PitchFinder extends JFrame implements PitchDetectionHandler {


	/**
	 *  Whatever the hell this thing is... Wouldnt compile without it...
	 */
	private static final long serialVersionUID = -6153964076527094208L;
	
	
	private final PitchFinderPanel panel;
	private AudioDispatcher dispatcher;
	private Mixer currentMixer = AudioSystem.getMixer(Shared.getMixerInfo(false, true).get(0));	
	private PitchEstimationAlgorithm algo;
	private double pitch; 

	private float sampleRate = 44100;
	private int bufferSize = 1024 * 4;
	private int overlap = 768 * 4 ;



	public PitchFinder() throws LineUnavailableException, UnsupportedAudioFileException{
		panel = new PitchFinderPanel();
		algo = PitchEstimationAlgorithm.DYNAMIC_WAVELET;
		setNewMixer(currentMixer);
	}

	AudioProcessor fftProcessor = new AudioProcessor(){

		FFT fft = new FFT(bufferSize);
		float[] amplitudes = new float[bufferSize/2];

		@Override
		public void processingFinished() {
			// TODO Auto-generated method stub
		}

		@Override
		public boolean process(AudioEvent audioEvent) {
			float[] audioFloatBuffer = audioEvent.getFloatBuffer();
			float[] transformbuffer = new float[bufferSize*2];
			System.arraycopy(audioFloatBuffer, 0, transformbuffer, 0, audioFloatBuffer.length); 
			fft.forwardTransform(transformbuffer);
			fft.modulus(transformbuffer, amplitudes);
			if (pitch != 0)
			panel.showFreq(pitch);
			return true;
		}

	};

	private void setNewMixer(Mixer mixer) throws LineUnavailableException, UnsupportedAudioFileException {

		if(dispatcher!= null){
			dispatcher.stop();
		}
		final AudioFormat format = new AudioFormat(sampleRate, 16, 1, true,
				false);
		final DataLine.Info dataLineInfo = new DataLine.Info(
				TargetDataLine.class, format);
		TargetDataLine line;
		line = (TargetDataLine) mixer.getLine(dataLineInfo);
		final int numberOfSamples = bufferSize;
		line.open(format, numberOfSamples);
		line.start();
		final AudioInputStream stream = new AudioInputStream(line);

		JVMAudioInputStream audioStream = new JVMAudioInputStream(stream);
		// create a new dispatcher
		dispatcher = new AudioDispatcher(audioStream, bufferSize,
				overlap);
		currentMixer = mixer;

		// add a processor, handle pitch event.
		dispatcher.addAudioProcessor(new PitchProcessor(algo, sampleRate, bufferSize, this));
		dispatcher.addAudioProcessor(fftProcessor);

		// run the dispatcher (on a new thread).
		new Thread(dispatcher,"Audio dispatching").start();
	}

	public void handlePitch(PitchDetectionResult pitchDetectionResult,AudioEvent audioEvent) {
		if(pitchDetectionResult.getPitch() != -1){
			double timeStamp = audioEvent.getTimeStamp();
			float pitch = pitchDetectionResult.getPitch();
			float probability = pitchDetectionResult.getProbability();
			double rms = audioEvent.getRMS() * 100;
			if ((int)pitch != 0)
			{
				panel.showFreq(Double.parseDouble(Float.toString(pitch)));
			}
		}
	}
}
