/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDETreeView;
import SA.SRFDA.PS.Core.App.View.PSAppDETreeViewImplBase;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DETREEVIEW", "DETREEVIEW9"})
public class PSAppDETreeViewImpl
extends PSAppDETreeViewImplBase
implements IPSAppDETreeView {
    private static final Log log = LogFactory.getLog(PSAppDETreeViewImpl.class);
    private IPSDETree iPSDETree = null;

    @Override
    protected boolean isEnableQuickSearchDefault() {
        return false;
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("tree");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDETree) {
            this.iPSDETree = (IPSDETree)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    public IPSDETree getPSDETree() {
        return this.iPSDETree;
    }

    @Override
    protected void onPreparePSAppDEMultiDataViewRefs() throws Exception {
        if (this.getPSDETree() == null || this.isPickupMode()) {
            return;
        }
        Iterator<IPSDETreeNode> psDETreeNodes = this.getPSDETree().getPSDETreeNodes();
        while (psDETreeNodes.hasNext()) {
            IPSDETreeNode iPSDETreeNode = psDETreeNodes.next();
            this.onPreparePSPSDETreeNodeRefs(iPSDETreeNode);
        }
    }

    @Override
    protected String onGetXDataControlName() {
        return "tree";
    }
}

