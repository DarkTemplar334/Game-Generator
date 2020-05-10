package gr.ict.ihu.Model;



public class Result {

    private Status status;
    private String progressMessage;

    public Result(Status status, String s) {
        this.status = status;
        this.progressMessage = s;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getProgressMessage() {
        return progressMessage;
    }
}
