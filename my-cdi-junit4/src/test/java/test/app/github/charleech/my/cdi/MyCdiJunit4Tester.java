package test.app.github.charleech.my.cdi;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

import app.github.charleech.my.cdi.Greetable;
import app.github.charleech.my.cdi.Greeter;

/**
 * <p>
 * This is a concrete implementing class which provides the feature to test the
 * simple CDI.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 */
public class MyCdiJunit4Tester {

    /**
     * This is a constant which represents the testing parameter.
     *
     * @since 1.0.0
     */
    private static final String NAME_1 = "JUnit4_1";

    /**
     * This is a constant which represents the testing parameter.
     *
     * @since 1.0.0
     */
    private static final String NAME_2 = "JUnit4_2";

    /**
     * This is a success test case when greeting.
     *
     * @since 1.0.0
     */
    @Test
    public void whenGreet1() {
        Greetable greeter  = null;
        String    expected = null;
        String    actual   = null;
        try {
            greeter  = new Greeter();
            expected = "Hello "+ MyCdiJunit4Tester.NAME_1;

            actual   = greeter.greet(MyCdiJunit4Tester.NAME_1);

            BDDAssertions.
                then(actual).
                as("The message must be valid.").
                isNotNull().
                isNotEmpty().
                isEqualTo(expected);

        } finally {
            greeter  = null;
            expected = null;
            actual   = null;
        }
    }

    /**
     * This is a success test case when greeting.
     *
     * @since 1.0.0
     */
    @Test
    public void whenGreet2() {
        Greetable greeter  = null;
        String    expected = null;
        String    actual   = null;
        try {
            greeter  = new Greeter();
            expected = "Hello "+ MyCdiJunit4Tester.NAME_2;

            actual   = greeter.greet(MyCdiJunit4Tester.NAME_2);

            BDDAssertions.
                then(actual).
                as("The message must be valid.").
                isNotNull().
                isNotEmpty().
                isEqualTo(expected);

        } finally {
            greeter  = null;
            expected = null;
            actual   = null;
        }
    }

}
