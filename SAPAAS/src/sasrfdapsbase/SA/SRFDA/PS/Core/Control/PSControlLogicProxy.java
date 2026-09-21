/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
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
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFramework.Utility.StringHelper;

public class PSControlLogicProxy
extends PSObjectImpl
implements IPSControlLogic {
    private IPSControl iPSControl = null;
    private IPSControlLogic iPSControlLogic = null;

    public PSControlLogicProxy(IPSControl iPSControl, IPSControlLogic iPSControlLogic) {
        this.iPSControl = iPSControl;
        this.iPSControlLogic = iPSControlLogic;
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5668\u7c7b\u578b", codelist="CtrlLogicTrigger", ignoredumpvalues="CTRLEVENT")
    public String getTriggerType() {
        return this.iPSControlLogic.getTriggerType();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u540d\u79f0")
    public String getEventNames() {
        return this.iPSControlLogic.getEventNames();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u6570")
    public String getEventArg() {
        return this.iPSControlLogic.getEventArg();
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u53c2\u65702")
    public String getEventArg2() {
        return this.iPSControlLogic.getEventArg2();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getName() {
        return this.iPSControlLogic.getName();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u903b\u8f91\u7c7b\u578b", codelist="ControlLogicType")
    public String getLogicType() {
        return this.iPSControlLogic.getLogicType();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u540d\u79f0")
    public String getItemName() {
        return this.iPSControlLogic.getItemName();
    }

    @Override
    @PSModelRTMeta(description="\u6ce8\u5165\u5c5e\u6027\u540d\u79f0")
    public String getAttrName() {
        return this.iPSControlLogic.getAttrName();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u89c6\u56fe\u5f15\u64ce", hideempty=true, dumpref=true)
    public IPSAppViewEngine getPSAppViewEngine() {
        return this.iPSControlLogic.getPSAppViewEngine();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u89c6\u56fe\u903b\u8f91", hideempty=true, dumpref=true)
    public IPSAppViewLogic getPSAppViewLogic() {
        return this.iPSControlLogic.getPSAppViewLogic();
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
    @PSModelRTMeta(description="\u89e6\u53d1\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91", hideempty=true, dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEUILogic getPSAppDEUILogic() {
        return this.iPSControlLogic.getPSAppDEUILogic();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a", hideempty=true, child=true)
    public IPSAppDEUIAction getPSAppDEUIAction() {
        return this.iPSControlLogic.getPSAppDEUIAction();
    }

    @Override
    @PSModelRTMeta(description="\u89e6\u53d1\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91", hideempty=true, dumpref=true, from="IPSApplication")
    public IPSAppUILogic getPSAppUILogic() {
        return this.iPSControlLogic.getPSAppUILogic();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true)
    public String getScriptCode() {
        return this.iPSControlLogic.getScriptCode();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6807\u8bb0")
    public String getLogicTag() {
        return this.iPSControlLogic.getLogicTag();
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1", outputdoc="%1$s.getTriggerType() == 'TIMER'")
    public int getTimer() {
        if (StringHelper.Compare((String)this.getTriggerType(), (String)"TIMER", (boolean)false) != 0) {
            return 0;
        }
        return this.iPSControlLogic.getTimer();
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

