/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class AttributeBuilder {
    protected Hashtable arrListItem = null;
    protected ArrayList arrList = null;
    protected String strExtAttr = "";

    public synchronized void Set(String strKey, String strValue) {
        this.Set(strKey, strValue, false);
    }

    public synchronized void Set(String strKey, String strValue, boolean bIngoreValueEmpty) {
        if (StringHelper.Length((String)strKey) == 0) {
            return;
        }
        if (StringHelper.Length((String)strValue) == 0 && !bIngoreValueEmpty) {
            return;
        }
        if ((strKey = strKey.toLowerCase()).compareToIgnoreCase("id") == 0 || strKey.compareToIgnoreCase("name") == 0) {
            return;
        }
        if (this.arrListItem == null) {
            this.arrListItem = new Hashtable();
            this.arrList = new ArrayList();
        }
        this.arrList.remove(strKey);
        this.arrList.add(strKey);
        this.arrListItem.put(strKey, strValue);
    }

    public synchronized String Get(String strKey) {
        if (this.arrListItem == null) {
            return "";
        }
        if (this.arrListItem.containsKey(strKey = strKey.toLowerCase())) {
            return (String)this.arrListItem.get(strKey);
        }
        return "";
    }

    public synchronized void Remove(String strKey) {
        if (this.arrListItem == null) {
            return;
        }
        if (this.arrListItem.containsKey(strKey = strKey.toLowerCase())) {
            this.arrListItem.remove(strKey);
        }
        this.arrList.remove(strKey);
    }

    public synchronized void Clear() {
        if (this.arrListItem == null) {
            return;
        }
        this.arrListItem.clear();
    }

    public synchronized String ToOutputString() {
        if (this.arrListItem == null) {
            return "";
        }
        String strOutput = "";
        int nCount = this.arrList.size();
        int i = 0;
        while (i < nCount) {
            String strKey = (String)this.arrList.get(i);
            if (StringHelper.Length((String)strKey) != 0) {
                String strValue = (String)this.arrListItem.get(strKey);
                if (strOutput.length() != 0) {
                    strOutput = String.valueOf(strOutput) + " ";
                }
                strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"%1$s=\"%2$s\" ", (Object)strKey, (Object)strValue);
            }
            ++i;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strExtAttr)) {
            strOutput = String.valueOf(strOutput) + " ";
            strOutput = String.valueOf(strOutput) + this.strExtAttr;
        }
        return strOutput;
    }

    public void InitFromHashtable(Hashtable hashtable, boolean bReset) {
        if (bReset) {
            this.Clear();
        }
        if (hashtable == null) {
            return;
        }
        Enumeration en = hashtable.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = (String)hashtable.get(strKey);
            this.Set(strKey, strValue);
        }
    }

    public void SetExtAttr(String strExtAttr) {
        this.strExtAttr = strExtAttr;
    }
}

