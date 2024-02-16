package org.example.javafxgui;

public class Questions {
    private  String question;
    private String[] answers;

    public Questions(String question, String[] answers){
        this.answers = answers;
        this.question = question;
    }

    public String correctAnswer() {
        if (answers.length > 0) {
            return this.answers[answers.length - 1];
        } else {
            // Handle the case when the array is empty
            return null; // or throw an exception, return a default value, etc.
        }
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
}
