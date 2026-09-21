/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.control.tree.ITreeNodeDataItem
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeColumn;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDETreeNodeColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u8282\u70b9\u6570\u636e\u7ebf\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDETreeNodeDataItem
extends IPSDataItem,
ITreeNodeDataItem {
    public void init(ISRFDAGlobalHelper var1, IPSDETreeNode var2, PSDETreeNodeColumn var3) throws Exception;

    public IPSDETreeNode getPSDETreeNode();

    public IPSDETreeColumn getPSDETreeColumn();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();

    public String getCLConvertMode();

    public String getPSCodeListId();

    public boolean isEnableItemPriv();

    public String getItemPrivId();

    public String getOriginDefaultValue();

    public String getDefaultValue();

    public IPSCodeList getFrontPSCodeList();

    public boolean isCustomCode();

    public String getScriptCode();

    public String getValueType();
}

