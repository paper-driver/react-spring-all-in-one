package com.allinone.reactspring.controller;

import com.allinone.reactspring.model.Account;
import com.allinone.reactspring.payload.ResponseMessage;
import com.allinone.reactspring.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/get", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> getById(@RequestParam(value = "id") Long id){
        ResponseMessage<Account> response = accountService.getById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> getByEmail(@RequestParam(value = "email") String email){
        ResponseMessage<Account> response = accountService.getByEmail(email);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> updateIncome(@Valid @RequestBody ){
        ResponseMessage<Account> response = accountService.updateIncome(income)
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
