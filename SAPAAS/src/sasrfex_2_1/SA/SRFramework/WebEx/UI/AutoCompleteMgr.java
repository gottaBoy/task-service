/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.WebEx.UI.AutoCompleteConfig;
import SA.SRFramework.WebEx.UI.AutoCompletesConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class AutoCompleteMgr
extends ConfigMgr {
    private final byte[] key;

    public AutoCompleteMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    public AutoCompleteConfig Get(String strACMode) {
        AutoCompletesConfig configs = this.GetAutoCompletesConfig();
        if (configs != null) {
            return configs.getAutoCompleteConfig(strACMode);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected AutoCompletesConfig GetAutoCompletesConfig() {
        block12: {
            String strAutoCompletesConfigPath = this.GetConfigFilePath("common" + this.strFolderSeperator + this.GetRealPath("AUTOCOMPLETE") + ".xml");
            File file = new File(strAutoCompletesConfigPath);
            if (file.exists()) {
                long nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strAutoCompletesConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strAutoCompletesConfigPath))) {
                        return (AutoCompletesConfig)((Object)this.fileList.get(strAutoCompletesConfigPath));
                    }
                }
                try {
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(AutoCompleteMgr.getContent((String)strAutoCompletesConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strAutoCompletesConfigPath);
                    }
                    Document doc = parser.getDocument();
                    AutoCompletesConfig autoCompletesConfig = new AutoCompletesConfig();
                    if (!autoCompletesConfig.LoadConfig(doc.getDocumentElement())) break block12;
                    Hashtable hashtable2 = this.fileList;
                    synchronized (hashtable2) {
                        this.fileList.put(strAutoCompletesConfigPath, autoCompletesConfig);
                        this.modifydateList.put(strAutoCompletesConfigPath, nLastModify);
                    }
                    return autoCompletesConfig;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        return new AutoCompletesConfig();
    }
}

