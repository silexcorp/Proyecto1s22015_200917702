/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import static modelo.DATOS.*;
/**
 *
 * @author Alexander
 */
public class RegistrarUsuario {
    DATOAVL nuevo = null;
    public RegistrarUsuario(){
        
    }
    public String setAdmin(String correo, String contrasenia, String rol){
        nuevo = new DATOAVL();
        nuevo.admin_id = correo;
        nuevo.admin_contrasenia = contrasenia;
        nuevo.rol = rol;
        return ARBOLAVL.insertar(nuevo);
    }
    public String getAdmin(String correo, String contrasenia){
        nuevo = new DATOAVL();
        nuevo.admin_id = correo;
        nuevo.admin_contrasenia = contrasenia;
        return ARBOLAVL.buscar(nuevo);
    }
}
