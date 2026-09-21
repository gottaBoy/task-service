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
import SA.SRFramework.WebEx.UI.ShortcutBarConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class ShortcutBarMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(ShortcutBarMgr.class);
    private final byte[] key;

    public ShortcutBarMgr() {
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
    protected Document GetDocument(String strShortcutBarId) {
        String strConfigPath = this.GetConfigFilePath("shortcutbar" + this.strFolderSeperator + this.GetRealPath(strShortcutBarId) + ".xml");
        File file = new File(strConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strConfigPath))) {
                    Document doc = (Document)this.fileList.get(strConfigPath);
                    return doc;
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(ShortcutBarMgr.getContent((String)strConfigPath, (byte[])this.key));
                } else {
                    parser.parse(strConfigPath);
                }
                Document doc = parser.getDocument();
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strConfigPath, doc);
                    this.modifydateList.put(strConfigPath, nLastModify);
                }
                return doc;
            }
            catch (Exception ex) {
                log.error((Object)"\u52a0\u8f7d\u5feb\u6377\u680f\u914d\u7f6e\u6587\u4ef6\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
                return null;
            }
        }
        log.error((Object)StringHelper.Format((String)"\u5feb\u6377\u680f\u914d\u7f6e\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)strConfigPath));
        return null;
    }

    public ShortcutBarConfig GetShortcutBarConfig(String strShortcutBarId) {
        Document doc = this.GetDocument(strShortcutBarId);
        if (doc == null) {
            return null;
        }
        try {
            ShortcutBarConfig shortcutBarConfig = new ShortcutBarConfig();
            if (shortcutBarConfig.LoadConfig(doc.getDocumentElement())) {
                return shortcutBarConfig;
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)"\u52a0\u8f7d\u5feb\u6377\u680f\u914d\u7f6e\u6570\u636e\u51fa\u73b0\u9519\u8bef", (Throwable)ex);
            return null;
        }
    }
}

