public class Chess_players {

    //variable
    private boolean MGM, GM, MM, FM, C;
    private boolean WMGM, WGM, WMM, WFM, WC;

    private int old;

    private String active;

    //constructors
    public Chess_players(boolean GM, boolean WGM, int old, String active){
        setValues(GM, WGM, old, active);
        getValues();
    }

    public Chess_players(boolean WGM, int old, String active){
        setValues(false, WGM, old, active);
        getValues();
    }


    protected void setValues(boolean GM, boolean WGM, int old, String active){
        this.WGM = WGM;
        this.GM = GM;
        this.old = old;
        this.active = active;
    }
    protected String getValues(){
        String res_valueOf_boolean_GM = String.valueOf(GM);
        String res_valueOf_boolean_WGM = String.valueOf(WGM);
        return res_valueOf_boolean_GM + res_valueOf_boolean_WGM + old + active;
    }


}
