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

import ec.edu.espe.distribuidas.examen.model.Usuario;
import ec.edu.espe.distribuidas.examen.model.UsuarioAgencia;
import ec.edu.espe.distribuidas.examen.service.UsuarioAgenciaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Windows Boo
 */
@RestController
@RequestMapping("/v1/usuarioAgencia")
@Slf4j
public class UsuarioAgenciaController {

    private final UsuarioAgenciaService service;

    public UsuarioAgenciaController(UsuarioAgenciaService service) {

        this.service = service;
    }

    @GetMapping(value = "{codigo}")
    @ApiOperation(value = "Obtiene las agencias del usuario", notes = "Retorna agencias del usuario"
            + " de acuerdo a su código")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Agencias encontrado"),
        @ApiResponse(code = 404, message = "No existe un usuario con agencia para "
                + "el codigo envidado")})
    public ResponseEntity obtenerUsuarioAgencia(
            @PathVariable("codigo") String codigo) {
        try {

            Usuario usuarioAgencia = this.service.obtainByCodigo(codigo);
            return ResponseEntity.ok(usuarioAgencia);

        } catch (Exception e) {

            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping
    @ApiOperation(value = "Listar usuarios con sus agencias", notes = "Retorna todas "
            + "los agencias por usuario")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Muestra todas las"
                + " agencias por usuario registradas en la base de datos")
    })
    public ResponseEntity listarTodos() {

        List<Usuario> usuariosAgencias = this.service.listAll();
        return ResponseEntity.ok(usuariosAgencias);

    }

    @PostMapping
    @ApiOperation(value = "Registrar agencias por usuario", notes = "Agrega "
            + "nuevas agencias por usuario a la base de datos")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Agencias por usuario registradas"),
        @ApiResponse(code = 400, message = "Agencias por usuario no pudieron ser registradas")

    })
    public ResponseEntity crear(@RequestBody List<UsuarioAgencia> usuarioAgencia) {
        try {

            log.info("Va a crear las agencias por usuario con la siguiente informacion: {}",
                    usuarioAgencia);
            this.service.create((UsuarioAgencia) usuarioAgencia);
            return ResponseEntity.ok().build();

        } catch (Exception e) {

            log.error("Ocurrio un error al crear las agencias por usuario. {} "
                    + "- retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
