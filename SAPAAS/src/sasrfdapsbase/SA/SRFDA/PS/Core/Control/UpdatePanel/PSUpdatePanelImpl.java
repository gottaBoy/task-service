/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.UpdatePanel;

import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlImpl;
import SA.SRFDA.PS.Core.Control.UpdatePanel.IPSUpdatePanel;
import SA.SRFDA.PS.Core.Control.UpdatePanel.IPSUpdatePanelParam;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

@PSModelIgnoreMeta
public class PSUpdatePanelImpl
extends PSControlImpl
implements IPSUpdatePanel {
    protected IPSUpdatePanelParam iPSDEViewPanelParam = null;
    private IPSSysMsgTempl iPSSysMsgTempl = null;
    private IPSDEAction iPSDEAction = null;
    private int nTimer = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSControlContainer(iPSControlContainer);
        this.setName(strName);
        if (iPSControlParam != null) {
            this.iPSDEViewPanelParam = (IPSUpdatePanelParam)iPSControlParam;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.iPSDEViewPanelParam.getPSDEId()) && StringHelper.Compare((String)this.iPSDEViewPanelParam.getPSDEId(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) {
            this.setPSDataEntity(this.getPSDataEntity().getPSSystem().getPSDataEntity2(this.iPSDEViewPanelParam.getPSDEId()));
        }
        super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.iPSDEViewPanelParam.getPSSysMsgTemplId())) {
            this.iPSSysMsgTempl = this.getPSSystem().getPSSysMsgTempl(this.iPSDEViewPanelParam.getPSSysMsgTemplId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.iPSDEViewPanelParam.getPSDEActionId())) {
            if (this.getPSDataEntity() == null) {
                throw new Exception(StringHelper.Format((String)"\u89c6\u56fe\u66f4\u65b0\u9762\u677f[%1$s]\u6307\u5b9a\u5904\u7406\u884c\u4e3a\uff0c\u4f46\u89c6\u56fe\u4e2d\u6ca1\u6709\u5b9e\u4f53\u5bf9\u8c61", (Object)this.getName()));
            }
            this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.iPSDEViewPanelParam.getPSDEActionId());
        }
        if (this.iPSDEViewPanelParam.getTimer() != null && this.iPSDEViewPanelParam.getTimer() > 0) {
            this.nTimer = this.iPSDEViewPanelParam.getTimer();
        }
        super.onInit();
    }

    @Override
    protected String onGetControlType() {
        return "UPDATEPANEL";
    }

    @Override
    public IPSSysMsgTempl getPSSysMsgTempl() {
        return this.iPSSysMsgTempl;
    }

    @Override
    public String getModelScope() {
        return "VIEW";
    }

    @Override
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    public int getTimer() {
        return this.nTimer;
    }

    @Override
    public String getModelType() {
        return "PSUPDATEPANEL";
    }
}

