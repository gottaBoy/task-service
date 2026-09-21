/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Ctrl;

import java.util.Hashtable;
import java.util.Iterator;
import net.sf.json.JSONObject;

public class BICubeCacheCondition {
    Hashtable<String, String> conditionMap = new Hashtable();
    protected JSONObject jo = null;

    public BICubeCacheCondition(JSONObject jo) {
        this.jo = jo;
        Iterator it = this.jo.keys();
        while (it.hasNext()) {
            String strKey = (String)it.next();
            this.conditionMap.put(strKey.toUpperCase(), this.jo.getString(strKey));
        }
    }

    public boolean hasCondition(String strBIHierarchy) {
        strBIHierarchy = strBIHierarchy.toUpperCase();
        return this.conditionMap.containsKey(strBIHierarchy);
    }

    public String getCondition(String strBIHierarchy) {
        if (this.conditionMap.containsKey(strBIHierarchy = strBIHierarchy.toUpperCase())) {
            return this.conditionMap.get(strBIHierarchy);
        }
        return "";
    }
}

