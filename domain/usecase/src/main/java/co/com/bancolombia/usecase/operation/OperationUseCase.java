package co.com.bancolombia.usecase.operation;

import co.com.bancolombia.model.account.gateways.AccountRepository;
import co.com.bancolombia.model.operation.Operation;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class OperationUseCase {

    private final AccountRepository cuentaRepository;


    public String saveSaldoNube(Operation operation){
        return cuentaRepository.save(operation);

    }
}
