/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSRegistryRepo;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDCRegistryRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDCRegistryRepo
extends IPSRegistryRepo {
    public void init(ISRFDAGlobalHelper var1, PSDCRegistryRepo var2) throws Exception;

    @Override
    public String getAdminUserName();

    @Override
    public String getAdminPassword();
}

