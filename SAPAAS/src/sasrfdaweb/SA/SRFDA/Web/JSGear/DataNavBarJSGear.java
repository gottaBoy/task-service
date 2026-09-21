/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExTabView
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.JSGear;

import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExTabView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataNavBarJSGear {
    private static final Log log = LogFactory.getLog(DataNavBarJSGear.class);

    public static boolean Load(SRFDAPage daPage, SRFExTabView tabView, SRFExForm form, String strKeyId) {
        try {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("function navdata(pos){");
            script.Append("SRFUtility.navpdg(pos,'%1$s',%2$s,'%3$s');", (Object)strKeyId.toLowerCase(), (Object)(form == null ? "null" : form.getFormId()), (Object)(tabView == null ? "" : tabView.getUniqueID()));
            script.Append("}");
            daPage.RegisterCacheScript(3, script.toString());
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return true;
    }
}

