/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Data;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Data.DBCallerConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class DBCallConfigMgr
extends ConfigMgr {
    private final byte[] key;
    protected boolean bUseProcName2;
    protected boolean bUseProcName3;
    protected boolean bUseProcName4;

    public DBCallConfigMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
        this.bUseProcName2 = false;
        this.bUseProcName3 = false;
        this.bUseProcName4 = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DBCallerConfig Get(String strDBCall) {
        String strDCConfigPath = this.GetConfigFilePath("dbcall" + this.strFolderSeperator + this.GetRealPath(strDBCall) + ".xml");
        File file = new File(strDCConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strDCConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strDCConfigPath))) {
                    return (DBCallerConfig)this.fileList.get(strDCConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DBCallConfigMgr.getContent(strDCConfigPath, this.key));
                } else {
                    parser.parse(strDCConfigPath);
                }
                Document doc = parser.getDocument();
                DBCallerConfig dbCallerConfig = new DBCallerConfig();
                dbCallerConfig.LoadConfig(doc.getDocumentElement());
                dbCallerConfig.setUseProcName2(this.bUseProcName2);
                dbCallerConfig.setUseProcName3(this.bUseProcName3);
                dbCallerConfig.setUseProcName4(this.bUseProcName4);
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strDCConfigPath, dbCallerConfig);
                    this.modifydateList.put(strDCConfigPath, nLastModify);
                }
                return dbCallerConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }

    public void setUseProcName2(boolean bUseProcName2) {
        this.bUseProcName2 = bUseProcName2;
    }

    public void setUseProcName3(boolean bUseProcName3) {
        this.bUseProcName3 = bUseProcName3;
    }

    public void setUseProcName4(boolean bUseProcName4) {
        this.bUseProcName4 = bUseProcName4;
    }
}

