/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Data;

import SA.SRFramework.Data.DBCallerConfig;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.SearchCtrlConfig;
import SA.SRFramework.Web.UI.SearchFormConfig;
import SA.SRFramework.Web.WebContext;
import java.sql.Timestamp;
import java.util.Hashtable;

public class SearchParamFiller {
    public static boolean Parser(WebContext webContext, DBCallerConfig searchCallConfig, Hashtable paramList) {
        boolean bRet = true;
        for (Object objParam : searchCallConfig.getParams()) {
            String strParamValue;
            DBCallerParam param = (DBCallerParam)objParam;
            String strParamName = param.getParamName();
            if (StringHelper.Length(strParamName) == 0) {
                strParamName = param.getParamValue();
            }
            if (StringHelper.Length(strParamValue = webContext.GetParamValue(strParamName)) == 0) continue;
            Object objValue = DataTypeParse.Parse(param.getDBType(), strParamValue);
            if (objValue == null) {
                bRet = false;
                continue;
            }
            paramList.put(strParamName.toUpperCase(), objValue);
        }
        return bRet;
    }

    public static boolean ParseExt(WebContext webContext, DBCallerConfig searchCallConfig, Hashtable paramList, SearchFormConfig searchFormConfig) {
        boolean bRet = true;
        bRet = SearchParamFiller.Parser(webContext, searchCallConfig, paramList);
        if (!bRet) {
            return false;
        }
        int nSearchItemCount = searchFormConfig.getSearchItems().size();
        int i = 0;
        while (i < nSearchItemCount) {
            Timestamp endTime;
            SearchCtrlConfig searchCtrlConfig = (SearchCtrlConfig)searchFormConfig.getSearchItems().get(i);
            String strIdFormat = searchCtrlConfig.getDBField();
            if (searchCtrlConfig.getSearchRange()) {
                String strParamKeyTo = String.valueOf(searchCtrlConfig.getDBField()) + "_TO";
                strParamKeyTo = strParamKeyTo.toUpperCase();
                Object objValueTo = null;
                if (paramList.containsKey(strParamKeyTo)) {
                    objValueTo = paramList.get(strParamKeyTo);
                }
                if (objValueTo != null && objValueTo.getClass().getName().equals("java.sql.Timestamp") && searchCtrlConfig.GetExtValue("ENDOFDAY", false)) {
                    endTime = (Timestamp)objValueTo;
                    endTime.setTime(endTime.getTime() + 86400000L - 1L);
                    paramList.put(strParamKeyTo, objValueTo);
                }
            } else {
                String strParamKey = searchCtrlConfig.getDBField();
                strParamKey = strParamKey.toUpperCase();
                Object objValue = null;
                if (paramList.containsKey(strParamKey)) {
                    objValue = paramList.get(strParamKey);
                }
                if (objValue != null && objValue.getClass().getName().equals("java.sql.Timestamp") && searchCtrlConfig.GetExtValue("ENDOFDAY", false)) {
                    endTime = (Timestamp)objValue;
                    endTime.setTime(endTime.getTime() + 86400000L - 1L);
                    paramList.put(strParamKey, objValue);
                }
            }
            ++i;
        }
        return true;
    }
}

