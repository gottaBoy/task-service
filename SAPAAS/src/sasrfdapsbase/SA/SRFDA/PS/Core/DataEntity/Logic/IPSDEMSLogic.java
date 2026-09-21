/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicNode;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELogic")
public interface IPSDEMSLogic
extends IPSDELogicBase {
    public IPSDEMSLogicNode getDefaultPSDEMSLogicNode();

    public Iterator<? extends IPSDEMSLogicNode> getPSDEMSLogicNodes();

    public IPSDEMSLogicNode getPSDEMSLogicNode(String var1) throws Exception;

    public Iterator<? extends IPSDEMSLogicLink> getPSDEMSLogicLinks();

    public String getLogicTag();

    public String getLogicTag2();

    public String getLogicTag3();

    public String getLogicTag4();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();
}

