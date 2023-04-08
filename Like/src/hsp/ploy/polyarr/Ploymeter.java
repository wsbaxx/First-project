package hsp.ploy.polyarr;

public class Ploymeter {
    public static void main(String[] args) {
        CommonEmployee sMith = new CommonEmployee("SMith", 2600);
        Ploymeter loymeter = new Ploymeter();
        loymeter.showEmp(sMith);
    }
    public void showEmp(Employee e){
        System.out.println(e.getAnnual());
    }
}

class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getAnnual(){
        return salary*12;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class CommonEmployee extends Employee{
    public CommonEmployee(String name, double salary) {
        super(name, salary);
    }
    public void work(){
        System.out.println("可怜的员工");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}

class Manager extends Employee{
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    public void manage(){
        System.out.println("管理者，但也只是打工人");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual()+bonus;
    }
}

class Test{
    public double showEmpAnnual(Employee e){
      return e.getAnnual();
    }
    public void testWork(Employee e){
        if(e instanceof CommonEmployee){
            CommonEmployee pol = (CommonEmployee) e;
            pol.work();
        } else if (e instanceof Manager) {
            Manager ma = (Manager) e;
            ma.manage();
        }
    }
    }
