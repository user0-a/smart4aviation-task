package smart4aviation.task.model.responses;

import java.util.Objects;

public class Response {
    private final boolean isFailed;
    private final String reason;

    public Response(boolean isFailed, String reason) {
        this.isFailed = isFailed;
        this.reason = reason;
    }

    public boolean isFailed() {
        return isFailed;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return isFailed == response.isFailed && Objects.equals(reason, response.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFailed, reason);
    }

    @Override
    public String toString() {
        return "Response{" +
                "isFailed=" + isFailed +
                ", reason=" + reason +
                '}';
    }
}
