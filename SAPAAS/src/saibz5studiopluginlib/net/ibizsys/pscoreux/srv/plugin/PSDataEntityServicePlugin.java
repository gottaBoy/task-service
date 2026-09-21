/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.PluginActionResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServicePluginBase
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService;
import org.hibernate.SessionFactory;

public class PSDataEntityServicePlugin
extends ServicePluginBase {
    public static final String TAG_WFINSTANCEID = "WFINSTANCEID";
    public static final String TAG_WFSTATE = "WFSTATE";
    public static final String TAG_WFSTEP = "WFSTEP";
    public static final String TAG_WFVERSION = "WFVERSION";
    public static final String TAG_WFUSERSTATE = "WFUSERSTATE";

    public PluginActionResult doRemove(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (nActionPos == 30) {
            PSDEViewBaseService psDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)iService.getSessionFactory());
            PSDEViewCtrlService psDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)iService.getSessionFactory());
            PSDEViewRVService psDEViewRVService = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, (SessionFactory)iService.getSessionFactory());
            PSDEViewLogicService psDEViewLogicService = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)iService.getSessionFactory());
            ArrayList psDeViewBaseList = psDEViewBaseService.selectByPSDE((PSDataEntityBase)((PSDataEntity)iEntity));
            for (PSDEViewBase psDEViewBase : psDeViewBaseList) {
                SelectCond cond = new SelectCond();
                cond.set("PSDEVIEWBASEID", (Object)psDEViewBase.getPSDEViewBaseId());
                cond.setConditon("DEFAULTFLAG", (Object)1);
                ArrayList updatePSDEViewCtrlList = psDEViewCtrlService.select((ISelectCond)cond);
                for (PSDEViewCtrl psDEViewCtrl : updatePSDEViewCtrlList) {
                    psDEViewCtrl.setDefaultFlag(Integer.valueOf(0));
                    psDEViewCtrlService.update((IEntity)psDEViewCtrl);
                }
                ArrayList psDEViewCtrlList = psDEViewCtrlService.selectByPSDEViewBase((PSDEViewBaseBase)psDEViewBase);
                psDEViewCtrlService.remove(psDEViewCtrlList);
                ArrayList psDeViewRVList = psDEViewRVService.selectByMajorPSDEView((PSDEViewBaseBase)psDEViewBase);
                psDEViewRVService.remove(psDeViewRVList);
                ArrayList psDEViewLogicList = psDEViewLogicService.selectByPSDEViewBase((PSDEViewBaseBase)psDEViewBase);
                psDEViewLogicService.remove(psDEViewLogicList);
            }
            return PluginActionResult.Continue;
        }
        return super.doRemove(iService, nActionPos, iEntity, objParam);
    }

    public PluginActionResult doCustomAction(IService iService, String strActionName, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (nActionPos == 99 && StringHelper.compare((String)strActionName, (String)"INITMODEL", (boolean)true) == 0) {
            PSDataEntity psDataEntity = (PSDataEntity)iEntity;
            if (DataObject.getBoolValue((Integer)psDataEntity.getEnableWFModel(), (boolean)false)) {
                String strPSDataEntityId = psDataEntity.getPSDataEntityId();
                PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)iService.getSessionFactory());
                PSDEField psDEField = new PSDEField();
                psDEField.setPSDEId(strPSDataEntityId);
                psDEField.setBizTag(TAG_WFINSTANCEID);
                if (!psDEFieldService.select((IEntity)psDEField, true)) {
                    psDEField.setPSDEFieldName(TAG_WFINSTANCEID);
                    psDEField.setCodeName("WFInstanceId");
                    psDEField.setLogicName("\u5de5\u4f5c\u6d41\u5b9e\u4f8b");
                    psDEField.setDEFType(Integer.valueOf(1));
                    psDEField.setPSDataTypeId("TEXT");
                    psDEField.setPSDataTypeName("\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6");
                    psDEField.setAllowEmpty(Integer.valueOf(1));
                    psDEFieldService.save((IEntity)psDEField);
                }
                psDEField.reset();
                psDEField.setPSDEId(strPSDataEntityId);
                psDEField.setBizTag(TAG_WFSTATE);
                if (!psDEFieldService.select((IEntity)psDEField, true)) {
                    psDEField.setPSDEFieldName(TAG_WFSTATE);
                    psDEField.setCodeName("WFState");
                    psDEField.setLogicName("\u5de5\u4f5c\u6d41\u72b6\u6001");
                    psDEField.setDEFType(Integer.valueOf(1));
                    psDEField.setPSDataTypeId(TAG_WFSTATE);
                    psDEField.setPSDataTypeName("\u5de5\u4f5c\u6d41\u5904\u7406\u72b6\u6001");
                    psDEField.setAllowEmpty(Integer.valueOf(1));
                    psDEFieldService.save((IEntity)psDEField);
                }
                psDEField.reset();
                psDEField.setPSDEId(strPSDataEntityId);
                psDEField.setBizTag(TAG_WFSTEP);
                if (!psDEFieldService.select((IEntity)psDEField, true)) {
                    psDEField.setPSDEFieldName(TAG_WFSTEP);
                    psDEField.setCodeName("WFStep");
                    psDEField.setLogicName("\u5de5\u4f5c\u6d41\u6b65\u9aa4");
                    psDEField.setDEFType(Integer.valueOf(1));
                    psDEField.setPSDataTypeId("SSCODELIST");
                    psDEField.setPSDataTypeName("\u5355\u9879\u9009\u62e9(\u6587\u672c\u503c)");
                    psDEField.setAllowEmpty(Integer.valueOf(1));
                    psDEFieldService.save((IEntity)psDEField);
                }
                psDEField.reset();
                psDEField.setPSDEId(strPSDataEntityId);
                psDEField.setBizTag(TAG_WFVERSION);
                if (!psDEFieldService.select((IEntity)psDEField, true)) {
                    psDEField.setPSDEFieldName(TAG_WFVERSION);
                    psDEField.setCodeName("WFVersion");
                    psDEField.setLogicName("\u6d41\u7a0b\u7248\u672c");
                    psDEField.setDEFType(Integer.valueOf(1));
                    psDEField.setPSDataTypeId("TEXT");
                    psDEField.setPSDataTypeName("\u6587\u672c\uff0c\u53ef\u6307\u5b9a\u957f\u5ea6");
                    psDEField.setAllowEmpty(Integer.valueOf(1));
                    psDEFieldService.save((IEntity)psDEField);
                }
                psDEField.reset();
                psDEField.setPSDEId(strPSDataEntityId);
                psDEField.setBizTag(TAG_WFUSERSTATE);
                if (!psDEFieldService.select((IEntity)psDEField, true)) {
                    psDEField.setPSDEFieldName(String.valueOf(psDataEntity.getPSDataEntityName()) + TAG_WFSTATE);
                    String strPSDECodeName = psDataEntity.getCodeName();
                    if (StringHelper.isNullOrEmpty((String)strPSDECodeName)) {
                        strPSDECodeName = psDataEntity.getPSDataEntityName();
                    }
                    psDEField.setCodeName(StringHelper.format((String)"%1$sWFState", (Object)strPSDECodeName));
                    psDEField.setLogicName("\u4e1a\u52a1\u72b6\u6001");
                    psDEField.setDEFType(Integer.valueOf(1));
                    psDEField.setPSDataTypeId("SSCODELIST");
                    psDEField.setPSDataTypeName("\u5355\u9879\u9009\u62e9(\u6587\u672c\u503c)");
                    psDEField.setAllowEmpty(Integer.valueOf(1));
                    psDEFieldService.save((IEntity)psDEField);
                }
            }
            return PluginActionResult.Continue;
        }
        return super.doCustomAction(iService, strActionName, nActionPos, iEntity, objParam);
    }
}

