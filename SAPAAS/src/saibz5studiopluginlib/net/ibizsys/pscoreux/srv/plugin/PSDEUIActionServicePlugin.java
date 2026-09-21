/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.PluginActionResult
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServicePluginBase
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscoreux.srv.plugin;

import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import org.hibernate.SessionFactory;

public class PSDEUIActionServicePlugin
extends ServicePluginBase {
    public PluginActionResult doCustomAction(IService iService, String strActionName, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (nActionPos == 0 && StringHelper.compare((String)strActionName, (String)"CreateDEUAGroup", (boolean)true) == 0) {
            PSDEUIActionService psDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)iService.getSessionFactory());
            PSDEUIAction psDEUIAction = new PSDEUIAction();
            iEntity.copyTo((IDataObject)psDEUIAction, true);
            if (!psDEUIActionService.get((IEntity)psDEUIAction, true)) {
                throw new Exception(StringHelper.format((String)"\u754c\u9762\u884c\u4e3a[%1$s]\u672a\u627e\u5230\uff0c\u65e0\u6cd5\u521b\u5efa\u9ed8\u8ba4\u884c\u4e3a\u7ec4\uff01", (Object)psDEUIAction.getPSDEUIActionId()));
            }
            String strPSDEUIActionId = psDEUIAction.getPSDEUIActionId();
            String strPSDEId = psDEUIAction.getPSDEId();
            String strPSDEName = psDEUIAction.getPSDEName();
            String strPSDEUIActionName = psDEUIAction.getPSDEUIActionName();
            String strPSSystemId = psDEUIAction.getPSSystemId();
            PSDEUAGroup psDEUAGroup = new PSDEUAGroup();
            PSDEUAGroupService psDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)iService.getSessionFactory());
            psDEUAGroup.setPSDEId(strPSDEId);
            psDEUAGroup.setPSDEName(strPSDEName);
            psDEUAGroup.setPSDEUAGroupName(strPSDEUIActionName);
            psDEUAGroup.setPSSystemId(strPSSystemId);
            psDEUAGroupService.create((IEntity)psDEUAGroup);
            PSDEUAGroupDetail psDEUAGroupDetail = new PSDEUAGroupDetail();
            PSDEUAGroupDetailService psDEUAGroupDetailService = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)iService.getSessionFactory());
            boolean bPSDEUAGrop = psDEUAGroupService.get((IEntity)psDEUAGroup, true);
            String strPSDEUAGropId = psDEUAGroup.getPSDEUAGroupId();
            psDEUAGroupDetail.setPSDEUAGroupId(strPSDEUAGropId);
            psDEUAGroupDetail.setPSDEUIActionId(strPSDEUIActionId);
            psDEUAGroupDetailService.create((IEntity)psDEUAGroupDetail);
            return PluginActionResult.Replace;
        }
        return super.doCustomAction(iService, strActionName, nActionPos, iEntity, objParam);
    }
}

