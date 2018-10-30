import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        Sellable seat = new Seat("Leon","Gray",110,"Spain",11111.1);
        Rentable audi = new Audi("Leon","Gray",110,"Spain",3,99.9);

        printCarInfo(seat);
        printCarInfo(audi);

        }
        private static void printCarInfo(Car car){
            System.out.println(String.format(
                    "%s is %s color and have %s horse power",
                    car.getModel(),car.getColor(),car.getHorsePower()
            ));
            System.out.println(car);
        }
}
