/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ACFetchResultHelper {
    private static final Log log = LogFactory.getLog(ACFetchResultHelper.class);

    public static void Fill(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams) {
        ACFetchResultHelper.Fill(webContext, items, dataTable, strTextFormat, strTextParams, "", "", false, "", "");
    }

    public static void FillEx(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams) {
        ACFetchResultHelper.FillEx(webContext, items, dataTable, strTextFormat, strTextParams, "", "", false, "", "");
    }

    public static void Fill(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strValueFormat, String strValueParams) {
        ACFetchResultHelper.Fill(webContext, items, dataTable, strTextFormat, strTextParams, "", "", true, strValueFormat, strValueParams);
    }

    public static void FillEx(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strValueFormat, String strValueParams) {
        ACFetchResultHelper.FillEx(webContext, items, dataTable, strTextFormat, strTextParams, "", "", true, strValueFormat, strValueParams);
    }

    public static void Fill(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strRealTextFormat, String strRealTextParams, String strValueFormat, String strValueParams) {
        ACFetchResultHelper.Fill(webContext, items, dataTable, strTextFormat, strTextParams, strRealTextFormat, strRealTextParams, true, strValueFormat, strValueParams);
    }

    public static void FillEx(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strRealTextFormat, String strRealTextParams, String strValueFormat, String strValueParams) {
        ACFetchResultHelper.FillEx(webContext, items, dataTable, strTextFormat, strTextParams, strRealTextFormat, strRealTextParams, true, strValueFormat, strValueParams);
    }

    public static void Fill(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strRealTextFormat, String strRealTextParams, String strValueFormat, String strValueParams, Hashtable extParam) {
        ACFetchResultHelper.Fill(webContext, items, dataTable, strTextFormat, strTextParams, strRealTextFormat, strRealTextParams, true, strValueFormat, strValueParams, extParam);
    }

    public static void FillEx(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strRealTextFormat, String strRealTextParams, String strValueFormat, String strValueParams, Hashtable extParam) {
        ACFetchResultHelper.FillEx(webContext, items, dataTable, strTextFormat, strTextParams, strRealTextFormat, strRealTextParams, true, strValueFormat, strValueParams, extParam);
    }

    public static void Fill(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strRealTextFormat, String strRealTextParams, boolean bFillValue, String strValueFormat, String strValueParams) {
        ACFetchResultHelper.Fill(webContext, items, dataTable, strTextFormat, strTextParams, strRealTextFormat, strRealTextParams, bFillValue, strValueFormat, strValueParams, null);
    }

    public static void FillEx(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strRealTextFormat, String strRealTextParams, boolean bFillValue, String strValueFormat, String strValueParams) {
        ACFetchResultHelper.FillEx(webContext, items, dataTable, strTextFormat, strTextParams, strRealTextFormat, strRealTextParams, bFillValue, strValueFormat, strValueParams, null);
    }

    public static void Fill(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strRealTextFormat, String strRealTextParams, boolean bFillValue, String strValueFormat, String strValueParams, Hashtable extParam) {
        if (StringHelper.Length((String)strTextFormat) == 0) {
            strTextFormat = "%1$s";
        }
        if (bFillValue && StringHelper.Length((String)strValueFormat) == 0) {
            strValueFormat = "%1$s";
        }
        if (StringHelper.Length((String)strRealTextFormat) == 0) {
            strRealTextFormat = "%1$s";
        }
        Hashtable<String, JSONObject> maps = new Hashtable<String, JSONObject>();
        int i = 0;
        while (i < items.size()) {
            JSONObject objJSON = (JSONObject)items.get(i);
            String strText = objJSON.getString("text");
            maps.put(strText, objJSON);
            ++i;
        }
        boolean bFillRealTextParams = true;
        if (StringHelper.Length((String)strRealTextParams) == 0) {
            strRealTextParams = "";
            bFillRealTextParams = false;
        }
        strTextParams = strTextParams.replace(";", "|");
        strRealTextParams = strRealTextParams.replace(";", "|");
        strValueParams = strValueParams.replace(";", "|");
        String[] textParams = strTextParams.split("[|]");
        String[] realTextParams = strRealTextParams.split("[|]");
        String[] valueParams = strValueParams.split("[|]");
        int nRowCount = dataTable.GetRowCount();
        int i2 = 0;
        while (i2 < nRowCount) {
            DataRow dr = dataTable.GetRow(i2);
            JSONObject objJSON = new JSONObject();
            String strText = ACFetchResultHelper.GetValue(dr, strTextFormat, textParams);
            if (StringHelper.Length((String)strText) != 0) {
                objJSON.put("text", (Object)strText);
                if (bFillRealTextParams) {
                    String strRealText = ACFetchResultHelper.GetValue(dr, strRealTextFormat, realTextParams);
                    objJSON.put("realtext", (Object)strRealText);
                } else {
                    objJSON.put("realtext", (Object)strText);
                }
                if (bFillValue) {
                    String strValue = ACFetchResultHelper.GetValue(dr, strValueFormat, valueParams);
                    objJSON.put("value", (Object)strValue);
                }
                if (extParam != null) {
                    Enumeration e = extParam.keys();
                    while (e.hasMoreElements()) {
                        String strValue;
                        String strKey = (String)e.nextElement();
                        String strExtParamFormat = (String)extParam.get(strKey);
                        String[] extParams = strExtParamFormat.split("[|]");
                        if (extParams.length == 0) continue;
                        if (extParams.length == 1) {
                            strValue = ACFetchResultHelper.GetValue(dr, "%1$s", extParams);
                            objJSON.put(strKey.toLowerCase(), (Object)strValue);
                            continue;
                        }
                        if (extParams.length <= 1) continue;
                        strValue = ACFetchResultHelper.GetValue(dr, extParams);
                        objJSON.put(strKey.toLowerCase(), (Object)strValue);
                    }
                }
                maps.put(strText, objJSON);
            }
            ++i2;
        }
        items.clear();
        Enumeration e = maps.keys();
        while (e.hasMoreElements()) {
            String strKey = (String)e.nextElement();
            items.add(maps.get(strKey));
        }
    }

    public static void FillEx(SRFExWebContext webContext, Vector items, DataTable dataTable, String strTextFormat, String strTextParams, String strRealTextFormat, String strRealTextParams, boolean bFillValue, String strValueFormat, String strValueParams, Hashtable extParam) {
        if (StringHelper.Length((String)strTextFormat) == 0) {
            strTextFormat = "%1$s";
        }
        if (bFillValue && StringHelper.Length((String)strValueFormat) == 0) {
            strValueFormat = "%1$s";
        }
        if (StringHelper.Length((String)strRealTextFormat) == 0) {
            strRealTextFormat = "%1$s";
        }
        Hashtable<String, Boolean> maps = new Hashtable<String, Boolean>();
        int i = 0;
        while (i < items.size()) {
            JSONObject objJSON = (JSONObject)items.get(i);
            String strText = objJSON.getString("text");
            maps.put(strText, true);
            ++i;
        }
        boolean bFillRealTextParams = true;
        if (StringHelper.Length((String)strRealTextParams) == 0) {
            strRealTextParams = "";
            bFillRealTextParams = false;
        }
        strTextParams = strTextParams.replace(";", "|");
        strRealTextParams = strRealTextParams.replace(";", "|");
        strValueParams = strValueParams.replace(";", "|");
        String[] textParams = strTextParams.split("[|]");
        String[] realTextParams = strRealTextParams.split("[|]");
        String[] valueParams = strValueParams.split("[|]");
        int nRowCount = dataTable.GetRowCount();
        int i2 = 0;
        while (i2 < nRowCount) {
            DataRow dr = dataTable.GetRow(i2);
            JSONObject objJSON = new JSONObject();
            String strText = ACFetchResultHelper.GetValue(dr, strTextFormat, textParams);
            if (StringHelper.Length((String)strText) != 0 && !maps.containsKey(strText)) {
                maps.put(strText, true);
                objJSON.put("text", (Object)strText);
                if (bFillRealTextParams) {
                    String strRealText = ACFetchResultHelper.GetValue(dr, strRealTextFormat, realTextParams);
                    objJSON.put("realtext", (Object)strRealText);
                } else {
                    objJSON.put("realtext", (Object)strText);
                }
                if (bFillValue) {
                    String strValue = ACFetchResultHelper.GetValue(dr, strValueFormat, valueParams);
                    objJSON.put("value", (Object)strValue);
                }
                if (extParam != null) {
                    Enumeration e = extParam.keys();
                    while (e.hasMoreElements()) {
                        String strValue;
                        String strKey = (String)e.nextElement();
                        String strExtParamFormat = (String)extParam.get(strKey);
                        String[] extParams = strExtParamFormat.split("[|]");
                        if (extParams.length == 0) continue;
                        if (extParams.length == 1) {
                            strValue = ACFetchResultHelper.GetValue(dr, "%1$s", extParams);
                            objJSON.put(strKey.toLowerCase(), (Object)strValue);
                            continue;
                        }
                        if (extParams.length <= 1) continue;
                        strValue = ACFetchResultHelper.GetValue(dr, extParams);
                        objJSON.put(strKey.toLowerCase(), (Object)strValue);
                    }
                }
                items.add(objJSON);
            }
            ++i2;
        }
    }

    protected static String GetValue(DataRow dr, String strValueFormat, String[] valueParams) {
        try {
            Object[] valueObj = new Object[valueParams.length];
            int j = 0;
            while (j < valueParams.length) {
                String strParam = valueParams[j];
                valueObj[j] = dr.IsDBNull(strParam) ? "" : dr.Get(strParam);
                ++j;
            }
            return StringHelper.Format((String)strValueFormat, (Object[])valueObj);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return "";
        }
    }

    protected static String GetValue(DataRow dr, String[] valueParams) {
        try {
            Object[] valueObj = new Object[valueParams.length - 1];
            int j = 0;
            while (j < valueParams.length - 1) {
                String strParam = valueParams[j + 1];
                valueObj[j] = dr.IsDBNull(strParam) ? "" : dr.Get(strParam);
                ++j;
            }
            return StringHelper.Format((String)valueParams[0], (Object[])valueObj);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return "";
        }
    }
}

