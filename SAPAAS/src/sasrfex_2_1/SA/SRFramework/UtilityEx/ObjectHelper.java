/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.UtilityEx;

import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ObjectHelper {
    private static final Log log = LogFactory.getLog(ObjectHelper.class);

    public static Object Create(String strType) {
        try {
            return Class.forName(strType).newInstance();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strType), (Throwable)ex);
            ex.printStackTrace();
            return null;
        }
    }

    public static Object Create(Class classType) {
        try {
            return classType.newInstance();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)classType.toString()), (Throwable)ex);
            ex.printStackTrace();
            return null;
        }
    }
}

