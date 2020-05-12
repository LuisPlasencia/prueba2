package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;
import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;

public class ClickListPresenter implements ClickListContract.Presenter {

  public static String TAG = ClickListPresenter.class.getSimpleName();

  private WeakReference<ClickListContract.View> view;
  private ClickListState state;
  private ClickListContract.Model model;
  private ClickListContract.Router router;

  public ClickListPresenter(ClickListState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new ClickListState();
    }

    // use passed state if is necessary
    CounterToClickState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.clicks);
    }
  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // update the model if is necessary
    model.onRestartScreen(state.clicks);
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    /*
    // use passed state if is necessary
    ClickListState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromNextScreen(savedState.data);
    }
    */

    // call the model and update the state
    state.clicks = model.getStoredData();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
    state.datasource = new ArrayList<>();
    ClickToCounterState clickToCounterState = new ClickToCounterState();
    clickToCounterState.clicks = state.clicks;
    router.passStateToPreviousScreen(clickToCounterState);

  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onClickButtonPressed() {
    ClickData clickData = new ClickData();
    state.datasource.add(clickData);
    view.get().onDataUpdated(state);
  }

  @Override
  public void onDataClicked(ClickData data) {
    state.clicks ++;
    Log.d("Hola", String.valueOf(state.clicks));
    view.get().onDataUpdated(state);

  }

  @Override
  public void injectView(WeakReference<ClickListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ClickListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ClickListContract.Router router) {
    this.router = router;
  }
}
