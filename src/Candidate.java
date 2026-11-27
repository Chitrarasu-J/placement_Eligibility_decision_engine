// candidate model class

public class Candidate {

    private String name;
    private double percentage;
    private int backlogs;
    private int graduationYear;
    private String[] skills;

    // constructor
    public Candidate(
            String name,
            double percentage,
            int backlogs,
            int graduationYear,
            String[] skills
    ) {
        this.name = name;
        this.percentage = percentage;
        this.backlogs = backlogs;
        this.graduationYear = graduationYear;
        this.skills = skills;
    }

    // getter methods
    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    // Creating a method for checking a skill is present in the candidate skill or not
    public boolean hasSkill(String requiredSkill) {
        for (int i = 0; i < skills.length; i++) {
            if (skills[i].equalsIgnoreCase(requiredSkill)) {
                return true;
            }
        }
        return false;
    }
}
