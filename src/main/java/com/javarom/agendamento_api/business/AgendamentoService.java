package com.javarom.agendamento_api.business;

import com.javarom.agendamento_api.business.mapper.IAgendamentoMapper;
import com.javarom.agendamento_api.controller.dto.in.AgendamentoRecord;
import com.javarom.agendamento_api.controller.dto.out.AgendamentoRecordOut;
import com.javarom.agendamento_api.infrastructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento){
       return agendamentoMapper.paraOut(repository.save(agendamentoMapper.paraEntity(agendamento)));
    }


}



