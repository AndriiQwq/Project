import java.util.Arrays;

public class Transport  {

    /// public protected private

    public float speed, weight;
    public String color;
    public byte[] coordinate;

    //private String cute; //private - Мы не имеем доступа за пределами этого класса
    University_student first_student = new University_student();

    public void setFirst_student(University_student first_student) {
        this.first_student = first_student;
    }

    public University_student getFirst_student() {
        return first_student;
    }

    public void setValues(float speed, float weight, String color, byte[] coordinate){
        this.speed = speed;
        this.weight = weight;
        this.color = color;
        this.coordinate = coordinate;
    }

    public String getValues(){
        String info = "OBJECT:\nSpeed: " + speed + "\nWeight: " + weight + "\nColor" + color + "\nCoordinate" + Arrays.toString(coordinate);
        String infoCoordinate = "\nCoordinate: ";
        for (int i = 0; i < coordinate.length; i++){
            infoCoordinate += coordinate[i];
            if (i < coordinate.length - 1)
                infoCoordinate += "; ";
            else
                infoCoordinate += ".";
        }
        return info + infoCoordinate ;
    }


}