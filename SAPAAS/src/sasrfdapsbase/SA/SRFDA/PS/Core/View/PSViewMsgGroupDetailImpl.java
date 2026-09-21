/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroupDetail;
import SA.SRFDA.PS.Data.PSViewMsgGroupDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSViewMsgGroupDetailImpl
extends PSObjectImpl
implements IPSViewMsgGroupDetail {
    private PSViewMsgGroupDetail psViewMsgGroupDetail = null;
    private IPSViewMsgGroup iPSViewMsgGroup = null;
    private String strPSViewMsgId = null;
    private IPSViewMsg iPSViewMsg = null;
    private static final Log log = LogFactory.getLog(PSViewMsgGroupDetailImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSViewMsgGroup iPSViewMsgGroup, PSViewMsgGroupDetail psViewMsgGroupDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psViewMsgGroupDetail = psViewMsgGroupDetail;
            this.iPSViewMsgGroup = iPSViewMsgGroup;
            this.setId(this.psViewMsgGroupDetail.getPSVIEWMSGGRPDETAILID());
            this.setName(this.psViewMsgGroupDetail.getPSVIEWMSGGRPDETAILNAME());
            this.setPSObjectData(this.psViewMsgGroupDetail);
            this.strPSViewMsgId = this.psViewMsgGroupDetail.getPSVIEWMSGID();
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u89c6\u56fe\u6d88\u606f\u7ec4")
    public IPSViewMsgGroup getPSViewMsgGroup() {
        return this.iPSViewMsgGroup;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSViewMsgGroup().getPSSysModelInstId();
    }

    @Override
    public String getPSViewMsgId() {
        return this.strPSViewMsgId;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u89c6\u56fe\u6d88\u606f")
    public IPSViewMsg getPSViewMsg() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSViewMsgId())) {
            return null;
        }
        if (this.iPSViewMsg == null) {
            this.iPSViewMsg = this.getPSViewMsgGroup().getPSSystem().getPSViewMsg(this.getPSViewMsgId());
        }
        return this.iPSViewMsg;
    }

    @Override
    public String getModelType() {
        return "PSVIEWMSGGRPDETAIL";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSViewMsgGroup().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSViewMsgGroup().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSViewMsgGroup().getModelId(), (Object)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4f4d\u7f6e", codelist="ViewMsgPos")
    public String getPosition() {
        return this.psViewMsgGroupDetail.getMSGPOS();
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

