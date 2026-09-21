/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPDataGridConfig;
import SA.SRFramework.WebEx.DP.UI.DPItemConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class DPDataGridItemConfig
extends DPItemConfig {
    public static final String TAG_DPDATAGRIDITEM = "SRFEXDPDATAGRIDITEM";
    public static final String TAG_DATAGRIDID = "DATAGRIDID";
    protected DPDataGridConfig dpDataGridConfig = null;
    protected String strDataGridId = "";

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDPDATAGRID", (boolean)true) == 0) {
            if (this.dpDataGridConfig == null) {
                this.dpDataGridConfig = new DPDataGridConfig();
            }
            this.dpDataGridConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAGRIDID, (boolean)true) == 0) {
            this.setDataGridId(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void GetFormCtrlConfig(ArrayList list) {
        list.add(this);
    }

    public DPDataGridConfig getDPDataGridConfig() {
        return this.dpDataGridConfig;
    }

    public void setDPDataGridConfig(DPDataGridConfig dpDataGridConfig) {
        this.dpDataGridConfig = dpDataGridConfig;
    }

    public String getDataGridId() {
        return this.strDataGridId;
    }

    public void setDataGridId(String strDataGridId) {
        this.strDataGridId = strDataGridId;
    }
}

