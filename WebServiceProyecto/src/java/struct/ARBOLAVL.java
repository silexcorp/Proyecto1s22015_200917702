package struct;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
        Random ran = new Random();
        System.out.println("");
        /*ARBOLAVL a = new ARBOLAVL();DATOAVL dats = new DATOAVL(3);
        a.modificar(dats);
        for(int i = 0; i< 4;i++){
            int j = ran.nextInt(20) + 1;
            System.out.print(" " + Integer.toString(j));
            DATOAVL b = new DATOAVL(j);
            a.insertar(b);
        }
        System.out.println("");
        System.out.println("    NODO RAIZ: "+ Integer.toString(a.raizArbol().datos.id));
        DATOAVL dat = new DATOAVL(3);
        a.modificar(dat);
        a.in_orden(a.raizArbol());
        a.graficar_AVL(a.raizArbol());
       
        DATOAVL b = new DATOAVL(50);        a.insertar(b);
        DATOAVL c = new DATOAVL(25);        a.insertar(c);
        DATOAVL d = new DATOAVL(75);        a.insertar(d);
        DATOAVL e = new DATOAVL(12);        a.insertar(e);
        DATOAVL f = new DATOAVL(30);        a.insertar(f);
        DATOAVL g = new DATOAVL(72);        a.insertar(g);
        DATOAVL h = new DATOAVL(85);        a.insertar(h);
        DATOAVL i = new DATOAVL(5);         a.insertar(i);
        DATOAVL j = new DATOAVL(18);        a.insertar(j);
        DATOAVL k = new DATOAVL(40);        a.insertar(k);
        DATOAVL l = new DATOAVL(74);        a.insertar(l);
        DATOAVL m = new DATOAVL(99);        a.insertar(m);
        DATOAVL n = new DATOAVL(72);        a.insertar(n);
        //System.out.println("    NODO RAIZ: "+ Integer.toString(a.raizArbol().datos.id));
        //a.in_orden(a.raizArbol());
        //a.graficar_AVL(a.raizArbol());
        
        
        LISTADOBLE lista = new LISTADOBLE();
        for(int h = 0; h < 9; h ++){
            int j = ran.nextInt(30) + 1;
            DATOLD a = new DATOLD(j);
            lista.insertar(a);
            //
        }
        DATOLD a = new DATOLD(11);
        //lista.eliminar(a );
        DATOLD nuevo = new DATOLD(3);
        
        lista.mostrar(lista);
        
        lista.editar(nuevo);
        lista.graficar_lista(lista);
 */

/**
 *
 * @author Alexander
 */
public class ARBOLAVL {
    private NODOAVL raiz;
    private boolean estado;
    
    public ARBOLAVL(){
        this.raiz = null;
        this.estado = false;
    }
    
    public NODOAVL raizArbol(){return this.raiz;}
    public void setEstado(boolean b){this.estado = b;}
    public boolean getEstado(){ return this.estado;}
    
    private NODOAVL rotacionII(NODOAVL nodo, NODOAVL nodo2){
        nodo.ramaIzq(nodo2.subarbolDer());
        nodo2.ramaDer(nodo);
        /* Actualización del FE */
        if(nodo2.fe == -1){
            nodo.fe = 0;
            nodo2.fe = 0;
        }else{
            nodo.fe = -1;
            nodo2.fe = 1;
        }
        return nodo2;
    }

    private NODOAVL rotacionDD(NODOAVL nodo, NODOAVL nodo2){
        nodo.ramaDer(nodo2.subarbolIzq());
        nodo2.ramaIzq(nodo);
        /* Actualización del FE */
        if(nodo2.fe == +1){
            nodo.fe = 0;
            nodo2.fe = 0;
        }else{
            nodo.fe = +1;
            nodo2.fe = -1;
        }
        return nodo2;
    }

