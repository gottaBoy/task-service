/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDataTypeItem;
import SA.SRFDA.PS.Core.EAI.IPSSysEAISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSEAIDataType
extends IPSSysEAISchemeObject {
    @Override
    public String getCodeName();

    public int getPrecision();

    public int getMaxStringLength();

    public int getMinStringLength();

    public String getMaxValueString();

    public String getMinValueString();

    public String getDataTypeTag();

    public String getDataTypeTag2();

    public String getPattern();

    public boolean isEnableEnum();

    public boolean isIncludeMinValue();

    public boolean isIncludeMaxValue();

    public int getStdDataType();

    public Iterator<? extends IPSEAIDataTypeItem> getAllPSEAIDataTypeItems() throws Exception;

    public IPSEAIDataTypeItem getPSEAIDataTypeItem(String var1) throws Exception;

    public IPSEAIDataTypeItem getPSEAIDataTypeItem(String var1, boolean var2) throws Exception;
}

