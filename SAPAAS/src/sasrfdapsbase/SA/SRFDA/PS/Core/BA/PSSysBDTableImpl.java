/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psba.core.IBAColSet
 *  net.ibizsys.psba.core.IBAColumn
 *  net.ibizsys.psba.core.IBATableDE
 *  net.ibizsys.psba.core.IBATableDER
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDColSet;
import SA.SRFDA.PS.Core.BA.IPSSysBDColumn;
import SA.SRFDA.PS.Core.BA.IPSSysBDModule;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableDE;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableDER;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableRS;
import SA.SRFDA.PS.Core.BA.PSSysBDColSetGlobalModel;
import SA.SRFDA.PS.Core.BA.PSSysBDColumnGlobalModel;
import SA.SRFDA.PS.Core.BA.PSSysBDSchemeObjectImpl;
import SA.SRFDA.PS.Core.BA.PSSysBDTableDEGlobalModel;
import SA.SRFDA.PS.Core.BA.PSSysBDTableDERGlobalModel;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBDTable;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.IBAColSet;
import net.ibizsys.psba.core.IBAColumn;
import net.ibizsys.psba.core.IBATableDE;
import net.ibizsys.psba.core.IBATableDER;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDTableImpl
extends PSSysBDSchemeObjectImpl
implements IPSSysBDTable {
    private static final Log log = LogFactory.getLog(PSSysBDTableImpl.class);
    protected PSSysBDTable psSysBDTable = null;
    private PSSysBDColSetGlobalModel psSysBDColSetGlobalModel = new PSSysBDColSetGlobalModel();
    private PSSysBDTableDEGlobalModel psSysBDTableDEGlobalModel = new PSSysBDTableDEGlobalModel();
    private PSSysBDTableDERGlobalModel psSysBDTableDERGlobalModel = new PSSysBDTableDERGlobalModel();
    private PSSysBDColumnGlobalModel psSysBDColumnGlobalModel = new PSSysBDColumnGlobalModel();
    private int nBATableType = 1;
    private String strInheritTypeValue = "";
    private String strPickupDEFName = "";
    private IPSDataEntity minorPSDE = null;
    private IPSDataEntity inheritPSDE = null;
    private ArrayList<IPSSysBDTable> minorPSSysBDTableList = null;
    private ArrayList<IPSSysBDTable> majorPSSysBDTableList = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSSysBDModule iPSSysBDModule = null;
    private int nLoadedLevel = IPSSystem.LOADLEVEL_NONE;
    private int nLoadingLevel = IPSSystem.LOADLEVEL_NONE;
    private ArrayList<IPSSysBDTableRS> majorPSSysBDTableRSList = null;
    private ArrayList<IPSSysBDTableRS> minorPSSysBDTableRSList = null;
    private IPSDER1N iPSDER1N = null;
    private IPSDEField iPSDEField = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBDScheme iPSSysBDScheme, PSSysBDTable psSysBDTable) throws Exception {
        try {
            block18: {
                block20: {
                    IPSDER1N iPSDER1N;
                    block19: {
                        this.setDAGlobalHelper(iDAGlobalHelper);
                        this.setPSSysBDScheme(iPSSysBDScheme);
                        this.psSysBDTable = psSysBDTable;
                        this.setId(this.psSysBDTable.getPSSYSBDTABLEID());
                        this.setName(this.psSysBDTable.getPSSYSBDTABLENAME());
                        this.setPSObjectData(this.psSysBDTable);
                        this.iPSDataEntity = this.iPSSysBDScheme.getPSSystem().getPSDataEntity2(this.psSysBDTable.getPSDEID());
                        if (!StringHelper.isNullOrEmpty((String)this.psSysBDTable.getPSSYSBDMODULEID())) {
                            this.iPSSysBDModule = this.iPSSysBDScheme.getPSSysBDModule(this.psSysBDTable.getPSSYSBDMODULEID());
                        }
                        if (!this.psSysBDTable.isBDTABLETYPENull()) {
                            this.nBATableType = this.psSysBDTable.getBDTABLETYPE();
                        }
                        if (this.nBATableType != 3) break block18;
                        this.minorPSDE = this.iPSSysBDScheme.getPSSystem().getPSDataEntity2(this.psSysBDTable.getMINORPSDEID());
                        if (StringHelper.isNullOrEmpty((String)this.psSysBDTable.getPSDERID())) break block19;
                        this.iPSDER1N = this.getPSSysBDScheme().getPSSystem().getPSDER1N(this.psSysBDTable.getMINORPSDEID());
                        if (this.minorPSDE != null) break block20;
                        this.minorPSDE = this.iPSDER1N.getMinorPSDataEntity();
                        break block20;
                    }
                    if (this.getMinorPSDE() == null) {
                        throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5173\u7cfb\u9644\u5c5e\u5b9e\u4f53"));
                    }
                    Iterator<IPSDER1N> psDER1Ns = this.getPSDataEntity().getPSDER1Ns(true);
                    if (psDER1Ns != null) {
                        while (psDER1Ns.hasNext()) {
                            iPSDER1N = psDER1Ns.next();
                            if (StringHelper.compare((String)iPSDER1N.getMinorPSDataEntity().getId(), (String)this.getMinorPSDE().getId(), (boolean)false) != 0) continue;
                            this.iPSDER1N = iPSDER1N;
                            break;
                        }
                    }
                    if (this.iPSDER1N == null && this.getPSDataEntity().getInheritPSDataEntity() != null && (psDER1Ns = this.getPSDataEntity().getInheritPSDataEntity().getPSDER1Ns(true)) != null) {
                        while (psDER1Ns.hasNext()) {
                            iPSDER1N = psDER1Ns.next();
                            if (StringHelper.compare((String)iPSDER1N.getMinorPSDataEntity().getId(), (String)this.getMinorPSDE().getId(), (boolean)false) != 0) continue;
                            this.iPSDER1N = iPSDER1N;
                            break;
                        }
                    }
                }
                this.strPickupDEFName = this.psSysBDTable.getPICKUPDEFNAME();
                if (StringHelper.isNullOrEmpty((String)this.strPickupDEFName) && this.iPSDER1N != null) {
                    this.strPickupDEFName = this.iPSDER1N.getPickupDEFName();
                }
                if (!StringHelper.isNullOrEmpty((String)this.strPickupDEFName)) {
                    this.iPSDEField = this.getMinorPSDataEntity().getPSDEField(this.strPickupDEFName);
                } else if (this.iPSDER1N != null) {
                    this.iPSDEField = this.iPSDER1N.getPSPickupDEField();
                }
            }
            if (this.nBATableType == 9) {
                this.inheritPSDE = StringHelper.isNullOrEmpty((String)this.psSysBDTable.getINHERITPSDEID()) ? this.getPSDataEntity().getInheritPSDataEntity() : this.iPSSysBDScheme.getPSSystem().getPSDataEntity2(this.psSysBDTable.getINHERITPSDEID());
                if (this.inheritPSDE == null) {
                    throw new Exception("\u65e0\u6cd5\u8ba1\u7b97\u7ee7\u627f\u4e3b\u5b9e\u4f53\u5bf9\u8c61");
                }
                this.strInheritTypeValue = this.psSysBDTable.getTYPEVALUE();
                if (StringHelper.isNullOrEmpty((String)this.strInheritTypeValue) && this.getPSDataEntity().getPSDERInherit() != null) {
                    this.strInheritTypeValue = this.getPSDataEntity().getPSDERInherit().getTypeValue();
                }
                if (StringHelper.isNullOrEmpty((String)this.strInheritTypeValue)) {
                    throw new Exception("\u65e0\u6cd5\u8ba1\u7b97\u7ee7\u627f\u8bc6\u522b\u503c");
                }
            }
            this.psSysBDTableDEGlobalModel.Init(iDAGlobalHelper, this);
            this.psSysBDTableDERGlobalModel.Init(iDAGlobalHelper, this);
            this.psSysBDColSetGlobalModel.Init(iDAGlobalHelper, this);
            this.psSysBDColumnGlobalModel.Init(iDAGlobalHelper, this);
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
        this.psSysBDColSetGlobalModel.getAllModelHelpers();
        this.psSysBDTableDEGlobalModel.getAllModelHelpers();
        this.psSysBDColSetGlobalModel.getAllModelHelpers();
        this.psSysBDColumnGlobalModel.getAllModelHelpers();
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868\u7c7b\u578b", codelist="BDTableType")
    public int getBDTableType() {
        return this.getBATableType();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBDTable.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        if (StringHelper.isNullOrEmpty((String)this.psSysBDTable.getLOGICNAME())) {
            return this.getPSDataEntity().getLogicName();
        }
        return this.psSysBDTable.getLOGICNAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSBDTABLE";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysBDScheme().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5217\u65cf\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBDColSet> getAllPSSysBDColSets() throws Exception {
        return this.psSysBDColSetGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBDColSet getPSSysBDColSet(String strSysBDColSetId) throws Exception {
        return (IPSSysBDColSet)this.psSysBDColSetGlobalModel.FindModelHelper(strSysBDColSetId);
    }

    @Override
    public void resetPSSysBDColSet(String strSysBDColSetId) throws Exception {
        this.psSysBDColSetGlobalModel.ResetModel(strSysBDColSetId);
    }

    @Override
    public void resetAllPSSysBDColSets() {
        this.psSysBDColSetGlobalModel.ResetAll();
    }

    @Override
    public IPSSysBDColSet getDefaultPSSysBDColSet() {
        return this.psSysBDColSetGlobalModel.getDefaultPSSysBDColSet();
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5b9e\u4f53\u96c6\u5408")
    public Iterator<? extends IPSSysBDTableDE> getAllPSSysBDTableDEs() throws Exception {
        return this.psSysBDTableDEGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBDTableDE getPSSysBDTableDE(String strSysBDTableDEId) throws Exception {
        return (IPSSysBDTableDE)this.psSysBDTableDEGlobalModel.FindModelHelper(strSysBDTableDEId);
    }

    @Override
    public void resetPSSysBDTableDE(String strSysBDTableDEId) throws Exception {
        this.psSysBDTableDEGlobalModel.ResetModel(strSysBDTableDEId);
    }

    @Override
    public void resetAllPSSysBDTableDEs() {
        this.psSysBDTableDEGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5217\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBDColumn> getAllPSSysBDColumns() throws Exception {
        return this.psSysBDColumnGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBDColumn getPSSysBDColumn(String strSysBDColumnId) throws Exception {
        return (IPSSysBDColumn)this.psSysBDColumnGlobalModel.FindModelHelper(strSysBDColumnId);
    }

    @Override
    public void resetPSSysBDColumn(String strSysBDColumnId) throws Exception {
        this.psSysBDColumnGlobalModel.ResetModel(strSysBDColumnId);
    }

    @Override
    public void resetAllPSSysBDColumns() {
        this.psSysBDColumnGlobalModel.ResetAll();
    }

    public Iterator<IBAColSet> getBAColSets() {
        return null;
    }

    public Iterator<IBAColumn> getBAColumns() {
        return null;
    }

    public IBATableDE getBATableDE(String strDEName) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public IBATableDER getBATableDER(String strDERName) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public IBAColSet getBAColSet(String strBAColSetName) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public IBAColumn getBAColumn(String strBAColumnName) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public IBATableDE getBATableDE(String strDEName, boolean bTryMode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public Iterator<IBATableDE> getBATableDEs() {
        return null;
    }

    public IBAColumn getBAColumn(String strBAColSetId, String strBAColumnId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public Iterator<? extends IPSSysBDTableDER> getAllPSSysBDTableDERs() throws Exception {
        return this.psSysBDTableDERGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysBDTableDER getPSSysBDTableDER(String strSysBDTableDERId) throws Exception {
        return (IPSSysBDTableDER)this.psSysBDTableDERGlobalModel.FindModelHelper(strSysBDTableDERId);
    }

    @Override
    public void resetPSSysBDTableDER(String strSysBDTableDERId) throws Exception {
        this.psSysBDTableDERGlobalModel.ResetModel(strSysBDTableDERId);
    }

    @Override
    public void resetAllPSSysBDTableDERs() {
        this.psSysBDTableDERGlobalModel.ResetAll();
    }

    public int getBATableType() {
        return this.nBATableType;
    }

    @Override
    public IPSDataEntity getMinorPSDE() {
        return this.minorPSDE;
    }

    @Override
    public IPSDataEntity getInheritPSDE() {
        return this.inheritPSDE;
    }

    @Override
    public synchronized Iterator<IPSSysBDTable> getPSSysBDTables(boolean bMajor) throws Exception {
        if (bMajor) {
            if (this.majorPSSysBDTableList == null) {
                ArrayList<IPSSysBDTable> majorPSSysBDTableList = new ArrayList<IPSSysBDTable>();
                Iterator<? extends IPSSysBDTable> psSysBDTables = this.getPSSysBDScheme().getAllPSSysBDTables();
                while (psSysBDTables.hasNext()) {
                    IPSSysBDTable iPSSysBDTable = psSysBDTables.next();
                    if (iPSSysBDTable.getBATableType() != 3 || StringHelper.compare((String)iPSSysBDTable.getPSDataEntity().getId(), (String)this.getPSDataEntity().getId(), (boolean)false) != 0) continue;
                    majorPSSysBDTableList.add(iPSSysBDTable);
                }
                this.majorPSSysBDTableList = majorPSSysBDTableList;
            }
            return this.majorPSSysBDTableList.iterator();
        }
        if (this.minorPSSysBDTableList == null) {
            ArrayList<IPSSysBDTable> minorPSSysBDTableList = new ArrayList<IPSSysBDTable>();
            Iterator<? extends IPSSysBDTable> psSysBDTables = this.getPSSysBDScheme().getAllPSSysBDTables();
            while (psSysBDTables.hasNext()) {
                IPSSysBDTable iPSSysBDTable = psSysBDTables.next();
                if (iPSSysBDTable.getBATableType() != 3 || StringHelper.compare((String)iPSSysBDTable.getMinorPSDE().getId(), (String)this.getPSDataEntity().getId(), (boolean)false) != 0) continue;
                minorPSSysBDTableList.add(iPSSysBDTable);
            }
            this.minorPSSysBDTableList = minorPSSysBDTableList;
        }
        return this.minorPSSysBDTableList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u4e3b\u6570\u636e\u8868", hideempty=true)
    public IPSSysBDTable getInheritPSSysBDTable() throws Exception {
        if (this.getInheritPSDE() == null) {
            return null;
        }
        return this.getPSSysBDScheme().getPSSysBDTable(this.getInheritPSDE().getName(), true);
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5b9e\u4f53")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public IPSSysBDModule getPSSysBDModule() {
        return this.iPSSysBDModule;
    }

    @Override
    public void load(int nLoadLevel) throws Exception {
        try {
            this.nLoadingLevel = nLoadLevel;
            Iterator<? extends IPSSysBDColSet> psSysBDColSets = this.getAllPSSysBDColSets();
            this.getAllPSSysBDTableDEs();
            this.getAllPSSysBDTableDERs();
            this.getAllPSSysBDColumns();
            while (psSysBDColSets.hasNext()) {
                IPSSysBDColSet iPSSysBDColSet = psSysBDColSets.next();
                iPSSysBDColSet.getAllPSSysBDColumns();
            }
            this.getAllPSSysBDTableRSes(true);
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
    public Iterator<? extends IPSSysBDTableRS> getAllPSSysBDTableRSes(boolean bMajor) throws Exception {
        this.preparePSSysBDTableRSList();
        if (bMajor) {
            return this.majorPSSysBDTableRSList.iterator();
        }
        return this.minorPSSysBDTableRSList.iterator();
    }

    protected synchronized void preparePSSysBDTableRSList() throws Exception {
        if (this.majorPSSysBDTableRSList == null) {
            this.majorPSSysBDTableRSList = new ArrayList();
            this.minorPSSysBDTableRSList = new ArrayList();
            Iterator<IPSSysBDTableRS> psSysBDTableRSes = this.getPSSysBDScheme().getAllPSSysBDTableRSes();
            while (psSysBDTableRSes.hasNext()) {
                IPSSysBDTableRS iPSSysBDTableRS = psSysBDTableRSes.next();
                if (iPSSysBDTableRS.getMajorPSSysBDTable() == this) {
                    this.majorPSSysBDTableRSList.add(iPSSysBDTableRS);
                    continue;
                }
                if (iPSSysBDTableRS.getMinorPSSysBDTable() != this) continue;
                this.minorPSSysBDTableRSList.add(iPSSysBDTableRS);
            }
        }
    }

    @Override
    public Iterator<? extends IPSSysBDTableRS> getAllPSSysBDTableRSs(boolean bMajor) throws Exception {
        return this.getAllPSSysBDTableRSes(bMajor);
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u4ece\u5b9e\u4f53", hideempty=true)
    public IPSDataEntity getMinorPSDataEntity() {
        return this.minorPSDE;
    }

    @Override
    public String getPickupDEFName() {
        return this.strPickupDEFName;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u8fde\u63a5\u5c5e\u6027", hideempty2=true)
    public IPSDEField getPickupPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5bf9\u8c61", hideempty2=true)
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u4e3b\u5b9e\u4f53", hideempty=true)
    public IPSDataEntity getInheritPSDataEntity() {
        return this.inheritPSDE;
    }

    @Override
    @PSModelRTMeta(description="\u7ee7\u627f\u7c7b\u578b\u503c", hideempty2=true)
    public String getInheritTypeValue() {
        return this.strInheritTypeValue;
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5173\u7cfb\u96c6\u5408\uff08\u4e3b\u8868\uff09", child=true, dumpref=true, ignorert=3, from="IPSSysBDScheme")
    public Iterator<? extends IPSSysBDTableRS> getMajorPSSysBDTableRSs() throws Exception {
        return this.getAllPSSysBDTableRSes(true);
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5173\u7cfb\u96c6\u5408\uff08\u4ece\u8868\uff09", child=true, dumpref=true, rtdump=2, from="IPSSysBDScheme")
    public Iterator<? extends IPSSysBDTableRS> getMinorPSSysBDTableRSs() throws Exception {
        return this.getAllPSSysBDTableRSes(false);
    }
}

