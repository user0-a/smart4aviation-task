package smart4aviation.task.model.responses;

public class Response {
    private final boolean isFailed;

    @Override
    public String toString() {
        return "Response{" +
                "isFailed=" + isFailed +
                ", reason=" + reason +
                '}';
    }

    private final String reason;

    public boolean isFailed() {
        return isFailed;
    }

    public String getReason() {
        return reason;
    }

    public Response(boolean isFailed, String reason) {
        this.isFailed = isFailed;
        this.reason = reason;
    }
}
