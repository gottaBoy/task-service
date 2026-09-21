/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.WebThemeConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class WebThemeMgr
extends ConfigMgr {
    private final byte[] key;

    public WebThemeMgr() {
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
    public WebThemeConfig Get(String strThemeId) {
        String strWTConfigPath = this.GetConfigFilePath("theme" + this.strFolderSeperator + this.GetRealPath(strThemeId) + ".xml");
        File file = new File(strWTConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strWTConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strWTConfigPath))) {
                    return (WebThemeConfig)this.fileList.get(strWTConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(WebThemeMgr.getContent(strWTConfigPath, this.key));
                } else {
                    parser.parse(strWTConfigPath);
                }
                Document doc = parser.getDocument();
                WebThemeConfig webThemeConfig = new WebThemeConfig();
                webThemeConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strWTConfigPath, webThemeConfig);
                    this.modifydateList.put(strWTConfigPath, nLastModify);
                }
                return webThemeConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return new WebThemeConfig();
            }
        }
        return new WebThemeConfig();
    }
}

