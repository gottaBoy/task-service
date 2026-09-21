/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPDeployItem;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFuncItem;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Data.PSDevSlnMSDepFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSDevSlnMSDepFunc
extends IPSModelObject,
IPSDCMSPDeployItem {
    public void init(ISRFDAGlobalHelper var1, IPSDevSlnSys var2, PSDevSlnMSDepFunc var3) throws Exception;

    public int getHttpPort();

    public IPSDevSlnSys getPSDevSlnSys() throws Exception;

    public String getPSDevCenterDBInstId();

    public IPSDBDevInst getPSDBDevInst();

    public Iterator<IPSDevSlnMSDepFuncItem> getPSDevSlnMSDepFuncItems();
}

