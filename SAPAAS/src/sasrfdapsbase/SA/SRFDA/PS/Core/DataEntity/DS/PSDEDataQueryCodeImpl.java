/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 *  net.ibizsys.paas.core.IDEDataQueryCodeExp
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeCond;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryCodeCondGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryCodeExpGlobalModel;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDataQueryCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryCodeImpl
extends PSObjectImpl
implements IPSDEDataQueryCode {
    private static final Log log = LogFactory.getLog(PSDEDataQueryCodeImpl.class);
    protected IPSDEDataQuery iPSDEDataQuery;
    protected String strQueryCode;
    protected String strQueryCodeTemp;
    private String strDBType = "";
    protected PSDEDataQueryCodeExpGlobalModel psDEDataQueryCodeExpGlobalModel = new PSDEDataQueryCodeExpGlobalModel();
    protected PSDEDataQueryCodeCondGlobalModel psDEDataQueryCodeCondGlobalModel = new PSDEDataQueryCodeCondGlobalModel();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataQuery iPSDEDataQuery, PSDEDataQueryCode psDEDataQueryCode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataQuery = iPSDEDataQuery;
            this.setId(psDEDataQueryCode.getPSDEDQCODEID());
            this.setName(psDEDataQueryCode.getPSDEDQCODENAME());
            this.setPSObjectData(psDEDataQueryCode, false);
            this.strQueryCode = psDEDataQueryCode.getUSERQUERYCODE();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strQueryCode)) {
                this.strQueryCode = psDEDataQueryCode.getQUERYCODE();
            }
            this.strQueryCodeTemp = psDEDataQueryCode.getUSERQUERYCODE2();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strQueryCodeTemp)) {
                this.strQueryCodeTemp = psDEDataQueryCode.getQUERYCODETEMP();
            }
            this.strDBType = psDEDataQueryCode.getDBTYPE();
            this.psDEDataQueryCodeExpGlobalModel.Init(iDAGlobalHelper, this);
            this.psDEDataQueryCodeCondGlobalModel.Init(iDAGlobalHelper, this);
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
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7c7b\u578b", codelist="DBType", group="\u57fa\u672c", order=125, fields={"DBTYPE"})
    public String getDBType() {
        return this.strDBType;
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u4ee3\u7801", doctype="sql", group="\u57fa\u672c", order=130, fields={"USERQUERYCODE", "QUERYCODE"}, doc="\u4f18\u5148\u4f7f\u7528\u7528\u6237\u67e5\u8be2\u4ee3\u7801")
    public String getQueryCode() {
        return this.strQueryCode;
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6a21\u5f0f\u67e5\u8be2\u4ee3\u7801", dump=false, doctype="sql", group="\u57fa\u672c", order=132, fields={"USERQUERYCODE2", "QUERYCODETEMP"}, doc="\u4f18\u5148\u4f7f\u7528\u7528\u6237\u4e34\u65f6\u67e5\u8be2\u4ee3\u7801")
    public String getQueryCodeTemp() {
        return this.strQueryCodeTemp;
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f\u96c6\u5408", child=true, dynamodelmode=4, group="\u57fa\u672c", order=134)
    public Iterator<IPSDEDataQueryCodeExp> getPSDEDataQueryCodeExps() throws Exception {
        return this.psDEDataQueryCodeExpGlobalModel.getAllModelHelpers();
    }

    public Iterator<IDEDataQueryCodeCond> getDEDataQueryCodeConds() {
        return null;
    }

    @Override
    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    @Override
    public String getDeclareCode() {
        return "";
    }

    public void fillDeclareParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
    }

    public void fillQueryParams(IWebContext webContext, IDataObject iDataObject, SqlParamList sqlParamList) throws Exception {
    }

    public String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEDataQueryCodeCond iDEDataQueryCond, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u4ee3\u7801\u6761\u4ef6\u96c6\u5408", child=true, dynamodelmode=4, group="\u57fa\u672c", order=133)
    public Iterator<IPSDEDataQueryCodeCond> getPSDEDataQueryCodeConds() throws Exception {
        return this.psDEDataQueryCodeCondGlobalModel.getAllModelHelpers();
    }

    @Override
    public void loadAll() throws Exception {
        this.getPSDEDataQueryCodeConds();
        this.getPSDEDataQueryCodeExps();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataQuery.getPSSysModelInstId();
    }

    public String getDEFieldExp(String strName, boolean bTry) throws Exception {
        return null;
    }

    public String getExtJoinSQL(IDEDataSetFetchContext iDEDataSetFetchContext, String strCode, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return strCode;
    }

    public IDEDataQuery getDEDataQuery() {
        return this.getPSDEDataQuery();
    }

    public String getQueryCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return null;
    }

    public String getQueryCodeTemp(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return null;
    }

    public String getDeclareCode(IDEDataSetFetchContext iDEDataSetFetchContext, IDBDialect iDBDialect, SqlParamList list) throws Exception {
        return null;
    }

    public Iterator<IDEDataQueryCodeExp> getDEDataQueryCodeExps() {
        return null;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataQuery().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDEDQCODE";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDataQuery().getModelId(), (Object)this.getDBType());
    }

    @Override
    public IPSDEDataQueryCodeExp getPSDEDataQueryCodeExp(String strPSDEDataQueryCodeExpId, boolean bTryMode) throws Exception {
        return (IPSDEDataQueryCodeExp)this.psDEDataQueryCodeExpGlobalModel.FindModelHelper(strPSDEDataQueryCodeExpId, bTryMode);
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getDBType();
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return this.getPSDEDataQuery().getPSDataEntity().isEnableDynaModel();
    }

    @Override
    protected String onGetDynaModelFolder() {
        return String.format("%1$s/%2$s/%3$s", this.getPSDEDataQuery().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
    }

    @Override
    public String getCodeName() {
        return this.getDBType();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSDEDataQuery() != null) {
            return String.format("%1$s/%2$s", this.getPSDEDataQuery().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSDEDataQuery() != null) {
            return String.format("%1$s/%2$s", this.getPSDEDataQuery().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

