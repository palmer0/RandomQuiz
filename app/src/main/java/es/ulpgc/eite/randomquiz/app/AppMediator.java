package es.ulpgc.eite.randomquiz.app;


import es.ulpgc.eite.randomquiz.cheat.CheatState;
import es.ulpgc.eite.randomquiz.question.QuestionState;

public class AppMediator {

  private QuestionState questionState;
  private CheatState cheatState;
  private CheatToQuestionState cheatToQuestionState;
  private QuestionToCheatState questionToCheatState;

  private static AppMediator INSTANCE;

  private AppMediator() {
    questionState = new QuestionState();
    cheatState = new CheatState();
  }

  public static void resetInstance() {
    INSTANCE = null;
  }


  public static AppMediator getInstance() {
    if(INSTANCE == null){
      INSTANCE = new AppMediator();
    }

    return INSTANCE;
  }

  public void resetCheatState() {
    cheatState = new CheatState();
  }

  public CheatState getCheatState() {
    return cheatState;
  }

  public QuestionState getQuestionState() {
    return questionState;
  }

  public CheatToQuestionState getCheatToQuestionState() {
    CheatToQuestionState state = cheatToQuestionState;
    cheatToQuestionState = null;
    return state;
  }

  public void setCheatToQuestionState(CheatToQuestionState state) {
    this.cheatToQuestionState = state;
  }

  public QuestionToCheatState getQuestionToCheatState() {
    QuestionToCheatState state = questionToCheatState;
    questionToCheatState = null;
    return state;
  }

  public void setQuestionToCheatState(QuestionToCheatState state) {
    this.questionToCheatState = state;
  }

}
