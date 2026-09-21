/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDETreeGridExView;
import SA.SRFDA.PS.Core.App.View.PSAppDETreeViewImplBase;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeGridEx;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DETREEGRIDEXVIEW", "DETREEGRIDEXVIEW9"})
public class PSAppDETreeGridExViewImpl
extends PSAppDETreeViewImplBase
implements IPSAppDETreeGridExView {
    private static final Log log = LogFactory.getLog(PSAppDETreeGridExViewImpl.class);
    private IPSDETreeGridEx iPSDETreeGridEx = null;

    @Override
    protected boolean isEnableQuickSearchDefault() {
        return false;
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("treegridex");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDETreeGridEx) {
            this.iPSDETreeGridEx = (IPSDETreeGridEx)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    public IPSDETreeGridEx getPSDETreeGridEx() {
        return this.iPSDETreeGridEx;
    }

    @Override
    protected void onPreparePSAppDEMultiDataViewRefs() throws Exception {
        if (this.getPSDETreeGridEx() == null || this.isPickupMode()) {
            return;
        }
        Iterator<IPSDETreeNode> psDETreeNodes = this.getPSDETreeGridEx().getPSDETreeNodes();
        while (psDETreeNodes.hasNext()) {
            IPSDETreeNode iPSDETreeNode = psDETreeNodes.next();
            this.onPreparePSPSDETreeNodeRefs(iPSDETreeNode);
        }
    }

    @Override
    protected String onGetXDataControlName() {
        return "treegridex";
    }
}

