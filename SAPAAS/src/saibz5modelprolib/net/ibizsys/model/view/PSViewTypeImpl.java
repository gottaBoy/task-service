/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.view;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.entity.PSViewType;
import net.ibizsys.model.view.IPSViewTypeRuntime;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewTypeImpl
extends PSObjectImpl
implements IPSViewTypeRuntime {
    protected PSViewType psViewType = null;
    private static final Log log = LogFactory.getLog(PSViewTypeImpl.class);
    private boolean bDEViewType = false;
    private String strCodeName = "";
    private boolean bEmbeddedView = false;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSViewType psViewType) throws Exception {
        this.psViewType = psViewType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psViewType.getPSVIEWTYPEID());
        this.setName(psViewType.getPSVIEWTYPENAME());
        this.setPSObjectData(this.psViewType);
        if (!this.psViewType.isDEVIEWMODENull()) {
            this.bDEViewType = this.psViewType.getDEVIEWMODE();
        }
        this.strCodeName = this.psViewType.getCODENAME();
        if (!this.psViewType.isEMBEDVIEWFLAGNull()) {
            this.bEmbeddedView = this.psViewType.getEMBEDVIEWFLAG();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IPSAppView createPSAppView(PSAppView psApplicationView) throws Exception {
        IPSAppView iPSAppDEView = (IPSAppView)this.getPSModelStorageContext().createObject(this.psViewType.getAPPVIEWOBJ());
        ((IPSAppViewRuntime)iPSAppDEView).setPSViewType(this);
        return iPSAppDEView;
    }

    public boolean isDEViewType() {
        return this.bDEViewType;
    }

    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    public boolean isEmbeddedView() {
        return this.bEmbeddedView;
    }
}

