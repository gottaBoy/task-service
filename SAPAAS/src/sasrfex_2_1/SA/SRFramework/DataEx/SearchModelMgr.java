/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.DataEx.SearchModelConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class SearchModelMgr
extends ConfigMgr {
    private final byte[] key;

    public SearchModelMgr() {
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
    public SearchModelConfig Get(String strSearchModelId) {
        String strDCConfigPath = this.GetConfigFilePath("searchmodel" + this.strFolderSeperator + this.GetRealPath(strSearchModelId) + ".xml");
        File file = new File(strDCConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strDCConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strDCConfigPath))) {
                    return (SearchModelConfig)((Object)this.fileList.get(strDCConfigPath));
                }
            }
            try {
                SearchModelConfig searchModelConfig = new SearchModelConfig();
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(SearchModelMgr.getContent((String)strDCConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strDCConfigPath);
                }
                Document doc = parser.getDocument();
                searchModelConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strDCConfigPath, searchModelConfig);
                    this.modifydateList.put(strDCConfigPath, nLastModify);
                }
                return searchModelConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }
}

