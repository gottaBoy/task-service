/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u5916\u952e\u503c\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSPickupDEField
extends IPSLinkDEField {
    public IPSLinkDEField getPSPickupTextDEField() throws Exception;

    public String getPickupDataRange();

    public IPSDER1N getPSDER1N() throws Exception;
}

