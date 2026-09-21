/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggDataDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u805a\u5408\u6570\u636e\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DERAGGDATA"})
public interface IPSDERAggData
extends IPSDERBase {
    public Iterator<IPSDERAggDataDEFieldMap> getPSDERAggDataDEFieldMaps();

    public IPSDEDataSet getSourcePSDEDataSet() throws Exception;

    public String getSourcePSDEDataSetId();
}

