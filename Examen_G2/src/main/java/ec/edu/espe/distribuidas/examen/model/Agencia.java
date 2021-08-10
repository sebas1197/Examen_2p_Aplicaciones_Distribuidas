/*
 * Copyright (c) 2021 Windows Boo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Windows Boo - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.distribuidas.examen.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Windows Boo
 */
@Entity
@Table(name = "gen_agencia")
public class Agencia implements Serializable {

    private static final long serialVersionUID = 123456L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_agencia", nullable = false)
    private String codigoAgencia;

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL)
    private List<UsuarioAgencia> empresas;
    
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    public Agencia() {
    }

    public List<UsuarioAgencia> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<UsuarioAgencia> empresas) {
        this.empresas = empresas;
    }
    
    public Agencia(String codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public String getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(String codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {

        int hash = 0;
        hash += (codigoAgencia != null ? codigoAgencia.hashCode() : 0);
        return hash;

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agencia other = (Agencia) obj;
        if (!Objects.equals(this.codigoAgencia, other.codigoAgencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agencia[ "
                + "codigo Agencia = " + codigoAgencia + " ]";
    }

    

}
