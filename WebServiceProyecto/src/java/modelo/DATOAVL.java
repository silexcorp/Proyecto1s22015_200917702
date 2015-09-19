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
public class DATOAVL {
    /* Admin */
    public int id;
    public String rol;
    public String admin_id;
    public String admin_contrasenia;
    /* Est CLAVE */
    public String est_clave_id;
    public String est_clave_nombre;
    public String est_clave_contrasenia;
    /* Est GENERAL */
    public String est_gene_id;
    public String est_gene_nombre;
    public String est_gene_contrasenia;
    /* CHOFERES */
    public String chofer_id;
    public String chofer_nombre;
    public String chofer_apellido;
    public String chofer_contrasenia;
    public String chofer_correo;
    public LISTADOBLE chofer_lista;
    
    public DATOAVL(){
        this.id = 0;
        this.admin_id = this.admin_contrasenia = null;
        this.est_clave_id = this.est_clave_nombre = null;
        this.est_clave_contrasenia = this.est_gene_id = null;
        this.est_gene_nombre = this.est_gene_contrasenia = null;
        this.chofer_id = this.chofer_nombre = null;
        this.chofer_apellido = this.chofer_contrasenia = null;
        this.chofer_lista = null; this.chofer_correo = null;
    }
    
}