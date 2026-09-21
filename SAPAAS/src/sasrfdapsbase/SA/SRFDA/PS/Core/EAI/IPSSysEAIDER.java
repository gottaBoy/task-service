/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDER;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDEObject;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementRE;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSSysEAIDER
extends IPSEAIDER,
IPSSysEAIDEObject {
    public IPSSysEAIElementRE getPSSysEAIElementRE();
}

