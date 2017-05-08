///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package platformer.util;
//
//import platformer.core.Platformer;
//import java.io.File;
//import java.io.IOException;
//import org.ini4j.*;
//
///**
// *
// * @author Julian
// */
//public class ReadINI {
//
//    //INI Objects
//    Ini inifile;
//    //File Paths
//    File iniloc;
//
//    public ReadINI(File iniloc) {
//        //Loading INI
//        try {
//            //Checks whether ini exists..
//            if (!iniloc.exists()) {
//                Platformer.print("Config doesn't exist..");
//                InitINI.initIni(iniloc);
//            }
//            //creating the ini object
//            inifile = new Wini(iniloc);
//        } catch (IOException e) {
//            Platformer.print("Error reading file..");
//        }
//    }
//
//    //two methods to read, both return types differenced by the last parameter
//    public int read(String pSection, String pOption, int p) {
//        return inifile.get(pSection, pOption, int.class);
//    }
//
//    public String read(String pSection, String pOption, String p) {
//        return inifile.get(pSection, pOption);
//    }
//
//    public void put(String pSection, String pOption, int pValue) {
//        inifile.put(pSection, pOption, pValue);
//    }
//
//    public void put(String pSection, String pOption, String pValue) {
//        inifile.put(pSection, pOption, pValue);
//    }
//}
