/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Web.UI.DynamicFormConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class DynamicFormMgr
extends ConfigMgr {
    private final byte[] key;

    public DynamicFormMgr() {
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
    public DynamicFormConfig Get(String strDynamicFormId) {
        String strDFConfigPath = this.GetConfigFilePath("dynamicform" + this.strFolderSeperator + this.GetRealPath(strDynamicFormId) + ".xml");
        File file = new File(strDFConfigPath);
        if (file.exists()) {
            long nLastModify = file.lastModified();
            Hashtable hashtable = this.fileList;
            synchronized (hashtable) {
                Long nCurLastModify;
                if (this.fileList.containsKey(strDFConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strDFConfigPath))) {
                    return (DynamicFormConfig)this.fileList.get(strDFConfigPath);
                }
            }
            try {
                DOMParser parser = new DOMParser();
                if (this.bEncrypt) {
                    parser.parse(DynamicFormMgr.getContent(strDFConfigPath, this.key));
                } else {
                    parser.parse(strDFConfigPath);
                }
                Document doc = parser.getDocument();
                DynamicFormConfig dynamicFormConfig = new DynamicFormConfig();
                dynamicFormConfig.LoadConfig(doc.getDocumentElement());
                Hashtable hashtable2 = this.fileList;
                synchronized (hashtable2) {
                    this.fileList.put(strDFConfigPath, dynamicFormConfig);
                    this.modifydateList.put(strDFConfigPath, nLastModify);
                }
                return dynamicFormConfig;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return null;
            }
        }
        return null;
    }
}

