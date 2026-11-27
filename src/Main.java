// scanner library to accept user inputs

import java.util.Scanner;

// main execution class for placement engine
public class Main {

    // starting point of the java program
    public static void main(String[] args) {
        // scanner object to read terminal input
        Scanner scanner = new Scanner(System.in);

        // read student name
        String name = scanner.next();
        // read overall marks percentage
        double percentage = scanner.nextDouble();
        // read number of standing backlogs
        int backlogs = scanner.nextInt();
        // read student passing out year
        int graduationYear = scanner.nextInt();

        int skillCount = scanner.nextInt();
        String[] skills = new String[skillCount];

        for (int i = 0; i < skills.length; i++) {
            skills[i] = scanner.next();
        }

        // store student details into candidate instance
        Candidate candidate = new Candidate(
                name,
                percentage,
                backlogs,
                graduationYear,
                skills
        );

        // company drive criteria to check against
        int jobCount = scanner.nextInt();
        Job job[] = new Job[jobCount];

        for (int i = 0; i < job.length; i++) {
            String company = scanner.next();
            String role = scanner.next();
            Double minimumPercentage = scanner.nextDouble();
            int maxBackLog = scanner.nextInt();
            int requiredGraduationYear = scanner.nextInt();

            int requiredSkillsCount = scanner.nextInt();
            String[] requiredSkills = new String[requiredSkillsCount];

            for (int j = 0; j < requiredSkills.length; j++) {
                requiredSkills[j] = scanner.next();
            }

            job[i] = new Job(
                    company,
                    role,
                    minimumPercentage,
                    maxBackLog,
                    requiredGraduationYear,
                    requiredSkills
            );
        }

        // instantiate checking engine
        EligibilityChecker checker = new EligibilityChecker();
        // instantiate result formatter
        Eligibility eligibility = new Eligibility();

        // print basic student and company summary
        System.out.println();
        System.out.println("Candidate : " + candidate.getName());
        System.out.println();

        System.err.println("AVAILABLE JOBS");

        for (int i = 0; i < job.length; i++) {
            int index = i + 1;
            System.out.println(index + ". " + job[i].getCompany() + " - " + job[i].getRole());
        }
        int select = scanner.nextInt();
        Job selectedJob = job[select - 1];

        // print evaluation header banner
        System.out.println("================================");
        System.out.println("PLACEMENT ELIGIBILITY RESULTS");
        System.out.println("================================");

        System.out.println("Candidate Name: " + candidate.getName());
        System.out.println("Company: " + selectedJob.getCompany());
        System.out.println("Role: " + selectedJob.getCompany());
        System.out.println();

        // run all rules to check if eligible
        boolean eligible = checker.check(candidate, selectedJob);

        System.out.println("================================");

        // prepare pass/fail decision text
        String result = eligibility.eligible(eligible);

        // print the final decision output
        System.out.println(result);

        System.out.println("================================");

        // release scanner resource
        scanner.close();
    }
}
