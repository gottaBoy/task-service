/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.common.entity.LoginAccount
 *  net.ibizsys.psrt.srv.common.entity.User
 *  net.ibizsys.psrt.srv.common.service.DataSyncAgentService
 *  net.ibizsys.psrt.srv.common.service.LoginAccountService
 *  net.ibizsys.psrt.srv.common.service.MsgTemplateService
 *  net.ibizsys.psrt.srv.common.service.ServiceService
 *  net.ibizsys.psrt.srv.common.service.UniResService
 *  net.ibizsys.psrt.srv.common.service.UserDictCatService
 *  net.ibizsys.psrt.srv.common.service.UserDictService
 *  net.ibizsys.psrt.srv.common.service.UserService
 *  net.ibizsys.psrt.srv.demodel.entity.DataEntity
 *  net.ibizsys.psrt.srv.demodel.entity.QueryModel
 *  net.ibizsys.psrt.srv.demodel.service.DataEntityService
 *  net.ibizsys.psrt.srv.demodel.service.QueryModelService
 *  net.ibizsys.psrt.srv.wf.service.WFAppSettingService
 *  net.ibizsys.psrt.srv.wx.service.WXAccountService
 *  net.ibizsys.psrt.srv.wx.service.WXEntAppService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Database.PSDBDevInstGlobal;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.DataSyncAgentService;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.MsgTemplateService;
