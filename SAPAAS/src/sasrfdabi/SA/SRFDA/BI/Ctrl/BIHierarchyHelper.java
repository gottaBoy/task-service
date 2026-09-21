/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.TreeNode
 *  SA.SRFDA.Ctrl.Data.TreeNodeRS
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BILevelHelper;
import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIHierarchy;
import SA.SRFDA.BI.Ctrl.Data.BILevel;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.BI.Ctrl.IBIHierarchyHelper;
import SA.SRFDA.BI.Ctrl.IBILevelHelper;
import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class BIHierarchyHelper
extends BaseBIObject
implements IBIHierarchyHelper {
    private String strShortId = "";
    protected IBIDimensionHelper iBIDimensionHelper = null;
    protected BIHierarchy biHierarchy = null;
    protected TreeView treeView = null;
    protected IDEHelper iBIHierarchyDEHelper = null;
    protected Vector<IBILevelHelper> biLevels = new Vector();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IBIDimensionHelper iBIDimensionHelper, BIHierarchy biHierarchy) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iBIDimensionHelper = iBIDimensionHelper;
        this.biHierarchy = biHierarchy;
        this.iBIHierarchyDEHelper = iDAGlobalHelper.getDAModelStorage().FindDEHelper(biHierarchy.getDEID());
        if (this.iBIHierarchyDEHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5206\u6790\u7ef4\u5ea6\u4f53\u7cfb\u7ed1\u5b9a\u5b9e\u4f53[%1$s]", (Object)biHierarchy.getDEID()));
        }
        this.OnPrepareBILevels();
        this.OnPrepareTreeView();
        this.OnInit();
    }

    protected void OnPrepareBILevels() throws Exception {
        Vector<BILevel> list = new Vector<BILevel>();
        CallResult callResult = this.getBIModelHelper().GetBILevels(this.biHierarchy.getBIHIERARCHYID(), list);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7ef4\u5ea6\u4f53\u7cfb\u5c42\u7ea7\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        int nShortIdIndex = 0;
        for (BILevel biLevel : list) {
            IBILevelHelper iBILevelHelper = this.OnCreateBILevelHelper(biLevel);
            String strBILevelShortId = StringHelper.Format((String)"%1$sL%2$s", (Object)this.getShortId(), (Object)(++nShortIdIndex));
            iBILevelHelper.setShortId(strBILevelShortId);
            iBILevelHelper.Init(this.iDAGlobalHelper, this, biLevel);
            this.biLevels.add(iBILevelHelper);
        }
    }

    protected void OnPrepareTreeView() throws Exception {
        this.treeView = BIHierarchyHelper.GetHierarchyTreeView(this);
    }

    protected IBILevelHelper OnCreateBILevelHelper(BILevel biLevel) throws Exception {
        return new BILevelHelper();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String getShortId() {
        return this.strShortId;
    }

    @Override
    public void setShortId(String strShortId) {
        this.strShortId = strShortId;
    }

    @Override
    public String getId() {
        return this.biHierarchy.getBIHIERARCHYID();
    }

    @Override
    public String getUniqueName() {
        return StringHelper.Format((String)"%1$s.%2$s", (Object)this.iBIDimensionHelper.getUniqueName(), (Object)this.biHierarchy.getBIHIERARCHYNAME());
    }

    @Override
    public String getLogicName() {
        if (StringHelper.IsNullOrEmpty((String)this.biHierarchy.getCAPTION())) {
            return this.biHierarchy.getBIHIERARCHYNAME();
        }
        return this.biHierarchy.getCAPTION();
    }

    @Override
    public BIHierarchy getBIHierarchy() {
        return this.biHierarchy;
    }

    @Override
    public IBIDimensionHelper getIBIDimension() {
        return this.iBIDimensionHelper;
    }

    @Override
    public String getFilterType() {
        if (this.biHierarchy.isQUERYCTRLNull()) {
            return this.iBIDimensionHelper.getBIDimension().getQUERYCTRL();
        }
        return this.biHierarchy.getQUERYCTRL();
    }

    @Override
    public String getCustomFilter() {
        if (this.biHierarchy.isCUSTOMQUERYCTRLNull()) {
            return this.iBIDimensionHelper.getBIDimension().getCUSTOMQUERYCTRL();
        }
        return this.biHierarchy.getCUSTOMQUERYCTRL();
    }

    @Override
    public TreeView getTreeView() {
        return this.treeView;
    }

    @Override
    public boolean isHasAll() {
        return this.biHierarchy.getHASALL();
    }

    @Override
    public String getAllCaption() {
        return this.biHierarchy.getALLCAPTION();
    }

    @Override
    public Vector<IBILevelHelper> getBILevels() {
        return this.biLevels;
    }

    @Override
    public int getColumnWidth() {
        return 120;
    }

    public static TreeView GetHierarchyTreeView(IBIHierarchyHelper iBIHierarchyHelper) throws Exception {
        TreeView treeView = new TreeView();
        TreeNode rootNode = new TreeNode();
        rootNode.setTREENODETYPE("STATIC");
        rootNode.setTREENODEID("ROOT");
        rootNode.setROOTNODE(true);
        rootNode.setTREENODENAME("\u6839\u8282\u70b9");
        treeView.getTreeNodeList().add(rootNode);
        TreeNode lastNode = rootNode;
        BIHierarchy hierarchy = iBIHierarchyHelper.getBIHierarchy();
        if (iBIHierarchyHelper.isHasAll()) {
            TreeNode allNode = new TreeNode();
            allNode.setTREENODEID("HRC|" + iBIHierarchyHelper.getId());
            allNode.setTREENODETYPE("STATIC");
            allNode.setROOTNODE(false);
            allNode.setTREENODENAME(iBIHierarchyHelper.getAllCaption());
            allNode.setNODEVALUE(iBIHierarchyHelper.getUniqueName());
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
        Vector<IBILevelHelper> levels = iBIHierarchyHelper.getBILevels();
        Vector<String> paramList = new Vector<String>();
        boolean bFirstLevel = true;
        for (IBILevelHelper iBILevelHelper : levels) {
            BILevel biLevel = iBILevelHelper.getBILevel();
            TreeNode treeNode = new TreeNode();
            treeNode.setTREENODEID("LVL|" + iBILevelHelper.getId());
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
        return treeView;
    }

    @Override
    public String getTableName() {
        if (this.biHierarchy.getUSEVIEW()) {
            return this.iBIHierarchyDEHelper.GetDEViewName();
        }
        return this.iBIHierarchyDEHelper.GetMainTable();
    }

    @Override
    public IDEHelper getBIHierarchyDEHelper() {
        return this.iBIHierarchyDEHelper;
    }

    @Override
    public String getDataCaption(BaseDataEntity data) {
        String strDataCaption = "";
        int nLevelCnt = 0;
        for (IBILevelHelper iBILevelHelper : this.biLevels) {
            if (!data.ContainesParam(iBILevelHelper.getShortId())) {
                String strRetDataCaption = "";
                int i = 0;
                while (i < nLevelCnt) {
                    strRetDataCaption = String.valueOf(strRetDataCaption) + "    ";
                    ++i;
                }
                return String.valueOf(strRetDataCaption) + strDataCaption;
            }
            String strContent = data.GetParamStringValue(iBILevelHelper.getShortId(), null);
            if (StringHelper.IsNullOrEmpty((String)strContent)) {
                String strRetDataCaption = "";
                int i = 0;
                while (i < nLevelCnt) {
                    strRetDataCaption = String.valueOf(strRetDataCaption) + "    ";
                    ++i;
                }
                return String.valueOf(strRetDataCaption) + strDataCaption + iBILevelHelper.getAggCaption();
            }
            strDataCaption = iBILevelHelper.isUniqueMembers() ? strContent : String.valueOf(strDataCaption) + strContent;
            ++nLevelCnt;
        }
        String strRetDataCaption = "";
        int i = 0;
        while (i < nLevelCnt) {
            strRetDataCaption = String.valueOf(strRetDataCaption) + "    ";
            ++i;
        }
        return String.valueOf(strRetDataCaption) + strDataCaption;
    }

    @Override
    public String getDataKey(BaseDataEntity data) {
        String strDataKey = "";
        for (IBILevelHelper iBILevelHelper : this.biLevels) {
            if (!data.ContainesParam(iBILevelHelper.getShortId())) {
                return strDataKey;
            }
            String strContent = data.GetParamStringValue(iBILevelHelper.getShortId(), "(ALL)");
            if (!StringHelper.IsNullOrEmpty((String)strDataKey)) {
                strDataKey = String.valueOf(strDataKey) + ".";
            }
            strDataKey = String.valueOf(strDataKey) + strContent;
        }
        return strDataKey;
    }
}

