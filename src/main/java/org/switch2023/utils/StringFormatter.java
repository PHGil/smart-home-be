package org.switch2023.utils;

import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.message.ParameterizedMessage;

/**
 * Utility class that provides a set of methods to format messages.
 */
@UtilityClass
public class StringFormatter {
    /**
     * Formats a message with the given parameters.
     *
     * @param message the message to format
     * @param params  the parameters to replace in the message
     * @return the formatted message
     */
    public static String format(final String message, final Object... params) {
        return new ParameterizedMessage(message, params).getFormattedMessage();
    }
}
