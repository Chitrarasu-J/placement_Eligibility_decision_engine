// rule to check percentage criteria
public class PercentageRule extends EligibilityRule {

    @Override
    public String getRuleName() {
        return "Percentage";
    }

    // candidate percentage must meet or exceed required percentage
    @Override
    public boolean check(Candidate candidate, Job job) {

        return (candidate.getPercentage() >= job.getMinimumPercentage());
    }
}
