/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityException
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.util.HashMap;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDE;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWCreateDEItem;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWCreateDEServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSUWCreateDEService
extends PSUWCreateDEServiceBase {
    private static final Log log = LogFactory.getLog(PSUWCreateDEService.class);

    @Override
    protected void onAfterCreate(PSUWCreateDE pSUWCreateDE) throws Exception {
        block8: {
            block7: {
                super.onAfterCreate(pSUWCreateDE);
                if (StringHelper.compare((String)pSUWCreateDE.getWizardMode(), (String)"BATCLONE", (boolean)true) != 0) break block7;
                String string = pSUWCreateDE.getWizardData();
                if (StringHelper.isNullOrEmpty((String)string)) break block8;
                HashMap<String, String> hashMap = new HashMap<String, String>();
                HashMap<String, String> hashMap2 = new HashMap<String, String>();
                String[] stringArray = StringHelper.splitEx((String)string);
                for (int i = 0; i < stringArray.length; ++i) {
                    PSDataEntity pSDataEntity;
                    String string2 = stringArray[i];
                    PSDataEntity pSDataEntity2 = new PSDataEntity();
                    pSDataEntity2.setPSDataEntityId(string2);
                    pSDataEntity2.setSessionFactory(this.getSessionFactory());
                    if (!pSDataEntity2.get(true)) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)string2));
                    }
                    PSUWCreateDEItem pSUWCreateDEItem = new PSUWCreateDEItem();
                    pSUWCreateDEItem.setPSUWCreateDEItemName(pSDataEntity2.getLogicName());
                    pSUWCreateDEItem.setPSUWCreateDEId(pSUWCreateDE.getPSUWCreateDEId());
                    pSUWCreateDEItem.setPSDEId(pSDataEntity2.getPSDataEntityId());
                    pSUWCreateDEItem.setPSDEName(pSDataEntity2.getPSDataEntityName());
                    pSUWCreateDEItem.setCodeName(pSDataEntity2.getCodeName());
                    int n = 1;
                    while (true) {
                        pSDataEntity = new PSDataEntity();
                        pSDataEntity.setPSSystemId(pSDataEntity2.getPSSystemId());
                        pSDataEntity.setPSDataEntityName(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity2.getPSDataEntityName(), (Object)(++n)));
                        if (hashMap.containsKey(pSDataEntity.getPSDataEntityName())) continue;
                        pSDataEntity.setSessionFactory(this.getSessionFactory());
                        if (!pSDataEntity.select(true)) break;
                    }
                    pSUWCreateDEItem.setNewDEName(pSDataEntity.getPSDataEntityName());
                    pSUWCreateDEItem.setNewDELogicName(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity2.getLogicName(), (Object)n));
                    n = 1;
                    while (true) {
                        pSDataEntity = new PSDataEntity();
                        pSDataEntity.setPSSystemId(pSDataEntity2.getPSSystemId());
                        pSDataEntity.setCodeName(StringHelper.format((String)"%1$s%2$s", (Object)pSDataEntity2.getCodeName(), (Object)(++n)));
                        if (hashMap2.containsKey(pSDataEntity.getCodeName())) continue;
                        pSDataEntity.setSessionFactory(this.getSessionFactory());
                        if (!pSDataEntity.select(true)) break;
                    }
                    pSUWCreateDEItem.setNewCodeName(pSDataEntity.getCodeName());
                    pSUWCreateDEItem.setSessionFactory(this.getSessionFactory());
                    pSUWCreateDEItem.create();
                    hashMap.put(pSUWCreateDEItem.getNewDEName(), "");
                    hashMap2.put(pSUWCreateDEItem.getNewCodeName(), "");
                }
                break block8;
            }
            try {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSUWCreateDE.copyTo((IDataObject)pSDataEntity, false);
                pSDataEntity.setSessionFactory(this.getSessionFactory());
                pSDataEntity.setDEType(1);
                pSDataEntity.create();
                pSUWCreateDE.setPSUWCreateDEId(pSDataEntity.getPSDataEntityId());
                pSUWCreateDE.setPSUWCreateDEName(pSDataEntity.getPSDataEntityName());
            }
            catch (Exception exception) {
                if (exception instanceof EntityException) {
                    EntityException entityException = (EntityException)exception;
                    throw new EntityException(entityException.getEntityError(), (IDataEntity)this.getDEModel());
                }
                throw exception;
            }
        }
    }

    @Override
    protected void onAfterUpdate(PSUWCreateDE pSUWCreateDE) throws Exception {
        super.onAfterUpdate(pSUWCreateDE);
        final PSUWCreateDE pSUWCreateDE2 = pSUWCreateDE;
        if (StringHelper.compare((String)pSUWCreateDE.getWizardMode(), (String)"BATCLONE", (boolean)true) == 0) {
            SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

                public void rollback() {
                }

                public void commit() {
                    try {
                        PSUWCreateDEService.this.executeAction("X_ADDCLONEDEMODELTASK", pSUWCreateDE2);
                    }
                    catch (Exception exception) {
                        log.error((Object)exception);
                    }
                }
            });
            if (WebContext.getCurrent() != null && WebContext.getCurrent().getCurAjaxActionResult() != null) {
                WebContext.getCurrent().getCurAjaxActionResult().setRetInfo("\u5df2\u5efa\u7acb\u514b\u9686\u5b9e\u4f53\u6a21\u578b\u540e\u53f0\u4efb\u52a1");
            }
        }
    }
}

