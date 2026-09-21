/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl.Tree;

import SA.SRFDA.BI.Ctrl.BIModelStorageFactory;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBIModelStorage;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.BI.Web.SRFDABIWebCTXHelper;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class BIRepExDMTreeViewActionHelper
extends BaseDATreeActionHelperEx {
    protected TreeView biHierarchyTreeView = null;

    protected boolean OnBeforeProcess() {
        if (!super.OnBeforeProcess()) {
            return false;
        }
        String strBIReportExId = SRFDABIWebCTXHelper.GetBIReportExId((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strBIReportExId)) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5206\u6790\u62a5\u8868\u7f16\u53f7"));
            return false;
        }
        String strBIHIERARCHYID = this.getWebContext().GetParamValue("BIHIERARCHYID");
        if (StringHelper.IsNullOrEmpty((String)strBIReportExId)) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5206\u6790\u7ef4\u5ea6\u4f53\u7cfb"));
            return false;
        }
        try {
            IBIModelStorage iBIModelStorage = BIModelStorageFactory.Create((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
            IBIReportExHelper iBIReportExHelper = iBIModelStorage.FindBIReportEx(strBIReportExId);
            IBIHierarchyHelper iBIHierarchyHelper = iBIReportExHelper.getBICube().FindBIHierarchy(strBIHIERARCHYID);
            this.biHierarchyTreeView = iBIHierarchyHelper.getTreeView();
        }
        catch (Exception ex) {
            this.getPage().PageLog((Object)this, 1, ex.getMessage(), (Throwable)ex);
            return false;
        }
        return true;
    }

    public TreeView getTreeView() {
        return this.biHierarchyTreeView;
    }
}

