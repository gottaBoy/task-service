/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.db.SqlParamList
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSBDType;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.Database.PSDBTypeImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSDBPublisherContext;
import SA.SRFDA.PS.Data.PSBDType;
import SA.SRFDA.PS.Data.PSDBType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import net.ibizsys.paas.db.SqlParamList;

@PSModelIgnoreMeta
public class PSBDTypeImpl
extends PSDBTypeImpl
implements IPSBDType {
    protected PSBDType psBDType = null;
    private String strBDType = "";
    private boolean bNullValue = false;
    private boolean bSupportSQLQuery = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSBDType psBDType) throws Exception {
        PSDBType psDBType = new PSDBType();
        psBDType.CopyTo(psDBType, false);
        psDBType.setPSDBTYPEID(psBDType.getPSBDTYPEID());
        psDBType.setPSDBTYPENAME(psBDType.getPSBDTYPENAME());
        this.init(iDAGlobalHelper, psDBType);
        this.psBDType = psBDType;
        this.setId(this.psBDType.getPSBDTYPEID());
        this.setName(this.psBDType.getPSBDTYPENAME());
        this.setPSObjectData(this.psBDType);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public boolean isSupportSQLQuery() {
        return this.bSupportSQLQuery;
    }

    @Override
    public SqlParamList getDBProcParamList(IPSDatabase iPSDatabase, String strProcName) throws Exception {
        throw new Exception("\u4e0d\u652f\u6301\u6b64\u529f\u80fd");
    }

    @Override
    protected boolean isTableExists(IPSDatabase iPSDatabase, String strTableName, boolean bTempMode) throws Exception {
        throw new Exception("\u4e0d\u652f\u6301\u6b64\u529f\u80fd");
    }

    @Override
    protected boolean isTableColumnExists(IPSDatabase iPSDatabase, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode) throws Exception {
        throw new Exception("\u4e0d\u652f\u6301\u6b64\u529f\u80fd");
    }

    @Override
    protected ArrayList<String> getTableColumns(IPSDatabase iPSDatabase, String strTableName, boolean bTempMode) throws Exception {
        throw new Exception("\u4e0d\u652f\u6301\u6b64\u529f\u80fd");
    }

    @Override
    protected boolean isViewExists(IPSDatabase iPSDatabase, String strViewName, boolean bTempMode) throws Exception {
        throw new Exception("\u4e0d\u652f\u6301\u6b64\u529f\u80fd");
    }

    @Override
    protected void fillCreateTableSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strTableName, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        throw new Exception("\u4e0d\u652f\u6301\u6b64\u529f\u80fd");
    }

    @Override
    protected boolean isFKeyExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, String strFKName) throws Exception {
        throw new Exception("\u4e0d\u652f\u6301\u6b64\u529f\u80fd");
    }

    @Override
    protected boolean isIndexExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        throw new Exception("\u4e0d\u652f\u6301\u6b64\u529f\u80fd");
    }

    @Override
    protected String getCreateIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        throw new Exception("\u4e0d\u652f\u6301\u6b64\u529f\u80fd");
    }
}

