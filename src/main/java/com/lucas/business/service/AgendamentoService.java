package com.lucas.business.service;

import com.lucas.business.mapper.AgendamentoMapper;
import com.lucas.controller.dto.in.AgendamentoRecord;
import com.lucas.controller.dto.out.AgendamentoRecordOut;
import com.lucas.infrastructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    private final AgendamentoMapper mapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamentoRecord){
        return mapper.paraOut(
                repository.save(mapper.paraEntity(agendamentoRecord))
        );
    }
}
