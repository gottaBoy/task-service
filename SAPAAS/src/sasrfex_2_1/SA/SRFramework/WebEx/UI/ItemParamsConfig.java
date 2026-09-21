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
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import org.w3c.dom.Node;

public class ItemParamsConfig
extends CollectionXMLConfig {
    public static final String TAG_SRFEXITEMPARAMS = "SRFEXITEMPARAMS";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXITEMPARAM", (boolean)true) == 0) {
            ItemParamConfig itemParamConfig = new ItemParamConfig();
            if (itemParamConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(itemParamConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

