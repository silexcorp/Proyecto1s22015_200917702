/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wservice;

import java.io.IOException;
import modelo.DATOS.*;
import modelo.*;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alexander
 */
@WebService(serviceName = "WSGUsuario")
public class WSGUsuario {
    public DATOAVL dato;
    RegistrarUsuario usuario;
    public WSGUsuario(){
        dato = new DATOAVL();
        dato.admin_id = "admin";
        dato.admin_contrasenia = "admin";
        dato.rol = "admin";
        ARBOLAVL.insertar(dato);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrarUsuario")
    public String registrarUsuario(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass, @WebParam(name = "rol") String rol) {
        usuario = new RegistrarUsuario();
        return usuario.setAdmin(user, pass, rol);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarUsuario")
    public String buscarUsuario(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        usuario = new RegistrarUsuario();
        return usuario.getAdmin(user, pass);
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "mostUS")
    public void mostUS(){
        try{
        ARBOLAVL.graficar_AVL(ARBOLAVL.raizArbol());
        }catch(IOException  e){
            e.getMessage();
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "datos")
    public String datos() {
        return ARBOLAVL.mostrar_datos(ARBOLAVL.raiz);
    }


    
    
}
