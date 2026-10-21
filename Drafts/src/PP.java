public class PP {
    private String name;
    private int age;
    private SexEnum sex;
    private double income;

    public PP(String name, int age, SexEnum sex, double income) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.income = income;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex.getDescription();
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public double getIncomeTax() {
        return income * 13 * 0.275;
    }
}
