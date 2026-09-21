/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.SRFExTreeActionHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExTreeActionHelper;

public class TreeViewDataPage
extends SRFDAPage {
    protected TreeView treeView = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strTreeViewId = this.OnGetTreeView();
        if (!StringHelper.IsNullOrEmpty((String)strTreeViewId)) {
            this.treeView = this.getDAModelStorage().FindTreeView(strTreeViewId);
            if (this.treeView == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u89c6\u56fe[%1$s]", (Object)strTreeViewId));
                return false;
            }
            this.setPageParam("TREEVIEW", this.treeView);
            if (!StringHelper.IsNullOrEmpty((String)this.treeView.getDEID())) {
                this.strPageDataEntityId = this.treeView.getDEID();
            }
        }
        if (StringHelper.IsNullOrEmpty((String)this.strPageDataEntityId)) {
            this.strPageDataEntityId = this.GetDefaultPageDataEntityId();
        }
        if (!this.LoadPageDataEntity()) {
            return true;
        }
        return true;
    }

    protected void OnLoadBackEnd() {
        String strActionType = this.webContext.getActionType();
        String strAction = this.webContext.getAction();
        String strTreeId = this.webContext.getTreeId();
        if (StringHelper.IsNullOrEmpty((String)strTreeId)) {
            strTreeId = "treeid";
        }
        if (StringHelper.Length((String)strTreeId) > 0) {
            String strTreeActionHelper = this.GetTreeActionHelper();
            Object objTreeActionHelper = ObjectHelper.Create((String)strTreeActionHelper);
            if (objTreeActionHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u89c6\u56fe\u540e\u53f0\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strTreeActionHelper));
                return;
            }
            SRFExTreeActionHelper treeActionHelper = (SRFExTreeActionHelper)objTreeActionHelper;
            if (treeActionHelper.Process((SRFExPage)this, strTreeId, this.getWebContext().getTreeNode(), strAction)) {
                return;
            }
        }
    }

    protected String OnGetTreeView() {
        String strTreeViewId = SRFDAWebCTXHelper.GetTreeView((ISRFDAWebContext)this.getWebContext());
        return this.getPageParam("PAGE.TREEVIEW", strTreeViewId);
    }

    protected String GetTreeActionHelper() {
        String strTreeActionHelper = "";
        if (!StringHelper.IsNullOrEmpty((String)(strTreeActionHelper = this.getPageParam("PAGE.TREEACTIONHELPER", strTreeActionHelper)))) {
            return strTreeActionHelper;
        }
        return this.GetDefaultTreeActionHelper();
    }

    protected String GetDefaultTreeActionHelper() {
        if (this.treeView != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.treeView.getBACKENDCTRL())) {
                return this.treeView.getBACKENDCTRL();
            }
            return "SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx";
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "TREEACTIONHELPER", "");
    }
}

