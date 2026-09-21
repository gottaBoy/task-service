/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBList
 *  SA.SRFDA.Mobile.UIPart.Model.MBListConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Mobile.Web;

import SA.SRFDA.Ctrl.Data.MBList;
import SA.SRFDA.Mobile.Ctrl.DefaultMBListActionHelper;
import SA.SRFDA.Mobile.Ctrl.SRFDAMBListActionHelper;
import SA.SRFDA.Mobile.UIPart.Model.MBListConfig;
import SA.SRFDA.Mobile.Web.BaseMBPanelPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public abstract class BaseMBListPanelPage
extends BaseMBPanelPage {
    protected MBList mbList = null;

    @Override
    protected void OnMBListAction(String strMBListId, String strMBCtrlId, String strAction) throws Exception {
        this.mbList = this.OnGetMBList(strMBListId, strMBCtrlId);
        MBListConfig mbListConfig = this.OnGetMBListConfig(this.mbList);
        SRFDAMBListActionHelper mbListActionHelper = this.OnGetMBListActionHelper(this.mbList, strMBCtrlId);
        mbListActionHelper.Process(this, mbListConfig, this.mbList, strMBCtrlId, strAction);
    }

    protected MBList OnGetMBList(String strMBListId, String strMBCtrlId) throws Exception {
        MBList mbList = new MBList();
        CallResult callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetMBList(strMBListId, mbList);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u79fb\u52a8\u5217\u8868\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)callResult.getErrorInfo()));
        }
        return mbList;
    }

    protected abstract MBListConfig OnGetMBListConfig(MBList var1) throws Exception;

    protected SRFDAMBListActionHelper OnGetMBListActionHelper(MBList mbList, String strMBCtrlId) throws Exception {
        DefaultMBListActionHelper defaultMBListActionHelper = new DefaultMBListActionHelper();
        return defaultMBListActionHelper;
    }
}

