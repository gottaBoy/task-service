/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import java.util.Enumeration;
import java.util.Hashtable;

public class StyleBuilder {
    protected Hashtable styleList = null;
    protected boolean bKeyToLowerCase = true;

    public boolean getKeyToLowerCase() {
        return this.bKeyToLowerCase;
    }

    public void setKeyToLowerCase(boolean bKeyToLowerCase) {
        this.bKeyToLowerCase = bKeyToLowerCase;
    }

    public void AddStyle(String strKey, String strValue) {
        if (StringHelper.Length((String)strKey) == 0) {
            return;
        }
        if (StringHelper.Length((String)strValue) == 0) {
            return;
        }
        if (this.styleList == null) {
            this.styleList = new Hashtable();
        }
        if (this.bKeyToLowerCase) {
            this.styleList.put(strKey.toLowerCase(), strValue);
        } else {
            this.styleList.put(strKey, strValue);
        }
    }

    public void RemoveStyle(String strKey) {
        if (this.styleList == null) {
            return;
        }
        if (this.bKeyToLowerCase) {
            this.styleList.remove(strKey.toLowerCase());
        } else {
            this.styleList.remove(strKey);
        }
    }

    public void RemoveAllStyle() {
        if (this.styleList == null) {
            return;
        }
        this.styleList.clear();
    }

    public String ToStyleList() {
        if (this.styleList == null) {
            return "";
        }
        String strOutput = "";
        Enumeration en = this.styleList.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"%1$s:%2$s;", (Object)strKey, this.styleList.get(strKey));
        }
        return strOutput;
    }
}

