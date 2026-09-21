/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub;

import java.util.Map;
import net.ibizsys.model.pub.PSExtJSDataTypeMethod;
import net.ibizsys.model.pub.PSExtJSImagePathMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSExtJSTemplHelper {
    private static final Log log = LogFactory.getLog(PSExtJSTemplHelper.class);
    private static PSExtJSDataTypeMethod psExtJSDataTypeMethod = new PSExtJSDataTypeMethod();
    private static PSExtJSImagePathMethod psExtJSImagePathMethod = new PSExtJSImagePathMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("srfextjsdatatype", psExtJSDataTypeMethod);
        params.put("srfextjsimagepath", psExtJSImagePathMethod);
    }
}

