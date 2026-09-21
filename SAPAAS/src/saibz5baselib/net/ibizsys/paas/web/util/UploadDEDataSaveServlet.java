/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.fileupload.FileItem
 *  org.apache.commons.fileupload.FileItemFactory
 *  org.apache.commons.fileupload.disk.DiskFileItemFactory
 *  org.apache.commons.fileupload.servlet.ServletFileUpload
 *  org.apache.poi.hssf.usermodel.HSSFDateUtil
 *  org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.CellValue
 *  org.apache.poi.ss.usermodel.FormulaEvaluator
 *  org.apache.poi.ss.usermodel.Row
 *  org.apache.poi.ss.usermodel.Sheet
 *  org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator
 *  org.apache.poi.xssf.usermodel.XSSFWorkbook
 */
package net.ibizsys.paas.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDERInherit;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.ExcelCellFuncHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.UploadDEDataSavePage;
import net.ibizsys.psrt.srv.common.service.FileService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UploadDEDataSaveServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private ThreadLocal<IDataEntityModel> iDataEntityModel = new ThreadLocal();
    private ThreadLocal<Integer> rowIndex2 = new ThreadLocal();
    private ThreadLocal<Integer> errorRowIndex = new ThreadLocal();
    private ThreadLocal<String> insertDataAction = new ThreadLocal();
    private ThreadLocal<String> updateDataAction = new ThreadLocal();

    @Override
    protected AjaxActionResult onProcessAction() throws Exception {
        IDEDataImport iDEDataImport;
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        StringBuilderEx processInfo = new StringBuilderEx();
        StringBuilderEx strErrorFileLink = new StringBuilderEx();
        this.rowIndex2.set(1);
        this.errorRowIndex.set(0);
        this.insertDataAction.set("CREATE");
        this.updateDataAction.set("UPDATE");
        String strPageDataEntityId = WebContext.getDEId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strPageDataEntityId)) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u7f16\u53f7"));
        }
        this.setDEModel(DEModelGlobal.getDEModel(strPageDataEntityId));
        String strKeyName = this.getDEModel().getKeyDEField().getName();
        String strDEDataImport = WebContext.getDEDataImport(this.getWebContext());
        if (!StringHelper.isNullOrEmpty(strDEDataImport) && (iDEDataImport = this.getDEModel().getDEDataImport(strDEDataImport)) == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5bfc\u5165\u6a21\u5f0f[%2$s]", this.getDEModel().getId(), strDEDataImport));
        }
        this.fillParentDataEntity();
        this.doDataImport(processInfo, strErrorFileLink);
        ajaxActionResult.setExtAttr("errorfileid", strErrorFileLink.toString());
        ajaxActionResult.setExtAttr("processinfo", processInfo.toString());
        return ajaxActionResult;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected void doDataImport(StringBuilderEx processInfo, StringBuilderEx strErrorFileLink) throws Exception {
        block100: {
            in = null;
            bStopWhenError = false;
            nRowIndex2 = this.rowIndex2.get();
            try {
                strFileLocalPath = WebConfig.getCurrent().getFilePath();
                strErrorFileFolder = "";
                strErrorFileFolder = String.valueOf(strErrorFileFolder) + "TEMP";
                strErrorFileFolder = String.valueOf(strErrorFileFolder) + File.separator;
                strErrorFileFolder = String.valueOf(strErrorFileFolder) + StringHelper.format("%1$tY-%1$tm-%1$td", new Date());
                strErrorFileFolder = String.valueOf(strErrorFileFolder) + File.separator;
                dir = new File(String.valueOf(strFileLocalPath) + strErrorFileFolder);
                dir.mkdirs();
                factory = new DiskFileItemFactory();
                upload = new ServletFileUpload((FileItemFactory)factory);
                list = upload.parseRequest(this.getWebContext().getRequest());
                if (list.size() == 0) {
                    return;
                }
                fileItem = (FileItem)list.get(0);
                if (fileItem == null) {
                    return;
                }
                bAccess = false;
                strTempId = KeyValueHelper.genGuidEx();
                strTempFilePath = "";
                fileName = fileItem.getName();
                fileNameExt = (fileName = fileName.substring(fileName.lastIndexOf("\\") + 1)).substring(fileName.lastIndexOf(".") + 1);
                if (StringHelper.compare(fileNameExt, "mdb", true) == 0) {
                    bAccess = true;
                }
                if (bAccess) {
                    this.rowIndex2.set(++nRowIndex2);
                    strTempFilePath = StringHelper.format("%1$s%2$s.%3$s", WebConfig.getCurrent().getTempPath(), strTempId, fileNameExt);
                } else {
                    strTempFilePath = StringHelper.format("%1$s%2$s.%3$s", WebConfig.getCurrent().getTempPath(), strTempId, fileNameExt);
                }
                tempFile = new File(strTempFilePath);
                fileItem.write(tempFile);
                deFieldMap = new TreeMap<Integer, IDEFieldModel>();
                codeListMap = new TreeMap<String, ICodeListModel>();
                serviceMap = new TreeMap<String, IService>();
                pickupFieldMap = new TreeMap<String, String>();
                deFieldImpMap = new TreeMap<String, IDEFieldModel>();
                importKeyList = new Vector<E>();
                tempList = new Vector<E>();
                strKeyFieldName = this.getDEModel().getKeyDEField().getName();
                deFields = this.getDEModel().getDEFields();
                while (deFields.hasNext()) {
                    iDEField = (IDEFieldModel)deFields.next();
                    if (iDEField.getImportOrder() == -1) continue;
                    deFieldImpMap.put(iDEField.getImportTag().toUpperCase(), iDEField);
                }
                this.onAfterFillDEFieldImpMap(deFieldImpMap);
                if (bAccess) break block100;
                workbook = null;
                errSheet = null;
                errWorkbook = null;
                strErrorTempFilePath2 = "";
                if (!bStopWhenError) {
                    strErrorTempFilePath2 = StringHelper.format("%1$s%2$s_E.xls", strErrorFileFolder, strTempId);
                    errWorkbook = new HSSFWorkbook();
                    errSheet = errWorkbook.createSheet("\u9519\u8bef\u6570\u636e");
                }
                excleFile = new File(strTempFilePath);
                strSuffix = UploadDEDataSavePage.getFileSuffixName(excleFile.getName());
                in = new FileInputStream(strTempFilePath);
                eva = null;
                if (StringHelper.compare(strSuffix, "xls", true) == 0) {
                    hssfWorkbook = new HSSFWorkbook(in);
                    eva = new HSSFFormulaEvaluator(hssfWorkbook);
                    workbook = hssfWorkbook;
                } else if (StringHelper.compare(strSuffix, "xlsx", true) == 0) {
                    xssfWorkbook = new XSSFWorkbook(in);
                    eva = new XSSFFormulaEvaluator(xssfWorkbook);
                    workbook = xssfWorkbook;
                }
                if (workbook.getNumberOfSheets() < 1) {
                    processInfo.append("<SPAN class='sx-normaltext-red'>Excel\u4e2d\u6ca1\u6709\u5305\u542b\u4efb\u4f55\u6570\u636e\u5206\u9875\uff01</SPAN><BR>");
                    return;
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
                        processInfo.append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c\u5fc5\u987b\u8f93\u5165\u5185\u5bb9</SPAN><BR>", ExcelCellFuncHelper.getCellSN(i, nRowIndex));
                        return;
                    }
                    strColumnName = (strContent = strContent.trim()).toUpperCase();
                    iDEField = deFieldImpMap.get(strColumnName);
                    if (iDEField == null) {
                        processInfo.append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61</SPAN><BR>", strColumnName);
                        return;
                    }
                    strCodeListId = iDEField.getCodeListId();
                    if (!StringHelper.isNullOrEmpty(strCodeListId) && !codeListMap.containsKey(strCodeListId)) {
                        codeListConfig = (ICodeListModel)CodeListGlobal.getCodeList(strCodeListId, this.getSessionFactory());
                        if (codeListConfig == null) {
                            processInfo.append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e</SPAN><BR>", strCodeListId);
                            return;
                        }
                        codeListMap.put(strCodeListId, codeListConfig);
                    }
                    if (iDEField.isLinkDEField()) {
                        iDERBase = this.getDEModel().getSystem().getDER(iDEField.getDERName());
                        if (iDERBase instanceof IDER1N) {
                            if (!serviceMap.containsKey(iDEField.getDERName())) {
                                strDEId = iDERBase.getMajorDEId();
                                iService = DEModelGlobal.getDEModel(strDEId).getService(this.getSessionFactory());
                                if (iService == null) {
                                    processInfo.append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61</SPAN><BR>", strDEId);
                                    return;
                                }
                                serviceMap.put(iDEField.getDERName(), iService);
                            }
                        } else if (iDERBase instanceof IDERInherit && (linkDEField = iDEField.getLinkDEField()).isLinkDEField() && (iDERBase = this.getDEModel().getSystem().getDER(linkDEField.getDERName())) instanceof IDER1N && !serviceMap.containsKey(linkDEField.getDERName())) {
                            strDEId = iDERBase.getMajorDEId();
                            iService = DEModelGlobal.getDEModel(strDEId).getService(this.getSessionFactory());
                            if (iService == null) {
                                processInfo.append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61</SPAN><BR>", strDEId);
                                return;
                            }
                            serviceMap.put(linkDEField.getDERName(), iService);
                        }
                    }
                    deFieldMap.put(i, iDEField);
                    ++i;
                }
                if (!bStopWhenError) {
                    this.addErrorSheetRow((Sheet)errSheet, row);
                }
                dataEntities = new Vector<IEntity>();
                nLastRow = dataSheet.getLastRowNum();
                i = 1;
                while (i <= nLastRow) {
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
                        if (!StringHelper.isNullOrEmpty(strContent) && !StringHelper.isNullOrEmpty(strContent = strContent.trim())) {
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
                                            nRealValue = Integer.parseInt(strContent);
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
                                    iCodeItem = codeListConfig.getCodeItemByText(strContent, true);
                                    if (iCodeItem == null && (iCodeItem = codeListConfig.getCodeItem(strContent, true)) == null && StringHelper.compare(codeListConfig.getEmptyText(), strContent, true) != 0) {
                                        processInfo.append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c \u4ee3\u7801\u8868[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i), strCodeListId, strContent);
                                        if (!bStopWhenError) {
                                            bErrorFlag = true;
                                            this.addErrorSheetRow((Sheet)errSheet, row);
                                            break;
                                        }
                                        return;
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
                                        processInfo.append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027[%2$s]\u76f8\u5173\u4fe1\u606f</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getRealDEField().getDEModel().getLogicName());
                                        if (!bStopWhenError) {
                                            bErrorFlag = true;
                                            this.addErrorSheetRow((Sheet)errSheet, row);
                                            break;
                                        }
                                        return;
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
                                        processInfo.append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027[%2$s]\u76f8\u5173\u4fe1\u606f</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getRealDEField().getDEModel().getLogicName());
                                        if (!bStopWhenError) {
                                            bErrorFlag = true;
                                            this.addErrorSheetRow((Sheet)errSheet, row);
                                            break;
                                        }
                                        return;
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
                                    objValue = DataTypeHelper.parse(iDEField.getRealDEField().getStdDataType(), strContent);
                                    if (objValue == null) {
                                        processInfo.append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getLogicName(), strContent);
                                        if (!bStopWhenError) {
                                            bErrorFlag = true;
                                            this.addErrorSheetRow((Sheet)errSheet, row);
                                            break;
                                        }
                                        return;
                                    }
                                    dataEntity.set(iDEField.getName(), objValue);
                                }
                            } else {
                                objValue = DataTypeHelper.parse(iDEField.getStdDataType(), strContent);
                                if (objValue == null) {
                                    processInfo.append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getLogicName(), strContent);
                                    if (!bStopWhenError) {
                                        bErrorFlag = true;
                                        this.addErrorSheetRow((Sheet)errSheet, row);
                                        break;
                                    }
                                    return;
                                }
                                dataEntity.set(iDEField.getName(), objValue);
                            }
                        }
                        ++j;
                    }
                    if (!bErrorFlag) {
                        for (String strDERName : majorEntityMap.keySet()) {
                            majorEntity = (IEntity)majorEntityMap.get(strDERName);
                            iService = (IService)serviceMap.get(strDERName);
                            if (!this.selectPickupData(iService, majorEntity)) {
                                processInfo.append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u65e0\u6cd5\u8ba1\u7b97\u5f15\u7528\u6570\u636e[%2$s]\uff0c%3$s</SPAN><BR>", i + 1, iService.getDEModel().getLogicName(), DataObject.toJSONObject(majorEntity, false));
                                if (!bStopWhenError) {
                                    bErrorFlag = true;
                                    this.addErrorSheetRow((Sheet)errSheet, row);
                                    break;
                                }
                                return;
                            }
                            strPickupField = (String)pickupFieldMap.get(strDERName);
                            dataEntity.set(strPickupField, majorEntity.get(iService.getDEModel().getKeyDEField().getName()));
                        }
                        dataEntities.add((IEntity)dataEntity);
                        if (!bStopWhenError) {
                            if (!this.doSaveDatas(dataEntities, false, processInfo)) {
                                this.addErrorSheetRow((Sheet)errSheet, row);
                            }
                            dataEntities.clear();
                        } else if (dataEntities.size() >= 1000) {
                            if (!this.doSaveDatas(dataEntities, false, processInfo)) {
                                return;
                            }
                            dataEntities.clear();
                        }
                    }
                    ++i;
                }
                if (dataEntities.size() <= 0) ** GOTO lbl307
                if (!this.doSaveDatas(dataEntities, false, processInfo)) {
                    return;
                }
                try {
                    dataEntities.clear();
lbl307:
                    // 2 sources

                    if (!bStopWhenError) {
                        fOut = new FileOutputStream(String.valueOf(strFileLocalPath) + strErrorTempFilePath2);
                        errWorkbook.write((OutputStream)fOut);
                        fOut.flush();
                        fOut.close();
                        if (this.errorRowIndex.get() > 1) {
                            fileDEDataCtrl = ServiceGlobal.getService(FileService.class, this.getSessionFactory());
                            strErrorTempFilePath2 = StringHelper.format("%1$s%2$s_E.xls", strErrorFileFolder, strTempId);
                            saveFile = new net.ibizsys.psrt.srv.common.entity.File();
                            saveFile.setFileSize(0);
                            saveFile.setFileName("\u65e0\u6cd5\u5bfc\u5165\u6570\u636e.xls");
                            saveFile.setLocalPath(strErrorTempFilePath2);
                            saveFile.setFolder("TEMP");
                            fileDEDataCtrl.create(saveFile);
                            strErrorFileLink.append(saveFile.getFileId());
                        }
                    }
                }
                catch (Exception ex) {
                    processInfo.append("<SPAN class='sx-normaltext-red'>\u5bfc\u5165\u6570\u636e\u8fc7\u7a0b\u4e2d\u53d1\u751f\u9519\u8bef\uff0c%1$s!</SPAN><BR>", ex.getMessage());
                    ex.printStackTrace();
                }
            }
            finally {
                if (in != null) {
                    in.close();
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean doSaveDatas(Vector<IEntity> dataEntities, boolean bAccess, StringBuilderEx processInfo) throws Exception {
        IService iService = this.getDEModel().getService(this.getSessionFactory());
        int nRowIndex2 = this.rowIndex2.get();
        String strInsertDataAction = this.insertDataAction.get();
        String strUpdateDataAction = this.updateDataAction.get();
        try {
            SessionFactoryManager.addRef();
            Iterator<IEntity> iterator = dataEntities.iterator();
            while (true) {
                boolean bInsert;
                if (!iterator.hasNext()) {
                    SessionFactoryManager.releaseRef(true);
                    return true;
                }
                IEntity dataEntity = iterator.next();
                int nCheckState = iService.checkKey(dataEntity);
                if (nCheckState == 2) {
                    SessionFactoryManager.releaseRef(false);
                    processInfo.append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u65e0\u6548\uff0c%2$s!</SPAN><BR>", nRowIndex2 + 1, "\u8be5\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!");
                    return false;
                }
                boolean bl = bInsert = nCheckState == 0;
                if (bInsert) {
                    iService.getDraft(dataEntity);
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
                        processInfo.append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u5931\u8d25\uff0c%2$s!</SPAN><BR>", nRowIndex2 + 1, strErrorInfo);
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
                    processInfo.append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u5931\u8d25\uff0c%2$s!</SPAN><BR>", nRowIndex2 + 1, strErrorInfo);
                    return false;
                }
                try {
                    this.doSaveData(iService, bInsert ? strInsertDataAction : strUpdateDataAction, dataEntity);
                    processInfo.append("<SPAN class='sx-normaltext'>\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u6210\u529f\uff0c%2$s!</SPAN><BR>", nRowIndex2 + 1, this.getDEModel().getDataInfo(dataEntity));
                }
                catch (Exception ex) {
                    SessionFactoryManager.releaseRef(false);
                    processInfo.append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u5931\u8d25\uff0c%2$s!</SPAN><BR>", nRowIndex2 + 1, ex.getMessage());
                    return false;
                }
                this.rowIndex2.set(++nRowIndex2);
            }
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef(false);
            processInfo.append("<SPAN class='sx-normaltext-red'>\u5bfc\u5165\u6570\u636e\u8fc7\u7a0b\u4e2d\u53d1\u751f\u9519\u8bef\uff0c%1$s!</SPAN><BR>", ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    protected void doSaveData(IService iService, String strActionMode, IEntity dataEntity) throws Exception {
        iService.executeAction(strActionMode, dataEntity);
    }

    protected void onSaveDataBeforeInsert(IEntity dataEntity) throws Exception {
    }

    protected void onSaveDataBeforeUpdate(IEntity dataEntity) throws Exception {
    }

    protected void fillDataEntityParentInfo(IEntity dataEntity) throws Exception {
    }

    protected void fillParentDataEntity() {
        String strDERID = WebContext.getDER1NId(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strDERID)) {
            return;
        }
    }

    protected void addErrorSheetRow(Sheet s1, Row row) throws Exception {
        int nRowIndex2 = this.rowIndex2.get();
        int nErrorRowIndex = this.errorRowIndex.get();
        if (nErrorRowIndex != 0) {
            this.rowIndex2.set(++nRowIndex2);
        }
        int nFirst = row.getFirstCellNum();
        short nLast = row.getLastCellNum();
        Row newRow = s1.createRow(nErrorRowIndex);
        int i = nFirst;
        while (i < nLast) {
            String strContent = this.getCellValue(row.getCell(i), null);
            Cell hssfcell = newRow.createCell(i);
            hssfcell.setCellValue(strContent);
            hssfcell.setCellType(1);
            if (nErrorRowIndex == 0) {
                s1.setColumnWidth(i, 4000);
            }
            ++i;
        }
        this.errorRowIndex.set(++nErrorRowIndex);
    }

    protected void onAfterFillDEFieldImpMap(TreeMap<String, IDEFieldModel> deFieldImpMap) {
    }

    protected boolean selectPickupData(IService iService, IEntity majorEntity) throws Exception {
        return iService.select(majorEntity, true);
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

    protected void setDEModel(IDataEntityModel iDataEntityModel) {
        this.iDataEntityModel.set(iDataEntityModel);
    }

    public IDataEntityModel getDEModel() {
        return this.iDataEntityModel.get();
    }
}

