package es.ulpgc.eite.cleancode.advclickcounter.counters;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;
import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;
import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class CounterListPresenter implements CounterListContract.Presenter {

  public static String TAG = CounterListPresenter.class.getSimpleName();

  private WeakReference<CounterListContract.View> view;
  private CounterListState state;
  private CounterListContract.Model model;
  private CounterListContract.Router router;

  public CounterListPresenter(CounterListState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new CounterListState();
    }

    /*
    // use passed state if is necessary
    CounterListState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.data);
    }
    */
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

    // use passed state if is necessary
    ClickToCounterState savedState = router.getStateFromNextScreen();

    if (savedState != null) {
      Log.d("HOLA", String.valueOf(savedState.clicks));
      // update the model if is necessary
      model.onDataFromNextScreen(savedState.clicks);
    }

    // call the model and update the state
    state.clicks = model.getStoredData();

    int celdaActual = state.celdaActual;
    if(state.datasource.size() > 0){
      Log.d("hola", String.valueOf(state.clicks));
      state.datasource.get(celdaActual).value = state.clicks;
    }



    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
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
  public void onCounterButtonPressed() {
    CounterData counterData = new CounterData();
    ClickData clickData = new ClickData();
    counterData.clicks.add(clickData);
    state.datasource.add(counterData);
    view.get().onDataUpdated(state);
  }

  @Override
  public void onDataClicked(CounterData counter) {
    for(int i = 0; i< state.datasource.size(); i++){
      if(counter.value == state.datasource.get(i).value){
        state.celdaActual = i;
      }
    }

    state.clicks = counter.value;
    CounterToClickState estado = new CounterToClickState();
    estado.clicks = counter.value;
    router.passStateToNextScreen(estado);

    view.get().navigateToNextScreen();
  }

  @Override
  public void injectView(WeakReference<CounterListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CounterListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CounterListContract.Router router) {
    this.router = router;
  }
}
