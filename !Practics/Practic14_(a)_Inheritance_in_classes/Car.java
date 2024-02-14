public class Car extends Transport{

    public Car(float speed, float weight, String color, byte[] coordinate){

//            System.out.println("Object created");
//            setValues(speed,  weight,  color, coordinate);
//            System.out.println(getValues());

        super(speed, weight, color, coordinate);

        // Transport -> public String color;
        // this.color = "RED";

        //or
        //super.color = "BLUE";

        this.setValues(speed, weight, color, coordinate);
        super.setValues(speed, weight, color, coordinate);

    }



}
