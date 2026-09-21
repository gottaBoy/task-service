/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.DataEntity.Priv.IPSSysDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.PSDEOPPrivImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public class PSSysDEOPPrivImpl
extends PSDEOPPrivImpl
implements IPSSysDEOPPriv {
    @Override
    public String getModelType() {
        return "PSSYSDEOPPRIV";
    }

    @Override
    public String getModelId() {
        return this.getId();
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getName();
    }

    @Override
    protected String onGetRTMOSFileName() {
        return this.getName();
    }

    @Override
    public String getDumpModelType() {
        return "PSDEOPPRIV";
    }

    @Override
    public String getMOSModelType() {
        return "PSDEOPPRIV";
    }
}

