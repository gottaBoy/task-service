/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEWF
 */
package SA.SRFDA.PS.Core.DataEntity.WF;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSWFDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEWF;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u914d\u7f6e\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWFDE")
public interface IPSDEWF
extends IPSDataEntityObject,
IDEWF {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSWFDE var3) throws Exception;

    public boolean isValid();

    public IPSWorkflow getPSWorkflow();

    @Override
    public String getCodeName();

    public IPSDEField getWFStepPSDEField();

    public IPSDEField getWFStatePSDEField();

    public IPSDEField getUDStatePSDEField();

    public IPSDEField getWFInstPSDEField();

    public IPSDEField getWFActorsPSDEField();

    public IPSDEField getWFRetPSDEField();

    public IPSCodeList getWFStepPSCodeList() throws Exception;

    public IPSCodeList getEntityStatePSCodeList() throws Exception;

    public boolean isDefaultMode();

    public boolean isEnableUserStart();

    public IPSDEAction getInitPSDEAction();

    public IPSDEAction getFinishPSDEAction();

    public IPSDEField getWFVerPSDEField();

    public IPSDEField getWorkflowPSDEField();

    public String getMyWFWorkCaption();

    public IPSLanguageRes getMyWFWorkCapPSLanguageRes();

    public String getMyWFDataCaption();

    public IPSLanguageRes getMyWFDataCapPSLanguageRes();

    public boolean isUseWFProxyApp();

    public int getWFProxyMode();

    public IPSDEField getProxyModulePSDEField();

    public IPSDEField getProxyDataPSDEField();

    public Iterator<IPSAppView> getDataRedirectPSAppViews() throws Exception;

    public Iterator<IPSAppView> getMobDataRedirectPSAppViews() throws Exception;

    public String getProxyDataPSDEViewId();

    public String getMobProxyDataPSDEViewId();

    public Iterator<IPSAppView> getProxyDataPSAppViews() throws Exception;

    public Iterator<IPSAppView> getMobProxyDataPSAppViews() throws Exception;

    public String getEditProxyDataPSDEViewId();

    public String getMobEditProxyDataPSDEViewId();

    public Iterator<IPSAppView> getEditProxyDataPSAppViews() throws Exception;

    public Iterator<IPSAppView> getMobEditProxyDataPSAppViews() throws Exception;

    public IPSDEField getPWFInstPSDEField();

    public IPSDEMainState getProcessPSDEMainState();

    public IPSDEMainState getFinishPSDEMainState();

    public IPSDEMainState getErrorPSDEMainState();

    public String getStartPSDEViewId();

    public String getMobStartPSDEViewId();

    public String getActionPSDEViewId();

    public String getMobActionPSDEViewId();

    public String getStartViewCodeName();

    public String getMobStartViewCodeName();

    public String getActionViewCodeName();

    public String getMobActionViewCodeName();

    public String getEntityWFFinishState();

    public String getEntityWFErrorState();

    public String getEntityWFCancelState();

    public String getWFStepField();

    public String getWFStateField();

    public String getUDStateField();

    public String getWFInstField();

    public String getEntityWFState();

    public String getWFActorsField();

    public String getWFRetField();

    public String getWFStartName();

    public String getWFVerField();

    public String getWorkflowField();

    public String getWFMode();

    public String getWFCatCode();
}

