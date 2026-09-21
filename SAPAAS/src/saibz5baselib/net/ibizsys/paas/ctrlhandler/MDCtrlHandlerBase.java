/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlhandler.IMDCtrlHandler;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.IDEDataExportModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.AccessDenyException;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.security.IUserRoleMgr2;
import net.ibizsys.paas.util.DEDataExportHelper;
import net.ibizsys.paas.util.DEDataImportTemplateHelper;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public abstract class MDCtrlHandlerBase
extends CtrlHandlerBase
implements IMDCtrlHandler {
    private boolean bEnableUserSort = true;
    private String strMinorSortField = "";
    private String strMinorSortDir = "";
    private int nDefaultPageSize = -1;
    private boolean bEnableOrgDR = false;
    private boolean bEnableSecDR = false;
    private boolean bEnableSecBC = false;
    private long nOrgDR = 0L;
    private long nSecDR = 0L;
    private String strSecBC = "";
    private boolean bEnableUserDR = false;
    private String strUserDRAction = "READ";
    private boolean bEnableItemPriv = false;
    private String strCustomDRMode = null;
    private String strCustomDRMode2 = null;
    private String strCustomDRModeParam = null;
    private String strCustomDRMode2Param = null;
    private String strDEDataExportId = null;
    private int nMaxExportRowCount = 1000;
    private String strActiveDataDELogicId = null;

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.isNullOrEmpty(strAction)) {
            return this.createFetchActionResult();
        }
        if (StringHelper.compare(strAction, "fetch", true) == 0) {
            return this.onFetch();
        }
        if (StringHelper.compare(strAction, "exportdata", true) == 0) {
            return this.onExportData();
        }
        if (StringHelper.compare(strAction, "remove", true) == 0) {
            return this.onRemove();
        }
        if (StringHelper.compare(strAction, "addbatch", true) == 0) {
            return this.onAddBatch();
        }
        if (StringHelper.compare(strAction, "uiaction", true) == 0) {
            return this.onUIAction();
        }
        if (StringHelper.compare(strAction, "loaduiaction", true) == 0) {
            return this.onLoadUIAction();
        }
        if (StringHelper.compare(strAction, "exportmodel", true) == 0) {
            return this.onExportModel();
        }
        if (StringHelper.compare(strAction, "exportimptempl", true) == 0) {
            return this.onExportImpTempl();
        }
        if (StringHelper.compare(strAction, "itemtip", true) == 0) {
            return this.onItemTip();
        }
        return super.onProcessAction(strAction);
    }

    protected MDAjaxActionResult createFetchActionResult() {
        return new MDAjaxActionResult();
    }

    protected AjaxActionResult onFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = this.createFetchActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
        deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
        IMDCtrlRender iMDCtrlRender = this.getMDCtrlRender();
        if (iMDCtrlRender != null) {
            iMDCtrlRender.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
        }
        if (!StringHelper.isNullOrEmpty(this.getActiveDataDELogicId())) {
            Object activeData = this.getService().getDEModel().createEntity();
            this.getService().executeLogic(this.getActiveDataDELogicId(), (IEntity)activeData);
            deDataSetFetchContextImpl.setActiveDataObject((ISimpleDataObject)activeData);
        }
        if (!this.isEnableUserSort()) {
            deDataSetFetchContextImpl.resetSortInfo();
        }
        if (!StringHelper.isNullOrEmpty(this.getMinorSortField())) {
            deDataSetFetchContextImpl.setSort2(this.getMinorSortField());
            deDataSetFetchContextImpl.setSort2Dir(this.getMinorSortDir());
        }
        if (this.getDefaultPageSize() > 0) {
            deDataSetFetchContextImpl.setDefaultPageSize(this.getDefaultPageSize());
        }
        this.fillFetchConditions(deDataSetFetchContextImpl);
        this.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
        if (deDataSetFetchContextImpl.isCancel()) {
            mdAjaxActionResult.setTotalRow(0);
            mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
            mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
            return mdAjaxActionResult;
        }
        this.fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);
        DBFetchResult fetchResult = this.fetchDEDataSet(deDataSetFetchContextImpl);
        mdAjaxActionResult.setTotalRow(fetchResult.getTotalRow());
        mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
        mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
        this.fillFetchResult(mdAjaxActionResult, fetchResult.getDataSet().getDataTable(0));
        fetchResult.getDataSet().close();
        return mdAjaxActionResult;
    }

    protected AjaxActionResult onExportData() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = this.createFetchActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
        deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
        IMDCtrlRender iMDCtrlRender = this.getMDCtrlRender();
        if (iMDCtrlRender != null) {
            iMDCtrlRender.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
        }
        if (!StringHelper.isNullOrEmpty(this.getActiveDataDELogicId())) {
            Object activeData = this.getService().getDEModel().createEntity();
            this.getService().executeLogic(this.getActiveDataDELogicId(), (IEntity)activeData);
            deDataSetFetchContextImpl.setActiveDataObject((ISimpleDataObject)activeData);
        }
        if (!this.isEnableUserSort()) {
            deDataSetFetchContextImpl.resetSortInfo();
        }
        if (!StringHelper.isNullOrEmpty(this.getMinorSortField())) {
            deDataSetFetchContextImpl.setSort2(this.getMinorSortField());
            deDataSetFetchContextImpl.setSort2Dir(this.getMinorSortDir());
        }
        if (this.getDefaultPageSize() > 0) {
            deDataSetFetchContextImpl.setDefaultPageSize(this.getDefaultPageSize());
        }
        this.fillFetchConditions(deDataSetFetchContextImpl);
        this.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
        if (deDataSetFetchContextImpl.isCancel()) {
            mdAjaxActionResult.setTotalRow(0);
            mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
            mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
            return mdAjaxActionResult;
        }
        this.fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);
        DBFetchResult fetchResult = this.fetchDEDataSet(deDataSetFetchContextImpl);
        mdAjaxActionResult.setTotalRow(fetchResult.getTotalRow());
        mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
        mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
        this.fillExportFileEx(mdAjaxActionResult, fetchResult.getDataSet().getDataTable(0), "EXCEL");
        fetchResult.getDataSet().close();
        return mdAjaxActionResult;
    }

    protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected void fillExportFileEx(MDAjaxActionResult fetchResult, IDataTable dt, String strType) throws Exception {
        if (!StringHelper.isNullOrEmpty(this.getDEDataExportId())) {
            String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date());
            if (StringHelper.compare(strType, "EXCEL", true) == 0) {
                IDEDataExport iDEDataExport = this.getDEModel().getDEDataExport(this.getDEDataExportId());
                String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".xls");
                DEDataExportHelper.output(strTempFilePath, dt, (IDEDataExportModel)iDEDataExport, this.getWebContext(), this.isEnableItemPriv());
                String strDownloadTmpFileUrl = this.getViewController().getAppModel().getUtilPageUrl("DOWNLOADTMPFILE");
                String strDownloadUrl = StringHelper.format("%1$sFILEID=%2$s", strDownloadTmpFileUrl, WebUtility.encodeURLParamValue(String.valueOf(strTempFileName) + ".xls"));
                fetchResult.setDownloadPath(strDownloadUrl);
                return;
            }
            return;
        }
        this.fillExportFile(fetchResult, dt, strType);
    }

    protected void fillExportFile(MDAjaxActionResult fetchResult, IDataTable dt, String strType) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected AjaxActionResult onAddBatch() throws Exception {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
        String strKeys = WebContext.getKeys(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strKeys)) {
            strKeys = WebContext.getKey(this.getWebContext());
        }
        if (StringHelper.isNullOrEmpty(strKeys)) {
            ajaxActionResult.setRetCode(4);
            return ajaxActionResult;
        }
        String[] keys = strKeys.split("[;]");
        this.addEntities(keys);
        return ajaxActionResult;
    }

    protected AjaxActionResult onRemove() throws Exception {
        MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
        String strKeys = WebContext.getKeys(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strKeys)) {
            strKeys = WebContext.getKey(this.getWebContext());
        }
        if (StringHelper.isNullOrEmpty(strKeys)) {
            ajaxActionResult.setRetCode(4);
            return ajaxActionResult;
        }
        String[] keys = strKeys.split("[;]");
        String strDataAccessAction = this.getDataAccessAction("remove");
        CallResult callResult = this.testDataAccessAction(strDataAccessAction);
        if (!callResult.isOk()) {
            ajaxActionResult.setRetCode(2);
            ajaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return ajaxActionResult;
        }
        String[] stringArray = keys;
        int n = keys.length;
        int n2 = 0;
        while (n2 < n) {
            String strKey = stringArray[n2];
            IEntity iEntity = this.getSimpleEntity(strKey);
            if (iEntity != null && !(callResult = this.testDataAccessAction(iEntity, strDataAccessAction)).isOk()) {
                ajaxActionResult.setRetCode(2);
                ajaxActionResult.setErrorInfo(callResult.getErrorInfo());
                return ajaxActionResult;
            }
            ++n2;
        }
        this.removeEntities(keys);
        ajaxActionResult.setReloadData(true);
        return ajaxActionResult;
    }

    protected void removeEntities(String[] keys) throws Exception {
        String[] stringArray = keys;
        int n = keys.length;
        int n2 = 0;
        while (n2 < n) {
            String strKey = stringArray[n2];
            this.removeEntity(strKey);
            ++n2;
        }
    }

    protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        this.onFillDEDataSetFetchContext(deDataSetFetchContextImpl);
    }

    protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    protected void fillFetchConditions(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        if (this.getTempMode() != 0 || WebContext.isTempMode(this.getWebContext())) {
            this.onFillTempDataConditions(deDataSetFetchContextImpl.getConditionList());
        }
        this.onFillFetchSearchFormCSMConditions(deDataSetFetchContextImpl.getConditionList());
        this.onFillFetchSearchFormConditions(deDataSetFetchContextImpl.getConditionList());
        this.onFillFetchURLConditions(deDataSetFetchContextImpl.getConditionList());
    }

    protected void onFillTempDataConditions(ArrayList<IDEDataSetCond> userConditions) {
        DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
        deDataSetCondImpl.setCondType("CUSTOM");
        deDataSetCondImpl.setCustomCond("t1.SRFDRAFTFLAG = 0");
        userConditions.add(deDataSetCondImpl);
    }

    protected void onFillFetchURLConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
        IDEDataSetCond iDEDataSetCond;
        String strFetchCond = WebContext.getFetchCond(this.getWebContext());
        if (!StringHelper.isNullOrEmpty(strFetchCond)) {
            JSONObject jo = JSONObjectHelper.fromString(strFetchCond);
            Iterator conds = jo.keys();
            while (conds.hasNext()) {
                String strCond = (String)conds.next();
                String objValue = jo.optString(strCond, null);
                IDEFSearchMode iDEFSearchMode = this.getDEModel().getDEFSearchMode(strCond, false);
                DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("DEFIELD");
                deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
                deDataSetCondImpl.setDEFName(iDEFSearchMode.getDEFName());
                deDataSetCondImpl.setCondValue(objValue);
                userConditions.add(deDataSetCondImpl);
            }
        }
        String strQuickSearch = null;
        IMDCtrlRender iMDCtrlRender = this.getMDCtrlRender();
        if (iMDCtrlRender != null) {
            strQuickSearch = iMDCtrlRender.getFetchQuickSearch();
        }
        if (StringHelper.isNullOrEmpty(strQuickSearch)) {
            strQuickSearch = WebContext.getFetchQuickSearch(this.getWebContext());
        }
        if (!StringHelper.isNullOrEmpty(strQuickSearch) && (iDEDataSetCond = this.getFetchQuickSearchCondition(strQuickSearch)) != null) {
            userConditions.add(iDEDataSetCond);
        }
        if (this.isEnableParentCondition()) {
            this.onFillFetchParentCondition(userConditions);
        }
    }

    protected void onFillFetchParentCondition(ArrayList<IDEDataSetCond> userConditions) throws Exception {
        String strParentType = WebContext.getParentType(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strParentType)) {
            return;
        }
        String strParentKey = WebContext.getParentKey(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strParentKey)) {
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("CUSTOM");
            deDataSetCondImpl.setCustomCond("1<>1");
            userConditions.add(deDataSetCondImpl);
            return;
        }
        if (StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0) {
            String strDER1N = WebContext.getDER1NId(this.getWebContext());
            IDER1N der = (IDER1N)this.getSystemModel().getDER(strDER1N);
            IDEField iDEFieldModel = this.getDEModel().getDEField(der.getPickupDEFName(), false);
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("DEFIELD");
            deDataSetCondImpl.setCondOp("EQ");
            deDataSetCondImpl.setDEFName(iDEFieldModel.getName());
            deDataSetCondImpl.setCondValue(strParentKey);
            userConditions.add(deDataSetCondImpl);
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void onFillFetchSearchFormConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
        deFields = this.getDEModel().getDEFields();
        while (deFields.hasNext()) {
            defield = deFields.next();
            defSearchModes = defield.getDEFSearchModes();
            if (defSearchModes != null) ** GOTO lbl19
            continue;
lbl-1000:
            // 1 sources

            {
                iDEFSearchMode = defSearchModes.next();
                strFormItemId = iDEFSearchMode.getName();
                strValue = this.getWebContext().getPostValue(strFormItemId.toLowerCase());
                if (StringHelper.isNullOrEmpty(strValue)) continue;
                deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("DEFIELD");
                deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
                deDataSetCondImpl.setDEFName(defield.getName());
                deDataSetCondImpl.setValueFunc(iDEFSearchMode.getValueFunc());
                deDataSetCondImpl.setCondValue(strValue);
                userConditions.add(deDataSetCondImpl);
lbl19:
                // 3 sources

                ** while (defSearchModes.hasNext())
            }
lbl20:
            // 1 sources

        }
    }

    protected void onFillFetchSearchFormCSMConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
        JSONObject jo;
        DEDataSetCond cond;
        String strCustomSearchVal = this.getWebContext().getPostValue("customsearchval");
        if (!StringHelper.isNullOrEmpty(strCustomSearchVal) && (cond = this.getCSMConditon(jo = JSONObjectHelper.fromString(strCustomSearchVal))) != null) {
            userConditions.add(cond);
        }
    }

    protected DEDataSetCond getCSMConditon(JSONObject jo) throws Exception {
        if (!jo.has("condtype") || !jo.has("condop")) {
            return null;
        }
        DEDataSetCond cond = new DEDataSetCond();
        String strCondType = jo.get("condtype").toString();
        String strCondOP = jo.get("condop").toString();
        boolean bNotMode = jo.getBoolean("notmode");
        cond.setCondType(strCondType);
        cond.setCondOp(strCondOP);
        cond.setNotMode(bNotMode);
        if (StringHelper.compare(strCondType, "GROUP", true) == 0) {
            if (!jo.has("items") || jo.get("items") == null) {
                return null;
            }
            JSONArray arr = JSONArray.fromString((String)jo.get("items").toString());
            int i = 0;
            int len = arr.length();
            while (i < len) {
                JSONObject joChild = (JSONObject)arr.get(i);
                DEDataSetCond condChild = this.getCSMConditon(joChild);
                if (condChild != null) {
                    cond.addChildDEDataQueryCond(condChild);
                }
                ++i;
            }
        } else {
            if (!jo.has("defid") || jo.get("defid") == null) {
                return null;
            }
            cond.setDEFName(jo.get("defid").toString());
            if (jo.has("condvalue") && jo.get("condvalue") != null) {
                cond.setCondValue(jo.get("condvalue").toString());
            }
            if (!jo.has("stddatatype") && jo.get("stddatatype") != null) {
                cond.setStdDataType(DataTypes.fromString(jo.get("stddatatype").toString()));
            }
        }
        return cond;
    }

    protected IDEDataSetCond getFetchQuickSearchCondition(String strQuickSearch) throws Exception {
        return this.getDEModel().getFetchQuickSearchCondition(strQuickSearch);
    }

    protected boolean isEnableParentCondition() {
        return !this.getViewController().isPickupView();
    }

    protected IEntity getDraftEntity(String strParentType, String strTypeParam, String strParentKey, String strParentKey2) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected IEntity getEntity(Object objKeyValue) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected IEntity createEntity(IEntity iEntity) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected IEntity updateEntity(IEntity iEntity) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected void removeEntity(Object objKeyValue) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected IEntity getDraftEntity() throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected void addEntities(String[] keys) throws Exception {
        String strParentKey;
        String strParentType = WebContext.getParentType(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strParentType)) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u7236\u6570\u636e\u7c7b\u578b"));
        }
        String strTypeParam = "";
        if (StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0) {
            strTypeParam = WebContext.getDER1NId(this.getWebContext());
        }
        if (StringHelper.isNullOrEmpty(strParentKey = WebContext.getParentKey(this.getWebContext()))) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u7236\u6570\u636e"));
        }
        String[] stringArray = keys;
        int n = keys.length;
        int n2 = 0;
        while (n2 < n) {
            String strKey = stringArray[n2];
            IEntity iEntity = this.getDraftEntity(strParentType, strTypeParam, strParentKey, strKey);
            if (!(this.getTempMode() != 0 ? !EntityBase.isDraft(iEntity) : this.getViewController().getService().checkKey(iEntity) != 0)) {
                this.createEntity(iEntity);
            }
            ++n2;
        }
    }

    protected boolean isEnableUserSort() {
        return this.bEnableUserSort;
    }

    protected String getMinorSortField() {
        return this.strMinorSortField;
    }

    protected String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    protected void setEnableUserSort(boolean bEnableUserSort) {
        this.bEnableUserSort = bEnableUserSort;
    }

    protected void setMinorSortField(String strMinorSortField) {
        this.strMinorSortField = strMinorSortField;
    }

    protected void setMinorSortDir(String strMinorSortDir) {
        this.strMinorSortDir = strMinorSortDir;
    }

    protected int getDefaultPageSize() {
        return this.nDefaultPageSize;
    }

    protected void setDefaultPageSize(int nDefaultPageSize) {
        this.nDefaultPageSize = nDefaultPageSize;
    }

    protected AjaxActionResult onUIAction() throws Exception {
        String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
        IDEUIActionModel iDEUIActionModel = (IDEUIActionModel)this.getDEModel().getDEUIAction(strDEUIActionId);
        return this.doUIAction(iDEUIActionModel);
    }

    protected AjaxActionResult onLoadUIAction() throws Exception {
        String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
        IDEUIActionModel iDEUIActionModel = (IDEUIActionModel)this.getDEModel().getDEUIAction(strDEUIActionId);
        return this.onLoadUIAction(iDEUIActionModel);
    }

    protected AjaxActionResult onLoadUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
        return iDEUIActionModel.getRuntimeModelAjaxActionResult(this.getSessionFactory());
    }

    protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
        MDAjaxActionResult mdAjaxActionResult = this.createFetchActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        IDataEntityModel iDEModel = iDEUIActionModel.getDEModel();
        if (StringHelper.compare(iDEUIActionModel.getActionTarget(), "NONE", true) == 0) {
            CallResult callResult;
            if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction()) && (callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction())).isError()) {
                mdAjaxActionResult.from(callResult);
                return mdAjaxActionResult;
            }
            iDEUIActionModel.execute(null, this.getSessionFactory());
        } else {
            String strKeys = WebContext.getKeys(this.getWebContext());
            if (StringHelper.isNullOrEmpty(strKeys)) {
                strKeys = WebContext.getKey(this.getWebContext());
            }
            if (StringHelper.isNullOrEmpty(strKeys)) {
                mdAjaxActionResult.setRetCode(4);
                return mdAjaxActionResult;
            }
            ArrayList entities = iDEModel.createEntityList();
            String[] keys = strKeys.split("[;]");
            int i = 0;
            while (i < keys.length) {
                Object iEntity = iDEModel.createEntity();
                iEntity.set(iDEModel.getKeyDEField().getName(), keys[i]);
                if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
                    if (StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false) == 0) {
                        IEntity iEntity2 = this.getSimpleEntity(keys[i]);
                        if (iEntity2 != null) {
                            CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), iEntity2, iDEUIActionModel.getDataAccessAction());
                            if (callResult.isError()) {
                                mdAjaxActionResult.from(callResult);
                                return mdAjaxActionResult;
                            }
                            if (DataTypeHelper.compare(iDEModel.getKeyDEField().getStdDataType(), iEntity.get(iDEModel.getKeyDEField().getName()), iEntity2.get(iDEModel.getKeyDEField().getName())) == 0L) {
                                iEntity = iEntity2;
                            }
                        }
                    } else {
                        CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), (IEntity)iEntity, iDEUIActionModel.getDataAccessAction());
                        if (callResult.isError()) {
                            mdAjaxActionResult.from(callResult);
                            return mdAjaxActionResult;
                        }
                    }
                }
                if (this.getDEModel() != null && StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false) != 0) {
                    iEntity.set("srfdeid", this.getDEModel().getId());
                }
                entities.add(iEntity);
                ++i;
            }
            iDEUIActionModel.execute(entities, this.getSessionFactory());
        }
        mdAjaxActionResult.setReloadData(iDEUIActionModel.isReloadData());
        mdAjaxActionResult.setErrorInfo(iDEUIActionModel.getSuccessMsg());
        if (iDEUIActionModel.isClosePopupView()) {
            mdAjaxActionResult.setExtAttr("closepopupview", iDEUIActionModel.isClosePopupView());
        }
        return mdAjaxActionResult;
    }

    protected AjaxActionResult onExportModel() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = this.createFetchActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        String strKeys = WebContext.getKeys(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strKeys)) {
            strKeys = WebContext.getKey(this.getWebContext());
        }
        if (StringHelper.isNullOrEmpty(strKeys)) {
            mdAjaxActionResult.setRetCode(4);
            return mdAjaxActionResult;
        }
        ArrayList<JSONObject> jsonObjectList = new ArrayList<JSONObject>();
        String[] keys = strKeys.split("[;]");
        int i = 0;
        while (i < keys.length) {
            Object iEntity = this.getDEModel().createEntity();
            iEntity.set(this.getDEModel().getKeyDEField().getName(), keys[i]);
            this.getService().exportModel(iEntity, jsonObjectList);
            ++i;
        }
        JSONObject rootNode = new JSONObject();
        rootNode.put("items", (Object)jsonObjectList.toArray());
        String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date());
        String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".ibzbak");
        OutputStreamWriter out = new OutputStreamWriter((OutputStream)new FileOutputStream(strTempFilePath, false), "UTF-8");
        out.write(rootNode.toString());
        out.flush();
        out.close();
        String strDownloadTmpFileUrl = this.getViewController().getAppModel().getUtilPageUrl("DOWNLOADTMPFILE");
        String strDownloadUrl = StringHelper.format("%1$sFILEID=%2$s", strDownloadTmpFileUrl, WebUtility.encodeURLParamValue(String.valueOf(strTempFileName) + ".ibzbak"));
        mdAjaxActionResult.setDownloadPath(strDownloadUrl);
        return mdAjaxActionResult;
    }

    protected AjaxActionResult onExportImpTempl() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = this.createFetchActionResult();
        this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
        String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date());
        String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".xls");
        DEDataImportTemplateHelper.output(this.getDEModel(), strTempFilePath);
        String strDownloadTmpFileUrl = this.getViewController().getAppModel().getUtilPageUrl("DOWNLOADTMPFILE");
        String strDownloadUrl = StringHelper.format("%1$sFILEID=%2$s", strDownloadTmpFileUrl, WebUtility.encodeURLParamValue(String.valueOf(strTempFileName) + ".xls"));
        mdAjaxActionResult.setDownloadPath(strDownloadUrl);
        return mdAjaxActionResult;
    }

    protected AjaxActionResult onItemTip() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected IMDCtrlRender getMDCtrlRender() throws Exception {
        ICtrlRender iCtrlRender = this.getCtrlRender();
        if (iCtrlRender == null) {
            return null;
        }
        return (IMDCtrlRender)iCtrlRender;
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return null;
    }

    @Override
    public boolean isEnableOrgDR() {
        return this.bEnableOrgDR;
    }

    @Override
    public boolean isEnableSecDR() {
        return this.bEnableSecDR;
    }

    @Override
    public boolean isEnableSecBC() {
        return this.bEnableSecBC;
    }

    @Override
    public long getOrgDR() {
        return this.nOrgDR;
    }

    @Override
    public long getSecDR() {
        return this.nSecDR;
    }

    @Override
    public String getSecBC() {
        return this.strSecBC;
    }

    protected void setEnableOrgDR(boolean bEnableOrgDR) {
        this.bEnableOrgDR = bEnableOrgDR;
    }

    protected void setEnableSecDR(boolean bEnableSecDR) {
        this.bEnableSecDR = bEnableSecDR;
    }

    protected void setEnableSecBC(boolean bEnableSecBC) {
        this.bEnableSecBC = bEnableSecBC;
    }

    protected void setOrgDR(long nOrgDR) {
        this.nOrgDR = nOrgDR;
    }

    protected void setSecDR(long nSecDR) {
        this.nSecDR = nSecDR;
    }

    protected void setSecBC(String strSecBC) {
        this.strSecBC = strSecBC;
    }

    @Override
    public boolean isEnableUserDR() {
        return this.bEnableUserDR;
    }

    protected void setEnableUserDR(boolean bEnableUserDR) {
        this.bEnableUserDR = bEnableUserDR;
    }

    @Override
    public String getUserDRAction() {
        return this.strUserDRAction;
    }

    @Override
    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
    }

    protected void fillDEDataSetFetchDataRange(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        if (!this.isUseServiceAPI()) {
            ArrayList<String> condList = new ArrayList<String>();
            if (this.isEnableUserDR() || this.isEnableOrgDR() || this.isEnableSecDR() || this.isEnableSecBC() || !StringHelper.isNullOrEmpty(this.getCustomDRMode()) || !StringHelper.isNullOrEmpty(this.getCustomDRMode2())) {
                if (StringHelper.isNullOrEmpty(this.getWebContext().getCurUserId())) {
                    throw new AccessDenyException("\u7528\u6237\u8fd8\u672a\u767b\u5f55", true);
                }
                IUserRoleMgr iUserRoleMgr = this.getWebContext().getUserRoleMgr();
                if (this.getWebContext().isSuperUser()) {
                    condList.add("1=1");
                } else {
                    String strCode;
                    if (this.isEnableUserDR()) {
                        this.fillDEDataSetFetchUserDRCond(deDataSetFetchContextImpl, condList);
                    }
                    if (!(this.isEnableUserDR() && condList.size() <= 0 && !this.getWebContext().isOrgAdmin() || StringHelper.isNullOrEmpty(strCode = iUserRoleMgr.getDEDataRangeCond(this.getService(), this, deDataSetFetchContextImpl)))) {
                        condList.add(strCode);
                    }
                }
                this.fillDEDataSetFetchOrgDRCond(deDataSetFetchContextImpl, condList);
            }
        }
    }

    protected void fillDEDataSetFetchOrgDRCond(DEDataSetFetchContext deDataSetFetchContextImpl, ArrayList<String> condList) throws Exception {
        IDEField orgIdDEField = this.getDEModel().getDEFieldByPDT("ORGID", true);
        IDEField secIdDEField = this.getDEModel().getDEFieldByPDT("ORGSECTORID", true);
        DEDataSetFetchContext.enableOrgDRCond(deDataSetFetchContextImpl, orgIdDEField, secIdDEField, condList);
    }

    protected void fillDEDataSetFetchUserDRCond(DEDataSetFetchContext deDataSetFetchContextImpl, ArrayList<String> condList) throws Exception {
        IUserRoleMgr iUserRoleMgr = this.getWebContext().getUserRoleMgr();
        int nDataAccCtrlArch = this.getDEModel().getDataAccCtrlArch();
        switch (nDataAccCtrlArch) {
            case 1: {
                ArrayList<UserRoleData> list = iUserRoleMgr.getUserRoleDatas(this.getDEModel().getId(), this.getUserDRAction());
                if (list == null) break;
                for (UserRoleData userRoleData : list) {
                    String strCode = iUserRoleMgr.getUserRoleDataCond(this.getService(), userRoleData, deDataSetFetchContextImpl);
                    if (StringHelper.isNullOrEmpty(strCode)) continue;
                    condList.add(strCode);
                }
                break;
            }
            case 2: {
                IUserRoleMgr2 iUserRoleMgr2 = WebContext.getUserRoleMgr2(this.getWebContext());
                String strCode = iUserRoleMgr2.getDEOPPrivRoleCond(this.getService(), this.getUserDRAction(), deDataSetFetchContextImpl);
                if (StringHelper.isNullOrEmpty(strCode)) break;
                condList.add(strCode);
                break;
            }
            default: {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u4f53\u7cfb[%1$s]", nDataAccCtrlArch));
            }
        }
        if (condList.size() == 0) {
            String strParentType = WebContext.getParentType(this.getWebContext());
            if (StringHelper.isNullOrEmpty(strParentType)) {
                return;
            }
            String strParentKey = WebContext.getParentKey(this.getWebContext());
            if (StringHelper.isNullOrEmpty(strParentKey)) {
                return;
            }
            if (StringHelper.compare(strParentType, "DER1N", true) == 0 || StringHelper.compare(strParentType, "SYSDER1N", true) == 0) {
                String strDER1N = WebContext.getDER1NId(this.getWebContext());
                IDER1N der = (IDER1N)this.getSystemModel().getDER(strDER1N);
                IDEField iDEFieldModel = this.getDEModel().getDEField(der.getPickupDEFName(), false);
                Object iEntity = this.getDEModel().createEntity();
                iEntity.set(iDEFieldModel.getName(), strParentKey);
                CallResult callResult = this.testDataAccessAction((IEntity)iEntity, this.getUserDRAction());
                if (callResult.isOk()) {
                    condList.add("");
                }
                return;
            }
        }
    }

    @Override
    public String getCustomDRMode() {
        return this.strCustomDRMode;
    }

    @Override
    public String getCustomDRMode2() {
        return this.strCustomDRMode2;
    }

    @Override
    public String getCustomDRModeParam() {
        return this.strCustomDRModeParam;
    }

    @Override
    public String getCustomDRMode2Param() {
        return this.strCustomDRMode2Param;
    }

    protected void setCustomDRMode(String strCustomDRMode) {
        this.strCustomDRMode = strCustomDRMode;
    }

    protected void setCustomDRMode2(String strCustomDRMode2) {
        this.strCustomDRMode2 = strCustomDRMode2;
    }

    protected void setCustomDRModeParam(String strCustomDRModeParam) {
        this.strCustomDRModeParam = strCustomDRModeParam;
    }

    protected void setCustomDRMode2Param(String strCustomDRMode2Param) {
        this.strCustomDRMode2Param = strCustomDRMode2Param;
    }

    protected String getDEDataExportId() {
        return this.strDEDataExportId;
    }

    protected void setDEDataExportId(String strDEDataExportId) {
        this.strDEDataExportId = strDEDataExportId;
    }

    protected int getMaxExportRowCount() {
        return this.nMaxExportRowCount;
    }

    protected void setMaxExportRowCount(int nMaxExportRowCount) {
        this.nMaxExportRowCount = nMaxExportRowCount;
    }

    @Override
    protected String getCacheDataTag(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "fetch", true) == 0) {
            DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
            deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
            IMDCtrlRender iMDCtrlRender = this.getMDCtrlRender();
            if (iMDCtrlRender != null) {
                iMDCtrlRender.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
            }
            if (!this.isEnableUserSort()) {
                deDataSetFetchContextImpl.resetSortInfo();
            }
            if (!StringHelper.isNullOrEmpty(this.getMinorSortField())) {
                deDataSetFetchContextImpl.setSort2(this.getMinorSortField());
                deDataSetFetchContextImpl.setSort2Dir(this.getMinorSortDir());
            }
            if (this.getDefaultPageSize() > 0) {
                deDataSetFetchContextImpl.setDefaultPageSize(this.getDefaultPageSize());
            }
            this.fillFetchConditions(deDataSetFetchContextImpl);
            this.fillDEDataSetFetchContext(deDataSetFetchContextImpl);
            if (!deDataSetFetchContextImpl.isCancel()) {
                this.fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);
                if (deDataSetFetchContextImpl.getConditionList().size() > 0) {
                    return null;
                }
                String strDEDataSetFetchContext = StringHelper.format("%1$s|%2$s|%3$s|%4$s|%5$s|%6$s", deDataSetFetchContextImpl.getStartRow(), deDataSetFetchContextImpl.getPageSize(), deDataSetFetchContextImpl.getSort(), deDataSetFetchContextImpl.getSortDir(), deDataSetFetchContextImpl.getSort2(), deDataSetFetchContextImpl.getSort2Dir());
                return KeyValueHelper.genUniqueId(StringHelper.format("%1$s|%2$s|%3$s|%4$s", this.getViewController().getId(), this.getCtrlModel().getId(), WebContext.getRender(this.getWebContext()), strDEDataSetFetchContext));
            }
            return null;
        }
        return super.getCacheDataTag(strAction);
    }

    public String getActiveDataDELogicId() {
        return this.strActiveDataDELogicId;
    }

    protected void setActiveDataDELogicId(String strActiveDataDELogicId) {
        this.strActiveDataDELogicId = strActiveDataDELogicId;
    }
}

