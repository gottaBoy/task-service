/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.UserConfirmException
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.UserConfirmException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.codelist.DERTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDERService
extends PSDERServiceBase {
    private static final Log log = LogFactory.getLog(PSDERService.class);

    @Override
    protected void onBeforeCreate(PSDER pSDER) throws Exception {
        int n;
        String string;
        super.onBeforeCreate(pSDER);
        String string2 = "";
        String string3 = "";
        if (!StringHelper.isNullOrEmpty((String)pSDER.getMajorPSDEName()) && !StringHelper.isNullOrEmpty((String)pSDER.getMinorPSDEName())) {
            if (StringHelper.compare((String)pSDER.getMajorPSDEId(), (String)KeyValueHelper.genUniqueId((String)pSDER.getPSSystemId(), (String)pSDER.getMajorPSDEName().toUpperCase()), (boolean)false) != 0) {
                string2 = pSDER.getMajorPSDEId();
            }
            if (StringHelper.compare((String)pSDER.getMinorPSDEId(), (String)KeyValueHelper.genUniqueId((String)pSDER.getPSSystemId(), (String)pSDER.getMinorPSDEName().toUpperCase()), (boolean)false) != 0) {
                string3 = pSDER.getMinorPSDEId();
            }
            if (!StringHelper.isNullOrEmpty((String)string2) || !StringHelper.isNullOrEmpty((String)string3)) {
                string2 = KeyValueHelper.genUniqueId((String)string2, (String)string3);
                string2 = "_" + string2.substring(0, 6).toUpperCase();
            }
        }
        if (PSDERService.isImpSysModelNowEx()) {
            if (StringHelper.isNullOrEmpty((String)pSDER.getPSDERName())) {
                String string4;
                String string5 = "";
                String string6 = pSDER.getDERType();
                String string7 = pSDER.getMajorPSDEName();
                if (StringHelper.isNullOrEmpty((String)string7)) {
                    string7 = pSDER.getMajorPSDE().getPSDataEntityName();
                }
                if (StringHelper.isNullOrEmpty((String)(string4 = pSDER.getMinorPSDEName()))) {
                    string4 = pSDER.getMinorPSDE().getPSDataEntityName();
                }
                if (StringHelper.compare((String)pSDER.getDERType(), (String)"DER1N", (boolean)true) == 0) {
                    string5 = StringHelper.format((String)"%1$s_%2$s_%3$s_%4$s", (Object)string6, (Object)string4, (Object)string7, (Object)pSDER.getDERFieldName());
                }
                if (StringHelper.compare((String)pSDER.getDERType(), (String)"DERINHERIT", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DERINDEX", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DER11", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DERMULINH", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DERCUSTOM", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DERAGGDATA", (boolean)true) == 0) {
                    string5 = StringHelper.format((String)"%1$s_%2$s_%3$s", (Object)string6, (Object)string4, (Object)string7);
                }
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    string5 = string5 + string2;
                }
                pSDER.setPSDERName(string5);
            }
            return;
        }
        String string8 = "";
        String string9 = pSDER.getDERType();
        String string10 = pSDER.getMajorPSDEName();
        if (StringHelper.isNullOrEmpty((String)string10)) {
            if (StringHelper.isNullOrEmpty((String)pSDER.getMajorPSDEId())) {
                throw new Exception("\u4e3b\u5b9e\u4f53\u65e0\u6548");
            }
            string10 = pSDER.getMajorPSDE().getPSDataEntityName();
        }
        if (StringHelper.isNullOrEmpty((String)(string = pSDER.getMinorPSDEName()))) {
            if (StringHelper.isNullOrEmpty((String)pSDER.getMinorPSDEId())) {
                throw new Exception("\u4ece\u5b9e\u4f53\u65e0\u6548");
            }
            string = pSDER.getMinorPSDE().getPSDataEntityName();
        }
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DERCUSTOM", (boolean)true) == 0 && !StringHelper.isNullOrEmpty((String)pSDER.getPSDERName())) {
            return;
        }
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DERMULINH", (boolean)true) == 0 && (n = DataObject.getIntegerValue((Object)pSDER.getMinorPSDE().getVirtualFlag(), (Integer)0).intValue()) != 1 && n != 4 && n != 5) {
            ICodeListModel iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList(DERTypeCodeListModel.class);
            String string11 = iCodeListModel.getCodeListText(pSDER.getDERType(), false);
            String string12 = StringHelper.format((String)"\u4e0d\u80fd\u5efa\u7acb%1$s\uff0c\u5173\u7cfb\u5b9e\u4f53\u5fc5\u987b\u4e3a\u865a\u62df\u5b9e\u4f53", (Object)string11);
            throw new Exception(string12);
        }
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DER1N", (boolean)true) == 0) {
            string8 = StringHelper.format((String)"%1$s_%2$s_%3$s_%4$s", (Object)string9, (Object)string, (Object)string10, (Object)pSDER.getDERFieldName());
        }
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DERINHERIT", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DERINDEX", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DER11", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DERMULINH", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DERCUSTOM", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DERAGGDATA", (boolean)true) == 0) {
            if (StringHelper.compare((String)pSDER.getMajorPSDEId(), (String)pSDER.getMinorPSDEId(), (boolean)false) == 0) {
                ICodeListModel iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList(DERTypeCodeListModel.class);
                String string13 = iCodeListModel.getCodeListText(pSDER.getDERType(), false);
                String string14 = StringHelper.format((String)"\u4e0d\u80fd\u5efa\u7acb\u5b9e\u4f53\u81ea\u5df1\u8ddf\u81ea\u5df1\u7684%1$s", (Object)string13);
                throw new Exception(string14);
            }
            string8 = StringHelper.format((String)"%1$s_%2$s_%3$s", (Object)string9, (Object)string, (Object)string10);
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            string8 = string8 + string2;
        }
        pSDER.setPSDERName(string8);
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DER11", (boolean)true) == 0) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSDER.getMinorPSDEId());
            pSDEField.setPKey(1);
            if (!pSDEFieldService.select(pSDEField, true)) {
                String string15 = StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5173\u7cfb\u5b9e\u4f53[%1$s]\u4e3b\u952e\u5c5e\u6027", (Object)pSDER.getMinorPSDEName());
                throw new Exception(string15);
            }
            pSDER.setDERFieldName(pSDEField.getPSDEFieldName());
        }
    }

    @Override
    protected void onAfterCreate(PSDER pSDER) throws Exception {
        String string;
        Object object;
        PSDEField pSDEField;
        PSDEFieldService pSDEFieldService;
        super.onAfterCreate(pSDER);
        if (PSDERService.isImpSysModelNowEx() || PSDERService.isSimpleImportExportMode()) {
            return;
        }
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DER1N", (boolean)true) == 0) {
            pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSDER.getMajorPSDEId());
            pSDEField.setPKey(1);
            if (!pSDEFieldService.select(pSDEField, true)) {
                String string2 = StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u4e3b\u5b9e\u4f53[%1$s]\u4e3b\u952e\u5c5e\u6027", (Object)pSDER.getMajorPSDEName());
                throw new Exception(string2);
            }
            object = pSDER.getMinorPSDE();
            string = ((PSDataEntityBase)object).getTableName();
            PSDEField pSDEField2 = new PSDEField();
            pSDEField2.setPSDEFieldName(pSDER.getDERFieldName());
            pSDEField2.setDERPSDEFId(pSDEField.getPSDEFieldId());
            pSDEField2.setDERPSDEFName(pSDEField.getPSDEFieldName());
            pSDEField2.setPSDERId(pSDER.getPSDERId());
            pSDEField2.setPSDERName(pSDER.getPSDERName());
            pSDEField2.setPSDEId(((PSDataEntityBase)object).getPSDataEntityId());
            pSDEField2.setLogicName(pSDER.getDERFieldLName());
            if (StringHelper.isNullOrEmpty((String)pSDEField2.getLogicName())) {
                pSDEField2.setLogicName(pSDEField.getLogicName());
            }
            pSDEField2.setTableName(string);
            pSDEField2.setDEFType(1);
            pSDEField2.setPhysicalField(1);
            pSDEField2.setAllowEmpty(1);
            pSDEField2.setPSDataTypeId("PICKUP");
            pSDEField2.setMajorField(0);
            pSDEField2.setPKey(0);
            pSDEField2.setFKey(1);
            pSDEField2.setEnableUserInput(3);
            boolean bl = true;
            if (WebContext.getCurrent() != null && WebContext.getCurrent().getCurAjaxActionResult() != null) {
                String string3 = WebContext.getCurrent().getPostValue("srfreplacedef");
                if (StringHelper.compare((String)string3, (String)"yes", (boolean)true) == 0) {
                    bl = false;
                }
            } else {
                PSDEField pSDEField3 = new PSDEField();
                pSDEField3.setPSDEId(pSDEField2.getPSDEId());
                pSDEField3.setPSDEFieldName(pSDEField2.getPSDEFieldName().toUpperCase());
                pSDEField3.setSessionFactory(this.getSessionFactory());
                if (pSDEField3.select(true)) {
                    bl = false;
                    pSDEField2.setPSDEFieldId(pSDEField3.getPSDEFieldId());
                }
            }
            if (bl) {
                pSDEFieldService.create(pSDEField2);
            } else {
                pSDEFieldService.update(pSDEField2);
            }
        }
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DER11", (boolean)true) == 0) {
            pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSDER.getMajorPSDEId());
            pSDEField.setPKey(1);
            if (!pSDEFieldService.select(pSDEField, true)) {
                object = StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u4e3b\u5b9e\u4f53[%1$s]\u4e3b\u952e\u5c5e\u6027", (Object)pSDER.getMajorPSDEName());
                throw new Exception((String)object);
            }
            object = new PSDEField();
            ((PSDEFieldBase)object).setPSDEId(pSDER.getMinorPSDEId());
            ((PSDEFieldBase)object).setPKey(1);
            if (!pSDEFieldService.select(object, true)) {
                string = StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5173\u7cfb\u5b9e\u4f53[%1$s]\u4e3b\u952e\u5c5e\u6027", (Object)pSDER.getMinorPSDEName());
                throw new Exception(string);
            }
            if (!StringHelper.isNullOrEmpty((String)((PSDEFieldBase)object).getPSDERName())) {
                string = StringHelper.format((String)"\u5173\u7cfb\u5b9e\u4f53[%1$s]\u4e3b\u952e\u5c5e\u6027\u5df2\u5b58\u5728\u5173\u7cfb[%2$s]", (Object)pSDER.getMinorPSDEName(), (Object)((PSDEFieldBase)object).getPSDERName());
                throw new Exception(string);
            }
            ((PSDEFieldBase)object).setDERPSDEFId(pSDEField.getPSDEFieldId());
            ((PSDEFieldBase)object).setDERPSDEFName(pSDEField.getPSDEFieldName());
            ((PSDEFieldBase)object).setPSDERId(pSDER.getPSDERId());
            ((PSDEFieldBase)object).setPSDERName(pSDER.getPSDERName());
            ((PSDEFieldBase)object).setPSDataTypeId("PICKUP");
            ((PSDEFieldBase)object).setPSDataTypeName(null);
            pSDEFieldService.update(object, false);
        }
    }

    @Override
    protected void onCheckEntity(boolean bl, PSDER pSDER, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        if (PSDERService.isImpSysModelNowEx()) {
            return;
        }
        if (!bl && StringHelper.compare((String)pSDER.getDERType(), (String)"DER1N", (boolean)false) == 0) {
            String string;
            if (bl2 && StringHelper.compare((String)pSDER.getDERFieldName(), (String)pSDER.getCodeName(), (boolean)true) == 0) {
                entityError.register("CODENAME", "\u4ee3\u7801\u540d\u79f0", "", 3, StringHelper.format((String)"\u4ee3\u7801\u540d\u79f0[%1$s]\u4e0d\u80fd\u4e0e\u5173\u7cfb\u5c5e\u6027\u540d\u79f0\u76f8\u540c", (Object)pSDER.getCodeName()));
                entityError.register("DERFIELDNAME", "\u5173\u7cfb\u5c5e\u6027\u540d\u79f0", "", 3, StringHelper.format((String)"\u5173\u7cfb\u5c5e\u6027\u540d\u79f0[%1$s]\u4e0d\u80fd\u4e0e\u4ee3\u7801\u540d\u79f0\u76f8\u540c", (Object)pSDER.getDERFieldName()));
            }
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.setPSDataEntityId(pSDER.getMinorPSDEId());
            PSDataEntity pSDataEntity2 = new PSDataEntity();
            pSDataEntity2.setPSDataEntityId(pSDER.getMajorPSDEId());
            PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
            if (!StringHelper.isNullOrEmpty((String)pSDER.getCodeName()) && !StringHelper.isNullOrEmpty((String)(string = pSDataEntityService.checkObjCodeName(pSDataEntity, pSDER, pSDER.getCodeName())))) {
                entityError.register("CODENAME", "\u4ee3\u7801\u540d\u79f0", "", 3, StringHelper.format((String)"\u4ee3\u7801\u540d\u79f0[%1$s]\u5df2\u7ecf\u88ab%2$s\u4f7f\u7528", (Object)pSDER.getCodeName(), (Object)string));
            }
            if (!StringHelper.isNullOrEmpty((String)pSDER.getMinorCodeName()) && !StringHelper.isNullOrEmpty((String)(string = pSDataEntityService.checkObjCodeName(pSDataEntity2, pSDER, pSDER.getMinorCodeName())))) {
                entityError.register("MINORCODENAME", "\u5173\u7cfb\u4ee3\u7801\u540d\u79f0", "", 3, StringHelper.format((String)"\u5173\u7cfb\u4ee3\u7801\u540d\u79f0[%1$s]\u5df2\u7ecf\u88ab%2$s\u4f7f\u7528", (Object)pSDER.getMinorCodeName(), (Object)string));
            }
            if (bl2 && !StringHelper.isNullOrEmpty((String)pSDER.getDERFieldName()) && !StringHelper.isNullOrEmpty((String)(string = pSDataEntityService.checkDEFieldName(pSDataEntity, pSDER, pSDER.getDERFieldName())))) {
                boolean bl4 = false;
                String string2 = EntityBase.getStringValue((Object)pSDER.get("srfreplacedef"));
                if (StringHelper.isNullOrEmpty((String)string2)) {
                    if (WebContext.getCurrent() != null && WebContext.getCurrent().getCurAjaxActionResult() != null) {
                        string2 = WebContext.getCurrent().getPostValue("srfreplacedef");
                        if (string2 == null) {
                            PSDEField pSDEField = new PSDEField();
                            pSDEField.setPSDEId(pSDataEntity.getPSDataEntityId());
                            pSDEField.setPSDEFieldName(pSDER.getDERFieldName().toUpperCase());
                            pSDEField.setSessionFactory(this.getSessionFactory());
                            if (pSDEField.select(true) && StringHelper.isNullOrEmpty((String)pSDEField.getPSDERId())) {
                                throw new UserConfirmException(StringHelper.format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s]\u5df2\u7ecf\u5b58\u5728\uff0c\u662f\u5426\u8981\u5c06\u539f\u6709\u5c5e\u6027\u8c03\u6574\u4e3a\u5173\u7cfb\u5c5e\u6027", (Object)pSDEField.getPSDEFieldName()), "srfreplacedef", "\u8be2\u95ee", null, null);
                            }
                        } else if (StringHelper.compare((String)string2, (String)"yes", (boolean)true) == 0) {
                            bl4 = true;
                        }
                    } else {
                        bl4 = true;
                    }
                } else if (StringHelper.compare((String)string2, (String)"yes", (boolean)true) == 0) {
                    bl4 = true;
                }
                if (!bl4) {
                    entityError.register("DERFIELDNAME", "\u5173\u7cfb\u5c5e\u6027\u540d\u79f0", "", 3, StringHelper.format((String)"\u5173\u7cfb\u5c5e\u6027\u540d\u79f0[%1$s]\u5df2\u7ecf\u88ab%2$s\u4f7f\u7528", (Object)pSDER.getDERFieldName(), (Object)string));
                }
            }
        }
        super.onCheckEntity(bl, pSDER, bl2, bl3, entityError);
    }

    @Override
    protected void onCreateDefaultVR(PSDER pSDER) throws Exception {
        this.get((IEntity)pSDER);
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)pSDER.getDERType(), (String)"DER11", (boolean)true) == 0) {
            PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
            pSDEFValueRuleService.createDER1NDefaultVR(pSDER);
            return;
        }
        throw new Exception("\u5173\u7cfb\u7c7b\u578b\u4e0d\u652f\u6301");
    }

    @Override
    protected void onCreatePickupTextField(PSDER pSDER) throws Exception {
        this.get((IEntity)pSDER);
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DER1N", (boolean)true) == 0) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEField> arrayList = pSDEFieldService.selectByPSDER(pSDER);
            PSDEField pSDEField = null;
            PSDEField pSDEField2 = null;
            for (PSDEField object2 : arrayList) {
                if (StringHelper.compare((String)object2.getPSDataTypeId(), (String)"PICKUP", (boolean)true) == 0) {
                    pSDEField = object2;
                    continue;
                }
                if (StringHelper.compare((String)object2.getPSDataTypeId(), (String)"PICKUPTEXT", (boolean)true) != 0) continue;
                pSDEField2 = object2;
            }
            if (pSDEField2 != null) {
                return;
            }
            if (pSDEField == null) {
                throw new Exception(StringHelper.format((String)"\u5173\u7cfb[%1$s]\u5916\u952e\u503c\u5c5e\u6027\u4e0d\u5b58\u5728", (Object)pSDER.getPSDERName()));
            }
            PSDEField pSDEField3 = new PSDEField();
            pSDEField3.setPSDEId(pSDER.getMajorPSDEId());
            pSDEField3.setMajorField(1);
            if (!pSDEFieldService.select(pSDEField3, true)) {
                String string = StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u4e3b\u5b9e\u4f53[%1$s]\u4e3b\u5c5e\u6027", (Object)pSDER.getMajorPSDEName());
                throw new Exception(string);
            }
            String string = pSDEField.getPSDEFieldName().replace(pSDEField.getDERPSDEFName(), "%1$s");
            if (StringHelper.compare((String)string, (String)pSDEField.getPSDEFieldName(), (boolean)true) == 0) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5173\u7cfb[%1$s]\u5916\u952e\u503c\u6587\u672c\u5c5e\u6027\u540d\u79f0", (Object)pSDER.getPSDERName()));
            }
            String string2 = StringHelper.format((String)string, (Object)pSDEField3.getPSDEFieldName());
            pSDEField2 = new PSDEField();
            pSDEField.copyTo((IDataObject)pSDEField2, true);
            pSDEField2.resetPSDEFieldId();
            pSDEField2.resetTableName();
            pSDEField2.setDEFType(3);
            pSDEField2.setPSDEFieldName(string2);
            pSDEField2.resetPSDataTypeName();
            pSDEField2.setPSDataTypeId("PICKUPTEXT");
            pSDEField2.setDERPSDEFId(pSDEField3.getPSDEFieldId());
            pSDEField2.setDERPSDEFName(pSDEField3.getPSDEFieldName());
            pSDEField2.setLogicName(pSDEField3.getLogicName());
            pSDEField2.resetCodeName();
            pSDEFieldService.create(pSDEField2, false);
            return;
        }
        throw new Exception("\u5173\u7cfb\u7c7b\u578b\u4e0d\u652f\u6301");
    }

    @Override
    protected void onCreateDEOPPriv(PSDER pSDER) throws Exception {
        this.get((IEntity)pSDER);
        if (StringHelper.compare((String)pSDER.getDERType(), (String)"DER1N", (boolean)true) == 0) {
            if ((pSDER.getMasterRS() & 4) == 0) {
                throw new Exception("\u5f53\u524d\u5173\u7cfb\u6ca1\u6709\u542f\u7528\u6570\u636e\u8bbf\u95ee\u63a7\u5236");
            }
            PSDEOPPrivService pSDEOPPrivService = (PSDEOPPrivService)ServiceGlobal.getService(PSDEOPPrivService.class, (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = new PSDEOPPriv();
            pSDEOPPriv.setPSSystemId(pSDER.getPSSystemId());
            pSDEOPPriv.setPSDEId(pSDER.getMinorPSDEId());
            pSDEOPPriv.setPSDEOPPrivName("READ");
            pSDEOPPriv.setPSDERId(pSDER.getPSDERId());
            pSDEOPPriv.setMapPSDEOPPrivId(KeyValueHelper.genUniqueId((String)pSDER.getMajorPSDEId(), (String)"READ"));
            pSDEOPPriv.setLogicName("\u8bfb\u53d6");
            if (pSDEOPPrivService.checkKey(pSDEOPPriv) == 0) {
                pSDEOPPrivService.create(pSDEOPPriv);
            }
            pSDEOPPriv = new PSDEOPPriv();
            pSDEOPPriv.setPSSystemId(pSDER.getPSSystemId());
            pSDEOPPriv.setPSDEId(pSDER.getMinorPSDEId());
            pSDEOPPriv.setPSDEOPPrivName("CREATE");
            pSDEOPPriv.setPSDERId(pSDER.getPSDERId());
            pSDEOPPriv.setMapPSDEOPPrivId(KeyValueHelper.genUniqueId((String)pSDER.getMajorPSDEId(), (String)"UPDATE"));
            pSDEOPPriv.setLogicName("\u5efa\u7acb");
            if (pSDEOPPrivService.checkKey(pSDEOPPriv) == 0) {
                pSDEOPPrivService.create(pSDEOPPriv);
            }
            pSDEOPPriv = new PSDEOPPriv();
            pSDEOPPriv.setPSSystemId(pSDER.getPSSystemId());
            pSDEOPPriv.setPSDEId(pSDER.getMinorPSDEId());
            pSDEOPPriv.setPSDEOPPrivName("UPDATE");
            pSDEOPPriv.setPSDERId(pSDER.getPSDERId());
            pSDEOPPriv.setMapPSDEOPPrivId(KeyValueHelper.genUniqueId((String)pSDER.getMajorPSDEId(), (String)"UPDATE"));
            pSDEOPPriv.setLogicName("\u66f4\u65b0");
            if (pSDEOPPrivService.checkKey(pSDEOPPriv) == 0) {
                pSDEOPPrivService.create(pSDEOPPriv);
            }
            pSDEOPPriv = new PSDEOPPriv();
            pSDEOPPriv.setPSSystemId(pSDER.getPSSystemId());
            pSDEOPPriv.setPSDEId(pSDER.getMinorPSDEId());
            pSDEOPPriv.setPSDEOPPrivName("DELETE");
            pSDEOPPriv.setPSDERId(pSDER.getPSDERId());
            pSDEOPPriv.setMapPSDEOPPrivId(KeyValueHelper.genUniqueId((String)pSDER.getMajorPSDEId(), (String)"UPDATE"));
            pSDEOPPriv.setLogicName("\u5220\u9664");
            if (pSDEOPPrivService.checkKey(pSDEOPPriv) == 0) {
                pSDEOPPrivService.create(pSDEOPPriv);
            }
            return;
        }
        throw new Exception("\u5173\u7cfb\u7c7b\u578b\u4e0d\u652f\u6301");
    }

    @Override
    public String getModelV2Tag(PSDER pSDER) {
        if (!StringHelper.isNullOrEmpty((String)pSDER.getPSDERName())) {
            return pSDER.getPSDERName();
        }
        return super.getModelV2Tag(pSDER);
    }

    @Override
    protected void onWriteFileCurModelV2Data(PSDER pSDER, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDER.getMajorPSDEId())) {
            pSDER.setMajorPSDEId(pSDER.getMinorPSDEId());
        }
        if (StringHelper.isNullOrEmpty((String)pSDER.getMajorPSDEName())) {
            pSDER.setMajorPSDEName(pSDER.getMinorPSDEName());
        }
        super.onWriteFileCurModelV2Data(pSDER, string);
    }

    @Override
    protected boolean isExportRelatedModelV2(String string) {
        if (PSDERService.isSimpleImportExportMode() && StringHelper.compare((String)"DER1N_PSDEFIELD_PSDER_PSDERID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return super.isExportRelatedModelV2(string);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDER pSDER, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (PSDERService.isSimpleImportExportMode()) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayNode arrayNode = null;
            String string3 = pSDEFieldService.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                    PSDEField pSDEField = new PSDEField();
                    pSDEField.setPSDERId(pSDER.getPSDERId());
                    pSDEField.setPSDERName(pSDER.getPSDERName());
                    pSDEFieldService.compileModelV2(pSDEField, objectNode2, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File file = new File(string4);
                if (file.exists()) {
                    File[] fileArray;
                    for (File file2 : fileArray = file.listFiles()) {
                        if (!file2.isDirectory()) continue;
                        PSDEField pSDEField = new PSDEField();
                        pSDEField.setPSDERId(pSDER.getPSDERId());
                        pSDEField.setPSDERName(pSDER.getPSDERName());
                        pSDEFieldService.compileModelV2(pSDEField, null, string, file2.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDER, objectNode, string, string2, n);
    }

    @Override
    public ObjectNode exportModelV2(PSDER pSDER) throws Exception {
        pSDER.resetPSDERName();
        return super.exportModelV2(pSDER);
    }
}

