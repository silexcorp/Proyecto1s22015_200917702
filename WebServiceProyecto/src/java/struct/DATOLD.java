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
public class DATOLD {
    public int id;
    public String id_alfa;
    public DATOLD(){
        this.id = 0;
    }
    public DATOLD(int id){
        this.id = id;
    }
    public DATOLD(String id){
        this.id_alfa = id;
        this.id = convertir(id);
    }
    private int convertir(String dato){
        int longitud = 0;
        for (int x = 0; x<dato.length(); x++){
            System.out.println(dato.charAt(x) + " = " + dato.codePointAt(x));
            longitud += (int)dato.codePointAt(x);
        }
        return longitud;
    }
}
