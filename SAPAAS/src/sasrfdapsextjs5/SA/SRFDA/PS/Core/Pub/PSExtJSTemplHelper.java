/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSExtJSDataTypeMethod;
import SA.SRFDA.PS.Core.Pub.PSExtJSImagePathMethod;
import java.util.Map;
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

