/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.DBOPBaseProcessConfig;
import SA.SRFDA.EAI.Model.DBOPDicisionConfig;
import SA.SRFDA.EAI.Model.DBOPEndConfig;
import SA.SRFDA.EAI.Model.DBOPProcessConfig;
import SA.SRFDA.EAI.Model.DBOPStartConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DBOPProcessesConfig
extends XMLCollectionExConfig<DBOPBaseProcessConfig> {
    public static final String TAG_SRFDBOPPROCS = "SRFDBOPPROCS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    private DBOPStartConfig startProcessConfig = null;
    private Hashtable<String, DBOPBaseProcessConfig> processConfigMap = new Hashtable();

    static {
        childNodeMap.put("SRFDBOPPROC", DBOPProcessConfig.class.getName());
        childNodeMap.put("SRFDBOPDECISION", DBOPDicisionConfig.class.getName());
        childNodeMap.put("SRFDBOPEND", DBOPEndConfig.class.getName());
        childNodeMap.put(DBOPStartConfig.TAG_SRFDBOPSTART, DBOPStartConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (childNodeMap.containsKey(strName)) {
            XMLConfig childNode;
            String strObject = childNodeMap.get(strName);
            if (!StringHelper.IsNullOrEmpty((String)strObject) && (childNode = DBOPProcessesConfig.CreateChildNode((String)strObject)) != null) {
                childNode.LoadConfig(xmlNode);
                this.arr.add((DBOPBaseProcessConfig)childNode);
            }
            String.format("", "");
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DBOPBaseProcessConfig FindProcessConfig(String strProcessId) {
        return this.processConfigMap.get(strProcessId);
    }

    public DBOPStartConfig GetStartProcessConfig() {
        return this.startProcessConfig;
    }

    protected boolean OnLoadConfig() {
        boolean bRet = super.OnLoadConfig();
        if (!bRet) {
            return bRet;
        }
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            DBOPBaseProcessConfig processConfig = (DBOPBaseProcessConfig)((Object)iterator.next());
            if (processConfig instanceof DBOPStartConfig) {
                this.startProcessConfig = (DBOPStartConfig)processConfig;
                continue;
            }
            this.processConfigMap.put(processConfig.getID(), processConfig);
        }
        return true;
    }
}

