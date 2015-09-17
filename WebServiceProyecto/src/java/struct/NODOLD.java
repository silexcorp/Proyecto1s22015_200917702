/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author Alexander
 */
public class NODOLD {
    protected DATOLD datos;
    protected NODOLD ant;
    protected NODOLD sig;
    
    public NODOLD(DATOLD datos){
        //super(datos);
        this.datos = datos;
        this.ant = this.sig = null;
    }
    
    public NODOLD(NODOLD izq,DATOLD datos, NODOLD der){
        //super(izq, datos, der);
        this(datos);
        this.ant = izq;
        this.sig = der;
    }
}
