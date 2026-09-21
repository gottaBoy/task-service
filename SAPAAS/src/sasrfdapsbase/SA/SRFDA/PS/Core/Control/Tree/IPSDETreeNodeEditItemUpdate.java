/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETNEIUpdateDetail;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDETEIUpdate;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6811\u8282\u70b9\u7f16\u8f91\u9879\u66f4\u65b0\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDETEIUpdate")
public interface IPSDETreeNodeEditItemUpdate
extends IPSObject,
IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDETreeNode var2, PSDETEIUpdate var3) throws Exception;

    public IPSDETreeNode getPSDETreeNode();

    @Override
    public String getCodeName();

    public Iterator<IPSDETNEIUpdateDetail> getPSDETNEIUpdateDetails();

    public IPSDEAction getPSDEAction() throws Exception;

    public boolean isShowBusyIndicator();

    public IPSAppDEMethod getPSAppDEMethod() throws Exception;

    public boolean isCustomCode();

    public String getScriptCode();
}

