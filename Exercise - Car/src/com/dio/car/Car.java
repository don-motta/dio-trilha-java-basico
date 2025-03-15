package com.dio.car;

public class Car {
    private boolean isRunning = false;
    private int speed = 0;
    private String steeringWheel = "center";
    private int gear = 0;
    private int gearMinSpeedLimit = 0;
    private int gearMaxSpeedLimit = 0;

    //setters

    public void setIsRunning (boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setSpeed (int speed){
        this.speed = speed;
    }

    public void setSteeringWheel(String steeringWheel){
        this.steeringWheel = steeringWheel;
    }

    public void setGear(int gear){
        this.gear = gear;
        switch (gear){
            case 0:
                setGearMinSpeedLimit(0);
                setGearMaxSpeedLimit(0);
                break;
            case 1:
                setGearMinSpeedLimit(0);
                setGearMaxSpeedLimit(20);
                break;
            case 2:
                setGearMinSpeedLimit(20);
                setGearMaxSpeedLimit(40);
                break;
            case 3:
                setGearMinSpeedLimit(40);
                setGearMaxSpeedLimit(60);
                break;
            case 4:
                setGearMinSpeedLimit(60);
                setGearMaxSpeedLimit(80);
                break;
            case 5:
                setGearMinSpeedLimit(80);
                setGearMaxSpeedLimit(100);
                break;
            case 6:
                setGearMinSpeedLimit(100);
                setGearMaxSpeedLimit(120);
                break;
            default:
                break;
        }

    }

    public void setGearMinSpeedLimit(int gearMinSpeedLimit){
        this.gearMinSpeedLimit = gearMinSpeedLimit;
    }

    public void setGearMaxSpeedLimit(int gearMaxSpeedLimit){
        this.gearMaxSpeedLimit = gearMaxSpeedLimit;
    }

    //getter

    public boolean getIsRunning(){
        return isRunning;
    }

    public int getSpeed(){
        return speed;
    }

    public String getSteeringWheel(){
        return steeringWheel;
    }

    public int getGear(){
        return gear;
    }

    public int getGearMinSpeedLimit(){
        return gearMinSpeedLimit;
    }

    public int getGearMaxSpeedLimit() {
        return gearMaxSpeedLimit;
    }

    //metods



}
