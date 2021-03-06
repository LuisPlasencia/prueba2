package es.ulpgc.eite.cleancode.advclickcounter.counters;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.advclickcounter.R;
import es.ulpgc.eite.cleancode.advclickcounter.app.AppMediator;

public class CounterListScreen {

  public static void configure(CounterListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    int clicks = 0;

    AppMediator mediator = AppMediator.getInstance();
    CounterListState state = mediator.getCounterListState();

    CounterListContract.Router router = new CounterListRouter(mediator);
    CounterListContract.Presenter presenter = new CounterListPresenter(state);
    CounterListContract.Model model = new CounterListModel(clicks);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
