/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Pub.PSCodePublisherParamImplBase;
import net.ibizsys.paas.util.StringHelper;

public class PSPFCodePublisherParamImpl
extends PSCodePublisherParamImplBase {
    public PSPFCodePublisherParamImpl(IPSModelObject iPSModelObject, String strKey, Object objValue, String strDesc, String strValueInterface) {
        super(iPSModelObject, strKey, objValue, strDesc, strValueInterface);
    }

    @Override
    public String getModelType() {
        return StringHelper.format((String)"%1$s$%2$s", (Object)"PSPFCODEPUBLISHERPARAM", (Object)this.getPSModelObject().getModelType());
    }
}

