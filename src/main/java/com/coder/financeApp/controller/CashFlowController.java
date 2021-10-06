package com.coder.financeApp.controller;

import com.coder.financeApp.exception.ResourceNotFoundException;
import com.coder.financeApp.model.CashFlow;
import com.coder.financeApp.service.CashFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cash-flows")
//@CrossOrigin(origins = "http://localhost:4288")
public class CashFlowController {

    @Autowired
    private CashFlowService service;

    @GetMapping
    public ResponseEntity<List<CashFlow>> getAllCashFlow() {
        return ResponseEntity.ok().body(service.getAllCashFlow());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CashFlow> getCashFlowById(@PathVariable(value = "id") long fluxId)
            throws ResourceNotFoundException {
        CashFlow CashFlow = service.findById(fluxId);
        return ResponseEntity.ok().body(CashFlow);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<CashFlow> createCashFlow(@Valid @RequestBody CashFlow CashFlow) {
        CashFlow cf = service.insert(CashFlow);
        return ResponseEntity.ok().body(cf);
    }
}
