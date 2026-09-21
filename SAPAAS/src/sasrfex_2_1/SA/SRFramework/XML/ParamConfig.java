/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 */
package SA.SRFramework.XML;

import SA.SRFramework.Base.XMLConfig;
import java.util.Enumeration;

public class ParamConfig
extends XMLConfig {
    public static final String TAG_PARAM = "PARAM";

    public void CopyTo(XMLConfig xmlConfig) {
        if (this.extAttrList == null) {
            return;
        }
        Enumeration en = this.extAttrList.keys();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = (String)this.extAttrList.get(strKey);
            xmlConfig.SetProperty(strKey, strValue);
        }
    }
}

