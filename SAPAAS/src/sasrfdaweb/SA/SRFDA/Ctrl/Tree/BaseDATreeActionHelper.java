/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.PP.PPTreePanel
 *  SA.SRFDA.Ctrl.Data.QueryModel
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.BaseDataEntityEx
 *  SA.SRFramework.DataEx.SearchCondition
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
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
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.PP.PPTreePanel;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.Tree.BaseDATreeNodeConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.BaseDataEntityEx;
import SA.SRFramework.DataEx.SearchCondition;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTreeActionHelper;
import SA.SRFramework.WebEx.SRFExTreeNodeLoadResult;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDATreeActionHelper
extends SRFExTreeActionHelper {
    private static final Log log = LogFactory.getLog(BaseDATreeActionHelper.class);
    protected DefaultDAQueryModelUserContext qmUserContext = null;
    protected PPTreePanel ppTreePanel = null;

    protected boolean OnBeforeProcess() {
        if (!super.OnBeforeProcess()) {
            return false;
        }
        BaseDataEntity pageParam = this.getPage().getAdvPageParam(this.getTree().getID().toUpperCase(), "PP_TREEPANEL");
        if (pageParam != null && pageParam instanceof PPTreePanel) {
            this.ppTreePanel = (PPTreePanel)pageParam;
        }
        return true;
    }

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }

    private String getIDKEY() {
        String strIDKEY = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isNODEIDFIELDNull()) {
            strIDKEY = this.ppTreePanel.getNODEIDFIELD();
        }
        if (StringHelper.IsNullOrEmpty((String)(strIDKEY = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.ID", strIDKEY)))) {
            strIDKEY = this.getPage().getDEHelper().GetKeyDEFHelper().getName();
        }
        return strIDKEY;
    }

    private String getPIDKEY() {
        String strPIDKEY = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isPNODEIDFIELDNull()) {
            strPIDKEY = this.ppTreePanel.getPNODEIDFIELD();
        }
        if (StringHelper.IsNullOrEmpty((String)(strPIDKEY = this.getPage().getPageParam("PAGE.TREEACTIONHELPER.PID", strPIDKEY)))) {
            strPIDKEY = "P" + this.getPage().getDEHelper().GetKeyDEFHelper().getName();
            for (IDEFHelper iDEFHelper : this.getPage().getDEHelper().GetDEFHelpers()) {
                IPickupDEFHelper iPickupDEFHelper;
                String strDEFieldId;
                if (!(iDEFHelper instanceof IPickupDEFHelper) || StringHelper.Compare((String)(strDEFieldId = this.getPage().getDEHelper().GetKeyDEFHelper().getName()), (String)(iPickupDEFHelper = (IPickupDEFHelper)iDEFHelper).GetRelatedDEFHelper().getName(), (boolean)true) != 0) continue;
                strPIDKEY = iPickupDEFHelper.getName();
            }
        }
        return strPIDKEY;
    }

    protected boolean OnLoadChildNodes(String strTreeNodeId) {
        Hashtable<String, String> paramList = new Hashtable<String, String>();
        if (StringHelper.Compare((String)"root", (String)strTreeNodeId, (boolean)true) == 0) {
            strTreeNodeId = "";
        }
        paramList.put(this.getPIDKEY(), strTreeNodeId);
        SRFExTreeNodeLoadResult treeNodeResult = this.GetTreeNodeLoadResult(paramList, this.getWebContext().getCurUserId());
        String strOutput = treeNodeResult.ToJSONString();
        this.getPage().Output(strOutput);
        return true;
    }

    protected boolean TestLeafNode(String strTreeNodeId) {
        Hashtable<String, String> paramList = new Hashtable<String, String>();
        if (StringHelper.Compare((String)"root", (String)strTreeNodeId, (boolean)true) == 0) {
            strTreeNodeId = "";
        }
        paramList.put(this.getPIDKEY(), strTreeNodeId);
        SelectResult selectResult = this.GetSelectResult(paramList);
        return selectResult.getRetCode() != 0 || selectResult.getMainTable().GetRowCount() <= 0;
    }

    protected String getExTreeNode() {
        return this.getWebContext().GetParamValue("EXTREENODEID");
    }

    protected String getCurTreeNode() {
        return this.getWebContext().GetParamValue("CURTREENODEID");
    }

    public SRFExTreeNodeLoadResult GetTreeNodeLoadResult(Hashtable paramList, String strOpPersonId) {
        String strSelectedNode;
        Hashtable<String, String> expandNodeMap = null;
        boolean bMultiSelect = this.OnGetTreeMultiSelect();
        if (!bMultiSelect && !StringHelper.IsNullOrEmpty((String)(strSelectedNode = this.getWebContext().GetPostValue("selectednode")))) {
            String strParentNodeId;
            String strCurNode = this.getWebContext().GetPostValue("node");
            expandNodeMap = new Hashtable<String, String>();
            while (StringHelper.Length((String)(strParentNodeId = this.OnGetTreeNodeParentId(strSelectedNode))) != 0 && StringHelper.Compare((String)strCurNode, (String)strParentNodeId, (boolean)true) != 0) {
                expandNodeMap.put(strParentNodeId, "");
                if (this.getTree().getTreePanelConfig().getRootNodeConfig().ContainTreeNode(strParentNodeId)) break;
                strSelectedNode = strParentNodeId;
            }
        }
        SRFExTreeNodeLoadResult result = new SRFExTreeNodeLoadResult();
        try {
            SelectResult selectResult = this.GetSelectResult(paramList);
            if (selectResult.getRetCode() == 0) {
                int nCount = selectResult.getSelectData().getTable(0).GetRowCount();
                int i = 0;
                while (i < nCount) {
                    DataRow dr = selectResult.getSelectData().getTable(0).GetRow(i);
                    if (this.IsLoadDataRow(dr)) {
                        BaseDATreeNodeConfig treeConfig = new BaseDATreeNodeConfig();
                        treeConfig.setPage(this.getPage());
                        treeConfig.setPPTreePanel(this.ppTreePanel);
                        if (treeConfig.FromDataRow(dr) && StringHelper.Compare((String)treeConfig.getID(), (String)this.getExTreeNode(), (boolean)true) != 0) {
                            if (!treeConfig.getLeaf() && this.TestLeafNode(treeConfig.getID())) {
                                treeConfig.setLeaf(true);
                            }
                            if (bMultiSelect) {
                                treeConfig.setEnableCheck(true);
                            }
                            if (expandNodeMap != null && expandNodeMap.containsKey(treeConfig.getID())) {
                                treeConfig.setExpand(true);
                            }
                            result.getItems().add(TreeNodeConfig.ToJSON((TreeNodeConfig)treeConfig));
                        }
                    }
                    ++i;
                }
            } else {
                result.setRetCode(selectResult.getRetCode());
                result.setErrorInfo(selectResult.getErrorInfo());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex.toString());
        }
        return result;
    }

    protected boolean OnGetTreeMultiSelect() {
        boolean bMultiSelect = false;
        if (this.ppTreePanel != null && !this.ppTreePanel.isMULTISELECTNull()) {
            bMultiSelect = this.ppTreePanel.getMULTISELECT();
        }
        return this.getPage().getPageParam("PAGE.TREE.MULTISELECT", bMultiSelect);
    }

    protected String OnGetTreeNodeParentId(String strShowTreeNodeId) {
        String strPId = "";
        try {
            BaseDataEntityEx obj = new BaseDataEntityEx();
            obj.SetParamValue(this.getIDKEY(), (Object)strShowTreeNodeId);
            SelectResult selectResult = this.GetSelectResult(obj.getParamList());
            if (selectResult.getRetCode() == 0 && selectResult.getMainTable().GetRowCount() > 0) {
                DataRow dr = selectResult.getSelectData().getTable(0).GetRow(0);
                obj.FromDataRow(dr);
                strPId = obj.GetParamStringValue(this.getPIDKEY(), "");
                if (StringHelper.Length((String)strPId) == 0) {
                    strPId = "root";
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex.toString());
        }
        return strPId;
    }

    protected boolean OnLoadChildNodes(TreeNodeConfig parentNodeConfig) {
        SearchCondition searchCondition = new SearchCondition();
        if (StringHelper.Compare((String)"root", (String)parentNodeConfig.getID(), (boolean)true) != 0) {
            searchCondition.SetParamValue(this.getPIDKEY(), (Object)parentNodeConfig.getID());
        } else {
            searchCondition.SetParamValue(this.getPIDKEY(), (Object)"");
        }
        searchCondition.SetMaxPageSize();
        return this.GetTreeNodeChilds(parentNodeConfig, searchCondition, this.getWebContext().getCurUserId());
    }

    public boolean GetTreeNodeChilds(TreeNodeConfig parentNodeConfig, SearchCondition condition, String strOpPersonId) {
        block7: {
            try {
                SelectResult selectResult = this.GetSelectResult(condition.getParamList());
                if (selectResult.getRetCode() == 0) {
                    int nCount = selectResult.getSelectData().getTable(0).GetRowCount();
                    int i = 0;
                    while (i < nCount) {
                        DataRow dr = selectResult.getSelectData().getTable(0).GetRow(i);
                        if (this.IsLoadDataRow(dr)) {
                            BaseDATreeNodeConfig treeConfig = new BaseDATreeNodeConfig();
                            treeConfig.setPage(this.getPage());
                            treeConfig.setPPTreePanel(this.ppTreePanel);
                            if (treeConfig.FromDataRow(dr) && StringHelper.Compare((String)treeConfig.getID(), (String)this.getExTreeNode(), (boolean)true) != 0) {
                                if (!treeConfig.getLeaf() && this.TestLeafNode(treeConfig.getID())) {
                                    treeConfig.setLeaf(true);
                                }
                                parentNodeConfig.AddChildNode((TreeNodeConfig)treeConfig);
                            }
                        }
                        ++i;
                    }
                    break block7;
                }
                return false;
            }
            catch (Exception ex) {
                log.error((Object)ex.toString());
            }
        }
        return true;
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

    private SelectResult GetSelectResult(Hashtable paramList) {
        SelectResult selectResult = new SelectResult();
        try {
            BaseDAQueryModelHelper daQueryModelHelper = null;
            String strQueryModel = this.OnGetAdditionalQueryModel();
            boolean bUserDP = this.OnGetUserDP();
            if (StringHelper.IsNullOrEmpty((String)strQueryModel)) {
                QueryModel queryModel = new QueryModel();
                queryModel.setQUERYMODELID(StringHelper.Format((String)"TREEQM_%1$s_%2$s", (Object)this.getPage().getDEHelper().getId(), (Object)this.getPage().getDEHelper().getVersion()));
                queryModel.setQMVERSION(this.getPage().getDEHelper().getVersion());
                queryModel.setQUERYMODEL("<?xml version=\"1.0\" encoding=\"utf-8\" ?><SRFDADATAGRIDMODEL><SRFDADGMODELCOLUMNS/><SRFDADGMODELMAINQUERY EXTSELECT=\"\" ALIAS=\"\"><SRFDADGMODELJOINQUERIES/><SRFDADGMODELGROUPLOGIC LOGICNAME=\"\u4e0e(AND)\" CONDITION=\"AND\" NOT=\"FALSE\"/></SRFDADGMODELMAINQUERY></SRFDADATAGRIDMODEL>");
                queryModel.setDEID(this.getPage().getDEHelper().getId());
                daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(queryModel) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(queryModel);
            } else {
                daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel) : this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel);
                log.info((Object)StringHelper.Format((String)"\u6811\u67e5\u8be2 [%1$s]", (Object)strQueryModel));
            }
            if (daQueryModelHelper == null) {
                selectResult.setRetCode(1);
                selectResult.setErrorInfo("\u67e5\u8be2\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u65e0\u6548");
                log.error((Object)selectResult.getErrorInfo());
                return selectResult;
            }
            this.qmUserContext = new DefaultDAQueryModelUserContext();
            StringBuilderEx script = new StringBuilderEx();
            script.Append(this.GetDAModelQueryScript(daQueryModelHelper));
            Vector<String> userConditions = new Vector<String>();
            daQueryModelHelper.FillMajorConditions(userConditions);
            this.FillDAQueryModelHelperCondition(userConditions, paramList, daQueryModelHelper);
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
            String strQueryString = daQueryModelHelper.GetSortSQL(script.toString(), this.GetTreeSortParams(), this.GetTreeMajorSortDir(), this.getPage().getPageParam("PAGE.TREE.SORT.MINOR", ""), this.getPage().getPageParam("PAGE.TREE.SORT.MINORDIR", ""));
            log.info((Object)("\u6811\u8282\u70b9\u67e5\u8be2\uff1a[" + strQueryString + "]"));
            Vector list = new Vector();
            daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            selectResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), (String)this.getPage().getDEHelper().GetDBStorage(), (String)strQueryString, list);
        }
        catch (Exception ex) {
            log.error((Object)ex.toString());
        }
        return selectResult;
    }

    protected String GetTreeSortParams() {
        String strTreeSortParams = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isMAJORSORTFIELDNull()) {
            strTreeSortParams = this.ppTreePanel.getMAJORSORTFIELD();
        }
        return StringHelper.IsNullOrEmpty((String)(strTreeSortParams = this.getPage().getPageParam("PAGE.TREE.SORT.MAJOR", strTreeSortParams))) ? this.getIDKEY() : strTreeSortParams;
    }

    protected String GetTreeMajorSortDir() {
        String strTreeSortDir = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isMAJORSORTDIRNull()) {
            strTreeSortDir = this.ppTreePanel.getMAJORSORTDIR();
        }
        strTreeSortDir = this.getPage().getPageParam("PAGE.TREE.SORT.MAJORDIR", strTreeSortDir);
        return strTreeSortDir;
    }

    protected boolean IsLoadDataRow(DataRow dr) {
        return true;
    }

    protected boolean OnGetUserDP() {
        if (StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) == 0) {
            return false;
        }
        boolean bUserDP = false;
        if (this.ppTreePanel != null && !this.ppTreePanel.isUSERDPNull()) {
            bUserDP = this.ppTreePanel.getUSERDP();
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.USERDP", bUserDP);
    }

    protected String OnGetAdditionalQueryModel() {
        String strQueryModelId = "";
        if (this.ppTreePanel != null && !this.ppTreePanel.isQUERYMODELIDNull()) {
            strQueryModelId = this.ppTreePanel.getQUERYMODELID();
        }
        return this.getPage().getPageParam("PAGE.DATAGRID.QUERYMODEL", strQueryModelId);
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }
}

