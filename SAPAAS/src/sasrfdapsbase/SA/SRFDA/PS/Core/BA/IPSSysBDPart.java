/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDSchemeObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSSysBDPart;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysBDPart
extends IPSSysBDSchemeObject,
IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysBDScheme var2, PSSysBDPart var3) throws Exception;

    @Override
    public String getCodeName();
}

