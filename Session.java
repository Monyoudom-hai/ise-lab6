

public class Session {
    
    private int start;
    private int stop;
    private String sessionName;
    private String instructor;
    private boolean isActive;


    
    public Session(String sessionName, String instructor) {
        this.sessionName = sessionName;
        this.instructor = instructor;
        this.isActive = false;
    }

    public Session( String sessionName) {
        this.sessionName = sessionName;
        this.instructor = "BRo Nak";
        this.isActive = false;
    }

    
    public Session() {
        this.sessionName = "Unnamed Session";
        this.instructor = "Unknown";
        this.isActive = false;
    }

    
    public void setDuration(int start, int stop) {
        if (start < 0 || stop < 0 || stop < start) {
            throw new IllegalArgumentException("Invalid start or stop time");
        }
        this.start = start;
        this.stop = stop;
    }

    
    public int getDuration() {
        return stop - start;
    }


    

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public boolean isActive() {
        return isActive;
    }

    
    public void startSession() {
        this.isActive = true;
        System.out.println("Session started at: " + start + " for " + sessionName);
    }

    
    public void endSession() {
        this.isActive = false;
        System.out.println("Session ended at: " + stop + " for " + sessionName);
    }


    public void displayInfo() {
        System.out.println("Session: " + sessionName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Duration: " + getDuration() + " Hours");
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
    }

    
    public static void main(String[] args) {
        Session mySession = new Session("Java Basics", "Mr. Smith");
        mySession.setDuration(7,9 );
        mySession.displayInfo();
        mySession.startSession();
        mySession.endSession();

        Session defaultSession = new Session("Default Session");
        defaultSession.setDuration(14,12);
        defaultSession.startSession();
        defaultSession.displayInfo();

    }
}