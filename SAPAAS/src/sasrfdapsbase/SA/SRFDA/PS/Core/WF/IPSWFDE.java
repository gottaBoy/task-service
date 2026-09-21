/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5b9e\u4f53\u914d\u7f6e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFDE")
public interface IPSWFDE
extends IPSDEWF {
    @Override
    public IPSDataEntity getPSDataEntity();
}

