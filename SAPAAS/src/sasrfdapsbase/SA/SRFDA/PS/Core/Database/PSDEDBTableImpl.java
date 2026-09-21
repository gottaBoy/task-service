/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.Database.IPSDEDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEDBTable;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEDBTableImpl
extends PSDataEntityObjectImpl
implements IPSDEDBTable {
    private static final Log log = LogFactory.getLog(PSDEDBTableImpl.class);
    private PSDEDBTable psDETable = null;
    private IPSSysDBTable iPSSysDBTable = null;
    private String strCodeName = null;
    private List<IPSDEField> psDEFieldList = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDBTable psDETable) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.setId(psDETable.getPSDETABLEID());
            this.setName(psDETable.getPSDETABLENAME());
            this.setPSObjectData(psDETable, false);
            this.psDETable = psDETable;
            if (this.getPSDataEntity().getPSSysDBScheme() != null && !StringHelper.IsNullOrEmpty((String)this.getPSSysDBTableId())) {
                this.iPSSysDBTable = this.getPSDataEntity().getPSSysDBScheme().getPSSysDBTable(this.getPSSysDBTableId());
            }
            if (StringHelper.Compare((String)this.getTableType(), (String)"MAIN", (boolean)true) == 0) {
                this.strCodeName = "Table";
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u8868\u7c7b\u578b", codelist="DETableType", group="\u57fa\u672c", order=125, fields={"TABLETYPE"})
    public String getTableType() {
        return this.psDETable.getTABLETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6570\u636e\u5e93\u8868", dumpref=true, from="IPSDataEntity", from_method="getPSSysDBSchemeMust().getPSSysDBTable", group="\u57fa\u672c", order=127)
    public IPSSysDBTable getPSSysDBTable() {
        return this.iPSSysDBTable;
    }

    @Override
    public String getModelType() {
        return "PSDETABLE";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5c5e\u6027\u96c6\u5408", child=true, dumpref=true, ignorert=1, from="IPSDataEntity", group="\u57fa\u672c", order=145)
    public Iterator<IPSDEField> getAllPSDEFields() throws Exception {
        if (this.psDEFieldList != null) {
            return this.psDEFieldList.iterator();
        }
        ArrayList<IPSDEField> psDEFieldList = new ArrayList<IPSDEField>();
        Iterator<IPSDEField> allPSDEFields = this.getPSDataEntity().getAllPSDEFields();
        while (allPSDEFields.hasNext()) {
            IPSDEField iPSDEField = allPSDEFields.next();
            if (iPSDEField.getPSDEDBTable() == null || StringHelper.Compare((String)iPSDEField.getPSDEDBTable().getId(), (String)this.getId(), (boolean)false) != 0) continue;
            psDEFieldList.add(iPSDEField);
        }
        if (this.psDEFieldList == null) {
            this.psDEFieldList = psDEFieldList;
        }
        return this.psDEFieldList.iterator();
    }

    @Override
    public String getPSSysDBTableId() {
        return this.psDETable.getPSSYSDBTABLEID();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

