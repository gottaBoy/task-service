/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TreeNode
 *  SA.SRFDA.Ctrl.Data.TreeNodeRS
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExTreeNodeLoadResult
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 */
package SA.SRFDA.ND.Ctrl.Tree;

import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.ND.Ctrl.INDUserModelStorage;
import SA.SRFDA.ND.Ctrl.Tree.NDTreeActionHelperEx;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExTreeNodeLoadResult;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.util.Iterator;

public class NDMoveTargetTreeActionHelper
extends NDTreeActionHelperEx {
    public static final String TREENODERSID_MYDISK = "UID_2013122510403372200212212689";
    public static final String TREENODERSID_DEPTDISK = "UID_201312251041225300112212691";

    protected void FillNDDiskTreeNodeConfig(TreeNodeConfig treeNodeConfig, NDDisk ndDisk, String strRealNodeId, TreeNode treeNode, boolean bAutoExpand) {
        IDEHelper ndDiskHelper = this.getPage().getDAModelStorage().FindDEHelper("ND0011");
        String strNodeId = treeNode.getTREENODEID();
        strNodeId = String.valueOf(strNodeId) + ";";
        strNodeId = String.valueOf(strNodeId) + ndDisk.getNDDISKID();
        if (!StringHelper.IsNullOrEmpty((String)strRealNodeId) && treeNode.getAPPENDPNODEID()) {
            strNodeId = String.valueOf(strNodeId) + ";";
            strNodeId = String.valueOf(strNodeId) + strRealNodeId;
        }
        treeNodeConfig.setID(strNodeId);
        treeNodeConfig.setText(ndDisk.getNDDISKNAME());
        if (!StringHelper.IsNullOrEmpty((String)treeNode.getICONCLS())) {
            treeNodeConfig.setIconCssClass(treeNode.getICONCLS());
        } else {
            String strIconPath = ndDiskHelper.getDataEntity().getSMALLICON();
            treeNodeConfig.setIcon(strIconPath);
        }
        treeNodeConfig.setAsyncMode(true);
        treeNodeConfig.setLeaf(treeNode.getTreeNodeRSList().size() == 0);
        treeNodeConfig.setExpand(treeNode.getEXPAND() || bAutoExpand);
        treeNodeConfig.setEnableCheck(treeNode.getENABLECHECK());
        if (treeNode.getENABLECHECK()) {
            treeNodeConfig.setChecked(treeNode.getCHECKED());
        }
        if (!StringHelper.IsNullOrEmpty((String)treeNode.getNODETYPE())) {
            treeNodeConfig.setTagValue("srfnodetype", (Object)treeNode.getNODETYPE());
        }
        treeNodeConfig.setTagValue("value", (Object)ndDisk.getOWNERID());
        treeNodeConfig.setTagValue("selecttext", (Object)ndDisk.getOWNERNAME());
    }

    protected boolean FillTreeNodeLoadResult(String strRealNodeId, TreeNodeRS treeNodeRS, SRFExTreeNodeLoadResult treeNodeLoadResult) {
        INDUserModelStorage iNDUserModelStorage;
        boolean bAutoExpand;
        TreeNode treeNode;
        String strTreeNodeRSId;
        block10: {
            strTreeNodeRSId = treeNodeRS.getTREENODERSID();
            if (StringHelper.Compare((String)strTreeNodeRSId, (String)TREENODERSID_MYDISK, (boolean)false) != 0 && StringHelper.Compare((String)strTreeNodeRSId, (String)TREENODERSID_DEPTDISK, (boolean)false) != 0) {
                return super.FillTreeNodeLoadResult(strRealNodeId, treeNodeRS, treeNodeLoadResult);
            }
            treeNode = this.getTreeView().FindTreeNode(treeNodeRS.getCTREENODEID());
            if (treeNode == null) {
                treeNodeLoadResult.setRetCode(1);
                treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", (Object)treeNodeRS.getCTREENODEID()));
                this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo());
                return false;
            }
            String strNodeFilter = this.getWebContext().GetPostValue("srfnodefilter");
            if (StringHelper.IsNullOrEmpty((String)strNodeFilter)) {
                strNodeFilter = "";
            }
            bAutoExpand = false;
            if (!StringHelper.IsNullOrEmpty((String)strNodeFilter)) {
                String strAutoExpand = this.getWebContext().GetPostValue("srfautoexpand");
                if (StringHelper.IsNullOrEmpty((String)strAutoExpand)) {
                    strAutoExpand = "";
                }
                bAutoExpand = StringHelper.Compare((String)strAutoExpand, (String)"TRUE", (boolean)true) == 0;
            }
            try {
                iNDUserModelStorage = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext());
            }
            catch (Exception exception) {
                return false;
            }
            if (StringHelper.Compare((String)strTreeNodeRSId, (String)TREENODERSID_MYDISK, (boolean)false) != 0) break block10;
            NDDisk ndDisk;
            try {
                ndDisk = iNDUserModelStorage.FindNDDisk(false);
            }
            catch (Exception exception) {
                return false;
            }
            TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
            this.FillNDDiskTreeNodeConfig(treeNodeConfig, ndDisk, strRealNodeId, treeNode, bAutoExpand);
            treeNodeLoadResult.getItems().add(TreeNodeConfig.ToJSON((TreeNodeConfig)treeNodeConfig, (boolean)this.bSimpleMode));
            return true;
        }
        try {
            if (StringHelper.Compare((String)strTreeNodeRSId, (String)TREENODERSID_DEPTDISK, (boolean)false) == 0) {
                Iterator<NDDisk> ndDisks = iNDUserModelStorage.getDeptNDDisks();
                while (ndDisks.hasNext()) {
                    NDDisk ndDisk = ndDisks.next();
                    TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                    this.FillNDDiskTreeNodeConfig(treeNodeConfig, ndDisk, strRealNodeId, treeNode, bAutoExpand);
                    treeNodeLoadResult.getItems().add(TreeNodeConfig.ToJSON((TreeNodeConfig)treeNodeConfig, (boolean)this.bSimpleMode));
                }
                return true;
            }
            return true;
        }
        catch (Exception ex) {
            treeNodeLoadResult.setRetCode(1);
            treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u6811\u8282\u70b9[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)treeNodeRS.getCTREENODEID(), (Object)ex.getMessage()));
            this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo(), (Throwable)ex);
            return false;
        }
    }
}

