/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.pswf.core.IWFModel
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.WF.IPSWFDE;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Data.PSWorkflow;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.pswf.core.IWFModel;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSWorkflow")
public interface IPSWorkflow
extends IPSSystemObject,
IWFModel,
IPSSysSFPubObject {
    public static final String WFENGINETYPE_EMBEDDED = "EMBEDDED";
    public static final String WFENGINETYPE_ACTIVITI = "ACTIVITI";
    public static final String WFENGINETYPE_ACTIVITI_REMOTE = "ACTIVITI_REMOTE";
    public static final int WFPROXYMODE_NONE = 0;
    public static final int WFPROXYMODE_CLIENT = 1;
    public static final int WFPROXYMODE_SERVER = 2;
    public static final int WFPROXYMODE_SERVERCLIENT = 3;
    public static final String WFTYPE_ORG = "ORG";
    public static final String WFTYPE_ORGSECTOR = "ORGSECTOR";
    public static final String WFTYPE_DEFAULT = "DEFAULT";

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSWorkflow var3) throws Exception;

    @Override
    public String getCodeName();

    public String getLogicName();

    public Iterator<IPSWFVersion> getPSWFVersions() throws Exception;

    public IPSWFVersion getPSWFVersion(String var1) throws Exception;

    public Iterator<IPSWFDE> getPSWFDEs() throws Exception;

    public IPSDEWF getPSDEWF(String var1, boolean var2) throws Exception;

    public IPSDEWF getPSDEWF(String var1) throws Exception;

    public IPSCodeList getWFStepPSCodeList();

    public IPSCodeList getEntityStatePSCodeList();

    public Iterator<String> getEntityWFStates();

    public IPSWFVersion getLastPSWFVersion() throws Exception;

    public boolean isValid();

    public String getWFType();

    public String getWFSN();

    public void loadAll() throws Exception;

    public IPSWXAccount getPSWXAccount();

    public IPSWXEntApp getPSWXEntApp();

    @Deprecated
    public boolean isEnableDynamicView();

    public String getWFEngineCat();

    public String getWFEngineType();

    public boolean isDynamicWorkflow();

    public IPSLanguageRes getNamePSLanguageRes();

    public IPSSystemModule getPSSystemModule();

    public boolean isUseRemoteEngine();

    public boolean isUseWFProxyApp();

    public String getDefaultDEName();

    public Iterator<IPSWFUIAction> getAllPSWFUIActions() throws Exception;

    public IPSWFUIAction getPSWFUIAction(String var1) throws Exception;

    public IPSWFUIAction getPSWFUIAction(String var1, boolean var2) throws Exception;

    public void resetPSWFUIAction(String var1) throws Exception;

    public IPSWFUIActionGroup getPSWFUIActionGroup(String var1) throws Exception;

    public IPSWFUIActionGroup getPSWFUIActionGroup(String var1, boolean var2) throws Exception;

    public void resetPSWFUIActionGroup(String var1) throws Exception;

    public int getWFProxyMode();

    public Iterator<IPSAppWF> getPSAppWFs() throws Exception;

    public String getEntityWFState();

    public String getEntityWFFinishState();

    public String getEntityWFErrorState();

    public String getEntityWFCancelState();

    public String getNameLanResTag();

    public int getDynaSysMode();

    public String getWFCatCode();

    public String getUniqueTag();
}

