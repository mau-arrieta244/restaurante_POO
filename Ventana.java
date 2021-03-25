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
	
	JButton botonAvanzar;
	
	
	
	
	public Ventana() {
		super("Restaurante");
		this.setPreferredSize(new DimensionUIResource(800,500));
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
		
		principalWest.setBackground(Color.blue);
		principalEast.setBackground(Color.yellow);
		principalSouth.setBackground(Color.lightGray);
		
		l2 = new JLabel("órdenes pendientes + contadores");
		principalCenter.add(l2);
		
		comida = new JLabel("Hamburguesa, 1000 colones, tiempo de produccion = 5");
		comida1 = new JLabel("Sopa Azteca, 5000 colones, tiempo de produccion = 4");
		comida2 = new JLabel("Pollo a la parmesana, 7000 colones, tiempo de produccion = 8");
		comida3 = new JLabel("Casado tipico, 2000 colones, tiempo de produccion = 3");
		comida4 = new JLabel("orden de papas grandes, 1000 colones, tiempo de produccion = 2");
		comida5 = new JLabel("Pescado entero, 3000 colones, tiempo de produccion = 5");
		
		principalCenter.add(comida);
		principalCenter.add(comida1);
		principalCenter.add(comida2);
		principalCenter.add(comida3);
		principalCenter.add(comida4);
		principalCenter.add(comida5);
		
		l3 = new JLabel("acá va la foto del cliente 1");
		l4 = new JLabel("acá va la info del cliente ");
		l5 = new JLabel("acá van los contadores del cliente aaaaaaaaa");
		
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
		this.add(principalCenter,BorderLayout.CENTER);
		//this.add(scroll,BorderLayout.SOUTH);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
