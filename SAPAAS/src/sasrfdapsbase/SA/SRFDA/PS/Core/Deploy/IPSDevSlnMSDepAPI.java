/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPDeployItem;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSDevSlnMSDepAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSDevSlnMSDepAPI
extends IPSModelObject,
IPSDCMSPDeployItem {
    public void init(ISRFDAGlobalHelper var1, IPSDevSlnSys var2, PSDevSlnMSDepAPI var3) throws Exception;

    public int getHttpPort();

    public IPSDevSlnSys getPSDevSlnSys() throws Exception;

    public IPSSysServiceAPI getPSSysServiceAPI() throws Exception;

    public String getPSDevCenterDBInstId();

    public IPSDBDevInst getPSDBDevInst();

    public String getPSDevSlnSysAPIId();
}

