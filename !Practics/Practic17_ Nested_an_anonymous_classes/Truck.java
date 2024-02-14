public class Truck extends Transport{


    //public Engine engine = new Engine(true, 500000);
    public Engine engine = new Engine();
    private boolean isLoaded;
    public Truck(int weight, byte[] coordinate){
        super(weight, coordinate);
    }

    @Override
    public void moveObject(float speed) {
        System.out.println("object`s speed: " + speed);
    }

    public Truck(int weight, byte[] coordinate, boolean isLoaded){

        super(weight, coordinate);
        this.isLoaded = isLoaded;

    }

    @Override
    protected String getValues(){
        System.out.println(super.getValues());
        return getLoaded();
    }


    protected void setValues(float speed, float weight, String color, byte[] coordinate, boolean isLoaded){
        super.setValues(speed, weight, color, coordinate);
        //System.out.println("наш второй метод ");
        this.isLoaded = isLoaded;
    }

    public void setLoaded(boolean loaded){

        isLoaded = loaded;

    }
    public String getLoaded(){

        if(isLoaded)
            return ("truck was");
        else
            return ("fff");
    }

}