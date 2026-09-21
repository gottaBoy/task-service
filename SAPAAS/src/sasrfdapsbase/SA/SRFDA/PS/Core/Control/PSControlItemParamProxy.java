/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControlItemParam;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import net.ibizsys.paas.util.StringHelper;

public class PSControlItemParamProxy
extends PSObjectImpl
implements IPSControlItemParam {
    private IPSModelObject iPSModelObject = null;
    private IPSControlItemParam iPSControlItemParam = null;

    public void init(IPSModelObject iPSModelObject, IPSControlItemParam iPSControlItemParam) {
        this.iPSModelObject = iPSModelObject;
        this.iPSControlItemParam = iPSControlItemParam;
        this.setName(this.iPSControlItemParam.getName());
    }

    protected IPSModelObject getOwner() {
        return this.iPSModelObject;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570")
    public String getKey() {
        return this.iPSControlItemParam.getKey();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.iPSControlItemParam.getCaption();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public String getValue() {
        return this.iPSControlItemParam.getValue();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247")
    public IPSSysImage getPSSysImage() {
        return this.iPSControlItemParam.getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u754c\u9762\u884c\u4e3a", hideempty=true, child=true)
    public IPSUIAction getPSUIAction() {
        return this.iPSControlItemParam.getPSUIAction();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        return this.iPSControlItemParam.getTooltip();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getOwner().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return StringHelper.format((String)"PSCONTROLITEMPARAM$%1$s", (Object)this.getOwner().getModelType());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getOwner().getModelId(), (Object)this.getName());
    }
}

