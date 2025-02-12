package com.javarom.agendamento_api.business.mapper;

import com.javarom.agendamento_api.controller.dto.in.AgendamentoRecord;
import com.javarom.agendamento_api.controller.dto.out.AgendamentoRecordOut;
import com.javarom.agendamento_api.infrastructure.entities.Agendamento;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;


@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamento);
    AgendamentoRecordOut paraOut(Agendamento agendamento);
}
