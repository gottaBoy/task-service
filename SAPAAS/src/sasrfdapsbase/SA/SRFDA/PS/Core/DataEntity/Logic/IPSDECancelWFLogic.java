/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u53d6\u6d88\u6d41\u7a0b\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"CANCELWF"})
public interface IPSDECancelWFLogic
extends IPSDELogicNode {
    public IPSWorkflow getPSWorkflow() throws Exception;

    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEWF getPSDEWF() throws Exception;

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSAppWF getPSAppWF();
}

