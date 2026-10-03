/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplServiceBase;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabHelper;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnTemplService
extends PSDevSlnTemplServiceBase {
    private static Random random = new Random();
    private static final Log log = LogFactory.getLog(PSDevSlnTemplService.class);

    @Override
    public void update(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        super.update(pSDevSlnTempl, true);
    }

    @Override
    protected void onBeforeCreate(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if (this.isMajorSessionFactory()) {
            PSDevCenterHelper.testCreate(pSDevSlnTempl.getPSDevSln().getPSDevCenter(), "DEVTEMPLCNT", false);
            if (StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getStyleEngine())) {
                pSDevSlnTempl.setStyleEngine("V2");
            }
            if (pSDevSlnTempl.isEnableRefDirty() && DataObject.getBoolValue((Integer)pSDevSlnTempl.getEnableRef(), (boolean)false)) {
                pSDevSlnTempl.setRefCode(KeyValueHelper.genUniqueId((String)DateHelper.toDateTimeString((Date)new Date()), (String)KeyValueHelper.genGuidEx()));
            } else {
                pSDevSlnTempl.setRefCode(null);
            }
        }
        super.onBeforeCreate(pSDevSlnTempl);
    }

    @Override
    protected void onBeforeUpdate(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if (pSDevSlnTempl.isEnableRefDirty()) {
            if (DataObject.getBoolValue((Integer)pSDevSlnTempl.getEnableRef(), (boolean)false)) {
                PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getLast(pSDevSlnTempl);
                if (pSDevSlnTempl2 == null || StringHelper.isNullOrEmpty((String)pSDevSlnTempl2.getRefCode())) {
                    pSDevSlnTempl.setRefCode(KeyValueHelper.genUniqueId((String)DateHelper.toDateTimeString((Date)new Date()), (String)KeyValueHelper.genGuidEx()));
                }
            } else {
                pSDevSlnTempl.setRefCode(null);
            }
        }
        super.onBeforeUpdate(pSDevSlnTempl);
    }

    @Override
    protected void onAfterUpdate(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if (this.isMajorSessionFactory()) {
            this.syncTempl(pSDevSlnTempl);
        }
        super.onAfterUpdate(pSDevSlnTempl);
    }

    @Override
    protected void onAfterCreate(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if (this.isMajorSessionFactory()) {
            this.syncTempl(pSDevSlnTempl);
            PSDevCenterHelper.updatetPSDCResRep(pSDevSlnTempl.getPSDevSln().getPSDevCenter(), "DEVTEMPLCNT");
        }
        super.onAfterCreate(pSDevSlnTempl);
    }

    protected void syncTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if ("PSPF".equals(pSDevSlnTempl.getTemplType())) {
            if (StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSPFId())) {
                return;
            }
            PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
            if (StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSPFStyleId())) {
                Object object;
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFId(pSDevSlnTempl.getPSPFId());
                pSPFStyle.setPSPFName(pSDevSlnTempl.getPSPFName());
                pSPFStyle.setPSPFStyleId(StringHelper.format((String)"%1$s__%2$s", (Object)pSDevSlnTempl.getPSPFId(), (Object)pSDevSlnTempl.getPSDevSlnTemplId()));
                if (!StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getLogicName())) {
                    pSPFStyle.setPSPFStyleName(pSDevSlnTempl.getLogicName());
                } else {
                    pSPFStyle.setPSPFStyleName(pSDevSlnTempl.getPSDevSlnTemplName());
                }
                if (StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getStyleCode())) {
                    pSPFStyle.setDCStyleCode(StringHelper.format((String)"S%1$tY%1$tm%1$td%1$tH%1$tM%1$tS%2$s", (Object)new Date(), (Object)random.nextInt(10000)));
                } else {
                    pSPFStyle.setDCStyleCode(pSDevSlnTempl.getStyleCode().toUpperCase());
                }
                pSPFStyle.setStyleEngine(pSDevSlnTempl.getStyleEngine());
                pSPFStyle.setPSDevCenterId(pSDevSlnTempl.getPSDevCenterId());
                pSPFStyle.setPSDevCenterName(pSDevSlnTempl.getPSDevCenterName());
                pSPFStyle.setPubMode(2);
                pSPFStyle.setMemo(pSDevSlnTempl.getMemo());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(pSDevSlnTempl.getPSDevCenterId());
                pSDevCenterService.get(pSDevCenter);
                pSPFStyle.setV2Folder(StringHelper.format((String)"I:\\TEMPL\\PSPF\\%1$s\\%2$s\\%3$s", (Object)pSDevCenter.getDomainName(), (Object)pSDevSlnTempl.getPSDevSlnId(), (Object)pSDevSlnTempl.getPSDevSlnTemplName()));
                pSPFStyle.setV2Folder2(StringHelper.format((String)"/app/TEMPL/PSPF/%1$s/%2$s/%3$s", (Object)pSDevCenter.getDomainName(), (Object)pSDevSlnTempl.getPSDevSlnId(), (Object)pSDevSlnTempl.getPSDevSlnTemplName()));
                if (!StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSDevCenterSVNId())) {
                    object = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                    PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                    pSDevCenterSVN.setPSDevCenterSVNId(pSDevSlnTempl.getPSDevCenterSVNId());
                    ((PSDevCenterSVNService)object).get(pSDevCenterSVN);
                    String string = pSDevCenterSVN.getGitBranch();
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        string = "master";
                    }
                    pSPFStyle.setV2GitPath(StringHelper.format((String)"%3$s*%1$s*%2$s", (Object)pSDevCenterSVN.getGitPath(), (Object)pSDevSlnTempl.getPSDevSlnTemplName(), (Object)string));
                }
                pSPFStyle.setStyleResUrl(pSDevSlnTempl.getV2GitPath());
                pSPFStyleService.create(pSPFStyle);
                PSDevSlnTempl pSDevSlnTemplUpdate = new PSDevSlnTempl();
                pSDevSlnTemplUpdate.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
                pSDevSlnTemplUpdate.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                pSDevSlnTemplUpdate.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
                pSDevSlnTemplUpdate.setDevTemplState(30);
                this.sysUpdate(pSDevSlnTemplUpdate, false);
                pSDevSlnTempl.setPSPFStyleId(pSPFStyle.getPSPFStyleId());
                pSDevSlnTempl.setPSPFStyleName(pSPFStyle.getPSPFStyleName());
            } else {
                PSPFStyle pSPFStyle = new PSPFStyle();
                pSPFStyle.setPSPFStyleId(pSDevSlnTempl.getPSPFStyleId());
                pSPFStyle.setStyleResUrl(pSDevSlnTempl.getV2GitPath());
                if (!StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getLogicName())) {
                    pSPFStyle.setPSPFStyleName(pSDevSlnTempl.getLogicName());
                } else {
                    pSPFStyle.setPSPFStyleName(pSDevSlnTempl.getPSDevSlnTemplName());
                }
                pSPFStyle.setMemo(pSDevSlnTempl.getMemo());
                pSPFStyleService.update(pSPFStyle);
            }
        } else if ("PSSF".equals(pSDevSlnTempl.getTemplType())) {
            if (StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSSFId())) {
                return;
            }
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
            if (StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSSFStyleId())) {
                Object object;
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFId(pSDevSlnTempl.getPSSFId());
                pSSFStyle.setPSSFName(pSDevSlnTempl.getPSSFName());
                pSSFStyle.setPSSFStyleId(StringHelper.format((String)"%1$s__%2$s", (Object)pSDevSlnTempl.getPSSFId(), (Object)pSDevSlnTempl.getPSDevSlnTemplId()));
                if (!StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getLogicName())) {
                    pSSFStyle.setPSSFStyleName(pSDevSlnTempl.getLogicName());
                } else {
                    pSSFStyle.setPSSFStyleName(pSDevSlnTempl.getPSDevSlnTemplName());
                }
                pSSFStyle.setStyleEngine(pSDevSlnTempl.getStyleEngine());
                pSSFStyle.setPSDevCenterId(pSDevSlnTempl.getPSDevCenterId());
                pSSFStyle.setPSDevCenterName(pSDevSlnTempl.getPSDevCenterName());
                pSSFStyle.setPubMode(2);
                pSSFStyle.setMemo(pSDevSlnTempl.getMemo());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(pSDevSlnTempl.getPSDevCenterId());
                pSDevCenterService.get(pSDevCenter);
                pSSFStyle.setV2Folder(StringHelper.format((String)"I:\\TEMPL\\PSSF\\%1$s\\%2$s\\%3$s", (Object)pSDevCenter.getDomainName(), (Object)pSDevSlnTempl.getPSDevSlnId(), (Object)pSDevSlnTempl.getPSDevSlnTemplName()));
                pSSFStyle.setV2Folder2(StringHelper.format((String)"/app/TEMPL/PSSF/%1$s/%2$s/%3$s", (Object)pSDevCenter.getDomainName(), (Object)pSDevSlnTempl.getPSDevSlnId(), (Object)pSDevSlnTempl.getPSDevSlnTemplName()));
                if (!StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSDevCenterSVNId())) {
                    object = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                    PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                    pSDevCenterSVN.setPSDevCenterSVNId(pSDevSlnTempl.getPSDevCenterSVNId());
                    ((PSDevCenterSVNService)object).get(pSDevCenterSVN);
                    String string = pSDevCenterSVN.getGitBranch();
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        string = "master";
                    }
                    pSSFStyle.setV2GitPath(StringHelper.format((String)"%3$s*%1$s*%2$s", (Object)pSDevCenterSVN.getGitPath(), (Object)pSDevSlnTempl.getPSDevSlnTemplName(), (Object)string));
                }
                pSSFStyle.setStyleResUrl(pSDevSlnTempl.getV2GitPath());
                pSSFStyleService.create(pSSFStyle);
                PSDevSlnTempl pSDevSlnTemplUpdate = new PSDevSlnTempl();
                pSDevSlnTemplUpdate.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
                pSDevSlnTemplUpdate.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
                pSDevSlnTemplUpdate.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
                pSDevSlnTemplUpdate.setDevTemplState(30);
                this.sysUpdate(pSDevSlnTemplUpdate, false);
                pSDevSlnTempl.setPSSFStyleId(pSSFStyle.getPSSFStyleId());
                pSDevSlnTempl.setPSSFStyleName(pSSFStyle.getPSSFStyleName());
            } else {
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(pSDevSlnTempl.getPSSFStyleId());
                pSSFStyle.setStyleResUrl(pSDevSlnTempl.getV2GitPath());
                if (!StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getLogicName())) {
                    pSSFStyle.setPSSFStyleName(pSDevSlnTempl.getLogicName());
                } else {
                    pSSFStyle.setPSSFStyleName(pSDevSlnTempl.getPSDevSlnTemplName());
                }
                pSSFStyle.setMemo(pSDevSlnTempl.getMemo());
                pSSFStyleService.update(pSSFStyle);
            }
        }
    }

    @Override
    protected void onPubTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            Object object;
            this.get(pSDevSlnTempl);
            if ("PSPF".equals(pSDevSlnTempl.getTemplType())) {
                if (!StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSPFStyleId())) {
                    object = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                    PSPFStyle pSPFStyle = new PSPFStyle();
                    pSPFStyle.setPSPFStyleId(pSDevSlnTempl.getPSPFStyleId());
                    ((PSPFStyleService)object).get(pSPFStyle);
                    int n = DataObject.getIntegerValue((Object)pSPFStyle.getVersion(), (Integer)1);
                    pSPFStyle.reset();
                    pSPFStyle.setPSPFStyleId(pSDevSlnTempl.getPSPFStyleId());
                    pSPFStyle.setVersion(++n);
                    ((PSCoreSysServiceBaseBase)((Object)object)).sysUpdate(pSPFStyle, true);
                }
            } else if ("PSSF".equals(pSDevSlnTempl.getTemplType()) && !StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSSFStyleId())) {
                object = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                PSSFStyle pSSFStyle = new PSSFStyle();
                pSSFStyle.setPSSFStyleId(pSDevSlnTempl.getPSSFStyleId());
                ((PSSFStyleService)object).get(pSSFStyle);
                int n = DataObject.getIntegerValue((Object)pSSFStyle.getVersion(), (Integer)1);
                pSSFStyle.reset();
                pSSFStyle.setPSSFStyleId(pSDevSlnTempl.getPSSFStyleId());
                pSSFStyle.setVersion(++n);
                ((PSCoreSysServiceBaseBase)((Object)object)).sysUpdate(pSSFStyle, true);
            }
            object = pSDevSlnTempl.getPSDevSlnTemplId();
            pSDevSlnTempl.reset();
            pSDevSlnTempl.setPSDevSlnTemplId((String)object);
            pSDevSlnTempl.setLastPubDate(new Timestamp(new Date().getTime()));
            this.update(pSDevSlnTempl);
        }
    }

    @Override
    public boolean fillEntityKeyValue(PSDevSlnTempl pSDevSlnTempl, boolean bl) throws Exception {
        String string = pSDevSlnTempl.getPSDevSlnTemplId();
        if (string != null) {
            return true;
        }
        return super.fillEntityKeyValue(pSDevSlnTempl, bl);
    }

    @Override
    protected void internalCreate(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSDevCenterSVNId()) && PSDevSlnTemplService.isEnableGitLabPlugin()) {
            PSDevSln pSDevSln = pSDevSlnTempl.getPSDevSln();
            if (pSDevSln == null) {
                throw new Exception("\u7cfb\u7edf\u5f00\u53d1\u65b9\u6848\u65e0\u6548");
            }
            PSDevCenter pSDevCenter = pSDevSln.getPSDevCenter();
            if (pSDevCenter == null) {
                throw new Exception("\u7cfb\u7edf\u5e94\u7528\u4e2d\u5fc3\u65e0\u6548");
            }
            if (pSDevCenter.getV6PSSvnInstRepo() != null) {
                Project project = PSDevSlnTemplService.getPSGitLabPlugin().createProjectByPSDevSlnTempl(pSDevSlnTempl);
                PSDevCenterSVN pSDevCenterSVN = PSGitLabHelper.createPSDevCenterSVN(pSDevCenter, pSDevSln, project);
                pSDevSlnTempl.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
                pSDevSlnTempl.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
            }
        }
        super.internalCreate(pSDevSlnTempl);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            return true;
        }
        return super.isPrepareLastForRemove();
    }

    @Override
    protected void onAfterRemove(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getLast(pSDevSlnTempl);
            PSDevCenterHelper.updatetPSDCResRep(pSDevSlnTempl2.getPSDevSln().getPSDevCenter(), "DEVTEMPLCNT");
        }
        super.onAfterRemove(pSDevSlnTempl);
    }

    public void remove(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        final PSDevSlnTempl pSDevSlnTempl2 = pSDevSlnTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnTemplService.this.doRealRemove(pSDevSlnTempl2);
            }
        }, true);
    }

    protected void doRealRemove(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            this.get(pSDevSlnTempl);
            if (StringHelper.isNullOrEmpty((String)PSDevSlnTemplService.getRecyclePSDCId()) && ("PSPF".equals(pSDevSlnTempl.getTemplType()) ? !StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSPFStyleId()) : "PSSF".equals(pSDevSlnTempl.getTemplType()) && !StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSSFStyleId()))) {
                throw new Exception("\u5f00\u53d1\u6a21\u677f\u7981\u6b62\u5220\u9664");
            }
            try {
                PSDevSlnTempl pSDevSlnTempl2 = new PSDevSlnTempl();
                pSDevSlnTempl2.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
                pSDevSlnTempl2.setTemplType(null);
                pSDevSlnTempl2.setPSPFId(null);
                pSDevSlnTempl2.setPSPFStyleId(null);
                pSDevSlnTempl2.setPSSFId(null);
                pSDevSlnTempl2.setPSSFStyleId(null);
                this.sysUpdate(pSDevSlnTempl2, false);
                if ("PSPF".equals(pSDevSlnTempl.getTemplType())) {
                    if (!StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSPFStyleId())) {
                        PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
                        PSPFStyle pSPFStyle = new PSPFStyle();
                        pSPFStyle.setPSPFStyleId(pSDevSlnTempl.getPSPFStyleId());
                        pSPFStyleService.remove(pSPFStyle);
                    }
                } else if ("PSSF".equals(pSDevSlnTempl.getTemplType()) && !StringHelper.isNullOrEmpty((String)pSDevSlnTempl.getPSSFStyleId())) {
                    PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
                    PSSFStyle pSSFStyle = new PSSFStyle();
                    pSSFStyle.setPSSFStyleId(pSDevSlnTempl.getPSSFStyleId());
                    pSSFStyleService.remove(pSSFStyle);
                }
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5220\u9664\u5e73\u53f0\u6a21\u677f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw exception;
            }
        }
        super.remove(pSDevSlnTempl);
    }

    @Override
    protected void internalRemove(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) && this.doMovePSDevSlnTempl(pSDevSlnTempl)) {
            return;
        }
        super.internalRemove(pSDevSlnTempl);
    }

    protected boolean doMovePSDevSlnTempl(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        Object object;
        if (StringHelper.isNullOrEmpty((String)PSDevSlnTemplService.getRecyclePSDCId())) {
            return false;
        }
        PSDevSlnTempl pSDevSlnTempl2 = (PSDevSlnTempl)this.getLast(pSDevSlnTempl);
        PSDevSln pSDevSln = pSDevSlnTempl2.getPSDevSln();
        PSDevSln pSDevSln2 = new PSDevSln();
        pSDevSln2.setPSDevSlnName(StringHelper.format((String)"S%1$s", (Object)KeyValueHelper.genUniqueId((String)pSDevSlnTempl.getPSDevSlnTemplId(), (String)Integer.toString(random.nextInt(99999999)))));
        pSDevSln2.setCodeName(pSDevSln2.getPSDevSlnName());
        pSDevSln2.setPSDevCenterId(PSDevSlnTemplService.getRecyclePSDCId());
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        if (pSDevSln != null) {
            stringBuilderEx.append("PSDEVCENTERID=%1$s\r\n", (Object)pSDevSln.getPSDevCenterId());
            stringBuilderEx.append("PSDEVCENTERNAME%1$s\r\n", (Object)pSDevSln.getPSDevCenterName());
            stringBuilderEx.append("PSDEVSLNID=%1$s\r\n", (Object)pSDevSln.getPSDevSlnId());
            stringBuilderEx.append("PSDEVSLNNAME=%1$s\r\n", (Object)pSDevSln.getPSDevSlnName());
        }
        stringBuilderEx.append("PSDEVSLNTEMPLID=%1$s\r\n", (Object)pSDevSlnTempl2.getPSDevSlnTemplId());
        stringBuilderEx.append("PSDEVSLNTEMPLNAME=%1$s\r\n", (Object)pSDevSlnTempl2.getPSDevSlnTemplName());
        pSDevSln2.setMemo(stringBuilderEx.toString());
        try {
            object = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
            ((PSCoreSysServiceBaseBase)((Object)object)).create(pSDevSln2);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u56de\u6536\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u56de\u6536\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        try {
            PSDevSlnTempl pSDevSlnTemplUpdate = new PSDevSlnTempl();
            pSDevSlnTemplUpdate.setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            pSDevSlnTemplUpdate.setPSDevSlnId(pSDevSln2.getPSDevSlnId());
            pSDevSlnTemplUpdate.setPSDevSlnName(pSDevSln2.getPSDevSlnName());
            pSDevSlnTemplUpdate.setPSDevCenterId(pSDevSln2.getPSDevCenterId());
            pSDevSlnTemplUpdate.setPSDevCenterName(pSDevSln2.getPSDevCenterName());
            this.sysUpdate(pSDevSlnTemplUpdate, false);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u5f00\u53d1\u6a21\u677f\u5f52\u5c5e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u5f00\u53d1\u6a21\u677f\u5f52\u5c5e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        object = null;
        if (PSDevSlnTemplService.isEnableGitLabPlugin()) {
            try {
                object = PSDevSlnTemplService.getPSGitLabPlugin().moveProjectByPSDevSlnTempl(pSDevSlnTempl2, pSDevSln2);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u8f6c\u79fb\u4ee3\u7801\u4ed3\u5e93\u7fa4\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u8f6c\u79fb\u4ee3\u7801\u4ed3\u5e93\u7fa4\u7ec4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
        }
        try {
            if (pSDevSlnTempl2.getPSDevCenterSVN() != null) {
                PSGitLabHelper.movePSDevCenterSVN(pSDevSlnTempl2.getPSDevCenterSVN(), (Project)object, pSDevSln2);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u8f6c\u79fb\u5e73\u53f0\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u8f6c\u79fb\u5e73\u53f0\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        return true;
    }

    @Override
    protected void onGetWithRepo(PSDevSlnTempl pSDevSlnTempl) throws Exception {
        this.get(pSDevSlnTempl);
        PSDevCenterSVN pSDevCenterSVN = pSDevSlnTempl.getPSDevCenterSVN();
        if (pSDevCenterSVN != null) {
            String string = pSDevCenterSVN.getGitPath();
            pSDevSlnTempl.set("gitpath", string);
        }
    }
}
