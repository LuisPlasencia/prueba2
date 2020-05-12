package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;

public class CounterListModel implements CounterListContract.Model {

  public static String TAG = CounterListModel.class.getSimpleName();

  public int clicks;

  public CounterListModel(int data) {
    this.clicks = data;
  }

  @Override
  public int getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return clicks;
  }

  @Override
  public void onRestartScreen(int clicks) {
    // Log.e(TAG, "onRestartScreen()");
    this.clicks = clicks;
  }

  @Override
  public void onDataFromNextScreen(int clicks) {
    // Log.e(TAG, "onDataFromNextScreen()");
    this.clicks = clicks;
  }

  @Override
  public void onDataFromPreviousScreen(int clicks) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    this.clicks = clicks;
  }
}
