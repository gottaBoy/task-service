/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstRef;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstRefService;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWProject;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWProjectServiceBase;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.pscore.srv.util.PSStudioEnvHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSUWProjectService
extends PSUWProjectServiceBase {
    private static final Log log = LogFactory.getLog(PSUWProjectService.class);

    @Override
    protected void onBeforeCreate(PSUWProject pSUWProject) throws Exception {
        super.onBeforeCreate(pSUWProject);
    }

    @Override
    protected void onAfterCreate(PSUWProject pSUWProject) throws Exception {
        super.onAfterCreate(pSUWProject);
    }

    @Override
    protected void onFinish(PSUWProject pSUWProject) throws Exception {
        if (this.isMajorSessionFactory()) {
            if (!this.get((IEntity)pSUWProject, true)) {
                throw new Exception(StringHelper.format((String)"\u6307\u5b9a\u9879\u76ee\u5411\u5bfc\u65e0\u6548"));
            }
            if (DataObject.getIntegerValue((Object)pSUWProject.getWizardState(), (Integer)10) != 10) {
                throw new Exception(StringHelper.format((String)"\u6307\u5b9a\u9879\u76ee\u5411\u5bfc\u72b6\u6001\u4e0d\u6b63\u786e"));
            }
            PSDevCenter pSDevCenter = new PSDevCenter();
            pSDevCenter.setPSDevCenterId(pSUWProject.getPSDevCenterId());
            pSDevCenter.setPSDevCenterName(pSUWProject.getPSDevCenterName());
            PSDCWorkspace pSDCWorkspace = null;
            if (!(StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKSYS", (boolean)false) != 0 && StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"ADVANCESYS", (boolean)false) != 0 || StringHelper.isNullOrEmpty((String)pSUWProject.getPSDCWorkspaceId()))) {
                pSDCWorkspace = PSDevCenterHelper.getPSDCWorkspace(pSDevCenter, pSUWProject.getPSDCWorkspaceId(), true, false);
            }
            PSDevSln pSDevSln = null;
            if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKSYS", (boolean)false) == 0 || StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"ADVANCESYS", (boolean)false) == 0) {
                pSDevSln = this.getPSDevSln(pSUWProject);
                this.createPSDevSlnSys(pSDevSln, pSUWProject);
            } else if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKSF", (boolean)false) == 0 || StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKPF", (boolean)false) == 0) {
                pSDevSln = this.getPSDevSln(pSUWProject);
                this.createPSDevSlnTempl(pSDevSln, pSUWProject);
            } else if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKDYNAINST", (boolean)false) == 0) {
                pSDevSln = this.getPSDevSln(pSUWProject);
                this.createPSDevSlnSysDynaInst(pSDevSln, pSUWProject);
            } else if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"APPLYDYNAMODELRES", (boolean)false) == 0) {
                this.applyDynaModelRes(pSUWProject);
            } else if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"APPLYDYNAINST", (boolean)false) == 0) {
                this.applyDynaInst(pSUWProject);
            } else if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"RECOMMANDINSTTEMPL", (boolean)false) == 0) {
                this.recommandInstTempl(pSUWProject);
            } else {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5411\u5bfc\u6a21\u5f0f[%1$s]", (Object)pSUWProject.getWizardMode()));
            }
            pSUWProject.setWizardState(20);
            if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKSYS", (boolean)false) == 0 || StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"ADVANCESYS", (boolean)false) == 0) {
                pSUWProject.setWizardState(30);
                if (pSDCWorkspace != null) {
                    PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
                    PSDCWorkspace pSDCWorkspace2 = new PSDCWorkspace();
                    pSDCWorkspace2.setPSDCWorkspaceId(pSDCWorkspace.getPSDCWorkspaceId());
                    pSDCWorkspace.setPSDevCenterId(pSDCWorkspace.getPSDevCenterId());
                    pSDCWorkspace2.setPSDevSlnId(pSUWProject.getPSDevSlnId());
                    pSDCWorkspace2.setPSDevSlnSysId(pSUWProject.getRealProjectId());
                    pSDCWorkspace2.setActionParam("PSUWPROJECT");
                    pSDCWorkspace2.setActionParam2(pSUWProject.getPSUWProjectId());
                    pSDCWorkspaceService.installSys(pSDCWorkspace2);
                }
            } else if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKSF", (boolean)false) == 0 || StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKPF", (boolean)false) == 0) {
                log.info((Object)StringHelper.format((String)"\u5f00\u53d1\u6a21\u677f\u5411\u5bfc[%1$s]", (Object)pSUWProject.getSource()));
                if (!StringHelper.isNullOrEmpty((String)pSUWProject.getSource())) {
                    final PSUWProject pSUWProject2 = pSUWProject;
                    SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

                        public void commit() {
                            try {
                                log.info((Object)StringHelper.format((String)"\u51c6\u5907\u542f\u52a8\u5f00\u53d1\u6a21\u677f\u5411\u5bfc[%1$s]\u540e\u53f0\u4efb\u52a1", (Object)pSUWProject2.getSource()));
                                PSUWProjectService.this.executeAction("X2_ADDDCBKTASK", (IEntity)pSUWProject2);
                            }
                            catch (Exception exception) {
                                log.error((Object)exception);
                            }
                        }

                        public void rollback() {
                        }
                    });
                }
            } else {
                log.info((Object)StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u5411\u5bfc[%1$s]", (Object)pSUWProject.getSource()));
            }
            this.update(pSUWProject, true);
        }
    }

    protected PSDevSlnSysDynaInst createPSDevSlnSysDynaInst(PSDevSln pSDevSln, PSUWProject pSUWProject) throws Exception {
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        pSDevSlnSysDynaInst.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnSysDynaInst.setPSDevSlnName(pSDevSln.getPSDevSlnName());
        pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstName(pSUWProject.getProjectName());
        pSDevSlnSysDynaInst.setPSDevCenterId(pSUWProject.getPSDevCenterId());
        pSDevSlnSysDynaInst.setPSDevCenterName(pSUWProject.getPSDevCenterName());
        pSDevSlnSysDynaInst.setMemo(pSUWProject.getMemo());
        pSDevSlnSysDynaInst.setInstState(30);
        pSDevSlnSysDynaInst.setInstType("DEFAULT");
        PSDevSlnSysDepInst pSDevSlnSysDepInst = new PSDevSlnSysDepInst();
        pSDevSlnSysDepInst.setInstTag4(pSUWProject.getSource());
        PSDevSlnSysDepInstService pSDevSlnSysDepInstService = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)this.getSessionFactory());
        pSDevSlnSysDepInstService.select(pSDevSlnSysDepInst, false);
        pSDevSlnSysDynaInst.setPSDevSlnSysDepInstId(pSDevSlnSysDepInst.getPSDevSlnSysDepInstId());
        PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        try {
            pSDevSlnSysDynaInstService.create(pSDevSlnSysDynaInst);
            pSUWProject.setRealProjectId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            String string = pSUWProject.getWizardParam();
            if (!StringHelper.isNullOrEmpty((String)string)) {
                // empty if block
            }
            return pSDevSlnSysDynaInst;
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage(), (Object)exception));
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u52a8\u6001\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage(), (Object)exception));
        }
    }

    protected PSDevSlnTempl createPSDevSlnTempl(PSDevSln pSDevSln, PSUWProject pSUWProject) throws Exception {
        PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
        pSDevSlnTempl.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnTempl.setPSDevSlnName(pSDevSln.getPSDevSlnName());
        if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKSF", (boolean)false) == 0) {
            pSDevSlnTempl.setTemplType("PSSF");
            if (StringHelper.isNullOrEmpty((String)pSUWProject.getPSSFId())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u540e\u53f0\u6a21\u677f");
            }
            pSDevSlnTempl.setPSSFId(pSUWProject.getPSSFId());
        } else if (StringHelper.compare((String)pSUWProject.getWizardMode(), (String)"QUICKPF", (boolean)false) == 0) {
            pSDevSlnTempl.setTemplType("PSPF");
            if (StringHelper.isNullOrEmpty((String)pSUWProject.getPSPFId())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u524d\u7aef\u6a21\u677f");
            }
            pSDevSlnTempl.setPSPFId(pSUWProject.getPSPFId());
        }
        pSDevSlnTempl.setPSDevSlnTemplName(pSUWProject.getProjectName());
        pSDevSlnTempl.setLogicName(pSUWProject.getPSUWProjectName());
        pSDevSlnTempl.setMemo(pSUWProject.getMemo());
        PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        try {
            pSDevSlnTemplService.create(pSDevSlnTempl);
            pSUWProject.setRealProjectId(pSDevSlnTempl.getPSDevSlnTemplId());
            return pSDevSlnTempl;
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage(), (Object)exception));
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage(), (Object)exception));
        }
    }

    protected PSDevSlnSys createPSDevSlnSys(PSDevSln pSDevSln, PSUWProject pSUWProject) throws Exception {
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnSys.setPSDevSlnName(pSDevSln.getPSDevSlnName());
        pSDevSlnSys.setLogicName(pSUWProject.getPSUWProjectName());
        pSDevSlnSys.setPSDevSlnSysName(pSUWProject.getProjectName());
        pSDevSlnSys.setCodeName(pSUWProject.getCodeName());
        if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getCodeName())) {
            pSDevSlnSys.setCodeName(pSUWProject.getProjectName());
        }
        pSDevSlnSys.setPSSFId(pSUWProject.getPSSFId());
        pSDevSlnSys.setPSSFName(pSUWProject.getPSSFName());
        pSDevSlnSys.setMemo(pSUWProject.getMemo());
        pSDevSlnSys.setTemplEngine("V2");
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        try {
            pSDevSlnSysService.create(pSDevSlnSys);
            pSUWProject.setRealProjectId(pSDevSlnSys.getPSDevSlnSysId());
            return pSDevSlnSys;
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage(), (Object)exception));
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage(), (Object)exception));
        }
    }

    protected PSDevSln getPSDevSln(PSUWProject pSUWProject) throws Exception {
        PSDevSln pSDevSln = new PSDevSln();
        PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
        if (!StringHelper.isNullOrEmpty((String)pSUWProject.getPSDevSlnId())) {
            pSDevSln.setPSDevCenterId(pSUWProject.getPSDevCenterId());
            pSDevSln.setPSDevSlnId(pSUWProject.getPSDevSlnId());
            if (!pSDevSlnService.select(pSDevSln, true)) {
                throw new Exception("\u6307\u5b9a\u5f00\u53d1\u65b9\u6848\u4e0d\u5b58\u5728");
            }
            return pSDevSln;
        }
        if (!StringHelper.isNullOrEmpty((String)pSUWProject.getPSDevSlnName())) {
            pSDevSln.setPSDevCenterId(pSUWProject.getPSDevCenterId());
            pSDevSln.setPSDevSlnName(pSUWProject.getPSDevSlnName());
            if (pSDevSlnService.select(pSDevSln, true)) {
                return pSDevSln;
            }
        }
        try {
            pSDevSlnService.create(pSDevSln);
            pSUWProject.setPSDevSlnId(pSDevSln.getPSDevSlnId());
            return pSDevSln;
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage(), (Object)exception));
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage(), (Object)exception));
        }
    }

    protected void applyDynaModelRes(PSUWProject pSUWProject) throws Exception {
        boolean bl;
        String string = pSUWProject.getWizardParam();
        String string2 = pSUWProject.getWizardParam2();
        boolean bl2 = bl = StringHelper.compare((String)"replace", (String)string2, (boolean)true) == 0;
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b\u6807\u8bc6", new Object[0]));
        }
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(string);
        PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst, true)) {
            log.error((Object)String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]", string));
            throw new Exception("\u4f20\u5165\u52a8\u6001\u5b9e\u4f8b\u65e0\u6548");
        }
        if (StringHelper.compare((String)pSUWProject.getPSDevCenterId(), (String)pSDevSlnSysDynaInst.getPSDevCenterId(), (boolean)false) != 0) {
            log.error((Object)String.format("\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]\u5e94\u7528\u4e2d\u5fc3[%2$s]\u4e0e\u4f5c\u4e1a\u5411\u5bfc\u4e2d\u5fc3[%3$s]\u4e0d\u4e00\u81f4", string, pSDevSlnSysDynaInst.getPSDevCenterId(), pSUWProject.getPSDevCenterId()));
            throw new Exception("\u4f20\u5165\u52a8\u6001\u5b9e\u4f8b\u65e0\u6548");
        }
        pSDevSlnSysDynaInstService.checkOutModel(pSDevSlnSysDynaInst);
        try {
            String string3 = PSDevSlnSysDynaInstService.getPSDynaInstModelFolder(pSDevSlnSysDynaInst);
            String string4 = "";
            string4 = PSStudioEnvHelper.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$sdynainsthelp.py %3$s %4$s %5$s %6$s %7$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string3, (Object)"7z", (Object)pSUWProject.getSource(), (Object)PSStudioEnvHelper.getCurrent().getTempFolder(), (Object)bl) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$sdynainsthelp.py %3$s %4$s %5$s %6$s %7$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string3, (Object)"7z", (Object)pSUWProject.getSource(), (Object)PSStudioEnvHelper.getCurrent().getTempFolder(), (Object)bl);
            PSStudioEnvHelper.Result result = PSStudioEnvHelper.getCurrent().executeBat(string4);
        }
        catch (Exception exception) {
            try {
                pSDevSlnSysDynaInstService.checkOutModel(pSDevSlnSysDynaInst);
            }
            catch (Exception exception2) {
                log.error((Object)String.format("\u7b7e\u51fa\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception2.getMessage()), (Throwable)exception2);
            }
            log.error((Object)String.format("\u6267\u884c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u5408\u5e76\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
            throw new Exception(String.format("\u6267\u884c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u5408\u5e76\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()));
        }
        pSDevSlnSysDynaInstService.checkInModel(pSDevSlnSysDynaInst);
    }

    protected void applyDynaInst(PSUWProject pSUWProject) throws Exception {
        boolean bl;
        String string = pSUWProject.getWizardParam();
        String string2 = pSUWProject.getWizardParam2();
        boolean bl2 = bl = StringHelper.compare((String)"replace", (String)string2, (boolean)true) == 0;
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b\u6807\u8bc6", new Object[0]));
        }
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(string);
        PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst, true)) {
            log.error((Object)String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]", string));
            throw new Exception("\u4f20\u5165\u52a8\u6001\u5b9e\u4f8b\u65e0\u6548");
        }
        if (StringHelper.compare((String)pSUWProject.getPSDevCenterId(), (String)pSDevSlnSysDynaInst.getPSDevCenterId(), (boolean)false) != 0) {
            log.error((Object)String.format("\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b[%1$s]\u5e94\u7528\u4e2d\u5fc3[%2$s]\u4e0e\u4f5c\u4e1a\u5411\u5bfc\u4e2d\u5fc3[%3$s]\u4e0d\u4e00\u81f4", string, pSDevSlnSysDynaInst.getPSDevCenterId(), pSUWProject.getPSDevCenterId()));
            throw new Exception("\u4f20\u5165\u52a8\u6001\u5b9e\u4f8b\u65e0\u6548");
        }
        if ("MODULE".equals(pSDevSlnSysDynaInst.getInstType())) {
            pSDevSlnSysDynaInstService.checkOutModel(pSDevSlnSysDynaInst);
            try {
                String string3 = PSDevSlnSysDynaInstService.getPSDynaInstModelFolder(pSDevSlnSysDynaInst);
                String string4 = "";
                string4 = PSStudioEnvHelper.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$sdynainsthelp.py %3$s %4$s %5$s %6$s %7$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string3, (Object)"7z", (Object)pSUWProject.getSource(), (Object)PSStudioEnvHelper.getCurrent().getTempFolder(), (Object)bl) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$sdynainsthelp.py %3$s %4$s %5$s %6$s %7$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string3, (Object)"7z", (Object)pSUWProject.getSource(), (Object)PSStudioEnvHelper.getCurrent().getTempFolder(), (Object)bl);
                PSStudioEnvHelper.Result result = PSStudioEnvHelper.getCurrent().executeBat(string4);
            }
            catch (Exception exception) {
                try {
                    pSDevSlnSysDynaInstService.checkOutModel(pSDevSlnSysDynaInst);
                }
                catch (Exception exception2) {
                    log.error((Object)String.format("\u7b7e\u51fa\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception2.getMessage()), (Throwable)exception2);
                }
                log.error((Object)String.format("\u6267\u884c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u5408\u5e76\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
                throw new Exception(String.format("\u6267\u884c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u5408\u5e76\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()));
            }
            pSDevSlnSysDynaInstService.checkInModel(pSDevSlnSysDynaInst);
        } else {
            Object object;
            Object object2;
            ArrayList<PSDevSlnSysDynaInst> arrayList = pSDevSlnSysDynaInstService.selectByPPSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
            ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)pSUWProject.getSource());
            String string5 = JsonNodeHelper.getString((ObjectNode)objectNode, (String)"PSDevSlnSysDynaInstId", null);
            if (!StringHelper.isNullOrEmpty((String)string5)) {
                pSDevSlnSysDynaInstService.checkOutModel(pSDevSlnSysDynaInst);
                try {
                    object2 = PSDevSlnSysDynaInstService.getPSDynaInstModelFolder(pSDevSlnSysDynaInst);
                    String string6 = "";
                    string6 = PSStudioEnvHelper.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$sdynainsthelp.py %3$s %4$s %5$s %6$s %7$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)object2, (Object)"7z", (Object)string5, (Object)PSStudioEnvHelper.getCurrent().getTempFolder(), (Object)bl) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$sdynainsthelp.py %3$s %4$s %5$s %6$s %7$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)object2, (Object)"7z", (Object)string5, (Object)PSStudioEnvHelper.getCurrent().getTempFolder(), (Object)bl);
                    object = PSStudioEnvHelper.getCurrent().executeBat(string6);
                }
                catch (Exception exception) {
                    try {
                        pSDevSlnSysDynaInstService.checkOutModel(pSDevSlnSysDynaInst);
                    }
                    catch (Exception exception3) {
                        log.error((Object)String.format("\u7b7e\u51fa\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception3.getMessage()), (Throwable)exception3);
                    }
                    log.error((Object)String.format("\u6267\u884c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u5408\u5e76\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
                    throw new Exception(String.format("\u6267\u884c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u5408\u5e76\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()));
                }
                pSDevSlnSysDynaInstService.checkInModel(pSDevSlnSysDynaInst);
            }
            if ((object2 = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)"PSDevSlnSysDynaInsts")) != null) {
                for (int i = 0; i < object2.size(); ++i) {
                    object = (ObjectNode)object2.get(i);
                    String string7 = JsonNodeHelper.getString((ObjectNode)object, (String)"InstTag", (String)"");
                    String string8 = JsonNodeHelper.getString((ObjectNode)object, (String)"InstTag2", (String)"");
                    PSDevSlnSysDynaInst object4 = null;
                    for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 : arrayList) {
                        if (StringHelper.compare((String)string7, (String)pSDevSlnSysDynaInst2.getInstTag(), (boolean)false) != 0 || StringHelper.compare((String)string8, (String)pSDevSlnSysDynaInst2.getInstTag2(), (boolean)false) != 0) continue;
                        object4 = pSDevSlnSysDynaInst2;
                        break;
                    }
                    String string9 = JsonNodeHelper.getString((ObjectNode)object, (String)"PSDevSlnSysDynaInstId", null);
                    String object32 = JsonNodeHelper.getString((ObjectNode)object, (String)"PSDevSlnSysDynaInstName", null);
                    if (object4 == null) {
                        object4 = new PSDevSlnSysDynaInst();
                        object4.setPSDevCenterId(pSDevSlnSysDynaInst.getPSDevCenterId());
                        object4.setPSDevCenterName(pSDevSlnSysDynaInst.getPSDevCenterName());
                        object4.setPPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
                        object4.setPPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
                        object4.setPSDevSlnSysDynaInstName(object32);
                        object4.setInstType("MODULE");
                        object4.setInstTag(string7);
                        object4.setInstTag2(string8);
                        pSDevSlnSysDynaInstService.create(object4);
                    }
                    if (StringHelper.isNullOrEmpty((String)string9)) continue;
                    pSDevSlnSysDynaInstService.checkOutModel(object4);
                    try {
                        String string3 = PSDevSlnSysDynaInstService.getPSDynaInstModelFolder(object4);
                        String string4 = "";
                        string4 = PSStudioEnvHelper.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$sdynainsthelp.py %3$s %4$s %5$s %6$s %7$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string3, (Object)"7z", (Object)string9, (Object)PSStudioEnvHelper.getCurrent().getTempFolder(), (Object)bl) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$sdynainsthelp.py %3$s %4$s %5$s %6$s %7$s", (Object)PSStudioEnvHelper.getCurrent().getToolFolder(), (Object)File.separator, (Object)string3, (Object)"7z", (Object)string9, (Object)PSStudioEnvHelper.getCurrent().getTempFolder(), (Object)bl);
                        PSStudioEnvHelper.Result result = PSStudioEnvHelper.getCurrent().executeBat(string4);
                    }
                    catch (Exception exception) {
                        try {
                            pSDevSlnSysDynaInstService.checkOutModel(pSDevSlnSysDynaInst);
                        }
                        catch (Exception exception2) {
                            log.error((Object)String.format("\u7b7e\u51fa\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception2.getMessage()), (Throwable)exception2);
                        }
                        log.error((Object)String.format("\u6267\u884c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u5408\u5e76\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
                        throw new Exception(String.format("\u6267\u884c\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u5408\u5e76\u4f5c\u4e1a\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()));
                    }
                    pSDevSlnSysDynaInstService.checkInModel(object4);
                }
            }
        }
    }

    protected void recommandInstTempl(PSUWProject pSUWProject) throws Exception {
        String string = pSUWProject.getWizardParam();
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b\u6807\u8bc6", new Object[0]));
        }
        PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(string);
        if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst, true)) {
            throw new Exception(String.format("\u52a8\u6001\u5b9e\u4f8b\u4e0d\u5b58\u5728", new Object[0]));
        }
        String string2 = pSUWProject.getSource();
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = new PSDevSlnSysDynaInst();
        pSDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(string2);
        if (!pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst2, true)) {
            throw new Exception(String.format("\u5f15\u7528\u5b9e\u4f8b\u6a21\u677f\u4e0d\u5b58\u5728", new Object[0]));
        }
        if (!("CONFTEMPL".equals(pSDevSlnSysDynaInst2.getInstType()) || "MODULETEMPL".equals(pSDevSlnSysDynaInst2.getInstType()) || "MISCTEMPL".equals(pSDevSlnSysDynaInst2.getInstType()))) {
            throw new Exception(String.format("\u5f15\u7528\u5b9e\u4f8b\u975e\u6a21\u677f\u5b9e\u4f8b", new Object[0]));
        }
        PSDevSlnSysDynaInstRefService pSDevSlnSysDynaInstRefService = (PSDevSlnSysDynaInstRefService)ServiceGlobal.getService(PSDevSlnSysDynaInstRefService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef = new PSDevSlnSysDynaInstRef();
        pSDevSlnSysDynaInstRef.setPSDevSlnSysDynaInstRefName(pSUWProject.getPSUWProjectName());
        pSDevSlnSysDynaInstRef.setPSDevSlnSysDynaInstId(string);
        pSDevSlnSysDynaInstRef.setPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
        pSDevSlnSysDynaInstRef.setRefPSDevSlnSysDynaInstId(string2);
        pSDevSlnSysDynaInstRef.setRefPSDevSlnSysDynaInstName(pSDevSlnSysDynaInst2.getPSDevSlnSysDynaInstName());
        pSDevSlnSysDynaInstRef.setRefTag(pSUWProject.getWizardParam2());
        pSDevSlnSysDynaInstRef.setOrderValue(pSUWProject.getWizardParam5());
        pSDevSlnSysDynaInstRefService.create(pSDevSlnSysDynaInstRef);
    }
}

