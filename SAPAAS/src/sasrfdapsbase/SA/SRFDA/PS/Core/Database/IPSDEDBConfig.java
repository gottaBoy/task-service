/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDBConfig
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Data.PSDEDBConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDBConfig;

@PSModelPFIgnoreMeta
public interface IPSDEDBConfig
extends IPSDataEntityObject,
IDEDBConfig {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDBConfig var3) throws Exception;

    public String getDBType();

    public String getLogicValidSQLCode(boolean var1);

    public IPSDEFDTColumn getPSDEFDTColumn(String var1) throws Exception;

    public IPSDEFDTColumn getPSDEFDTColumn(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEFDTColumn> getAllPSDEFDTColumns() throws Exception;

    public void publishDBModel(IPSPublisherContext var1, IPSDatabase var2) throws Exception;

    public void publishDBModel2(IPSPublisherContext var1, IPSDatabase var2) throws Exception;

    public void loadAll() throws Exception;

    public String getTableSpace();

    public boolean isUnicodeChar();

    @Deprecated
    public boolean isValidFlag();

    public boolean isValid();

    public boolean isPubModel();

    public boolean isCustomTableOrView();

    public String getViewName(int var1);

    public String getSaaSDataIdColumnName();

    public String getSaaSDCIdColumnName();

    public String getObjNameCase();

    public IPSSystemDBConfig getPSSystemDBConfig();

    public String getTableName();

    public String getUserTable();

    public String getViewName();

    public String getView2Name();

    public String getView3Name();

    public String getView4Name();

    public String getStandardTableName();
}

