/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dynasys.service;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstRef;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSDevCenterSVNHelper;
import net.ibizsys.pscore.srv.util.PSStudioEnvHelper;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabHelper;
import net.ibizsys.pscore.srv.util.gitlab.model.Group;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysDynaInstService
extends PSDevSlnSysDynaInstServiceBase {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstService.class);
    private static Map<String, PSDevSlnSysDynaInst> cachePSDevSlnSysDynaInstMap = new HashMap<String, PSDevSlnSysDynaInst>();

    @Override
    protected boolean isUpdateModelKeeper(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        return PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).isPSDevSlnSysDynaInstEnabled();
    }

    @Override
    protected void onUpdateModelKeeper(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final String string = pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId();
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                    pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(string);
                    PSDevSlnSysDynaInstService.this.get(pSDevSlnSysDynaInst);
                    PSCoreEntityKeeperGlobal.getCurrent(PSDevSlnSysDynaInstService.this.getSessionFactory()).updatePSDevSlnSysDynaInst(pSDevSlnSysDynaInst);
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }

            public void rollback() {
            }
        });
    }

    @Override
    protected void onRemoveModelKeeper(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        final String string = pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId();
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSCoreEntityKeeperGlobal.getCurrent(PSDevSlnSysDynaInstService.this.getSessionFactory()).resetPSDevSlnSysDynaInst(string);
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }

            public void rollback() {
            }
        });
    }

    @Override
    protected void onAfterCreate(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        this.initPSDynaInst(pSDevSlnSysDynaInst);
        super.onAfterCreate(pSDevSlnSysDynaInst);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        this.initPSDynaInst(pSDevSlnSysDynaInst);
        super.onAfterUpdate(pSDevSlnSysDynaInst);
    }

    @Override
    protected void onAfterRemove(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        super.onAfterRemove(pSDevSlnSysDynaInst);
    }

    protected void initPSDynaInst(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
    }

    @Override
    protected void internalCreate(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInst.getModelPSDevCenterSVNId()) && StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInst.getCfgPSDevCenterSVNId()) && PSDevSlnSysDynaInstService.isEnableGitLabPlugin()) {
            PSDevCenter pSDevCenter = pSDevSlnSysDynaInst.getPSDevCenter();
            if (pSDevCenter == null) {
                throw new Exception("\u7cfb\u7edf\u5e94\u7528\u4e2d\u5fc3\u65e0\u6548");
            }
            if (pSDevCenter.getV6PSSvnInstRepo() != null) {
                PSDevCenterSVN pSDevCenterSVN;
                Object object;
                PSDevSln pSDevSln = pSDevSlnSysDynaInst.getPSDevSln();
                if (pSDevSln == null) {
                    pSDevSln = new PSDevSln();
                    pSDevSln.setCodeName("DynaInst" + Long.toString(System.currentTimeMillis()));
                    pSDevSln.setPSDevSlnName(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstName());
                    pSDevSln.setPSDevCenterId(pSDevSlnSysDynaInst.getPSDevCenterId());
                    pSDevSln.setPSDevCenterName(pSDevSlnSysDynaInst.getPSDevCenterName());
                    pSDevSln.setSlnTag(pSDevCenter.getV6PSSvnInstRepo().getPSSVNServerId());
                    object = PSDevSlnSysDynaInstService.getPSGitLabPlugin().createGroupByPSDevSln(pSDevSln);
                    pSDevCenterSVN = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, (Group)object);
                    pSDevSln.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
                    pSDevSln.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterName());
                    pSDevSlnSysDynaInst.setInstTag3(pSDevSln.getSlnTag2());
                }
                object = PSDevSlnSysDynaInstService.getPSGitLabPlugin().createProjectByPSDevSlnSysDynaInst(pSDevSln, pSDevSlnSysDynaInst, true);
                pSDevCenterSVN = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, (Project)object);
                pSDevSlnSysDynaInst.setModelPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
                pSDevSlnSysDynaInst.setModelPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
                Project project = PSDevSlnSysDynaInstService.getPSGitLabPlugin().createProjectByPSDevSlnSysDynaInst(pSDevSln, pSDevSlnSysDynaInst, false);
                PSDevCenterSVN pSDevCenterSVN2 = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, project);
                pSDevSlnSysDynaInst.setCfgPSDevCenterSVNId(pSDevCenterSVN2.getPSDevCenterSVNId());
                pSDevSlnSysDynaInst.setCfgPSDevCenterSVNName(pSDevCenterSVN2.getPSDevCenterSVNName());
            }
        }
        super.internalCreate(pSDevSlnSysDynaInst);
    }

    @Override
    protected void onCheckOutModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        PSDevCenterSVN pSDevCenterSVN;
        if (!pSDevSlnSysDynaInst.isFullEntity()) {
            this.get(pSDevSlnSysDynaInst);
        }
        if ((pSDevCenterSVN = pSDevSlnSysDynaInst.getModelPSDevCenterSVN()) == null) {
            throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
        }
        String string = String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        PSDevCenterSVNHelper.getInstance().checkOut(pSDevCenterSVN, string);
    }

    @Override
    protected void onCheckInModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        PSDevCenterSVN pSDevCenterSVN;
        if (!pSDevSlnSysDynaInst.isFullEntity()) {
            this.get(pSDevSlnSysDynaInst);
        }
        if ((pSDevCenterSVN = pSDevSlnSysDynaInst.getModelPSDevCenterSVN()) == null) {
            throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b\u4ed3\u5e93\u65e0\u6548");
        }
        String string = String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        PSDevCenterSVNHelper.getInstance().checkIn(pSDevCenterSVN, string);
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = new PSDevSlnSysDynaInst();
        pSDevSlnSysDynaInst2.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        pSDevSlnSysDynaInst2.setLastCheckinTime(new Timestamp(System.currentTimeMillis()));
        this.sysUpdate(pSDevSlnSysDynaInst2, false);
    }

    @Override
    protected void onCheckOutCfg(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        PSDevCenterSVN pSDevCenterSVN;
        if (!pSDevSlnSysDynaInst.isFullEntity()) {
            this.get(pSDevSlnSysDynaInst);
        }
        if ((pSDevCenterSVN = pSDevSlnSysDynaInst.getCfgPSDevCenterSVN()) == null) {
            throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u914d\u7f6e\u4ed3\u5e93\u65e0\u6548");
        }
        String string = String.format("%1$s%2$sCFG%2$s%3$s", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        PSDevCenterSVNHelper.getInstance().checkOut(pSDevCenterSVN, string);
    }

    @Override
    protected void onCheckInCfg(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        PSDevCenterSVN pSDevCenterSVN;
        if (!pSDevSlnSysDynaInst.isFullEntity()) {
            this.get(pSDevSlnSysDynaInst);
        }
        if ((pSDevCenterSVN = pSDevSlnSysDynaInst.getCfgPSDevCenterSVN()) == null) {
            throw new Exception("\u52a8\u6001\u5b9e\u4f8b\u914d\u7f6e\u4ed3\u5e93\u65e0\u6548");
        }
        String string = String.format("%1$s%2$sCFG%2$s%3$s", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        PSDevCenterSVNHelper.getInstance().checkIn(pSDevCenterSVN, string);
    }

    public static String getPSDynaInstModelFolder(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) {
        return String.format("%1$s%2$s%3$s%2$sMODEL", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
    }

    public static String getPSDynaInstCfgFolder(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) {
        return String.format("%1$s%2$sCFG%2$s%3$s", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
    }

    @Override
    protected void onCheckOutAllModel(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        boolean bl = false;
        ActionSession actionSession = null;
        try {
            actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bl = true;
                actionSession = ActionSessionManager.openSession((String)"PSDevSlnSysDynaInstService");
                actionSession.registerRecursion("PSDEVSLNSYSDYNAINST", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            } else if (!actionSession.registerRecursion("PSDEVSLNSYSDYNAINST", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId())) {
                throw new Exception(StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b[%1$s]\u5b58\u5728\u9012\u5f52\u5f15\u7528", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId()));
            }
            this.onCheckOutAllModelReal(pSDevSlnSysDynaInst);
            actionSession.unregisterRecursion("PSDEVSLNSYSDYNAINST", (Object)pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            if (bl) {
                ActionSessionManager.closeSession();
            }
        }
        catch (Exception exception) {
            if (bl) {
                ActionSessionManager.closeSession();
            }
            throw exception;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onCheckOutAllModelReal(PSDevSlnSysDynaInst pSDevSlnSysDynaInst) throws Exception {
        String string = pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId();
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst2 = PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).getPSDevSlnSysDynaInst(string);
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst3 = cachePSDevSlnSysDynaInstMap.get(string);
        if (pSDevSlnSysDynaInst3 != null) {
            long l = -1L;
            long l2 = -1L;
            long l3 = -1L;
            long l4 = -1L;
            if (pSDevSlnSysDynaInst2.getLastCheckinTime() != null) {
                l = pSDevSlnSysDynaInst2.getLastCheckinTime().getTime();
            }
            if (pSDevSlnSysDynaInst3.getLastCheckinTime() != null) {
                l2 = pSDevSlnSysDynaInst3.getLastCheckinTime().getTime();
            }
            if (pSDevSlnSysDynaInst2.getRefUpdateDate() != null) {
                l3 = pSDevSlnSysDynaInst2.getRefUpdateDate().getTime();
            }
            if (pSDevSlnSysDynaInst3.getRefUpdateDate() != null) {
                l4 = pSDevSlnSysDynaInst3.getRefUpdateDate().getTime();
            }
            if (l != l2 || l3 != l4) {
                pSDevSlnSysDynaInst3 = null;
            }
        }
        if (pSDevSlnSysDynaInst3 == null) {
            pSDevSlnSysDynaInst3 = new PSDevSlnSysDynaInst();
            pSDevSlnSysDynaInst3.setPSDevSlnSysDynaInstId(string);
            this.get(pSDevSlnSysDynaInst3);
            if (StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInst3.getInstModelPath()) && !StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInst3.getModelPSDevCenterSVNId())) {
                this.checkOutModel(pSDevSlnSysDynaInst3);
                pSDevSlnSysDynaInst3.setInstModelPath(PSDevSlnSysDynaInstService.getPSDynaInstModelFolder(pSDevSlnSysDynaInst3));
            }
            if ("DEFAULT".equals(pSDevSlnSysDynaInst3.getInstType()) || "MODULE".equals(pSDevSlnSysDynaInst3.getInstType())) {
                ArrayList<PSDevSlnSysDynaInstRef> arrayList2 = pSDevSlnSysDynaInst3.getPSDevSlnSysDynaInstRefs();
                ArrayList<PSDevSlnSysDynaInstRef> arrayList3 = new ArrayList<PSDevSlnSysDynaInstRef>();
                for (PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef : arrayList2) {
                    if (!DataObject.getBoolValue((Integer)pSDevSlnSysDynaInstRef.getValidFlag(), (boolean)true)) continue;
                    arrayList3.add(pSDevSlnSysDynaInstRef);
                }
                Collections.sort(arrayList3, new Comparator<PSDevSlnSysDynaInstRef>(){

                    @Override
                    public int compare(PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef, PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef2) {
                        try {
                            Integer n = DataObject.getIntegerValue((Object)pSDevSlnSysDynaInstRef.getOrderValue(), (Integer)99999);
                            Integer n2 = DataObject.getIntegerValue((Object)pSDevSlnSysDynaInstRef2.getOrderValue(), (Integer)99999);
                            return n.compareTo(n2);
                        }
                        catch (Exception exception) {
                            log.error((Object)String.format("\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b\u5f15\u7528\u6392\u5e8f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), (Throwable)exception);
                            return 0;
                        }
                    }
                });
                pSDevSlnSysDynaInst3.getPSDevSlnSysDynaInstRefs().clear();
                pSDevSlnSysDynaInst3.getPSDevSlnSysDynaInstRefs().addAll(arrayList3);
                for (PSDevSlnSysDynaInstRef pSDevSlnSysDynaInstRef : arrayList3) {
                    PSDevSlnSysDynaInst pSDevSlnSysDynaInst4 = new PSDevSlnSysDynaInst();
                    pSDevSlnSysDynaInst4.setPSDevSlnSysDynaInstId(pSDevSlnSysDynaInstRef.getRefPSDevSlnSysDynaInstId());
                    this.checkOutAllModel(pSDevSlnSysDynaInst4);
                    if (StringHelper.isNullOrEmpty((String)pSDevSlnSysDynaInst4.getInstModelPath())) {
                        pSDevSlnSysDynaInstRef.setInstModelPath(PSDevSlnSysDynaInstService.getPSDynaInstModelFolder(pSDevSlnSysDynaInst4));
                        continue;
                    }
                    pSDevSlnSysDynaInstRef.setInstModelPath(pSDevSlnSysDynaInst4.getInstModelPath());
                }
            }
            pSDevSlnSysDynaInst3.setCreateDate(new Timestamp(System.currentTimeMillis()));
            Map<String, PSDevSlnSysDynaInst> map = cachePSDevSlnSysDynaInstMap;
            synchronized (map) {
                cachePSDevSlnSysDynaInstMap.put(string, pSDevSlnSysDynaInst3);
            }
        } else {
            pSDevSlnSysDynaInst3.setCreateDate(new Timestamp(System.currentTimeMillis()));
            if (("DEFAULT".equals(pSDevSlnSysDynaInst3.getInstType()) || "MODULE".equals(pSDevSlnSysDynaInst3.getInstType())) && pSDevSlnSysDynaInst3.getPSDevSlnSysDynaInstRefs() != null) {
                for (PSDevSlnSysDynaInstRef l : pSDevSlnSysDynaInst3.getPSDevSlnSysDynaInstRefs()) {
                    PSDevSlnSysDynaInst pSDevSlnSysDynaInst5 = new PSDevSlnSysDynaInst();
                    pSDevSlnSysDynaInst5.setPSDevSlnSysDynaInstId(l.getRefPSDevSlnSysDynaInstId());
                    this.checkOutAllModel(pSDevSlnSysDynaInst5);
                }
            }
        }
        if (cachePSDevSlnSysDynaInstMap.size() >= 200) {
            ArrayList<PSDevSlnSysDynaInst> arrayList4 = new ArrayList<PSDevSlnSysDynaInst>();
            Map<String, PSDevSlnSysDynaInst> map = cachePSDevSlnSysDynaInstMap;
            synchronized (map) {
                arrayList4.addAll(cachePSDevSlnSysDynaInstMap.values());
            }
            long l = System.currentTimeMillis() - 300000L;
            for (PSDevSlnSysDynaInst pSDevSlnSysDynaInst6 : arrayList4) {
                if (pSDevSlnSysDynaInst6.getCreateDate() != null && pSDevSlnSysDynaInst6.getCreateDate().getTime() >= l) continue;
                Map<String, PSDevSlnSysDynaInst> map2 = cachePSDevSlnSysDynaInstMap;
                synchronized (map2) {
                    cachePSDevSlnSysDynaInstMap.remove(pSDevSlnSysDynaInst6.getPSDevSlnSysDynaInstId());
                }
            }
        }
        pSDevSlnSysDynaInst.proxy((IDataObject)pSDevSlnSysDynaInst3);
    }
}

