// rule to check backlogs
public class BacklogRule extends EligibilityRule {

    @Override
    public String getRuleName() {
        return "Backlog";
    }

    // check if candidate's backlogs are within allowed limit
    @Override
    public boolean check(Candidate candidate, Job job) {

        return (candidate.getBacklogs() <= job.getMaximumBacklogs());
    }
}
