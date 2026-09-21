/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.ER;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.ER.IPSERMap;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSERMapNode
extends IPSModelObject {
    public IPSERMap getPSERMap();

    public IPSDataEntity getPSDataEntity() throws Exception;

    public int getLeftPos();

    public int getTopPos();
}

