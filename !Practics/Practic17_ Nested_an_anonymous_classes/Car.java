public class Car extends Transport{

    //public Engine engine = new Engine(false, 500000);
    public Engine engine = new Engine();
    public Car(float speed, float weight, String color, byte[] coordinate){

        super(speed, weight, color, coordinate);

        this.setValues(speed, weight, color, coordinate);
        super.setValues(speed, weight, color, coordinate);

    }

    @Override
    public void moveObject(float speed) {

    }


}
