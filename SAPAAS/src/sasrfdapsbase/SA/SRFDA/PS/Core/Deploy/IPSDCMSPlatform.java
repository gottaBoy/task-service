/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCCluster;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformFunc;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatformNode;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSDCMSPlatform;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSDCMSPlatform
extends IPSObject,
IPSRemoteResObject,
IPSMSPlatform {
    public static final String PARAM_DEVOPSCALLBACK = "devopscallback";

    public void init(ISRFDAGlobalHelper var1, PSDCMSPlatform var2) throws Exception;

    public IPSMSPlatform getPSMSPlatform();

    public IPSDCMSPlatformFunc getPSDCMSPlatformFunc(String var1) throws Exception;

    public IPSDCMSPlatformNode getPSDCMSPlatformNode(String var1) throws Exception;

    public Iterator<IPSDCMSPlatformNode> getAllPSDCMSPlatformNodes();

    public Iterator<IPSDCMSPlatformFunc> getAllPSDCMSPlatformFuncs();

    public IPSDCCluster getPSDCCluster() throws Exception;
}

