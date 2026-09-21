/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelTabPage;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelContainerImplBase;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"TAGPAGE"})
public class PSSysPanelTabPageImpl
extends PSSysPanelContainerImplBase
implements IPSSysPanelTabPage {
    private int nTitleBarCloseMode = 0;

    @Override
    protected void onInit() throws Exception {
        if (!this.psSysPanelItem.isTITLEBARCLOSEMODENull()) {
            this.nTitleBarCloseMode = this.psSysPanelItem.getTITLEBARCLOSEMODE();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSPanelItem> getPSPanelItems() {
        return this.psPanelItemList.iterator();
    }

    @Override
    public int getPSPanelItemCount() {
        return this.psPanelItemList.size();
    }

    @Override
    public IPSPanelItem getPSPanelItem(int nIndex) throws Exception {
        return (IPSPanelItem)this.psPanelItemList.get(nIndex);
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_TABPAGE";
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b", fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return super.getPredefinedType();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f", codelist="FormTitleBarCloseMode", ignoredumpvalues="0", fields={"TITLEBARCLOSEMODE"})
    public int getTitleBarCloseMode() {
        return this.nTitleBarCloseMode;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6807\u9898\u7ed1\u5b9a\u503c\u9879", fields={"FIELDNAME"}, doc="\u4ec5\u5728\u6570\u636e\u533a\u57df\u7c7b\u578b{@link #getDataRegionType}\u4e3a\u65e0(NONE)\u53ca\u7ee7\u627f(INHERIT)\u65f6\u542f\u7528")
    public String getCaptionItemName() {
        if (StringHelper.Compare((String)this.getDataRegionType(), (String)"NONE", (boolean)false) == 0 || StringHelper.Compare((String)this.getDataRegionType(), (String)"INHERIT", (boolean)false) == 0) {
            return this.psSysPanelItem.getFIELDNAME();
        }
        return "";
    }

    @Override
    public IPSUIActionGroup getPSUIActionGroup() {
        return null;
    }

    @Override
    public String getActionGroupExtractMode() {
        return null;
    }
}

