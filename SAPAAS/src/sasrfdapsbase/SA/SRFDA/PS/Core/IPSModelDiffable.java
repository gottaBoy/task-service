/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelDiffActionContext;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFramework.DataEx.BaseDataEntity;

@PSModelIgnoreMeta
public interface IPSModelDiffable
extends IPSObject {
    public int diff(IPSModelDiffActionContext var1, Object var2) throws Exception;

    public String getModelType();

    public BaseDataEntity getModelData();
}

