/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPanelParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelRTIgnoreMeta
public class PSTabExpPanelParamImpl
extends PSControlParamImpl
implements IPSTabExpPanelParam {
    private String strTabLayout = "";

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        IPSTabExpPanelParam iPSTabExpPanelParam;
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSTabExpPanelParam && !StringHelper.isNullOrEmpty((String)(iPSTabExpPanelParam = (IPSTabExpPanelParam)iPSControlParam).getTabLayout())) {
            this.setTabLayout(iPSTabExpPanelParam.getTabLayout());
        }
    }

    @Override
    public String getTabLayout() {
        return this.strTabLayout;
    }

    public void setTabLayout(String strTabLayout) {
        this.strTabLayout = strTabLayout;
    }
}

