/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.TreeNode
 *  SA.SRFDA.Ctrl.Data.TreeNodeRS
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.Utility.MacroHelper
 *  SA.SRFDA.Web.ISRFDAPage
 *  SA.SRFDA.Web.ISRFDATreeActionHelperEx
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ProcParam
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.SRFExTreeActionHelper
 *  SA.SRFramework.WebEx.SRFExTreeNodeLoadResult
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Tree;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.ISRFDATreeActionHelperEx;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ProcParam;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExTreeActionHelper;
import SA.SRFramework.WebEx.SRFExTreeNodeLoadResult;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDATreeActionHelperEx
extends SRFExTreeActionHelper
implements ISRFDATreeActionHelperEx {
    private static final Log log = LogFactory.getLog(BaseDATreeActionHelperEx.class);
    protected DefaultDAQueryModelUserContext qmUserContext = null;
    public static final String SEPARATOR = ";";
    protected boolean bRetFullMode = false;
    protected boolean bSimpleMode = false;
    private TreeView treeView = null;

    protected boolean OnBeforeProcess() {
        this.bRetFullMode = !StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel());
        this.bSimpleMode = !StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel());
        return super.OnBeforeProcess();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean OnLoadChildNodes(String strTreeNodeId) {
        SRFExTreeNodeLoadResult treeNodeLoadResult = new SRFExTreeNodeLoadResult();
        try {
            String strRealNodeId = "";
            TreeNode treeNode = null;
            boolean bRootSelect = false;
            String strRootSelectNode = this.getWebContext().GetPostValue("srfnodeselect");
            if (StringHelper.Compare((String)"root", (String)strTreeNodeId, (boolean)true) == 0) {
                treeNode = this.getTreeView().getRootTreeNode();
                strRealNodeId = "";
                bRootSelect = this.getTreeView().getROOTSELECT();
            } else {
                int nPos = strTreeNodeId.indexOf(SEPARATOR);
                if (nPos == -1) {
                    treeNodeLoadResult.setRetCode(1);
                    treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", (Object)strTreeNodeId));
                    this.getPage().Output(treeNodeLoadResult.ToJSONString(this.bRetFullMode));
                    return true;
                }
                String strNodeType = strTreeNodeId.substring(0, nPos);
                strRealNodeId = strTreeNodeId.substring(nPos + 1);
                treeNode = this.getTreeView().FindTreeNode(strNodeType);
            }
            if (treeNode == null) {
                treeNodeLoadResult.setRetCode(1);
                treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", (Object)strTreeNodeId));
                this.getPage().Output(treeNodeLoadResult.ToJSONString(this.bRetFullMode));
                return true;
            }
            for (TreeNodeRS treeNodeRS : treeNode.getTreeNodeRSList()) {
                if (!treeNodeRS.isVALIDFLAGNull() && !treeNodeRS.getVALIDFLAG() || treeNodeRS.getTreeNodeRSSelector() != null && !treeNodeRS.getTreeNodeRSSelector().Test((ISRFDAWebContext)this.getWebContext(), this.getTreeView())) continue;
                if (bRootSelect) {
                    if (!StringHelper.IsNullOrEmpty((String)strRootSelectNode) && StringHelper.Compare((String)strRootSelectNode, (String)treeNodeRS.getCTREENODEID(), (boolean)true) != 0) continue;
                    this.FillTreeNodeLoadResult(strRealNodeId, treeNodeRS, treeNodeLoadResult);
                    this.getPage().Output(treeNodeLoadResult.ToJSONString(this.bRetFullMode));
                    return true;
                }
                if (this.FillTreeNodeLoadResult(strRealNodeId, treeNodeRS, treeNodeLoadResult)) continue;
                this.getPage().Output(treeNodeLoadResult.ToJSONString(this.bRetFullMode));
                return true;
            }
        }
        catch (Exception ex) {
            treeNodeLoadResult.setRetCode(1);
            treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u6811\u8282\u70b9[%1$s]\u52a0\u8f7d\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strTreeNodeId, (Object)ex.getMessage()));
            log.error((Object)treeNodeLoadResult.getErrorInfo(), (Throwable)ex);
        }
        this.getPage().Output(treeNodeLoadResult.ToJSONString(this.bRetFullMode));
        return true;
    }

    protected boolean FillTreeNodeLoadResult(String strRealNodeId, TreeNodeRS treeNodeRS, SRFExTreeNodeLoadResult treeNodeLoadResult) {
        TreeNode treeNode = this.getTreeView().FindTreeNode(treeNodeRS.getCTREENODEID());
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
        boolean bAutoExpand = false;
        if (!StringHelper.IsNullOrEmpty((String)strNodeFilter)) {
            String strAutoExpand = this.getWebContext().GetPostValue("srfautoexpand");
            if (StringHelper.IsNullOrEmpty((String)strAutoExpand)) {
                strAutoExpand = "";
            }
            boolean bl = bAutoExpand = StringHelper.Compare((String)strAutoExpand, (String)"TRUE", (boolean)true) == 0;
        }
        if (StringHelper.Compare((String)treeNode.getTREENODETYPE(), (String)"STATIC", (boolean)true) == 0) {
            TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
            String strNodeId = treeNode.getTREENODEID();
            if (!StringHelper.IsNullOrEmpty((String)treeNode.getNODEVALUE())) {
                strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                strNodeId = String.valueOf(strNodeId) + treeNode.getNODEVALUE();
            }
            if (!StringHelper.IsNullOrEmpty((String)strRealNodeId) && (treeNode.getAPPENDPNODEID() || StringHelper.IsNullOrEmpty((String)treeNode.getNODEVALUE()))) {
                strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                strNodeId = String.valueOf(strNodeId) + strRealNodeId;
            }
            treeNodeConfig.setID(strNodeId);
            treeNodeConfig.setText(treeNode.getTREENODENAME());
            treeNodeConfig.setIconCssClass(treeNode.getICONCLS());
            treeNodeConfig.setAsyncMode(true);
            treeNodeConfig.setLeaf(treeNode.getTreeNodeRSList().size() == 0);
            treeNodeConfig.setExpand(treeNode.getEXPAND() || bAutoExpand);
            treeNodeConfig.setEnableCheck(treeNode.getENABLECHECK());
            if (!StringHelper.IsNullOrEmpty((String)treeNode.getNODETYPE())) {
                treeNodeConfig.setTagValue("srfnodetype", (Object)treeNode.getNODETYPE());
            }
            if (treeNode.getENABLECHECK()) {
                treeNodeConfig.setChecked(treeNode.getCHECKED());
            }
            treeNodeLoadResult.getItems().add(TreeNodeConfig.ToJSON((TreeNodeConfig)treeNodeConfig, (boolean)this.bSimpleMode));
            return true;
        }
        if (StringHelper.Compare((String)treeNode.getTREENODETYPE(), (String)"DE", (boolean)true) == 0) {
            BaseDataEntity cond = new BaseDataEntity();
            IDEDataCtrl iDataCtrl = this.getPage().GetDEDataCtrl(treeNode.getDEID());
            if (iDataCtrl == null) {
                treeNodeLoadResult.setRetCode(1);
                treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)treeNode.getDEID()));
                this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo());
                return false;
            }
            IDEFHelper keyDEFHelper = null;
            IDEFHelper textDEFHelper = null;
            String strIconDEF = "";
            keyDEFHelper = StringHelper.IsNullOrEmpty((String)treeNode.getKEYDEFID()) ? iDataCtrl.GetDEHelper().GetKeyDEFHelper() : iDataCtrl.GetDEHelper().GetDEFHelper(treeNode.getKEYDEFID());
            if (keyDEFHelper == null) {
                treeNodeLoadResult.setRetCode(1);
                treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u6811\u8282\u70b9\u6807\u8bc6\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)treeNode.getKEYDEFNAME()));
                this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo());
                return true;
            }
            textDEFHelper = StringHelper.IsNullOrEmpty((String)treeNode.getTEXTDEFID()) ? iDataCtrl.GetDEHelper().GetMajorDEFHelper() : iDataCtrl.GetDEHelper().GetDEFHelper(treeNode.getTEXTDEFID());
            if (textDEFHelper == null) {
                treeNodeLoadResult.setRetCode(1);
                treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u6811\u8282\u70b9\u6587\u672c\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)treeNode.getTEXTDEFNAME()));
                this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo());
                return true;
            }
            if (!StringHelper.IsNullOrEmpty((String)treeNode.getICONDEFID())) {
                IDEFHelper iconDEFHelper = iDataCtrl.GetDEHelper().GetDEFHelper(treeNode.getICONDEFID());
                if (iconDEFHelper == null) {
                    treeNodeLoadResult.setRetCode(1);
                    treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u6811\u8282\u70b9\u56fe\u6807\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)treeNode.getICONDEFNAME()));
                    this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo());
                    return true;
                }
                strIconDEF = iconDEFHelper.getName();
            }
            BaseDataEntity srcDataEntity = new BaseDataEntity();
            srcDataEntity.SetParamValue("NODEFILTER", (Object)strNodeFilter);
            String[] nodeid = strRealNodeId.split(SEPARATOR);
            int i = 0;
            while (i < nodeid.length) {
                if (i == 0) {
                    srcDataEntity.SetParamValue("NODEID", (Object)nodeid[i]);
                } else {
                    srcDataEntity.SetParamValue(StringHelper.Format((String)"NODEID%1$s", (Object)(i + 1)), (Object)nodeid[i]);
                }
                ++i;
            }
            CallResult callResult = this.FillDataEntity(iDataCtrl.GetDEHelper(), treeNode, treeNodeRS, srcDataEntity, cond);
            if (callResult.IsError()) {
                treeNodeLoadResult.From(callResult);
                return false;
            }
            String strSortParam = "";
            String strSortDir = "ASC";
            if (!StringHelper.IsNullOrEmpty((String)treeNode.getSORTDEFID())) {
                IDEFHelper sortDEFHelper = iDataCtrl.GetDEHelper().GetDEFHelper(treeNode.getSORTDEFID());
                if (sortDEFHelper != null) {
                    strSortParam = sortDEFHelper.GetDTColumn().GetColumnName();
                }
                if (!StringHelper.IsNullOrEmpty((String)treeNode.getSORTDIR())) {
                    strSortDir = treeNode.getSORTDIR();
                }
            }
            Vector list = new Vector();
            String strQueryModelId = "";
            if (!StringHelper.IsNullOrEmpty((String)strNodeFilter)) {
                strQueryModelId = treeNode.getFILTERQMID();
            }
            if (StringHelper.IsNullOrEmpty((String)strQueryModelId)) {
                strQueryModelId = treeNode.getQUERYMODELID();
            }
            if (StringHelper.IsNullOrEmpty((String)strQueryModelId)) {
                String strOrderInfo = "";
                if (!StringHelper.IsNullOrEmpty((String)strSortParam)) {
                    strOrderInfo = StringHelper.Format((String)" ORDER BY %1$s %2$s ", (Object)strSortParam, (Object)strSortDir);
                }
                if (treeNode.getDISTINCTMODE()) {
                    Hashtable<String, String> dictinctFieldMap = new Hashtable<String, String>();
                    dictinctFieldMap.put(keyDEFHelper.getName(), "");
                    dictinctFieldMap.put(textDEFHelper.getName(), "");
                    if (!StringHelper.IsNullOrEmpty((String)strSortParam)) {
                        dictinctFieldMap.put(strSortParam.toUpperCase(), "");
                    }
                    String strDistinct = "";
                    for (String StrField : dictinctFieldMap.keySet()) {
                        if (StringHelper.IsNullOrEmpty((String)StrField)) continue;
                        if (!StringHelper.IsNullOrEmpty((String)strDistinct)) {
                            strDistinct = String.valueOf(strDistinct) + ",";
                        }
                        strDistinct = String.valueOf(strDistinct) + StrField;
                    }
                    callResult = this.Select(iDataCtrl, cond, list, BaseDataEntity.class.getName(), strOrderInfo, strDistinct);
                } else {
                    callResult = iDataCtrl.Select(cond, list, BaseDataEntity.class.getName(), strOrderInfo);
                }
                if (callResult.IsError()) {
                    treeNodeLoadResult.From(callResult);
                    this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo());
                    return false;
                }
            } else {
                BaseDAQueryModelHelper daQueryModelHelper = null;
                boolean bUserDP = treeNode.getENABLEUP();
                if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
                    bUserDP = false;
                }
                if ((daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModelId) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModelId)) == null) {
                    treeNodeLoadResult.setRetCode(1);
                    treeNodeLoadResult.setErrorInfo("\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
                    this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo());
                    return true;
                }
                this.qmUserContext = new DefaultDAQueryModelUserContext();
                StringBuilderEx script = new StringBuilderEx();
                script.Append(this.GetDAModelQueryScript(daQueryModelHelper));
                Vector<String> userConditions = new Vector<String>();
                daQueryModelHelper.FillMajorConditions(userConditions);
                this.FillDAQueryModelHelperCondition(treeNode, userConditions, daQueryModelHelper);
                if (userConditions.size() != 0) {
                    script.Append(" WHERE ");
                    boolean bFirst = true;
                    for (String strCondition : userConditions) {
                        if (bFirst) {
                            bFirst = false;
                        } else {
                            script.Append(" AND ");
                        }
                        script.Append("(%1$s)", (Object)strCondition);
                    }
                }
                String strQuerySQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript();
                strQuerySQL = !StringHelper.IsNullOrEmpty((String)strSortParam) ? String.valueOf(strQuerySQL) + daQueryModelHelper.GetSortSQL(script.toString(), strSortParam, strSortDir, "", "") : String.valueOf(strQuerySQL) + script.toString();
                strQuerySQL = daQueryModelHelper.ReplaceURLParamMacro(strQuerySQL, (ISRFExWebContext)this.getWebContext(), true);
                Vector paramList = new Vector();
                daQueryModelHelper.FillQMDeclareParams(paramList, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId(), cond);
                this.qmUserContext.FillQMDeclareParams(paramList, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId(), cond);
                daQueryModelHelper.FillCallParams(paramList, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId(), cond);
                StringBuilderEx info = new StringBuilderEx();
                info.Append("QUERY SQL\r\n%1$s\r\n", (Object)strQuerySQL);
                if (paramList != null) {
                    int i2 = 0;
                    while (i2 < paramList.size()) {
                        CallParam callParam = (CallParam)paramList.get(i2);
                        info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i2 + 1), (Object)callParam.getParamName(), callParam.getValue());
                        ++i2;
                    }
                }
                log.info((Object)info.toString());
                BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)iDataCtrl.GetDEHelper().GetDBStorage(), (String)strQuerySQL, paramList, list, (String)BaseDataEntity.class.getName());
                if (callResult.IsError()) {
                    treeNodeLoadResult.From(callResult);
                    return false;
                }
            }
            for (BaseDataEntity dataEntity : list) {
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                String strNodeId = treeNode.getTREENODEID();
                strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                strNodeId = String.valueOf(strNodeId) + dataEntity.GetParamValue(keyDEFHelper.getName());
                if (!StringHelper.IsNullOrEmpty((String)strRealNodeId) && treeNode.getAPPENDPNODEID()) {
                    strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                    strNodeId = String.valueOf(strNodeId) + strRealNodeId;
                }
                treeNodeConfig.setID(strNodeId);
                treeNodeConfig.setText(dataEntity.GetParamStringValue(textDEFHelper.getName(), ""));
                if (!StringHelper.IsNullOrEmpty((String)treeNode.getICONCLS())) {
                    treeNodeConfig.setIconCssClass(treeNode.getICONCLS());
                } else {
                    String strIconPath = "";
                    if (!StringHelper.IsNullOrEmpty((String)strIconDEF)) {
                        strIconPath = dataEntity.GetParamStringValue(strIconDEF, "");
                    }
                    if (StringHelper.IsNullOrEmpty((String)strIconPath)) {
                        strIconPath = iDataCtrl.GetDEHelper().getDataEntity().getSMALLICON();
                    }
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
                treeNodeConfig.setTagValue("value", dataEntity.GetParamValue(keyDEFHelper.getName()));
                treeNodeConfig.setTagValue("selecttext", (Object)dataEntity.GetParamStringValue(textDEFHelper.getName(), ""));
                treeNodeLoadResult.getItems().add(TreeNodeConfig.ToJSON((TreeNodeConfig)treeNodeConfig, (boolean)this.bSimpleMode));
            }
            return true;
        }
        if (StringHelper.Compare((String)treeNode.getTREENODETYPE(), (String)"CODELIST", (boolean)true) == 0) {
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(treeNode.getCODELISTID(), this.getWebContext().getLocalization());
            if (codeListConfig == null) {
                treeNodeLoadResult.setRetCode(1);
                treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)treeNode.getCODELISTID()));
                this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo());
                this.getPage().Output(treeNodeLoadResult.ToJSONString(this.bRetFullMode));
                return true;
            }
            CodeListConfig rootCodeItemConfig = codeListConfig;
            if (rootCodeItemConfig.getCodeItems() == null) {
                return true;
            }
            int i = 0;
            while (i < rootCodeItemConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)rootCodeItemConfig.getCodeItems().get(i);
                String strNodeId = treeNode.getTREENODEID();
                strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                strNodeId = String.valueOf(strNodeId) + codeItemConfig.getValue();
                if (!StringHelper.IsNullOrEmpty((String)strRealNodeId) && treeNode.getAPPENDPNODEID()) {
                    strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                    strNodeId = String.valueOf(strNodeId) + strRealNodeId;
                }
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                treeNodeConfig.setID(strNodeId);
                treeNodeConfig.setText(codeItemConfig.getText());
                if (!StringHelper.IsNullOrEmpty((String)treeNode.getICONCLS())) {
                    treeNodeConfig.setIconCssClass(treeNode.getICONCLS());
                } else {
                    treeNodeConfig.setIcon(codeItemConfig.getIcon());
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
                treeNodeConfig.setTagValue("value", (Object)codeItemConfig.getValue());
                treeNodeConfig.setTagValue("selecttext", (Object)codeItemConfig.getText());
                treeNodeLoadResult.getItems().add(TreeNodeConfig.ToJSON((TreeNodeConfig)treeNodeConfig, (boolean)this.bSimpleMode));
                ++i;
            }
            return true;
        }
        treeNodeLoadResult.setRetCode(1);
        treeNodeLoadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6811\u8282\u70b9\u7c7b\u578b[%1$s]", (Object)treeNode.getTREENODETYPE()));
        this.getPage().Output(treeNodeLoadResult.ToJSONString(this.bRetFullMode));
        this.getPage().PageLog((Object)this, 1, treeNodeLoadResult.getErrorInfo());
        return true;
    }

    protected void FillDAQueryModelHelperCondition(TreeNode treeNode, Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    protected CallResult FillDataEntity(IDEHelper iDEHelper, TreeNode treeNode, TreeNodeRS treeNodeRS, BaseDataEntity srcDataEntity, BaseDataEntity dstDataEntity) {
        CallResult callResult = new CallResult();
        Properties properties = treeNodeRS.getProcessParams();
        if (properties == null) {
            return callResult;
        }
        Enumeration<Object> en = properties.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strMacro = PropertiesHelper.GetProperty((Properties)properties, (String)strKey);
            String strValue = strMacro;
            if (StringHelper.Compare((String)"%%SRFREMOVE()%%", (String)strValue, (boolean)true) == 0 || StringHelper.Compare((String)"%%SRFREMOVE%%", (String)strValue, (boolean)true) == 0) {
                dstDataEntity.RemoveParam(strKey);
                continue;
            }
            callResult = MacroHelper.GetValue((String)strValue, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)this.getWebContext().getCurUserId(), (BaseDataEntity)srcDataEntity);
            if (callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6307\u5b9a\u503c[%1$s],%2$s", (Object)strValue, (Object)callResult.getErrorInfo()));
                callResult.setRetCode(1);
                return callResult;
            }
            Object obj = callResult.getUserObject();
            if (obj == null) {
                dstDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            if (obj instanceof String) {
                strValue = obj.toString();
                if (StringHelper.IsNullOrEmpty((String)strValue)) {
                    if (StringHelper.Compare((String)strMacro, (String)"%%SRFDEF(NODEFILTER)%%", (boolean)true) == 0) {
                        dstDataEntity.SetParamValue(strKey, (Object)"");
                        continue;
                    }
                    dstDataEntity.SetParamValue(strKey, null);
                    continue;
                }
                IDEFHelper iDEFHelper = null;
                if (iDEHelper != null) {
                    iDEFHelper = iDEHelper.GetDEFHelper(strKey);
                }
                if (iDEFHelper != null && (obj = DataTypeParse.Parse((String)iDEFHelper.GetStdDataType(), (String)strValue)) == null) {
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8f6c\u6362\u6307\u5b9a\u503c[%1$s]\u81f3\u7c7b\u578b[%2$s]", (Object)strValue, (Object)iDEFHelper.GetStdDataType()));
                    callResult.setRetCode(1);
                    return callResult;
                }
                dstDataEntity.SetParamValue(strKey, obj);
                continue;
            }
            dstDataEntity.SetParamValue(strKey, obj);
        }
        return callResult;
    }

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, Hashtable paramList, BaseDAQueryModelHelper daQueryModelHelper) {
        this.FillURLCondition(userConditions, paramList, daQueryModelHelper);
    }

    protected void FillURLCondition(Vector<String> userConditions, Hashtable paramList, BaseDAQueryModelHelper daQueryModelHelper) {
        String strValue;
        String[] strLists = this.getWebContext().GetQueryString().split("&");
        int i = 0;
        while (i < strLists.length) {
            String[] set = strLists[i].split("=");
            if (set.length == 2) {
                try {
                    String strCondition;
                    String strName = set[0];
                    strValue = SRFExWebContext.EncodeURLParamValue((String)set[1]);
                    if (StringHelper.Length((String)strValue) != 0 && this.getPage().getDEHelper().GetDEFHelper(strName) != null && !StringHelper.IsNullOrEmpty((String)(strCondition = daQueryModelHelper.GetConditionSQL(this.getPage().getDEHelper().GetDEFHelper(strName), "", "=", strValue)))) {
                        userConditions.add(strCondition);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
        Enumeration enumeration = paramList.keys();
        while (enumeration.hasMoreElements()) {
            String strName = (String)enumeration.nextElement();
            String strCondition = "";
            if (StringHelper.Length((String)strName) == 0) continue;
            strValue = (String)paramList.get(strName);
            if (this.getPage().getDEHelper().GetDEFHelper(strName) == null) {
                strCondition = StringHelper.Length((String)strValue) == 0 ? StringHelper.Format((String)"%1$s IS NULL", (Object)strName) : StringHelper.Format((String)"%1$s = '%2$s'", (Object)strName, (Object)strValue);
            } else {
                IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(strName);
                strCondition = StringHelper.Length((String)strValue) == 0 ? daQueryModelHelper.GetConditionSQL(iDEFHelper, "", "ISNULL", strValue) : daQueryModelHelper.GetConditionSQL(iDEFHelper, "", "==", strValue);
            }
            if (StringHelper.IsNullOrEmpty((String)strCondition)) continue;
            userConditions.add(strCondition);
        }
    }

    protected boolean IsLoadDataRow(DataRow dr) {
        return true;
    }

    protected boolean OnGetUserDP() {
        if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
            return false;
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.USERDP", false);
    }

    protected String OnGetAdditionalQueryModel() {
        return this.getPage().getPageParam("PAGE.DATAGRID.QUERYMODEL", "");
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected boolean OnRemoveNode(String strTreeNodeId) {
        SRFExAjaxActionResult ajaxActionResult = new SRFExAjaxActionResult();
        int nPos = strTreeNodeId.indexOf(SEPARATOR);
        if (nPos == -1) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", (Object)strTreeNodeId));
            this.getPage().PageLog((Object)this, 1, ajaxActionResult.getErrorInfo());
            this.getPage().Output(ajaxActionResult.ToJSONString());
            return true;
        }
        String strNodeType = strTreeNodeId.substring(0, nPos);
        String strRealNodeId = strTreeNodeId.substring(nPos + 1);
        TreeNode treeNode = this.getTreeView().FindTreeNode(strNodeType);
        if (treeNode == null) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", (Object)strTreeNodeId));
            this.getPage().PageLog((Object)this, 1, ajaxActionResult.getErrorInfo());
            this.getPage().Output(ajaxActionResult.ToJSONString());
            return true;
        }
        if (!treeNode.getCMREMOVE()) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6811\u8282\u70b9[%1$s]\u6ca1\u6709\u63d0\u4f9b\u5220\u9664\u529f\u80fd", (Object)strTreeNodeId));
            this.getPage().PageLog((Object)this, 1, ajaxActionResult.getErrorInfo());
            this.getPage().Output(ajaxActionResult.ToJSONString());
            return true;
        }
        if (StringHelper.IsNullOrEmpty((String)treeNode.getREMOVEDEACTIONID())) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6811\u8282\u70b9[%1$s]\u6ca1\u6709\u63d0\u4f9b\u5220\u9664\u6267\u884c\u529f\u80fd", (Object)strTreeNodeId));
            this.getPage().PageLog((Object)this, 1, ajaxActionResult.getErrorInfo());
            this.getPage().Output(ajaxActionResult.ToJSONString());
            return true;
        }
        IDEDataCtrl iDataCtrl = this.getPage().GetDEDataCtrl(treeNode.getDEID());
        if (iDataCtrl == null) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)treeNode.getDEID()));
            this.getPage().PageLog((Object)this, 1, ajaxActionResult.getErrorInfo());
            this.getPage().Output(ajaxActionResult.ToJSONString());
            return false;
        }
        IDEFHelper keyDEFHelper = null;
        keyDEFHelper = StringHelper.IsNullOrEmpty((String)treeNode.getKEYDEFID()) ? iDataCtrl.GetDEHelper().GetKeyDEFHelper() : iDataCtrl.GetDEHelper().GetDEFHelper(treeNode.getKEYDEFID());
        if (keyDEFHelper == null) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u6811\u8282\u70b9\u6807\u8bc6\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)treeNode.getKEYDEFNAME()));
            this.getPage().PageLog((Object)this, 1, ajaxActionResult.getErrorInfo());
            this.getPage().Output(ajaxActionResult.ToJSONString());
            return true;
        }
        String[] nodeid = strRealNodeId.split(SEPARATOR);
        BaseDataEntity srcDataEntity = new BaseDataEntity();
        srcDataEntity.SetParamValue(keyDEFHelper.getName(), keyDEFHelper.GetDEFValue(nodeid[0]));
        CallResult callResult = iDataCtrl.Execute(treeNode.getREMOVEDEACTIONID(), srcDataEntity);
        if (callResult.IsError()) {
            callResult.Fill((CallResult)ajaxActionResult);
            ajaxActionResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u6811\u8282\u70b9\u51fa\u73b0\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            this.getPage().PageLog((Object)this, 1, ajaxActionResult.getErrorInfo());
            this.getPage().Output(ajaxActionResult.ToJSONString());
            return true;
        }
        callResult.Fill((CallResult)ajaxActionResult);
        this.getPage().Output(ajaxActionResult.ToJSONString());
        return true;
    }

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }

    public TreeView getTreeView() {
        if (this.treeView == null) {
            this.treeView = (TreeView)this.getPage().getPageParam("TREEVIEW");
        }
        return this.treeView;
    }

    public void setTreeView(TreeView treeView) {
        this.treeView = treeView;
    }

    public CallResult Select(IDEDataCtrl iDEDataCtrl, BaseDataEntity dataEntity, Vector list, String strObject, String strOrderInfo, String strDistinct) {
        CallResult callResult = new CallResult();
        Vector selectParams = new Vector();
        String strSQL_SELECT = iDEDataCtrl.GetDEHelper().GetSelectCode(dataEntity, selectParams);
        if (StringHelper.IsNullOrEmpty((String)strSQL_SELECT)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u591a\u884c\u67e5\u8be2\u8bed\u53e5\u65e0\u6548");
            return callResult;
        }
        Vector<CallParam> params = new Vector<CallParam>();
        for (ProcParam procParam : selectParams) {
            Object objValue = dataEntity.GetParamValue(procParam.getParamName());
            if (objValue == null) {
                callResult.setRetCode(4);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u952e\u503c[%1$s]", (Object)procParam.getParamName()));
                return callResult;
            }
            params.add(new CallParam(objValue));
        }
        if (!StringHelper.IsNullOrEmpty((String)strDistinct)) {
            strSQL_SELECT = StringHelper.Format((String)"SELECT distinct %1$s from ( %2$s ) d1", (Object)strDistinct, (Object)strSQL_SELECT);
        }
        if (!StringHelper.IsNullOrEmpty((String)strOrderInfo)) {
            strSQL_SELECT = String.valueOf(strSQL_SELECT) + " " + strOrderInfo;
        }
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)iDEDataCtrl.getGlobalHelper(), null, (String)iDEDataCtrl.GetDEHelper().GetDBStorage(), (String)strSQL_SELECT, params, (Vector)list, (String)strObject);
    }

    public TreeNodeConfig getTreeNodeConfig(ISRFDAPage iSRFDAPage, String strTreeNodeId, HashMap<String, Integer> filterMap, boolean bIncludeChild) throws Exception {
        this.page = (SRFExPage)iSRFDAPage;
        this.strTreeNodeId = strTreeNodeId;
        if (!this.OnBeforeProcess()) {
            throw new Exception("\u6267\u884c\u9884\u5904\u7406\u5931\u8d25");
        }
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setID(strTreeNodeId);
        TreeNode treeNode = null;
        boolean bRootSelect = false;
        String strRootSelectNode = this.getWebContext().GetPostValue("srfnodeselect");
        if (StringHelper.Compare((String)"root", (String)strTreeNodeId, (boolean)true) == 0) {
            treeNode = this.getTreeView().getRootTreeNode();
            bRootSelect = this.getTreeView().getROOTSELECT();
            treeNodeConfig.setText(this.getTreeView().getRootTreeNode().getTREENODENAME());
        } else {
            int nPos = strTreeNodeId.indexOf(SEPARATOR);
            if (nPos == -1) {
                throw new Exception(StringHelper.Format((String)"\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", (Object)strTreeNodeId));
            }
            String strNodeType = strTreeNodeId.substring(0, nPos);
            treeNode = this.getTreeView().FindTreeNode(strNodeType);
            treeNodeConfig.setText(treeNode.getTREENODENAME());
        }
        if (bIncludeChild) {
            this.FillChildTreeNodeConfigs(iSRFDAPage, treeNodeConfig, filterMap);
        }
        return treeNodeConfig;
    }

    protected void FillChildTreeNodeConfigs(ISRFDAPage iSRFDAPage, TreeNodeConfig treeNodeConfig, HashMap<String, Integer> filterMap) throws Exception {
        String strTreeNodeId = treeNodeConfig.getID();
        String strRealNodeId = "";
        TreeNode treeNode = null;
        boolean bRootSelect = false;
        String strRootSelectNode = this.getWebContext().GetPostValue("srfnodeselect");
        if (StringHelper.Compare((String)"root", (String)strTreeNodeId, (boolean)true) == 0) {
            treeNode = this.getTreeView().getRootTreeNode();
            strRealNodeId = "";
            bRootSelect = this.getTreeView().getROOTSELECT();
        } else {
            int nPos = strTreeNodeId.indexOf(SEPARATOR);
            if (nPos == -1) {
                throw new Exception(StringHelper.Format((String)"\u6811\u8282\u70b9[%1$s]\u6807\u8bc6\u65e0\u6548", (Object)strTreeNodeId));
            }
            String strNodeType = strTreeNodeId.substring(0, nPos);
            strRealNodeId = strTreeNodeId.substring(nPos + 1);
            treeNode = this.getTreeView().FindTreeNode(strNodeType);
        }
        if (treeNode == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", (Object)strTreeNodeId));
        }
        ArrayList<TreeNodeConfig> childTreeNodeConfigList = new ArrayList<TreeNodeConfig>();
        for (TreeNodeRS treeNodeRS : treeNode.getTreeNodeRSList()) {
            if (!treeNodeRS.isVALIDFLAGNull() && !treeNodeRS.getVALIDFLAG() || treeNodeRS.getTreeNodeRSSelector() != null && !treeNodeRS.getTreeNodeRSSelector().Test((ISRFDAWebContext)this.getWebContext(), this.getTreeView())) continue;
            if (bRootSelect) {
                if (!StringHelper.IsNullOrEmpty((String)strRootSelectNode) && StringHelper.Compare((String)strRootSelectNode, (String)treeNodeRS.getCTREENODEID(), (boolean)true) != 0) continue;
                this.FillChildTreeNodeConfigs(strRealNodeId, treeNodeRS, childTreeNodeConfigList);
                continue;
            }
            this.FillChildTreeNodeConfigs(strRealNodeId, treeNodeRS, childTreeNodeConfigList);
        }
        for (TreeNodeConfig childTreeNodeConfig : childTreeNodeConfigList) {
            if (filterMap != null && !filterMap.containsKey(childTreeNodeConfig.getID())) continue;
            treeNodeConfig.AddChildNode(childTreeNodeConfig);
            if (filterMap == null) {
                this.FillChildTreeNodeConfigs(iSRFDAPage, childTreeNodeConfig, filterMap);
                continue;
            }
            int nState = filterMap.get(childTreeNodeConfig.getID());
            if (nState != 2) continue;
            this.FillChildTreeNodeConfigs(iSRFDAPage, childTreeNodeConfig, filterMap);
        }
    }

    protected void FillChildTreeNodeConfigs(String strRealNodeId, TreeNodeRS treeNodeRS, ArrayList<TreeNodeConfig> childTreeNodeConfigList) throws Exception {
        TreeNode treeNode = this.getTreeView().FindTreeNode(treeNodeRS.getCTREENODEID());
        if (treeNode == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6811\u8282\u70b9[%1$s]", (Object)treeNodeRS.getCTREENODEID()));
        }
        String strNodeFilter = this.getWebContext().GetPostValue("srfnodefilter");
        if (StringHelper.IsNullOrEmpty((String)strNodeFilter)) {
            strNodeFilter = "";
        }
        boolean bAutoExpand = false;
        if (!StringHelper.IsNullOrEmpty((String)strNodeFilter)) {
            String strAutoExpand = this.getWebContext().GetPostValue("srfautoexpand");
            if (StringHelper.IsNullOrEmpty((String)strAutoExpand)) {
                strAutoExpand = "";
            }
            boolean bl = bAutoExpand = StringHelper.Compare((String)strAutoExpand, (String)"TRUE", (boolean)true) == 0;
        }
        if (StringHelper.Compare((String)treeNode.getTREENODETYPE(), (String)"STATIC", (boolean)true) == 0) {
            TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
            String strNodeId = treeNode.getTREENODEID();
            if (!StringHelper.IsNullOrEmpty((String)treeNode.getNODEVALUE())) {
                strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                strNodeId = String.valueOf(strNodeId) + treeNode.getNODEVALUE();
            }
            if (!StringHelper.IsNullOrEmpty((String)strRealNodeId) && (treeNode.getAPPENDPNODEID() || StringHelper.IsNullOrEmpty((String)treeNode.getNODEVALUE()))) {
                strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                strNodeId = String.valueOf(strNodeId) + strRealNodeId;
            }
            treeNodeConfig.setID(strNodeId);
            treeNodeConfig.setText(treeNode.getTREENODENAME());
            treeNodeConfig.setIconCssClass(treeNode.getICONCLS());
            treeNodeConfig.setAsyncMode(true);
            treeNodeConfig.setLeaf(treeNode.getTreeNodeRSList().size() == 0);
            treeNodeConfig.setExpand(treeNode.getEXPAND() || bAutoExpand);
            treeNodeConfig.setEnableCheck(treeNode.getENABLECHECK());
            if (!StringHelper.IsNullOrEmpty((String)treeNode.getNODETYPE())) {
                treeNodeConfig.setTagValue("srfnodetype", (Object)treeNode.getNODETYPE());
            }
            if (treeNode.getENABLECHECK()) {
                treeNodeConfig.setChecked(treeNode.getCHECKED());
            }
            childTreeNodeConfigList.add(treeNodeConfig);
            return;
        }
        if (StringHelper.Compare((String)treeNode.getTREENODETYPE(), (String)"DE", (boolean)true) == 0) {
            BaseDataEntity cond = new BaseDataEntity();
            IDEDataCtrl iDataCtrl = this.getPage().GetDEDataCtrl(treeNode.getDEID());
            if (iDataCtrl == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)treeNode.getDEID()));
            }
            IDEFHelper keyDEFHelper = null;
            IDEFHelper textDEFHelper = null;
            String strIconDEF = "";
            keyDEFHelper = StringHelper.IsNullOrEmpty((String)treeNode.getKEYDEFID()) ? iDataCtrl.GetDEHelper().GetKeyDEFHelper() : iDataCtrl.GetDEHelper().GetDEFHelper(treeNode.getKEYDEFID());
            if (keyDEFHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u6811\u8282\u70b9\u6807\u8bc6\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)treeNode.getKEYDEFNAME()));
            }
            textDEFHelper = StringHelper.IsNullOrEmpty((String)treeNode.getTEXTDEFID()) ? iDataCtrl.GetDEHelper().GetMajorDEFHelper() : iDataCtrl.GetDEHelper().GetDEFHelper(treeNode.getTEXTDEFID());
            if (textDEFHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u6811\u8282\u70b9\u6587\u672c\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)treeNode.getTEXTDEFNAME()));
            }
            if (!StringHelper.IsNullOrEmpty((String)treeNode.getICONDEFID())) {
                IDEFHelper iconDEFHelper = iDataCtrl.GetDEHelper().GetDEFHelper(treeNode.getICONDEFID());
                if (iconDEFHelper == null) {
                    throw new Exception(StringHelper.Format((String)"\u6811\u8282\u70b9\u56fe\u6807\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)treeNode.getICONDEFNAME()));
                }
                strIconDEF = iconDEFHelper.getName();
            }
            BaseDataEntity srcDataEntity = new BaseDataEntity();
            srcDataEntity.SetParamValue("NODEFILTER", (Object)strNodeFilter);
            String[] nodeid = strRealNodeId.split(SEPARATOR);
            int i = 0;
            while (i < nodeid.length) {
                if (i == 0) {
                    srcDataEntity.SetParamValue("NODEID", (Object)nodeid[i]);
                } else {
                    srcDataEntity.SetParamValue(StringHelper.Format((String)"NODEID%1$s", (Object)(i + 1)), (Object)nodeid[i]);
                }
                ++i;
            }
            CallResult callResult = this.FillDataEntity(iDataCtrl.GetDEHelper(), treeNode, treeNodeRS, srcDataEntity, cond);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u586b\u5145\u6570\u636e\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            String strSortParam = "";
            String strSortDir = "ASC";
            if (!StringHelper.IsNullOrEmpty((String)treeNode.getSORTDEFID())) {
                IDEFHelper sortDEFHelper = iDataCtrl.GetDEHelper().GetDEFHelper(treeNode.getSORTDEFID());
                if (sortDEFHelper != null) {
                    strSortParam = sortDEFHelper.GetDTColumn().GetColumnName();
                }
                if (!StringHelper.IsNullOrEmpty((String)treeNode.getSORTDIR())) {
                    strSortDir = treeNode.getSORTDIR();
                }
            }
            Vector list = new Vector();
            String strQueryModelId = "";
            if (!StringHelper.IsNullOrEmpty((String)strNodeFilter)) {
                strQueryModelId = treeNode.getFILTERQMID();
            }
            if (StringHelper.IsNullOrEmpty((String)strQueryModelId)) {
                strQueryModelId = treeNode.getQUERYMODELID();
            }
            if (StringHelper.IsNullOrEmpty((String)strQueryModelId)) {
                String strOrderInfo = "";
                if (!StringHelper.IsNullOrEmpty((String)strSortParam)) {
                    strOrderInfo = StringHelper.Format((String)" ORDER BY %1$s %2$s ", (Object)strSortParam, (Object)strSortDir);
                }
                if (treeNode.getDISTINCTMODE()) {
                    Hashtable<String, String> dictinctFieldMap = new Hashtable<String, String>();
                    dictinctFieldMap.put(keyDEFHelper.getName(), "");
                    dictinctFieldMap.put(textDEFHelper.getName(), "");
                    if (!StringHelper.IsNullOrEmpty((String)strSortParam)) {
                        dictinctFieldMap.put(strSortParam.toUpperCase(), "");
                    }
                    String strDistinct = "";
                    for (String StrField : dictinctFieldMap.keySet()) {
                        if (StringHelper.IsNullOrEmpty((String)StrField)) continue;
                        if (!StringHelper.IsNullOrEmpty((String)strDistinct)) {
                            strDistinct = String.valueOf(strDistinct) + ",";
                        }
                        strDistinct = String.valueOf(strDistinct) + StrField;
                    }
                    callResult = this.Select(iDataCtrl, cond, list, BaseDataEntity.class.getName(), strOrderInfo, strDistinct);
                } else {
                    callResult = iDataCtrl.Select(cond, list, BaseDataEntity.class.getName(), strOrderInfo);
                }
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            } else {
                BaseDAQueryModelHelper daQueryModelHelper = null;
                boolean bUserDP = treeNode.getENABLEUP();
                if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
                    bUserDP = false;
                }
                if ((daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModelId) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModelId)) == null) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548", (Object)strQueryModelId));
                }
                this.qmUserContext = new DefaultDAQueryModelUserContext();
                StringBuilderEx script = new StringBuilderEx();
                script.Append(this.GetDAModelQueryScript(daQueryModelHelper));
                Vector<String> userConditions = new Vector<String>();
                daQueryModelHelper.FillMajorConditions(userConditions);
                this.FillDAQueryModelHelperCondition(treeNode, userConditions, daQueryModelHelper);
                if (userConditions.size() != 0) {
                    script.Append(" WHERE ");
                    boolean bFirst = true;
                    for (String strCondition : userConditions) {
                        if (bFirst) {
                            bFirst = false;
                        } else {
                            script.Append(" AND ");
                        }
                        script.Append("(%1$s)", (Object)strCondition);
                    }
                }
                String strQuerySQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript();
                strQuerySQL = !StringHelper.IsNullOrEmpty((String)strSortParam) ? String.valueOf(strQuerySQL) + daQueryModelHelper.GetSortSQL(script.toString(), strSortParam, strSortDir, "", "") : String.valueOf(strQuerySQL) + script.toString();
                strQuerySQL = daQueryModelHelper.ReplaceURLParamMacro(strQuerySQL, (ISRFExWebContext)this.getWebContext(), true);
                Vector paramList = new Vector();
                daQueryModelHelper.FillQMDeclareParams(paramList, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId(), cond);
                this.qmUserContext.FillQMDeclareParams(paramList, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId(), cond);
                daQueryModelHelper.FillCallParams(paramList, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId(), cond);
                StringBuilderEx info = new StringBuilderEx();
                info.Append("QUERY SQL\r\n%1$s\r\n", (Object)strQuerySQL);
                if (paramList != null) {
                    int i2 = 0;
                    while (i2 < paramList.size()) {
                        CallParam callParam = (CallParam)paramList.get(i2);
                        info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i2 + 1), (Object)callParam.getParamName(), callParam.getValue());
                        ++i2;
                    }
                }
                log.info((Object)info.toString());
                BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)iDataCtrl.GetDEHelper().GetDBStorage(), (String)strQuerySQL, paramList, list, (String)BaseDataEntity.class.getName());
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u6570\u636e\u67e5\u8be2[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strQuerySQL, (Object)callResult.getErrorInfo()));
                }
            }
            for (BaseDataEntity dataEntity : list) {
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                String strNodeId = treeNode.getTREENODEID();
                strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                strNodeId = String.valueOf(strNodeId) + dataEntity.GetParamValue(keyDEFHelper.getName());
                if (!StringHelper.IsNullOrEmpty((String)strRealNodeId) && treeNode.getAPPENDPNODEID()) {
                    strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                    strNodeId = String.valueOf(strNodeId) + strRealNodeId;
                }
                treeNodeConfig.setID(strNodeId);
                treeNodeConfig.setText(dataEntity.GetParamStringValue(textDEFHelper.getName(), ""));
                if (!StringHelper.IsNullOrEmpty((String)treeNode.getICONCLS())) {
                    treeNodeConfig.setIconCssClass(treeNode.getICONCLS());
                } else {
                    String strIconPath = "";
                    if (!StringHelper.IsNullOrEmpty((String)strIconDEF)) {
                        strIconPath = dataEntity.GetParamStringValue(strIconDEF, "");
                    }
                    if (StringHelper.IsNullOrEmpty((String)strIconPath)) {
                        strIconPath = iDataCtrl.GetDEHelper().getDataEntity().getSMALLICON();
                    }
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
                treeNodeConfig.setTagValue("value", dataEntity.GetParamValue(keyDEFHelper.getName()));
                treeNodeConfig.setTagValue("selecttext", (Object)dataEntity.GetParamStringValue(textDEFHelper.getName(), ""));
                childTreeNodeConfigList.add(treeNodeConfig);
            }
            return;
        }
        if (StringHelper.Compare((String)treeNode.getTREENODETYPE(), (String)"CODELIST", (boolean)true) == 0) {
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig(treeNode.getCODELISTID(), this.getWebContext().getLocalization());
            if (codeListConfig == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)treeNode.getCODELISTID()));
            }
            CodeListConfig rootCodeItemConfig = codeListConfig;
            if (rootCodeItemConfig.getCodeItems() == null) {
                return;
            }
            int i = 0;
            while (i < rootCodeItemConfig.getCodeItems().size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)rootCodeItemConfig.getCodeItems().get(i);
                String strNodeId = treeNode.getTREENODEID();
                strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                strNodeId = String.valueOf(strNodeId) + codeItemConfig.getValue();
                if (!StringHelper.IsNullOrEmpty((String)strRealNodeId) && treeNode.getAPPENDPNODEID()) {
                    strNodeId = String.valueOf(strNodeId) + SEPARATOR;
                    strNodeId = String.valueOf(strNodeId) + strRealNodeId;
                }
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                treeNodeConfig.setID(strNodeId);
                treeNodeConfig.setText(codeItemConfig.getText());
                if (!StringHelper.IsNullOrEmpty((String)treeNode.getICONCLS())) {
                    treeNodeConfig.setIconCssClass(treeNode.getICONCLS());
                } else {
                    treeNodeConfig.setIcon(codeItemConfig.getIcon());
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
                treeNodeConfig.setTagValue("value", (Object)codeItemConfig.getValue());
                treeNodeConfig.setTagValue("selecttext", (Object)codeItemConfig.getText());
                childTreeNodeConfigList.add(treeNodeConfig);
                ++i;
            }
            return;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6811\u8282\u70b9\u7c7b\u578b[%1$s]", (Object)treeNode.getTREENODETYPE()));
    }
}

