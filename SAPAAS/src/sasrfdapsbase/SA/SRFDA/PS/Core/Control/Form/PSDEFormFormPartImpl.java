/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormFormPart;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormBaseGroupPanelImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import java.util.Iterator;

public class PSDEFormFormPartImpl
extends PSDEFormBaseGroupPanelImpl
implements IPSDEFormFormPart {
    private String strFormPartType = "DYNASYS";

    @Override
    protected void onInit() throws Exception {
        this.strFormPartType = this.psDEFormDetail.getCONTENTTYPE();
        super.onInit();
    }

    @Override
    public Iterator<IPSDEFormDetail> getPSDEFormDetails() {
        return this.psDEFormDetailList.iterator();
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
    @PSModelRTMeta(description="\u8868\u5355\u90e8\u4ef6\u7c7b\u578b", codelist="FormPartType", fields={"CONTENTTYPE"})
    public String getFormPartType() {
        return this.strFormPartType;
    }

    @Override
    public String getModelType() {
        return "PSDEFORMDETAIL_FORMPART";
    }
}

