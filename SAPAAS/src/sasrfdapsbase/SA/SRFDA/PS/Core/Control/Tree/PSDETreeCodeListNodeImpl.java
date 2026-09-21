/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeCodeListNode;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeImplBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSDETreeCodeListNodeImpl
extends PSDETreeNodeImplBase
implements IPSDETreeCodeListNode {
    private IPSCodeList iPSCodeList = null;
    private IPSAppCodeList iPSAppCodeList = null;
    private boolean bAppendCaption = false;

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDETreeNode.getPSCODELISTID())) {
            throw new Exception("\u4ee3\u7801\u8868\u6811\u8282\u70b9\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u8868\u5bf9\u8c61");
        }
        this.iPSCodeList = this.getPSDETree().getPSDataEntity().getPSSystem().getPSCodeList(this.psDETreeNode.getPSCODELISTID());
        this.iPSAppCodeList = this.getPSDETree().getPSAppView().getPSApplication().getPSAppCodeList(this.iPSCodeList, true);
        if (!this.psDETreeNode.isAPPENDCAPFLAGNull()) {
            this.bAppendCaption = this.psDETreeNode.getAPPENDCAPFLAG();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", dump=false)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true, modelattr="getPSCodeList", fields={"PSCODELISTID"})
    public IPSAppCodeList getPSAppCodeList() {
        return this.iPSAppCodeList;
    }

    public String getCodeListId() {
        return this.psDETreeNode.getPSCODELISTID();
    }

    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u8282\u70b9\u6807\u9898", fields={"APPENDCAPFLAG"})
    public boolean isAppendCaption() {
        return this.bAppendCaption;
    }
}

