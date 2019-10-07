/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Producto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class modeloProducto {

    private Session sesion;

    private void iniciaOperacion() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession();
        sesion.getTransaction().begin();
    }

    private void terminaOperacion() {
        sesion.getTransaction().commit();
        sesion.close();
    }

    public int guardaProducto(Producto producto) {
        int id = 0;
        iniciaOperacion();
        id = (int) sesion.save(producto);
        terminaOperacion();
        return id;
    }

    public void actualizaProducto(Producto producto) {
        iniciaOperacion();
        sesion.update(producto);
        terminaOperacion();
    }

    public void eliminaProducto(Producto producto) {
        iniciaOperacion();
        sesion.delete(producto);
        terminaOperacion();
    }

    public Producto buscarProducto(int idProducto) {
        Producto producto = null;

        iniciaOperacion();
        producto = (Producto) sesion.get(Producto.class, idProducto);
        terminaOperacion();
        return producto;
    }

    public List<Producto> listarProducto() {
        List<Producto> listaProducto = null;
        iniciaOperacion();
        listaProducto = sesion.createQuery("from Producto").list();
        terminaOperacion();
        return listaProducto;
    }    
}
