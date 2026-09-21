/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFLinkGroupCondModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFLinkCond;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFLinkGroupCondModel;

@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u5904\u7406\u8fde\u63a5\u7ec4\u5408\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"GROUP"})
@PSModelPFIgnoreMeta
public interface IPSWFLinkGroupCond
extends IPSWFLinkCond,
IWFLinkGroupCondModel {
    public String getGroupOP();

    public boolean isNotMode();

    public Iterator<IPSWFLinkCond> getPSWFLinkConds();
}

