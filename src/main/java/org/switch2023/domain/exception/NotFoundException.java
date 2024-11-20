package org.switch2023.domain.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.switch2023.utils.StringFormatter;

/**
 * Exception thrown when an object is not found.
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ToString
@JsonIgnoreProperties({"cause", "stackTrace", "localizedMessage", "suppressed"})
public class NotFoundException extends Exception {
    /**
     * The class name that was expected to be updated.
     */
    private String type;
    /**
     * The id of the object.
     */
    private long id;

    /**
     * Creates a new exception when an object is not found.
     *
     * @param type the class of the object that was expected to be updated
     * @param id   the id of the object
     */
    public NotFoundException(final Class<?> type, final long id) {
        super(StringFormatter.format("The object '{}' with id '{}' doesn't exist.", type.getSimpleName(), id));
        this.id = id;
        this.type = type.getSimpleName();
    }
}
