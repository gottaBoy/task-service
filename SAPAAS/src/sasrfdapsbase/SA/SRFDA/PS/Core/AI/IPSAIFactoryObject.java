/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.AI;

import SA.SRFDA.PS.Core.AI.IPSAIFactory;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="AI\u5de5\u5382\u6a21\u578b\u76f8\u5173\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAIFactoryObject
extends IPSModelObject {
    public IPSAIFactory getPSAIFactory();
}

