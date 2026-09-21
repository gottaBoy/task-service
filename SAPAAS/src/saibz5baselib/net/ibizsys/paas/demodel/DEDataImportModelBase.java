/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.poi.hssf.usermodel.HSSFDateUtil
 *  org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.CellValue
 *  org.apache.poi.ss.usermodel.FormulaEvaluator
 *  org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator
 *  org.apache.poi.xssf.usermodel.XSSFWorkbook
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.demodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataImportResult;
import net.ibizsys.paas.core.IDEDataImportItem;
import net.ibizsys.paas.core.IDEDataImportResult;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDERInherit;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEDataImportModel;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.ExcelCellFuncHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SessionFactory;

public abstract class DEDataImportModelBase
extends ModelBase3Impl
implements IDEDataImportModel {
    private static final Log log = LogFactory.getLog(DEDataImportModelBase.class);
    private IDataEntity iDataEntity = null;
    protected ArrayList<IDEDataImportItem> deDataImportItemList = new ArrayList();
    protected ArrayList<IDEDataImportItem> deDataImportKeyItemList = new ArrayList();
    private boolean bIgnoreError = false;
    private String strCreateDEActionName = null;
    private String strUpdateDEActionName = null;
    private String strUpdateDataAccessAction = "UPDATE";
    private String strCreateDataAccessAction = "CREATE";
    private boolean bDefault = false;
    private static final String ROWNUM = "_SRFROWNUM_";

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.prepareDEDataImportItemModels();
    }

    protected void prepareDEDataImportItemModels() throws Exception {
    }

    protected IDEDataImportItem createDEDataImportItem(String strName) throws Exception {
        return null;
    }

    @Override
    public Iterator<IDEDataImportItem> getDEDataImportItems() {
        return this.deDataImportItemList.iterator();
    }

    protected void registerDEDataImportItem(IDEDataImportItem iDEDataImportItem) {
        this.deDataImportItemList.add(iDEDataImportItem);
        if (iDEDataImportItem.isUniqueItem()) {
            this.deDataImportKeyItemList.add(iDEDataImportItem);
        }
    }

    @Override
    public boolean isIgnoreError() {
        return this.bIgnoreError;
    }

    @Override
    public String getCreateDEActionName() {
        return this.strCreateDEActionName;
    }

    @Override
    public String getUpdateDEActionName() {
        return this.strUpdateDEActionName;
    }

    public void setIgnoreError(boolean bIgnoreError) {
        this.bIgnoreError = bIgnoreError;
    }

    public void setCreateDEActionName(String strCreateDEActionName) {
        this.strCreateDEActionName = strCreateDEActionName;
    }

    public void setUpdateDEActionName(String strUpdateDEActionName) {
        this.strUpdateDEActionName = strUpdateDEActionName;
    }

    @Override
    public String getCreateDataAccessAction() {
        return this.strCreateDataAccessAction;
    }

    @Override
    public String getUpdateDataAccessAction() {
        return this.strUpdateDataAccessAction;
    }

    @Override
    public boolean isDefault() {
        return this.bDefault;
    }

    public void setDefault(boolean bDefault) {
        this.bDefault = bDefault;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return (IDataEntityModel)this.getDataEntity();
    }

    @Override
    public boolean importFile(File importFile, String strFileType, ArrayList<IDEDataImportResult> importResultList) throws Exception {
        return this.importFile(importFile, strFileType, null, importResultList);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public boolean importFile(File importFile, String strFileType, SessionFactory sessionFactory, ArrayList<IDEDataImportResult> importResultList) throws Exception {
        block77: {
            block75: {
                deFieldMap = new TreeMap<Integer, IDEFieldModel>();
                codeListMap = new TreeMap<String, ICodeListModel>();
                serviceMap = new TreeMap<String, IService>();
                pickupFieldMap = new TreeMap<String, String>();
                deFieldImpMap = new TreeMap<String, IDEFieldModel>();
                strKeyFieldName = this.getDEModel().getKeyDEField().getName();
                majorService = this.getDEModel().getService(sessionFactory);
                iWebContext = WebContext.getCurrent();
                deDataImportItems = this.getDEDataImportItems();
                while (deDataImportItems.hasNext()) {
                    iDEDataImportItem = deDataImportItems.next();
                    strImportTag = null;
                    strImportTag = StringHelper.isNullOrEmpty(iDEDataImportItem.getCapLanResTag()) != false ? iDEDataImportItem.getCaption() : iWebContext.getLocalization(iDEDataImportItem.getCapLanResTag(), iDEDataImportItem.getCaption());
                    if (deFieldImpMap.containsKey(strImportTag = strImportTag.toUpperCase())) {
                        throw new Exception(StringHelper.format("\u51fa\u73b0\u91cd\u590d\u7684\u5bfc\u5165\u6807\u8bc6[%1$s]", strImportTag));
                    }
                    deFieldImpMap.put(strImportTag, (IDEFieldModel)iDEDataImportItem.getDEField());
                }
                this.onAfterFillDEFieldImpMap(deFieldImpMap);
                if (StringHelper.compare(strFileType, "EXCEL", false) != 0) break block75;
                workbook = null;
                in = new FileInputStream(importFile);
                eva = null;
                if (importFile.getName().endsWith(".xls")) {
                    hssfWorkbook = new HSSFWorkbook((InputStream)in);
                    eva = new HSSFFormulaEvaluator(hssfWorkbook);
                    workbook = hssfWorkbook;
                } else if (importFile.getName().endsWith(".xlsx")) {
                    xssfWorkbook = new XSSFWorkbook((InputStream)in);
                    eva = new XSSFFormulaEvaluator(xssfWorkbook);
                    workbook = xssfWorkbook;
                }
                if (workbook.getNumberOfSheets() < 1) {
                    return true;
                }
                dataSheet = workbook.getSheetAt(0);
                nCelLIndex = false;
                nRowIndex = 0;
                row = dataSheet.getRow(nRowIndex);
                nFirst = row.getFirstCellNum();
                nLast = row.getLastCellNum();
                i = nFirst;
                while (i < nLast) {
                    strContent = this.getCellValue(row.getCell(i), (FormulaEvaluator)eva);
                    if (StringHelper.isNullOrEmpty(strContent)) {
                        throw new Exception(StringHelper.format("\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c\u5fc5\u987b\u8f93\u5165\u5185\u5bb9", ExcelCellFuncHelper.getCellSN(i, nRowIndex)));
                    }
                    strColumnName = (strContent = strContent.trim()).toUpperCase();
                    iDEField = (IDEFieldModel)deFieldImpMap.get(strColumnName);
                    if (iDEField == null) {
                        throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", strColumnName));
                    }
                    strCodeListId = iDEField.getCodeListId();
                    if (!StringHelper.isNullOrEmpty(strCodeListId) && !codeListMap.containsKey(strCodeListId)) {
                        codeListConfig = (ICodeListModel)CodeListGlobal.getCodeList(strCodeListId, sessionFactory);
                        if (codeListConfig == null) {
                            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e", strCodeListId));
                        }
                        codeListMap.put(strCodeListId, codeListConfig);
                    }
                    if (iDEField.isLinkDEField()) {
                        iDERBase = this.getDEModel().getSystem().getDER(iDEField.getDERName());
                        if (iDERBase instanceof IDER1N) {
                            if (!serviceMap.containsKey(iDEField.getDERName())) {
                                strDEId = iDERBase.getMajorDEId();
                                iService = DEModelGlobal.getDEModel(strDEId).getService(sessionFactory);
                                if (iService == null) {
                                    throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u670d\u52a1\u5bf9\u8c61", strDEId));
                                }
                                serviceMap.put(iDEField.getDERName(), iService);
                            }
                        } else if (iDERBase instanceof IDERInherit && (linkDEField = iDEField.getLinkDEField()).isLinkDEField() && (iDERBase = this.getDEModel().getSystem().getDER(linkDEField.getDERName())) instanceof IDER1N && !serviceMap.containsKey(linkDEField.getDERName())) {
                            strDEId = iDERBase.getMajorDEId();
                            iService = DEModelGlobal.getDEModel(strDEId).getService(sessionFactory);
                            if (iService == null) {
                                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u670d\u52a1\u5bf9\u8c61", strDEId));
                            }
                            serviceMap.put(linkDEField.getDERName(), iService);
                        }
                    }
                    deFieldMap.put(i, iDEField);
                    ++i;
                }
                dataEntities = new ArrayList<IEntity>();
                nLastRow = dataSheet.getLastRowNum();
                i = 1;
                while (i <= nLastRow) {
                    block76: {
                        bErrorFlag = false;
                        dataEntity = this.getDEModel().createEntity();
                        row = dataSheet.getRow(i);
                        nFirst = row.getFirstCellNum();
                        nLast = row.getLastCellNum();
                        majorEntityMap = new HashMap<String, IEntity>();
                        j = nFirst;
                        while (j <= nLast) {
                            strContent = this.getCellValue(row.getCell(j), (FormulaEvaluator)eva);
                            bErrorFlag = false;
                            if (!StringHelper.isNullOrEmpty((String)strContent) && !StringHelper.isNullOrEmpty((String)(strContent = strContent.trim()))) {
                                iDEField = (IDEFieldModel)deFieldMap.get(j);
                                strCodeListId = iDEField.getCodeListId();
                                if (!StringHelper.isNullOrEmpty(strCodeListId)) {
                                    codeListConfig = (ICodeListModel)codeListMap.get(strCodeListId);
                                    strDataType = iDEField.getDataType();
                                    if (StringHelper.compare(strDataType, "NMCODELIST", false) == 0 || StringHelper.compare(strDataType, "SMCODELIST", false) == 0) {
                                        bNumberMode = StringHelper.compare(strDataType, "NMCODELIST", false) == 0;
                                        nRealValue = 0;
                                        strRealValue = "";
                                        strNewContent = strContent;
                                        strNewContent = strNewContent.replace("|", ";");
                                        strNewContent = strNewContent.replace(",", ";");
                                        strNewContent = strNewContent.replace("\uff0c", ";");
                                        strNewContent = strNewContent.replace("\u3001", ";");
                                        items = strNewContent.split("[;]");
                                        bValueMode = false;
                                        l = 0;
                                        while (l < items.length) {
                                            strText = items[l];
                                            iCodeItem = codeListConfig.getCodeItemByText(strText, true);
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
                                                nRealValue = Integer.parseInt((String)strContent);
                                                dataEntity.set(iDEField.getName(), nRealValue);
                                            } else {
                                                strRealValue = strNewContent.replace(";", codeListConfig.getValueSeparator());
                                                dataEntity.set(iDEField.getName(), strRealValue);
                                            }
                                        } else if (bNumberMode) {
                                            dataEntity.set(iDEField.getName(), nRealValue);
                                        } else {
                                            dataEntity.set(iDEField.getName(), strRealValue);
                                        }
                                    } else {
                                        iCodeItem = codeListConfig.getCodeItemByText((String)strContent, true);
                                        if (iCodeItem == null && (iCodeItem = codeListConfig.getCodeItem((String)strContent, true)) == null && StringHelper.compare(codeListConfig.getEmptyText(), (String)strContent, true) != 0) {
                                            deDataImportResult = new DEDataImportResult();
                                            deDataImportResult.setRetCode(5);
                                            deDataImportResult.setRetInfo(StringHelper.format("\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c \u4ee3\u7801\u8868[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]", ExcelCellFuncHelper.getCellSN(j, i), strCodeListId));
                                            importResultList.add(deDataImportResult);
                                            if (this.isIgnoreError()) {
                                                bErrorFlag = true;
                                                break;
                                            }
                                            return false;
                                        }
                                        dataEntity.set(iDEField.getName(), DataTypeHelper.parse(iDEField.getStdDataType(), iCodeItem.getValue()));
                                    }
                                } else if (iDEField.isLinkDEField()) {
                                    if (StringHelper.compare(iDEField.getDataType(), "PICKUPTEXT", true) == 0 || StringHelper.compare(iDEField.getDataType(), "INHERIT", true) == 0 && StringHelper.compare(iDEField.getLinkDEField().getDataType(), "PICKUPTEXT", true) == 0) {
                                        strDERName = "";
                                        iPickupDEFHelper = null;
                                        if (StringHelper.compare(iDEField.getDataType(), "PICKUPTEXT", true) == 0) {
                                            iPickupDEFHelper = (IDEFieldModel)iDEField.getDEModel().getPickupDEField(iDEField.getDERName());
                                            strDERName = iDEField.getDERName();
                                        } else {
                                            iLinkDEFHelper2 = iDEField.getLinkDEField();
                                            iPickupDEFHelper = (IDEFieldModel)iDEField.getLinkDEField().getDEModel().getPickupDEField(iLinkDEFHelper2.getDERName());
                                            strDERName = iDEField.getLinkDEField().getDERName();
                                        }
                                        if (iPickupDEFHelper == null) {
                                            deDataImportResult = new DEDataImportResult();
                                            deDataImportResult.setRetCode(5);
                                            deDataImportResult.setRetInfo(StringHelper.format("\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027[%2$s]\u76f8\u5173\u4fe1\u606f", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getRealDEField().getDEModel().getLogicName()));
                                            deDataImportResult.setRowSN(row.getRowNum());
                                            importResultList.add(deDataImportResult);
                                            if (this.isIgnoreError()) {
                                                bErrorFlag = true;
                                                break;
                                            }
                                            return false;
                                        }
                                        if (!dataEntity.contains(iPickupDEFHelper.getName())) {
                                            iService = (IService)serviceMap.get(strDERName);
                                            majorEntity /* !! */  = (IEntity)majorEntityMap.get(strDERName);
                                            if (majorEntity /* !! */  == null) {
                                                majorEntity /* !! */  = iService.getDEModel().createEntity();
                                                majorEntityMap.put(strDERName, majorEntity /* !! */ );
                                            }
                                            majorEntity /* !! */ .set(iDEField.getRealDEField().getName(), strContent);
                                            pickupFieldMap.put(strDERName, iPickupDEFHelper.getName());
                                        }
                                    } else if (StringHelper.compare(iDEField.getDataType(), "PICKUPDATA", true) == 0 || StringHelper.compare(iDEField.getDataType(), "INHERIT", true) == 0 && StringHelper.compare(iDEField.getLinkDEField().getDataType(), "PICKUPDATA", true) == 0) {
                                        strDERName = "";
                                        iPickupDEFHelper = null;
                                        if (StringHelper.compare(iDEField.getDataType(), "PICKUPDATA", true) == 0) {
                                            iPickupDEFHelper = (IDEFieldModel)iDEField.getDEModel().getPickupDEField(iDEField.getDERName());
                                            strDERName = iDEField.getDERName();
                                        } else {
                                            iLinkDEFHelper2 = iDEField.getLinkDEField();
                                            iPickupDEFHelper = (IDEFieldModel)iDEField.getLinkDEField().getDEModel().getPickupDEField(iLinkDEFHelper2.getDERName());
                                            strDERName = iDEField.getLinkDEField().getDERName();
                                        }
                                        if (iPickupDEFHelper == null) {
                                            deDataImportResult = new DEDataImportResult();
                                            deDataImportResult.setRetCode(5);
                                            deDataImportResult.setRetInfo(StringHelper.format("\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027[%2$s]\u76f8\u5173\u4fe1\u606f", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getRealDEField().getDEModel().getLogicName()));
                                            deDataImportResult.setRowSN(row.getRowNum());
                                            importResultList.add(deDataImportResult);
                                            if (this.isIgnoreError()) {
                                                bErrorFlag = true;
                                                break;
                                            }
                                            return false;
                                        }
                                        if (!dataEntity.contains(iPickupDEFHelper.getName())) {
                                            iService = (IService)serviceMap.get(strDERName);
                                            majorEntity /* !! */  = (IEntity)majorEntityMap.get(strDERName);
                                            if (majorEntity /* !! */  == null) {
                                                majorEntity /* !! */  = iService.getDEModel().createEntity();
                                                majorEntityMap.put(strDERName, majorEntity /* !! */ );
                                            }
                                            majorEntity /* !! */ .set(iDEField.getRealDEField().getName(), strContent);
                                            pickupFieldMap.put(strDERName, iPickupDEFHelper.getName());
                                        }
                                    } else {
                                        objValue = DataTypeHelper.parse(iDEField.getRealDEField().getStdDataType(), (String)strContent);
                                        if (objValue == null) {
                                            deDataImportResult = new DEDataImportResult();
                                            deDataImportResult.setRetCode(5);
                                            deDataImportResult.setRetInfo(StringHelper.format("\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getLogicName(), strContent));
                                            deDataImportResult.setRowSN(row.getRowNum());
                                            importResultList.add(deDataImportResult);
                                            if (this.isIgnoreError()) {
                                                bErrorFlag = true;
                                                break;
                                            }
                                            return false;
                                        }
                                        dataEntity.set(iDEField.getName(), objValue);
                                    }
                                } else {
                                    objValue = DataTypeHelper.parse(iDEField.getStdDataType(), (String)strContent);
                                    if (objValue == null) {
                                        deDataImportResult = new DEDataImportResult();
                                        deDataImportResult.setRetCode(5);
                                        deDataImportResult.setRetInfo(StringHelper.format("\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getLogicName(), strContent));
                                        deDataImportResult.setRowSN(row.getRowNum());
                                        importResultList.add(deDataImportResult);
                                        if (this.isIgnoreError()) {
                                            bErrorFlag = true;
                                            break;
                                        }
                                        return false;
                                    }
                                    dataEntity.set(iDEField.getName(), objValue);
                                }
                            }
                            ++j;
                        }
                        if (bErrorFlag) break block76;
                        for (String strDERName : majorEntityMap.keySet()) {
                            majorEntity = (IEntity)majorEntityMap.get(strDERName);
                            iService = (IService)serviceMap.get(strDERName);
                            if (!this.selectPickupData(iService, majorEntity)) {
                                deDataImportResult = new DEDataImportResult();
                                deDataImportResult.setRetCode(5);
                                deDataImportResult.setRetInfo(StringHelper.format("\u884c\u6570\u636e[%1$s]\u65e0\u6cd5\u8ba1\u7b97\u5f15\u7528\u6570\u636e[%2$s]\uff0c%3$s", i + 1, iService.getDEModel().getLogicName(), DataObject.toJSONObject(majorEntity, false)));
                                deDataImportResult.setRowSN(row.getRowNum());
                                importResultList.add(deDataImportResult);
                                if (this.isIgnoreError()) {
                                    bErrorFlag = true;
                                    break;
                                }
                                return false;
                            }
                            strPickupField = (String)pickupFieldMap.get(strDERName);
                            dataEntity.set(strPickupField, majorEntity.get(iService.getDEModel().getKeyDEField().getName()));
                        }
                        if (dataEntity.contains(strKeyFieldName) || this.deDataImportKeyItemList.size() <= 0) ** GOTO lbl288
                        bSelectKey = true;
                        selectCond = new SelectCond();
                        for (IDEDataImportItem iDEDataImportItem : this.deDataImportKeyItemList) {
                            objValue = dataEntity.get(iDEDataImportItem.getDEField().getName());
                            if (objValue == null) {
                                bSelectKey = false;
                                break;
                            }
                            selectCond.set(iDEDataImportItem.getDEField().getName(), objValue);
                        }
                        if (!bSelectKey) ** GOTO lbl288
                        tempList = majorService.select(selectCond);
                        if (tempList.size() > 1) {
                            deDataImportResult = new DEDataImportResult();
                            deDataImportResult.setRetCode(5);
                            deDataImportResult.setRetInfo(StringHelper.format("\u884c\u8bb0\u5f55[%1$s]\u65e0\u6548\uff0c\u67e5\u8be2\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef\uff0c\u5b58\u5728\u591a\u6761\u6ee1\u8db3\u5bfc\u5165\u8bc6\u522b\u9879\u7684\u6570\u636e\u3002", nRowIndex));
                            deDataImportResult.setRowSN(row.getRowNum());
                            importResultList.add(deDataImportResult);
                            if (!this.isIgnoreError()) {
                                return false;
                            }
                        } else {
                            if (tempList.size() == 1) {
                                iEntity = (IEntity)tempList.get(0);
                                dataEntity.set(strKeyFieldName, iEntity.get(strKeyFieldName));
                            }
lbl288:
                            // 5 sources

                            dataEntity.set("_SRFROWNUM_", row.getRowNum());
                            dataEntities.add((IEntity)dataEntity);
                            if (this.isIgnoreError()) {
                                this.doSaveDatas(majorService, dataEntities, importResultList);
                                dataEntities.clear();
                            } else if (dataEntities.size() >= 1000) {
                                if (!this.doSaveDatas(majorService, dataEntities, importResultList)) {
                                    return false;
                                }
                                dataEntities.clear();
                            }
                        }
                    }
                    ++i;
                }
                if (dataEntities.size() > 0) {
                    if (!this.doSaveDatas(majorService, dataEntities, importResultList)) {
                        return false;
                    }
                    dataEntities.clear();
                }
                break block77;
            }
            throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
        }
        return true;
    }

    protected String getCellValue(Cell cell, FormulaEvaluator eva) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case 1: {
                return cell.getStringCellValue();
            }
            case 4: {
                return String.valueOf(cell.getBooleanCellValue());
            }
            case 2: {
                if (eva == null) {
                    return cell.getCellFormula();
                }
                CellValue cellVal = eva.evaluate(cell);
                if (cellVal.getCellType() == 0) {
                    return String.valueOf(cellVal.getNumberValue());
                }
                return cellVal.getStringValue();
            }
            case 0: {
                boolean b = HSSFDateUtil.isCellDateFormatted((Cell)cell);
                if (b) {
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    return df.format(date);
                }
                cell.setCellType(1);
                return cell.getStringCellValue();
            }
        }
        return "";
    }

    protected void onAfterFillDEFieldImpMap(Map<String, IDEFieldModel> deFieldImpMap) {
    }

    protected boolean selectPickupData(IService iService, IEntity majorEntity) throws Exception {
        return iService.select(majorEntity, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean doSaveDatas(IService majorService, ArrayList<IEntity> dataEntities, ArrayList<IDEDataImportResult> importResultList) throws Exception {
        int nRowNum = 1;
        try {
            SessionFactoryManager.addRef();
            for (IEntity dataEntity : dataEntities) {
                boolean bInsert;
                nRowNum = DataObject.getIntegerValue(dataEntity, ROWNUM, 1);
                int nCheckState = majorService.checkKey(dataEntity);
                if (nCheckState == 2) {
                    SessionFactoryManager.releaseRef(false);
                    DEDataImportResult deDataImportResult = new DEDataImportResult();
                    deDataImportResult.setRetCode(5);
                    deDataImportResult.setRetInfo(StringHelper.format("\u884c\u8bb0\u5f55[%1$s]\u65e0\u6548\uff0c\u67e5\u8be2\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef\uff0c\u5b58\u5728\u591a\u6761\u6ee1\u8db3\u5bfc\u5165\u8bc6\u522b\u9879\u7684\u6570\u636e\u3002", nRowNum));
                    deDataImportResult.setRowSN(nRowNum);
                    importResultList.add(deDataImportResult);
                    return false;
                }
                boolean bl = bInsert = nCheckState == 0;
                if (bInsert) {
                    majorService.getDraft(dataEntity);
                }
                if (bInsert) {
                    this.fillDataEntityParentInfo(dataEntity);
                    try {
                        this.onSaveDataBeforeInsert(dataEntity);
                    }
                    catch (Exception ex) {
                        String strErrorFormat = "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s";
                        String strErrorInfo = StringHelper.format(strErrorFormat, ex.getMessage());
                        SessionFactoryManager.releaseRef(false);
                        DEDataImportResult deDataImportResult = new DEDataImportResult();
                        deDataImportResult.setRetCode(5);
                        deDataImportResult.setRetInfo(StringHelper.format("\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u5931\u8d25\uff0c%2$s!", nRowNum, strErrorInfo));
                        deDataImportResult.setRowSN(nRowNum);
                        importResultList.add(deDataImportResult);
                        return false;
                    }
                }
                try {
                    this.onSaveDataBeforeUpdate(dataEntity);
                }
                catch (Exception ex) {
                    String strErrorFormat = "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s";
                    String strErrorInfo = StringHelper.format(strErrorFormat, ex.getMessage());
                    SessionFactoryManager.releaseRef(false);
                    DEDataImportResult deDataImportResult = new DEDataImportResult();
                    deDataImportResult.setRetCode(5);
                    deDataImportResult.setRetInfo(StringHelper.format("\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u5931\u8d25\uff0c%2$s!", nRowNum, strErrorInfo));
                    deDataImportResult.setRowSN(nRowNum);
                    importResultList.add(deDataImportResult);
                    return false;
                }
                try {
                    this.doSaveData(majorService, bInsert ? this.getCreateDEActionName() : this.getUpdateDEActionName(), dataEntity);
                    DEDataImportResult deDataImportResult = new DEDataImportResult();
                    deDataImportResult.setRetCode(0);
                    deDataImportResult.setRetInfo(StringHelper.format("\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u6210\u529f\uff0c%2$s!", nRowNum, this.getDEModel().getDataInfo(dataEntity)));
                    deDataImportResult.setRowSN(nRowNum);
                    importResultList.add(deDataImportResult);
                }
                catch (Exception ex) {
                    SessionFactoryManager.releaseRef(false);
                    DEDataImportResult deDataImportResult = new DEDataImportResult();
                    deDataImportResult.setRetCode(5);
                    deDataImportResult.setRetInfo(StringHelper.format("\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u5931\u8d25\uff0c%2$s!", nRowNum, ex.getMessage()));
                    deDataImportResult.setRowSN(nRowNum);
                    importResultList.add(deDataImportResult);
                    return false;
                }
            }
            SessionFactoryManager.releaseRef(true);
            return true;
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef(false);
            DEDataImportResult deDataImportResult = new DEDataImportResult();
            deDataImportResult.setRetCode(5);
            deDataImportResult.setRetInfo(StringHelper.format("\u5bfc\u5165\u6570\u636e\u8fc7\u7a0b\u4e2d\u53d1\u751f\u9519\u8bef\uff0c%1$s!", ex.getMessage()));
            deDataImportResult.setRowSN(nRowNum);
            importResultList.add(deDataImportResult);
            log.error((Object)ex);
            return false;
        }
    }

    protected void doSaveData(IService iService, String strActionMode, IEntity dataEntity) throws Exception {
        iService.executeAction(strActionMode, dataEntity);
    }

    protected void onSaveDataBeforeInsert(IEntity dataEntity) throws Exception {
        CallResult callResult = this.getDEModel().getDEDataAccMgr().test(WebContext.getCurrent(), dataEntity, this.getCreateDataAccessAction());
        if (callResult.isError()) {
            throw new ErrorException(callResult.getRetCode(), callResult.getErrorInfo());
        }
    }

    protected void onSaveDataBeforeUpdate(IEntity dataEntity) throws Exception {
        CallResult callResult = this.getDEModel().getDEDataAccMgr().test(WebContext.getCurrent(), dataEntity, this.getUpdateDataAccessAction());
        if (callResult.isError()) {
            throw new ErrorException(callResult.getRetCode(), callResult.getErrorInfo());
        }
    }

    protected void fillDataEntityParentInfo(IEntity dataEntity) throws Exception {
    }
}

