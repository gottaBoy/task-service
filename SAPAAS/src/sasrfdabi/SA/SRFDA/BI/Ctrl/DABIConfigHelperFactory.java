/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.DABIConfigHelper;
import SA.SRFDA.BI.Ctrl.IDABIConfigHelper;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DABIConfigHelperFactory {
    protected static Hashtable<String, IDABIConfigHelper> daBIConfigHelperMap = new Hashtable();
    private static final Log log = LogFactory.getLog(DABIConfigHelperFactory.class);

    public static IDABIConfigHelper GetDABIConfigHelper(SRFDAPageEx page) {
        String strKey = StringHelper.Format((String)"%1$s_%2$s", (Object)page.getLanguage(), (Object)page.getPageModel());
        IDABIConfigHelper iConfigHelper = daBIConfigHelperMap.get(strKey);
        if (iConfigHelper != null) {
            return iConfigHelper;
        }
        String strConfigHelper = page.getWebContext().getWebExConfig().GetValue("SRFBI", "DABICONFIGHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strConfigHelper)) {
            iConfigHelper = new DABIConfigHelper();
        } else {
            Object obj = ObjectHelper.Create((String)strConfigHelper);
            if (obj == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acbBI\u754c\u9762\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strConfigHelper));
                return null;
            }
            if (!(obj instanceof IDABIConfigHelper)) {
                log.error((Object)StringHelper.Format((String)"BI\u754c\u9762\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strConfigHelper));
                return null;
            }
            iConfigHelper = (IDABIConfigHelper)obj;
        }
        if (!iConfigHelper.Init((ISRFDAGlobalHelper)page.getWebContext().getGlobalHelper(), page.getLanguage(), page.getPageModel())) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316BI\u754c\u9762\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strConfigHelper));
            return null;
        }
        daBIConfigHelperMap.put(strKey, iConfigHelper);
        return iConfigHelper;
    }
}

