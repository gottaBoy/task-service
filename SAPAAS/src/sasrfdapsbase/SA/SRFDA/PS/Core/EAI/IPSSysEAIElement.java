/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementAttr;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementRE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysEAIElement
extends IPSSysEAISchemeObject,
IPSEAIElement {
    public Iterator<? extends IPSSysEAIElementAttr> getAllPSSysEAIElementAttrs() throws Exception;

    public IPSSysEAIElementAttr getPSSysEAIElementAttr(String var1) throws Exception;

    public IPSSysEAIElementAttr getPSSysEAIElementAttr(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysEAIElementRE> getAllPSSysEAIElementREs() throws Exception;

    public IPSSysEAIElementRE getPSSysEAIElementRE(String var1) throws Exception;

    public IPSSysEAIElementRE getPSSysEAIElementRE(String var1, boolean var2) throws Exception;
}

