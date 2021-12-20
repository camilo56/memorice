package Clases_Guis;

import Clases_Dominio.Estadisticas;
import Clases_Dominio.Tablero;
import Manejo_Archivos.GestorDeVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;

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
    private String nick = "";

    Thread hilo;
    boolean cronometroActivo;
    boolean pausar;


    public void iniciarCronometro() {
        // Ajuste al código: se crea if esto para que cuando se vuelva oprimir iniciar no llame a otro hilo e impida que se vea como si estuviera en error.
        hilo = new Thread(this);
        cronometroActivo = true;
        pausar = false;
        hilo.start();
    }

    public void run() {
        Integer minutos = 0, segundos = 0, milesimas = 0;
        //min es minutos, seg es segundos y mil es milesimas de segundo
        String min = "", seg = "", mil = "";
        try {
            //Mientras cronometroActivo sea verdadero entonces seguira
            //aumentando el tiempo
            while (cronometroActivo) {
                // Ajuste al codigo: se elimina while y se anexa un if donde se niega la variable pausar
                if (!pausar) {
                    //**************************************************************************************
                    Thread.sleep(4);
                    //Incrementamos 4 milesimas de segundo
                    milesimas += 4;
                    //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                    //y las milesimas de segundo de nuevo a 0
                    if (milesimas == 1000) {
                        milesimas = 0;
                        segundos += 1;
                        //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                        //y los segundos vuelven a 0
                        if (segundos == 60) {
                            segundos = 0;
                            minutos++;
                        }
                    }

                    //Esto solamente es estetica para que siempre este en formato
                    //00:00:000
                    if (minutos < 10) min = "0" + minutos;
                    else min = minutos.toString();
                    if (segundos < 10) seg = "0" + segundos;
                    else seg = segundos.toString();

                    //Colocamos en la etiqueta la informacion
                    tiempo.setText(min + ":" + seg);
                }
            }
            tiempo.setText(min + ":" + seg);

        } catch (Exception e) {
            System.out.println("Error al correr metodo run");
        }
    }

    public Gui_Juego(Container container, int cartasTotales)  {


        this.ventana = container;
        this.cartasTotales = cartasTotales;
        arregloEtiquetasImagenes = new JLabel[this.cartasTotales];
        arregloControlPareja = new int[this.cartasTotales];
        llenarArregloConCeros(arregloControlPareja);
        arregloCantidadClick = new int[this.cartasTotales];
        llenarArregloConCeros(arregloCantidadClick);
        traerArregloCartas();
        crearComponentes();
        iniciarCronometro();
        actualizarPaneles();
        Estadisticas();


    }

    private void Estadisticas(){

        Estadisticas datos =new Estadisticas(this.nick,this.click,this.puntaje);
        datos.setPuntaje(this.puntaje);
        datos.setnick(this.nick);
        datos.setIdPartida(this.click);

    }

    private int[] llenarArregloConCeros(int[] arreglo) {
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
        panelCentral.setBackground(Color.pink);//ELIMINAR ESTO DESPUES
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));//new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS)

        panelSuperior = new JPanel();
        panelSuperior.setVisible(true);
        panelSuperior.setBackground(Color.green);//ELIMINAR ESTO DESPUES
        panelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));

        panelInferior = new JPanel();
        panelInferior.setVisible(true);
        panelInferior.setBackground(Color.cyan);//ELIMINAR ESTO DESPUES
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
        etiquetaTiempo = modelarEtiqueta(etiquetaTiempo, 160, 20, 100, 25, Color.white, getFuente());
        panelSuperior.add(etiquetaTiempo);

        JLabel etiquetaPuntaje = new JLabel("Puntaje: ", SwingConstants.CENTER);
        etiquetaPuntaje = modelarEtiqueta(etiquetaPuntaje, 0, 0, 140, 25, Color.white, getFuente());
        panelInferior.add(etiquetaPuntaje);

        mostrarPuntaje = new JLabel(String.valueOf(puntaje), SwingConstants.CENTER);
        mostrarPuntaje = modelarEtiqueta(mostrarPuntaje, 0 ,0, 50, 25 , Color.white, getFuente());
        panelInferior.add(mostrarPuntaje);

        finalizadoJuego = new JLabel("Has completado este nivel", SwingConstants.CENTER);
        finalizadoJuego = modelarEtiqueta(finalizadoJuego, 0 ,0 ,250, 30, Color.YELLOW, getFuente());
        finalizadoJuego.setVisible(false);
        panelInferior.add(finalizadoJuego);

        tiempo = new JLabel("00:00:000", SwingConstants.CENTER);
        tiempo = modelarEtiqueta(tiempo, 0, 0, 100, 25, Color.white, getFuente());
        panelSuperior.add(tiempo);
        run();
        iniciarCronometro();
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

    private boolean elementosArregloIguales(int[] arreglo) {
        return (Arrays.stream(arreglo).distinct().count() == 1) && arreglo[0] == 1;
    }// retorna true si todos los elementos son igaules, y si el primer dato del arreglo es '1' (basicamente todos los elementos del arreglo deben ser '1')

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