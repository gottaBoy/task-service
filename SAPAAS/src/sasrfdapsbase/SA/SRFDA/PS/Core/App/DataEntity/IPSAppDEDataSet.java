/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppDEDataSet
extends IPSAppDEMethod {
    public IPSDEDataSet getPSDEDataSet();

    public IPSAppCodeList getPSAppCodeList();

    public String getPredefinedType();

    public boolean isCustomCode();

    public String getScriptCode();

    public String getDataSetType();

    public Iterator<IPSDEDQCondition> getADPSDEDQConditions();

    public IPSAppDELogic getPSAppDELogic() throws Exception;

    public String getBeforeCode();

    public String getAfterCode();

    public Iterator<IPSDEDQGroupCondition> getPSDEDQGroupConditions();

    public String getDataSetName();

    public String getDataSetTag();
}

