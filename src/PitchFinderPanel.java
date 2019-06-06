

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PitchFinderPanel extends JComponent implements ComponentListener
{
	/**
	 * I wasn't planning on serializing but it wants this for some reason
	 */
	private static final long serialVersionUID = -2339852797440765783L;
	
	JFrame frame;
	JPanel panel;
	JLabel disp, frequency;
	int freq = 0;

	public PitchFinderPanel()
	{
		panel = new JPanel();
		panel.add(Box.createVerticalStrut(120));
		disp = new JLabel("The current frequency is:");
		panel.add(disp);
		panel.add(Box.createVerticalStrut(50));
		frequency = new JLabel();
		frequency.setText(freq + " Hz");
		frequency.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(frequency);
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(450, 180));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2,	(int) (dim.height/2.5));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		JOptionPane.showMessageDialog(frame, "The computer is now listening");

	}
	
	public void showFreq(double frequency)
	{
		this.frequency.setText(frequency + " Hz");
		frame.setVisible(true);
	}


	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
