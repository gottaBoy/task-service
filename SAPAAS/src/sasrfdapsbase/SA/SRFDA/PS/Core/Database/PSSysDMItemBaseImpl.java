/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDMItemBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSysDMItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;

@PSModelIgnoreMeta
public abstract class PSSysDMItemBaseImpl
extends PSObjectImpl
implements IPSSysDMItemBase {
    private PSSysDMItem psSysDMItem = null;
    private String strCreateSql = null;
    private long nCreateTime = 0L;
    private long nUpdateTime = 0L;
    private String strDBObjType = "";
    private String strPSDEId = "";
    private String strPSDEName = "";
    private boolean bUserCustomMode = false;
    private String strDropSql = "";
    private String strBeforeCreateSql = "";
    private String strAfterCreateSql = "";
    private String strTestSql = "";
    private String strPSObjId = "";
    private String strPSObjName = "";
    private String strDBType = "";
    private String strAfterCreateSql2 = "";
    private String strPSSystemDBCfgId = "";

    protected void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSysDMItem psSysDMItem) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psSysDMItem = psSysDMItem;
        this.setId(this.psSysDMItem.getPSSYSDMITEMID());
        this.setName(this.psSysDMItem.getPSSYSDMITEMNAME());
        this.setPSObjectData(this.psSysDMItem);
        this.strCreateSql = this.psSysDMItem.getCREATESQL();
        if (StringHelper.isNullOrEmpty((String)this.strCreateSql)) {
            this.strCreateSql = this.psSysDMItem.getCREATESQL4();
        }
        if (!psSysDMItem.isCREATEDATENull()) {
            this.nCreateTime = this.psSysDMItem.getCREATEDATE().getTime();
        }
        if (!psSysDMItem.isUPDATEDATENull()) {
            this.nUpdateTime = this.psSysDMItem.getUPDATEDATE().getTime();
        }
        this.strDBObjType = this.psSysDMItem.getDBOBJTYPE();
        this.strPSDEId = this.psSysDMItem.getPSDEID();
        this.strPSDEName = this.psSysDMItem.getPSDENAME();
        this.bUserCustomMode = this.psSysDMItem.getUSERFLAG();
        this.strDropSql = this.psSysDMItem.getDROPSQL();
        this.strBeforeCreateSql = this.psSysDMItem.getCREATESQL3();
        this.strAfterCreateSql = this.psSysDMItem.getCREATESQL2();
        this.strTestSql = this.psSysDMItem.getTESTSQL();
        this.strPSObjId = this.psSysDMItem.getPSOBJID();
        this.strPSObjName = this.psSysDMItem.getPSOBJNAME();
        this.strDBType = this.psSysDMItem.getPSSYSTEMDBCFGNAME();
        this.strAfterCreateSql2 = this.psSysDMItem.getCREATESQL5();
        this.strPSSystemDBCfgId = this.psSysDMItem.getPSSYSTEMDBCFGID();
        this.onInit();
    }

    @Override
    public String getDBObjType() {
        return this.strDBObjType;
    }

    @Override
    public boolean isUserCustomMode() {
        return this.bUserCustomMode;
    }

    @Override
    public String getDropSql() {
        return this.strDropSql;
    }

    @Override
    public String getBeforeCreateSql() {
        return this.strBeforeCreateSql;
    }

    @Override
    public String getCreateSql() {
        return this.strCreateSql;
    }

    @Override
    public String getAfterCreateSql() {
        return this.strAfterCreateSql;
    }

    @Override
    public String getTestSql() {
        return this.strTestSql;
    }

    @Override
    public String getPSObjId() {
        return this.strPSObjId;
    }

    @Override
    public String getPSObjName() {
        return this.strPSObjName;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7c7b\u578b", codelist="DBType")
    public String getDBType() {
        return this.strDBType;
    }

    @Override
    public String getPSDEId() {
        return this.strPSDEId;
    }

    @Override
    public String getPSDEName() {
        return this.strPSDEName;
    }

    @Override
    public String getPSSystemDBCfgId() {
        return this.strPSSystemDBCfgId;
    }

    @Override
    public String getAfterCreateSql2() {
        return this.strAfterCreateSql2;
    }

    @Override
    public long getCreateTime() {
        return this.nCreateTime;
    }

    @Override
    public long getUpdateTime() {
        return this.nUpdateTime;
    }
}

