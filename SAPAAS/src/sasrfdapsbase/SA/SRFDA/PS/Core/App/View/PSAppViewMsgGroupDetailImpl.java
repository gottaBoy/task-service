/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppViewMsg;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroup;
import SA.SRFDA.PS.Core.App.View.IPSAppViewMsgGroupDetail;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
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

public class PSAppViewMsgGroupDetailImpl
extends PSObjectImpl
implements IPSAppViewMsgGroupDetail {
    private static final Log log = LogFactory.getLog(PSAppViewMsgGroupDetailImpl.class);
    private IPSAppViewMsgGroup iPSAppViewMsgGroup = null;
    private IPSViewMsgGroupDetail iPSViewMsgGroupDetail = null;
    private IPSAppViewMsg iPSAppViewMsg = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppViewMsgGroup iPSAppViewMsgGroup, IPSViewMsgGroupDetail iPSViewMsgGroupDetail) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppViewMsgGroup = iPSAppViewMsgGroup;
            this.iPSViewMsgGroupDetail = iPSViewMsgGroupDetail;
            this.setId(iPSViewMsgGroupDetail.getId());
            this.setName(iPSViewMsgGroupDetail.getName());
            this.iPSAppViewMsg = this.getPSAppViewMsgGroup().getPSApplication().getPSAppViewMsg(iPSViewMsgGroupDetail.getPSViewMsgId());
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
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
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSViewMsgGroup iPSViewMsgGroup, PSViewMsgGroupDetail psViewMsgGroupDetail) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSViewMsgGroupDetail();
    }

    @Override
    public IPSViewMsgGroup getPSViewMsgGroup() {
        return this.iPSAppViewMsgGroup;
    }

    public IPSViewMsgGroupDetail getPSViewMsgGroupDetail() {
        return this.iPSViewMsgGroupDetail;
    }

    @Override
    public String getPSViewMsgId() {
        return this.getPSViewMsgGroupDetail().getPSViewMsgId();
    }

    @Override
    public IPSViewMsg getPSViewMsg() throws Exception {
        return this.iPSAppViewMsg;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u6d88\u606f\u7ec4", outputdoc="false")
    public IPSAppViewMsgGroup getPSAppViewMsgGroup() {
        return this.iPSAppViewMsgGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u6d88\u606f", dumpref=true, from="IPSApplication", group="\u57fa\u672c", order=130, fields={"PSVIEWMSGID"})
    public IPSAppViewMsg getPSAppViewMsg() {
        return this.iPSAppViewMsg;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppViewMsgGroup().getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppViewMsgGroup().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelId() {
        if (this.getPSAppViewMsgGroup() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppViewMsgGroup().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        return "PSAPPVIEWMSGGRPDETAIL";
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u4f4d\u7f6e", codelist="ViewMsgPos", fields={"MSGPOS"})
    public String getPosition() {
        return this.getPSViewMsgGroupDetail().getPosition();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSAppViewMsgGroup();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSAppViewMsgGroup();
    }
}

