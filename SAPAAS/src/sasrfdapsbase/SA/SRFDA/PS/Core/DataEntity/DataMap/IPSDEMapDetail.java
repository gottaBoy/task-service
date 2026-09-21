/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEMapDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDEMapDetail
extends IPSModelObject,
IPSDEMapField {
    public void init(ISRFDAGlobalHelper var1, IPSDEMap var2, PSDEMapDetail var3) throws Exception;

    @Override
    public String getDstFieldName();

    @Override
    public String getSrcFieldName();

    @Override
    public String getSrcValue();
}

