/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Util;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSAppUtil;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5e94\u7528\u529f\u80fd\u914d\u7f6e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="utilType", implement="PSAppUtilImpl", model="PSAppUtil")
public interface IPSAppUtil
extends IPSApplicationObject {
    public static final String UTILTYPE_FILTERSTORAGE = "FILTERSTORAGE";
    public static final String UTILTYPE_DYNADASHBOARD = "DYNADASHBOARD";
    public static final String UTILTYPE_DYNAFORM = "DYNAFORM";
    public static final String UTILTYPE_DYNAGRID = "DYNAGRID";
    public static final String UTILTYPE_DYNACHART = "DYNACHART";
    public static final String UTILTYPE_USER = "USER";

    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppUtil var3) throws Exception;

    public String getUtilType();

    public String getUtilTag();

    public String getUtilPSDEId();

    public String getUtilPSDE2Id();

    public String getUtilPSDE3Id();

    public String getUtilPSDE4Id();

    public String getUtilPSDE5Id();

    public String getUtilPSDE6Id();

    public String getUtilPSDE7Id();

    public String getUtilPSDE8Id();

    public String getUtilPSDE9Id();

    public String getUtilPSDE10Id();

    public String getUtilPSDE11Id();

    public String getUtilPSDE12Id();

    public String getUtilPSDE13Id();

    public String getUtilPSDE14Id();

    public String getUtilPSDE15Id();

    public String getUtilPSDE16Id();

    public String getUtilPSDE17Id();

    public String getUtilPSDE18Id();

    public String getUtilPSDE19Id();

    public String getUtilPSDE20Id();

    public String getUtilPSDEName();

    public String getUtilPSDE2Name();

    public String getUtilPSDE3Name();

    public String getUtilPSDE4Name();

    public String getUtilPSDE5Name();

    public String getUtilPSDE6Name();

    public String getUtilPSDE7Name();

    public String getUtilPSDE8Name();

    public String getUtilPSDE9Name();

    public String getUtilPSDE10Name();

    public String getUtilPSDE11Name();

    public String getUtilPSDE12Name();

    public String getUtilPSDE13Name();

    public String getUtilPSDE14Name();

    public String getUtilPSDE15Name();

    public String getUtilPSDE16Name();

    public String getUtilPSDE17Name();

    public String getUtilPSDE18Name();

    public String getUtilPSDE19Name();

    public String getUtilPSDE20Name();

    public boolean isRegToApp();

    public IPSPFXCodeObject getRender();

    public IPSSysPFPlugin getPSSysPFPlugin();

    @Override
    public String getCodeName();

    public Properties getUtilParams();
}

