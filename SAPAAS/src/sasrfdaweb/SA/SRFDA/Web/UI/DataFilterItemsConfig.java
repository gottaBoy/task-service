/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.UI;

import SA.SRFDA.Web.UI.DataFilterItemConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DataFilterItemsConfig
extends XMLCollectionExConfig<DataFilterItemConfig> {
    public static final String TAG_DATAFILTERITEMS = "DATAFILTERITEMS";

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)"DATAFILTERITEM", (String)strName, (boolean)true) == 0) {
            DataFilterItemConfig dataFilterItemConfig = new DataFilterItemConfig();
            dataFilterItemConfig.LoadConfig(xmlNode);
            this.add((Object)dataFilterItemConfig);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

