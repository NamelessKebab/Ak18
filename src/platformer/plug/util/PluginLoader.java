/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package platformer.plug.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import platformer.api.interf.Pluggable;

/**
 *
 * @author Julian
 */
public class PluginLoader {

    public static List<Pluggable> loadPlugins(File pluginDir) throws MalformedURLException, IOException {
        File[] plugJars = pluginDir.listFiles(new JARFileFilter());
        ClassLoader cl = new URLClassLoader(PluginLoader.fileArrayToURLArray(plugJars));
        List<Class<Pluggable>> plugClasses = PluginLoader.extractClassesFromJARs(plugJars, cl);
        return PluginLoader.createPluggableObjects(plugClasses);
    }

    private static URL[] fileArrayToURLArray(File[] files) throws MalformedURLException {
        if (files == null) {
            files = new File[0];
        }
        URL[] urls = new URL[files.length];
        for (int i = 0; i < files.length; i++) {
            urls[i] = files[i].toURI().toURL();
        }
        return urls;
    }

    private static List<Class<Pluggable>> extractClassesFromJARs(File[] plugJars, ClassLoader cl) throws IOException {
        List<Class<Pluggable>> classes = new ArrayList<>();
        if (plugJars == null) {
            return classes;
        }
        for (File jar : plugJars) {
            classes.addAll(PluginLoader.extractClassesFromJAR(jar, cl));
        }
        return classes;
    }

    private static Collection<? extends Class<Pluggable>> extractClassesFromJAR(File jar, ClassLoader cl) throws IOException {
        List<Class<Pluggable>> classes = new ArrayList<>();
        JarInputStream jaris = new JarInputStream(new FileInputStream(jar));
        JarEntry ent = null;
        while ((ent = jaris.getNextJarEntry()) != null) {
            if (ent.getName().toLowerCase().endsWith(".class")) {
                try {
                    Class<?> cls = cl.loadClass(ent.getName().substring(0, ent.getName().length() - 6).replace('/', '.'));
                    if (PluginLoader.isPluggableClass(cls)) {
                        classes.add((Class<Pluggable>) cls);
                    }
                } catch (ClassNotFoundException e) {
                    System.err.println("Can't load Class " + ent.getName());
                    e.printStackTrace();
                }
            }
        }
        jaris.close();
        return classes;
    }

    private static boolean isPluggableClass(Class<?> cls) {
        for (Class<?> i : cls.getInterfaces()) {
            if (i.equals(Pluggable.class)) {
                return true;
            }
        }
        return false;
    }

    private static List<Pluggable> createPluggableObjects(List<Class<Pluggable>> plugClasses) {
        List<Pluggable> plugs = new ArrayList<>(plugClasses.size());
        for (Class<Pluggable> plug : plugClasses) {
            try {
                plugs.add(plug.newInstance());
            } catch (InstantiationException e) {
                System.err.println("Can't instantiate plugin: " + plug.getName());
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                System.err.println("IllegalAccess for plugin: " + plug.getName());
                e.printStackTrace();
            }
        }
        return plugs;
    }
}
