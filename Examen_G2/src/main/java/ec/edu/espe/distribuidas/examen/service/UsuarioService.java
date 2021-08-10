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

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ec.edu.espe.distribuidas.examen.dao.UsuarioRepository;
import ec.edu.espe.distribuidas.examen.model.Usuario;

/**
 *
 * @author Windows Boo
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;

    public UsuarioService(UsuarioRepository usuarioRepo) {

        this.usuarioRepo = usuarioRepo;

    }

    public List<Usuario> listAll() {

        return this.usuarioRepo.findAll();
    }

    public Optional<Usuario> obtainByCodigo(String codigo) {

        Optional<Usuario> usuarioCodigo = this.usuarioRepo
                .findById(codigo);
        if (usuarioCodigo.isPresent()) {
            return usuarioCodigo;
        } else {
            throw new RuntimeException("No encontrado");
        }

    }
}
