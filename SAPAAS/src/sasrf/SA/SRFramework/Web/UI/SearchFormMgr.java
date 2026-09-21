/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.SearchFormConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class SearchFormMgr
extends ConfigMgr {
    private final byte[] key;

    public SearchFormMgr() {
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
    public SearchFormConfig Get(String strSearchFormId) {
        String strSFConfigPath = this.GetConfigFilePath("searchform" + this.strFolderSeperator + this.GetRealPath(strSearchFormId) + ".xml");
        File file = new File(strSFConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strSFConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strSFConfigPath))) {
                    return (SearchFormConfig)this.fileList.get(strSFConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(SearchFormMgr.getContent(strSFConfigPath, this.key));
                } else {
                    parser.parse(strSFConfigPath);
                }
                Document doc = parser.getDocument();
                SearchFormConfig searchFormConfig = new SearchFormConfig();
                searchFormConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strSFConfigPath, searchFormConfig);
                    this.modifydateList.put(strSFConfigPath, nLastModify);
                }
                return searchFormConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }
}

