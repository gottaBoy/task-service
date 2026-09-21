/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u81ea\u5b9a\u4e49\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"USER"})
public interface IPSDEUserLogic
extends IPSDELogicNode {
    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEAction getDstPSDEAction() throws Exception;

    public IPSDEDataQuery getDstPSDEDataQuery() throws Exception;

    public IPSDEDataSet getDstPSDEDataSet() throws Exception;

    public IPSDELogic getDstPSDELogic() throws Exception;

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSDELogicParam getRetPSDELogicParam() throws Exception;

    public String getParam1();

    public String getParam2();

    public String getParam3();

    public String getParam4();

    public String getParam5();

    public String getParam6();

    public Integer getParam7();

    public Integer getParam8();

    public Integer getParam9();

    public Integer getParam10();

    public String getParam11();

    public String getParam12();

    public String getParam13();

    public String getParam14();
}

