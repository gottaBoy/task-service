/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DataGrid;

import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.DataGrid.ISRFExDGEditItemRuleEngine;
import SA.SRFramework.WebEx.SRFExDataGrid;
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

    /*
     * Unable to fully structure code
     */
    public boolean FillDataEntityEx(boolean bInsert, BaseDataEntity baseDataEntity, boolean bIgnoreEmpty, DataGridEditItemErrors dgEditItemErrors) {
        bRet = true;
        dataGridConfig = this.dataGrid.getDataGridConfig();
        stringLengthsConfig = this.dataGrid.getWebContext().getStringLengthMgr().GetStringLengthsConfig();
        realDataEntity = new BaseDataEntity();
        dataGridRSConfig = dataGridConfig.getDataGridDSConfig();
        nCount = dataGridRSConfig.getList().size();
        i = 0;
        while (i < nCount) {
            dsItemConfig = (DataGridDSItemConfig)dataGridRSConfig.getList().get(i);
            if (dsItemConfig.getKey()) {
                realDataEntity.SetParamValue(dsItemConfig.getID(), baseDataEntity.GetParamValue(dsItemConfig.getID()));
            }
            if (dsItemConfig.getDataGridEditItemConfig() != null) {
                dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
                baseDataEntity.RemoveParam(dgEditItemConfig.getDBField());
            }
            ++i;
        }
        dgEditItemRuleEngine = DataGridRowActionHelperEx.CreateDGEditItemRuleEngine(this.dataGrid, baseDataEntity);
        i = 0;
        while (i < nCount) {
            block27: {
                block30: {
                    block29: {
                        block28: {
                            dsItemConfig = (DataGridDSItemConfig)dataGridRSConfig.getList().get(i);
                            if (dsItemConfig.getDataGridEditItemConfig() == null) break block27;
                            dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
                            strValue = this.dataGrid.getWebContext().GetPostValue(dsItemConfig.getID());
                            if (strValue != null) {
                                strValue = strValue.trim();
                                if (!StringHelper.IsNullOrEmpty((String)dgEditItemConfig.getStringCase())) {
                                    strValue = StringHelper.Compare((String)dgEditItemConfig.getStringCase(), (String)"UCASE", (boolean)true) == 0 ? strValue.toUpperCase() : strValue.toLowerCase();
                                }
                            }
                            strBackupValue = strValue;
                            if (StringHelper.Length((String)strValue) != 0) break block28;
                            if (!bIgnoreEmpty) {
                                if (!dgEditItemConfig.getAllowEmpty()) {
                                    dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 1, GridRowActionHelper.GetDataGridEditItemErrorMsg(1, dgEditItemConfig));
                                    bRet = false;
                                } else {
                                    baseDataEntity.SetParamValue(dgEditItemConfig.getDBField(), null);
                                    realDataEntity.SetParamValue(dgEditItemConfig.getDBField(), null);
                                }
                            }
                            break block27;
                        }
                        strValue = strBackupValue;
                        objValue = DataTypeParse.Parse((int)dgEditItemConfig.getDataType(), (String)strValue);
                        if (objValue != null) break block29;
                        dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 2, GridRowActionHelper.GetDataGridEditItemErrorMsg(2, dgEditItemConfig));
                        bRet = false;
                        break block27;
                    }
                    if (objValue instanceof Float && dgEditItemConfig.getPrecision() >= 0) {
                        bd = new BigDecimal(((Float)objValue).floatValue());
                        bd = bd.setScale(dgEditItemConfig.getPrecision(), 6);
                        objValue = Float.valueOf(bd.floatValue());
                    }
                    if (objValue instanceof Double && dgEditItemConfig.getPrecision() >= 0) {
                        bd = new BigDecimal((Double)objValue);
                        bd = bd.setScale(dgEditItemConfig.getPrecision(), 6);
                        objValue = bd.doubleValue();
                    }
                    if (!(objValue instanceof String)) break block30;
                    nMaxLength = dgEditItemConfig.getMaxLength();
                    if (nMaxLength == 0) {
                        nMaxLength = stringLengthsConfig.getStringMaxLength(dgEditItemConfig.getDBField());
                    }
                    if (nMaxLength <= 0 || StringHelper.Length((String)objValue.toString()) <= nMaxLength) break block30;
                    dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 3, GridRowActionHelper.GetDataGridEditItemLengthErrorMsg(dgEditItemConfig, nMaxLength));
                    bRet = false;
                    break block27;
                }
                if (objValue instanceof Timestamp) {
                    if (dgEditItemConfig.getEndOfDay()) {
                        endTime = (Timestamp)objValue;
                        cal = Calendar.getInstance();
                        cal.setTime(new Date(endTime.getTime()));
                        cal.set(11, 23);
                        cal.set(12, 59);
                        cal.set(13, 59);
                        endTime.setTime(cal.getTime().getTime());
                        objValue = endTime;
                    }
                } else if (objValue instanceof java.sql.Date) {
                    if (dgEditItemConfig.getEndOfDay()) {
                        endTime = (java.sql.Date)objValue;
                        cal = Calendar.getInstance();
                        cal.setTime(new Date(endTime.getTime()));
                        cal.set(11, 23);
                        cal.set(12, 59);
                        cal.set(13, 59);
                        endTime.setTime(cal.getTime().getTime());
                        objValue = endTime;
                    }
                } else if (objValue instanceof Time && dgEditItemConfig.getEndOfDay()) {
                    endTime = (Time)objValue;
                    cal = Calendar.getInstance();
                    cal.setTime(new Date(endTime.getTime()));
                    cal.set(11, 23);
                    cal.set(12, 59);
                    cal.set(13, 59);
                    endTime.setTime(cal.getTime().getTime());
                    objValue = endTime;
                }
                bCheckRule = true;
                strValidCode = dgEditItemConfig.getValidCond();
                if (StringHelper.Compare((String)strValidCode, (String)"NONE", (boolean)true) == 0) {
                    bCheckRule = false;
                } else if (StringHelper.Compare((String)strValidCode, (String)"CREATE", (boolean)true) == 0) {
                    if (!bInsert) {
                        bCheckRule = false;
                    }
                } else if (StringHelper.Compare((String)strValidCode, (String)"UPDATE", (boolean)true) == 0 && bInsert) {
                    bCheckRule = false;
                }
                if (!bCheckRule || StringHelper.IsNullOrEmpty((String)dgEditItemConfig.getValueRuleCode()) || dgEditItemRuleEngine == null) ** GOTO lbl-1000
                baseDataEntity.SetParamValue(dsItemConfig.getID(), objValue);
                bTestRet = dgEditItemRuleEngine.TestValueRule(dgEditItemConfig, objValue, strValue);
                baseDataEntity.RemoveParam(dsItemConfig.getID());
                if (!bTestRet) {
                    dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 3, dgEditItemConfig.getValueRuleInfo());
                    bRet = false;
                } else lbl-1000:
                // 2 sources

                {
                    baseDataEntity.SetParamValue(dgEditItemConfig.getDBField(), objValue);
                    realDataEntity.SetParamValue(dgEditItemConfig.getDBField(), objValue);
                }
            }
            ++i;
        }
        realDataEntity.CopyTo(baseDataEntity, true);
        return bRet;
    }

    public void RemoveInvalidValue(BaseDataEntity dataEntity, boolean bCreate) {
        ISRFExDGEditItemRuleEngine dgEditItemRuleEngine = DataGridRowActionHelperEx.CreateDGEditItemRuleEngine(this.dataGrid, dataEntity);
        int nCount = this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().size();
        int i = 0;
        while (i < nCount) {
            DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)((Object)this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().get(i));
            if (!dsItemConfig.getKey()) {
                DataGridEditItemConfig dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
                if (dgEditItemConfig == null) {
                    dataEntity.RemoveParam(dsItemConfig.getID());
                } else {
                    String strValidCond = dgEditItemConfig.getValidCond();
                    if (!StringHelper.IsNullOrEmpty((String)strValidCond)) {
                        if (StringHelper.Compare((String)strValidCond, (String)"NONE", (boolean)true) == 0) {
                            dataEntity.RemoveParam(dsItemConfig.getID());
                        } else if (StringHelper.Compare((String)strValidCond, (String)"ALL", (boolean)true) != 0) {
                            if (StringHelper.Compare((String)strValidCond, (String)"CREATE", (boolean)true) == 0) {
                                if (!bCreate) {
                                    dataEntity.RemoveParam(dsItemConfig.getID());
                                }
                            } else if (StringHelper.Compare((String)strValidCond, (String)"UPDATE", (boolean)true) == 0) {
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
            ++i;
        }
    }

    public void FillDataEntityDV(BaseDataEntity dataEntity) {
        int nCount = this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().size();
        int i = 0;
        while (i < nCount) {
            DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)((Object)this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().get(i));
            DataGridEditItemConfig dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
            if (dgEditItemConfig != null && dataEntity.GetParamValue(dsItemConfig.getID()) == null) {
                String strDVT = dgEditItemConfig.getDVT();
                String strDV = dgEditItemConfig.getDV();
                if (StringHelper.Length((String)strDVT) != 0 || StringHelper.Length((String)strDV) != 0) {
                    dataEntity.SetParamValue(dsItemConfig.getID(), DADVHelper.GetDefaultValue(this.dataGrid.getWebContext(), strDVT, strDV, dsItemConfig.getDataType(), dataEntity));
                }
            }
            ++i;
        }
    }

    private static ISRFExDGEditItemRuleEngine CreateDGEditItemRuleEngine(SRFExDataGrid dataGrid, BaseDataEntity dataEntity) {
        ISRFExDGEditItemRuleEngine iEngine = null;
        String strEngine = dataGrid.getPage().getWebContext().getWebExConfig().GetValue("SRFEXWEB", "DGEDITITEMRULEENGINE", "");
        if (StringHelper.IsNullOrEmpty((String)strEngine)) {
            return null;
        }
        Object objEngine = ObjectHelper.Create(strEngine);
        if (objEngine != null && objEngine instanceof ISRFExDGEditItemRuleEngine) {
            iEngine = (ISRFExDGEditItemRuleEngine)objEngine;
        }
        if (iEngine != null && iEngine.Init(dataGrid, dataEntity)) {
            return iEngine;
        }
        return null;
    }
}

