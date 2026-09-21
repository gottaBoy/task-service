/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Control.Tree.IPSDETree
 *  SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode
 *  SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 *  SA.SRFDA.PS.Core.Pub.Util.PSCtrlMethod
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSExtJS5CtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSCtrlMethod;
import java.util.HashMap;
import java.util.Iterator;

public class PSExtJS5DETreeCCPublisherImpl
extends PSExtJS5CtrlCodePublisherImpl {
    protected IPSDETree iPSDETree = null;

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDETree = (IPSDETree)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSCtrlMethod psCMMethod = new PSCtrlMethod();
        psCMMethod.resetCtrlResult();
        params.put("srfcm", psCMMethod);
        Iterator psDETreeNodes = this.iPSDETree.getPSDETreeNodes();
        if (psDETreeNodes != null) {
            while (psDETreeNodes.hasNext()) {
                IPSPFCtrlTempl iPSPFCtrlTempl;
                IPSDETreeNode iPSDETreeNode = (IPSDETreeNode)psDETreeNodes.next();
                if (iPSDETreeNode.getPSDEContextMenu() == null || (iPSPFCtrlTempl = this.iPSPFStyle.getPSPFCtrlTempl(iPSDETreeNode.getPSDEContextMenu().getPSControlType(), this.getPSPFPubCode())) == null) continue;
                IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = iPSPFCtrlTempl.getPSPFCtrlCodePublisher();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)iPSDETreeNode.getPSDEContextMenu());
                if (iPSGenerateCodeResult != null) {
                    psCMMethod.registerCtrlResult(iPSDETreeNode.getNodeType(), iPSGenerateCodeResult);
                }
                iPSPFCtrlCodePublisher.close();
            }
        }
    }

    protected void onClose() {
        this.iPSDETree = null;
        super.onClose();
    }
}

