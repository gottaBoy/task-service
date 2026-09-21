/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class FileItemConfig
extends XMLConfig {
    public static final String TAG_FILEID = "FILEID";
    public static final String TAG_FILENAME = "FILENAME";
    public String strFileId = "";
    public String strFileName = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_FILEID, (boolean)true) == 0) {
            this.strFileId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FILENAME, (boolean)true) == 0) {
            this.strFileName = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getFileId() {
        return this.strFileId;
    }

    public void setFileId(String strFileId) {
        this.strFileId = strFileId;
    }

    public String getFileName() {
        return this.strFileName;
    }

    public void setFileName(String strFileName) {
        this.strFileName = strFileName;
    }
}

