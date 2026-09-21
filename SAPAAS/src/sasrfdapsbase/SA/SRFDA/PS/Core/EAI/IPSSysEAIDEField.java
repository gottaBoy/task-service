/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDEField;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDEObject;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementAttr;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementRE;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSSysEAIDEField
extends IPSEAIDEField,
IPSSysEAIDEObject {
    public IPSSysEAIElementAttr getPSSysEAIElementAttr();

    public IPSSysEAIElementRE getPSSysEAIElementRE();
}

