

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionSelectorPanel extends JPanel
{
	JFrame frame;
	JPanel panel;
	ButtonGroup optionGroup;
	JButton pitchFinder, pitchGenerator;

	public OptionSelectorPanel()
	{
		super(new BorderLayout());
		frame = new JFrame("Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FinderListener flistener = new FinderListener();
		pitchFinder = new JButton("Pitch Finder");
		pitchFinder.addActionListener(flistener);

		SynthListener sListener = new SynthListener();
		pitchGenerator = new JButton("Synthesize Pitch");
		pitchGenerator.addActionListener(sListener);


		JLabel selectorPrompt = new JLabel("Select the utility that you want:");

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(240, 200));
		panel.add(selectorPrompt);
		panel.add(Box.createVerticalStrut(80));
		panel.add(pitchFinder);
		panel.add(Box.createVerticalStrut(50));
		panel.add(pitchGenerator);


		frame.getContentPane().add(panel);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2,	(int) (dim.height/2.5));
		frame.pack();
		frame.setVisible(true);
	}

	private class FinderListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			frame.setVisible(false);
			
			try {
				new PitchFinder();
			} catch (UnsupportedAudioFileException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private class SynthListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			frame.setVisible(false);
			try
			{
				new PitchGenerator();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}

