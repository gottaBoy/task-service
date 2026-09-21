/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDBTypeEx;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEFDTColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEFDTColumnGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEFDTColumn, IPSDEFDTColumn> {
    private static final Log log = LogFactory.getLog(PSDEFDTColumnGlobalModel.class);
    private static final PSDEFDTColumn PSDEFDTCOLUMN = new PSDEFDTColumn();
    protected IPSDEDBConfig iPSDEDBConfig = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDBConfig iPSDEDBConfig) {
        this.iPSDEDBConfig = iPSDEDBConfig;
        CallResult callResult = super.Init(iDAGlobalHelper, iPSDEDBConfig.getPSDataEntity());
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected PSDEFDTColumn GetObject(String strPSDEFDTColumnId) {
        if (this.isPrepareModels()) {
            return null;
        }
        log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u6570\u636e\u5e93\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFDTColumnId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEFDTColumn OnCreateModelHelper(PSDEFDTColumn vt) throws Exception {
        IPSDBType iPSDBType = this.iPSModelStorage.getPSDBType(vt.getDBType());
        IPSDEFDTColumn iPSDEFDTColumn = null;
        iPSDEFDTColumn = iPSDBType instanceof IPSDBTypeEx ? ((IPSDBTypeEx)iPSDBType).createPSDEFDTColumnEx(vt, this.iPSDEDBConfig) : iPSDBType.createPSDEFDTColumn(vt);
        IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(vt.getPSDEFName(), false);
        iPSDEFDTColumn.init(this.iDAGlobalHelper, this.iPSDEDBConfig, iPSDEField, vt);
        return iPSDEFDTColumn;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFDTColumn obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected Vector<PSDEFDTColumn> getAllModels() throws Exception {
        Vector<PSDEFDTColumn> psDEFDTColumnList = new Vector<PSDEFDTColumn>();
        if (!this.iPSDEDBConfig.isAutoModel()) {
            CallResult callResult = this.iPSModelHelper.getPSDEFDTColumns(this.getPSDataEntity().getId(), this.iPSDEDBConfig.getDBType(), psDEFDTColumnList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5b9e\u4f53\u5c5e\u6027\u6570\u636e\u5e93\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSDEFDTColumn psDEFDTColumn : psDEFDTColumnList) {
                if (!StringHelper.isNullOrEmpty((String)psDEFDTColumn.getPSDEFName())) continue;
                psDEFDTColumn.setPSDEFName(psDEFDTColumn.getPSDEFDTColName());
            }
            Collections.sort(psDEFDTColumnList, new Comparator<PSDEFDTColumn>(){

                @Override
                public int compare(PSDEFDTColumn o1, PSDEFDTColumn o2) {
                    return StringHelper.compare((String)o1.getPSDEFDTColName(), (String)o2.getPSDEFDTColName(), (boolean)false);
                }
            });
        }
        return psDEFDTColumnList;
    }

    @Override
    protected IPSDEFDTColumn registerModel(PSDEFDTColumn vt) throws Exception {
        IPSDEFDTColumn iPSDEFDTColumn = (IPSDEFDTColumn)this.InternalGetModelHelper(vt.getPSDEFName());
        if (iPSDEFDTColumn != null) {
            return iPSDEFDTColumn;
        }
        this.setModel(vt.getPSDEFName(), vt, null);
        iPSDEFDTColumn = (IPSDEFDTColumn)this.FindModelHelper(vt.getPSDEFName());
        this.setModel(vt.getPSDEFName(), PSDEFDTCOLUMN, iPSDEFDTColumn);
        return iPSDEFDTColumn;
    }

    @Override
    protected String getObjectId(PSDEFDTColumn vt) {
        return vt.getPSDEFName();
    }

    @Override
    public IPSDEFDTColumn FindModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSDEFDTColumn iPSDEFDTColumn = (IPSDEFDTColumn)super.FindModelHelper(objObjectId, true);
        if (iPSDEFDTColumn != null) {
            return iPSDEFDTColumn;
        }
        IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(objObjectId, true);
        if (iPSDEField == null || this.iPSDEDBConfig == null) {
            if (bTryMode) {
                return null;
            }
            return (IPSDEFDTColumn)super.FindModelHelper(objObjectId, bTryMode);
        }
        PSDEFDTColumn psDEFDTColumn = new PSDEFDTColumn();
        psDEFDTColumn.setPSDEFDTColId(KeyValueHelper.genUniqueId((String)iPSDEField.getId(), (String)this.iPSDEDBConfig.getDBType()));
        psDEFDTColumn.setPSDEFDTColName(iPSDEField.getName());
        psDEFDTColumn.setPSDEFId(iPSDEField.getId());
        psDEFDTColumn.setPSDEFName(iPSDEField.getName());
        psDEFDTColumn.setDBType(this.iPSDEDBConfig.getDBType());
        psDEFDTColumn.set("AUTOMODEL", 1);
        iPSDEFDTColumn = this.OnCreateModelHelper(psDEFDTColumn);
        this.setModel(objObjectId, psDEFDTColumn, iPSDEFDTColumn);
        this.internalAddAllModelHelper(iPSDEFDTColumn);
        return iPSDEFDTColumn;
    }
}

