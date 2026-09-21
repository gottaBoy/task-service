/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.EAI.IPSEAIDEObject;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementRE;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSEAIDER
extends IPSModelObject,
IPSEAIDEObject {
    public IPSDERBase getPSDER();

    @Override
    public String getCodeName();

    public IPSEAIElementRE getPSEAIElementRE();

    public String getDERTag();

    public String getDERTag2();
}

