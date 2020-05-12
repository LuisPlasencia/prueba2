package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class CounterListViewModel {

  // put the view state here
  public int clicks;
  public List<CounterData> datasource = new ArrayList<>();
}
