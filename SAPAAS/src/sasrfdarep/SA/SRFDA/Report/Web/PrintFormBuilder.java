package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Ctrl.Data.PrintLog;
import SA.SRFDA.Report.DAJRDataSource;
import SA.SRFDA.Report.Utility.PDFPrintHelper;
import SA.SRFDA.Report.Utility.PrintDialogMode;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrintFormBuilder extends SRFDAHttpServlet {
   private static final Log log = LogFactory.getLog(PrintFormBuilder.class);

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.addTimeOutHeaders(response);
      String strReportType = this.getInitParameter("REPORTTYPE");
      SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(request, response, this.getServletContext());
      PrintForm printForm = new PrintForm();
      String strDEId = servletContext.GetParamValue("SRFDEID");
      if (StringHelper.IsNullOrEmpty(strDEId)) {
         this.SendbackError(servletContext, "没有指定数据实体编号", strReportType, request, response);
      } else {
         IDEHelper iDEHelper = servletContext.getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
         if (iDEHelper == null) {
            this.SendbackError(servletContext, StringHelper.Format("无法获取实体[%1$s]辅助对象", strDEId), strReportType, request, response);
         } else {
            IDEDataCtrl iDEDataCtrl = iDEHelper.GetDEDataCtrl(servletContext.getCurUserId(), null);
            if (iDEDataCtrl == null) {
               log.error(StringHelper.Format("无法获取实体[%1$s]数据操作对象", strDEId));
               this.SendbackError(servletContext, StringHelper.Format("无法获取实体[%1$s]数据操作对象", strDEId), strReportType, request, response);
            } else {
               String strFormName = servletContext.GetParamValue("PRINTFORM");
               if (StringHelper.IsNullOrEmpty(strFormName)) {
                  strFormName = "DEFAULT";
               }

               CallResult callResult = servletContext.getGlobalHelper().getDAModelHelper().GetDEPrintForm(strDEId, strFormName, printForm);
               if (callResult.getRetCode() != 0) {
                  log.error(StringHelper.Format("无法获取实体[%1$s]指定报表[%2$s]，%3$s", strDEId, strFormName, callResult.getErrorInfo()));
                  this.SendbackError(
                     servletContext,
                     StringHelper.Format("无法获取实体[%1$s]指定报表[%2$s]，%3$s", strDEId, strFormName, callResult.getErrorInfo()),
                     strReportType,
                     request,
                     response
                  );
               } else {
                  String strKey = iDEHelper.GetKeyDEFHelper().getName();
                  String strKeyValue = servletContext.GetParamValue(strKey);
                  if (StringHelper.IsNullOrEmpty(strKeyValue)) {
                     this.SendbackError(servletContext, StringHelper.Format("没有传入实体[%1$s]数据键值", strDEId), strReportType, request, response);
                  } else if (printForm.getENABLEMP()) {
                     this.DoMulitplePrintInDataSource(
                        strReportType, strDEId, iDEHelper, iDEDataCtrl, printForm, strKey, strKeyValue, servletContext, request, response
                     );
                  } else {
                     String strPrintMode = servletContext.GetParamValue("PRINTMODE");
                     if (StringHelper.Compare(strPrintMode, "MULTIPLE", true) == 0 && StringHelper.Compare(strReportType, "PDF", true) == 0) {
                        this.DoMulitplePrint(strReportType, strDEId, iDEHelper, strKey, strKeyValue, servletContext, request, response);
                     } else {
                        BaseDataEntity dataEntity = new BaseDataEntity();
                        dataEntity.SetParamValue(strKey, DataTypeParse.Parse(iDEHelper.GetKeyDEFHelper().GetStdDataType(), strKeyValue));
                        callResult = iDEHelper.GetDataAccHelper().Test(servletContext, dataEntity, "READ");
                        if (callResult.getRetCode() != 0) {
                           log.error(StringHelper.Format("检查用户数据权限发生错误,%1$s", callResult.getErrorInfo()));
                           this.SendbackError(
                              servletContext, StringHelper.Format("检查用户数据权限发生错误,%1$s", callResult.getErrorInfo()), strReportType, request, response
                           );
                        } else {
                           if (StringHelper.IsNullOrEmpty(printForm.getGETACTION())) {
                              callResult = iDEDataCtrl.Get(dataEntity);
                           } else {
                              callResult = iDEDataCtrl.CustomCall(printForm.getGETACTION(), dataEntity);
                           }

                           if (callResult.getRetCode() != 0) {
                              log.error(StringHelper.Format("获取实体[%1$s][%2$s]失败，%3$s", strDEId, strKeyValue, callResult.getErrorInfo()));
                              this.SendbackError(
                                 servletContext,
                                 StringHelper.Format("获取实体[%1$s][%2$s]失败，%3$s", strDEId, strKeyValue, callResult.getErrorInfo()),
                                 strReportType,
                                 request,
                                 response
                              );
                           } else {
                              if (printForm.getENABLECOLPRIV()) {
                                 IUserPrivilegeMgr iUserPrivilegeMgr = servletContext.GetUserPrivilegeMgr();

                                 for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                                    if (iDEFHelper.IsEnableDEFieldPriv()) {
                                       int nRet = iUserPrivilegeMgr.TestColumn(
                                          servletContext, StringHelper.Format("%1$s|%2$s", iDEHelper.getId(), iDEFHelper.getId())
                                       );
                                       if (nRet == 0) {
                                          dataEntity.RemoveParam(iDEFHelper.getName());
                                       }
                                    }
                                 }
                              }

                              PrintFormActionHelper printFormActionHelper = null;
                              String strReportObject = printForm.getFORMOBJECT();
                              if (StringHelper.IsNullOrEmpty(strReportObject)) {
                                 printFormActionHelper = new PrintFormActionHelper();
                              } else {
                                 Object obj = ObjectHelper.Create(strReportObject);
                                 if (obj == null) {
                                    this.SendbackError(
                                       servletContext, StringHelper.Format("无法建立打印表单处理对象[%1$s]", strReportObject), strReportType, request, response
                                    );
                                    return;
                                 }

                                 if (!(obj instanceof PrintFormActionHelper)) {
                                    this.SendbackError(
                                       servletContext, StringHelper.Format("打印表单处理对象[%1$s]类型不正确", strReportObject), strReportType, request, response
                                    );
                                    return;
                                 }

                                 printFormActionHelper = (PrintFormActionHelper)obj;
                              }

                              String strReportFile = printFormActionHelper.GetPrintFormFile(
                                 dataEntity, servletContext, servletContext.getGlobalHelper(), printForm, strReportType
                              );
                              if (StringHelper.IsNullOrEmpty(strReportFile)) {
                                 log.error(StringHelper.Format("生成报表文件失败"));
                              } else {
                                 if (SendBackFile(strReportFile, strReportType, request, response) && printForm.getENABLELOG()) {
                                    PrintLog printLog = new PrintLog();
                                    printLog.setPRINTFORMID(printForm.getPRINTFORMID());
                                    printLog.setFORMDATA(strKeyValue);
                                    IDEDataCtrl printLogDataCtrl = servletContext.getGlobalHelper()
                                       .getDAModelStorage()
                                       .FindDEDataCtrl("DE0202", servletContext);
                                    if (printLogDataCtrl != null) {
                                       printLogDataCtrl.Save(true, printLog);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   protected void DoMulitplePrintInDataSource(
      String strReportType,
      String strDEId,
      IDEHelper iDEHelper,
      IDEDataCtrl iDEDataCtrl,
      PrintForm printForm,
      String strKey,
      String strKeyMultiValue,
      SRFDAHttpServletContext servletContext,
      HttpServletRequest request,
      HttpServletResponse response
   ) {
      Vector<BaseDataEntity> dataEntities = new Vector<>();
      String[] arrKeyValue = strKeyMultiValue.split(",");
      String[] printLog = arrKeyValue;
      int strReportFile = arrKeyValue.length;

      for (int strReportObject = 0; strReportObject < strReportFile; strReportObject++) {
         String strKeyValue = printLog[strReportObject];
         BaseDataEntity dataEntity = new BaseDataEntity();
         dataEntity.SetParamValue(strKey, DataTypeParse.Parse(iDEHelper.GetKeyDEFHelper().GetStdDataType(), strKeyValue));
         CallResult callResult = iDEHelper.GetDataAccHelper().Test(servletContext, dataEntity, "READ");
         if (callResult.getRetCode() != 0) {
            this.SendbackError(servletContext, StringHelper.Format("检查用户数据权限发生错误,%1$s", callResult.getErrorInfo()), strReportType, request, response);
            return;
         }

         if (StringHelper.IsNullOrEmpty(printForm.getGETACTION())) {
            callResult = iDEDataCtrl.Get(dataEntity);
         } else {
            callResult = iDEDataCtrl.CustomCall(printForm.getGETACTION(), dataEntity);
         }

         if (callResult.getRetCode() != 0) {
            this.SendbackError(
               servletContext,
               StringHelper.Format("获取实体[%1$s][%2$s]失败，%3$s", strDEId, strKeyValue, callResult.getErrorInfo()),
               strReportType,
               request,
               response
            );
            return;
         }

         if (printForm.getENABLECOLPRIV()) {
            IUserPrivilegeMgr iUserPrivilegeMgr = servletContext.GetUserPrivilegeMgr();

            for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
               if (iDEFHelper.IsEnableDEFieldPriv()) {
                  int nRet = iUserPrivilegeMgr.TestColumn(servletContext, StringHelper.Format("%1$s|%2$s", iDEHelper.getId(), iDEFHelper.getId()));
                  if (nRet == 0) {
                     dataEntity.RemoveParam(iDEFHelper.getName());
                  }
               }
            }
         }

         dataEntities.add(dataEntity);
      }

      PrintFormActionHelper printFormActionHelper = null;
      String strReportObject = printForm.getFORMOBJECT();
      if (StringHelper.IsNullOrEmpty(strReportObject)) {
         printFormActionHelper = new PrintFormActionHelper();
      } else {
         Object obj = ObjectHelper.Create(strReportObject);
         if (obj == null) {
            this.SendbackError(servletContext, StringHelper.Format("无法建立打印表单处理对象[%1$s]", strReportObject), strReportType, request, response);
            return;
         }

         if (!(obj instanceof PrintFormActionHelper)) {
            this.SendbackError(servletContext, StringHelper.Format("打印表单处理对象[%1$s]类型不正确", strReportObject), strReportType, request, response);
            return;
         }

         printFormActionHelper = (PrintFormActionHelper)obj;
      }

      String strReportFilex = printFormActionHelper.GetPrintFormFile(dataEntities, servletContext, servletContext.getGlobalHelper(), printForm, strReportType);
      if (StringHelper.IsNullOrEmpty(strReportFilex)) {
         log.error(StringHelper.Format("生成报表文件失败"));
      } else {
         if (SendBackFile(strReportFilex, strReportType, request, response) && printForm.getENABLELOG()) {
            PrintLog printLogx = new PrintLog();
            printLogx.setPRINTFORMID(printForm.getPRINTFORMID());
            printLogx.setFORMDATA(strKeyMultiValue);
            IDEDataCtrl printLogDataCtrl = servletContext.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0202", servletContext);
            if (printLogDataCtrl != null) {
               printLogDataCtrl.Save(true, printLogx);
            }
         }
      }
   }

   protected void DoMulitplePrint(
      String strReportType,
      String strDEId,
      IDEHelper iDEHelper,
      String strKey,
      String strKeyMultiValue,
      SRFDAHttpServletContext servletContext,
      HttpServletRequest request,
      HttpServletResponse response
   ) {
      IDEDataCtrl iDEDataCtrl = iDEHelper.GetDEDataCtrl(servletContext.getCurUserId(), null);
      if (iDEDataCtrl == null) {
         this.SendbackError(servletContext, StringHelper.Format("无法获取实体[%1$s]数据操作对象", strDEId), strReportType, request, response);
      } else {
         String strFormName = servletContext.GetParamValue("PRINTFORM");
         if (StringHelper.IsNullOrEmpty(strFormName)) {
            strFormName = "DEFAULT";
         }

         PrintForm printForm = new PrintForm();
         CallResult callResult = servletContext.getGlobalHelper().getDAModelHelper().GetDEPrintForm(strDEId, strFormName, printForm);
         if (callResult.getRetCode() != 0) {
            this.SendbackError(
               servletContext,
               StringHelper.Format("无法获取实体[%1$s]指定报表[%2$s]，%3$s", strDEId, strFormName, callResult.getErrorInfo()),
               strReportType,
               request,
               response
            );
         } else {
            ArrayList<String> arrPdfFiles = new ArrayList<>();
            String[] arrKeyValue = strKeyMultiValue.split(",");
            String[] printLogDataCtrl = arrKeyValue;
            int printLog = arrKeyValue.length;

            for (int pdfPrintHelper = 0; pdfPrintHelper < printLog; pdfPrintHelper++) {
               String strKeyValue = printLogDataCtrl[pdfPrintHelper];
               BaseDataEntity dataEntity = new BaseDataEntity();
               dataEntity.SetParamValue(strKey, DataTypeParse.Parse(iDEHelper.GetKeyDEFHelper().GetStdDataType(), strKeyValue));
               callResult = iDEHelper.GetDataAccHelper().Test(servletContext, dataEntity, "READ");
               if (callResult.getRetCode() != 0) {
                  this.SendbackError(servletContext, StringHelper.Format("检查用户数据权限发生错误,%1$s", callResult.getErrorInfo()), strReportType, request, response);
                  return;
               }

               if (StringHelper.IsNullOrEmpty(printForm.getGETACTION())) {
                  callResult = iDEDataCtrl.Get(dataEntity);
               } else {
                  callResult = iDEDataCtrl.CustomCall(printForm.getGETACTION(), dataEntity);
               }

               if (callResult.getRetCode() != 0) {
                  this.SendbackError(
                     servletContext,
                     StringHelper.Format("获取实体[%1$s][%2$s]失败，%3$s", strDEId, strKeyValue, callResult.getErrorInfo()),
                     strReportType,
                     request,
                     response
                  );
                  return;
               }

               if (printForm.getENABLECOLPRIV()) {
                  IUserPrivilegeMgr iUserPrivilegeMgr = servletContext.GetUserPrivilegeMgr();

                  for (IDEFHelper iDEFHelper : iDEHelper.GetDEFHelpers()) {
                     if (iDEFHelper.IsEnableDEFieldPriv()) {
                        int nRet = iUserPrivilegeMgr.TestColumn(servletContext, StringHelper.Format("%1$s|%2$s", iDEHelper.getId(), iDEFHelper.getId()));
                        if (nRet == 0) {
                           dataEntity.RemoveParam(iDEFHelper.getName());
                        }
                     }
                  }
               }

               PrintFormActionHelper printFormActionHelper = null;
               String strReportObject = printForm.getFORMOBJECT();
               if (StringHelper.IsNullOrEmpty(strReportObject)) {
                  printFormActionHelper = new PrintFormActionHelper();
               } else {
                  Object obj = ObjectHelper.Create(strReportObject);
                  if (obj == null) {
                     this.SendbackError(servletContext, StringHelper.Format("无法建立打印表单处理对象[%1$s]", strReportObject), strReportType, request, response);
                     continue;
                  }

                  if (!(obj instanceof PrintFormActionHelper)) {
                     this.SendbackError(servletContext, StringHelper.Format("打印表单处理对象[%1$s]类型不正确", strReportObject), strReportType, request, response);
                     continue;
                  }

                  printFormActionHelper = (PrintFormActionHelper)obj;
               }

               servletContext.SetParamValue(strKey, strKeyValue);
               String strReportFile = printFormActionHelper.GetPrintFormFile(
                  dataEntity, servletContext, servletContext.getGlobalHelper(), printForm, strReportType
               );
               if (StringHelper.IsNullOrEmpty(strReportFile)) {
                  log.error(StringHelper.Format("生成报表文件失败[%1$s]", strKeyValue));
               } else {
                  arrPdfFiles.add(strReportFile);
               }
            }

            String strMergedPdfURL = this.GetTmpFilePath(servletContext, strReportType, "MERGED_");
            PDFPrintHelper pdfPrintHelper = new PDFPrintHelper(strMergedPdfURL, arrPdfFiles, this.OnGetPrintDialogMode(servletContext));

            try {
               pdfPrintHelper.DoMerge();
            } catch (Exception e) {
               this.SendbackError(servletContext, StringHelper.Format("合并文件出现错误！"), strReportType, request, response);
               e.printStackTrace();
            } finally {
               pdfPrintHelper.Close();
            }

            if (SendBackFile(strMergedPdfURL, strReportType, request, response) && printForm.getENABLELOG()) {
               PrintLog printLogx = new PrintLog();
               printLogx.setPRINTFORMID(printForm.getPRINTFORMID());
               printLogx.setFORMDATA(strKeyMultiValue);
               IDEDataCtrl printLogDataCtrlx = servletContext.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0202", servletContext);
               if (printLogDataCtrlx != null) {
                  printLogDataCtrlx.Save(true, printLogx);
               }
            }
         }
      }
   }

   protected String OnGetPrintDialogMode(SRFDAHttpServletContext servletContext) {
      String strPrintDialogMode = servletContext.GetParamValue("PRINTDIALOGMODE");
      if (StringHelper.IsNullOrEmpty(strPrintDialogMode)) {
         strPrintDialogMode = servletContext.getWebExConfig().GetValue("SRFDA", "PRINTDIALOGMODE", PrintDialogMode.NONE);
      }

      return strPrintDialogMode;
   }

   protected void SendbackError(
      SRFDAHttpServletContext servletContext, String strError, String strReportType, HttpServletRequest request, HttpServletResponse response
   ) {
      log.error(strError);
      String strPrintFormPath = servletContext.GetAppRootPath() + "srfreport" + File.separator + "printform" + File.separator + "error.jasper";
      String strTempFilePath = this.GetTmpFilePath(servletContext, strReportType);
      Map parameters = new TreeMap();
      parameters.put("ERROR_INFO", strError);

      try {
         JasperRunManager.runReportToPdfFile(strPrintFormPath, strTempFilePath, parameters, new DAJRDataSource(null));
         SendBackFile(strTempFilePath, strReportType, request, response);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   protected static boolean SendBackFile(String strReportFile, String strReportType, HttpServletRequest request, HttpServletResponse response) {
      boolean bRet = true;

      try {
         if (StringHelper.Compare(strReportType, "PDF", true) == 0) {
            response.setContentType("application/pdf");
         }

         BufferedInputStream bis = null;
         BufferedOutputStream bos = null;

         try {
            bis = new BufferedInputStream(new FileInputStream(strReportFile));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];

            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
               bos.write(buff, 0, bytesRead);
            }
         } catch (IOException e) {
            bRet = false;
            System.out.println("出现IOException." + e);
         } finally {
            if (bis != null) {
               bis.close();
            }

            if (bos != null) {
               bos.close();
            }
         }
      } catch (Exception ex) {
         bRet = false;
         ex.printStackTrace();
      }

      return bRet;
   }

   protected String GetTmpFilePath(SRFDAHttpServletContext servletContext, String strReportType, String strPrefix) {
      String strFileName = strPrefix + Helper.GenGuid();
      return StringHelper.Compare(strReportType, "PDF", true) == 0
         ? StringHelper.Format("%1$s%2$s.pdf", servletContext.GetTempPath(), strFileName)
         : StringHelper.Format("%1$s%2$s", strReportType, strFileName);
   }

   protected String GetTmpFilePath(SRFDAHttpServletContext servletContext, String strReportType) {
      return this.GetTmpFilePath(servletContext, strReportType, "");
   }
}
