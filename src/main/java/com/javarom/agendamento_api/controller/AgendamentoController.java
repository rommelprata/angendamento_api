package com.javarom.agendamento_api.controller;

import com.javarom.agendamento_api.business.AgendamentoService;
import com.javarom.agendamento_api.controller.dto.in.AgendamentoRecord;
import com.javarom.agendamento_api.controller.dto.out.AgendamentoRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgendamento(@RequestBody AgendamentoRecord agendamento){

        return  ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoRecordOut> buscarAgendamentoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(agendamentoService.buscarAgendamentosPorId(id));
    }

}
