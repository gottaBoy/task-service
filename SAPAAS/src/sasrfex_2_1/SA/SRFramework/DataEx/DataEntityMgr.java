/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.DataEntityConfig;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class DataEntityMgr
extends ConfigMgr {
    private final byte[] key;

    public DataEntityMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataEntityConfig Get(String strDataEntityId) {
        String strDCConfigPath = this.GetConfigFilePath("dataentity" + this.strFolderSeperator + this.GetRealPath(strDataEntityId) + ".xml");
        File file = new File(strDCConfigPath);
        if (file.exists()) {
            XMLConfig baseConfig;
            Document doc;
            DataEntityConfig dataEntityConfig;
            long nLastModify;
            block16: {
                nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strDCConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strDCConfigPath))) {
                        return (DataEntityConfig)((Object)this.fileList.get(strDCConfigPath));
                    }
                }
                try {
                    dataEntityConfig = new DataEntityConfig();
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(DataEntityMgr.getContent((String)strDCConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strDCConfigPath);
                    }
                    doc = parser.getDocument();
                    baseConfig = new XMLConfig();
                    if (baseConfig.LoadConfig((Node)doc.getDocumentElement())) break block16;
                    return null;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                    return null;
                }
            }
            String strGlobalConfigId = baseConfig.GetExtValue("GLOBALCONFIGID", "");
            if (StringHelper.Length((String)strGlobalConfigId) != 0) {
                String strGlobalConfigPath = this.GetConfigFilePath("dataentity" + this.strFolderSeperator + this.GetRealPath(strGlobalConfigId) + ".xml");
                DOMParser parserGlobal = new DOMParser();
                if (this.bEncrypt) {
                    parserGlobal.parse(DataEntityMgr.getContent((String)strGlobalConfigPath, (byte[])this.key));
                } else {
                    parserGlobal.parse(strGlobalConfigPath);
                }
                Document docGlobal = parserGlobal.getDocument();
                dataEntityConfig.LoadConfig(docGlobal.getDocumentElement());
            }
            dataEntityConfig.LoadConfig(doc.getDocumentElement());
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                this.fileList.put(strDCConfigPath, dataEntityConfig);
                this.modifydateList.put(strDCConfigPath, nLastModify);
            }
            return dataEntityConfig;
        }
        return null;
    }
}

