package ec.edu.ups.vista;

import ec.edu.ups.controlador.ProductoController;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.impl.ProductoDAOMemoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            PrincipalView principalView = new PrincipalView();
            ProductoDAO productoDAO = new ProductoDAOMemoria();

            ProductoAnadirView productoAnadirView = new ProductoAnadirView();
            ProductoController productoController = new ProductoController(productoDAO);
            productoController.setProductoAnadirView(productoAnadirView);

            principalView.getMenuItemCrearProducto().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    principalView.getjDesktopPane().add(productoAnadirView);
                }
            });
            principalView.getMenuItemActualizarProducto().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });


        });
    }
}