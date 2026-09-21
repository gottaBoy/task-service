/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.Angular;

import SA.SRFDA.PS.Core.Pub.Angular.PSAngularFileNameMethod;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAngularTemplHelper {
    private static final Log log = LogFactory.getLog(PSAngularTemplHelper.class);
    private static PSAngularFileNameMethod psNgFileNameMethod = new PSAngularFileNameMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("ngfilename", psNgFileNameMethod);
    }
}

