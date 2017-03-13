/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import erstesgame.Erstesgame;
import java.io.File;
import java.io.IOException;
import org.ini4j.*;

/**
 *
 * @author Julian
 */
public class ReadConfig {
    //Settings
    Wini iniconf;
    //File Paths
    File inidir;
    File iniloc;
    
    public ReadConfig(String dirName) {
        //Checks OS and sets File Path and dir to the right loc.
        if(CheckOS.isWindows()){
            inidir = new File(System.getenv("AppData"),"Erstesgame");
            iniloc = new File(System.getenv("AppData"),"Erstesgame\\config.ini");
        }
        else if(CheckOS.isUnix()){
            inidir = new File(System.getenv("XDG_CONFIG_HOME"),"Erstesgame");
            iniloc = new File(System.getenv("XDG_CONFIG_HOME"),"Erstesgame\\config.ini");
        }
        else{
            Erstesgame.print("Sorry, but your System is not yet supported for using Configs..");
        }
        //Checks whether directory exists, if not it will create it.
        if(inidir.exists()){
            Erstesgame.print("Erstesgame dir already exists. Loc: " + inidir.getPath());
        }
        else{
            if(inidir.mkdir()){
                Erstesgame.print("Erstesgame dir created..");
            }
            else{
                Erstesgame.print("Erstesgame dir failed to create.. Tried at: " + inidir.getPath());
            }
        }
        //Loading INI
        try{
            //Checks whether ini exists..
            if(!iniloc.exists()){
                Erstesgame.print("Config doesn't exist..");
                InitConfig.initIni(iniloc);
            }
            //creating the ini object
            iniconf = new Wini(iniloc);
        }
        catch(IOException e){
            Erstesgame.print("Error reading file..");
        }
    }
    //two methods to read, both return types differenced by the last parameter
    public int read(String pSection,String pOption,int p){
        return iniconf.get(pSection,pOption,int.class);
    }
    
    public String read(String pSection,String pOption,String p){
        return iniconf.get(pSection, pOption);
    }
    
    public void put(String pSection,String pOption, int pValue){
        iniconf.put(pSection,pOption,pValue);
    }
    
    public void put(String pSection,String pOption, String pValue){
        iniconf.put(pSection,pOption,pValue);
    }
}
