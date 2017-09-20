/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.plug.manager;

import platformer.api.interf.Pluggable;
import platformer.api.interf.PluginManager;

/**
 *
 * @author Julian
 */
public class PluginManagerImpl implements PluginManager {

    @Override
    public void showMessage(Pluggable plugin, String msg) {
        if(plugin.permTextOutput()){
            System.out.println(msg);
        } else {
            System.err.println("Missing permission: \"Text Output\" in Plugin "+plugin.getClass().getSimpleName());
        }
    }

}