    private NODOAVL rotacionID(NODOAVL nodo, NODOAVL nodo2){
        NODOAVL nodo3;
        nodo3 = (NODOAVL)nodo2.subarbolDer();
        nodo.ramaIzq(nodo3.subarbolDer());
        nodo3.ramaDer(nodo);
        nodo2.ramaDer(nodo3.subarbolIzq());
        nodo3.ramaIzq(nodo2);
        /* Actualización del FE */
        if(nodo3.fe == +1){
            nodo2.fe = -1;
        }else{
            nodo2.fe = 0;
        }
        if(nodo3.fe == -1){
            nodo.fe = 1;
        }else{
            nodo.fe = 0;
        }
        nodo3.fe = 0;
        return nodo3;
    }
    
    private NODOAVL rotacionDI(NODOAVL nodo, NODOAVL nodo2){
        NODOAVL nodo3;
        nodo3 = (NODOAVL)nodo2.subarbolIzq();
        nodo.ramaDer(nodo3.subarbolIzq());
        nodo3.ramaIzq(nodo);
        nodo2.ramaIzq(nodo3.subarbolDer());
        nodo3.ramaDer(nodo2);
        /* Actualización del FE */
        if(nodo3.fe == +1){
            nodo.fe = -1;
        }else{
            nodo.fe = 0;
        }
        if(nodo3.fe == -1){
            nodo2.fe = 1;
        }else{
            nodo2.fe = 0;
        }
        nodo3.fe = 0;
        return nodo3;
    }
    
    public void insertar(DATOAVL dato){
        NODOAVL aux = insertarAVL(raiz, dato, estado);
        setEstado(false);
        if(aux != null){
            raiz = aux;
        }
    }

    private NODOAVL insertarAVL(NODOAVL raiz, DATOAVL dato, boolean estado){
        NODOAVL nodo;
        if(raiz == null){
            raiz = new NODOAVL(dato);
            setEstado(true);
        }else if(dato.id < raiz.valorNodo().id){
            NODOAVL izq;
            izq = insertarAVL((NODOAVL)raiz.subarbolIzq(),dato, estado);
            raiz.ramaIzq(izq);
            /* Regreso por busqueda */
            if(getEstado()){
                switch(raiz.fe){
                    case 1:
                        raiz.fe = 0;
                        setEstado(false);
                        break;
                    case 0:
                        raiz.fe = -1;
                        break;
                    case -1:
                        /* Aplicar rotacion II */
                        nodo = (NODOAVL)raiz.subarbolIzq();
                        if(nodo.fe == -1){
                            raiz = rotacionII(raiz, nodo);
                        }else{
                            raiz = rotacionID(raiz, nodo);
                        }
                    setEstado(false);      
                }
            }
        }else if(dato.id > raiz.valorNodo().id){
            NODOAVL node;
            node = insertarAVL((NODOAVL)raiz.subarbolDer(), dato, estado);
            raiz.ramaDer(node);
            /* Regresar nodo a busqueda */
            if(getEstado()){
                /* Incrementar fe por altura */
                /* Aplicar rotacion derecha */
                switch(raiz.fe){
                    case 1:
                        nodo = (NODOAVL)raiz.subarbolDer();
                        if(nodo.fe == +1){
                            raiz = rotacionDD(raiz,nodo);
                        }else{
                            raiz = rotacionDI(raiz, nodo);
                        }
                        setEstado(false);
                        break;
                    case 0:
                        raiz.fe = +1;
                        break;
                    case -1:
                        raiz.fe = 0;
                        setEstado(false);                        
                }
            }
        }else{
            System.out.println("CLAVE REPETIDA EN INSERCION");
        }
        return raiz;        
    }
    
    
    public void modificar(DATOAVL dato){
        modificarAVL(this.raiz,dato);
    }
    private void modificarAVL(NODOAVL raiz, DATOAVL dato){
        if(raiz != null){
            if(raiz.datos.id == dato.id){
                raiz.datos = dato;
                System.out.println("    Dato hallado: " + Integer.toString(raiz.datos.id));
            }else if(raiz.datos.id < dato.id){
                modificarAVL(raiz.der, dato);
            }else{
                modificarAVL(raiz.izq, dato);
            } 
        }else{
             System.out.println(" NO EXISTE: " + Integer.toString(dato.id));
        }
        
    }
    
