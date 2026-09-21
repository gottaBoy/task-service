/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExDataGroupFetchConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExDataGroupsConfig;
import org.w3c.dom.Node;

public class DGExDataGroupConfig
extends XMLConfig {
    public static final String TAG_SRFEXDGEXDATAGROUP = "SRFEXDGEXDATAGROUP";
    protected DGExDataGroupsConfig dataGroupsConfig = null;
    protected DGExDataGroupFetchConfig dataGroupFetchConfig = null;

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXDATAGROUPFETCH", (boolean)true) == 0) {
            if (this.dataGroupFetchConfig == null) {
                this.dataGroupFetchConfig = new DGExDataGroupFetchConfig();
                this.dataGroupFetchConfig.LoadConfig(xmlNode);
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXDATAGROUPS", (boolean)true) == 0) {
            if (this.dataGroupsConfig == null) {
                this.dataGroupsConfig = new DGExDataGroupsConfig();
                this.dataGroupsConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DGExDataGroupsConfig getDataGroupsConfig() {
        return this.dataGroupsConfig;
    }

    public DGExDataGroupFetchConfig getDataGroupFetchConfig() {
        return this.dataGroupFetchConfig;
    }

    public DGExDataGroupConfig FindDataGroup(String strDataGroupId) {
        if (StringHelper.IsNullOrEmpty((String)strDataGroupId)) {
            return this;
        }
        DGExDataGroupConfig activeDataGroupConfig = this;
        String[] dataGroupIds = strDataGroupId.split("[.]");
        int i = 0;
        while (i < dataGroupIds.length) {
            if (activeDataGroupConfig.getDataGroupsConfig() == null) {
                return null;
            }
            if ((activeDataGroupConfig = (DGExDataGroupConfig)((Object)activeDataGroupConfig.getDataGroupsConfig().findById(dataGroupIds[i]))) == null) {
                return null;
            }
            ++i;
        }
        return activeDataGroupConfig;
    }
}

