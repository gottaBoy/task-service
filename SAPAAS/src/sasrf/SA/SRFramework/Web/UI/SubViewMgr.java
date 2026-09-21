/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.SubViewConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class SubViewMgr
extends ConfigMgr {
    private final byte[] key;

    public SubViewMgr() {
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
    public SubViewConfig Get(String strSubViewId) {
        String strSVConfigPath = this.GetConfigFilePath("subview" + this.strFolderSeperator + this.GetRealPath(strSubViewId) + ".xml");
        File file = new File(strSVConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strSVConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strSVConfigPath))) {
                    return (SubViewConfig)this.fileList.get(strSVConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(SubViewMgr.getContent(strSVConfigPath, this.key));
                } else {
                    parser.parse(strSVConfigPath);
                }
                Document doc = parser.getDocument();
                SubViewConfig dynamicFormConfig = new SubViewConfig();
                dynamicFormConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strSVConfigPath, dynamicFormConfig);
                    this.modifydateList.put(strSVConfigPath, nLastModify);
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

