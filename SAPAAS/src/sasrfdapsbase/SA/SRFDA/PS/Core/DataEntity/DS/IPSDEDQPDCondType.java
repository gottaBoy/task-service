/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQPDCondition;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDQPDCond;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDEDQPDCondType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDEDQPDCond var2) throws Exception;

    public IPSDEDQPDCondition createPSDEDQPDCondition(PSDEDataQueryCond var1) throws Exception;
}

