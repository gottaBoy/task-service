/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEGanttView;
import SA.SRFDA.PS.Core.App.View.PSAppDETreeViewImplBase;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDEGantt;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEGANTTVIEW", "DEGANTTVIEW9"})
public class PSAppDEGanttViewImpl
extends PSAppDETreeViewImplBase
implements IPSAppDEGanttView {
    private static final Log log = LogFactory.getLog(PSAppDEGanttViewImpl.class);
    private IPSDEGantt iPSDEGantt = null;

    @Override
    protected boolean isEnableQuickSearchDefault() {
        return false;
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("gantt");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDEGantt) {
            this.iPSDEGantt = (IPSDEGantt)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    public IPSDEGantt getPSDEGantt() {
        return this.iPSDEGantt;
    }

    @Override
    protected void onPreparePSAppDEMultiDataViewRefs() throws Exception {
        if (this.getPSDEGantt() == null || this.isPickupMode()) {
            return;
        }
        Iterator<IPSDETreeNode> psDETreeNodes = this.getPSDEGantt().getPSDETreeNodes();
        while (psDETreeNodes.hasNext()) {
            IPSDETreeNode iPSDETreeNode = psDETreeNodes.next();
            this.onPreparePSPSDETreeNodeRefs(iPSDETreeNode);
        }
    }

    @Override
    protected String onGetXDataControlName() {
        return "gantt";
    }
}

