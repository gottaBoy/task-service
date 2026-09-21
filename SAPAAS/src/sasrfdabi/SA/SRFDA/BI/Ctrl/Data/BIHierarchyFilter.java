/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Vector;
import net.sf.json.JSONObject;

public class BIHierarchyFilter {
    String strBILevel = "";
    String strFilters = "";
    String strBIHierarchy = "";

    public String getBILevel() {
        return this.strBILevel;
    }

    public void setBILevel(String strBILevel) {
        this.strBILevel = strBILevel;
    }

    public String getFilters() {
        return this.strFilters;
    }

    public void setFilters(String strFilters) {
        this.strFilters = strFilters;
    }

    public String getBIHierarchy() {
        return this.strBIHierarchy;
    }

    public void setBIHierarchy(String strBIHierarchy) {
        this.strBIHierarchy = strBIHierarchy;
    }

    public static Vector<BIHierarchyFilter> Parse(String strBIFilter) throws Exception {
        JSONObject filter = JSONObject.fromString((String)strBIFilter);
        if (filter == null) {
            throw new Exception(StringHelper.Format((String)"\u8fc7\u6ee4\u6761\u4ef6\u65e0\u6548[%1$s]", (Object)strBIFilter));
        }
        Vector<BIHierarchyFilter> biHierarchyItems = new Vector<BIHierarchyFilter>();
        Iterator it = filter.keys();
        while (it.hasNext()) {
            String strBIHierarchy = (String)it.next();
            String strBIHierarchyConfig = filter.getString(strBIHierarchy);
            if (StringHelper.IsNullOrEmpty((String)strBIHierarchyConfig)) continue;
            JSONObject biHierarchyConfig = JSONObject.fromString((String)strBIHierarchyConfig);
            String strFilter = "";
            boolean bVisible = true;
            String strBILevel = "";
            if (biHierarchyConfig.has("visible")) {
                bVisible = biHierarchyConfig.getBoolean("visible");
            }
            if (!bVisible) continue;
            if (biHierarchyConfig.has("filter")) {
                strFilter = biHierarchyConfig.getString("filter");
            }
            if (biHierarchyConfig.has("level")) {
                strBILevel = biHierarchyConfig.getString("level");
            }
            BIHierarchyFilter biHierarchyItem = new BIHierarchyFilter();
            biHierarchyItem.setBIHierarchy(strBIHierarchy);
            biHierarchyItem.setBILevel(strBILevel);
            biHierarchyItem.setFilters(strFilter);
            biHierarchyItems.add(biHierarchyItem);
        }
        return biHierarchyItems;
    }
}

