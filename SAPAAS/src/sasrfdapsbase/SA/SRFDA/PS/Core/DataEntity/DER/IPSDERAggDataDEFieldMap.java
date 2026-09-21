/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggData;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERDEFieldMap;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u805a\u5408\u6570\u636e\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDERDEFMap")
public interface IPSDERAggDataDEFieldMap
extends IPSDERDEFieldMap {
    public static final String MAPTYPE_DIGEST = "DIGEST";
    public static final String MAPTYPE_SUM = "SUM";
    public static final String MAPTYPE_AVG = "AVG";
    public static final String MAPTYPE_MAX = "MAX";
    public static final String MAPTYPE_MIN = "MIN";
    public static final String MAPTYPE_COUNT = "COUNT";

    public String getMapType();

    public IPSDERAggData getPSDERAggData();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getFormulaFormat();

    public String getDrillDownCondFormat();
}

