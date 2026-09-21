/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFTimerEventProcessModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import net.ibizsys.pswf.core.IWFTimerEventProcessModel;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u5b9a\u65f6\u5904\u7406\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", extend="IPSWFProcess", typevalue={"TIMEREVENT"})
public interface IPSWFTimerEventProcess
extends IPSWFProcess,
IWFTimerEventProcessModel {
}

