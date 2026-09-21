/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExCellsConfig;
import org.w3c.dom.Node;

public class DGExGroupContentConfig
extends DGExBaseCellConfig {
    public static final String TAG_SRFEXDGEXGROUPCONTENT = "SRFEXDGEXGROUPCONTENT";
    protected DGExCellsConfig cellsConfig = null;

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXCELLS", (boolean)true) == 0) {
            if (this.cellsConfig == null) {
                this.cellsConfig = new DGExCellsConfig();
                this.cellsConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DGExCellsConfig getCellsConfig() {
        return this.cellsConfig;
    }
}

