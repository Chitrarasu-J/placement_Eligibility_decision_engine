// rule to check graduation year
public class GraduationYearRule extends EligibilityRule {

    @Override
    public String getRuleName() {
        return "GraduationYear";
    }

    // graduation year must match required year
    @Override
    public boolean check(Candidate candidate, Job job) {

        return (candidate.getGraduationYear() == job.getRequiredGraduationYear());
    }
}
