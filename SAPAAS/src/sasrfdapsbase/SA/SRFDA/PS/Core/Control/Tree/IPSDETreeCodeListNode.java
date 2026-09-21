/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.ITreeCodeListNodeModel
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import net.ibizsys.paas.ctrlmodel.ITreeCodeListNodeModel;

@PSModelExtendMeta(title="\u5b9e\u4f53\u6811\u89c6\u56fe\u4ee3\u7801\u8868\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"CODELIST"})
public interface IPSDETreeCodeListNode
extends IPSDETreeNode,
ITreeCodeListNodeModel {
    public IPSCodeList getPSCodeList();

    public IPSAppCodeList getPSAppCodeList();

    public boolean isAppendCaption();
}

