import java.util.Stack;

public class ResumeVersionManager {
    private Stack<ResumeEditor.Memento> resumeVersions = new Stack<>();

    public void save(ResumeEditor resume){
        resumeVersions.push(resume.save());
    }

    public void rollback(ResumeEditor resume){
        if(!resumeVersions.empty()){
            resume.restore(resumeVersions.pop());
        } else{
            System.out.println("No History Found.");
        }
    }
}
