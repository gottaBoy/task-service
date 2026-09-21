/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeDEFColumn;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeColumnImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDETreeDEFColumnImpl
extends PSDETreeColumnImpl
implements IPSDETreeDEFColumn {
    protected String strPSCodeListId = "";
    protected IPSCodeList iPSCodeList = null;

    @Override
    protected void onInit() throws Exception {
        this.strPSCodeListId = this.psDETreeColumn.getPSCODELISTID();
        if (!StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
            this.iPSCodeList = this.getPSDETree().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
            if (this.iPSCodeList != null) {
                this.iPSCodeList = this.getPSDETree().getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u9879\u540d\u79f0", hideempty2=true)
    public String getDataItemName() {
        return this.getName().toLowerCase();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61")
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    public String getPSCodeListId() {
        return this.strPSCodeListId;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", hideempty2=true, fields={"DEFAULTVALUE"})
    public String getDefaultValue() {
        return this.psDETreeColumn.getDEFAULTVALUE();
    }
}

