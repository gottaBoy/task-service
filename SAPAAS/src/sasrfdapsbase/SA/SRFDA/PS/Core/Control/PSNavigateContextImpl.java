/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSNavigateContextImpl
extends PSNavigateParamImpl
implements IPSNavigateContext {
    @Override
    public String getModelType() {
        return StringHelper.format((String)"%1$s$%2$s", (Object)"PSNAVIGATECONTEXT", (Object)this.getPSModelObject().getModelType());
    }
}

