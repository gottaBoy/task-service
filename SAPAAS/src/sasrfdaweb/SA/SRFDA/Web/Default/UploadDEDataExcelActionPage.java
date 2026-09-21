/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEDataImport
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.File
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.AccessUtil
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.ReportEx.SRFCellFuncHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Utility.DADVHelper
 *  com.jspsmart.upload.SmartUpload
 *  jxl.Cell
 *  jxl.Workbook
 *  jxl.write.Label
 *  jxl.write.WritableCell
 *  jxl.write.WritableSheet
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.AccessUtil;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.ReportEx.SRFCellFuncHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Utility.DADVHelper;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;

public class UploadDEDataExcelActionPage
extends BaseMainPage {
    protected StringBuilderEx processInfo = new StringBuilderEx();
    protected String strErrorFileLink = "";
    int nRowIndex2 = 1;
    protected String strPKeyName = "";
    protected Object objPKeyValue = null;
    protected boolean bStopWhenError = true;
    protected String strMultiKeys = "";
    protected String strKeyName = "";
    protected String strInsertMode = "DEFAULT";
    protected String strUpdateMode = "DEFAULT";
    protected String strInsertDataAction = "CREATE";
    protected String strUpdateDataAction = "UPDATE";
    protected int nErrorRowIndex = 0;

    @Override
    protected boolean PreparePageEnv() {
        String strReferPageId;
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (StringHelper.IsNullOrEmpty((String)this.strPageDataEntityId)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u7f16\u53f7"));
            return false;
        }
        if (!this.LoadPageDataEntity()) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u52a0\u8f7d\u9875\u9762\u5b9e\u4f53[%1$s]\u5931\u8d25", (Object)this.strPageDataEntityId));
            return false;
        }
        this.strKeyName = this.getDEHelper().GetKeyDEFHelper().getName();
        String strDEDataImport = this.getWebContext().GetParamValue("SRFDEDATAIMPORT");
        if (!StringHelper.IsNullOrEmpty((String)strDEDataImport)) {
            DEDataImport deDataImport = this.getDEHelper().GetDataImport(strDEDataImport);
            if (deDataImport != null) {
                if (!deDataImport.isSTOPWHENERRORNull()) {
                    this.bStopWhenError = deDataImport.getSTOPWHENERROR();
                }
                if (deDataImport.getMultiKeys() != null && deDataImport.getMultiKeys().size() > 0) {
                    for (String strKey : deDataImport.getMultiKeys()) {
                        if (!StringHelper.IsNullOrEmpty((String)this.strMultiKeys)) {
                            this.strMultiKeys = String.valueOf(this.strMultiKeys) + ";";
                        }
                        this.strMultiKeys = String.valueOf(this.strMultiKeys) + strKey;
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)deDataImport.getINSERTMODE())) {
                    this.strInsertMode = deDataImport.getINSERTMODE();
                }
                if (!StringHelper.IsNullOrEmpty((String)deDataImport.getUPDATEMODE())) {
                    this.strUpdateMode = deDataImport.getUPDATEMODE();
                }
                if (!StringHelper.IsNullOrEmpty((String)deDataImport.getINSERTDATAACTION())) {
                    this.strInsertDataAction = deDataImport.getINSERTDATAACTION();
                }
                if (!StringHelper.IsNullOrEmpty((String)deDataImport.getUPDATEDATAACTION())) {
                    this.strUpdateDataAction = deDataImport.getUPDATEDATAACTION();
                }
            } else {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5bfc\u5165\u6a21\u5f0f[%2$s]", (Object)this.getDEHelper().getId(), (Object)strDEDataImport));
                return false;
            }
        }
        this.FillParentDataEntity();
        if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0 && !StringHelper.IsNullOrEmpty((String)(strReferPageId = this.getWebContext().GetParamValue("SRFREFERPAGEID")))) {
            StringBuilderEx sb = new StringBuilderEx();
            sb.Append("if(window.opener&&!window.opener.closed && window.opener.SLApp){ var page=window.opener.SLApp.GetPage('%1$s'); if(page!=null){page.refresh();}}", (Object)strReferPageId);
            this.getPage().RegisterScript(5, sb.toString());
        }
        return true;
    }

    /*
     * Unable to fully structure code
     */
    protected void OnInitComponents() {
        block229: {
            super.OnInitComponents();
            accessUtil = null;
            try {
                strFileLocalPath = this.webContext.getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
                strErrorFileFolder = "";
                strErrorFileFolder = String.valueOf(strErrorFileFolder) + "TEMP";
                strErrorFileFolder = String.valueOf(strErrorFileFolder) + File.separator;
                strErrorFileFolder = String.valueOf(strErrorFileFolder) + StringHelper.Format((String)"%1$tY-%1$tm-%1$td", (Object)new Date());
                strErrorFileFolder = String.valueOf(strErrorFileFolder) + File.separator;
                dir = new File(String.valueOf(strFileLocalPath) + strErrorFileFolder);
                dir.mkdirs();
                su = new SmartUpload();
                su.initialize(this.pageContext);
                su.upload();
                nCount = su.getFiles().getCount();
                if (nCount == 0) {
                    return;
                }
                strTempId = Helper.GenGuidEx();
                strTempFilePath = "";
                file = su.getFiles().getFile(0);
                bAccess = false;
                if (StringHelper.Compare((String)file.getFileExt(), (String)"mdb", (boolean)true) == 0) {
                    bAccess = true;
                }
                if (bAccess) {
                    --this.nRowIndex2;
                    strTempFilePath = StringHelper.Format((String)"%1$s%2$s.%3$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strTempId, (Object)file.getFileExt());
                } else {
                    strTempFilePath = StringHelper.Format((String)"%1$s%2$s.%3$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strTempId, (Object)file.getFileExt());
                }
                file.saveAs(strTempFilePath);
                deFieldMap = new TreeMap<Integer, IDEFHelper>();
                codeListMap = new TreeMap<String, CodeListConfig>();
                deDataCtrlMap = new TreeMap<String, IDEDataCtrl>();
                deFieldImpMap = new TreeMap<String, IDEFHelper>();
                importKeyList = new Vector<String>();
                tempList = new Vector<E>();
                strKeyFieldName = this.getDEHelper().GetKeyDEFHelper().getName();
                for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                    if (iDEFHelper.getDEField().getEXCELIMPORDER() == -1) continue;
                    if (iDEFHelper.getDEField().getEXCELIMPKEY()) {
                        importKeyList.add(iDEFHelper.GetDTColumn().GetColumnName());
                    }
                    deFieldImpMap.put(iDEFHelper.getDEField().getEXCELIMPID().toUpperCase(), iDEFHelper);
                }
                this.OnAfterFillDEFieldImpMap(deFieldImpMap);
                if (bAccess) {
                    accessUtil = new AccessUtil();
                    accessUtil.ConnectAccessDB(strTempFilePath);
                    rs = accessUtil.ExecuteQuerySql("SELECT * FROM TABLE1");
                    columnIndextable = new TreeMap<String, Integer>();
                    rsmd = rs.getMetaData();
                    numberOfColumns = rsmd.getColumnCount();
                    i = 1;
                    while (i <= numberOfColumns) {
                        columnIndextable.put(rsmd.getColumnName(i).toUpperCase(), i - 1);
                        ++i;
                    }
                    for (String strContent : columnIndextable.keySet()) {
                        strColumnName = (strContent = strContent.trim()).toUpperCase();
                        iDEFHelper = deFieldImpMap.get(strColumnName);
                        if (iDEFHelper == null) {
                            if (StringHelper.Compare((String)strColumnName, (String)"ID", (boolean)true) == 0) continue;
                            this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61</SPAN><BR>", (Object)strColumnName);
                            return;
                        }
                        strCodeListId = iDEFHelper.GetCodeList();
                        if (!StringHelper.IsNullOrEmpty((String)strCodeListId) && !codeListMap.containsKey(strCodeListId)) {
                            codeListConfig = this.getWebContext().getGlobalHelper().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
                            if (codeListConfig == null) {
                                this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e</SPAN><BR>", (Object)strCodeListId);
                                return;
                            }
                            codeListMap.put(strCodeListId, codeListConfig);
                        }
                        if (iDEFHelper.IsLinkDEField() && !deDataCtrlMap.containsKey(strDEId = (iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetRealDEFHelper().getDEHelper().getId())) {
                            iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl(strDEId, (ISRFDAWebContext)this.getWebContext());
                            if (iDEDataCtrl == null) {
                                this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61</SPAN><BR>", (Object)strDEId);
                                return;
                            }
                            deDataCtrlMap.put(strDEId, iDEDataCtrl);
                        }
                        deFieldMap.put((Integer)columnIndextable.get(strContent), iDEFHelper);
                    }
                    dataEntities = new Vector<BaseDataEntity>();
                    nRowIndex = -1;
                    while (rs.next()) {
                        dataEntity = new BaseDataEntity();
                        j = 0;
                        while (j < numberOfColumns) {
                            objContent = rs.getObject(j + 1);
                            if (objContent != null && !StringHelper.IsNullOrEmpty((String)(strContent = objContent.toString())) && !StringHelper.IsNullOrEmpty((String)(strContent = strContent.trim())) && (iDEFHelper = (IDEFHelper)deFieldMap.get(j)) != null && StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPDATA", (boolean)true) != 0) {
                                strCodeListId = iDEFHelper.GetCodeList();
                                if (!StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                                    codeListConfig = (CodeListConfig)codeListMap.get(strCodeListId);
                                    strDataType = iDEFHelper.GetDataType();
                                    if (StringHelper.Compare((String)strDataType, (String)"NMCODELIST", (boolean)false) == 0 || StringHelper.Compare((String)strDataType, (String)"SMCODELIST", (boolean)false) == 0) {
                                        bNumberMode = StringHelper.Compare((String)strDataType, (String)"NMCODELIST", (boolean)false) == 0;
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
                                            codeItemConfig = codeListConfig.FindCodeItemConfigByText(strText, true);
                                            if (codeItemConfig == null) {
                                                bValueMode = true;
                                                break;
                                            }
                                            if (bNumberMode) {
                                                nRealValue |= Integer.parseInt(codeItemConfig.getValue());
                                            } else {
                                                if (!StringHelper.IsNullOrEmpty((String)strRealValue)) {
                                                    strRealValue = String.valueOf(strRealValue) + codeListConfig.getSeparator();
                                                }
                                                strRealValue = String.valueOf(strRealValue) + codeItemConfig.getValue();
                                            }
                                            ++l;
                                        }
                                        if (bValueMode) {
                                            if (bNumberMode) {
                                                nRealValue = Integer.parseInt(strContent);
                                                dataEntity.SetParamValue(iDEFHelper.getName(), (Object)nRealValue);
                                            } else {
                                                strRealValue = strNewContent.replace(";", codeListConfig.getSeparator());
                                                dataEntity.SetParamValue(iDEFHelper.getName(), (Object)strRealValue);
                                            }
                                        } else if (bNumberMode) {
                                            dataEntity.SetParamValue(iDEFHelper.getName(), (Object)nRealValue);
                                        } else {
                                            dataEntity.SetParamValue(iDEFHelper.getName(), (Object)strRealValue);
                                        }
                                    } else {
                                        codeItemConfig = codeListConfig.FindCodeItemConfigByText(strContent, true);
                                        if (codeItemConfig == null && (codeItemConfig = codeListConfig.FindCodeItemConfigByValue(strContent, true)) == null && StringHelper.Compare((String)codeListConfig.getEmptyText(), (String)strContent, (boolean)true) != 0) {
                                            this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c \u4ee3\u7801\u8868[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)nRowIndex), (Object)strCodeListId, (Object)strContent);
                                            return;
                                        }
                                        dataEntity.SetParamValue(iDEFHelper.getName(), iDEFHelper.GetDEFValue(codeItemConfig.getValue()));
                                    }
                                } else if (iDEFHelper.IsLinkDEField()) {
                                    iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                                    if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0 || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"INHERIT", (boolean)true) == 0 && StringHelper.Compare((String)iLinkDEFHelper.GetRelatedDEFHelper().GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                                        iPickupDEFHelper = null;
                                        if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                                            iPickupDEFHelper = iLinkDEFHelper.getDEHelper().FindPickupDEFHelper(iLinkDEFHelper.GetDERId());
                                        } else {
                                            iLinkDEFHelper2 = (ILinkDEFHelper)iLinkDEFHelper.GetRelatedDEFHelper();
                                            iPickupDEFHelper = iLinkDEFHelper.GetRelatedDEFHelper().getDEHelper().FindPickupDEFHelper(iLinkDEFHelper2.GetDERId());
                                        }
                                        if (iPickupDEFHelper == null) {
                                            this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027[%2$s]\u76f8\u5173\u4fe1\u606f</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)nRowIndex), (Object)iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName());
                                            return;
                                        }
                                        if (!dataEntity.ContainesParam(iPickupDEFHelper.getName())) {
                                            iDataCtrl = (IDEDataCtrl)deDataCtrlMap.get(iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getId());
                                            callResult = this.SelectPickupData(iDEFHelper, iLinkDEFHelper, iDataCtrl, dataEntity, strContent, dataList = new Vector<BaseDataEntity>());
                                            if (callResult.IsError()) {
                                                this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u67e5\u8be2[%3$s]\u53d1\u751f\u9519\u8bef\uff0c%4$s</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)nRowIndex), (Object)iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(), (Object)strContent, (Object)callResult.getErrorInfo());
                                                return;
                                            }
                                            if (dataList.size() == 0) {
                                                this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)nRowIndex), (Object)iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(), (Object)strContent);
                                                return;
                                            }
                                            if (dataList.size() != 1) {
                                                this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u6709%4$s\u6761\u8bb0\u5f55\u7b26\u5408\u8be5\u540d\u79f0</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)nRowIndex), (Object)iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(), (Object)strContent, (Object)dataList.size());
                                                return;
                                            }
                                            dataEntity.SetParamValue(iPickupDEFHelper.getName(), dataList.get(0).GetParamValue(iPickupDEFHelper.GetRealDEFHelper().getName()));
                                        }
                                    } else {
                                        objValue = iLinkDEFHelper.GetRealDEFHelper().GetDEFValue(strContent);
                                        if (objValue == null) {
                                            this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)nRowIndex), (Object)iDEFHelper.getLogicName(), (Object)strContent);
                                            return;
                                        }
                                        dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                                    }
                                } else {
                                    objValue = iDEFHelper.GetDEFValue(strContent);
                                    if (objValue == null) {
                                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)nRowIndex), (Object)iDEFHelper.getLogicName(), (Object)strContent);
                                        return;
                                    }
                                    dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                                }
                            }
                            ++j;
                        }
                        if (!dataEntity.ContainesParam(strKeyFieldName) && importKeyList.size() > 0) {
                            bSelectKey = true;
                            cond = new BaseDataEntity();
                            iDEFHelper = importKeyList.iterator();
                            while (iDEFHelper.hasNext()) {
                                strKey = (String)iDEFHelper.next();
                                objValue = dataEntity.GetParamValue(strKey);
                                if (objValue == null) {
                                    bSelectKey = false;
                                    break;
                                }
                                cond.SetParamValue(strKey, objValue);
                            }
                            if (bSelectKey) {
                                iDEDataCtrl = this.GetDEDataCtrl();
                                tempList.clear();
                                callResult = iDEDataCtrl.Select(cond, tempList);
                                if (callResult.IsError()) {
                                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u8bb0\u5f55[%1$s]\u65e0\u6548\uff0c\u67e5\u8be2\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef\uff0c%2$s</SPAN><BR>", (Object)nRowIndex, (Object)callResult.getErrorInfo());
                                    return;
                                }
                                if (tempList.size() > 1) {
                                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u8bb0\u5f55[%1$s]\u65e0\u6548\uff0c\u67e5\u8be2\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef\uff0c\u5b58\u5728\u591a\u6761\u6ee1\u8db3\u5bfc\u5165\u8bc6\u522b\u9879\u7684\u6570\u636e\u3002</SPAN><BR>", (Object)nRowIndex);
                                    return;
                                }
                                if (tempList.size() == 1) {
                                    dataEntity.SetParamValue(strKeyFieldName, ((BaseDataEntity)tempList.get(0)).GetParamValue(strKeyFieldName));
                                }
                            }
                        }
                        dataEntities.add(dataEntity);
                        if (dataEntities.size() < 1000) continue;
                        if (!this.DoSaveData(dataEntities, true)) {
                            return;
                        }
                        dataEntities.clear();
                    }
                    if (dataEntities.size() > 0) {
                        if (!this.DoSaveData(dataEntities, true)) {
                            return;
                        }
                        dataEntities.clear();
                    }
                    break block229;
                }
                errSheet = null;
                errWorkbook = null;
                strErrorTempFilePath2 = "";
                if (!this.bStopWhenError) {
                    strErrorTempFilePath2 = StringHelper.Format((String)"%1$s%2$s_E.xls", (Object)strErrorFileFolder, (Object)strTempId);
                    errWorkbook = Workbook.createWorkbook((File)new File(String.valueOf(strFileLocalPath) + strErrorTempFilePath2));
                    errSheet = errWorkbook.createSheet("\u9519\u8bef\u6570\u636e", 0);
                }
                if ((workbook = Workbook.getWorkbook((File)new File(strTempFilePath))).getSheets().length < 1) {
                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>Excel\u4e2d\u6ca1\u6709\u5305\u542b\u4efb\u4f55\u6570\u636e\u5206\u9875\uff01</SPAN><BR>");
                    return;
                }
                dataSheet = workbook.getSheet(0);
                nCelLIndex = 0;
                nRowIndex = 0;
                cells = dataSheet.getRow(nRowIndex);
                i = 0;
                while (i < cells.length) {
                    strContent = cells[i].getContents();
                    if (StringHelper.IsNullOrEmpty((String)strContent)) {
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c\u5fc5\u987b\u8f93\u5165\u5185\u5bb9</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)nCelLIndex, (int)nRowIndex));
                        return;
                    }
                    strColumnName = (strContent = strContent.trim()).toUpperCase();
                    iDEFHelper = deFieldImpMap.get(strColumnName);
                    if (iDEFHelper == null) {
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61</SPAN><BR>", (Object)strColumnName);
                        return;
                    }
                    strCodeListId = iDEFHelper.GetCodeList();
                    if (!StringHelper.IsNullOrEmpty((String)strCodeListId) && !codeListMap.containsKey(strCodeListId)) {
                        codeListConfig = this.getWebContext().getGlobalHelper().getCodeListMgr().GetCodeListConfig(strCodeListId, this.getLanguage());
                        if (codeListConfig == null) {
                            this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u914d\u7f6e</SPAN><BR>", (Object)strCodeListId);
                            return;
                        }
                        codeListMap.put(strCodeListId, codeListConfig);
                    }
                    if (iDEFHelper.IsLinkDEField() && !deDataCtrlMap.containsKey(strDEId = (iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper).GetRealDEFHelper().getDEHelper().getId())) {
                        iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl(strDEId, (ISRFDAWebContext)this.getWebContext());
                        if (iDEDataCtrl == null) {
                            this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61</SPAN><BR>", (Object)strDEId);
                            return;
                        }
                        deDataCtrlMap.put(strDEId, iDEDataCtrl);
                    }
                    deFieldMap.put(i, iDEFHelper);
                    ++i;
                }
                if (!this.bStopWhenError) {
                    this.AddErrorSheetRow(errSheet, cells);
                }
                dataEntities = new Vector<BaseDataEntity>();
                nRowCount = dataSheet.getRows();
                i = 1;
                while (i < nRowCount) {
                    block230: {
                        block231: {
                            block232: {
                                bErrorFlag = false;
                                dataEntity = new BaseDataEntity();
                                cells = dataSheet.getRow(i);
                                j = 0;
                                while (j < cells.length) {
                                    bErrorFlag = false;
                                    strContent = "";
                                    try {
                                        strContent = cells[j].getContents();
                                    }
                                    catch (Exception ex) {
                                        this.PageLog(this, 1, ex.getMessage(), ex);
                                        strContent = cells[j].toString();
                                    }
                                    if (!StringHelper.IsNullOrEmpty((String)strContent) && !StringHelper.IsNullOrEmpty((String)(strContent = strContent.trim())) && StringHelper.Compare((String)(iDEFHelper = (IDEFHelper)deFieldMap.get(j)).GetDataType(), (String)"PICKUPDATA", (boolean)true) != 0) {
                                        strCodeListId = iDEFHelper.GetCodeList();
                                        if (!StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                                            codeListConfig = (CodeListConfig)codeListMap.get(strCodeListId);
                                            strDataType = iDEFHelper.GetDataType();
                                            if (StringHelper.Compare((String)strDataType, (String)"NMCODELIST", (boolean)false) == 0 || StringHelper.Compare((String)strDataType, (String)"SMCODELIST", (boolean)false) == 0) {
                                                bNumberMode = StringHelper.Compare((String)strDataType, (String)"NMCODELIST", (boolean)false) == 0;
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
                                                    codeItemConfig = codeListConfig.FindCodeItemConfigByText(strText, true);
                                                    if (codeItemConfig == null) {
                                                        bValueMode = true;
                                                        break;
                                                    }
                                                    if (bNumberMode) {
                                                        nRealValue |= Integer.parseInt(codeItemConfig.getValue());
                                                    } else {
                                                        if (!StringHelper.IsNullOrEmpty((String)strRealValue)) {
                                                            strRealValue = String.valueOf(strRealValue) + codeListConfig.getSeparator();
                                                        }
                                                        strRealValue = String.valueOf(strRealValue) + codeItemConfig.getValue();
                                                    }
                                                    ++l;
                                                }
                                                if (bValueMode) {
                                                    if (bNumberMode) {
                                                        nRealValue = Integer.parseInt(strContent);
                                                        dataEntity.SetParamValue(iDEFHelper.getName(), (Object)nRealValue);
                                                    } else {
                                                        strRealValue = strNewContent.replace(";", codeListConfig.getSeparator());
                                                        dataEntity.SetParamValue(iDEFHelper.getName(), (Object)strRealValue);
                                                    }
                                                } else if (bNumberMode) {
                                                    dataEntity.SetParamValue(iDEFHelper.getName(), (Object)nRealValue);
                                                } else {
                                                    dataEntity.SetParamValue(iDEFHelper.getName(), (Object)strRealValue);
                                                }
                                            } else {
                                                codeItemConfig = codeListConfig.FindCodeItemConfigByText(strContent, true);
                                                if (codeItemConfig == null && (codeItemConfig = codeListConfig.FindCodeItemConfigByValue(strContent, true)) == null && StringHelper.Compare((String)codeListConfig.getEmptyText(), (String)strContent, (boolean)true) != 0) {
                                                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c \u4ee3\u7801\u8868[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)i), (Object)strCodeListId, (Object)strContent);
                                                    if (!this.bStopWhenError) {
                                                        bErrorFlag = true;
                                                        this.AddErrorSheetRow(errSheet, cells);
                                                        break;
                                                    }
                                                    return;
                                                }
                                                dataEntity.SetParamValue(iDEFHelper.getName(), iDEFHelper.GetDEFValue(codeItemConfig.getValue()));
                                            }
                                        } else if (iDEFHelper.IsLinkDEField()) {
                                            iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                                            if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0 || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"INHERIT", (boolean)true) == 0 && StringHelper.Compare((String)iLinkDEFHelper.GetRelatedDEFHelper().GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                                                iPickupDEFHelper = null;
                                                if (StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                                                    iPickupDEFHelper = iLinkDEFHelper.getDEHelper().FindPickupDEFHelper(iLinkDEFHelper.GetDERId());
                                                } else {
                                                    iLinkDEFHelper2 = (ILinkDEFHelper)iLinkDEFHelper.GetRelatedDEFHelper();
                                                    iPickupDEFHelper = iLinkDEFHelper.GetRelatedDEFHelper().getDEHelper().FindPickupDEFHelper(iLinkDEFHelper2.GetDERId());
                                                }
                                                if (iPickupDEFHelper == null) {
                                                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5c5e\u6027[%2$s]\u76f8\u5173\u4fe1\u606f</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)i), (Object)iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName());
                                                    if (!this.bStopWhenError) {
                                                        bErrorFlag = true;
                                                        this.AddErrorSheetRow(errSheet, cells);
                                                        break;
                                                    }
                                                    return;
                                                }
                                                if (!dataEntity.ContainesParam(iPickupDEFHelper.getName())) {
                                                    iDataCtrl = (IDEDataCtrl)deDataCtrlMap.get(iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getId());
                                                    callResult = this.SelectPickupData(iDEFHelper, iLinkDEFHelper, iDataCtrl, dataEntity, strContent, dataList = new Vector<BaseDataEntity>());
                                                    if (callResult.IsError()) {
                                                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u67e5\u8be2[%3$s]\u53d1\u751f\u9519\u8bef\uff0c%4$s</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)i), (Object)iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(), (Object)strContent, (Object)callResult.getErrorInfo());
                                                        if (!this.bStopWhenError) {
                                                            bErrorFlag = true;
                                                            this.AddErrorSheetRow(errSheet, cells);
                                                            break;
                                                        }
                                                        return;
                                                    }
                                                    if (dataList.size() == 0) {
                                                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)i), (Object)iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(), (Object)strContent);
                                                        if (!this.bStopWhenError) {
                                                            bErrorFlag = true;
                                                            this.AddErrorSheetRow(errSheet, cells);
                                                            break;
                                                        }
                                                        return;
                                                    }
                                                    if (dataList.size() != 1) {
                                                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u6709%4$s\u6761\u8bb0\u5f55\u7b26\u5408\u8be5\u540d\u79f0</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)i), (Object)iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(), (Object)strContent, (Object)dataList.size());
                                                        if (!this.bStopWhenError) {
                                                            bErrorFlag = true;
                                                            this.AddErrorSheetRow(errSheet, cells);
                                                            break;
                                                        }
                                                        return;
                                                    }
                                                    dataEntity.SetParamValue(iPickupDEFHelper.getName(), dataList.get(0).GetParamValue(iPickupDEFHelper.GetRealDEFHelper().getName()));
                                                }
                                            } else {
                                                objValue = iLinkDEFHelper.GetRealDEFHelper().GetDEFValue(strContent);
                                                if (objValue == null) {
                                                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)i), (Object)iDEFHelper.getLogicName(), (Object)strContent);
                                                    if (!this.bStopWhenError) {
                                                        bErrorFlag = true;
                                                        this.AddErrorSheetRow(errSheet, cells);
                                                        break;
                                                    }
                                                    return;
                                                }
                                                dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                                            }
                                        } else {
                                            objValue = iDEFHelper.GetDEFValue(strContent);
                                            if (objValue == null) {
                                                this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5355\u5143\u683c[%1$s]\u65e0\u6548\uff0c[%2$s]\u65e0\u6cd5\u8bc6\u522b[%3$s]\uff0c\u8bf7\u786e\u8ba4\u6570\u636e\u7c7b\u578b\u662f\u5426\u6b63\u786e\uff01</SPAN><BR>", (Object)SRFCellFuncHelper.GetCellSN((int)j, (int)i), (Object)iDEFHelper.getLogicName(), (Object)strContent);
                                                if (!this.bStopWhenError) {
                                                    bErrorFlag = true;
                                                    this.AddErrorSheetRow(errSheet, cells);
                                                    break;
                                                }
                                                return;
                                            }
                                            dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                                        }
                                    }
                                    ++j;
                                }
                                if (bErrorFlag) break block230;
                                if (dataEntity.ContainesParam(strKeyFieldName) || importKeyList.size() <= 0) ** GOTO lbl428
                                bSelectKey = true;
                                cond = new BaseDataEntity();
                                for (String strKey : importKeyList) {
                                    objValue = dataEntity.GetParamValue(strKey);
                                    if (objValue == null) {
                                        bSelectKey = false;
                                        break;
                                    }
                                    cond.SetParamValue(strKey, objValue);
                                }
                                if (!bSelectKey) ** GOTO lbl428
                                iDEDataCtrl = this.GetDEDataCtrl();
                                tempList.clear();
                                callResult = iDEDataCtrl.Select(cond, tempList);
                                if (!callResult.IsError()) break block231;
                                this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u8bb0\u5f55[%1$s]\u65e0\u6548\uff0c\u67e5\u8be2\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef\uff0c%2$s</SPAN><BR>", (Object)nRowIndex, (Object)callResult.getErrorInfo());
                                if (this.bStopWhenError) break block232;
                                this.AddErrorSheetRow(errSheet, cells);
                                break block230;
                            }
                            return;
                        }
                        if (tempList.size() <= 1) ** GOTO lbl426
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u8bb0\u5f55[%1$s]\u65e0\u6548\uff0c\u67e5\u8be2\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef\uff0c\u5b58\u5728\u591a\u6761\u6ee1\u8db3\u5bfc\u5165\u8bc6\u522b\u9879\u7684\u6570\u636e\u3002</SPAN><BR>", (Object)nRowIndex);
                        if (!this.bStopWhenError) {
                            this.AddErrorSheetRow(errSheet, cells);
                        } else {
                            return;
lbl426:
                            // 1 sources

                            if (tempList.size() == 1) {
                                dataEntity.SetParamValue(strKeyFieldName, ((BaseDataEntity)tempList.get(0)).GetParamValue(strKeyFieldName));
                            }
lbl428:
                            // 5 sources

                            dataEntities.add(dataEntity);
                            if (!this.bStopWhenError) {
                                if (!this.DoSaveData(dataEntities, false)) {
                                    this.AddErrorSheetRow(errSheet, cells);
                                }
                                dataEntities.clear();
                            } else if (dataEntities.size() >= 1000) {
                                if (!this.DoSaveData(dataEntities, false)) {
                                    return;
                                }
                                dataEntities.clear();
                            }
                        }
                    }
                    ++i;
                }
                if (dataEntities.size() > 0) {
                    if (!this.DoSaveData(dataEntities, false)) {
                        return;
                    }
                    dataEntities.clear();
                }
                if (this.bStopWhenError) break block229;
                errWorkbook.write();
                errWorkbook.close();
                if (this.nErrorRowIndex <= 1) break block229;
                fileDEDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0010", (ISRFDAWebContext)this.getWebContext());
                if (fileDEDataCtrl == null) {
                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[FILE]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61</SPAN><BR>");
                    return;
                }
                try {
                    strErrorTempFilePath2 = StringHelper.Format((String)"%1$s%2$s_E.xls", (Object)strErrorFileFolder, (Object)strTempId);
                    saveFile = new SA.SRFDA.Ctrl.Data.File();
                    saveFile.setFILESIZE(0);
                    saveFile.setFILE_NAME("\u65e0\u6cd5\u5bfc\u5165\u6570\u636e.xls");
                    saveFile.setLOCALPATH(strErrorTempFilePath2);
                    saveFile.setFOLDER("TEMP");
                    callResult = fileDEDataCtrl.Save(true, (BaseDataEntity)saveFile);
                    if (callResult.getRetCode() != 0) {
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u4fdd\u5b58\u9519\u8bef\u6587\u4ef6\u51fa\u73b0\u9519\u8bef\uff0c%1$s</SPAN><BR>", (Object)callResult.getErrorInfo());
                        break block229;
                    }
                    this.strErrorFileLink = StringHelper.Format((String)"<A href=\"../srfpage/exportfile.jsp?FILEID=%1$s\" target=\"_blank\">\u4e0b\u8f7d\u5bfc\u5165\u5931\u8d25\u6570\u636e\u6587\u4ef6</a>", (Object)saveFile.getFILE_ID());
                }
                catch (Exception ex) {
                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5bfc\u5165\u6570\u636e\u8fc7\u7a0b\u4e2d\u53d1\u751f\u9519\u8bef\uff0c%1$s!</SPAN><BR>", (Object)ex.getMessage());
                    ex.printStackTrace();
                }
            }
            finally {
                if (accessUtil != null) {
                    try {
                        accessUtil.CloseConnection();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    accessUtil = null;
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean DoSaveData(Vector<BaseDataEntity> dataEntities, boolean bAccess) {
        CallResult callResult = null;
        IDEDataCtrl iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl(this.strPageDataEntityId, (ISRFDAWebContext)this.getWebContext());
        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        transactionManager.Register(iDEDataCtrl);
        try {
            for (BaseDataEntity dataEntity : dataEntities) {
                String strErrorInfo;
                String strErrorFormat;
                BaseDataEntity checkkeyparam;
                boolean bInsert;
                boolean bl = bInsert = !dataEntity.ContainesParam(this.getDEHelper().GetKeyDEFHelper().getName());
                if (!bInsert) {
                    checkkeyparam = new BaseDataEntity();
                    dataEntity.CopyTo(checkkeyparam, true);
                    callResult = iDEDataCtrl.CheckKeyState(checkkeyparam);
                    if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
                        transactionManager.Rollback();
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u65e0\u6548\uff0c\u68c0\u67e5\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef!</SPAN><BR>", (Object)(this.nRowIndex2 + 1));
                        return false;
                    }
                    int nState = (Integer)callResult.getUserObject();
                    if (nState == 0) {
                        bInsert = true;
                    } else {
                        if (nState != 1) {
                            transactionManager.Rollback();
                            this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u65e0\u6548\uff0c%2$s!</SPAN><BR>", (Object)(this.nRowIndex2 + 1), (Object)this.getPage().GetLocalization("CTRL.FORMAH.DATAALREADYREMOVED", "\u8be5\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!"));
                            return false;
                        }
                        bInsert = false;
                    }
                } else if (!StringHelper.IsNullOrEmpty((String)this.strMultiKeys)) {
                    checkkeyparam = new BaseDataEntity();
                    dataEntity.CopyTo(checkkeyparam, this.strMultiKeys, true);
                    callResult = iDEDataCtrl.Select(checkkeyparam);
                    if (callResult.IsError()) {
                        if (callResult.getRetCode() != 3) {
                            transactionManager.Rollback();
                            this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u65e0\u6548\uff0c\u68c0\u67e5\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef!</SPAN><BR>", (Object)(this.nRowIndex2 + 1));
                            return false;
                        }
                        bInsert = true;
                    } else {
                        bInsert = false;
                        dataEntity.SetParamValue(this.strKeyName, checkkeyparam.GetParamValue(this.strKeyName));
                    }
                }
                for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                    if (bInsert || iDEFHelper.IsKeyDEField() || iDEFHelper.GetFormCtrl().IsEnableFormUpdate()) continue;
                    dataEntity.RemoveParam(iDEFHelper.getName());
                }
                if (bInsert) {
                    for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                        if (iDEFHelper.IsKeyDEField()) continue;
                        String strDVT = iDEFHelper.GetFormCtrl().GetDefaultValueType();
                        String strDV = iDEFHelper.GetFormCtrl().GetDefaultValue();
                        if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0 || dataEntity.ContainesParam(iDEFHelper.getName())) continue;
                        dataEntity.SetParamValue(iDEFHelper.getName(), DADVHelper.GetDefaultValue((SRFExWebContext)this.getWebContext(), (String)strDVT, (String)strDV, (String)iDEFHelper.GetStdDataType()));
                    }
                }
                if (bInsert) {
                    this.FillDataEntityParentInfo(dataEntity);
                    callResult = this.OnSaveActionBeforeInsert(dataEntity);
                    if (callResult.getRetCode() != 0) {
                        strErrorFormat = this.getPage().GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s");
                        strErrorInfo = StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo());
                        transactionManager.Rollback();
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u5931\u8d25\uff0c%2$s!</SPAN><BR>", (Object)(this.nRowIndex2 + 1), (Object)strErrorInfo);
                        return false;
                    }
                    callResult = this.OnSaveData(iDEDataCtrl, true, this.strInsertMode, dataEntity);
                } else {
                    callResult = this.OnSaveActionBeforeUpdate(dataEntity);
                    if (callResult.getRetCode() != 0) {
                        strErrorFormat = this.getPage().GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s");
                        strErrorInfo = StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo());
                        transactionManager.Rollback();
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u5931\u8d25\uff0c%2$s!</SPAN><BR>", (Object)(this.nRowIndex2 + 1), (Object)strErrorInfo);
                        return false;
                    }
                    callResult = this.OnSaveData(iDEDataCtrl, false, this.strUpdateMode, dataEntity);
                }
                if (callResult.IsError()) {
                    transactionManager.Rollback();
                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u5931\u8d25\uff0c%2$s!</SPAN><BR>", (Object)(this.nRowIndex2 + 1), (Object)callResult.getErrorInfo());
                    return false;
                }
                this.processInfo.Append("<SPAN class='sx-normaltext'>\u884c\u6570\u636e[%1$s]\u4fdd\u5b58\u6210\u529f\uff0c%2$s!</SPAN><BR>", (Object)(this.nRowIndex2 + 1), (Object)this.getDEHelper().GetDataInfo(dataEntity));
                ++this.nRowIndex2;
                transactionManager.CommitAndBegin();
            }
            transactionManager.Commit();
            return true;
        }
        catch (Exception ex) {
            transactionManager.Rollback();
            this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u5bfc\u5165\u6570\u636e\u8fc7\u7a0b\u4e2d\u53d1\u751f\u9519\u8bef\uff0c%1$s!</SPAN><BR>", (Object)ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    protected CallResult OnSaveData(IDEDataCtrl iDEDataCtrl, boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        return iDEDataCtrl.Save(bInsert, strActionMode, dataEntity);
    }

    protected CallResult OnSaveActionBeforeInsert(BaseDataEntity dataEntity) {
        CallResult callResult = this.OnTestDataAction(dataEntity, this.strInsertDataAction);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        return this.GetDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
        CallResult callResult = this.OnTestDataAction(dataEntity, this.strUpdateDataAction);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        return this.GetDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected String GetDataLockKey(BaseDataEntity dataEntity) {
        try {
            return this.getDEHelper().GetDataLockKey((ISRFDAWebContext)this.getWebContext(), dataEntity);
        }
        catch (Exception ex) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5bf9\u8c61\u9501\u94a5\u5319\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction) {
        return this.getDEHelper().GetDataAccHelper().Test((ISRFDAWebContext)this.getWebContext(), dataEntity, strAction);
    }

    public String OutputProcessInfo() {
        return this.processInfo.toString();
    }

    public String OutputErrorFileLink() {
        return this.strErrorFileLink;
    }

    protected void FillDataEntityParentInfo(BaseDataEntity dataEntity) {
        if (StringHelper.IsNullOrEmpty((String)this.strPKeyName)) {
            return;
        }
        Object objValue = dataEntity.GetParamValue(this.strPKeyName);
        if (objValue == null) {
            dataEntity.SetParamValue(this.strPKeyName, this.objPKeyValue);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void FillParentDataEntity() {
        String strDERID = this.getWebContext().getSRFDERID();
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            return;
        }
        IPickupDEFHelper pickupDEFHelper = this.getDEHelper().FindPickupDEFHelper(strDERID);
        if (pickupDEFHelper == null) {
            DER1N der1n = new DER1N();
            CallResult callResult = this.getDAModelHelper().GetDER1N(strDERID, der1n);
            if (callResult.getRetCode() != 0) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERID, (Object)callResult.getErrorInfo()));
                return;
            }
            IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(der1n.getMAJORKEYDEFNAME());
            if (iDEFHelper == null) {
                return;
            }
            if (!(iDEFHelper instanceof IPickupDEFHelper)) {
                if (!(iDEFHelper instanceof IInheritDEFHelper)) {
                    return;
                }
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                if (!(inheritDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) return;
                pickupDEFHelper = (IPickupDEFHelper)inheritDEFHelper.GetRelatedDEFHelper();
            } else {
                pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            }
            strDERID = pickupDEFHelper.GetDERId();
            this.getWebContext().SetParamValue("SRFDERID", strDERID);
        }
        if (!pickupDEFHelper.GetRealDEFHelper().GetDTColumn().IsPKey()) {
            return;
        }
        String strKeyValue = this.getWebContext().GetParamValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            if (!pickupDEFHelper.GetRealDEFHelper().getDEHelper().IsIndexDE()) return;
            Vector list = pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDERINDEXs(true);
            boolean bFind = false;
            for (DERINDEX dERINDEX : list) {
                IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
                if (iDEHelper == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dERINDEX.getDEID()));
                    continue;
                }
                strKeyValue = this.getWebContext().GetParamValue(iDEHelper.GetKeyDEFHelper().getName());
                if (StringHelper.IsNullOrEmpty((String)strKeyValue)) continue;
                bFind = true;
                break;
            }
            if (!bFind) {
                return;
            }
        }
        this.strPKeyName = pickupDEFHelper.GetFormCtrl().GetFormCtrlId();
        this.objPKeyValue = strKeyValue;
    }

    protected void AddErrorSheetRow(WritableSheet s1, Cell[] cells) {
        try {
            if (this.nErrorRowIndex != 0) {
                ++this.nRowIndex2;
            }
            int i = 0;
            while (i < cells.length) {
                Label l = new Label(i, this.nErrorRowIndex, cells[i].getContents());
                s1.addCell((WritableCell)l);
                if (this.nErrorRowIndex == 0) {
                    s1.setColumnView(i, 30);
                }
                ++i;
            }
            ++this.nErrorRowIndex;
        }
        catch (Exception ex) {
            this.PageLog(this, 1, ex.getMessage(), ex);
        }
    }

    protected void OnAfterFillDEFieldImpMap(TreeMap<String, IDEFHelper> deFieldImpMap) {
    }

    protected CallResult SelectPickupData(IDEFHelper iDEFHelper, ILinkDEFHelper iLinkDEFHelper, IDEDataCtrl iDataCtrl, BaseDataEntity dataEntity, String strContent, Vector<BaseDataEntity> dataList) {
        BaseDataEntity temp = new BaseDataEntity();
        temp.SetParamValue(iLinkDEFHelper.GetRealDEFHelper().getName(), iDEFHelper.GetDEFValue(strContent));
        return iDataCtrl.Select(temp, dataList);
    }
}

