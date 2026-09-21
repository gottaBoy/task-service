/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Localization;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class LocalizationConfig
extends XMLConfig {
    protected ArrayList<XMLConfig> list = new ArrayList();
    protected Hashtable<String, String> hashTable = new Hashtable();

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig xmlConfig = new XMLConfig();
        if (xmlConfig.LoadConfig(xmlNode)) {
            this.list.add(xmlConfig);
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public int GetValue(String strNodeName, String strAttr, int nDefault) {
        String strDefault = StringHelper.Format((String)"%1$s", (Object)nDefault);
        strDefault = this.GetValue(strNodeName, strAttr, strDefault);
        return Integer.parseInt(strDefault);
    }

    public double GetValue(String strNodeName, String strAttr, double fDefault) {
        String strDefault = StringHelper.Format((String)"%1$s", (Object)fDefault);
        strDefault = this.GetValue(strNodeName, strAttr, strDefault);
        return Double.parseDouble(strDefault);
    }

    public boolean GetValue(String strNodeName, String strAttr, boolean bDefault) {
        String strDefault = StringHelper.Format((String)"%1$s", (Object)bDefault);
        strDefault = this.GetValue(strNodeName, strAttr, strDefault);
        return Boolean.parseBoolean(strDefault);
    }

    public String GetValue(String strNodeName, String strAttr, String strDefault) {
        String strKey = StringHelper.Format((String)"%1$s__%2$s", (Object)(strNodeName = strNodeName.toUpperCase()), (Object)(strAttr = strAttr.toUpperCase()));
        if (this.hashTable.containsKey(strKey)) {
            return this.hashTable.get(strKey);
        }
        int nCount = this.list.size();
        int i = 0;
        while (i < nCount) {
            XMLConfig xmlConfig = this.list.get(i);
            if (StringHelper.Compare((String)xmlConfig.getID(), (String)strNodeName, (boolean)true) == 0) {
                strDefault = xmlConfig.GetExtValue(strAttr, strDefault);
                this.hashTable.put(strKey, strDefault);
                return strDefault;
            }
            ++i;
        }
        this.hashTable.put(strKey, strDefault);
        return strDefault;
    }
}

