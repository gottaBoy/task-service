/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSRegistryRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSRegistryRepo
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public void init(ISRFDAGlobalHelper var1, PSRegistryRepo var2) throws Exception;

    public String getRegistryType();

    public String getConnStr();

    public String getUserName();

    public String getPassword();

    public String getAdminUserName();

    public String getAdminPassword();
}

