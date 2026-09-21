/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSControlLogicProxy3
extends PSObjectImpl
implements IPSControlLogic {
    private static final Log log = LogFactory.getLog(PSControlLogicProxy3.class);
    private IPSControl iPSControl = null;
    private IPSAppViewLogic iPSAppViewLogic = null;
    private IPSAppDEUIAction iPSAppDEUIAction = null;

    public PSControlLogicProxy3(IPSControl iPSControl, IPSAppViewLogic iPSAppViewLogic) {
        this.iPSControl = iPSControl;
        this.iPSAppViewLogic = iPSAppViewLogic;
    }

    public PSControlLogicProxy3(IPSControl iPSControl, IPSAppViewLogic iPSAppViewLogic, IPSAppDEUIAction iPSAppDEUIAction) {
        this.iPSControl = iPSControl;
        this.iPSAppViewLogic = iPSAppViewLogic;
        this.iPSAppDEUIAction = iPSAppDEUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5668\u7c7b\u578b", codelist="CtrlLogicTrigger", ignoredumpvalues="CTRLEVENT")
    public String getTriggerType() {
        return this.iPSAppViewLogic.getLogicTrigger();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u540d\u79f0")
    public String getEventNames() {
        return this.iPSAppViewLogic.getEventNames();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u6570")
    public String getEventArg() {
        return this.iPSAppViewLogic.getEventArg();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u65702")
    public String getEventArg2() {
        return this.iPSAppViewLogic.getEventArg2();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getName() {
        return this.iPSAppViewLogic.getName();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u7c7b\u578b", codelist="ControlLogicType")
    public String getLogicType() {
        if (this.iPSControl != null && this.iPSControl.isEnableUIModelEx()) {
            if (StringHelper.Compare((String)this.iPSAppViewLogic.getLogicType(), (String)"DEUIACTION", (boolean)false) == 0) {
                return "APPDEUIACTION";
            }
            if (StringHelper.Compare((String)this.iPSAppViewLogic.getLogicType(), (String)"DEUILOGIC", (boolean)false) == 0) {
                return "APPDEUILOGIC";
            }
            if (StringHelper.Compare((String)this.iPSAppViewLogic.getLogicType(), (String)"SYSVIEWLOGIC", (boolean)false) == 0) {
                return "APPUILOGIC";
            }
        }
        return this.iPSAppViewLogic.getLogicType();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u89c6\u56fe\u5f15\u64ce", hideempty=true)
    public IPSAppViewEngine getPSAppViewEngine() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u89c6\u56fe\u903b\u8f91", hideempty=true)
    public IPSAppViewLogic getPSAppViewLogic() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true)
    public String getScriptCode() {
        return this.iPSAppViewLogic.getScriptCode();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0")
    public String getItemName() {
        if (!StringHelper.IsNullOrEmpty((String)this.iPSAppViewLogic.getItemName())) {
            return this.iPSAppViewLogic.getItemName();
        }
        String strItemName = this.iPSAppViewLogic.getPSViewCtrlName();
        if (!StringHelper.IsNullOrEmpty((String)strItemName)) {
            return strItemName.toLowerCase();
        }
        return strItemName;
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u5165\u5c5e\u6027\u540d\u79f0")
    public String getAttrName() {
        return this.iPSAppViewLogic.getAttrName();
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1")
    public int getTimer() {
        if (StringHelper.Compare((String)this.getTriggerType(), (String)"TIMER", (boolean)false) != 0) {
            return 0;
        }
        return this.iPSAppViewLogic.getTimer();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb0")
    public String getLogicTag() {
        return this.iPSControl.getName();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91", hideempty=true)
    public IPSAppDEUILogic getPSAppDEUILogic() {
        try {
            return this.iPSAppViewLogic.getPSAppDEUILogic();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", hideempty=true)
    public IPSAppDEUIAction getPSAppDEUIAction() {
        return this.iPSAppDEUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91", hideempty=true, from="IPSApplication")
    public IPSAppUILogic getPSAppUILogic() {
        try {
            return this.iPSAppViewLogic.getPSAppUILogic();
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u6240\u5728\u5e94\u7528\u5b9e\u4f53", hideempty=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.getPSAppDEUIAction() != null) {
            return this.getPSAppDEUIAction().getPSAppDataEntity();
        }
        if (this.getPSAppDEUILogic() != null) {
            return this.getPSAppDEUILogic().getPSAppDataEntity();
        }
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSControl.getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return StringHelper.Format((String)"PSCONTROLLOGIC$%1$s", (Object)this.iPSControl.getModelType());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSControl.getModelId(), (Object)this.getName());
    }
}

