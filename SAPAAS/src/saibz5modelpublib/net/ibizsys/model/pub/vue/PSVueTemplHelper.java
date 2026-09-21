/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub.vue;

import java.util.Map;
import net.ibizsys.model.pub.vue.PSVueFileNameMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSVueTemplHelper {
    private static final Log log = LogFactory.getLog(PSVueTemplHelper.class);
    private static PSVueFileNameMethod psVueFileNameMethod = new PSVueFileNameMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("vfilename", psVueFileNameMethod);
    }
}

