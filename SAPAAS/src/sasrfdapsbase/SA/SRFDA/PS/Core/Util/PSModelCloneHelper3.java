/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSModule
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSModuleService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDE
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEItem
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.Util.PSModelCloneHelper;
import java.util.ArrayList;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDE;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSModelCloneHelper3
extends PSModelCloneHelper {
    private static final Log log = LogFactory.getLog(PSModelCloneHelper3.class);

    public PSModelCloneHelper3(PSSystem psSystem, SessionFactory srcSessionFactory, SessionFactory dstSessionFactory, String strSrcPSSysModelInstId, String strDstPSSysModelInstId) {
        super(psSystem, srcSessionFactory, dstSessionFactory, strSrcPSSysModelInstId, strDstPSSysModelInstId, 0);
    }

    public String cloneDataEntities(PSUWCreateDE psUWCreateDE) throws Exception {
        SessionFactoryManager.releaseAndAddRef((boolean)true);
        ArrayList<PSUWCreateDEItem> psUWCreateDEItemList = psUWCreateDE.getPSUWCreateDEItems();
        for (PSUWCreateDEItem psUWCreateDEItem : psUWCreateDEItemList) {
            this.newDENameMap.put(psUWCreateDEItem.getPSDEName(), psUWCreateDEItem.getNewDEName());
            this.newDENameMap.put(psUWCreateDEItem.getPSDEId(), psUWCreateDEItem.getNewDEName());
            PSDataEntity newDEDataEntity = new PSDataEntity();
            newDEDataEntity.setPSDataEntityName(psUWCreateDEItem.getNewDEName());
            if (!StringHelper.isNullOrEmpty((String)psUWCreateDEItem.getNewCodeName())) {
                newDEDataEntity.setCodeName(psUWCreateDEItem.getNewCodeName());
            }
            if (!StringHelper.isNullOrEmpty((String)psUWCreateDEItem.getNewDELogicName())) {
                newDEDataEntity.setLogicName(psUWCreateDEItem.getNewDELogicName());
            }
            if (!StringHelper.isNullOrEmpty((String)psUWCreateDEItem.getNewDETableName())) {
                newDEDataEntity.setTableName(psUWCreateDEItem.getNewDETableName());
            }
            if (!StringHelper.isNullOrEmpty((String)psUWCreateDEItem.getNewDEViewName())) {
                newDEDataEntity.setViewName(psUWCreateDEItem.getNewDEViewName());
            }
            this.newDEMap.put(psUWCreateDEItem.getPSDEId(), newDEDataEntity);
        }
        PSModuleService psModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.srcSessionFactory);
        ArrayList<PSModule> psModuleList = psModuleService.selectByPSSystem((PSSystemBase)this.psSystem);
        String strTag = StringHelper.format((String)"%1$s||%2$s", (Object)"PSSYSTEM", (Object)this.getPSSystem().getPSSystemId());
        this.existsDEDataMap.put(strTag, 2);
        this.newDEDataIdMap.put(strTag, this.psSystem.getPSSystemId());
        for (PSModule psModule : psModuleList) {
            String strTag2 = StringHelper.format((String)"%1$s||%2$s", (Object)"PSMODULE", (Object)psModule.getPSModuleId());
            this.existsDEDataMap.put(strTag2, 2);
            this.newDEDataIdMap.put(strTag2, psModule.getPSModuleId());
        }
        ArrayList<PSDataEntity> srcDEList = new ArrayList<PSDataEntity>();
        PSDataEntityService psDataEntityService2 = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.dstSessionFactory);
        for (PSUWCreateDEItem psUWCreateDEItem : psUWCreateDEItemList) {
            String strTag3 = StringHelper.format((String)"%1$s||%2$s", (Object)"PSDATAENTITY", (Object)psUWCreateDEItem.getPSDEId());
            PSDataEntity psDataEntitySrc = new PSDataEntity();
            psDataEntitySrc.setPSDataEntityId(psUWCreateDEItem.getPSDEId());
            psDataEntitySrc.setSessionFactory(this.srcSessionFactory);
            if (!psDataEntitySrc.get(true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)psUWCreateDEItem.getPSDEId()));
            }
            srcDEList.add(psDataEntitySrc);
            PSDataEntity psDataEntity = new PSDataEntity();
            psDataEntitySrc.copyTo((IDataObject)psDataEntity, true);
            psDataEntity.setSessionFactory(this.dstSessionFactory);
            psDataEntity.setPSDataEntityName(psUWCreateDEItem.getNewDEName());
            psDataEntity.resetCodeName();
            if (!StringHelper.isNullOrEmpty((String)psUWCreateDEItem.getNewCodeName())) {
                psDataEntity.setCodeName(psUWCreateDEItem.getNewCodeName());
            }
            psDataEntity.resetLogicName();
            if (!StringHelper.isNullOrEmpty((String)psUWCreateDEItem.getNewDELogicName())) {
                psDataEntity.setLogicName(psUWCreateDEItem.getNewDELogicName());
            }
            psDataEntity.resetTableName();
            if (!StringHelper.isNullOrEmpty((String)psUWCreateDEItem.getNewDETableName())) {
                psDataEntity.setTableName(psUWCreateDEItem.getNewDETableName());
            }
            psDataEntity.resetViewName();
            psDataEntity.resetViewName2();
            psDataEntity.resetViewName3();
            psDataEntity.resetViewName4();
            if (!StringHelper.isNullOrEmpty((String)psUWCreateDEItem.getNewDEViewName())) {
                psDataEntity.setViewName(psUWCreateDEItem.getNewDEViewName());
            }
            psDataEntity.resetLNPSLanResId();
            psDataEntity.resetPSDataEntityId();
            if (psDataEntityService2.checkKey(psDataEntity) != 0) {
                throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u5df2\u5b58\u5728\u5b9e\u4f53[%1$s]", (Object)psDataEntity.getPSDataEntityName()));
            }
            psDataEntity.setDEType(Integer.valueOf(1));
            psDataEntityService2.create(psDataEntity, false);
            psDataEntity.setDEType(psDataEntitySrc.getDEType());
            this.existsDEDataMap.put(strTag3, 0);
            this.newDEDataIdMap.put(strTag3, psDataEntity.getPSDataEntityId());
            this.newDENameMap.put(psUWCreateDEItem.getPSDEName(), psUWCreateDEItem.getNewDEName());
            this.newDENameMap.put(psUWCreateDEItem.getPSDEId(), psUWCreateDEItem.getNewDEName());
            this.newDENameMap.put(psDataEntity.getPSDataEntityId(), psUWCreateDEItem.getNewDEName());
            this.newDEMap.put(psUWCreateDEItem.getPSDEId(), psDataEntity);
            this.newDEMap.put(psDataEntity.getPSDataEntityId(), psDataEntity);
        }
        IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)"PSDATAENTITY");
        for (PSDataEntity psDataEntity : srcDEList) {
            this.cloneDEData(iDataEntityModel, (IEntity)psDataEntity, null, 0, false);
        }
        String strRet = this.importModelList();
        this.appendLog(strRet);
        return strRet;
    }

    @Override
    boolean isCheckModelLock() {
        return false;
    }

    @Override
    boolean isSetModelLock() {
        return false;
    }

    @Override
    boolean isCloneMode() {
        return true;
    }
}
