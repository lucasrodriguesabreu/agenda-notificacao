package com.lucas.business.service;

import com.lucas.business.mapper.AgendamentoMapper;
import com.lucas.controller.dto.in.AgendamentoRecord;
import com.lucas.controller.dto.out.AgendamentoRecordOut;
import com.lucas.infrastructure.entities.Agendamento;
import com.lucas.infrastructure.exceptions.NotFoundException;
import com.lucas.infrastructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    private final AgendamentoMapper mapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento){
        return mapper.paraOut(
                repository.save(
                        mapper.paraEntity(agendamento)));
    }

    public AgendamentoRecordOut buscarAgendamentosPorId(Long id){
        return mapper
                .paraOut(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrador")));
    }

    public void cancelarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrador"));
        repository.save(
                mapper.paraEntityCancelamento(agendamento)
        );
    }
}
