/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class modeloMarca {

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

    static public int guardaMarca(Marca marca) {
        int id = marca.getIdMarca();
        try {
            iniciaOperacion();

            id = (int) sesion.save(marca);
            terminaOperacion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return id;
    }

    static public void actualizaMarca(Marca marca) {
        try {
        iniciaOperacion();
        sesion.update(marca);
        terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public void eliminaMarca(Marca marca) {
        try {
        iniciaOperacion();
        sesion.delete(marca);
        terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public Marca buscarMarca(int idMarca) {
        
        Marca marca = null;
        try {
        iniciaOperacion();
        marca = (Marca) sesion.get(Marca.class, idMarca);
        terminaOperacion();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return marca;
    }

    static public List<Marca> listarMarca() {
        List<Marca> listaMarca = null;
        try {
        iniciaOperacion();
        listaMarca = sesion.createQuery("from Marca").list();
        terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return listaMarca;
    }
}
