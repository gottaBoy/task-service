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
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.appdesign.service;

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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.dao.PSMobAppPackTDDAO;
import net.ibizsys.pscore.srv.appdesign.demodel.PSMobAppPackTDDEModel;
import net.ibizsys.pscore.srv.appdesign.entity.PSDCMobPackCert;
import net.ibizsys.pscore.srv.appdesign.entity.PSDCMobPackCertBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPackBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPackTD;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTestDevice;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTestDeviceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMobAppPackTDServiceBase
extends PSCoreSysServiceBase<PSMobAppPackTD> {
    private static final Log log = LogFactory.getLog(PSMobAppPackTDServiceBase.class);
    public static final String DATASET_DEFAULT = "DEFAULT";
    private PSMobAppPackTDDEModel pSMobAppPackTDDEModel;
    private PSMobAppPackTDDAO pSMobAppPackTDDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackTDService";
    }

    public PSMobAppPackTDDEModel getPSMobAppPackTDDEModel() {
        if (this.pSMobAppPackTDDEModel == null) {
            try {
                this.pSMobAppPackTDDEModel = (PSMobAppPackTDDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.appdesign.demodel.PSMobAppPackTDDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMobAppPackTDDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSMobAppPackTDDEModel();
    }

    public PSMobAppPackTDDAO getPSMobAppPackTDDAO() {
        if (this.pSMobAppPackTDDAO == null) {
            try {
                this.pSMobAppPackTDDAO = (PSMobAppPackTDDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.appdesign.dao.PSMobAppPackTDDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSMobAppPackTDDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSMobAppPackTDDAO();
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

    protected void onFillParentInfo(PSMobAppPackTD pSMobAppPackTD, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOBAPPPACKTD_PSDCMOBAPPTESTDEVICE_PSDCMOBAPPTESTDEVICEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceService", (SessionFactory)this.getSessionFactory());
            PSDCMobAppTestDevice pSDCMobAppTestDevice = (PSDCMobAppTestDevice)iService.getDEModel().createEntity();
            pSDCMobAppTestDevice.set("PSDCMOBAPPTESTDEVICEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCMobAppTestDevice);
            } else {
                iService.get(pSDCMobAppTestDevice);
            }
            this.onFillParentInfo_PSDCMobAppTestDevice(pSMobAppPackTD, pSDCMobAppTestDevice);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOBAPPPACKTD_PSDCMOBPACKCERT_PSDCMOBPACKCERTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSDCMobPackCertService", (SessionFactory)this.getSessionFactory());
            PSDCMobPackCert pSDCMobPackCert = (PSDCMobPackCert)iService.getDEModel().createEntity();
            pSDCMobPackCert.set("PSDCMOBPACKCERTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCMobPackCert);
            } else {
                iService.get(pSDCMobPackCert);
            }
            this.onFillParentInfo_PSDCMobPackCert(pSMobAppPackTD, pSDCMobPackCert);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSMOBAPPPACKTD_PSMOBAPPPACK_PSMOBAPPPACKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService", (SessionFactory)this.getSessionFactory());
            PSMobAppPack pSMobAppPack = (PSMobAppPack)iService.getDEModel().createEntity();
            pSMobAppPack.set("PSMOBAPPPACKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSMobAppPack);
            } else {
                iService.get(pSMobAppPack);
            }
            this.onFillParentInfo_PSMobAppPack(pSMobAppPackTD, pSMobAppPack);
            return;
        }
        super.onFillParentInfo(pSMobAppPackTD, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDCMobAppTestDevice(PSMobAppPackTD pSMobAppPackTD, PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        pSMobAppPackTD.setPSDCMobAppTestDeviceId(pSDCMobAppTestDevice.getPSDCMobAppTestDeviceId());
        pSMobAppPackTD.setPSDCMobAppTestDeviceName(pSDCMobAppTestDevice.getPSDCMobAppTestDeviceName());
    }

    protected void onFillParentInfo_PSDCMobPackCert(PSMobAppPackTD pSMobAppPackTD, PSDCMobPackCert pSDCMobPackCert) throws Exception {
        pSMobAppPackTD.setPSDCMobPackCertId(pSDCMobPackCert.getPSDCMobPackCertId());
        pSMobAppPackTD.setPSDCMobPackCertName(pSDCMobPackCert.getPSDCMobPackCertName());
    }

    protected void onFillParentInfo_PSMobAppPack(PSMobAppPackTD pSMobAppPackTD, PSMobAppPack pSMobAppPack) throws Exception {
        pSMobAppPackTD.setPSMobAppPackId(pSMobAppPack.getPSMobAppPackId());
        pSMobAppPackTD.setPSMobAppPackName(pSMobAppPack.getPSMobAppPackName());
    }

    protected void onFillEntityFullInfo(PSMobAppPackTD pSMobAppPackTD, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSMobAppPackTD, bl);
        this.onFillEntityFullInfo_PSDCMobAppTestDevice(pSMobAppPackTD, bl);
        this.onFillEntityFullInfo_PSDCMobPackCert(pSMobAppPackTD, bl);
        this.onFillEntityFullInfo_PSMobAppPack(pSMobAppPackTD, bl);
    }

    protected void onFillEntityFullInfo_PSDCMobAppTestDevice(PSMobAppPackTD pSMobAppPackTD, boolean bl) throws Exception {
        if (pSMobAppPackTD.isPSDCMobAppTestDeviceIdDirty()) {
            if (pSMobAppPackTD.getPSDCMobAppTestDeviceId() != null) {
                if (pSMobAppPackTD.getPSDCMobAppTestDeviceId() == null || pSMobAppPackTD.getPSDCMobAppTestDeviceName() == null) {
                    PSDCMobAppTestDevice pSDCMobAppTestDevice = pSMobAppPackTD.getPSDCMobAppTestDevice();
                    pSMobAppPackTD.setPSDCMobAppTestDeviceName(pSDCMobAppTestDevice.getPSDCMobAppTestDeviceName());
                }
            } else {
                pSMobAppPackTD.setPSDCMobAppTestDeviceName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDCMobPackCert(PSMobAppPackTD pSMobAppPackTD, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSMobAppPack(PSMobAppPackTD pSMobAppPackTD, boolean bl) throws Exception {
        if (pSMobAppPackTD.isPSMobAppPackIdDirty()) {
            if (pSMobAppPackTD.getPSMobAppPackId() != null) {
                if (pSMobAppPackTD.getPSMobAppPackId() == null || pSMobAppPackTD.getPSMobAppPackName() == null) {
                    PSMobAppPack pSMobAppPack = pSMobAppPackTD.getPSMobAppPack();
                    pSMobAppPackTD.setPSMobAppPackName(pSMobAppPack.getPSMobAppPackName());
                }
            } else {
                pSMobAppPackTD.setPSMobAppPackName(null);
            }
        }
    }

    protected void onWriteBackParent(PSMobAppPackTD pSMobAppPackTD, boolean bl) throws Exception {
        super.onWriteBackParent(pSMobAppPackTD, bl);
    }

    public ArrayList<PSMobAppPackTD> selectByPSDCMobAppTestDevice(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase) throws Exception {
        return this.selectByPSDCMobAppTestDevice(pSDCMobAppTestDeviceBase, "", -1);
    }

    public ArrayList<PSMobAppPackTD> selectByPSDCMobAppTestDevice(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, String string) throws Exception {
        return this.selectByPSDCMobAppTestDevice(pSDCMobAppTestDeviceBase, string, -1);
    }

    public ArrayList<PSMobAppPackTD> selectByPSDCMobAppTestDevice(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMOBAPPTESTDEVICEID", (Object)pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMobAppTestDeviceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMobAppTestDeviceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSMobAppPackTD> selectByPSDCMobPackCert(PSDCMobPackCertBase pSDCMobPackCertBase) throws Exception {
        return this.selectByPSDCMobPackCert(pSDCMobPackCertBase, "", -1);
    }

    public ArrayList<PSMobAppPackTD> selectByPSDCMobPackCert(PSDCMobPackCertBase pSDCMobPackCertBase, String string) throws Exception {
        return this.selectByPSDCMobPackCert(pSDCMobPackCertBase, string, -1);
    }

    public ArrayList<PSMobAppPackTD> selectByPSDCMobPackCert(PSDCMobPackCertBase pSDCMobPackCertBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMOBPACKCERTID", (Object)pSDCMobPackCertBase.getPSDCMobPackCertId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCMobPackCertCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCMobPackCertCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSMobAppPackTD> selectByPSMobAppPack(PSMobAppPackBase pSMobAppPackBase) throws Exception {
        return this.selectByPSMobAppPack(pSMobAppPackBase, "", -1);
    }

    public ArrayList<PSMobAppPackTD> selectByPSMobAppPack(PSMobAppPackBase pSMobAppPackBase, String string) throws Exception {
        return this.selectByPSMobAppPack(pSMobAppPackBase, string, -1);
    }

    public ArrayList<PSMobAppPackTD> selectByPSMobAppPack(PSMobAppPackBase pSMobAppPackBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMOBAPPPACKID", (Object)pSMobAppPackBase.getPSMobAppPackId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSMobAppPackCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSMobAppPackCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
    }

    public void resetPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        ArrayList<PSMobAppPackTD> arrayList = this.selectByPSDCMobAppTestDevice(pSDCMobAppTestDevice);
        for (PSMobAppPackTD pSMobAppPackTD : arrayList) {
            PSMobAppPackTD pSMobAppPackTD2 = (PSMobAppPackTD)this.getDEModel().createEntity();
            pSMobAppPackTD2.setPSMobAppPackTDId(pSMobAppPackTD.getPSMobAppPackTDId());
            pSMobAppPackTD2.setPSDCMobAppTestDeviceId(null);
            this.update(pSMobAppPackTD2);
        }
    }

    public void removeByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        final PSDCMobAppTestDevice pSDCMobAppTestDevice2 = pSDCMobAppTestDevice;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMobAppPackTDServiceBase.this.onBeforeRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice2);
                PSMobAppPackTDServiceBase.this.internalRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice2);
                PSMobAppPackTDServiceBase.this.onAfterRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
    }

    protected void internalRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
        ArrayList<PSMobAppPackTD> arrayList = this.selectByPSDCMobAppTestDevice(pSDCMobAppTestDevice);
        this.onBeforeRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice, arrayList);
        for (PSMobAppPackTD pSMobAppPackTD : arrayList) {
            this.remove(pSMobAppPackTD);
        }
        this.onAfterRemoveByPSDCMobAppTestDevice(pSDCMobAppTestDevice, arrayList);
    }

    protected void onAfterRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice, ArrayList<PSMobAppPackTD> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMobAppTestDevice(PSDCMobAppTestDevice pSDCMobAppTestDevice, ArrayList<PSMobAppPackTD> arrayList) throws Exception {
    }

    public void testRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
    }

    public void resetPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        ArrayList<PSMobAppPackTD> arrayList = this.selectByPSDCMobPackCert(pSDCMobPackCert);
        for (PSMobAppPackTD pSMobAppPackTD : arrayList) {
            PSMobAppPackTD pSMobAppPackTD2 = (PSMobAppPackTD)this.getDEModel().createEntity();
            pSMobAppPackTD2.setPSMobAppPackTDId(pSMobAppPackTD.getPSMobAppPackTDId());
            pSMobAppPackTD2.setPSDCMobPackCertId(null);
            this.update(pSMobAppPackTD2);
        }
    }

    public void removeByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        final PSDCMobPackCert pSDCMobPackCert2 = pSDCMobPackCert;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMobAppPackTDServiceBase.this.onBeforeRemoveByPSDCMobPackCert(pSDCMobPackCert2);
                PSMobAppPackTDServiceBase.this.internalRemoveByPSDCMobPackCert(pSDCMobPackCert2);
                PSMobAppPackTDServiceBase.this.onAfterRemoveByPSDCMobPackCert(pSDCMobPackCert2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
    }

    protected void internalRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
        ArrayList<PSMobAppPackTD> arrayList = this.selectByPSDCMobPackCert(pSDCMobPackCert);
        this.onBeforeRemoveByPSDCMobPackCert(pSDCMobPackCert, arrayList);
        for (PSMobAppPackTD pSMobAppPackTD : arrayList) {
            this.remove(pSMobAppPackTD);
        }
        this.onAfterRemoveByPSDCMobPackCert(pSDCMobPackCert, arrayList);
    }

    protected void onAfterRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert) throws Exception {
    }

    protected void onBeforeRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert, ArrayList<PSMobAppPackTD> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCMobPackCert(PSDCMobPackCert pSDCMobPackCert, ArrayList<PSMobAppPackTD> arrayList) throws Exception {
    }

    public void testRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
    }

    public void resetPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
        ArrayList<PSMobAppPackTD> arrayList = this.selectByPSMobAppPack(pSMobAppPack);
        for (PSMobAppPackTD pSMobAppPackTD : arrayList) {
            PSMobAppPackTD pSMobAppPackTD2 = (PSMobAppPackTD)this.getDEModel().createEntity();
            pSMobAppPackTD2.setPSMobAppPackTDId(pSMobAppPackTD.getPSMobAppPackTDId());
            pSMobAppPackTD2.setPSMobAppPackId(null);
            this.update(pSMobAppPackTD2);
        }
    }

    public void removeByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
        final PSMobAppPack pSMobAppPack2 = pSMobAppPack;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMobAppPackTDServiceBase.this.onBeforeRemoveByPSMobAppPack(pSMobAppPack2);
                PSMobAppPackTDServiceBase.this.internalRemoveByPSMobAppPack(pSMobAppPack2);
                PSMobAppPackTDServiceBase.this.onAfterRemoveByPSMobAppPack(pSMobAppPack2);
            }
        });
    }

    protected void onBeforeRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
    }

    protected void internalRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
        ArrayList<PSMobAppPackTD> arrayList = this.selectByPSMobAppPack(pSMobAppPack);
        this.onBeforeRemoveByPSMobAppPack(pSMobAppPack, arrayList);
        for (PSMobAppPackTD pSMobAppPackTD : arrayList) {
            this.remove(pSMobAppPackTD);
        }
        this.onAfterRemoveByPSMobAppPack(pSMobAppPack, arrayList);
    }

    protected void onAfterRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack) throws Exception {
    }

    protected void onBeforeRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack, ArrayList<PSMobAppPackTD> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSMobAppPack(PSMobAppPack pSMobAppPack, ArrayList<PSMobAppPackTD> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSMobAppPackTD pSMobAppPackTD) throws Exception {
        super.onBeforeRemove(pSMobAppPackTD);
    }

    protected void replaceParentInfo(PSMobAppPackTD pSMobAppPackTD, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSMobAppPackTD, cloneSession);
        if (pSMobAppPackTD.getPSDCMobAppTestDeviceId() != null && (iEntity = cloneSession.getEntity("PSDCMOBAPPTESTDEVICE", (Object)pSMobAppPackTD.getPSDCMobAppTestDeviceId())) != null) {
            this.onFillParentInfo_PSDCMobAppTestDevice(pSMobAppPackTD, (PSDCMobAppTestDevice)iEntity);
        }
        if (pSMobAppPackTD.getPSDCMobPackCertId() != null && (iEntity = cloneSession.getEntity("PSDCMOBPACKCERT", (Object)pSMobAppPackTD.getPSDCMobPackCertId())) != null) {
            this.onFillParentInfo_PSDCMobPackCert(pSMobAppPackTD, (PSDCMobPackCert)iEntity);
        }
        if (pSMobAppPackTD.getPSMobAppPackId() != null && (iEntity = cloneSession.getEntity("PSMOBAPPPACK", (Object)pSMobAppPackTD.getPSMobAppPackId())) != null) {
            this.onFillParentInfo_PSMobAppPack(pSMobAppPackTD, (PSMobAppPack)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSMobAppPackTD pSMobAppPackTD, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSMobAppPackTD, bl);
    }

    protected void onCheckEntity(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSMobAppPackTD, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSMobAppPackTD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobAppTestDeviceId(bl, pSMobAppPackTD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobAppTestDeviceName(bl, pSMobAppPackTD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCMobPackCertId(bl, pSMobAppPackTD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackId(bl, pSMobAppPackTD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackName(bl, pSMobAppPackTD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackTDId(bl, pSMobAppPackTD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSMobAppPackTDName(bl, pSMobAppPackTD, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSMobAppPackTD, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackTD.isCodeNameDirty() : !pSMobAppPackTD.isCodeNameDirty()) {
            return null;
        }
        String string = pSMobAppPackTD.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSMobAppPackTD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSMOBAPPPACKID";
                String string4 = this.checkFieldDupRule(this.getPSMobAppPackTDDEModel(), "CODENAME", string3, pSMobAppPackTD, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackTD.isMemoDirty() : !pSMobAppPackTD.isMemoDirty()) {
            return null;
        }
        String string = pSMobAppPackTD.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSMobAppPackTD, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDCMobAppTestDeviceId(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackTD.isPSDCMobAppTestDeviceIdDirty() && !bl2 : !pSMobAppPackTD.isPSDCMobAppTestDeviceIdDirty()) {
            return null;
        }
        String string = pSMobAppPackTD.getPSDCMobAppTestDeviceId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobAppTestDeviceId_Default(pSMobAppPackTD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMobAppTestDeviceName(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackTD.isPSDCMobAppTestDeviceNameDirty() && !bl2 : !pSMobAppPackTD.isPSDCMobAppTestDeviceNameDirty()) {
            return null;
        }
        String string = pSMobAppPackTD.getPSDCMobAppTestDeviceName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobAppTestDeviceName_Default(pSMobAppPackTD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBAPPTESTDEVICENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCMobPackCertId(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackTD.isPSDCMobPackCertIdDirty() : !pSMobAppPackTD.isPSDCMobPackCertIdDirty()) {
            return null;
        }
        String string = pSMobAppPackTD.getPSDCMobPackCertId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCMobPackCertId_Default(pSMobAppPackTD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMOBPACKCERTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackId(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackTD.isPSMobAppPackIdDirty() : !pSMobAppPackTD.isPSMobAppPackIdDirty()) {
            return null;
        }
        String string = pSMobAppPackTD.getPSMobAppPackId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackId_Default(pSMobAppPackTD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackName(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackTD.isPSMobAppPackNameDirty() : !pSMobAppPackTD.isPSMobAppPackNameDirty()) {
            return null;
        }
        String string = pSMobAppPackTD.getPSMobAppPackName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackName_Default(pSMobAppPackTD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackTDId(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackTD.isPSMobAppPackTDIdDirty() && !bl2 : !pSMobAppPackTD.isPSMobAppPackTDIdDirty()) {
            return null;
        }
        String string = pSMobAppPackTD.getPSMobAppPackTDId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKTDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackTDId_Default(pSMobAppPackTD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKTDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSMobAppPackTDName(boolean bl, PSMobAppPackTD pSMobAppPackTD, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSMobAppPackTD.isPSMobAppPackTDNameDirty() && !bl2 : !pSMobAppPackTD.isPSMobAppPackTDNameDirty()) {
            return null;
        }
        String string = pSMobAppPackTD.getPSMobAppPackTDName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKTDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSMobAppPackTDName_Default(pSMobAppPackTD, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMOBAPPPACKTDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSMobAppPackTD pSMobAppPackTD, boolean bl) throws Exception {
        super.onSyncEntity(pSMobAppPackTD, bl);
    }

    protected void onSyncIndexEntities(PSMobAppPackTD pSMobAppPackTD, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSMobAppPackTD, bl);
    }

    public Object getDataContextValue(PSMobAppPackTD pSMobAppPackTD, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSMobAppPackTD, string, iDataContextParam)) != null) {
            return object;
        }
        PSDCMobPackCert pSDCMobPackCert = pSMobAppPackTD.getPSDCMobPackCert();
        if (pSDCMobPackCert != null && pSDCMobPackCert.contains(string)) {
            return pSDCMobPackCert.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSMobAppPackTD pSMobAppPackTD, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSMobAppPackTD, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBAPPTESTDEVICEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobAppTestDeviceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBAPPTESTDEVICENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobAppTestDeviceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBPACKCERTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobPackCertId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMOBPACKCERTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCMobPackCertName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKTDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackTDId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACKTDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSMobAppPackTDName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDCMobAppTestDeviceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBAPPTESTDEVICEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMobAppTestDeviceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBAPPTESTDEVICENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMobPackCertId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBPACKCERTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCMobPackCertName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMOBPACKCERTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackTDId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKTDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSMobAppPackTDName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMOBAPPPACKTDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSMobAppPackTD pSMobAppPackTD) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSMobAppPackTD)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSMobAppPackTD pSMobAppPackTD) throws Exception {
        super.onUpdateParent(pSMobAppPackTD);
    }

    @Override
    protected void exportCurXmlModel(PSMobAppPackTD pSMobAppPackTD, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSMOBAPPPACKTD");
        if (!bl) {
            pSMobAppPackTD.setCreateDate(null);
            pSMobAppPackTD.setCreateMan(null);
            pSMobAppPackTD.setPSDCMobPackCertName(null);
            pSMobAppPackTD.setPSMobAppPackTDId(null);
            pSMobAppPackTD.setUpdateDate(null);
            pSMobAppPackTD.setUpdateMan(null);
            super.exportCurXmlModel(pSMobAppPackTD, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSMobAppPackTD pSMobAppPackTD, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSMobAppPackTD, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMOBAPPPACKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMOBAPPPACK#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMOBAPPPACKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSMOBAPPPACKTD_PSMOBAPPPACK_PSMOBAPPPACKID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMOBAPPPACKID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMOBAPPPACKNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSMOBAPPPACK", (boolean)true) == 0) {
            iEntity.set("PSMOBAPPPACKID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSMOBAPPPACKID"};
    }

    @Override
    public String getModelV2Tag(PSMobAppPackTD pSMobAppPackTD) {
        if (!StringHelper.isNullOrEmpty((String)pSMobAppPackTD.getCodeName())) {
            return pSMobAppPackTD.getCodeName();
        }
        return super.getModelV2Tag(pSMobAppPackTD);
    }

    @Override
    public boolean setModelV2Tag(PSMobAppPackTD pSMobAppPackTD, String string) {
        return super.setModelV2Tag(pSMobAppPackTD, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSMOBAPPPACKID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSMobAppPackTD pSMobAppPackTD, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSMobAppPackTD.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSMobAppPackTD, true);
        pSMobAppPackTD.set("CODENAME", string);
        if (this.select(pSMobAppPackTD, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSMobAppPackTD, true);
        return super.getModelV2Entity(pSMobAppPackTD, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSMobAppPackTD pSMobAppPackTD, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSMobAppPackTD, objectNode, string, string2, n);
    }
}

