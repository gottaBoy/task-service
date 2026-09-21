/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswx.core.IWXMenu
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Core.WX.IPSWXLogic;
import SA.SRFDA.PS.Core.WX.IPSWXMenu;
import SA.SRFDA.PS.Core.WX.IPSWXMenuFunc;
import SA.SRFDA.PS.Core.WX.PSWXAccountObjectImpl;
import SA.SRFDA.PS.Core.WX.PSWXLogicImpl;
import SA.SRFDA.PS.Core.WX.PSWXMenuFuncImpl;
import SA.SRFDA.PS.Core.WX.PSWXMenuImpl;
import SA.SRFDA.PS.Data.PSWXEntApp;
import SA.SRFDA.PS.Data.PSWXLogic;
import SA.SRFDA.PS.Data.PSWXMenu;
import SA.SRFDA.PS.Data.PSWXMenuFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswx.core.IWXMenu;

public class PSWXEntAppImpl
extends PSWXAccountObjectImpl
implements IPSWXEntApp {
    protected PSWXEntApp psWXEntApp = null;
    private String strAPPURL = null;
    private IPSApplication iPSApplication = null;
    private String strAppType = null;
    private boolean bReportLocation = false;
    private boolean bReportEnter = false;
    private ArrayList<IPSWXLogic> psWXLogicList = new ArrayList();
    private ArrayList<IPSWXMenu> psWXMenuList = new ArrayList();
    private Map<String, IPSWXMenuFunc> psWXMenuFuncMap = new LinkedHashMap<String, IPSWXMenuFunc>();
    private ArrayList<IPSWXMenuFunc> psWXMenuFuncList = new ArrayList();
    private IPSWXMenu defaultPSWXMenu = null;
    private String strCodeName = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSSysResource iPSSysResource = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWXAccount iPSWXAccount, PSWXEntApp psWXEntApp) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSWXAccount(iPSWXAccount);
        this.psWXEntApp = psWXEntApp;
        this.setId(this.psWXEntApp.getPSWXENTAPPID());
        this.setName(this.psWXEntApp.getPSWXENTAPPNAME());
        this.setPSObjectData(this.psWXEntApp);
        this.strAPPURL = this.psWXEntApp.getAPPURL();
        this.strAppType = this.psWXEntApp.getAPPTYPE();
        if (!this.psWXEntApp.isREPENTERFLAGNull()) {
            this.bReportEnter = this.psWXEntApp.getREPENTERFLAG();
        }
        if (!this.psWXEntApp.isREPLOCATIONFLAGNull()) {
            this.bReportLocation = this.psWXEntApp.getREPLOCATIONFLAG();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psWXEntApp.getPSSYSRESOURCEID())) {
            this.iPSSysResource = this.getPSWXAccount().getPSSystem().getPSSysResource(this.psWXEntApp.getPSSYSRESOURCEID());
        }
        this.strCodeName = this.psWXEntApp.getCODENAME();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        String strPSSysSFPluginId = this.psWXEntApp.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSWXAccount().getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSWXAccount().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSWXAccount().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        this.onPreparePSWXMenuFuncs();
        this.onPreparePSWXMenus();
        this.onPreparePSWXLogics();
        if (!StringHelper.isNullOrEmpty((String)this.psWXEntApp.getPSSYSAPPID())) {
            this.iPSApplication = this.getPSWXAccount().getPSSystem().getPSApplication(this.psWXEntApp.getPSSYSAPPID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8def\u5f84")
    public String getAppURL() {
        return this.strAPPURL;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528", dumpref=true)
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    @PSModelRTMeta(description="\u5e94\u7528\u7c7b\u578b")
    public String getAppType() {
        return this.strAppType;
    }

    @PSModelRTMeta(description="\u62a5\u544a\u4f4d\u7f6e", ignoredumpvalues="false", fields={"REPLOCATIONFLAG"})
    public boolean isReportLocation() {
        return this.bReportLocation;
    }

    @PSModelRTMeta(description="\u62a5\u544a\u8fdb\u5165", ignoredumpvalues="false", fields={"REPENTERFLAG"})
    public boolean isReportEnter() {
        return this.bReportEnter;
    }

    protected void onPreparePSWXMenuFuncs() throws Exception {
        this.psWXMenuFuncList.clear();
        Vector<PSWXMenuFunc> psWXMenuFuncList = new Vector<PSWXMenuFunc>();
        CallResult callResult = this.getPSModelHelper().getPSWXMenuFuncsByApp(this.getId(), psWXMenuFuncList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5fae\u4fe1\u516c\u4f17\u53f7\u83dc\u5355\u529f\u80fd\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWXMenuFunc psWXMenuFunc : psWXMenuFuncList) {
            PSWXMenuFuncImpl iPSWXMenuFunc = new PSWXMenuFuncImpl();
            iPSWXMenuFunc.init(this.getDAGlobalHelper(), this.getPSWXAccount(), this, psWXMenuFunc);
            this.psWXMenuFuncList.add(iPSWXMenuFunc);
            this.psWXMenuFuncMap.put(iPSWXMenuFunc.getId(), iPSWXMenuFunc);
        }
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u529f\u80fd\u96c6\u5408", child=true)
    public Iterator<IPSWXMenuFunc> getPSWXMenuFuncs() {
        if (this.psWXMenuFuncList.size() == 0) {
            return null;
        }
        return this.psWXMenuFuncList.iterator();
    }

    protected void onPreparePSWXMenus() throws Exception {
        this.psWXMenuList.clear();
        Vector<PSWXMenu> psWXMenuList = new Vector<PSWXMenu>();
        CallResult callResult = this.getPSModelHelper().getPSWXMenusByApp(this.getId(), psWXMenuList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5fae\u4fe1\u516c\u4f17\u53f7\u83dc\u5355\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWXMenu psWXMenu : psWXMenuList) {
            PSWXMenuImpl iPSWXMenu = new PSWXMenuImpl();
            iPSWXMenu.init(this.getDAGlobalHelper(), this.getPSWXAccount(), this, psWXMenu);
            this.psWXMenuList.add(iPSWXMenu);
            if (!iPSWXMenu.isDefaultMenu()) continue;
            this.defaultPSWXMenu = iPSWXMenu;
        }
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u96c6\u5408", child=true)
    public Iterator<IPSWXMenu> getPSWXMenus() {
        if (this.psWXMenuList.size() == 0) {
            return null;
        }
        return this.psWXMenuList.iterator();
    }

    @Override
    public IPSWXMenuFunc getPSWXMenuFunc(String strPSWXMenuFuncId) throws Exception {
        IPSWXMenuFunc iPSWXMenuFunc = this.psWXMenuFuncMap.get(strPSWXMenuFuncId);
        if (iPSWXMenuFunc == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u4fe1\u83dc\u5355\u529f\u80fd[%1$s]", (Object)strPSWXMenuFuncId));
        }
        return iPSWXMenuFunc;
    }

    @Override
    public IPSWXMenu getDefaultPSWXMenu() {
        return this.defaultPSWXMenu;
    }

    protected void onPreparePSWXLogics() throws Exception {
        this.psWXLogicList.clear();
        Vector<PSWXLogic> psWXLogicList = new Vector<PSWXLogic>();
        CallResult callResult = this.getPSModelHelper().getPSWXLogicsByApp(this.getId(), psWXLogicList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5fae\u4fe1\u516c\u4f17\u53f7\u54cd\u5e94\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWXLogic psWXLogic : psWXLogicList) {
            PSWXLogicImpl iPSWXLogic = new PSWXLogicImpl();
            iPSWXLogic.init(this.getDAGlobalHelper(), this.getPSWXAccount(), this, psWXLogic);
            this.psWXLogicList.add(iPSWXLogic);
        }
    }

    @Override
    @PSModelRTMeta(description="\u54cd\u5e94\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<IPSWXLogic> getPSWXLogics() {
        if (this.psWXLogicList.size() == 0) {
            return null;
        }
        return this.psWXLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    public IWXMenu getDefaultWXMenu() {
        return this.getDefaultPSWXMenu();
    }

    @PSModelRTMeta(description="AppSecret")
    public String getAppSecret() {
        return null;
    }

    public String getToken() {
        return null;
    }

    @PSModelRTMeta(description="EncodingAESKey")
    public String getEncodingAESKey() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8d44\u6e90\u5bf9\u8c61", dumpref=true, fields={"PSSYSRESOURCEID"})
    public IPSSysResource getPSSysResource() {
        return this.iPSSysResource;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }
}

