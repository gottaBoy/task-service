/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Common.SRFGlobal
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebUtility
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Common.SRFGlobal;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import SA.SRFramework.WebEx.UI.DataGridDSConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import java.util.Hashtable;
import java.util.TimeZone;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GridFetchResultHelper {
    private static final Log log = LogFactory.getLog(GridFetchResultHelper.class);

    public static void Fill(SRFExWebContext webContext, Vector items, DataTable dataTable, DataGridConfig dataGridConfig, String strDataGridId) {
        GridFetchResultHelper.Fill(webContext, items, dataTable, dataGridConfig, strDataGridId, false);
    }

    public static void Fill(SRFExWebContext webContext, Vector items, DataTable dataTable, DataGridConfig dataGridConfig, String strDataGridId, boolean bRealTempKey) {
        Hashtable userTable = null;
        int nRowCount = dataTable.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            DataRow dr = dataTable.GetRow(i);
            JSONObject objJSON = new JSONObject();
            GridFetchResultHelper.FillRow(webContext, i, objJSON, dr, dataGridConfig.getDataGridDSConfig(), userTable, dataGridConfig.getSelectColumn(), strDataGridId, bRealTempKey, false);
            items.add(objJSON);
            ++i;
        }
    }

    public static void Fill(SRFExWebContext webContext, Vector items, DataTable dataTable, DataGridConfig dataGridConfig, String strDataGridId, boolean bRealTempKey, boolean bItemPrivilege) {
        Hashtable userTable = null;
        int nRowCount = dataTable.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            DataRow dr = dataTable.GetRow(i);
            JSONObject objJSON = new JSONObject();
            GridFetchResultHelper.FillRow(webContext, i, objJSON, dr, dataGridConfig.getDataGridDSConfig(), userTable, dataGridConfig.getSelectColumn(), strDataGridId, bRealTempKey, bItemPrivilege);
            items.add(objJSON);
            ++i;
        }
    }

    protected static void FillRow(SRFExWebContext webContext, int nIndex, JSONObject objJSON, DataRow dr, DataGridDSConfig dataGridRS, Hashtable userTable, boolean bSelectColumn, String strDataGridId, boolean bRealTempKey, boolean bItemPrivilege) {
        try {
            String strPageModel = webContext.GetParamValue("SRFPAGEMODEL");
            String strSRFRowId = "";
            String strKey = "";
            int nColumnCount = dataGridRS.getList().size();
            int i = 0;
            while (i < nColumnCount) {
                DataGridDSItemConfig dsItemConfig = (DataGridDSItemConfig)((Object)dataGridRS.getList().get(i));
                if (!bItemPrivilege || StringHelper.IsNullOrEmpty((String)dsItemConfig.getPrivilegeId()) || webContext.GetUserPrivilegeMgr().TestColumn(webContext, dsItemConfig.getPrivilegeId()) != 0) {
                    if (StringHelper.Compare((String)dsItemConfig.getID(), (String)"SRFROWID", (boolean)true) == 0) {
                        strSRFRowId = Helper.GenGuid();
                        objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)strSRFRowId);
                    } else if (StringHelper.Compare((String)dsItemConfig.getID(), (String)"SRFROWSN", (boolean)true) == 0) {
                        objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)StringHelper.Format((String)"%1$s", (Object)(nIndex + 1)));
                    } else if (!bRealTempKey && StringHelper.Compare((String)dsItemConfig.getID(), (String)"SRFDATEMPKEYID", (boolean)true) == 0) {
                        objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)"");
                    } else {
                        if (StringHelper.Length((String)dsItemConfig.getCustom()) > 0) {
                            ISRFExDataGridDSItem iDataGridDSItem = GridFetchResultHelper.GetDataGridDSItem(dsItemConfig.getCustom(), userTable);
                            if (iDataGridDSItem == null) {
                                objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)"\u65e0\u6548\u7684\u81ea\u5b9a\u4e49\u8868\u683c\u6570\u636e");
                            } else if (iDataGridDSItem instanceof ISRFExDataGridDSItem3) {
                                objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)WebUtility.GetJSONText((String)((ISRFExDataGridDSItem3)((Object)iDataGridDSItem)).GetValue(webContext, dsItemConfig, dr, false), (boolean)true, (boolean)false));
                            } else {
                                objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)WebUtility.GetJSONText((String)iDataGridDSItem.GetValue(dsItemConfig, dr, false), (boolean)true, (boolean)false));
                            }
                        } else {
                            Object objValue;
                            int j;
                            Object[] valueObj;
                            Object objValue2;
                            ItemParamsConfig itemParamsConfig;
                            String strValue;
                            String strItemFormat;
                            try {
                                CodeListConfig codeListConfig;
                                strItemFormat = dsItemConfig.getItemFormat();
                                strValue = "";
                                if (StringHelper.Length((String)strItemFormat) == 0) {
                                    strItemFormat = "%1$s";
                                }
                                if ((itemParamsConfig = dsItemConfig.getItemParamsConfig()) == null) {
                                    if (dr.IsDBNull(dsItemConfig.getID())) {
                                        strValue = "";
                                    } else {
                                        objValue2 = dr.Get(dsItemConfig.getID());
                                        if (objValue2 == null) {
                                            strValue = "";
                                        } else {
                                            if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType((Object)objValue2)) {
                                                objValue2 = DateParser.AdjustByTimeZone((Object)objValue2, (TimeZone)webContext.getCurTimeZone(), (boolean)false);
                                            }
                                            strValue = StringHelper.Format((String)strItemFormat, (Object)objValue2);
                                        }
                                    }
                                } else {
                                    valueObj = new Object[itemParamsConfig.getList().size()];
                                    j = 0;
                                    while (j < itemParamsConfig.getList().size()) {
                                        ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                                        if (dr.IsDBNull(itemParamConfig.getID())) {
                                            valueObj[j] = StringHelper.IsNullOrEmpty((String)itemParamConfig.getDefault()) ? null : itemParamConfig.getDefault();
                                        } else {
                                            objValue = null;
                                            if (StringHelper.Length((String)itemParamConfig.getItemFormat()) > 0) {
                                                objValue = dr.Get(itemParamConfig.getID());
                                                if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType((Object)objValue)) {
                                                    objValue = DateParser.AdjustByTimeZone((Object)objValue, (TimeZone)webContext.getCurTimeZone(), (boolean)false);
                                                }
                                                objValue = StringHelper.Format((String)itemParamConfig.getItemFormat(), (Object)objValue);
                                            } else {
                                                objValue = dr.Get(itemParamConfig.getID());
                                                if (SRFGlobal.isMultiTimeZone() && DateParser.isDateTimeType((Object)objValue)) {
                                                    objValue = DateParser.AdjustByTimeZone((Object)objValue, (TimeZone)webContext.getCurTimeZone(), (boolean)false);
                                                }
                                            }
                                            if (StringHelper.Length((String)itemParamConfig.getCodeList()) > 0) {
                                                String strTempValue = objValue.toString();
                                                CodeListConfig codeListConfig2 = webContext.getCodeListMgr().GetCodeListConfig(itemParamConfig.getCodeList());
                                                if (codeListConfig2 != null) {
                                                    objValue = StringHelper.IsNullOrEmpty((String)strPageModel) ? codeListConfig2.GetCodeListValueWithStyle(strTempValue, true) : codeListConfig2.GetCodeListValue(strTempValue, true);
                                                }
                                            }
                                            valueObj[j] = objValue;
                                        }
                                        ++j;
                                    }
                                    boolean bNullValue = true;
                                    int j2 = 0;
                                    while (j2 < valueObj.length) {
                                        if (valueObj[j2] != null) {
                                            bNullValue = false;
                                            break;
                                        }
                                        ++j2;
                                    }
                                    strValue = bNullValue ? "" : StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                                }
                                if (StringHelper.Length((String)dsItemConfig.getCodeList()) > 0 && (codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(dsItemConfig.getCodeList())) != null) {
                                    strValue = StringHelper.IsNullOrEmpty((String)strPageModel) ? codeListConfig.GetCodeListValueWithStyle(strValue, true) : codeListConfig.GetCodeListValue(strValue, true);
                                }
                                objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)WebUtility.GetJSONText((String)strValue, (boolean)true, (boolean)false));
                            }
                            catch (Exception ex) {
                                objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)ex.getMessage());
                                log.error((Object)ex);
                            }
                            if (dsItemConfig.getKey()) {
                                try {
                                    strItemFormat = dsItemConfig.getKeyFormat();
                                    strValue = "";
                                    if (StringHelper.Length((String)strItemFormat) == 0) {
                                        strItemFormat = "%1$s";
                                    }
                                    if ((itemParamsConfig = dsItemConfig.getItemParamsConfig()) == null) {
                                        strValue = dr.IsDBNull(dsItemConfig.getID()) ? "" : ((objValue2 = dr.Get(dsItemConfig.getID())) == null ? "" : StringHelper.Format((String)strItemFormat, (Object)objValue2));
                                    } else {
                                        valueObj = new Object[itemParamsConfig.getList().size()];
                                        j = 0;
                                        while (j < itemParamsConfig.getList().size()) {
                                            ItemParamConfig itemParamConfig = (ItemParamConfig)((Object)itemParamsConfig.getList().get(j));
                                            if (dr.IsDBNull(itemParamConfig.getID())) {
                                                valueObj[j] = itemParamConfig.getDefault();
                                            } else {
                                                objValue = null;
                                                objValue = StringHelper.Length((String)itemParamConfig.getKeyFormat()) > 0 ? StringHelper.Format((String)itemParamConfig.getKeyFormat(), (Object)dr.Get(itemParamConfig.getID())) : dr.Get(itemParamConfig.getID());
                                                valueObj[j] = objValue;
                                            }
                                            ++j;
                                        }
                                        strValue = StringHelper.Format((String)strItemFormat, (Object[])valueObj);
                                    }
                                    objJSON.put(dsItemConfig.getID().toUpperCase(), (Object)strValue);
                                }
                                catch (Exception ex) {
                                    objJSON.put(dsItemConfig.getID().toUpperCase(), (Object)ex.getMessage());
                                    log.error((Object)ex);
                                }
                            }
                        }
                        if (dsItemConfig.getKey() && bSelectColumn) {
                            if (StringHelper.Length((String)strKey) != 0) {
                                strKey = String.valueOf(strKey) + "|";
                            }
                            strKey = String.valueOf(strKey) + objJSON.getString(dsItemConfig.getID().toUpperCase());
                        }
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
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected static ISRFExDataGridDSItem GetDataGridDSItem(String strCustomId, Hashtable userTable) {
        if (userTable != null && userTable.contains(strCustomId)) {
            return (ISRFExDataGridDSItem)userTable.get(strCustomId);
        }
        Object obj = ObjectHelper.Create(strCustomId);
        if (obj == null) {
            return null;
        }
        if (obj instanceof ISRFExDataGridDSItem) {
            if (userTable == null) {
                userTable = new Hashtable<String, Object>();
            }
            userTable.put(strCustomId, obj);
            return (ISRFExDataGridDSItem)obj;
        }
        return null;
    }
}

