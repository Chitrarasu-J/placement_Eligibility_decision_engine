
public class EligibilityChecker {

    EligibilityRule rule[] = {new PercentageRule(), new BacklogRule(), new GraduationYearRule()};
    boolean eligible = true;

    public boolean check(Candidate candidate, Job job) {
        for (int i = 0; i < rule.length; i++) {

            boolean pass = rule[i].check(candidate, job);

            if (pass) {
                System.err.println(rule[i].getRuleName() + ": PASS");
            } else {
                eligible = false;
                System.err.println(rule[i].getRuleName() + ": FAIL");
            }
        }
        return eligible;
    }

}
