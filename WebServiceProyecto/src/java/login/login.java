/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loginUser")
    public String loginUser(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        if(user.equals("admin")&&pass.equals("admin")){
            return "admin";
        }else{
            return "guess";
        }
    }

    
    
}
