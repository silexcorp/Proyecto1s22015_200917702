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
public class NODOAVL {
    protected DATOAVL datos;
    protected NODOAVL izq;
    protected NODOAVL der;
    int fe;
    
    public NODOAVL(DATOAVL datos){
        //super(datos);
        this.datos = datos;
        this.izq = this.der = null;
        fe = 0;
    }
    
    public NODOAVL(NODOAVL izq,DATOAVL datos, NODOAVL der){
        //super(izq, datos, der);
        this(datos);
        this.izq = izq;
        this.der = der;
        fe = 0;
    }
    
    
    /* Operaciones de acceso a los datos */
    public DATOAVL valorNodo(){return this.datos;}
    public NODOAVL subarbolIzq(){return this.izq;}
    public NODOAVL subarbolDer(){return this.der;}
    public void nuevoValor(DATOAVL dato){this.datos = dato;}
    public void ramaIzq(NODOAVL nodo){this.izq = nodo;}
    public void ramaDer(NODOAVL nodo){this.der = nodo;}
    public void visitar() {System.out.println(this.datos.id + " ");}
    
    
    
}
