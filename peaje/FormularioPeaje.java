package peaje;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormularioPeaje {
    private JFrame formulario;
    private Peaje peajeSeleccionado;
    private ArrayList<Peaje> peajes;

    public FormularioPeaje(ArrayList<Peaje> peajes) {
        this.peajes = peajes;
        seleccionarPeaje();
    }

    private void seleccionarPeaje() {
        JFrame seleccionFrame = new JFrame("Seleccionar Peaje");
        seleccionFrame.setSize(400, 200);
        seleccionFrame.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("Seleccione el peaje:");
        JComboBox<String> comboBox = new JComboBox<>();
        
        // Agregar nombres de peajes al JComboBox
        for (Peaje p : peajes) {
            comboBox.addItem(p.getNombre());
        }

        JButton seleccionarButton = new JButton("Seleccionar");
        seleccionarButton.addActionListener(e -> {
            String nombrePeajeSeleccionado = (String) comboBox.getSelectedItem();
            for (Peaje p : peajes) {
                if (p.getNombre().equals(nombrePeajeSeleccionado)) {
                    peajeSeleccionado = p;
                    break;
                }
            }
            seleccionFrame.dispose();
            inicializarFormulario();
        });

        seleccionFrame.add(label);
        seleccionFrame.add(comboBox);
        seleccionFrame.add(seleccionarButton);
        
        seleccionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        seleccionFrame.setVisible(true);
    }

    private void inicializarFormulario() {
        formulario = new JFrame();
        formulario.setTitle("Sistema de Peaje - " + peajeSeleccionado.getNombre());

        JLabel tituloJLabel = new JLabel("Seleccione el tipo de vehículo para cobrar el peaje");
        tituloJLabel.setBounds(50, 20, 400, 40);

        JButton b1 = new JButton("Moto");
        JButton b2 = new JButton("Carro");
        JButton b3 = new JButton("Camión");
        JButton b4 = new JButton("Imprimir Boletas");
        JButton b5 = new JButton("Salir");

        b1.setBounds(50, 80, 100, 40);
        b2.setBounds(150, 80, 100, 40);
        b3.setBounds(250, 80, 100, 40);
        b4.setBounds(150, 140, 150, 40);
        b5.setBounds(150, 200, 150, 40);

        formulario.add(b1);
        formulario.add(b2);
        formulario.add(b3);
        formulario.add(b4);
        formulario.add(b5);
        formulario.add(tituloJLabel);
        formulario.setSize(400, 300);
        formulario.setLayout(null);
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Acciones de los botones
        agregarAcciones(b1, b2, b3, b4, b5);

        formulario.setVisible(true);
    }

    private void agregarAcciones(JButton b1, JButton b2, JButton b3, JButton b4, JButton b5) {
        b1.addActionListener(e -> registrarBoleta("Moto", 5000));
        b2.addActionListener(e -> registrarBoleta("Carro", 10000));

        b3.addActionListener(e -> {
            String placaCamion = JOptionPane.showInputDialog("Ingrese la placa del camión:");
            if (placaCamion != null && !placaCamion.isEmpty()) {
                String ejesStr = JOptionPane.showInputDialog("Ingrese el número de ejes:");
                try {
                    int nEjes = Integer.parseInt(ejesStr);
                    int totalCamion = 5000 * nEjes;
                    Boleta boletaCamion = new Boleta("Camión", totalCamion, placaCamion, peajeSeleccionado);
                    mostrarMensaje(peajeSeleccionado.ingresar_boleta(boletaCamion), "Camión");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(formulario, "Número de ejes inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        b4.addActionListener(e -> mostrarBoletas());

        b5.addActionListener(e -> System.exit(0));
    }

    private void registrarBoleta(String tipo, int costo) {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del " + tipo.toLowerCase() + ":");
        if (placa != null && !placa.isEmpty()) {
            Boleta boleta = new Boleta(tipo, costo, placa, peajeSeleccionado);
            mostrarMensaje(peajeSeleccionado.ingresar_boleta(boleta), tipo);
        }
    }

    private void mostrarMensaje(int resultado, String tipo) {
        if (resultado == 1) {
            JOptionPane.showMessageDialog(formulario, "Boleta registrada para " + tipo + ".");
        } else {
            JOptionPane.showMessageDialog(formulario, "La boleta no se ha podido registrar.");
        }
    }

    // Método para mostrar las boletas en una ventana emergente
    private void mostrarBoletas() {
        if (peajeSeleccionado.getBoletas().isEmpty()) {
            JOptionPane.showMessageDialog(formulario, "No hay boletas registradas.", "Boletas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DefaultTableModel modelo = new DefaultTableModel(new String[]{"Tipo Vehículo", "Total", "Patente", "Peaje"}, 0);
            for (Boleta boleta : peajeSeleccionado.getBoletas()) {
                modelo.addRow(new Object[]{boleta.getTipo(), boleta.getTotal(), boleta.getPatente(), boleta.getPeaje().getNombre()});
            }

            JTable tabla = new JTable(modelo);
            JScrollPane scrollPane = new JScrollPane(tabla);
            scrollPane.setPreferredSize(new Dimension(400, 200));

            JOptionPane.showMessageDialog(formulario, scrollPane, "Boletas Registradas", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
