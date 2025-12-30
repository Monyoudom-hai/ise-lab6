/**
 * Subject class represents an academic subject with name, credits, and hours.
 * 
 * @author Rith Chankolboth
 * @version 1.0
 */
class SubjectData {
    private String name;
    private int totalCredits;
    private int totalHours;

    private int presentCount;
    private int lateCount;
    private int absentCount;

    // Existing Getters/Setters
    public String getName() {
         return name; 
        }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be null or empty");
        }
         this.name = name; 
        }

    public int getTotalCredits() {
         return totalCredits; 
        }
    public void setTotalCredits(int totalCredits) { 
        this.totalCredits = totalCredits; 
    }

    public int getTotalHours() {
         return totalHours; 
        }
    public void setTotalHours(int totalHours) {
         this.totalHours = totalHours; 
        }

    public int getPresentCount() {
         return presentCount; 
        }
    public void setPresentCount(int presentCount) {
         this.presentCount = presentCount; 
        }

    public int getLateCount() {
         return lateCount; 
        }
    public void setLateCount(int lateCount) 
    { this.lateCount = lateCount; 

    }

    public int getAbsentCount() {
         return absentCount; 
        }
    public void setAbsentCount(int absentCount) {
         this.absentCount = absentCount; 
        }
    /**
     * Calculates the score out of 100 based on attendance.
     * Formula: ((Present + (Late * 0.5)) / Total Sessions) * 100
     */
    public double calculateAttendanceScore() {
        int totalSessions = presentCount + lateCount + absentCount;
        
        // Prevent division by zero if no attendance is recorded yet
        if (totalSessions == 0) return 0.0;

        double score = (presentCount + (lateCount * 0.5)) / totalSessions;
        return score * 100;
    }

    @Override
    public String toString() {
        return String.format(
            "Subject: %s\nCredits: %d\nHours: %d\nAttendance Score: %.2f%% (P: %d, L: %d, A: %d)",
            name, totalCredits, totalHours, calculateAttendanceScore(), 
            presentCount, lateCount, absentCount
        );
    }
}

public class Subject {
    public static void main(String[] args) {
           // Test 1: Valid subject
        System.out.println("=== Test 1: Valid Subject ===");
        SubjectData x = new SubjectData();
        x.setName("Introduction to SE");
        x.setTotalCredits(3);
        x.setTotalHours(45);
        x.setPresentCount(10);
        x.setLateCount(2);
        x.setAbsentCount(1);
        System.out.println(x);
        
        // Test 2: Null name
        System.out.println("\n=== Test 2: Null Name ===");
        try {
            SubjectData y = new SubjectData();
            y.setName(null);
            y.setTotalCredits(3);
            System.out.println(y);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // Test 3: Empty name
        System.out.println("\n=== Test 3: Empty Name ===");
        try {
            SubjectData z = new SubjectData();
            z.setName("");
            z.setTotalCredits(3);
            System.out.println(z);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // Test 4: Whitespace-only name
        System.out.println("\n=== Test 4: Whitespace-only Name ===");
        try {
            SubjectData w = new SubjectData();
            w.setName("   ");
            w.setTotalCredits(3);
            System.out.println(w);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
    }