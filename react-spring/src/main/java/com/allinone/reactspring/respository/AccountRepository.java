package com.allinone.reactspring.respository;

import com.allinone.reactspring.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(Integer id);

    Account findByEmail(String email);

    Boolean existsByEmail(String email);

    List<Account> findAll();
}
