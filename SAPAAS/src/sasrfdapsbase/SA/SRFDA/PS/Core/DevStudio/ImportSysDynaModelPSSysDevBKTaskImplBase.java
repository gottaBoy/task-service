/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class ImportSysDynaModelPSSysDevBKTaskImplBase
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(ImportSysDynaModelPSSysDevBKTaskImplBase.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getTASKPARAM())) {
            return "\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u52a8\u6001\u6a21\u578b";
        }
        PSSysDynaModelService psSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysDynaModel psSysDynaModel2 = new PSSysDynaModel();
        psSysDynaModel2.setPSSysDynaModelId(this.psSysDevBKTask.getTASKPARAM());
        psSysDynaModelService.get((IEntity)psSysDynaModel2);
        return this.onImportPSSysDynaModel(psSysDynaModel2);
    }

    protected abstract String onImportPSSysDynaModel(PSSysDynaModel var1) throws Exception;
}

