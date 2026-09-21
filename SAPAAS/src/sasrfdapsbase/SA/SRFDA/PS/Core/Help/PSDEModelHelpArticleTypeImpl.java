/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.config.entity.PSModel
 *  net.ibizsys.pscore.srv.config.service.PSModelService
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle
 *  net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.Help.PSHelpArticleTypeImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpArticle;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpArticleService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PSDEModelHelpArticleTypeImpl
extends PSHelpArticleTypeImpl {
    @Override
    protected void onInitModel(IPSSystem iPSSystem, PSHelpArticle psHelpArticle) throws Exception {
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)iPSSystem.getPSSysModelInstId());
        PSModelService psModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class);
        PSModel psModel = new PSModel();
        String strPSModelId = psHelpArticle.getPSDEName();
        if (!StringHelper.isNullOrEmpty((String)psHelpArticle.getUserTag())) {
            strPSModelId = StringHelper.format((String)"%1$s_%2$s", (Object)psHelpArticle.getPSDEName(), (Object)psHelpArticle.getUserTag());
        }
        psModel.setPSModelId(strPSModelId);
        if (psModelService.get((IEntity)psModel, true) && !StringHelper.isNullOrEmpty((String)psModel.getModelDesc())) {
            psHelpArticle.setContent(psModel.getModelDesc());
            PSHelpArticleService psHelpArticleService = (PSHelpArticleService)ServiceGlobal.getService(PSHelpArticleService.class, (SessionFactory)sessionFactory);
            psHelpArticleService.update((IEntity)psHelpArticle);
        }
        super.onInitModel(iPSSystem, psHelpArticle);
    }
}

