import db.DB;

public class Main {

    public static void info(){
        System.out.println("Some text");
    }

    public final static void info(String text){
        System.out.println("Out: " + text);
    }

    public static void info(Boolean bool){
        if (bool)
            System.out.println("Out: " + true);
        else
            System.out.println("www q_q");
    }

    public static void main(String[] args) {


        Car car = new Car();
        car.setLight(true);
        car.blinkLight(); 

        final int constanta = 44;

        DB db = new DB();

        info();
        info("fff");
        info(false);

        //Person person = new Person();
        //person.count; // пренадлежит к класу в целом, не нужно создавать обект

        Person.count = 5;

        Person obj1 = new Person();
        Person obj2 = new Person();
        Person obj3 = new Person();

        obj3.getCount2();
        Person.getCount();

        obj3.metod_count_without_static_plus_plus();
        obj3.metod_count_without_static_plus_plus();
        obj3.metod_count_without_static_plus_plus();

        obj3.getCount_of_count_without_static();
        obj3.WWWW_getCount_of_count_without_static();

//        Transport transport = new Truck(950, new byte[]{7, -2, 0});
//
//            Truck truck = new Truck(850, new byte[]{97, 34, -66});
//            truck.setValues(200f, 1200f, "Green", new byte[]{-12, 0, 8}, true);
//            System.out.println(truck.getValues());
//            truck.engine.setValues(true, 500000);
//            truck.engine.info();
//
//            Car bmw = new Car(200f, 1200f, "Green", new byte[]{-12, 46, -17});
//            bmw.engine.setValues(false, 300000);
//            bmw.engine.info();
//
//
//
//            Car flyCar = new Car(200f, 1200f, "Green", new byte[]{-12, 46, -17}){
//                @Override
//                public void moveObject(float speed){
//                    super.moveObject(speed);
//
//                    this.engine.isReady(true);
//                    System.out.println("Car is fling");
//                }
//            };
//            flyCar.moveObject(450);






    }


}
