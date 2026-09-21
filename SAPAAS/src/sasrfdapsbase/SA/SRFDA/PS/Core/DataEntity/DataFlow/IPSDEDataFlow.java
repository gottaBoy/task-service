/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowLink;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginSupportable;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEDataFlow
extends IPSDataEntityObject,
IPSSysSFPluginSupportable {
    public static final int DEBUGMODE_NONE = 0;
    public static final int DEBUGMODE_INFO = 1;
    public static final String LOGICSUBTYPE_PACKAGE = "PACKAGE";

    public int getDebugMode();

    public Iterator<? extends IPSDEDataFlowNode> getPSDEDataFlowNodes();

    public IPSDEDataFlowNode getPSDEDataFlowNode(String var1) throws Exception;

    public Iterator<? extends IPSDEDataFlowLink> getPSDEDataFlowLinks();

    public IPSSFXCodeObject getRender();

    public String getLogicSubType();

    public String getPackageModel();
}

