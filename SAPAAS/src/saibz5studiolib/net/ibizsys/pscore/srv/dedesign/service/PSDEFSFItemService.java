/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFSFItemService
extends PSDEFSFItemServiceBase
implements IPSModelService<PSDEFSFItem> {
    private static final Log log = LogFactory.getLog(PSDEFSFItemService.class);
    public static final String CONDOP_EXISTS = "EXISTS";
    public static final String CONDOP_NOTEXISTS = "NOTEXISTS";

    @Override
    public boolean fillEntityKeyValue(PSDEFSFItem pSDEFSFItem, boolean bl) throws Exception {
        if (!(bl || StringHelper.isNullOrEmpty((String)pSDEFSFItem.getPSDEFName()) || PSCoreSysServiceBase.isImpSysModelNow())) {
            String string = "";
            string = StringHelper.isNullOrEmpty((String)pSDEFSFItem.getPSSysDBVFId()) ? StringHelper.format((String)"N_%1$s_%2$s", (Object)pSDEFSFItem.getPSDEFName(), (Object)pSDEFSFItem.getPSDBValueOPId()).toUpperCase() : StringHelper.format((String)"F_%1$s_%2$s_%3$s", (Object)pSDEFSFItem.getPSDEFName(), (Object)pSDEFSFItem.getPSSysDBVF().getCodeName(), (Object)pSDEFSFItem.getPSDBValueOPId()).toUpperCase();
            if (CONDOP_EXISTS.equals(pSDEFSFItem.getPSDBValueOPId()) || CONDOP_NOTEXISTS.equals(pSDEFSFItem.getPSDBValueOPId())) {
                if (pSDEFSFItem.getDstPSDEFSFItem() != null) {
                    string = string + "__";
                    string = string + pSDEFSFItem.getDstPSDEFSFItem().getPSDEFSFItemName();
                }
            } else {
                pSDEFSFItem.setDstPSDEFSFItemId(null);
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEFSFItem.getSearchMode())) {
                string = string + "#";
                string = string + pSDEFSFItem.getSearchMode();
            }
            pSDEFSFItem.setPSDEFSFItemName(string);
        }
        return super.fillEntityKeyValue(pSDEFSFItem, bl);
    }

    @Override
    protected void onBeforeCreate(PSDEFSFItem pSDEFSFItem) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSDEFSFItem.getPSDEFName())) {
            String string = "";
            string = StringHelper.isNullOrEmpty((String)pSDEFSFItem.getPSSysDBVFId()) ? StringHelper.format((String)"N_%1$s_%2$s", (Object)pSDEFSFItem.getPSDEFName(), (Object)pSDEFSFItem.getPSDBValueOPId()).toUpperCase() : StringHelper.format((String)"F_%1$s_%2$s_%3$s", (Object)pSDEFSFItem.getPSDEFName(), (Object)pSDEFSFItem.getPSSysDBVF().getCodeName(), (Object)pSDEFSFItem.getPSDBValueOPId()).toUpperCase();
            if (CONDOP_EXISTS.equals(pSDEFSFItem.getPSDBValueOPId()) || CONDOP_NOTEXISTS.equals(pSDEFSFItem.getPSDBValueOPId())) {
                if (pSDEFSFItem.getDstPSDEFSFItem() != null) {
                    string = string + "__";
                    string = string + pSDEFSFItem.getDstPSDEFSFItem().getPSDEFSFItemName();
                }
            } else {
                pSDEFSFItem.setDstPSDEFSFItemId(null);
            }
            if (!StringHelper.isNullOrEmpty((String)pSDEFSFItem.getSearchMode())) {
                string = string + "#";
                string = string + pSDEFSFItem.getSearchMode();
            }
            pSDEFSFItem.setPSDEFSFItemName(string);
        }
        super.onBeforeCreate(pSDEFSFItem);
    }

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFIELD", (boolean)true) == 0) {
            String string3;
            PSDEFSFItem pSDEFSFItem;
            PSDEField pSDEField = new PSDEField();
            pSDEField.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDEField.getPSDEId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreUIModel(), (boolean)false)) {
                return;
            }
            if (DataObject.getBoolValue((Integer)pSDEField.getMajorField(), (boolean)false) || StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                pSDEFSFItem = new PSDEFSFItem();
                pSDEFSFItem.setPSDEFId(pSDEField.getPSDEFieldId());
                string3 = StringHelper.format((String)"N_%1$s_LIKE", (Object)pSDEField.getPSDEFieldName());
                pSDEFSFItem.setPSDEFSFItemName(string3);
                if (!this.select(pSDEFSFItem, true)) {
                    pSDEFSFItem.setPSDEFId(pSDEField.getPSDEFieldId());
                    pSDEFSFItem.setPSDEFSFItemName(string3);
                    pSDEFSFItem.setPSDBValueOPId("LIKE");
                    pSDEFSFItem.setPSDEId(pSDEField.getPSDEId());
                    pSDEFSFItem.setPSDEName(pSDEField.getPSDEName());
                    pSDEFSFItem.setPSDEFName(pSDEField.getPSDEFieldName());
                    this.create(pSDEFSFItem);
                }
            }
            if (StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"PICKUPTEXT", (boolean)true) == 0 || StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"SSCODELIST", (boolean)true) == 0 || StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"NSCODELIST", (boolean)true) == 0) {
                pSDEFSFItem = new PSDEFSFItem();
                pSDEFSFItem.setPSDEFId(pSDEField.getPSDEFieldId());
                string3 = StringHelper.format((String)"N_%1$s_EQ", (Object)pSDEField.getPSDEFieldName());
                pSDEFSFItem.setPSDEFSFItemName(string3);
                if (!this.select(pSDEFSFItem, true)) {
                    pSDEFSFItem.setPSDBValueOPId("EQ");
                    pSDEFSFItem.setPSDEId(pSDEField.getPSDEId());
                    pSDEFSFItem.setPSDEName(pSDEField.getPSDEName());
                    pSDEFSFItem.setPSDEFName(pSDEField.getPSDEFieldName());
                    this.create(pSDEFSFItem);
                }
            }
            if (StringHelper.compare((String)pSDEField.getPSDataTypeId(), (String)"PICKUP", (boolean)true) == 0) {
                pSDEFSFItem = new PSDEFSFItem();
                pSDEFSFItem.setPSDEFId(pSDEField.getPSDEFieldId());
                string3 = StringHelper.format((String)"N_%1$s_EQ", (Object)pSDEField.getPSDEFieldName());
                pSDEFSFItem.setPSDEFSFItemName(string3);
                if (!this.select(pSDEFSFItem, true)) {
                    pSDEFSFItem.setPSDBValueOPId("EQ");
                    pSDEFSFItem.setPSDEId(pSDEField.getPSDEId());
                    pSDEFSFItem.setPSDEName(pSDEField.getPSDEName());
                    pSDEFSFItem.setPSDEFName(pSDEField.getPSDEFieldName());
                    this.create(pSDEFSFItem);
                }
            }
        }
    }

    @Override
    protected void onCalcDstPSDEId(PSDEFSFItem pSDEFSFItem) throws Exception {
        pSDEFSFItem.setDstPSDEId(null);
        if ((CONDOP_EXISTS.equals(pSDEFSFItem.getPSDBValueOPId()) || CONDOP_NOTEXISTS.equals(pSDEFSFItem.getPSDBValueOPId())) && pSDEFSFItem.getPSDEF() != null) {
            if (pSDEFSFItem.getPSDEF().getO2OPSDER() != null) {
                pSDEFSFItem.setDstPSDEId(pSDEFSFItem.getPSDEF().getO2OPSDER().getMinorPSDEId());
                return;
            }
            if (pSDEFSFItem.getPSDEF().getO2MPSDER() != null) {
                pSDEFSFItem.setDstPSDEId(pSDEFSFItem.getPSDEF().getO2MPSDER().getMinorPSDEId());
                return;
            }
        }
    }

    @Override
    public Object getDataContextValue(PSDEFSFItem pSDEFSFItem, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"psdefsfitem", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"dstpsdefsfitemname", (boolean)true) == 0) {
            this.calcDstPSDEId(pSDEFSFItem);
            return pSDEFSFItem.getDstPSDEId();
        }
        return super.getDataContextValue(pSDEFSFItem, string, iDataContextParam);
    }
}

