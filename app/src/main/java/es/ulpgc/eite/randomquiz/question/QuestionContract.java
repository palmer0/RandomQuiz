package es.ulpgc.eite.randomquiz.question;

import java.lang.ref.WeakReference;


public interface QuestionContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayQuestionData(QuestionViewModel viewModel);
    //String getIncorrectLabel();
    //String getCorrectLabel();
    void navigateToCheatScreen();

  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

    void onResumeCalled();
    void trueButtonClicked();
    void falseButtonClicked();
    void cheatButtonClicked();
    void nextButtonClicked();

    void onCreateWithoutStateCalled();
    void onCreateWithStateCalled();
  }

  interface Model {

    String getCorrectLabel();
    String getIncorrectLabel();

    void setQuizAnswers(boolean[] answers);

    void setQuizQuestions(String[] questions);

    String getCurrentQuestion();
    boolean getCurrentAnswer();
    boolean isLastQuestion();
    void incrQuizIndex();
    void setCurrentIndex(int index);

    /*
    String getCurrentQuestion(int quizIndex);
    boolean getCurrentAnswer(int quizIndex);
    boolean isLastQuestion(int quizIndex);
    */

    String[] getQuizQuestions();
    boolean[] getQuizAnswers();
  }

}