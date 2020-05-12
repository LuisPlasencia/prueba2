package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;

public class ClickListViewModel {

  // put the view state here
  public int clicks;
  public List<ClickData> datasource = new ArrayList<>();
}
