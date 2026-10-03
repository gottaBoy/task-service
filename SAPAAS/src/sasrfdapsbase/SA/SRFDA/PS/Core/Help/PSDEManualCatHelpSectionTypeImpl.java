/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection
 *  net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Help.PSHelpSectionTypeImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.hibernate.SessionFactory;

public class PSDEManualCatHelpSectionTypeImpl
extends PSHelpSectionTypeImpl {
    @Override
    protected void onInitModel(IPSSystem iPSSystem, PSHelpSection psHelpSection) throws Exception {
        String strPSDEId = psHelpSection.getPSHelpArticle().getPSDEId();
        if (StringHelper.isNullOrEmpty((String)strPSDEId)) {
            throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u64cd\u4f5c\u5206\u7c7b\u5e2e\u52a9\u7ae0\u8282\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53"));
        }
        IPSDataEntity iPSDataEntity = iPSSystem.getPSDataEntity2(strPSDEId);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PPSHELPSECTIONID", (Object)psHelpSection.getPSHelpSectionId());
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)iPSSystem.getPSSysModelInstId());
        int nMaxOrderValue = 100;
        PSHelpSectionService psHelpSectionService = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)sessionFactory);
        ArrayList<PSHelpSection> psHelpSectionList = psHelpSectionService.select((ISelectCond)selectCond);
        HashMap<String, PSHelpSection> psHelpSectionMap = new HashMap<String, PSHelpSection>();
        for (PSHelpSection psHelpSection2 : psHelpSectionList) {
            psHelpSectionMap.put(psHelpSection2.getPSHelpSectionId(), psHelpSection2);
            if (DataObject.getIntegerValue((Object)psHelpSection2.getOrderValue(), (Integer)100) <= nMaxOrderValue) continue;
            nMaxOrderValue = DataObject.getIntegerValue((Object)psHelpSection2.getOrderValue(), (Integer)100);
        }
        super.onInitModel(iPSSystem, psHelpSection);
    }
}
