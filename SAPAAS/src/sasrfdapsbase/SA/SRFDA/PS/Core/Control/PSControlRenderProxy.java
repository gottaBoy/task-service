/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelParamImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSControlRenderProxy
extends PSObjectImpl
implements IPSControlRender {
    private static final Log log = LogFactory.getLog(PSControlRenderProxy.class);
    private IPSControl iPSControl = null;
    private IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail = null;
    private IPSLayoutPanel iPSLayoutPanel = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    public PSControlRenderProxy(IPSControl iPSControl, IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail) {
        this.iPSControl = iPSControl;
        this.iPSAppDEUILogicGroupDetail = iPSAppDEUILogicGroupDetail;
        if ("LAYOUTPANEL".equals(this.getRenderType())) {
            if (!StringHelper.IsNullOrEmpty((String)iPSAppDEUILogicGroupDetail.getPSSysViewPanelId())) {
                try {
                    PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
                    psSysPanelParamImpl.setPSSysPanelId(iPSAppDEUILogicGroupDetail.getPSSysViewPanelId());
                    IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("PANEL");
                    IPSControl iPSControl2 = iPSControlType.createPSControl(psSysPanelParamImpl);
                    IPSControlContainer iPSControlContainer = null;
                    iPSControlContainer = iPSControl instanceof IPSControlContainer ? (IPSControlContainer)((Object)iPSControl) : iPSControl.getPSControlContainer();
                    iPSControl2.init(this.getDAGlobalHelper(), iPSControlContainer, this.getName().toLowerCase(), psSysPanelParamImpl);
                    this.iPSLayoutPanel = (IPSLayoutPanel)iPSControl2;
                    iPSControlContainer.registerPSLayoutPanel(this.iPSLayoutPanel);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
        } else if ("PFPLUGIN".equals(this.getRenderType()) && !StringHelper.IsNullOrEmpty((String)iPSAppDEUILogicGroupDetail.getPSSysPFPluginId())) {
            try {
                this.iPSSysPFPlugin = iPSControl.getPSAppView().getPSApplication().getPSSysPFPlugin(iPSAppDEUILogicGroupDetail.getPSSysPFPluginId(), "CONTROLRENDER", null, null);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0", dump=false)
    public String getItemName() {
        return this.iPSAppDEUILogicGroupDetail.getItemName();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668\u540d\u79f0")
    public String getRenderName() {
        return this.iPSAppDEUILogicGroupDetail.getAttrName();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getName() {
        return this.iPSAppDEUILogicGroupDetail.getName();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSControl.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return StringHelper.Format((String)"PSCONTROLRENDER$%1$s", (Object)this.iPSControl.getModelType());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSControl.getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668\u7c7b\u578b", codelist="ControlRenderType")
    public String getRenderType() {
        if ("PFPLUGIN".equals(this.iPSAppDEUILogicGroupDetail.getLogicType())) {
            return "PFPLUGIN";
        }
        if ("SCRIPT".equals(this.iPSAppDEUILogicGroupDetail.getLogicType())) {
            return "LAYOUTPANEL_MODEL";
        }
        if ("LAYOUTPANEL".equals(this.iPSAppDEUILogicGroupDetail.getLogicType())) {
            return "LAYOUTPANEL";
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f\u6a21\u578b")
    public String getLayoutPanelModel() {
        if ("LAYOUTPANEL_MODEL".equals(this.getRenderType())) {
            return this.iPSAppDEUILogicGroupDetail.getScriptCode();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f", child=true)
    public IPSLayoutPanel getPSLayoutPanel() {
        return this.iPSLayoutPanel;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }
}

