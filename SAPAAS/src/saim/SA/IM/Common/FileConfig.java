/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfigEx
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Common;

import SA.SRFramework.Base.XMLConfigEx;
import SA.SRFramework.Utility.StringHelper;

public class FileConfig
extends XMLConfigEx {
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
}

