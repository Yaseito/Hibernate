/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Producto;
import com.demo.modelo.entidades.Zona;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class modeloProducto {

    static private Session sesion;

    static private void iniciaOperacion() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession();
        sesion.getTransaction().begin();
    }

    static private void terminaOperacion() {
        sesion.getTransaction().commit();
        sesion.close();
    }

    static public int guardaProducto(Producto producto) {

        int id = producto.getIdProducto();
        try {
            iniciaOperacion();
            id = (int) sesion.save(producto);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return id;
    }

    static public void actualizaProducto(Producto producto) {
        iniciaOperacion();
        try {
            sesion.update(producto);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public void eliminaProducto(Producto producto) {
        iniciaOperacion();
        try {
            sesion.delete(producto);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public Producto buscarProducto(int idProducto) {
        Producto producto = null;
        try {
            iniciaOperacion();
            producto = (Producto) sesion.get(Producto.class, idProducto);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return producto;
    }

    static public List<Producto> listarProducto() {
        List<Producto> listaProducto = null;
        try {
            iniciaOperacion();
            listaProducto = sesion.createQuery("from Producto").list();

            for (int i = 0; i < listaProducto.size(); i++) {
                //Idea tomada de (Ascencio Gino, 2019)
                listaProducto.get(i).getMarca().getDescripcion();
                listaProducto.get(i).getPresentacion().getDescripcion();
                listaProducto.get(i).getProveedor().getDescripcion();
                listaProducto.get(i).getZona().getDescripcion();
                //(Obtenido de Github: Mapeo Tienda)
            }
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return listaProducto;
    }

}
