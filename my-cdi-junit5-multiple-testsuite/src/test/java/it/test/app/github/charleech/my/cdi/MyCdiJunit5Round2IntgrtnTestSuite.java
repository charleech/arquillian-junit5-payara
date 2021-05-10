package it.test.app.github.charleech.my.cdi;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * <p>
 * This is a concrete implementing class which provides the features as a test
 * suite for testing the simple CDI.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 */
@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectClasses({
    MyCdiJunit5IntgrtnTester.class
})
@IncludeClassNamePatterns("^(Test.*|.+[.$]Test.*|.*Tests?|.*Tester)$")
public class MyCdiJunit5Round2IntgrtnTestSuite {

}
