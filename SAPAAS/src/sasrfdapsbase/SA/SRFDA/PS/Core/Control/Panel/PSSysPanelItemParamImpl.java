/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItemParam;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelButtonImplBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import java.util.ArrayList;
import net.ibizsys.paas.util.StringHelper;

@PSModelIgnoreMeta
public class PSSysPanelItemParamImpl
extends PSSysPanelButtonImplBase
implements IPSSysPanelItemParam {
    private IPSSysResource iPSSysResource = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getPSSYSRESOURCEID())) {
            this.iPSSysResource = this.getPSSystem().getPSSysResource(this.psSysPanelItem.getPSSYSRESOURCEID());
        }
        super.onInit();
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psSysViewPanelFieldList) {
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_PARAM";
    }

    @Override
    public String getValue() {
        if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getRAWCONTENT())) {
            return this.psSysPanelItem.getRAWCONTENT();
        }
        if (this.getPSSysResource() != null) {
            return this.getPSSysResource().getContent();
        }
        return null;
    }

    public IPSSysResource getPSSysResource() {
        return this.iPSSysResource;
    }

    @Override
    public IPSUIAction getPSUIAction() {
        return super.getPSUIAction();
    }

    @Override
    public String getTooltip() {
        if (!StringHelper.isNullOrEmpty((String)this.psSysPanelItem.getTOOLTIPINFO())) {
            return this.psSysPanelItem.getTOOLTIPINFO();
        }
        if (this.getPSUIAction() != null) {
            return this.getPSUIAction().getTooltip();
        }
        return null;
    }

    @Override
    public String getKey() {
        if (StringHelper.isNullOrEmpty((String)this.getPredefinedType())) {
            return this.getName();
        }
        return this.getPredefinedType();
    }
}

