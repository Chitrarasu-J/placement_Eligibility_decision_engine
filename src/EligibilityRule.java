// base class for eligibility rules
public abstract class EligibilityRule {

    public abstract String getRuleName();

    public abstract boolean check(Candidate candidate, Job job);
}
