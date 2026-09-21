/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.DataEx.DataEntityItemConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class DataEntityConfig
extends CollectionXMLConfig {
    public static final String TAG_DATAENTITY = "SRFEXDATAENTITY";
    public static final String TAG_GLOBALCONFIGID = "GLOBALCONFIGID";
    protected Hashtable<String, DataEntityItemConfig> idMap = new Hashtable();
    protected String strGlobalConfigId = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_GLOBALCONFIGID, (boolean)true) == 0) {
            this.strGlobalConfigId = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAENTITYITEM", (boolean)true) == 0) {
            DataEntityItemConfig dataEntityItemConfig = new DataEntityItemConfig();
            if (dataEntityItemConfig.LoadConfig(xmlNode)) {
                String strKey = dataEntityItemConfig.getID().toUpperCase();
                if (this.idMap.containsKey(dataEntityItemConfig.getID().toUpperCase())) {
                    DataEntityItemConfig existConfig = this.idMap.get(strKey);
                    existConfig.LoadConfig(xmlNode);
                } else {
                    this.arrayList.add(dataEntityItemConfig);
                    this.idMap.put(strKey, dataEntityItemConfig);
                }
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public String getGlobalConfigId() {
        return this.strGlobalConfigId;
    }

    public void setGlobalConfigId(String strGlobalConfigId) {
        this.strGlobalConfigId = strGlobalConfigId;
    }

    public DataEntityItemConfig GetKeyItemConfig() {
        for (DataEntityItemConfig item : this.idMap.values()) {
            if (!item.isKey()) continue;
            return item;
        }
        return null;
    }

    public DataEntityItemConfig GetParentKeyItemConfig() {
        for (DataEntityItemConfig item : this.idMap.values()) {
            if (!item.isParentKey()) continue;
            return item;
        }
        return null;
    }
}

