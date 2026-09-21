/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSourceNode;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEDFPredefinedSourceNode
extends IPSDEDataFlowSourceNode {
    public static final String SUBTYPE_SESSION = "SESSION";
    public static final String SUBTYPE_DATACONTEXT = "DATACONTEXT";
    public static final String SUBTYPE_ENVPARAM = "ENVPARAM";

    public String getPredefinedType();
}

