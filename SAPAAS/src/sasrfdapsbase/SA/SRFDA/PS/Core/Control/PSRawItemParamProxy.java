/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSRawItemParam;
import SA.SRFDA.PS.Core.Control.PSControlItemParamProxy;
import SA.SRFDA.PS.Core.IPSModelObject;

public class PSRawItemParamProxy
extends PSControlItemParamProxy
implements IPSRawItemParam {
    public void init(IPSModelObject iPSModelObject, IPSRawItemParam iPSRawItemParam) {
        super.init(iPSModelObject, iPSRawItemParam);
    }

    public static IPSRawItemParam from(IPSModelObject iPSModelObject, IPSRawItemParam iPSRawItemParam) {
        PSRawItemParamProxy psRawItemParamProxy = new PSRawItemParamProxy();
        psRawItemParamProxy.init(iPSModelObject, iPSRawItemParam);
        return psRawItemParamProxy;
    }
}

