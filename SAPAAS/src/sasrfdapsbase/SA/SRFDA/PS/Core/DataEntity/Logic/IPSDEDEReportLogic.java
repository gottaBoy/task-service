/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8c03\u7528\u5b9e\u4f53\u62a5\u8868\u529f\u80fd\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEREPORT"})
@PSModelPFIgnoreMeta
public interface IPSDEDEReportLogic
extends IPSDELogicNode {
    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEReport getDstPSDEReport() throws Exception;

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSDELogicParam getOSPSDELogicParam() throws Exception;
}

