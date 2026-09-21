/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class FormDesignerPage
extends SRFDAPage {
    public FormDesignerPage() {
        this.setJSCache(false);
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    public String GetDEID() {
        return this.getWebContext().getSRFDEID();
    }

    public String GetCtrlID() {
        return this.getWebContext().GetParamValue("SRFCTRLID");
    }

    public boolean GetSearchFormMode() {
        String strSFMode = this.getWebContext().GetParamValue("SRFSFMODE");
        return StringHelper.Compare((String)strSFMode, (String)"TRUE", (boolean)true) == 0;
    }

    public boolean GetDEFGroupSPMode() {
        String strDEFGroupSFMode = this.getWebContext().GetParamValue("SRFDEFGROUPSFMODE");
        return StringHelper.Compare((String)strDEFGroupSFMode, (String)"TRUE", (boolean)true) == 0;
    }

    public String OutputDEFName2DEFIdCode() {
        IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(this.GetDEID());
        StringBuilderEx sb = new StringBuilderEx();
        for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
            sb.Append("if(name=='%1$s')return '%2$s';\r\n", (Object)iDEFHelper.getName(), (Object)iDEFHelper.getId());
        }
        return sb.toString();
    }
}

