/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    
    
    
    
    public static void escribirNodo(BufferedWriter bw, LISTADOBLE lista) throws IOException{
        NODOLD aux;
        aux = lista.ini;
        int i = 0;
        bw.write("\t\tcabecera_"+Integer.toString(0) + " [label = \"<a> | <b> cabercera | <c>\"];\r");
        while(aux != null){
            bw.write("\t\tlista_"+Integer.toString(i) + " [label = \"<a> | <b> id: " + Integer.toString(aux.datos.id) + " | <c>\"];\r");
            aux = aux.sig; i++;
        }
        bw.write("\t\tnull_"+Integer.toString(0) + " [label = \"null\" , shape = none];\r");
        i = 0;
        bw.write("\t\n");
        //bw.write("\t}\n");
        bw.write("\t\tcabecera_"+Integer.toString(i) + " -> lista_" + Integer.toString(i) + ";\r");
        
        aux = lista.ini;
        while(aux != null){
            if(aux.sig != null){
                bw.write("\t\tlista_"+Integer.toString(i) + " -> lista_" + Integer.toString(i+1) + ";\r");
            }
            aux = aux.sig; i++;
        }

        aux = lista.ini;
        i--;
        /* INVERTIR FLECHAS XD */
        while(aux != null){
            if(aux.sig != null){
                bw.write("\t\tlista_"+Integer.toString(i) + " -> lista_" + Integer.toString(i-1) + ";\r");
            }
            aux = aux.sig; i--;
        }
        bw.write("\t\tlista_"+Integer.toString(lista.tam-1) + " -> null_" + Integer.toString(0) + ";\r");
        i = 0;
    }
    
    public void graficar_lista(LISTADOBLE lista) throws IOException{
        String fileInputPath = "A:\\grafo_lista.dot";
        File archivo = new File(fileInputPath);
        BufferedWriter bw;
        if(archivo.exists() || !archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("");
            bw.write("digraph LISTADOBLE{\r");
            bw.write("\t/*Definicion atributos grafo en general*/ \r");
            bw.write("\tnode [shape = record];\r");
            bw.write("\t/*Definicion atributos generales nodos*/\r");
            bw.write("\trankdir=TD; /*LR=Izquierda a derecha || TB=Arriba a abajo*/\r");
            bw.write("\tlabel=LISTA;\r");
            bw.write("\tnodesep=0.5;\r");
            bw.write("\t/*Definicion atributos generales aristas*/\r");
            bw.write("\tedge [color=\"black\", dir=fordware]\r");
            bw.write("\t\r");
            bw.write("\t/*Definicion de nodos*/\r");
            bw.write("\tsubgraph cluster0{\t\r");
            bw.write("\tlabel=LISTA;\r");
            bw.write("\tnode [style=filled, color = \"skyblue\"];\r");
            bw.write("\t\t\r");
            
            bw.write("\t/*Definicion de relaciones entre nodos*/\r");
            escribirNodo(bw, lista);
            
            bw.write("\t}\t\r");
            bw.write("\t\r");
            bw.write("}\r");
            bw.write("\r");
            bw.write("");
            bw.close();
        } 
        
        try {

          String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
          String fileOutputPath = "A:\\grafo_lista.png";
          
          String tParam = "-Tpng";
          String tOParam = "-o";

          String[] cmd = new String[5];
          cmd[0] = dotPath;
          cmd[1] = tParam;
          cmd[2] = fileInputPath;
          cmd[3] = tOParam;
          cmd[4] = fileOutputPath;

          Runtime rt = Runtime.getRuntime();
          rt.exec( cmd );

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        
        
        abrir();

    }
    
    public static void abrir() {
    //ruta del archivo en el pc
    String file = new String("A:\\grafo_lista.png"); 
        try{ 
        //definiendo la ruta en la propiedad file
        Runtime.getRuntime().exec("cmd /c start "+file);

        }catch(IOException e){
          e.printStackTrace();
        } 
    }

    
    
    
    
    
}
