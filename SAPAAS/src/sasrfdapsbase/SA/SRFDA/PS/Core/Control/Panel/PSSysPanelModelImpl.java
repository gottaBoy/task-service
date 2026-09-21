/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.Panel.IPSPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelItem;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSysPanelModel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPanelModelImpl
extends PSObjectImpl
implements IPSSysPanelModel {
    private static final Log log = LogFactory.getLog(PSSysPanelModelImpl.class);
    protected IPSSysPanel iPSSysPanel;
    protected PSSysPanelModel psSysPanelModel;
    private String strCodeName = "";
    private boolean bContextModel = false;
    private String strDataType = "OBJECT";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysPanel iPSSysPanel, PSSysPanelModel psSysPanelModel) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysPanel = iPSSysPanel;
            this.psSysPanelModel = psSysPanelModel;
            this.setId(psSysPanelModel.getPSSYSVIEWPANELMODELID());
            this.setName(psSysPanelModel.getPSSYSVIEWPANELMODELNAME());
            this.setPSObjectData(psSysPanelModel);
            this.strCodeName = this.psSysPanelModel.getCODENAME();
            if (StringHelper.Compare((String)this.psSysPanelModel.getMODELTYPE(), (String)"CONTEXTMODEL", (boolean)true) == 0) {
                this.bContextModel = true;
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelModel.getDATATYPE())) {
                this.strDataType = this.psSysPanelModel.getDATATYPE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IPSSysPanel getPSSysPanel() {
        return this.iPSSysPanel;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u7c7b\u578b", codelist="PanelModelType")
    public String getType() {
        return this.psSysPanelModel.getMODELTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b", codelist="CtrlModelDataType")
    public String getDataType() {
        return this.strDataType;
    }

    public boolean isDesignMode() {
        return this.iPSSysPanel.isDesignMode();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysPanel.getPSSysModelInstId();
    }

    public IPSSystem getPSSystem() {
        return this.getPSSysPanel().getPSAppView().getPSSystem();
    }

    @Override
    public IPSPanel getPSPanel() {
        return this.getPSSysPanel();
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELMODEL";
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysPanel().getModelId(), (Object)this.getName());
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysPanel().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6210\u5458\u5bf9\u8c61", hideempty=true)
    public IPSPanelItem getPSPanelItem() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psSysPanelModel.getPSSYSVIEWPANELITEMID())) {
            return null;
        }
        return this.getPSSysPanel().getPSPanelItem(this.psSysPanelModel.getPSSYSVIEWPANELITEMID());
    }

    @Override
    public boolean isContextModel() {
        return this.bContextModel;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6a21\u578b", ignoredumpvalues="false")
    public boolean isViewModel() {
        return "VIEWMODEL".equals(this.getType());
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6a21\u578b", ignoredumpvalues="false")
    public boolean isPanelModel() {
        return "PANELMODEL".equals(this.getType());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6a21\u578b", ignoredumpvalues="false")
    public boolean isCtrlModel() {
        return "CTRLMODEL".equals(this.getType());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysPanel().getPSAppView().getPSSystem());
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSSysPanel().getPSAppView().getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }
}