    public void eliminar(DATOAVL dato){
        setEstado(false);
        raiz = borrarAVL(raiz, dato, estado);
    }
    
    private NODOAVL borrarAVL(NODOAVL nodo, DATOAVL dato, boolean estado){
        if(nodo == null){
            System.out.println("NODO NO ENCONTRADO");
        }else if(dato.id < nodo.valorNodo().id){
            NODOAVL izq;
            izq = borrarAVL((NODOAVL)nodo.subarbolIzq(), dato, estado);
            nodo.ramaIzq(izq);
            if(getEstado()){
                nodo = equilibrarA(nodo, estado);
            }
        }else if(dato.id > nodo.valorNodo().id){
            NODOAVL der;
            der = borrarAVL((NODOAVL)nodo.subarbolDer(), dato, estado);
            nodo.ramaDer(der);
            if(getEstado()){
                nodo = equilibrarB(nodo, estado);
            }
        }else{
            /* No se encontró nodo y quitar el nuevo */
            NODOAVL aux;
            aux = nodo;
            if(aux.subarbolIzq() == null){
                nodo = (NODOAVL)aux.subarbolDer();
                setEstado(true);
                
            }else if(aux.subarbolDer() == null){
                nodo = (NODOAVL)aux.subarbolIzq();
                setEstado(true);
            }else{
                /* No existe rara der ni izq */
                NODOAVL izq;
                izq = reemplazar(nodo,(NODOAVL)nodo.subarbolIzq(), estado);
                nodo.ramaIzq(izq);
                if(getEstado()){
                    nodo = equilibrarA(nodo, estado);
                }
            }
            aux = null;
        }
        return nodo;
    }
    
    
    private NODOAVL reemplazar(NODOAVL nodo, NODOAVL actual, boolean estado){
        if(actual.subarbolDer() != null){
            NODOAVL der;
            der = reemplazar(nodo, (NODOAVL)actual.subarbolDer(), estado);
            actual.ramaDer(der);
            if(getEstado()){
                actual = equilibrarB(actual, estado);
            }
        }else{
            nodo.nuevoValor(actual.valorNodo());
            nodo = actual;
            actual = (NODOAVL)actual.subarbolIzq();
            nodo = null;
            setEstado(true);
        }
        return actual;
    }
    
    
    private NODOAVL equilibrarA(NODOAVL nodo, boolean estado) {
        NODOAVL aux;
        switch(nodo.fe){
            case -1:
                nodo.fe = 0;
                break;
            case 0:
                nodo.fe = 1;
                setEstado(false);
                break;
            case +1: /* Rotacion derecha */
                aux = (NODOAVL)nodo.subarbolDer();
                if(aux.fe >= 0){
                    if(aux.fe == 0){
                        setEstado(false);
                    }
                    nodo = rotacionDI(nodo,aux);
                }
            break; 
        }
        return nodo;
    }
    
    private NODOAVL equilibrarB(NODOAVL nodo, boolean estado) {
        NODOAVL aux;
        switch(nodo.fe){
            case -1:
                /* Rotaciones */
                aux = (NODOAVL)nodo.subarbolIzq();
                if(aux.fe >= 0){
                    if(aux.fe == 0){
                        setEstado(false);
                    }
                    nodo = rotacionII(nodo, aux);
                }else{
                    nodo = rotacionID(nodo, aux);
                }
                break;
            case 0:
                nodo.fe = -1;
                setEstado(false);
                break;
            case +1: /* Rotacion derecha */
                nodo.fe = 0;
                break; 
        }
        return nodo;
    }
    
    
    
    
    
    
    
    
    
    public void in_orden(NODOAVL raiz){
        if(raiz == null){
            //System.out.println("ARBOL VACIO!");
        }else{
            in_orden(raiz.izq);
            System.out.println("DATO: "+ Integer.toString(raiz.datos.id));
            in_orden(raiz.der);
        }
    }
    

    
    
    
    
    
    
