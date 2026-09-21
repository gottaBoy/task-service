/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import java.util.Enumeration;
import java.util.Hashtable;

public class AttributeCollection {
    private static String SATAB = "##SA_TAB##";
    private static String SARET = "##SA_RET##";
    protected Hashtable arrListItem = new Hashtable();

    public void Set(String strKey, String strValue) {
        if ((strKey = strKey.toUpperCase()).compareToIgnoreCase("ID") == 0 || strKey.compareToIgnoreCase("NAME") == 0) {
            return;
        }
        this.arrListItem.put(strKey, strValue);
    }

    public String Get(String strKey) {
        if (this.arrListItem.containsKey(strKey = strKey.toUpperCase())) {
            return (String)this.arrListItem.get(strKey);
        }
        return "";
    }

    public void Remove(String strKey) {
        if (this.arrListItem.containsKey(strKey = strKey.toUpperCase())) {
            this.arrListItem.remove(strKey);
        }
    }

    public void Clear() {
        this.arrListItem.clear();
    }

    public String ToOutputString() {
        String strOutput = "";
        Enumeration enumeration = this.arrListItem.keys();
        while (enumeration.hasMoreElements()) {
            String strName = (String)enumeration.nextElement();
            String strValue = (String)this.arrListItem.get(strName);
            if (strOutput.length() != 0) {
                strOutput = String.valueOf(strOutput) + " ";
            }
            strOutput = String.valueOf(strOutput) + String.format("%1$s=\"%2$s\"", strName.toLowerCase(), strValue);
        }
        return strOutput;
    }
}

