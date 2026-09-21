/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswf.core.IWFProcRoleModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import SA.SRFDA.PS.Data.PSWFProcRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.pswf.core.IWFProcRoleModel;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u8282\u70b9\u89d2\u8272\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFProcRole")
public interface IPSWFProcessRole
extends IPSModelObject,
IWFProcRoleModel {
    public static final String ROLETYPE_WFROLE = "WFROLE";
    public static final String ROLETYPE_LASTTWOSTEPACTOR = "LASTTWOSTEPACTOR";
    public static final String ROLETYPE_LASTTHREESTEPACTOR = "LASTTHREESTEPACTOR";
    public static final String ROLETYPE_LASTSTEPACTOR = "LASTSTEPACTOR";
    public static final String ROLETYPE_UDACTOR = "UDACTOR";
    public static final String ROLETYPE_CURACTOR = "CURACTOR";

    public void init(ISRFDAGlobalHelper var1, IPSWFProcess var2, PSWFProcRole var3) throws Exception;

    public IPSWFProcess getPSWFProcess();

    public String getWFProcessRoleType();

    public String getUDField();

    public IPSWFRole getPSWFRole();

    public String getUserData();

    public String getUserData2();

    public IPSSysMsgTempl getPSSysMsgTempl();

    public IPSSysMsgTempl getOriginPSSysMsgTempl();

    public boolean isCCMode();
}

