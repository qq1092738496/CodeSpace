package pojo;

public class grade {
    private Integer id;
    private String username;
    private Integer math;
    private Integer english;
    private Integer chinese;

    @Override
    public String toString() {
        return "grade{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", math=" + math +
                ", english=" + english +
                ", chinese=" + chinese +
                '}';
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getId() {

        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getMath() {
        return math;
    }

    public Integer getEnglish() {
        return english;
    }

    public Integer getChinese() {
        return chinese;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public grade() {
    }

    public grade(Integer id, String username, Integer math, Integer english, Integer chinese) {
        this.id = id;
        this.username = username;
        this.math = math;
        this.english = english;
        this.chinese = chinese;
    }

    public grade(String username, Integer math, Integer english, Integer chinese) {
        this.username = username;
        this.math = math;
        this.english = english;

        this.chinese = chinese;
    }
}
