/**
 * Created by stratos on 4/8/15.
 */
public class Tuple<T> {

    private T before;
    private T after;

    public T getAfter() {
        return after;
    }

    public void setAfter(T after) {
        this.after = after;
    }

    public T getBefore() {
        return before;
    }

    public void setBefore(T before) {
        this.before = before;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s", before, after);
    }
}
