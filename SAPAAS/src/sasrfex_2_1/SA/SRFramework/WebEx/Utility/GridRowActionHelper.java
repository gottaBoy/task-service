package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Common.SRFGlobal;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.ValueRule.DataGridValueRuleEngineContext;
import SA.SRFramework.ValueRule.DefaultValueRuleEngine;
import SA.SRFramework.ValueRule.FormValueRuleConfig;
import SA.SRFramework.ValueRule.StringLengthsConfig;
import SA.SRFramework.ValueRule.ValueRuleConfig;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem2;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem4;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.DataGrid.ISRFExDGEditItemRuleEngine;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.UI.DataGridEditItemConfig;
import SA.SRFramework.WebEx.UI.DataGridEditItemErrors;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import net.sf.json.JSONObject;

public class GridRowActionHelper {
   public static boolean FillRow(
      SRFExWebContext webContext, int nIndex, JSONObject objJSON, BaseDataEntity baseDataEntity, DataGridConfig dataGridConfig, String strDataGridId
   ) {
      try {
         boolean bSelectColumn = dataGridConfig.getSelectColumn();
         DataGridDSConfig dataGridRS = dataGridConfig.getDataGridDSConfig();
         String strSRFRowId = "";
         String strKey = "";
         int nColumnCount = dataGridRS.getList().size();

         for (int i = 0; i < nColumnCount; i++) {
            DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)dataGridRS.getList().get(i);
            if (StringHelper.Compare(dsItemConfig.getID(), "SRFROWID", true) == 0) {
               strSRFRowId = Helper.GenGuid();
               objJSON.put(dsItemConfig.getID().toLowerCase(), strSRFRowId);
            } else {
               if (StringHelper.Length(dsItemConfig.getCustom()) > 0) {
                  Object dsItem = GetDataGridDSItem(dsItemConfig.getCustom());
                  if (dsItem == null) {
                     objJSON.put(dsItemConfig.getID().toLowerCase(), "无效的自定义表格数据");
                  } else if (dsItem instanceof ISRFExDataGridDSItem4) {
                     ISRFExDataGridDSItem4 iDataGridDSItem4 = (ISRFExDataGridDSItem4)dsItem;
                     objJSON.put(dsItemConfig.getID().toLowerCase(), iDataGridDSItem4.GetValue(webContext, dsItemConfig, baseDataEntity, false));
                  } else if (dsItem instanceof ISRFExDataGridDSItem2) {
                     ISRFExDataGridDSItem2 iDataGridDSItem2 = (ISRFExDataGridDSItem2)dsItem;
                     objJSON.put(dsItemConfig.getID().toLowerCase(), iDataGridDSItem2.GetValue(dsItemConfig, baseDataEntity));
                  } else {
                     objJSON.put(dsItemConfig.getID().toLowerCase(), "无效的自定义表格数据对象");
                  }
               } else {
                  String strItemFormat = dsItemConfig.getItemFormat();
                  String strValue = "";
                  if (StringHelper.Length(strItemFormat) == 0) {
                     strItemFormat = "%1$s";
                  }

                  ItemParamsConfig itemParamsConfig = dsItemConfig.getItemParamsConfig();
                  if (itemParamsConfig == null) {
                     Object objValue = baseDataEntity.GetParamValue(dsItemConfig.getID());
                     if (objValue == null) {
                        strValue = "";
                     } else {
                        if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType(objValue)) {
                           objValue = DateParser.AdjustByTimeZone(objValue, webContext.getCurTimeZone(), false);
                        }

                        strValue = StringHelper.Format(strItemFormat, objValue);
                     }
                  } else {
                     Object[] valueObj = new Object[itemParamsConfig.getList().size()];

                     for (int j = 0; j < itemParamsConfig.getList().size(); j++) {
                        ItemParamConfig itemParamConfig = (ItemParamConfig)itemParamsConfig.getList().get(j);
                        Object objValue = baseDataEntity.GetParamValue(itemParamConfig.getID());
                        if (objValue == null) {
                           valueObj[j] = itemParamConfig.getDefault();
                        } else {
                           if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType(objValue)) {
                              objValue = DateParser.AdjustByTimeZone(objValue, webContext.getCurTimeZone(), false);
                           }

                           if (StringHelper.Length(itemParamConfig.getItemFormat()) > 0) {
                              objValue = StringHelper.Format(itemParamConfig.getItemFormat(), objValue);
                           }

                           if (StringHelper.Length(itemParamConfig.getCodeList()) > 0) {
                              String strTempValue = objValue.toString();
                              CodeListConfig codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                              if (codeListConfig != null) {
                                 objValue = codeListConfig.GetCodeListValueWithStyle(strTempValue, true);
                              }
                           }

                           valueObj[j] = objValue;
                        }
                     }

                     strValue = StringHelper.Format(strItemFormat, valueObj);
                  }

                  if (StringHelper.Length(dsItemConfig.getCodeList()) > 0) {
                     CodeListConfig codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(dsItemConfig.getCodeList());
                     if (codeListConfig != null) {
                        strValue = codeListConfig.GetCodeListValueWithStyle(strValue, true);
                     }
                  }

                  objJSON.put(dsItemConfig.getID().toLowerCase(), strValue);
               }

               if (dsItemConfig.getKey()) {
                  String strItemFormat = dsItemConfig.getKeyFormat();
                  String strValue = "";
                  if (StringHelper.Length(strItemFormat) == 0) {
                     strItemFormat = "%1$s";
                  }

                  ItemParamsConfig itemParamsConfig = dsItemConfig.getItemParamsConfig();
                  if (itemParamsConfig == null) {
                     Object objValue = baseDataEntity.GetParamValue(dsItemConfig.getID());
                     if (objValue == null) {
                        strValue = "";
                     } else {
                        strValue = StringHelper.Format(strItemFormat, objValue);
                     }
                  } else {
                     Object[] valueObj = new Object[itemParamsConfig.getList().size()];

                     for (int j = 0; j < itemParamsConfig.getList().size(); j++) {
                        ItemParamConfig itemParamConfig = (ItemParamConfig)itemParamsConfig.getList().get(j);
                        Object objValue = baseDataEntity.GetParamValue(itemParamConfig.getID());
                        if (objValue == null) {
                           valueObj[j] = itemParamConfig.getDefault();
                        } else {
                           if (StringHelper.Length(itemParamConfig.getKeyFormat()) > 0) {
                              objValue = StringHelper.Format(itemParamConfig.getKeyFormat(), objValue);
                           }

                           valueObj[j] = objValue;
                        }
                     }

                     strValue = StringHelper.Format(strItemFormat, valueObj);
                  }

                  objJSON.put(dsItemConfig.getID().toUpperCase(), strValue);
               }

               if (dsItemConfig.getKey() && bSelectColumn) {
                  if (StringHelper.Length(strKey) != 0) {
                     strKey = strKey + "|";
                  }

                  strKey = strKey + objJSON.getString(dsItemConfig.getID().toUpperCase());
               }
            }
         }

         objJSON.put("KEYS", strKey);
         if (bSelectColumn) {
            String strSelectColumn = "";
            if (StringHelper.IsNullOrEmpty(strSRFRowId)) {
               strSelectColumn = strSelectColumn
                  + StringHelper.Format(
                     "<INPUT type='checkbox' id='%1$s_SC%2$s' name='%1$s_SC%2$s' value='%3$s' style='height:15px;'>", strDataGridId, nIndex, strKey
                  );
            } else {
               strSelectColumn = strSelectColumn
                  + StringHelper.Format(
                     "<INPUT type='checkbox' id='%1$s_SC%2$s' name='%1$s_SC%2$s' value='%3$s' style='height:15px;'>", strDataGridId, strSRFRowId, strKey
                  );
            }

            objJSON.put("SELECTCOLUMN", strSelectColumn);
         }

         return true;
      } catch (Exception ex) {
         ex.printStackTrace();
         return false;
      }
   }

   protected static ISRFExDataGridDSItem2 GetDataGridDSItem2(String strCustomId) {
      Object obj = ObjectHelper.Create(strCustomId);
      if (obj == null) {
         return null;
      } else {
         return obj instanceof ISRFExDataGridDSItem2 ? (ISRFExDataGridDSItem2)obj : null;
      }
   }

   protected static Object GetDataGridDSItem(String strCustomId) {
      Object obj = ObjectHelper.Create(strCustomId);
      return obj == null ? null : obj;
   }

   public static boolean FillDataEntity(SRFExWebContext webContext, BaseDataEntity baseDataEntity, DataGridConfig dataGridConfig) {
      try {
         DataGridDSConfig dataGridRS = dataGridConfig.getDataGridDSConfig();
         int nColumnCount = dataGridRS.getList().size();

         for (int i = 0; i < nColumnCount; i++) {
            DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)dataGridRS.getList().get(i);
            String strValue = webContext.GetPostValue(dsItemConfig.getID());
            if (StringHelper.Length(strValue) > 0) {
               Object objValue = DataTypeParse.Parse(dsItemConfig.getDataType(), strValue);
               if (objValue != null
                  && SRFGlobal.isMultiTimeZone()
                  && DataTypeParse.IsDateTimeDataType(dsItemConfig.getDataType())
                  && DateParser.isDateTimeType(objValue)) {
                  objValue = DateParser.AdjustByTimeZone(objValue, webContext.getCurTimeZone(), true);
               }

               baseDataEntity.SetParamValue(dsItemConfig.getID(), objValue);
            }
         }

         baseDataEntity.SetParamValue("KEYS", webContext.getPage().getRequest().getParameter("KEYS"));
         return true;
      } catch (Exception ex) {
         ex.printStackTrace();
         return false;
      }
   }

   public static boolean FillDataEntityKeys(SRFExWebContext webContext, BaseDataEntity baseDataEntity, SRFExDataGrid dataGrid) {
      DataGridConfig dataGridConfig = dataGrid.getDataGridConfig();
      DataGridDSConfig dataGridRSConfig = dataGridConfig.getDataGridDSConfig();
      int nCount = dataGridRSConfig.getList().size();

      for (int i = 0; i < nCount; i++) {
         DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)dataGridRSConfig.getList().get(i);
         if (dsItemConfig.getKey()) {
            String strValue = webContext.getPage().getRequest().getParameter(dsItemConfig.getID().toUpperCase());
            if (StringHelper.Length(strValue) == 0) {
               return false;
            }

            Object objValue = DataTypeParse.Parse(dsItemConfig.getDataType(), strValue);
            if (objValue == null) {
               return false;
            }

            baseDataEntity.SetParamValue(dsItemConfig.getID().toUpperCase(), objValue);
         }
      }

      return true;
   }

   public static boolean IsContainerKeyValue(SRFExWebContext webContext, BaseDataEntity baseDataEntity, SRFExDataGrid dataGrid) {
      boolean bHasKey = false;
      DataGridConfig dataGridConfig = dataGrid.getDataGridConfig();
      DataGridDSConfig dataGridRSConfig = dataGridConfig.getDataGridDSConfig();
      int nCount = dataGridRSConfig.getList().size();

      for (int i = 0; i < nCount; i++) {
         DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)dataGridRSConfig.getList().get(i);
         if (dsItemConfig.getKey()) {
            bHasKey = true;
            String strValue = webContext.getPage().getRequest().getParameter(dsItemConfig.getID().toUpperCase());
            if (StringHelper.Length(strValue) == 0) {
               return false;
            }

            Object objValue = DataTypeParse.Parse(dsItemConfig.getDataType(), strValue);
            if (objValue == null) {
               return false;
            }

            baseDataEntity.SetParamValue(dsItemConfig.getID().toUpperCase(), objValue);
         }
      }

      return bHasKey;
   }

   public static boolean FillDataEntityEx(
      SRFExWebContext webContext, BaseDataEntity baseDataEntity, SRFExDataGrid dataGrid, boolean bIgnoreEmpty, DataGridEditItemErrors dgEditItemErrors
   ) {
      boolean bRet = true;
      DataGridConfig dataGridConfig = dataGrid.getDataGridConfig();
      StringLengthsConfig stringLengthsConfig = webContext.getStringLengthMgr().GetStringLengthsConfig();
      FormValueRuleConfig formValueRuleConfig = null;
      String strFormValueRuleId = dataGrid.getDataGridConfig().getFormValueRuleId();
      if (StringHelper.Length(strFormValueRuleId) > 0) {
         formValueRuleConfig = webContext.getValueRuleMgr().GetFormValueRuleConfig(strFormValueRuleId);
         if (formValueRuleConfig == null) {
            System.out.print(StringHelper.Format("定义了表单值规则[%1$s]，但无法获取对应的配置。", strFormValueRuleId));
         }
      }

      BaseDataEntity realDataEntity = new BaseDataEntity();
      DataGridDSConfig dataGridRSConfig = dataGridConfig.getDataGridDSConfig();
      int nCount = dataGridRSConfig.getList().size();

      for (int i = 0; i < nCount; i++) {
         DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)dataGridRSConfig.getList().get(i);
         if (dsItemConfig.getKey()) {
            realDataEntity.SetParamValue(dsItemConfig.getID(), baseDataEntity.GetParamValue(dsItemConfig.getID()));
         }

         if (dsItemConfig.getDataGridEditItemConfig() != null) {
            DataGridEditItemConfig dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
            baseDataEntity.RemoveParam(dgEditItemConfig.getDBField());
         }
      }

      DataGridValueRuleEngineContext valueRuleEngineContext = new DataGridValueRuleEngineContext();
      valueRuleEngineContext.setDataEntity(baseDataEntity);
      valueRuleEngineContext.setDBCallerHelper(webContext.getDBCaller());
      valueRuleEngineContext.setValueRuleMgr(webContext.getValueRuleMgr());
      valueRuleEngineContext.setDataGrid(dataGrid);
      DefaultValueRuleEngine valueRuleEngine = new DefaultValueRuleEngine();

      for (int i = 0; i < nCount; i++) {
         DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)dataGridRSConfig.getList().get(i);
         if (dsItemConfig.getDataGridEditItemConfig() != null) {
            DataGridEditItemConfig dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
            String strValue = webContext.GetPostValue(dsItemConfig.getID());
            String strBackupValue = strValue;
            if (strValue != null) {
               strValue = strValue.trim();
            }

            if (StringHelper.Length(strValue) == 0) {
               if (!bIgnoreEmpty) {
                  if (!dgEditItemConfig.getAllowEmpty()) {
                     dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 1, GetDataGridEditItemErrorMsg(1, dgEditItemConfig));
                     bRet = false;
                  } else {
                     baseDataEntity.SetParamValue(dgEditItemConfig.getDBField(), null);
                     realDataEntity.SetParamValue(dgEditItemConfig.getDBField(), null);
                  }
               }
            } else {
               strValue = strBackupValue;
               Object objValue = DataTypeParse.Parse(dgEditItemConfig.getDataType(), strValue);
               if (objValue == null) {
                  dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 2, GetDataGridEditItemErrorMsg(2, dgEditItemConfig));
                  bRet = false;
               } else {
                  if (SRFGlobal.isMultiTimeZone() && DataTypeParse.IsDateTimeDataType(dgEditItemConfig.getDataType()) && DateParser.isDateTimeType(objValue)) {
                     objValue = DateParser.AdjustByTimeZone(objValue, webContext.getCurTimeZone(), true);
                  }

                  if (objValue instanceof String) {
                     int nMaxLength = dgEditItemConfig.getMaxLength();
                     if (nMaxLength == 0) {
                        nMaxLength = stringLengthsConfig.getStringMaxLength(dgEditItemConfig.getDBField());
                     }

                     if (nMaxLength > 0 && StringHelper.Length(objValue.toString()) > nMaxLength) {
                        dgEditItemErrors.Register(
                           dsItemConfig.getID(), dgEditItemConfig.getName(), 3, GetDataGridEditItemLengthErrorMsg(dgEditItemConfig, nMaxLength)
                        );
                        bRet = false;
                        continue;
                     }
                  }

                  if (objValue instanceof Timestamp) {
                     if (dgEditItemConfig.getEndOfDay()) {
                        Timestamp endTime = (Timestamp)objValue;
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(endTime.getTime()));
                        cal.set(11, 23);
                        cal.set(12, 59);
                        cal.set(13, 59);
                        endTime.setTime(cal.getTime().getTime());
                        objValue = endTime;
                     }
                  } else if (objValue instanceof java.sql.Date) {
                     if (dgEditItemConfig.getEndOfDay()) {
                        java.sql.Date endTime = (java.sql.Date)objValue;
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date(endTime.getTime()));
                        cal.set(11, 23);
                        cal.set(12, 59);
                        cal.set(13, 59);
                        endTime.setTime(cal.getTime().getTime());
                        objValue = endTime;
                     }
                  } else if (objValue instanceof Time && dgEditItemConfig.getEndOfDay()) {
                     Time endTime = (Time)objValue;
                     Calendar cal = Calendar.getInstance();
                     cal.setTime(new Date(endTime.getTime()));
                     cal.set(11, 23);
                     cal.set(12, 59);
                     cal.set(13, 59);
                     endTime.setTime(cal.getTime().getTime());
                     objValue = endTime;
                  }

                  ValueRuleConfig valueRuleConfig = dgEditItemConfig.getValueRuleConfig();
                  if (valueRuleConfig == null && StringHelper.Length(dgEditItemConfig.getValueRuleId()) > 0) {
                     valueRuleConfig = webContext.getValueRuleMgr().GetValueRuleConfig(dgEditItemConfig.getValueRuleId());
                  }

                  if (valueRuleConfig == null && formValueRuleConfig != null) {
                     valueRuleConfig = formValueRuleConfig.GetFormItemValueRuleConfig(dgEditItemConfig.getDBField());
                  }

                  if (valueRuleConfig != null) {
                     valueRuleEngineContext.setErrorMessage("");
                     valueRuleEngineContext.setDataType(dgEditItemConfig.getDataType());
                     valueRuleEngineContext.setValue(objValue);
                     valueRuleEngineContext.setErrorMessage("");
                     if (!valueRuleEngine.Check(valueRuleEngineContext, valueRuleConfig)) {
                        dgEditItemErrors.Register(
                           dsItemConfig.getID(),
                           dgEditItemConfig.getName(),
                           3,
                           GetDataGridEditItemErrorMsg(dgEditItemConfig, valueRuleEngineContext.getErrorMessage())
                        );
                        bRet = false;
                        continue;
                     }
                  }

                  baseDataEntity.SetParamValue(dgEditItemConfig.getDBField(), objValue);
                  realDataEntity.SetParamValue(dgEditItemConfig.getDBField(), objValue);
               }
            }
         }
      }

      realDataEntity.CopyTo(baseDataEntity, true);
      return bRet;
   }

   private static ISRFExDGEditItemRuleEngine CreateDGEditItemRuleEngine(SRFExDataGrid dataGrid, BaseDataEntity dataEntity) {
      ISRFExDGEditItemRuleEngine iEngine = null;
      String strEngine = dataGrid.getPage().getWebContext().getWebExConfig().GetValue("SRFEXWEB", "DGEDITITEMRULEENGINE", "");
      if (StringHelper.IsNullOrEmpty(strEngine)) {
         return null;
      }

      Object objEngine = ObjectHelper.Create(strEngine);
      if (objEngine != null && objEngine instanceof ISRFExDGEditItemRuleEngine) {
         iEngine = (ISRFExDGEditItemRuleEngine)objEngine;
      }

      return iEngine != null && iEngine.Init(dataGrid, dataEntity) ? iEngine : null;
   }

   public static String GetDataGridEditItemErrorMsg(int nErrorType, DataGridEditItemConfig dgEditItemConfig) {
      switch (nErrorType) {
         case 1:
            return StringHelper.Format("%1$s 不能输入为空，必须为其指定值", dgEditItemConfig.getName());
         case 2:
            return StringHelper.Format("%1$s 输入内容不正确，必须输入类型为[%2$s]的值", dgEditItemConfig.getName(), DataTypeHelper.GetTypeName(dgEditItemConfig.getDataType()));
         default:
            return StringHelper.Format("%1$s 输入不正确", dgEditItemConfig.getName());
      }
   }

   public static String GetDataGridEditItemLengthErrorMsg(DataGridEditItemConfig dgEditItemConfig, int nLength) {
      return StringHelper.Format("%1$s 输入内容不正确，输入内容的长度不得大于[%2$s](含%2$s)", dgEditItemConfig.getName(), nLength);
   }

   protected static String GetDataGridEditItemErrorMsg(DataGridEditItemConfig dgEditItemConfig, String strErrorMsg) {
      return StringHelper.Length(strErrorMsg) > 0
         ? StringHelper.Format("%1$s 输入不正确，请确认您的输入符合以下规则：%2$s", dgEditItemConfig.getName(), strErrorMsg)
         : StringHelper.Format("%1$s 输入不正确", dgEditItemConfig.getName());
   }
}
