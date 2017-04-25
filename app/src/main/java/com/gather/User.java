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

    public boolean isArt = false;
    public boolean isDesign = false;
    public boolean isLeadership = false;
    public boolean isJava = false;
    public boolean isPython = false;
    public boolean isCSharp = false;
    public boolean isWindows = false;
    public boolean isLinux = false;
    public boolean isOSX = false;
    public boolean isAndroid = false;
    public boolean isIOS = false;
    public boolean isCPP = false;
    public boolean isHTML = false;
    User(){

    }
    User(int Artlvl, int Designlvl, int Leadershiplvl, int Javalvl, int Pythonlvl, int CSharplvl, int Windowslvl, int Linuxlvl, int OSXlvl, int Androidlvl, int IOSlvl, int CPPlvl, int HTMPlvl){
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
    }
    public ArrayList WhatIs() {
        ArrayList<String> list = new ArrayList<>();
        if (isArt)
            list.add("Art");
        if (isDesign)
            list.add("Design");
        if (isLeadership)
            list.add("Leadership");
        if (isJava)
            list.add("Java");
        if (isPython)
            list.add("Python");
        if (isCSharp)
            list.add("CSharp");
        if (isWindows)
            list.add("Windows");
        if (isLinux)
            list.add("Linux");
        if (isOSX)
            list.add("OSX");
        if (isAndroid)
            list.add("Android");
        if (isIOS)
            list.add("IOS");
        if (isCPP)
            list.add("CPP");
        if (isHTML)
            list.add("HTML");
        return list;
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
        list.add(CPPLevel);
        list.add(HTMLLevel);
        return list;
    }
}
