/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.ISystemUserRole
 */
package SA.SRFDA.PS.Core.Security;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Security.IPSSysUserRoleData;
import SA.SRFDA.PS.Core.Security.IPSSysUserRoleRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysUserRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.ISystemUserRole;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u7528\u6237\u89d2\u8272\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysUserRole")
public interface IPSSysUserRole
extends IPSSystemObject,
ISystemUserRole,
IPSModelObject,
IPSSysSFPubObject {
    public static final String DEFAULTUSER_NONE = "NONE";
    public static final String DEFAULTUSER_USER = "USER";
    public static final String DEFAULTUSER_ADMIN = "ADMIN";
    public static final String DEFAULTUSER_ACCESSUSER = "ACCESSUSER";
    public static final String DEFAULTUSER_ACCESSADMIN = "ACCESSADMIN";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysUserRole var3) throws Exception;

    public String getRoleTag();

    public String getRoleType();

    public IPSDataEntity getPSDE();

    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getUserIdPSDEField();

    public IPSDEField getRoleTagPSDEField();

    public Iterator<IPSSysUserRoleRes> getPSSysUserRoleReses();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public Iterator<IPSSysUserRoleData> getPSSysUserRoleDatas();

    public String getDefaultUser();

    public boolean isSystemReserved();

    public boolean isGlobalRole();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();
}

