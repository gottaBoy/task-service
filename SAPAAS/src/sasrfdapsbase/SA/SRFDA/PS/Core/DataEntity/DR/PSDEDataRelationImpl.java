/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.DataEntity.DR.PSDEDRDetailImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSDEDRDetail;
import SA.SRFDA.PS.Data.PSDEDataRelation;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEDataRelationImpl
extends PSDataEntityObjectImpl
implements IPSDEDataRelation,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEDataRelationImpl.class);
    protected PSDEDataRelation psDEDataRelation;
    protected ArrayList<IPSDEDRDetail> psDEDRDetailList = new ArrayList();
    private boolean bHideEditItem = false;
    private String strFormCaption = null;
    private IPSLanguageRes formCapPSLanguageRes = null;
    private IPSSysImage formPSSysImage = null;
    private List<IPSDEDRGroup> psDEDRGroupList = null;
    private boolean bEnableCustomized = false;
    private IPSSysCounter iPSSysCounter = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDataRelation psDEDataRelation) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEDataRelation = psDEDataRelation;
            this.setId(psDEDataRelation.getPSDEDATARELATIONID());
            this.setName(psDEDataRelation.getPSDEDATARELATIONNAME());
            this.setPSObjectData(this.psDEDataRelation);
            if (!this.psDEDataRelation.isHIDEEDITITEMNull()) {
                this.bHideEditItem = this.psDEDataRelation.getHIDEEDITITEM();
            }
            this.strFormCaption = this.psDEDataRelation.getFORMCAPTION();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strFormCaption)) {
                this.strFormCaption = this.getPSDataEntity().getLogicName();
            }
            this.formCapPSLanguageRes = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataRelation.getFORMCAPPSLANRESID()) ? this.getPSSystem().getPSLanguageRes(this.psDEDataRelation.getFORMCAPPSLANRESID()) : this.getPSDataEntity().getLNPSLanguageRes();
            this.formPSSysImage = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataRelation.getFORMPSSYSIMAGEID()) ? this.getPSSystem().getPSSysImage(this.psDEDataRelation.getFORMPSSYSIMAGEID()) : this.getPSDataEntity().getPSSysImage();
            if (!this.psDEDataRelation.isENABLECUSTOMIZEDNull()) {
                this.bEnableCustomized = this.psDEDataRelation.getENABLECUSTOMIZED();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataRelation.getPSSYSCOUNTERID())) {
                this.iPSSysCounter = this.getPSSystem().getPSSysCounter(this.psDEDataRelation.getPSSYSCOUNTERID());
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
        super.onInit();
        this.onPreparePSDEDRDetails();
    }

    protected void onPreparePSDEDRDetails() throws Exception {
        this.psDEDRDetailList.clear();
        this.psDEDRGroupList = null;
        Vector<PSDEDRDetail> psDEDRDetailList = new Vector<PSDEDRDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDEDRDetails(this.getId(), psDEDRDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDRDetail psDEDRDetail : psDEDRDetailList) {
            if (psDEDRDetail.getORDERVALUE() < 0 || !psDEDRDetail.isVALIDFLAGNull() && !psDEDRDetail.getVALIDFLAG()) continue;
            PSDEDRDetailImpl iPSDEDRDetail = new PSDEDRDetailImpl();
            iPSDEDRDetail.init(this.getDAGlobalHelper(), this, psDEDRDetail);
            this.psDEDRDetailList.add(iPSDEDRDetail);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u6210\u5458\u96c6\u5408", child=true)
    public Iterator<IPSDEDRDetail> getPSDEDRDetails() {
        return this.psDEDRDetailList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u7ec4\u5206\u7ec4\u96c6\u5408")
    public Iterator<IPSDEDRGroup> getPSDEDRGroups() {
        if (this.psDEDRGroupList == null) {
            ArrayList<IPSDEDRGroup> psDEDRGroupList = new ArrayList<IPSDEDRGroup>();
            LinkedHashMap<String, IPSDEDRGroup> psDEDRGroupMap = new LinkedHashMap<String, IPSDEDRGroup>();
            Iterator<IPSDEDRDetail> psDEDRDetails = this.getPSDEDRDetails();
            if (psDEDRDetails != null) {
                while (psDEDRDetails.hasNext()) {
                    IPSDEDRDetail iPSDEDRDetail = psDEDRDetails.next();
                    IPSDEDRGroup iPSDEDRGroup = iPSDEDRDetail.getPSDEDRGroup();
                    if (iPSDEDRGroup == null || psDEDRGroupMap.containsKey(iPSDEDRGroup.getId())) continue;
                    psDEDRGroupMap.put(iPSDEDRGroup.getId(), iPSDEDRGroup);
                    psDEDRGroupList.add(iPSDEDRGroup);
                }
            }
            if (this.psDEDRGroupList == null) {
                this.psDEDRGroupList = psDEDRGroupList;
            }
        }
        return this.psDEDRGroupList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psDEDataRelation.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSDEDATARELATION";
    }

    @Override
    public String getPSSysCounterId() {
        return this.psDEDataRelation.getPSSYSCOUNTERID();
    }

    @Override
    public String getFormPSDEViewBaseId() {
        return this.psDEDataRelation.getFORMPSDEVIEWBASEID();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u9690\u85cf\u7f16\u8f91\u9879", ignoredumpvalues="false", fields={"HIDEEDITITEM"})
    public boolean isHideEditItem() {
        return this.bHideEditItem;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u6807\u9898", fields={"FORMCAPTION"})
    public String getFormCaption() {
        return this.strFormCaption;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"FORMCAPPSLANRESID"})
    public IPSLanguageRes getFormCapPSLanguageRes() {
        return this.formCapPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u56fe\u6807\u8d44\u6e90", fields={"FORMPSSYSIMAGEID"})
    public IPSSysImage getFormPSSysImage() {
        return this.formPSSysImage;
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getCodeName());
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    public String getPSDEUILogicGroupId() {
        return this.psDEDataRelation.getPSCTRLLOGICGROUPID();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u5b9a\u4e49\u5173\u7cfb\u9879", ignoredumpvalues="false", fields={"ENABLECUSTOMIZED"})
    public boolean isEnableCustomized() {
        return this.bEnableCustomized;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668", dumpref=true, fields={"PSSYSCOUNTERID"})
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }
}

