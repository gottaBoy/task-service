/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.CodeEngine.CodeEngineMgr
 *  SA.SRFDA.Ctrl.DAHelperActionResult
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEFGroupDetail
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDBModelHelper
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Model.DataGridModelConfig
 *  SA.SRFDA.Model.SearchItemConfig
 *  SA.SRFDA.Model.SearchModelConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExTreeNodeLoadResult
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.CodeEngine.CodeEngineMgr;
import SA.SRFDA.Ctrl.DAHelperActionResult;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEFGroupDetail;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.DataGridModelConfig;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTreeNodeLoadResult;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import java.io.StringWriter;
import java.io.Writer;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;

public class HelperPage
extends SRFDAPage {
    private IDBModelHelper iDBModelHelper = null;
    public static final String TAG_ACTION_CREATEVIEW = "CREATEVIEW";
    public static final String TAG_ACTION_GETDATAENTITIES = "GETDATAENTITIES";
    public static final String TAG_ACTION_GETDERELATIONSHIP = "GETDERELATIONSHIP";
    public static final String TAG_ACTION_GETDEFIELD = "GETDEFIELD";
    public static final String TAG_ACTION_GETSEARCHDEFIELD = "GETSEARCHDEFIELD";
    public static final String TAG_ACTION_GETQUERYMODELSQL = "GETQUERYMODELSQL";
    public static final String TAG_ACTION_FORMATXML = "FORMATXML";
    public static final String TAG_ACTION_PUBLISHCODE = "PUBLISHCODE";
    public static final String TAG_ACTION_GETFIELDTREENODE = "GETFIELDTREENODE";
    public static final String TAG_ACTION_UPDATEAPPUITHEME = "UPDATEAPPUITHEME";
    protected DefaultDAQueryModelUserContext qmUserContext;

    public HelperPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected void OnLoadBackEnd() {
        DAHelperActionResult actionResult = new DAHelperActionResult();
        String strMajorAction = this.getWebContext().GetParamValue("MAJORACTION");
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_CREATEVIEW, (boolean)true) == 0) {
            String strDEId = this.getWebContext().getSRFDEID();
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                this.PageLog((Object)this, 1, "\u5efa\u7acb\u89c6\u56fe\u5931\u8d25\uff0c\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
                return;
            }
            IDEHelper iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5efa\u7acb\u89c6\u56fe\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId));
                return;
            }
            IDBModelHelper iDBModelHelper = this.getDBModelHelper(iDEHelper.getDataEntity());
            if (iDBModelHelper == null) {
                return;
            }
            CallResult callResult = iDBModelHelper.CreateView();
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5efa\u7acb\u89c6\u56fe\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return;
            }
            actionResult.setRetCode(0);
            this.Output(actionResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_GETDEFIELD, (boolean)true) == 0) {
            String strDEId = this.getWebContext().getSRFDEID();
            IDEHelper iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId));
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId));
                this.Output(actionResult.ToJSONString());
                return;
            }
            TreeMap<String, JSONObject> fieldJSONMap = new TreeMap<String, JSONObject>();
            for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                if (!iDEFHelper.IsUserVisible()) continue;
                JSONObject objJSON = new JSONObject();
                iDEFHelper.getDEField().FillJSONObject(objJSON);
                fieldJSONMap.put(iDEFHelper.getName(), objJSON);
            }
            for (JSONObject objJSON : fieldJSONMap.values()) {
                actionResult.getItems().add(objJSON);
            }
            actionResult.setRetCode(0);
            this.Output(actionResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_GETFIELDTREENODE, (boolean)true) == 0) {
            String strDEId = this.getWebContext().GetPostValue("deid");
            IDEHelper iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
            if (iDEHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId));
                actionResult.setRetCode(1);
                actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId));
                this.Output(actionResult.ToJSONString());
                return;
            }
            TreeMap<String, JSONObject> fieldJSONMap = new TreeMap<String, JSONObject>();
            for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                treeNodeConfig.setLeaf(true);
                treeNodeConfig.setText(StringHelper.Format((String)"%1$s [%2$s]", (Object)iDEFHelper.getLogicName(), (Object)iDEFHelper.getName()));
                treeNodeConfig.setAsyncMode(false);
                treeNodeConfig.setTagValue("defname", (Object)iDEFHelper.getName());
                treeNodeConfig.setTagValue("deflogicname", (Object)iDEFHelper.getLogicName());
                treeNodeConfig.setTagValue("defid", (Object)iDEFHelper.getId());
                treeNodeConfig.setTagValue("deid", (Object)iDEFHelper.getDEHelper().getId());
                treeNodeConfig.setDraggable(true);
                treeNodeConfig.setTagValue("allowDrop", (Object)"false");
                treeNodeConfig.setTagValue("nodetype", (Object)"defield");
                fieldJSONMap.put(iDEFHelper.getName(), TreeNodeConfig.ToJSON((TreeNodeConfig)treeNodeConfig));
            }
            SRFExTreeNodeLoadResult result = new SRFExTreeNodeLoadResult();
            for (JSONObject objJSON : fieldJSONMap.values()) {
                result.getItems().add(objJSON);
            }
            result.setRetCode(0);
            this.Output(result.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_GETSEARCHDEFIELD, (boolean)true) == 0) {
            boolean bDEFGroupSPMode;
            String strDEId = this.getWebContext().getSRFDEID();
            boolean bl = bDEFGroupSPMode = StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFDEFGROUPSPMODE"), (String)"TRUE", (boolean)true) == 0;
            if (bDEFGroupSPMode) {
                IDEDataCtrl iDEFGroupDetailDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0161", (ISRFDAWebContext)this.getWebContext());
                if (iDEFGroupDetailDataCtrl == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0161"));
                    actionResult.setRetCode(1);
                    actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0161"));
                    this.Output(actionResult.ToJSONString());
                    return;
                }
                BaseDataEntity cond = new BaseDataEntity();
                cond.SetParamValue("DEFGROUPID", (Object)strDEId);
                Vector<BaseDataEntity> defGroupDetailList = new Vector<BaseDataEntity>();
                CallResult callResult = iDEFGroupDetailDataCtrl.Select(cond, defGroupDetailList);
                if (callResult.IsError()) {
                    String strErrorInfo = StringHelper.Format((String)"\u67e5\u8be2\u5c5e\u6027\u5206\u7ec4[%1$s]\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDEId, (Object)callResult.getErrorInfo());
                    this.PageLog((Object)this, 1, strErrorInfo);
                    actionResult.setRetCode(1);
                    actionResult.setErrorInfo(strErrorInfo);
                    this.Output(actionResult.ToJSONString());
                    return;
                }
                DEFGroupDetail defGroupDetail = new DEFGroupDetail();
                for (BaseDataEntity dataEntity : defGroupDetailList) {
                    defGroupDetail.Proxy(dataEntity);
                    if (StringHelper.IsNullOrEmpty((String)defGroupDetail.getSEARCHMODEL())) continue;
                    SearchModelConfig searchModelConfig = new SearchModelConfig();
                    if (!XMLConfig.LoadFromXML((String)defGroupDetail.getSEARCHMODEL(), (XMLConfig)searchModelConfig)) continue;
                    IDEHelper iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(defGroupDetail.getDEID());
                    if (iDEHelper == null) {
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)defGroupDetail.getDEID()));
                        actionResult.setRetCode(1);
                        actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)defGroupDetail.getDEID()));
                        this.Output(actionResult.ToJSONString());
                        return;
                    }
                    IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(defGroupDetail.getDEFID());
                    if (iDEFHelper == null) {
                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)defGroupDetail.getDEFID()));
                        actionResult.setRetCode(1);
                        actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)defGroupDetail.getDEFID()));
                        this.Output(actionResult.ToJSONString());
                        return;
                    }
                    for (SearchItemConfig searchItemConfig : searchModelConfig) {
                        XMLNode formItemNode;
                        if (!iDEFHelper.IsSupportSearchAction(searchItemConfig) || (formItemNode = this.getWebContext().getGlobalHelper().getDAFormItemHelper().GetSearchFormCtrlNode(this.getPageModel(), this.getLanguage(), iDEHelper, iDEFHelper, searchItemConfig)) == null || formItemNode.getChildNodes() == null || formItemNode.getChildNodes().size() != 1) continue;
                        XMLNode ctrlItemNode = (XMLNode)formItemNode.getChildNodes().get(0);
                        JSONObject objJSON = new JSONObject();
                        String strDEFId = ctrlItemNode.getID();
                        strDEFId = strDEFId.toUpperCase();
                        strDEFId = strDEFId.replace("_" + iDEFHelper.getName() + "_", "_" + defGroupDetail.getDEFGROUPDETAILNAME().toUpperCase() + "_");
                        objJSON.put("defid", (Object)strDEFId);
                        objJSON.put("defid2", (Object)iDEFHelper.getId());
                        objJSON.put("defname", (Object)iDEFHelper.getName());
                        objJSON.put("deid", (Object)iDEHelper.getId());
                        objJSON.put("tablename", (Object)iDEHelper.GetMainTable());
                        objJSON.put("deflogicname", (Object)formItemNode.GetExtValue("CAPTION", ""));
                        actionResult.getItems().add(objJSON);
                    }
                }
            } else {
                IDEHelper iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
                if (iDEHelper == null) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId));
                    actionResult.setRetCode(1);
                    actionResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u64cd\u4f5c\u5bf9\u8c61", (Object)strDEId));
                    this.Output(actionResult.ToJSONString());
                    return;
                }
                for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                    SearchModelConfig searchModelConfig = iDEFHelper.GetSearchModel();
                    if (searchModelConfig == null) continue;
                    for (SearchItemConfig searchItemConfig : searchModelConfig) {
                        XMLNode formItemNode;
                        if (!iDEFHelper.IsSupportSearchAction(searchItemConfig) || (formItemNode = this.getWebContext().getGlobalHelper().getDAFormItemHelper().GetSearchFormCtrlNode(this.getPageModel(), this.getLanguage(), iDEHelper, iDEFHelper, searchItemConfig)) == null || formItemNode.getChildNodes() == null || formItemNode.getChildNodes().size() != 1) continue;
                        XMLNode ctrlItemNode = (XMLNode)formItemNode.getChildNodes().get(0);
                        JSONObject objJSON = new JSONObject();
                        objJSON.put("defid", (Object)ctrlItemNode.getID());
                        objJSON.put("defid2", (Object)iDEFHelper.getId());
                        objJSON.put("defname", (Object)iDEFHelper.getName());
                        objJSON.put("deid", (Object)iDEHelper.getId());
                        objJSON.put("tablename", (Object)iDEHelper.GetMainTable());
                        objJSON.put("deflogicname", (Object)formItemNode.GetExtValue("CAPTION", ""));
                        actionResult.getItems().add(objJSON);
                    }
                }
            }
            actionResult.setRetCode(0);
            this.Output(actionResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_GETQUERYMODELSQL, (boolean)true) == 0) {
            String strDEId = this.getWebContext().getSRFDEID();
            String strQueryModel = this.getWebContext().GetPostValue("querymodel");
            if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                actionResult.setRetCode(5);
                actionResult.setErrorInfo("\u7f16\u8bd1\u67e5\u8be2\u6a21\u578b\u5931\u8d25\uff0c\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
                this.PageLog((Object)this, 1, actionResult.getErrorInfo());
                this.Output(actionResult.ToJSONString());
                return;
            }
            if (StringHelper.IsNullOrEmpty((String)strQueryModel)) {
                actionResult.setRetCode(5);
                actionResult.setErrorInfo("\u7f16\u8bd1\u67e5\u8be2\u6a21\u578b\u5931\u8d25\uff0c\u6ca1\u6709\u6307\u5b9a\u67e5\u8be2\u6a21\u578b");
                this.PageLog((Object)this, 1, actionResult.getErrorInfo());
                this.Output(actionResult.ToJSONString());
                return;
            }
            DataGridModelConfig dgModelConfig = new DataGridModelConfig();
            XMLConfig.LoadFromXML((String)strQueryModel, (XMLConfig)dgModelConfig);
            BaseDAQueryModelHelper daQueryModelHelper = this.getDAModelStorage().GetDAQueryModelHelper(strDEId, dgModelConfig.getMainQueryConfig());
            if (daQueryModelHelper == null) {
                actionResult.setRetCode(1);
                actionResult.setErrorInfo("\u7f16\u8bd1\u67e5\u8be2\u6a21\u578b\u5931\u8d25");
                this.PageLog((Object)this, 1, actionResult.getErrorInfo());
                this.Output(actionResult.ToJSONString());
                return;
            }
            this.qmUserContext = new DefaultDAQueryModelUserContext();
            StringBuilderEx script = new StringBuilderEx();
            script.Append(daQueryModelHelper.GetQueryModelScript());
            Vector<String> userConditions = new Vector<String>();
            daQueryModelHelper.FillMajorConditions(userConditions);
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
            String strSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + script.toString();
            Vector list = new Vector();
            daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
            StringBuilderEx info = new StringBuilderEx();
            info.Append("Query Sql \r\n\r\n%1$s", (Object)strSQL);
            if (list != null && list.size() > 0) {
                info.Append("\r\n\r\nQuery Params \r\n\r\n");
                int i = 0;
                while (i < list.size()) {
                    CallParam callParam = (CallParam)list.get(i);
                    info.Append("\u53c2\u6570[%1$s][%2$s] \r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    ++i;
                }
            }
            actionResult.getItems().add(info.toString());
            actionResult.setRetCode(0);
            this.Output(actionResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_FORMATXML, (boolean)true) == 0) {
            String strXML = this.getWebContext().GetPostValue("xml");
            XMLNode xmlNode = XMLNode.LoadFromXML((String)strXML);
            StringBuilder sb = new StringBuilder();
            SimpleXMLWriter writer = new SimpleXMLWriter(sb);
            writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
            xmlNode.Save(writer);
            actionResult.getItems().add(sb.toString());
            actionResult.setRetCode(0);
            this.Output(actionResult.ToJSONString());
            return;
        }
        if (StringHelper.Compare((String)strMajorAction, (String)TAG_ACTION_PUBLISHCODE, (boolean)true) == 0) {
            String strKeys = this.getWebContext().GetPostValue("srfdakeys");
            String strCodeType = this.getWebContext().GetPostValue("codetype");
            CodeEngineMgr codeEngineMgr = new CodeEngineMgr();
            StringWriter writer = new StringWriter();
            codeEngineMgr.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), "", (Writer)writer);
            codeEngineMgr.GenCode(strCodeType, strKeys.split("[,]"));
            actionResult.getItems().add(writer.toString());
            actionResult.setRetCode(0);
            this.Output(actionResult.ToJSONString());
            return;
        }
        this.Output(actionResult.ToJSONString());
    }

    protected IDBModelHelper getDBModelHelper(DataEntity dataEntity) {
        if (this.iDBModelHelper != null) {
            return this.iDBModelHelper;
        }
        String strDBModelHelper = this.getWebContext().getWebExConfig().GetValue("SRFDA", "DBMODELHELPER", "");
        Object obj = ObjectHelper.Create((String)strDBModelHelper);
        if (obj == null || !(obj instanceof IDBModelHelper)) {
            return null;
        }
        this.iDBModelHelper = (IDBModelHelper)obj;
        this.iDBModelHelper.Init(dataEntity, (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        return this.iDBModelHelper;
    }
}
