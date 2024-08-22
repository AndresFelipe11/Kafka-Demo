package co.com.bancolombia.model.operation;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Operation {
    private String accountSource;
    private String accountDestination;
    private double amount;
    private String transactionType;
}
