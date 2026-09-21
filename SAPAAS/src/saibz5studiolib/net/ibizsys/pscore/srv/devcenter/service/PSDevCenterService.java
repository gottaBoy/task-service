/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.common.entity.LoginAccount
 *  net.ibizsys.psrt.srv.common.service.LoginAccountService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DCLevelCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSAppTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSCodeListTempl;
import net.ibizsys.pscore.srv.config.entity.PSDBValueFunc;
import net.ibizsys.pscore.srv.config.entity.PSDBValueFuncBase;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.entity.PSDBValueOPBase;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.entity.PSDEFDataTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSDEJoinType;
import net.ibizsys.pscore.srv.config.entity.PSDEJoinTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSEditorType;
import net.ibizsys.pscore.srv.config.entity.PSEditorTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSImageTempl;
import net.ibizsys.pscore.srv.config.entity.PSImageTemplBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFACHandler;
import net.ibizsys.pscore.srv.config.entity.PSSFACHandlerBase;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleBase;
import net.ibizsys.pscore.srv.config.entity.PSSysACHandler;
import net.ibizsys.pscore.srv.config.entity.PSSysACHandlerBase;
import net.ibizsys.pscore.srv.config.entity.PSSysTBItem;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbar;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbarBase;
import net.ibizsys.pscore.srv.config.entity.PSSysUIAction;
import net.ibizsys.pscore.srv.config.entity.PSSysUIActionBase;
import net.ibizsys.pscore.srv.config.entity.PSValueRule;
import net.ibizsys.pscore.srv.config.entity.PSValueRuleBase;
import net.ibizsys.pscore.srv.config.entity.PSVarType;
import net.ibizsys.pscore.srv.config.entity.PSVarTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeBase;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSDBValueFuncService;
import net.ibizsys.pscore.srv.config.service.PSDBValueOPService;
import net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService;
import net.ibizsys.pscore.srv.config.service.PSDEJoinTypeService;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.ibizsys.pscore.srv.config.service.PSImageTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFACHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSysACHandlerService;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemService;
import net.ibizsys.pscore.srv.config.service.PSSysTBItemServiceBase;
import net.ibizsys.pscore.srv.config.service.PSSysToolbarService;
import net.ibizsys.pscore.srv.config.service.PSSysUIActionService;
import net.ibizsys.pscore.srv.config.service.PSValueRuleService;
import net.ibizsys.pscore.srv.config.service.PSVarTypeService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCResRep;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTSBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObjBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMSPlatformService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCResRepService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDCInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSDCInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNInstRepoService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSDCInstGlobal;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.pscore.srv.xml.CodeItemConfig;
import net.ibizsys.pscore.srv.xml.CodeListConfig;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevCenterService
extends PSDevCenterServiceBase {
    private static final Log log = LogFactory.getLog(PSDevCenterService.class);
    private static final Random random = new Random();

    @Override
    protected void onInitModel(PSDevCenter pSDevCenter) throws Exception {
        super.onInitModel(pSDevCenter);
        this.initPSDevCenter(pSDevCenter);
    }

    protected void initPSVarType() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSVarTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSVarType> hashMap = new HashMap<String, PSVarType>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSVarTypeBase)serializable).getPSVarTypeId(), (PSVarType)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSVarTypeService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSVarType pSVarType = (PSVarType)iterator.next();
                if (hashMap.containsKey(pSVarType.getPSVarTypeId())) continue;
                iService.create((IEntity)pSVarType);
                hashMap.put(pSVarType.getPSVarTypeId(), pSVarType);
                arrayList.add(pSVarType);
            }
        }
    }

    protected void initPSDEJoinType() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSDEJoinTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSDEJoinType> hashMap = new HashMap<String, PSDEJoinType>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSDEJoinTypeBase)serializable).getPSDEJoinTypeId(), (PSDEJoinType)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSDEJoinTypeService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSDEJoinType pSDEJoinType = (PSDEJoinType)iterator.next();
                if (hashMap.containsKey(pSDEJoinType.getPSDEJoinTypeId())) continue;
                iService.create((IEntity)pSDEJoinType);
                hashMap.put(pSDEJoinType.getPSDEJoinTypeId(), pSDEJoinType);
                arrayList.add(pSDEJoinType);
            }
        }
    }

    protected void initPSDBValueFunc() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSDBValueFuncService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSDBValueFunc> hashMap = new HashMap<String, PSDBValueFunc>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSDBValueFuncBase)serializable).getPSDBValueFuncId(), (PSDBValueFunc)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSDBValueFuncService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSDBValueFunc pSDBValueFunc = (PSDBValueFunc)iterator.next();
                if (hashMap.containsKey(pSDBValueFunc.getPSDBValueFuncId())) continue;
                iService.create((IEntity)pSDBValueFunc);
                hashMap.put(pSDBValueFunc.getPSDBValueFuncId(), pSDBValueFunc);
                arrayList.add(pSDBValueFunc);
            }
        }
    }

    protected void initPSDBValueOP() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSDBValueOP> hashMap = new HashMap<String, PSDBValueOP>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSDBValueOPBase)serializable).getPSDBValueOPId(), (PSDBValueOP)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSDBValueOPService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSDBValueOP pSDBValueOP = (PSDBValueOP)iterator.next();
                if (hashMap.containsKey(pSDBValueOP.getPSDBValueOPId())) continue;
                iService.create((IEntity)pSDBValueOP);
                hashMap.put(pSDBValueOP.getPSDBValueOPId(), pSDBValueOP);
                arrayList.add(pSDBValueOP);
            }
        }
    }

    protected void initPSDEFDataType() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSDEFDataType> hashMap = new HashMap<String, PSDEFDataType>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSDEFDataTypeBase)serializable).getPSDEFDataTypeId(), (PSDEFDataType)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSDEFDataTypeService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSDEFDataType pSDEFDataType = (PSDEFDataType)iterator.next();
                if (hashMap.containsKey(pSDEFDataType.getPSDEFDataTypeId())) continue;
                iService.create((IEntity)pSDEFDataType);
                hashMap.put(pSDEFDataType.getPSDEFDataTypeId(), pSDEFDataType);
                arrayList.add(pSDEFDataType);
            }
        }
    }

    protected void initPSEditorType() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSEditorTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSEditorType> hashMap = new HashMap<String, PSEditorType>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSEditorTypeBase)serializable).getPSEditorTypeId(), (PSEditorType)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSEditorTypeService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSEditorType pSEditorType = (PSEditorType)iterator.next();
                if (hashMap.containsKey(pSEditorType.getPSEditorTypeId())) continue;
                iService.create((IEntity)pSEditorType);
                hashMap.put(pSEditorType.getPSEditorTypeId(), pSEditorType);
                arrayList.add(pSEditorType);
            }
        }
    }

    protected void initPSSF() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSSF> hashMap = new HashMap<String, PSSF>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSSFBase)serializable).getPSSFId(), (PSSF)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSSFService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSSF pSSF = (PSSF)iterator.next();
                if (hashMap.containsKey(pSSF.getPSSFId())) continue;
                iService.create((IEntity)pSSF);
                hashMap.put(pSSF.getPSSFId(), pSSF);
                arrayList.add(pSSF);
            }
        }
    }

    protected void initPSSFStyle() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSSFStyle> hashMap = new HashMap<String, PSSFStyle>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSSFStyleBase)serializable).getPSSFStyleId(), (PSSFStyle)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSSFStyleService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSSFStyle pSSFStyle = (PSSFStyle)iterator.next();
                if (hashMap.containsKey(pSSFStyle.getPSSFStyleId())) continue;
                iService.create((IEntity)pSSFStyle);
                hashMap.put(pSSFStyle.getPSSFStyleId(), pSSFStyle);
                arrayList.add(pSSFStyle);
            }
        }
    }

    protected void initPSPF() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSPF> hashMap = new HashMap<String, PSPF>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSPFBase)serializable).getPSPFId(), (PSPF)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSPFService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSPF pSPF = (PSPF)iterator.next();
                if (hashMap.containsKey(pSPF.getPSPFId())) continue;
                iService.create((IEntity)pSPF);
                hashMap.put(pSPF.getPSPFId(), pSPF);
                arrayList.add(pSPF);
            }
        }
    }

    protected void initPSPFStyle() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSPFStyle> hashMap = new HashMap<String, PSPFStyle>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSPFStyleBase)serializable).getPSPFStyleId(), (PSPFStyle)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSPFStyleService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSPFStyle pSPFStyle = (PSPFStyle)iterator.next();
                if (hashMap.containsKey(pSPFStyle.getPSPFStyleId())) continue;
                iService.create((IEntity)pSPFStyle);
                hashMap.put(pSPFStyle.getPSPFStyleId(), pSPFStyle);
                arrayList.add(pSPFStyle);
            }
        }
    }

    protected void initPSAppType() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSAppType> hashMap = new HashMap<String, PSAppType>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSAppTypeBase)serializable).getPSAppTypeId(), (PSAppType)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSAppTypeService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSAppType pSAppType = (PSAppType)iterator.next();
                if (hashMap.containsKey(pSAppType.getPSAppTypeId())) continue;
                iService.create((IEntity)pSAppType);
                hashMap.put(pSAppType.getPSAppTypeId(), pSAppType);
                arrayList.add(pSAppType);
            }
        }
    }

    protected void initPSSysACHandler() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSSysACHandlerService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSSysACHandler> hashMap = new HashMap<String, PSSysACHandler>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSSysACHandlerBase)serializable).getPSSysACHandlerId(), (PSSysACHandler)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSSysACHandlerService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSSysACHandler pSSysACHandler = (PSSysACHandler)iterator.next();
                if (hashMap.containsKey(pSSysACHandler.getPSSysACHandlerId())) continue;
                iService.create((IEntity)pSSysACHandler);
                hashMap.put(pSSysACHandler.getPSSysACHandlerId(), pSSysACHandler);
                arrayList.add(pSSysACHandler);
            }
        }
    }

    protected void initPSACHandlers(PSSystem pSSystem) throws Exception {
        Object object;
        Object object2;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSFACHandlerService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSSFACHandlerBase)serializable2).getPSSFACHandlerId(), serializable2);
        }
        if (this.getSessionFactory() != null) {
            iService = ServiceGlobal.getService(PSSFACHandlerService.class);
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object2 = ((ArrayList)serializable2).iterator();
            while (object2.hasNext()) {
                object = (PSSFACHandler)object2.next();
                if (hashMap.containsKey(((PSSFACHandlerBase)object).getPSSFACHandlerId())) continue;
                iService2.create(object);
                hashMap.put(((PSSFACHandlerBase)object).getPSSFACHandlerId(), object);
                arrayList.add(object);
            }
        }
        iService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        serializable2 = iService.select((ISelectCond)selectCond);
        object2 = new HashMap();
        object = ((ArrayList)serializable2).iterator();
        while (object.hasNext()) {
            EntityBase entityBase = (PSACHandler)object.next();
            ((HashMap)object2).put(entityBase.getPSACHandlerId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSSFACHandlerId());
            if (((HashMap)object2).containsKey(string2)) continue;
            this.initPSACHandler(pSSystem, (PSSFACHandler)entityBase);
        }
    }

    protected void initPSACHandler(PSSystem pSSystem, PSSFACHandler pSSFACHandler) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSACHandlerService pSACHandlerService = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, (SessionFactory)this.getSessionFactory());
        PSACHandler pSACHandler = new PSACHandler();
        pSSFACHandler.copyTo((IDataObject)pSACHandler, false);
        pSACHandler.setPSACHandlerId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSSFACHandler.getPSSFACHandlerId()));
        pSACHandler.setPSACHandlerName(pSSFACHandler.getPSSFACHandlerName());
        pSACHandler.setPSSystemId(pSSystem.getPSSystemId());
        pSACHandler.setPSSystemName(pSSystem.getPSSystemName());
        pSACHandlerService.create(pSACHandler);
    }

    protected void initPSViewType() throws Exception {
        if (this.getSessionFactory() == null) {
            return;
        }
        IService iService = ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService.select((ISelectCond)selectCond);
        HashMap<String, PSViewType> hashMap = new HashMap<String, PSViewType>();
        for (Serializable serializable : arrayList) {
            hashMap.put(((PSViewTypeBase)serializable).getPSViewTypeId(), (PSViewType)serializable);
        }
        if (this.getSessionFactory() != null) {
            Serializable serializable;
            IService iService2 = ServiceGlobal.getService(PSViewTypeService.class);
            selectCond.reset();
            serializable = iService2.select((ISelectCond)selectCond);
            Iterator iterator = ((ArrayList)serializable).iterator();
            while (iterator.hasNext()) {
                PSViewType pSViewType = (PSViewType)iterator.next();
                if (hashMap.containsKey(pSViewType.getPSViewTypeId())) continue;
                iService.create((IEntity)pSViewType);
                hashMap.put(pSViewType.getPSViewTypeId(), pSViewType);
                arrayList.add(pSViewType);
            }
        }
    }

    protected void initPSDEUIActions(PSSystem pSSystem) throws Exception {
        Object object;
        Object object2;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSysUIActionService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSSysUIActionBase)serializable2).getPSSysUIActionId(), serializable2);
        }
        if (this.getSessionFactory() != null) {
            iService = ServiceGlobal.getService(PSSysUIActionService.class);
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object2 = ((ArrayList)serializable2).iterator();
            while (object2.hasNext()) {
                object = (PSSysUIAction)object2.next();
                if (hashMap.containsKey(((PSSysUIActionBase)object).getPSSysUIActionId())) continue;
                iService2.create(object);
                hashMap.put(((PSSysUIActionBase)object).getPSSysUIActionId(), object);
                arrayList.add(object);
            }
        }
        iService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        serializable2 = iService.select((ISelectCond)selectCond);
        object2 = new HashMap();
        object = ((ArrayList)serializable2).iterator();
        while (object.hasNext()) {
            EntityBase entityBase = (PSDEUIAction)object.next();
            ((HashMap)object2).put(entityBase.getPSDEUIActionId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSSysUIActionId());
            if (((HashMap)object2).containsKey(string2)) continue;
            this.initPSDEUIAction(pSSystem, (PSSysUIAction)entityBase);
        }
    }

    protected void initPSDEUIAction(PSSystem pSSystem, PSSysUIAction pSSysUIAction) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        PSDEUIAction pSDEUIAction = new PSDEUIAction();
        pSSysUIAction.copyTo((IDataObject)pSDEUIAction, false);
        pSDEUIAction.setPSDEUIActionId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSSysUIAction.getPSSysUIActionId()));
        pSDEUIAction.setPSDEUIActionName(pSSysUIAction.getPSSysUIActionName());
        pSDEUIAction.setPSSystemId(pSSystem.getPSSystemId());
        pSDEUIAction.setPSSystemName(pSSystem.getPSSystemName());
        pSDEUIAction.setUIActionType("SYS");
        pSDEUIAction.setTemplMode(1);
        if (!StringHelper.isNullOrEmpty((String)pSSysUIAction.getPSImageTemplId())) {
            String string2 = KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSSysUIAction.getPSImageTemplId());
            pSDEUIAction.setPSSysImageId(string2);
        }
        pSDEUIActionService.create(pSDEUIAction);
    }

    protected void initPSSysValueRules(PSSystem pSSystem) throws Exception {
        Object object;
        Object object2;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSValueRuleService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSValueRuleBase)serializable2).getPSValueRuleId(), serializable2);
        }
        if (this.getSessionFactory() != null) {
            iService = ServiceGlobal.getService(PSValueRuleService.class);
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object2 = ((ArrayList)serializable2).iterator();
            while (object2.hasNext()) {
                object = (PSValueRule)object2.next();
                if (hashMap.containsKey(((PSValueRuleBase)object).getPSValueRuleId())) continue;
                iService2.create(object);
                hashMap.put(((PSValueRuleBase)object).getPSValueRuleId(), object);
                arrayList.add(object);
            }
        }
        iService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        serializable2 = iService.select((ISelectCond)selectCond);
        object2 = new HashMap();
        object = ((ArrayList)serializable2).iterator();
        while (object.hasNext()) {
            EntityBase entityBase = (PSSysValueRule)object.next();
            ((HashMap)object2).put(entityBase.getPSSysValueRuleId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSValueRuleId());
            if (((HashMap)object2).containsKey(string2)) continue;
            this.initPSSysValueRule(pSSystem, (PSValueRule)entityBase);
        }
    }

    protected void initPSSysValueRule(PSSystem pSSystem, PSValueRule pSValueRule) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
        PSSysValueRule pSSysValueRule = new PSSysValueRule();
        pSValueRule.copyTo((IDataObject)pSSysValueRule, false);
        pSSysValueRule.setPSSysValueRuleId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSValueRule.getPSValueRuleId()));
        pSSysValueRule.setPSSysValueRuleName(pSValueRule.getPSValueRuleName());
        pSSysValueRule.setPSSystemId(pSSystem.getPSSystemId());
        pSSysValueRule.setPSSystemName(pSSystem.getPSSystemName());
        pSSysValueRuleService.create(pSSysValueRule);
    }

    protected void initPSSysImages(PSSystem pSSystem) throws Exception {
        Object object;
        Object object2;
        IService iService;
        Serializable serializable2;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSImageTemplService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (Serializable serializable2 : arrayList) {
            hashMap.put(((PSImageTemplBase)serializable2).getPSImageTemplId(), serializable2);
        }
        if (this.getSessionFactory() != null) {
            iService = ServiceGlobal.getService(PSImageTemplService.class);
            selectCond.reset();
            serializable2 = iService.select((ISelectCond)selectCond);
            object2 = ((ArrayList)serializable2).iterator();
            while (object2.hasNext()) {
                object = (PSImageTempl)object2.next();
                if (hashMap.containsKey(((PSImageTemplBase)object).getPSImageTemplId())) continue;
                iService2.create(object);
                hashMap.put(((PSImageTemplBase)object).getPSImageTemplId(), object);
                arrayList.add(object);
            }
        }
        iService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        serializable2 = iService.select((ISelectCond)selectCond);
        object2 = new HashMap();
        object = ((ArrayList)serializable2).iterator();
        while (object.hasNext()) {
            EntityBase entityBase = (PSSysImage)object.next();
            ((HashMap)object2).put(entityBase.getPSSysImageId(), entityBase);
        }
        for (EntityBase entityBase : arrayList) {
            String string2 = KeyValueHelper.genUniqueId((String)string, (String)entityBase.getPSImageTemplId());
            if (((HashMap)object2).containsKey(string2)) continue;
            this.initPSSysImage(pSSystem, (PSImageTempl)entityBase);
        }
    }

    protected void initPSSysImage(PSSystem pSSystem, PSImageTempl pSImageTempl) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
        PSSysImage pSSysImage = new PSSysImage();
        pSImageTempl.copyTo((IDataObject)pSSysImage, false);
        pSSysImage.setPSSysImageId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSImageTempl.getPSImageTemplId()));
        pSSysImage.setPSSysImageName(pSImageTempl.getPSImageTemplName());
        pSSysImage.setPSSystemId(pSSystem.getPSSystemId());
        pSSysImage.setPSSystemName(pSSystem.getPSSystemName());
        pSSysImageService.create(pSSysImage);
    }

    protected void initPSDEToolbars(PSSystem pSSystem) throws Exception {
        Object object;
        EntityBase entityBase2;
        Iterator iterator;
        Cloneable cloneable;
        IService iService;
        Object object22;
        String string = pSSystem.getPSSystemId();
        IService iService2 = ServiceGlobal.getService(PSSysToolbarService.class, (SessionFactory)this.getSessionFactory());
        IService iService3 = ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        ArrayList arrayList = iService2.select((ISelectCond)selectCond);
        HashMap<String, EntityBase> hashMap = new HashMap<String, EntityBase>();
        for (Object object22 : arrayList) {
            hashMap.put(((PSSysToolbarBase)object22).getPSSysToolbarId(), (EntityBase)object22);
        }
        if (this.getSessionFactory() != null) {
            iService = ServiceGlobal.getService(PSSysToolbarService.class);
            object22 = (PSSysTBItemService)ServiceGlobal.getService(PSSysTBItemService.class);
            selectCond.reset();
            cloneable = iService.select((ISelectCond)selectCond);
            iterator = ((ArrayList)cloneable).iterator();
            while (iterator.hasNext()) {
                entityBase2 = (PSSysToolbar)iterator.next();
                if (hashMap.containsKey(entityBase2.getPSSysToolbarId())) continue;
                object = ((PSSysTBItemServiceBase)object22).selectByPSSysToolbar((PSSysToolbarBase)entityBase2);
                PSSysTBItemService.sortHierarchyEntities(object, (String)"PSSYSTBITEMID", (String)"PPSSYSTBITEMID");
                iService2.create((IEntity)entityBase2);
                hashMap.put(entityBase2.getPSSysToolbarId(), entityBase2);
                arrayList.add(entityBase2);
                Iterator iterator2 = ((ArrayList)object).iterator();
                while (iterator2.hasNext()) {
                    PSSysTBItem pSSysTBItem = (PSSysTBItem)iterator2.next();
                    iService3.create((IEntity)pSSysTBItem);
                }
            }
        }
        iService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        object22 = iService.select((ISelectCond)selectCond);
        cloneable = new HashMap();
        iterator = ((ArrayList)object22).iterator();
        while (iterator.hasNext()) {
            entityBase2 = (PSDEToolbar)iterator.next();
            ((HashMap)cloneable).put(entityBase2.getPSDEToolbarId(), entityBase2);
        }
        for (EntityBase entityBase2 : arrayList) {
            object = KeyValueHelper.genUniqueId((String)string, (String)entityBase2.getPSSysToolbarId());
            if (((HashMap)cloneable).containsKey(object)) continue;
            this.initPSDEToolbar(pSSystem, (PSSysToolbar)entityBase2);
        }
    }

    protected void initPSDEToolbar(PSSystem pSSystem, PSSysToolbar pSSysToolbar) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSDEToolbarService pSDEToolbarService = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        PSDEToolbar pSDEToolbar = new PSDEToolbar();
        pSSysToolbar.copyTo((IDataObject)pSDEToolbar, false);
        pSDEToolbar.setPSDEToolbarId(KeyValueHelper.genUniqueId((String)pSSystem.getPSSystemId(), (String)pSSysToolbar.getPSSysToolbarId()));
        pSDEToolbar.setPSDEToolbarName(pSSysToolbar.getPSSysToolbarName());
        pSDEToolbar.setPSSystemId(pSSystem.getPSSystemId());
        pSDEToolbar.setPSSystemName(pSSystem.getPSSystemName());
        pSDEToolbar.setTemplToolbar(1);
        pSDEToolbarService.create(pSDEToolbar);
        PSSysTBItemService pSSysTBItemService = (PSSysTBItemService)ServiceGlobal.getService(PSSysTBItemService.class, (SessionFactory)this.getSessionFactory());
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysTBItem> arrayList = pSSysTBItemService.selectByPSSysToolbar(pSSysToolbar);
        PSSysTBItemService.sortHierarchyEntities(arrayList, (String)"PSSYSTBITEMID", (String)"PPSSYSTBITEMID");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        int n = 0;
        while (arrayList.size() > 0) {
            String string2;
            ++n;
            String string3 = "";
            PSSysTBItem pSSysTBItem = arrayList.remove(0);
            if (!StringHelper.isNullOrEmpty((String)pSSysTBItem.getPPSSysTBItemId()) && StringHelper.isNullOrEmpty((String)(string3 = (String)hashMap.get(pSSysTBItem.getPPSSysTBItemId())))) {
                arrayList.add(pSSysTBItem);
                continue;
            }
            PSDETBItem pSDETBItem = new PSDETBItem();
            pSSysTBItem.copyTo((IDataObject)pSDETBItem, true);
            pSDETBItem.setPSDETBItemName(StringHelper.format((String)"tbitem%1$s", (Object)n));
            pSDETBItem.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                pSDETBItem.setPPSDETBItemId(string3);
            }
            if (!StringHelper.isNullOrEmpty((String)(string2 = pSSysTBItem.getPSSysUIActionId()))) {
                String string4 = KeyValueHelper.genUniqueId((String)pSDEToolbar.getPSSystemId(), (String)string2);
                pSDETBItem.setPSDEUIActionId(string4);
            }
            pSDETBItemService.create(pSDETBItem);
            hashMap.put(pSSysTBItem.getPSSysTBItemId(), pSDETBItem.getPSDETBItemId());
        }
    }

    protected void initPSDevCenter(PSDevCenter pSDevCenter) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDevCenter.getPSDCInstId())) {
            return;
        }
        SessionFactory sessionFactory = PSDCInstGlobal.getSessionFactory(pSDevCenter.getPSDCInstId());
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)sessionFactory);
        if (pSDevCenterService.checkKey(pSDevCenter) == 1) {
            return;
        }
        PSDevCenter pSDevCenter2 = new PSDevCenter();
        pSDevCenter.copyTo((IDataObject)pSDevCenter2, true);
        pSDevCenter2.resetPSDCInstId();
        pSDevCenter2.resetPSDCInstName();
        pSDevCenterService.save((IEntity)pSDevCenter2);
    }

    protected void initPSCodeList(PSSystem pSSystem, PSCodeListTempl pSCodeListTempl) throws Exception {
        String string = pSSystem.getPSSystemId();
        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        PSCodeList pSCodeList = new PSCodeList();
        pSCodeListTempl.copyTo((IDataObject)pSCodeList, false);
        pSCodeList.setPSCodeListName(pSCodeListTempl.getPSCodeListTemplName());
        pSCodeList.setPSCodeListId(KeyValueHelper.genUniqueId((String)string, (String)pSCodeListTempl.getPSCodeListTemplId()));
        pSCodeList.setPSSystemId(string);
        pSCodeList.setCLType("STATIC");
        pSCodeList.setCodeListSN(pSCodeListTempl.getPSCodeListTemplId());
        pSCodeList.setPSCodeListTemplId(pSCodeListTempl.getPSCodeListTemplId());
        pSCodeList.setUserScope(0);
        pSCodeList.setCodeName(pSCodeListTempl.getCodeName());
        pSCodeListService.create(pSCodeList);
        if (StringHelper.isNullOrEmpty((String)pSCodeListTempl.getCLModel())) {
            return;
        }
        CodeListConfig codeListConfig = new CodeListConfig();
        codeListConfig.loadXML(pSCodeListTempl.getCLModel());
        for (int i = 0; i < codeListConfig.getCodeItems().size(); ++i) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)codeListConfig.getCodeItems().get(i));
            this.initPSCodeItem(pSCodeList, null, codeItemConfig, i);
        }
    }

    protected void initPSCodeItem(PSCodeList pSCodeList, PSCodeItem pSCodeItem, CodeItemConfig codeItemConfig, int n) throws Exception {
        IService iService = ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        PSCodeItem pSCodeItem2 = new PSCodeItem();
        pSCodeItem2.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSCodeItem2.setCodeItemValue(codeItemConfig.getValue());
        pSCodeItem2.setPSCodeItemName(codeItemConfig.getText());
        pSCodeItem2.setOrderValue(n);
        if (pSCodeItem != null) {
            pSCodeItem2.setPPSCodeItemId(pSCodeItem.getPSCodeItemId());
        }
        iService.create((IEntity)pSCodeItem2);
        if (codeItemConfig.getCodeItems() == null || codeItemConfig.getCodeItems().size() == 0) {
            return;
        }
        for (int i = 0; i < codeItemConfig.getCodeItems().size(); ++i) {
            CodeItemConfig codeItemConfig2 = (CodeItemConfig)((Object)codeItemConfig.getCodeItems().get(i));
            this.initPSCodeItem(pSCodeList, pSCodeItem2, codeItemConfig2, i);
        }
    }

    @Override
    protected void onBeforeCreate(PSDevCenter pSDevCenter) throws Exception {
        if (this.getSessionFactory() != null) {
            pSDevCenter.setPSDCInstId(null);
            pSDevCenter.setPSDCInstName(null);
        }
        if (PSDevCenterService.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevCenterHelper.fillPSDevCenter(pSDevCenter, null);
            if (pSDevCenter.getDCLevel() != null && pSDevCenter.getDCLevel() >= 10 && pSDevCenter.getDCLevel() < 100) {
                this.initLabDC(pSDevCenter);
            }
        }
        super.onBeforeCreate(pSDevCenter);
    }

    @Override
    protected void onBeforeUpdate(PSDevCenter pSDevCenter) throws Exception {
        if (!PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            pSDevCenter.setPSDCInstId(null);
            pSDevCenter.setPSDCInstName(null);
        } else {
            PSDevCenterHelper.fillPSDevCenter(pSDevCenter, (PSDevCenter)this.getLast((IEntity)pSDevCenter));
        }
        super.onBeforeUpdate(pSDevCenter);
    }

    @Override
    protected void onAfterCreate(PSDevCenter pSDevCenter) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDCResRepService pSDCResRepService = (PSDCResRepService)ServiceGlobal.getService(PSDCResRepService.class, (SessionFactory)this.getSessionFactory());
            PSDCResRep pSDCResRep = new PSDCResRep();
            pSDCResRep.setPSDCResRepId(pSDevCenter.getPSDevCenterId());
            pSDCResRep.setPSDCResRepName(pSDevCenter.getPSDevCenterName());
            pSDCResRep.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDCResRep.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
            pSDCResRep.setRepTime(new Timestamp(System.currentTimeMillis()));
            pSDCResRep.setDefaultFlag(1);
            pSDCResRepService.save((IEntity)pSDCResRep, false);
        }
        if (PSDevCenterService.isMajorSessionFactory(this.getSessionFactory()) && pSDevCenter.getDCLevel() != null && pSDevCenter.getDCLevel() >= 10 && pSDevCenter.getDCLevel() < 100) {
            this.afterCreateLabDC(pSDevCenter);
        }
        super.onAfterCreate(pSDevCenter);
    }

    @Override
    protected void onAfterUpdate(PSDevCenter pSDevCenter) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            Object var2_2 = null;
            if (!pSDevCenter.isFullEntity()) {
                this.get((IEntity)pSDevCenter);
            }
            PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).updatePSDevCenter(pSDevCenter);
        }
        super.onAfterUpdate(pSDevCenter);
    }

    protected void initPSDCInst(PSDevCenter pSDevCenter, PSDevCenter pSDevCenter2) throws Exception {
        if (this.getSessionFactory() != null) {
            return;
        }
        PSDCInstService pSDCInstService = (PSDCInstService)ServiceGlobal.getService(PSDCInstService.class);
        String string = pSDevCenter.getPSDCInstId();
        String string2 = "";
        if (pSDevCenter2 != null) {
            string2 = pSDevCenter2.getPSDCInstId();
        }
        if (!StringHelper.isNullOrEmpty((String)string) && StringHelper.compare((String)string, (String)string2, (boolean)true) != 0) {
            PSDCInst pSDCInst = new PSDCInst();
            pSDCInst.setPSDCInstId(pSDevCenter.getPSDCInstId());
            if (!pSDCInstService.get((IEntity)pSDCInst, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u5b9e\u4f8b"));
            }
            if (StringHelper.compare((String)pSDCInst.getInstState(), (String)"20", (boolean)true) != 0) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u5b9e\u4f8b\u72b6\u6001\u4e0d\u6b63\u786e"));
            }
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSDCInstGlobal.getSessionFactory(pSDevCenter.getPSDCInstId()));
            PSDevCenter pSDevCenter3 = new PSDevCenter();
            pSDevCenter.copyTo((IDataObject)pSDevCenter3, false);
            pSDevCenterService.save((IEntity)pSDevCenter3);
            pSDCInst.reset();
            pSDCInst.setPSDCInstId(pSDevCenter.getPSDCInstId());
            pSDCInst.setInstState("30");
            pSDCInst.setMemo(pSDevCenter.getPSDevCenterName());
            pSDCInstService.update(pSDCInst);
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    public void genResRep(PSDevCenter pSDevCenter, String string) throws Exception {
        final PSDevCenter pSDevCenter2 = pSDevCenter;
        final String string2 = string;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevCenterService.this.onGenResRep(pSDevCenter2, string2);
            }
        });
    }

    @Override
    protected void onGenResRep(PSDevCenter pSDevCenter) throws Exception {
        this.onGenResRep(pSDevCenter, null);
    }

    protected void onGenResRep(PSDevCenter pSDevCenter, String string) throws Exception {
        IEntity iEntity;
        ArrayList arrayList;
        SelectField selectField;
        SelectContext selectContext;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!pSDevCenter.isFullEntity()) {
            this.get((IEntity)pSDevCenter);
        }
        PSDCResRepService pSDCResRepService = (PSDCResRepService)ServiceGlobal.getService(PSDCResRepService.class, (SessionFactory)this.getSessionFactory());
        PSDCResRep pSDCResRep = new PSDCResRep();
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"USERCNT", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
            selectContext = new SelectContext();
            selectField = new SelectField();
            selectField.setFunc("COUNT");
            selectField.setAlias("USERCNT");
            selectContext.addSelectField((ISelectField)selectField);
            selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            selectContext.set("VALIDFLAG", (Object)1);
            arrayList = pSCoreSysServiceBase.select((ISelectCond)selectContext);
            if (arrayList.size() == 0) {
                throw new Exception("\u65e0\u6cd5\u5408\u8ba1\u5e94\u7528\u4e2d\u5fc3\u7528\u6237");
            }
            iEntity = (IEntity)arrayList.get(0);
            iEntity.copyTo((IDataObject)pSDCResRep, false);
        }
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DEVSLNCNT", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
            selectContext = new SelectContext();
            selectField = new SelectField();
            selectField.setFunc("COUNT");
            selectField.setAlias("DEVSLNCNT");
            selectContext.addSelectField((ISelectField)selectField);
            selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            arrayList = pSCoreSysServiceBase.select((ISelectCond)selectContext);
            if (arrayList.size() == 0) {
                throw new Exception("\u65e0\u6cd5\u5408\u8ba1\u5e94\u7528\u4e2d\u5fc3\u5f00\u53d1\u65b9\u6848");
            }
            iEntity = (IEntity)arrayList.get(0);
            iEntity.copyTo((IDataObject)pSDCResRep, false);
        }
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DEVSYSCNT", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
            selectContext = new SelectContext();
            selectField = new SelectField();
            selectField.setFunc("COUNT");
            selectField.setAlias("DEVSYSCNT");
            selectContext.addSelectField((ISelectField)selectField);
            selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            arrayList = pSCoreSysServiceBase.select((ISelectCond)selectContext);
            if (arrayList.size() == 0) {
                throw new Exception("\u65e0\u6cd5\u5408\u8ba1\u5e94\u7528\u4e2d\u5fc3\u5f00\u53d1\u7cfb\u7edf");
            }
            iEntity = (IEntity)arrayList.get(0);
            iEntity.copyTo((IDataObject)pSDCResRep, false);
        }
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DEVTEMPLCNT", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
            selectContext = new SelectContext();
            selectField = new SelectField();
            selectField.setFunc("COUNT");
            selectField.setAlias("DEVTEMPLCNT");
            selectContext.addSelectField((ISelectField)selectField);
            selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            arrayList = pSCoreSysServiceBase.select((ISelectCond)selectContext);
            if (arrayList.size() == 0) {
                throw new Exception("\u65e0\u6cd5\u5408\u8ba1\u5e94\u7528\u4e2d\u5fc3\u5f00\u53d1\u6a21\u677f");
            }
            iEntity = (IEntity)arrayList.get(0);
            iEntity.copyTo((IDataObject)pSDCResRep, false);
        }
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"SYSBAKCNT", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)this.getSessionFactory());
            selectContext = new SelectContext();
            selectField = new SelectField();
            selectField.setFunc("COUNT");
            selectField.setAlias("SYSBAKCNT");
            selectContext.addSelectField((ISelectField)selectField);
            selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            arrayList = pSCoreSysServiceBase.select((ISelectCond)selectContext);
            if (arrayList.size() == 0) {
                throw new Exception("\u65e0\u6cd5\u5408\u8ba1\u5e94\u7528\u4e2d\u5fc3\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd");
            }
            iEntity = (IEntity)arrayList.get(0);
            iEntity.copyTo((IDataObject)pSDCResRep, false);
        }
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DBINSTCNT", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
            selectContext = new SelectContext();
            selectField = new SelectField();
            selectField.setFunc("COUNT");
            selectField.setAlias("DBINSTCNT");
            selectContext.addSelectField((ISelectField)selectField);
            selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            arrayList = pSCoreSysServiceBase.select((ISelectCond)selectContext);
            if (arrayList.size() == 0) {
                throw new Exception("\u65e0\u6cd5\u5408\u8ba1\u5e94\u7528\u4e2d\u5fc3\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b");
            }
            iEntity = (IEntity)arrayList.get(0);
            iEntity.copyTo((IDataObject)pSDCResRep, false);
        }
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"MSPCNT", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDCMSPlatformService)ServiceGlobal.getService(PSDCMSPlatformService.class, (SessionFactory)this.getSessionFactory());
            selectContext = new SelectContext();
            selectField = new SelectField();
            selectField.setFunc("COUNT");
            selectField.setAlias("MSPCNT");
            selectContext.addSelectField((ISelectField)selectField);
            selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            arrayList = pSCoreSysServiceBase.select((ISelectCond)selectContext);
            if (arrayList.size() == 0) {
                throw new Exception("\u65e0\u6cd5\u5408\u8ba1\u5e94\u7528\u4e2d\u5fc3\u5fae\u670d\u52a1\u5e73\u53f0");
            }
            iEntity = (IEntity)arrayList.get(0);
            iEntity.copyTo((IDataObject)pSDCResRep, false);
        }
        if (StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"WORKSPACECNT", (boolean)true) == 0) {
            pSCoreSysServiceBase = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
            selectContext = new SelectContext();
            selectField = new SelectField();
            selectField.setFunc("COUNT");
            selectField.setAlias("WORKSPACECNT");
            selectContext.addSelectField((ISelectField)selectField);
            selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            arrayList = pSCoreSysServiceBase.select((ISelectCond)selectContext);
            if (arrayList.size() == 0) {
                throw new Exception("\u65e0\u6cd5\u5408\u8ba1\u5e94\u7528\u4e2d\u5fc3\u751f\u4ea7\u7ebf");
            }
            iEntity = (IEntity)arrayList.get(0);
            iEntity.copyTo((IDataObject)pSDCResRep, false);
        }
        pSDCResRep.setPSDCResRepName(StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3[%1$s]\u9ed8\u8ba4\u8d44\u6e90\u62a5\u8868", (Object)pSDevCenter.getPSDevCenterName()));
        pSDCResRep.setPSDCResRepId(pSDevCenter.getPSDevCenterId());
        pSDCResRep.setDefaultFlag(1);
        pSDCResRep.setRepTime(new Timestamp(System.currentTimeMillis()));
        pSDCResRepService.save((IEntity)pSDCResRep, true);
        pSDCResRep.resetPSDCResRepId();
        pSDCResRep.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCResRep.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
        pSDCResRep.setPSDCResRepName("\u5e94\u7528\u4e2d\u5fc3\u8d44\u6e90\u62a5\u8868");
        pSDCResRep.setRepTime(new Timestamp(System.currentTimeMillis()));
        pSDCResRep.setDefaultFlag(0);
        pSDCResRepService.create(pSDCResRep, false);
    }

    protected void onGenResRep2(PSDevCenter pSDevCenter) throws Exception {
        EntityBase entityBase;
        if (!pSDevCenter.isFullEntity()) {
            this.get((IEntity)pSDevCenter);
        }
        PSDCResRepService pSDCResRepService = (PSDCResRepService)ServiceGlobal.getService(PSDCResRepService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterFileService pSDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterMQService pSDevCenterMQService = (PSDevCenterMQService)ServiceGlobal.getService(PSDevCenterMQService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterServerService pSDevCenterServerService = (PSDevCenterServerService)ServiceGlobal.getService(PSDevCenterServerService.class, (SessionFactory)this.getSessionFactory());
        PSDCResRep pSDCResRep = new PSDCResRep();
        SelectContext selectContext = new SelectContext();
        Object object = new SelectField();
        object.setAlias("DISKUSED");
        object.setFunc("SUM");
        object.setName("FILEOBJSIZE");
        selectContext.addSelectField((ISelectField)object);
        selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
        ArrayList arrayList = pSDevCenterFileService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u6587\u4ef6\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSDCResRep, false);
        selectContext = new SelectContext();
        selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
        object = pSDevCenterDBInstService.select((ISelectCond)selectContext);
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        Iterator iterator = ((ArrayList)object).iterator();
        while (iterator.hasNext()) {
            entityBase = (PSDevCenterDBInst)iterator.next();
            ++n;
            if (entityBase.getResPos() != null && entityBase.getResPos() == 2) {
                ++n3;
            } else {
                if (entityBase.getResState() == null || entityBase.getResState() != 20) {
                    ++n4;
                    continue;
                }
                if (entityBase.getExpriedTime() != null) {
                    if (entityBase.getExpriedTime().getTime() < System.currentTimeMillis()) {
                        ++n4;
                        continue;
                    }
                    if (entityBase.getExpriedTime().getTime() + 259200000L > System.currentTimeMillis()) {
                        ++n5;
                    }
                }
            }
            if (DataObject.getIntegerValue((Object)entityBase.getRefCount(), (Integer)0) > 0) {
                ++n2;
                continue;
            }
            ++n6;
        }
        pSDCResRep.setDBInstCnt(n);
        pSDCResRep.setUsedDBInstCnt(n2);
        pSDCResRep.setUserDBInstCnt(n3);
        pSDCResRep.setExpiredDBInstCnt(n4);
        pSDCResRep.setExpiredDBInstCnt2(n5);
        pSDCResRep.setIdleDBInstCnt(n6);
        selectContext = new SelectContext();
        selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
        object = pSDevCenterASService.select((ISelectCond)selectContext);
        n = 0;
        n2 = 0;
        n3 = 0;
        n4 = 0;
        n5 = 0;
        n6 = 0;
        iterator = ((ArrayList)object).iterator();
        while (iterator.hasNext()) {
            entityBase = (PSDevCenterAS)iterator.next();
            ++n;
            if (entityBase.getResPos() != null && entityBase.getResPos() == 2) {
                ++n6;
            } else {
                if (entityBase.getResState() == null || entityBase.getResState() != 20) {
                    ++n3;
                    continue;
                }
                if (entityBase.getExpriedTime() != null) {
                    if (entityBase.getExpriedTime().getTime() < System.currentTimeMillis()) {
                        ++n3;
                        continue;
                    }
                    if (entityBase.getExpriedTime().getTime() + 259200000L > System.currentTimeMillis()) {
                        ++n4;
                    }
                }
            }
            if (DataObject.getIntegerValue((Object)entityBase.getRefFlag(), (Integer)0) > 0) {
                ++n2;
                continue;
            }
            ++n5;
        }
        pSDCResRep.setASCnt(n);
        pSDCResRep.setUserASCnt(n6);
        pSDCResRep.setUsedASCnt(n2);
        pSDCResRep.setExpiredASCnt(n3);
        pSDCResRep.setExpiredASCnt2(n4);
        pSDCResRep.setIdleASCnt(n5);
        selectContext = new SelectContext();
        selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
        object = pSDevCenterSVNService.select((ISelectCond)selectContext);
        n = 0;
        n2 = 0;
        n3 = 0;
        n4 = 0;
        n5 = 0;
        n6 = 0;
        iterator = ((ArrayList)object).iterator();
        while (iterator.hasNext()) {
            entityBase = (PSDevCenterSVN)iterator.next();
            ++n;
            if (entityBase.getResPos() != null && entityBase.getResPos() == 2) {
                ++n6;
            } else {
                if (entityBase.getResState() == null || entityBase.getResState() != 20) {
                    ++n3;
                    continue;
                }
                if (entityBase.getExpriedTime() != null) {
                    if (entityBase.getExpriedTime().getTime() < System.currentTimeMillis()) {
                        ++n3;
                        continue;
                    }
                    if (entityBase.getExpriedTime().getTime() + 259200000L > System.currentTimeMillis()) {
                        ++n4;
                    }
                }
            }
            if (DataObject.getIntegerValue((Object)entityBase.getRefFlag(), (Integer)0) > 0) {
                ++n2;
                continue;
            }
            ++n5;
        }
        pSDCResRep.setCodeRepoCnt(n);
        pSDCResRep.setUsedCodeRepoCnt(n2);
        pSDCResRep.setUserCodeRepoCnt(n6);
        pSDCResRep.setExpiredCodeRepoCnt(n3);
        pSDCResRep.setExpiredASCnt2(n4);
        pSDCResRep.setIdleCodeRepoCnt(n5);
        pSDCResRep.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDCResRep.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
        pSDCResRep.setPSDCResRepName("\u5e94\u7528\u4e2d\u5fc3\u8d44\u6e90\u62a5\u8868");
        pSDCResRep.setRepTime(new Timestamp(System.currentTimeMillis()));
        pSDCResRep.setDefaultFlag(0);
        pSDCResRepService.create(pSDCResRep);
        pSDCResRep.setPSDCResRepName(StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3[%1$s]\u9ed8\u8ba4\u8d44\u6e90\u62a5\u8868", (Object)pSDevCenter.getPSDevCenterName()));
        pSDCResRep.setPSDCResRepId(pSDevCenter.getPSDevCenterId());
        pSDCResRep.setDefaultFlag(1);
        pSDCResRepService.save((IEntity)pSDCResRep);
    }

    @Override
    protected void onResetDC(PSDevCenter pSDevCenter) throws Exception {
        LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenter pSDevCenter2 = new PSDevCenter();
        pSDevCenter2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        this.get((IEntity)pSDevCenter2);
        pSDevCenter2.setDomainName(StringHelper.format((String)"%1$s_%2$s", (Object)pSDevCenter2.getDomainName(), (Object)random.nextInt(10000)));
        pSDevCenter2.setFullDomainName(StringHelper.format((String)"%1$s_%2$s", (Object)pSDevCenter2.getFullDomainName(), (Object)random.nextInt(10000)));
        this.sysUpdate(pSDevCenter2, false);
        PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSDevUserService.selectByPSDevCenter(pSDevCenter2);
        for (PSDevUser pSDevUser : arrayList) {
            LoginAccount loginAccount = new LoginAccount();
            if (!StringHelper.isNullOrEmpty((String)pSDevUser.getFullLoginName())) {
                loginAccount.setLoginAccountName(pSDevUser.getFullLoginName());
                if (loginAccountService.select((IEntity)loginAccount, true)) {
                    loginAccount.setLoginAccountName(StringHelper.format((String)"%1$s_%2$s", (Object)loginAccount.getLoginAccountName(), (Object)random.nextInt(10000)));
                    loginAccountService.sysUpdate((IEntity)loginAccount, false);
                }
            }
            loginAccount.reset();
            if (!StringHelper.isNullOrEmpty((String)pSDevUser.getFullLoginName2())) {
                loginAccount.setLoginAccountName(pSDevUser.getFullLoginName2());
                if (loginAccountService.select((IEntity)loginAccount, true)) {
                    loginAccount.setLoginAccountName(StringHelper.format((String)"%1$s_%2$s", (Object)loginAccount.getLoginAccountName(), (Object)random.nextInt(10000)));
                    loginAccountService.sysUpdate((IEntity)loginAccount, false);
                }
            }
            try {
                PSDevUser pSDevUser2 = new PSDevUser();
                pSDevUser2.setPSDevUserId(pSDevUser.getPSDevUserId());
                pSDevUser2.setValidFlag(0);
                pSDevUserService.sysUpdate(pSDevUser2, false);
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
    }

    @Override
    protected void onToggleInvalid(PSDevCenter pSDevCenter) throws Exception {
    }

    @Override
    protected void onToggleValid(PSDevCenter pSDevCenter) throws Exception {
    }

    protected void initLabDC(PSDevCenter pSDevCenter) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvrDomainId())) {
            pSDevCenter.setPSSvrDomainId(PSDevCenterService.getCurrentPSSvrDomainId());
        }
        if (StringHelper.isNullOrEmpty((String)pSDevCenter.getPSSvrDomainId())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u670d\u52a1\u57df");
        }
        if (StringHelper.isNullOrEmpty((String)pSDevCenter.getDCType())) {
            pSDevCenter.setDCType("DEVCENTER");
        }
        if (pSDevCenter.getSPFlag() == null) {
            pSDevCenter.setSPFlag(1);
        }
        pSDevCenter.setEnableWorkspace(1);
        if (StringHelper.isNullOrEmpty((String)pSDevCenter.getFullDomainName())) {
            pSDevCenter.setFullDomainName(pSDevCenter.getDomainName());
        }
        if (StringHelper.isNullOrEmpty((String)pSDevCenter.getV6PSSvnInstRepoId())) {
            PSSVNServerService pSSVNServerService = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class, (SessionFactory)this.getSessionFactory());
            SelectCond selectCond = new SelectCond();
            selectCond.set("SVNTYPE", (Object)"GIT");
            selectCond.set("PSSVRDOMAINID", (Object)pSDevCenter.getPSSvrDomainId());
            if (DataObject.getIntegerValue((Object)pSDevCenter.getDCLevel(), (Integer)DCLevelCodeListModel.LAB_10) >= 50) {
                selectCond.set("VALIDFLAG", (Object)2);
                selectCond.set("PSSVNSERVERID", (Object)pSDevCenter.getDomainName());
            } else {
                selectCond.set("VALIDFLAG", (Object)1);
            }
            ArrayList arrayList = pSSVNServerService.select((ISelectCond)selectCond);
            if (arrayList.size() == 0) {
                throw new Exception("\u5f53\u524d\u670d\u52a1\u57df\u6ca1\u6709GIT\u670d\u52a1\u5668");
            }
            PSSVNServer pSSVNServer = null;
            pSSVNServer = arrayList.size() == 1 ? (PSSVNServer)arrayList.get(0) : (PSSVNServer)arrayList.get((int)(System.currentTimeMillis() % (long)arrayList.size()));
            PSSVNInstRepoService pSSVNInstRepoService = (PSSVNInstRepoService)ServiceGlobal.getService(PSSVNInstRepoService.class, (SessionFactory)this.getSessionFactory());
            PSSVNInstRepo pSSVNInstRepo = new PSSVNInstRepo();
            pSSVNInstRepo.setPSSVNInstRepoName(StringHelper.format((String)"\u4e2d\u5fc3[%1$s]\u9ed8\u8ba4\u4ed3\u5e93", (Object)pSDevCenter.getPSDevCenterName()));
            pSSVNInstRepo.setGitPath(pSSVNServer.getGitPath());
            pSSVNInstRepo.setSVNType("GIT");
            pSSVNInstRepo.setConnStr(pSSVNServer.getGitPath());
            pSSVNInstRepo.setPSSvrDomainId(pSSVNServer.getPSSvrDomainId());
            pSSVNInstRepo.setPSSVNServerId(pSSVNServer.getPSSVNServerId());
            pSSVNInstRepo.setLocalRes(0);
            pSSVNInstRepo.setRepoState(30);
            try {
                pSSVNInstRepoService.create(pSSVNInstRepo);
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u4e2d\u5fc3\u9ed8\u8ba4\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u4e2d\u5fc3\u9ed8\u8ba4\u4ed3\u5e93\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
            }
            pSDevCenter.setV6PSSvnInstRepoId(pSSVNInstRepo.getPSSVNInstRepoId());
            pSDevCenter.setV6PSSvnInstRepoName(pSSVNInstRepo.getPSSVNInstRepoName());
        }
    }

    protected void afterCreateLabDC(PSDevCenter pSDevCenter) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
        Object object = new SelectCond();
        object.set("VALIDFLAG", (Object)1);
        object.set("PSSVRDOMAINID", (Object)pSDevCenter.getPSSvrDomainId());
        Object object2 = pSCoreSysServiceBase.select((ISelectCond)object);
        if (((ArrayList)object2).size() == 0) {
            throw new Exception("\u5f53\u524d\u670d\u52a1\u57df\u6ca1\u6709\u4efb\u52a1\u670d\u52a1\u5668");
        }
        PSTaskServer pSTaskServer = null;
        pSTaskServer = ((ArrayList)object2).size() == 1 ? (PSTaskServer)((ArrayList)object2).get(0) : (PSTaskServer)((ArrayList)object2).get((int)(System.currentTimeMillis() % (long)((ArrayList)object2).size()));
        Object object3 = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)this.getSessionFactory());
        Object object4 = new PSDevCenterTS();
        ((PSDevCenterTSBase)object4).setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        ((PSDevCenterTSBase)object4).setPSDevCenterName(pSDevCenter.getPSDevCenterName());
        ((PSDevCenterTSBase)object4).setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        ((PSDevCenterTSBase)object4).setPSTaskServerName(pSTaskServer.getPSTaskServerName());
        ((PSDevCenterTSBase)object4).setPSDevCenterTSName(pSTaskServer.getPSTaskServerName());
        ((PSCoreSysServiceBase)object3).create(object4, false);
        pSCoreSysServiceBase = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
        object = new PSDevUser();
        ((PSDevUserBase)object).setPSDevUserName(pSDevCenter.getPSDevCenterName());
        ((PSDevUserObjBase)object).setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        ((PSDevUserObjBase)object).setPSDevCenterName(pSDevCenter.getPSDevCenterName());
        ((PSDevUserBase)object).setAdminMode(1);
        ((PSDevUserObjBase)object).setDefaultFlag(1);
        if (PSDevCenterService.isCloudMode()) {
            ((PSDevUserBase)object).setLoginName(String.format("%1$s_admin", pSDevCenter.getDomainName()));
        } else {
            ((PSDevUserBase)object).setLoginName(pSDevCenter.getDomainName());
        }
        object2 = pSDevCenter.getWebFolder();
        if (!StringHelper.isNullOrEmpty((String)object2)) {
            pSTaskServer = (ObjectNode)JsonNodeHelper.fromString((String)object2);
            object3 = JsonNodeHelper.getString((ObjectNode)pSTaskServer, (String)"password", null);
            object4 = JsonNodeHelper.getString((ObjectNode)pSTaskServer, (String)"mobile", null);
            ((PSDevUserBase)object).setLoginPwd((String)object3);
            pSDevCenter.reset();
            pSDevCenter.setPSDevCenterId(((PSDevUserObjBase)object).getPSDevCenterId());
            pSDevCenter.setWebFolder(null);
            this.sysUpdate(pSDevCenter, true);
        }
        try {
            pSCoreSysServiceBase.create(object);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u4e2d\u5fc3\u9ed8\u8ba4\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u4e2d\u5fc3\u9ed8\u8ba4\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    protected void onChangeLevel(PSDevCenter pSDevCenter) throws Exception {
        Object object;
        if (pSDevCenter.getDCLevel() == null) {
            this.get((IEntity)pSDevCenter);
        } else {
            object = (PSDevCenter)this.getLast((IEntity)pSDevCenter);
            this.update(pSDevCenter);
        }
        if (PSDevCenterHelper.isLabDC(pSDevCenter)) {
            if (PSDevCenterService.isEnableGitLabPlugin()) {
                object = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)this.getSessionFactory());
                SelectContext selectContext = new SelectContext();
                selectContext.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
                selectContext.setDEDataQueryName("CtxDC");
                ArrayList arrayList = object.select((ISelectCond)selectContext);
                for (PSDevSlnUser pSDevSlnUser : arrayList) {
                    if (StringHelper.isNullOrEmpty((String)pSDevSlnUser.getDevUserObjType())) {
                        pSDevSlnUser.setDevUserObjType(DataObject.getStringValue((Object)pSDevSlnUser.get("PSDEVUSEROBJTYPE"), null));
                        if (StringHelper.isNullOrEmpty((String)pSDevSlnUser.getDevUserObjType())) continue;
                    }
                    if (StringHelper.isNullOrEmpty((String)pSDevSlnUser.getPSDevUserObjId())) continue;
                    try {
                        PSDevCenterService.getPSGitLabPlugin().updateMemberByPSDevSlnUser(pSDevSlnUser);
                    }
                    catch (Exception exception) {
                        log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u65b9\u6848\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                        throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u65b9\u6848\u6210\u5458\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
                    }
                }
            } else {
                throw new Exception(StringHelper.format((String)"\u672a\u914d\u7f6eGitLab\u63d2\u4ef6"));
            }
        }
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected void onBeforeRemove(PSDevCenter pSDevCenter) throws Exception {
        if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
            PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
            selectCond.set("DEFAULTFLAG", (Object)1);
            ArrayList arrayList = pSDevUserService.select((ISelectCond)selectCond);
            for (PSDevUser pSDevUser : arrayList) {
                PSDevUser pSDevUser2 = new PSDevUser();
                pSDevUser2.setPSDevUserId(pSDevUser.getPSDevUserId());
                pSDevUser2.setDefaultFlag(0);
                pSDevUserService.sysUpdate(pSDevUser2, false);
            }
        }
        super.onBeforeRemove(pSDevCenter);
    }

    protected CallResult internalGet(PSDevCenter pSDevCenter, boolean bl) throws Exception {
        CallResult callResult = super.internalGet((IEntity)pSDevCenter, bl);
        if (callResult.isOk()) {
            PSDevCenterHelper.fillPSDevCenter(pSDevCenter, null);
        }
        return callResult;
    }

    @Override
    protected void onInitDCWorkspaces(PSDevCenter pSDevCenter) throws Exception {
        this.get((IEntity)pSDevCenter);
        int n = 10;
        int n2 = 9999;
        PSWorkspaceService pSWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        ArrayList<PSWorkspace> arrayList = new ArrayList<PSWorkspace>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() + (long)(n2 * 24 * 60 * 60 * 1000));
        if (n2 >= 9999) {
            timestamp = null;
        }
        String string = String.format("%1$tY%1$tm%1$td", new Date());
        for (int i = 0; i < n && PSDevCenterHelper.testCreate(pSDevCenter, "WORKSPACECNT", true); ++i) {
            PSWorkspace pSWorkspace = new PSWorkspace();
            pSWorkspace.setPSWorkspaceName(String.format("\u751f\u4ea7\u7ebf[%1$s]_%2$s_%3$s", pSDevCenter.getPSDevCenterName(), string, random.nextInt(9999999)));
            pSWorkspace.setExpiredTime(timestamp);
            pSWorkspace.setWorkspaceState(20);
            pSWorkspace.setWorkspaceType("CLOUD");
            pSWorkspace.setWorkspaceUsage("CLOUD");
            pSWorkspace.setPSSvrDomainId(pSDevCenter.getPSSvrDomainId());
            pSWorkspace.setPSSvrDomainName(pSDevCenter.getPSSvrDomainName());
            pSWorkspaceService.create(pSWorkspace);
            arrayList.add(pSWorkspace);
        }
        for (PSWorkspace pSWorkspace : arrayList) {
            pSWorkspace.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSWorkspace.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
            pSWorkspaceService.bindDC(pSWorkspace);
        }
    }
}

