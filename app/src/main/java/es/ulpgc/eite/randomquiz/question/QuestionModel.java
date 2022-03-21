package es.ulpgc.eite.randomquiz.question;

public class QuestionModel implements QuestionContract.Model {

  public static String TAG = "RandomQuiz.QuestionModel";

  private String[] questionArray = {
      "Christian Bale played Batman in 'The Dark Knight Rises'?", // 1
      "The Gremlins movie was released in 1986?",  // 2
      "Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?",  // 3
      "A spoon full of sugar' came from the 1964 movie Mary Poppins?",  // 4
      "The song “I don't want to miss a thing” featured in Armageddon?", // 5
      "Will Smith has a son called Jaden?", // 6
      "Mark Ruffalo played Teddy Daniels in Shutter Island?", // 7
      "Mike Myers starred in the 'Cat in the Hat' 2003 children's movie?", // 8
      "Ryan Reynolds is married to Scarlett Johansson?", // 9
      "The movie 'White House Down' was released in 2014?",  // 10
      "Michael Douglas starred in Basic Instinct, Falling Down and The Game?", // 11
      "Colin Firth won an Oscar for his performance in the historical movie 'The King's Speech'?",  // 12
      "Cameron Diaz and Ashton Kutcher starred in the movie 'What happens in Vegas'?", // 13
      "Arnold Schwarzenegger played lead roles in Rocky, Rambo and Judge Dredd?", // 14
      "The Titanic movie featured the song 'My Heart Will Go On'?", // 15
      "Eddie Murphy narrates the voice of Donkey in the Shrek movies?", // 16
      "Nicole Kidman played Poison Ivy in 'Batman and Robin'?", // 17
      "The Lara Croft: Tomb Raider movie was released in 2003?", // 18
      "Hallie Berry played the character Rogue in X Men?", // 19
      "The Teenage Mutant Ninja Turtles are named after famous artists?" // 20
  };

  private boolean[] answerArray = {
      true, // 1
      false, // 2
      false, // 3
      true, // 4
      true, // 5
      true, // 6
      false, // 7
      true, // 8
      false, // 9
      false, // 10
      true, // 11
      true, // 12
      true, // 13
      false, // 14
      true, // 15
      true, // 16
      false, // 17
      false, // 18
      false, // 19
      true // 20
  };

  private String[] quizQuestions;
  private boolean[] quizAnswers;

  private int quizIndex = 0;

  private String correctLabel, incorrectLabel;

  public QuestionModel() {
    int size = 5;
    generateQuizQuestions(size);
    generateQuizAnswers( size);
  }

  private void generateQuizQuestions(int size) {
    quizQuestions = new String[size];
    int[] indexArray = generateIndexArray(size);

    for (int i = 0; i < size; i++) {
      int index = indexArray[i];
      quizQuestions[i] = questionArray[index];
    }

  }

  private void generateQuizAnswers(int size) {
    quizAnswers = new boolean[size];
    int[] indexArray = generateIndexArray(size);

    for (int i = 0; i < size; i++) {
      int index = indexArray[i];
      quizAnswers[i] = answerArray[index];
    }

  }

  // Valor entre M y N, ambos incluidos: Math.floor(Math.random()*(N-M+1)+M);
  private int[] generateIndexArray(int size) {
    int[] indexArray = new int[size];

    for (int i = 0; i < size; i++) {
      indexArray[i] = (int)(Math.random()*20); // generates numbers from [0,19]

      for (int j = 0; j < i; j++) {
        if (indexArray[i] == indexArray[j]) {
          i--; // if a[i] is a duplicate of a[j], then run outer loop on i again
          break;
        }
      }
    }

    return indexArray;
  }


  @Override
  public String[] getQuizQuestions() {
    return quizQuestions;
  }

  @Override
  public boolean[] getQuizAnswers() {
    return quizAnswers;
  }

  @Override
  public void setQuizAnswers(boolean[] answers) {
    quizAnswers = answers;
  }

  @Override
  public void setQuizQuestions(String[] questions) {
    quizQuestions= questions;
  }


  @Override
  public String getCurrentQuestion() {
    return quizQuestions[quizIndex];
  }

  @Override
  public boolean getCurrentAnswer() {
    return quizAnswers[quizIndex];
  }

  @Override
  public boolean isLastQuestion() {
    if(quizIndex == quizQuestions.length-1){
      return true;
    }

    return false;

  }

  @Override
  public void incrQuizIndex() {
    quizIndex++;
  }

  @Override
  public void setCurrentIndex(int index) {
    quizIndex = index;
  }

  /*
  @Override
  public String getCurrentQuestion(int quizIndex) {
    return quizQuestions[quizIndex];
  }

  @Override
  public boolean getCurrentAnswer(int quizIndex) {
    return quizAnswers[quizIndex];
  }

  @Override
  public boolean isLastQuestion(int quizIndex) {
    if(quizIndex == quizQuestions.length-1){
      return true;
    }

    return false;

  }
  */

  @Override
  public String getCorrectLabel() {
    return correctLabel;
  }

  @Override
  public String getIncorrectLabel() {
    return incorrectLabel;
  }

  public void setCorrectLabel(String label) {
    correctLabel = label;
  }

  public void setIncorrectLabel(String label) {
    incorrectLabel = label;
  }
}
