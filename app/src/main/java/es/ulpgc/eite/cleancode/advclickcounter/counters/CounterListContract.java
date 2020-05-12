package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;
import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;
import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public interface CounterListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(CounterListViewModel viewModel);
    void navigateToNextScreen();

  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();

    void onCounterButtonPressed();

      void onDataClicked(CounterData counter);
  }

  interface Model {
    int getStoredData();

    void onDataFromNextScreen(int clicks);

    void onRestartScreen(int clicks);

    void onDataFromPreviousScreen(int clicks);
  }

  interface Router {

    void passStateToNextScreen(CounterToClickState state);

    //CounterListState getStateFromPreviousScreen();

    ClickToCounterState getStateFromNextScreen();

    //void passStateToPreviousScreen(CounterListState state);
  }
}
