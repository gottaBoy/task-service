/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Common.SRFGlobal
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
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
import SA.SRFramework.WebEx.DataGrid.ISRFExDGEditItemRuleEngine;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem2;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem4;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.UI.DataGridEditItemConfig;
import SA.SRFramework.WebEx.UI.DataGridEditItemErrors;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;
import net.sf.json.JSONObject;

public class GridRowActionHelper {
    public static boolean FillRow(SRFExWebContext webContext, int nIndex, JSONObject objJSON, BaseDataEntity baseDataEntity, DataGridConfig dataGridConfig, String strDataGridId) {
        try {
            boolean bSelectColumn = dataGridConfig.getSelectColumn();
            DataGridDSConfig dataGridRS = dataGridConfig.getDataGridDSConfig();
            String strSRFRowId = "";
            String strKey = "";
            int nColumnCount = dataGridRS.getList().size();
            int i = 0;
            while (i < nColumnCount) {
                DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)((Object)dataGridRS.getList().get(i));
                if (StringHelper.Compare((String)dsItemConfig.getID(), (String)"SRFROWID", (boolean)true) == 0) {
                    strSRFRowId = Helper.GenGuid();
                    objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)strSRFRowId);
                } else {
                    Object objValue;
                    ItemParamConfig itemParamConfig;
                    int j;
                    Object[] valueObj;
                    Object objValue2;
                    ItemParamsConfig itemParamsConfig;
                    String strValue;
                    String strItemFormat;
                    if (StringHelper.Length((String)dsItemConfig.getCustom()) > 0) {
                        Object dsItem = GridRowActionHelper.GetDataGridDSItem(dsItemConfig.getCustom());
                        if (dsItem == null) {
                            objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)"\u65e0\u6548\u7684\u81ea\u5b9a\u4e49\u8868\u683c\u6570\u636e");
                        } else if (dsItem instanceof ISRFExDataGridDSItem4) {
                            ISRFExDataGridDSItem4 iDataGridDSItem4 = (ISRFExDataGridDSItem4)dsItem;
                            objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)iDataGridDSItem4.GetValue(webContext, dsItemConfig, baseDataEntity, false));
                        } else if (dsItem instanceof ISRFExDataGridDSItem2) {
                            ISRFExDataGridDSItem2 iDataGridDSItem2 = (ISRFExDataGridDSItem2)dsItem;
                            objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)iDataGridDSItem2.GetValue(dsItemConfig, baseDataEntity));
                        } else {
                            objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)"\u65e0\u6548\u7684\u81ea\u5b9a\u4e49\u8868\u683c\u6570\u636e\u5bf9\u8c61");
                        }
                    } else {
                        CodeListConfig codeListConfig;
                        strItemFormat = dsItemConfig.getItemFormat();
                        strValue = "";
                        if (StringHelper.Length((String)strItemFormat) == 0) {
                            strItemFormat = "%1$s";
                        }
                        if ((itemParamsConfig = dsItemConfig.getItemParamsConfig()) == null) {
                            objValue2 = baseDataEntity.GetParamValue(dsItemConfig.getID());
                            if (objValue2 == null) {
                                strValue = "";
                            } else {
                                if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType((Object)objValue2)) {
                                    objValue2 = DateParser.AdjustByTimeZone((Object)objValue2, (TimeZone)webContext.getCurTimeZone(), (boolean)false);
                                }
                                strValue = StringHelper.Format((String)strItemFormat, (Object)objValue2);
                            }
                        } else {
                            valueObj = new Object[itemParamsConfig.getList().size()];
                            j = 0;
                            while (j < itemParamsConfig.getList().size()) {
                                itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                                objValue = baseDataEntity.GetParamValue(itemParamConfig.getID());
                                if (objValue == null) {
                                    valueObj[j] = itemParamConfig.getDefault();
                                } else {
                                    if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType((Object)objValue)) {
                                        objValue = DateParser.AdjustByTimeZone((Object)objValue, (TimeZone)webContext.getCurTimeZone(), (boolean)false);
                                    }
                                    if (StringHelper.Length((String)itemParamConfig.getItemFormat()) > 0) {
                                        objValue = StringHelper.Format((String)itemParamConfig.getItemFormat(), (Object)objValue);
                                    }
                                    if (StringHelper.Length((String)itemParamConfig.getCodeList()) > 0) {
                                        String strTempValue = objValue.toString();
                                        CodeListConfig codeListConfig2 = webContext.getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                                        if (codeListConfig2 != null) {
                                            objValue = codeListConfig2.GetCodeListValueWithStyle(strTempValue, true);
                                        }
                                    }
                                    valueObj[j] = objValue;
                                }
                                ++j;
                            }
                            strValue = StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                        }
                        if (StringHelper.Length((String)dsItemConfig.getCodeList()) > 0 && (codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(dsItemConfig.getCodeList())) != null) {
                            strValue = codeListConfig.GetCodeListValueWithStyle(strValue, true);
                        }
                        objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)strValue);
                    }
                    if (dsItemConfig.getKey()) {
                        strItemFormat = dsItemConfig.getKeyFormat();
                        strValue = "";
                        if (StringHelper.Length((String)strItemFormat) == 0) {
                            strItemFormat = "%1$s";
                        }
                        if ((itemParamsConfig = dsItemConfig.getItemParamsConfig()) == null) {
                            objValue2 = baseDataEntity.GetParamValue(dsItemConfig.getID());
                            strValue = objValue2 == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue2);
                        } else {
                            valueObj = new Object[itemParamsConfig.getList().size()];
                            j = 0;
                            while (j < itemParamsConfig.getList().size()) {
                                itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                                objValue = baseDataEntity.GetParamValue(itemParamConfig.getID());
                                if (objValue == null) {
                                    valueObj[j] = itemParamConfig.getDefault();
                                } else {
                                    if (StringHelper.Length((String)itemParamConfig.getKeyFormat()) > 0) {
                                        objValue = StringHelper.Format((String)itemParamConfig.getKeyFormat(), (Object)objValue);
                                    }
                                    valueObj[j] = objValue;
                                }
                                ++j;
                            }
                            strValue = StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                        }
                        objJSON.put(dsItemConfig.getID().toUpperCase(), (Object)strValue);
                    }
                    if (dsItemConfig.getKey() && bSelectColumn) {
                        if (StringHelper.Length((String)strKey) != 0) {
                            strKey = String.valueOf(strKey) + "|";
                        }
                        strKey = String.valueOf(strKey) + objJSON.getString(dsItemConfig.getID().toUpperCase());
                    }
                }
                ++i;
            }
            objJSON.put("KEYS", (Object)strKey);
            if (bSelectColumn) {
                String strSelectColumn = "";
                strSelectColumn = StringHelper.IsNullOrEmpty((String)strSRFRowId) ? String.valueOf(strSelectColumn) + StringHelper.Format((String)"<INPUT type='checkbox' id='%1$s_SC%2$s' name='%1$s_SC%2$s' value='%3$s' style='height:15px;'>", (Object)strDataGridId, (Object)nIndex, (Object)strKey) : String.valueOf(strSelectColumn) + StringHelper.Format((String)"<INPUT type='checkbox' id='%1$s_SC%2$s' name='%1$s_SC%2$s' value='%3$s' style='height:15px;'>", (Object)strDataGridId, (Object)strSRFRowId, (Object)strKey);
                objJSON.put("SELECTCOLUMN", (Object)strSelectColumn);
            }
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    protected static ISRFExDataGridDSItem2 GetDataGridDSItem2(String strCustomId) {
        Object obj = ObjectHelper.Create(strCustomId);
        if (obj == null) {
            return null;
        }
        if (obj instanceof ISRFExDataGridDSItem2) {
            return (ISRFExDataGridDSItem2)obj;
        }
        return null;
    }

    protected static Object GetDataGridDSItem(String strCustomId) {
        Object obj = ObjectHelper.Create(strCustomId);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public static boolean FillDataEntity(SRFExWebContext webContext, BaseDataEntity baseDataEntity, DataGridConfig dataGridConfig) {
        try {
            DataGridDSConfig dataGridRS = dataGridConfig.getDataGridDSConfig();
            int nColumnCount = dataGridRS.getList().size();
            int i = 0;
            while (i < nColumnCount) {
                DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)((Object)dataGridRS.getList().get(i));
                String strValue = webContext.GetPostValue(dsItemConfig.getID());
                if (StringHelper.Length((String)strValue) > 0) {
                    Object objValue = DataTypeParse.Parse((int)dsItemConfig.getDataType(), (String)strValue);
                    if (objValue != null && SRFGlobal.isMultiTimeZone() && DataTypeParse.IsDateTimeDataType((int)dsItemConfig.getDataType()) && DateParser.isDateTimeType((Object)objValue)) {
                        objValue = DateParser.AdjustByTimeZone((Object)objValue, (TimeZone)webContext.getCurTimeZone(), (boolean)true);
                    }
                    baseDataEntity.SetParamValue(dsItemConfig.getID(), objValue);
                }
                ++i;
            }
            baseDataEntity.SetParamValue("KEYS", webContext.getPage().getRequest().getParameter("KEYS"));
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean FillDataEntityKeys(SRFExWebContext webContext, BaseDataEntity baseDataEntity, SRFExDataGrid dataGrid) {
        DataGridConfig dataGridConfig = dataGrid.getDataGridConfig();
        DataGridDSConfig dataGridRSConfig = dataGridConfig.getDataGridDSConfig();
        int nCount = dataGridRSConfig.getList().size();
        int i = 0;
        while (i < nCount) {
            DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)((Object)dataGridRSConfig.getList().get(i));
            if (dsItemConfig.getKey()) {
                String strValue = webContext.getPage().getRequest().getParameter(dsItemConfig.getID().toUpperCase());
                if (StringHelper.Length((String)strValue) == 0) {
                    return false;
                }
                Object objValue = DataTypeParse.Parse((int)dsItemConfig.getDataType(), (String)strValue);
                if (objValue == null) {
                    return false;
                }
                baseDataEntity.SetParamValue(dsItemConfig.getID().toUpperCase(), objValue);
            }
            ++i;
        }
        return true;
    }

    public static boolean IsContainerKeyValue(SRFExWebContext webContext, BaseDataEntity baseDataEntity, SRFExDataGrid dataGrid) {
        boolean bHasKey = false;
        DataGridConfig dataGridConfig = dataGrid.getDataGridConfig();
        DataGridDSConfig dataGridRSConfig = dataGridConfig.getDataGridDSConfig();
        int nCount = dataGridRSConfig.getList().size();
        int i = 0;
        while (i < nCount) {
            DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)((Object)dataGridRSConfig.getList().get(i));
            if (dsItemConfig.getKey()) {
                bHasKey = true;
                String strValue = webContext.getPage().getRequest().getParameter(dsItemConfig.getID().toUpperCase());
                if (StringHelper.Length((String)strValue) == 0) {
                    return false;
                }
                Object objValue = DataTypeParse.Parse((int)dsItemConfig.getDataType(), (String)strValue);
                if (objValue == null) {
                    return false;
                }
                baseDataEntity.SetParamValue(dsItemConfig.getID().toUpperCase(), objValue);
            }
            ++i;
        }
        return bHasKey;
    }

    /*
     * Unable to fully structure code
     */
    public static boolean FillDataEntityEx(SRFExWebContext webContext, BaseDataEntity baseDataEntity, SRFExDataGrid dataGrid, boolean bIgnoreEmpty, DataGridEditItemErrors dgEditItemErrors) {
        bRet = true;
        dataGridConfig = dataGrid.getDataGridConfig();
        stringLengthsConfig = webContext.getStringLengthMgr().GetStringLengthsConfig();
        formValueRuleConfig = null;
        strFormValueRuleId = dataGrid.getDataGridConfig().getFormValueRuleId();
        if (StringHelper.Length((String)strFormValueRuleId) > 0 && (formValueRuleConfig = webContext.getValueRuleMgr().GetFormValueRuleConfig(strFormValueRuleId)) == null) {
            System.out.print(StringHelper.Format((String)"\u5b9a\u4e49\u4e86\u8868\u5355\u503c\u89c4\u5219[%1$s]\uff0c\u4f46\u65e0\u6cd5\u83b7\u53d6\u5bf9\u5e94\u7684\u914d\u7f6e\u3002", (Object)strFormValueRuleId));
        }
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
        valueRuleEngineContext = new DataGridValueRuleEngineContext();
        valueRuleEngineContext.setDataEntity(baseDataEntity);
        valueRuleEngineContext.setDBCallerHelper(webContext.getDBCaller());
        valueRuleEngineContext.setValueRuleMgr(webContext.getValueRuleMgr());
        valueRuleEngineContext.setDataGrid(dataGrid);
        valueRuleEngine = new DefaultValueRuleEngine();
        i = 0;
        while (i < nCount) {
            block22: {
                block25: {
                    block24: {
                        block23: {
                            dsItemConfig = (DataGridDSItemConfig)dataGridRSConfig.getList().get(i);
                            if (dsItemConfig.getDataGridEditItemConfig() == null) break block22;
                            dgEditItemConfig = dsItemConfig.getDataGridEditItemConfig();
                            strBackupValue = strValue = webContext.GetPostValue(dsItemConfig.getID());
                            if (strValue != null) {
                                strValue = strValue.trim();
                            }
                            if (StringHelper.Length((String)strValue) != 0) break block23;
                            if (!bIgnoreEmpty) {
                                if (!dgEditItemConfig.getAllowEmpty()) {
                                    dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 1, GridRowActionHelper.GetDataGridEditItemErrorMsg(1, dgEditItemConfig));
                                    bRet = false;
                                } else {
                                    baseDataEntity.SetParamValue(dgEditItemConfig.getDBField(), null);
                                    realDataEntity.SetParamValue(dgEditItemConfig.getDBField(), null);
                                }
                            }
                            break block22;
                        }
                        strValue = strBackupValue;
                        objValue = DataTypeParse.Parse((int)dgEditItemConfig.getDataType(), (String)strValue);
                        if (objValue != null) break block24;
                        dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 2, GridRowActionHelper.GetDataGridEditItemErrorMsg(2, dgEditItemConfig));
                        bRet = false;
                        break block22;
                    }
                    if (SRFGlobal.isMultiTimeZone() && DataTypeParse.IsDateTimeDataType((int)dgEditItemConfig.getDataType()) && DateParser.isDateTimeType((Object)objValue)) {
                        objValue = DateParser.AdjustByTimeZone((Object)objValue, (TimeZone)webContext.getCurTimeZone(), (boolean)true);
                    }
                    if (!(objValue instanceof String)) break block25;
                    nMaxLength = dgEditItemConfig.getMaxLength();
                    if (nMaxLength == 0) {
                        nMaxLength = stringLengthsConfig.getStringMaxLength(dgEditItemConfig.getDBField());
                    }
                    if (nMaxLength <= 0 || StringHelper.Length((String)objValue.toString()) <= nMaxLength) break block25;
                    dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 3, GridRowActionHelper.GetDataGridEditItemLengthErrorMsg(dgEditItemConfig, nMaxLength));
                    bRet = false;
                    break block22;
                }
                if (objValue instanceof Timestamp) {
                    if (dgEditItemConfig.getEndOfDay()) {
                        endTime = (Timestamp)objValue;
                        cal = Calendar.getInstance();
                        cal.setTime(new java.util.Date(endTime.getTime()));
                        cal.set(11, 23);
                        cal.set(12, 59);
                        cal.set(13, 59);
                        endTime.setTime(cal.getTime().getTime());
                        objValue = endTime;
                    }
                } else if (objValue instanceof Date) {
                    if (dgEditItemConfig.getEndOfDay()) {
                        endTime = (Date)objValue;
                        cal = Calendar.getInstance();
                        cal.setTime(new java.util.Date(endTime.getTime()));
                        cal.set(11, 23);
                        cal.set(12, 59);
                        cal.set(13, 59);
                        endTime.setTime(cal.getTime().getTime());
                        objValue = endTime;
                    }
                } else if (objValue instanceof Time && dgEditItemConfig.getEndOfDay()) {
                    endTime = (Time)objValue;
                    cal = Calendar.getInstance();
                    cal.setTime(new java.util.Date(endTime.getTime()));
                    cal.set(11, 23);
                    cal.set(12, 59);
                    cal.set(13, 59);
                    endTime.setTime(cal.getTime().getTime());
                    objValue = endTime;
                }
                if ((valueRuleConfig = dgEditItemConfig.getValueRuleConfig()) == null && StringHelper.Length((String)dgEditItemConfig.getValueRuleId()) > 0) {
                    valueRuleConfig = webContext.getValueRuleMgr().GetValueRuleConfig(dgEditItemConfig.getValueRuleId());
                }
                if (valueRuleConfig == null && formValueRuleConfig != null) {
                    valueRuleConfig = formValueRuleConfig.GetFormItemValueRuleConfig(dgEditItemConfig.getDBField());
                }
                if (valueRuleConfig == null) ** GOTO lbl-1000
                valueRuleEngineContext.setErrorMessage("");
                valueRuleEngineContext.setDataType(dgEditItemConfig.getDataType());
                valueRuleEngineContext.setValue(objValue);
                valueRuleEngineContext.setErrorMessage("");
                if (!valueRuleEngine.Check(valueRuleEngineContext, valueRuleConfig)) {
                    dgEditItemErrors.Register(dsItemConfig.getID(), dgEditItemConfig.getName(), 3, GridRowActionHelper.GetDataGridEditItemErrorMsg(dgEditItemConfig, valueRuleEngineContext.getErrorMessage()));
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

    public static String GetDataGridEditItemErrorMsg(int nErrorType, DataGridEditItemConfig dgEditItemConfig) {
        switch (nErrorType) {
            case 1: {
                return StringHelper.Format((String)"%1$s \u4e0d\u80fd\u8f93\u5165\u4e3a\u7a7a\uff0c\u5fc5\u987b\u4e3a\u5176\u6307\u5b9a\u503c", (Object)dgEditItemConfig.getName());
            }
            case 2: {
                return StringHelper.Format((String)"%1$s \u8f93\u5165\u5185\u5bb9\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u8f93\u5165\u7c7b\u578b\u4e3a[%2$s]\u7684\u503c", (Object)dgEditItemConfig.getName(), (Object)DataTypeHelper.GetTypeName((int)dgEditItemConfig.getDataType()));
            }
        }
        return StringHelper.Format((String)"%1$s \u8f93\u5165\u4e0d\u6b63\u786e", (Object)dgEditItemConfig.getName());
    }

    public static String GetDataGridEditItemLengthErrorMsg(DataGridEditItemConfig dgEditItemConfig, int nLength) {
        return StringHelper.Format((String)"%1$s \u8f93\u5165\u5185\u5bb9\u4e0d\u6b63\u786e\uff0c\u8f93\u5165\u5185\u5bb9\u7684\u957f\u5ea6\u4e0d\u5f97\u5927\u4e8e[%2$s](\u542b%2$s)", (Object)dgEditItemConfig.getName(), (Object)nLength);
    }

    protected static String GetDataGridEditItemErrorMsg(DataGridEditItemConfig dgEditItemConfig, String strErrorMsg) {
        if (StringHelper.Length((String)strErrorMsg) > 0) {
            return StringHelper.Format((String)"%1$s \u8f93\u5165\u4e0d\u6b63\u786e\uff0c\u8bf7\u786e\u8ba4\u60a8\u7684\u8f93\u5165\u7b26\u5408\u4ee5\u4e0b\u89c4\u5219\uff1a%2$s", (Object)dgEditItemConfig.getName(), (Object)strErrorMsg);
        }
        return StringHelper.Format((String)"%1$s \u8f93\u5165\u4e0d\u6b63\u786e", (Object)dgEditItemConfig.getName());
    }
}

