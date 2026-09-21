/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormTabPage;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormBaseGroupPanelImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;

public class PSDEFormTabPageImpl
extends PSDEFormBaseGroupPanelImpl
implements IPSDEFormTabPage {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public boolean isEnableAnchor() {
        return false;
    }

    @Override
    public int getBuildInActions() {
        return 0;
    }

    @Override
    public boolean isEnableBuildInAction(int nAction) {
        return false;
    }

    @Override
    public int getPSDEFormDetailCount() {
        return this.psDEFormDetailList.size();
    }

    @Override
    public IPSDEFormDetail getPSDEFormDetail(int nIndex) throws Exception {
        return (IPSDEFormDetail)this.psDEFormDetailList.get(nIndex);
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_TABPAGE";
    }

    @Override
    public IPSUIActionGroup getPSUIActionGroup() {
        return null;
    }

    @Override
    public String getActionGroupExtractMode() {
        return null;
    }

    @Override
    public Iterator<IPSDEFormItem> getAnchorablePSDEFormItems() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u9879\u6807\u8bb0", ignorert=3, fields={"DRITEMTAG"})
    public String getDRItemTag() {
        return this.psDEFormDetail.getPSDEDRITEMNAME();
    }
}

