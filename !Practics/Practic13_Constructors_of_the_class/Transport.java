import java.util.Arrays;

public class Transport {
    private float speed, weight;
    private String color;
    private byte[] coordinate;


    //public Transport(){} // default constructor of the class

    /*
    public Transport(){
        //join to DB
        System.out.println("Object created"); // when the object is created, a message will be displayed
    }
    */

    public Transport(float speed, float weight, String color, byte[] coordinate){
        System.out.println("Object created");
        /*
        this.speed = speed;
        this.weight = weight;
        this.color = color;
        this.coordinate = coordinate;
         */
        setValues(speed,  weight,  color, coordinate);
        System.out.println(getValues());
    }

    public Transport(float speed, int weight, String color, byte[] coordinate){}


    public Transport(int weight, byte[] coordinate){
        this.weight = weight;
        this.coordinate = coordinate;
        System.out.println(getValues());
    }



    public void setValues(float speed, float weight, String color, byte[] coordinate){
        this.speed = speed;
        this.weight = weight;
        this.color = color;
        this.coordinate = coordinate;
    }
    public String getValues(){
        String info = "OBJECT:\nSpeed: " + this.speed + "\nWeight: " + this.weight + "\nColor" + this.color + "\nCoordinate" + Arrays.toString(coordinate);
        String infoCoordinate = "\nCoordinate: ";
        for (int i = 0; i < this.coordinate.length; i++){
            infoCoordinate += this.coordinate[i];
            if (i < this.coordinate.length - 1)
                infoCoordinate += "; ";
            else
                infoCoordinate += ".";
        }
        return info + infoCoordinate ;
    }


}