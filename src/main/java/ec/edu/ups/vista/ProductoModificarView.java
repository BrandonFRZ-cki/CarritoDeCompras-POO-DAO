package ec.edu.ups.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoModificarView extends JFrame {

    private JPanel panelPrincipal;
    private JTextField txtCodigo;
    private JTextField txtNuevoNombre;
    private JTextField txtNuevoPrecio;
    private JButton btnActualizar;
    private JButton btnEliminar;

    public ProductoModificarView() {
        setContentPane(panelPrincipal);
        setTitle("Modificar Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocation(100,100);
        setVisible(true);

        configurarEventos();
    }

    private void configurarEventos() {
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }

    public int getCodigo() {
        try {
            return Integer.parseInt(txtCodigo.getText());
        } catch (NumberFormatException e) {
            mostrarMensaje("Error: Código inválido.");
            return -1; // Valor por defecto en caso de error
        }
    }

    public void setCodigo(String codigo) {
        this.txtCodigo.setText(codigo);
    }

    public String getNuevoNombre() {
        return txtNuevoNombre.getText();
    }

    public void setNuevoNombre(String nuevoNombre) {
        this.txtNuevoNombre.setText(nuevoNombre);
    }

    public double getNuevoPrecio() {
        try {
            return Double.parseDouble(txtNuevoPrecio.getText());
        } catch (NumberFormatException e) {
            mostrarMensaje("Error: Precio inválido.");
            return -1; // Valor por defecto en caso de error
        }
    }

    public void setNuevoPrecio(String nuevoPrecio) {
        this.txtNuevoPrecio.setText(nuevoPrecio);
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void actualizarProducto() {
    }

    public void eliminarProducto() {
    }
}