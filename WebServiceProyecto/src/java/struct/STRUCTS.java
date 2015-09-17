/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Alexander
 */
@WebService(serviceName = "STRUCTS")
@Stateless()
public class STRUCTS {
 public static ARBOLAVL arbol_chofer = new ARBOLAVL();
 public static LISTADOBLE lista_admin  = new LISTADOBLE();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getChoferes")
    public ARBOLAVL getChoferes() {
        //TODO write your implementation code here:
        return arbol_chofer;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAdmin")
    public LISTADOBLE getAdmin() {
        //TODO write your implementation code here:
        return lista_admin;
    }
}
