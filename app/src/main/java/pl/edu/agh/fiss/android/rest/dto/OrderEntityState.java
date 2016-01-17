package pl.edu.agh.fiss.android.rest.dto;

/**
 * Created by wemstar on 2016-01-16.
 */
public enum OrderEntityState {
    NEW("NEW"),
    CONFIRMED("CONFIRMED"),
    REDY("REDY"),
    CLOSED("CLOSED");

    private final String name;

    OrderEntityState(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
