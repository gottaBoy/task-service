/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDAQueryModelUserContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Model.SearchItemConfig
 *  SA.SRFDA.Model.SearchModelConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Web.PDA;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.PDA.BasePDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ListPage
extends BasePDAPage {
    protected DataGrid gridView = null;
    protected String strGridViewId = "";
    private static final Log log = LogFactory.getLog(ListPage.class);
    protected DefaultDAQueryModelUserContext qmUserContext = null;
    protected int nTotalRowCount = -1;
    protected int nCurPageSN = -1;
    protected String strListContent = "";
    protected int nPageSize = 0;
    protected int nStartRow = -1;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        if (!this.OnGetGridView()) {
            return false;
        }
        this.strPageDataEntityId = this.OnGetDataEntityId();
        return this.LoadPageDataEntity();
    }

    protected void OnInit() {
        String strPageSize;
        super.OnInit();
        BaseDAQueryModelHelper daQueryModelHelper = null;
        String strQueryModel = this.OnGetAdditionalQueryModel();
        boolean bUserDP = this.OnGetUserDP();
        if (StringHelper.IsNullOrEmpty((String)strQueryModel)) {
            daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(this.gridView) : this.getDAModelStorage().FindDAQueryModelHelper(this.gridView);
        } else {
            daQueryModelHelper = bUserDP ? this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel, this.gridView) : this.getDAModelStorage().FindDAQueryModelHelper(strQueryModel, this.gridView);
            log.info((Object)StringHelper.Format((String)"\u8868\u683c\u67e5\u8be2 [%1$s] \u8054\u5408 [%2$s]", (Object)strQueryModel, (Object)this.gridView.getDATAGRIDID()));
        }
        if (daQueryModelHelper == null) {
            return;
        }
        this.qmUserContext = new DefaultDAQueryModelUserContext();
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.GetDAModelQueryScript(daQueryModelHelper));
        Vector<String> userConditions = new Vector<String>();
        daQueryModelHelper.FillMajorConditions(userConditions);
        this.FillDAQueryModelHelperCondition(userConditions, daQueryModelHelper);
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
        String strCountSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetCountSQL(script.toString());
        String strPageStart = this.getWebContext().GetParamValue("PAGESTART");
        if (!StringHelper.IsNullOrEmpty((String)strPageStart)) {
            try {
                this.nStartRow = Integer.parseInt(strPageStart);
            }
            catch (Exception ex) {
                this.nStartRow = -1;
            }
        }
        if (StringHelper.Length((String)(strPageSize = this.getWebContext().GetParamValue("PAGESIZE"))) != 0) {
            try {
                this.nPageSize = Integer.parseInt(strPageSize);
            }
            catch (Exception ex) {
                this.nPageSize = 0;
            }
        }
        String strSortParam = this.getWebContext().GetParamValue("SORTFIELD");
        String strSortDirection = this.getWebContext().GetParamValue("SORTDIR");
        String strPagingSQL = String.valueOf(daQueryModelHelper.GetQMDeclareScript()) + this.qmUserContext.GetQMDeclareScript() + daQueryModelHelper.GetPagingSQL(script.toString(), this.nStartRow, this.nPageSize, strSortParam, strSortDirection, "", "");
        Vector<CallParam> list = new Vector<CallParam>();
        daQueryModelHelper.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.qmUserContext.FillQMDeclareParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        daQueryModelHelper.FillCallParams(list, (ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.getWebContext().getCurUserId());
        this.SelectAndFillListContent(strCountSQL, strPagingSQL, list);
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected String OnGetAdditionalQueryModel() {
        return "";
    }

    protected boolean OnGetUserDP() {
        return StringHelper.Compare((String)this.getWebContext().getCurUserId(), (String)"SYSTEM", (boolean)true) != 0;
    }

    protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        this.FillSearchFormCondition(userConditions, daQueryModelHelper);
        this.FillURLCondition(userConditions, daQueryModelHelper);
    }

    protected void FillPickupModeCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
    }

    protected void FillURLCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        String strDERID = this.getWebContext().getSRFDERID();
        if (!StringHelper.IsNullOrEmpty((String)strDERID)) {
            String strCondition;
            ILinkDEFHelper pickupDEFHelper = null;
            for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                ILinkDEFHelper linkDEFHelper;
                if (!iDEFHelper.IsLinkDEField() || StringHelper.Compare((String)(linkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetDERId(), (String)strDERID, (boolean)true) != 0 || StringHelper.Compare((String)linkDEFHelper.GetDataType(), (String)"PICKUP", (boolean)true) != 0) continue;
                pickupDEFHelper = linkDEFHelper;
                break;
            }
            if (pickupDEFHelper == null) {
                return;
            }
            String strValue = "";
            String strParamName = "";
            String strDERIndexId = this.getWebContext().getSRFDERINDEXID();
            if (!StringHelper.IsNullOrEmpty((String)strDERIndexId)) {
                DERINDEX derIndex = new DERINDEX();
                CallResult callResult = this.getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERIndexId, (Object)callResult.getErrorInfo()));
                } else {
                    IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(derIndex.getDEID());
                    if (iDEHelper == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)derIndex.getDEID()));
                    } else {
                        strParamName = iDEHelper.GetKeyDEFHelper().getName();
                    }
                }
            } else {
                strParamName = pickupDEFHelper.GetRelatedDEFHelper().getName();
            }
            strValue = this.getWebContext().GetPostValue(strParamName);
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = this.getWebContext().GetParamValue(strParamName);
            }
            if (strValue != null) {
                strValue = strValue.trim();
            }
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                strValue = "NA";
            }
            if (!StringHelper.IsNullOrEmpty((String)(strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, (IDEFHelper)pickupDEFHelper, "", "=", strValue)))) {
                userConditions.add(strCondition);
            }
        }
    }

    protected void FillSearchFormCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
        for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
            SearchModelConfig searchModelConfig = iDEFHelper.GetSearchModel();
            if (searchModelConfig == null) continue;
            for (SearchItemConfig searchItemConfig : searchModelConfig) {
                String strCondition;
                if (!iDEFHelper.IsSupportSearchAction(searchItemConfig)) continue;
                String strFormItemId = this.getWebContext().getGlobalHelper().getDAFormItemHelper().GetSearchFormItemId(iDEFHelper, searchItemConfig);
                String strValue = this.getPage().getRequest().getParameter(strFormItemId.toLowerCase());
                if (strValue == null && (strValue = this.getWebContext().GetParamValue(strFormItemId.toUpperCase())) == null || StringHelper.IsNullOrEmpty((String)(strValue = strValue.trim())) || StringHelper.IsNullOrEmpty((String)(strCondition = daQueryModelHelper.GetConditionSQL((IDAQueryModelUserContext)this.qmUserContext, iDEFHelper, searchItemConfig, strValue = strValue.replace("\\'", "'"))))) continue;
                userConditions.add(strCondition);
            }
        }
    }

    protected String OnGetGridViewId() {
        return this.getWebContext().getSRFGridView();
    }

    protected boolean OnGetGridView() {
        String strGridViewId = this.OnGetGridViewId();
        if (!StringHelper.IsNullOrEmpty((String)strGridViewId)) {
            this.gridView = new DataGrid();
            CallResult callResult = this.getDAModelHelper().GetUserDEDataGrid(strGridViewId, this.getWebContext().getCurUserId(), this.gridView);
            if (callResult == null || callResult.getRetCode() != 0) {
                this.PageLog((Object)this, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u8868\u683c\u89c6\u56fe[%1$s]\u5931\u8d25", (Object)strGridViewId), callResult);
                return false;
            }
            this.strPageDataEntityId = this.gridView.getDEID();
            return true;
        }
        return false;
    }

    protected void SelectAndFillListContent(String strCountSQL, String strPagingSQL, Vector<CallParam> list) {
        try {
            StringBuilderEx info = new StringBuilderEx();
            info.Append("PAGING SQL\r\n%1$s\r\n", (Object)strPagingSQL);
            if (list != null) {
                int i = 0;
                while (i < list.size()) {
                    CallParam callParam = list.get(i);
                    info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    ++i;
                }
            }
            log.info((Object)info.toString());
            SelectResult selectResult = this.getWebContext().getDBCaller().CallRaw3(strCountSQL, list);
            if (selectResult == null) {
                return;
            }
            if (selectResult.getRetCode() != 0) {
                return;
            }
            if (selectResult.getSelectData().getTableCount() != 1) {
                return;
            }
            DataSet ds = selectResult.getSelectData();
            String strTotalRow = ds.getTable(0).GetRow(0).Get("TOTALROW").toString();
            this.nTotalRowCount = Integer.parseInt(strTotalRow);
            selectResult = this.getWebContext().getDBCaller().CallRaw3(strPagingSQL, list);
            if (selectResult == null) {
                return;
            }
            if (selectResult.getRetCode() != 0) {
                return;
            }
            if (selectResult.getSelectData().getTableCount() != 1) {
                return;
            }
            ds = selectResult.getSelectData();
            this.FillListContent(ds.getTable(0));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    protected void FillListContent(DataTable dataTable) {
    }

    public int GetTotalPageCount() {
        if (this.nPageSize == 0) {
            return 0;
        }
        return this.nTotalRowCount / this.nPageSize + (this.nTotalRowCount % this.nPageSize == 0 ? 0 : 1);
    }

    public int GetTotalRowCount() {
        return this.nTotalRowCount;
    }

    public int GetCurPageIndex() {
        if (this.nStartRow == -1 || this.nPageSize == -1) {
            return 1;
        }
        return this.nStartRow / this.nPageSize + 1;
    }

    public String GetListContent() {
        return this.strListContent;
    }
}

