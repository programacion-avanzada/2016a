import javax.swing.*;
import java.awt.event.*;

public class Prueba extends JFrame {
	private JTabbedPane tabbedPane;
	private JPanel panelCombo;
	private JPanel panelLista;
	private JPanel panelTextArea;
	private JTextField txtTextoCombo;
	private JComboBox comboBox;
	private JButton btnAgregarCombo;
	private JTextField txtListaSeleccion;
	private JScrollPane scrollPane;
	private JList lista;
	private JScrollPane scrollPaneTextArea;
	private JButton btnSalir;
	private JButton btnAbrirDialogo;
	private JTextArea textArea;

	public Prueba() {
		super("Prueba de Componentes");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				AbreDialogoConfirmacion();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(450, 291);
		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.setBounds(0, 0, 442, 240);
		panelCombo = new JPanel();
		panelCombo.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setBounds(120, 11, 185, 22);
		panelCombo.add(comboBox);

		txtTextoCombo = new JTextField();
		txtTextoCombo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar() == KeyEvent.VK_ENTER)
					AgregarTextoCombo();
			}
		});

		txtTextoCombo.setBounds(10, 155, 332, 20);
		panelCombo.add(txtTextoCombo);
		txtTextoCombo.setColumns(10);

		btnAgregarCombo = new JButton("Agregar");
		btnAgregarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarTextoCombo();
			}
		});
		btnAgregarCombo.setBounds(348, 154, 89, 23);
		panelCombo.add(btnAgregarCombo);

		tabbedPane.addTab("Ejemplo JComboBox", null, panelCombo, "Tab1");

		panelLista = new JPanel();
		panelLista.setLayout(null);

		txtListaSeleccion = new JTextField();
		txtListaSeleccion.setBounds(10, 161, 417, 20);
		panelLista.add(txtListaSeleccion);
		txtListaSeleccion.setColumns(10);

		tabbedPane.addTab("Ejemplo JList", null, panelLista, "Tab2");

		scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(103, 11, 229, 139);
		panelLista.add(scrollPane);

		JList lista = new JList();
		lista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SeleccionaItemLista(arg0);
			}
		});

		DefaultListModel modeloLista = new DefaultListModel();
		modeloLista.addElement("Herencia");
		modeloLista.addElement("Interfaces");
		modeloLista.addElement("Generics");
		modeloLista.addElement("Collection");
		modeloLista.addElement("Swing");
		lista.setModel(modeloLista);
		scrollPane.setViewportView(lista);

		panelTextArea = new JPanel();
		panelTextArea.setLayout(null);

		scrollPaneTextArea = new JScrollPane();
		scrollPaneTextArea
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTextArea.setBounds(10, 11, 417, 158);
		panelTextArea.add(scrollPaneTextArea);

		textArea = new JTextArea();
		scrollPaneTextArea.setViewportView(textArea);

		btnAbrirDialogo = new JButton("Agregar");
		btnAbrirDialogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirVentanaDialogo();
			}
		});
		btnAbrirDialogo.setBounds(172, 180, 89, 23);
		panelTextArea.add(btnAbrirDialogo);

		tabbedPane.addTab("Ejemplo JTextArea", null, panelTextArea, "Tab3");

		getContentPane().add(tabbedPane);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbreDialogoConfirmacion();
			}
		});

		btnSalir.setBounds(343, 239, 89, 23);
		getContentPane().add(btnSalir);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void AgregarTextoCombo() {
		String texto;

		texto = txtTextoCombo.getText();

		if (texto.length() == 0)
			JOptionPane.showMessageDialog(this,
					"No se ha ingresado ningún texto.");
		else {
			comboBox.addItem(texto);
			txtTextoCombo.setText("");
			JOptionPane.showMessageDialog(this, "Se agrego el texto \"" + texto
					+ "\" al Combo");
		}
	}

	private void AbreDialogoConfirmacion() {
		int respuesta = JOptionPane.showConfirmDialog(this,
				"Desea salir del programa?", getTitle(),
				JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION)
			System.exit(0);

	}

	private void SeleccionaItemLista(MouseEvent evento) {
		int i;
		String temp = "";
		JList tempLista = (JList) evento.getSource();
		Object seleccion[] = tempLista.getSelectedValues();
		for (i = 0; i < seleccion.length; i++)
			temp = temp + "\"" + (String) seleccion[i] + "\" ";
		txtListaSeleccion.setText(temp);
	}

	private void AbrirVentanaDialogo() {
		new Dialogo(this);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
					.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new Prueba();
	}
}
