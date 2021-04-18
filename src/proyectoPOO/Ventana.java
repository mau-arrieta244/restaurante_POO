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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class Ventana extends JFrame implements ActionListener {
	
	JPanel principalWest;
	JPanel principalCenter;
	JPanel principalEast;
	JPanel principalSouth;
	
	JLabel l2;
	
	//cliente 1 de la cola
	JLabel l3;
	
	ImageIcon fotoCliente;
	JScrollPane scrollCentro;//este scrollpane es solo para el panel del CENTRO
	JScrollPane scrollWest;//...Solo para el west...
	JScrollPane scrollEast;// ....
	
	JButton botonAvanzar;
	//
	
	public Ventana() { //no se está usando este constructor default
		//super("Restaurante");
		//this.setPreferredSize(new DimensionUIResource(1200,600));
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//agregarComponentes(); se eliminó para dar campo a la que recibe colaClientes como parametro
		//this.pack();
		//this.setVisible(true);
	}
	
	public void agregarACliente(ArrayList<String> info) {
		JPanel panel;
		JLabel espacio = new JLabel("\n -------------------- \n");
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);
		
		for(String dato:info) {
			JLabel labelDato = new JLabel(dato);
			panel.add(labelDato);
		}
		panel.add(espacio);
		principalWest.add(panel);
	}
	private void crearPanelWest(Cola cola) {
		principalWest = new JPanel();
		principalWest.setLayout(new BoxLayout(principalWest,BoxLayout.Y_AXIS));
		scrollWest = new JScrollPane(principalWest);
		principalWest.setBackground(Color.WHITE);
		
		
		//panel CLIENTE
		fotoCliente = new ImageIcon("C:\\Users\\mauar\\Desktop\\CODE\\restaurante_POO\\src\\proyectoPOO\\imagen\\cliente.jpg");
		l3 = new JLabel(fotoCliente);
		principalWest.add(l3);	
		for (Alimento alimento : cola.pedidosTotales.get(0).items) {
			ArrayList<String> informacion = alimento.info();
			agregarACliente(informacion);		
		}
	}
	
	public void agregarACentro(Pedido pedido) {
		JPanel panel;
		JLabel espacio = new JLabel("\n ----------------------------------- \n");
		JLabel espacio1 = new JLabel("\n ----------------------------------- \n");
		JLabel p = new JLabel("\n Pedido : \n");
			
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);
		panel.add(p);
		
		for(Alimento alim:pedido.items) {
			JLabel espacio3 = new JLabel(" -  -  -  -  -  -  -");
			panel.add(espacio3);
			for(String dato : alim.info()) {
				JLabel labelDato = new JLabel(dato);
				panel.add(labelDato);
			}
			
		}
		panel.add(espacio);
		panel.add(espacio1);
		panel.setBackground(Color.orange);
		principalCenter.add(panel);
	}
	
	private void crearPanelCenter(Cola cola) {
		principalCenter = new JPanel();
		principalCenter.setBackground(Color.orange);
		principalCenter.setLayout(new BoxLayout(principalCenter,BoxLayout.Y_AXIS));
		scrollCentro = new JScrollPane(principalCenter);
		
		l2 = new JLabel("Pedidos Totales");
		principalCenter.add(l2);
		
		for (Pedido pedido : cola.pedidosTotales) {
			agregarACentro(pedido);		
		}
	}
	
	public void agregarAEast(Alimento alim) {
		JPanel panel;
		JLabel espacio = new JLabel("\n ----------------------------------- \n");
		JLabel espacio1 = new JLabel("\n ----------------------------------- \n");
		JLabel p = new JLabel("\n Alimento : \n");
			
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setBackground(Color.WHITE);
		panel.add(p);
		for(String dato : alim.info()) {
			JLabel labelDato = new JLabel(dato);
			panel.add(labelDato);
		}
		panel.add(espacio);
		panel.add(espacio1);
		//panel.setBackground(Color.orange);
		principalEast.add(panel);
	}
	
	private void crearPanelEast(ColaProduccion cola) {
		principalEast = new JPanel();
		principalEast.setLayout(new BoxLayout(principalEast,BoxLayout.Y_AXIS));
		principalEast.setBackground(Color.WHITE);
		scrollEast = new JScrollPane(principalEast);
		
		l2 = new JLabel("En Produccion: ");
		principalEast.add(l2);
		
		for (Alimento alim : cola.produccion) {
			agregarAEast(alim);		
		}
	}
	
	private void agregarComponentes(Cola colaClientes,ColaProduccion colaProduc) {
		
		//principalWest = new JPanel();
		//principalWest.setLayout(new BoxLayout(principalWest,BoxLayout.Y_AXIS));
		
		//principalCenter = new JPanel();
		//principalCenter.setLayout(new BoxLayout(principalCenter,BoxLayout.Y_AXIS));
		
		//principalEast = new JPanel();
		//principalEast.setLayout(new BoxLayout(principalEast,BoxLayout.Y_AXIS));
		
		principalSouth = new JPanel();
		
		//scrollCentro = new JScrollPane(principalCenter);
		//scrollWest = new JScrollPane(principalWest);
		//scrollEast = new JScrollPane(principalEast);
		
		
		//principalWest.setBackground(Color.WHITE);
		//principalEast.setBackground(Color.WHITE);
		principalSouth.setBackground(Color.orange);
		
		//l2 = new JLabel("órdenes pendientes + contadores");
		//principalCenter.add(l2);
		
		botonAvanzar = new JButton("AVANZAR");
		botonAvanzar.addActionListener(this);
		principalSouth.add(botonAvanzar);
		
		crearPanelWest(colaClientes); // crea el panel del cliente
		crearPanelCenter(colaClientes);//crea el panel de ordenes pendientes
		crearPanelEast(colaProduc);
		this.add(scrollWest); // agrega el scroll que contiene el panel del cliente
		this.add(scrollCentro);
		
		this.add(scrollEast);
		this.add(principalSouth);
		this.setLayout(new GridLayout());
		
	}
	
	public Ventana(Cola cola, ColaProduccion colaProduccion) {
		super("Restaurante");
		this.setPreferredSize(new DimensionUIResource(1000,600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		agregarComponentes(cola,colaProduccion);
		
		this.pack();
		this.setVisible(true);
	}
	///////////////////////////////////////////////////// ///////////////////////////////////////////////////// 
	///////////////////////////////////////////////////// ///////////////////////////////////////////////////// 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(botonAvanzar)) {
			Main.avanzar();
			Main.info();
			Ventana nueva = new Ventana(Main.colaClientes,Main.colaProduc);//nueva ventana con contadores actualizados
			nueva.setVisible(true); //esto permite la actualización de los contadores dentro de la interfaz
			this.dispose();//eliminamos la ventana con contadores desactualizados
			
		}
		
	}
}
