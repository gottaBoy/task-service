/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExGroupConfig;
import org.w3c.dom.Node;

public class DGExGroupCellConfig
extends DGExBaseCellConfig {
    public static final String TAG_SRFEXDGEXGROUPCELL = "SRFEXDGEXGROUPCELL";
    public static final String TAG_DATAGROUPID = "DATAGROUPID";
    protected String strDataGroupId = "";
    protected DGExGroupConfig groupConfig = null;

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXGROUP", (boolean)true) == 0) {
            if (this.groupConfig == null) {
                this.groupConfig = new DGExGroupConfig();
                this.groupConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAGROUPID, (boolean)true) == 0) {
            this.setDataGroupId(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public DGExGroupConfig getGroupConfig() {
        return this.groupConfig;
    }

    public String getDataGroupId() {
        return this.strDataGroupId;
    }

    public void setDataGroupId(String strDataGroupId) {
        this.strDataGroupId = strDataGroupId;
    }
}

