package com.worldline.interview;

import java.math.BigDecimal;

public class WidgetMachine {
    private Engine engine = new InternalCombustionEngine(FuelType.PETROL);

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public BigDecimal produceWidgets(int quantity) {
        engine.start();
        BigDecimal cost = BigDecimal.valueOf(0);

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private BigDecimal produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        float costPerBatch = 0;

        if (engine.getFuelType() == FuelType.PETROL) {
            costPerBatch = 9;
        } else if (engine.getFuelType() == FuelType.DIESEL) {
            costPerBatch = 12;
        } else if (engine.getFuelType() == FuelType.WOOD) {
            costPerBatch = 4.35F;
        } else if (engine.getFuelType() == FuelType.COAL) {
            costPerBatch = 5.65F;
        }

        while (batch < quantity) {
            batch = batch + engine.getBatchSize();
            batchCount++;
        }

        return new BigDecimal(batchCount).multiply(new BigDecimal(costPerBatch));
    }


}
