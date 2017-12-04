package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestIntegrationInitializeItems.class, TestIntegrationInitializeTowers.class, TestIntegrationInitializeWeapons.class })
public class AllTests {

}
