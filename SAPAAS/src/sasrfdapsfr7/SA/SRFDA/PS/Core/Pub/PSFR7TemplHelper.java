/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSFR7DataTypeMethod;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFR7TemplHelper {
    private static final Log log = LogFactory.getLog(PSFR7TemplHelper.class);
    private static PSFR7DataTypeMethod psExtJSDataTypeMethod = new PSFR7DataTypeMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("srfextjsdatatype", psExtJSDataTypeMethod);
    }
}

