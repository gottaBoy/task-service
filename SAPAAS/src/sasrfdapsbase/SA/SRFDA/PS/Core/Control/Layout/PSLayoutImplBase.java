/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSLayout;

public abstract class PSLayoutImplBase
extends PSObjectImpl
implements IPSLayout {
    private IPSModelObject iPSModelObject = null;
    private PSLayout layoutData = null;
    private IPSLayout parentPSLayout = null;
    private IPSControl iPSControl = null;

    @Override
    public void init(IPSModelObject iPSModelObject, PSLayout layoutData) throws Exception {
        this.layoutData = layoutData;
        this.iPSModelObject = iPSModelObject;
        if (this.iPSModelObject instanceof IPSLayoutContainer) {
            this.parentPSLayout = ((IPSLayoutContainer)((Object)this.iPSModelObject)).getPSLayout();
        }
        if (this.iPSModelObject instanceof IPSControl) {
            this.iPSControl = (IPSControl)this.iPSModelObject;
        } else if (this.iPSModelObject instanceof IPSControlObject) {
            this.iPSControl = ((IPSControlObject)((Object)this.iPSModelObject)).getOwnedPSControl();
        }
        this.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5bb9\u5668\u5bf9\u8c61", hideempty2=true, dump=false)
    public String getName() {
        if (this.getOwner() != null) {
            return this.getOwner().getModelName();
        }
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected IPSModelObject getOwner() {
        return this.iPSModelObject;
    }

    protected PSLayout getPSLayoutData() {
        return this.layoutData;
    }

    @Override
    public IPSLayoutPos createPSLayoutPos(IPSModelObject iPSModelObject, PSLayout layoutData) throws Exception {
        IPSLayoutPos iPSLayoutPos = this.createPSLayoutPos();
        iPSLayoutPos.init(iPSModelObject, this, layoutData);
        return iPSLayoutPos;
    }

    protected abstract IPSLayoutPos createPSLayoutPos() throws Exception;

    public IPSLayout getParentPSLayout() {
        return this.parentPSLayout;
    }

    @Override
    public IPSControl getPSControl() {
        if (this.iPSControl != null) {
            return this.iPSControl;
        }
        if (this.getParentPSLayout() != null) {
            return this.getParentPSLayout().getPSControl();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSLAYOUT$" + this.iPSModelObject.getModelType();
    }

    @Override
    public String getModelId() {
        return this.iPSModelObject.getModelId();
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

