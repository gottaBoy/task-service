/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u5916\u952e\u9644\u52a0\u6570\u636e\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSPickupDataDEField
extends IPSLinkDEField {
    public static final int DEFWRITEBACKMODE_DISABLED = 0;
    public static final int DEFWRITEBACKMODE_WRITEBACK = 1;
    public static final int DEFWRITEBACKMODE_IGNOREREFRESH = 2;

    public IPSPickupDEField getPSPickupDEField() throws Exception;

    public IPSDER1N getPSDER1N() throws Exception;

    public boolean isEnableWriteBack() throws Exception;

    public boolean isIgnoreRefresh() throws Exception;

    public IPSDEField getRealWriteBackPSDEField() throws Exception;
}

