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
import ec.edu.espe.distribuidas.examen.service.AgenciaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/v1/agencia")
@Slf4j
public class AgenciaController {

    private final AgenciaService service;

    public AgenciaController(AgenciaService service) {

        this.service = service;

    }

    @GetMapping
    @ApiOperation(value = "Listar Agencias", notes = "Retorna todas "
            + "las agencias")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Muestra todas las"
                + " agencias")
    })
    public ResponseEntity listarTodos() {
        List<Agencia> agencia = this.service.listAll();
        return ResponseEntity.ok(agencia);
    }


    @PostMapping
    @ApiOperation(value = "Registrar una nueva agencia", notes = "Agrega"
            + "una nueva agencia a la base de datos")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Agencia registrada"),
        @ApiResponse(code = 400, message = "Agencia no pudo ser "
                + "registrada")

    })
    public ResponseEntity crearAgencia(
            @RequestBody Agencia agencia) {

        try {

            log.info("Va a crear la agencia con la siguiente informacion:"
                    + " {}", agencia);
            this.service.createAgencia(agencia);
            return ResponseEntity.ok().build();

        } catch (Exception e) {

            log.error("Ocurrio un error al crear la agencia. "
                    + "{} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();

        }
    }

}
