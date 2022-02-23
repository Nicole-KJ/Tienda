/**
 * @author KEREN NICOLE JIMENEZ FERNANDEZ
 */
package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name="personas")
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    
    @ManyToOne
    @JoinColumn(name="paises_id")
    private Pais pais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
   
}
