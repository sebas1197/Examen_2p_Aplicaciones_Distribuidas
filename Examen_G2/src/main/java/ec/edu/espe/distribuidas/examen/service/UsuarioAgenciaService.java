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
package ec.edu.espe.distribuidas.examen.service;

import ec.edu.espe.distribuidas.examen.model.Usuario;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ec.edu.espe.distribuidas.examen.dao.UsuarioAgenciaRepository;
import ec.edu.espe.distribuidas.examen.model.UsuarioAgencia;

/**
 *
 * @author Windows Boo
 */
@Service
public class UsuarioAgenciaService {

    private final UsuarioAgenciaRepository empresaRepo;

    public UsuarioAgenciaService(UsuarioAgenciaRepository empresaRepo) {

        this.empresaRepo = empresaRepo;

    }

    public Usuario obtainByCodigo(String codigo) {

        Optional<Usuario> usuarioOpt = this.empresaRepo.findById(codigo);
        if (usuarioOpt.isPresent()) {

            return usuarioOpt.get();

        } else {

            throw new RuntimeException("No encontrado");

        }
    }

    public List<Usuario> listAll() {

        return this.empresaRepo.findAll();

    }
    
    @Transactional
    public void create(UsuarioAgencia empresa) {

            empresaRepo.save(empresa);

    }

}
