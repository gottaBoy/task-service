/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Requirement;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysReqModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysReqModule
extends IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, IPSSysReqModule var3, PSSysReqModule var4) throws Exception;

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getModuleTag();

    public String getModuleTag2();

    public IPSSysReqModule getParentPSSysReqModule();

    public Iterator<IPSSysReqModule> getPSSysReqModules() throws Exception;

    public IPSSysReqModule getPSSysReqModule(String var1) throws Exception;

    public IPSSysReqModule getPSSysReqModule(String var1, boolean var2) throws Exception;

    public void resetPSSysReqModule(String var1) throws Exception;

    public void resetPSSysReqModules();

    public Iterator<IPSSysReqItem> getPSSysReqItems() throws Exception;

    public String getModuleSN();
}

