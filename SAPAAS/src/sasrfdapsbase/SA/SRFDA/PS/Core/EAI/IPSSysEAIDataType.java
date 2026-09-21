/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataTypeItem;
import SA.SRFDA.PS.Core.EAI.IPSSysEAISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysEAIDataType
extends IPSSysEAISchemeObject,
IPSEAIDataType {
    public Iterator<? extends IPSSysEAIDataTypeItem> getAllPSSysEAIDataTypeItems() throws Exception;

    public IPSSysEAIDataTypeItem getPSSysEAIDataTypeItem(String var1) throws Exception;

    public IPSSysEAIDataTypeItem getPSSysEAIDataTypeItem(String var1, boolean var2) throws Exception;
}

