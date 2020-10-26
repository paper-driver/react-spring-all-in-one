package com.allinone.reactspring.controller;

import com.allinone.reactspring.model.Account;
import com.allinone.reactspring.payload.RequestMessage;
import com.allinone.reactspring.payload.ResponseMessage;
import com.allinone.reactspring.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/get-all", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<List<Account>>> getAll(){
        ResponseMessage<List<Account>> response = accountService.getAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping(value = "/get", params = "id", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> getById(@RequestParam Long id){
        ResponseMessage<Account> response = accountService.getById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping(value = "/get", params = "email", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> getByEmail(@RequestParam String email){
        ResponseMessage<Account> response = accountService.getByEmail(email);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping(value = "/update/income", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> updateIncome(@Valid @RequestBody RequestMessage<Long> body){
        ResponseMessage<Account> response = accountService.updateIncome(body.getEmail(), body.getRequest());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping(value = "/update/debt", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> updateDebt(@Valid @RequestBody RequestMessage<Long> body){
        ResponseMessage<Account> response = accountService.updateDebt(body.getEmail(), body.getRequest());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping(value = "/update/saving", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> updateSaving(@Valid @RequestBody RequestMessage<Long> body){
        ResponseMessage<Account> response = accountService.updateSaving(body.getEmail(), body.getRequest());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping(value = "/update/net-saving", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> updateNetSaving(@Valid @RequestBody RequestMessage body){
        ResponseMessage<Account> response = accountService.updateNetSaving(body.getEmail());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<ResponseMessage<Account>> createAccount(@Valid @RequestBody RequestMessage<Account> body){
        ResponseMessage<Account> response = accountService.createAccount(body.getRequest());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
