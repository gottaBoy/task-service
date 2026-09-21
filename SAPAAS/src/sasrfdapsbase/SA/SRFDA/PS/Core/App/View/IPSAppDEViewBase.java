/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true, model="PSDEViewBase")
@PSModelRTIgnoreMeta
public interface IPSAppDEViewBase {
    public String getPSDEViewId();

    public String getPSDEViewName();

    public IPSDataEntity getPSDataEntity();

    public int getTempMode();

    public boolean isEnableWF();

    public IPSDEActionWizardGroup getPSDEActionWizardGroup();

    public String getPSDEViewCodeName();

    public IPSDER1N getPSDER1N();

    public String getFuncViewMode();

    public String getFuncViewParam();

    public IPSSysCounter getPSSysCounter();

    public IPSSysCounterRef getPSSysCounterRef();

    public IPSAppCounterRef getPSAppCounterRef();

    public IPSAppDataEntity getParentPSAppDataEntity() throws Exception;
}

