package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.AccessUtil;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.ReportEx.SRFCellFuncHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Utility.DADVHelper;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UploadDEDataExcelActionPage2 extends BaseMainPage {
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
      if (!super.PreparePageEnv()) {
         return false;
      }

      this.strPageDataEntityId = this.getWebContext().getSRFDEID();
      if (StringHelper.IsNullOrEmpty(this.strPageDataEntityId)) {
         this.PageLog(this, 1, StringHelper.Format("没有指定实体编号"));
         return false;
      }

      if (!this.LoadPageDataEntity()) {
         this.PageLog(this, 1, StringHelper.Format("加载页面实体[%1$s]失败", this.strPageDataEntityId));
         return false;
      }

      this.strKeyName = this.getDEHelper().GetKeyDEFHelper().getName();
      String strDEDataImport = this.getWebContext().GetParamValue("SRFDEDATAIMPORT");
      if (!StringHelper.IsNullOrEmpty(strDEDataImport)) {
         DEDataImport deDataImport = this.getDEHelper().GetDataImport(strDEDataImport);
         if (deDataImport == null) {
            this.PageLog(this, 1, StringHelper.Format("无法获取实体[%1$s]数据导入模式[%2$s]", this.getDEHelper().getId(), strDEDataImport));
            return false;
         }

         if (!deDataImport.isSTOPWHENERRORNull()) {
            this.bStopWhenError = deDataImport.getSTOPWHENERROR();
         }

         if (deDataImport.getMultiKeys() != null && deDataImport.getMultiKeys().size() > 0) {
            for (String strKey : deDataImport.getMultiKeys()) {
               if (!StringHelper.IsNullOrEmpty(this.strMultiKeys)) {
                  this.strMultiKeys = this.strMultiKeys + ";";
               }

               this.strMultiKeys = this.strMultiKeys + strKey;
            }
         }

         if (!StringHelper.IsNullOrEmpty(deDataImport.getINSERTMODE())) {
            this.strInsertMode = deDataImport.getINSERTMODE();
         }

         if (!StringHelper.IsNullOrEmpty(deDataImport.getUPDATEMODE())) {
            this.strUpdateMode = deDataImport.getUPDATEMODE();
         }

         if (!StringHelper.IsNullOrEmpty(deDataImport.getINSERTDATAACTION())) {
            this.strInsertDataAction = deDataImport.getINSERTDATAACTION();
         }

         if (!StringHelper.IsNullOrEmpty(deDataImport.getUPDATEDATAACTION())) {
            this.strUpdateDataAction = deDataImport.getUPDATEDATAACTION();
         }
      }

      this.FillParentDataEntity();
      if (StringHelper.Compare(this.getPageModel(), "SL", true) == 0) {
         String strReferPageId = this.getWebContext().GetParamValue("SRFREFERPAGEID");
         if (!StringHelper.IsNullOrEmpty(strReferPageId)) {
            StringBuilderEx sb = new StringBuilderEx();
            sb.Append(
               "if(window.opener&&!window.opener.closed && window.opener.SLApp){ var page=window.opener.SLApp.GetPage('%1$s'); if(page!=null){page.refresh();}}",
               strReferPageId
            );
            this.getPage().RegisterScript(5, sb.toString());
         }
      }

      return true;
   }

   @Override
   protected void OnInitComponents() {
      super.OnInitComponents();
      AccessUtil accessUtil = null;

      try {
         String strFileLocalPath = this.webContext.getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
         String strErrorFileFolder = "";
         strErrorFileFolder = strErrorFileFolder + "TEMP";
         strErrorFileFolder = strErrorFileFolder + File.separator;
         strErrorFileFolder = strErrorFileFolder + StringHelper.Format("%1$tY-%1$tm-%1$td", new Date());
         strErrorFileFolder = strErrorFileFolder + File.separator;
         File dir = new File(strFileLocalPath + strErrorFileFolder);
         dir.mkdirs();
         SmartUpload su = new SmartUpload();
         su.initialize(this.pageContext);
         su.upload();
         int nCount = su.getFiles().getCount();
         if (nCount != 0) {
            String strTempId = Helper.GenGuidEx();
            String strTempFilePath = "";
            SmartFile file = su.getFiles().getFile(0);
            boolean bAccess = false;
            if (StringHelper.Compare(file.getFileExt(), "mdb", true) == 0) {
               bAccess = true;
            }

            if (bAccess) {
               this.nRowIndex2--;
               strTempFilePath = StringHelper.Format("%1$s%2$s.%3$s", this.getWebContext().getGlobalHelper().GetTempPath(), strTempId, file.getFileExt());
            } else {
               strTempFilePath = StringHelper.Format("%1$s%2$s.%3$s", this.getWebContext().getGlobalHelper().GetTempPath(), strTempId, file.getFileExt());
            }

            file.saveAs(strTempFilePath);
            TreeMap<Integer, IDEFHelper> deFieldMap = new TreeMap<>();
            TreeMap<String, CodeListConfig> codeListMap = new TreeMap<>();
            TreeMap<String, IDEDataCtrl> deDataCtrlMap = new TreeMap<>();
            TreeMap<String, IDEFHelper> deFieldImpMap = new TreeMap<>();
            Vector<String> importKeyList = new Vector<>();
            Vector<BaseDataEntity> tempList = new Vector<>();
            String strKeyFieldName = this.getDEHelper().GetKeyDEFHelper().getName();

            for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
               if (iDEFHelper.getDEField().getEXCELIMPORDER() != -1) {
                  if (iDEFHelper.getDEField().getEXCELIMPKEY()) {
                     importKeyList.add(iDEFHelper.GetDTColumn().GetColumnName());
                  }

                  deFieldImpMap.put(iDEFHelper.getDEField().getEXCELIMPID().toUpperCase(), iDEFHelper);
               }
            }

            this.OnAfterFillDEFieldImpMap(deFieldImpMap);
            if (bAccess) {
               accessUtil = new AccessUtil();
               accessUtil.ConnectAccessDB(strTempFilePath);
               ResultSet rs = accessUtil.ExecuteQuerySql("SELECT * FROM TABLE1");
               TreeMap<String, Integer> columnIndextable = new TreeMap<>();
               ResultSetMetaData rsmd = rs.getMetaData();
               int numberOfColumns = rsmd.getColumnCount();

               for (int i = 1; i <= numberOfColumns; i++) {
                  columnIndextable.put(rsmd.getColumnName(i).toUpperCase(), i - 1);
               }

               for (String strContent : columnIndextable.keySet()) {
                  strContent = strContent.trim();
                  String strColumnName = strContent.toUpperCase();
                  IDEFHelper iDEFHelper = deFieldImpMap.get(strColumnName);
                  if (iDEFHelper == null) {
                     if (StringHelper.Compare(strColumnName, "ID", true) != 0) {
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>无法获取属性[%1$s]辅助对象</SPAN><BR>", strColumnName);
                        return;
                     }
                  } else {
                     String strCodeListId = iDEFHelper.GetCodeList();
                     if (!StringHelper.IsNullOrEmpty(strCodeListId) && !codeListMap.containsKey(strCodeListId)) {
                        CodeListConfig codeListConfig = this.getWebContext()
                           .getGlobalHelper()
                           .getCodeListMgr()
                           .GetCodeListConfig(strCodeListId, this.getLanguage());
                        if (codeListConfig == null) {
                           this.processInfo.Append("<SPAN class='sx-normaltext-red'>无法获取代码表[%1$s]配置</SPAN><BR>", strCodeListId);
                           return;
                        }

                        codeListMap.put(strCodeListId, codeListConfig);
                     }

                     if (iDEFHelper.IsLinkDEField()) {
                        ILinkDEFHelper iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                        String strDEId = iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getId();
                        if (!deDataCtrlMap.containsKey(strDEId)) {
                           IDEDataCtrl iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl(strDEId, this.getWebContext());
                           if (iDEDataCtrl == null) {
                              this.processInfo.Append("<SPAN class='sx-normaltext-red'>无法获取实体[%1$s]数据操作对象</SPAN><BR>", strDEId);
                              return;
                           }

                           deDataCtrlMap.put(strDEId, iDEDataCtrl);
                        }
                     }

                     deFieldMap.put(columnIndextable.get(strContent), iDEFHelper);
                  }
               }

               Vector<BaseDataEntity> dataEntities = new Vector<>();
               int nRowIndex = -1;

               while (rs.next()) {
                  BaseDataEntity dataEntity = new BaseDataEntity();

                  for (int j = 0; j < numberOfColumns; j++) {
                     Object objContent = rs.getObject(j + 1);
                     if (objContent != null) {
                        String strContent = objContent.toString();
                        if (!StringHelper.IsNullOrEmpty(strContent)) {
                           strContent = strContent.trim();
                           if (!StringHelper.IsNullOrEmpty(strContent)) {
                              IDEFHelper iDEFHelper = deFieldMap.get(j);
                              if (iDEFHelper != null && StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUPDATA", true) != 0) {
                                 String strCodeListId = iDEFHelper.GetCodeList();
                                 if (!StringHelper.IsNullOrEmpty(strCodeListId)) {
                                    CodeListConfig codeListConfig = codeListMap.get(strCodeListId);
                                    String strDataType = iDEFHelper.GetDataType();
                                    if (StringHelper.Compare(strDataType, "NMCODELIST", false) != 0
                                       && StringHelper.Compare(strDataType, "SMCODELIST", false) != 0) {
                                       CodeItemConfig codeItemConfig = codeListConfig.FindCodeItemConfigByText(strContent, true);
                                       if (codeItemConfig == null) {
                                          codeItemConfig = codeListConfig.FindCodeItemConfigByValue(strContent, true);
                                          if (codeItemConfig == null && StringHelper.Compare(codeListConfig.getEmptyText(), strContent, true) != 0) {
                                             this.processInfo
                                                .Append(
                                                   "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效， 代码表[%2$s]无法识别[%3$s]</SPAN><BR>",
                                                   SRFCellFuncHelper.GetCellSN(j, nRowIndex),
                                                   strCodeListId,
                                                   strContent
                                                );
                                             return;
                                          }
                                       }

                                       dataEntity.SetParamValue(iDEFHelper.getName(), iDEFHelper.GetDEFValue(codeItemConfig.getValue()));
                                    } else {
                                       boolean bNumberMode = StringHelper.Compare(strDataType, "NMCODELIST", false) == 0;
                                       int nRealValue = 0;
                                       String strRealValue = "";
                                       String strNewContent = strContent;
                                       strNewContent = strNewContent.replace("|", ";");
                                       strNewContent = strNewContent.replace(",", ";");
                                       strNewContent = strNewContent.replace("，", ";");
                                       strNewContent = strNewContent.replace("、", ";");
                                       String[] items = strNewContent.split("[;]");
                                       boolean bValueMode = false;

                                       for (int l = 0; l < items.length; l++) {
                                          String strText = items[l];
                                          CodeItemConfig codeItemConfig = codeListConfig.FindCodeItemConfigByText(strText, true);
                                          if (codeItemConfig == null) {
                                             bValueMode = true;
                                             break;
                                          }

                                          if (bNumberMode) {
                                             nRealValue |= Integer.parseInt(codeItemConfig.getValue());
                                          } else {
                                             if (!StringHelper.IsNullOrEmpty(strRealValue)) {
                                                strRealValue = strRealValue + codeListConfig.getSeparator();
                                             }

                                             strRealValue = strRealValue + codeItemConfig.getValue();
                                          }
                                       }

                                       if (bValueMode) {
                                          if (bNumberMode) {
                                             nRealValue = Integer.parseInt(strContent);
                                             dataEntity.SetParamValue(iDEFHelper.getName(), nRealValue);
                                          } else {
                                             strRealValue = strNewContent.replace(";", codeListConfig.getSeparator());
                                             dataEntity.SetParamValue(iDEFHelper.getName(), strRealValue);
                                          }
                                       } else if (bNumberMode) {
                                          dataEntity.SetParamValue(iDEFHelper.getName(), nRealValue);
                                       } else {
                                          dataEntity.SetParamValue(iDEFHelper.getName(), strRealValue);
                                       }
                                    }
                                 } else if (!iDEFHelper.IsLinkDEField()) {
                                    Object objValue = iDEFHelper.GetDEFValue(strContent);
                                    if (objValue == null) {
                                       this.processInfo
                                          .Append(
                                             "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！</SPAN><BR>",
                                             SRFCellFuncHelper.GetCellSN(j, nRowIndex),
                                             iDEFHelper.getLogicName(),
                                             strContent
                                          );
                                       return;
                                    }

                                    dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                                 } else {
                                    ILinkDEFHelper iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                                    if (StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUPTEXT", true) == 0
                                       || StringHelper.Compare(iDEFHelper.GetDataType(), "INHERIT", true) == 0
                                          && StringHelper.Compare(iLinkDEFHelper.GetRelatedDEFHelper().GetDataType(), "PICKUPTEXT", true) == 0) {
                                       IPickupDEFHelper iPickupDEFHelper = null;
                                       if (StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUPTEXT", true) == 0) {
                                          iPickupDEFHelper = iLinkDEFHelper.getDEHelper().FindPickupDEFHelper(iLinkDEFHelper.GetDERId());
                                       } else {
                                          ILinkDEFHelper iLinkDEFHelper2 = (ILinkDEFHelper)iLinkDEFHelper.GetRelatedDEFHelper();
                                          iPickupDEFHelper = iLinkDEFHelper.GetRelatedDEFHelper().getDEHelper().FindPickupDEFHelper(iLinkDEFHelper2.GetDERId());
                                       }

                                       if (iPickupDEFHelper == null) {
                                          this.processInfo
                                             .Append(
                                                "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，无法获取指定属性[%2$s]相关信息</SPAN><BR>",
                                                SRFCellFuncHelper.GetCellSN(j, nRowIndex),
                                                iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName()
                                             );
                                          return;
                                       }

                                       if (!dataEntity.ContainesParam(iPickupDEFHelper.getName())) {
                                          IDEDataCtrl iDataCtrl = deDataCtrlMap.get(iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getId());
                                          Vector<BaseDataEntity> dataList = new Vector<>();
                                          CallResult callResult = this.SelectPickupData(iDEFHelper, iLinkDEFHelper, iDataCtrl, dataEntity, strContent, dataList);
                                          if (callResult.IsError()) {
                                             this.processInfo
                                                .Append(
                                                   "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]查询[%3$s]发生错误，%4$s</SPAN><BR>",
                                                   SRFCellFuncHelper.GetCellSN(j, nRowIndex),
                                                   iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(),
                                                   strContent,
                                                   callResult.getErrorInfo()
                                                );
                                             return;
                                          }

                                          if (dataList.size() == 0) {
                                             this.processInfo
                                                .Append(
                                                   "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]</SPAN><BR>",
                                                   SRFCellFuncHelper.GetCellSN(j, nRowIndex),
                                                   iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(),
                                                   strContent
                                                );
                                             return;
                                          }

                                          if (dataList.size() != 1) {
                                             this.processInfo
                                                .Append(
                                                   "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，有%4$s条记录符合该名称</SPAN><BR>",
                                                   SRFCellFuncHelper.GetCellSN(j, nRowIndex),
                                                   iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(),
                                                   strContent,
                                                   dataList.size()
                                                );
                                             return;
                                          }

                                          dataEntity.SetParamValue(
                                             iPickupDEFHelper.getName(), dataList.get(0).GetParamValue(iPickupDEFHelper.GetRealDEFHelper().getName())
                                          );
                                       }
                                    } else {
                                       Object objValue = iLinkDEFHelper.GetRealDEFHelper().GetDEFValue(strContent);
                                       if (objValue == null) {
                                          this.processInfo
                                             .Append(
                                                "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！</SPAN><BR>",
                                                SRFCellFuncHelper.GetCellSN(j, nRowIndex),
                                                iDEFHelper.getLogicName(),
                                                strContent
                                             );
                                          return;
                                       }

                                       dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (!dataEntity.ContainesParam(strKeyFieldName) && importKeyList.size() > 0) {
                     boolean bSelectKey = true;
                     BaseDataEntity cond = new BaseDataEntity();

                     for (String strKey : importKeyList) {
                        Object objValue = dataEntity.GetParamValue(strKey);
                        if (objValue == null) {
                           bSelectKey = false;
                           break;
                        }

                        cond.SetParamValue(strKey, objValue);
                     }

                     if (bSelectKey) {
                        IDEDataCtrl iDEDataCtrl = this.GetDEDataCtrl();
                        tempList.clear();
                        CallResult callResult = iDEDataCtrl.Select(cond, tempList);
                        if (callResult.IsError()) {
                           this.processInfo
                              .Append("<SPAN class='sx-normaltext-red'>行记录[%1$s]无效，查询数据主键发生错误，%2$s</SPAN><BR>", nRowIndex, callResult.getErrorInfo());
                           return;
                        }

                        if (tempList.size() > 1) {
                           this.processInfo.Append("<SPAN class='sx-normaltext-red'>行记录[%1$s]无效，查询数据主键发生错误，存在多条满足导入识别项的数据。</SPAN><BR>", nRowIndex);
                           return;
                        }

                        if (tempList.size() == 1) {
                           dataEntity.SetParamValue(strKeyFieldName, tempList.get(0).GetParamValue(strKeyFieldName));
                        }
                     }
                  }

                  dataEntities.add(dataEntity);
                  if (dataEntities.size() >= 1000) {
                     if (!this.DoSaveData(dataEntities, true)) {
                        return;
                     }

                     dataEntities.clear();
                  }
               }

               if (dataEntities.size() > 0) {
                  if (this.DoSaveData(dataEntities, true)) {
                     dataEntities.clear();
                  }
               }
            } else {
               Workbook workbook = null;
               HSSFSheet errSheet = null;
               HSSFWorkbook errWorkbook = null;
               String strErrorTempFilePath2 = "";
               if (!this.bStopWhenError) {
                  strErrorTempFilePath2 = StringHelper.Format("%1$s%2$s_E.xls", strErrorFileFolder, strTempId);
                  errWorkbook = new HSSFWorkbook();
                  errSheet = errWorkbook.createSheet("错误数据");
               }

               File excleFile = new File(strTempFilePath);
               InputStream in = new FileInputStream(strTempFilePath);
               FormulaEvaluator eva = null;
               if (excleFile.getName().endsWith(".xls")) {
                  HSSFWorkbook hssfWorkbook = new HSSFWorkbook(in);
                  eva = new HSSFFormulaEvaluator(hssfWorkbook);
                  workbook = hssfWorkbook;
               } else if (excleFile.getName().endsWith(".xlsx")) {
                  XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
                  eva = new XSSFFormulaEvaluator(xssfWorkbook);
                  workbook = xssfWorkbook;
               }

               if (workbook.getNumberOfSheets() < 1) {
                  this.processInfo.Append("<SPAN class='sx-normaltext-red'>Excel中没有包含任何数据分页！</SPAN><BR>");
               } else {
                  Sheet dataSheet = workbook.getSheetAt(0);
                  int nCelLIndex = 0;
                  int nRowIndex = 0;
                  Row row = dataSheet.getRow(nRowIndex);
                  int nFirst = row.getFirstCellNum();
                  int nLast = row.getLastCellNum();

                  for (int i = nFirst; i < nLast; i++) {
                     String strContent = this.getCellValue(row.getCell(i), eva);
                     if (StringHelper.IsNullOrEmpty(strContent)) {
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，必须输入内容</SPAN><BR>", SRFCellFuncHelper.GetCellSN(i, nRowIndex));
                        return;
                     }

                     strContent = strContent.trim();
                     String strColumnName = strContent.toUpperCase();
                     IDEFHelper iDEFHelper = deFieldImpMap.get(strColumnName);
                     if (iDEFHelper == null) {
                        this.processInfo.Append("<SPAN class='sx-normaltext-red'>无法获取属性[%1$s]辅助对象</SPAN><BR>", strColumnName);
                        return;
                     }

                     String strCodeListId = iDEFHelper.GetCodeList();
                     if (!StringHelper.IsNullOrEmpty(strCodeListId) && !codeListMap.containsKey(strCodeListId)) {
                        CodeListConfig codeListConfig = this.getWebContext()
                           .getGlobalHelper()
                           .getCodeListMgr()
                           .GetCodeListConfig(strCodeListId, this.getLanguage());
                        if (codeListConfig == null) {
                           this.processInfo.Append("<SPAN class='sx-normaltext-red'>无法获取代码表[%1$s]配置</SPAN><BR>", strCodeListId);
                           return;
                        }

                        codeListMap.put(strCodeListId, codeListConfig);
                     }

                     if (iDEFHelper.IsLinkDEField()) {
                        ILinkDEFHelper iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                        String strDEId = iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getId();
                        if (!deDataCtrlMap.containsKey(strDEId)) {
                           IDEDataCtrl iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl(strDEId, this.getWebContext());
                           if (iDEDataCtrl == null) {
                              this.processInfo.Append("<SPAN class='sx-normaltext-red'>无法获取实体[%1$s]数据操作对象</SPAN><BR>", strDEId);
                              return;
                           }

                           deDataCtrlMap.put(strDEId, iDEDataCtrl);
                        }
                     }

                     deFieldMap.put(i, iDEFHelper);
                  }

                  if (!this.bStopWhenError) {
                     this.AddErrorSheetRow(errSheet, row);
                  }

                  Vector<BaseDataEntity> dataEntities = new Vector<>();
                  nFirst = dataSheet.getLastRowNum();

                  for (int i = 1; i <= nFirst; i++) {
                     boolean bErrorFlag = false;
                     BaseDataEntity dataEntity = new BaseDataEntity();
                     Row rowx = dataSheet.getRow(i);
                     int nFirstx = rowx.getFirstCellNum();
                     int nLastx = rowx.getLastCellNum();

                     for (int j = nFirstx; j <= nLastx; j++) {
                        String strContent = this.getCellValue(rowx.getCell(j), eva);
                        bErrorFlag = false;
                        if (!StringHelper.IsNullOrEmpty(strContent)) {
                           strContent = strContent.trim();
                           if (!StringHelper.IsNullOrEmpty(strContent)) {
                              IDEFHelper iDEFHelper = deFieldMap.get(j);
                              if (StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUPDATA", true) != 0) {
                                 String strCodeListId = iDEFHelper.GetCodeList();
                                 if (!StringHelper.IsNullOrEmpty(strCodeListId)) {
                                    CodeListConfig codeListConfig = codeListMap.get(strCodeListId);
                                    String strDataType = iDEFHelper.GetDataType();
                                    if (StringHelper.Compare(strDataType, "NMCODELIST", false) != 0
                                       && StringHelper.Compare(strDataType, "SMCODELIST", false) != 0) {
                                       CodeItemConfig codeItemConfig = codeListConfig.FindCodeItemConfigByText(strContent, true);
                                       if (codeItemConfig == null) {
                                          codeItemConfig = codeListConfig.FindCodeItemConfigByValue(strContent, true);
                                          if (codeItemConfig == null && StringHelper.Compare(codeListConfig.getEmptyText(), strContent, true) != 0) {
                                             this.processInfo
                                                .Append(
                                                   "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效， 代码表[%2$s]无法识别[%3$s]</SPAN><BR>",
                                                   SRFCellFuncHelper.GetCellSN(j, i),
                                                   strCodeListId,
                                                   strContent
                                                );
                                             if (this.bStopWhenError) {
                                                return;
                                             }

                                             bErrorFlag = true;
                                             this.AddErrorSheetRow(errSheet, rowx);
                                             break;
                                          }
                                       }

                                       dataEntity.SetParamValue(iDEFHelper.getName(), iDEFHelper.GetDEFValue(codeItemConfig.getValue()));
                                    } else {
                                       boolean bNumberMode = StringHelper.Compare(strDataType, "NMCODELIST", false) == 0;
                                       int nRealValue = 0;
                                       String strRealValue = "";
                                       String strNewContent = strContent;
                                       strNewContent = strNewContent.replace("|", ";");
                                       strNewContent = strNewContent.replace(",", ";");
                                       strNewContent = strNewContent.replace("，", ";");
                                       strNewContent = strNewContent.replace("、", ";");
                                       String[] items = strNewContent.split("[;]");
                                       boolean bValueMode = false;

                                       for (int l = 0; l < items.length; l++) {
                                          String strText = items[l];
                                          CodeItemConfig codeItemConfig = codeListConfig.FindCodeItemConfigByText(strText, true);
                                          if (codeItemConfig == null) {
                                             bValueMode = true;
                                             break;
                                          }

                                          if (bNumberMode) {
                                             nRealValue |= Integer.parseInt(codeItemConfig.getValue());
                                          } else {
                                             if (!StringHelper.IsNullOrEmpty(strRealValue)) {
                                                strRealValue = strRealValue + codeListConfig.getSeparator();
                                             }

                                             strRealValue = strRealValue + codeItemConfig.getValue();
                                          }
                                       }

                                       if (bValueMode) {
                                          if (bNumberMode) {
                                             nRealValue = Integer.parseInt(strContent);
                                             dataEntity.SetParamValue(iDEFHelper.getName(), nRealValue);
                                          } else {
                                             strRealValue = strNewContent.replace(";", codeListConfig.getSeparator());
                                             dataEntity.SetParamValue(iDEFHelper.getName(), strRealValue);
                                          }
                                       } else if (bNumberMode) {
                                          dataEntity.SetParamValue(iDEFHelper.getName(), nRealValue);
                                       } else {
                                          dataEntity.SetParamValue(iDEFHelper.getName(), strRealValue);
                                       }
                                    }
                                 } else if (iDEFHelper.IsLinkDEField()) {
                                    ILinkDEFHelper iLinkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                                    if (StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUPTEXT", true) == 0
                                       || StringHelper.Compare(iDEFHelper.GetDataType(), "INHERIT", true) == 0
                                          && StringHelper.Compare(iLinkDEFHelper.GetRelatedDEFHelper().GetDataType(), "PICKUPTEXT", true) == 0) {
                                       IPickupDEFHelper iPickupDEFHelper = null;
                                       if (StringHelper.Compare(iDEFHelper.GetDataType(), "PICKUPTEXT", true) == 0) {
                                          iPickupDEFHelper = iLinkDEFHelper.getDEHelper().FindPickupDEFHelper(iLinkDEFHelper.GetDERId());
                                       } else {
                                          ILinkDEFHelper iLinkDEFHelper2 = (ILinkDEFHelper)iLinkDEFHelper.GetRelatedDEFHelper();
                                          iPickupDEFHelper = iLinkDEFHelper.GetRelatedDEFHelper().getDEHelper().FindPickupDEFHelper(iLinkDEFHelper2.GetDERId());
                                       }

                                       if (iPickupDEFHelper == null) {
                                          this.processInfo
                                             .Append(
                                                "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，无法获取指定属性[%2$s]相关信息</SPAN><BR>",
                                                SRFCellFuncHelper.GetCellSN(j, i),
                                                iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName()
                                             );
                                          if (this.bStopWhenError) {
                                             return;
                                          }

                                          bErrorFlag = true;
                                          this.AddErrorSheetRow(errSheet, rowx);
                                          break;
                                       }

                                       if (!dataEntity.ContainesParam(iPickupDEFHelper.getName())) {
                                          IDEDataCtrl iDataCtrl = deDataCtrlMap.get(iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getId());
                                          Vector<BaseDataEntity> dataList = new Vector<>();
                                          CallResult callResult = this.SelectPickupData(iDEFHelper, iLinkDEFHelper, iDataCtrl, dataEntity, strContent, dataList);
                                          if (callResult.IsError()) {
                                             this.processInfo
                                                .Append(
                                                   "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]查询[%3$s]发生错误，%4$s</SPAN><BR>",
                                                   SRFCellFuncHelper.GetCellSN(j, i),
                                                   iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(),
                                                   strContent,
                                                   callResult.getErrorInfo()
                                                );
                                             if (this.bStopWhenError) {
                                                return;
                                             }

                                             bErrorFlag = true;
                                             this.AddErrorSheetRow(errSheet, rowx);
                                             break;
                                          }

                                          if (dataList.size() == 0) {
                                             this.processInfo
                                                .Append(
                                                   "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]</SPAN><BR>",
                                                   SRFCellFuncHelper.GetCellSN(j, i),
                                                   iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(),
                                                   strContent
                                                );
                                             if (this.bStopWhenError) {
                                                return;
                                             }

                                             bErrorFlag = true;
                                             this.AddErrorSheetRow(errSheet, rowx);
                                             break;
                                          }

                                          if (dataList.size() != 1) {
                                             this.processInfo
                                                .Append(
                                                   "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，有%4$s条记录符合该名称</SPAN><BR>",
                                                   SRFCellFuncHelper.GetCellSN(j, i),
                                                   iLinkDEFHelper.GetRealDEFHelper().getDEHelper().getLogicName(),
                                                   strContent,
                                                   dataList.size()
                                                );
                                             if (this.bStopWhenError) {
                                                return;
                                             }

                                             bErrorFlag = true;
                                             this.AddErrorSheetRow(errSheet, rowx);
                                             break;
                                          }

                                          dataEntity.SetParamValue(
                                             iPickupDEFHelper.getName(), dataList.get(0).GetParamValue(iPickupDEFHelper.GetRealDEFHelper().getName())
                                          );
                                       }
                                    } else {
                                       Object objValue = iLinkDEFHelper.GetRealDEFHelper().GetDEFValue(strContent);
                                       if (objValue == null) {
                                          this.processInfo
                                             .Append(
                                                "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！</SPAN><BR>",
                                                SRFCellFuncHelper.GetCellSN(j, i),
                                                iDEFHelper.getLogicName(),
                                                strContent
                                             );
                                          if (this.bStopWhenError) {
                                             return;
                                          }

                                          bErrorFlag = true;
                                          this.AddErrorSheetRow(errSheet, rowx);
                                          break;
                                       }

                                       dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                                    }
                                 } else {
                                    Object objValue = iDEFHelper.GetDEFValue(strContent);
                                    if (objValue == null) {
                                       this.processInfo
                                          .Append(
                                             "<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！</SPAN><BR>",
                                             SRFCellFuncHelper.GetCellSN(j, i),
                                             iDEFHelper.getLogicName(),
                                             strContent
                                          );
                                       if (this.bStopWhenError) {
                                          return;
                                       }

                                       bErrorFlag = true;
                                       this.AddErrorSheetRow(errSheet, rowx);
                                       break;
                                    }

                                    dataEntity.SetParamValue(iDEFHelper.getName(), objValue);
                                 }
                              }
                           }
                        }
                     }

                     if (!bErrorFlag) {
                        if (!dataEntity.ContainesParam(strKeyFieldName) && importKeyList.size() > 0) {
                           boolean bSelectKey = true;
                           BaseDataEntity cond = new BaseDataEntity();

                           for (String strKey : importKeyList) {
                              Object objValue = dataEntity.GetParamValue(strKey);
                              if (objValue == null) {
                                 bSelectKey = false;
                                 break;
                              }

                              cond.SetParamValue(strKey, objValue);
                           }

                           if (bSelectKey) {
                              IDEDataCtrl iDEDataCtrl = this.GetDEDataCtrl();
                              tempList.clear();
                              CallResult callResult = iDEDataCtrl.Select(cond, tempList);
                              if (callResult.IsError()) {
                                 this.processInfo
                                    .Append("<SPAN class='sx-normaltext-red'>行记录[%1$s]无效，查询数据主键发生错误，%2$s</SPAN><BR>", nRowIndex, callResult.getErrorInfo());
                                 if (this.bStopWhenError) {
                                    return;
                                 }

                                 this.AddErrorSheetRow(errSheet, rowx);
                                 continue;
                              }

                              if (tempList.size() > 1) {
                                 this.processInfo.Append("<SPAN class='sx-normaltext-red'>行记录[%1$s]无效，查询数据主键发生错误，存在多条满足导入识别项的数据。</SPAN><BR>", nRowIndex);
                                 if (this.bStopWhenError) {
                                    return;
                                 }

                                 this.AddErrorSheetRow(errSheet, rowx);
                                 continue;
                              }

                              if (tempList.size() == 1) {
                                 dataEntity.SetParamValue(strKeyFieldName, tempList.get(0).GetParamValue(strKeyFieldName));
                              }
                           }
                        }

                        dataEntities.add(dataEntity);
                        if (!this.bStopWhenError) {
                           if (!this.DoSaveData(dataEntities, false)) {
                              this.AddErrorSheetRow(errSheet, rowx);
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

                  if (dataEntities.size() > 0) {
                     if (!this.DoSaveData(dataEntities, false)) {
                        return;
                     }

                     dataEntities.clear();
                  }

                  if (!this.bStopWhenError) {
                     FileOutputStream fOut = new FileOutputStream(strFileLocalPath + strErrorTempFilePath2);
                     errWorkbook.write(fOut);
                     fOut.flush();
                     fOut.close();
                     if (this.nErrorRowIndex > 1) {
                        IDEDataCtrl fileDEDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0010", this.getWebContext());
                        if (fileDEDataCtrl == null) {
                           this.processInfo.Append("<SPAN class='sx-normaltext-red'>无法获取实体[FILE]数据访问对象</SPAN><BR>");
                        } else {
                           strErrorTempFilePath2 = StringHelper.Format("%1$s%2$s_E.xls", strErrorFileFolder, strTempId);
                           SA.SRFDA.Ctrl.Data.File saveFile = new SA.SRFDA.Ctrl.Data.File();
                           saveFile.setFILESIZE(0);
                           saveFile.setFILE_NAME("无法导入数据.xls");
                           saveFile.setLOCALPATH(strErrorTempFilePath2);
                           saveFile.setFOLDER("TEMP");
                           CallResult callResult = fileDEDataCtrl.Save(true, saveFile);
                           if (callResult.getRetCode() != 0) {
                              this.processInfo.Append("<SPAN class='sx-normaltext-red'>保存错误文件出现错误，%1$s</SPAN><BR>", callResult.getErrorInfo());
                           } else {
                              this.strErrorFileLink = StringHelper.Format(
                                 "<A href=\"../srfpage/exportfile.jsp?FILEID=%1$s\" target=\"_blank\">下载导入失败数据文件</a>", saveFile.getFILE_ID()
                              );
                           }
                        }
                     }
                  }
               }
            }
         }
      } catch (Exception ex) {
         this.processInfo.Append("<SPAN class='sx-normaltext-red'>导入数据过程中发生错误，%1$s!</SPAN><BR>", ex.getMessage());
         ex.printStackTrace();
      } finally {
         if (accessUtil != null) {
            try {
               accessUtil.CloseConnection();
            } catch (Exception e) {
               e.printStackTrace();
            }

            AccessUtil var93 = null;
         }
      }
   }

   protected boolean DoSaveData(Vector<BaseDataEntity> dataEntities, boolean bAccess) {
      CallResult callResult = null;
      IDEDataCtrl iDEDataCtrl = this.getDAModelStorage().FindDEDataCtrl(this.strPageDataEntityId, this.getWebContext());
      DefaultTransactionManager transactionManager = new DefaultTransactionManager();
      transactionManager.Init(this.getWebContext().getGlobalHelper());
      transactionManager.Register(iDEDataCtrl);

      try {
         for (BaseDataEntity dataEntity : dataEntities) {
            boolean bInsert = !dataEntity.ContainesParam(this.getDEHelper().GetKeyDEFHelper().getName());
            if (!bInsert) {
               BaseDataEntity checkkeyparam = new BaseDataEntity();
               dataEntity.CopyTo(checkkeyparam, true);
               callResult = iDEDataCtrl.CheckKeyState(checkkeyparam);
               if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
                  transactionManager.Rollback();
                  this.processInfo.Append("<SPAN class='sx-normaltext-red'>行数据[%1$s]无效，检查数据主键发生错误!</SPAN><BR>", this.nRowIndex2 + 1);
                  return false;
               }

               int nState = (Integer)callResult.getUserObject();
               if (nState == 0) {
                  bInsert = true;
               } else {
                  if (nState != 1) {
                     transactionManager.Rollback();
                     this.processInfo
                        .Append(
                           "<SPAN class='sx-normaltext-red'>行数据[%1$s]无效，%2$s!</SPAN><BR>",
                           this.nRowIndex2 + 1,
                           this.getPage().GetLocalization("CTRL.FORMAH.DATAALREADYREMOVED", "该数据已经被删除!数据无法保存!")
                        );
                     return false;
                  }

                  bInsert = false;
               }
            } else if (!StringHelper.IsNullOrEmpty(this.strMultiKeys)) {
               BaseDataEntity checkkeyparam = new BaseDataEntity();
               dataEntity.CopyTo(checkkeyparam, this.strMultiKeys, true);
               callResult = iDEDataCtrl.Select(checkkeyparam);
               if (callResult.IsError()) {
                  if (callResult.getRetCode() != 3) {
                     transactionManager.Rollback();
                     this.processInfo.Append("<SPAN class='sx-normaltext-red'>行数据[%1$s]无效，检查数据主键发生错误!</SPAN><BR>", this.nRowIndex2 + 1);
                     return false;
                  }

                  bInsert = true;
               } else {
                  bInsert = false;
                  dataEntity.SetParamValue(this.strKeyName, checkkeyparam.GetParamValue(this.strKeyName));
               }
            }

            for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
               if (!bInsert && !iDEFHelper.IsKeyDEField() && !iDEFHelper.GetFormCtrl().IsEnableFormUpdate()) {
                  dataEntity.RemoveParam(iDEFHelper.getName());
               }
            }

            if (bInsert) {
               for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
                  if (!iDEFHelper.IsKeyDEField()) {
                     String strDVT = iDEFHelper.GetFormCtrl().GetDefaultValueType();
                     String strDV = iDEFHelper.GetFormCtrl().GetDefaultValue();
                     if ((StringHelper.Length(strDVT) != 0 || StringHelper.Length(strDV) != 0) && !dataEntity.ContainesParam(iDEFHelper.getName())) {
                        dataEntity.SetParamValue(
                           iDEFHelper.getName(), DADVHelper.GetDefaultValue(this.getWebContext(), strDVT, strDV, iDEFHelper.GetStdDataType())
                        );
                     }
                  }
               }
            }

            if (bInsert) {
               this.FillDataEntityParentInfo(dataEntity);
               callResult = this.OnSaveActionBeforeInsert(dataEntity);
               if (callResult.getRetCode() != 0) {
                  String strErrorFormat = this.getPage().GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "数据无法保存，%1$s");
                  String strErrorInfo = StringHelper.Format(strErrorFormat, callResult.getErrorInfo());
                  transactionManager.Rollback();
                  this.processInfo.Append("<SPAN class='sx-normaltext-red'>行数据[%1$s]保存失败，%2$s!</SPAN><BR>", this.nRowIndex2 + 1, strErrorInfo);
                  return false;
               }

               callResult = this.OnSaveData(iDEDataCtrl, true, this.strInsertMode, dataEntity);
            } else {
               callResult = this.OnSaveActionBeforeUpdate(dataEntity);
               if (callResult.getRetCode() != 0) {
                  String strErrorFormat = this.getPage().GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "数据无法保存，%1$s");
                  String strErrorInfo = StringHelper.Format(strErrorFormat, callResult.getErrorInfo());
                  transactionManager.Rollback();
                  this.processInfo.Append("<SPAN class='sx-normaltext-red'>行数据[%1$s]保存失败，%2$s!</SPAN><BR>", this.nRowIndex2 + 1, strErrorInfo);
                  return false;
               }

               callResult = this.OnSaveData(iDEDataCtrl, false, this.strUpdateMode, dataEntity);
            }

            if (callResult.IsError()) {
               transactionManager.Rollback();
               this.processInfo.Append("<SPAN class='sx-normaltext-red'>行数据[%1$s]保存失败，%2$s!</SPAN><BR>", this.nRowIndex2 + 1, callResult.getErrorInfo());
               return false;
            }

            this.processInfo
               .Append("<SPAN class='sx-normaltext'>行数据[%1$s]保存成功，%2$s!</SPAN><BR>", this.nRowIndex2 + 1, this.getDEHelper().GetDataInfo(dataEntity));
            this.nRowIndex2++;
            transactionManager.CommitAndBegin();
         }

         transactionManager.Commit();
         return true;
      } catch (Exception ex) {
         transactionManager.Rollback();
         this.processInfo.Append("<SPAN class='sx-normaltext-red'>导入数据过程中发生错误，%1$s!</SPAN><BR>", ex.getMessage());
         ex.printStackTrace();
         return false;
      }
   }

   protected CallResult OnSaveData(IDEDataCtrl iDEDataCtrl, boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
      return iDEDataCtrl.Save(bInsert, strActionMode, dataEntity);
   }

   protected CallResult OnSaveActionBeforeInsert(BaseDataEntity dataEntity) {
      CallResult callResult = this.OnTestDataAction(dataEntity, this.strInsertDataAction);
      return callResult.getRetCode() != 0 ? callResult : this.GetDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
   }

   protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
      CallResult callResult = this.OnTestDataAction(dataEntity, this.strUpdateDataAction);
      return callResult.getRetCode() != 0 ? callResult : this.GetDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
   }

   protected String GetDataLockKey(BaseDataEntity dataEntity) {
      try {
         return this.getDEHelper().GetDataLockKey(this.getWebContext(), dataEntity);
      } catch (Exception ex) {
         this.PageLog(this, 1, StringHelper.Format("获取数据对象锁钥匙发生异常，%1$s", ex.getMessage()), ex);
         return "";
      }
   }

   protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction) {
      return this.getDEHelper().GetDataAccHelper().Test(this.getWebContext(), dataEntity, strAction);
   }

   public String OutputProcessInfo() {
      return this.processInfo.toString();
   }

   public String OutputErrorFileLink() {
      return this.strErrorFileLink;
   }

   protected void FillDataEntityParentInfo(BaseDataEntity dataEntity) {
      if (!StringHelper.IsNullOrEmpty(this.strPKeyName)) {
         Object objValue = dataEntity.GetParamValue(this.strPKeyName);
         if (objValue == null) {
            dataEntity.SetParamValue(this.strPKeyName, this.objPKeyValue);
         }
      }
   }

   protected void FillParentDataEntity() {
      String strDERID = this.getWebContext().getSRFDERID();
      if (!StringHelper.IsNullOrEmpty(strDERID)) {
         IPickupDEFHelper pickupDEFHelper = this.getDEHelper().FindPickupDEFHelper(strDERID);
         if (pickupDEFHelper == null) {
            DER1N der1n = new DER1N();
            CallResult callResult = this.getDAModelHelper().GetDER1N(strDERID, der1n);
            if (callResult.getRetCode() != 0) {
               this.PageLog(this, 1, StringHelper.Format("获取DER1N[%1$s]失败，%2$s", strDERID, callResult.getErrorInfo()));
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
               if (!(inheritDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) {
                  return;
               }

               pickupDEFHelper = (IPickupDEFHelper)inheritDEFHelper.GetRelatedDEFHelper();
            } else {
               pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            }

            strDERID = pickupDEFHelper.GetDERId();
            this.getWebContext().SetParamValue("SRFDERID", strDERID);
         }

         if (pickupDEFHelper.GetRealDEFHelper().GetDTColumn().IsPKey()) {
            String strKeyValue = this.getWebContext().GetParamValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
            if (StringHelper.IsNullOrEmpty(strKeyValue)) {
               if (!pickupDEFHelper.GetRealDEFHelper().getDEHelper().IsIndexDE()) {
                  return;
               }

               Vector<DERINDEX> list = pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDERINDEXs(true);
               boolean bFind = false;

               for (DERINDEX dERINDEX : list) {
                  IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
                  if (iDEHelper == null) {
                     this.PageLog(this, 1, StringHelper.Format("无法获取实体[%1$s]辅助对象", dERINDEX.getDEID()));
                  } else {
                     strKeyValue = this.getWebContext().GetParamValue(iDEHelper.GetKeyDEFHelper().getName());
                     if (!StringHelper.IsNullOrEmpty(strKeyValue)) {
                        bFind = true;
                        break;
                     }
                  }
               }

               if (!bFind) {
                  return;
               }
            }

            this.strPKeyName = pickupDEFHelper.GetFormCtrl().GetFormCtrlId();
            this.objPKeyValue = strKeyValue;
         }
      }
   }

   protected void AddErrorSheetRow(Sheet s1, Row row) {
      try {
         if (this.nErrorRowIndex != 0) {
            this.nRowIndex2++;
         }

         int nFirst = row.getFirstCellNum();
         int nLast = row.getLastCellNum();
         Row newRow = s1.createRow(this.nErrorRowIndex);

         for (int i = nFirst; i < nLast; i++) {
            String strContent = this.getCellValue(row.getCell(i), null);
            Cell hssfcell = newRow.createCell(i);
            hssfcell.setCellValue(strContent);
            hssfcell.setCellType(1);
            if (this.nErrorRowIndex == 0) {
               s1.setColumnWidth(i, 4000);
            }
         }

         this.nErrorRowIndex++;
      } catch (Exception ex) {
         this.PageLog(this, 1, ex.getMessage(), ex);
      }
   }

   protected void OnAfterFillDEFieldImpMap(TreeMap<String, IDEFHelper> deFieldImpMap) {
   }

   protected CallResult SelectPickupData(
      IDEFHelper iDEFHelper,
      ILinkDEFHelper iLinkDEFHelper,
      IDEDataCtrl iDataCtrl,
      BaseDataEntity dataEntity,
      String strContent,
      Vector<BaseDataEntity> dataList
   ) {
      BaseDataEntity temp = new BaseDataEntity();
      temp.SetParamValue(iLinkDEFHelper.GetRealDEFHelper().getName(), iDEFHelper.GetDEFValue(strContent));
      return iDataCtrl.Select(temp, dataList);
   }

   protected String getCellValue(Cell cell, FormulaEvaluator eva) {
      if (cell == null) {
         return "";
      }

      switch (cell.getCellType()) {
         case 0:
            boolean b = HSSFDateUtil.isCellDateFormatted(cell);
            if (b) {
               Date date = cell.getDateCellValue();
               SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               return df.format(date);
            }

            cell.setCellType(1);
            return cell.getStringCellValue();
         case 1:
            return cell.getStringCellValue();
         case 2:
            if (eva == null) {
               return cell.getCellFormula();
            } else {
               CellValue cellVal = eva.evaluate(cell);
               if (cellVal.getCellType() == 0) {
                  return String.valueOf(cellVal.getNumberValue());
               }

               return cellVal.getStringValue();
            }
         case 3:
         default:
            return "";
         case 4:
            return String.valueOf(cell.getBooleanCellValue());
      }
   }
}
