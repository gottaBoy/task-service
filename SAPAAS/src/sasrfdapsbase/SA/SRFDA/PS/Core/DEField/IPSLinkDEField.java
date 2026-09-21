/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u94fe\u63a5\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSLinkDEField
extends IPSDEField {
    public IPSDEField getRelatedPSDEField() throws Exception;

    public IPSDEField getRealPSDEField() throws Exception;

    public IPSDEField getRealPSDEField(boolean var1) throws Exception;

    public IPSDERBase getPSDER() throws Exception;

    public boolean isCustomJoin();

    public String getDERId();

    public IPSDataEntity getRelatedPSDataEntity() throws Exception;

    public IPSDataEntity getRealPSDataEntity() throws Exception;
}

