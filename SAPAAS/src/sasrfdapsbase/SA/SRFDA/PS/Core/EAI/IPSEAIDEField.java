/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.EAI.IPSEAIDEObject;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementAttr;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementRE;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSEAIDEField
extends IPSEAIDEObject,
IPSModelObject {
    public static final String DSTTYPE_ATTRIBUTE = "ATTRIBUTE";
    public static final String DSTTYPE_ELEMENT = "ELEMENT";

    public IPSDEField getPSDEField();

    @Override
    public String getCodeName();

    public IPSEAIElementAttr getPSEAIElementAttr();

    public IPSEAIElementRE getPSEAIElementRE();

    public String getDstType();

    public String getFieldTag();

    public String getFieldTag2();
}

