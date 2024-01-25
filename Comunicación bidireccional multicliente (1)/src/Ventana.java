
	import java.awt.BorderLayout;
	import java.awt.Dimension;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;

	public class Ventana extends JFrame {
		private static final long serialVersionUID = 1L;

		// Área de mensajes
		public final JTextArea mensajes = new JTextArea();
		// Prompt de envío                                                                                 
		private final JTextArea prompt = new JTextArea();
		// Botón de envío
		private final JButton boton = new JButton();

		public Ventana() {
			// Distribución de los componentes por zonas de la ventana
			setLayout(new BorderLayout());

			mensajes.setPreferredSize(new Dimension(400, 200));
			prompt.setPreferredSize(new Dimension(200, 30));
			boton.setPreferredSize(new Dimension(20, 30));
			prompt.setToolTipText("Escribe aquí tu mensaje...");
			boton.setText("Enviar");
			boton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					// Método que se ejecuta cuando hagamos click
					enviar();
				}

			});
			//jList
			//buscar como crear un j list

			add(new JScrollPane(mensajes), BorderLayout.NORTH);
			add(new JScrollPane(prompt), BorderLayout.CENTER);
			add(boton, BorderLayout.SOUTH);
			//Aca se añade la lista
			pack();

			setTitle("Cliente");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
		}

		public void enviar() {
			String mensaje = prompt.getText();

			// Mostrar mensaje en el área de texto
			mensajes.append("Yo: " + mensaje + "\n");
			MainCliente.enviarMensaje(mensaje);
			// Borrar el mensaje enviado del prompt
			prompt.setText("");

			// TODO CÓDIGO DE ENVÍO DE MENSAJE
		}

	}


