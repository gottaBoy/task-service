/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.IPSAppType;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPkg;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVerCDN;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubObj;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFEditorCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFUIActionCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSPF;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFDA.PS.Data.PSSysApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Map;

public interface IPSPF
extends IPSObject {
    public static final int PFENGINEVER_UNKNOWN = 0;
    public static final int PFENGINEVER_10 = 10;
    public static final int PFENGINEVER_20 = 20;

    public void init(ISRFDAGlobalHelper var1, PSPF var2) throws Exception;

    public IPSAppType getPSAppType();

    public IPSPFStyle getPSPFStyle(String var1) throws Exception;

    public void resetPSPFStyle(String var1) throws Exception;

    public IPSPFCodeFolder getPSPFCodeFolder(String var1) throws Exception;

    public void resetPSPFCodeFolder(String var1) throws Exception;

    public Iterator<IPSPFPubCode> getPSPFPubCodes(String var1) throws Exception;

    public Iterator<IPSPFPubCode> getPSPFPubCodes(String var1, boolean var2) throws Exception;

    public IPSPFViewCodePublisher createPSPFViewCodePublisher() throws Exception;

    public IPSPFPubCode getPSPFPubCode(String var1) throws Exception;

    public IPSPFPubCode getPSPFPubCode(String var1, boolean var2) throws Exception;

    public void resetAllPSPFPubCodes() throws Exception;

    public IPSPFCtrlCodePublisher createPSPFCtrlCodePublisher() throws Exception;

    public IPSPFCtrlPartCodePublisher createPSPFCtrlPartCodePublisher() throws Exception;

    public IPSPFEditorCodePublisher createPSPFEditorCodePublisher() throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(String var1) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(String var1, boolean var2) throws Exception;

    public void resetPSPFEditorTempl(String var1) throws Exception;

    public IPSPFUIActionCodePublisher createPSPFUIActionCodePublisher() throws Exception;

    public IPSPFViewLogicCodePublisher createPSPFViewLogicCodePublisher() throws Exception;

    public IPSPFAppCodePublisher createPSPFAppCodePublisher() throws Exception;

    public String getFormLayoutMode();

    public String getPanelLayoutMode();

    public void fillPSSubAppView(PSSubAppView var1, PSSysApp var2, PSAppModule var3, PSAppView var4) throws Exception;

    public String getPSAppViewPageUrl(IPSAppView var1) throws Exception;

    public String getPSAppViewBackendUrl(IPSAppView var1) throws Exception;

    public String getPSAppViewPageUrl(IPSAppView var1, Map<String, String> var2) throws Exception;

    public String getPSAppViewBackendUrl(IPSAppView var1, Map<String, String> var2) throws Exception;

    public IPSPFPkg getPSPFPkg(String var1) throws Exception;

    public void resetPSPFPkg(String var1) throws Exception;

    public IPSPFPkgVer getPSPFPkgVer(String var1) throws Exception;

    public void resetPSPFPkgVer(String var1) throws Exception;

    public IPSPFPkgVerCDN getPSPFPkgVerCDN(String var1) throws Exception;

    public void resetPSPFPkgVerCDN(String var1) throws Exception;

    public IPSPFPkgVerCDN getPSPFPkgVerCDN(String var1, String var2, String var3, boolean var4) throws Exception;

    public IPSPFStyle createPSPFStyle() throws Exception;

    public IPSJITAppModel createPSJITAppModel() throws Exception;

    public boolean isUseJITDesignPreview();

    public boolean isPreviewFramework();

    public IPSPFPubObj getPSPFPubObj(String var1, boolean var2) throws Exception;

    public IPSPFPubObj getPSPFPubObjByTarget(String var1, boolean var2) throws Exception;

    public void resetPSPFPubObj(String var1) throws Exception;

    public int getPFEngineVer();
}

