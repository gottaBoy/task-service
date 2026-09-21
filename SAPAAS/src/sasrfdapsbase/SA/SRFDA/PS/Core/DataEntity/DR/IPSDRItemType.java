/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDRItem;
import SA.SRFDA.PS.Data.PSDRItemType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDRItemType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDRItemType var2) throws Exception;

    public IPSDEDRItem createPSDEDRItem(PSDEDRItem var1) throws Exception;
}

