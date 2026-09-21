/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationLogic;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSApplicationLogicImpl
extends PSObjectImpl
implements IPSApplicationLogic {
    private static final Log log = LogFactory.getLog(PSApplicationLogicImpl.class);
    private IPSApplication iPSApplication = null;
    private IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail = null;

    public PSApplicationLogicImpl(IPSApplication iPSApplication, IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail) {
        this.iPSApplication = iPSApplication;
        this.iPSAppDEUILogicGroupDetail = iPSAppDEUILogicGroupDetail;
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5668\u7c7b\u578b", codelist="UILogicTrigger", ignoredumpvalues="APPEVENT")
    public String getTriggerType() {
        return this.iPSAppDEUILogicGroupDetail.getTriggerType();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u540d\u79f0")
    public String getEventNames() {
        return this.iPSAppDEUILogicGroupDetail.getEventNames();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u6570")
    public String getEventArg() {
        return this.iPSAppDEUILogicGroupDetail.getEventArg();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u65702")
    public String getEventArg2() {
        return this.iPSAppDEUILogicGroupDetail.getEventArg2();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getName() {
        return this.iPSAppDEUILogicGroupDetail.getName();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u7c7b\u578b")
    public String getLogicType() {
        return this.iPSAppDEUILogicGroupDetail.getLogicType();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true)
    public String getScriptCode() {
        return this.iPSAppDEUILogicGroupDetail.getScriptCode();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb0")
    public String getLogicTag() {
        if (!StringHelper.isNullOrEmpty((String)this.iPSAppDEUILogicGroupDetail.getLogicTag())) {
            return this.iPSAppDEUILogicGroupDetail.getLogicTag();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91", hideempty=true, from="IPSAppDataEntity")
    public IPSAppDEUILogic getPSAppDEUILogic() {
        try {
            return this.iPSAppDEUILogicGroupDetail.getPSAppDEUILogic();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91", hideempty=true, dumpref=true, from="IPSApplication")
    public IPSAppUILogic getPSAppUILogic() {
        try {
            return this.iPSAppDEUILogicGroupDetail.getPSAppUILogic();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u6240\u5728\u5e94\u7528\u5b9e\u4f53", hideempty=true, dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.getPSAppDEUILogic() != null) {
            return this.getPSAppDEUILogic().getPSAppDataEntity();
        }
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSApplication.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return StringHelper.format((String)"PSAPPLICATIONLOGIC$%1$s", (Object)this.iPSApplication.getModelType());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.iPSApplication.getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1")
    public int getTimer() {
        if (StringHelper.compare((String)this.getTriggerType(), (String)"TIMER", (boolean)false) != 0) {
            return 0;
        }
        return this.iPSAppDEUILogicGroupDetail.getTimer();
    }
}

