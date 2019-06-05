
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PitchGenerator {

	// Use PitchConverter to change between Notes
	// 200 Cents = 1 Note
	// C=261.63 Hz
	// D= C + 200 cents
	// E = C + 600 cents...
	// B = C + 1000 cents
	// 1200 cents = 1 octave

	final double START_FREQ = 261.63;
	JFrame frame;
	JPanel panel;
	JRadioButton A0, B0, C0, D0, E0, F0, G0, A1, B1, C1, D1, E1, F1, G1, A2, B2, C2, D2, E2, F2, G2, A3, B3, C3, D3, E3,
			F3, G3;
	JRadioButton A4, B4, C4, D4, E4, F4, G4, A5, B5, C5, D5, E5, F5, G5, A6, B6, C6, D6, E6, F6, G6, A7, B7, C7, D7, E7,
			F7, G7;
	JRadioButton A8, B8, C8, D8, E8, F8, G8;
	ButtonGroup group = new ButtonGroup();
	sinwaveSoundGenerator gen;

	public PitchGenerator() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 600));

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - 400, (int) (dim.height / 4));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		panel = new JPanel();
		panel.setLayout(new GridLayout(9, 7));

		// Fundamental
		A0 = new JRadioButton("A0", true);
		A0Listener a0Listener = new A0Listener();
		A0.addActionListener(a0Listener);
		B0 = new JRadioButton("B0");
		B0Listener b0Listener = new B0Listener();
		B0.addActionListener(b0Listener);
		C0 = new JRadioButton("C0");
		C0Listener c0Listener = new C0Listener();
		C0.addActionListener(c0Listener);
		D0 = new JRadioButton("D0");
		D0Listener d0Listener = new D0Listener();
		D0.addActionListener(d0Listener);
		E0 = new JRadioButton("E0");
		E0Listener e0Listener = new E0Listener();
		E0.addActionListener(e0Listener);
		F0 = new JRadioButton("F0");
		F0Listener f0Listener = new F0Listener();
		F0.addActionListener(f0Listener);
		G0 = new JRadioButton("G0");
		G0Listener g0Listener = new G0Listener();
		G0.addActionListener(g0Listener);

		// 1st Octave
		A1 = new JRadioButton("A1", true);
		A1Listener a1Listener = new A1Listener();
		A1.addActionListener(a1Listener);
		B1 = new JRadioButton("B1");
		B1Listener b1Listener = new B1Listener();
		B1.addActionListener(b1Listener);
		C1 = new JRadioButton("C1");
		C1Listener c1Listener = new C1Listener();
		C1.addActionListener(c1Listener);
		D1 = new JRadioButton("D1");
		D1Listener d1Listener = new D1Listener();
		D1.addActionListener(d1Listener);
		E1 = new JRadioButton("E1");
		E1Listener e1Listener = new E1Listener();
		E1.addActionListener(e1Listener);
		F1 = new JRadioButton("F1");
		F1Listener f1Listener = new F1Listener();
		F1.addActionListener(f1Listener);
		G1 = new JRadioButton("G1");
		G1Listener g1Listener = new G1Listener();
		G1.addActionListener(g1Listener);

		// 2nd Octave
		A2 = new JRadioButton("A2", true);
		A2Listener a2Listener = new A2Listener();
		A2.addActionListener(a2Listener);
		B2 = new JRadioButton("B2");
		B2Listener b2Listener = new B2Listener();
		B2.addActionListener(b2Listener);
		C2 = new JRadioButton("C2");
		C2Listener c2Listener = new C2Listener();
		C2.addActionListener(c2Listener);
		D2 = new JRadioButton("D2");
		D2Listener d2Listener = new D2Listener();
		D2.addActionListener(d2Listener);
		E2 = new JRadioButton("E2");
		E2Listener e2Listener = new E2Listener();
		E2.addActionListener(e2Listener);
		F2 = new JRadioButton("F2");
		F2Listener f2Listener = new F2Listener();
		F2.addActionListener(f2Listener);
		G2 = new JRadioButton("G2");
		G2Listener g2Listener = new G2Listener();
		G2.addActionListener(g2Listener);

		// 3rd Octave
		A3 = new JRadioButton("A3", true);
		A3Listener a3Listener = new A3Listener();
		A3.addActionListener(a3Listener);
		B3 = new JRadioButton("B3");
		B3Listener b3Listener = new B3Listener();
		B3.addActionListener(b3Listener);
		C3 = new JRadioButton("C3");
		C3Listener c3Listener = new C3Listener();
		C3.addActionListener(c3Listener);
		D3 = new JRadioButton("D3");
		D3Listener d3Listener = new D3Listener();
		D3.addActionListener(d3Listener);
		E3 = new JRadioButton("E3");
		E3Listener e3Listener = new E3Listener();
		E3.addActionListener(e3Listener);
		F3 = new JRadioButton("F3");
		F3Listener f3Listener = new F3Listener();
		F3.addActionListener(f3Listener);
		G3 = new JRadioButton("G3");
		G3Listener g3Listener = new G3Listener();
		G3.addActionListener(g3Listener);

		// 4th Octave
		A4 = new JRadioButton("A4", true);
		A4Listener a4Listener = new A4Listener();
		A4.addActionListener(a4Listener);
		B4 = new JRadioButton("B4");
		B4Listener b4Listener = new B4Listener();
		B4.addActionListener(b4Listener);
		C4 = new JRadioButton("C4");
		C4Listener c4Listener = new C4Listener();
		C4.addActionListener(c4Listener);
		D4 = new JRadioButton("D4");
		D4Listener d4Listener = new D4Listener();
		D4.addActionListener(d4Listener);
		E4 = new JRadioButton("E4");
		E4Listener e4Listener = new E4Listener();
		E4.addActionListener(e4Listener);
		F4 = new JRadioButton("F4");
		F4Listener f4Listener = new F4Listener();
		F4.addActionListener(f4Listener);
		G4 = new JRadioButton("G4");
		G4Listener g4Listener = new G4Listener();
		G4.addActionListener(g4Listener);

		// 5th Octave
		A5 = new JRadioButton("A5", true);
		A5Listener a5Listener = new A5Listener();
		A5.addActionListener(a5Listener);
		B5 = new JRadioButton("B5");
		B5Listener b5Listener = new B5Listener();
		B5.addActionListener(b5Listener);
		C5 = new JRadioButton("C5");
		C5Listener c5Listener = new C5Listener();
		C5.addActionListener(c5Listener);
		D5 = new JRadioButton("D5");
		D5Listener d5Listener = new D5Listener();
		D5.addActionListener(d5Listener);
		E5 = new JRadioButton("E5");
		E5Listener e5Listener = new E5Listener();
		E5.addActionListener(e5Listener);
		F5 = new JRadioButton("F5");
		F5Listener f5Listener = new F5Listener();
		F5.addActionListener(f5Listener);
		G5 = new JRadioButton("G5");
		G5Listener g5Listener = new G5Listener();
		G5.addActionListener(g5Listener);

		// 6th Octave
		A6 = new JRadioButton("A6", true);
		A6Listener a6Listener = new A6Listener();
		A6.addActionListener(a6Listener);
		B6 = new JRadioButton("B6");
		B6Listener b6Listener = new B6Listener();
		B6.addActionListener(b6Listener);
		C6 = new JRadioButton("C6");
		C6Listener c6Listener = new C6Listener();
		C6.addActionListener(c6Listener);
		D6 = new JRadioButton("D6");
		D6Listener d6Listener = new D6Listener();
		D6.addActionListener(d6Listener);
		E6 = new JRadioButton("E6");
		E6Listener e6Listener = new E6Listener();
		E6.addActionListener(e6Listener);
		F6 = new JRadioButton("F6");
		F6Listener f6Listener = new F6Listener();
		F6.addActionListener(f6Listener);
		G6 = new JRadioButton("G6");
		G6Listener g6Listener = new G6Listener();
		G6.addActionListener(g6Listener);

		// 7th Octave
		A7 = new JRadioButton("A7", true);
		A7Listener a7Listener = new A7Listener();
		A7.addActionListener(a7Listener);
		B7 = new JRadioButton("B7");
		B7Listener b7Listener = new B7Listener();
		B7.addActionListener(b7Listener);
		C7 = new JRadioButton("C7");
		C7Listener c7Listener = new C7Listener();
		C7.addActionListener(c7Listener);
		D7 = new JRadioButton("D7");
		D7Listener d7Listener = new D7Listener();
		D7.addActionListener(d7Listener);
		E7 = new JRadioButton("E7");
		E7Listener e7Listener = new E7Listener();
		E7.addActionListener(e7Listener);
		F7 = new JRadioButton("F7");
		F7Listener f7Listener = new F7Listener();
		F7.addActionListener(f7Listener);
		G7 = new JRadioButton("G7");
		G7Listener g7Listener = new G7Listener();
		G7.addActionListener(g7Listener);

		// 8th OCtave
		A8 = new JRadioButton("A8", true);
		A8Listener a8Listener = new A8Listener();
		A8.addActionListener(a8Listener);
		B8 = new JRadioButton("B8");
		B8Listener b8Listener = new B8Listener();
		B8.addActionListener(b8Listener);
		C8 = new JRadioButton("C8");
		C8Listener c8Listener = new C8Listener();
		C8.addActionListener(c8Listener);
		D8 = new JRadioButton("D8");
		D8Listener d8Listener = new D8Listener();
		D8.addActionListener(d8Listener);
		E8 = new JRadioButton("E8");
		E8Listener e8Listener = new E8Listener();
		E8.addActionListener(e8Listener);
		F8 = new JRadioButton("F8");
		F8Listener f8Listener = new F8Listener();
		F8.addActionListener(f8Listener);
		G8 = new JRadioButton("G8");
		G8Listener g8Listener = new G8Listener();
		G8.addActionListener(g8Listener);

		group.add(A0);
		group.add(B0);
		group.add(C0);
		group.add(D0);
		group.add(E0);
		group.add(F0);
		group.add(G0);

		group.add(A1);
		group.add(B1);
		group.add(C1);
		group.add(D1);
		group.add(E1);
		group.add(F1);
		group.add(G1);

		group.add(A2);
		group.add(B2);
		group.add(C2);
		group.add(D2);
		group.add(E2);
		group.add(F2);
		group.add(G2);

		group.add(A3);
		group.add(B3);
		group.add(C3);
		group.add(D3);
		group.add(E3);
		group.add(F3);
		group.add(G3);

		group.add(A4);
		group.add(B4);
		group.add(C4);
		group.add(D4);
		group.add(E4);
		group.add(F4);
		group.add(G4);

		group.add(A5);
		group.add(B5);
		group.add(C5);
		group.add(D5);
		group.add(E5);
		group.add(F5);
		group.add(G5);

		group.add(A6);
		group.add(B6);
		group.add(C6);
		group.add(D6);
		group.add(E6);
		group.add(F6);
		group.add(G6);

		group.add(A7);
		group.add(B7);
		group.add(C7);
		group.add(D7);
		group.add(E7);
		group.add(F7);
		group.add(G7);

		group.add(A8);
		group.add(B8);
		group.add(C8);
		group.add(D8);
		group.add(E8);
		group.add(F8);
		group.add(G8);

		// Fundamental
		panel.add(C0);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(D0);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(E0);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(F0);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(G0);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(A0);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(B0);
		panel.add(Box.createVerticalStrut(50));

		// 1st Octave
		panel.add(C1);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(D1);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(E1);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(F1);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(G1);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(A1);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(B1);
		panel.add(Box.createVerticalStrut(50));

		// 2nd Octave
		panel.add(C2);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(D2);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(E2);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(F2);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(G2);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(A2);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(B2);
		panel.add(Box.createVerticalStrut(50));

		// 3rd Octave
		panel.add(C3);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(D3);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(E3);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(F3);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(G3);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(A3);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(B3);
		panel.add(Box.createVerticalStrut(50));

		// 4th Octave
		panel.add(C4);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(D4);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(E4);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(F4);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(G4);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(A4);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(B4);
		panel.add(Box.createVerticalStrut(50));

		// 5th Octave
		panel.add(C5);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(D5);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(E5);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(F5);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(G5);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(A5);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(B5);
		panel.add(Box.createVerticalStrut(50));

		// 6th Octave
		panel.add(C6);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(D6);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(E6);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(F6);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(G6);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(A6);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(B6);
		panel.add(Box.createVerticalStrut(50));

		// 7th Octave
		panel.add(C7);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(D7);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(E7);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(F7);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(G7);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(A7);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(B7);
		panel.add(Box.createVerticalStrut(50));

		// 8th Octave
		panel.add(C8);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(D8);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(E8);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(F8);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(G8);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(A8);
		panel.add(Box.createHorizontalStrut(20));
		panel.add(B8);
		panel.add(Box.createVerticalStrut(50));

		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);

		JOptionPane.showMessageDialog(frame, "Please select the note that you would like to play");

		gen = new sinwaveSoundGenerator(440, 1);
		gen.Play();
	}

	// Fundamental
	private class A0Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (A0.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(28, 1);
				gen.Play();
			}
		}
	}

	private class B0Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (B0.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(31, 1);
				gen.Play();
			}
		}
	}

	private class C0Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (C0.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(16, 1);
				gen.Play();
			}
		}
	}

	private class D0Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (D0.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(18, 1);
				gen.Play();
			}
		}
	}

	private class E0Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (E0.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(20, 1);
				gen.Play();
			}
		}
	}

	private class F0Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (F0.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(22, 1);
				gen.Play();
			}
		}
	}

	private class G0Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (G0.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(24, 1);
				gen.Play();
			}
		}
	}

	// 1st octave
	private class A1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (A1.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(55, 1);
				gen.Play();
			}
		}
	}

	private class B1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (B1.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(62, 1);
				gen.Play();
			}
		}
	}

	private class C1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (C1.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(33, 1);
				gen.Play();
			}
		}
	}

	private class D1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (D1.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(37, 1);
				gen.Play();
			}
		}
	}

	private class E1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (E1.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(41, 1);
				gen.Play();
			}
		}
	}

	private class F1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (F1.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(44, 1);
				gen.Play();
			}
		}
	}

	private class G1Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (G1.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(49, 1);
				gen.Play();
			}
		}
	}

	// 2nd Octave
	private class A2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (A2.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(110, 1);
				gen.Play();
			}
		}
	}

	private class B2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (B2.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(123, 1);
				gen.Play();
			}
		}
	}

	private class C2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (C2.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(65, 1);
				gen.Play();
			}
		}
	}

	private class D2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (D2.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(73, 1);
				gen.Play();
			}
		}
	}

	private class E2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (E2.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(82, 1);
				gen.Play();
			}
		}
	}

	private class F2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (F2.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(87, 1);
				gen.Play();
			}
		}
	}

	private class G2Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (G2.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(98, 1);
				gen.Play();
			}
		}
	}

	// 3rd Octave
	private class A3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (A3.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(220, 1);
				gen.Play();
			}
		}
	}

	private class B3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (B3.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(247, 1);
				gen.Play();
			}
		}
	}

	private class C3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (C3.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(131, 1);
				gen.Play();
			}
		}
	}

	private class D3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (D3.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(147, 1);
				gen.Play();
			}
		}
	}

	private class E3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (E3.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(165, 1);
				gen.Play();
			}
		}
	}

	private class F3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (F3.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(175, 1);
				gen.Play();
			}
		}
	}

	private class G3Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (G3.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(196, 1);
				gen.Play();
			}
		}
	}

	// 4th Octave
	private class A4Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (A4.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(440, 1);
				gen.Play();
			}
		}
	}

	private class B4Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (B4.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(494, 1);
				gen.Play();
			}
		}
	}

	private class C4Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (C4.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(261, 1);
				gen.Play();
			}
		}
	}

	private class D4Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (D4.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(294, 1);
				gen.Play();
			}
		}
	}

	private class E4Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (E4.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(323, 1);
				gen.Play();
			}
		}
	}

	private class F4Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (F4.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(349, 1);
				gen.Play();
			}
		}
	}

	private class G4Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (G4.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(392, 1);
				gen.Play();
			}
		}
	}

	// 5th Octave
	private class A5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (A5.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(880, 1);
				gen.Play();
			}
		}
	}

	private class B5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (B5.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(988, 1);
				gen.Play();
			}
		}
	}

	private class C5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (C5.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(523, 1);
				gen.Play();
			}
		}
	}

	private class D5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (D5.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(587, 1);
				gen.Play();
			}
		}
	}

	private class E5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (E5.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(659, 1);
				gen.Play();
			}
		}
	}

	private class F5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (F5.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(698, 1);
				gen.Play();
			}
		}
	}

	private class G5Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (G5.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(784, 1);
				gen.Play();
			}
		}
	}

	// 6th Octave
	private class A6Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (A6.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(1760, 1);
				gen.Play();
			}
		}
	}

	private class B6Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (B6.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(1975, 1);
				gen.Play();
			}
		}
	}

	private class C6Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (C6.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(1047, 1);
				gen.Play();
			}
		}
	}

	private class D6Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (D6.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(1175, 1);
				gen.Play();
			}
		}
	}

	private class E6Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (E6.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(1319, 1);
				gen.Play();
			}
		}
	}

	private class F6Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (F6.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(1397, 1);
				gen.Play();
			}
		}
	}

	private class G6Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (G6.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(1568, 1);
				gen.Play();
			}
		}
	}

	// 7th Octave
	private class A7Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (A7.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(3520, 1);
				gen.Play();
			}
		}
	}

	private class B7Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (B7.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(3951, 1);
				gen.Play();
			}
		}
	}

	private class C7Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (C7.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(2093, 1);
				gen.Play();
			}
		}
	}

	private class D7Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (D7.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(2349, 1);
				gen.Play();
			}
		}
	}

	private class E7Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (E7.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(2637, 1);
				gen.Play();
			}
		}
	}

	private class F7Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (F7.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(2794, 1);
				gen.Play();
			}
		}
	}

	private class G7Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (G7.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(3136, 1);
				gen.Play();
			}
		}
	}

	// 8th octave
	private class A8Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (A8.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(7040, 1);
				gen.Play();
			}
		}
	}

	private class B8Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (B8.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(7902, 1);
				gen.Play();
			}
		}
	}

	private class C8Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (C8.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(4186, 1);
				gen.Play();
			}
		}
	}

	private class D8Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (D8.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(4699, 1);
				gen.Play();
			}
		}
	}

	private class E8Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (E8.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(5274, 1);
				gen.Play();
			}
		}
	}

	private class F8Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (F8.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(5588, 1);
				gen.Play();
			}
		}
	}

	private class G8Listener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (G8.isSelected()) {
				gen.Stop();
				gen = new sinwaveSoundGenerator(6274, 1);
				gen.Play();
			}
		}
	}

}
