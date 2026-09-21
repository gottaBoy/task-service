/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupBottomConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupContentConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupHeaderConfig;
import org.w3c.dom.Node;

public class DGExGroupConfig
extends DGExBaseCellConfig {
    public static final String TAG_SRFEXDGEXGROUP = "SRFEXDGEXGROUP";
    protected DGExGroupHeaderConfig headerConfig = null;
    protected DGExGroupBottomConfig bottomConfig = null;
    protected DGExGroupContentConfig contentConfig = null;

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXGROUPHEADER", (boolean)true) == 0) {
            if (this.headerConfig == null) {
                this.headerConfig = new DGExGroupHeaderConfig();
                this.headerConfig.LoadConfig(xmlNode);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXGROUPCONTENT", (boolean)true) == 0) {
            if (this.contentConfig == null) {
                this.contentConfig = new DGExGroupContentConfig();
                this.contentConfig.LoadConfig(xmlNode);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXGROUPBOTTOM", (boolean)true) == 0) {
            if (this.bottomConfig == null) {
                this.bottomConfig = new DGExGroupBottomConfig();
                this.bottomConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DGExGroupHeaderConfig getGroupHeaderConfig() {
        return this.headerConfig;
    }

    public DGExGroupBottomConfig getGroupBottomConfig() {
        return this.bottomConfig;
    }

    public DGExGroupContentConfig getGroupContentConfig() {
        return this.contentConfig;
    }
}

