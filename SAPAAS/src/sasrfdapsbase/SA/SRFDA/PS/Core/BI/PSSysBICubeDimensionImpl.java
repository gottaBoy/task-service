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

import SA.SRFDA.PS.Core.BI.IPSBICubeLevel;
import SA.SRFDA.PS.Core.BI.IPSBIDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeLevel;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimension;
import SA.SRFDA.PS.Core.BI.PSSysBICubeLevelImpl;
import SA.SRFDA.PS.Core.BI.PSSysBICubeObjectImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBICubeDimension;
import SA.SRFDA.PS.Data.PSSysBICubeLevel;
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

public class PSSysBICubeDimensionImpl
extends PSSysBICubeObjectImpl
implements IPSSysBICubeDimension {
    private static final Log log = LogFactory.getLog(PSSysBICubeDimensionImpl.class);
    protected PSSysBICubeDimension psSysBICubeDimension = null;
    private String strCubeDimensionType = "COMMON";
    private String strDimensionFormula = null;
    private IPSSysBIDimension iPSSysBIDimension = null;
    private IPSDEField iPSDEField = null;
    private IPSDEField textPSDEField = null;
    private ArrayList<IPSSysBICubeLevel> psSysBICubeLevelList = new ArrayList();
    private Map<String, IPSSysBICubeLevel> psSysBICubeLevelMap = new LinkedHashMap<String, IPSSysBICubeLevel>();
    private IPSCodeList iPSCodeList = null;
    private boolean bAllHierarchy = false;
    private boolean bDefault = false;
    private int nStdDataType = 0;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBICube iPSSysBICube, PSSysBICubeDimension psSysBICubeDimension) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBICube(iPSSysBICube);
            this.psSysBICubeDimension = psSysBICubeDimension;
            this.setId(this.psSysBICubeDimension.getPSSYSBICUBEDIMENSIONID());
            this.setName(this.psSysBICubeDimension.getPSSYSBICUBEDIMENSIONNAME());
            this.setPSObjectData(this.psSysBICubeDimension);
            if (!StringHelper.isNullOrEmpty((String)this.psSysBICubeDimension.getBIDIMENSIONTYPE())) {
                this.strCubeDimensionType = this.psSysBICubeDimension.getBIDIMENSIONTYPE();
            }
            if ("COMMON".equals(this.getDimensionType())) {
                if (this.getPSDEField() == null && !StringHelper.isNullOrEmpty((String)this.psSysBICubeDimension.getPSDEFID())) {
                    this.iPSDEField = this.getPSSysBICube().getPSDataEntity().getPSDEField(this.psSysBICubeDimension.getPSDEFID());
                }
                if (this.getPSDEField() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027", new Object[0]));
                }
                if (this.getTextPSDEField() == null) {
                    IPSLinkDEField textPSDEField;
                    IPSInheritDEField iPSInheritDEField;
                    if (!StringHelper.isNullOrEmpty((String)this.psSysBICubeDimension.getTEXTPSDEFID())) {
                        this.textPSDEField = this.getPSSysBICube().getPSDataEntity().getPSDEField(this.psSysBICubeDimension.getTEXTPSDEFID());
                    } else if (this.getPSDEField() instanceof IPSPickupDEField) {
                        this.textPSDEField = ((IPSPickupDEField)this.getPSDEField()).getPSPickupTextDEField();
                    } else if (this.getPSDEField() instanceof IPSInheritDEField && (iPSInheritDEField = (IPSInheritDEField)this.getPSDEField()).getRelatedPSDEField() instanceof IPSPickupDEField && (textPSDEField = ((IPSPickupDEField)iPSInheritDEField.getRelatedPSDEField()).getPSPickupTextDEField()) != null) {
                        this.textPSDEField = this.getPSSysBICube().getPSDataEntity().getPSDEField(textPSDEField.getName(), true);
                    }
                }
            } else if ("CALCULATED".equals(this.getDimensionType())) {
                if (StringHelper.isNullOrEmpty((String)this.getDimensionFormula()) && !StringHelper.isNullOrEmpty((String)this.psSysBICubeDimension.getDIMENSIONFORMULA())) {
                    this.strDimensionFormula = this.psSysBICubeDimension.getDIMENSIONFORMULA();
                }
                if (StringHelper.isNullOrEmpty((String)this.getDimensionFormula())) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u7ef4\u5ea6\u516c\u5f0f", new Object[0]));
                }
            }
            if (this.getPSSysBIDimension() == null && !StringHelper.isNullOrEmpty((String)this.psSysBICubeDimension.getPSSYSBIDIMENSIONID())) {
                this.iPSSysBIDimension = this.getPSSysBIScheme().getPSSysBIDimension(this.psSysBICubeDimension.getPSSYSBIDIMENSIONID());
                if (!this.psSysBICubeDimension.isALLHIERARCHYFLAGNull()) {
                    this.bAllHierarchy = this.psSysBICubeDimension.getALLHIERARCHYFLAG();
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBICubeDimension.getPSCODELISTID())) {
                this.iPSCodeList = this.getPSSysBICube().getPSSysBIScheme().getPSSystem().getPSCodeList(this.psSysBICubeDimension.getPSCODELISTID());
            } else if (this.getPSDEField() != null) {
                this.iPSCodeList = this.getPSDEField().getPSCodeList();
            }
            if (!this.psSysBICubeDimension.isDEFAULTFLAGNull()) {
                this.bDefault = this.psSysBICubeDimension.getDEFAULTFLAG();
            }
            if (!this.psSysBICubeDimension.isSTDDATATYPENull()) {
                this.nStdDataType = this.psSysBICubeDimension.getSTDDATATYPE();
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
        if (this.getPSSysBIDimension() != null) {
            this.onPreparePSSysBICubeLevels();
        }
        super.onInit();
    }

    protected void onPreparePSSysBICubeLevels() throws Exception {
        this.psSysBICubeLevelList.clear();
        Vector<PSSysBICubeLevel> psSysBICubeLevelList = new Vector<PSSysBICubeLevel>();
        CallResult callResult = this.getPSModelHelper().getPSSysBICubeLevels(this.getId(), psSysBICubeLevelList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7acb\u65b9\u4f53\u7ef4\u5ea6\u5c42\u7ea7\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBICubeLevel psSysBICubeLevel : psSysBICubeLevelList) {
            PSSysBICubeLevelImpl iPSSysBICubeLevel = new PSSysBICubeLevelImpl();
            iPSSysBICubeLevel.init(this.getDAGlobalHelper(), this, psSysBICubeLevel);
            this.psSysBICubeLevelList.add(iPSSysBICubeLevel);
            this.psSysBICubeLevelMap.put(iPSSysBICubeLevel.getId(), iPSSysBICubeLevel);
            this.psSysBICubeLevelMap.put(iPSSysBICubeLevel.getName(), iPSSysBICubeLevel);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSBICUBEDIMENSION";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"CODENAME"})
    public String getCodeName() {
        return this.psSysBICubeDimension.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u6807\u8bb0", hideempty2=true, fields={"BICUBEDIMENSIONTAG"})
    public String getDimensionTag() {
        return this.psSysBICubeDimension.getBICUBEDIMENSIONTAG();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u6807\u8bb02", hideempty2=true, fields={"BICUBEDIMENSIONTAG2"})
    public String getDimensionTag2() {
        return this.psSysBICubeDimension.getBICUBEDIMENSIONTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSSysBICube", from_method="getPSDataEntityMust().getPSDEField", fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSSysBICube", from_method="getPSDataEntityMust().getPSDEField", fields={"TEXTPSDEFID"})
    public IPSDEField getTextPSDEField() {
        return this.textPSDEField;
    }

    @Override
    public IPSBIDimension getPSBIDimension() {
        return this.getPSSysBIDimension();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6", hideempty=true, dumpref=true, from="IPSSysBIScheme", fields={"PSSYSBIDIMENSIONID"})
    public IPSSysBIDimension getPSSysBIDimension() {
        return this.iPSSysBIDimension;
    }

    @Override
    @PSModelRTMeta(description="\u7acb\u65b9\u4f53\u7ef4\u5ea6\u5c42\u7ea7\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBICubeLevel> getAllPSSysBICubeLevels() throws Exception {
        if (this.psSysBICubeLevelList == null || this.psSysBICubeLevelList.size() == 0) {
            return null;
        }
        return this.psSysBICubeLevelList.iterator();
    }

    @Override
    public IPSSysBICubeLevel getPSSysBICubeLevel(String strPSSysBICubeLevelId) throws Exception {
        return this.getPSSysBICubeLevel(strPSSysBICubeLevelId, false);
    }

    @Override
    public IPSBICubeLevel getPSBICubeLevel(String strPSBICubeLevelId, boolean bTryMode) throws Exception {
        return this.getPSSysBICubeLevel(strPSBICubeLevelId, bTryMode);
    }

    @Override
    public IPSSysBICubeLevel getPSSysBICubeLevel(String strPSSysBICubeLevelId, boolean bTryMode) throws Exception {
        IPSSysBICubeLevel iPSSysBICubeLevel = null;
        if (this.psSysBICubeLevelMap != null) {
            iPSSysBICubeLevel = this.psSysBICubeLevelMap.get(strPSSysBICubeLevelId);
        }
        if (iPSSysBICubeLevel != null || bTryMode) {
            return iPSSysBICubeLevel;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7acb\u65b9\u4f53\u7ef4\u5ea6\u5c42\u7ea7[%1$s]", (Object)strPSSysBICubeLevelId));
    }

    @Override
    public Iterator<? extends IPSBICubeLevel> getAllPSBICubeLevels() throws Exception {
        return this.getAllPSSysBICubeLevels();
    }

    @Override
    public IPSBICubeLevel getPSBICubeLevel(String strPSBICubeLevelId) throws Exception {
        return this.getPSSysBICubeLevel(strPSBICubeLevelId);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true, dumpref=true, fields={"PSCODELISTID"})
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u7c7b\u578b", codelist="BIDimensionType", fields={"BIDIMENSIONTYPE"})
    public String getDimensionType() {
        return this.strCubeDimensionType;
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u516c\u5f0f", fields={"DIMENSIONFORMULA"})
    public String getDimensionFormula() {
        return this.strDimensionFormula;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u7ef4\u5ea6\u4f53\u7cfb", ignoredumpvalues="false", fields={"ALLHIERARCHYFLAG"})
    public boolean isAllHierarchy() {
        return this.bAllHierarchy;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7ef4\u5ea6", ignoredumpvalues="false", fields={"DEFAULTFLAG"})
    public boolean isDefault() {
        return this.bDefault;
    }

    @Override
    public String getParamPSDEUIActionId() {
        return this.psSysBICubeDimension.getPARAMPSDEUIACTIONID();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u914d\u7f6e\u754c\u9762\u884c\u4e3a\u6807\u8bb0", hideempty=true)
    public String getParamPSDEUIActionTag() throws Exception {
        IPSDEUIAction iPSDEUIAction;
        if (!StringHelper.isNullOrEmpty((String)this.getParamPSDEUIActionId()) && (iPSDEUIAction = this.getPSSysBICube().getPSDataEntity().getPSDEUIAction(this.getParamPSDEUIActionId(), true)) != null) {
            return iPSDEUIAction.getUIActionFullTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0", fields={"STDDATATYPE"})
    public int getStdDataType() {
        if (this.nStdDataType == 0 && this.getPSDEField() != null) {
            return this.getPSDEField().getStdDataType();
        }
        return this.nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u7ed8\u5236\u6a21\u677f", fields={"TEXTTEMPLATE"})
    public String getTextTemplate() {
        return this.psSysBICubeDimension.getTEXTTEMPLATE();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u7ed8\u5236\u6a21\u677f", fields={"TIPTEMPLATE"})
    public String getTipTemplate() {
        return this.psSysBICubeDimension.getTIPTEMPLATE();
    }
}

