/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.WebEx.UI.PickerDialogConfig;
import SA.SRFramework.WebEx.UI.PickerDialogsConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class PickerDialogMgr
extends ConfigMgr {
    private final byte[] key;

    public PickerDialogMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    public PickerDialogConfig Get(String strPickerDialogId) {
        PickerDialogsConfig configs = this.GetPickerDialogsConfig();
        if (configs != null) {
            return configs.getPickerDialogConfig(strPickerDialogId);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected PickerDialogsConfig GetPickerDialogsConfig() {
        block12: {
            String strPickerDialogsConfigPath = this.GetConfigFilePath("common" + this.strFolderSeperator + this.GetRealPath("PICKERDIALOG") + ".xml");
            File file = new File(strPickerDialogsConfigPath);
            if (file.exists()) {
                long nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strPickerDialogsConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strPickerDialogsConfigPath))) {
                        return (PickerDialogsConfig)((Object)this.fileList.get(strPickerDialogsConfigPath));
                    }
                }
                try {
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(PickerDialogMgr.getContent((String)strPickerDialogsConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strPickerDialogsConfigPath);
                    }
                    Document doc = parser.getDocument();
                    PickerDialogsConfig pickerDialogsConfig = new PickerDialogsConfig();
                    if (!pickerDialogsConfig.LoadConfig(doc.getDocumentElement())) break block12;
                    Hashtable hashtable2 = this.fileList;
                    synchronized (hashtable2) {
                        this.fileList.put(strPickerDialogsConfigPath, pickerDialogsConfig);
                        this.modifydateList.put(strPickerDialogsConfigPath, nLastModify);
                    }
                    return pickerDialogsConfig;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        return new PickerDialogsConfig();
    }
}

