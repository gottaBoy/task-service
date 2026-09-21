/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSPFPluginType;
import SA.SRFDA.PS.Data.PSSysPFPlugin;
import SA.SRFDA.PS.Data.PSSysPFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPFPluginType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSPFPluginType var2) throws Exception;

    public IPSSysPFPlugin createPSSysPFPlugin(PSSysPFPlugin var1) throws Exception;

    public IPSSysPFPluginTempl createPSSysPFPluginTempl(PSSysPFPluginTempl var1) throws Exception;
}

