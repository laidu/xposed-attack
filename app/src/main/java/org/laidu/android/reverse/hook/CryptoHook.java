package org.laidu.android.reverse.hook;

import org.laidu.android.reverse.util.MethodHookUtil;

/**
 * Created by tczang on 18/1/17.
 */

public class CryptoHook implements Hook {

    //        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "init", int.class, Certificate.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "init", int.class, Certificate.class, SecureRandom.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "init", int.class, Key.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "init", int.class, Key.class, AlgorithmParameters.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "init", int.class, Key.class, AlgorithmParameters.class,SecureRandom.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "init", int.class, Key.class, AlgorithmParameterSpec.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "init", int.class, Key.class, AlgorithmParameterSpec.class,SecureRandom.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "init", int.class, Key.class, SecureRandom.class, MethodHookUtil.methodSignatureHook());


//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "doFinal", MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "doFinal", byte[].class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "doFinal", byte[].class,int.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "doFinal", byte[].class,int.class,int.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "doFinal", byte[].class,int.class,int.class,byte[].class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "doFinal", byte[].class,int.class,int.class,byte[].class,int.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookMethod(Class.forName("javax.crypto.Cipher"), "doFinal", ByteBuffer.class, MethodHookUtil.methodSignatureHook());

    //        XposedHelpers.findAndHookConstructor(Class.forName("javax.crypto.spec.SecretKeySpec"), byte[].class,int.class,int.class,String.class, MethodHookUtil.methodSignatureHook());
//        XposedHelpers.findAndHookConstructor(Class.forName("javax.crypto.spec.SecretKeySpec"), byte[].class,String.class, MethodHookUtil.methodSignatureHook());
    @Override
    public void hook() {

        MethodHookUtil.hookAllMethods("javax.crypto.Cipher");
        MethodHookUtil.hookAllMethods("javax.crypto.spec.SecretKeySpec");
        MethodHookUtil.hookAllMethods("javax.crypto.spec.IvParameterSpec");
        MethodHookUtil.hookAllMethods("java.security.SecureRandom");
    }
}
