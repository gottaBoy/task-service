/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.PSCodePublisherMacroImplBase;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSCodePublisherParamImplBase
extends PSCodePublisherMacroImplBase
implements IPSCodePublisherParam {
    private String strDesc = null;
    private String strValueInterface = null;

    public PSCodePublisherParamImplBase(IPSModelObject iPSModelObject, String strKey, Object objValue, String strDesc, String strValueInterface) {
        super(iPSModelObject, strKey, objValue);
        this.strDesc = strDesc;
        this.strValueInterface = strValueInterface;
    }

    @Override
    @PSModelRTMeta(description="\u503c", order=110)
    public Object getValue() {
        if (super.getValue() == null) {
            return "(\u53d1\u5e03\u65f6\u6307\u5b9a)";
        }
        return super.getValue();
    }

    @Override
    @PSModelRTMeta(description="\u8bf4\u660e", order=130)
    public String getDesc() {
        return this.strDesc;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5bf9\u8c61\u63a5\u53e3", order=120)
    public String getValueInterface() {
        if (StringHelper.isNullOrEmpty((String)this.strValueInterface) && this.getValue() instanceof IPSModelObject) {
            return ((IPSModelObject)this.getValue()).getModelInterface();
        }
        return this.strValueInterface;
    }
}

