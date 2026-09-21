/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.PSSFCodeObjectHelper;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSSystemModule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemModuleImpl
extends PSSystemObjectImpl
implements IPSSystemModule,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSSystemModuleImpl.class);
    protected PSSystemModule psSystemModule = null;
    private boolean bSubSysModule = false;
    private Properties classOrPkgNameMap = null;
    private IPSSysRef iPSSysRef = null;
    private IPSSysSFPub iPSSysSFPub = null;
    private boolean bDefaultModule = false;
    private IPSSysModelGroup iPSSysModelGroup = null;
    private List<IPSDataEntity> psDataEntityList = null;
    private List<IPSSystemModule> majorPSSystemModuleList = null;
    private List<IPSSystemModule> minorPSSystemModuleList = null;
    private List<IPSWorkflow> psWorkflowList = null;
    private List<IPSCodeList> psCodeListList = null;
    private String strSysRefType = "";
    private boolean bSubSysAsCloud = false;
    private int nDynaInstMode = 0;
    private String strDynaInstTag = null;
    private String strUtilType = "";
    private String strUtilTag = null;
    private Properties utilProperties = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSystemModule psSystemModule) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSystemModule = psSystemModule;
            this.setId(this.psSystemModule.getPSMODULEID());
            this.setName(this.psSystemModule.getPSMODULENAME());
            this.setPSObjectData(this.psSystemModule);
            if (!this.psSystemModule.isSUBSYSMODULENull()) {
                this.bSubSysModule = this.psSystemModule.getSUBSYSMODULE();
                if (!StringHelper.isNullOrEmpty((String)this.psSystemModule.getSYSREFTYPE())) {
                    this.strSysRefType = this.psSystemModule.getSYSREFTYPE();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psSystemModule.getPSSYSREFID())) {
                    this.iPSSysRef = this.iPSSystem.getPSSysRef(this.psSystemModule.getPSSYSREFID());
                    if (StringHelper.isNullOrEmpty((String)this.strSysRefType)) {
                        this.strSysRefType = this.iPSSysRef.getSysRefType();
                    }
                }
                boolean bl = this.bSubSysAsCloud = StringHelper.compare((String)this.getSysRefType(), (String)"DEVSYSCLOUD", (boolean)false) == 0;
            }
            if (!this.isSubSysModule() || this.isSubSysAsCloud()) {
                this.iPSSysSFPub = StringHelper.isNullOrEmpty((String)this.psSystemModule.getPSSYSSFPUBID()) ? this.getPSSystem().getDefaultPSSysSFPub() : this.getPSSystem().getPSSysSFPub(this.psSystemModule.getPSSYSSFPUBID());
                if (!this.psSystemModule.isDEFAULTFLAGNull()) {
                    this.bDefaultModule = this.psSystemModule.getDEFAULTFLAG();
                }
            }
            this.classOrPkgNameMap = SA.SRFramework.UtilityEx.PropertiesHelper.Load((String)this.psSystemModule.getCLSPKGPARAMS());
            if (!StringHelper.isNullOrEmpty((String)this.psSystemModule.getPSSYSMODELGROUPID())) {
                this.iPSSysModelGroup = this.getPSSystem().getPSSysModelGroup(this.psSystemModule.getPSSYSMODELGROUPID());
            }
            if (this.getPSSystem().isEnableDynaSys()) {
                this.nDynaInstMode = this.psSystemModule.getDYNAINSTMODE();
            }
            this.strUtilType = this.psSystemModule.getUTILTYPE();
            this.strUtilTag = this.psSystemModule.getUTILTAG();
            if (!StringHelper.isNullOrEmpty((String)this.psSystemModule.getUTILPARAMS())) {
                this.utilProperties = PropertiesHelper.load((String)this.psSystemModule.getUTILPARAMS());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psSystemModule.getCODENAME();
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        return PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSysRef, this.classOrPkgNameMap, strCodeType, iPSSysSFPub);
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u6a21\u5757", ignoredumpvalues="false", fields={"SUBSYSMODULE"})
    public boolean isSubSysModule() {
        return this.bSubSysModule;
    }

    @Override
    public String getModelType() {
        return "PSMODULE";
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        return this.iPSSysSFPub;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5f15\u7528", hideempty=true, dumpref=true, dynamodelmode=4, fields={"PSSYSREFID"})
    public IPSSysRef getPSSysRef() {
        return this.iPSSysRef;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6a21\u5757", ignoredumpvalues="false", fields={"DEFAULTFLAG"})
    public boolean isDefaultModule() {
        return !this.isSubSysModule() && this.bDefaultModule;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b")
    public IPSDynaModel getPSDynaModel() {
        return this.getPSSystem().getDefaultPSSysDynaModelByModule(this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u578b\u7ec4", hideempty=true, dumpref=true, dynamodelmode=4, fields={"PSSYSMODELGROUPID"})
    public IPSSysModelGroup getPSSysModelGroup() {
        return this.iPSSysModelGroup;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb0", hideempty2=true, fields={"MODTAG"})
    public String getModuleTag() {
        return this.psSystemModule.getMODTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb02", hideempty2=true, fields={"MODTAG2"})
    public String getModuleTag2() {
        return this.psSystemModule.getMODTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb03", hideempty2=true, fields={"MODTAG3"})
    public String getModuleTag3() {
        return this.psSystemModule.getMODTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u6807\u8bb04", hideempty2=true, fields={"MODTAG4"})
    public String getModuleTag4() {
        return this.psSystemModule.getMODTAG4();
    }

    @Override
    @PSModelRTMeta(description="\u5305\u4ee3\u7801\u540d\u79f0", hideempty2=true, fields={"PKGCODENAME"})
    public String getPKGCodeName() {
        return this.psSystemModule.getPKGCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u96c6\u5408", child=true, dumpref=true, ignorert=1, group="\u57fa\u672c", order=142)
    public Iterator<IPSDataEntity> getAllPSDataEntities() throws Exception {
        if (this.psDataEntityList == null) {
            ArrayList<IPSDataEntity> list = new ArrayList<IPSDataEntity>();
            Iterator<IPSDataEntity> psDataEntities = this.getPSSystem().getAllPSDataEntities();
            if (psDataEntities != null) {
                while (psDataEntities.hasNext()) {
                    IPSDataEntity iPSDataEntity = psDataEntities.next();
                    if (StringHelper.compare((String)iPSDataEntity.getPSSystemModule().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    list.add(iPSDataEntity);
                }
            }
            if (this.psDataEntityList == null) {
                this.psDataEntityList = list;
            }
        }
        if (this.psDataEntityList.size() == 0) {
            return null;
        }
        return this.psDataEntityList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u96c6\u5408", child=true, dumpref=true, ignorert=1, group="\u57fa\u672c", order=150)
    public Iterator<IPSWorkflow> getAllPSWorkflows() throws Exception {
        if (this.psWorkflowList == null) {
            ArrayList<IPSWorkflow> list = new ArrayList<IPSWorkflow>();
            Iterator<IPSWorkflow> psWorkflows = this.getPSSystem().getAllPSWorkflows();
            if (psWorkflows != null) {
                while (psWorkflows.hasNext()) {
                    IPSWorkflow iPSWorkflow = psWorkflows.next();
                    if (iPSWorkflow.getPSSystemModule() == null || StringHelper.compare((String)iPSWorkflow.getPSSystemModule().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    list.add(iPSWorkflow);
                }
            }
            if (this.psWorkflowList == null) {
                this.psWorkflowList = list;
            }
        }
        if (this.psWorkflowList.size() == 0) {
            return null;
        }
        return this.psWorkflowList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u96c6\u5408", child=true, dumpref=true, ignorert=1, group="\u57fa\u672c", order=140)
    public Iterator<IPSCodeList> getAllPSCodeLists() throws Exception {
        if (this.psCodeListList == null) {
            ArrayList<IPSCodeList> list = new ArrayList<IPSCodeList>();
            Iterator<IPSCodeList> psCodeLists = this.getPSSystem().getAllPSCodeLists();
            if (psCodeLists != null) {
                while (psCodeLists.hasNext()) {
                    IPSCodeList iPSCodeList = psCodeLists.next();
                    if (iPSCodeList.getPSSystemModule() == null || StringHelper.compare((String)iPSCodeList.getPSSystemModule().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    list.add(iPSCodeList);
                }
            }
            if (this.psCodeListList == null) {
                this.psCodeListList = list;
            }
        }
        if (this.psCodeListList.size() == 0) {
            return null;
        }
        return this.psCodeListList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757\u96c6\u5408\uff08\u4ece\u5173\u7cfb\uff09", outputdoc="false")
    public Iterator<IPSSystemModule> getMinorPSSystemModules() throws Exception {
        if (this.minorPSSystemModuleList == null) {
            Iterator<IPSDataEntity> psDataEntities = this.getAllPSDataEntities();
            if (psDataEntities == null) {
                return null;
            }
            HashMap<String, IPSSystemModule> map = new HashMap<String, IPSSystemModule>();
            while (psDataEntities.hasNext()) {
                IPSDataEntity iPSDataEntity = psDataEntities.next();
                Iterator<IPSDERBase> psDERs = iPSDataEntity.getPSDERs(false);
                if (psDERs == null) continue;
                while (psDERs.hasNext()) {
                    IPSSystemModule iPSSystemModule = psDERs.next().getMajorPSDataEntity().getPSSystemModule();
                    map.put(iPSSystemModule.getId(), iPSSystemModule);
                }
            }
            map.remove(this.getId());
            ArrayList<IPSSystemModule> list = new ArrayList<IPSSystemModule>();
            list.addAll(map.values());
            if (this.minorPSSystemModuleList == null) {
                this.minorPSSystemModuleList = list;
            }
        }
        if (this.minorPSSystemModuleList.size() == 0) {
            return null;
        }
        return this.minorPSSystemModuleList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757\u96c6\u5408\uff08\u4e3b\u5173\u7cfb\uff09", outputdoc="false")
    public Iterator<IPSSystemModule> getMajorPSSystemModules() throws Exception {
        if (this.majorPSSystemModuleList == null) {
            Iterator<IPSDataEntity> psDataEntities = this.getAllPSDataEntities();
            if (psDataEntities == null) {
                return null;
            }
            HashMap<String, IPSSystemModule> map = new HashMap<String, IPSSystemModule>();
            while (psDataEntities.hasNext()) {
                IPSDataEntity iPSDataEntity = psDataEntities.next();
                Iterator<IPSDERBase> psDERs = iPSDataEntity.getPSDERs(true);
                if (psDERs == null) continue;
                while (psDERs.hasNext()) {
                    IPSSystemModule iPSSystemModule = psDERs.next().getMinorPSDataEntity().getPSSystemModule();
                    map.put(iPSSystemModule.getId(), iPSSystemModule);
                }
            }
            map.remove(this.getId());
            ArrayList<IPSSystemModule> list = new ArrayList<IPSSystemModule>();
            list.addAll(map.values());
            if (this.majorPSSystemModuleList == null) {
                this.majorPSSystemModuleList = list;
            }
        }
        if (this.majorPSSystemModuleList.size() == 0) {
            return null;
        }
        return this.majorPSSystemModuleList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u7cfb\u7edf\u7c7b\u578b", codelist="SysRefType", hideempty2=true)
    public String getSysRefType() {
        return this.strSysRefType;
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u4ee5\u4e91\u670d\u52a1\u65b9\u5f0f\u63d0\u4f9b", ignoredumpvalues="false")
    public boolean isSubSysAsCloud() {
        return this.bSubSysAsCloud;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        if (this.getPSSysModelGroup() != null) {
            return KeyValueHelper.genUniqueId((String)this.getPSSysModelGroup().getDeployId(), (String)this.getCodeName());
        }
        return KeyValueHelper.genUniqueId((String)this.getPSSystem().getDeployId(), (String)this.getCodeName());
    }

    @Override
    public String getFullModelName() {
        if (this.getPSSysModelGroup() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysModelGroup().getFullModelName(), (Object)super.getFullModelName());
        }
        return super.getFullModelName();
    }

    @Override
    protected int onGetDynaInstMode() {
        return this.nDynaInstMode;
    }

    @Override
    protected String onGetDynaInstTag() {
        if (this.getDynaInstMode() == 2) {
            if (this.strDynaInstTag == null) {
                this.strDynaInstTag = this.psSystemModule.getDYNAINSTTAG();
                if (StringHelper.isNullOrEmpty((String)this.strDynaInstTag)) {
                    this.strDynaInstTag = this.getCodeName();
                }
            }
            return this.strDynaInstTag;
        }
        return "";
    }

    @Override
    protected String onGetDynaInstTag2() {
        return this.psSystemModule.getDYNAINSTTAG2();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSSysModelGroup() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSSysModelGroup().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        if (this.getPSSysRef() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSSysRef().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u77ed\u6807\u8bb0", dump=false)
    public String getShortTag() {
        return this.psSystemModule.getSHORTTAG();
    }

    @Override
    @PSModelRTMeta(description="\u8bed\u8a00\u8d44\u6e90\u6807\u8bb0\u524d\u7f00", dump=false)
    public String getLanResTag() {
        return this.psSystemModule.getLANRESTAG();
    }

    @Override
    public String getDEPSSysSFPluginId() {
        return this.psSystemModule.getDEPSSYSSFPLUGINID();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u529f\u80fd\u7c7b\u578b", codelist="ModuleUtilType")
    public String getUtilType() {
        return this.strUtilType;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u529f\u80fd\u6807\u8bb0")
    public String getUtilTag() {
        if (StringHelper.isNullOrEmpty((String)this.getUtilType())) {
            return null;
        }
        return this.strUtilTag;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u529f\u80fd\u53c2\u6570")
    public Properties getUtilParams() {
        if (StringHelper.isNullOrEmpty((String)this.getUtilType())) {
            return null;
        }
        return this.utilProperties;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        try {
            Iterator<IPSSysSFPlugin> psSysSFPlugins = this.getPSSystem().getAllPSSysSFPlugins();
            if (psSysSFPlugins != null) {
                while (psSysSFPlugins.hasNext()) {
                    IPSSysSFPlugin iPSSysSFPlugin = psSysSFPlugins.next();
                    if (iPSSysSFPlugin.getPSSystemModule() == null || StringHelper.compare((String)iPSSysSFPlugin.getPSSystemModule().getId(), (String)this.getId(), (boolean)false) != 0 || !"GLOBAL_MODULERUNTIME".equalsIgnoreCase(iPSSysSFPlugin.getPluginCode())) continue;
                    return iPSSysSFPlugin;
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6570\u636e\u6e90", codelist="SysDeployDBMode", dynamodelmode=4, fields={"DSLINK"})
    public String getDSLink() {
        return this.psSystemModule.getDSLINK();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSSysModelGroup() != null) {
            return this.getPSSysModelGroup();
        }
        if (this.getPSSysRef() != null) {
            return this.getPSSysRef();
        }
        return this.getPSSystem();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSSysModelGroup() != null) {
            return this.getPSSysModelGroup();
        }
        if (this.getPSSysRef() != null) {
            return this.getPSSysRef();
        }
        return this.getPSSystem();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSSysModelGroup() != null) {
            return String.format("%1$s/psmodules", this.getPSSysModelGroup().getMOSFilePath());
        }
        if (this.getPSSysRef() != null) {
            return String.format("%1$s/psmodules", this.getPSSysRef().getMOSFilePath());
        }
        return "psmodules";
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysModelGroup() != null) {
            return String.format("%1$s/psmodules", this.getPSSysModelGroup().getRTMOSFilePath());
        }
        if (this.getPSSysRef() != null) {
            return String.format("%1$s/psmodules", this.getPSSysRef().getRTMOSFilePath());
        }
        return "psmodules";
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u7f16\u53f7", dynamodelmode=4, group="\u57fa\u672c", order=105, fields={"MODULESN"})
    public String getModuleSN() {
        return this.psSystemModule.getMODULESN();
    }

    @Override
    @PSModelRTMeta(description="DTO\u4ee3\u7801\u6807\u8bc6\u683c\u5f0f\u5316", dump=false)
    public String getDTOCodeNameFormat() {
        if (!StringHelper.isNullOrEmpty((String)this.psSystemModule.getDTOFORMAT())) {
            return this.psSystemModule.getDTOFORMAT();
        }
        if (this.getPSSysModelGroup() != null) {
            return this.getPSSysModelGroup().getDTOCodeNameFormat();
        }
        return this.getPSSystem().getDTOCodeNameFormat();
    }

    @Override
    public int getOrderValue() {
        if (this.psSystemModule.isORDERVALUENull() || this.psSystemModule.getORDERVALUE() < 0) {
            return 99999;
        }
        return this.psSystemModule.getORDERVALUE();
    }

    @Override
    @PSModelRTMeta(description="API\u4ee3\u7801\u6807\u8bc6\u6a21\u5f0f", codelist="CodeNameMode", fields={"CODENAMEMODE"}, dump=false)
    public String getAPICodeNameMode() {
        if (!StringHelper.isNullOrEmpty((String)this.psSystemModule.getCODENAMEMODE())) {
            return this.psSystemModule.getCODENAMEMODE();
        }
        if (this.getPSSysModelGroup() != null) {
            return this.getPSSysModelGroup().getAPICodeNameMode();
        }
        return this.getPSSystem().getAPICodeNameMode();
    }

    @Override
    public String getAPICodeName(String strPrefix, String strCodeName, String strSuffix) {
        return PSModelCodeNameUtils.to(this.getAPICodeNameMode(), strPrefix, strCodeName, strSuffix);
    }

    @Override
    @PSModelRTMeta(description="DTO\u4f7f\u7528\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", dump=false)
    public boolean isDTOUseServiceCodeName() {
        return !StringHelper.isNullOrEmpty((String)this.getAPICodeNameMode()) && !"NONE".equalsIgnoreCase(this.getAPICodeNameMode());
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528PQL", dump=false, ignoredumpvalues="false", fields={"ENABLEPQL"})
    public boolean isEnablePQL() {
        if (!this.psSystemModule.isENABLEPQLNull()) {
            return this.psSystemModule.getENABLEPQL();
        }
        if (this.getPSSysModelGroup() != null) {
            return this.getPSSysModelGroup().isEnablePQL();
        }
        return this.getPSSystem().isEnablePQL();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u7c7b\u578b", fields={"RUNTIMETYPE"})
    public String getRuntimeType() {
        String strRuntimeType = this.psSystemModule.getRUNTIMETYPE();
        if (StringHelper.isNullOrEmpty((String)strRuntimeType) && this.getPSSysModelGroup() != null) {
            return this.getPSSysModelGroup().getRuntimeType();
        }
        return strRuntimeType;
    }
}

