package it.test.app.github.charleech.my.cdi;

import javax.inject.Inject;

import org.assertj.core.api.BDDAssertions;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import app.github.charleech.my.cdi.Greetable;

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
@ExtendWith(ArquillianExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class MyCdiJunit5Round2IntgrtnTester {

    /**
     * This is a constant which represents the testing parameter.
     *
     * @since 1.0.0
     */
    private static final String NAME_1 = "JUnit5_1";

    /**
     * This is a constant which represents the testing parameter.
     *
     * @since 1.0.0
     */
    private static final String NAME_2 = "JUnit5_2";

    /**
     * This is a variable which represents the {@link Greetable}.
     *
     * @since 1.0.0
     */
    @Inject
    private Greetable greeter;

    /**
     * This is a success test case when greeting.
     *
     * @since 1.0.0
     */
    @Test
    public void whenGreet1() {
        String expected = null;
        String actual   = null;
        try {

            expected = "Hello "+ MyCdiJunit5Round2IntgrtnTester.NAME_1;

            actual   = this.greeter.greet(MyCdiJunit5Round2IntgrtnTester.NAME_1);

            BDDAssertions.
                then(actual).
                as("The message must be valid.").
                isNotNull().
                isNotEmpty().
                isEqualTo(expected);

        } finally {
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
        String expected = null;
        String actual   = null;
        try {

            expected = "Hello "+ MyCdiJunit5Round2IntgrtnTester.NAME_2;

            actual   = this.greeter.greet(MyCdiJunit5Round2IntgrtnTester.NAME_2);

            BDDAssertions.
                then(actual).
                as("The message must be valid.").
                isNotNull().
                isNotEmpty().
                isEqualTo(expected);

        } finally {
            expected = null;
            actual   = null;
        }
    }

}
