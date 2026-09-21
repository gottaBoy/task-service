/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSSubAppRef;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.Res.IPSAppPFPluginRef;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysSF;
import SA.SRFDA.PS.Core.System.IPSSubSysRef;
import SA.SRFDA.PS.Data.PSAppSubApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubAppRefImpl
extends PSApplicationObjectImpl
implements IPSSubAppRef {
    private static final Log log = LogFactory.getLog(PSSubAppRefImpl.class);
    protected PSAppSubApp psAppSubApp = null;
    protected IPSSubApp iPSSubApp = null;
    protected IPSSubSysRef iPSSubSysRef = null;
    protected IPSSubSys iPSSubSys = null;
    protected String strFolderName = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppSubApp psAppSubApp) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSApplication(iPSApplication);
        this.psAppSubApp = psAppSubApp;
        this.setId(this.psAppSubApp.getPSAPPSUBAPPID());
        this.setName(this.psAppSubApp.getPSAPPSUBAPPNAME());
        this.setPSObjectData(this.psAppSubApp);
        String strPSSubSysRefId = Helper.GenUniqueId((String)iPSApplication.getPSSystem().getId(), (String)psAppSubApp.getPSSUBSYSID());
        this.iPSSubSysRef = this.iPSApplication.getPSSystem().getPSSubSysRef(strPSSubSysRefId);
        this.iPSSubSys = this.iPSSubSysRef.getPSSubSys();
        this.iPSSubApp = this.iPSSubSys.getPSSubApp(psAppSubApp.getPSSUBAPPID());
        this.strFolderName = psAppSubApp.getFOLDERNAME();
        if (StringHelper.IsNullOrEmpty((String)this.strFolderName)) {
            this.strFolderName = this.getName();
        }
        this.onInit();
    }

    @Override
    public String getPKGCodeName(String strPSSFStyleId) throws Exception {
        IPSSubSysSF iPSSubSysSF = this.getPSSubSys().getPSSubSysSFBySFStyle(strPSSFStyleId, false);
        return StringHelper.Format((String)"%1$s.%2$s", (Object)iPSSubSysSF.getPKGCodeName(), (Object)this.iPSSubApp.getAppPKGName()).toLowerCase();
    }

    public IPSSubSys getPSSubSys() {
        return this.iPSSubSys;
    }

    @Override
    public IPSSubApp getPSSubApp() {
        return this.iPSSubApp;
    }

    @Override
    public String getFolderName() {
        return this.strFolderName;
    }

    @Override
    public String getModelType() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u6a21\u578b", child=true)
    public IPSAppMenuModel getPSAppMenuModel() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u96c6\u5408", child=true, dumpref=true, ignorert=1, modelreftype="APPLICATION")
    public Iterator<IPSAppView> getAllPSAppViews() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description=" \u5e94\u7528\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u96c6\u5408", child=true, dumpref=true, ignorert=1, modelreftype="APPLICATION")
    public Iterator<IPSAppDEUIActionGroup> getAllPSAppDEUIActionGroups() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description=" \u5e94\u7528\u5b9e\u4f53\u5173\u7cfb\u90e8\u4ef6\u96c6\u5408", child=true, dumpref=true, ignorert=1, modelreftype="APPLICATION")
    public Iterator<IPSControl> getAllPSDEDRControls() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description=" \u5408\u5e76\u90e8\u4ef6\u96c6\u5408\uff08\u9664\u5173\u7cfb\u90e8\u4ef6\uff09", child=true, dumpref=true, ignorert=1, modelreftype="APPLICATION")
    public Iterator<IPSControl> getAllPSControls() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description=" \u5408\u5e76\u83dc\u5355\u96c6\u5408\uff08\u9664\u9ed8\u8ba4\u83dc\u5355\uff09", child=true, dumpref=true, ignorert=1, modelreftype="APPLICATION")
    public Iterator<IPSAppMenuModel> getAllPSAppMenuModels() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description=" \u5408\u5e76\u89c6\u56fe\u5f15\u7528\u96c6\u5408", child=true, dumpref=true, ignorert=1, modelreftype="APPLICATION")
    public Iterator<IPSAppViewRef> getAllPSAppViewRefs() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description=" \u5e94\u7528\u63d2\u4ef6\u96c6\u5408", child=true, dumpref=true, ignorert=1, modelreftype="APPLICATION")
    public Iterator<IPSAppPFPluginRef> getAllPSAppPFPluginRefs() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description=" \u5e94\u7528\u95e8\u6237\u90e8\u4ef6\u96c6\u5408", child=true, dumpref=true, ignorert=1, modelreftype="APPLICATION")
    public Iterator<IPSAppPortlet> getAllPSAppPortlets() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u6233")
    public String getModelStamp() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u53c2\u6570")
    public String getRefParam() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u53c2\u65702")
    public String getRefParam2() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u670d\u52a1\u6807\u8bc6")
    public String getServiceId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u6807\u8bc6")
    public String getAccessKey() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5f15\u7528\u7c7b\u578b", codelist="SysRefType")
    public String getSysRefType() {
        return null;
    }
}

