/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.IconViewConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class IconViewMgr
extends ConfigMgr {
    private final byte[] key;

    public IconViewMgr() {
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
    public IconViewConfig Get(String strMainListId) {
        String strIVConfigPath = this.GetConfigFilePath("iconview" + this.strFolderSeperator + this.GetRealPath(strMainListId) + ".xml");
        File file = new File(strIVConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strIVConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strIVConfigPath))) {
                    return (IconViewConfig)this.fileList.get(strIVConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(IconViewMgr.getContent(strIVConfigPath, this.key));
                } else {
                    parser.parse(strIVConfigPath);
                }
                Document doc = parser.getDocument();
                IconViewConfig iconViewConfig = new IconViewConfig();
                iconViewConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strIVConfigPath, iconViewConfig);
                    this.modifydateList.put(strIVConfigPath, nLastModify);
                }
                return iconViewConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }
}

