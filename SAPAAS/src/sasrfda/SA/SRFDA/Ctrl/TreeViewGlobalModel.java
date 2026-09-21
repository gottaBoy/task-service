/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.DEDataCtrl.ITreeViewDataCtrl;
import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TreeViewGlobalModel
extends BaseDAGlobalModel {
    protected ITreeViewDataCtrl treeViewDataCtrl = null;
    private static final Log log = LogFactory.getLog(TreeViewGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nRenewTimer = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "TREEVIEWRENEWTIMER", this.nRenewTimer);
        if (this.nRenewTimer < 5000) {
            this.nRenewTimer = 5000;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11041000) {
            IDEDataCtrl deDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0154", "SYSTEM", null);
            if (deDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0154"));
                return callResult;
            }
            if (!(deDataCtrl instanceof ITreeViewDataCtrl)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)"DE0154"));
                return callResult;
            }
            this.treeViewDataCtrl = (ITreeViewDataCtrl)deDataCtrl;
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6a21\u578b\u7248\u672c[%1$s]\u4e0d\u80fd\u6ee1\u8db3\u6811\u89c6\u56fe\u5bf9\u8c61\u52a0\u8f7d\u8981\u6c42", (Object)this.iDAGlobalHelper.getDAModelVersion()));
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        if (this.treeViewDataCtrl == null) {
            return null;
        }
        TreeView treeView = new TreeView();
        treeView.setTREEVIEWID((String)objObjectId);
        CallResult callResult = this.treeViewDataCtrl.Get(treeView);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6811\u89c6\u56fe[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        callResult = this.treeViewDataCtrl.ListTreeNodes(treeView.getTREEVIEWID(), treeView.getTreeNodeList());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6811\u89c6\u56fe\u76f8\u5173\u8282\u70b9[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        treeView.InitTreeNodeMap();
        for (TreeNode treeNode : treeView.getTreeNodeList()) {
            callResult = this.treeViewDataCtrl.ListTreeNodeRSs(treeNode.getTREENODEID(), treeNode.getTreeNodeRSList());
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6811\u8282\u70b9[%1$s]\u5173\u7cfb\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)treeNode.getTREENODEID(), (Object)callResult.getErrorInfo()));
                return null;
            }
            treeNode.InitTreeNodeRSProcessParams();
        }
        return treeView;
    }

    protected Boolean TestObjectRenew(Object obj) {
        TreeView treeView = (TreeView)((Object)obj);
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0154", treeView.getTREEVIEWID()) != treeView.getVERSION()) {
            return true;
        }
        return false;
    }
}

