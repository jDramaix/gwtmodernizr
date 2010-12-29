package com.google.gwt.modernizr.client.tests;

import com.google.gwt.modernizr.client.Modernizr;

public class IndexedDB extends AbstractModernizrTest {

  public static final Class<IndexedDB> IndexedDB = IndexedDB.class;

  static {
    Modernizr.addTest(new IndexedDB());
  }

  @Override
  protected boolean runTest() {
    String prefix = impl.getDomVendorPrefix().toLowerCase();
    return getWindowElement().getPropertyBoolean(prefix + "_indexedDB")
        || getWindowElement().getPropertyBoolean(prefix + "IndexedDB");
  }
}
