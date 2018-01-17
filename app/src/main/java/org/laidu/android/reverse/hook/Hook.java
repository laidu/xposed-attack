package org.laidu.android.reverse.hook;

import org.laidu.android.reverse.util.MethodHookUtil;

import java.util.List;

/**
 * Created by tczang on 18/1/17.
 */

public interface Hook {

    default void hook(){
        buildHookClassList().forEach(MethodHookUtil::hookAllMethods);
    }

    List<String> buildHookClassList();

}
