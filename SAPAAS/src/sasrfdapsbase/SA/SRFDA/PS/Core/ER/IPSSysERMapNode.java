/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.ER;

import SA.SRFDA.PS.Core.ER.IPSERMapNode;
import SA.SRFDA.PS.Core.ER.IPSSysERMap;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysERMapNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysERMapNode
extends IPSERMapNode,
IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysERMap var2, PSSysERMapNode var3) throws Exception;

    public IPSSysERMap getPSSysERMap();
}

