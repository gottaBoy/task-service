/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.DP.UI.DPFormItemConfig
 */
package SA.SRFDA.Web.UI;

import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPFormItemConfig;
import org.w3c.dom.Node;

public class DataFilterItemCtrlsConfig
extends XMLCollectionExConfig<DPFormItemConfig> {
    public static final String TAG_DATAFILTERITEMCTRLS = "DATAFILTERITEMCTRLS";

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)"SRFEXDPFORMITEM", (String)strName, (boolean)true) == 0) {
            DPFormItemConfig dpFormItemConfig = new DPFormItemConfig();
            dpFormItemConfig.LoadConfig(xmlNode);
            this.add(dpFormItemConfig);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

