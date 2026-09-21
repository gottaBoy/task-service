/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.report;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.report.IPrintService;
import net.ibizsys.paas.report.PrintServiceGlobal;
import net.ibizsys.paas.report.util.PDFPrintHelper;
import net.ibizsys.paas.report.util.PrintDialogModes;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PrintServiceBase
extends ModelBaseImpl
implements IPrintService {
    private static final Log log = LogFactory.getLog(PrintServiceBase.class);
    private String strDetailDEDataSetName = null;
    private boolean bEnableColPriv = false;
    private boolean bEnableLog = false;
    private boolean bEnableMultiPrint = false;
    private String strGetDataDEActionName = "GET";
    private String strGetDataDataAccessAction = "READ";
    private IDataEntity iDataEntity = null;
    private String strReportFilePath = null;
    private String strId = null;
    private String strName = null;
    private String strDetailDEName;

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty(this.getId())) {
            PrintServiceGlobal.registerPrintService(this.getId(), this);
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

    @Override
    public IDataEntityModel getDEModel() {
        return (IDataEntityModel)this.getDataEntity();
    }

    @Override
    public String getPrintFile(String strKeys, IWebContext iWebContext, SessionFactory sessionFactory, String strContentType, String strPrintFileFolder) throws Exception {
        if (StringHelper.isNullOrEmpty(strKeys)) {
            throw new ErrorException(4, "\u6ca1\u6709\u6253\u5370\u6570\u636e\u952e\u503c");
        }
        IService iService = this.getDEModel().getService(sessionFactory);
        if (this.isEnableMulitPrint()) {
            return this.doMulitplePrintInDataSource(strKeys, iService, iWebContext, strContentType, strPrintFileFolder);
        }
        String strPrintMode = iWebContext.getParamValue("PRINTMODE");
        if (StringHelper.compare(strPrintMode, "MULTIPLE", true) == 0 && StringHelper.compare(strContentType, "PDF", true) == 0) {
            return this.doMulitplePrint(strKeys, iService, iWebContext, strContentType, strPrintFileFolder);
        }
        Object iEntity = this.getDEModel().createEntity();
        iEntity.set(this.getDEModel().getKeyDEField().getName(), strKeys);
        CallResult callResult = iWebContext.getUserPrivilegeMgr().testDataAccessAction(iWebContext, this.getDEModel(), (IEntity)iEntity, this.getGetDataDataAccessAction());
        if (callResult.getRetCode() != 0) {
            throw new ErrorException(2);
        }
        iService.executeAction(this.getGetDataDEActionName(), (IEntity)iEntity);
        String strReportFile = this.getPrintFile((IEntity)iEntity, iService, iWebContext, strContentType, strPrintFileFolder);
        return strReportFile;
    }

    protected String doMulitplePrintInDataSource(String strKey, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception {
        String[] arrKeyValue;
        ArrayList<IEntity> entityList = new ArrayList<IEntity>();
        String[] stringArray = arrKeyValue = StringHelper.splitEx(strKey);
        int n = arrKeyValue.length;
        int n2 = 0;
        while (n2 < n) {
            String strKeyValue = stringArray[n2];
            Object iEntity = this.getDEModel().createEntity();
            iEntity.set(this.getDEModel().getKeyDEField().getName(), strKeyValue);
            CallResult callResult = iWebContext.getUserPrivilegeMgr().testDataAccessAction(iWebContext, this.getDEModel(), (IEntity)iEntity, this.getGetDataDataAccessAction());
            if (callResult.getRetCode() != 0) {
                throw new ErrorException(2);
            }
            iService.executeAction(this.getGetDataDEActionName(), (IEntity)iEntity);
            entityList.add((IEntity)iEntity);
            ++n2;
        }
        String strReportFile = this.getPrintFile(entityList, iService, iWebContext, strContentType, strPrintFileFolder);
        return strReportFile;
    }

    protected abstract String getPrintFile(ArrayList<IEntity> var1, IService var2, IWebContext var3, String var4, String var5) throws Exception;

    protected abstract String getPrintFile(IEntity var1, IService var2, IWebContext var3, String var4, String var5) throws Exception;

    protected String doMulitplePrint(String strKey, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception {
        String[] arrKeyValue;
        ArrayList<String> arrPdfFiles = new ArrayList<String>();
        String[] stringArray = arrKeyValue = StringHelper.splitEx(strKey);
        int n = arrKeyValue.length;
        int n2 = 0;
        while (n2 < n) {
            String strKeyValue = stringArray[n2];
            Object iEntity = this.getDEModel().createEntity();
            iEntity.set(this.getDEModel().getKeyDEField().getName(), strKeyValue);
            CallResult callResult = iWebContext.getUserPrivilegeMgr().testDataAccessAction(iWebContext, this.getDEModel(), (IEntity)iEntity, this.getGetDataDataAccessAction());
            if (callResult.getRetCode() != 0) {
                throw new ErrorException(2);
            }
            iService.executeAction(this.getGetDataDEActionName(), (IEntity)iEntity);
            String strReportFile = this.getPrintFile((IEntity)iEntity, iService, iWebContext, strContentType, strPrintFileFolder);
            arrPdfFiles.add(strReportFile);
            ++n2;
        }
        String strMergedPdfURL = File.createTempFile("MERGED_", ".pdf").getPath();
        PDFPrintHelper pdfPrintHelper = new PDFPrintHelper(strMergedPdfURL, arrPdfFiles, this.getPrintDialogMode(iWebContext));
        try {
            pdfPrintHelper.doMerge();
            pdfPrintHelper.close();
        }
        catch (Exception e) {
            pdfPrintHelper.close();
            throw e;
        }
        return strMergedPdfURL;
    }

    @Override
    public String getDEDataSetName() {
        return this.strDetailDEDataSetName;
    }

    @Override
    public boolean isEnableColPriv() {
        return this.bEnableColPriv;
    }

    @Override
    public boolean isEnableLog() {
        return this.bEnableLog;
    }

    @Override
    public boolean isEnableMulitPrint() {
        return this.bEnableMultiPrint;
    }

    @Override
    public String getGetDataDEActionName() {
        return this.strGetDataDEActionName;
    }

    public void setDEDataSetName(String strDetailDEDataSetName) {
        this.strDetailDEDataSetName = strDetailDEDataSetName;
    }

    public void setEnableColPriv(boolean bEnableColPriv) {
        this.bEnableColPriv = bEnableColPriv;
    }

    public void setEnableLog(boolean bEnableLog) {
        this.bEnableLog = bEnableLog;
    }

    public void setEnableMultiPrint(boolean bEnableMultiPrint) {
        this.bEnableMultiPrint = bEnableMultiPrint;
    }

    public void setGetDataDEActionName(String strGetDataDEActionName) {
        this.strGetDataDEActionName = strGetDataDEActionName;
    }

    @Override
    public String getGetDataDataAccessAction() {
        return this.strGetDataDataAccessAction;
    }

    public void setGetDataDataAccessAction(String strGetDataDataAccessAction) {
        this.strGetDataDataAccessAction = strGetDataDataAccessAction;
    }

    protected String getPrintDialogMode(IWebContext iWebContext) {
        String strPrintDialogMode = iWebContext.getParamValue("SRFPRINTDIALOGMODE");
        if (StringHelper.isNullOrEmpty(strPrintDialogMode)) {
            strPrintDialogMode = WebConfig.getCurrent().getAttribute("PRINTDIALOGMODE", PrintDialogModes.NONE);
        }
        return strPrintDialogMode;
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
    public String getCodeListText(String strCodeListId, String strValue) throws Exception {
        return CodeListGlobal.getCodeList(strCodeListId).getCodeListText(strValue, true);
    }

    @Override
    public String getDetailDEDataSetName() {
        return this.strDetailDEDataSetName;
    }

    public void setDetailDEDataSetName(String strDetailDEDataSetName) {
        this.strDetailDEDataSetName = strDetailDEDataSetName;
    }

    @Override
    public String getDetailDEName() {
        return this.strDetailDEName;
    }

    public void setDetailDEName(String strDetailDEName) {
        this.strDetailDEName = strDetailDEName;
    }
}

