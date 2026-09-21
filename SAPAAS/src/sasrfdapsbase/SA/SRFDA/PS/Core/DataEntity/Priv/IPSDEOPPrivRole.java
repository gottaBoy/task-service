/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEOPPrivRole
 */
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRoleOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Data.PSDEOPPrivRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEOPPrivRole;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u89d2\u8272\u64cd\u4f5c\u6807\u8bc6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEOPPrivRole")
public interface IPSDEOPPrivRole
extends IPSDataEntityObject,
IDEOPPrivRole,
IPSDEUserRoleOPPriv {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEOPPrivRole var3) throws Exception;

    public String getDEOPPrivTag();

    public String getRoleType();

    @Override
    public IPSDEOPPriv getPSDEOPPriv();

    @Override
    public IPSDEDataQuery getPSDEDataQuery();

    @Override
    public IPSDEUserRole getPSDEUserRole();

    public IPSSysUserRole getPSSysUserRole();
}

