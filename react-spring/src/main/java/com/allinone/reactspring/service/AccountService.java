package com.allinone.reactspring.service;

import com.allinone.reactspring.respository.AccountRepository;
import com.allinone.reactspring.model.Account;
import com.allinone.reactspring.payload.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    public ResponseMessage<Account> updateIncome(String email, Long new_income){
        if(accountRepository.existsByEmail(email)){
            try{
                Account account = accountRepository.findByEmail(email);
                account.setIncome(new_income);
                accountRepository.saveAndFlush(account);
                return new ResponseMessage<Account>("Succeeded to update income", HttpStatus.ACCEPTED);
            }catch(Exception e){
                logger.error("update income error: " + e.getMessage());
                return new ResponseMessage<Account>("Failed to update income", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseMessage<Account>("The account does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseMessage<Account> updateNetSaving(String email){
        if(accountRepository.existsByEmail(email)){
            try{
                Account account = accountRepository.findByEmail(email);
                account.setNet_saving(account.getSaving() - account.getDebt());
                accountRepository.saveAndFlush(account);
                return new ResponseMessage<Account>("Succeeded to update net saving", HttpStatus.ACCEPTED);
            }catch(Exception e){
                logger.error("update net saving error: " + e.getMessage());
                return new ResponseMessage<Account>("Failed to update net saving", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseMessage<Account>("The account does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseMessage<Account> updateDebt(String email, Long debt){
        if(accountRepository.existsByEmail(email)){
            try{
                Account account = accountRepository.findByEmail(email);
                account.setDebt(debt);
                account.setNet_saving(account.getSaving() - debt);
                accountRepository.saveAndFlush(account);
                return new ResponseMessage<Account>("Succeeded to update debt", HttpStatus.ACCEPTED);
            }catch(Exception e){
                logger.error("update debt error: " + e.getMessage());
                return new ResponseMessage<Account>("Failed to update debt", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseMessage<Account>("The account does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseMessage<Account> updateSaving(String email, Long saving){
        if(accountRepository.existsByEmail(email)){
            try{
                Account account = accountRepository.findByEmail(email);
                account.setSaving(saving);
                account.setNet_saving(saving - account.getDebt());
                accountRepository.saveAndFlush(account);
                return new ResponseMessage<Account>("Succeeded to update saving", HttpStatus.ACCEPTED);
            }catch(Exception e){
                logger.error("update saving error: " + e.getMessage());
                return new ResponseMessage<Account>("Failed to update saving", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseMessage<Account>("The account does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseMessage<Account> getByEmail(String email){
        if(accountRepository.existsByEmail(email)){
            try{
                Account account = accountRepository.findByEmail(email);
                return new ResponseMessage<Account>("Succeeded to find the account", HttpStatus.ACCEPTED, account);
            }catch(Exception e){
                logger.error("get account by email error: " + e.getMessage());
                return new ResponseMessage<Account>("Failed to find the account", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseMessage<Account>("The account does not exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseMessage<Account> getById(Long id){
        if(accountRepository.existsById(id)){
            try{
                Account account = accountRepository.findById(id).get();
                return new ResponseMessage<Account>("Succeeded to find the account", HttpStatus.ACCEPTED, account);
            }catch(Exception e){
                logger.error("get account by id error: " + e.getMessage());
                return new ResponseMessage<Account>("Failed to find the account", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseMessage<Account>("The account does not exist", HttpStatus.BAD_REQUEST);
        }
    }
}
