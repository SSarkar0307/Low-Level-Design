import java.util.*;

public class Main{
    public static void main(String[] args) {
        List<String> skills= new ArrayList<>(List.of("LLD", "DSA"));

        ResumeEditor resume = new ResumeEditor("Sohan", "B.Tech", "Fresher", skills);
        ResumeVersionManager versions = new ResumeVersionManager();

        versions.save(resume);
        resume.printResume();
        
        resume.setExperience("SDE-1");
        versions.save(resume);
        resume.printResume();
        
        resume.setEducation("High School");
        resume.printResume();
        
        versions.rollback(resume);
        System.out.println("1st Rollback");
        resume.printResume();
        
        versions.rollback(resume);
        System.out.println("2nd Rollback");
        resume.printResume();
        
        versions.rollback(resume);
        System.out.println("3rd Rollback");
        resume.printResume();
    }
}