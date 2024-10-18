/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idscpayrollsystem_v01;
import java.util.Date;

/**
 *
 * @author lyren
 */
class User {
    private Date dob, doj;
    private int empid;
    private String name, email, department, status, cprsn, eno, hno, eprsn, pcode, bank, ano, branch, marital, blood;
    public User(int empid, String name, String email, String department, String status){
        this.empid = empid;
        this.name = name;
        this.email = email;
        this.department = department;
        this.status = status;
    }
    public User(int empid, String name, String email, String department, String status, String cprsn, String eno, String hno, String eprsn, String dept, String pcode, String bank, String ano, String branch, String marital, String blood, Date dob, Date doj) {
        this.empid = empid;
        this.name = name;
        this.email = email;
        this.department = department;
        this.status = status;
        this.cprsn = cprsn;
        this.eno = eno;
        this.hno = hno;
        this.eprsn = eprsn;
        this.pcode = pcode;
        this.bank = bank;
        this.ano = ano;
        this.branch = branch;
        this.marital = marital;
        this.blood = blood;
        this.dob = dob;
        this.doj = doj;
    }

    //User(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
    
    public Date getdob(){
        return dob;
    }
    public Date getdoj(){
        return doj;
    }
    public int getempid(){
        return empid;
    }
    public String getname(){
        return name;
    }
    public String getemail(){
        return email;
    }
    public String getdept(){
        return department;
    }
    public String getstatus(){
        return status;
    }
    public String getcprsn(){
        return cprsn;
    }
    public String geteno(){
        return eno;
    }
    public String gethno(){
        return hno;
    }
    public String geteprsn(){
        return eprsn;
    }
    public String getpcode(){
        return pcode;
    }
    public String getbank(){
        return bank;
    }
    public String getano(){
        return ano;
    }
    public String getbranch(){
        return branch;
    }
    public String getmarital(){
        return marital;
    }
    public String getblood(){
        return blood;
    }
}
