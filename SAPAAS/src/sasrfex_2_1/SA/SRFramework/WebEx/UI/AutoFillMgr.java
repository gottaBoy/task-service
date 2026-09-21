/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.WebEx.UI.AutoFillConfig;
import SA.SRFramework.WebEx.UI.AutoFillsConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class AutoFillMgr
extends ConfigMgr {
    private final byte[] key;

    public AutoFillMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    public AutoFillConfig Get(String strAFMode) {
        AutoFillsConfig configs = this.GetAutoFillsConfig();
        if (configs != null) {
            return configs.getAutoFillConfig(strAFMode);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected AutoFillsConfig GetAutoFillsConfig() {
        block12: {
            String strAutoFillsConfigPath = this.GetConfigFilePath("common" + this.strFolderSeperator + this.GetRealPath("AUTOFILL") + ".xml");
            File file = new File(strAutoFillsConfigPath);
            if (file.exists()) {
                long nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strAutoFillsConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strAutoFillsConfigPath))) {
                        return (AutoFillsConfig)((Object)this.fileList.get(strAutoFillsConfigPath));
                    }
                }
                try {
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(AutoFillMgr.getContent((String)strAutoFillsConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strAutoFillsConfigPath);
                    }
                    Document doc = parser.getDocument();
                    AutoFillsConfig AutoFillsConfig2 = new AutoFillsConfig();
                    if (!AutoFillsConfig2.LoadConfig(doc.getDocumentElement())) break block12;
                    Hashtable hashtable2 = this.fileList;
                    synchronized (hashtable2) {
                        this.fileList.put(strAutoFillsConfigPath, AutoFillsConfig2);
                        this.modifydateList.put(strAutoFillsConfigPath, nLastModify);
                    }
                    return AutoFillsConfig2;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        return new AutoFillsConfig();
    }
}

