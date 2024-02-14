

public class Main {

    public static void main(String[] args) {
        //but
        Transport transport = new Truck(950, new byte[]{7, -2, 0});
        //

            Truck truck = new Truck(850, new byte[]{97, 34, -66});
            truck.setValues(200f, 1200f, "Green", new byte[]{-12, 0, 8}, true);
            System.out.println(truck.getValues());
            truck.engine.setValues(true, 500000);
            truck.engine.info();


            Car bmw = new Car(200f, 1200f, "Green", new byte[]{-12, 46, -17});
            bmw.engine.setValues(false, 300000);
            bmw.engine.info();



            Car flyCar = new Car(200f, 1200f, "Green", new byte[]{-12, 46, -17}){
                //novy funkcional
                @Override
                public void moveObject(float speed){
                    super.moveObject(speed);

                    this.engine.isReady(true);
                    System.out.println("Car is fling");
                }
            };


            flyCar.moveObject(450);









    }


}
