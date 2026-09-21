/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDTSQueue
 */
package SA.SRFDA.PS.Core.DataEntity.DTS;

import SA.SRFDA.PS.Core.DTS.IPSSysDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Data.PSDEDTSQueue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEDTSQueue;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5206\u5e03\u4e8b\u52a1\u961f\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDTSQueue")
public interface IPSDEDTSQueue
extends IPSDataEntityObject,
IDEDTSQueue {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDTSQueue var3) throws Exception;

    public boolean isDefault();

    public IPSSysDTSQueue getPSSysDTSQueue();

    @Override
    public String getCodeName();

    public int getCancelTimeout();

    public int getRefreshTimer();

    public IPSDEAction getCancelPSDEAction();

    public IPSDEAction getConfirmPSDEAction();

    public IPSDEAction getPushPSDEAction();

    public IPSDEAction getRefreshPSDEAction();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSXCodeObject getRender();
}

