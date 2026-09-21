/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPluginTempl;
import SA.SRFDA.PS.Data.PSSysSFPluginTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;

@PSModelIgnoreMeta
public interface IPSSysSFPluginTempl
extends IPSModelObject,
IPSSFPluginTempl {
    public void init(ISRFDAGlobalHelper var1, IPSSysSFPlugin var2, PSSysSFPluginTempl var3) throws Exception;

    public IPSSysSFPlugin getPSSysSFPlugin();

    @Override
    public IPSSF getPSSF();

    @Override
    public String getCode(String var1);

    public String[] getXCodes();

    public boolean hasXCode(String var1);

    public String getXCode(String var1, Object var2, Map<String, Object> var3) throws Exception;
}

