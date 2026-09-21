/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.pswx.core.IWXEntApp
 *  net.ibizsys.pswx.core.IWXMenu
 */
package SA.SRFDA.PS.Core.WX;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Core.WX.IPSWXLogic;
import SA.SRFDA.PS.Core.WX.IPSWXMenu;
import SA.SRFDA.PS.Core.WX.IPSWXMenuFunc;
import SA.SRFDA.PS.Core.WX.PSWXEntAppImpl;
import SA.SRFDA.PS.Core.WX.PSWXLogicImpl;
import SA.SRFDA.PS.Core.WX.PSWXMenuFuncImpl;
import SA.SRFDA.PS.Core.WX.PSWXMenuImpl;
import SA.SRFDA.PS.Data.PSWXAccount;
import SA.SRFDA.PS.Data.PSWXEntApp;
import SA.SRFDA.PS.Data.PSWXLogic;
import SA.SRFDA.PS.Data.PSWXMenu;
import SA.SRFDA.PS.Data.PSWXMenuFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pswx.core.IWXEntApp;
import net.ibizsys.pswx.core.IWXMenu;

public class PSWXAccountImpl
extends PSSystemObjectImpl
implements IPSWXAccount {
    protected PSWXAccount psWXAccount = null;
    private ArrayList<IPSWXEntApp> psWXEntAppList = new ArrayList();
    private ArrayList<IPSWXLogic> psWXLogicList = new ArrayList();
    private ArrayList<IPSWXMenu> psWXMenuList = new ArrayList();
    private Map<String, IPSWXMenuFunc> psWXMenuFuncMap = new LinkedHashMap<String, IPSWXMenuFunc>();
    private ArrayList<IPSWXMenuFunc> psWXMenuFuncList = new ArrayList();
    private IPSWXMenu defaultPSWXMenu = null;
    private String strCodeName = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSSysResource iPSSysResource = null;
    private Properties wxAccountParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSWXAccount psWXAccount) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSystem(iPSSystem);
        this.psWXAccount = psWXAccount;
        this.setId(this.psWXAccount.getPSWXACCOUNTID());
        this.setName(this.psWXAccount.getPSWXACCOUNTNAME());
        this.setPSObjectData(this.psWXAccount);
        this.strCodeName = this.psWXAccount.getCODENAME();
        if (!StringHelper.IsNullOrEmpty((String)this.psWXAccount.getPSMODULEID())) {
            this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psWXAccount.getPSMODULEID());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWXAccount.getPSSYSRESOURCEID())) {
            this.iPSSysResource = this.getPSSystem().getPSSysResource(this.psWXAccount.getPSSYSRESOURCEID());
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        String strPSSysSFPluginId = this.psWXAccount.getPSSYSSFPLUGINID();
        if (!StringHelper.IsNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        this.onPreparePSWXEntApps();
        this.onPreparePSWXMenuFuncs();
        this.onPreparePSWXMenus();
        this.onPreparePSWXLogics();
        super.onInit();
    }

    protected void onPreparePSWXEntApps() throws Exception {
        this.psWXEntAppList.clear();
        Vector<PSWXEntApp> psWXEntAppList = new Vector<PSWXEntApp>();
        CallResult callResult = this.getPSModelHelper().getPSWXEntApps(this.getId(), psWXEntAppList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5fae\u4fe1\u516c\u4f17\u53f7\u4f01\u4e1a\u5e94\u7528\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWXEntApp psWXEntApp : psWXEntAppList) {
            if (!psWXEntApp.isVALIDFLAGNull() && !psWXEntApp.getVALIDFLAG()) continue;
            PSWXEntAppImpl iPSWXEntApp = new PSWXEntAppImpl();
            iPSWXEntApp.init(this.getDAGlobalHelper(), this, psWXEntApp);
            this.psWXEntAppList.add(iPSWXEntApp);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u96c6\u5408", child=true)
    public Iterator<IPSWXEntApp> getPSWXEntApps() {
        if (this.psWXEntAppList.size() == 0) {
            return null;
        }
        return this.psWXEntAppList.iterator();
    }

    @Override
    public IPSWXEntApp getPSWXEntApp(String strPSWXEntAppId) throws Exception {
        for (IPSWXEntApp iPSWXEntApp : this.psWXEntAppList) {
            if (StringHelper.Compare((String)iPSWXEntApp.getId(), (String)strPSWXEntAppId, (boolean)false) != 0) continue;
            return iPSWXEntApp;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strPSWXEntAppId));
    }

    protected void onPreparePSWXMenuFuncs() throws Exception {
        this.psWXMenuFuncList.clear();
        Vector<PSWXMenuFunc> psWXMenuFuncList = new Vector<PSWXMenuFunc>();
        CallResult callResult = this.getPSModelHelper().getPSWXMenuFuncs(this.getId(), psWXMenuFuncList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5fae\u4fe1\u516c\u4f17\u53f7\u83dc\u5355\u529f\u80fd\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWXMenuFunc psWXMenuFunc : psWXMenuFuncList) {
            PSWXMenuFuncImpl iPSWXMenuFunc = new PSWXMenuFuncImpl();
            iPSWXMenuFunc.init(this.getDAGlobalHelper(), this, null, psWXMenuFunc);
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
        CallResult callResult = this.getPSModelHelper().getPSWXMenus(this.getId(), psWXMenuList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5fae\u4fe1\u516c\u4f17\u53f7\u83dc\u5355\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWXMenu psWXMenu : psWXMenuList) {
            PSWXMenuImpl iPSWXMenu = new PSWXMenuImpl();
            iPSWXMenu.init(this.getDAGlobalHelper(), this, null, psWXMenu);
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

    public IWXMenu getDefaultWXMenu() {
        return this.getDefaultPSWXMenu();
    }

    @Override
    public IPSWXMenuFunc getPSWXMenuFunc(String strPSWXMenuFuncId) throws Exception {
        IPSWXMenuFunc iPSWXMenuFunc = this.psWXMenuFuncMap.get(strPSWXMenuFuncId);
        if (iPSWXMenuFunc == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u4fe1\u83dc\u5355\u529f\u80fd[%1$s]", (Object)strPSWXMenuFuncId));
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
        CallResult callResult = this.getPSModelHelper().getPSWXLogics(this.getId(), psWXLogicList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5fae\u4fe1\u516c\u4f17\u53f7\u54cd\u5e94\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSWXLogic psWXLogic : psWXLogicList) {
            PSWXLogicImpl iPSWXLogic = new PSWXLogicImpl();
            iPSWXLogic.init(this.getDAGlobalHelper(), this, null, psWXLogic);
            this.psWXLogicList.add(iPSWXLogic);
        }
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u96c6\u5408", child=true)
    public Iterator<IPSWXLogic> getPSWXLogics() {
        if (this.psWXLogicList.size() == 0) {
            return null;
        }
        return this.psWXLogicList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSWXACCOUNT";
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

    public IWXEntApp getWXEntApp(String strWXEntAppId) throws Exception {
        return this.getPSWXEntApp(strWXEntAppId);
    }

    public Object getRuntimeId() {
        return this.getId();
    }

    public void setRuntimeId(Object objId) {
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true, dumpref=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
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

