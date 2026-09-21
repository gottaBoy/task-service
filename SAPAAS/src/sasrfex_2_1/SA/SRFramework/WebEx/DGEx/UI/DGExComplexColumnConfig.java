/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseColumnConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExColumnsConfig;
import org.w3c.dom.Node;

public class DGExComplexColumnConfig
extends DGExBaseColumnConfig {
    public static final String TAG_SRFEXDGEXCOMPLEXCOLUMN = "SRFEXDGEXCOMPLEXCOLUMN";
    public static final String TAG_ISHORIZONTAL = "ISHORIZONTAL";
    protected boolean bHorizontal = true;
    protected DGExColumnsConfig columnsConfig = null;

    protected void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDGEXCOLUMNS", (boolean)true) == 0) {
            if (this.columnsConfig == null) {
                this.columnsConfig = new DGExColumnsConfig();
                this.columnsConfig.LoadConfig(xmlNode);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ISHORIZONTAL, (boolean)true) == 0) {
            this.setHorizontal(DGExComplexColumnConfig.GetValue((String)strValue, (boolean)this.isHorizontal()));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean isHorizontal() {
        return this.bHorizontal;
    }

    public void setHorizontal(boolean bHorizontal) {
        this.bHorizontal = bHorizontal;
    }

    public DGExColumnsConfig getColumnsConfig() {
        return this.columnsConfig;
    }
}

