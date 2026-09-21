/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFGatewayProcessBase;
import SA.SRFDA.PS.Core.WF.PSWFProcessImpl;

@PSModelPFIgnoreMeta
public abstract class PSWFGatewayProcessBaseImpl
extends PSWFProcessImpl
implements IPSWFGatewayProcessBase {
    @Override
    protected int getDefaultWidth() {
        return 40;
    }

    @Override
    protected int getDefaultHeight() {
        return 40;
    }
}

