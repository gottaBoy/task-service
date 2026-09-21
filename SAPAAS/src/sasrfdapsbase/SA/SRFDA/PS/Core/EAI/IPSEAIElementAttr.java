/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSEAIElementAttr
extends IPSEAIElementObject {
    public static final String ELEMENTATTRTYPE_SIMPLE = "SIMPLE";
    public static final String ELEMENTATTRTYPE_GROUP = "GROUP";

    @Override
    public String getCodeName();

    public String getElementAttrType();

    public boolean isAllowEmpty();

    public String getDefaultValue();

    public String getFixedValue();

    public IPSEAIDataType getPSEAIDataType();

    public IPSEAIElement getRefPSEAIElement();

    public String getAttrTag();

    public String getAttrTag2();
}

