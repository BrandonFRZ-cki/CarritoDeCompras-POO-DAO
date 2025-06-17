package ec.edu.ups.controlador;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.vista.ProductoAnadirView;
import ec.edu.ups.vista.ProductoListaView;
import ec.edu.ups.vista.ProductoModificarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductoController {

    private ProductoAnadirView productoAnadirView;
    private ProductoListaView productoListaView;
    private ProductoModificarView productoModificarView;
    private ProductoDAO productoDAO;

    public ProductoController(ProductoDAO productoDAO,
                              ProductoAnadirView productoAnadirView,
                              ProductoListaView productoListaView,
                              ProductoModificarView productoModificarView) {
        this.productoDAO = productoDAO;
        this.productoAnadirView = productoAnadirView;
        this.productoListaView = productoListaView;
        this.productoModificarView = productoModificarView;
        configurarEventos();
    }
    public ProductoController(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    private void configurarEventos() {


        productoListaView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

        productoListaView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProductos();
            }
        });

        productoModificarView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });

        productoModificarView.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

    }


    private void guardarProducto() {
        int codigo = Integer.parseInt(productoAnadirView.getTxtCodigo().getText());
        String nombre = productoAnadirView.getTxtNombre().getText();
        double precio = Double.parseDouble(productoAnadirView.getTxtPrecio().getText());

        productoDAO.crear(new Producto(codigo, nombre, precio));
        productoAnadirView.mostrarMensaje("Producto guardado correctamente");
        productoAnadirView.limpiarCampos();
        productoAnadirView.mostrarProductos(productoDAO.listarTodos());
    }

    private void buscarProducto() {
        String nombre = productoListaView.getTxtBuscar().getText();

        List<Producto> productosEncontrados = productoDAO.buscarPorNombre(nombre);
        productoListaView.cargarDatos(productosEncontrados);
    }

    private void listarProductos() {
        List<Producto> productos = productoDAO.listarTodos();
        productoListaView.cargarDatos(productos);
    }

    private void actualizarProducto() {
        int codigo = productoModificarView.getCodigo();
        Producto producto = productoDAO.buscarPorCodigo(codigo);

        if (producto != null) {
            String nuevoNombre = productoModificarView.getNuevoNombre();
            double nuevoPrecio = productoModificarView.getNuevoPrecio();

            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            productoDAO.actualizar(producto);
            productoModificarView.mostrarMensaje("Producto actualizado correctamente.");
            listarProductos(); // Refrescar la lista
        } else {
            productoModificarView.mostrarMensaje("Error: Producto no encontrado.");
        }
    }
    private void eliminarProducto() {
        int codigo = productoModificarView.getCodigo();

        productoDAO.eliminar(codigo);
        productoModificarView.mostrarMensaje("Producto eliminado correctamente.");
        listarProductos(); // Refrescar la lista
    }
     public void setProductoAnadirView(ProductoAnadirView productoAnadirView) {
         this.productoAnadirView = productoAnadirView;
     }
}