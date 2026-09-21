/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEXDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEXDataViewImpl
extends PSAppDEViewImpl
implements IPSAppDEXDataView {
    private static final Log log = LogFactory.getLog(PSAppDEXDataViewImpl.class);
    private Boolean bEnableNewDataDefault = null;
    private Boolean bEnableEditDataDefault = null;
    private Boolean bEnableRemoveDataDefault = null;
    private boolean bEnablePrintDefault = false;
    private IPSDEPrint iPSDEPrint = null;
    private boolean bReadOnly = false;
    private IPSWFInteractiveProcess iPSWFInteractiveProcess = null;
    private boolean bLoadDefault = true;

    @Override
    protected void onInit() throws Exception {
        this.bLoadDefault = !this.psViewBase.isLOADDEFAULTNull() ? this.psViewBase.getLOADDEFAULT() : this.isLoadDefaultDefault();
        this.setEnableViewModelDefault(true);
        this.setEnablePrintDefault(this.getPSDataEntity().hasPSDEPrint());
        if (this.isEnablePrint() && this.getPSDataEntity().hasPSDEPrint()) {
            this.iPSDEPrint = this.getPSDataEntity().getDefaultPSDEPrint();
        }
        if (this.isWFIAMode() && !StringHelper.IsNullOrEmpty((String)this.getWFStepValue())) {
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
                log.warn((Object)StringHelper.Format((String)"\u6d41\u7a0b[%1$s]\u7248\u672c[%2$s]\u4e2d\u6ca1\u6709\u5bf9\u5e94\u6b65\u9aa4\u503c[%3$s]\u7684\u5904\u7406", (Object)this.getPSWFVersion().getPSWorkflow().getName(), (Object)this.getPSWFVersion().getWFVersion(), (Object)this.getWFStepValue()));
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

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d\u6570\u636e", ignoredumpvalues="true", fields={"LOADDEFAULT"})
    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    protected boolean isLoadDefaultDefault() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u53ea\u8bfb\u6a21\u5f0f", ignoredumpvalues="false", ignorert=3, fields={"READONLYMODE"})
    public boolean isReadOnly() {
        return this.bReadOnly;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u65b0\u5efa\u64cd\u4f5c", dump=false)
    public boolean isEnableNewData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 1L) > 0L;
        }
        if (this.isWFIAMode()) {
            return false;
        }
        return this.isEnableNewDataDefault() && !this.isReadOnly();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91\u64cd\u4f5c", dump=false)
    public boolean isEnableEditData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 2L) > 0L;
        }
        return this.isEnableEditDataDefault() && !this.isReadOnly();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5220\u9664\u64cd\u4f5c", dump=false)
    public boolean isEnableRemoveData() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 8L) > 0L;
        }
        if (this.isWFIAMode()) {
            return false;
        }
        return this.isEnableRemoveDataDefault() && !this.isReadOnly();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6253\u5370\u64cd\u4f5c", dump=false)
    public boolean isEnablePrint() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x80L) > 0L;
        }
        return this.isEnablePrintDefault();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u62f7\u8d1d\u64cd\u4f5c", dump=false)
    public boolean isEnableCopy() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x10L) > 0L;
        }
        return this.isEnableNewData() && !this.isReadOnly();
    }

    protected boolean isEnableEditDataDefault() {
        if (this.bEnableEditDataDefault != null) {
            return this.bEnableEditDataDefault;
        }
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().isEnableUIModify();
        }
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().isEnableUIModify();
        }
        return true;
    }

    protected void setEnableEditDataDefault(boolean bEnableEditDataDefault) {
        this.bEnableEditDataDefault = bEnableEditDataDefault;
    }

    protected boolean isEnableNewDataDefault() {
        if (this.bEnableNewDataDefault != null) {
            return this.bEnableNewDataDefault;
        }
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().isEnableUICreate();
        }
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().isEnableUICreate();
        }
        return true;
    }

    protected void setEnableNewDataDefault(boolean bEnableNewDataDefault) {
        this.bEnableNewDataDefault = bEnableNewDataDefault;
    }

    protected boolean isEnableRemoveDataDefault() {
        if (this.bEnableRemoveDataDefault != null) {
            return this.bEnableRemoveDataDefault;
        }
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity().isEnableUIRemove();
        }
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().isEnableUIRemove();
        }
        return true;
    }

    protected void setEnableRemoveDataDefault(boolean bEnableRemoveDataDefault) {
        this.bEnableRemoveDataDefault = bEnableRemoveDataDefault;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u542f\u52a8\u6d41\u7a0b", dump=false)
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
    @PSModelRTMeta(description="\u6253\u5370\u5bf9\u8c61", dump=false)
    public IPSDEPrint getPSDEPrint() {
        return this.iPSDEPrint;
    }

    @Override
    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) throws Exception {
        super.setPSDataEntity(iPSDataEntity);
    }

    @Override
    @PSModelRTMeta(description="\u4ea4\u4e92\u6d41\u7a0b\u5904\u7406\u5bf9\u8c61", hideempty=true)
    public IPSWFInteractiveProcess getPSWFInteractiveProcess() {
        return this.iPSWFInteractiveProcess;
    }

    @Override
    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        Iterator<PSDEViewBase> psDEViewBases;
        if (this.isDynamicView() && this.isEnableWF() && this.getPSDEWF() != null && (psDEViewBases = this.getPSDataEntity().getAllPSDEViewDatas()) != null) {
            while (psDEViewBases.hasNext()) {
                IPSAppView iPSAppView;
                PSDEViewBase psDEViewBase = psDEViewBases.next();
                if (StringHelper.Compare((String)psDEViewBase.getPSWFDEID(), (String)this.getPSDEWF().getId(), (boolean)true) != 0) continue;
                if (this.isMobileView()) {
                    if (StringHelper.Compare((String)psDEViewBase.getPSDEVIEWBASETYPE(), (String)"DEMOBWFSTARTVIEW", (boolean)true) != 0 && StringHelper.Compare((String)psDEViewBase.getPSDEVIEWBASETYPE(), (String)"DEMOBWFACTIONVIEW", (boolean)true) != 0 || (iPSAppView = this.getPSApplication().getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), true)) == null) continue;
                    relatedAppViewList.add(iPSAppView);
                    continue;
                }
                if (StringHelper.Compare((String)psDEViewBase.getPSDEVIEWBASETYPE(), (String)"DEWFSTARTVIEW", (boolean)true) != 0 && StringHelper.Compare((String)psDEViewBase.getPSDEVIEWBASETYPE(), (String)"DEWFACTIONVIEW", (boolean)true) != 0 || (iPSAppView = this.getPSApplication().getPSAppViewByDEViewId(psDEViewBase.getPSDEVIEWBASEID(), true)) == null) continue;
                relatedAppViewList.add(iPSAppView);
            }
        }
        super.onFillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u80fd\u529b\u90e8\u4ef6")
    public IPSControl getXDataPSControl() throws Exception {
        String strXDataCtrlName = this.getXDataControlName();
        if (StringHelper.IsNullOrEmpty((String)strXDataCtrlName)) {
            return null;
        }
        return this.getPSControl(strXDataCtrlName);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u80fd\u529b\u90e8\u4ef6\u540d\u79f0", doc="\u83b7\u53d6\u5b9e\u4f53\u6570\u636e\u89c6\u56fe\u9ed8\u8ba4\u7684\u6570\u636e\u90e8\u4ef6\u540d\u79f0")
    public String getXDataControlName() {
        return this.onGetXDataControlName();
    }

    protected String onGetXDataControlName() {
        return null;
    }
}

