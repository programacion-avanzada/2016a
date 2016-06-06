import javax.swing.*;
import java.awt.event.*;


public class Dialogo extends JDialog
{
	private Prueba referencia;
	private JTextField textField;
	private JButton btnOk;
	private JButton btnCancel;

	public Dialogo(Prueba referencia)
	{
		super(referencia);
		this.referencia = referencia;
		setModal(true);
		setTitle("Agregar Texto a JTextArea");
		setSize(382, 105);
		setLayout(null);
		textField = new JTextField();
		textField.setBounds(10, 11, 354, 20);
		add(textField);
		textField.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				AgregaTexto();
				dispose();
			}
		});
		btnOk.setActionCommand("OK");
		btnOk.setBounds(247, 42, 47, 23);
		getContentPane().add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
			}
		});
		btnCancel.setActionCommand("Cancel");
		btnCancel.setBounds(299, 42, 65, 23);
		add(btnCancel);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(referencia);
		setVisible(true);
	}
	
	private void AgregaTexto()
	{
		referencia.getTextArea().append(textField.getText() + "\n");
		referencia.getTextArea().setCaretPosition(referencia.getTextArea().getText().length());
	}

}
