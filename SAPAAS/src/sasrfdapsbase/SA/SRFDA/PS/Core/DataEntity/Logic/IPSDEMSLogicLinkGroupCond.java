/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkGroupCondBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLinkCond;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u903b\u8f91\u8fde\u63a5\u7ec4\u5408\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"GROUP"})
public interface IPSDEMSLogicLinkGroupCond
extends IPSDEMSLogicLinkCond,
IPSDELogicLinkGroupCondBase {
    public Iterator<? extends IPSDEMSLogicLinkCond> getPSDEMSLogicLinkConds();
}

