/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDERDEFMap")
public interface IPSDERDEFieldMap
extends IPSModelObject {
    @Override
    public String getCodeName();

    public IPSDERBase getPSDERBase();

    public IPSDEField getMajorPSDEField() throws Exception;

    public IPSDEField getMinorPSDEField() throws Exception;
}

