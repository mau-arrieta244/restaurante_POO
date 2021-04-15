package proyectoPOO;

import javax.swing.plaf.DimensionUIResource;
//la propia ventana principal
//para poner y ordenar una imagen
//ordenar (paneles)
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;




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
	
	//cliente 1 de la cola
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel numPedido;
	JLabel item0nombre;
	JLabel item0precio;
	JLabel item0tiempo;
	JLabel item1nombre;
	JLabel item1precio;
	JLabel item1tiempo;
	
	JLabel l6;
	JLabel l7;
	
	JPanel panelComida;
	JPanel panelComida1;
	JPanel panelComida2;
	JPanel panelComida3;
	JPanel panelComida4;
	JPanel panelComida5;
	
	ImageIcon fotoCliente;
	JScrollPane scrollCentro;//este scrollpane es solo para el panel del CENTRO
	//si ocuparamos mas espacio por ejemplo en panel cliente,
	//crear otro JscrollPane y wrappear ese otro panel, easy.
	JScrollPane scrollWest;
	JScrollPane scrollEast;
	
	JButton botonAvanzar;
	
	

	
	public Ventana() {
		super("Restaurante");
		this.setPreferredSize(new DimensionUIResource(1000,600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agregarComponentes();
		
		this.pack();
		this.setVisible(true);
	}
	public Ventana(Pedido primerCliente) {
		super("Restaurante");
		this.setPreferredSize(new DimensionUIResource(1000,600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		agregarComponentes(primerCliente);
		
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
		
		scrollCentro = new JScrollPane(principalCenter);
		scrollWest = new JScrollPane(principalWest);
		scrollEast = new JScrollPane(principalEast);
		
		
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
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
		//panel CLIENTE
		fotoCliente = new ImageIcon("C:\\Users\\mauar\\Desktop\\CODE\\restaurante_POO\\src\\proyectoPOO\\imagen\\cliente.jpg");
		l3 = new JLabel(fotoCliente);
		l4 = new JLabel("acá va la info del cliente ");
		l4.setForeground(Color.BLACK);
		l5 = new JLabel("acá van los contadores del cliente aaaaaaaaa");
		l5.setForeground(Color.BLACK);
		/*
		numPedido = new JLabel(cliente1.items.toString());
		item0nombre = new JLabel(cliente1.items.get(0).nombre);
		item0precio = new JLabel(String.valueOf(cliente1.items.get(0).precio));
		item0tiempo = new JLabel(String.valueOf(cliente1.items.get(0).tiempoProduccion));
		item1nombre = new JLabel(cliente1.items.get(1).nombre);
		item1precio = new JLabel(String.valueOf(cliente1.items.get(1).precio));
		item1tiempo = new JLabel(String.valueOf(cliente1.items.get(1).tiempoProduccion));
		// //////////////////////////////////////////////////////////////////////////////////////
		*/
		principalWest.add(l3);
		principalWest.add(l4);
		principalWest.add(l5);
		/*
		principalWest.add(numPedido);
		principalWest.add(item0nombre);
		principalWest.add(item0precio);
		principalWest.add(item0tiempo);
		principalWest.add(item1nombre);
		principalWest.add(item1precio);
		principalWest.add(item1tiempo);
		*/
		l6 = new JLabel("acá van las estadisticas generales");
		l7 = new JLabel("acá van los contadores generales AAAAAAAAAAA ");
		
		principalEast.add(l6);
		principalEast.add(l7);
		
		botonAvanzar = new JButton("AVANZAR");
		botonAvanzar.addActionListener(this);
		principalSouth.add(botonAvanzar);
		
		this.add(scrollWest);
		this.add(scrollCentro);
		this.add(scrollEast);
		this.add(principalSouth);
		this.setLayout(new GridLayout());
		
		
	}
	
	private void agregarComponentes(Pedido cliente1) {
		principalWest = new JPanel();
		principalWest.setLayout(new BoxLayout(principalWest,BoxLayout.Y_AXIS));
		
		principalCenter = new JPanel();
		principalCenter.setLayout(new BoxLayout(principalCenter,BoxLayout.Y_AXIS));
		
		principalEast = new JPanel();
		principalEast.setLayout(new BoxLayout(principalEast,BoxLayout.Y_AXIS));
		
		principalSouth = new JPanel();
		
		scrollCentro = new JScrollPane(principalCenter);
		scrollWest = new JScrollPane(principalWest);
		scrollEast = new JScrollPane(principalEast);
		
		
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
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
		//panel CLIENTE
		fotoCliente = new ImageIcon("C:\\Users\\mauar\\Desktop\\CODE\\restaurante_POO\\src\\proyectoPOO\\imagen\\cliente.jpg");
		l3 = new JLabel(fotoCliente);
		l4 = new JLabel("acá va la info del cliente ");
		l4.setForeground(Color.BLACK);
		l5 = new JLabel("acá van los contadores del cliente aaaaaaaaa");
		l5.setForeground(Color.BLACK);
		
		numPedido = new JLabel(cliente1.items.toString());
		item0nombre = new JLabel(cliente1.items.get(0).nombre);
		item0precio = new JLabel(String.valueOf(cliente1.items.get(0).precio));
		item0tiempo = new JLabel(String.valueOf(cliente1.items.get(0).tiempoProduccion));
		item1nombre = new JLabel(cliente1.items.get(1).nombre);
		item1precio = new JLabel(String.valueOf(cliente1.items.get(1).precio));
		item1tiempo = new JLabel(String.valueOf(cliente1.items.get(1).tiempoProduccion));
		// //////////////////////////////////////////////////////////////////////////////////////
		
		principalWest.add(l3);
		principalWest.add(l4);
		principalWest.add(l5);
		
		principalWest.add(numPedido);
		principalWest.add(item0nombre);
		principalWest.add(item0precio);
		principalWest.add(item0tiempo);
		principalWest.add(item1nombre);
		principalWest.add(item1precio);
		principalWest.add(item1tiempo);
		
		l6 = new JLabel("acá van las estadisticas generales");
		l7 = new JLabel("acá van los contadores generales AAAAAAAAAAA ");
		
		principalEast.add(l6);
		principalEast.add(l7);
		
		botonAvanzar = new JButton("AVANZAR");
		botonAvanzar.addActionListener(this);
		principalSouth.add(botonAvanzar);
		
		this.add(scrollWest);
		this.add(scrollCentro);
		this.add(scrollEast);
		this.add(principalSouth);
		this.setLayout(new GridLayout());
		
		
	}
	
	///////////////////////////////////////////////////// ///////////////////////////////////////////////////// 
	///////////////////////////////////////////////////// ///////////////////////////////////////////////////// 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(botonAvanzar)) {
			System.out.println("AAAA");
			Main.avanzar();
			Main.info();
			Ventana nueva = new Ventana(Main.colaClientes.pedidosTotales.get(0));
			nueva.setVisible(true);
			this.dispose();
			
		}
		
	}
}
