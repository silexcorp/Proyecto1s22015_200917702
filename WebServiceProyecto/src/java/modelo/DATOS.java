/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alexander
 */
public class DATOS {
    public static ARBOLAVL arbol_choferes;
    public static ARBOLAVL arbol_usuarios;
    public static LISTADOBLE lista;
    public DATOS(){
        arbol_choferes = new ARBOLAVL(); 
        arbol_usuarios = new ARBOLAVL(); 
        lista = new LISTADOBLE();
    }
}
