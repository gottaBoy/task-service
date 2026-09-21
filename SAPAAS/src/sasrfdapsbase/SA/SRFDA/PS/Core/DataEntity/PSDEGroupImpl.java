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
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDEGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDEGroupDetailImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Util.PSModelUtil;
import SA.SRFDA.PS.Data.PSDEGroup;
import SA.SRFDA.PS.Data.PSDEGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGroupImpl
extends PSDataEntityObjectImpl
implements IPSDEGroup {
    private static final Log log = LogFactory.getLog(PSDEGroupImpl.class);
    protected PSDEGroup psDEGroup = null;
    protected ArrayList<IPSDataEntity> psDataEntityList = new ArrayList();
    protected ArrayList<IPSDEGroupDetail> psDEGroupDetailList = new ArrayList();
    private String strCodeName = "";
    private int nOrderValue = 99999;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEGroup psDEGroup) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEGroup = psDEGroup;
            this.setId(this.psDEGroup.getPSDEGROUPID());
            this.setName(this.psDEGroup.getPSDEGROUPNAME());
            this.setPSObjectData(this.psDEGroup);
            this.strCodeName = this.psDEGroup.getCODENAME();
            if (!this.psDEGroup.isORDERVALUENull()) {
                this.nOrderValue = this.psDEGroup.getORDERVALUE();
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
        this.onPreparePSDataEntities();
    }

    protected void onPreparePSDataEntities() throws Exception {
        this.psDataEntityList.clear();
        this.psDEGroupDetailList.clear();
        Vector<PSDEGroupDetail> psDEGroupDetailList = new Vector<PSDEGroupDetail>();
        CallResult callResult = this.getPSModelHelper().getPSDEGroupDetails(this.getId(), psDEGroupDetailList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u7ec4\u6210\u5458\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEGroupDetail psDEGroupDetail : psDEGroupDetailList) {
            if (!psDEGroupDetail.isVALIDFLAGNull() && !psDEGroupDetail.getVALIDFLAG()) continue;
            PSDEGroupDetailImpl iPSDEGroupDetail = new PSDEGroupDetailImpl();
            iPSDEGroupDetail.init(this.getDAGlobalHelper(), this, psDEGroupDetail);
            this.psDEGroupDetailList.add(iPSDEGroupDetail);
            if (iPSDEGroupDetail.getPSDataEntity() == null) continue;
            this.psDataEntityList.add(iPSDEGroupDetail.getPSDataEntity());
        }
        PSModelUtil.sort(this.psDEGroupDetailList);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDataEntity> getPSDataEntities() {
        if (this.psDataEntityList == null || this.psDataEntityList.size() == 0) {
            return null;
        }
        return this.psDataEntityList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7ec4\u6210\u5458\u96c6\u5408", child=true, dynamodelmode=5, ignorepf=true, group="\u57fa\u672c", order=130)
    public Iterator<IPSDEGroupDetail> getPSDEGroupDetails() {
        if (this.psDEGroupDetailList == null || this.psDEGroupDetailList.size() == 0) {
            return null;
        }
        return this.psDEGroupDetailList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDEGROUP";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDEGroup.getCODENAME2();
    }

    @Override
    public boolean contains(String strPSDataEntityName) {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDataEntityName)) {
            return false;
        }
        if (this.psDataEntityList == null || this.psDataEntityList.size() == 0) {
            return false;
        }
        for (IPSDataEntity iPSDataEntity : this.psDataEntityList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDataEntity.getId(), (String)strPSDataEntityName, (boolean)false) == 0) {
                return true;
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDataEntity.getName(), (String)strPSDataEntityName, (boolean)true) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(IPSDataEntity iPSDataEntity2) {
        if (iPSDataEntity2 == null) {
            return false;
        }
        if (this.psDataEntityList == null || this.psDataEntityList.size() == 0) {
            return false;
        }
        for (IPSDataEntity iPSDataEntity : this.psDataEntityList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDataEntity.getId(), (String)iPSDataEntity2.getId(), (boolean)false) != 0) continue;
            return true;
        }
        return false;
    }

    @Override
    public IPSDEGroupDetail getPSDEGroupDetail(String strPSDEIdOrName, boolean bTryMode) throws Exception {
        for (IPSDEGroupDetail iPSDEGroupDetail : this.psDEGroupDetailList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEGroupDetail.getPSDataEntity().getId(), (String)strPSDEIdOrName, (boolean)false) == 0) {
                return iPSDEGroupDetail;
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEGroupDetail.getPSDataEntity().getName(), (String)strPSDEIdOrName, (boolean)true) != 0) continue;
            return iPSDEGroupDetail;
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u7ec4\u6210\u5458[%1$s]", (Object)strPSDEIdOrName));
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6a21\u5f0f", hideempty2=true, codelist="DEGroupLogicMode", fields={"LOGICMODE"})
    public String getLogicMode() {
        return this.psDEGroup.getLOGICMODE();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u6570", hideempty2=true, fields={"LOGICPARAM"})
    public String getLogicParam() {
        return this.psDEGroup.getLOGICPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u53c2\u65702", hideempty2=true, fields={"LOGICPARAM2"})
    public String getLogicParam2() {
        return this.psDEGroup.getLOGICPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb0", fields={"GROUPTAG"})
    public String getGroupTag() {
        return this.psDEGroup.getGROUPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6807\u8bb02", fields={"GROUPTAG2"})
    public String getGroupTag2() {
        return this.psDEGroup.getGROUPTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return null;
    }
}

