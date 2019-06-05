

import sun.audio.*;


public class sinwaveSoundGenerator
{ 
	public int period,baseF; // base frequency 
	private byte record[];
	private double Y[];
	private static double UNIT=8000.;
	private double omega;//=2.*Math.PI/period
	private java.io.InputStream soundStream=null;
	private boolean playstatus=false;
	private double amplitude,y,amplitudeCST=1000.,A;//maxAmplitude=8160.;
	sinwaveSoundGenerator(int _baseF,double _amplitude){
		baseF=_baseF;
		amplitude=_amplitude;
		setBaseFrequency(baseF);
	}
	public void setBaseFrequency(int _baseF){ // input base frequency
		period=(int)(UNIT/_baseF);
		record=new byte[period];
		Y=new double[period];
		omega=2.*Math.PI/period;
		setit();
	}
	public void setAmplitude(int _amplitude){
		amplitude=_amplitude;
		setit();		
	}
	public void setit(){
		if(playstatus)Stop();
		calc();
		if(playstatus)Play();
	}

	double[] yVal(){ return Y;}
	double getBaseFrequency(){ return baseF;}
	double getAmplitude(){return amplitude;}

	public void Play(){
		try{
			AudioPlayer player2 = AudioPlayer.player;
			AudioPlayer player = player2;
			if(soundStream!=null)player.stop(soundStream);
			soundStream = new ContinuousAudioDataStream(new AudioData(record));
			player.start(soundStream);
		}catch(SecurityException e){
		}
	}
	public void Stop(){
		if(soundStream!=null)
		try{
			AudioPlayer.player.stop(soundStream);
			soundStream=null;
		}catch(SecurityException e){
		}
	}
	public void calc() {
			A=amplitude*amplitudeCST;
				for (int i = 0; i < period; i++){
					y=A*Math.sin(i*omega);
					record[i] = int2ulaw((int)(y));
					Y[i]=y;
				}
	}

	public static byte int2ulaw(int ch) {
		int mask;
		if (ch < 0) {
			ch = -ch;
			mask = 0x7f;
		}else mask = 0xff;

		if (ch < 32) ch = 0xF0 | 15 - (ch/2);
			else if (ch < 96) ch = 0xE0 | 15 - (ch-32)/4;
			else if (ch < 224) ch = 0xD0 | 15 - (ch-96)/8;
			else if (ch < 480) ch = 0xC0 | 15 - (ch-224)/16;
			else if (ch < 992 ) ch = 0xB0 | 15 - (ch-480)/32;
			else if (ch < 2016) ch = 0xA0 | 15 - (ch-992)/64;
			else if (ch < 4064) ch = 0x90 | 15 - (ch-2016)/128;
			else if (ch < 8160) ch = 0x80 | 15 - (ch-4064)/256;
			else ch = 0x80;
		return (byte)(mask & ch);
	}
}
