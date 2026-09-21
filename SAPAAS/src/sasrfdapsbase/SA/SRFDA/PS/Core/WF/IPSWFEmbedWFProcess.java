/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFEmbedWFProcessModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFEmbedWFProcessBase;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModel;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u5d4c\u5165\u6d41\u7a0b\u5904\u7406\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", extend="IPSWFProcess", typevalue={"EMBED"}, model="PSWFProcess")
public interface IPSWFEmbedWFProcess
extends IPSWFEmbedWFProcessBase,
IWFEmbedWFProcessModel {
    public Iterator<IPSWFProcessRole> getPSWFProcessRoles();
}

