/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.FormItemErrorConfig;
import org.w3c.dom.Node;

public class FormItemErrorsConfig
extends CollectionXMLConfig {
    public static final String TAG_FORMITEMERRORS = "SRFEXFORMITEMERRORS";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXFORMITEMERROR", (boolean)true) == 0) {
            FormItemErrorConfig formItemErrorConfig = new FormItemErrorConfig();
            if (formItemErrorConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(formItemErrorConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public FormItemErrorConfig FindError(int nErrorType) {
        switch (nErrorType) {
            case 1: {
                return this.FindError("EMPTY");
            }
            case 2: {
                return this.FindError("DATATYPE");
            }
        }
        return null;
    }

    public FormItemErrorConfig FindError(String strErrorType) {
        int nCount = this.arrayList.size();
        int i = 0;
        while (i < nCount) {
            FormItemErrorConfig formItemErrorConfig = (FormItemErrorConfig)((Object)this.arrayList.get(i));
            if (StringHelper.Compare((String)formItemErrorConfig.getID(), (String)strErrorType, (boolean)true) == 0) {
                return formItemErrorConfig;
            }
            ++i;
        }
        return null;
    }
}

