/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.TipsConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class TipsMgr
extends ConfigMgr {
    private final byte[] key;

    public TipsMgr() {
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
    public TipsConfig Get(String strLanguage) {
        String strTipsConfigPath = this.GetConfigFilePath("tips" + this.strFolderSeperator + "tips_" + strLanguage + ".xml");
        File file = new File(strTipsConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strTipsConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strTipsConfigPath))) {
                    return (TipsConfig)this.fileList.get(strTipsConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(TipsMgr.getContent(strTipsConfigPath, this.key));
                } else {
                    parser.parse(strTipsConfigPath);
                }
                Document doc = parser.getDocument();
                TipsConfig tipsConfig = new TipsConfig();
                tipsConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strTipsConfigPath, tipsConfig);
                    this.modifydateList.put(strTipsConfigPath, nLastModify);
                }
                return tipsConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }
}

