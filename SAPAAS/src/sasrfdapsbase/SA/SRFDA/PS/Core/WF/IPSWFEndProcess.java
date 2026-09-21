/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5de5\u4f5c\u6d41\u7ed3\u675f\u5904\u7406\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", extend="IPSWFProcess", typevalue={"END"})
public interface IPSWFEndProcess
extends IPSWFProcess {
    public String getExitStateValue();
}

