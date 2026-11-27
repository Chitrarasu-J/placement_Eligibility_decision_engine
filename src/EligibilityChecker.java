// class to evaluate all rules

public class EligibilityChecker {

    // list of rules
    EligibilityRule rule[] = {new PercentageRule(), new BacklogRule(), new GraduationYearRule(), new SkillRule()};
    boolean eligible = true;

    // validate candidate against all rules
    public boolean check(Candidate candidate, Job job) {
        for (int i = 0; i < rule.length; i++) {

            boolean pass = rule[i].check(candidate, job);

            // print result for each rule
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
