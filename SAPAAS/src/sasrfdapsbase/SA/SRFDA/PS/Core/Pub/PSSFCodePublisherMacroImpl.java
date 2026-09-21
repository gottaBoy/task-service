/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Pub.PSCodePublisherMacroImplBase;
import net.ibizsys.paas.util.StringHelper;

public class PSSFCodePublisherMacroImpl
extends PSCodePublisherMacroImplBase {
    public PSSFCodePublisherMacroImpl(IPSModelObject iPSModelObject, String strKey, Object objValue) {
        super(iPSModelObject, strKey, objValue);
    }

    @Override
    public String getModelType() {
        return StringHelper.format((String)"%1$s$%2$s", (Object)"PSSFCODEPUBLISHERMACRO", (Object)this.getPSModelObject().getModelType());
    }
}