import net.ibizsys.psrt.srv.common.service.ServiceService;
import net.ibizsys.psrt.srv.common.service.UniResService;
import net.ibizsys.psrt.srv.common.service.UserDictCatService;
import net.ibizsys.psrt.srv.common.service.UserDictService;
import net.ibizsys.psrt.srv.common.service.UserService;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.entity.QueryModel;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.ibizsys.psrt.srv.demodel.service.QueryModelService;
import net.ibizsys.psrt.srv.wf.service.WFAppSettingService;
import net.ibizsys.psrt.srv.wx.service.WXAccountService;
import net.ibizsys.psrt.srv.wx.service.WXEntAppService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class InstallRTDataPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(InstallRTDataPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
        if (iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
            iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
        }
        return this.installRTData(iPSSystem);
    }

    protected String installRTData(IPSSystem iPSSystem) throws Exception {
        IPSSystemDBConfig iPSSystemDBConfig;
        IPSDBDevInst jitPSDBDevInst = iPSSystem.getJITPSDBDevInst();
        if (jitPSDBDevInst != null) {
            SessionFactory sessionFactory = PSDBDevInstGlobal.getSessionFactory(jitPSDBDevInst.getId());
            this.installRTData(iPSSystem, sessionFactory);
        }
        if ((iPSSystemDBConfig = iPSSystem.getDefaultPSSystemDBConfig()) == null || StringHelper.isNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) {
            if (jitPSDBDevInst == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u8fd0\u884c\u6570\u636e\u5e93\u5b9e\u4f8b");
            }
            return null;
        }
        if (StringHelper.compare((String)iPSSystemDBConfig.getPSDBDevInstId(), (String)jitPSDBDevInst.getId(), (boolean)false) != 0) {
            SessionFactory sessionFactory = PSDBDevInstGlobal.getSessionFactory(iPSSystemDBConfig.getPSDBDevInstId());
            this.installRTData(iPSSystem, sessionFactory);
        }
        return null;
    }

    protected String installRTData(IPSSystem iPSSystem, SessionFactory sessionFactory) throws Exception {
        IPSDataEntity iPSDataEntity;
        UserService userService = (UserService)ServiceGlobal.getService(UserService.class, (SessionFactory)sessionFactory);
        SelectCond selectCond = new SelectCond();
        selectCond.setFetchFirst(true);
        ArrayList userList = userService.select((ISelectCond)selectCond);
        if (userList.size() == 0) {
            LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class, (SessionFactory)sessionFactory);
            User user = new User();
            user.setUserName("\u7cfb\u7edf\u7ba1\u7406\u5458");
            user.setIsSystem(Integer.valueOf(1));
            user.setValidFlag(Integer.valueOf(1));
            user.setMemo("\u7cfb\u7edf\u8d85\u7ea7\u7ba1\u7406\u5458");
            userService.create((IEntity)user);
            String strPassword = KeyValueHelper.genUniqueId((String)"ibzadmin", (String)"123456");
            LoginAccount loginAccount = new LoginAccount();
            loginAccount.setUserId(user.getUserId());
            loginAccount.setUserName(user.getUserName());
            loginAccount.setLoginAccountName("ibzadmin");
            loginAccount.setSuperUser(Integer.valueOf(1));
            loginAccount.setPwd(strPassword);
            loginAccountService.create((IEntity)loginAccount);
        }
        DataEntityService dataEntityService = (DataEntityService)ServiceGlobal.getService(DataEntityService.class, (SessionFactory)sessionFactory);
        QueryModelService queryModelService = (QueryModelService)ServiceGlobal.getService(QueryModelService.class, (SessionFactory)sessionFactory);
        UserDictCatService userDictCatService = (UserDictCatService)ServiceGlobal.getService(UserDictCatService.class, (SessionFactory)sessionFactory);
        UserDictService userDictService = (UserDictService)ServiceGlobal.getService(UserDictService.class, (SessionFactory)sessionFactory);
        UniResService uniResService = (UniResService)ServiceGlobal.getService(UniResService.class, (SessionFactory)sessionFactory);
        MsgTemplateService msgTemplateService = (MsgTemplateService)ServiceGlobal.getService(MsgTemplateService.class, (SessionFactory)sessionFactory);
        ServiceService serviceService = (ServiceService)ServiceGlobal.getService(ServiceService.class, (SessionFactory)sessionFactory);
        WFAppSettingService wfAppSettingService = (WFAppSettingService)ServiceGlobal.getService(WFAppSettingService.class, (SessionFactory)sessionFactory);
        DataSyncAgentService dataSyncAgentService = (DataSyncAgentService)ServiceGlobal.getService(DataSyncAgentService.class, (SessionFactory)sessionFactory);
        WXAccountService wxAccountService = (WXAccountService)ServiceGlobal.getService(WXAccountService.class, (SessionFactory)sessionFactory);
        WXEntAppService wxEntAppService = (WXEntAppService)ServiceGlobal.getService(WXEntAppService.class, (SessionFactory)sessionFactory);
        Iterator<IPSDataEntity> psDataEntities = iPSSystem.getAllPSDataEntities();
        while (psDataEntities.hasNext()) {
            iPSDataEntity = psDataEntities.next();
            if (!iPSDataEntity.isSubSysDE() || iPSDataEntity.getDynamicMode() != 2) continue;
            Iterator<IPSDEDataQuery> psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
            while (psDEDataQueries.hasNext()) {
                IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                if (!iPSDEDataQuery.isPrivQuery() || iPSDEDataQuery.getExtendMode() != 2) continue;
                QueryModel queryModel = new QueryModel();
                queryModel.setQueryModelId(iPSDEDataQuery.getId());
                queryModel.setQueryModelName(iPSDEDataQuery.getName());
                queryModel.setQMVersion(Integer.valueOf(1));
                queryModel.setDEId(iPSDataEntity.getId());
                queryModel.setDEName(iPSDataEntity.getName());
                if (queryModelService.checkKey((IEntity)queryModel) != 0) continue;
                queryModelService.create((IEntity)queryModel, false);
            }
        }
        psDataEntities = iPSSystem.getAllPSDataEntities();
        while (psDataEntities.hasNext()) {
            iPSDataEntity = psDataEntities.next();
            if (iPSDataEntity.isSubSysDE()) continue;
            DataEntity dataEntity = new DataEntity();
            dataEntity.setDEId(iPSDataEntity.getId());
            dataEntity.setDEName(iPSDataEntity.getName());
            dataEntity.setDEType(Integer.valueOf(iPSDataEntity.getDEType()));
            dataEntity.setIsLogicValid(Integer.valueOf(iPSDataEntity.isLogicValid() ? 1 : 0));
            dataEntity.setDELogicName(iPSDataEntity.getLogicName());
            dataEntity.setDEVersion(Integer.valueOf(1));
            if (dataEntityService.checkKey((IEntity)dataEntity) == 0) {
                dataEntityService.create((IEntity)dataEntity, false);
            }
            Iterator<IPSDEDataQuery> psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
            while (psDEDataQueries.hasNext()) {
                IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                if (!iPSDEDataQuery.isPrivQuery() || iPSDEDataQuery.getExtendMode() != 2) continue;
                QueryModel queryModel = new QueryModel();
                queryModel.setQueryModelId(iPSDEDataQuery.getId());
                queryModel.setQueryModelName(iPSDEDataQuery.getName());
                queryModel.setQMVersion(Integer.valueOf(1));
                queryModel.setDEId(iPSDataEntity.getId());
                queryModel.setDEName(iPSDataEntity.getName());
                if (queryModelService.checkKey((IEntity)queryModel) != 0) continue;
                queryModelService.create((IEntity)queryModel, false);
            }
        }
        return null;
    }
}

