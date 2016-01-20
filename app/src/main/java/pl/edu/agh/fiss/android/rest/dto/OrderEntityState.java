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

    public int position(){
        switch (this){
            case NEW:
                return 0;
            case CONFIRMED:
                return 1;
            case REDY:
                return 2;
            case CLOSED:
                return 3;
        }
        return 0;
    }

    public String toString() {
        return this.name;
    }
}
