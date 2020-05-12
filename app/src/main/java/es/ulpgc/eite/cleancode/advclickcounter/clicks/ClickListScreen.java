package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.advclickcounter.R;
import es.ulpgc.eite.cleancode.advclickcounter.app.AppMediator;

public class ClickListScreen {

  public static void configure(ClickListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    int clicks = 0;

    AppMediator mediator = AppMediator.getInstance();
    ClickListState state = mediator.getClickListState();

    ClickListContract.Router router = new ClickListRouter(mediator);
    ClickListContract.Presenter presenter = new ClickListPresenter(state);
    ClickListContract.Model model = new ClickListModel(clicks);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
