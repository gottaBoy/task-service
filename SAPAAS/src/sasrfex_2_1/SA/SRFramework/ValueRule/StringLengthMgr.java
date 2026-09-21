/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.ValueRule.StringLengthsConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class StringLengthMgr
extends ConfigMgr {
    private final byte[] key;

    public StringLengthMgr() {
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
    public StringLengthsConfig GetStringLengthsConfig() {
        block12: {
            String strStringLengthsConfigPath = this.GetConfigFilePath("common" + this.strFolderSeperator + this.GetRealPath("STRINGLENGTH") + ".xml");
            File file = new File(strStringLengthsConfigPath);
            if (file.exists()) {
                long nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strStringLengthsConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strStringLengthsConfigPath))) {
                        return (StringLengthsConfig)((Object)this.fileList.get(strStringLengthsConfigPath));
                    }
                }
                try {
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(StringLengthMgr.getContent((String)strStringLengthsConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strStringLengthsConfigPath);
                    }
                    Document doc = parser.getDocument();
                    StringLengthsConfig stringLengthsConfig = new StringLengthsConfig();
                    if (!stringLengthsConfig.LoadConfig(doc.getDocumentElement())) break block12;
                    Hashtable hashtable2 = this.fileList;
                    synchronized (hashtable2) {
                        this.fileList.put(strStringLengthsConfigPath, stringLengthsConfig);
                        this.modifydateList.put(strStringLengthsConfigPath, nLastModify);
                    }
                    return stringLengthsConfig;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        return new StringLengthsConfig();
    }
}

