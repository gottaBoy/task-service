/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TreeNode
 *  SA.SRFDA.Ctrl.Data.TreeNodeRS
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBIHierarchyDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BITreeModelStorage {
    private static final Log log = LogFactory.getLog(BITreeModelStorage.class);
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    private static BITreeModelStorage biTreeModelStroage = null;
    protected Hashtable<String, TreeView> hierarchyTreeViewMap = new Hashtable();

    public static BITreeModelStorage Current(ISRFDAGlobalHelper iDAGlobalHelper) {
        if (biTreeModelStroage != null) {
            return biTreeModelStroage;
        }
        biTreeModelStroage = new BITreeModelStorage();
        biTreeModelStroage.Init(iDAGlobalHelper);
        return biTreeModelStroage;
    }

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        return new CallResult();
    }

    public TreeView FindHierarchyTreeView(String strCubeDimensionId, String strHierarchyId) {
        Vector<BILevel> levels;
        TreeView treeView = new TreeView();
        this.hierarchyTreeViewMap.put(strHierarchyId, treeView);
        IBIHierarchyDataCtrl biHierarchyDataCtrl = (IBIHierarchyDataCtrl)this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("BI0005", "SYSTEM", null);
        if (biHierarchyDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0005"));
            return null;
        }
        TreeNode rootNode = new TreeNode();
        rootNode.setTREENODETYPE("STATIC");
        rootNode.setTREENODEID("ROOT");
        rootNode.setROOTNODE(true);
        rootNode.setTREENODENAME("\u6839\u8282\u70b9");
        treeView.getTreeNodeList().add(rootNode);
        TreeNode lastNode = rootNode;
        BIHierarchy hierarchy = new BIHierarchy();
        hierarchy.setBIHIERARCHYID(strHierarchyId);
        CallResult callResult = biHierarchyDataCtrl.Get(hierarchy);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u6790\u4f53\u7cfb[%1$s]\u9519\u8bef\uff0c%2$s", (Object)strHierarchyId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (hierarchy.getHASALL()) {
            TreeNode allNode = new TreeNode();
            allNode.setTREENODEID("HRC|" + hierarchy.getBIHIERARCHYID());
            allNode.setTREENODETYPE("STATIC");
            allNode.setROOTNODE(false);
            allNode.setTREENODENAME(hierarchy.getALLCAPTION());
            allNode.setNODEVALUE(StringHelper.Format((String)"%1$s.%2$s", (Object)hierarchy.getBIDIMENSIONNAME(), (Object)hierarchy.getBIHIERARCHYNAME()));
            allNode.setENABLECHECK(true);
            allNode.setCHECKED(true);
            treeView.getTreeNodeList().add(allNode);
            TreeNodeRS treeNodeRS = new TreeNodeRS();
            treeNodeRS.setTREENODERSID(StringHelper.Format((String)"%1$s_%2$s", (Object)lastNode.getTREENODEID(), (Object)allNode.getTREENODEID()));
            treeNodeRS.setPTREENODEID(lastNode.getTREENODEID());
            treeNodeRS.setCTREENODEID(allNode.getTREENODEID());
            lastNode.getTreeNodeRSList().add(treeNodeRS);
            lastNode.InitTreeNodeRSProcessParams();
            lastNode = allNode;
        }
        if ((callResult = biHierarchyDataCtrl.ListBILevels(strHierarchyId, levels = new Vector<BILevel>())).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u6790\u4f53\u7cfb[%1$s]\u5c42\u7ea7\u9519\u8bef\uff0c%2$s", (Object)strHierarchyId, (Object)callResult.getErrorInfo()));
            return null;
        }
        Vector<String> paramList = new Vector<String>();
        boolean bFirstLevel = true;
        for (BILevel biLevel : levels) {
            TreeNode treeNode = new TreeNode();
            treeNode.setTREENODEID("LVL|" + biLevel.getBILEVELID());
            treeNode.setTREENODETYPE("DE");
            treeNode.setDEID(hierarchy.getDEID());
            treeNode.setROOTNODE(false);
            treeNode.setTREENODENAME(biLevel.getBILEVELNAME());
            treeNode.setSORTDEFID(biLevel.getDEFID());
            treeNode.setSORTDEFNAME(biLevel.getDEFNAME());
            treeNode.setDISTINCTMODE(true);
            if (StringHelper.IsNullOrEmpty((String)biLevel.getCAPDEFID())) {
                treeNode.setKEYDEFID(biLevel.getDEFID());
                treeNode.setKEYDEFNAME(biLevel.getDEFNAME());
                treeNode.setTEXTDEFID(biLevel.getDEFID());
                treeNode.setTEXTDEFNAME(biLevel.getDEFNAME());
            } else {
                treeNode.setKEYDEFID(biLevel.getCAPDEFID());
                treeNode.setKEYDEFNAME(biLevel.getCAPDEFNAME());
                treeNode.setTEXTDEFID(biLevel.getCAPDEFID());
                treeNode.setTEXTDEFNAME(biLevel.getCAPDEFNAME());
            }
            treeNode.setAPPENDPNODEID(!bFirstLevel);
            treeNode.setENABLECHECK(true);
            treeNode.setCHECKED(true);
            treeView.getTreeNodeList().add(treeNode);
            TreeNodeRS treeNodeRS = new TreeNodeRS();
            treeNodeRS.setTREENODERSID(StringHelper.Format((String)"%1$s_%2$s", (Object)lastNode.getTREENODEID(), (Object)treeNode.getTREENODEID()));
            treeNodeRS.setPTREENODEID(lastNode.getTREENODEID());
            treeNodeRS.setCTREENODEID(treeNode.getTREENODEID());
            String strProperty = "";
            int i = 0;
            while (i < paramList.size()) {
                String strDEFName = (String)paramList.get(i);
                if (i != 0) {
                    strProperty = String.valueOf(strProperty) + "\r\n";
                }
                strProperty = String.valueOf(strProperty) + StringHelper.Format((String)"%1$s=%%%%SRFDEF(NODEID%2$s)%%%%", (Object)strDEFName, (Object)(i == 0 ? "" : Integer.valueOf(i + 1)));
                ++i;
            }
            treeNodeRS.setPROCESSPARAM(strProperty);
            lastNode.getTreeNodeRSList().add(treeNodeRS);
            lastNode.InitTreeNodeRSProcessParams();
            lastNode = treeNode;
            if (biLevel.getUNIQUEMEMBERS()) {
                paramList.clear();
            }
            if (StringHelper.IsNullOrEmpty((String)biLevel.getCAPDEFID())) {
                paramList.add(0, biLevel.getDEFNAME());
            } else {
                paramList.add(0, biLevel.getCAPDEFNAME());
            }
            bFirstLevel = false;
        }
        treeView.InitTreeNodeMap();
        this.hierarchyTreeViewMap.put(strHierarchyId, treeView);
        return treeView;
    }
}

