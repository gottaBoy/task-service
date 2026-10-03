package SA.SRFramework.WebEx.DataGrid;

import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.ValueRule.StringLengthsConfig;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.UI.DataGridEditItemConfig;
import SA.SRFramework.WebEx.UI.DataGridEditItemErrors;
import SA.SRFramework.WebEx.Utility.DADVHelper;
import SA.SRFramework.WebEx.Utility.GridRowActionHelper;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DataGridRowActionHelperEx {
   protected SRFExDataGrid dataGrid = null;

   public DataGridRowActionHelperEx(SRFExDataGrid dataGrid) {
      this.dataGrid = dataGrid;
   }

   public boolean FillDataEntityEx(boolean bInsert, BaseDataEntity baseDataEntity, boolean bIgnoreEmpty, DataGridEditItemErrors dgEditItemErrors) {
      boolean bRet = true;
      DataGridConfig dataGridConfig = this.dataGrid.getDataGridConfig();
      StringLengthsConfig stringLengthsConfig = this.dataGrid.getWebContext().getStringLengthMgr().GetStringLengthsConfig();
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

      ISRFExDGEditItemRuleEngine dgEditItemRuleEngine = CreateDGEditItemRuleEngine(this.dataGrid, baseDataEntity);

      for (int i = 0; i < nCount; i++) {
         DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)dataGridRSConfig.getList().get(i);
         if (dsItemConfig.getDataGridEditItemConfig() != null) {
            DataGridEditItemConfig dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
            String strValue = this.dataGrid.getWebContext().GetPostValue(dsItemConfig.getID());
            if (strValue != null) {
               strValue = strValue.trim();
               if (!StringHelper.IsNullOrEmpty(dgEditItemConfig.getStringCase())) {
                  if (StringHelper.Compare(dgEditItemConfig.getStringCase(), "UCASE", true) == 0) {
                     strValue = strValue.toUpperCase();
                  } else {
                     strValue = strValue.toLowerCase();
                  }
               }
            }

            String strBackupValue = strValue;
            if (StringHelper.Length(strValue) == 0) {
               if (!bIgnoreEmpty) {
                  if (!dgEditItemConfig.getAllowEmpty()) {
                     dgEditItemErrors.Register(
                        dsItemConfig.getID(), dgEditItemConfig.getName(), 1, GridRowActionHelper.GetDataGridEditItemErrorMsg(1, dgEditItemConfig)
                     );
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
                  dgEditItemErrors.Register(
                     dsItemConfig.getID(), dgEditItemConfig.getName(), 2, GridRowActionHelper.GetDataGridEditItemErrorMsg(2, dgEditItemConfig)
                  );
                  bRet = false;
               } else {
                  if (objValue instanceof Float && dgEditItemConfig.getPrecision() >= 0) {
                     BigDecimal bd = new BigDecimal(((Float)objValue).floatValue());
                     bd = bd.setScale(dgEditItemConfig.getPrecision(), 6);
                     objValue = bd.floatValue();
                  }

                  if (objValue instanceof Double && dgEditItemConfig.getPrecision() >= 0) {
                     BigDecimal bd = new BigDecimal((Double)objValue);
                     bd = bd.setScale(dgEditItemConfig.getPrecision(), 6);
                     objValue = bd.doubleValue();
                  }

                  if (objValue instanceof String) {
                     int nMaxLength = dgEditItemConfig.getMaxLength();
                     if (nMaxLength == 0) {
                        nMaxLength = stringLengthsConfig.getStringMaxLength(dgEditItemConfig.getDBField());
                     }

                     if (nMaxLength > 0 && StringHelper.Length(objValue.toString()) > nMaxLength) {
                        dgEditItemErrors.Register(
                           dsItemConfig.getID(),
                           dgEditItemConfig.getName(),
                           3,
                           GridRowActionHelper.GetDataGridEditItemLengthErrorMsg(dgEditItemConfig, nMaxLength)
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

                  boolean bCheckRule = true;
                  String strValidCode = dgEditItemConfig.getValidCond();
                  if (StringHelper.Compare(strValidCode, "NONE", true) == 0) {
                     bCheckRule = false;
                  } else if (StringHelper.Compare(strValidCode, "CREATE", true) == 0) {
                     if (!bInsert) {
                        bCheckRule = false;
                     }
                  } else if (StringHelper.Compare(strValidCode, "UPDATE", true) == 0 && bInsert) {
                     bCheckRule = false;
                  }

                  if (bCheckRule && !StringHelper.IsNullOrEmpty(dgEditItemConfig.getValueRuleCode()) && dgEditItemRuleEngine != null) {
                     baseDataEntity.SetParamValue(dsItemConfig.getID(), objValue);
                     boolean bTestRet = dgEditItemRuleEngine.TestValueRule(dgEditItemConfig, objValue, strValue);
                     baseDataEntity.RemoveParam(dsItemConfig.getID());
                     if (!bTestRet) {
                        dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 3, dgEditItemConfig.getValueRuleInfo());
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

   public void RemoveInvalidValue(BaseDataEntity dataEntity, boolean bCreate) {
      ISRFExDGEditItemRuleEngine dgEditItemRuleEngine = CreateDGEditItemRuleEngine(this.dataGrid, dataEntity);
      int nCount = this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().size();

      for (int i = 0; i < nCount; i++) {
         DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().get(i);
         if (!dsItemConfig.getKey()) {
            DataGridEditItemConfig dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
            if (dgEditItemConfig == null) {
               dataEntity.RemoveParam(dsItemConfig.getID());
            } else {
               String strValidCond = dgEditItemConfig.getValidCond();
               if (!StringHelper.IsNullOrEmpty(strValidCond)) {
                  if (StringHelper.Compare(strValidCond, "NONE", true) == 0) {
                     dataEntity.RemoveParam(dsItemConfig.getID());
                  } else if (StringHelper.Compare(strValidCond, "ALL", true) != 0) {
                     if (StringHelper.Compare(strValidCond, "CREATE", true) == 0) {
                        if (!bCreate) {
                           dataEntity.RemoveParam(dsItemConfig.getID());
                        }
                     } else if (StringHelper.Compare(strValidCond, "UPDATE", true) == 0) {
                        if (bCreate) {
                           dataEntity.RemoveParam(dsItemConfig.getID());
                        }
                     } else if (dgEditItemRuleEngine != null && !dgEditItemRuleEngine.TestProcess(dgEditItemConfig)) {
                        dataEntity.RemoveParam(dsItemConfig.getID());
                     }
                  }
               }
            }
         }
      }
   }

   public void FillDataEntityDV(BaseDataEntity dataEntity) {
      int nCount = this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().size();

      for (int i = 0; i < nCount; i++) {
         DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().get(i);
         DataGridEditItemConfig dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
         if (dgEditItemConfig != null && dataEntity.GetParamValue(dsItemConfig.getID()) == null) {
            String strDVT = dgEditItemConfig.getDVT();
            String strDV = dgEditItemConfig.getDV();
            if (StringHelper.Length(strDVT) != 0 || StringHelper.Length(strDV) != 0) {
               dataEntity.SetParamValue(
                  dsItemConfig.getID(), DADVHelper.GetDefaultValue(this.dataGrid.getWebContext(), strDVT, strDV, dsItemConfig.getDataType(), dataEntity)
               );
            }
         }
      }
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
}
