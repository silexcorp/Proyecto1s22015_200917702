/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import struct.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Alexander
 */
@WebService(serviceName = "login")
@Stateless()
public class login {

    public DATOS datos_admin;
    public DATOLD dato;
    public login(){
        datos_admin = new DATOS();
        dato = new DATOLD();
        //dato.
        //datos_admin.lista_admin.insertar(null)
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "loginUser")
    public String loginUser(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        if(user.equals("admin")&&pass.equals("admin")){
            return "admin";
        }else if(user.equals("user")&&pass.equals("user")){
            return "user";
        }else{
            return "guest";
        }
    }

    
    
}
