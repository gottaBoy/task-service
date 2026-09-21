/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.MenuExConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class MenuExMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(MenuExMgr.class);
    private final byte[] key;

    public MenuExMgr() {
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
    protected Document GetDocument(String strMenuExId) {
        String strMenuConfigPath = this.GetConfigFilePath("menuex" + this.strFolderSeperator + this.GetRealPath(strMenuExId) + ".xml");
        File file = new File(strMenuConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strMenuConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strMenuConfigPath))) {
                    Document doc = (Document)this.fileList.get(strMenuConfigPath);
                    return doc;
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(MenuExMgr.getContent((String)strMenuConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strMenuConfigPath);
                }
                Document doc = parser.getDocument();
                this.fileList.put(strMenuConfigPath, doc);
                this.modifydateList.put(strMenuConfigPath, nLastModify);
                return doc;
            }
            catch (Exception ex) {
                log.error((Object)"\u52a0\u8f7d\u83dc\u5355\u914d\u7f6e\u6587\u4ef6\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
                return null;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u83dc\u5355\u914d\u7f6e\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)strMenuConfigPath));
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MenuExConfig GetMenuExConfig(String strMenuExId) {
        Document doc = this.GetDocument(strMenuExId);
        if (doc == null) {
            return null;
        }
        try {
            Document document = doc;
            synchronized (document) {
                MenuExConfig menuExConfig = new MenuExConfig();
                if (menuExConfig.LoadConfig(doc.getDocumentElement())) {
                    menuExConfig.setConfigId(strMenuExId);
                    return menuExConfig;
                }
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u83dc\u5355\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }
}

