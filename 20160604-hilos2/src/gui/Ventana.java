package gui;

import hilos.*;

import java.awt.event.*;

import javax.swing.*;

public class Ventana extends JFrame {
	private JScrollPane scrollPaneIzq;
	private JScrollPane scrollPaneDer;
	private JTextArea textAreaIzq;
	private JButton btnContinuarIzq;
	private JButton btnPararDer;
	private JButton btnArranqueDer;
	private JButton btnInterrumpirDer;
	private JButton btnContinuarDer;
	private JButton btnPararIzq;
	private JButton btnInterrumpirIzq;
	private JButton btnArranqueIzq;
	private JTextArea textAreaDer;
	private MiThread threadDer;
	private MiThread threadIzq;

	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
					.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Ventana();
	}

	public Ventana() {
		super();
		iniciarGUI();
	}

	private void iniciarGUI() {
		try {
			this.setTitle("Probando funcionamiento de Threads");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setLayout(null);

			scrollPaneIzq = new JScrollPane();
			this.add(scrollPaneIzq);
			scrollPaneIzq.setBounds(0, 0, 360, 375);
			textAreaIzq = new JTextArea();
			scrollPaneIzq.setViewportView(textAreaIzq);
			scrollPaneIzq
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

			scrollPaneDer = new JScrollPane();
			this.add(scrollPaneDer);
			scrollPaneDer.setBounds(359, 0, 360, 375);
			textAreaDer = new JTextArea();
			scrollPaneDer.setViewportView(textAreaDer);
			scrollPaneDer
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

			btnArranqueIzq = new JButton();
			this.add(btnArranqueIzq);
			btnArranqueIzq.setText("Iniciar");
			btnArranqueIzq.setBounds(1, 378, 71, 21);
			btnArranqueIzq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnArranqueIzqActionPerformed(evt);
				}
			});

			btnInterrumpirIzq = new JButton();
			this.add(btnInterrumpirIzq);
			btnInterrumpirIzq.setText("Interrumpir");
			btnInterrumpirIzq.setBounds(77, 378, 108, 21);

			btnContinuarIzq = new JButton();
			this.add(btnContinuarIzq);
			btnContinuarIzq.setText("Continuar");
			btnContinuarIzq.setBounds(190, 378, 92, 21);

			btnPararIzq = new JButton();
			this.add(btnPararIzq);
			btnPararIzq.setText("Parar");
			btnPararIzq.setBounds(286, 378, 72, 21);

			btnPararDer = new JButton();
			this.add(btnPararDer);
			btnPararDer.setText("Parar");
			btnPararDer.setBounds(646, 378, 72, 21);

			btnContinuarDer = new JButton();
			this.add(btnContinuarDer);
			btnContinuarDer.setText("Continuar");
			btnContinuarDer.setBounds(549, 378, 92, 21);

			btnInterrumpirDer = new JButton();
			this.add(btnInterrumpirDer);
			btnInterrumpirDer.setText("Interrumpir");
			btnInterrumpirDer.setBounds(436, 378, 108, 21);

			btnArranqueDer = new JButton();
			this.add(btnArranqueDer);
			btnArranqueDer.setText("Iniciar");
			btnArranqueDer.setBounds(360, 378, 71, 21);
			btnArranqueDer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnArranqueDerActionPerformed(evt);
				}
			});

			btnInterrumpirIzq.setEnabled(false);
			btnInterrumpirIzq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnInterrumpirIzqActionPerformed(evt);
				}
			});
			btnContinuarIzq.setEnabled(false);
			btnContinuarIzq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnContinuarIzqActionPerformed(evt);
				}
			});
			btnPararIzq.setEnabled(false);
			btnPararIzq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnPararIzqActionPerformed(evt);
				}
			});
			btnInterrumpirDer.setEnabled(false);
			btnInterrumpirDer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnInterrumpirDerActionPerformed(evt);
				}
			});
			btnContinuarDer.setEnabled(false);
			btnContinuarDer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnContinuarDerActionPerformed(evt);
				}
			});
			btnPararDer.setEnabled(false);
			btnPararDer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnPararDerActionPerformed(evt);
				}
			});

			this.setResizable(false);
			this.setSize(727, 437);
			this.setLocationRelativeTo(null);
			this.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void btnArranqueIzqActionPerformed(ActionEvent evt) {
		threadIzq = new MiThread(textAreaIzq);
		threadIzq.start();

		btnArranqueIzq.setEnabled(false);
		btnInterrumpirIzq.setEnabled(true);
		btnPararIzq.setEnabled(true);
	}

	private void btnInterrumpirIzqActionPerformed(ActionEvent evt) {
		threadIzq.interrumpir();

		btnInterrumpirIzq.setEnabled(false);
		btnPararIzq.setEnabled(false);
		btnContinuarIzq.setEnabled(true);

	}

	private void btnContinuarIzqActionPerformed(ActionEvent evt) {
		threadIzq.continuar();

		btnContinuarIzq.setEnabled(false);
		btnInterrumpirIzq.setEnabled(true);
		btnPararIzq.setEnabled(true);

	}

	private void btnPararIzqActionPerformed(ActionEvent evt) {
		threadIzq.parar();

		btnArranqueIzq.setEnabled(true);
		btnInterrumpirIzq.setEnabled(false);
		btnContinuarIzq.setEnabled(false);
		btnPararIzq.setEnabled(false);

	}

	private void btnArranqueDerActionPerformed(ActionEvent evt) {
		threadDer = new MiThread(textAreaDer);
		threadDer.start();

		btnArranqueDer.setEnabled(false);
		btnInterrumpirDer.setEnabled(true);
		btnPararDer.setEnabled(true);
	}

	private void btnInterrumpirDerActionPerformed(ActionEvent evt) {
		threadDer.interrumpir();

		btnInterrumpirDer.setEnabled(false);
		btnPararDer.setEnabled(false);
		btnContinuarDer.setEnabled(true);
	}

	private void btnContinuarDerActionPerformed(ActionEvent evt) {
		threadDer.continuar();

		btnContinuarDer.setEnabled(false);
		btnInterrumpirDer.setEnabled(true);
		btnPararDer.setEnabled(true);
	}

	private void btnPararDerActionPerformed(ActionEvent evt) {
		threadDer.parar();

		btnArranqueDer.setEnabled(true);
		btnInterrumpirDer.setEnabled(false);
		btnContinuarDer.setEnabled(false);
		btnPararDer.setEnabled(false);
	}

}
