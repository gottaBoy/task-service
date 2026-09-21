/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5\u8c03\u7528\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SUBSYSSAMETHOD"})
@PSModelPFIgnoreMeta
public interface IPSDESubSysSAMethodLogic
extends IPSDELogicNode {
    public IPSSubSysServiceAPI getPSSubSysServiceAPI() throws Exception;

    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() throws Exception;

    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception;

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSDELogicParam getRetPSDELogicParam() throws Exception;
}

