/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBILevel;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBILevel;
import SA.SRFDA.PS.Core.BI.PSSysBIDimensionObjectImpl;
import SA.SRFDA.PS.Core.BI.PSSysBILevelImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBIHierarchy;
import SA.SRFDA.PS.Data.PSSysBILevel;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBIHierarchyImpl
extends PSSysBIDimensionObjectImpl
implements IPSSysBIHierarchy {
    private static final Log log = LogFactory.getLog(PSSysBIHierarchyImpl.class);
    protected PSSysBIHierarchy psSysBIHierarchy = null;
    private String strHierarchyType = "DE";
    private IPSDataEntity iPSDataEntity = null;
    private ArrayList<IPSSysBILevel> psSysBILevelList = new ArrayList();
    private Map<String, IPSSysBILevel> psSysBILevelMap = new LinkedHashMap<String, IPSSysBILevel>();
    private boolean bHasAll = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBIDimension iPSSysBIDimension, PSSysBIHierarchy psSysBIHierarchy) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBIDimension(iPSSysBIDimension);
            this.psSysBIHierarchy = psSysBIHierarchy;
            this.setId(this.psSysBIHierarchy.getPSSYSBIHIERARCHYID());
            this.setName(this.psSysBIHierarchy.getPSSYSBIHIERARCHYNAME());
            this.setPSObjectData(this.psSysBIHierarchy);
            if (!StringHelper.isNullOrEmpty((String)this.psSysBIHierarchy.getBIHIERARCHYTYPE())) {
                this.strHierarchyType = this.psSysBIHierarchy.getBIHIERARCHYTYPE();
            }
            if ("DE".equals(this.getHierarchyType())) {
                if (this.getPSDataEntity() == null && !StringHelper.isNullOrEmpty((String)this.psSysBIHierarchy.getPSDEID())) {
                    this.iPSDataEntity = this.getPSSysBIScheme().getPSSystem().getPSDataEntity2(this.psSysBIHierarchy.getPSDEID());
                }
                if (this.getPSDataEntity() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61", new Object[0]));
                }
            }
            this.bHasAll = this.psSysBIHierarchy.getHASALL();
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
        this.onPreparePSSysBILevels();
        super.onInit();
    }

    protected void onPreparePSSysBILevels() throws Exception {
        this.psSysBILevelList.clear();
        Vector<PSSysBILevel> psSysBILevelList = new Vector<PSSysBILevel>();
        CallResult callResult = this.getPSModelHelper().getPSSysBILevels(this.getId(), psSysBILevelList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7ef4\u5ea6\u5c42\u7ea7\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBILevel psSysBILevel : psSysBILevelList) {
            PSSysBILevelImpl iPSSysBILevel = new PSSysBILevelImpl();
            iPSSysBILevel.init(this.getDAGlobalHelper(), this, psSysBILevel);
            this.psSysBILevelList.add(iPSSysBILevel);
            this.psSysBILevelMap.put(iPSSysBILevel.getId(), iPSSysBILevel);
            this.psSysBILevelMap.put(iPSSysBILevel.getName(), iPSSysBILevel);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSBIHIERARCHY";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysBIHierarchy.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u67b6\u6784\u6807\u8bb0", hideempty2=true)
    public String getHierarchyTag() {
        return this.psSysBIHierarchy.getBIHIERARCHYTAG();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u67b6\u6784\u6807\u8bb02", hideempty2=true)
    public String getHierarchyTag2() {
        return this.psSysBIHierarchy.getBIHIERARCHYTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53", hideempty=true, dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u67b6\u6784\u7c7b\u578b", hideempty2=true, codelist="BIHierarchyType")
    public String getHierarchyType() {
        return this.strHierarchyType;
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u67b6\u6784\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBILevel> getAllPSSysBILevels() throws Exception {
        if (this.psSysBILevelList == null || this.psSysBILevelList.size() == 0) {
            return null;
        }
        return this.psSysBILevelList.iterator();
    }

    @Override
    public IPSSysBILevel getPSSysBILevel(String strPSSysBILevelId) throws Exception {
        return this.getPSSysBILevel(strPSSysBILevelId, false);
    }

    @Override
    public IPSBILevel getPSBILevel(String strPSBILevelId, boolean bTryMode) throws Exception {
        return this.getPSSysBILevel(strPSBILevelId, bTryMode);
    }

    @Override
    public IPSSysBILevel getPSSysBILevel(String strPSSysBILevelId, boolean bTryMode) throws Exception {
        IPSSysBILevel iPSSysBILevel = null;
        if (this.psSysBILevelMap != null) {
            iPSSysBILevel = this.psSysBILevelMap.get(strPSSysBILevelId);
        }
        if (iPSSysBILevel != null || bTryMode) {
            return iPSSysBILevel;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7ef4\u5ea6\u67b6\u6784[%1$s]", (Object)strPSSysBILevelId));
    }

    @Override
    public Iterator<? extends IPSBILevel> getAllPSBILevels() throws Exception {
        return this.getAllPSSysBILevels();
    }

    @Override
    public IPSBILevel getPSBILevel(String strPSBILevelId) throws Exception {
        return this.getPSSysBILevel(strPSBILevelId);
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5168\u90e8\u6570\u636e", ignoredumpvalues="false", fields={"HASALL"})
    public boolean hasAll() {
        return this.bHasAll;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u6570\u636e\u6807\u9898", fields={"ALLCAPTION"})
    public String getAllCaption() {
        if (this.hasAll()) {
            return this.psSysBIHierarchy.getALLCAPTION();
        }
        return null;
    }
}

