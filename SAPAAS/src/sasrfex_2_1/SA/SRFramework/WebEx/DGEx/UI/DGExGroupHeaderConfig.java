/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExColumnsConfig;
import org.w3c.dom.Node;

public class DGExGroupHeaderConfig
extends DGExBaseCellConfig {
    public static final String TAG_SRFEXDGEXGROUPHEADER = "SRFEXDGEXGROUPHEADER";
    protected DGExColumnsConfig dgExColumnsConfig = null;

    public DGExColumnsConfig getColumnsConfig() {
        return this.dgExColumnsConfig;
    }

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)"SRFEXDGEXCOLUMNS", (String)strName, (boolean)true) == 0) {
            if (this.dgExColumnsConfig == null) {
                this.dgExColumnsConfig = new DGExColumnsConfig();
                this.dgExColumnsConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

