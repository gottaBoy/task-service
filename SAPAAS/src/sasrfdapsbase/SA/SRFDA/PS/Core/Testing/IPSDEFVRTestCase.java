/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u6d4b\u8bd5\u7528\u4f8b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEFVR"}, model="PSSysTestCase")
public interface IPSDEFVRTestCase
extends IPSSysTestCase,
IPSDataEntityObject {
    public IPSDEField getPSDEField();

    public String getDEFValue();
}

