/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Security;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Data.PSSysUserRoleData;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u7528\u6237\u89d2\u8272\u6570\u636e\u80fd\u529b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysUserRoleData")
public interface IPSSysUserRoleData
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSSysUserRole var2, PSSysUserRoleData var3) throws Exception;

    public IPSSysUserRole getPSSysUserRole();

    public IPSDataEntity getPSDataEntity();

    public IPSDEUserRole getPSDEUserRole();
}

