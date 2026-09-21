/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEOPPriv
 */
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSDEOPPriv;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEOPPriv;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEOPPriv")
public interface IPSDEOPPriv
extends IPSDataEntityObject,
IDEOPPriv {
    public static final String DEFIELDPRIV_PREFIX = "DEFIELD__";
    public static final String OPPRIVTYPE_DEFAULT = "DEFAULT";
    public static final String OPPRIVTYPE_DEFGROUP = "DEFGROUP";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, IPSDataEntity var3, PSDEOPPriv var4) throws Exception;

    @Override
    public IPSDataEntity getPSDataEntity();

    public String getLogicName();

    public String getPSDERName();

    public IPSDERBase getPSDER();

    public String getMapPSDEOPPrivName();

    public String getMapPSDERName();

    public IPSDERBase getMapPSDER();

    public IPSDER1N getMapPSDER1N();

    public IPSSysUniRes getMapPSSysUniRes();

    public boolean isMapSysUniRes();

    public String getMapSysUniResCode();

    public String getMapPSDEName();

    public IPSDataEntity getMapPSDataEntity();

    public boolean isSystemReserved();

    public boolean isDEFieldPriv();

    public IPSDEField getPSDEField();

    public String getOPPrivType();

    public IPSDEFGroup getPSDEFGroup();
}

