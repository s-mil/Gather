package com.gather;
import android.view.Window;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class User {
    private String Username = " ";
    private String CourseNumber = " ";
    private String Art = "Art";
    private String Design = "Design";
    private String Leadership = "Leadership";
    private String Java = "Java";
    private String Python = "Python";
    private String CSharp = "C#";
    private String Windows = "Windows";
    private String Linux = "Linux";
    private String OSX = "OSX";
    private String Android = "Android";
    private String IOS = "IOS";
    private String CPP = "C++";
    private String HTML = "HTML";

    private int ArtLevel =   0;
    private int DesignLevel =   0;
    private int LeadershipLevel =  0;
    private int JavaLevel =  0;
    private int PythonLevel =  0;
    private int CSharpLevel =  0;
    private int WindowsLevel =  0;
    private int LinuxLevel =  0;
    private int OSXLevel =  0;
    private int AndroidLevel =  0;
    private int IOSLevel =  0;
    private int CPPLevel =  0;
    private int HTMLLevel =  0;

    private boolean isArt = false;
    private boolean isDesign = false;
    private boolean isLeadership = false;
    private boolean isJava = false;
    private boolean isPython = false;
    private boolean isCSharp = false;
    private boolean isWindows = false;
    private boolean isLinux = false;
    private boolean isOSX = false;
    private boolean isAndroid = false;
    private boolean isIOS = false;
    private boolean isCPP = false;
    private boolean isHTML = false;
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
            list.add(Art);
        if (isDesign)
            list.add(Design);
        if (isLeadership)
            list.add(Leadership);
        if (isJava)
            list.add(Java);
        if (isPython)
            list.add(Python);
        if (isCSharp)
            list.add(CSharp);
        if (isWindows)
            list.add(Windows);
        if (isLinux)
            list.add(Linux);
        if (isOSX)
            list.add(OSX);
        if (isAndroid)
            list.add(Android);
        if (isIOS)
            list.add(IOS);
        if (isCPP)
            list.add(CPP);
        if (isHTML)
            list.add(HTML);
        return list;
    }
}
