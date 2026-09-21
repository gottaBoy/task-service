/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDEGroupDetail;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEGroupDetailImpl
extends PSObjectImpl
implements IPSDEGroupDetail,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEGroupDetailImpl.class);
    private IPSDEGroup iPSDEGroup = null;
    private PSDEGroupDetail psDEGroupDetail = null;
    private IPSDataEntity iPSDataEntity = null;
    private int nOrderValue = 99999;
    private String strCodeName = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEGroup iPSDEGroup, PSDEGroupDetail psDEGroupDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEGroup = iPSDEGroup;
            this.psDEGroupDetail = psDEGroupDetail;
            this.setId(this.psDEGroupDetail.getPSDEGROUPDETAILID());
            this.setName(this.psDEGroupDetail.getPSDEGROUPDETAILNAME());
            this.setPSObjectData(this.psDEGroupDetail);
            if (!StringHelper.isNullOrEmpty((String)psDEGroupDetail.getPSDEID())) {
                if (iPSDEGroup.getPSDataEntity() != null && StringHelper.compare((String)iPSDEGroup.getPSDataEntity().getId(), (String)psDEGroupDetail.getPSDEID(), (boolean)false) == 0) {
                    this.iPSDataEntity = iPSDEGroup.getPSDataEntity();
                }
                if (this.getPSDataEntity() == null) {
                    this.iPSDataEntity = iPSDEGroup.getPSSystem().getPSDataEntity2(psDEGroupDetail.getPSDEID());
                }
            }
            if (this.getPSDataEntity() == null) {
                throw new Exception("\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548");
            }
            this.strCodeName = psDEGroupDetail.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getPSDataEntity().getCodeName();
            }
            if (!this.psDEGroupDetail.isORDERVALUENull()) {
                this.nOrderValue = this.psDEGroupDetail.getORDERVALUE();
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
    public IPSDEGroup getPSDEGroup() {
        return this.iPSDEGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEGroup().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        if (StringHelper.compare((String)this.getPSDEGroup().getModelType(), (String)"PSSYSDEGROUP", (boolean)false) == 0) {
            return "PSSYSDEGROUPDETAIL";
        }
        return "PSDEGROUPDETAIL";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEGroup().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEGroup().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEGroup().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999")
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return this.psDEGroupDetail.getCODENAME2();
    }

    @Override
    public String getMemo() {
        if (StringHelper.isNullOrEmpty((String)super.getMemo())) {
            return this.getPSDataEntity().getMemo();
        }
        return super.getMemo();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u53c2\u6570", hideempty2=true)
    public String getDetailParam() {
        return this.psDEGroupDetail.getDETAILPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u53c2\u65702", hideempty2=true)
    public String getDetailParam2() {
        return this.psDEGroupDetail.getDETAILPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb0", hideempty2=true)
    public String getDetailTag() {
        return this.psDEGroupDetail.getDETAILTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6807\u8bb02", hideempty2=true)
    public String getDetailTag2() {
        return this.psDEGroupDetail.getDETAILTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6210\u5458\u6570\u636e", hideempty2=true)
    public String getData() {
        return this.psDEGroupDetail.getDATA();
    }
}

