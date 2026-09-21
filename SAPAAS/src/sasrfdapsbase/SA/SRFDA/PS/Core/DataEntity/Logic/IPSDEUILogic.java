/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELogic")
public interface IPSDEUILogic
extends IPSDELogicBase {
    public IPSDEUILogicNode getStartPSDEUILogicNode();

    public Iterator<? extends IPSDEUILogicNode> getPSDEUILogicNodes();

    public Iterator<? extends IPSDEUILogicParam> getPSDEUILogicParams();

    public IPSDEUILogicParam getPSDEUILogicParam(String var1) throws Exception;

    public IPSDEUILogicNode getPSDEUILogicNode(String var1) throws Exception;

    public Iterator<? extends IPSDEUILogicLink> getPSDEUILogicLinks();
}

