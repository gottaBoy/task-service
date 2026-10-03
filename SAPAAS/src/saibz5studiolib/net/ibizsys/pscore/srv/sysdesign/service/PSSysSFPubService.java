/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStylePrj;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysProject;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysSFPubService
extends PSSysSFPubServiceBase {
    private static final Log log = LogFactory.getLog(PSSysSFPubService.class);

    @Override
    protected void onBeforeCreate(PSSysSFPub pSSysSFPub) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysSFPub.getPPSSysSFPubId()) && StringHelper.isNullOrEmpty((String)pSSysSFPub.getContentType())) {
            pSSysSFPub.setContentType("CODE");
        }
        if (StringHelper.compare((String)pSSysSFPub.getContentType(), (String)"DOC", (boolean)true) == 0) {
            pSSysSFPub.setPSSFStyleId(pSSysSFPub.getDocPSSFStyleId());
            pSSysSFPub.setPSSFStyleName(pSSysSFPub.getDocPSSFStyleName());
        }
        this.syncPSSFStyle(pSSysSFPub);
        if (pSSysSFPub.getDefaultPub() == null) {
            PSSysSFPub pSSysSFPub2 = new PSSysSFPub();
            pSSysSFPub2.setPSSystemId(pSSysSFPub.getPSSystemId());
            pSSysSFPub2.setDefaultPub(1);
            if (!this.existsData(pSSysSFPub2)) {
                pSSysSFPub.setDefaultPub(1);
            }
        } else if (DataObject.getBoolValue((Integer)pSSysSFPub.getDefaultPub(), (boolean)false)) {
            PSSysSFPub pSSysSFPub3 = new PSSysSFPub();
            pSSysSFPub3.setPSSystemId(pSSysSFPub.getPSSystemId());
            pSSysSFPub3.setDefaultPub(1);
            if (this.existsData(pSSysSFPub3)) {
                pSSysSFPub3.setDefaultPub(0);
                this.update(pSSysSFPub3, false);
            }
        }
        super.onBeforeCreate(pSSysSFPub);
    }

    @Override
    protected void onBeforeUpdate(PSSysSFPub pSSysSFPub) throws Exception {
        PSSysSFPub pSSysSFPub2;
        if (!pSSysSFPub.isContentTypeDirty()) {
            pSSysSFPub2 = (PSSysSFPub)this.getLast(pSSysSFPub);
            pSSysSFPub.setContentType(pSSysSFPub2.getContentType());
        }
        if (StringHelper.isNullOrEmpty((String)pSSysSFPub.getContentType())) {
            pSSysSFPub.setContentType("CODE");
        }
        if (StringHelper.compare((String)pSSysSFPub.getContentType(), (String)"DOC", (boolean)true) == 0) {
            pSSysSFPub.setPSSFStyleId(pSSysSFPub.getDocPSSFStyleId());
            pSSysSFPub.setPSSFStyleName(pSSysSFPub.getDocPSSFStyleName());
        }
        this.syncPSSFStyle(pSSysSFPub);
        if (DataObject.getBoolValue((Integer)pSSysSFPub.getDefaultPub(), (boolean)false)) {
            pSSysSFPub2 = new PSSysSFPub();
            pSSysSFPub2.setPSSystemId(pSSysSFPub.getPSSystemId());
            pSSysSFPub2.setDefaultPub(1);
            if (this.existsData(pSSysSFPub2) && StringHelper.compare((String)pSSysSFPub2.getPSSysSFPubId(), (String)pSSysSFPub.getPSSysSFPubId(), (boolean)false) != 0) {
                pSSysSFPub2.setDefaultPub(0);
                this.update(pSSysSFPub2, false);
            }
        }
        super.onBeforeUpdate(pSSysSFPub);
    }

    @Override
    protected void onBeforeRemove(PSSysSFPub pSSysSFPub) throws Exception {
        String string;
        PSSysSFPub pSSysSFPub2 = (PSSysSFPub)this.getLast(pSSysSFPub);
        if (DataObject.getIntegerValue((Object)pSSysSFPub2.getRemoveFlag(), (Integer)0) != 1) {
            throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u540e\u53f0\u670d\u52a1[%1$s]\u5fc5\u987b\u8bbe\u7f6e\u4e3a[\u5141\u8bb8\u5220\u9664]\u624d\u80fd\u5220\u9664", (Object)pSSysSFPub2.getPSSysSFPubName()));
        }
        if (pSSysSFPub2.getPSSystem() != null && !StringHelper.isNullOrEmpty((String)(string = pSSysSFPub2.getPSSystem().getPSDevSlnSysId()))) {
            PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
            pSSysSFPub.copyTo((IDataObject)pSDevSlnSysSrv, false);
            pSDevSlnSysSrv.setPSDevSlnSysId(string);
            pSDevSlnSysSrvService.fillEntityKeyValue(pSDevSlnSysSrv);
            if (pSDevSlnSysSrvService.checkKey(pSDevSlnSysSrv) == 1) {
                pSDevSlnSysSrvService.remove(pSDevSlnSysSrv);
            }
        }
        super.onBeforeRemove(pSSysSFPub);
    }

    @Override
    protected void onAfterCreate(PSSysSFPub pSSysSFPub) throws Exception {
        String string;
        boolean bl = false;
        if (StringHelper.isNullOrEmpty((String)pSSysSFPub.getContentType()) || StringHelper.compare((String)pSSysSFPub.getContentType(), (String)"CODE", (boolean)true) == 0) {
            bl = true;
        }
        if (pSSysSFPub.isPSSFStyleIdDirty() && bl) {
            this.buildPSSysProject(pSSysSFPub);
        }
        if (pSSysSFPub.getPSSystem() != null && !StringHelper.isNullOrEmpty((String)(string = pSSysSFPub.getPSSystem().getPSDevSlnSysId())) && StringHelper.isNullOrEmpty((String)pSSysSFPub.getPPSSysSFPubId())) {
            PSDevSlnSysSrvService pSDevSlnSysSrvService = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
            pSSysSFPub.copyTo((IDataObject)pSDevSlnSysSrv, false);
            pSDevSlnSysSrv.setPSDevSlnSysId(string);
            pSDevSlnSysSrv.setPSDevSlnSysSrvName(pSSysSFPub.getPSSysSFPubName());
            pSDevSlnSysSrvService.save(pSDevSlnSysSrv, false);
        }
        super.onAfterCreate(pSSysSFPub);
    }

    @Override
    protected void onAfterUpdate(PSSysSFPub pSSysSFPub) throws Exception {
        Object object;
        Object object2;
        Object object3;
        String string = null;
        if (pSSysSFPub.isContentTypeDirty()) {
            string = pSSysSFPub.getContentType();
        } else {
            PSSysSFPub pSSysSFPub2 = (PSSysSFPub)this.getLast(pSSysSFPub);
            string = pSSysSFPub2.getContentType();
        }
        boolean bl = false;
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"CODE", (boolean)true) == 0) {
            bl = true;
        }
        if (pSSysSFPub.isPSSFStyleIdDirty() && bl) {
            object3 = pSSysSFPub;
            if (StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSystemId()) || StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSystemName()) || StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSysSFPubId()) || StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSysSFPubName()) || StringHelper.isNullOrEmpty((String)pSSysSFPub.getCodeName())) {
                object2 = (PSSysSFPub)this.getLast(pSSysSFPub);
                object3 = new PSSysSFPub();
                ((PSSysSFPub)object2).copyTo((IDataObject)object3, false);
                pSSysSFPub.copyTo((IDataObject)object3, false);
            }
            this.buildPSSysProject((PSSysSFPub)object3);
        }
        object3 = null;
        object2 = pSSysSFPub.getPPSSysSFPubId();
        if (pSSysSFPub.getPSSystem() != null) {
            object3 = pSSysSFPub.getPSSystem().getPSDevSlnSysId();
        } else {
            object = (PSSysSFPub)this.getLast(pSSysSFPub);
            if (((PSSysSFPubBase)object).getPSSystem() != null) {
                object3 = ((PSSysSFPubBase)object).getPSSystem().getPSDevSlnSysId();
            }
        }
        if (StringHelper.isNullOrEmpty((String)object2)) {
            object = (PSSysSFPub)this.getLast(pSSysSFPub);
            object2 = ((PSSysSFPubBase)object).getPPSSysSFPubId();
        }
        if (!StringHelper.isNullOrEmpty((String)object3) && StringHelper.isNullOrEmpty((String)object2)) {
            PSDevSlnSysSrvService service = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysSrv pSDevSlnSysSrv = new PSDevSlnSysSrv();
            pSSysSFPub.copyTo((IDataObject)pSDevSlnSysSrv, false);
            pSDevSlnSysSrv.setPSDevSlnSysId((String)object3);
            if (!StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSysSFPubName())) {
                pSDevSlnSysSrv.setPSDevSlnSysSrvName(pSSysSFPub.getPSSysSFPubName());
            }
            service.save(pSDevSlnSysSrv, false);
        }
        super.onAfterUpdate(pSSysSFPub);
    }

    protected void buildPSSysProject(PSSysSFPub pSSysSFPub) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSFStyleId())) {
            PSSysProjectService pSSysProjectService = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysProject> arrayList = pSSysSFPub.getPSSysProjects();
            for (PSSysProject pSSysProject : arrayList) {
                pSSysProjectService.remove(pSSysProject);
            }
        } else {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSSFStyle pSSFStyle = new PSSFStyle();
            pSSFStyle.setPSSFStyleId(pSSysSFPub.getPSSFStyleId());
            pSSFStyleService.get(pSSFStyle);
            ArrayList<PSSFStylePrj> arrayList = pSSFStyle.getPSSFStylePrjs();
            PSSysProjectService pSSysProjectService = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysProject> arrayList2 = pSSysSFPub.getPSSysProjects();
            HashMap<String, PSSysProject> hashMap = new HashMap<String, PSSysProject>();
            for (PSSysProject entityBase : arrayList2) {
                hashMap.put(entityBase.getPSSysProjectId(), entityBase);
            }
            for (PSSFStylePrj pSSFStylePrj : arrayList) {
                PSSysProject pSSysProject = new PSSysProject();
                pSSysProject.setPSSysProjectName(pSSFStylePrj.getNameFmt().replace("_SYSSFPUBNAME_", pSSysSFPub.getCodeName()));
                pSSysProject.setPSSystemId(pSSysSFPub.getPSSystemId());
                pSSysProject.setPSSystemName(pSSysSFPub.getPSSystemName());
                pSSysProject.setPrjType(pSSFStylePrj.getPrjType());
                pSSysProject.setReadOnlyMode(pSSFStylePrj.getReadOnlyMode());
                pSSysProject.setPSObjType("PSSYSSFPUB");
                pSSysProject.setPSSysSFPubId(pSSysSFPub.getPSSysSFPubId());
                pSSysProject.setPSSysSFPubName(pSSysSFPub.getPSSysSFPubName());
                pSSysProject.setPSObjId(pSSysSFPub.getPSSysSFPubId());
                pSSysProject.setPSObjName(pSSysSFPub.getPSSysSFPubName());
                pSSysProjectService.save(pSSysProject);
                hashMap.remove(pSSysProject.getPSSysProjectId());
            }
            for (PSSysProject pSSysProject : hashMap.values()) {
                pSSysProjectService.remove(pSSysProject);
            }
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected void syncPSSFStyle(PSSysSFPub pSSysSFPub) throws Exception {
        this.syncPSSFStyle2(pSSysSFPub);
        this.syncPSSFStyleVer(pSSysSFPub);
    }

    protected void syncPSSFStyle2(PSSysSFPub pSSysSFPub) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSFStyleId())) {
            return;
        }
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
        PSSFStyle pSSFStyle = new PSSFStyle();
        pSSFStyle.setPSSFStyleId(pSSysSFPub.getPSSFStyleId());
        if (pSSFStyleService.get(pSSFStyle, true)) {
            return;
        }
        PSSFStyleService pSSFStyleService2 = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSFStyle pSSFStyle2 = new PSSFStyle();
        pSSFStyle2.setPSSFStyleId(pSSysSFPub.getPSSFStyleId());
        if (!pSSFStyleService2.get(pSSFStyle2, true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u6a21\u677f\u6837\u5f0f[%1$s]", (Object)pSSysSFPub.getPSSFStyleId()));
        }
        PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
        PSSF pSSF = new PSSF();
        pSSF.setPSSFId(pSSFStyle2.getPSSFId());
        if (!pSSFService.get(pSSF, true)) {
            PSSFService pSSFService2 = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSSF pSSF2 = new PSSF();
            pSSF2.setPSSFId(pSSFStyle2.getPSSFId());
            if (!pSSFService2.get(pSSF2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u6a21\u677f[%1$s]", (Object)pSSFStyle2.getPSSFId()));
            }
            pSSF.setPSSFId(pSSF2.getPSSFId());
            pSSF.setPSSFName(pSSF2.getPSSFName());
            pSSF.setCodeFlag(pSSF2.getCodeFlag());
            pSSF.setDocFlag(pSSF2.getDocFlag());
            pSSF.setValidFlag(1);
            pSSFService.create(pSSF);
        }
        pSSFStyle.setPSSFStyleId(pSSFStyle2.getPSSFStyleId());
        pSSFStyle.setPSSFStyleName(pSSFStyle2.getPSSFStyleName());
        pSSFStyle.setPSSFId(pSSFStyle2.getPSSFId());
        pSSFStyle.setPSSFName(pSSFStyle2.getPSSFName());
        pSSFStyle.setStyleEngine(pSSFStyle2.getStyleEngine());
        pSSFStyleService.create(pSSFStyle);
    }

    protected void syncPSSFStyleVer(PSSysSFPub pSSysSFPub) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysSFPub.getPSSFStyleVerId())) {
            return;
        }
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        PSSFStyleVerService pSSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)this.getSessionFactory());
        PSSFStyleVer pSSFStyleVer = new PSSFStyleVer();
        pSSFStyleVer.setPSSFStyleVerId(pSSysSFPub.getPSSFStyleVerId());
        if (pSSFStyleVerService.get(pSSFStyleVer, true)) {
            return;
        }
        PSSFStyleVerService pSSFStyleVerService2 = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSFStyleVer pSSFStyleVer2 = new PSSFStyleVer();
        pSSFStyleVer2.setPSSFStyleVerId(pSSysSFPub.getPSSFStyleVerId());
        if (!pSSFStyleVerService2.get(pSSFStyleVer2, true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u540e\u53f0\u6a21\u677f\u6837\u5f0f\u7248\u672c[%1$s]", (Object)pSSysSFPub.getPSSFStyleVerId()));
        }
        pSSFStyleVer.setPSSFStyleVerId(pSSFStyleVer2.getPSSFStyleVerId());
        pSSFStyleVer.setPSSFStyleVerName(pSSFStyleVer2.getPSSFStyleVerName());
        pSSFStyleVer.setPSSFId(pSSFStyleVer2.getPSSFId());
        pSSFStyleVer.setPSSFStyleId(pSSFStyleVer2.getPSSFStyleId());
        pSSFStyleVer.setPSSFStyleName(pSSFStyleVer2.getPSSFStyleName());
        pSSFStyleVerService.create(pSSFStyleVer);
    }
}
