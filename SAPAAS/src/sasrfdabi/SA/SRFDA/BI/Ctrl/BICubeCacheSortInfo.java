/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class BICubeCacheSortInfo {
    private String strSortField = "";
    private String strSortDir = "";
    private int nTopCount = 10;

    public BICubeCacheSortInfo(JSONObject jo) {
        if (jo.has("measure")) {
            this.strSortField = jo.getString("measure");
        }
        if (jo.has("sortdir")) {
            this.strSortDir = jo.getString("sortdir");
        }
        if (jo.has("topcnt")) {
            String strTopCnt = jo.getString("topcnt");
            this.nTopCount = Integer.parseInt(strTopCnt);
        }
        if (StringHelper.IsNullOrEmpty((String)this.strSortDir)) {
            this.strSortDir = "ASC";
        }
    }

    public String getSortField() {
        return this.strSortField;
    }

    public void setSortField(String strSortField) {
        this.strSortField = strSortField;
    }

    public String getSortDir() {
        return this.strSortDir;
    }

    public int getTopCount() {
        return this.nTopCount;
    }
}

