/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idscpayrollsystem_v01;

/**
 *
 * @author lyren
 */
class Dept {
    private String department, shift;
    private int monthlyRate, daysperMonth, dailyRate, hoursperDay, hourlyRate;
    
    Dept (String department, int monthlyRate, int daysperMonth, int dailyRate, int hoursperDay, int hourlyRate, String shift){
        this.department = department;
        this.shift = shift;
        this.monthlyRate = monthlyRate;
        this.daysperMonth = daysperMonth;
        this.dailyRate = dailyRate;
        this.hoursperDay = hoursperDay;
        this.hourlyRate = hourlyRate;
    }
    
    public String getdept(){
        return department;
    }
    
    public String getshift(){
        return shift;
    }
    
    public int getmRate(){
        return monthlyRate;
    }
    
    public int getdpM(){
        return daysperMonth;
    }
    
    public int getdRate(){
        return dailyRate;
    }
    
    public int gethpD(){
        return hoursperDay;
    }
    
    public int gethRate(){
        return hourlyRate;
    }
}
