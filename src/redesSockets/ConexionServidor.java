package redesSockets;
/*
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConexionServidor implements ActionListener {
    
    //private Socket socket; 
    String mensaje;
    private String usuario;
    private DataOutputStream salidaDatos;
    
    public ConexionServidor(Socket socket, String mensaje, String usuario) {
        //this.socket = socket;
        this.mensaje = mensaje;
        this.usuario = usuario;
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("El socket no se creo correctamente. ");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            salidaDatos.writeUTF(usuario + ": " + mensaje);
        } catch (IOException ex) {
            System.out.println("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }
}
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextField;

public class ConexionServidor implements ActionListener {

	private JTextField tfMensaje;
	private String usuario;
	private DataOutputStream salidaDatos;

	public ConexionServidor(Socket socket, JTextField tfMensaje, String usuario) {
		this.tfMensaje = tfMensaje;
		this.usuario = usuario;
		try {
			this.salidaDatos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			System.out.println("Error al crear el stream de salida : " + ex.getMessage());
		} catch (NullPointerException ex) {
			System.out.println("El socket no se creo correctamente. ");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			salidaDatos.writeUTF(usuario + ": " + tfMensaje.getText());
			tfMensaje.setText("");
		} catch (IOException ex) {
			System.out.println("Error al intentar enviar un mensaje: " + ex.getMessage());
		}
	}
}