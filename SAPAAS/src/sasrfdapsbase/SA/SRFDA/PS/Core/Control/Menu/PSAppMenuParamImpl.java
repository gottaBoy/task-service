/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuParam;
import SA.SRFDA.PS.Core.Control.PSAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSAppMenuParamImpl
extends PSAjaxControlParamImpl
implements IPSAppMenuParam {
    private String strPSAppMenuId = "";
    private String strAppMenuStyle = "";

    @Override
    public String getPSAppMenuId() {
        return this.strPSAppMenuId;
    }

    public void setPSAppMenuId(String strPSAppMenuId) {
        this.strPSAppMenuId = strPSAppMenuId;
    }

    @Override
    public String getAppMenuStyle() {
        return this.strAppMenuStyle;
    }

    public void setAppMenuStyle(String strAppMenuStyle) {
        this.strAppMenuStyle = strAppMenuStyle;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSAppMenuParam) {
            IPSAppMenuParam iPSAppMenuParam = (IPSAppMenuParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty((String)iPSAppMenuParam.getPSAppMenuId())) {
                this.setPSAppMenuId(iPSAppMenuParam.getPSAppMenuId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSAppMenuParam.getAppMenuStyle())) {
                this.setAppMenuStyle(iPSAppMenuParam.getAppMenuStyle());
            }
        }
    }
}

