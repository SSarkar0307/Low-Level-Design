import java.util.*;

public class ResumeEditor{
    private String name;
    private String education;
    private String experience;
    private List<String> skills;

    public ResumeEditor(String name, String education, String experience, List<String> skills){
        setName(name);
        setEducation(education);
        setExperience(experience);
        setSkills(skills);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void printResume() {
        System.out.println("----- Resume -----");
        System.out.println("Name: " + name);
        System.out.println("Education: " + education);
        System.out.println("Experience: " + experience);
        System.out.println("Skills: " + skills);
        System.out.println("------------------");
    }

    public void restore(Memento resumeVersion){
        setName(resumeVersion.getName());
        setEducation(resumeVersion.getEducation());
        setExperience(resumeVersion.getExperience());
        setSkills(resumeVersion.getSkills());
    }

    public Memento save(){
        return new Memento(name, education, experience, new ArrayList<>(skills));
    }

    public static class Memento{
        private final String name;
        private final String education;
        private final String experience;
        private final List<String> skills;

        private Memento(String name, String education, String experience, List<String> skills) {
            this.name = name;
            this.education = education;
            this.experience = experience;
            this.skills = skills;
        }

        private String getName() {
            return name;
        }

        private String getEducation() {
            return education;
        }

        private String getExperience() {
            return experience;
        }

        private List<String> getSkills() {
            return skills;
        }
    }
}