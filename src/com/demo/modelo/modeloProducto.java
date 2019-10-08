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

        iniciaOperacion();
        id = (int) sesion.save(producto);
        terminaOperacion();

        return id;
    }

    static public void actualizaProducto(Producto producto) {
        iniciaOperacion();
        sesion.update(producto);
        terminaOperacion();
    }

    static public void eliminaProducto(Producto producto) {
        iniciaOperacion();
        sesion.delete(producto);
        terminaOperacion();
    }

    static public Producto buscarProducto(int idProducto) {
        Producto producto = null;

        iniciaOperacion();
        producto = (Producto) sesion.get(Producto.class, idProducto);
        terminaOperacion();
        return producto;
    }

    static public List<Producto> listarProducto() {
        List<Producto> listaProducto = null;
        iniciaOperacion();
        listaProducto = sesion.createQuery("from Producto").list();
        terminaOperacion();
        return listaProducto;
    }

}
