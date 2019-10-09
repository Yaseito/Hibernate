/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Proveedor;
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
public class modeloZona {

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

    static public int guardaZona(Zona zona) {
        int id = zona.getIdZona();
        try {
            iniciaOperacion();
            id = (int) sesion.save(zona);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return id;
    }

    static public void actualizaZona(Zona zona) {
        try {
            iniciaOperacion();
            sesion.update(zona);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public void eliminaZona(Zona zona) {
        try {
            iniciaOperacion();
            sesion.delete(zona);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public Zona buscarZona(int idZona) {
        Zona zona = null;
        try {
            iniciaOperacion();
            zona = (Zona) sesion.get(Zona.class, idZona);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return zona;
    }

    static public List<Zona> listarZona() {
        List<Zona> listaZona = null;
        try {
            iniciaOperacion();
            listaZona = sesion.createQuery("from Zona").list();
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return listaZona;
    }
}
