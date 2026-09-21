/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import java.util.Iterator;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u62f7\u8d1d\u903b\u8f91\u53c2\u6570\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"COPYPARAM"})
public interface IPSDECopyParamLogic
extends IPSDELogicNode {
    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSDELogicParam getSrcPSDELogicParam() throws Exception;

    public Iterator<String> getCopyFields();

    public boolean isCopyIfNotExists();
}

