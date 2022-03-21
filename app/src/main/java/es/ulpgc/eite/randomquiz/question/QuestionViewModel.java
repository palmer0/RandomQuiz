package es.ulpgc.eite.randomquiz.question;

public class QuestionViewModel {

  public String questionText;
  public String resultText = "";

  public boolean falseButton = true;
  public boolean trueButton = true;
  public boolean cheatButton = true;
  public boolean nextButton = false;

  public String[] quizQuestions;
  public boolean[] quizAnswers;
}

