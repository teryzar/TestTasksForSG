
import entity.Issue;
import pojo.issues.InsertIssueTemplate;
import utils.database.AddIssue;


public class TestAdding {

    public static void main(String[] args) {
        InsertIssueTemplate issue = new InsertIssueTemplate(3453L, 1, "test", "test", 0);
        AddIssue.addIssue(issue);

    }

}
