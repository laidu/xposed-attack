package org.laidu.android.reverse;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import org.laidu.android.reverse.annotation.HookService;
import org.laidu.android.reverse.hook.CryptoHook;
import org.laidu.android.reverse.hook.Hook;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import dalvik.system.DexFile;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by tczang on 18/1/17.
 */

public class MainApp implements IXposedHookLoadPackage {

    private final static String HOOK_SERVICE_PACKAGE = "org.laidu.android.reverse.hook";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("Loaded app: " + lpparam.packageName);

//        startHooks();
        new CryptoHook().hook();
    }

    void startHooks() throws IOException, ClassNotFoundException {
        File file = new File(Hook.class.getResource("").getFile());
        URL url = file.toURI().toURL();

        List<Class<Hook>> hookList = new ArrayList<>();
        ClassLoader loader = new URLClassLoader(new URL[]{url});
        for (File var : file.listFiles()) {
            File classFile = var.getCanonicalFile();
            if (classFile.isFile() && classFile.getName().endsWith(".class")) {
                Class clazz = loader.loadClass(Hook.class.getPackage().getName() +"."+classFile.getName().replace(".class",""));
                if (!clazz.getClass().isInterface()) {
                    for (Class c : clazz.getInterfaces()){
                        if (c.equals(Hook.class)){
                            hookList.add(clazz);
                        }
                    }
                }
            }
        }
        hookList.forEach((Class<Hook> hook) -> {
            try {
                HookService hookService = hook.getAnnotation(HookService.class);
                if (hookService !=null && !hookService.ignore()){
                    hook.newInstance().hook();
                }
            } catch (Exception e) {
                XposedBridge.log(String.format("start %s hook failure",hook.getCanonicalName()));
            }
        });
    }

}
