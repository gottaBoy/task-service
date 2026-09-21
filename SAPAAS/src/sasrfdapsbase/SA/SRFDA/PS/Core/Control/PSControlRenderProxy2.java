/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFramework.Utility.StringHelper;

@PSModelIgnoreMeta
public class PSControlRenderProxy2
extends PSObjectImpl
implements IPSControlRender {
    private IPSControl iPSControl = null;
    private IPSControlRender iPSControlRender = null;

    public PSControlRenderProxy2(IPSControl iPSControl, IPSControlRender iPSControlRender) {
        this.iPSControl = iPSControl;
        this.iPSControlRender = iPSControlRender;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0", dump=false)
    public String getItemName() {
        return this.iPSControlRender.getItemName();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u5668\u540d\u79f0")
    public String getRenderName() {
        return this.iPSControlRender.getRenderName();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getName() {
        return this.iPSControlRender.getName();
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
        return this.iPSControlRender.getRenderType();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f\u6a21\u578b")
    public String getLayoutPanelModel() {
        return this.iPSControlRender.getLayoutPanelModel();
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u9762\u677f", child=true)
    public IPSLayoutPanel getPSLayoutPanel() {
        return this.iPSControlRender.getPSLayoutPanel();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSControlRender.getPSSysPFPlugin();
    }
}

