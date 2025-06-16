package ec.edu.ups.vista;

import ec.edu.ups.controlador.ProductoController;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.impl.ProductoDAOMemoria;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            ProductoDAO productoDAO = new ProductoDAOMemoria();
            ProductoAnadirView productoView = new ProductoAnadirView();
            ProductoListaView productoListaView = new ProductoListaView();
            ProductoModificarView productoGestionView = new ProductoModificarView();
            new ProductoController(productoDAO, productoView, productoListaView, productoGestionView);
        });
    }
}