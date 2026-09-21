/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIActionRuntime;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSAppViewUIActionProxy
extends PSObjectImpl
implements IPSAppViewUIAction,
IPSAppViewUIActionRuntime {
    private static final Log log = LogFactory.getLog(PSAppViewUIActionProxy.class);
    private IPSControlContainer iPSControlContainer = null;
    private IPSUIAction iPSUIAction = null;
    private Object objOwner = null;
    private IPSControl xDataPSControl = null;
    private IPSAppCounterRef iPSAppCounterRef = null;
    private IPSAppViewUIAction iPSAppViewUIAction = null;

    public PSAppViewUIActionProxy(Object objOwner, IPSUIAction iPSUIAction, IPSControl xDataPSControl) throws Exception {
        this.iPSControlContainer = PSSystemUtil.getRefPSControlContainer(objOwner, false);
        this.iPSUIAction = iPSUIAction;
        this.xDataPSControl = xDataPSControl;
        this.setId(iPSUIAction.getId());
        this.setName(iPSUIAction.getName());
    }

    public PSAppViewUIActionProxy(String strId, String strName, Object objOwner, IPSAppViewUIAction iPSAppViewUIAction) throws Exception {
        IPSControl iPSControl;
        this.iPSAppViewUIAction = iPSAppViewUIAction;
        this.setId(strId);
        this.setName(strName);
        this.objOwner = objOwner;
        if (this.getPSAppView().getPSSystem().isEnableDynaSys() && (iPSControl = PSSystemUtil.getRefPSControl(objOwner, true)) != null && objOwner != iPSControl && objOwner instanceof IPSObject) {
            this.setId(String.format("%1$s_%2$s", iPSControl.getName(), strId));
            this.setName(String.format("%1$s_%2$s", iPSControl.getName(), strName));
        }
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61", dumpref=true)
    public IPSUIAction getPSUIAction() {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.getPSUIAction();
        }
        return this.iPSUIAction;
    }

    @Override
    public IPSAppView getPSAppView() {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.getPSAppView();
        }
        return this.getPSControlContainer().getPSAppView();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u53c2\u6570")
    public JSONObject getUIActionParamJO() {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.getUIActionParamJO();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u6570\u636e\u90e8\u4ef6\u540d\u79f0")
    public String getXDataControlName() {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.getXDataControlName();
        }
        try {
            if (this.getXDataPSControl() != null) {
                return this.getXDataPSControl().getName();
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u6570\u636e\u90e8\u4ef6")
    public IPSControl getXDataPSControl() throws Exception {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.getXDataPSControl();
        }
        return this.xDataPSControl;
    }

    @Override
    @PSModelRTMeta(description="\u5148\u4fdd\u5b58\u76ee\u6807\u6570\u636e", ignoredumpvalues="false")
    public boolean isSaveTargetFirst() {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.isSaveTargetFirst();
        }
        if (this.iPSUIAction instanceof IPSDEUIAction) {
            return ((IPSDEUIAction)this.iPSUIAction).isSaveTargetFirst();
        }
        if (this.iPSUIAction instanceof IPSWFUIAction) {
            return ((IPSWFUIAction)this.iPSUIAction).isSaveTargetFirst();
        }
        return false;
    }

    @Override
    public IPSControlContainer getPSControlContainer() {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.getPSControlContainer();
        }
        return this.iPSControlContainer;
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.getPSSysModelInstId();
        }
        return this.getPSControlContainer().getPSSysModelInstId();
    }

    public Object getOwner() {
        return this.objOwner;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true)
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.getPSAppCounterRef();
        }
        return this.iPSAppCounterRef;
    }

    @Override
    public void setPSAppCounterRef(IPSAppCounterRef iPSAppCounterRef) {
        if (this.iPSAppViewUIAction != null && this.iPSAppViewUIAction instanceof IPSAppViewUIActionRuntime) {
            ((IPSAppViewUIActionRuntime)((Object)this.iPSAppViewUIAction)).setPSAppCounterRef(iPSAppCounterRef);
            return;
        }
        this.iPSAppCounterRef = iPSAppCounterRef;
    }

    @Override
    public String getModelType() {
        if (this.getPSControlContainer() instanceof IPSModelObject) {
            return StringHelper.Format((String)"%1$s$%2$s", (Object)"PSAPPVIEWUIACTION", (Object)this.getPSControlContainer().getModelType());
        }
        return "PSAPPVIEWUIACTION";
    }

    @Override
    public String getModelId() {
        if (this.getPSControlContainer() instanceof IPSModelObject) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSControlContainer().getModelId(), (Object)this.getId());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u64cd\u4f5c\u76ee\u6807", codelist="DEUIActionDataRange")
    public String getUIActionTarget() {
        if (this.iPSAppViewUIAction != null) {
            return this.iPSAppViewUIAction.getUIActionTarget();
        }
        return this.getPSUIAction().getActionTarget();
    }
}