    public static void escribirNodo(BufferedWriter bw, NODOAVL nodo) throws IOException{
        if(nodo == null){return;}
        else{
          bw.write("\t\t"+Integer.toString(nodo.datos.id) + " [label = \"<der> | <dat> " + Integer.toString(nodo.datos.id) + " | <izq>\"];\r");
        }
        NODOAVL iz = nodo.izq;
        NODOAVL de = nodo.der;
        if (de != null){
            bw.write("\t\t"+Integer.toString(nodo.datos.id) + " :izq -> " + Integer.toString(nodo.der.datos.id) + ";\r");
        }
        if (iz != null){
            bw.write("\t\t"+Integer.toString(nodo.datos.id) + " :der -> " + Integer.toString(nodo.izq.datos.id) + ";\r");
        }
 
        escribirNodo(bw,iz);
        escribirNodo(bw,de);
    }
    
    
    
    public static void escribirNodoB(BufferedWriter bw, NODOAVL nodo) throws IOException{
        if(nodo == null){return;}
        
        NODOAVL iz = nodo.izq;
        NODOAVL de = nodo.der;
        if (de != null){
            bw.write("\t\t"+Integer.toString(nodo.datos.id) + " :izq -> " + Integer.toString(nodo.der.datos.id) + ";\r");
        }
        if (iz != null){
            bw.write("\t\t"+Integer.toString(nodo.datos.id) + " :der -> " + Integer.toString(nodo.izq.datos.id) + ";\r");
        }
 
        escribirNodoB(bw,iz);
        escribirNodoB(bw,de);
    }
    
    public static void escribirNodoA(BufferedWriter bw, NODOAVL nodo) throws IOException{
        if(nodo == null){return;}
        else{
          bw.write("\t\t"+Integer.toString(nodo.datos.id) + " [label = \"<der> | <dat> " + Integer.toString(nodo.datos.id) + " | <izq>\"];\r");
        }
        NODOAVL iz = nodo.izq;
        NODOAVL de = nodo.der;
        
        escribirNodoA(bw,iz);
        escribirNodoA(bw,de);
    }
    
    public void graficar_AVL(NODOAVL raiz) throws IOException{
        String fileInputPath = "A:\\grafo_avl.dot";
        File archivo = new File(fileInputPath);
        BufferedWriter bw;
        if(archivo.exists() || !archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("");
            bw.write("digraph ARBOLAVL{\r");
            bw.write("\t/*Definicion atributos grafo en general*/ \r");
            bw.write("\tnode [shape = record];\r");
            bw.write("\t/*Definicion atributos generales nodos*/\r");
            bw.write("\trankdir=TD; /*LR=Izquierda a derecha || TB=Arriba a abajo*/\r");
            bw.write("\tlabel=ARBOL;\r");
            //bw.write("\trank=same;\r");
            bw.write("\tnodesep=0.5;\r");
            bw.write("\t/*Definicion atributos generales aristas*/\r");
            bw.write("\tedge [color=\"black\", dir=fordware]\r");
            bw.write("\t\r");
            bw.write("\t/*Definicion de nodos*/\r");
            //bw.write("\tsubgraph dato0{\t\r");
            bw.write("\tsubgraph cluster0{\t\r");
            bw.write("\tlabel=AVL;\r");
            bw.write("\tnode [style=filled, color = \"skyblue\"];\r");
            bw.write("\t\t\r");
            
            escribirNodoA(bw, raiz);
            escribirNodoB(bw, raiz);
            
            bw.write("\t}\t\r");
            bw.write("\t/*Definicion de relaciones entre nodos*/\r");
            bw.write("\t\r");
            bw.write("}\r");
            bw.write("\r");
            bw.write("");
            
            bw.close();
        } 
        
        try {

          String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
          String fileOutputPath = "A:\\grafo_avl.png";
          
          //dibujar(dotPath,fileOutputPath);
          
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
    String file = new String("A:\\grafo_avl.png"); 
        try{ 
        //definiendo la ruta en la propiedad file
        Runtime.getRuntime().exec("cmd /c start "+file);

        }catch(IOException e){
          e.printStackTrace();
        } 
    }

    
    
    
    
   
    
 
    
    
}

