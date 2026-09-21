/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.SubListConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class SubListMgr
extends ConfigMgr {
    private final byte[] key;

    public SubListMgr() {
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
    public SubListConfig Get(String strSubListId) {
        String strSLConfigPath = this.GetConfigFilePath("sublist" + this.strFolderSeperator + this.GetRealPath(strSubListId) + ".xml");
        File file = new File(strSLConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strSLConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strSLConfigPath))) {
                    return (SubListConfig)this.fileList.get(strSLConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(SubListMgr.getContent(strSLConfigPath, this.key));
                } else {
                    parser.parse(strSLConfigPath);
                }
                Document doc = parser.getDocument();
                SubListConfig mainListConfig = new SubListConfig();
                mainListConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strSLConfigPath, mainListConfig);
                    this.modifydateList.put(strSLConfigPath, nLastModify);
                }
                return mainListConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }
}

