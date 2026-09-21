/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEUserRole
 */
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEDataRange;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRoleOPPriv;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import SA.SRFDA.PS.Data.PSDEUserRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEUserRole;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u7528\u6237\u89d2\u8272\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEUserRole")
public interface IPSDEUserRole
extends IPSDataEntityObject,
IDEUserRole,
IPSDEDataRange {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEUserRole var3) throws Exception;

    public String getRoleTag();

    public IPSSysUserDR getPSSysUserDR();

    public IPSSysUserDR getPSSysUserDR2();

    public Iterator<IPSDEOPPriv> getPSDEOPPrivs() throws Exception;

    public Iterator<IPSDEUserRoleOPPriv> getPSDEUserRoleOPPrivs() throws Exception;

    public String getCustomCond();

    public boolean isDefaultMode();

    public IPSDEDataSet getPSDEDataSet();

    public boolean isSystemReserved();

    public boolean isAllData();

    public IPSDEFGroup getPSDEFGroup();
}

