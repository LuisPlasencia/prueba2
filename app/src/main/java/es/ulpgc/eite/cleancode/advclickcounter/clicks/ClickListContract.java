package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;
import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;

public interface ClickListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(ClickListViewModel viewModel);
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

    void onClickButtonPressed();

      void onDataClicked(ClickData data);
  }

  interface Model {
    int getStoredData();

    void onDataFromNextScreen(int data);

    void onRestartScreen(int data);

    void onDataFromPreviousScreen(int data);
  }

  interface Router {
    //void navigateToNextScreen();

    //void passStateToNextScreen(ClickListState state);

    CounterToClickState getStateFromPreviousScreen();

    //ClickListState getStateFromNextScreen();

    void passStateToPreviousScreen(ClickToCounterState state);
  }
}
