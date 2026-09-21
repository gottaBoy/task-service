/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.MainListConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class MainListMgr
extends ConfigMgr {
    private final byte[] key;

    public MainListMgr() {
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
    public MainListConfig Get(String strMainListId) {
        String strMLConfigPath = this.GetConfigFilePath("mainlist" + this.strFolderSeperator + this.GetRealPath(strMainListId) + ".xml");
        File file = new File(strMLConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strMLConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strMLConfigPath))) {
                    return (MainListConfig)this.fileList.get(strMLConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(MainListMgr.getContent(strMLConfigPath, this.key));
                } else {
                    parser.parse(strMLConfigPath);
                }
                Document doc = parser.getDocument();
                MainListConfig mainListConfig = new MainListConfig();
                mainListConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strMLConfigPath, mainListConfig);
                    this.modifydateList.put(strMLConfigPath, nLastModify);
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

