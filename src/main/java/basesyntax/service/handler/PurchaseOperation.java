package basesyntax.service.handler;

import basesyntax.model.FruitTransaction;
import basesyntax.storage.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int current = Storage.get(fruit);
        int result = current - transaction.getQuantity();
        if (result < 0) {
            throw new RuntimeException("Not enough " + fruit + " in stock");
        }
        Storage.put(fruit, result);
    }
}
