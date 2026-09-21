/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswf.core.IWFRoleModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSWFRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.pswf.core.IWFRoleModel;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u89d2\u8272\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFRole")
public interface IPSWFRole
extends IPSSystemObject,
IWFRoleModel,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSWFRole var3) throws Exception;

    @Override
    public String getCodeName();

    public String getLogicName();

    public String getUserData();

    public String getUserData2();

    public String getWFRoleSN();

    public IPSSystemModule getPSSystemModule();

    public String getWFRoleType();

    public String getUniqueTag();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();
}

