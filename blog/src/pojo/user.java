package pojo;


/**
 * @description:
 * @author: Andy
 * @time: 2022/6/11 12:10
 */

public class user {
    private String userName;
    private String passWord;
    private String fullName;
    private String Student_ID;
    private String mailbox;

    public user() {
    }

    public user(String userName, String passWord, String fullName, String student_ID, String mailbox) {
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        Student_ID = student_ID;
        this.mailbox = mailbox;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    @Override
    public String toString() {
        return "user{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", fullName='" + fullName + '\'' +
                ", Student_ID='" + Student_ID + '\'' +
                ", mailbox='" + mailbox + '\'' +
                '}';
    }
}
