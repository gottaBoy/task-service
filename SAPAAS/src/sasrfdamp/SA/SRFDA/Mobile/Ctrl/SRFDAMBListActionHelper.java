/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBList
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Mobile.UIPart.Model.MBListConfig
 *  SA.SRFDA.Mobile.UIPart.Model.MBUIPartConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Mobile.Ctrl.SRFDAMBUIPartActionHelper;
import SA.SRFDA.Mobile.UIPart.Model.MBListConfig;
import SA.SRFDA.Mobile.UIPart.Model.MBUIPartConfig;
import SA.SRFDA.Mobile.Web.BaseMBPanelPage;
import SA.SRFramework.Utility.StringHelper;

public abstract class SRFDAMBListActionHelper
extends SRFDAMBUIPartActionHelper {
    public static final String ACTIONTYPE = "MBLIST";
    public static final String ACTION_FETCH = "fetch";
    protected MBList mbList = null;
    protected MBListConfig mbListConfig = null;

    public void Process(BaseMBPanelPage page, MBListConfig mbListConfig, MBList mbList, String strCtrlId, String strAction) throws Exception {
        IDEHelper iDEHelper = null;
        this.mbList = mbList;
        this.mbListConfig = mbListConfig;
        if (StringHelper.Compare((String)mbList.getDEID(), (String)page.getDEHelper().getId(), (boolean)true) == 0) {
            iDEHelper = page.getDEHelper();
        } else {
            iDEHelper = this.page.getDAModelStorage().FindDEHelper(mbList.getDEID());
            if (iDEHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)mbList.getDEID()));
            }
        }
        super.InitHelper(page, iDEHelper, (MBUIPartConfig)this.mbListConfig, strCtrlId);
        this.OnBeforeProcess();
        this.OnProcess(strAction);
    }

    protected void OnBeforeProcess() throws Exception {
    }

    protected void OnProcess(String strAction) throws Exception {
        if (StringHelper.Compare((String)strAction, (String)ACTION_FETCH, (boolean)true) == 0 || StringHelper.IsNullOrEmpty((String)strAction)) {
            this.OnFetchAction();
            return;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u64cd\u4f5c[%1$s]", (Object)strAction));
    }

    protected void OnFetchAction() throws Exception {
        throw new Exception("\u6ca1\u6709\u6267\u884c Fetch ");
    }
}

