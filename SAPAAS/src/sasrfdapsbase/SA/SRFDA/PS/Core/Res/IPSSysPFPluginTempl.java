/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSSysPFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;

@PSModelIgnoreMeta
public interface IPSSysPFPluginTempl
extends IPSModelObject,
IPSPFPluginTempl {
    public void init(ISRFDAGlobalHelper var1, IPSSysPFPlugin var2, PSSysPFPluginTempl var3) throws Exception;

    public IPSSysPFPlugin getPSSysPFPlugin();

    @Override
    public IPSPF getPSPF();

    public PSSysPFPluginTempl getPSSysPFPluginTemplData(IPSPFStyle var1) throws Exception;

    @Override
    public String getCode(String var1);

    public String[] getXCodes();

    public boolean hasXCode(String var1);

    public String getXCode(String var1, Object var2, Object var3, Object var4, Map<String, Object> var5) throws Exception;
}

