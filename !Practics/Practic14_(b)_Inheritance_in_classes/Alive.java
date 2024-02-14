public class Alive extends Chess_players{


    //truck
    private boolean isLoaded;

    public Alive(boolean GM, boolean WGM, int old, String active){
        super(GM, WGM, old, active);
    }


    public Alive(boolean GM, boolean WGM, int old, String active, boolean isLoaded){
        super(GM, WGM, old, active);
        this.isLoaded = isLoaded;

    }



    public void setLoaded(boolean loaded){

        isLoaded = loaded;

    }


    public void getLoaded(){

        if(isLoaded)
            System.out.println("isLoaded");
        else
            System.out.println("isn'tLoaded");
    }

}
