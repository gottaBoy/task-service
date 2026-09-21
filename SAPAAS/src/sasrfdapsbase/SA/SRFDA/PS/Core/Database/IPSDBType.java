/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.db.SqlParamList
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDSCodePublisher;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcTempl;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeployDB;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Data.PSDBType;
import SA.SRFDA.PS.Data.PSDEDBConfig;
import SA.SRFDA.PS.Data.PSDEFDTColumn;
import SA.SRFDA.PS.Data.PSSystemDBConfig;
import SA.SRFDA.PS.Data.PSSystemDeployDB;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.SqlParamList;

@PSModelIgnoreMeta
public interface IPSDBType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDBType var2) throws Exception;

    public IPSSystemDeployDB createPSSystemDeployDB(PSSystemDeployDB var1) throws Exception;

    public IPSDEFDTColumn createPSDEFDTColumn(PSDEFDTColumn var1) throws Exception;

    public String getDriverName();

    public IPSDEDBConfig createPSDEDBConfig(PSDEDBConfig var1) throws Exception;

    public IPSSystemDBConfig createPSSystemDBConfig(PSSystemDBConfig var1) throws Exception;

    public void publishPSDataEntityDBModel(IPSPublisherContext var1, IPSDatabase var2, IPSDEDBConfig var3) throws Exception;

    public void publishPSDataEntityDBModel2(IPSPublisherContext var1, IPSDatabase var2, IPSDEDBConfig var3) throws Exception;

    public void publishPSDataEntityDBModel(IPSPublisherContext var1, IPSDatabase var2, IPSDEDBConfig var3, boolean var4) throws Exception;

    public IPSDEDQCodePublisher getPSDEDQCodePublisher() throws Exception;

    public void releasePSDEDQCodePublisher(IPSDEDQCodePublisher var1);

    public void resetPSDEDQCodePublishers();

    public IPSDEDQEngine createPSDEDQEngine();

    public IPSDEDSCodePublisher getPSDEDSCodePublisher() throws Exception;

    public void releasePSDEDSCodePublisher(IPSDEDSCodePublisher var1);

    public void resetPSDEDSCodePublishers();

    public SqlParamList getDBProcParamList(IPSDatabase var1, String var2) throws Exception;

    public IPSDBSysProcTempl getPSDBSysProcTempl(String var1) throws Exception;

    public void resetPSDBSysProcTempl(String var1);

    public CallResult callCreateDBModelSql(IPSDatabase var1, String var2) throws Exception;

    public CallResult compileDBProc(IPSDatabase var1, String var2, String var3) throws Exception;

    public String getHibernateDialect();

    public String getJdbcDialect();

    public String getDBObjStandardName(String var1);

    public String getDBClientPath(String var1);

    public String getFuncSQL(String var1, boolean var2, String[] var3) throws Exception;

    public IDBFunction getDBFunction(String var1) throws Exception;
}

