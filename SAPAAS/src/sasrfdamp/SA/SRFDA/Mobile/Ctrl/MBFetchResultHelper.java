/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Mobile.UIPart.Model.MBUIPartConfig
 *  SA.SRFDA.Mobile.UIPart.Model.MBUIPartDSConfig
 *  SA.SRFDA.Mobile.UIPart.Model.MBUIPartDSItemConfig
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Common.SRFGlobal
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.Web.WebUtility
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.UI.ItemParamConfig
 *  SA.SRFramework.WebEx.UI.ItemParamsConfig
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Mobile.Ctrl;

import SA.SRFDA.Mobile.Ctrl.ISRFDAMBUIPartDSItem;
import SA.SRFDA.Mobile.UIPart.Model.MBUIPartConfig;
import SA.SRFDA.Mobile.UIPart.Model.MBUIPartDSConfig;
import SA.SRFDA.Mobile.UIPart.Model.MBUIPartDSItemConfig;
import SA.SRFDA.Web.SRFDAWebContext;
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
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import java.util.Hashtable;
import java.util.TimeZone;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MBFetchResultHelper {
    private static final Log log = LogFactory.getLog(MBFetchResultHelper.class);

    public static void Fill(SRFDAWebContext webContext, Vector items, DataTable dataTable, MBUIPartConfig mbUIPartConfig, boolean bRealTempKey, boolean bItemPrivilege) {
        Hashtable userTable = null;
        int nRowCount = dataTable.GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            DataRow dr = dataTable.GetRow(i);
            JSONObject objJSON = new JSONObject();
            MBFetchResultHelper.FillRow(webContext, i, objJSON, dr, mbUIPartConfig.getDSConfig(), userTable, bRealTempKey, bItemPrivilege);
            items.add(objJSON);
            ++i;
        }
    }

    protected static void FillRow(SRFDAWebContext webContext, int nIndex, JSONObject objJSON, DataRow dr, MBUIPartDSConfig dataGridRS, Hashtable userTable, boolean bRealTempKey, boolean bItemPrivilege) {
        try {
            String strPageModel = webContext.GetParamValue("SRFPAGEMODEL");
            String strSRFRowId = "";
            String strKey = "";
            int nColumnCount = dataGridRS.getList().size();
            int i = 0;
            while (i < nColumnCount) {
                MBUIPartDSItemConfig dsItemConfig = (MBUIPartDSItemConfig)dataGridRS.getList().get(i);
                if (!bItemPrivilege || StringHelper.IsNullOrEmpty((String)dsItemConfig.getPrivilegeId()) || webContext.GetUserPrivilegeMgr().TestColumn((ISRFExWebContext)webContext, dsItemConfig.getPrivilegeId()) != 0) {
                    if (StringHelper.Compare((String)dsItemConfig.getID(), (String)"SRFROWID", (boolean)true) == 0) {
                        strSRFRowId = Helper.GenGuid();
                        objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)strSRFRowId);
                    } else if (StringHelper.Compare((String)dsItemConfig.getID(), (String)"SRFROWSN", (boolean)true) == 0) {
                        objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)StringHelper.Format((String)"%1$s", (Object)(nIndex + 1)));
                    } else if (!bRealTempKey && StringHelper.Compare((String)dsItemConfig.getID(), (String)"SRFDATEMPKEYID", (boolean)true) == 0) {
                        objJSON.put(dsItemConfig.getID().toLowerCase(), (Object)"");
                    } else if (StringHelper.Length((String)dsItemConfig.getCustom()) <= 0) {
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
                                    ItemParamConfig itemParamConfig = (ItemParamConfig)itemParamsConfig.getList().get(j);
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
                                                objValue = StringHelper.IsNullOrEmpty((String)strPageModel) ? codeListConfig2.GetCodeListValueWithStyle(strTempValue, false) : codeListConfig2.GetCodeListValue(strTempValue, false);
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
                                strValue = StringHelper.IsNullOrEmpty((String)strPageModel) ? codeListConfig.GetCodeListValueWithStyle(strValue, false) : codeListConfig.GetCodeListValue(strValue, false);
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
                                        ItemParamConfig itemParamConfig = (ItemParamConfig)itemParamsConfig.getList().get(j);
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
                }
                ++i;
            }
            objJSON.put("KEYS", (Object)strKey);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected static ISRFDAMBUIPartDSItem GetDataGridDSItem(String strCustomId, Hashtable userTable) {
        if (userTable != null && userTable.contains(strCustomId)) {
            return (ISRFDAMBUIPartDSItem)userTable.get(strCustomId);
        }
        Object obj = ObjectHelper.Create((String)strCustomId);
        if (obj == null) {
            return null;
        }
        if (obj instanceof ISRFExDataGridDSItem) {
            if (userTable == null) {
                userTable = new Hashtable<String, Object>();
            }
            userTable.put(strCustomId, obj);
            return (ISRFDAMBUIPartDSItem)obj;
        }
        return null;
    }
}

