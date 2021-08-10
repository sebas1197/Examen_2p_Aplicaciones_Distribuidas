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

import ec.edu.espe.distribuidas.examen.controller.AgenciaController;
import ec.edu.espe.distribuidas.examen.model.Agencia;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ec.edu.espe.distribuidas.examen.dao.AgenciaRepository;

/**
 *
 * @author Windows Boo
 */
@Service
public class AgenciaService {

    private final AgenciaRepository agenciaRepo;

    public AgenciaService(AgenciaRepository agenciaRepo) {

        this.agenciaRepo = agenciaRepo;

    }

    public List<Agencia> listAll() {

        return this.agenciaRepo.findAll();

    }

    public List<Agencia> findByName(String nombre) {

        return agenciaRepo.findByNombreStartingWithOrderByNombre(nombre);

    }

    @Transactional 
    public void createAgencia(Agencia agencia) {

        if (agenciaRepo.existsByNombre(agencia.getNombre())) {

            throw new IllegalArgumentException("La agencia ya existe");

        } else {

            agenciaRepo.save(agencia);

        }
    }


}
