/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFRole;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5b9e\u4f53\u6570\u636e\u96c6\u89d2\u8272\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFRole")
public interface IPSWFDEDataSetRole
extends IPSWFRole {
    public IPSDataEntity getPSDataEntity();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEField getWFUserIdPSDEF();

    public IPSDEField getWFUserNamePSDEF();
}

