/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFramework.Utility.StringHelper;

public class PSControlAttributeProxy
extends PSObjectImpl
implements IPSControlAttribute {
    private IPSControl iPSControl = null;
    private IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail = null;

    public PSControlAttributeProxy(IPSControl iPSControl, IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail) {
        this.iPSControl = iPSControl;
        this.iPSAppDEUILogicGroupDetail = iPSAppDEUILogicGroupDetail;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0", dump=false)
    public String getItemName() {
        return this.iPSAppDEUILogicGroupDetail.getItemName();
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u5165\u5c5e\u6027\u540d\u79f0")
    public String getAttrName() {
        return this.iPSAppDEUILogicGroupDetail.getAttrName();
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u5165\u5c5e\u6027\u503c")
    public String getAttrValue() {
        return this.iPSAppDEUILogicGroupDetail.getScriptCode();
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
        return StringHelper.Format((String)"PSCONTROLATTRIBUTE$%1$s", (Object)this.iPSControl.getModelType());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSControl.getModelId(), (Object)this.getName());
    }
}

