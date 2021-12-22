package Clases_Guis;

import Clases_Dominio.Datos;
import Clases_Dominio.Tablero;
import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class Gui_Juego extends Modelo implements ActionListener, MouseListener, Runnable {

    private final GestorDeVentanas gestorDeVentanas = new GestorDeVentanas();
    private Container ventana;
    private JPanel panelCentral, panelSuperior, panelInferior;

    private final ImageIcon question = new ImageIcon("src/main/java/Imagenes/question.png");
    private final String rutaImagesAnimales =  "src/main/java/Imagenes/Animales/";
    private JLabel[] arregloEtiquetasImagenes;
    private JButton botonVolver;
    private JLabel mostrarPuntaje;
    private JLabel tiempo;
    private JLabel finalizadoJuego;
    private JLabel jLabelCantidadClick;

    private String nick;
    private String dificultad;
    private final int cartasTotales;
    private int[] arregloCartas;
    private int[] arregloControlPareja;
    private int[] arregloCantidadClick;

    private final int altoCarta = 65;
    private final int anchoCarta = 65;
    private int eleccion1 = 0;
    private int eleccion2 = 0;
    private int click = 0;
    private int puntaje = 0;
    private int cantidadClick = 0;

    private Thread hilo;
    boolean cronometroActivo;
    boolean pausar;


    public void iniciarCronometro() {
        hilo = new Thread(this);
        cronometroActivo = true;
        pausar = false;
        hilo.start();
    }

    public void run() {
        int minutos = 0, segundos = 0;
        String min = "", seg = "";
        tiempo.setText("00:00");
        try {
            while (cronometroActivo) {
                if (!pausar) {
                    Thread.sleep(1000);
                    segundos += 1;
                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                    if (minutos < 10) min = "0" + minutos;
                    else min = String.valueOf(minutos);
                    if (segundos < 10) seg = "0" + segundos;
                    else seg = String.valueOf(segundos);
                    tiempo.setText(min + ":" + seg);
                }
            }
            tiempo.setText(min + ":" + seg);
        } catch (Exception e) {
            System.out.println("Error al correr metodo run");
        }
    }

    public  Gui_Juego(){
        this.cartasTotales=8;
    }

    public Gui_Juego(Container container, int cartasTotales, String nick, String dificultad)  {
        this.ventana = container;
        this.cartasTotales = cartasTotales;
        this.nick = nick;
        this.dificultad = dificultad;
        arregloEtiquetasImagenes = new JLabel[this.cartasTotales];
        arregloControlPareja = new int[this.cartasTotales];
        llenarArregloConCeros(arregloControlPareja);
        arregloCantidadClick = new int[this.cartasTotales];
        llenarArregloConCeros(arregloCantidadClick);
        traerArregloCartas();
        crearComponentes();
        iniciarCronometro();
        actualizarPaneles();
    }

    public int[] llenarArregloConCeros(int[] arreglo) {
        Arrays.fill(arreglo, 0);
        return arreglo;
    }

    private void traerArregloCartas() {
        Tablero tablero = new Tablero();
        tablero.contruirArreglosCartas(cartasTotales);
        this.arregloCartas = tablero.getArregloCartas();
    }

    private void crearComponentes() {
        crearPaneles();
        crearBotones();
        crearEtiquetas();
        crearCartasIncognitas();
    }

    private JLabel[] crearCartasIncognitas() {
        for (int i = 0; i < arregloEtiquetasImagenes.length; i++) {
            arregloEtiquetasImagenes[i] = new JLabel();
            arregloEtiquetasImagenes[i].setBounds(0, 0,anchoCarta, altoCarta);
            arregloEtiquetasImagenes[i].setIcon(new ImageIcon(question.getImage().getScaledInstance(anchoCarta, altoCarta, Image.SCALE_SMOOTH)));
            arregloEtiquetasImagenes[i].setOpaque(true);
            arregloEtiquetasImagenes[i].setBackground(Color.gray);
            arregloEtiquetasImagenes[i].addMouseListener(this);
            panelCentral.add(arregloEtiquetasImagenes[i]);
        }
        return arregloEtiquetasImagenes;
    }

    private void crearPaneles() {
        panelCentral = new JPanel();
        panelCentral.setVisible(true);
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));//new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS)

        panelSuperior = new JPanel();
        panelSuperior.setVisible(true);
        panelSuperior.setOpaque(false);
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));

        panelInferior = new JPanel();
        panelInferior.setVisible(true);
        panelInferior.setOpaque(false);
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER));


        ventana.add(panelSuperior, BorderLayout.PAGE_START);
        ventana.add(panelCentral, BorderLayout.CENTER);
        ventana.add(panelInferior, BorderLayout.PAGE_END);
    }

    private void crearBotones() {
        botonVolver = botonImagenVolver(botonVolver, 15, 15);
        botonVolver.addActionListener(this);
        panelSuperior.add(botonVolver);
    }

    private void crearEtiquetas() {
        JLabel etiquetaTiempo = new JLabel("Tiempo : ", SwingConstants.CENTER);
        etiquetaTiempo = modelarEtiqueta(etiquetaTiempo, 160, 20, 100, 25, null, getFuente());
        panelSuperior.add(etiquetaTiempo);

        JLabel etiquetaPuntaje = new JLabel("Puntaje: ", SwingConstants.CENTER);
        etiquetaPuntaje = modelarEtiqueta(etiquetaPuntaje, 0, 0, 140, 25, null, getFuente());
        panelInferior.add(etiquetaPuntaje);

        mostrarPuntaje = new JLabel(String.valueOf(puntaje), SwingConstants.CENTER);
        mostrarPuntaje = modelarEtiqueta(mostrarPuntaje, 0 ,0, 50, 25 , Color.white, getFuente());
        panelInferior.add(mostrarPuntaje);

        finalizadoJuego = new JLabel("Has completado este nivel", SwingConstants.CENTER);
        finalizadoJuego = modelarEtiqueta(finalizadoJuego, 0 ,0 ,250, 30, Color.YELLOW, getFuente());
        finalizadoJuego.setVisible(false);
        panelInferior.add(finalizadoJuego);

        tiempo = new JLabel("00:00", SwingConstants.CENTER);
        tiempo = modelarEtiqueta(tiempo, 0, 0, 100, 25, Color.white, getFuente());
        panelSuperior.add(tiempo);
        run();
        iniciarCronometro();

        JLabel infoCartasRotadas = new JLabel("Cartas Rotadas: ");
        infoCartasRotadas = modelarEtiqueta(infoCartasRotadas,0,0,0,0, null, getFuente());
        panelSuperior.add(infoCartasRotadas);

        jLabelCantidadClick = new JLabel("0");
        jLabelCantidadClick = modelarEtiqueta(jLabelCantidadClick, 0 ,0 ,0, 0, Color.white, getFuente());
        panelSuperior.add(jLabelCantidadClick);
    }

    private void actualizarPaneles() {
        panelCentral.updateUI();
        panelSuperior.updateUI();
        panelInferior.updateUI();
    }

    private void visibilidadPaneles(boolean visible) {
        panelCentral.setVisible(visible);
        panelSuperior.setVisible(visible);
        panelInferior.setVisible(visible);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonVolver) {
            visibilidadPaneles(false);
            if (pausar == true) {
                DatosJugador();
            }
            actualizarPaneles();
            gestorDeVentanas.ejecutarVentanaMenuPrincipal(ventana);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < arregloEtiquetasImagenes.length; i++) {
            if (e.getSource() == arregloEtiquetasImagenes[i] && verificarParejasElegidas(i)) {
                arregloCantidadClick[i]++;
                if (arregloCantidadClick[i] < 2) {
                    ImageIcon imagen = new ImageIcon(rutaImagesAnimales + arregloCartas[i] + ".png");
                    arregloEtiquetasImagenes[i].setIcon(new ImageIcon(imagen.getImage().getScaledInstance(anchoCarta, altoCarta, Image.SCALE_SMOOTH)));
                    arregloEtiquetasImagenes[i].setBackground(Color.white);
                    //
                    click++;
                    if (click == 1) {
                        eleccion1 = i;
                    } else {
                        eleccion2 = i;
                    }
                    cantidadClick++;
                    jLabelCantidadClick.setText(String.valueOf(cantidadClick));
                }
                actualizarPaneles();
            }
        }
    }

    private boolean verificarParejasElegidas(int i) {
        return arregloControlPareja[i] != 1;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < arregloEtiquetasImagenes.length; i++) {
            if (e.getSource() == arregloEtiquetasImagenes[i]) {
                if (click == 2) {
                    validarParejas();
                    click = 0;
                }
            }
            if (elementosArregloIguales(arregloControlPareja)) {
                pausar = true;
                tiempo.setBackground(Color.CYAN);
                finalizadoJuego.setVisible(true);
            }
            actualizarPaneles();
        }
    }

    public boolean DatosJugador() {
        Datos datos = new Datos();
        try {
            datos.crearJugador(nick, dificultad, puntaje, tiempo.getText());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean elementosArregloIguales(int[] arreglo) {
        return (Arrays.stream(arreglo).distinct().count() == 1) && arreglo[0] == 1;
    }

    private void validarParejas() {
        if (arregloCartas[eleccion1] == arregloCartas[eleccion2]) {
            arregloControlPareja[eleccion1] = 1;
            arregloControlPareja[eleccion2] = 1;
            puntaje += 10;
            mostrarPuntaje.setText(String.valueOf(puntaje));
        } else {
            arregloEtiquetasImagenes[eleccion1].setIcon(new ImageIcon(question.getImage().getScaledInstance(anchoCarta, altoCarta, Image.SCALE_SMOOTH)));
            arregloEtiquetasImagenes[eleccion1].setBackground(Color.gray);
            arregloEtiquetasImagenes[eleccion2].setIcon(new ImageIcon(question.getImage().getScaledInstance(anchoCarta, altoCarta, Image.SCALE_SMOOTH)));
            arregloEtiquetasImagenes[eleccion2].setBackground(Color.gray);
            arregloCantidadClick[eleccion1] = 0;
            arregloCantidadClick[eleccion2] = 0;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }
}