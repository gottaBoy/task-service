/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEFSearchMode
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.web.IWebContext
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetCode;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEDataSetCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.web.IWebContext;

public class PSDEDataSetCodeImpl
extends PSObjectImpl
implements IPSDEDataSetCode {
    protected IPSDEDataSet iPSDEDataSet;
    protected PSDEDataSetCode psDEDataSetCode;
    protected String strQueryCode;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataSet iPSDEDataSet, PSDEDataSetCode psDEDataSetCode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDEDataSet = iPSDEDataSet;
        this.psDEDataSetCode = psDEDataSetCode;
        this.setId(this.psDEDataSetCode.getPSDEDSCODEID());
        this.setName(this.psDEDataSetCode.getPSDEDSCODENAME());
        this.setPSObjectData(this.psDEDataSetCode);
        this.strQueryCode = this.psDEDataSetCode.getUSERQUERYCODE();
        if (StringHelper.IsNullOrEmpty((String)this.strQueryCode)) {
            this.strQueryCode = this.psDEDataSetCode.getQUERYCODE();
        }
        this.onInit();
    }

    public String getDBType() {
        return this.psDEDataSetCode.getDBTYPE();
    }

    public String getQueryCode() {
        return this.strQueryCode;
    }

    public String getDeclareScript() {
        return null;
    }

    public String replaceURLParamMacro(String strFinalScript, IWebContext webContext, boolean bTestPost) throws Exception {
        return null;
    }

    public String replaceURLParamMacro(String strFinalScript, IWebContext webContext) throws Exception {
        return null;
    }

    public String replaceDynamicTableMacro(String strFinalScript, ArrayList<String> dynamicTables) throws Exception {
        return null;
    }

    public void fillDeclareParams(SqlParamList sqlParamList, IWebContext webContext, IDataObject iDataObject) throws Exception {
    }

    public void fillSqlParams(SqlParamList sqlParamList, IWebContext webContext, IDataObject iDataObject) throws Exception {
    }

    public void fillSqlParams(SqlParamList sqlParamList, IWebContext webContext) throws Exception {
    }

    public String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEField iDEField, String strFunc, String strAction, String strValue) throws Exception {
        return null;
    }

    public String getConditionSQL(IDEDataSetFetchContext iDEDataSetFetchContext, IDEFSearchMode iDEFSearchItem, String strValue) throws Exception {
        return null;
    }

    public String getDEFieldExp(IDEField iDEField) throws Exception {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEDataSet.getPSSysModelInstId();
    }
}

