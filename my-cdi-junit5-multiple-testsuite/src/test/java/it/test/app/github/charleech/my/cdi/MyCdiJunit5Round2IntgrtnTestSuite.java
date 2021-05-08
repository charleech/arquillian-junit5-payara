package it.test.app.github.charleech.my.cdi;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

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
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectClasses({
    MyCdiJunit5IntgrtnTester.class
})
@IncludeClassNamePatterns("^(Test.*|.+[.$]Test.*|.*Tests?|.*Tester)$")
public class MyCdiJunit5Round2IntgrtnTestSuite {

}
