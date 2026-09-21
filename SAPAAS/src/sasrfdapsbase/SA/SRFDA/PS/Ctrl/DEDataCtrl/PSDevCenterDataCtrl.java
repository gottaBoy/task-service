/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DCLevelCodeListModel
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevUser
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevUserService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSMavenServer
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemService
 *  net.ibizsys.pscore.srv.util.PSDCInstGlobal
 *  net.ibizsys.pscore.srv.util.PSModelV2Helper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin
 *  net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl
 *  net.ibizsys.psrt.srv.common.entity.LoginAccount
 *  net.ibizsys.psrt.srv.common.service.LoginAccountService
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Deploy.IPSMavenServerType;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterRuntime;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSModelDEDataCtrl;
import SA.SRFDA.PS.Data.PSDCInst;
import SA.SRFDA.PS.Data.PSDevCenter;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.PS.Data.PSSVNInstRepo;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DCLevelCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMavenServer;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.util.PSDCInstGlobal;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevCenterDataCtrl
extends PSModelDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDevCenterDataCtrl.class);
    public static final String CUSTOMCALL_RELOAD = "RELOAD";
    public static final String CUSTOMCALL_GENRESREP = "GENRESREP";
    public static final String CUSTOMCALL_RESETDOMAIN = "RESETDOMAIN";
    public static final String CUSTOMCALL_UNLOAD = "UNLOAD";
    public static final String CUSTOMCALL_INITMAVENREPO = "INITMAVENREPO";
    public static final String CUSTOMCALL_UPDATEMAVENREPOADMIN = "UPDATEMAVENREPOADMIN";
    public static final String CUSTOMCALL_UPDATEMAVENREPOGUEST = "UPDATEMAVENREPOGUEST";
    public static final String CUSTOMCALL_TESTCREATE = "TESTCREATE";
    public static final String CUSTOMCALL_CHANGELEVEL = "CHANGELEVEL";
    private static final Random random = new Random();

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        PSDevCenter psDevCenter = new PSDevCenter();
        psDevCenter.proxy(dataEntity);
        if (bInsert) {
            try {
                if (!StringHelper.isNullOrEmpty((String)psDevCenter.getPSSVNINSTREPOID())) {
                    IDEDataCtrl psSVNInstRepoDataCtrl = this.GetRelatedDataCtrl("DE1904");
                    PSSVNInstRepo psSVNInstRepo = new PSSVNInstRepo();
                    psSVNInstRepo.setPSSVNINSTREPOID(psDevCenter.getPSSVNINSTREPOID());
                    callResult = psSVNInstRepoDataCtrl.Get((BaseDataEntity)psSVNInstRepo);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.format((String)"\u83b7\u53d6SVN\u4ed3\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    if (psSVNInstRepo.getREPOSTATE() != 20) {
                        throw new Exception(StringHelper.format((String)"SVN\u4ed3\u5e93\u72b6\u6001\u4e0d\u6b63\u786e"));
                    }
                    if (StringHelper.compare((String)psSVNInstRepo.getPSSVRDOMAINID(), (String)psDevCenter.getPSSVRDOMAINID(), (boolean)true) != 0) {
                        throw new Exception(StringHelper.format((String)"SVN\u4ed3\u5e93\u670d\u52a1\u57df\u4e0e\u5e94\u7528\u4e2d\u5fc3\u4e0d\u6b63\u786e"));
                    }
                    psSVNInstRepo.Reset();
                    psSVNInstRepo.setPSSVNINSTREPOID(psDevCenter.getPSSVNINSTREPOID());
                    psSVNInstRepo.setREPOSTATE(30);
                    psSVNInstRepo.setREFINFO(StringHelper.format((String)psDevCenter.getPSDEVCENTERNAME()));
                    callResult = psSVNInstRepoDataCtrl.Save(false, (BaseDataEntity)psSVNInstRepo);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.format((String)"\u66f4\u65b0SVN\u4ed3\u5e93\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = new CallResult();
        String strPSDCInstId = dataEntity.getParamStringValue("PSDCINSTID", "");
        String strLastPSDCInstId = "";
        if (lastDataEntity != null) {
            strLastPSDCInstId = lastDataEntity.getParamStringValue("PSDCINSTID", "");
        }
        PSDevCenter psDevCenter = new PSDevCenter();
        dataEntity.CopyTo((BaseDataEntity)psDevCenter, true);
        if (!StringHelper.isNullOrEmpty((String)strPSDCInstId) && StringHelper.compare((String)strPSDCInstId, (String)strLastPSDCInstId, (boolean)true) != 0) {
            try {
                this.initPSDCInst(psDevCenter);
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
        if (bInsert) {
            try {
                SA.SRFDA.PS.Data.PSDevUser psDevUser = new SA.SRFDA.PS.Data.PSDevUser();
                psDevUser.setPSDEVCENTERID(psDevCenter.getPSDEVCENTERID());
                psDevUser.setPSDEVCENTERNAME(psDevCenter.getPSDEVCENTERNAME());
                psDevUser.setPSDEVUSERNAME("\u4e2d\u5fc3\u7ba1\u7406\u5458");
                psDevUser.setADMINMODE(true);
                psDevUser.setLOGINNAME("admin");
                psDevUser.setVALIDFLAG(true);
                IDEDataCtrl psDevUserDataCtrl = this.GetRelatedDataCtrl("DE2012");
                callResult = psDevUserDataCtrl.Save(true, (BaseDataEntity)psDevUser);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7ba1\u7406\u5458\u8d26\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(ex.getMessage());
                return callResult;
            }
        }
        return super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
    }

    protected void initPSDCInst(PSDevCenter psDevCenter) throws Exception {
        IDEDataCtrl psDCInstDataCtrl = this.GetRelatedDataCtrl("DE1898");
        PSDCInst psDCInst = new PSDCInst();
        psDCInst.setPSDCINSTID(psDevCenter.getPSDCINSTID());
        CallResult callResult = psDCInstDataCtrl.Get((BaseDataEntity)psDCInst);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u5b9e\u4f8b"));
        }
        if (StringHelper.compare((String)psDCInst.getINSTSTATE(), (String)"20", (boolean)true) != 0) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u5b9e\u4f8b\u72b6\u6001\u4e0d\u6b63\u786e"));
        }
        PSDevCenterService psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSDCInstGlobal.getSessionFactory((String)psDevCenter.getPSDCINSTID()));
        net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter psDevCenter2 = new net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter();
        PSDEDataCtrl.convertEntity2(psDevCenter, (IEntity)psDevCenter2);
        psDevCenterService.save((IEntity)psDevCenter2);
        psDCInst.Reset();
        psDCInst.setPSDCINSTID(psDevCenter.getPSDCINSTID());
        psDCInst.setINSTSTATE("30");
        psDCInst.setMEMO(psDevCenter.getPSDEVCENTERNAME());
        callResult = psDCInstDataCtrl.Save(false, (BaseDataEntity)psDCInst);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u5e94\u7528\u4e2d\u5fc3\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    protected void onReloadModel(BaseDataEntity dataEntity) throws Exception {
        String strPSDevCenterId = dataEntity.getParamStringValue("PSDEVCENTERID", "");
        this.getPSModelStorage().resetPSDevCenter(strPSDevCenterId);
        this.getPSModelStorage().getPSDevCenter(strPSDevCenterId);
    }

    public CallResult reload(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.onReload(dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5237\u65b0\u7b56\u7565\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onReload(BaseDataEntity dataEntity) throws Exception {
        String strPSDevCenterId = dataEntity.getParamStringValue("PSDEVCENTERID", "");
        IPSDevCenterRuntime iPSDevCenterRuntime = (IPSDevCenterRuntime)this.getPSModelStorage().getPSDevCenter(strPSDevCenterId);
        iPSDevCenterRuntime.reload();
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_RELOAD, (boolean)true) == 0) {
            return this.reload(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_UNLOAD, (boolean)true) == 0) {
            return this.unload(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_GENRESREP, (boolean)true) == 0) {
            return this.genResRep(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_RESETDOMAIN, (boolean)true) == 0) {
            return this.resetDomain(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_INITMAVENREPO, (boolean)true) == 0) {
            return this.initMavenRepo(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_UPDATEMAVENREPOADMIN, (boolean)true) == 0) {
            return this.updateMavenRepo(dataEntity, 1);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_UPDATEMAVENREPOGUEST, (boolean)true) == 0) {
            return this.updateMavenRepo(dataEntity, 2);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_TESTCREATE, (boolean)true) == 0) {
            return this.testCreate(dataEntity);
        }
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_CHANGELEVEL, (boolean)true) == 0) {
            return this.changeLevel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult genResRep(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevCenterDataCtrl.this.onGenResRep(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u4ea7\u751f\u5e94\u7528\u4e2d\u5fc3\u8d44\u6e90\u62a5\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenResRep(BaseDataEntity dataEntity) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)"0A27E963-AD4D-4704-B1B2-8B8DE9060500");
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId("2C40DFCD-0DF5-47BF-91A5-C45F810B0001");
        PSSystemService psSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        IEntity iEntity = psSystemService.getModelV2Entity((IEntity)psSystem, "PSDELOGIC", "OrderMgr/ORDER/Test36");
        System.out.println(iEntity.get("PSDELOGICID"));
    }

    protected void onGenResRep3(BaseDataEntity dataEntity) throws Exception {
        boolean bLastCloudMode = PSCoreSysServiceBase.isCloudMode();
        PSCoreSysServiceBase.setCloudMode((boolean)true);
        try {
            PSDCModelTemplService psDCModelTemplServiceService = (PSDCModelTemplService)ServiceGlobal.getService(PSDCModelTemplService.class);
            PSDCModelTempl psDCModelTempl = new PSDCModelTempl();
            psDCModelTempl.setPSDCModelTemplId("0D2DDEFD-68B5-4148-A518-A412002323BC");
            psDCModelTemplServiceService.get((IEntity)psDCModelTempl);
            ObjectNode objectNode = psDCModelTemplServiceService.exportModelV2((IEntity)psDCModelTempl);
            log.debug((Object)objectNode.toString());
            PSDCModelTempl psDCModelTempl2 = new PSDCModelTempl();
            psDCModelTempl2.setPSDCModelTemplId("0D2DDEFD-68B5-4148-A518-A412002323BC");
            objectNode.put("psdcmodeltemplname", "\u65b0\u6a21\u677f4");
            psDCModelTemplServiceService.importModelV2((IEntity)psDCModelTempl2, objectNode);
        }
        finally {
            PSCoreSysServiceBase.setCloudMode((boolean)bLastCloudMode);
        }
    }

    protected void onGenResRep2(BaseDataEntity dataEntity) throws Exception {
        boolean bLastCloudMode = PSCoreSysServiceBase.isCloudMode();
        PSCoreSysServiceBase.setCloudMode((boolean)true);
        try {
            PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class);
            PSDEFSFItemService psDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class);
            PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class);
            HashMap<String, PSDataEntity> psDataEntityMap = new HashMap<String, PSDataEntity>();
            Iterator names = PSModelV2Helper.getExportModelV2s();
            while (names.hasNext()) {
                psDataEntityMap.put((String)names.next(), null);
            }
            PSSystem psSystem = new PSSystem();
            psSystem.setPSSystemId("86E2A266-4D1E-49F0-A12D-D636905457A3");
            ArrayList psDataEntityList = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
            for (PSDataEntity psDataEntity : psDataEntityList) {
                if (!psDataEntityMap.containsKey(psDataEntity.getPSDataEntityName())) continue;
                psDataEntityMap.put(psDataEntity.getPSDataEntityName(), psDataEntity);
            }
            psDataEntityMap.remove("PSSYSDMITEM");
            String[] fields = new String[]{"USERTAG", "USERTAG2", "USERTAG3", "USERTAG4", "CODENAME", "__NAME__"};
            for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
                if (psDataEntity == null) continue;
                log.debug((Object)String.format("\u6b63\u5728\u5904\u7406\u5b9e\u4f53[%1$s]", psDataEntity.getPSDataEntityName()));
                SelectCond selectCond = new SelectCond();
                selectCond.set("psdeid", (Object)psDataEntity.getPSDataEntityId());
                ArrayList psDEFieldList = psDEFieldService.select((ISelectCond)selectCond);
                ArrayList psDEFSFItemList = psDEFSFItemService.select((ISelectCond)selectCond);
                HashMap<String, PSDEField> psDEFieldMap = new HashMap<String, PSDEField>();
                for (PSDEField psDEField : psDEFieldList) {
                    psDEFieldMap.put(psDEField.getPSDEFieldName(), psDEField);
                    if (DataTypeHelper.getIntegerValue((Object)psDEField.getMajorField(), (Integer)0) != 1) continue;
                    psDEFieldMap.put("__NAME__", psDEField);
                }
                HashMap<String, PSDEFSFItem> psDEFSFItemMap = new HashMap<String, PSDEFSFItem>();
                for (PSDEFSFItem psDEFSFItem : psDEFSFItemList) {
                    psDEFSFItemMap.put(psDEFSFItem.getPSDEFSFItemName().toUpperCase(), psDEFSFItem);
                }
                String[] stringArray = fields;
                int n = fields.length;
                int n2 = 0;
                while (n2 < n) {
                    String strField = stringArray[n2];
                    PSDEField psDEField = (PSDEField)psDEFieldMap.get(strField);
                    if (psDEField != null) {
                        String strSFItemName = String.format("N_%1$s_EQ", psDEField.getPSDEFieldName()).toUpperCase();
                        if (!psDEFSFItemMap.containsKey(strSFItemName)) {
                            PSDEFSFItem psDEFSFItem = new PSDEFSFItem();
                            psDEFSFItem.setPSDEId(psDataEntity.getPSDataEntityId());
                            psDEFSFItem.setPSDEName(psDataEntity.getPSDataEntityName());
                            psDEFSFItem.setPSDEFId(psDEField.getPSDEFieldId());
                            psDEFSFItem.setPSDEFName(psDEField.getPSDEFieldName());
                            psDEFSFItem.setPSDBValueOPId("EQ");
                            psDEFSFItem.setPSDBValueOPName("\u7b49\u4e8e(=)");
                            psDEFSFItemService.create((IEntity)psDEFSFItem);
                            log.debug((Object)String.format("\u589e\u52a0\u641c\u7d22\u6a21\u5f0f[%1$s]", psDEFSFItem.getPSDEFSFItemName()));
                            psDEFSFItemMap.put(psDEFSFItem.getPSDEFSFItemName().toUpperCase(), psDEFSFItem);
                        }
                    }
                    ++n2;
                }
            }
        }
        finally {
            PSCoreSysServiceBase.setCloudMode((boolean)bLastCloudMode);
        }
    }

    public CallResult resetDomain(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevCenterDataCtrl.this.onResetDomain(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u91cd\u7f6e\u5e94\u7528\u4e2d\u5fc3\u57df\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onResetDomain(BaseDataEntity dataEntity) throws Exception {
        String strPSDevCenterId = dataEntity.getParamStringValue("PSDEVCENTERID", "");
        PSDevCenterService psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class);
        LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class);
        net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter psDevCenter2 = new net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter();
        psDevCenter2.setPSDevCenterId(strPSDevCenterId);
        psDevCenterService.get((IEntity)psDevCenter2);
        psDevCenter2.setDomainName(StringHelper.format((String)"%1$s_%2$s", (Object)psDevCenter2.getDomainName(), (Object)random.nextInt(10000)));
        psDevCenter2.setFullDomainName(StringHelper.format((String)"%1$s_%2$s", (Object)psDevCenter2.getFullDomainName(), (Object)random.nextInt(10000)));
        psDevCenterService.sysUpdate((IEntity)psDevCenter2, false);
        PSDevUserService psDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class);
        ArrayList psDevUserList = psDevUserService.selectByPSDevCenter((PSDevCenterBase)psDevCenter2);
        for (PSDevUser psDevUser : psDevUserList) {
            LoginAccount loginAccount = new LoginAccount();
            if (!StringHelper.isNullOrEmpty((String)psDevUser.getFullLoginName())) {
                loginAccount.setLoginAccountName(psDevUser.getFullLoginName());
                if (loginAccountService.select((IEntity)loginAccount, true)) {
                    loginAccount.setLoginAccountName(StringHelper.format((String)"%1$s_%2$s", (Object)loginAccount.getLoginAccountName(), (Object)random.nextInt(10000)));
                    loginAccountService.sysUpdate((IEntity)loginAccount, false);
                }
            }
            loginAccount.reset();
            if (StringHelper.isNullOrEmpty((String)psDevUser.getFullLoginName2())) continue;
            loginAccount.setLoginAccountName(psDevUser.getFullLoginName2());
            if (!loginAccountService.select((IEntity)loginAccount, true)) continue;
            loginAccount.setLoginAccountName(StringHelper.format((String)"%1$s_%2$s", (Object)loginAccount.getLoginAccountName(), (Object)random.nextInt(10000)));
            loginAccountService.sysUpdate((IEntity)loginAccount, false);
        }
    }

    public CallResult unload(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDevCenter psDevCenter = new PSDevCenter();
            psDevCenter.proxy(dataEntity);
            this.onUnload(psDevCenter);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5378\u8f7d\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onUnload(PSDevCenter psDevCenter) throws Exception {
        String strPSDevCenterId = psDevCenter.getPSDEVCENTERID();
        try {
            this.getPSModelStorage().getPSDevCenterBKTaskGlobal().resetPSBKTaskSession(strPSDevCenterId);
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage());
        }
        this.getPSModelStorage().resetPSDevCenter(strPSDevCenterId);
    }

    public CallResult initMavenRepo(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevCenterDataCtrl.this.onInitMavenRepo(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u4e2d\u5fc3\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitMavenRepo(BaseDataEntity dataEntity2) throws Exception {
        net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter psDevCenter = new net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter();
        PSDEDataCtrl.convertEntity2(dataEntity2, (IEntity)psDevCenter);
        net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo psMavenRepo = new net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo();
        psMavenRepo.setPSMavenRepoId(KeyValueHelper.genUniqueId((String)"PSDEVCENTER", (String)psDevCenter.getPSDevCenterId()));
        if (psMavenRepo.get(true)) {
            return;
        }
        PSMavenServer psMavenServer = new PSMavenServer();
        psMavenServer.setPSSvrDomainId(psDevCenter.getPSSvrDomainId());
        psMavenServer.setValidFlag(Integer.valueOf(1));
        if (!psMavenServer.select(true)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u670d\u52a1\u57dfMaven\u670d\u52a1\u5668");
        }
        psMavenRepo.setPSMavenRepoName(psDevCenter.getDomainName().toLowerCase());
        psMavenRepo.setLogicName(StringHelper.format((String)"[%1$s]Maven\u4ed3\u5e93", (Object)psDevCenter.getPSDevCenterName()));
        psMavenRepo.setRepoState(Integer.valueOf(20));
        psMavenRepo.setPSMavenServerId(psMavenServer.getPSMavenServerId());
        psMavenRepo.setPSMavenServerName(psMavenServer.getPSMavenServerName());
        psMavenRepo.setPSSvrDomainId(psMavenServer.getPSSvrDomainId());
        psMavenRepo.setPSSvrDomainName(psMavenServer.getPSSvrDomainName());
        psMavenRepo.setPSObjType("PSDEVCENTER");
        psMavenRepo.setPSObjId(psDevCenter.getPSDevCenterId());
        psMavenRepo.setPSObjName(psDevCenter.getPSDevCenterName());
        psMavenRepo.setPSDevCenterId(psDevCenter.getPSDevCenterId());
        psMavenRepo.setPSDevCenterName(psDevCenter.getPSDevCenterName());
        psMavenRepo.setValidFlag(Integer.valueOf(1));
        psMavenRepo.setConnStr(StringHelper.format((String)"%1$s/%2$s", (Object)psMavenServer.getMavenUrl(), (Object)psMavenRepo.getPSMavenRepoName()));
        psMavenRepo.setMavenUserName(StringHelper.format((String)"admin@maven.%1$s", (Object)psDevCenter.getFullDomainName()));
        psMavenRepo.setMavenPasswd(this.calcPassword());
        psMavenRepo.setROUserName(StringHelper.format((String)"guest@maven.%1$s", (Object)psDevCenter.getFullDomainName()));
        psMavenRepo.setROPasswd(this.calcPassword());
        psMavenRepo.create();
        PSMavenRepo psMavenRepo2 = new PSMavenRepo();
        PSDEDataCtrl.convertEntity((IEntity)psMavenRepo, psMavenRepo2);
        IPSMavenServerType iPSMavenServerType = this.getPSModelStorage().getPSMavenServerType(psMavenServer.getMavenServerType());
        iPSMavenServerType.createMavenRepo(psMavenRepo2);
    }

    protected String calcPassword() {
        String strSource = Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 8);
        String strPassword = "";
        int i = 0;
        while (i < 8) {
            int nPos = random.nextInt(100) % 5;
            strPassword = nPos == 0 ? String.valueOf(strPassword) + "@" : (nPos == 2 ? String.valueOf(strPassword) + strSource.substring(i, i + 1).toUpperCase() : String.valueOf(strPassword) + strSource.substring(i, i + 1));
            ++i;
        }
        return strPassword;
    }

    public CallResult updateMavenRepo(BaseDataEntity dataEntity, int nMode) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            final int nMode2 = nMode;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevCenterDataCtrl.this.onUpdateMavenRepo(dataEntity2, nMode2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u4e2d\u5fc3\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onUpdateMavenRepo(BaseDataEntity dataEntity2, int nMode) throws Exception {
        net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter psDevCenter = new net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter();
        PSDEDataCtrl.convertEntity2(dataEntity2, (IEntity)psDevCenter);
        net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo psMavenRepo = new net.ibizsys.pscore.srv.paasmgr.entity.PSMavenRepo();
        psMavenRepo.setPSMavenRepoId(KeyValueHelper.genUniqueId((String)"PSDEVCENTER", (String)psDevCenter.getPSDevCenterId()));
        if (!psMavenRepo.get(true)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3Maven\u4ed3\u5e93");
        }
        PSMavenRepo psMavenRepo2 = new PSMavenRepo();
        PSDEDataCtrl.convertEntity((IEntity)psMavenRepo, psMavenRepo2);
        IPSMavenServerType iPSMavenServerType = this.getPSModelStorage().getPSMavenServerType(psMavenRepo.getPSMavenServer().getMavenServerType());
        iPSMavenServerType.updateMavenRepo(psMavenRepo2, nMode);
    }

    public CallResult testCreate(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevCenterDataCtrl.this.onTestCreate();
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u6d4b\u8bd5\u5efa\u7acb\u4e2d\u5fc3\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onTestCreate() throws Exception {
        net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter psDevCenter = new net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter();
        PSCoreSysServiceBase.setCurrentPSSvrDomainId((String)"SVRDOMAIN0001");
        PSCoreSysServiceBase.setEnableGitLabPlugin((boolean)true);
        PSCoreSysServiceBase.setPSGitLabPlugin((IPSGitLabPlugin)new PSGitLabPluginImpl());
        String strValue = StringHelper.format((String)"%1$08d", (Object)random.nextInt(10000000));
        String strName = StringHelper.format((String)"TC%1$s", (Object)strValue);
        psDevCenter.setPSDevCenterName(strName);
        psDevCenter.setDomainName(strName);
        psDevCenter.setDCType("DEVCENTER");
        psDevCenter.setDCLevel(DCLevelCodeListModel.LAB_10);
        JSONObject jo = new JSONObject();
        jo.put("password", (Object)"12345678");
        jo.put("mobile", (Object)("139" + strValue));
        psDevCenter.setWebFolder(jo.toString());
        PSDevCenterService psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class);
        psDevCenterService.create((IEntity)psDevCenter);
    }

    public CallResult changeLevel(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            final net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter psDevCenter = new net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter();
            PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevCenter);
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevCenterDataCtrl.this.onChangeLevel(psDevCenter);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u6d4b\u8bd5\u5efa\u7acb\u4e2d\u5fc3\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onChangeLevel(net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter psDevCenter) throws Exception {
        PSCoreSysServiceBase.setCurrentPSSvrDomainId((String)"SVRDOMAIN0001");
        PSCoreSysServiceBase.setEnableGitLabPlugin((boolean)true);
        PSCoreSysServiceBase.setPSGitLabPlugin((IPSGitLabPlugin)new PSGitLabPluginImpl());
        PSDevCenterService psDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class);
        psDevCenterService.changeLevel(psDevCenter);
    }
}

