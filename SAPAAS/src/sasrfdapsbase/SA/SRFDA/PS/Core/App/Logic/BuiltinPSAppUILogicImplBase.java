/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.Logic.PSAppUILogicImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSSysViewLogic;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class BuiltinPSAppUILogicImplBase
extends PSAppUILogicImpl {
    private Object objOwner = null;
    private IPSControlContainer iPSControlContainer = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object objOwner, PSSysViewLogic psSysViewLogic) throws Exception {
        this.setBuiltinLogic(true);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setOwner(objOwner);
        if (this.getPSAppView() == null) {
            throw new Exception("\u5e94\u7528\u89c6\u56fe\u903b\u8f91\u4f20\u5165\u5bf9\u8c61\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u5e94\u7528\u89c6\u56fe\u5bf9\u8c61");
        }
        super.init(iDAGlobalHelper, this.getPSAppView().getPSApplication(), psSysViewLogic);
    }

    protected void setOwner(Object objOwner) {
        this.objOwner = objOwner;
        this.iPSControlContainer = null;
        if (this.objOwner instanceof IPSControlContainer) {
            this.iPSControlContainer = (IPSControlContainer)this.objOwner;
        } else if (this.objOwner instanceof IPSControlObject) {
            IPSControlObject iPSControlObject = (IPSControlObject)this.objOwner;
            this.iPSControlContainer = iPSControlObject.getOwnedPSControl().getPSControlContainer();
        } else if (this.objOwner instanceof IPSControl) {
            IPSControl iPSControl = (IPSControl)this.objOwner;
            this.iPSControlContainer = iPSControl.getPSControlContainer();
        }
    }

    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u5bf9\u8c61")
    public IPSAppView getPSAppView() {
        if (this.getPSControlContainer() == null) {
            return null;
        }
        return this.getPSControlContainer().getPSAppView();
    }

    @PSModelRTMeta(description="\u90e8\u4ef6\u5bb9\u5668\u5bf9\u8c61")
    public IPSControlContainer getPSControlContainer() {
        return this.iPSControlContainer;
    }

    public Object getOwner() {
        return this.objOwner;
    }

    @Override
    public String getModelType() {
        if (this.getOwner() instanceof IPSModelObject) {
            return StringHelper.Format((String)"%1$s$%2$s", (Object)"PSAPPUILOGICBUILDIN", (Object)((IPSModelObject)this.getOwner()).getModelType());
        }
        return "PSAPPUILOGICBUILDIN";
    }

    @Override
    public String getModelId() {
        if (this.getOwner() instanceof IPSModelObject) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)((IPSModelObject)this.getOwner()).getModelId(), (Object)this.getId());
        }
        return super.getModelId();
    }

    @Override
    public ObjectNode toModelRef(String strType) {
        return this.toModel(strType);
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return false;
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

