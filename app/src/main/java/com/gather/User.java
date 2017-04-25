package com.gather;

import android.view.Window;

import java.util.ArrayList;

/**
 * Created by Sithis on 4/25/2017.
 */

public class User {
    private String Username;
    private String CourseNumber;
    private String Art;
    private String Design;
    private String Leadership;
    private String Java;
    private String Python;
    private String CSharp;
    private String Windows;
    private String Linux;
    private String OSX;
    private String Android;
    private String IOS;

    private int ArtLevel;
    private int DesignLevel;
    private int LeadershipLevel;
    private int JavaLevel;
    private int PythonLevel;
    private int CSharpLevel;
    private int WindowsLevel;
    private int LinuxLevel;
    private int OSXLevel;
    private int AndroidLevel;
    private int IOSLevel;

    private boolean isArt;
    private boolean isDesign;
    private boolean isLeadership;
    private boolean isJava;
    private boolean isPython;
    private boolean isCSharp;
    private boolean isWindows;
    private boolean isLinux;
    private boolean isOSX;
    private boolean isAndroid;
    private boolean isIOS;
    User(){

    }
    User(int Artlvl, int Designlvl, int Leadershiplvl, int Javalvl, int Pythonlvl, int CSharplvl, int Windowslvl, int Linuxlvl, int OSXlvl, int Androidlvl, int IOSlvl){
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
        return list;
    }
}
