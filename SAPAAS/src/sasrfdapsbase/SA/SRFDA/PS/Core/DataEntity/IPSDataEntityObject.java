/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelPFIgnoreMeta
public interface IPSDataEntityObject
extends IPSObject,
IPSModelObject,
IPSDynaInstSupportable {
    @PSModelRTMeta(dump=false)
    public IPSDataEntity getPSDataEntity();

    public int getExtendMode();
}

