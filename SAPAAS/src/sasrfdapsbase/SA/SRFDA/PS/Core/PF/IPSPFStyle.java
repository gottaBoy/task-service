/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFAppTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.IPSPFEditorTempl;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyleCode;
import SA.SRFDA.PS.Core.PF.IPSPFStylePkg;
import SA.SRFDA.PS.Core.PF.IPSPFStylePrj;
import SA.SRFDA.PS.Core.PF.IPSPFUIActionTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Data.PSPFStyle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSPFStyle
extends IPSPFObject {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, PSPFStyle var3) throws Exception;

    public String getStyleCode();

    public Iterator<IPSPFViewTempl> getPSPFViewTempls(IPSAppView var1) throws Exception;

    public Iterator<IPSPFCtrlTempl> getPSPFCtrlTempls(IPSControl var1) throws Exception;

    public boolean hasPSPFCtrlTempls(IPSControl var1) throws Exception;

    public boolean hasPSPFCtrlTempls(IPSControl var1, String var2) throws Exception;

    public IPSPFCtrlTempl getPSPFCtrlTempl(IPSControlType var1, IPSPFPubCode var2) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(IPSControlType var1, IPSPFPubCode var2, String var3) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(IPSControlType var1, IPSPFPubCode var2, String var3, boolean var4) throws Exception;

    public IPSPFUIActionTempl getPSPFUIActionTempl(IPSUIAction var1, IPSPFPubCode var2) throws Exception;

    public IPSPFViewLogicTempl getPSPFViewLogicTempl(IPSViewLogicType var1, IPSPFPubCode var2) throws Exception;

    public Iterator<IPSPFAppTempl> getPSPFAppTempls(IPSApplication var1) throws Exception;

    public IPSPFStyleCode getPSPFStyleCode(String var1, boolean var2) throws Exception;

    public Iterator<IPSPFStyleCode> getPSPFStyleCodes() throws Exception;

    public String replacePFStyleCode(String var1) throws Exception;

    public String getPFStyleParams();

    public IPSPFViewTempl getPSPFViewTempl(String var1) throws Exception;

    public IPSPFViewTempl getPSPFViewTempl(String var1, boolean var2) throws Exception;

    public void resetPSPFViewTempl(String var1) throws Exception;

    public IPSPFCtrlTempl getPSPFCtrlTempl(String var1) throws Exception;

    public IPSPFCtrlTempl getPSPFCtrlTempl(String var1, boolean var2) throws Exception;

    public void resetPSPFCtrlTempl(String var1) throws Exception;

    public IPSPFUIActionTempl getPSPFUIActionTempl(String var1) throws Exception;

    public IPSPFUIActionTempl getPSPFUIActionTempl(String var1, boolean var2) throws Exception;

    public void resetPSPFUIActionTempl(String var1) throws Exception;

    public IPSPFViewLogicTempl getPSPFViewLogicTempl(String var1, boolean var2) throws Exception;

    public void resetPSPFViewLogicTempl(String var1) throws Exception;

    public IPSPFAppTempl getPSPFAppTempl(String var1) throws Exception;

    public IPSPFAppTempl getPSPFAppTempl(String var1, boolean var2) throws Exception;

    public void resetPSPFAppTempl(String var1) throws Exception;

    public IPSPFViewTempl getPSPFViewTempl(IPSViewType var1, IPSPFPubCode var2) throws Exception;

    public IPSPFAppTempl getPSPFAppTempl(IPSPFPubCode var1) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(String var1) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(String var1, boolean var2) throws Exception;

    public void resetPSPFEditorTempl(String var1) throws Exception;

    public IPSPFEditorTempl getPSPFEditorTempl(IPSEditorType var1, String var2, IPSPFPubCode var3) throws Exception;

    public IPSPFStyle getTemplPSPFStyle() throws Exception;

    public IPSPFStylePrj getPSPFStylePrj(String var1, boolean var2) throws Exception;

    public Iterator<IPSPFStylePrj> getPSPFStylePrjs() throws Exception;

    public String getPSDevCenterName();

    public String getPSDevCenterId();

    public Iterator<IPSPFStylePkg> getPSPFStylePkgs() throws Exception;

    public Iterator<IPSPFPkgVer> getPSPFPkgVers() throws Exception;

    public String getTemplDocRootUrl();

    public String getResourceUrl();

    public String getVersionString();

    public String getStyleParam(String var1, String var2);

    public int getStyleParam(String var1, int var2);

    public IPSPFCodeFolder getPSPFCodeFolder(String var1) throws Exception;

    public void resetPSPFCodeFolder(String var1) throws Exception;

    public IPSPFPubCode getPSPFPubCode(String var1) throws Exception;

    public IPSPFPubCode getPSPFPubCode(String var1, boolean var2) throws Exception;

    public Iterator<IPSPFPubCode> getPSPFPubCodes(String var1, boolean var2) throws Exception;

    public Iterator<IPSPFPubCode> getPSPFPubCodes(String var1) throws Exception;

    public boolean isAutoNameOrCode();

    public boolean isSystemFieldReadonlyDefault();

    public boolean isEnableEditorStyleCode();

    public boolean isRegisterToContainer();

    public String getTemplInfo();

    public int getPFEngineVer();

    public String getResLocalPath();
}

