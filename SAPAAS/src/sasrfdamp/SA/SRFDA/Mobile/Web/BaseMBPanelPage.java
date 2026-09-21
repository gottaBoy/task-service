/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MBPanel
 *  SA.SRFDA.Ctrl.IDAMBConfigHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Mobile.Web;

import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.IDAMBConfigHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.Utility.StringHelper;

public abstract class BaseMBPanelPage
extends SRFDAPageEx {
    protected MBPanel mbPanel = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strMBPanelId = SRFDAWebCTXHelper.GetMBPanelId((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strMBPanelId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u79fb\u52a8\u5e94\u7528\u9762\u677f\u7f16\u53f7");
            return false;
        }
        this.mbPanel = this.getDAModelStorage().FindMBPanel(strMBPanelId);
        if (this.mbPanel == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u79fb\u52a8\u5e94\u7528\u9762\u677f\u5bf9\u8c61[%1$s]", (Object)strMBPanelId));
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!StringHelper.IsNullOrEmpty((String)this.mbPanel.getDEID()) && StringHelper.Compare((String)this.strPageDataEntityId, (String)this.mbPanel.getDEID(), (boolean)true) != 0) {
            this.strPageDataEntityId = this.mbPanel.getDEID();
            this.getWebContext().SetParamValue("SRFDEID", this.mbPanel.getDEID());
            this.PageLog((Object)this, 4, StringHelper.Format((String)"\u4f20\u5165\u5b9e\u4f53\u7f16\u53f7\u4e0e\u79fb\u52a8\u5e94\u7528\u9762\u677f\u7f16\u53f7\u4e0d\u4e00\u81f4"));
        }
        return this.LoadPageDataEntity();
    }

    protected void OnLoadBackEnd() {
        try {
            String strActionType = this.getWebContext().getActionType();
            String strAction = this.getWebContext().getAction();
            String strMBCtrlId = SRFDAWebCTXHelper.GetMBCtrlId((ISRFDAWebContext)this.getWebContext());
            if (StringHelper.Compare((String)strActionType, (String)"MBLIST", (boolean)true) == 0) {
                String strMBListId = SRFDAWebCTXHelper.GetMBListId((ISRFDAWebContext)this.getWebContext());
                this.OnMBListAction(strMBListId, strMBCtrlId, strAction);
                return;
            }
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5904\u7406\u540e\u53f0\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38"), ex);
            return;
        }
        super.OnLoadBackEnd();
    }

    protected void OnMBListAction(String strMBListId, String strMBCtrlId, String strAction) throws Exception {
        throw new Exception("\u6ca1\u6709\u6267\u884c\u540e\u53f0\u64cd\u4f5c");
    }

    public IDAMBConfigHelper getDAMBConfigHelper() throws Exception {
        return this.getDAMBConfigHelper(null);
    }

    public IDAMBConfigHelper getDAMBConfigHelper(IDEHelper iDEHelper) throws Exception {
        if (iDEHelper != null) {
            return iDEHelper.GetDAMBConfigHelper(this.getLanguage(), this.strPageModel);
        }
        if (this.getDEHelper() != null) {
            return this.getDEHelper().GetDAMBConfigHelper(this.getLanguage(), this.strPageModel);
        }
        return this.getWebContext().getGlobalHelper().getDAMBConfigHelper(this.getLanguage(), this.strPageModel);
    }
}

