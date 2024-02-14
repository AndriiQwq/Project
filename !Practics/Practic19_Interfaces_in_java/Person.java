public final class Person { //nemoze mat naslednicov

    private final static int count_constanta = 43;
    public static int count; // prenadlizit k clasu v celom
    private static int count2;// nemozem obratitsa v main
    public int count_without_static;

    public int WWWW_count_without_static;

    public void metod_count_without_static_plus_plus() {
        count_without_static++;
    }

    public void getCount_of_count_without_static(){
        System.out.println("Count of count_without_static: "+ count_without_static);
    }

    public void WWWW_getCount_of_count_without_static(){
        System.out.println("Count of WWWW_count_without_static: "+ WWWW_count_without_static);
    }
    public Person() {
        count++;
        WWWW_count_without_static++;
    }

    public static void getCount() {
        System.out.println("Count of count: "+ count);
        ///this.count_without_static = 45;
        // nemozem pouzit t.k. premena count_without_static nie je sttaticna
    }

    public void getCount2() {
        System.out.println("Count of count: "+ count);
    }

}
