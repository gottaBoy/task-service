/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlNavParam;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSControlNavParamImpl
extends PSNavigateParamImpl
implements IPSControlNavParam {
    private IPSControl iPSControl = null;

    public void init(ISRFDAGlobalHelper iDGlobalHelper, IPSControl iPSControl, String strKey, String strValue, String strDesc, boolean bRawValue) throws Exception {
        this.iPSControl = iPSControl;
        super.init(iDGlobalHelper, iPSControl, strKey, strValue, strDesc, bRawValue);
    }

    @Override
    public String getModelType() {
        return "PSCONTROLNAVPARAM";
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    @Override
    public String getModelId() {
        if (this.getPSControl() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSControl().getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

