package es.ulpgc.eite.cleancode.advclickcounter.clicks;

public class ClickListModel implements ClickListContract.Model {

  public static String TAG = ClickListModel.class.getSimpleName();

  private int clicks;

  public ClickListModel(int data) {
    this.clicks = data;
  }

  @Override
  public int getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return clicks;
  }

  @Override
  public void onRestartScreen(int data) {
    // Log.e(TAG, "onRestartScreen()");
    this.clicks = data;
  }

  @Override
  public void onDataFromNextScreen(int data) {
    // Log.e(TAG, "onDataFromNextScreen()");
    this.clicks = data;
  }

  @Override
  public void onDataFromPreviousScreen(int data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
    this.clicks = data;
  }
}
