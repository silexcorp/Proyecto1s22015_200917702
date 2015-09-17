/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struct;

/**
 *
 * @author Alexander
 */
public class DATOAVL {
    public int id;
    public LISTADOBLE lista_turno;
    public DATOAVL(){
        this.id = 0;
        this.lista_turno = null;
    }
    public DATOAVL(int id){
        this.id = id;
        this.lista_turno = null;
    }
}
