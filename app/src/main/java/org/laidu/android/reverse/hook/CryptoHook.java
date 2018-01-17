package org.laidu.android.reverse.hook;

import org.laidu.android.reverse.annotation.HookService;
import org.laidu.android.reverse.util.MethodHookUtil;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tczang on 18/1/17.
 */
@HookService
public class CryptoHook implements Hook {

    //  ookConstructor(Class.forName("javax.crypto.spec.SecretKeySpec"), byte[].class,String.class, MethodHookUtil.methodSignatureHook());

    @Override
    public List<String> buildHookClassList() {
        return Arrays.asList("javax.crypto.Cipher",
                "javax.crypto.spec.SecretKeySpec",
                "javax.crypto.spec.IvParameterSpec",
                "java.security.SecureRandom");
    }
}
