package co.com.bancolombia.model.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    private String accountNumber;
    private double amount;
    private String accountType;
}
