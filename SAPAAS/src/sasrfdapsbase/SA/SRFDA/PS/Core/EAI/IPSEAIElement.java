/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.EAI.IPSEAIElementAttr;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementRE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSEAIElement
extends IPSSysEAISchemeObject {
    public static final String EAIELEMENTTYPE_COMPLEX = "COMPLEX";
    public static final String EAIELEMENTTYPE_ELEMENTGROUP = "ELEMENTGROUP";
    public static final String EAIELEMENTTYPE_ATTRIBUTEGROUP = "ATTRIBUTEGROUP";
    public static final String ORDERMODE_ALL = "ALL";
    public static final String ORDERMODE_CHOICE = "CHOICE";
    public static final String ORDERMODE_SEQUENCE = "SEQUENCE";

    @Override
    public String getCodeName();

    public String getElementType();

    public String getOrderMode();

    public String getElementTag();

    public String getElementTag2();

    public Iterator<? extends IPSEAIElementAttr> getAllPSEAIElementAttrs() throws Exception;

    public IPSEAIElementAttr getPSEAIElementAttr(String var1) throws Exception;

    public IPSEAIElementAttr getPSEAIElementAttr(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSEAIElementRE> getAllPSEAIElementREs() throws Exception;

    public IPSEAIElementRE getPSEAIElementRE(String var1) throws Exception;

    public IPSEAIElementRE getPSEAIElementRE(String var1, boolean var2) throws Exception;
}

