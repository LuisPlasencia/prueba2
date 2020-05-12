package es.ulpgc.eite.cleancode.advclickcounter.counters;

import es.ulpgc.eite.cleancode.advclickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;

public class CounterListRouter implements CounterListContract.Router {

  public static String TAG = CounterListRouter.class.getSimpleName();

  private AppMediator mediator;

  public CounterListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }


  @Override
  public void passStateToNextScreen(CounterToClickState state) {
    mediator.setNextCounterScreenState(state);
  }

  /*
  @Override
  public void passStateToPreviousScreen(CounterListState state) {
    mediator.setPreviousCounterScreenState(state);
  }

  @Override
  public CounterListState getStateFromPreviousScreen() {
    return mediator.getPreviousCounterScreenState();
  }
  */

  @Override
  public ClickToCounterState getStateFromNextScreen() {
    return mediator.getNextCounterScreenState();
  }
}
