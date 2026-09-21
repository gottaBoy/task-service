/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(implement="PSModelDataImpl")
public interface IPSModelData
extends IPSModelObject {
    public IPSModelObject getPSModelObject();

    public String getContent();

    public String getModelTag();

    public String getModelTag2();

    public String getLogicName();

    public String getRealModelType();

    public String getRealModelSubType();

    public String getRealModelId();
}

