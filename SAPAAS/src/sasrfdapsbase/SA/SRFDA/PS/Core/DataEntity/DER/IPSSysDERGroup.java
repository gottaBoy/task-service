/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroup;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSSysDERGroupImpl", model="PSDERGroup")
public interface IPSSysDERGroup
extends IPSDERGroup,
IPSSystemObject,
IPSSysSFPubObject {
    public IPSSystemModule getPSSystemModule();
}

