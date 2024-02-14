import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args){

        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        Transport BMW = new Transport();
        BMW.weight = 700f;
        BMW.coordinate = new byte[]{100, 32, -53};
        BMW.speed = 300f;
        BMW.color = "RED";

        Transport Truck = new Transport();
        Truck.weight = 1000f;
        Truck.coordinate = new byte[]{-40, -2, 0};
        Truck.speed = 140f;
        Truck.color = "BLUE";

        System.out.println("BMW speed: " + BMW.speed);
        System.out.println("Truck speed: " + Truck.speed);

        University_student first_student = new University_student();
        first_student.existencia = true;
        first_student.first_name = "vini";
        first_student.second_name = "help";
        first_student.weight = 70f;
        first_student.marks = new String[]{"A", "B", "C", "D", "E"};
        first_student.arrayList = new ArrayList<>(){};
        first_student.arrayList.add("item1");first_student.arrayList.add("item2");first_student.arrayList.add("item3");
        // Выводим содержимое списка
        System.out.println("Items in the ArrayList:");
        for (String item : first_student.arrayList) {
            System.out.println(item);
        }
        System.out.println((first_student.existencia));
        System.out.println((Arrays.toString(first_student.marks)));

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//

        University_student student = new University_student();
        student.existencia = true;
        student.first_name = "John";
        student.second_name = "Doe";
        student.weight = 70.0f;
        student.marks = new String[]{"A", "B", "C"};

        BMW.setFirst_student(student);

        // Получаем объект student из объекта transport и выводим его атрибуты на экран
        University_student retrievedStudent = BMW.getFirst_student();
        System.out.println("\nStudent Details:");
        System.out.println("Existence: " + retrievedStudent.existencia);
        System.out.println("First Name: " + retrievedStudent.first_name);
        System.out.println("Second Name: " + retrievedStudent.second_name);
        System.out.println("Weight: " + retrievedStudent.weight);
        System.out.println("Marks: ");
        for (String mark : retrievedStudent.marks) {
            System.out.println(mark);
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//


        Transport transport = new Transport();
        transport.setValues(300, 544, "Green", new byte[]{2, -4, 97});
        String result = transport.getValues();
        System.out.println(result);
    }

}
