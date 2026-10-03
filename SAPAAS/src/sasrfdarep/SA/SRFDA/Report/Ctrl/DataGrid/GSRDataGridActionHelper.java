package SA.SRFDA.Report.Ctrl.DataGrid;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DefaultDAQueryModelUserContext;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.GSRGroupColumn;
import SA.SRFDA.Ctrl.Data.GSRMeasure;
import SA.SRFDA.Ctrl.Data.GroupStatisticsRep;
import SA.SRFDA.Model.DGModelBaseLogicConfig;
import SA.SRFDA.Model.DGModelGroupLogicConfig;
import SA.SRFDA.Model.QueryGroupItemConfig;
import SA.SRFDA.Model.QueryGroupModelConfig;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.DEDataImportTemplateHelper;
import SA.SRFDA.Web.Utility.ISRFDAPOLogger;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.DataEntityTable;
import SA.SRFramework.Log.LoggerEx;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDataGridActionHelper;
import SA.SRFramework.WebEx.SRFExGridFetchResult;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.Utility.DataGridExcelReportHelper;
import SA.SRFramework.WebEx.Utility.DataGridExcelReportHelperEx;
import SA.SRFramework.WebEx.Utility.GridFetchResultHelper;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GSRDataGridActionHelper extends SRFExDataGridActionHelper {
   private static final Log log = LogFactory.getLog(GSRDataGridActionHelper.class);
   protected DefaultDAQueryModelUserContext qmUserContext = null;
   protected String strQueryKey = "";
   protected GroupStatisticsRep groupStatisticsRep = null;

   @Override
   protected boolean OnBeforeProcess() {
      return super.OnBeforeProcess();
   }

   @Override
   protected boolean OnFetchAction() {
      SRFExGridFetchResult fetchResult = new SRFExGridFetchResult();
      this.groupStatisticsRep = this.getGroupStatisticsRep();
      if (this.groupStatisticsRep == null) {
         log.error("无法获取分组统计报表对象");
         fetchResult.setRetCode(1);
         fetchResult.setErrorInfo("无法获取分组统计报表对象");
         this.getPage().Output(fetchResult.ToJSONString());
         return true;
      }

      BaseDAQueryModelHelper daQueryModelHelper = null;
      String strQueryModel = this.groupStatisticsRep.getQUERYMODELID();
      boolean bUserDP = this.OnGetUserDP();
      if (!StringHelper.IsNullOrEmpty(strQueryModel)) {
         if (bUserDP) {
            daQueryModelHelper = this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel);
         } else {
            daQueryModelHelper = this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel);
         }
      } else if (bUserDP) {
         daQueryModelHelper = this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(this.getDEHelper(), "", false);
      } else {
         daQueryModelHelper = this.getPage().getDAModelStorage().getDAQueryModelHelper(this.getDEHelper());
      }

      this.strQueryKey = StringHelper.Format("QUERYMODEL[%1$s] USERDP[%2$s]", strQueryModel, bUserDP ? "TRUE" : "FALSE");
      log.info(StringHelper.Format("表格查询 [%1$s]", strQueryModel));
      if (daQueryModelHelper == null) {
         fetchResult.setRetCode(1);
         fetchResult.setErrorInfo("查询模型辅助对象无效");
         log.error(fetchResult.getErrorInfo());
         this.getPage().Output(fetchResult.ToJSONString());
         return true;
      }

      this.qmUserContext = new DefaultDAQueryModelUserContext();
      StringBuilderEx script = new StringBuilderEx();
      String strQueryScript = this.GetDAModelQueryScript(daQueryModelHelper);
      Vector<String> userConditions = new Vector<>();
      String strGroupField = this.getWebContext().GetPostValue("srfgroupfield");
      if (this.groupStatisticsRep.getENABLETIMEGROUP()) {
         CallResult callResult = this.AppendTimeGroupSQL(
            daQueryModelHelper,
            this.groupStatisticsRep.getTIMEDEFIELDID(),
            this.groupStatisticsRep.getBEGINTIMEARG(),
            this.groupStatisticsRep.getENDTIMEARG(),
            false,
            strQueryScript,
            userConditions,
            strGroupField
         );
         if (callResult.IsError()) {
            fetchResult.From(callResult);
            log.error(fetchResult.getErrorInfo());
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
         }

         strQueryScript = (String)callResult.getUserObject();
      } else {
         for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
            if (StringHelper.Compare(groupColumn.getDEFIELDNAME(), strGroupField, true) == 0) {
               if (groupColumn.getENABLETIMEGROUP()) {
                  CallResult callResult = this.AppendTimeGroupSQL(
                     daQueryModelHelper, groupColumn.getDEFIELDID(), "", "", true, strQueryScript, userConditions, groupColumn.getTIMEGROUPTYPE()
                  );
                  if (callResult.IsError()) {
                     fetchResult.From(callResult);
                     log.error(fetchResult.getErrorInfo());
                     this.getPage().Output(fetchResult.ToJSONString());
                     return true;
                  }

                  strQueryScript = (String)callResult.getUserObject();
               }
               break;
            }
         }
      }

      script.Append(strQueryScript);
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

            script.Append("(%1$s)", strCondition);
         }
      }

      Vector<String> dynamicTables = null;
      boolean bDynamicMode = false;
      if (StringHelper.Compare(this.getDEHelper().getDataEntity().getSTORAGETYPE(), "DYNAMIC", true) == 0) {
         bDynamicMode = true;
         String strTimeFrom = this.getDEHelper().GetProperty("DYNAMICFROM");
         String strTimeTo = this.getDEHelper().GetProperty("DYNAMICTO");
         String strTime1 = this.getPage().getRequest().getParameter(strTimeFrom.toLowerCase());
         if (strTime1 == null) {
            strTime1 = this.getWebContext().GetParamValue(strTimeFrom.toUpperCase());
         }

         String strTime2 = this.getPage().getRequest().getParameter(strTimeTo.toLowerCase());
         if (strTime2 == null) {
            strTime2 = this.getWebContext().GetParamValue(strTimeTo.toUpperCase());
         }

         if (StringHelper.IsNullOrEmpty(strTime1) || StringHelper.IsNullOrEmpty(strTime2)) {
            log.error("没有指定开始或结束时间");
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("没有指定开始或结束时间");
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
         }

         try {
            Date startDate = DateParser.Parse(strTime1);
            Date endDate = DateParser.Parse(strTime2);
            dynamicTables = new Vector<>();
            CallResult callResult = this.getDEHelper().GetDynamicTables(startDate, endDate, dynamicTables);
            if (callResult.IsError()) {
               fetchResult.setRetCode(1);
               fetchResult.setErrorInfo(callResult.getErrorInfo());
               this.getPage().Output(fetchResult.ToJSONString());
               return true;
            }
         } catch (Exception e) {
            log.error(e);
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo(e.getMessage());
            this.getPage().Output(fetchResult.ToJSONString());
            return true;
         }
      }

      String strSortParam = "";
      String strSortDirection = "";
      strSortParam = this.getPage().getRequest().getParameter("sort");
      String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
      if (StringHelper.Length(strRealSortParam) > 0) {
         strSortParam = strRealSortParam;
      }

      strSortDirection = this.getPage().getRequest().getParameter("dir");
      QueryGroupModelConfig queryGroupModelConfig = new QueryGroupModelConfig();
      String strGroupCond = this.groupStatisticsRep.getGROUPCOND();
      if (!this.groupStatisticsRep.getENABLETIMEGROUP()) {
         String strTopN = this.getPage().getRequest().getParameter("srftopn");
         if (StringHelper.IsNullOrEmpty(strTopN)) {
            queryGroupModelConfig.setTopCount(100);
         } else {
            int nInt = Integer.parseInt(strTopN);
            if (nInt <= 0) {
               nInt = 100;
            }

            queryGroupModelConfig.setTopCount(nInt);
         }

         if (!StringHelper.IsNullOrEmpty(strGroupField)) {
            for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
               if (StringHelper.Compare(groupColumn.getDEFIELDNAME(), strGroupField, true) == 0) {
                  if (!groupColumn.getENABLETIMEGROUP()) {
                     QueryGroupItemConfig queryGroupItemConfig = new QueryGroupItemConfig();
                     queryGroupItemConfig.setAlias(groupColumn.getDEFIELDNAME());
                     queryGroupItemConfig.setDEFields(groupColumn.getDEFIELDNAME());
                     queryGroupItemConfig.setIsGroup(true);
                     if (StringHelper.Compare(strSortParam, groupColumn.getDEFIELDNAME(), true) == 0) {
                        queryGroupItemConfig.setOrder(0);
                        queryGroupItemConfig.setOrderDirection(strSortDirection);
                     }

                     queryGroupModelConfig.add(queryGroupItemConfig);
                     if (!StringHelper.IsNullOrEmpty(groupColumn.getCOND())) {
                        if (!StringHelper.IsNullOrEmpty(strGroupCond)) {
                           strGroupCond = strGroupCond + " AND ";
                        }

                        strGroupCond = strGroupCond + groupColumn.getCOND();
                     }

                     if (!StringHelper.IsNullOrEmpty(groupColumn.getNAMEDEFNAME())) {
                        queryGroupItemConfig = new QueryGroupItemConfig();
                        queryGroupItemConfig.setAlias(groupColumn.getNAMEDEFNAME());
                        queryGroupItemConfig.setDEFields(groupColumn.getNAMEDEFNAME());
                        queryGroupItemConfig.setIsGroup(true);
                        if (StringHelper.Compare(strSortParam, groupColumn.getNAMEDEFNAME(), true) == 0) {
                           queryGroupItemConfig.setOrder(0);
                           queryGroupItemConfig.setOrderDirection(strSortDirection);
                        }

                        queryGroupModelConfig.add(queryGroupItemConfig);
                     }
                  } else {
                     String strTDSortParam = "";
                     if (StringHelper.Compare(strSortParam, groupColumn.getDEFIELDNAME(), true) == 0) {
                        strTDSortParam = "srftdid";
                     }

                     Vector<String> groupParams = new Vector<>();
                     groupParams.add("srftdid");
                     groupParams.add("srftdname");
                     groupParams.add("srftdfrom");
                     groupParams.add("srftdto");

                     for (String strGroupName : groupParams) {
                        QueryGroupItemConfig queryGroupItemConfig = new QueryGroupItemConfig();
                        if (StringHelper.Compare(strGroupName, "srftdname", true) == 0) {
                           queryGroupItemConfig.setAlias(groupColumn.getDEFIELDNAME());
                        } else {
                           queryGroupItemConfig.setAlias(strGroupName);
                        }

                        queryGroupItemConfig.setDEFields(strGroupName);
                        queryGroupItemConfig.setIsGroup(true);
                        if (StringHelper.Compare(strTDSortParam, strGroupName, true) == 0) {
                           queryGroupItemConfig.setOrder(0);
                           queryGroupItemConfig.setOrderDirection(strSortDirection);
                        }

                        queryGroupModelConfig.add(queryGroupItemConfig);
                     }
                  }
               } else if (groupColumn.getDEFAULTGROUP() || groupColumn.getORDERFLAG() == -1) {
                  QueryGroupItemConfig queryGroupItemConfig = new QueryGroupItemConfig();
                  queryGroupItemConfig.setAlias(groupColumn.getDEFIELDNAME());
                  queryGroupItemConfig.setDEFields(groupColumn.getDEFIELDNAME());
                  queryGroupItemConfig.setIsGroup(true);
                  if (StringHelper.Compare(strSortParam, groupColumn.getDEFIELDNAME(), true) == 0) {
                     queryGroupItemConfig.setOrder(0);
                     queryGroupItemConfig.setOrderDirection(strSortDirection);
                  }

                  queryGroupModelConfig.add(queryGroupItemConfig);
               }
            }
         }
      } else {
         Vector<String> groupParams = new Vector<>();
         groupParams.add("srftdid");
         groupParams.add("srftdname");
         groupParams.add("srftdfrom");
         groupParams.add("srftdto");

         for (String strGroupName : groupParams) {
            QueryGroupItemConfig queryGroupItemConfig = new QueryGroupItemConfig();
            queryGroupItemConfig.setAlias(strGroupName);
            queryGroupItemConfig.setDEFields(strGroupName);
            queryGroupItemConfig.setIsGroup(true);
            if (StringHelper.Compare(strSortParam, strGroupName, true) == 0) {
               queryGroupItemConfig.setOrder(0);
               queryGroupItemConfig.setOrderDirection(strSortDirection);
            }

            queryGroupModelConfig.add(queryGroupItemConfig);
         }
      }

      queryGroupModelConfig.setGroupCond(strGroupCond);

      for (GSRMeasure gsrMeasure : this.groupStatisticsRep.getMeasures()) {
         QueryGroupItemConfig queryGroupItemConfig = new QueryGroupItemConfig();
         queryGroupItemConfig.setAlias(gsrMeasure.getEXPALIAS());
         queryGroupItemConfig.setFormular(gsrMeasure.getEXPRESSION());
         queryGroupItemConfig.setIsGroup(false);
         queryGroupItemConfig.setReCalc(gsrMeasure.getRECALCFLAG());
         if (StringHelper.Compare(strSortParam, gsrMeasure.getEXPALIAS(), true) == 0) {
            queryGroupItemConfig.setOrder(0);
            queryGroupItemConfig.setOrderDirection(strSortDirection);
         }

         queryGroupModelConfig.add(queryGroupItemConfig);
      }

      Vector<CallParam> params = new Vector<>();
      daQueryModelHelper.FillQMDeclareParams(params, this.getWebContext(), this.getWebContext().getGlobalHelper(), "");
      String strSQL = daQueryModelHelper.GetGroupSQL(
         script.toString(), queryGroupModelConfig, params, this.getWebContext(), this.getWebContext().getGlobalHelper(), "", null
      );
      daQueryModelHelper.FillCallParams(params, this.getWebContext(), this.getWebContext().getGlobalHelper(), "");
      strSQL = daQueryModelHelper.GetQMDeclareScript() + strSQL;
      strSQL = daQueryModelHelper.ReplaceURLParamMacro(strSQL, this.getWebContext());
      if (bDynamicMode) {
         strSQL = daQueryModelHelper.ReplaceDynamicTableMacro(strSQL, dynamicTables);
      }

      this.SelectAndFillFetchResult(strSQL, params, fetchResult);
      this.getPage().Output(fetchResult.ToJSONString());
      return true;
   }

   protected String OnGetAdditionalQueryModel() {
      return this.getPage().getPageParam("PAGE.DATAGRID.QUERYMODEL", "");
   }

   protected boolean OnGetNoDefQuery() {
      return this.getPage().getPageParam("PAGE.DATAGRID.NODEFQUERY", false);
   }

   protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
      return daQueryModelHelper.GetQueryModelScript();
   }

   protected boolean OnGetUserDP() {
      return StringHelper.Compare(this.getWebContext().getCurUserId(), "SYSTEM", true) == 0 ? false : this.getPage().getPageParam("PAGE.DATAGRID.USERDP", true);
   }

   protected CallResult OnSaveActionBeforeInsert(BaseDataEntity dataEntity) {
      CallResult callResult = this.OnTestDataAction(dataEntity, "CREATE");
      return callResult.getRetCode() != 0 ? callResult : this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
   }

   protected String OnGetDGUpdateMode() {
      return this.getPage().getPageParam("PAGE.DATAGRID.UPDATEMODE", "DEFAULT");
   }

   protected String OnGetDGInsertMode() {
      return this.getPage().getPageParam("PAGE.DATAGRID.INSERTMODE", "DEFAULT");
   }

   protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
      String strAction = this.OnGetDGUpdateMode();
      if (StringHelper.IsNullOrEmpty(strAction)) {
         strAction = "DEFAULT";
      }

      if (StringHelper.IsNullOrEmpty(strAction) || StringHelper.Compare(strAction, "DEFAULT", true) == 0) {
         strAction = "UPDATE";
      }

      CallResult callResult = this.OnTestDataAction(dataEntity, strAction);
      return callResult.getRetCode() != 0 ? callResult : this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
   }

   protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction) {
      return this.OnTestDataAction(this.getDEHelper(), dataEntity, strAction);
   }

   protected CallResult OnTestDataAction(IDEHelper iDEHelper, BaseDataEntity dataEntity, String strAction) {
      return iDEHelper.GetDataAccHelper().Test(this.getWebContext(), dataEntity, strAction);
   }

   protected void FillAdditionalDPCode(TreeMap<String, String> codeSets) {
   }

   protected void FillDAQueryModelHelperCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
      this.FillSearchFormCondition(userConditions, daQueryModelHelper);
      this.FillURLCondition(userConditions, daQueryModelHelper);
   }

   protected void FillPickupModeCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
   }

   protected boolean FillURLCondition(BaseDataEntity userConditions) {
      String strDERID = this.getWebContext().getSRFDERID();
      if (StringHelper.IsNullOrEmpty(strDERID)) {
         return false;
      }

      ILinkDEFHelper pickupDEFHelper = null;

      for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
         if (iDEFHelper.IsLinkDEField()) {
            ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
            if (StringHelper.Compare(linkDEFHelper.GetDERId(), strDERID, true) == 0 && StringHelper.Compare(linkDEFHelper.GetDataType(), "PICKUP", true) == 0) {
               pickupDEFHelper = linkDEFHelper;
               break;
            }
         }
      }

      if (pickupDEFHelper == null) {
         return false;
      }

      String strValue = "";
      String strParamName = "";
      String strDERIndexId = this.getWebContext().getSRFDERINDEXID();
      if (!StringHelper.IsNullOrEmpty(strDERIndexId)) {
         DERINDEX derIndex = new DERINDEX();
         CallResult callResult = this.getPage().getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
         if (callResult.getRetCode() != 0) {
            log.error(StringHelper.Format("获取实体索引关系[%1$s]失败，%2$s", strDERIndexId, callResult.getErrorInfo()));
         } else {
            IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(derIndex.getDEID());
            if (iDEHelper == null) {
               log.error(StringHelper.Format("无法获取实体[%1$s]辅助对象", derIndex.getDEID()));
            } else {
               strParamName = iDEHelper.GetKeyDEFHelper().getName();
            }
         }
      } else {
         strParamName = pickupDEFHelper.GetRelatedDEFHelper().getName();
      }

      strValue = this.getWebContext().GetPostValue(strParamName);
      if (StringHelper.IsNullOrEmpty(strValue)) {
         strValue = this.getWebContext().GetParamValue(strParamName);
      }

      if (strValue != null) {
         strValue = strValue.trim();
      }

      if (StringHelper.IsNullOrEmpty(strValue)) {
         strValue = "NA";
      }

      userConditions.SetParamValue("PTEMPKEYVALUE", strValue);
      userConditions.SetParamValue("PDEID", pickupDEFHelper.GetRealDEFHelper().getDEHelper().getId());
      return true;
   }

   protected void FillURLCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
      String strDERID = this.getWebContext().getSRFDERID();
      if (!StringHelper.IsNullOrEmpty(strDERID)) {
         ILinkDEFHelper pickupDEFHelper = null;

         for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
            if (iDEFHelper.IsLinkDEField()) {
               ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
               if (StringHelper.Compare(linkDEFHelper.GetDERId(), strDERID, true) == 0
                  && StringHelper.Compare(linkDEFHelper.GetDataType(), "PICKUP", true) == 0) {
                  pickupDEFHelper = linkDEFHelper;
                  break;
               }
            }
         }

         if (pickupDEFHelper == null) {
            return;
         }

         String strValue = "";
         String strParamName = "";
         String strDERIndexId = this.getWebContext().getSRFDERINDEXID();
         if (!StringHelper.IsNullOrEmpty(strDERIndexId)) {
            DERINDEX derIndex = new DERINDEX();
            CallResult callResult = this.getPage().getDAModelHelper().GetDERINDEX(strDERIndexId, derIndex);
            if (callResult.getRetCode() != 0) {
               log.error(StringHelper.Format("获取实体索引关系[%1$s]失败，%2$s", strDERIndexId, callResult.getErrorInfo()));
            } else {
               IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(derIndex.getDEID());
               if (iDEHelper == null) {
                  log.error(StringHelper.Format("无法获取实体[%1$s]辅助对象", derIndex.getDEID()));
               } else {
                  strParamName = iDEHelper.GetKeyDEFHelper().getName();
               }
            }
         } else {
            strParamName = pickupDEFHelper.GetRelatedDEFHelper().getName();
         }

         strValue = this.getWebContext().GetPostValue(strParamName);
         if (StringHelper.IsNullOrEmpty(strValue)) {
            strValue = this.getWebContext().GetParamValue(strParamName);
         }

         if (strValue != null) {
            strValue = strValue.trim();
         }

         if (StringHelper.IsNullOrEmpty(strValue)) {
            strValue = "NA";
         }

         String strCondition = daQueryModelHelper.GetConditionSQL(this.qmUserContext, pickupDEFHelper, "", "=", strValue);
         if (!StringHelper.IsNullOrEmpty(strCondition)) {
            userConditions.add(strCondition);
         }
      }
   }

   protected void FillSearchFormCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
      this.FillSearchFormCSMCondition(userConditions, daQueryModelHelper);
      String strFilter = this.getWebContext().getSRFFILTER();
      TreeMap<String, String> filterMap = null;
      if (!StringHelper.IsNullOrEmpty(strFilter)) {
         filterMap = new TreeMap<>();
         String[] parts = strFilter.split("[;]");

         for (int i = 0; i < parts.length; i++) {
            String strPart = parts[i];
            if (!StringHelper.IsNullOrEmpty(strPart)) {
               String[] params = strPart.split("[|]");
               if (params.length >= 2) {
                  filterMap.put(params[0].toUpperCase(), params[1].toUpperCase());
               }
            }
         }
      }

      for (IDEFHelper iDEFHelper : this.getDEHelper().GetDEFHelpers()) {
         SearchModelConfig searchModelConfig = iDEFHelper.GetSearchModel();
         if (searchModelConfig != null) {
            for (SearchItemConfig searchItemConfig : searchModelConfig) {
               if (iDEFHelper.IsSupportSearchAction(searchItemConfig)) {
                  String strFormItemId = this.getWebContext().getGlobalHelper().getDAFormItemHelper().GetSearchFormItemId(iDEFHelper, searchItemConfig);
                  String strValue = this.getPage().getRequest().getParameter(strFormItemId.toLowerCase());
                  if (strValue == null) {
                     strValue = this.getWebContext().GetParamValue(strFormItemId.toUpperCase());
                     if (StringHelper.IsNullOrEmpty(strValue)) {
                        if (filterMap == null || !filterMap.containsKey(strFormItemId.toUpperCase())) {
                           continue;
                        }

                        strValue = this.getWebContext().GetParamValue(filterMap.get(strFormItemId.toUpperCase()));
                        if (StringHelper.IsNullOrEmpty(strValue)) {
                           continue;
                        }
                     }
                  }

                  strValue = strValue.trim();
                  if (!StringHelper.IsNullOrEmpty(strValue)) {
                     strValue = strValue.replace("\\'", "'");
                     String strCondition = daQueryModelHelper.GetConditionSQL(this.qmUserContext, iDEFHelper, searchItemConfig, strValue);
                     if (!StringHelper.IsNullOrEmpty(strCondition)) {
                        userConditions.add(strCondition);
                     }
                  }
               }
            }
         }
      }
   }

   protected void FillSearchFormCSMCondition(Vector<String> userConditions, BaseDAQueryModelHelper daQueryModelHelper) {
      String strValue = this.getPage().getRequest().getParameter("srfcsm");
      if (!StringHelper.IsNullOrEmpty(strValue)) {
         DGModelGroupLogicConfig dgModelGroupLogicConfig = new DGModelGroupLogicConfig();
         if (!XMLConfig.LoadFromXML(strValue, dgModelGroupLogicConfig)) {
            log.error(StringHelper.Format("搜索表单动态查询模型无效"));
         } else if (dgModelGroupLogicConfig.getLogicsConfig() != null) {
            DGModelGroupLogicConfig realGroupLogicConfig = new DGModelGroupLogicConfig();
            realGroupLogicConfig.InitLogicsConfig();
            realGroupLogicConfig.setCondition("OR");
            TreeMap<String, DGModelGroupLogicConfig> groups = new TreeMap<>();

            for (DGModelBaseLogicConfig dgModelBaseLogicConfig : dgModelGroupLogicConfig.getLogicsConfig()) {
               String strGroupNo = dgModelBaseLogicConfig.GetExtValue("GROUPNO", "");
               DGModelGroupLogicConfig curGroupLogicConfig = null;
               if (!groups.containsKey(strGroupNo.toUpperCase())) {
                  curGroupLogicConfig = new DGModelGroupLogicConfig();
                  curGroupLogicConfig.InitLogicsConfig();
                  curGroupLogicConfig.setCondition("AND");
                  groups.put(strGroupNo.toUpperCase(), curGroupLogicConfig);
                  realGroupLogicConfig.getLogicsConfig().add(curGroupLogicConfig);
               } else {
                  curGroupLogicConfig = groups.get(strGroupNo.toUpperCase());
               }

               curGroupLogicConfig.getLogicsConfig().add(dgModelBaseLogicConfig);
            }

            CallResult callResult = daQueryModelHelper.GetGroupCondition(realGroupLogicConfig);
            if (callResult.IsError()) {
               log.error(StringHelper.Format("获取自定义搜索逻辑发生错误，%1$s", callResult.getErrorInfo()));
            } else {
               userConditions.add(callResult.getUserObject().toString());
            }
         }
      }
   }

   protected void SelectAndFillFetchResult(String strPagingSQL, Vector<CallParam> list, SRFExGridFetchResult fetchResult) {
      try {
         StringBuilderEx paramInfo = new StringBuilderEx();
         StringBuilderEx info = new StringBuilderEx();
         info.Append("PAGING SQL\r\n%1$s\r\n", strPagingSQL);
         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               CallParam callParam = list.get(i);
               info.Append("参数[%1$s][%2$s][%3$s]\r\n", i + 1, callParam.getParamName(), callParam.getValue());
               paramInfo.Append("参数[%1$s][%2$s][%3$s]\r\n", i + 1, callParam.getParamName(), callParam.getValue());
            }
         }

         long nSelectTime = new Date().getTime();
         SelectResult selectResult = this.getWebContext().getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw3(strPagingSQL, list);
         if (selectResult == null) {
            info.Append("分页数据查询失败\r\n");
            LoggerEx.error(log, info.toString(), null, this.getWebContext(), this.getDEHelper().getId());
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("不明错误");
            return;
         }

         nSelectTime = new Date().getTime() - nSelectTime;
         if (selectResult.getRetCode() != 0) {
            info.Append("分页数据查询失败，%1$s\r\n", selectResult.getErrorInfo());
            LoggerEx.error(log, info.toString(), null, this.getWebContext(), this.getDEHelper().getId());
            fetchResult.From(selectResult);
            return;
         }

         if (selectResult.getSelectData().getTableCount() != 1) {
            info.Append("分页数据查询失败，没有返回结果\r\n");
            LoggerEx.error(log, info.toString(), null, this.getWebContext(), this.getDEHelper().getId());
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("返回结果集有误");
            return;
         }

         DataSet ds = selectResult.getSelectData();
         GridFetchResultHelper.Fill(
            this.getWebContext(),
            fetchResult.getItems(),
            ds.getTable(0),
            this.getDataGrid().getDataGridConfig(),
            this.getDataGrid().getUniqueID(),
            false,
            this.getDataGrid().isEnableItemPrivilege()
         );
         this.FillSummaryInfo(fetchResult, ds.getTable(0));
         fetchResult.setRetCode(0);
         info.Append("分页数据查询耗时[%1$sms]\r\n", nSelectTime);
         LoggerEx.info(log, info.toString(), null, this.getWebContext(), this.getDEHelper().getId());
         this.LogQueryPerformance(strPagingSQL + "\r\n" + paramInfo.toString(), (int)nSelectTime);
      } catch (Exception ex) {
         fetchResult.setRetCode(1);
         fetchResult.setErrorInfo(ex.getMessage());
      }
   }

   protected boolean isLogQueryPerformance() {
      return this.getDEHelper().GetProperty("LOGPODBQUERY", true);
   }

   public void LogQueryPerformance(String strSQL, int nProcessTime) {
      if (this.isLogQueryPerformance()) {
         ISRFDAPOLogger poLogger = this.getWebContext().getGlobalHelper().getPOLoggerEx();
         if (poLogger != null) {
            poLogger.LogDBQuery(this.getDEHelper().getId(), this.strQueryKey, strSQL, this.getWebContext().getCurUserId(), nProcessTime);
         }
      }
   }

   protected void SelectAndFillFetchResult(BaseDataEntity cond, SRFExGridFetchResult fetchResult) {
      try {
         IDEDataCtrl iTempDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0112", this.getWebContext());
         if (iTempDataCtrl == null) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo(StringHelper.Format("无法获取实体[%1$s]数据访问对象", "DE0112"));
            log.error(fetchResult.getErrorInfo());
            return;
         }

         Vector<BaseDataEntity> list = new Vector<>();
         CallResult callResult = iTempDataCtrl.Select(cond, list);
         if (callResult == null) {
            fetchResult.setRetCode(1);
            fetchResult.setErrorInfo("不明错误");
            return;
         }

         if (callResult.getRetCode() != 0) {
            fetchResult.From(callResult);
            return;
         }

         fetchResult.setTotalRow(list.size());
         Vector<BaseDataEntity> realList = new Vector<>();

         for (BaseDataEntity dataEntity : list) {
            BaseDataEntity realDE = BaseDataEntity.FromString(dataEntity.GetParamStringValue("DEDATA", ""));
            realDE.SetParamValue("SRFDATEMPKEYID", dataEntity.GetParamValue("TEMPDATAID"));
            realList.add(realDE);
         }

         DataEntityTable dataEntityTable = new DataEntityTable(realList);
         GridFetchResultHelper.Fill(
            this.getWebContext(), fetchResult.getItems(), dataEntityTable, this.getDataGrid().getDataGridConfig(), this.getDataGrid().getUniqueID(), true
         );
         fetchResult.setRetCode(0);
      } catch (Exception ex) {
         fetchResult.setRetCode(1);
         fetchResult.setErrorInfo(ex.getMessage());
      }
   }

   protected void FillSummaryInfo(SRFExGridFetchResult fetchResult, DataTable dataTable) {
   }

   protected CallResult SelectAndExport(String strPagingSQL, Vector<CallParam> list, String strExportType) {
      CallResult callResult = new CallResult();

      try {
         StringBuilderEx info = new StringBuilderEx();
         info.Append("PAGING SQL\r\n%1$s\r\n", strPagingSQL);
         if (list != null) {
            for (int i = 0; i < list.size(); i++) {
               CallParam callParam = list.get(i);
               info.Append("参数[%1$s][%2$s][%3$s]\r\n", i + 1, callParam.getParamName(), callParam.getValue());
            }
         }

         log.info(info.toString());
         SelectResult selectResult = this.getWebContext().getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw3(strPagingSQL, list);
         if (selectResult == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("不明错误");
            return callResult;
         }

         if (selectResult.getRetCode() != 0) {
            callResult.From(selectResult);
            return callResult;
         }

         if (selectResult.getSelectData().getTableCount() != 1) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("返回结果集有误");
            return callResult;
         }

         String strFileSuffix = "";
         if (StringHelper.Compare(strExportType, "HTML", true) == 0) {
            strFileSuffix = "htm";
         } else {
            strFileSuffix = "xls";
         }

         String strTempFileName = Helper.GenGuid();
         String strDir = StringHelper.Format("%1$s%2$s", this.getWebContext().getGlobalHelper().GetTempPath(), this.getWebContext().getSessionId());
         File dir = new File(strDir);
         dir.mkdirs();
         String strFullFileName = StringHelper.Format(
            "%1$s%2$s%3$s%4$s.%5$s",
            this.getWebContext().getGlobalHelper().GetTempPath(),
            this.getWebContext().getSessionId(),
            File.separator,
            strTempFileName,
            strFileSuffix
         );
         this.GenExcelFile(selectResult, strFullFileName, strExportType);
         callResult.setUserObject(strTempFileName);
         callResult.setRetCode(0);
      } catch (Exception ex) {
         callResult.setRetCode(1);
         callResult.setErrorInfo(ex.getMessage());
      }

      return callResult;
   }

   protected void GenExcelFile(SelectResult selectResult, String strTempFileName, String strExportType) {
      GenExcelFile(this.getPage(), this.getDataGrid(), selectResult, strTempFileName, strExportType);
   }

   protected static void GenExcelFile(SRFDAPage page, SRFExDataGrid dataGrid, SelectResult selectResult, String strTempFileName, String strExportType) {
      try {
         DataGrid excelDataGrid = new DataGrid();
         CallResult callResult = page.getDAModelHelper().GetExcelExportDEDataGrid(page.getPageDataEntityId(), excelDataGrid);
         callResult = CallResult.ToCallResult(callResult);
         DataGridConfig dataGridConfig = null;
         if (callResult.getRetCode() == 0) {
            String strDGConfigId = page.getDAConfigHelper().GetGridViewDGConfigId(page.getDEHelper(), null, excelDataGrid, "");
            if (StringHelper.IsNullOrEmpty(strDGConfigId)) {
               page.PageLog(page, 1, StringHelper.Format("获取下载表格配配置路径失败"));
               return;
            }

            dataGridConfig = page.getWebContext().getDataGridMgr().GetDataGridConfig(strDGConfigId);
            if (dataGridConfig == null) {
               page.PageLog(page, 1, StringHelper.Format("获取下载表格配配置失败"));
               return;
            }
         } else {
            dataGridConfig = dataGrid.getDataGridConfig();
         }

         if (StringHelper.Compare(strExportType, "HTML", true) == 0) {
            DataGridExcelReportHelper excelReportHelper = new DataGridExcelReportHelper();
            excelReportHelper.setPrint(true);
            excelReportHelper.setCloseAfterPrint(true);
            excelReportHelper.setDataSource(selectResult.getMainTable());
            excelReportHelper.setWebContext(page.getWebContext());
            excelReportHelper.setConfig(dataGridConfig);
            excelReportHelper.setEnableItemPrivilege(dataGrid.isEnableItemPrivilege());
            FileWriter fw = new FileWriter(new File(strTempFileName));
            fw.flush();
            excelReportHelper.Output(fw);
            fw.close();
         } else {
            DataGridExcelReportHelperEx excelReportHelperEx = new DataGridExcelReportHelperEx();
            excelReportHelperEx.setConfig(dataGridConfig);
            excelReportHelperEx.setWebContext(page.getWebContext());
            excelReportHelperEx.setDataSource(selectResult.getMainTable());
            excelReportHelperEx.setEnableItemPrivilege(dataGrid.isEnableItemPrivilege());
            excelReportHelperEx.Output(strTempFileName);
         }
      } catch (Exception ex) {
         log.error(ex);
      }
   }

   protected String GetExportType() {
      String strExportType = this.getWebContext().GetPostValue("exporttype");
      return StringHelper.IsNullOrEmpty(strExportType) ? "" : strExportType;
   }

   protected CallResult OnRemoveActionBeforeRemove(BaseDataEntity dataEntity) {
      return this.OnRemoveActionBeforeRemove(this.getDEDataCtrl(), dataEntity);
   }

   protected CallResult OnRemoveActionBeforeRemove(IDEDataCtrl iDEDataCtrl, BaseDataEntity dataEntity) {
      CallResult callResult = this.OnTestDataAction(iDEDataCtrl.GetDEHelper(), dataEntity, "DELETE");
      return callResult.getRetCode() != 0 ? callResult : iDEDataCtrl.TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
   }

   @Override
   protected boolean OnCustomAction(String strAction) {
      if (StringHelper.Compare(strAction, "SRFDAEXPORT", true) == 0) {
         this.OnExport();
         return true;
      } else {
         return false;
      }
   }

   protected boolean OnExport() {
      SRFExAjaxActionResult exportResult = new SRFExAjaxActionResult();
      this.groupStatisticsRep = this.getGroupStatisticsRep();
      if (this.groupStatisticsRep == null) {
         log.error("无法获取分组统计报表对象");
         exportResult.setRetCode(1);
         exportResult.setErrorInfo("无法获取分组统计报表对象");
         this.getPage().Output(exportResult.ToJSONString());
         return true;
      }

      BaseDAQueryModelHelper daQueryModelHelper = null;
      String strQueryModel = this.groupStatisticsRep.getQUERYMODELID();
      boolean bUserDP = this.OnGetUserDP();
      if (!StringHelper.IsNullOrEmpty(strQueryModel)) {
         if (bUserDP) {
            daQueryModelHelper = this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(strQueryModel);
         } else {
            daQueryModelHelper = this.getPage().getDAModelStorage().FindDAQueryModelHelper(strQueryModel);
         }
      } else if (bUserDP) {
         daQueryModelHelper = this.getWebContext().GetUserQueryModelStorage().FindDAQueryModelHelper(this.getDEHelper(), "", false);
      } else {
         daQueryModelHelper = this.getPage().getDAModelStorage().getDAQueryModelHelper(this.getDEHelper());
      }

      this.strQueryKey = StringHelper.Format("QUERYMODEL[%1$s] USERDP[%2$s]", strQueryModel, bUserDP ? "TRUE" : "FALSE");
      log.info(StringHelper.Format("表格查询 [%1$s]", strQueryModel));
      if (daQueryModelHelper == null) {
         exportResult.setRetCode(1);
         exportResult.setErrorInfo("查询模型辅助对象无效");
         log.error(exportResult.getErrorInfo());
         this.getPage().Output(exportResult.ToJSONString());
         return true;
      }

      this.qmUserContext = new DefaultDAQueryModelUserContext();
      StringBuilderEx script = new StringBuilderEx();
      String strQueryScript = this.GetDAModelQueryScript(daQueryModelHelper);
      Vector<String> userConditions = new Vector<>();
      String strGroupField = this.getWebContext().GetPostValue("srfgroupfield");
      if (this.groupStatisticsRep.getENABLETIMEGROUP()) {
         IDEFHelper timeGroupDEF = daQueryModelHelper.GetMajorDEHelper().GetDEFHelper(this.groupStatisticsRep.getTIMEDEFIELDID());
         if (timeGroupDEF == null) {
            exportResult.setRetCode(1);
            exportResult.setErrorInfo(StringHelper.Format("无法获取时间分组属性[%1$s]", this.groupStatisticsRep.getTIMEDEFIELDID()));
            log.error(exportResult.getErrorInfo());
            this.getPage().Output(exportResult.ToJSONString());
            return true;
         }

         String strFromTimeParam = this.groupStatisticsRep.getBEGINTIMEARG();
         if (StringHelper.IsNullOrEmpty(strFromTimeParam)) {
            strFromTimeParam = StringHelper.Format("n_%1$s_gtandeq", timeGroupDEF.GetDTColumn().GetColumnName());
         }

         String strToTimeParam = this.groupStatisticsRep.getENDTIMEARG();
         if (StringHelper.IsNullOrEmpty(strToTimeParam)) {
            strToTimeParam = StringHelper.Format("n_%1$s_lt", timeGroupDEF.GetDTColumn().GetColumnName());
         }

         String strFromTime = this.getWebContext().GetPostValue(strFromTimeParam);
         if (StringHelper.IsNullOrEmpty(strFromTime)) {
            strFromTime = this.getWebContext().GetParamValue(strFromTimeParam);
         }

         if (StringHelper.IsNullOrEmpty(strFromTime)) {
            exportResult.setRetCode(1);
            exportResult.setErrorInfo(StringHelper.Format("没有指定[%1$s]的起始时间", timeGroupDEF.getLogicName()));
            log.error(exportResult.getErrorInfo());
            this.getPage().Output(exportResult.ToJSONString());
            return true;
         }

         String strToTime = this.getWebContext().GetPostValue(strToTimeParam);
         if (StringHelper.IsNullOrEmpty(strToTimeParam)) {
            strToTime = this.getWebContext().GetParamValue(strToTimeParam);
         }

         if (StringHelper.IsNullOrEmpty(strFromTime)) {
            exportResult.setRetCode(1);
            exportResult.setErrorInfo(StringHelper.Format("没有指定[%1$s]的终止时间", timeGroupDEF.getLogicName()));
            log.error(exportResult.getErrorInfo());
            this.getPage().Output(exportResult.ToJSONString());
            return true;
         }

         int nPos = strQueryScript.indexOf("SELECT");
         if (nPos == -1) {
            exportResult.setRetCode(1);
            exportResult.setErrorInfo(StringHelper.Format("无法从查询语句中定位第一个[SELECT]"));
            log.error(exportResult.getErrorInfo());
            this.getPage().Output(exportResult.ToJSONString());
            return true;
         }

         strQueryScript = "SELECT s1.TIMEDIMENSIONID AS srftdid,s1.TIMEDIMENSIONNAME AS srftdname,s1.BEGINTIME AS srftdfrom,s1.ENDTIME AS srftdto, "
            + strQueryScript.substring(nPos + 6);
         strQueryScript = strQueryScript
            + StringHelper.Format(
               "\nLEFT OUTER JOIN t_SRFTIMEDIMENSION s1 ON %1$s >=s1.BEGINTIME AND %1$s<s1.ENDTIME \n",
               daQueryModelHelper.GetDEFieldExp(timeGroupDEF).getUserObject()
            );
         userConditions.add(StringHelper.Format("s1.TIMEDIMENSIONID IS NOT NULL "));
         String strCond = daQueryModelHelper.GetDateTimeConditionSQL("s1.BEGINTIME", 5, ">=", strFromTime);
         if (StringHelper.IsNullOrEmpty(strCond)) {
            exportResult.setRetCode(1);
            exportResult.setErrorInfo(StringHelper.Format("无法设置[%1$s]的起始时间[%2$s]", timeGroupDEF.getLogicName(), strFromTime));
            log.error(exportResult.getErrorInfo());
            this.getPage().Output(exportResult.ToJSONString());
            return true;
         }

         userConditions.add(strCond);
         strCond = daQueryModelHelper.GetDateTimeConditionSQL("s1.ENDTIME", 5, "<", strToTime);
         if (StringHelper.IsNullOrEmpty(strCond)) {
            exportResult.setRetCode(1);
            exportResult.setErrorInfo(StringHelper.Format("无法设置[%1$s]的终止时间[%2$s]", timeGroupDEF.getLogicName(), strToTime));
            log.error(exportResult.getErrorInfo());
            this.getPage().Output(exportResult.ToJSONString());
            return true;
         }

         userConditions.add(strCond);
         userConditions.add(StringHelper.Format("s1.TDTYPE='%1$s'", strGroupField));
      }

      script.Append(strQueryScript);
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

            script.Append("(%1$s)", strCondition);
         }
      }

      Vector<String> dynamicTables = null;
      boolean bDynamicMode = false;
      if (StringHelper.Compare(this.getDEHelper().getDataEntity().getSTORAGETYPE(), "DYNAMIC", true) == 0) {
         bDynamicMode = true;
         String strTimeFrom = this.getDEHelper().GetProperty("DYNAMICFROM");
         String strTimeTo = this.getDEHelper().GetProperty("DYNAMICTO");
         String strTime1 = this.getPage().getRequest().getParameter(strTimeFrom.toLowerCase());
         if (strTime1 == null) {
            strTime1 = this.getWebContext().GetParamValue(strTimeFrom.toUpperCase());
         }

         String strTime2 = this.getPage().getRequest().getParameter(strTimeTo.toLowerCase());
         if (strTime2 == null) {
            strTime2 = this.getWebContext().GetParamValue(strTimeTo.toUpperCase());
         }

         if (StringHelper.IsNullOrEmpty(strTime1) || StringHelper.IsNullOrEmpty(strTime2)) {
            log.error("没有指定开始或结束时间");
            exportResult.setRetCode(1);
            exportResult.setErrorInfo("没有指定开始或结束时间");
            this.getPage().Output(exportResult.ToJSONString());
            return true;
         }

         try {
            Date startDate = DateParser.Parse(strTime1);
            Date endDate = DateParser.Parse(strTime2);
            dynamicTables = new Vector<>();
            CallResult callResult = this.getDEHelper().GetDynamicTables(startDate, endDate, dynamicTables);
            if (callResult.IsError()) {
               exportResult.setRetCode(1);
               exportResult.setErrorInfo(callResult.getErrorInfo());
               this.getPage().Output(exportResult.ToJSONString());
               return true;
            }
         } catch (Exception e) {
            log.error(e);
            exportResult.setRetCode(1);
            exportResult.setErrorInfo(e.getMessage());
            this.getPage().Output(exportResult.ToJSONString());
            return true;
         }
      }

      String strSortParam = "";
      String strSortDirection = "";
      strSortParam = this.getPage().getRequest().getParameter("sort");
      String strRealSortParam = this.getPage().getRequest().getParameter("realsort");
      if (StringHelper.Length(strRealSortParam) > 0) {
         strSortParam = strRealSortParam;
      }

      strSortDirection = this.getPage().getRequest().getParameter("dir");
      QueryGroupModelConfig queryGroupModelConfig = new QueryGroupModelConfig();
      String strTopN = this.getPage().getRequest().getParameter("srftopn");
      if (StringHelper.IsNullOrEmpty(strTopN)) {
         queryGroupModelConfig.setTopCount(100);
      } else {
         int nInt = Integer.parseInt(strTopN);
         if (nInt <= 0) {
            nInt = 100;
         }

         queryGroupModelConfig.setTopCount(nInt);
      }

      String strGroupCond = this.groupStatisticsRep.getGROUPCOND();
      if (!this.groupStatisticsRep.getENABLETIMEGROUP()) {
         if (!StringHelper.IsNullOrEmpty(strGroupField)) {
            for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
               if (StringHelper.Compare(groupColumn.getDEFIELDNAME(), strGroupField, true) == 0) {
                  QueryGroupItemConfig queryGroupItemConfig = new QueryGroupItemConfig();
                  queryGroupItemConfig.setAlias(groupColumn.getDEFIELDNAME());
                  queryGroupItemConfig.setDEFields(groupColumn.getDEFIELDNAME());
                  queryGroupItemConfig.setIsGroup(true);
                  if (StringHelper.Compare(strSortParam, groupColumn.getDEFIELDNAME(), true) == 0) {
                     queryGroupItemConfig.setOrder(0);
                     queryGroupItemConfig.setOrderDirection(strSortDirection);
                  }

                  queryGroupModelConfig.add(queryGroupItemConfig);
                  if (!StringHelper.IsNullOrEmpty(groupColumn.getCOND())) {
                     if (!StringHelper.IsNullOrEmpty(strGroupCond)) {
                        strGroupCond = strGroupCond + " AND ";
                     }

                     strGroupCond = strGroupCond + groupColumn.getCOND();
                  }

                  if (!StringHelper.IsNullOrEmpty(groupColumn.getNAMEDEFNAME())) {
                     queryGroupItemConfig = new QueryGroupItemConfig();
                     queryGroupItemConfig.setAlias(groupColumn.getNAMEDEFNAME());
                     queryGroupItemConfig.setDEFields(groupColumn.getNAMEDEFNAME());
                     queryGroupItemConfig.setIsGroup(true);
                     if (StringHelper.Compare(strSortParam, groupColumn.getNAMEDEFNAME(), true) == 0) {
                        queryGroupItemConfig.setOrder(0);
                        queryGroupItemConfig.setOrderDirection(strSortDirection);
                     }

                     queryGroupModelConfig.add(queryGroupItemConfig);
                  }
               } else if (groupColumn.getDEFAULTGROUP() || groupColumn.getORDERFLAG() == -1) {
                  QueryGroupItemConfig queryGroupItemConfig = new QueryGroupItemConfig();
                  queryGroupItemConfig.setAlias(groupColumn.getDEFIELDNAME());
                  queryGroupItemConfig.setDEFields(groupColumn.getDEFIELDNAME());
                  queryGroupItemConfig.setIsGroup(true);
                  if (StringHelper.Compare(strSortParam, groupColumn.getDEFIELDNAME(), true) == 0) {
                     queryGroupItemConfig.setOrder(0);
                     queryGroupItemConfig.setOrderDirection(strSortDirection);
                  }

                  queryGroupModelConfig.add(queryGroupItemConfig);
               }
            }
         }
      } else {
         Vector<String> groupParams = new Vector<>();
         groupParams.add("srftdid");
         groupParams.add("srftdname");
         groupParams.add("srftdfrom");
         groupParams.add("srftdto");

         for (String strGroupName : groupParams) {
            QueryGroupItemConfig queryGroupItemConfig = new QueryGroupItemConfig();
            queryGroupItemConfig.setAlias(strGroupName);
            queryGroupItemConfig.setDEFields(strGroupName);
            queryGroupItemConfig.setIsGroup(true);
            if (StringHelper.Compare(strSortParam, strGroupName, true) == 0) {
               queryGroupItemConfig.setOrder(0);
               queryGroupItemConfig.setOrderDirection(strSortDirection);
            }

            queryGroupModelConfig.add(queryGroupItemConfig);
         }
      }

      queryGroupModelConfig.setGroupCond(strGroupCond);

      for (GSRMeasure gsrMeasure : this.groupStatisticsRep.getMeasures()) {
         QueryGroupItemConfig queryGroupItemConfig = new QueryGroupItemConfig();
         queryGroupItemConfig.setAlias(gsrMeasure.getEXPALIAS());
         queryGroupItemConfig.setFormular(gsrMeasure.getEXPRESSION());
         queryGroupItemConfig.setIsGroup(false);
         queryGroupItemConfig.setReCalc(gsrMeasure.getRECALCFLAG());
         if (StringHelper.Compare(strSortParam, gsrMeasure.getEXPALIAS(), true) == 0) {
            queryGroupItemConfig.setOrder(0);
            queryGroupItemConfig.setOrderDirection(strSortDirection);
         }

         queryGroupModelConfig.add(queryGroupItemConfig);
      }

      Vector<CallParam> params = new Vector<>();
      daQueryModelHelper.FillQMDeclareParams(params, this.getWebContext(), this.getWebContext().getGlobalHelper(), "");
      String strSQL = daQueryModelHelper.GetGroupSQL(
         script.toString(), queryGroupModelConfig, params, this.getWebContext(), this.getWebContext().getGlobalHelper(), "", null
      );
      daQueryModelHelper.FillCallParams(params, this.getWebContext(), this.getWebContext().getGlobalHelper(), "");
      strSQL = daQueryModelHelper.GetQMDeclareScript() + strSQL;
      strSQL = daQueryModelHelper.ReplaceURLParamMacro(strSQL, this.getWebContext());
      if (bDynamicMode) {
         strSQL = daQueryModelHelper.ReplaceDynamicTableMacro(strSQL, dynamicTables);
      }

      String strExportType = this.GetExportType();
      CallResult callResult = this.SelectAndExport(strSQL, params, strExportType);
      if (callResult.getRetCode() != 0) {
         callResult.From(exportResult);
         this.getPage().Output(exportResult.ToJSONString());
         return true;
      } else {
         String strDownloadURL = "";
         strDownloadURL = StringHelper.Format("'../srfpage/exportexcel.jsp?FILEID=%1$s&EXPORTTYPE=%2$s'", callResult.getUserObject(), strExportType);
         String strScript = StringHelper.Format("SRFUtility.root().location=%1$s;", strDownloadURL);
         exportResult.setJSCode(strScript);
         this.getPage().Output(exportResult.ToJSONString());
         return true;
      }
   }

   protected boolean OnExportImportTemplate() {
      SRFExAjaxActionResult exportResult = new SRFExAjaxActionResult();
      String strTempFileName = Helper.GenGuid();
      String strDir = StringHelper.Format("%1$s%2$s", this.getWebContext().getGlobalHelper().GetTempPath(), this.getWebContext().getSessionId());
      File dir = new File(strDir);
      dir.mkdirs();
      String strFullFileName = StringHelper.Format(
         "%1$s%2$s%3$s%4$s.%5$s",
         this.getWebContext().getGlobalHelper().GetTempPath(),
         this.getWebContext().getSessionId(),
         File.separator,
         strTempFileName,
         "xls"
      );

      CallResult callResult;
      try {
         callResult = DEDataImportTemplateHelper.Output(this.getWebContext().getGlobalHelper(), this.getDEHelper(), strFullFileName);
      } catch (Exception e) {
         callResult = new CallResult();
         callResult.setRetCode(1);
         callResult.setErrorInfo(StringHelper.Format("建立导入模板文件发生异常，%1$s", e.getMessage()));
         log.error(callResult.getErrorInfo(), e);
      }

      if (callResult.getRetCode() != 0) {
         callResult.From(exportResult);
         this.getPage().Output(exportResult.ToJSONString());
         return true;
      } else {
         String strDownloadURL = "";
         strDownloadURL = StringHelper.Format("'../srfpage/exportexcel.jsp?FILEID=%1$s&EXPORTTYPE=%2$s'", strTempFileName, "");
         String strScript = StringHelper.Format("SRFUtility.root().location=%1$s;", strDownloadURL);
         exportResult.setJSCode(strScript);
         this.getPage().Output(exportResult.ToJSONString());
         return true;
      }
   }

   protected String OnGetDGMode() {
      return this.getPage().getPageParam("PAGE.DGMODE", "");
   }

   protected SRFDAPage getPage() {
      return (SRFDAPage)super.page;
   }

   protected SRFDAWebContext getWebContext() {
      return (SRFDAWebContext)super.getWebContext();
   }

   protected IDEDataCtrl getDEDataCtrl() {
      return this.getPage().GetDEDataCtrl();
   }

   protected String GetDataLockKey(BaseDataEntity dataEntity) {
      return "";
   }

   protected IDEHelper getDEHelper() {
      return this.getPage().getDEHelper();
   }

   public static String GetSelectedColumns(DataGridConfig dataGridConfig) {
      String strColumns = "";
      int nSize = dataGridConfig.getDataGridDSConfig().getList().size();

      for (int i = 0; i < nSize; i++) {
         DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)dataGridConfig.getDataGridDSConfig().getList().get(i);
         if (dsItemConfig.getItemParamsConfig() == null) {
            strColumns = strColumns + dsItemConfig.getID();
            strColumns = strColumns + ";";
         } else {
            int nSize2 = dsItemConfig.getItemParamsConfig().getList().size();

            for (int j = 0; j < nSize2; j++) {
               ItemParamConfig itemParamConfig = (ItemParamConfig)dsItemConfig.getItemParamsConfig().getList().get(j);
               strColumns = strColumns + itemParamConfig.getID();
               strColumns = strColumns + ";";
            }
         }
      }

      return strColumns;
   }

   protected GroupStatisticsRep getGroupStatisticsRep() {
      if (this.groupStatisticsRep != null) {
         return this.groupStatisticsRep;
      }

      Object obj = this.getPage().getPageParam("GROUPSTATISTICSREP");
      if (obj == null) {
         return null;
      }

      if (obj instanceof GroupStatisticsRep) {
         this.groupStatisticsRep = (GroupStatisticsRep)obj;
      }

      return this.groupStatisticsRep;
   }

   public CallResult AppendTimeGroupSQL(
      BaseDAQueryModelHelper daQueryModelHelper,
      String strTimeGroupFieldId,
      String strFromTimeParam,
      String strToTimeParam,
      boolean bAllowTimeParamEmpty,
      String strQueryScript,
      Vector<String> userConditions,
      String strTDType
   ) {
      CallResult callResult = new CallResult();
      IDEFHelper timeGroupDEF = daQueryModelHelper.GetMajorDEHelper().GetDEFHelper(strTimeGroupFieldId);
      if (timeGroupDEF != null) {
         if (StringHelper.IsNullOrEmpty(strFromTimeParam)) {
            strFromTimeParam = StringHelper.Format("n_%1$s_gtandeq", timeGroupDEF.GetDTColumn().GetColumnName().toLowerCase());
         }

         if (StringHelper.IsNullOrEmpty(strToTimeParam)) {
            strToTimeParam = StringHelper.Format("n_%1$s_lt", timeGroupDEF.GetDTColumn().GetColumnName().toLowerCase());
         }

         String strFromTime = this.getWebContext().GetPostValue(strFromTimeParam);
         if (StringHelper.IsNullOrEmpty(strFromTime)) {
            strFromTime = this.getWebContext().GetParamValue(strFromTimeParam);
         }

         if (!bAllowTimeParamEmpty && StringHelper.IsNullOrEmpty(strFromTime)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format("没有指定[%1$s]的起始时间", timeGroupDEF.getLogicName()));
            return callResult;
         }

         String strToTime = this.getWebContext().GetPostValue(strToTimeParam);
         if (StringHelper.IsNullOrEmpty(strToTime)) {
            strToTime = this.getWebContext().GetParamValue(strToTimeParam);
         }

         if (!bAllowTimeParamEmpty && StringHelper.IsNullOrEmpty(strToTime)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format("没有指定[%1$s]的终止时间", timeGroupDEF.getLogicName()));
            return callResult;
         }

         int nPos = strQueryScript.indexOf("SELECT");
         if (nPos != -1) {
            strQueryScript = "SELECT s1.TIMEDIMENSIONID AS srftdid,s1.TIMEDIMENSIONNAME AS srftdname,s1.BEGINTIME AS srftdfrom,s1.ENDTIME AS srftdto, "
               + strQueryScript.substring(nPos + 6);
            strQueryScript = strQueryScript
               + StringHelper.Format(
                  "\nLEFT OUTER JOIN t_SRFTIMEDIMENSION s1 ON %1$s >=s1.BEGINTIME AND %1$s<s1.ENDTIME \n",
                  daQueryModelHelper.GetDEFieldExp(timeGroupDEF).getUserObject()
               );
            userConditions.add(StringHelper.Format("s1.TIMEDIMENSIONID IS NOT NULL "));
            if (!StringHelper.IsNullOrEmpty(strFromTime)) {
               String strCond = daQueryModelHelper.GetDateTimeConditionSQL("s1.BEGINTIME", 5, ">=", strFromTime);
               if (StringHelper.IsNullOrEmpty(strCond)) {
                  callResult.setRetCode(5);
                  callResult.setErrorInfo(StringHelper.Format("无法设置[%1$s]的起始时间[%2$s]", timeGroupDEF.getLogicName(), strFromTime));
                  return callResult;
               }

               userConditions.add(strCond);
            }

            if (!StringHelper.IsNullOrEmpty(strToTime)) {
               String strCond = daQueryModelHelper.GetDateTimeConditionSQL("s1.ENDTIME", 5, "<=", strToTime);
               if (StringHelper.IsNullOrEmpty(strCond)) {
                  callResult.setRetCode(5);
                  callResult.setErrorInfo(StringHelper.Format("无法设置[%1$s]的终止时间[%2$s]", timeGroupDEF.getLogicName(), strToTime));
                  return callResult;
               }

               userConditions.add(strCond);
            }

            userConditions.add(StringHelper.Format("s1.TDTYPE='%1$s'", strTDType));
            callResult.setUserObject(strQueryScript);
            return callResult;
         } else {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format("无法从查询语句中定位第一个[SELECT]"));
            return callResult;
         }
      } else {
         callResult.setRetCode(1);
         callResult.setErrorInfo(StringHelper.Format("无法获取时间分组属性[%1$s]", strTimeGroupFieldId));
         return callResult;
      }
   }
}
