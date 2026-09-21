/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8c03\u7528\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DELOGIC"})
public interface IPSDEUIDELogicLogic
extends IPSDEUILogicNode {
    public IPSAppDataEntity getDstPSAppDataEntity() throws Exception;

    public IPSAppDELogic getDstPSAppDELogic() throws Exception;

    @Override
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception;

    public IPSDEUILogicParam getRetPSDEUILogicParam() throws Exception;
}

