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
package ec.edu.espe.distribuidas.examen.controller;

import ec.edu.espe.distribuidas.examen.model.Agencia;
import ec.edu.espe.distribuidas.examen.model.Usuario;
import ec.edu.espe.distribuidas.examen.service.AgenciaService;
import ec.edu.espe.distribuidas.examen.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Windows Boo
 */
@RestController
@RequestMapping("/v1/usuario")
@Slf4j
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Listar usuarios", notes = "Retorna todos "
            + "los usuarios")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Muestra todos los usuarios"
           )
    })
    public ResponseEntity listarTodos() {

        List<Usuario> usuario = this.service.listAll();
        return ResponseEntity.ok(usuario);

    }

    
}
