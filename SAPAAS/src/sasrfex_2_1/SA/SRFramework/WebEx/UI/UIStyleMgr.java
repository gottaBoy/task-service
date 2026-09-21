/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.WebEx.UI.UIStyleConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class UIStyleMgr
extends ConfigMgr {
    private final byte[] key;

    public UIStyleMgr() {
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
    public UIStyleConfig Get(String strUIStyle) {
        block12: {
            String strUIStyleConfigPath = this.GetConfigFilePath("uistyle" + this.strFolderSeperator + this.GetRealPath(strUIStyle) + ".xml");
            File file = new File(strUIStyleConfigPath);
            if (file.exists()) {
                long nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strUIStyleConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strUIStyleConfigPath))) {
                        return (UIStyleConfig)((Object)this.fileList.get(strUIStyleConfigPath));
                    }
                }
                try {
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(UIStyleMgr.getContent((String)strUIStyleConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strUIStyleConfigPath);
                    }
                    Document doc = parser.getDocument();
                    UIStyleConfig uiStyleConfig = new UIStyleConfig();
                    if (!uiStyleConfig.LoadConfig(doc.getDocumentElement())) break block12;
                    Hashtable hashtable2 = this.fileList;
                    synchronized (hashtable2) {
                        this.fileList.put(strUIStyleConfigPath, uiStyleConfig);
                        this.modifydateList.put(strUIStyleConfigPath, nLastModify);
                    }
                    return uiStyleConfig;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                    return new UIStyleConfig();
                }
            }
        }
        return new UIStyleConfig();
    }
}

