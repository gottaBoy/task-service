/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.WebEx.UI.BaseControlConfig
 */
package SA.SRFDA.Web.UI;

import SA.SRFDA.Web.UI.DataFilterItemsConfig;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import org.w3c.dom.Node;

public class DataFilterConfig
extends BaseControlConfig {
    public static final String TAG_DATAFILTER = "SRFDADATAFILTER";
    protected DataFilterItemsConfig dataFilterItemsConfig = null;

    protected void OnLoadNode(String strName, Node xmlNode) {
        super.OnLoadNode(strName, xmlNode);
    }
}

