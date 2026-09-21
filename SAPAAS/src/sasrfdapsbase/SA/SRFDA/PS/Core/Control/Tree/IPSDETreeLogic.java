/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u89c6\u56fe\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDETreeLogic")
public interface IPSDETreeLogic
extends IPSDEUILogicGroupDetail,
IPSControlObject {
    public IPSDETree getPSDETree();

    public String getPSDETreeNodeName();

    public String getPSDETreeColumnName();
}

