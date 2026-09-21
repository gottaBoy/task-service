/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.PSSysDBTableObjectImpl;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysDBColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysDBColumnImpl
extends PSSysDBTableObjectImpl
implements IPSSysDBColumn {
    private static final Log log = LogFactory.getLog(PSSysDBColumnImpl.class);
    protected IPSDEDBConfig iPSDEDBConfig = null;
    private String strQueryCS = "";
    private boolean bFKey = false;
    private boolean bPKey = false;
    private boolean bAutoIncrement = false;
    private boolean bUnsigned = false;
    private String strDefaultValue = "";
    private PSSysDBColumn psSysDBColumn = null;
    private boolean bNullable = true;
    private int nStdDataType = 0;
    private int nLength = -1;
    private IPSSysDBTable refPSSysDBTable = null;
    private IPSSysDBColumn refPSSysDBColumn = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDBTable iPSSysDBTable, PSSysDBColumn psSysDBColumn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psSysDBColumn = psSysDBColumn;
            this.setId(psSysDBColumn.getPSSYSDBCOLUMNID());
            this.setName(psSysDBColumn.getPSSYSDBCOLUMNNAME());
            this.setPSSysDBTable(iPSSysDBTable);
            this.setPSObjectData(psSysDBColumn, false);
            if (!this.psSysDBColumn.isPKEYNull()) {
                boolean bl = this.bPKey = this.psSysDBColumn.getPKEY() == 1;
            }
            if (!this.psSysDBColumn.isFKEYNull()) {
                this.bFKey = this.psSysDBColumn.getFKEY();
            }
            if (!this.psSysDBColumn.isIDENTITYMODENull()) {
                this.bAutoIncrement = this.psSysDBColumn.getIDENTITYMODE();
            }
            if (!this.psSysDBColumn.isUNSIGNEDMODENull()) {
                this.bUnsigned = this.psSysDBColumn.getUNSIGNEDMODE();
            }
            if (!this.psSysDBColumn.isALLOWEMPTYNull()) {
                this.bNullable = this.psSysDBColumn.getALLOWEMPTY();
            }
            this.strDefaultValue = this.psSysDBColumn.getDEFAULTVALUE();
            if (!this.psSysDBColumn.isSTDDATATYPENull()) {
                this.nStdDataType = this.psSysDBColumn.getSTDDATATYPE();
            }
            if (!this.psSysDBColumn.isLENGTHNull() && this.psSysDBColumn.getLENGTH() >= 0) {
                this.nLength = this.psSysDBColumn.getLENGTH();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected int onCheck() throws Exception {
        this.getRefPSSysDBColumn();
        this.getRefPSSysDBTable();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e", ignoredumpvalues="false", group="\u57fa\u672c", order=120, fields={"PKEY"})
    public boolean isPKey() {
        return this.bPKey;
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u6bb5\u957f\u5ea6", ignoredumpvalues="-1;0", group="\u57fa\u672c", order=153, fields={"LENGTH"})
    public int getLength() throws Exception {
        return this.nLength;
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u6bb5\u7cbe\u5ea6", ignoredumpvalues="0", group="\u57fa\u672c", order=155, fields={"PRECISION2"})
    public int getPrecision() throws Exception {
        return this.psSysDBColumn.getPRECISION2();
    }

    @Override
    public int getScale() throws Exception {
        return this.getLength();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", fields={"DEFAULTVALUE"})
    public String getDefaultValue() throws Exception {
        return this.strDefaultValue;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165", ignoredumpvalues="false", group="\u57fa\u672c", order=160, fields={"ALLOWEMPTY"})
    public boolean isNullable() {
        return this.bNullable;
    }

    public String getQueryCaseSenstive() {
        return this.strQueryCS;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u589e\u5217", ignoredumpvalues="false", fields={"IDENTITYMODE"})
    public boolean isAutoIncrement() {
        return this.bAutoIncrement;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u7b26\u53f7\u5217", ignoredumpvalues="false", fields={"UNSIGNEDMODE"})
    public boolean isUnsigned() {
        return this.bUnsigned;
    }

    @Override
    public String getModelType() {
        return "PSSYSDBCOLUMN";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysDBTable().getModelId(), (Object)this.getName());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysDBTable().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysDBScheme().getPSSystem());
    }

    @Override
    public String getModelName() {
        return super.getModelName();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysDBColumn.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psSysDBColumn.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", fields={"CODENAME2"})
    public String getCodeName2() {
        return this.psSysDBColumn.getCODENAME2();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", group="\u57fa\u672c", order=150, fields={"STDDATATYPE"})
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b", fields={"DATATYPE"})
    public String getDataType() {
        return this.psSysDBColumn.getDATATYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acbSQL", fields={"CREATESQL"})
    public String getCreateSql() {
        return this.psSysDBColumn.getCREATESQL();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u9664SQL", fields={"DROPSQL"})
    public String getDropSql() {
        return this.psSysDBColumn.getDROPSQL();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u952e", ignoredumpvalues="false", fields={"FKEY"})
    public boolean isFKey() {
        return this.bFKey;
    }

    @Override
    public String getNameByDBType(String strDBType) throws Exception {
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(strDBType, true);
        if (iPSDBType == null) {
            throw new Exception(String.format("\u4e0d\u652f\u6301\u7684\u6570\u636e\u5e93\u7c7b\u578b[%1$s]", strDBType));
        }
        return iPSDBType.getDBObjStandardName(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6570\u636e\u8868", hideempty=true, from="IPSSysDBScheme", dumpref=true)
    public IPSSysDBTable getRefPSSysDBTable() throws Exception {
        this.prepareRefPSSysDBColumn();
        return this.refPSSysDBTable;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6570\u636e\u5217", hideempty=true, from="getRefPSSysDBTable()", dumpref=true)
    public IPSSysDBColumn getRefPSSysDBColumn() throws Exception {
        this.prepareRefPSSysDBColumn();
        return this.refPSSysDBColumn;
    }

    protected void prepareRefPSSysDBColumn() throws Exception {
        if (!this.isFKey()) {
            return;
        }
        if (this.refPSSysDBTable != null || this.refPSSysDBColumn != null) {
            return;
        }
        if (StringHelper.isNullOrEmpty((String)this.psSysDBColumn.getREFPSSYSDBTABLEID()) || StringHelper.isNullOrEmpty((String)this.psSysDBColumn.getREFPSSYSDBCOLUMNID())) {
            return;
        }
        boolean bClose = false;
        ActionSession actionSession = null;
        try {
            actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSSysDBColumnImpl");
                actionSession.registerRecursion("PSSYSDBCOLUMN", (Object)this.getId());
            } else if (!actionSession.registerRecursion("PSSYSDBCOLUMN", (Object)this.getId())) {
                throw new Exception(StringHelper.format((String)"\u6570\u636e\u5217[%1$s]\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.getFullName()));
            }
            this.refPSSysDBTable = this.getPSSysDBScheme().getPSSysDBTable(this.psSysDBColumn.getREFPSSYSDBTABLEID());
            this.refPSSysDBColumn = this.refPSSysDBTable.getPSSysDBColumn(this.psSysDBColumn.getREFPSSYSDBCOLUMNID());
            actionSession.unregisterRecursion("PSSYSDBCOLUMN", (Object)this.getId());
            if (bClose) {
                ActionSessionManager.closeSession();
            }
        }
        catch (Exception ex) {
            this.refPSSysDBTable = null;
            this.refPSSysDBColumn = null;
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5217\u6807\u8bb0", fields={"COLUMNTAG"})
    public String getColumnTag() {
        return this.psSysDBColumn.getCOLUMNTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5217\u6807\u8bb02", fields={"COLUMNTAG2"})
    public String getColumnTag2() {
        return this.psSysDBColumn.getCOLUMNTAG2();
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getName();
    }
}

