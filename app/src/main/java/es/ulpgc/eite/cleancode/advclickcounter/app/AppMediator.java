package es.ulpgc.eite.cleancode.advclickcounter.app;

import es.ulpgc.eite.cleancode.advclickcounter.clicks.ClickListState;
import es.ulpgc.eite.cleancode.advclickcounter.counters.CounterListState;

public class AppMediator  {

  private static AppMediator instance;

  private CounterListState counterListState;
  private ClickListState clickListState;
  private ClickToCounterState clickToCounterState;
  private CounterToClickState counterToClickState;


  private AppMediator() {
    counterListState = new CounterListState();
    clickListState = new ClickListState();

  }

  public static AppMediator getInstance() {
    if(instance == null){
      instance = new AppMediator();
    }

    return instance;
  }

  public static void resetInstance() {
    instance=null;
  }

  public CounterListState getCounterListState() {
    return counterListState;
  }

  public ClickListState getClickListState() {
    return clickListState;
  }

  public void setNextCounterScreenState(CounterToClickState state) {
    this.counterToClickState = state;
  }

  public ClickToCounterState getNextCounterScreenState() {
    return clickToCounterState;
  }


  public void setPreviousClickScreenState(ClickToCounterState state) {
    this.clickToCounterState = state;
  }

  public CounterToClickState getPreviousClickScreenState() {
    return this.counterToClickState;
  }
}
