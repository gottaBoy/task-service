/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.XML;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.ParamConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class ParamsConfig
extends XMLConfig {
    public static final String TAG_PARAMS = "PARAMS";
    protected ArrayList<ParamConfig> list = new ArrayList();
    protected Hashtable<String, String> hashTable = null;
    protected String strParamTagName = "PARAM";

    public ParamsConfig(String strParamTagName) {
        this.strParamTagName = strParamTagName;
    }

    public ParamsConfig() {
    }

    public void EnableIndex() {
        this.hashTable = new Hashtable();
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        ParamConfig xmlConfig;
        if (StringHelper.Compare((String)strName, (String)this.strParamTagName, (boolean)true) == 0 && (xmlConfig = new ParamConfig()).LoadConfig(xmlNode)) {
            this.list.add(xmlConfig);
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public int GetValue(String strSection, String strAttr, int nDefault) {
        String strDefault = StringHelper.Format((String)"%1$s", (Object)nDefault);
        strDefault = this.GetValue(strSection, strAttr, strDefault);
        return Integer.parseInt(strDefault);
    }

    public double GetValue(String strSection, String strAttr, double fDefault) {
        String strDefault = StringHelper.Format((String)"%1$s", (Object)fDefault);
        strDefault = this.GetValue(strSection, strAttr, strDefault);
        return Double.parseDouble(strDefault);
    }

    public boolean GetValue(String strSection, String strAttr, boolean bDefault) {
        String strDefault = StringHelper.Format((String)"%1$s", (Object)bDefault);
        strDefault = this.GetValue(strSection, strAttr, strDefault);
        return Boolean.parseBoolean(strDefault);
    }

    public String GetValue(String strSection, String strAttr, String strDefault) {
        strSection = strSection.toUpperCase();
        strAttr = strAttr.toUpperCase();
        String strKey = StringHelper.Format((String)"%1$s__%2$s", (Object)strSection, (Object)strAttr);
        if (this.hashTable != null && this.hashTable.containsKey(strKey)) {
            return this.hashTable.get(strKey);
        }
        int nCount = this.list.size();
        int i = 0;
        while (i < nCount) {
            XMLConfig xmlConfig = this.list.get(i);
            if (StringHelper.Compare((String)xmlConfig.getID(), (String)strSection, (boolean)true) == 0) {
                strDefault = xmlConfig.GetExtValue(strAttr, strDefault);
                if (this.hashTable != null) {
                    this.hashTable.put(strKey, strDefault);
                }
                return strDefault;
            }
            ++i;
        }
        if (this.hashTable != null) {
            this.hashTable.put(strKey, strDefault);
        }
        return strDefault;
    }

    public void SetValue(String strSection, String strAttr, String strValue) {
        strSection = strSection.toUpperCase();
        strAttr = strAttr.toUpperCase();
        String strKey = StringHelper.Format((String)"%1$s__%2$s", (Object)strSection, (Object)strAttr);
        if (this.hashTable != null) {
            this.hashTable.put(strKey, strValue);
        }
        int nCount = this.list.size();
        int i = 0;
        while (i < nCount) {
            XMLConfig xmlConfig = this.list.get(i);
            if (StringHelper.Compare((String)xmlConfig.getID(), (String)strSection, (boolean)true) == 0) {
                xmlConfig.SetValue(strAttr, strValue);
                return;
            }
            ++i;
        }
        ParamConfig xmlConfig = new ParamConfig();
        xmlConfig.setNodeName(this.strParamTagName);
        xmlConfig.SetValue(strAttr, strValue);
        this.list.add(xmlConfig);
    }

    public ParamConfig FindParamConfig(String strSection) {
        int nCount = this.list.size();
        int i = 0;
        while (i < nCount) {
            ParamConfig xmlConfig = this.list.get(i);
            if (StringHelper.Compare((String)xmlConfig.getID(), (String)strSection, (boolean)true) == 0) {
                return xmlConfig;
            }
            ++i;
        }
        return null;
    }
}

