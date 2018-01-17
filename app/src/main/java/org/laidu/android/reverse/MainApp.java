package org.laidu.android.reverse;

import org.laidu.android.reverse.util.MethodHookUtil;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by tczang on 18/1/17.
 */

public class MainApp implements IXposedHookLoadPackage {

    private final static String HOOK_SERVICE_PACKAGE = "org.laidu.android.reverse.hook";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedBridge.log("Loaded app: " + lpparam.packageName);

        File file = new File(MainApp.class.getResource("").getFile());
        URL url = file.toURI().toURL();
        ClassLoader loader = new URLClassLoader(new URL[]{url});
        Class<?> cls = loader.loadClass(HOOK_SERVICE_PACKAGE);//加载指定类，注意一定要带上类的包名


        hookCrypto();
    }

    void hookCrypto() throws ClassNotFoundException {

        //int i, java.security.Key key, java.security.spec.AlgorithmParameterSpec algorithmParameterSpec


    }

    void hookAllStringFactoryNewString() throws ClassNotFoundException {

        XposedHelpers.findAndHookMethod(Class.forName("java.lang.StringFactory"), "newStringFromBytes", byte[].class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookMethod(Class.forName("java.lang.StringFactory"), "newStringFromChars", char[].class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookMethod(Class.forName("java.lang.StringFactory"), "newStringFromStringBuffer", StringBuffer.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.callStaticMethod(Class.forName("java.lang.StringFactory"), "newStringFromCodePoints",MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookMethod(Class.forName("java.lang.StringFactory"), "newStringFromStringBuilder", StringBuilder.class, MethodHookUtil.methodSignatureHook());
    }

    void hookAllStringConstructor() {

        XposedHelpers.findAndHookConstructor(String.class, byte[].class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, byte[].class, String.class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, byte[].class, Charset.class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, byte[].class, int.class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, byte[].class, int.class, int.class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, byte[].class, int.class, int.class, String.class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, byte[].class, int.class, int.class, int.class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, byte[].class, int.class, int.class, Charset.class, MethodHookUtil.methodSignatureHook());

        XposedHelpers.findAndHookConstructor(String.class, char[].class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, char[].class, int.class, int.class, MethodHookUtil.methodSignatureHook());

        XposedHelpers.findAndHookConstructor(String.class, int[].class, int.class, int.class, MethodHookUtil.methodSignatureHook());

        XposedHelpers.findAndHookConstructor(String.class, String.class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, StringBuffer.class, MethodHookUtil.methodSignatureHook());
        XposedHelpers.findAndHookConstructor(String.class, StringBuilder.class, MethodHookUtil.methodSignatureHook());

    }


}
