package co.com.bancolombia.model;
import lombok.*;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Cuenta {

    String accountSource;
    String accountDestination;
    double amount;
    String accountType;
    String transactionType;
}
