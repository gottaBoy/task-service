/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswx.core.IWXLogic
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXAccountObject;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Core.WX.IPSWXMenuFunc;
import SA.SRFDA.PS.Data.PSWXLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.pswx.core.IWXLogic;

@PSModelPFIgnoreMeta
public interface IPSWXLogic
extends IPSWXAccountObject,
IWXLogic {
    public void init(ISRFDAGlobalHelper var1, IPSWXAccount var2, IPSWXEntApp var3, PSWXLogic var4) throws Exception;

    @Override
    public String getCodeName();

    public IPSDataEntity getPSDataEntity();

    public IPSDEAction getPSDEAction();

    public IPSWXMenuFunc getPSWXMenuFunc();

    public IPSWXEntApp getPSWXEntApp();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();
}

