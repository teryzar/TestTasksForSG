package utils.database;

import entity.Issue;
import pojo.issues.InsertIssueTemplate;
import utils.user.UserValidator;

public class AddIssue {
    public static void addIssue (InsertIssueTemplate issueToinsert){
        Long token = issueToinsert.getToken();
        UserValidator.verifyUserRights(token);
        //преобразовываем полученные в запросе значения в POJO для Hibernate
        Issue issueToAdd = new Issue(issueToinsert.getTitle(), issueToinsert.getDescription(), 
                issueToinsert.getStatus(), issueToinsert.getUser_id());
        //записываем обьект в базу данных
        DataHelper.getInstance().addIssue(issueToAdd);
    }
}
