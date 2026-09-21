/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.View.IPSUIEngineParam;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u754c\u9762\u5f15\u64ce\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppViewEngineParam
extends IPSUIEngineParam,
IPSModelObject {
    public static final String PARAMTYPE_LOGIC = "LOGIC";
    public static final String PARAMTYPE_CTRL = "CTRL";
    public static final String PARAMTYPE_VALUE = "VALUE";

    public IPSAppViewEngine getPSAppViewEngine();

    @Override
    public String getParamType();

    public IPSAppViewLogic getPSAppViewLogic();

    public IPSControl getPSControl();

    @Override
    public Object getValue();

    public String getCtrlName();

    public String getAppViewLogicName();
}

