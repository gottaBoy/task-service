/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewEngineImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Data.PSDEViewEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class PSAppDEViewEngineImpl
extends PSAppDEViewEngineImplBase {
    private String strEngineType = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEView iPSAppDEView, IPSUIEngineType iPSUIEngineType, PSDEViewEngine psDEViewEngine) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSUIEngineType(iPSUIEngineType);
        if (this.getPSUIEngineType() instanceof IPSSubViewType) {
            IPSUIEngineType orginPSUIEngineType;
            IPSSubViewType iPSSubViewType = (IPSSubViewType)((Object)this.getPSUIEngineType());
            this.strEngineType = StringHelper.Compare((String)iPSSubViewType.getNameMode(), (String)"REPLACE", (boolean)true) == 0 ? this.getPSUIEngineType().getTypeCode() : ((orginPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(iPSAppDEView.getViewType(), true)) != null ? StringHelper.Format((String)"%1$s_%2$s", (Object)orginPSUIEngineType.getTypeCode(), (Object)this.getPSUIEngineType().getTypeCode()) : StringHelper.Format((String)"%1$s_%2$s", (Object)iPSAppDEView.getPSViewType().getCodeName(), (Object)this.getPSUIEngineType().getTypeCode()));
        }
        super.init(iDAGlobalHelper, iPSAppDEView, psDEViewEngine);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u64ce\u7c7b\u578b")
    public String getEngineType() {
        if (!StringHelper.IsNullOrEmpty((String)this.strEngineType)) {
            return this.strEngineType;
        }
        return super.getEngineType();
    }
}

