/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.JSGear;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FormModifyAlertJSGear {
    private static final Log log = LogFactory.getLog(FormModifyAlertJSGear.class);

    public static boolean Load(SRFDAPage daPage, String strAlert) {
        try {
            String strInfo = strAlert;
            if (StringHelper.IsNullOrEmpty((String)strInfo)) {
                daPage.RegisterCacheOnReadyScript(3, "$U.formmodifyalert();");
            } else {
                StringBuilderEx script = new StringBuilderEx();
                script.Append("window.onbeforeunload=function(e){if($P.mainform==null||!$P.mainform.isdirty())return;return '%1$s';};", (Object)strInfo);
                daPage.RegisterCacheOnReadyScript(3, script.toString());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return true;
    }

    public static boolean Load(SRFDAPage daPage) {
        return FormModifyAlertJSGear.Load(daPage, "");
    }
}

