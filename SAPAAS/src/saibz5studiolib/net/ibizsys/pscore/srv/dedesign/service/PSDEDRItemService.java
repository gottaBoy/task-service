/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDRItemService
extends PSDEDRItemServiceBase
implements IPSModelService<PSDEDRItem> {
    private static final Log log = LogFactory.getLog(PSDEDRItemService.class);

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDER", (boolean)true) == 0) {
            PSDER pSDER = new PSDER();
            pSDER.proxy((IDataObject)iEntity);
            if (StringHelper.compare((String)pSDER.getDERType(), (String)"DER1N", (boolean)true) == 0) {
                // empty if block
            }
            return;
        }
    }

    protected void initDefaultDER1NItem(PSDER pSDER) throws Exception {
        PSDEDRItem pSDEDRItem = new PSDEDRItem();
        pSDEDRItem.setPSDEDRItemId(pSDER.getPSDERId());
        if (this.checkKey(pSDEDRItem) == 0) {
            pSDEDRItem.setDRItemType("DER1N");
            pSDEDRItem.setPSDEId(pSDER.getMajorPSDEId());
            pSDEDRItem.setPSDEDRItemName(pSDER.getLogicName());
            if (StringHelper.isNullOrEmpty((String)pSDEDRItem.getPSDEDRItemName())) {
                pSDEDRItem.setPSDEDRItemName(pSDER.getMinorPSDE().getLogicName());
            }
            pSDEDRItem.setPSDEDRGroupId(pSDER.getMajorPSDEId());
            pSDEDRItem.setPSDERId(pSDER.getPSDERId());
            pSDEDRItem.setPSDEViewBaseId(pSDER.getRSPSDEViewId());
            pSDEDRItem.setViewPSDEId(pSDER.getMinorPSDEId());
            if (StringHelper.isNullOrEmpty((String)pSDEDRItem.getPSDEViewBaseId())) {
                pSDEDRItem.setPSDEViewBaseId(KeyValueHelper.genUniqueId((String)pSDER.getMinorPSDEId(), (String)"DEGRIDVIEW"));
            }
            this.create(pSDEDRItem);
            PSDEDRGroup group = new PSDEDRGroup();
            group.setPSDEDRGroupId(pSDER.getMajorPSDEId());
            PSDEDRGroupService pSDEDRGroupService = (PSDEDRGroupService)ServiceGlobal.getService(PSDEDRGroupService.class, (SessionFactory)this.getSessionFactory());
            if (!pSDEDRGroupService.get(group, true)) {
                return;
            }
            PSDEDRDetailService pSDEDRDetailService = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEDRDetail> arrayList = pSDEDRDetailService.selectByPSDEDRGroup(group, "ORDER BY ORDERVALUE DESC");
            PSDEDRDetail pSDEDRDetail = new PSDEDRDetail();
            pSDEDRDetail.setPSDEDRId(pSDER.getMajorPSDEId());
            pSDEDRDetail.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
            pSDEDRDetail.setPSDEDRGroupId(pSDER.getMajorPSDEId());
            if (arrayList.size() == 0) {
                pSDEDRDetail.setOrderValue(100);
                pSDEDRDetail.setPSDEDRDetailName("dritem1");
            } else {
                String string;
                int n = 100;
                if (arrayList.get(0).getOrderValue() != null) {
                    n = arrayList.get(0).getOrderValue();
                }
                pSDEDRDetail.setOrderValue(n + 100);
                HashMap<String, String> hashMap = new HashMap<String, String>();
                for (PSDEDRDetail object2 : arrayList) {
                    hashMap.put(object2.getPSDEDRDetailName().toLowerCase(), "");
                }
                int n2 = 0;
                String string2 = "";
                while (hashMap.containsKey(string = StringHelper.format((String)"dritem%1$s", (Object)(++n2)))) {
                }
                pSDEDRDetail.setPSDEDRDetailName(string);
            }
            pSDEDRDetailService.create(pSDEDRDetail);
        }
    }

    @Override
    protected void onFillParentInfo_PSDER(PSDEDRItem pSDEDRItem, PSDER pSDER) throws Exception {
        super.onFillParentInfo_PSDER(pSDEDRItem, pSDER);
        pSDEDRItem.setViewPSDEId(pSDER.getMinorPSDEId());
    }

    @Override
    public Object getDataContextValue(PSDEDRItem pSDEDRItem, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEVIEWBASE", (boolean)true) == 0 && StringHelper.compare((String)string, (String)"psdeid", (boolean)true) == 0) {
            return pSDEDRItem.getViewPSDEId();
        }
        return super.getDataContextValue(pSDEDRItem, string, iDataContextParam);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDRItem pSDEDRItem, String string) throws Exception {
        if ((objectNode = super.fillModelV2(objectNode, pSDEDRItem, string)) != null && !StringHelper.isNullOrEmpty((String)pSDEDRItem.getViewPSDEId())) {
            try {
                String string2 = this.getModelV2UniqueTag("PSDATAENTITY", pSDEDRItem.getViewPSDEId(), string);
                objectNode.remove("viewpsdeid");
                objectNode.put("viewpsdeid", string2);
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
        return objectNode;
    }

    @Override
    public boolean fillModelV2Key(PSDEDRItem pSDEDRItem, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        boolean bl2 = super.fillModelV2Key(pSDEDRItem, objectNode, string, string2, bl);
        if (bl && objectNode != null) {
            try {
                String string3 = JsonNodeHelper.getString((ObjectNode)objectNode, (String)"viewpsdeid", null);
                if (!StringHelper.isNullOrEmpty((String)string3)) {
                    string3 = this.getModelV2Key("PSDATAENTITY", string3, string, "VIEWPSDEID");
                    pSDEDRItem.setViewPSDEId(string3);
                }
            }
            catch (Exception exception) {
                log.error((Object)exception);
                pSDEDRItem.setViewPSDEId(null);
            }
        }
        return bl2;
    }
}
