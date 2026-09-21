/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.Preview;

import SA.SRFDA.PS.Core.Pub.AngularGA.PSAngularCalculatingIteratorLengthMethod;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewDataTypeMethod;
import SA.SRFDA.PS.Core.Pub.Preview.PSPreviewFileNameMethod;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPreviewTemplHelper {
    private static final Log log = LogFactory.getLog(PSPreviewTemplHelper.class);
    private static PSPreviewDataTypeMethod psPreViewPCJSDataTypeMethod = new PSPreviewDataTypeMethod();
    private static PSPreviewFileNameMethod psPreViewPCFileNameMethod = new PSPreviewFileNameMethod();
    private static PSAngularCalculatingIteratorLengthMethod psCalculatingIteratorLengthMethod = new PSAngularCalculatingIteratorLengthMethod();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("srfextjsdatatype", psPreViewPCJSDataTypeMethod);
        params.put("filename", psPreViewPCFileNameMethod);
        params.put("iteratorlength", psCalculatingIteratorLengthMethod);
    }
}

