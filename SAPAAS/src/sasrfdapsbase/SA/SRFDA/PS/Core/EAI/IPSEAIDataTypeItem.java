/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDataType;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSEAIDataTypeItem
extends IPSModelObject {
    public IPSEAIDataType getPSEAIDataType();

    public String getValue();

    public String getData();

    public String getItemTag();

    public String getItemTag2();
}

