//package org.laidu.android.reverse.hook;
//
//import org.laidu.android.reverse.annotation.HookService;
//import org.laidu.android.reverse.util.MethodHookUtil;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by laidu on 18-1-17.
// */
//
//@HookService(ignore = true)
//public class StringConstructorHook implements Hook {
//
//    @Override
//    public List<String> buildHookClassList() {
//        return Arrays.asList("java.lang.StringFactory",
//                "java.lang.String",
//                "java.lang.StringBuffer",
//                "java.lang.StringBuilder");
//    }
//
//    @Override
//    public void hook() {
//        buildHookClassList().forEach(MethodHookUtil::hookAllConstructor);
//    }
//}
