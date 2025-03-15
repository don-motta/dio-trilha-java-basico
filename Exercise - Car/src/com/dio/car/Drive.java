package com.dio.car;
import com.dio.car.Car;

public class Drive {
    public Car car = new Car();

    public void start() {
        if (car.getIsRunning()) {
            System.out.println("Car is already running.");
            return;
        }
        car.setIsRunning(true);
        System.out.println("Car is now running.");
    }

    public void turnOff() {
        if (!car.getIsRunning()){
            System.out.println("Car is already off.");
            return;
        } else if (car.getSpeed() > 0) {
            System.out.println("Car is moving. Please, stop the car first.");
            return;
        }
        car.setIsRunning(false);
        System.out.println("Car is now off.");
    }

    public void accelerate() {
        if (!car.getIsRunning()) {
            System.out.println("Car is off. Please, start the engine.");
            return;
        } else if (car.getGear() == 0) {
            System.out.println("Car is in neutral. Please, change to the first gear.");
            return;
        } else if (!(car.getSpeed() >= car.getGearMinSpeedLimit() && car.getSpeed() <= car.getGearMaxSpeedLimit())) {
            System.out.println("Current speed: " + car.getSpeed());
            System.out.println("Car is out of speed of the gear. Please, change the gear.");
            return;
        }

        while (car.getSpeed() < car.getGearMaxSpeedLimit()) {
            car.setSpeed(car.getSpeed()+1);
        }
        System.out.println("Current speed: " + car.getSpeed());
        System.out.println("Car is at max speed limit of the gear. Please, change to the next gear.");
    }

    public void breakCar() {
        if (!car.getIsRunning()) {
            System.out.println("Car is off. Please, start the engine.");
            return;
        }
        while (car.getSpeed() > 0) {
            car.setSpeed(car.getSpeed()-1);
            if (car.getSpeed() <= car.getGearMinSpeedLimit()) {
                System.out.println("Car is at min speed limit of the gear. Please, change to the previous gear.");
                return;
            }
        }
    }


    public void changeGear(int gear) {
        if (!car.getIsRunning()) {
            System.out.println("Car is off. Please, start the engine.");
            return;
        } else if (gear < car.getGear()) {
            if (car.getSpeed() == car.getGearMinSpeedLimit()) {
                car.setGear(gear);
                System.out.println("Gear changed to " + car.getGear() + " gear.");
                return;
            } else {
                System.out.println("Current Speed: " + car.getSpeed());
                System.out.println("Car is not at min speed limit of the gear. Please, break.");
                return;
            }
        } else if (gear > car.getGear()) {
            if (car.getSpeed() == car.getGearMaxSpeedLimit()) {
                car.setGear(gear);
                System.out.println("Gear changed to " + car.getGear() + " gear.");
                return;
            } else {
                System.out.println("Current Speed: " + car.getSpeed());
                System.out.println("Car is not at max speed limit of the gear. Please, accelerate.");
                return;
            }
        }
    }

    public void turnSteeringWheel(String direction) {
        if (!car.getIsRunning()) {
            System.out.println("Car is off. Please, start the engine.");
            return;
        } else if (car.getSpeed() == 0) {
            System.out.println("Car is not moving. Please, accelerate.");
            return;
        } else if (car.getSpeed() > 40) {
            System.out.println("Current Speed: " + car.getSpeed());
            System.out.println("Car is at high speed. Please, reduce speed.");
            return;
        }
        car.setSteeringWheel(direction);
        System.out.println("Steering wheel turned to " + car.getSteeringWheel());
    }
}
