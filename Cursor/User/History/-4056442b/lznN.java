import java.time.LocalDate;

public class Complaint {
    private String description;
    private String status;
    private LocalDate date;

    public Complaint(String description) {
        this.description = description;
        this.status = "Pending";
        this.date = LocalDate.now();
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date.toString();
    }

    @Override
    public String toString() {
        return "Complaint: " + description + " (Status: " + status + ", Date: " + date + ")";
    }
}