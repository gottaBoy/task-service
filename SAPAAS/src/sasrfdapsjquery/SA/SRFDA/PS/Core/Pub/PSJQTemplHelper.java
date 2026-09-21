/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSJQDataTypeMethod;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJQTemplHelper {
    private static final Log log = LogFactory.getLog(PSJQTemplHelper.class);
    private static PSJQDataTypeMethod psJQJSDataTypeMethod = new PSJQDataTypeMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("srfextjsdatatype", psJQJSDataTypeMethod);
    }
}

