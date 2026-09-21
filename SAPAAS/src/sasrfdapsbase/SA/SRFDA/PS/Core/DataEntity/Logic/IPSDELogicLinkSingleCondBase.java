/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParamBase;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u903b\u8f91\u8fde\u63a5\u5355\u9879\u6761\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSDELogicLinkSingleCondBase
extends IPSDELogicLinkCondBase {
    public static final String PARAMTYPE_ENTITYFIELD = "ENTITYFIELD";
    public static final String PARAMTYPE_SRCENTITYFIELD = "SRCENTITYFIELD";
    public static final String PARAMTYPE_CURTIME = "CURTIME";

    public IPSDELogicParamBase getDstLogicParam() throws Exception;

    public String getDstFieldName() throws Exception;

    public String getCondOP();

    public String getValue();

    public String getParamType();

    public String getParamValue();

    public IPSDELogicParamBase getSrcLogicParam() throws Exception;
}

