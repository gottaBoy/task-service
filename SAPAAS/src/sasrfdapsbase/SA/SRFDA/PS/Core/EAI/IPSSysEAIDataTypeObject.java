/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDataTypeObject;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSSysEAIDataTypeObject
extends IPSEAIDataTypeObject,
IPSSysEAISchemeObject {
    public IPSSysEAIDataType getPSSysEAIDataType();
}

