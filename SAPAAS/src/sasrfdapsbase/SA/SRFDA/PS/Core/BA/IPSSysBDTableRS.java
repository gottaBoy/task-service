/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDSchemeObject;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysBDTableRS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysBDTableRS
extends IPSSysBDSchemeObject,
IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysBDScheme var2, PSSysBDTableRS var3) throws Exception;

    public IPSSysBDTable getMajorPSSysBDTable();

    public IPSSysBDTable getMinorPSSysBDTable();

    public IPSDER1N getPSDER1N();

    @Override
    public String getCodeName();

    public String getMinorCodeName();
}

