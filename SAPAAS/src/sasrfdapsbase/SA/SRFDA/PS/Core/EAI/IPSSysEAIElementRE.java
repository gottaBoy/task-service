/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIElementRE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSSysEAIElementRE
extends IPSEAIElementRE {
    public IPSSysEAIDataType getPSSysEAIDataType();

    public IPSSysEAIElement getRefPSSysEAIElement();
}

