package com.worldline.interview;

public interface Engine {
    public void start();

    public void stop();

    public boolean isRunning();

    public void fill(FuelType fuelType, int fuelLevel);

    public FuelType getFuelType();

    public int getBatchSize();
}
