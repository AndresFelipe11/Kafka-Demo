package co.com.bancolombia.model.account.gateways;

import co.com.bancolombia.model.operation.Operation;

public interface AccountRepository {
    String save(Operation operation);
}
