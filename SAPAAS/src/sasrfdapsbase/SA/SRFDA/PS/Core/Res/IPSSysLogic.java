/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSSysLogic
extends IPSSystemObject,
IPSSysSFPubObject {
    public static final String LOGICTYPE_CUSTOM = "CUSTOM";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysLogic var3) throws Exception;

    public String getLogicType();

    public String getCustomObject();

    public String getCustomParams();

    public boolean isCustomCode();

    public String getScriptCode();

    @Override
    public String getCodeName();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSystemModule getPSSystemModule();

    public IPSXCodeObject getRender();
}

