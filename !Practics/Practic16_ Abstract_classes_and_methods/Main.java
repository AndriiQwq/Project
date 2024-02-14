

public class Main {

    public Main(){} // default constructor of the class. We don't have to write this code.

    public static void main(String[] args) {
        //but
        Transport transport = new Truck(950, new byte[]{7, -2, 0});
        //

            Truck truck = new Truck(850, new byte[]{97, 34, -66});
            truck.setValues(200f, 1200f, "Green", new byte[]{-12, 0, 8}, true);
            System.out.println(truck.getValues());
    }


}
