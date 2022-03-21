package es.ulpgc.eite.randomquiz.cheat;

import java.lang.ref.WeakReference;


public interface CheatContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayCheatData(CheatViewModel viewModel);
    void finishView();
    //String getFalseLabel();
    //String getTrueLabel();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);

    void yesButtonClicked();
    void noButtonClicked();

    //void onCreateCalled();
    void onResumeCalled();
    //void onDestroyCalled();
  }

  interface Model {

    String getFalseLabel();
    String getTrueLabel();
  }
}