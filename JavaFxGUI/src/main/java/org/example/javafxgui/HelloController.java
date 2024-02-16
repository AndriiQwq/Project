/**
 * Sample Skeleton for 'hello-view.fxml' Controller Class
 */

package org.example.javafxgui;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class HelloController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="answer"
    private Button answer; // Value injected by FXMLLoader

    @FXML // fx:id="answers"
    private ToggleGroup answers; // Value injected by FXMLLoader

    @FXML // fx:id="exit"
    private Button exit; // Value injected by FXMLLoader

    @FXML // fx:id="questions_text"
    private Text questions_text; // Value injected by FXMLLoader

    @FXML // fx:id="radio_button1"
    private RadioButton radio_button1; // Value injected by FXMLLoader

    @FXML // fx:id="radio_button2"
    private RadioButton radio_button2; // Value injected by FXMLLoader

    @FXML // fx:id="radio_button3"
    private RadioButton radio_button3; // Value injected by FXMLLoader

    @FXML // fx:id="radio_button4"
    private RadioButton radio_button4; // Value injected by FXMLLoader

    private final Questions[] questions = new Questions[]{
            new Questions("В каком из вариантов представлен корректный формат вывода информации на экран?", new String[] {"Console.Write()", "console.log()", "print()", "System.out.println()"}),
            new Questions("Какой тип данных отвечает за целые числа?", new String[] {"String", "Float", "Boolean", "Integer"}),
            new Questions("Где правильно присвоено новое значение к многомерному массиву?", new String[] {"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
            new Questions("Какой метод позволяет запустить программу на Java?", new String[] {"Основного метода нет", "С класса, что был написан первым и с методов что есть внутри него", "Любой, его можно задавать в настройках проекта", "С метода main в любом из классов"}),
            new Questions("Каждый файл должен называется...", new String[] {"по имени первой библиотеки в нём", "по имени названия пакета", "как вам захочется", "по имени класса в нём"}),
            new Questions("Сколько параметров может принимать функция?", new String[] {"5", "10", "20", "неограниче"})
    };

    private int nowQuestion = 0, correctAnswers;
    //private boolean start_point = true;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert answer != null : "fx:id=\"answer\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert answers != null : "fx:id=\"answers\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert questions_text != null : "fx:id=\"questions_text\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert radio_button1 != null : "fx:id=\"radio_button1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert radio_button2 != null : "fx:id=\"radio_button2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert radio_button3 != null : "fx:id=\"radio_button3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert radio_button4 != null : "fx:id=\"radio_button4\" was not injected: check your FXML file 'hello-view.fxml'.";

        answer.setOnAction(event -> {
            //click on button
            RadioButton selectedRadio = (RadioButton) answers.getSelectedToggle();
            if (selectedRadio != null){
                String toggleGroupValue = selectedRadio.getText();

                //if (!start_point) {

                    if (toggleGroupValue.equals(questions[nowQuestion].correctAnswer())) {
                        System.out.println("Correct answer");
                        correctAnswers++;
                    } else {
                        System.out.println("Wrong answer");
                    }
                //}

                if(nowQuestion + 1 != questions.length) {
                    nowQuestion++;

                    questions_text.setText(questions[nowQuestion].getQuestion());
                    String[] answers = questions[nowQuestion].getAnswers();

                    List<String> stringList = Arrays.asList(answers);
                    Collections.shuffle(stringList);

                    radio_button1.setText(stringList.get(0));
                    radio_button2.setText(stringList.get(1));
                    radio_button3.setText(stringList.get(2));
                    radio_button4.setText(stringList.get(3));

                    selectedRadio.setSelected(false);
                    //start_point = false;
                } else {
                    radio_button1.setVisible(false);
                    radio_button2.setVisible(false);
                    radio_button3.setVisible(false);
                    radio_button4.setVisible(false);

                    answer.setVisible(false);

                    questions_text.setText("Correct answers: " + correctAnswers);
                    //start_point = false;
                }
            }
        });
    }

}