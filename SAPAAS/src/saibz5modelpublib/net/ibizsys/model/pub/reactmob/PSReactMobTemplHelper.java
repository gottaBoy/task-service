/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub.reactmob;

import java.util.Map;
import net.ibizsys.model.pub.reactmob.PSReactMobFileNameMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSReactMobTemplHelper {
    private static final Log log = LogFactory.getLog(PSReactMobTemplHelper.class);
    private static PSReactMobFileNameMethod psIonicFileNameMethod = new PSReactMobFileNameMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("filename", psIonicFileNameMethod);
    }
}

