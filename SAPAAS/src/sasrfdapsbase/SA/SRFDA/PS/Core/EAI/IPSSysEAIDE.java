/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDEField;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDER;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysEAIDE
extends IPSEAIDE,
IPSSysEAISchemeObject {
    public IPSSysEAIElement getPSSysEAIElement();

    public Iterator<? extends IPSSysEAIDEField> getAllPSSysEAIDEFields() throws Exception;

    public IPSSysEAIDEField getPSSysEAIDEField(String var1) throws Exception;

    public IPSSysEAIDEField getPSSysEAIDEField(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysEAIDER> getAllPSSysEAIDERs() throws Exception;

    public IPSSysEAIDER getPSSysEAIDER(String var1) throws Exception;

    public IPSSysEAIDER getPSSysEAIDER(String var1, boolean var2) throws Exception;
}

