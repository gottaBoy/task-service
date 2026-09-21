/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFActionView
 *  net.ibizsys.model.app.view.IPSAppDEXDataView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.wf.IPSWFInteractiveProcess
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.view;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.IPSAppDEXDataView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.PSAppDEViewImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.entity.PSDEViewBase;
import net.ibizsys.model.wf.IPSWFInteractiveProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppDEXDataViewImpl
extends PSAppDEViewImpl
implements IPSAppDEXDataView {
    private static final Log log = LogFactory.getLog(PSAppDEXDataViewImpl.class);
    private boolean bEnableEditDataDefault = true;
    private boolean bEnableNewDataDefault = true;
    private boolean bEnableRemoveDataDefault = true;
    private boolean bEnablePrintDefault = false;
    private boolean bReadOnly = false;
    private IPSWFInteractiveProcess iPSWFInteractiveProcess = null;
    private boolean bLoadDefault = true;

    @Override
    protected void onInit() throws Exception {
        this.bLoadDefault = !this.psViewBase.isLOADDEFAULTNull() ? this.psViewBase.getLOADDEFAULT() : this.isLoadDefaultDefault();
        this.setEnableViewModelDefault(true);
        if (this.isWFIAMode() && !StringHelper.isNullOrEmpty((String)this.getWFStepValue())) {
            IPSWFProcess iWFProcessModel = this.getPSWFVersion().getPSWFProcessByWFStepValue(this.getWFStepValue(), true);
            if (iWFProcessModel != null) {
                if (iWFProcessModel instanceof IPSWFInteractiveProcess) {
                    IPSWFInteractiveProcess iWFInteractiveProcessModel = (IPSWFInteractiveProcess)iWFProcessModel;
                    this.setEnableEditDataDefault(iWFInteractiveProcessModel.isEditable());
                    this.bReadOnly = !iWFInteractiveProcessModel.isEditable();
                    this.iPSWFInteractiveProcess = iWFInteractiveProcessModel;
                } else {
                    this.setEnableEditDataDefault(false);
                }
            } else {
                log.warn((Object)StringHelper.format((String)"\u6d41\u7a0b[%1$s]\u7248\u672c[%2$s]\u4e2d\u6ca1\u6709\u5bf9\u5e94\u6b65\u9aa4\u503c[%3$s]\u7684\u5904\u7406", (Object)this.getPSWFVersion().getPSWorkflow().getName(), (Object)this.getPSWFVersion().getWFVersion(), (Object)this.getWFStepValue()));
            }
        }
        if (!this.psViewBase.isREADONLYMODENull()) {
            this.bReadOnly = this.psViewBase.getREADONLYMODE();
        }
        if (this.isWFIAMode()) {
            this.setEnableNewDataDefault(false);
            this.setEnableRemoveDataDefault(false);
        }
        super.onInit();
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d\u6570\u636e")
    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    protected boolean isLoadDefaultDefault() {
        return true;
    }

    @PSModelRTMeta(description="\u53ea\u8bfb\u6a21\u5f0f")
    public boolean isReadOnly() {
        return this.bReadOnly;
    }

    @PSModelRTMeta(description="\u652f\u6301\u65b0\u5efa\u64cd\u4f5c")
    public boolean isEnableNewData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 1L) > 0L;
        }
        if (this.isWFIAMode()) {
            return false;
        }
        return this.isEnableNewDataDefault() && !this.isReadOnly();
    }

    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91\u64cd\u4f5c")
    public boolean isEnableEditData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 2L) > 0L;
        }
        return this.isEnableEditDataDefault() && !this.isReadOnly();
    }

    @PSModelRTMeta(description="\u652f\u6301\u5220\u9664\u64cd\u4f5c")
    public boolean isEnableRemoveData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 8L) > 0L;
        }
        if (this.isWFIAMode()) {
            return false;
        }
        return this.isEnableRemoveDataDefault() && !this.isReadOnly();
    }

    @PSModelRTMeta(description="\u652f\u6301\u6253\u5370\u64cd\u4f5c")
    public boolean isEnablePrint() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x80L) > 0L;
        }
        return this.isEnablePrintDefault();
    }

    @PSModelRTMeta(description="\u652f\u6301\u62f7\u8d1d\u64cd\u4f5c")
    public boolean isEnableCopy() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x10L) > 0L;
        }
        return this.isEnableNewData() && !this.isReadOnly();
    }

    protected boolean isEnableEditDataDefault() {
        return this.bEnableEditDataDefault;
    }

    protected void setEnableEditDataDefault(boolean bEnableEditDataDefault) {
        this.bEnableEditDataDefault = bEnableEditDataDefault;
    }

    protected boolean isEnableNewDataDefault() {
        return this.bEnableNewDataDefault;
    }

    protected void setEnableNewDataDefault(boolean bEnableNewDataDefault) {
        this.bEnableNewDataDefault = bEnableNewDataDefault;
    }

    protected boolean isEnableRemoveDataDefault() {
        return this.bEnableRemoveDataDefault;
    }

    protected void setEnableRemoveDataDefault(boolean bEnableRemoveDataDefault) {
        this.bEnableRemoveDataDefault = bEnableRemoveDataDefault;
    }

    @PSModelRTMeta(description="\u652f\u6301\u542f\u52a8\u6d41\u7a0b")
    public boolean isEnableStartWF() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x800L) > 0L;
        }
        return this.isEnableStartWFDefault();
    }

    protected boolean isEnableStartWFDefault() {
        if (this.isEnableWF()) {
            if (this instanceof IPSAppDEWFActionView) {
                return !this.isWFIAMode();
            }
            return this.getPSDEWF().isEnableUserStart();
        }
        return false;
    }

    protected boolean isEnablePrintDefault() {
        return this.bEnablePrintDefault;
    }

    protected void setEnablePrintDefault(boolean bEnablePrintDefault) {
        this.bEnablePrintDefault = bEnablePrintDefault;
    }

    @Override
    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) throws Exception {
        super.setPSDataEntity(iPSDataEntity);
        if (this.getPSDataEntity() != null) {
            this.bEnableNewDataDefault = (this.getPSDataEntity().getEnableUIActions() & 1) > 0;
            this.bEnableEditDataDefault = (this.getPSDataEntity().getEnableUIActions() & 2) > 0;
            this.bEnableRemoveDataDefault = (this.getPSDataEntity().getEnableUIActions() & 4) > 0;
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ea4\u4e92\u6d41\u7a0b\u5904\u7406\u5bf9\u8c61", hideempty=true)
    public IPSWFInteractiveProcess getPSWFInteractiveProcess() {
        return this.iPSWFInteractiveProcess;
    }

    @Override
    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        Iterator<PSDEViewBase> psDEViewBases;
        if (this.isDynamicView() && this.isEnableWF() && this.getPSDEWF() != null && (psDEViewBases = this.getPSDataEntityRuntime().getAllPSDEViewDatas()) != null) {
            while (psDEViewBases.hasNext()) {
                IPSAppView iPSAppView;
                PSDEViewBase psDEViewBase = psDEViewBases.next();
                if (StringHelper.compare((String)psDEViewBase.getPSWFDEID(), (String)this.getPSDEWF().getId(), (boolean)true) != 0) continue;
                if (this.isMobileView()) {
                    if (StringHelper.compare((String)psDEViewBase.getPSDEVIEWBASETYPE(), (String)"DEMOBWFSTARTVIEW", (boolean)true) != 0 && StringHelper.compare((String)psDEViewBase.getPSDEVIEWBASETYPE(), (String)"DEMOBWFACTIONVIEW", (boolean)true) != 0 || (iPSAppView = this.getPSApplicationRuntime().getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), true)) == null) continue;
                    relatedAppViewList.add(iPSAppView);
                    continue;
                }
                if (StringHelper.compare((String)psDEViewBase.getPSDEVIEWBASETYPE(), (String)"DEWFSTARTVIEW", (boolean)true) != 0 && StringHelper.compare((String)psDEViewBase.getPSDEVIEWBASETYPE(), (String)"DEWFACTIONVIEW", (boolean)true) != 0 || (iPSAppView = this.getPSApplicationRuntime().getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), true)) == null) continue;
                relatedAppViewList.add(iPSAppView);
            }
        }
        super.onFillRelatedPSAppViews(relatedAppViewList);
    }
}

