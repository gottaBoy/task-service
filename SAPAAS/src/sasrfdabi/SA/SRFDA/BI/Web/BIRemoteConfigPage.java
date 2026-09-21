/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExAjaxActionResultEx
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.BIModelStorageFactory;
import SA.SRFDA.BI.Ctrl.IBIModelStorage;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExAjaxActionResultEx;

public class BIRemoteConfigPage
extends SRFDAPage {
    public static final String TAG_FOLDER_BIREPPANEL = "BIREPPANEL";

    public BIRemoteConfigPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnLoad() {
        String strFolder = this.getWebContext().GetParamValue("FOLDER");
        String strItem = this.getWebContext().GetParamValue("ITEM");
        String strItem2 = this.getWebContext().GetParamValue("ITEM2");
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_BIREPPANEL, (boolean)true) == 0) {
            SRFExAjaxActionResultEx actionResult = new SRFExAjaxActionResultEx();
            try {
                IBIModelStorage iBIModelStorage = BIModelStorageFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
                IBIRepPanelHelper iBIRepPanelHelper = iBIModelStorage.FindBIRepPanel(strItem);
                actionResult.getItemObject().put("panelmodel", (Object)iBIRepPanelHelper.getPanelModel());
            }
            catch (Exception ex) {
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u9762\u677f\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                this.PageLog((Object)this, 1, actionResult.getErrorInfo(), ex);
            }
            this.Output(actionResult.ToJSONString());
            return;
        }
    }
}

