package com.javarom.agendamento_api.business;

import com.javarom.agendamento_api.business.mapper.IAgendamentoMapper;
import com.javarom.agendamento_api.controller.dto.in.AgendamentoRecord;
import com.javarom.agendamento_api.controller.dto.out.AgendamentoRecordOut;
import com.javarom.agendamento_api.infrastructure.entities.Agendamento;
import com.javarom.agendamento_api.infrastructure.exception.NotFoundException;
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

    public AgendamentoRecordOut buscarAgendamentosPorId(Long id){
        return agendamentoMapper.paraOut(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrador")));
    }

    public void cancelarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrador"));
        repository.save(
                agendamentoMapper.paraEntityCancelamento(agendamento)
        );
    }


}



