import java.util.Arrays;

public abstract class Transport {
    // abstract class - клас без возможности создания обектов в самом класе, но не в класах наследниках

    private float speed, weight;
    //public String color;
    private String color; // protected - видны только в самом класе и класах наследниках
    private byte[] coordinate;

    public Transport(float speed, float weight, String color, byte[] coordinate){
        System.out.println("Object created");
        setValues(speed,  weight,  color, coordinate);
        //System.out.println(getValues());
    }

    public Transport(int weight, byte[] coordinate){
        this.weight = weight;
        this.coordinate = coordinate;
        //System.out.println(getValues());
    }
    // protected - видны только в самом класе и класах наследниках


    public abstract void moveObject(float speed);






    protected void setValues(float speed, float weight, String color, byte[] coordinate){
        this.speed = speed;
        this.weight = weight;
        this.color = color;
        this.coordinate = coordinate;
    }
    // protected - видны только в самом класе и класах наследниках
    protected String getValues(){
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