/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.WebEx.UI.FormImageLinkConfig;
import SA.SRFramework.WebEx.UI.FormImageLinksConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class FormImageLinkMgr
extends ConfigMgr {
    private final byte[] key;

    public FormImageLinkMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    public FormImageLinkConfig Get(String strFormImageLinkId) {
        FormImageLinksConfig configs = this.GetFormImageLinksConfig();
        if (configs != null) {
            return configs.getFormImageLinkConfig(strFormImageLinkId);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected FormImageLinksConfig GetFormImageLinksConfig() {
        block12: {
            String strFormImageLinksConfigPath = this.GetConfigFilePath("common" + this.strFolderSeperator + this.GetRealPath("FORMIMAGELINK") + ".xml");
            File file = new File(strFormImageLinksConfigPath);
            if (file.exists()) {
                long nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strFormImageLinksConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strFormImageLinksConfigPath))) {
                        return (FormImageLinksConfig)((Object)this.fileList.get(strFormImageLinksConfigPath));
                    }
                }
                try {
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(FormImageLinkMgr.getContent((String)strFormImageLinksConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strFormImageLinksConfigPath);
                    }
                    Document doc = parser.getDocument();
                    FormImageLinksConfig formImageLinksConfig = new FormImageLinksConfig();
                    if (!formImageLinksConfig.LoadConfig(doc.getDocumentElement())) break block12;
                    Hashtable hashtable2 = this.fileList;
                    synchronized (hashtable2) {
                        this.fileList.put(strFormImageLinksConfigPath, formImageLinksConfig);
                        this.modifydateList.put(strFormImageLinksConfigPath, nLastModify);
                    }
                    return formImageLinksConfig;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        return new FormImageLinksConfig();
    }
}

