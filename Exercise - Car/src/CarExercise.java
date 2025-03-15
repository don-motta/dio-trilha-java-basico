import java.util.Scanner;
import com.dio.car.Drive;

public class CarExercise {

    static Scanner sc = new Scanner(System.in);

    public static void main (String [] args) {
        Drive drive = new Drive();

        int menuOption = 0;

        System.out.println("Welcome to the car's Assistant Driver!!!");

        do {
            System.out.println("""
                    Menu:
                    
                    1 - Start the car;
                    2 - Turn off the car;
                    3 - Accelerate the car;
                    4 - Break the car;
                    5 - Change the gear;
                    6 - Steering the car
                    7 - Check the car's speed;
                    8 - Exit.""");

            menuOption = sc.nextInt();

            switch (menuOption) {
                case 1:
                    drive.start();
                    break;
                case 2:
                    drive.turnOff();
                    break;
                case 3:
                    drive.accelerate();
                    break;
                case 4:
                    drive.breakCar();
                    break;
                case 5:
                    System.out.println("Enter the gear: ");
                    int gear = sc.nextInt();
                    if (gear < 0 || gear > 6) {
                        System.out.println("Invalid gear!!!");
                        break;
                    }
                    drive.changeGear(gear);
                    break;
                case 6:
                    drive.turnSteeringWheel(steeringDirection());
                    break;
                case 7:
                    System.out.println("Current speed: " + drive.car.getSpeed());
                    break;
                case 8:
                    System.out.println("Goodbye!!!");
                    break;
                default:
                    System.out.println("Invalid option!!!");
                    break;
            }
        } while (menuOption != 8);


    }

    private static String steeringDirection(){
        System.out.println("1 - Left \n2 - Right \n3 - Center");
        int direction = sc.nextInt();
        switch (direction) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "center";
            default:
                return "center";
        }
    }
}