package restaurante;

import javax.swing.plaf.DimensionUIResource;
//la propia ventana principal
//para poner y ordenar una imagen
//ordenar (paneles)
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {
		
	JPanel principalWest;
	JPanel principalCenter;
	JPanel principalEast;
	JPanel principalSouth;
	
	JLabel l2;
	JLabel comida;
	JLabel comida1;
	JLabel comida2;
	JLabel comida3;
	JLabel comida4;
	JLabel comida5;
	
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	
	JPanel panelComida;
	JPanel panelComida1;
	JPanel panelComida2;
	JPanel panelComida3;
	JPanel panelComida4;
	JPanel panelComida5;
	
	ImageIcon fotoCliente;
	JScrollPane scroll;//este scrollpane es solo para el panel del CENTRO
	//si ocuparamos mas espacio por ejemplo en panel cliente,
	//crear otro JscrollPane y wrappear ese otro panel, easy.
	
	JButton botonAvanzar;
	
	
	
	
	public Ventana() {
		super("Restaurante");
		this.setPreferredSize(new DimensionUIResource(1000,600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		agregarComponentes();
		
		this.pack();
		this.setVisible(true);
	}
	private void agregarComponentes() {
		principalWest = new JPanel();
		principalWest.setLayout(new BoxLayout(principalWest,BoxLayout.Y_AXIS));
		principalCenter = new JPanel();
		principalCenter.setLayout(new BoxLayout(principalCenter,BoxLayout.Y_AXIS));
		principalEast = new JPanel();
		principalEast.setLayout(new BoxLayout(principalEast,BoxLayout.Y_AXIS));
		principalSouth = new JPanel();
		
		scroll = new JScrollPane(principalCenter);
		
		principalWest.setBackground(Color.WHITE);
		principalEast.setBackground(Color.WHITE);
		principalSouth.setBackground(Color.orange);
		
		l2 = new JLabel("órdenes pendientes + contadores");
		principalCenter.add(l2);
		
		panelComida = new JPanel();
		panelComida.setBackground(Color.LIGHT_GRAY);
		panelComida1 = new JPanel();
		panelComida1.setBackground(Color.LIGHT_GRAY);
		panelComida2 = new JPanel();
		panelComida2.setBackground(Color.LIGHT_GRAY);
		panelComida3 = new JPanel();
		panelComida3.setBackground(Color.LIGHT_GRAY);
		panelComida4 = new JPanel();
		panelComida4.setBackground(Color.LIGHT_GRAY);
		panelComida5 = new JPanel();
		panelComida5.setBackground(Color.LIGHT_GRAY);
		
		comida = new JLabel("Hamburguesa, 1000 colones, tiempo de produccion = 5");
		comida1 = new JLabel("Sopa Azteca, 5000 colones, tiempo de produccion = 4");
		comida2 = new JLabel("Pollo a la parmesana, 7000 colones, tiempo de produccion = 8");
		comida3 = new JLabel("Casado tipico, 2000 colones, tiempo de produccion = 3");
		comida4 = new JLabel("orden de papas grandes, 1000 colones, tiempo de produccion = 2");
		comida5 = new JLabel("Pescado entero, 3000 colones, tiempo de produccion = 5");
		
		panelComida.add(comida);
		panelComida1.add(comida1);
		panelComida2.add(comida2);
		panelComida3.add(comida3);
		panelComida4.add(comida4);
		panelComida5.add(comida5);
		
		principalCenter.add(panelComida);
		principalCenter.add(panelComida1);
		principalCenter.add(panelComida2);
		principalCenter.add(panelComida3);
		principalCenter.add(panelComida4);
		principalCenter.add(panelComida5);
		
		
		fotoCliente = new ImageIcon("C:\\Users\\mauar\\Desktop\\CODE\\restaurante_POO\\restaurante\\src\\imagenes\\cliente.jpg");
		
		l3 = new JLabel(fotoCliente);
		//l3.setForeground(Color.BLACK);
		l4 = new JLabel("acá va la info del cliente ");
		l4.setForeground(Color.BLACK);
		l5 = new JLabel("acá van los contadores del cliente aaaaaaaaa");
		l5.setForeground(Color.BLACK);
		
		principalWest.add(l3);
		principalWest.add(l4);
		principalWest.add(l5);
		
		l6 = new JLabel("acá van las estadisticas generales");
		l7 = new JLabel("acá van los contadores generales AAAAAAAAAAA ");
		
		principalEast.add(l6);
		principalEast.add(l7);
		
		botonAvanzar = new JButton("AVANZAR");
		principalSouth.add(botonAvanzar);

		this.add(principalWest,BorderLayout.WEST);
		this.add(principalEast,BorderLayout.EAST);
		this.add(principalSouth,BorderLayout.SOUTH);
		this.add(scroll,BorderLayout.CENTER);
		//this.add(scroll,BorderLayout.SOUTH);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
