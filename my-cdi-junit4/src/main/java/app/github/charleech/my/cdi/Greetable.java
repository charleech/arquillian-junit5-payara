package app.github.charleech.my.cdi;

import java.io.Serializable;

/**
 * <p>
 * This is an interface which provides the feature for greeting.
 * It is a {@code CDI: ApplicationScoped Bean}.
 * </p>
 *
 * @author charlee.ch
 * @version 1.0.0
 * @since 1.0.0
 * @see Serializable
 */
public interface Greetable extends Serializable {

    /**
     * Say hello to the specified name.
     * @param name The name
     * @return The hello message
     * @since 0.0.1
     */
    String greet(final String name);
}
