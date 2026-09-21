/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroup;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDERGroupDetail")
public interface IPSDERGroupDetail
extends IPSModelObject {
    public IPSDERGroup getPSDERGroup();

    public IPSDERBase getPSDER();

    @Override
    public String getCodeName();

    public int getOrderValue();

    public String getCodeName2();

    public String getDetailTag();

    public String getDetailTag2();

    public String getData();
}

