package com.gather;
import android.view.Window;

import java.util.ArrayList;
import java.util.StringTokenizer;
public class User {
    public int ArtLevel =   0;
    public int DesignLevel =   0;
    public int LeadershipLevel =  0;
    public int JavaLevel =  0;
    public int PythonLevel =  0;
    public int CSharpLevel =  0;
    public int WindowsLevel =  0;
    public int LinuxLevel =  0;
    public int OSXLevel =  0;
    public int AndroidLevel =  0;
    public int IOSLevel =  0;
    public int CPPLevel =  0;
    public int HTMLLevel =  0;
    public int CourseNum = 0;
    public int SectionNum= 0;
    public int inGroup = 0;
    public String groupName = "General";
    public String displayName = "Anonymous";
    User(){

    }
    User(int Artlvl, int Designlvl, int Leadershiplvl, int Javalvl, int Pythonlvl, int CSharplvl, int Windowslvl, int Linuxlvl, int OSXlvl, int Androidlvl, int IOSlvl, int CPPlvl, int HTMPlvl, int CourseNum, int SectionNum, int inGroup, String groupName, String displayName){
        this.ArtLevel = Artlvl;
        this.DesignLevel = Designlvl;
        this.LeadershipLevel = Leadershiplvl;
        this.JavaLevel = Javalvl;
        this.PythonLevel = Pythonlvl;
        this.CSharpLevel = CSharplvl;
        this.WindowsLevel = Windowslvl;
        this.LinuxLevel = Linuxlvl;
        this.OSXLevel = OSXlvl;
        this.AndroidLevel = Androidlvl;
        this.IOSLevel = IOSlvl;
        this.CPPLevel = CPPlvl;
        this.HTMLLevel = HTMPlvl;
        this.CourseNum = CourseNum;
        this.SectionNum = SectionNum;
        this.inGroup = inGroup;
        this.groupName = groupName;
        this.displayName = displayName;
    }
    public ArrayList getLevels() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(ArtLevel);
        list.add(DesignLevel);
        list.add(LeadershipLevel);
        list.add(JavaLevel);
        list.add(PythonLevel);
        list.add(CSharpLevel);
        list.add(WindowsLevel);
        list.add(LinuxLevel);
        list.add(OSXLevel);
        list.add(AndroidLevel);
        list.add(IOSLevel);
        list.add(CPPLevel);
        list.add(HTMLLevel);
        return list;
    }
    public boolean inGroup() {
        if (inGroup == 0)
            return false;
        return true;
    }
    public String getGroupName() {
        return groupName;
    }
    public String getdisplayName() {
        return displayName;
    }
}
