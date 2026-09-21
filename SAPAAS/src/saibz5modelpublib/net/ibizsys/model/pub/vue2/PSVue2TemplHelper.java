/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.pub.vue2;

import java.util.Map;
import net.ibizsys.model.pub.angularga.PSAngularCalculatingIteratorLengthMethod;
import net.ibizsys.model.pub.vue2.PSVue2DataTypeMethod;
import net.ibizsys.model.pub.vue2.PSVue2FileNameMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSVue2TemplHelper {
    private static final Log log = LogFactory.getLog(PSVue2TemplHelper.class);
    private static PSVue2DataTypeMethod psVue2DataTypeMethod = new PSVue2DataTypeMethod();
    private static PSVue2FileNameMethod psVue2FileNameMethod = new PSVue2FileNameMethod();
    private static PSAngularCalculatingIteratorLengthMethod psCalculatingIteratorLengthMethod = new PSAngularCalculatingIteratorLengthMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("srfextjsdatatype", psVue2DataTypeMethod);
        params.put("filename", psVue2FileNameMethod);
        params.put("iteratorlength", psCalculatingIteratorLengthMethod);
    }
}

