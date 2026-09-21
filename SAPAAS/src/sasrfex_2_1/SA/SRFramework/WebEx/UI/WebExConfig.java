/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class WebExConfig
extends XMLConfig {
    protected ArrayList<WebExConfig> list = new ArrayList();
    protected Hashtable<String, String> hashTable = new Hashtable();

    public void OnLoadNode(String strName, Node xmlNode) {
        WebExConfig xmlConfig = new WebExConfig();
        if (xmlConfig.LoadConfig(xmlNode)) {
            this.list.add(xmlConfig);
        }
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
        return this.GetValue(strNodeName, strAttr, strDefault, true);
    }

    public String GetValue(String strNodeName, String strAttr, String strDefault, boolean bCache) {
        String strKey = StringHelper.Format((String)"%1$s__%2$s", (Object)(strNodeName = strNodeName.toUpperCase()), (Object)(strAttr = strAttr.toUpperCase()));
        if (this.hashTable.containsKey(strKey) && bCache) {
            return this.hashTable.get(strKey);
        }
        String[] parts = strNodeName.split("[.]");
        if (parts.length == 0) {
            return strDefault;
        }
        int nCount = this.list.size();
        int i = 0;
        while (i < nCount) {
            WebExConfig xmlConfig = this.list.get(i);
            if (StringHelper.Compare((String)xmlConfig.getID(), (String)parts[0], (boolean)true) == 0) {
                if (parts.length == 1) {
                    strDefault = xmlConfig.GetExtValue(strAttr, strDefault);
                } else {
                    String strNewNodeName = "";
                    int j = 1;
                    while (j < parts.length) {
                        if (j != 1) {
                            strNewNodeName = String.valueOf(strNewNodeName) + ".";
                        }
                        strNewNodeName = String.valueOf(strNewNodeName) + parts[j];
                        ++j;
                    }
                    strDefault = xmlConfig.GetValue(strNewNodeName, strAttr, strDefault, false);
                }
                if (bCache) {
                    this.hashTable.put(strKey, strDefault);
                }
                return strDefault;
            }
            ++i;
        }
        if (bCache) {
            this.hashTable.put(strKey, strDefault);
        }
        return strDefault;
    }

    public static WebExConfig LoadFromFile(String strConfigPath) {
        try {
            DOMParser parser = new DOMParser();
            parser.parse(strConfigPath);
            Document doc = parser.getDocument();
            WebExConfig webExConfig = new WebExConfig();
            webExConfig.LoadConfig(doc.getDocumentElement());
            return webExConfig;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }
}

