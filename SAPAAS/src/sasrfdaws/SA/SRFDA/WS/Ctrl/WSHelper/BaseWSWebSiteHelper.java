/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WS.Ctrl.WSHelper;

import SA.SRFDA.WS.Ctrl.BaseWSObject;
import SA.SRFDA.WS.Ctrl.Data.WSChannel;
import SA.SRFDA.WS.Ctrl.Data.WSPage;
import SA.SRFDA.WS.Ctrl.Data.WSRuntime;
import SA.SRFDA.WS.Ctrl.Data.WSWebPart;
import SA.SRFDA.WS.Ctrl.Data.WSWebSite;
import SA.SRFDA.WS.Ctrl.DefaultWSPagePublishContext;
import SA.SRFDA.WS.Ctrl.IWSPageHelper;
import SA.SRFDA.WS.Ctrl.IWSPageTemplHelper;
import SA.SRFDA.WS.Ctrl.IWSPageTypeHelper;
import SA.SRFDA.WS.Ctrl.IWSWebSiteHelper;
import SA.SRFDA.WS.Ctrl.WSHelper.BaseWSPageHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseWSWebSiteHelper
extends BaseWSObject
implements IWSWebSiteHelper {
    WSWebSite wsWebSite = null;
    ISRFDAGlobalHelper iDAGlobalHelper = null;
    Vector<WSChannel> channels = new Vector();
    Vector<WSPage> pages = new Vector();
    Vector<WSRuntime> wsRuntimes = new Vector();
    Vector<WSWebPart> webparts = new Vector();
    Hashtable<String, IWSPageHelper> wsPageHelpers = new Hashtable();
    Log log = LogFactory.getLog(BaseWSWebSiteHelper.class);

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, WSWebSite wsWebSite) throws Exception {
        this.wsWebSite = wsWebSite;
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.OnPrepareChannels();
        this.OnPrepareRuntimeEnvs();
        this.OnPreparePages();
        this.OnPrepareWebparts();
        this.OnInit();
    }

    protected void OnPrepareRuntimeEnvs() throws Exception {
        CallResult callResult = this.getWSModelHelper().GetWSWebSiteRuntimes(this.getId(), this.wsRuntimes);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u7ad9\u9875\u9762\u5185\u5bb9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void OnPrepareChannels() throws Exception {
        CallResult callResult = this.getWSModelHelper().GetWSChannel(this.getId(), this.channels);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u7ad9\u9891\u9053\u5185\u5bb9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void OnPreparePages() throws Exception {
        CallResult callResult = this.getWSModelHelper().GetWSPages(this.getId(), this.pages);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u7ad9\u9875\u9762\u5185\u5bb9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (WSPage wsPage : this.pages) {
            IWSPageHelper wsPageHelper = this.OnCreateWSPageHelper(wsPage);
            this.wsPageHelpers.put(wsPage.getWSPAGEID(), wsPageHelper);
            this.wsPageHelpers.put(wsPageHelper.getClass().getName(), wsPageHelper);
        }
    }

    protected void OnPrepareWebparts() throws Exception {
        CallResult callResult = this.getWSModelHelper().GetWSWebParts(this.getId(), this.webparts);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u7ad9\u90e8\u4ef6\u5185\u5bb9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void OnInit() {
    }

    @Override
    public IWSPageHelper FindWSPageHelper(String strWSPageId) throws Exception {
        IWSPageHelper wsPageHelper;
        WSPage wsPage2;
        WSPage wsPage = new WSPage();
        wsPage.setWSPAGEID(strWSPageId);
        CallResult callResult = this.getWSModelHelper().GetWSPage(strWSPageId, wsPage);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u7ad9\u9875\u9762\u5185\u5bb9\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (this.wsPageHelpers.containsKey(strWSPageId) && (wsPage2 = (wsPageHelper = this.wsPageHelpers.get(strWSPageId)).getWSPage()).getVERSION() == wsPage.getVERSION()) {
            return wsPageHelper;
        }
        wsPageHelper = this.OnCreateWSPageHelper(wsPage);
        this.wsPageHelpers.put(wsPage.getWSPAGEID(), wsPageHelper);
        this.wsPageHelpers.put(wsPageHelper.getClass().getName(), wsPageHelper);
        return wsPageHelper;
    }

    public String getId() {
        return this.getWSWebSite().getWSWEBSITEID();
    }

    @Override
    public String getName() {
        return this.getWSWebSite().getWSWEBSITENAME();
    }

    @Override
    public String getRootPath() {
        String strWSPath = this.getWSWebSite().getWSPath();
        if (StringHelper.IsNullOrEmpty((String)strWSPath)) {
            return "Web";
        }
        return this.OnGetRootPath("");
    }

    @Override
    public WSWebSite getWSWebSite() {
        return this.wsWebSite;
    }

    @Override
    public void Publish() throws Exception {
        this.wsWebSite = this.getWSWebSite();
        for (WSPage wsPage : this.pages) {
            IWSPageHelper iWSPageHelper = this.OnCreateWSPageHelper(wsPage);
            DefaultWSPagePublishContext publishContext = new DefaultWSPagePublishContext(this.getRootPath());
            try {
                iWSPageHelper.Publish(publishContext);
                this.log.debug((Object)StringHelper.Format((String)"\u9875\u9762[%1$s]\u53d1\u5e03\u6210\u529f", (Object)iWSPageHelper.getName()));
            }
            catch (Exception e) {
                this.log.debug((Object)StringHelper.Format((String)"\u9875\u9762[%1$s]\u53d1\u5e03\u5931\u8d25\uff1a%2$s", (Object)iWSPageHelper.getName(), (Object)e.getMessage()));
                e.printStackTrace();
            }
        }
    }

    protected String OnGetRootPath(String strWSRuntimeId) {
        if (StringHelper.IsNullOrEmpty((String)strWSRuntimeId)) {
            return this.getWSWebSite().getWSPath();
        }
        String strRootPath = "";
        for (WSRuntime wsRuntime : this.wsRuntimes) {
            if (StringHelper.Compare((String)wsRuntime.getWSRUNTIMEID(), (String)strWSRuntimeId, (boolean)true) != 0) continue;
            strRootPath = wsRuntime.getRTPATH();
            break;
        }
        if (StringHelper.IsNullOrEmpty((String)strRootPath)) {
            return this.wsRuntimes.get(0).getRTPATH();
        }
        return strRootPath;
    }

    protected IWSPageHelper OnCreateWSPageHelper(WSPage wsPage) throws Exception {
        try {
            IWSPageTemplHelper wsPageTemplHeper = this.getWSModelStorage().FindWSPageTemplHelper(wsPage.getWSPAGETEMPLID());
            IWSPageTypeHelper wsPageTypeHelper = this.getWSModelStorage().FindWSPageTypeHelper(wsPageTemplHeper.getWsPageTempl().getWSPAGETYPEID());
            String strHelperObject = wsPageTypeHelper.getHelperObject();
            if (StringHelper.IsNullOrEmpty((String)strHelperObject)) {
                strHelperObject = BaseWSPageHelper.class.getName();
            }
            IWSPageHelper wsPageHelper = (IWSPageHelper)ObjectHelper.Create((String)strHelperObject);
            wsPageHelper.Init(this.iDAGlobalHelper, this, wsPageTemplHeper, wsPage);
            return wsPageHelper;
        }
        catch (Exception e) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u7ad9\u9875\u9762[%1$s]\u53d1\u5e03\u8f85\u52a9\u5bf9\u8c61\u53d1\u751f\u9519\u8bef", (Object)wsPage.getWSPAGEID()));
        }
    }
}

