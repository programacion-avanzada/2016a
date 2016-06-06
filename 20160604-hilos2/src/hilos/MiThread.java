package hilos;

import javax.swing.*;

public class MiThread extends Thread
{
	private JTextArea textArea;
	private boolean senial;
	private boolean suspendido;
	private static int numero;
	
	public MiThread(JTextArea textArea)
	{
		this.textArea = textArea;
		numero++;
	}
	
	public void run()
	{
		try
		{
			int contador = 1;
			suspendido = false;
			senial = true;
			escribirTextArea("Arranca el Thread " + numero);
			while(senial)
			{
				while(suspendido);
				escribirTextArea("Ejecutando thread paso: " + contador);
				contador++;
				sleep(1000);
			}
			escribirTextArea("Thread finalizado.");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void escribirTextArea(String texto)
	{
		textArea.append(texto + "\n");
		textArea.setCaretPosition(textArea.getText().length()); 
	}
	
	public void parar()
	{
		senial = false;
	}
	
	public void interrumpir()
	{
		suspendido = true;
		escribirTextArea("Thread interrumpido...");
	}
	
	public void continuar()
	{
		suspendido = false;
		escribirTextArea("Thread prosigue...");
	}
}
