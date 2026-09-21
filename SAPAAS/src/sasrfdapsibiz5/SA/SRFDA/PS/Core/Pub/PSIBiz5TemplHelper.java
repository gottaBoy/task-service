/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSIBiz5LocaleMethod;
import SA.SRFDA.PS.Core.Pub.PSIBiz5MsgMethod;
import SA.SRFDA.PS.Core.Pub.PSIBiz5MsgMethod2;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSIBiz5TemplHelper {
    private static final Log log = LogFactory.getLog(PSIBiz5TemplHelper.class);
    private static PSIBiz5LocaleMethod psIBiz5LocaleMethod = new PSIBiz5LocaleMethod();
    private static PSIBiz5MsgMethod psIBiz5MsgMethod = new PSIBiz5MsgMethod();
    private static PSIBiz5MsgMethod2 psIBiz5MsgMethod2 = new PSIBiz5MsgMethod2();

    public static void fillParams(Map<String, Object> params) throws Exception {
        params.put("srfibiz5locale", psIBiz5LocaleMethod);
        params.put("srfibiz5msg", psIBiz5MsgMethod);
        params.put("srfibizmsg", psIBiz5MsgMethod2);
    }
}

