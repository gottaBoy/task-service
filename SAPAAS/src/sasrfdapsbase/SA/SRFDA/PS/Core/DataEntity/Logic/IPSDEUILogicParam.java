/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParamBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8282\u70b9\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELogicParam")
public interface IPSDEUILogicParam
extends IPSDELogicParamBase {
    public IPSDEUILogic getPSDEUILogic();

    public boolean isActiveViewParam();

    public boolean isActiveContainerParam();

    public boolean isActiveCtrlParam();

    public boolean isCtrlParam();

    public boolean isNavContextParam();

    public boolean isNavViewParamParam();

    public boolean isViewNavDataParam();

    public boolean isAppGlobalParam();

    public boolean isRouteViewSessionParam();

    public boolean isViewSessionParam();

    public String getParamTag();

    public String getParamTag2();

    public String getParamFieldName();

    public boolean isEntityParam();

    public boolean isFilterParam();

    public boolean isEntityListParam();

    public boolean isEntityMapParam();

    public boolean isLastReturnParam();

    public boolean isEntityPageParam();

    public boolean isSimpleParam();

    public boolean isSimpleListParam();

    public int getStdDataType();

    public String getDefaultValueType();

    public String getDefaultValue();

    public boolean isApplicationParam();

    public boolean isSessionParam();

    public boolean isEnvParam();
}

