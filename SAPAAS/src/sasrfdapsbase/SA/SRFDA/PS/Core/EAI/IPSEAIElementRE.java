/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSEAIElementRE
extends IPSEAIElementObject {
    public static final String ELEMENTRETYPE_SIMPLE = "SIMPLE";
    public static final String ELEMENTRETYPE_COMPLEX = "COMPLEX";
    public static final String ELEMENTRETYPE_GROUP = "GROUP";

    @Override
    public String getCodeName();

    public String getElementREType();

    public boolean isAllowEmpty();

    public String getDefaultValue();

    public String getFixedValue();

    public IPSEAIDataType getPSEAIDataType();

    public IPSEAIElement getRefPSEAIElement();

    public String getRETag();

    public String getRETag2();

    public int getMaxOccurs();

    public int getMinOccurs();
}

