/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.App.View.PSAppUtilViewImpl;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;

@PSModelIgnoreMeta
public class PSAppUtilWFViewImpl
extends PSAppUtilViewImpl
implements IPSAppDEWFView {
    @Override
    public String getFuncViewMode() {
        return null;
    }

    @Override
    public String getFuncViewParam() {
        return null;
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntity() {
        return null;
    }

    @Override
    public String getPSDEViewId() {
        return null;
    }

    @Override
    public String getPSDEViewName() {
        return null;
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return null;
    }

    @Override
    public IPSDER1N getPSDER1N() {
        return null;
    }

    @Override
    public int getTempMode() {
        return 0;
    }

    @Override
    public IPSDEActionWizardGroup getPSDEActionWizardGroup() {
        return null;
    }

    @Override
    public int getExtendMode() {
        return 0;
    }

    @Override
    public IPSDEWF getPSDEWF() {
        return null;
    }

    @Override
    public IPSWFVersion getPSWFVersion() {
        return null;
    }

    @Override
    public IPSWorkflow getPSWorkflow() {
        return null;
    }

    @Override
    public boolean isWFIAMode() {
        return false;
    }

    @Override
    public boolean isEnableWF() {
        return true;
    }

    @Override
    public String getPSDEViewCodeName() {
        return null;
    }

    @Override
    public IPSAppWF getPSAppWF() {
        return null;
    }

    @Override
    public IPSAppWFVer getPSAppWFVer() {
        return null;
    }

    @Override
    public IPSSysCounter getPSSysCounter() {
        return null;
    }

    @Override
    public IPSSysCounterRef getPSSysCounterRef() {
        return null;
    }

    @Override
    public IPSAppDataEntity getParentPSAppDataEntity() throws Exception {
        return null;
    }

    @Override
    public IPSAppCounterRef getPSAppCounterRef() {
        return null;
    }
}

