package es.ulpgc.eite.randomquiz.cheat;


import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.randomquiz.R;
import es.ulpgc.eite.randomquiz.app.AppMediator;

public class CheatScreen {


  public static void configure(CheatContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();

    CheatContract.Presenter presenter = new CheatPresenter(mediator);

    CheatModel model = new CheatModel();
    model.setTrueLabel(context.get().getString(R.string.true_label));
    model.setFalseLabel(context.get().getString(R.string.false_label));

    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    view.injectPresenter(presenter);

  }

}
