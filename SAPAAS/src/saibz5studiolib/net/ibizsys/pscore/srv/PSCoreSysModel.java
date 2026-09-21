/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.IDEFInputTipSetModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.security.IDEDataAccMgr
 *  net.ibizsys.paas.sysmodel.SysModelGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.view.IViewMsgGroupModel
 *  net.ibizsys.paas.view.IViewMsgModel
 *  net.ibizsys.paas.web.WebConfig
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.pscore.srv.PSCoreSysModelBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSViewMsgGroupModel;
import net.ibizsys.pscore.srv.core.PSDEDataSetViewMsgModel;
import net.ibizsys.pscore.srv.util.PSDEDataAccMgr;
import net.ibizsys.pscore.srv.util.PSDevSlnDEDataAccMgr;
import net.ibizsys.pscore.srv.util.PSDevSlnSysDEDataAccMgr;
import net.ibizsys.pscore.srv.util.PSDevSlnTemplDEDataAccMgr;
import net.ibizsys.pscore.srv.util.PSSysRTDEFInputTipSetModel;
import net.ibizsys.pscore.srv.util.PSUWProjectDEDataAccMgr;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSCoreSysModel
extends PSCoreSysModelBase {
    private static final Log log = LogFactory.getLog(PSCoreSysModel.class);
    private static boolean bSimpleMode = false;
    private static boolean bPrepareConfig = false;
    private static boolean bShareSysMode = false;
    private static boolean bEnableFolderKey = false;
    private static String strStudioVer = "S0500";
    private HashMap<String, String> psDevSlnMap = new HashMap();
    private HashMap<String, String> psDevSlnSysMap = new HashMap();
    private HashMap<String, IViewMsgGroupModel> viewMsgGroupModelMap = new HashMap();
    private static HashMap<String, String> globalModelInstMap = new HashMap();

    public static boolean isSimpleMode() {
        return bSimpleMode;
    }

    public static void setSimpleMode(boolean bl) {
        bSimpleMode = bl;
    }

    public PSCoreSysModel() throws Exception {
        this.psDevSlnMap.put("PSDEVSLN", "");
        this.psDevSlnSysMap.put("PSDEVSLNSYS", "");
    }

    public IDEDataAccMgr createDEDataAccMgr(IDataEntityModel iDataEntityModel) throws Exception {
        if (this.psDevSlnMap.containsKey(iDataEntityModel.getName())) {
            PSDevSlnDEDataAccMgr pSDevSlnDEDataAccMgr = new PSDevSlnDEDataAccMgr();
            pSDevSlnDEDataAccMgr.init(iDataEntityModel);
            return pSDevSlnDEDataAccMgr;
        }
        if (this.psDevSlnSysMap.containsKey(iDataEntityModel.getName())) {
            PSDevSlnSysDEDataAccMgr pSDevSlnSysDEDataAccMgr = new PSDevSlnSysDEDataAccMgr();
            pSDevSlnSysDEDataAccMgr.init(iDataEntityModel);
            return pSDevSlnSysDEDataAccMgr;
        }
        if (StringHelper.compare((String)"PSUWPROJECT", (String)iDataEntityModel.getName(), (boolean)false) == 0) {
            PSUWProjectDEDataAccMgr pSUWProjectDEDataAccMgr = new PSUWProjectDEDataAccMgr();
            pSUWProjectDEDataAccMgr.init(iDataEntityModel);
            return pSUWProjectDEDataAccMgr;
        }
        if (StringHelper.compare((String)"PSDEVSLNTEMPL", (String)iDataEntityModel.getName(), (boolean)false) == 0) {
            PSDevSlnTemplDEDataAccMgr pSDevSlnTemplDEDataAccMgr = new PSDevSlnTemplDEDataAccMgr();
            pSDevSlnTemplDEDataAccMgr.init(iDataEntityModel);
            return pSDevSlnTemplDEDataAccMgr;
        }
        PSDEDataAccMgr pSDEDataAccMgr = new PSDEDataAccMgr();
        pSDEDataAccMgr.init(iDataEntityModel);
        return pSDEDataAccMgr;
    }

    public SessionFactory getRealSessionFactory(IDataEntityModel iDataEntityModel, SessionFactory sessionFactory) {
        if (globalModelInstMap.containsKey(iDataEntityModel.getName())) {
            return PSCoreSysServiceBase.getCurMajorSessionFactory();
        }
        return super.getRealSessionFactory(iDataEntityModel, sessionFactory);
    }

    public JSONObject toJSONObject(IDataEntityModel iDataEntityModel, IEntity iEntity, boolean bl, int n) throws Exception {
        JSONObject jSONObject = DataObject.toJSONObject((IDataObject)iEntity, (boolean)bl);
        if ((n & 4) == 4) {
            jSONObject.remove("createdate");
            jSONObject.remove("updatedate");
            jSONObject.remove("createman");
            jSONObject.remove("updateman");
        }
        jSONObject.remove("lockflag");
        jSONObject.remove("modelstate");
        if ((n & 0x40) == 64 && iDataEntityModel != null) {
            Object object;
            Iterator iterator = iDataEntityModel.getDEFields();
            while (iterator.hasNext()) {
                object = (IDEField)iterator.next();
                if (object.isPhisicalDEField()) continue;
                jSONObject.remove(object.getName().toLowerCase());
            }
            if (jSONObject.has("validflag")) {
                object = jSONObject.opt("validflag");
                if (object != null) {
                    if (StringHelper.compare((String)object.toString(), (String)"1", (boolean)true) == 0) {
                        jSONObject.remove("validflag");
                    }
                } else {
                    jSONObject.remove("validflag");
                }
            }
        }
        if ((n & 0x10000) == 65536) {
            jSONObject.remove("pssystemname");
        }
        return jSONObject;
    }

    public static boolean isShareSysMode() {
        PSCoreSysModel.prepareAppConfig();
        return bShareSysMode;
    }

    protected static void prepareAppConfig() {
        if (bPrepareConfig) {
            return;
        }
        if (WebConfig.getCurrent() != null) {
            bShareSysMode = WebConfig.getCurrent().getAttribute("SHARESYSMODE", false);
            String string = WebConfig.getCurrent().getAttribute("MODELKEYMODE", "");
            bEnableFolderKey = StringHelper.compare((String)string, (String)"V2", (boolean)true) == 0;
        } else {
            bShareSysMode = false;
            bEnableFolderKey = false;
        }
        bPrepareConfig = true;
    }

    public static boolean isEnableFolderKey() {
        PSCoreSysModel.prepareAppConfig();
        return bEnableFolderKey;
    }

    @Override
    protected void prepareSysUtils() {
        super.prepareSysUtils();
    }

    public static String getStudioVer() {
        return strStudioVer;
    }

    public static void setStudioVer(String string) {
        strStudioVer = string;
    }

    public IDEFInputTipSetModel createDEFInputTipSetModel(String string) throws Exception {
        return new PSSysRTDEFInputTipSetModel();
    }

    public IViewMsgModel createViewMsgModel(int n, String string) throws Exception {
        if (n == 1) {
            return new PSDEDataSetViewMsgModel();
        }
        return super.createViewMsgModel(n, string);
    }

    public void registerViewMsgGroupModel(IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
        String string;
        if (iViewMsgGroupModel instanceof IPSViewMsgGroupModel && !StringHelper.isNullOrEmpty((String)(string = ((IPSViewMsgGroupModel)iViewMsgGroupModel).getCodeName()))) {
            if (this.viewMsgGroupModelMap.containsKey(string)) {
                throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e2d\u5df2\u7ecf\u6ce8\u518c\u4e86\u6807\u8bc6\u4e3a[%1$s]\u7684\u89c6\u56fe\u6d88\u606f\u7ec4\u6a21\u578b", (Object)string));
            }
            this.viewMsgGroupModelMap.put(string, iViewMsgGroupModel);
        }
        super.registerViewMsgGroupModel(iViewMsgGroupModel);
    }

    public IViewMsgGroupModel getViewMsgGroupModel(String string) throws Exception {
        IViewMsgGroupModel iViewMsgGroupModel = this.viewMsgGroupModelMap.get(string);
        if (iViewMsgGroupModel != null) {
            return iViewMsgGroupModel;
        }
        return super.getViewMsgGroupModel(string);
    }

    static {
        SysModelGlobal.setUseLoginNameAsOperator((boolean)true);
        globalModelInstMap.put("PSPFPKG", "");
        globalModelInstMap.put("PSPFPKGVER", "");
        globalModelInstMap.put("PSSFPKG", "");
        globalModelInstMap.put("PSSFPKGVER", "");
        globalModelInstMap.put("PSHELPPRJTEMPL", "");
        globalModelInstMap.put("PSHELPARTICLETEMPL", "");
        globalModelInstMap.put("PSHELPSECTIONTEMPL", "");
        globalModelInstMap.put("PSSYSENGINECFG", "");
        globalModelInstMap.put("PSDERTAW", "");
        globalModelInstMap.put("PSDERTAWI", "");
        globalModelInstMap.put("PSVARSAMPLEVALUE", "");
        globalModelInstMap.put("PSDEFTYPE", "");
        globalModelInstMap.put("PSDCMOBAPPTESTDEVICE", "");
        globalModelInstMap.put("PSVIEWENGINE", "");
        globalModelInstMap.put("PSSFPLUGIN", "");
        globalModelInstMap.put("PSSFPLUGINTEMPL", "");
        globalModelInstMap.put("PSPFPLUGIN", "");
        globalModelInstMap.put("PSPFPLUGINTEMPL", "");
        globalModelInstMap.put("PSPFPUBCODE", "");
        globalModelInstMap.put("PSDCCODESNIPPET", "");
        globalModelInstMap.put("PSDCCODESNIPPETREF", "");
        globalModelInstMap.put("PSDEVSLNMSDEPLOY", "");
        globalModelInstMap.put("PSDEVSLNMSDEPAPP", "");
        globalModelInstMap.put("PSDEVSLNMSDEPAPI", "");
        globalModelInstMap.put("PSDEVSLNMSDEPFUNC", "");
        globalModelInstMap.put("PSDEVSLNSYSAPP", "");
        globalModelInstMap.put("PSDEVSLNSYSSRV", "");
        globalModelInstMap.put("PSDEVSLNSYSAPI", "");
        globalModelInstMap.put("PSDEVSLNSYSVER", "");
        globalModelInstMap.put("PSDEVSLNSYSDYNAINST", "");
        globalModelInstMap.put("PSSFSTYLEPARAM", "");
        globalModelInstMap.put("PSMODELSUMMARYTEMPL", "");
        globalModelInstMap.put("PSDCDETEMPL", "");
        globalModelInstMap.put("PSDCDETEMPLFIELD", "");
        globalModelInstMap.put("PSDSPANELTOOLBOX", "");
        globalModelInstMap.put("PSVIEWLOGICTYPE", "");
        globalModelInstMap.put("PSVIEWLOGICTYPEPARAM", "");
        globalModelInstMap.put("PSUIENGINETYPE", "");
        globalModelInstMap.put("PSUIENGINETYPEPARAM", "");
        globalModelInstMap.put("PSPFPREVIEWACTION", "");
        globalModelInstMap.put("PSSFPREVIEWACTION", "");
        globalModelInstMap.put("PSCODEPREVIEWACTION", "");
        globalModelInstMap.put("PSCODESERVERACTION", "");
        globalModelInstMap.put("PSPFPREVIEWNODE", "");
        globalModelInstMap.put("PSCONSOLESERVER", "");
        globalModelInstMap.put("PSDSCONSOLE", "");
        globalModelInstMap.put("PSVIEWTYPE", "");
        globalModelInstMap.put("PSVIEWTYPECAT", "");
        globalModelInstMap.put("PSVTCATDETAIL", "");
        globalModelInstMap.put("PSDCWORKSHOPSERVER", "");
        globalModelInstMap.put("PSDCWORKSPACE", "");
        globalModelInstMap.put("PSDCWORKSPACEACTION", "");
        globalModelInstMap.put("PSDCWORKSPACELOG", "");
        globalModelInstMap.put("PSDCWORKSPACEUSER", "");
        globalModelInstMap.put("PSWORKSHOPSERVER", "");
        globalModelInstMap.put("PSWORKSPACE", "");
        globalModelInstMap.put("PSWORKSPACELOG", "");
        globalModelInstMap.put("PSWORKSPACETYPE", "");
        globalModelInstMap.put("PSDCREGISTRYREPO", "");
        globalModelInstMap.put("PSDCREGISTRYITEM", "");
        globalModelInstMap.put("PSDEFDATATYPE", "");
        globalModelInstMap.put("PSSYSMODELREPO", "");
        globalModelInstMap.put("PSDCSYSMODELREPO", "");
        globalModelInstMap.put("PSPMSSERVER", "");
        globalModelInstMap.put("PSDEVCENTERTYPE", "");
        globalModelInstMap.put("PSVIEWRTMSG", "");
        globalModelInstMap.put("PSSTUDIOPLUGIN", "");
        globalModelInstMap.put("PSSTUDIOPLUGINDATA", "");
        globalModelInstMap.put("PSDEVSLNSYSDEPINST", "");
        globalModelInstMap.put("PSDEVSLNSYSDYNAINST", "");
        globalModelInstMap.put("PSDEVSLNSYSDYNAINSTTAG", "");
        globalModelInstMap.put("PSDEVSLNSYSDYNAINSTREF", "");
        globalModelInstMap.put("PSCTRLTYPECALLBACK", "");
        globalModelInstMap.put("PSTSCMD", "");
        globalModelInstMap.put("PSPREDEFINEDTYPE", "");
        globalModelInstMap.put("PSRAWITEMTYPE", "");
        globalModelInstMap.put("PSBUTTONTYPE", "");
        globalModelInstMap.put("PSMSPLATFORM", "");
        globalModelInstMap.put("PSMSPLATFORMFUNC", "");
        globalModelInstMap.put("PSMSPLATFORMNODE", "");
        globalModelInstMap.put("PSDCMSPLATFORM", "");
        globalModelInstMap.put("PSDCMSPLATFORMFUNC", "");
        globalModelInstMap.put("PSDCMSPLATFORMNODE", "");
        globalModelInstMap.put("PSDEVSLNPIPELINE", "");
        globalModelInstMap.put("PSDEVSLNPIPELINEREF", "");
        globalModelInstMap.put("PSDEVSLNPIPELINELOG", "");
        globalModelInstMap.put("PSDEVSLNPIPELINESTAGE", "");
        globalModelInstMap.put("PSDEVSLNPIPELINESTEP", "");
        globalModelInstMap.put("PSGITUSER", "");
        globalModelInstMap.put("PSCREDENTIAL", "");
    }
}

