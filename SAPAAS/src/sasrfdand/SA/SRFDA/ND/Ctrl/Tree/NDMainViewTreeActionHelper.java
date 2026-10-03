/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.ORGTreeNode
 *  SA.SRFDA.Ctrl.Data.TreeNode
 *  SA.SRFDA.Ctrl.Data.TreeNodeRS
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExTreeNodeLoadResult
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 */
package SA.SRFDA.ND.Ctrl.Tree;

import SA.SRFDA.Ctrl.Data.ORGTreeNode;
import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.ND.Ctrl.INDUserModelStorage;
import SA.SRFDA.ND.Ctrl.Tree.NDTreeActionHelperEx;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExTreeNodeLoadResult;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.util.Iterator;
import java.util.Vector;

public class NDMainViewTreeActionHelper
extends NDTreeActionHelperEx {
    public static final String TREENODETYPE_OTHERSHARE = "UID_2013121813303943700112172010";
    public static final String TREENODETYPE_MYSHARE = "UID_201312181330307800112172008";
    public static final String TREENODETYPE_RECYCLE = "UID_2013121813302075000112171966";
    public static final String TREENODETYPE_MYDISK = "UID_201312210201334300112191399";
    public static final String TREENODETYPE_DEPTDISK = "GROUPDISK";
    public static final String TREENODETYPE_DEPTDISKITEM = "UID_201312181613137500212173213";
    public static final String TREENODETYPE_ORGDISK = "ORGDISK";
    public static final String TREENODETYPE_ORGDISKITEM = "UID_2013121817194418700212174412";

    protected boolean FillTreeNodeLoadResult(String strRealNodeId, TreeNodeRS treeNodeRS, SRFExTreeNodeLoadResult treeNodeLoadResult) {
        INDUserModelStorage iNDUserModelStorage;
        IDEHelper ndDiskHelper;
        boolean bAutoExpand;
        TreeNode treeNode;
        block31: {
            if (StringHelper.Compare((String)strRealNodeId, (String)TREENODETYPE_DEPTDISK, (boolean)false) != 0 && StringHelper.Compare((String)strRealNodeId, (String)TREENODETYPE_ORGDISK, (boolean)false) != 0 && StringHelper.Compare((String)treeNodeRS.getPTREENODEID(), (String)TREENODETYPE_ORGDISKITEM, (boolean)false) != 0) {
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
            ndDiskHelper = this.getPage().getDAModelStorage().FindDEHelper("ND0011");
            try {
                iNDUserModelStorage = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext());
            }
            catch (Exception exception) {
                return false;
            }
            if (StringHelper.Compare((String)strRealNodeId, (String)TREENODETYPE_DEPTDISK, (boolean)false) != 0) break block31;
            Iterator<NDDisk> ndDisks;
            try {
                ndDisks = iNDUserModelStorage.getDeptNDDisks();
            }
            catch (Exception exception) {
                return false;
            }
            while (ndDisks.hasNext()) {
                NDDisk ndDisk = ndDisks.next();
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
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
                treeNodeLoadResult.getItems().add(TreeNodeConfig.ToJSON((TreeNodeConfig)treeNodeConfig, (boolean)this.bSimpleMode));
            }
            return true;
        }
        try {
            if (StringHelper.Compare((String)strRealNodeId, (String)TREENODETYPE_ORGDISK, (boolean)false) == 0 || StringHelper.Compare((String)treeNodeRS.getPTREENODEID(), (String)TREENODETYPE_ORGDISKITEM, (boolean)false) == 0) {
                IDEHelper orgTreeNodeHelper = this.getPage().getDAModelStorage().FindDEHelper("ORG0032");
                Vector<ORGTreeNode> orgTreeNodes = new Vector();
                CallResult callResult = null;
                if (StringHelper.Compare((String)strRealNodeId, (String)TREENODETYPE_ORGDISK, (boolean)false) == 0) {
                    callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetORGTreeRootNodes(iNDUserModelStorage.getNDORGTreeId(), orgTreeNodes);
                    if (callResult.IsError()) {
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7ec4\u7ec7\u6811[%1$s]\u6839\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)iNDUserModelStorage.getNDORGTreeId(), (Object)callResult.getErrorInfo()));
                    }
                } else {
                    callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetChildORGTreeNodes(strRealNodeId, orgTreeNodes);
                    if (callResult.IsError()) {
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7ec4\u7ec7\u6811\u8282\u70b9[%1$s]\u5b50\u8282\u70b9\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strRealNodeId, (Object)callResult.getErrorInfo()));
                    }
                }
                for (ORGTreeNode orgTreeNode : orgTreeNodes) {
                    String strIconPath;
                    boolean bHasNDDisk = false;
                    NDDisk ndDisk2 = new NDDisk();
                    callResult = this.getNDModelHelper().GetNDDiskByOwner("DEPT", orgTreeNode.getORGUNITID(), ndDisk2);
                    if (callResult.IsOk()) {
                        bHasNDDisk = true;
                    } else {
                        callResult = this.getNDModelHelper().GetNDDiskByOwner("PERSON", orgTreeNode.getORGUNITID(), ndDisk2);
                        if (callResult.IsOk()) {
                            bHasNDDisk = true;
                        }
                    }
                    TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                    String strNodeId = treeNode.getTREENODEID();
                    strNodeId = String.valueOf(strNodeId) + ";";
                    strNodeId = String.valueOf(strNodeId) + orgTreeNode.getORGTREENODEID();
                    if (!StringHelper.IsNullOrEmpty((String)strRealNodeId) && treeNode.getAPPENDPNODEID()) {
                        strNodeId = String.valueOf(strNodeId) + ";";
                        strNodeId = String.valueOf(strNodeId) + strRealNodeId;
                    }
                    treeNodeConfig.setID(strNodeId);
                    treeNodeConfig.setText(orgTreeNode.getORGUNITNAME());
                    if (!StringHelper.IsNullOrEmpty((String)treeNode.getICONCLS())) {
                        treeNodeConfig.setIconCssClass(treeNode.getICONCLS());
                    } else if (bHasNDDisk) {
                        strIconPath = ndDiskHelper.getDataEntity().getSMALLICON();
                        treeNodeConfig.setIcon(strIconPath);
                    } else {
                        strIconPath = orgTreeNodeHelper.getDataEntity().getSMALLICON();
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
                    if (bHasNDDisk) {
                        treeNodeConfig.setTagValue("value", (Object)ndDisk2.getNDDISKID());
                        treeNodeConfig.setTagValue("selecttext", (Object)ndDisk2.getNDDISKNAME());
                    }
                    treeNodeLoadResult.getItems().add(TreeNodeConfig.ToJSON((TreeNodeConfig)treeNodeConfig, (boolean)this.bSimpleMode));
                }
                return true;
            }
        }
        catch (Exception ex) {
            treeNodeLoadResult.setRetCode(1);
            treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u6811\u8282\u70b9[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)treeNodeRS.getCTREENODEID(), (Object)ex.getMessage()));
            this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo(), (Throwable)ex);
            return false;
        }
        return true;
    }
}

