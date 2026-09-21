/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppViewEngine;
import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;

@PSModelRTIgnoreMeta
public abstract class PSControlLogicImpl
extends PSObjectImpl
implements IPSControlLogic {
    private IPSModelObject iPSModelObject = null;

    public PSControlLogicImpl(IPSModelObject iPSModelObject) {
        this.iPSModelObject = iPSModelObject;
    }

    @Override
    public String getTriggerType() {
        return "CTRLEVENT";
    }

    @Override
    public String getName() {
        if (this.getOwner() != null) {
            return this.getOwner().getName();
        }
        return super.getName();
    }

    @Override
    public String getId() {
        if (this.getOwner() != null) {
            return this.getOwner().getId();
        }
        return super.getId();
    }

    @Override
    public String getModelId() {
        if (this.getOwner() != null) {
            return this.getOwner().getModelId();
        }
        return super.getModelId();
    }

    @Override
    public String getModelType() {
        if (this.getOwner() != null) {
            return this.getOwner().getModelType();
        }
        return super.getModelType();
    }

    @Override
    public String getEventArg() {
        return "";
    }

    @Override
    public String getEventArg2() {
        return "";
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.getOwner() != null) {
            return this.getOwner().getPSSysModelInstId();
        }
        return null;
    }

    protected IPSModelObject getOwner() {
        return this.iPSModelObject;
    }

    @Override
    public IPSAppViewEngine getPSAppViewEngine() {
        return null;
    }

    @Override
    public IPSAppViewLogic getPSAppViewLogic() {
        return null;
    }

    @Override
    public IPSAppDEUILogic getPSAppDEUILogic() {
        return null;
    }

    @Override
    public IPSAppDEUIAction getPSAppDEUIAction() {
        return null;
    }

    @Override
    public IPSAppUILogic getPSAppUILogic() {
        return null;
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntity() {
        if (this.getPSAppDEUILogic() != null) {
            return this.getPSAppDEUILogic().getPSAppDataEntity();
        }
        return null;
    }

    @Override
    public String getScriptCode() {
        return null;
    }

    @Override
    public int getTimer() {
        return 0;
    }

    @Override
    public String getItemName() {
        return null;
    }

    @Override
    public String getAttrName() {
        return null;
    }

    @Override
    public String getLogicType() {
        if (this.getPSAppViewLogic() != null) {
            return "APPVIEWLOGIC";
        }
        if (this.getPSAppViewEngine() != null) {
            return "APPVIEWENGINE";
        }
        if (this.getPSAppDEUILogic() != null) {
            return "APPDEUILOGIC";
        }
        if (this.getPSAppDEUIAction() != null) {
            return "APPDEUIACTION";
        }
        if (this.getPSAppUILogic() != null) {
            return "APPUILOGIC";
        }
        return "CUSTOM";
    }
}

