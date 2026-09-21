/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMapObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEMapDataSet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6620\u5c04\u6570\u636e\u96c6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEMapDS")
public interface IPSDEMapDataSet
extends IPSDEMapObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEMap var2, PSDEMapDataSet var3) throws Exception;

    public IPSDEDataSet getSrcPSDEDataSet();

    public IPSDEDataSet getDstPSDEDataSet();

    public Properties getMapParams();

    public String getMapMode();

    public boolean isEnableDQCond();
}

