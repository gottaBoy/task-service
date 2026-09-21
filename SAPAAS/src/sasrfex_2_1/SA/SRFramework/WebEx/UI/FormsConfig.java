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
import SA.SRFramework.WebEx.UI.FormConfig;
import org.w3c.dom.Node;

public class FormsConfig
extends CollectionXMLConfig {
    public static final String TAG_FORMS = "SRFEXFORMS";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFFORM", (boolean)true) == 0) {
            FormConfig formConfig = new FormConfig();
            if (formConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(formConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

