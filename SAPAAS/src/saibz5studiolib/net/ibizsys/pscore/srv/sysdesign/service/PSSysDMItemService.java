/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMVerItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMVerItemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysDMItemService
extends PSSysDMItemServiceBase {
    private static final Log log = LogFactory.getLog(PSSysDMItemService.class);

    @Override
    protected void onAfterCreate(PSSysDMItem pSSysDMItem) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getPSSysDMVerId()) && !StringHelper.isNullOrEmpty((String)pSSysDMItem.getPSSysDMItemName())) {
            PSSysDMVerItemService pSSysDMVerItemService = (PSSysDMVerItemService)ServiceGlobal.getService(PSSysDMVerItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysDMVerItem pSSysDMVerItem = new PSSysDMVerItem();
            pSSysDMItem.copyTo((IDataObject)pSSysDMVerItem, false);
            pSSysDMVerItem.setPSSysDMVerItemName(pSSysDMItem.getPSSysDMItemName());
            if (StringHelper.isNullOrEmpty((String)pSSysDMVerItem.getPSSysDMVerName())) {
                pSSysDMVerItem.setPSSysDMVerName("\u7248\u672c");
            }
            pSSysDMVerItemService.save((IEntity)pSSysDMVerItem);
        }
        super.onAfterCreate(pSSysDMItem);
    }

    @Override
    protected void onAfterUpdate(PSSysDMItem pSSysDMItem) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getPSSysDMVerId()) && !StringHelper.isNullOrEmpty((String)pSSysDMItem.getPSSysDMItemName())) {
            PSSysDMVerItemService pSSysDMVerItemService = (PSSysDMVerItemService)ServiceGlobal.getService(PSSysDMVerItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysDMVerItem pSSysDMVerItem = new PSSysDMVerItem();
            pSSysDMItem.copyTo((IDataObject)pSSysDMVerItem, false);
            pSSysDMVerItem.setPSSysDMVerItemName(pSSysDMItem.getPSSysDMItemName());
            if (StringHelper.isNullOrEmpty((String)pSSysDMVerItem.getPSSysDMVerName())) {
                pSSysDMVerItem.setPSSysDMVerName("\u7248\u672c");
            }
            pSSysDMVerItemService.save((IEntity)pSSysDMVerItem);
        }
        super.onAfterUpdate(pSSysDMItem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysDMItem pSSysDMItem, String string) throws Exception {
        if (DataObject.getBoolValue((Integer)pSSysDMItem.getUserFlag(), (boolean)false)) {
            pSSysDMItem.setPSObjId(null);
        }
        return super.fillModelV2(objectNode, pSSysDMItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysDMItem pSSysDMItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        JsonNode jsonNode;
        if (n == 1) {
            return false;
        }
        if (pSSysDMItem.contains("USERFLAG") ? !DataObject.getBoolValue((Integer)pSSysDMItem.getUserFlag(), (boolean)false) : objectNode != null && (jsonNode = objectNode.get("userflag")) != null && jsonNode.asInt() != 1) {
            return false;
        }
        return super.testCompileCurModelV2(pSSysDMItem, objectNode, string, string2, n);
    }

    @Override
    public String getModelV2Tag(PSSysDMItem pSSysDMItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysDMItem.getPSSysDMItemName()) && !StringHelper.isNullOrEmpty((String)pSSysDMItem.getDBObjType())) {
            return StringHelper.format((String)"%1$s(%2$s)", (Object)pSSysDMItem.getPSSysDMItemName(), (Object)pSSysDMItem.getDBObjType());
        }
        return super.getModelV2Tag(pSSysDMItem);
    }
}

