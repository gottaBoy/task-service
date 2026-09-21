/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.Base;

import SA.SRFDA.PS.Core.Pub.Base.PSCalculatingIteratorLengthMethod;
import SA.SRFDA.PS.Core.Pub.Base.PSFileNameMethod;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSTemplHelper {
    private static final Log log = LogFactory.getLog(PSTemplHelper.class);
    private static PSFileNameMethod psFileNameMethod = new PSFileNameMethod();
    private static PSCalculatingIteratorLengthMethod psCalculatingIteratorLengthMethod = new PSCalculatingIteratorLengthMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("filename", psFileNameMethod);
        params.put("iteratorlength", psCalculatingIteratorLengthMethod);
    }
}

