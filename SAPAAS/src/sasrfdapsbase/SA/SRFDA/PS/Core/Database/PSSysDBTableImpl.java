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

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBIndex;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDBTableRuntime;
import SA.SRFDA.PS.Core.Database.PSSysDBColumnGlobalModel;
import SA.SRFDA.PS.Core.Database.PSSysDBIndexImpl;
import SA.SRFDA.PS.Core.Database.PSSysDBSchemeObjectImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysDBTable;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysDBTableImpl
extends PSSysDBSchemeObjectImpl
implements IPSSysDBTable,
IPSSysDBTableRuntime {
    private static final Log log = LogFactory.getLog(PSSysDBTableImpl.class);
    protected PSSysDBTable psSysDBTable = null;
    private PSSysDBColumnGlobalModel psSysDBColumnGlobalModel = new PSSysDBColumnGlobalModel();
    private int nLoadedLevel = IPSSystem.LOADLEVEL_NONE;
    private int nLoadingLevel = IPSSystem.LOADLEVEL_NONE;
    private boolean bExistingModel = false;
    private boolean bAutoExtendModel = true;
    private Map<String, IPSSysDBIndex> psSysDBIndexMap = new LinkedHashMap<String, IPSSysDBIndex>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDBScheme iPSSysDBScheme, PSSysDBTable psSysDBTable) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysDBScheme(iPSSysDBScheme);
            this.psSysDBTable = psSysDBTable;
            this.setPSSysDBScheme(iPSSysDBScheme);
            this.setId(this.psSysDBTable.getPSSYSDBTABLEID());
            this.setName(this.psSysDBTable.getPSSYSDBTABLENAME());
            this.setPSObjectData(this.psSysDBTable);
            this.bExistingModel = !this.psSysDBTable.isEXISTINGMODELNull() ? this.psSysDBTable.getEXISTINGMODEL() : iPSSysDBScheme.isExistingModel();
            this.bAutoExtendModel = !this.psSysDBTable.isAUTOEXTENDMODELNull() ? this.psSysDBTable.getAUTOEXTENDMODEL() : iPSSysDBScheme.isAutoExtendModel();
            this.psSysDBColumnGlobalModel.Init(iDAGlobalHelper, this);
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
    protected void onInit() throws Exception {
        this.psSysDBColumnGlobalModel.getAllModelHelpers();
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.psSysDBColumnGlobalModel.checkAll();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysDBTable.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0 ", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psSysDBTable.getLOGICNAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSDBTABLE";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysDBScheme().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5217\u96c6\u5408", child=true, rtname="getColumns", dynamodelmode=4, group="\u57fa\u672c", order=140)
    public Iterator<IPSSysDBColumn> getAllPSSysDBColumns() throws Exception {
        return this.psSysDBColumnGlobalModel.getAllModelHelpers();
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u96c6\u5408", child=true, rtname="getIndices", dynamodelmode=4, group="\u57fa\u672c", order=142)
    public Iterator<IPSSysDBIndex> getAllPSSysDBIndices() throws Exception {
        return this.psSysDBIndexMap.values().iterator();
    }

    @Override
    public IPSSysDBColumn getPSSysDBColumn(String strSysDBColumnId) throws Exception {
        return (IPSSysDBColumn)this.psSysDBColumnGlobalModel.FindModelHelper(strSysDBColumnId);
    }

    @Override
    public IPSSysDBColumn getPSSysDBColumn(String strSysDBColumnId, boolean bTryMode) throws Exception {
        return (IPSSysDBColumn)this.psSysDBColumnGlobalModel.FindModelHelper(strSysDBColumnId, bTryMode);
    }

    @Override
    public void resetPSSysDBColumn(String strSysDBColumnId) throws Exception {
        this.psSysDBColumnGlobalModel.ResetModel(strSysDBColumnId);
    }

    @Override
    public void resetAllPSSysDBColumns() {
        this.psSysDBColumnGlobalModel.ResetAll();
    }

    @Override
    public void load(int nLoadLevel) throws Exception {
        try {
            this.nLoadingLevel = nLoadLevel;
            this.getAllPSSysDBColumns();
            this.nLoadedLevel = nLoadLevel;
        }
        catch (Exception ex) {
            this.getPSSystemUtil().log(1, this, ex.getMessage());
            throw ex;
        }
    }

    @Override
    public int getLoadedLevel() {
        return this.nLoadedLevel;
    }

    @Override
    public int getLoadingLevel() {
        return this.nLoadingLevel;
    }

    @Override
    @PSModelRTMeta(description="\u73b0\u6709\u6570\u636e\u7ed3\u6784")
    public boolean isExistingModel() {
        return this.bExistingModel;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u6269\u5c55\u7ed3\u6784")
    public boolean isAutoExtendModel() {
        return this.bAutoExtendModel;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acbSQL", fields={"CREATESQL"})
    public String getCreateSql() {
        return this.psSysDBTable.getCREATESQL();
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u9664SQL", fields={"DROPSQL"})
    public String getDropSql() {
        return this.psSysDBTable.getDROPSQL();
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
    public void registerPSDataEntity(IPSDataEntity iPSDataEntity) throws Exception {
        if (this.getPSSysDBScheme().isPubIndex()) {
            Iterator<IPSDEDBIndex> psDEDBIndexs;
            IPSSysDBColumn[] extColumns = null;
            IPSSysDBColumn saaSDCIdPSSysDBColumn = null;
            String strSaaSDCIdColumn = iPSDataEntity.getSaaSDCIdColumnName();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strSaaSDCIdColumn) && (saaSDCIdPSSysDBColumn = this.getPSSysDBColumn(strSaaSDCIdColumn, true)) != null) {
                extColumns = new IPSSysDBColumn[]{saaSDCIdPSSysDBColumn};
            }
            if (this.getPSSysDBScheme().isEnableFKeyIndex()) {
                HashMap<String, IPSSysDBIndex> derPSSysDBIndexMap = new HashMap<String, IPSSysDBIndex>();
                Iterator<IPSDER1N> psDER1Ns = iPSDataEntity.getMinorPSDER1Ns();
                if (psDER1Ns != null) {
                    while (psDER1Ns.hasNext()) {
                        IPSDER1N iPSDER1N = psDER1Ns.next();
                        PSSysDBIndexImpl psSysDBIndexImpl = new PSSysDBIndexImpl();
                        psSysDBIndexImpl.init(this.getDAGlobalHelper(), this, iPSDER1N, extColumns);
                        if (psSysDBIndexImpl.getAllPSSysDBIndexColumns() == null || !psSysDBIndexImpl.getAllPSSysDBIndexColumns().hasNext() || this.psSysDBIndexMap.containsKey(psSysDBIndexImpl.getUniqueId())) continue;
                        this.psSysDBIndexMap.put(psSysDBIndexImpl.getUniqueId(), psSysDBIndexImpl);
                        derPSSysDBIndexMap.put(iPSDER1N.getPSPickupDEField().getName(), psSysDBIndexImpl);
                    }
                }
                if (iPSDataEntity.getVirtualMode() == 5) {
                    this.registerInheritPSDataEntity(iPSDataEntity, extColumns, derPSSysDBIndexMap, true);
                }
            }
            if (this.getPSSysDBScheme().isEnableSaaSDCIdIndex() && saaSDCIdPSSysDBColumn != null) {
                PSSysDBIndexImpl psSysDBIndexImpl = new PSSysDBIndexImpl();
                psSysDBIndexImpl.init(this.getDAGlobalHelper(), this, saaSDCIdPSSysDBColumn, null);
                if (psSysDBIndexImpl.getAllPSSysDBIndexColumns() != null && psSysDBIndexImpl.getAllPSSysDBIndexColumns().hasNext() && !this.psSysDBIndexMap.containsKey(psSysDBIndexImpl.getUniqueId())) {
                    this.psSysDBIndexMap.put(psSysDBIndexImpl.getUniqueId(), psSysDBIndexImpl);
                }
            }
            if ((psDEDBIndexs = iPSDataEntity.getAllPSDEDBIndexs()) != null) {
                while (psDEDBIndexs.hasNext()) {
                    IPSDEDBIndex iPSDEDBIndex = psDEDBIndexs.next();
                    PSSysDBIndexImpl psSysDBIndexImpl = new PSSysDBIndexImpl();
                    psSysDBIndexImpl.init(this.getDAGlobalHelper(), this, iPSDEDBIndex, extColumns);
                    if (psSysDBIndexImpl.getAllPSSysDBIndexColumns() == null || !psSysDBIndexImpl.getAllPSSysDBIndexColumns().hasNext()) continue;
                    this.psSysDBIndexMap.put(psSysDBIndexImpl.getUniqueId(), psSysDBIndexImpl);
                }
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868\u6807\u8bb0", fields={"TABLETAG"})
    public String getTableTag() {
        return this.psSysDBTable.getTABLETAG();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868\u6807\u8bb02", fields={"TABLETAG2"})
    public String getTableTag2() {
        return this.psSysDBTable.getTABLETAG2();
    }

    /*
     * Unable to fully structure code
     */
    protected void registerInheritPSDataEntity(IPSDataEntity iPSDataEntity, IPSSysDBColumn[] extColumns, Map<String, IPSSysDBIndex> derPSSysDBIndexMap, boolean bRoot) throws Exception {
        if (!bRoot) {
            psDER1Ns = iPSDataEntity.getMinorPSDER1Ns();
            if (psDER1Ns != null) {
                while (psDER1Ns.hasNext()) {
                    iPSDER1N = psDER1Ns.next();
                    psSysDBIndexImpl = new PSSysDBIndexImpl();
                    psSysDBIndexImpl.init(this.getDAGlobalHelper(), this, iPSDER1N.getPSPickupDEField(), extColumns);
                    if (psSysDBIndexImpl.getAllPSSysDBIndexColumns() == null || !psSysDBIndexImpl.getAllPSSysDBIndexColumns().hasNext() || this.psSysDBIndexMap.containsKey(psSysDBIndexImpl.getUniqueId()) || derPSSysDBIndexMap.containsKey(iPSDER1N.getPSPickupDEField().getName())) continue;
                    this.psSysDBIndexMap.put(psSysDBIndexImpl.getUniqueId(), psSysDBIndexImpl);
                    derPSSysDBIndexMap.put(iPSDER1N.getPSPickupDEField().getName(), psSysDBIndexImpl);
                }
            }
            if (iPSDataEntity.getVirtualMode() != 5) {
                return;
            }
        }
        if ((psDERMultiInherits = iPSDataEntity.getPSDERMultiInherits(false)) != null) ** GOTO lbl20
        return;
lbl-1000:
        // 1 sources

        {
            iPSDERMultiInherit = psDERMultiInherits.next();
            this.registerInheritPSDataEntity(iPSDERMultiInherit.getMajorPSDataEntity(), extColumns, derPSSysDBIndexMap, false);
lbl20:
            // 2 sources

            ** while (psDERMultiInherits.hasNext())
        }
lbl21:
        // 1 sources

    }
}

