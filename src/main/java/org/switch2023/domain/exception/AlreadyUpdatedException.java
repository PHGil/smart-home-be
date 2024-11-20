package org.switch2023.domain.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.switch2023.utils.StringFormatter;

/**
 * Exception thrown when the change version of an object is not the expected one.
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ToString
@JsonIgnoreProperties({"cause", "stackTrace", "localizedMessage", "suppressed"})
public class AlreadyUpdatedException extends Exception {
    /**
     * The class name that was expected to be updated.
     */
    private final String type;
    /**
     * The change version that was expected.
     */
    private final long changeVersion;

    /**
     * Creates a new exception with the expected change version.
     *
     * @param type          the class of the object that was expected to be updated
     * @param changeVersion the expected change version
     */
    public AlreadyUpdatedException(final Class<?> type, final long changeVersion) {
        super(StringFormatter.format(
                "The object '{}' expects a newer change version instead of '{}'.",
                type.getSimpleName(), changeVersion
        ));
        this.changeVersion = changeVersion;
        this.type = type.getSimpleName();
    }
}
