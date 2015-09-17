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
public class LISTADOBLE {
    private DATOLD dato;
    private NODOLD ini, fin;
    private int tam;
    private boolean estado;
    
    public LISTADOBLE(){
        //super(dato);
        this.ini = this.fin = null;
        this.estado = false;
        tam = 0;
    }
    public int getTam(){return this.tam;}
    public DATOLD getDato(){return this.dato;}
    public void setDato(DATOLD dato){this.dato = dato;}
    public NODOLD getIni(){return this.ini;}
    public NODOLD getFin(){return this.fin;}
    public void setIni(NODOLD ini){this.ini = ini;}
    public void setFin(NODOLD fin){this.fin = fin;}
    public void setEstado(boolean estado){this.estado = estado;}
    public boolean getEstado(){ return this.estado;}
    
    public boolean estaVacio(){
        return this.ini == null;
    }
    public LISTADOBLE insertar(DATOLD dato){
        NODOLD nuevo;
        if(estaVacio()){
            nuevo = new NODOLD(dato);
            this.ini = nuevo;
            this.fin = nuevo;
            this.tam++;
        }else{
            nuevo = new NODOLD(dato);
            this.fin.sig = nuevo;
            nuevo.ant = this.fin;
            this.fin = nuevo;
            this.tam++;
        }
        return this;
    }
    /*public void insertar_lista(LISTADOBLE lista, DATOLD dato){
        NODOLD nuevo;
        if(lista == null){
            nuevo = new NODOLD(dato);
            lista.setIni(nuevo);
            lista.setFin(nuevo);
            lista.tam++;
        }else{
            nuevo = new NODOLD(dato);
            nuevo.ant = lista.getFin();
            lista.getFin().sig = nuevo;
            lista.setFin(nuevo);
            lista.tam++;
        }
    }
    */

    public void eliminar(DATOLD dato){
        NODOLD temp = null, actual = this.ini;
        while(actual != this.fin){
            if(actual.datos.id == dato.id){
                if(temp == null){
                    this.ini = actual.sig;
                    this.ini.ant = null;
                    this.tam--;
                }else{
                    temp.sig = actual.sig;
                    NODOLD tempo;
                    tempo = actual.sig;
                    tempo.ant = temp;
                    this.tam--;
                }
                return;
            }
            temp = actual;
            actual = actual.sig;
        }
        if(dato.id == this.fin.datos.id){
            this.fin = actual.ant;
                    this.tam--;
        }else{
            System.out.println(" ELEMENTO NO ECNONTRAD: " + Integer.toString(dato.id));
        }
    }
    
    public void editar(DATOLD dato){
        NODOLD actual = this.ini;
        while(actual != this.fin){
            if(actual.datos.id == dato.id){
                actual.datos = dato;
                break;
            }
            actual = actual.sig;
        }
        if(dato.id == this.fin.datos.id){
            actual.datos = dato;
        }else{
            System.out.println(" ELEMENTO NO ECNONTRAD: " + Integer.toString(dato.id));
        }
    }
    
    public void mostrar(LISTADOBLE lista){
        NODOLD aux;
        aux = lista.ini;
        if(lista.getTam() >= 0){
            for(int i = 0; i<lista.tam; i++){
                System.out.println("    LISTADO: "+ Integer.toString(aux.datos.id));
                aux = aux.sig;
            }
        }
    }
}
