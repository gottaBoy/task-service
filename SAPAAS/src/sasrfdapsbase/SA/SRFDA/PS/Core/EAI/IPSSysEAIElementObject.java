/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIElementObject;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSSysEAIElementObject
extends IPSEAIElementObject,
IPSSysEAISchemeObject {
    public IPSSysEAIElement getPSSysEAIElement();
}

