

public class Main {

    public Main(){} // default constructor of the class. We don't have to write this code.

    public static void main(String[] args) {

            Transport BMW = new Transport(700f,300f ,"RED", new byte[]{100, 32, -53});

            Transport Truck = new Transport(1000f, 140f, "BLUE", new byte[]{-40, -2, 0});

            Transport car = new Transport( 650, new byte[]{-40, -2, 0});

            Car bmv = new Car(200f, 1200f, "Green", new byte[]{-12, 0, 8});

            Truck truck = new Truck(850, new byte[]{97, 34, -66});

            Truck new_truck = new Truck(850, new byte[]{97, 34, -66}, false);

            new_truck.setLoaded(true);
            new_truck.getLoaded();

    }


}
