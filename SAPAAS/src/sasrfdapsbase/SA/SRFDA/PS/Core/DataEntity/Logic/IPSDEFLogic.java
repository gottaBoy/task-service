/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelExtendMeta(extend="IPSDELogic", typevalue={"DEFIELD"})
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5c5e\u6027\u5904\u7406\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEFLogicImpl")
public interface IPSDEFLogic
extends IPSDELogic {
    public static final String DEFLOGICMODE_COMPUTE = "COMPUTE";
    public static final String DEFLOGICMODE_DEFAULT = "DEFAULT";
    public static final String DEFLOGICMODE_ONCHANGE = "ONCHANGE";
    public static final String DEFLOGICMODE_CHECK = "CHECK";
    public static final String DEFLOGICMODE_USER = "USER";
    public static final String DEFLOGICMODE_USER2 = "USER2";
    public static final String DEFLOGICMODE_USER3 = "USER3";
    public static final String DEFLOGICMODE_USER4 = "USER4";

    public IPSDEField getPSDEField();

    public String getDEFLogicMode();
}

