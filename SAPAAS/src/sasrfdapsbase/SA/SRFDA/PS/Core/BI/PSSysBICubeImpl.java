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

import SA.SRFDA.PS.Core.BI.IPSBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BI.PSSysBICubeDimensionImpl;
import SA.SRFDA.PS.Core.BI.PSSysBICubeMeasureImpl;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSSysBICube;
import SA.SRFDA.PS.Data.PSSysBICubeDimension;
import SA.SRFDA.PS.Data.PSSysBICubeMeasure;
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

public class PSSysBICubeImpl
extends PSSysBISchemeObjectImpl
implements IPSSysBICube {
    private static final Log log = LogFactory.getLog(PSSysBICubeImpl.class);
    protected PSSysBICube psSysBICube = null;
    private ArrayList<IPSSysBICubeDimension> psSysBICubeDimensionList = new ArrayList();
    private Map<String, IPSSysBICubeDimension> psSysBICubeDimensionMap = new LinkedHashMap<String, IPSSysBICubeDimension>();
    private ArrayList<IPSSysBICubeMeasure> psSysBICubeMeasureList = new ArrayList();
    private Map<String, IPSSysBICubeMeasure> psSysBICubeMeasureMap = new LinkedHashMap<String, IPSSysBICubeMeasure>();
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEField keyPSDEField = null;
    private IPSDEField typePSDEField = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSSysUniRes iPSSysUniRes = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBIScheme iPSSysBIScheme, PSSysBICube psSysBICube) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBIScheme(iPSSysBIScheme);
            this.psSysBICube = psSysBICube;
            this.setId(this.psSysBICube.getPSSYSBICUBEID());
            this.setName(this.psSysBICube.getPSSYSBICUBENAME());
            this.setPSObjectData(this.psSysBICube);
            if (this.getPSDataEntity() == null && !StringHelper.isNullOrEmpty((String)this.psSysBICube.getPSDEID())) {
                this.iPSDataEntity = this.getPSSysBIScheme().getPSSystem().getPSDataEntity2(this.psSysBICube.getPSDEID());
            }
            if (this.getPSDataEntity() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53");
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBICube.getKEYPSDEFID())) {
                this.keyPSDEField = this.getPSDataEntity().getPSDEField(this.psSysBICube.getKEYPSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBICube.getTYPEPSDEFID())) {
                this.typePSDEField = this.getPSDataEntity().getPSDEField(this.psSysBICube.getTYPEPSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBICube.getPSDEDATASETID())) {
                this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psSysBICube.getPSDEDATASETID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBICube.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSSysBIScheme().getPSSystem().getPSSysUniRes(this.psSysBICube.getPSSYSUNIRESID());
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
    protected void onInit() throws Exception {
        this.onPreparePSSysBICubeDimensions();
        this.onPreparePSSysBICubeMeasures();
        super.onInit();
    }

    protected void onPreparePSSysBICubeDimensions() throws Exception {
        this.psSysBICubeDimensionList.clear();
        Vector<PSSysBICubeDimension> psSysBICubeDimensionList = new Vector<PSSysBICubeDimension>();
        CallResult callResult = this.getPSModelHelper().getPSSysBICubeDimensions(this.getId(), psSysBICubeDimensionList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7acb\u65b9\u4f53\u7ef4\u5ea6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBICubeDimension psSysBICubeDimension : psSysBICubeDimensionList) {
            PSSysBICubeDimensionImpl iPSSysBICubeDimension = new PSSysBICubeDimensionImpl();
            iPSSysBICubeDimension.init(this.getDAGlobalHelper(), this, psSysBICubeDimension);
            this.psSysBICubeDimensionList.add(iPSSysBICubeDimension);
            this.psSysBICubeDimensionMap.put(iPSSysBICubeDimension.getId(), iPSSysBICubeDimension);
            this.psSysBICubeDimensionMap.put(iPSSysBICubeDimension.getName(), iPSSysBICubeDimension);
        }
    }

    protected void onPreparePSSysBICubeMeasures() throws Exception {
        this.psSysBICubeMeasureList.clear();
        Vector<PSSysBICubeMeasure> psSysBICubeMeasureList = new Vector<PSSysBICubeMeasure>();
        CallResult callResult = this.getPSModelHelper().getPSSysBICubeMeasures(this.getId(), psSysBICubeMeasureList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7acb\u65b9\u4f53\u6307\u6807\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBICubeMeasure psSysBICubeMeasure : psSysBICubeMeasureList) {
            PSSysBICubeMeasureImpl iPSSysBICubeMeasure = new PSSysBICubeMeasureImpl();
            iPSSysBICubeMeasure.init(this.getDAGlobalHelper(), this, psSysBICubeMeasure);
            this.psSysBICubeMeasureList.add(iPSSysBICubeMeasure);
            this.psSysBICubeMeasureMap.put(iPSSysBICubeMeasure.getId(), iPSSysBICubeMeasure);
            this.psSysBICubeMeasureMap.put(iPSSysBICubeMeasure.getName(), iPSSysBICubeMeasure);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSBICUBE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"CODENAME"})
    public String getCodeName() {
        return this.psSysBICube.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u6807\u8bb0", fields={"BICUBETAG"})
    public String getCubeTag() {
        return this.psSysBICube.getBICUBETAG();
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u6807\u8bb02", fields={"BICUBETAG2"})
    public String getCubeTag2() {
        return this.psSysBICube.getBICUBETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u7ef4\u5ea6\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBICubeDimension> getAllPSSysBICubeDimensions() throws Exception {
        if (this.psSysBICubeDimensionList == null || this.psSysBICubeDimensionList.size() == 0) {
            return null;
        }
        return this.psSysBICubeDimensionList.iterator();
    }

    @Override
    public IPSSysBICubeDimension getPSSysBICubeDimension(String strPSSysBICubeDimensionId) throws Exception {
        return this.getPSSysBICubeDimension(strPSSysBICubeDimensionId, false);
    }

    @Override
    public IPSBICubeDimension getPSBICubeDimension(String strPSBICubeDimensionId, boolean bTryMode) throws Exception {
        return this.getPSSysBICubeDimension(strPSBICubeDimensionId, bTryMode);
    }

    @Override
    public IPSSysBICubeDimension getPSSysBICubeDimension(String strPSSysBICubeDimensionId, boolean bTryMode) throws Exception {
        IPSSysBICubeDimension iPSSysBICubeDimension = null;
        if (this.psSysBICubeDimensionMap != null) {
            iPSSysBICubeDimension = this.psSysBICubeDimensionMap.get(strPSSysBICubeDimensionId);
        }
        if (iPSSysBICubeDimension != null || bTryMode) {
            return iPSSysBICubeDimension;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7acb\u65b9\u4f53\u7ef4\u5ea6[%1$s]", (Object)strPSSysBICubeDimensionId));
    }

    @Override
    public Iterator<? extends IPSBICubeDimension> getAllPSBICubeDimensions() throws Exception {
        return this.getAllPSSysBICubeDimensions();
    }

    @Override
    public IPSBICubeDimension getPSBICubeDimension(String strPSBICubeDimensionId) throws Exception {
        return this.getPSSysBICubeDimension(strPSBICubeDimensionId);
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u6307\u6807\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBICubeMeasure> getAllPSSysBICubeMeasures() throws Exception {
        if (this.psSysBICubeMeasureList == null || this.psSysBICubeMeasureList.size() == 0) {
            return null;
        }
        return this.psSysBICubeMeasureList.iterator();
    }

    @Override
    public IPSSysBICubeMeasure getPSSysBICubeMeasure(String strPSSysBICubeMeasureId) throws Exception {
        return this.getPSSysBICubeMeasure(strPSSysBICubeMeasureId, false);
    }

    @Override
    public IPSBICubeMeasure getPSBICubeMeasure(String strPSBICubeMeasureId, boolean bTryMode) throws Exception {
        return this.getPSSysBICubeMeasure(strPSBICubeMeasureId, bTryMode);
    }

    @Override
    public IPSSysBICubeMeasure getPSSysBICubeMeasure(String strPSSysBICubeMeasureId, boolean bTryMode) throws Exception {
        IPSSysBICubeMeasure iPSSysBICubeMeasure = null;
        if (this.psSysBICubeMeasureMap != null) {
            iPSSysBICubeMeasure = this.psSysBICubeMeasureMap.get(strPSSysBICubeMeasureId);
        }
        if (iPSSysBICubeMeasure != null || bTryMode) {
            return iPSSysBICubeMeasure;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7acb\u65b9\u4f53\u6307\u6807[%1$s]", (Object)strPSSysBICubeMeasureId));
    }

    @Override
    public Iterator<? extends IPSBICubeMeasure> getAllPSBICubeMeasures() throws Exception {
        return this.getAllPSSysBICubeMeasures();
    }

    @Override
    public IPSBICubeMeasure getPSBICubeMeasure(String strPSBICubeMeasureId) throws Exception {
        return this.getPSSysBICubeMeasure(strPSBICubeMeasureId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53", hideempty=true, dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u952e\u503c\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getKeyPSDEField() {
        return this.keyPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7c7b\u578b\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getTypePSDEField() {
        return this.typePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6", hideempty=true, dumpref=true, from="IPSDataEntity", fields={"PSDEDATASETID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u6743\u9650\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getPSSysUniRes() {
        return this.iPSSysUniRes;
    }

    @Override
    public String getDrillDownPSDEViewId() {
        return this.psSysBICube.getDRILLDOWNPSDEVIEWID();
    }

    @Override
    public String getDrillDetailPSDEViewId() {
        return this.psSysBICube.getDRILLDETAILPSDEVIEWID();
    }

    @Override
    public String getPortletPSDEUIActionGroupId() {
        return this.psSysBICube.getPORTLETPSDEUAGROUPID();
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u9009\u9879", ignoredumpvalues="0", codelist="BICubeOption", fields={"BICUBEOPTION"})
    public int getCubeOption() {
        int nOption = this.psSysBICube.getBICUBEOPTION();
        if (nOption > 0) {
            return nOption;
        }
        return 0;
    }
}

