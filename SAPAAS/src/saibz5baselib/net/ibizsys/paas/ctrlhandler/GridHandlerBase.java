/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.control.grid.GridRowError;
import net.ibizsys.paas.control.grid.GridRowException;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDERInherit;
import net.ibizsys.paas.ctrlhandler.ICtrlItemHandler;
import net.ibizsys.paas.ctrlhandler.IGridHandler;
import net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.AccessDenyException;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.exception.UserConfirmException;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.DEDataExportHelper;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.GridRowAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class GridHandlerBase
extends MDCtrlHandlerBase
implements IGridHandler {
    private static final Log log = LogFactory.getLog(GridHandlerBase.class);
    private boolean bEnableRowEdit = false;

    protected IGridModel getGridModel() {
        return null;
    }

    protected void setEnableRowEdit(boolean bEnableRowEdit) {
        this.bEnableRowEdit = bEnableRowEdit;
    }

    protected boolean isEnableRowEdit() {
        return this.bEnableRowEdit;
    }

    @Override
    protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        this.getGridModel().fillFetchResult(fetchResult, dt);
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getGridModel();
    }

    @Override
    protected void fillExportFile(MDAjaxActionResult fetchResult, IDataTable dt, String strType) throws Exception {
        String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date());
        if (StringHelper.compare(strType, "EXCEL", true) == 0) {
            String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".xls");
            DEDataExportHelper.output(strTempFilePath, dt, this.getGridModel(), this.getWebContext(), this.isEnableItemPriv());
            String strDownloadTmpFileUrl = this.getViewController().getAppModel().getUtilPageUrl("DOWNLOADTMPFILE");
            String strDownloadUrl = StringHelper.format("%1$sFILEID=%2$s", strDownloadTmpFileUrl, WebUtility.encodeURLParamValue(String.valueOf(strTempFileName) + ".xls"));
            fetchResult.setDownloadPath(strDownloadUrl);
            return;
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u5bfc\u51fa\u6570\u636e\u683c\u5f0f[%1$s]", strType));
    }

    protected AjaxActionResult onLoadDraft() throws Exception {
        GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(gridRowAjaxActionResult);
        IEntity iEntity = this.getDraftEntity();
        String strDataAccessAction = this.getDataAccessAction("create");
        CallResult callResult = this.testDataAccessAction(iEntity, strDataAccessAction);
        if (!callResult.isOk()) {
            this.fillDataAccActions(gridRowAjaxActionResult.getDataAccAction(true), false);
            gridRowAjaxActionResult.setRetCode(2);
            gridRowAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return gridRowAjaxActionResult;
        }
        iEntity.set("srfuf", 0);
        iEntity.set("srftempmode", this.getTempMode());
        this.fillRowOutputDatas(iEntity, false, gridRowAjaxActionResult);
        return gridRowAjaxActionResult;
    }

    protected AjaxActionResult onCreate() throws Exception {
        GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(gridRowAjaxActionResult);
        Object iEntity = this.getDEModel().createEntity();
        this.fillRowInputValues((IDataObject)iEntity, false, false);
        this.testRowInputValueRule((IDataObject)iEntity, false);
        String strDataAccessAction = this.getDataAccessAction("create");
        CallResult callResult = this.testDataAccessAction((IEntity)iEntity, strDataAccessAction);
        if (!callResult.isOk()) {
            this.fillDataAccActions(gridRowAjaxActionResult.getDataAccAction(true), false);
            gridRowAjaxActionResult.setRetCode(2);
            gridRowAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return gridRowAjaxActionResult;
        }
        iEntity = this.createEntity((IEntity)iEntity);
        iEntity.set("srfuf", 1);
        iEntity.set("srftempmode", this.getTempMode());
        this.fillRowOutputDatas((IDataObject)iEntity, true, gridRowAjaxActionResult);
        this.fillDataAccActions(gridRowAjaxActionResult.getDataAccAction(true), (IEntity)iEntity);
        return gridRowAjaxActionResult;
    }

    protected AjaxActionResult onUpdate() throws Exception {
        IEntity updateEntity;
        GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(gridRowAjaxActionResult);
        Object objKeyValue = this.getGridModel().getGridEditItemInputValue("srfkey", this.getWebContext());
        if (objKeyValue == null) {
            gridRowAjaxActionResult.setRetCode(4);
            return gridRowAjaxActionResult;
        }
        String strDataAccessAction = this.getDataAccessAction("update");
        CallResult callResult = this.testDataAccessAction(strDataAccessAction);
        if (callResult.isOk() && (updateEntity = this.getSimpleEntity(objKeyValue)) != null) {
            callResult = this.testDataAccessAction(updateEntity, strDataAccessAction);
        }
        if (!callResult.isOk()) {
            this.fillDataAccActions(gridRowAjaxActionResult.getDataAccAction(true), false);
            gridRowAjaxActionResult.setRetCode(2);
            gridRowAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return gridRowAjaxActionResult;
        }
        Object iEntity = this.getDEModel().createEntity();
        this.fillRowInputValues((IDataObject)iEntity, true, false);
        this.testRowInputValueRule((IDataObject)iEntity, true);
        iEntity.set(this.getDEModel().getKeyDEField().getName(), objKeyValue);
        iEntity = this.updateEntity((IEntity)iEntity);
        iEntity.set("srfuf", 1);
        iEntity.set("srftempmode", this.getTempMode());
        this.fillRowOutputDatas((IDataObject)iEntity, true, gridRowAjaxActionResult);
        this.fillDataAccActions(gridRowAjaxActionResult.getDataAccAction(true), (IEntity)iEntity);
        return gridRowAjaxActionResult;
    }

    protected void fillRowOutputDatas(IDataObject iDataObject, Boolean bUpdate, GridRowAjaxActionResult gridRowAjaxActionResult) throws Exception {
        this.getGridModel().fillRowOutputDatas(iDataObject, bUpdate, gridRowAjaxActionResult.getData(true), gridRowAjaxActionResult.getState(true), gridRowAjaxActionResult.getConfig(true));
    }

    protected void fillRowInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
        this.getGridModel().fillRowInputValues(iDataObject, bUpdate, bIgnoreEmpty);
    }

    protected void testRowInputValueRule(IDataObject iDataObject, boolean bUpdate) throws Exception {
        this.getGridModel().testRowValueRule(this.getService(), iDataObject, bUpdate);
    }

    protected void fillRowDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
        this.getGridModel().fillRowDefaultValues(iDataObject, bUpdate);
    }

    @Override
    public AjaxActionResult processAction(String strAction, IWebContext iWebContext) throws Exception {
        try {
            return super.processAction(strAction, iWebContext);
        }
        catch (GridRowException ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
            gridRowAjaxActionResult.setRetCode(5);
            gridRowAjaxActionResult.setErrorInfo(ex.getMessage());
            ex.getGridRowError().toJSONObject(gridRowAjaxActionResult.getError(true));
            return gridRowAjaxActionResult;
        }
        catch (EntityException ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
            gridRowAjaxActionResult.setRetCode(5);
            gridRowAjaxActionResult.setErrorInfo(ex.getMessage());
            GridRowError gridRowError = this.getGridRowError(ex.getEntityError());
            gridRowError.toJSONObject(gridRowAjaxActionResult.getError(true));
            return gridRowAjaxActionResult;
        }
        catch (ErrorException ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
            gridRowAjaxActionResult.setRetCode(ex.getErrorCode());
            gridRowAjaxActionResult.setErrorInfo(ex.getMessage());
            if (ex instanceof AccessDenyException) {
                gridRowAjaxActionResult.setNotLogin(((AccessDenyException)ex).isNotLogin());
            }
            return gridRowAjaxActionResult;
        }
        catch (UserConfirmException ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
            gridRowAjaxActionResult.setRetCode(19);
            gridRowAjaxActionResult.setConfirmMsg(ex.getMessage());
            gridRowAjaxActionResult.setConfirmKey(ex.getConfirmKey());
            gridRowAjaxActionResult.setConfirmTitle(ex.getConfirmTitle());
            gridRowAjaxActionResult.setConfirmOptions(ex.getConfirmOptions());
            gridRowAjaxActionResult.setConfirmActionParam(ex.getConfirmActionParam());
            return gridRowAjaxActionResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
            gridRowAjaxActionResult.setRetCode(1);
            gridRowAjaxActionResult.setErrorInfo(ex.getMessage());
            return gridRowAjaxActionResult;
        }
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "create", true) == 0) {
            return this.onCreate();
        }
        if (StringHelper.compare(strAction, "update", true) == 0) {
            return this.onUpdate();
        }
        if (StringHelper.compare(strAction, "itemfetch", true) == 0) {
            return this.onItemAction(strAction);
        }
        if (StringHelper.compare(strAction, "loaddraft", true) == 0) {
            return this.onLoadDraft();
        }
        if (StringHelper.compare(strAction, "loaddraftpaste", true) == 0) {
            return this.onPaste(true);
        }
        if (StringHelper.compare(strAction, "updategridedititem", true) == 0) {
            return this.onUpdateGridEditItem(WebContext.getUFIMode(this.getWebContext()));
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onItemAction(String strAction) throws Exception {
        String strFormItemName = WebContext.getFormItemId(this.getWebContext());
        ICtrlItemHandler iCtrlItemHandler = this.getCtrlItemHandler("GEI:" + strFormItemName);
        return iCtrlItemHandler.processAction(strAction);
    }

    protected AjaxActionResult onUpdateGridEditItem(String strUFIMode) throws Exception {
        String strCtrlItemName = strUFIMode;
        ICtrlItemHandler iCtrlItemHandler = this.getCtrlItemHandler("GEIU:" + strCtrlItemName);
        return iCtrlItemHandler.processAction("updategridedititem");
    }

    protected GridRowError getGridRowError(EntityError entityError) throws Exception {
        GridRowError gridRowError = new GridRowError();
        for (EntityFieldError entityFieldError : entityError.getEntityFieldErrorList()) {
            IGridEditItem iGridEditItem = this.getGridModel().getGridEditItem(entityFieldError.getFieldName(), true);
            if (iGridEditItem != null) {
                gridRowError.register(iGridEditItem.getName(), iGridEditItem.getCaption(), "", entityFieldError.getErrorType(), entityFieldError.getErrorInfo());
                continue;
            }
            log.error((Object)StringHelper.format("\u8868\u683c\u884c\u4e0d\u5b58\u5728\u5c5e\u6027 [%1$s]\uff0c\u9519\u8bef[%2$s]%3$s", entityFieldError.getFieldName(), entityFieldError.getErrorType(), entityFieldError.getErrorInfo()));
        }
        return gridRowError;
    }

    @Override
    public boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception {
        if (this.getGridModel().convertEntityFieldError(entityFieldError)) {
            return true;
        }
        return super.convertEntityFieldError(entityFieldError);
    }

    protected AjaxActionResult onPaste(boolean bPasteAsDraft) throws Exception {
        GridRowAjaxActionResult gridRowAjaxActionResult = new GridRowAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(gridRowAjaxActionResult);
        IEntity dataEntity = this.getDraftEntity();
        String strDataAccessAction = this.getDataAccessAction("create");
        CallResult callResult = this.testDataAccessAction(dataEntity, strDataAccessAction);
        if (!callResult.isOk()) {
            this.fillDataAccActions(gridRowAjaxActionResult.getDataAccAction(true), false);
            gridRowAjaxActionResult.setRetCode(2);
            gridRowAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return gridRowAjaxActionResult;
        }
        HashMap<String, IDEFieldModel> deFieldMap = new HashMap<String, IDEFieldModel>();
        HashMap<String, ICodeListModel> codeListMap = new HashMap<String, ICodeListModel>();
        HashMap<String, IService> serviceMap = new HashMap<String, IService>();
        HashMap<String, String> pickupFieldMap = new HashMap<String, String>();
        Iterator<IGridEditItem> gridEditItems = this.getGridModel().getGridEditItems();
        while (gridEditItems.hasNext()) {
            IDEFieldModel linkDEField;
            IGridEditItem iGridEditItem = gridEditItems.next();
            IDEFieldModel iDEField = (IDEFieldModel)this.getDEModel().getDEField(iGridEditItem.getDEFName(), true);
            if (iDEField == null) continue;
            deFieldMap.put(iGridEditItem.getName().toLowerCase(), iDEField);
            String strCodeListId = iDEField.getCodeListId();
            if (!StringHelper.isNullOrEmpty(strCodeListId) && !codeListMap.containsKey(strCodeListId)) {
                ICodeListModel codeListConfig = (ICodeListModel)CodeListGlobal.getCodeList(strCodeListId, this.getSessionFactory());
                if (codeListConfig == null) {
                    throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", strCodeListId));
                }
                codeListMap.put(strCodeListId, codeListConfig);
            }
            if (!iDEField.isLinkDEField()) continue;
            IDERBase iDERBase = this.getDEModel().getSystem().getDER(iDEField.getDERName());
            if (iDERBase instanceof IDER1N) {
                if (serviceMap.containsKey(iDEField.getDERName())) continue;
                String strDEId = iDERBase.getMajorDEId();
                IService iService = DEModelGlobal.getDEModel(strDEId).getService(this.getSessionFactory());
                if (iService == null) {
                    throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", strDEId));
                }
                serviceMap.put(iDEField.getDERName(), iService);
                continue;
            }
            if (!(iDERBase instanceof IDERInherit) || !(linkDEField = iDEField.getLinkDEField()).isLinkDEField() || !((iDERBase = this.getDEModel().getSystem().getDER(linkDEField.getDERName())) instanceof IDER1N) || serviceMap.containsKey(linkDEField.getDERName())) continue;
            String strDEId = iDERBase.getMajorDEId();
            IService iService = DEModelGlobal.getDEModel(strDEId).getService(this.getSessionFactory());
            if (iService == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", strDEId));
            }
            serviceMap.put(linkDEField.getDERName(), iService);
        }
        HashMap<String, IEntity> majorEntityMap = new HashMap<String, IEntity>();
        gridEditItems = this.getGridModel().getGridEditItems();
        while (gridEditItems.hasNext()) {
            Object objValue;
            IGridEditItem iGridEditItem = gridEditItems.next();
            String strContent = this.getWebContext().getPostValue(iGridEditItem.getName());
            if (StringHelper.isNullOrEmpty(strContent) || StringHelper.isNullOrEmpty(strContent = strContent.trim())) continue;
            IDEFieldModel iDEField = (IDEFieldModel)deFieldMap.get(iGridEditItem.getName().toLowerCase());
            String strCodeListId = iDEField.getCodeListId();
            if (!StringHelper.isNullOrEmpty(strCodeListId)) {
                ICodeListModel codeListConfig = (ICodeListModel)codeListMap.get(strCodeListId);
                String strDataType = iDEField.getDataType();
                if (StringHelper.compare(strDataType, "NMCODELIST", false) == 0 || StringHelper.compare(strDataType, "SMCODELIST", false) == 0) {
                    boolean bNumberMode = StringHelper.compare(strDataType, "NMCODELIST", false) == 0;
                    int nRealValue = 0;
                    String strRealValue = "";
                    String strNewContent = strContent;
                    strNewContent = strNewContent.replace("|", ";");
                    strNewContent = strNewContent.replace(",", ";");
                    strNewContent = strNewContent.replace("\uff0c", ";");
                    strNewContent = strNewContent.replace("\u3001", ";");
                    String[] items = strNewContent.split("[;]");
                    boolean bValueMode = false;
                    int l = 0;
                    while (l < items.length) {
                        String strText = items[l];
                        ICodeItem iCodeItem = codeListConfig.getCodeItemByText(strText, true);
                        if (iCodeItem == null) {
                            bValueMode = true;
                            break;
                        }
                        if (bNumberMode) {
                            nRealValue |= Integer.parseInt(iCodeItem.getValue());
                        } else {
                            if (!StringHelper.isNullOrEmpty(strRealValue)) {
                                strRealValue = String.valueOf(strRealValue) + codeListConfig.getValueSeparator();
                            }
                            strRealValue = String.valueOf(strRealValue) + iCodeItem.getValue();
                        }
                        ++l;
                    }
                    if (bValueMode) {
                        if (bNumberMode) {
                            nRealValue = Integer.parseInt(strContent);
                            dataEntity.set(iDEField.getName(), nRealValue);
                            continue;
                        }
                        strRealValue = strNewContent.replace(";", codeListConfig.getValueSeparator());
                        dataEntity.set(iDEField.getName(), strRealValue);
                        continue;
                    }
                    if (bNumberMode) {
                        dataEntity.set(iDEField.getName(), nRealValue);
                        continue;
                    }
                    dataEntity.set(iDEField.getName(), strRealValue);
                    continue;
                }
                ICodeItem iCodeItem = codeListConfig.getCodeItemByText(strContent, true);
                if (iCodeItem == null && (iCodeItem = codeListConfig.getCodeItem(strContent, true)) == null && StringHelper.compare(codeListConfig.getEmptyText(), strContent, true) != 0) {
                    throw new Exception(StringHelper.format("\u4ee3\u7801\u8868[%1$s]\u65e0\u6cd5\u8bc6\u522b[%2$s]", strCodeListId, strContent));
                }
                dataEntity.set(iDEField.getName(), DataTypeHelper.parse(iDEField.getStdDataType(), iCodeItem.getValue()));
                continue;
            }
            if (iDEField.isLinkDEField()) {
                Object objValue2;
                IDEFieldModel iPickupDEFHelper;
                String strDERName;
                if (StringHelper.compare(iDEField.getDataType(), "PICKUPTEXT", true) == 0 || StringHelper.compare(iDEField.getDataType(), "INHERIT", true) == 0 && StringHelper.compare(iDEField.getLinkDEField().getDataType(), "PICKUPTEXT", true) == 0) {
                    strDERName = "";
                    iPickupDEFHelper = null;
                    if (StringHelper.compare(iDEField.getDataType(), "PICKUPTEXT", true) == 0) {
                        iPickupDEFHelper = (IDEFieldModel)iDEField.getDEModel().getPickupDEField(iDEField.getDERName());
                        strDERName = iDEField.getDERName();
                    } else {
                        IDEFieldModel iLinkDEFHelper2 = iDEField.getLinkDEField();
                        iPickupDEFHelper = (IDEFieldModel)iDEField.getLinkDEField().getDEModel().getPickupDEField(iLinkDEFHelper2.getDERName());
                        strDERName = iDEField.getLinkDEField().getDERName();
                    }
                    if (iPickupDEFHelper == null) {
                        throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027[%1$s]\u76f8\u5173\u4fe1\u606f", iDEField.getRealDEField().getDEModel().getLogicName()));
                    }
                    if (dataEntity.contains(iPickupDEFHelper.getName())) continue;
                    IService iService = (IService)serviceMap.get(strDERName);
                    IEntity majorEntity = (IEntity)majorEntityMap.get(strDERName);
                    if (majorEntity == null) {
                        majorEntity = iService.getDEModel().createEntity();
                        majorEntityMap.put(strDERName, majorEntity);
                    }
                    majorEntity.set(iDEField.getRealDEField().getName(), strContent);
                    pickupFieldMap.put(strDERName, iPickupDEFHelper.getName());
                    objValue2 = DataTypeHelper.parse(iDEField.getStdDataType(), strContent);
                    if (objValue2 == null) {
                        throw new Exception(StringHelper.format("[%1$s]\u65e0\u6cd5\u8bc6\u522b[%2$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01", iDEField.getLogicName(), strContent));
                    }
                    dataEntity.set(iDEField.getName(), objValue2);
                    continue;
                }
                if (StringHelper.compare(iDEField.getDataType(), "PICKUPDATA", true) == 0 || StringHelper.compare(iDEField.getDataType(), "INHERIT", true) == 0 && StringHelper.compare(iDEField.getLinkDEField().getDataType(), "PICKUPDATA", true) == 0) {
                    strDERName = "";
                    iPickupDEFHelper = null;
                    if (StringHelper.compare(iDEField.getDataType(), "PICKUPDATA", true) == 0) {
                        iPickupDEFHelper = (IDEFieldModel)iDEField.getDEModel().getPickupDEField(iDEField.getDERName());
                        strDERName = iDEField.getDERName();
                    } else {
                        IDEFieldModel iLinkDEFHelper2 = iDEField.getLinkDEField();
                        iPickupDEFHelper = (IDEFieldModel)iDEField.getLinkDEField().getDEModel().getPickupDEField(iLinkDEFHelper2.getDERName());
                        strDERName = iDEField.getLinkDEField().getDERName();
                    }
                    if (iPickupDEFHelper == null) {
                        throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027[%1$s]\u76f8\u5173\u4fe1\u606f", iDEField.getRealDEField().getDEModel().getLogicName()));
                    }
                    if (dataEntity.contains(iPickupDEFHelper.getName())) continue;
                    IService iService = (IService)serviceMap.get(strDERName);
                    IEntity majorEntity = (IEntity)majorEntityMap.get(strDERName);
                    if (majorEntity == null) {
                        majorEntity = iService.getDEModel().createEntity();
                        majorEntityMap.put(strDERName, majorEntity);
                    }
                    majorEntity.set(iDEField.getRealDEField().getName(), strContent);
                    pickupFieldMap.put(strDERName, iPickupDEFHelper.getName());
                    objValue2 = DataTypeHelper.parse(iDEField.getStdDataType(), strContent);
                    if (objValue2 == null) {
                        throw new Exception(StringHelper.format("[%1$s]\u65e0\u6cd5\u8bc6\u522b[%2$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01", iDEField.getLogicName(), strContent));
                    }
                    dataEntity.set(iDEField.getName(), objValue2);
                    continue;
                }
                objValue = DataTypeHelper.parse(iDEField.getRealDEField().getStdDataType(), strContent);
                if (objValue == null) {
                    throw new Exception(StringHelper.format("[%1$s]\u65e0\u6cd5\u8bc6\u522b[%2$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01", iDEField.getLogicName(), strContent));
                }
                dataEntity.set(iDEField.getName(), objValue);
                continue;
            }
            objValue = DataTypeHelper.parse(iDEField.getStdDataType(), strContent);
            if (objValue == null) {
                throw new Exception(StringHelper.format("[%1$s]\u65e0\u6cd5\u8bc6\u522b[%2$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01", iDEField.getLogicName(), strContent));
            }
            dataEntity.set(iDEField.getName(), objValue);
        }
        for (String strDERName : majorEntityMap.keySet()) {
            IEntity majorEntity = (IEntity)majorEntityMap.get(strDERName);
            IService iService = (IService)serviceMap.get(strDERName);
            if (!this.selectPickupData(iService, majorEntity)) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u8ba1\u7b97\u5f15\u7528\u6570\u636e[%1$s]\uff0c%2$s", iService.getDEModel().getLogicName(), DataObject.toJSONObject(majorEntity, false)));
            }
            String strPickupField = (String)pickupFieldMap.get(strDERName);
            dataEntity.set(strPickupField, majorEntity.get(iService.getDEModel().getKeyDEField().getName()));
        }
        dataEntity.set("srfuf", 0);
        dataEntity.set("srftempmode", this.getTempMode());
        this.fillRowOutputDatas(dataEntity, false, gridRowAjaxActionResult);
        return gridRowAjaxActionResult;
    }

    protected boolean selectPickupData(IService iService, IEntity majorEntity) throws Exception {
        return iService.select(majorEntity, true);
    }

    @Override
    protected AjaxActionResult onItemTip() throws Exception {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
        String strKey = WebContext.getKey(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strKey)) {
            ajaxActionResult.setRetCode(4);
            return ajaxActionResult;
        }
        IEntity iEntity = null;
        String strDataAccessAction = "READ";
        CallResult callResult = this.testDataAccessAction(strDataAccessAction);
        if (callResult.isOk() && (iEntity = this.getSimpleEntity(strKey)) != null) {
            callResult = this.testDataAccessAction(iEntity, strDataAccessAction);
        }
        if (!callResult.isOk()) {
            ajaxActionResult.setRetCode(2);
            ajaxActionResult.setErrorInfo(callResult.getErrorInfo());
            return ajaxActionResult;
        }
        if (iEntity == null) {
            ajaxActionResult.setRetCode(3);
            return ajaxActionResult;
        }
        String strDataSummary = this.getDEModel().getService(this.getSessionFactory()).getDataSummary(iEntity);
        ajaxActionResult.setContent(strDataSummary);
        return ajaxActionResult;
    }
}

