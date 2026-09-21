/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.React;

import SA.SRFDA.PS.Core.Pub.React.PSReactCalculatingIteratorLengthMethod;
import SA.SRFDA.PS.Core.Pub.React.PSReactFileNameMethod;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSReactTemplHelper {
    private static final Log log = LogFactory.getLog(PSReactTemplHelper.class);
    private static PSReactFileNameMethod psFileNameMethod = new PSReactFileNameMethod();
    private static PSReactCalculatingIteratorLengthMethod psCalculatingIteratorLengthMethod = new PSReactCalculatingIteratorLengthMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("filename", psFileNameMethod);
        params.put("iteratorlength", psCalculatingIteratorLengthMethod);
    }
}

