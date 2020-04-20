package be.uantwerpen.lab3DistSystZsombor.controller;

import org.springframework.web.bind.annotation.RestController;
import be.uantwerpen.lab3DistSystZsombor.database.BankRepository;
import be.uantwerpen.lab3DistSystZsombor.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ServerController {
    @GetMapping(value = "/accounts/{id}")
    public Account getBalance(@PathVariable(required = true) int id) {
        if (id < 1 || id > BankRepository.getInstance().getAccounts().size()) {
            throw new AccountNotFoundException(id);
        }
        return BankRepository.getInstance().getAccounts().get(id-1);
    }

    @GetMapping(value = "/accounts/add/{id}/{amount}")
    public Account addMoney(@PathVariable(required = true) int id, @PathVariable(required = true) int amount) {
        if (id < 1 || id > BankRepository.getInstance().getAccounts().size()) {
            throw new AccountNotFoundException(id);
        }
        return BankRepository.getInstance().updateAccount(id, amount);
    }

    @GetMapping(value = "/accounts/remove/{id}/{amount}")
    public Account removeMoney(@PathVariable(required = true) int id, @PathVariable(required = true) int amount) {
        if (id < 1 || id > BankRepository.getInstance().getAccounts().size()) {
            throw new AccountNotFoundException(id);
        }
        return BankRepository.getInstance().updateAccount(id, -amount);
    }

    private class AccountNotFoundException extends RuntimeException {
        public AccountNotFoundException(int id) {
            super("No such bank account: " + id);
        }
    }
}
