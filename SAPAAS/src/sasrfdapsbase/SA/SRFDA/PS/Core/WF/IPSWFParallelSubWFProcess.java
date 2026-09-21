/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFParallelSubWFProcessModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFEmbedWFProcessBase;
import net.ibizsys.pswf.core.IWFParallelSubWFProcessModel;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u5e76\u884c\u5b50\u6d41\u7a0b\u5904\u7406\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", extend="IPSWFProcess", typevalue={"PARALLEL"})
public interface IPSWFParallelSubWFProcess
extends IPSWFEmbedWFProcessBase,
IWFParallelSubWFProcessModel {
}

