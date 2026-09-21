/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysUserRoleResDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserRoleResDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPriv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysOPPrivBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserRoleRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUserRoleResServiceBase
extends PSCoreSysServiceBase<PSSysUserRoleRes> {
    private static final Log log = LogFactory.getLog(PSSysUserRoleResServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSSysUserRoleResDEModel pSSysUserRoleResDEModel;
    private PSSysUserRoleResDAO pSSysUserRoleResDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysUserRoleResService";
    }

    public PSSysUserRoleResDEModel getPSSysUserRoleResDEModel() {
        if (this.pSSysUserRoleResDEModel == null) {
            try {
                this.pSSysUserRoleResDEModel = (PSSysUserRoleResDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysUserRoleResDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUserRoleResDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysUserRoleResDEModel();
    }

    public PSSysUserRoleResDAO getPSSysUserRoleResDAO() {
        if (this.pSSysUserRoleResDAO == null) {
            try {
                this.pSSysUserRoleResDAO = (PSSysUserRoleResDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysUserRoleResDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysUserRoleResDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysUserRoleResDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    protected void onFillParentInfo(PSSysUserRoleRes pSSysUserRoleRes, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysOPPrivService", (SessionFactory)this.getSessionFactory());
            PSSysOPPriv pSSysOPPriv = (PSSysOPPriv)iService.getDEModel().createEntity();
            pSSysOPPriv.set("PSSYSOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysOPPriv);
            } else {
                iService.get((IEntity)pSSysOPPriv);
            }
            this.onFillParentInfo_PSSysOPPriv(pSSysUserRoleRes, pSSysOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSUSERROLERES_PSSYSUNIRES_PSSYSUNIRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService", (SessionFactory)this.getSessionFactory());
            PSSysUniRes pSSysUniRes = (PSSysUniRes)iService.getDEModel().createEntity();
            pSSysUniRes.set("PSSYSUNIRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUniRes);
            } else {
                iService.get((IEntity)pSSysUniRes);
            }
            this.onFillParentInfo_PSSysUniRes(pSSysUserRoleRes, pSSysUniRes);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysUserRoleRes, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSSysOPPriv(PSSysUserRoleRes pSSysUserRoleRes, PSSysOPPriv pSSysOPPriv) throws Exception {
        pSSysUserRoleRes.setPSSysOPPrivId(pSSysOPPriv.getPSSysOPPrivId());
        pSSysUserRoleRes.setPSSysOPPrivName(pSSysOPPriv.getPSSysOPPrivName());
    }

    protected void onFillParentInfo_PSSysUniRes(PSSysUserRoleRes pSSysUserRoleRes, PSSysUniRes pSSysUniRes) throws Exception {
        pSSysUserRoleRes.setPSSysUniResId(pSSysUniRes.getPSSysUniResId());
        pSSysUserRoleRes.setPSSysUniResName(pSSysUniRes.getPSSysUniResName());
    }

    protected boolean onFillEntityKeyValue(PSSysUserRoleRes pSSysUserRoleRes, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSSysUserRoleRes.get("PSSYSOPPRIVID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSSysUserRoleRes.get("PSSYSUNIRESID");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSSysUserRoleRes.set(this.getPSSysUserRoleResDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSSysUserRoleRes pSSysUserRoleRes, boolean bl) throws Exception {
        if (bl) {
            if (pSSysUserRoleRes.getPSSysUserRoleResName() == null) {
                pSSysUserRoleRes.setPSSysUserRoleResName((String)this.getDefaultValue(this.getWebContext(), "", "\u89d2\u8272\u8d44\u6e90", 25));
            }
            if (pSSysUserRoleRes.getValidFlag() == null) {
                pSSysUserRoleRes.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysUserRoleRes, bl);
        this.onFillEntityFullInfo_PSSysOPPriv(pSSysUserRoleRes, bl);
        this.onFillEntityFullInfo_PSSysUniRes(pSSysUserRoleRes, bl);
    }

    protected void onFillEntityFullInfo_PSSysOPPriv(PSSysUserRoleRes pSSysUserRoleRes, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUniRes(PSSysUserRoleRes pSSysUserRoleRes, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysUserRoleRes pSSysUserRoleRes, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysUserRoleRes, bl);
    }

    public ArrayList<PSSysUserRoleRes> selectByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase) throws Exception {
        return this.selectByPSSysOPPriv(pSSysOPPrivBase, "", -1);
    }

    public ArrayList<PSSysUserRoleRes> selectByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase, String string) throws Exception {
        return this.selectByPSSysOPPriv(pSSysOPPrivBase, string, -1);
    }

    public ArrayList<PSSysUserRoleRes> selectByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSOPPRIVID", (Object)pSSysOPPrivBase.getPSSysOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserRoleRes> selectTempByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase) throws Exception {
        return this.selectTempByPSSysOPPriv(pSSysOPPrivBase, "");
    }

    public ArrayList<PSSysUserRoleRes> selectTempByPSSysOPPriv(PSSysOPPrivBase pSSysOPPrivBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSOPPRIVID", (Object)pSSysOPPrivBase.getPSSysOPPrivId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysOPPrivCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysUserRoleRes> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, "", -1);
    }

    public ArrayList<PSSysUserRoleRes> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string) throws Exception {
        return this.selectByPSSysUniRes(pSSysUniResBase, string, -1);
    }

    public ArrayList<PSSysUserRoleRes> selectByPSSysUniRes(PSSysUniResBase pSSysUniResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUNIRESID", (Object)pSSysUniResBase.getPSSysUniResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUniResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUniResCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSSysUserRoleRes> arrayList = this.selectByPSSysOPPriv(pSSysOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID", "", iDataEntityModel.getName(), "PSSYSUSERROLERES", iDataEntityModel.getDataInfo((IEntity)pSSysOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSSysUserRoleRes> arrayList = this.selectByPSSysOPPriv(pSSysOPPriv);
        for (PSSysUserRoleRes pSSysUserRoleRes : arrayList) {
            PSSysUserRoleRes pSSysUserRoleRes2 = (PSSysUserRoleRes)this.getDEModel().createEntity();
            pSSysUserRoleRes2.setPSSysUserRoleResId(pSSysUserRoleRes.getPSSysUserRoleResId());
            pSSysUserRoleRes2.setPSSysOPPrivId(null);
            this.update(pSSysUserRoleRes2);
        }
    }

    public void removeByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        final PSSysOPPriv pSSysOPPriv2 = pSSysOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserRoleResServiceBase.this.onBeforeRemoveByPSSysOPPriv(pSSysOPPriv2);
                PSSysUserRoleResServiceBase.this.internalRemoveByPSSysOPPriv(pSSysOPPriv2);
                PSSysUserRoleResServiceBase.this.onAfterRemoveByPSSysOPPriv(pSSysOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void internalRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSSysUserRoleRes> arrayList = this.selectByPSSysOPPriv(pSSysOPPriv);
        this.onBeforeRemoveByPSSysOPPriv(pSSysOPPriv, arrayList);
        for (PSSysUserRoleRes pSSysUserRoleRes : arrayList) {
            this.remove((IEntity)pSSysUserRoleRes);
        }
        this.onAfterRemoveByPSSysOPPriv(pSSysOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSSysUserRoleRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSSysUserRoleRes> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysUserRoleRes> arrayList = this.selectByPSSysUniRes(pSSysUniRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUNIRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUniRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSUSERROLERES_PSSYSUNIRES_PSSYSUNIRESID", "", iDataEntityModel.getName(), "PSSYSUSERROLERES", iDataEntityModel.getDataInfo((IEntity)pSSysUniRes), arrayList.get(0)));
        }
    }

    public void resetPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysUserRoleRes> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        for (PSSysUserRoleRes pSSysUserRoleRes : arrayList) {
            PSSysUserRoleRes pSSysUserRoleRes2 = (PSSysUserRoleRes)this.getDEModel().createEntity();
            pSSysUserRoleRes2.setPSSysUserRoleResId(pSSysUserRoleRes.getPSSysUserRoleResId());
            pSSysUserRoleRes2.setPSSysUniResId(null);
            this.update(pSSysUserRoleRes2);
        }
    }

    public void removeByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        final PSSysUniRes pSSysUniRes2 = pSSysUniRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserRoleResServiceBase.this.onBeforeRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysUserRoleResServiceBase.this.internalRemoveByPSSysUniRes(pSSysUniRes2);
                PSSysUserRoleResServiceBase.this.onAfterRemoveByPSSysUniRes(pSSysUniRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void internalRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
        ArrayList<PSSysUserRoleRes> arrayList = this.selectByPSSysUniRes(pSSysUniRes);
        this.onBeforeRemoveByPSSysUniRes(pSSysUniRes, arrayList);
        for (PSSysUserRoleRes pSSysUserRoleRes : arrayList) {
            this.remove((IEntity)pSSysUserRoleRes);
        }
        this.onAfterRemoveByPSSysUniRes(pSSysUniRes, arrayList);
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysUserRoleRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUniRes(PSSysUniRes pSSysUniRes, ArrayList<PSSysUserRoleRes> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysUserRoleRes pSSysUserRoleRes) throws Exception {
        super.onBeforeRemove(pSSysUserRoleRes);
    }

    public void removeTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        final PSSysOPPriv pSSysOPPriv2 = pSSysOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysUserRoleResServiceBase.this.onBeforeRemoveTempByPSSysOPPriv(pSSysOPPriv2);
                PSSysUserRoleResServiceBase.this.internalRemoveTempByPSSysOPPriv(pSSysOPPriv2);
                PSSysUserRoleResServiceBase.this.onAfterRemoveTempByPSSysOPPriv(pSSysOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void internalRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
        ArrayList<PSSysUserRoleRes> arrayList = this.selectTempByPSSysOPPriv(pSSysOPPriv);
        this.onBeforeRemoveTempByPSSysOPPriv(pSSysOPPriv, arrayList);
        for (PSSysUserRoleRes pSSysUserRoleRes : arrayList) {
            this.removeTemp((IEntity)pSSysUserRoleRes);
        }
        this.onAfterRemoveTempByPSSysOPPriv(pSSysOPPriv, arrayList);
    }

    protected void onAfterRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSSysUserRoleRes> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysOPPriv(PSSysOPPriv pSSysOPPriv, ArrayList<PSSysUserRoleRes> arrayList) throws Exception {
    }

    protected void replaceParentInfo(PSSysUserRoleRes pSSysUserRoleRes, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysUserRoleRes, cloneSession);
        if (pSSysUserRoleRes.getPSSysOPPrivId() != null && (iEntity = cloneSession.getEntity("PSSYSOPPRIV", (Object)pSSysUserRoleRes.getPSSysOPPrivId())) != null) {
            this.onFillParentInfo_PSSysOPPriv(pSSysUserRoleRes, (PSSysOPPriv)iEntity);
        }
        if (pSSysUserRoleRes.getPSSysUniResId() != null && (iEntity = cloneSession.getEntity("PSSYSUNIRES", (Object)pSSysUserRoleRes.getPSSysUniResId())) != null) {
            this.onFillParentInfo_PSSysUniRes(pSSysUserRoleRes, (PSSysUniRes)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysUserRoleRes pSSysUserRoleRes, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysUserRoleRes, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_Memo(bl, pSSysUserRoleRes, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysOPPrivId(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUniResId(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserRoleResId(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUserRoleResName(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResModel(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSSysUserRoleRes, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysUserRoleRes, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isMemoDirty() : !pSSysUserRoleRes.isMemoDirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysOPPrivId(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isPSSysOPPrivIdDirty() && !bl2 : !pSSysUserRoleRes.isPSSysOPPrivIdDirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getPSSysOPPrivId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOPPRIVID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysOPPrivId_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUniResId(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isPSSysUniResIdDirty() && !bl2 : !pSSysUserRoleRes.isPSSysUniResIdDirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getPSSysUniResId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUniResId_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUNIRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserRoleResId(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isPSSysUserRoleResIdDirty() && !bl2 : !pSSysUserRoleRes.isPSSysUserRoleResIdDirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getPSSysUserRoleResId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERROLERESID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserRoleResId_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERROLERESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysUserRoleResName(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isPSSysUserRoleResNameDirty() : !pSSysUserRoleRes.isPSSysUserRoleResNameDirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getPSSysUserRoleResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUserRoleResName_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUSERROLERESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResModel(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isResModelDirty() : !pSSysUserRoleRes.isResModelDirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getResModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResModel_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isUserCatDirty() : !pSSysUserRoleRes.isUserCatDirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isUserTagDirty() : !pSSysUserRoleRes.isUserTagDirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isUserTag2Dirty() : !pSSysUserRoleRes.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isUserTag3Dirty() : !pSSysUserRoleRes.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isUserTag4Dirty() : !pSSysUserRoleRes.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysUserRoleRes.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSSysUserRoleRes pSSysUserRoleRes, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysUserRoleRes.isValidFlagDirty() && !bl2 : !pSSysUserRoleRes.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSSysUserRoleRes.getValidFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSSysUserRoleRes, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysUserRoleRes pSSysUserRoleRes, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysUserRoleRes, bl);
    }

    protected void onSyncIndexEntities(PSSysUserRoleRes pSSysUserRoleRes, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysUserRoleRes, bl);
    }

    public Object getDataContextValue(PSSysUserRoleRes pSSysUserRoleRes, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysUserRoleRes, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysOPPriv pSSysOPPriv = pSSysUserRoleRes.getPSSysOPPriv();
        if (pSSysOPPriv != null && pSSysOPPriv.contains(string)) {
            return pSSysOPPriv.get(string);
        }
        PSSysUniRes pSSysUniRes = pSSysUserRoleRes.getPSSysUniRes();
        if (pSSysUniRes != null && pSSysUniRes.contains(string)) {
            return pSSysUniRes.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysUserRoleRes pSSysUserRoleRes, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysUserRoleRes, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUNIRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUniResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERROLERESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserRoleResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUSERROLERESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUserRoleResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUniResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUNIRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserRoleResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERROLERESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUserRoleResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUSERROLERESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected boolean onMergeChild(String string, String string2, PSSysUserRoleRes pSSysUserRoleRes) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysUserRoleRes)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysUserRoleRes pSSysUserRoleRes) throws Exception {
        super.onUpdateParent((IEntity)pSSysUserRoleRes);
    }

    @Override
    protected void exportCurXmlModel(PSSysUserRoleRes pSSysUserRoleRes, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSUSERROLERES");
        if (!bl) {
            pSSysUserRoleRes.setCreateDate(null);
            pSSysUserRoleRes.setCreateMan(null);
            pSSysUserRoleRes.setPSSysUserRoleResId(null);
            pSSysUserRoleRes.setUpdateDate(null);
            pSSysUserRoleRes.setUpdateMan(null);
            pSSysUserRoleRes.setPSSysOPPrivId(null);
            super.exportCurXmlModel(pSSysUserRoleRes, xmlNode, bl);
        }
    }

    @Override
    protected String getEntityFolderKeyValue(PSSysUserRoleRes pSSysUserRoleRes, PSSystem pSSystem) throws Exception {
        PSSysUserRoleRes pSSysUserRoleRes2 = new PSSysUserRoleRes();
        pSSysUserRoleRes2.setPSSysOPPrivId(pSSysUserRoleRes.getPSSysOPPrivId());
        pSSysUserRoleRes2.setPSSysUniResId(pSSysUserRoleRes.getPSSysUniResId());
        if (this.selectOne((IEntity)pSSysUserRoleRes2, true)) {
            return pSSysUserRoleRes2.getPSSysUserRoleResId();
        }
        return super.getEntityFolderKeyValue(pSSysUserRoleRes, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysUserRoleRes pSSysUserRoleRes, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysUserRoleRes, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSOPPRIV#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSUSERROLERES_PSSYSOPPRIV_PSSYSOPPRIVID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSOPPRIVNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSOPPRIV", (boolean)true) == 0) {
            iEntity.set("PSSYSOPPRIVID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSSYSOPPRIVID"};
    }

    @Override
    public String getModelV2Tag(PSSysUserRoleRes pSSysUserRoleRes) {
        return super.getModelV2Tag(pSSysUserRoleRes);
    }

    @Override
    public boolean setModelV2Tag(PSSysUserRoleRes pSSysUserRoleRes, String string) {
        return super.setModelV2Tag(pSSysUserRoleRes, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSOPPRIVID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysUserRoleRes pSSysUserRoleRes, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysUserRoleRes.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysUserRoleRes, true);
        return super.getModelV2Entity(pSSysUserRoleRes, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysUserRoleRes pSSysUserRoleRes, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysUserRoleRes, objectNode, string, string2, n);
    }
}

