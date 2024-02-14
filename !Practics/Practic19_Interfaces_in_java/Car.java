public class Car extends Transport implements ILights{

    private boolean isON;
    public Engine engine = new Engine();
    public Car(float speed, float weight, String color, byte[] coordinate){

        super(speed, weight, color, coordinate);

        this.setValues(speed, weight, color, coordinate);
        super.setValues(speed, weight, color, coordinate);

    }

    public Car() {
        super();

    }

    @Override
    public void moveObject(float speed) {

    }


    @Override
    public void setLight(boolean set) {
        this.isON = set;
    }

    @Override
    public void blinkLight() {
        System.out.println("we blink");
    }
}
