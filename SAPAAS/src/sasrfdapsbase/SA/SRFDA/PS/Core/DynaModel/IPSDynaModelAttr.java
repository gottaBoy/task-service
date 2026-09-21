/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DynaModel;

import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u52a8\u6001\u6a21\u578b\u5c5e\u6027\u5bf9\u8c61\u63a5\u53e3", implement="PSSysDynaModelAttrImpl")
public interface IPSDynaModelAttr
extends IPSModelObject {
    public static final String VALUETYPE_VALUE = "VALUE";
    public static final String VALUETYPE_OBJECT = "OBJECT";
    public static final String VALUETYPE_DE = "DE";

    @Override
    public IPSDynaModel getPSDynaModel();

    public String getValueType();

    public String getValue();

    public IPSDynaModel getRefPSDynaModel() throws Exception;

    public String getAttrTag();

    public String getAttrTag2();
}

