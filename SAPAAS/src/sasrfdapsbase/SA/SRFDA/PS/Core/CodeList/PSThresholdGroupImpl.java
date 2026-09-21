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
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSThreshold;
import SA.SRFDA.PS.Core.CodeList.IPSThresholdGroup;
import SA.SRFDA.PS.Core.CodeList.PSThresholdImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSThreshold;
import SA.SRFDA.PS.Data.PSThresholdGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSThresholdGroupImpl
extends PSSystemObjectImpl
implements IPSThresholdGroup,
IPSSystemObject,
IPSPFLogicCodeObject {
    private static final Log log = LogFactory.getLog(PSThresholdGroupImpl.class);
    protected PSThresholdGroup psThresholdGroup = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEField textPSDEField = null;
    private IPSDEField beginValuePSDEField = null;
    private IPSDEField endValuePSDEField = null;
    private IPSDEField iconClsPSDEField = null;
    private IPSDEField dataPSDEField = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private ArrayList<IPSThreshold> psThresholdList = new ArrayList();
    private String strThresholdGroupType = "STATIC";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSThresholdGroup psThresholdGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psThresholdGroup = psThresholdGroup;
            this.setId(this.psThresholdGroup.getPSTHRESHOLDGROUPID());
            this.setName(this.psThresholdGroup.getPSTHRESHOLDGROUPNAME());
            this.setPSObjectData(this.psThresholdGroup);
            this.strThresholdGroupType = this.psThresholdGroup.getTHRESHOLDGROUPTYPE();
            if (StringHelper.compare((String)this.getThresholdGroupType(), (String)"DYNAMIC", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.psThresholdGroup.getPSDEID())) {
                    this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psThresholdGroup.getPSDEID());
                    if (this.getPSDataEntity() != null) {
                        if (!StringHelper.isNullOrEmpty((String)this.psThresholdGroup.getBEGINVALUEPSDEFID())) {
                            this.beginValuePSDEField = this.getPSDataEntity().getPSDEField(this.psThresholdGroup.getBEGINVALUEPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psThresholdGroup.getENDVALUEPSDEFID())) {
                            this.endValuePSDEField = this.getPSDataEntity().getPSDEField(this.psThresholdGroup.getENDVALUEPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psThresholdGroup.getDATAPSDEFID())) {
                            this.dataPSDEField = this.getPSDataEntity().getPSDEField(this.psThresholdGroup.getDATAPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psThresholdGroup.getICONCLSPSDEFID())) {
                            this.iconClsPSDEField = this.getPSDataEntity().getPSDEField(this.psThresholdGroup.getICONCLSPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psThresholdGroup.getTEXTPSDEFID())) {
                            this.textPSDEField = this.getPSDataEntity().getPSDEField(this.psThresholdGroup.getTEXTPSDEFID());
                        }
                        if (!StringHelper.isNullOrEmpty((String)this.psThresholdGroup.getPSDEDSID())) {
                            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psThresholdGroup.getPSDEDSID());
                        }
                    }
                } else {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u9608\u503c\u7ec4\u6240\u5b58\u50a8\u7684\u5b9e\u4f53");
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psThresholdGroup.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psThresholdGroup.getPSMODULEID());
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
        this.onPreparePSThresholds();
        super.onInit();
    }

    protected void onPreparePSThresholds() throws Exception {
        this.psThresholdList.clear();
        Vector<PSThreshold> psThresholdList = new Vector<PSThreshold>();
        CallResult callResult = this.getPSModelHelper().getPSThresholds(this.getId(), psThresholdList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u9608\u503c\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSThreshold psThreshold : psThresholdList) {
            PSThresholdImpl iPSThreshold = new PSThresholdImpl();
            iPSThreshold.init(this.getDAGlobalHelper(), this, psThreshold);
            this.psThresholdList.add(iPSThreshold);
        }
    }

    @PSModelRTMeta(description="\u9608\u503c\u9879\u96c6\u5408", hideempty2=true, child=true)
    public Iterator<IPSThreshold> getPSThresholds() {
        if (this.psThresholdList == null || this.psThresholdList.size() == 0) {
            return null;
        }
        return this.psThresholdList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSTHRESHOLDGROUP";
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u7ec4\u7c7b\u578b", codelist="ThresholdGroupType")
    public String getThresholdGroupType() {
        return this.strThresholdGroupType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psThresholdGroup.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u7ec4\u6807\u8bb0")
    public String getThresholdGroupTag() {
        return this.psThresholdGroup.getTHRESHOLDGROUPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u7ec4\u6807\u8bb02")
    public String getThresholdGroupTag2() {
        return this.psThresholdGroup.getTHRESHOLDGROUPTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u503c\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getBeginValuePSDEField() {
        return this.beginValuePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u503c\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getEndValuePSDEField() {
        return this.endValuePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f\u503c\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getIconClsPSDEField() {
        return this.iconClsPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u503c\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getTextPSDEField() {
        return this.textPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u6570\u636e\u5b58\u50a8\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getDataPSDEField() {
        return this.dataPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeCat() {
        return "THRESHOLDGROUP";
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        return this.getThresholdGroupType();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6761\u4ef6")
    public String getCustomCond() {
        return this.psThresholdGroup.getCUSTOMCOND();
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return null;
    }
}

