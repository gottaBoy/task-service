/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.Ionic4;

import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4CalculatingIteratorLengthMethod;
import SA.SRFDA.PS.Core.Pub.Ionic4.PSIonic4FileNameMethod;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSIonic4TemplHelper {
    private static final Log log = LogFactory.getLog(PSIonic4TemplHelper.class);
    private static PSIonic4FileNameMethod psFileNameMethod = new PSIonic4FileNameMethod();
    private static PSIonic4CalculatingIteratorLengthMethod psCalculatingIteratorLengthMethod = new PSIonic4CalculatingIteratorLengthMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("filename", psFileNameMethod);
        params.put("iteratorlength", psCalculatingIteratorLengthMethod);
    }
}

