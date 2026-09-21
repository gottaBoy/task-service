/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.report;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.report.IReportService;
import net.ibizsys.paas.report.ReportServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public abstract class ReportServiceBase
extends ModelBaseImpl
implements IReportService {
    private String strAccessKey = null;
    private ArrayList<String> subReportList = new ArrayList();
    private String strDEDataSetName = null;
    private boolean bEnableLog = false;
    private IDataEntity iDataEntity = null;
    private String strReportFilePath = null;
    private String strId = null;
    private String strName = null;

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty(this.getId())) {
            ReportServiceGlobal.registerReportService(this.getId(), this);
        }
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    protected ISystemModel getSystemModel() {
        return (ISystemModel)this.getDataEntity().getSystem();
    }

    public IDataEntityModel getDEModel() {
        return (IDataEntityModel)this.getDataEntity();
    }

    public void registerSubReport(String strReportId) {
        this.subReportList.add(strReportId);
    }

    @Override
    public String getDEDataSetName() {
        return this.strDEDataSetName;
    }

    @Override
    public boolean isEnableLog() {
        return this.bEnableLog;
    }

    @Override
    public String getAccessKey() {
        return this.strAccessKey;
    }

    public void setDEDataSetName(String strDEDataSetName) {
        this.strDEDataSetName = strDEDataSetName;
    }

    public void setEnableLog(boolean bEnableLog) {
        this.bEnableLog = bEnableLog;
    }

    public void setAccessKey(String strAccessKey) {
        this.strAccessKey = strAccessKey;
    }

    @Override
    public String getReportFilePath() {
        return this.strReportFilePath;
    }

    public void setReportFilePath(String strReportFilePath) {
        this.strReportFilePath = strReportFilePath;
    }

    @Override
    public String getId() {
        return this.strId;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        this.onFillDEDataSetFetchContext(deDataSetFetchContextImpl);
    }

    protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    }

    protected void fillFetchConditions(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        this.onFillFetchSearchFormCSMConditions(deDataSetFetchContextImpl.getConditionList());
        this.onFillFetchSearchFormConditions(deDataSetFetchContextImpl.getConditionList());
        this.onFillFetchURLConditions(deDataSetFetchContextImpl.getConditionList());
    }

    protected void onFillFetchURLConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
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
    }

    /*
     * Unable to fully structure code
     */
    protected void onFillFetchSearchFormConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
        deFields = this.getDEModel().getDEFields();
        while (deFields.hasNext()) {
            defield = deFields.next();
            defSearchModes = defield.getDEFSearchModes();
            if (defSearchModes != null) ** GOTO lbl18
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
                deDataSetCondImpl.setCondValue(strValue);
                userConditions.add(deDataSetCondImpl);
lbl18:
                // 3 sources

                ** while (defSearchModes.hasNext())
            }
lbl19:
            // 1 sources

        }
    }

    protected void onFillFetchSearchFormCSMConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
    }

    protected IDEDataSetCond getFetchQuickSearchCondition(String strQuickSearch) throws Exception {
        return this.getDEModel().getFetchQuickSearchCondition(strQuickSearch);
    }

    protected IWebContext getWebContext() {
        return WebContext.getCurrent();
    }

    @Override
    public Iterator<String> getSubReportIds() {
        return this.subReportList.iterator();
    }

    @Override
    public boolean hasSubReport() {
        return this.subReportList.size() > 0;
    }

    @Override
    public String getCodeListText(String strCodeListId, String strValue) throws Exception {
        return CodeListGlobal.getCodeList(strCodeListId).getCodeListText(strValue, true);
    }

    @Override
    public String getJSONArrayText(Object objValue) {
        return this.getJSONArrayText(JSONArray.fromObject((Object)objValue), "name", ",", "");
    }

    @Override
    public String getJSONArrayText(Object objValue, String strKey, String strSplit, String strDefault) {
        return this.getJSONArrayText(JSONArray.fromObject((Object)objValue), strKey, strSplit, strDefault);
    }

    @Override
    public String getJSONArrayText(JSONArray jaList) {
        return this.getJSONArrayText(jaList, "name", ",", "");
    }

    @Override
    public String getJSONArrayText(JSONArray jaList, String strKey, String strSplit, String strDefault) {
        String strResult = strDefault;
        if (jaList != null) {
            int i = 0;
            while (i < jaList.length()) {
                JSONObject jo = jaList.optJSONObject(i);
                String strText = jo.optString(strKey, "");
                if (!StringHelper.isNullOrEmpty(strText)) {
                    if (!StringHelper.isNullOrEmpty(strResult)) {
                        strResult = String.valueOf(strResult) + strSplit;
                    }
                    strResult = String.valueOf(strResult) + strText;
                }
                ++i;
            }
        }
        return strResult;
    }
}

