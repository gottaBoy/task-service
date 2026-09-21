/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.PageConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class PageConfigMgr
extends ConfigMgr {
    private final byte[] key;

    public PageConfigMgr() {
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
    public PageConfig Get(String strPageId) {
        String strPageConfigPath = this.GetConfigFilePath("page" + this.strFolderSeperator + this.GetRealPath(strPageId) + ".xml");
        File file = new File(strPageConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strPageConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strPageConfigPath))) {
                    return (PageConfig)this.fileList.get(strPageConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(PageConfigMgr.getContent(strPageConfigPath, this.key));
                } else {
                    parser.parse(strPageConfigPath);
                }
                Document doc = parser.getDocument();
                PageConfig dynamicFormConfig = new PageConfig();
                dynamicFormConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strPageConfigPath, dynamicFormConfig);
                    this.modifydateList.put(strPageConfigPath, nLastModify);
                }
                return dynamicFormConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }
}

