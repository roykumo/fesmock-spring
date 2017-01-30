package com.btpn.fesmock;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(

{ AppTest.class, com.btpn.fesmock.rest.TestSuite.class })
public class TestSuite { // nothing
}
