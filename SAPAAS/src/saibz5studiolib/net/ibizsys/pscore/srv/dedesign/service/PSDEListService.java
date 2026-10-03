/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEListService
extends PSDEListServiceBase
implements IPSModelService<PSDEList> {
    private static final Log log = LogFactory.getLog(PSDEListService.class);
    public static final String RESERVERTAG_MOBDEFAULT = "R1";
    public static final String RESERVERTAG_MOBINDEXTYPE = "R2";
    public static final String RESERVERTAG_MOBFORMTYPE = "R3";
    public static final String XMLNODE_DELISTCONFIG = "DELISTCONFIG";
    public static final String XMLNODE_DELISTITEM = "DELISTITEM";

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDataEntity.getPSDataEntityId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreUIModel(), (boolean)false)) {
                return;
            }
            this.initDefaultMobList(pSDataEntity);
            if (DataObject.getBoolValue((Integer)pSDataEntity.getEnableMob(), (boolean)false)) {
                String string3 = pSDataEntity.getIndexDEType();
                if (!StringHelper.isNullOrEmpty((String)string3)) {
                    this.initMobIndexDEList(pSDataEntity);
                }
                if (DataObject.getIntegerValue((Object)pSDataEntity.getEnaMultiForm(), (Integer)0) > 0) {
                    this.initMobMultiFormList(pSDataEntity);
                }
            }
            return;
        }
    }

    protected void initDefaultMobList(PSDataEntity pSDataEntity) throws Exception {
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        String string = null;
        boolean bl = this.isEnableFolderKey(pSDataEntity);
        string = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_MOBDEFAULT) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"MOB");
        PSDEList pSDEList = new PSDEList();
        pSDEList.setPSDEListId(string);
        if (this.checkKey(pSDEList) == 0) {
            pSDEList.reset();
            pSDEList.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEList.setCodeName("Mob");
            if (this.selectOne(pSDEList, true)) {
                return;
            }
            pSDEList.reset();
            pSDEList.setPSDEListId(string);
            pSDEList.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEList.setCodeName("Mob");
            pSDEList.setPSDEListName("MOB");
            pSDEList.setLogicName("\u79fb\u52a8\u7aef\u5217\u8868");
            pSDEList.setAppendDEItems(1);
            PSDEDataSet pSDEDataSet = pSDataEntityService.getDefaultPSDEDataSet(pSDataEntity, null);
            if (pSDEDataSet != null) {
                pSDEList.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
            }
            this.autoFillCodeName(pSDEList);
            this.create(pSDEList);
        }
    }

    protected void initMobIndexDEList(PSDataEntity pSDataEntity) throws Exception {
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        String string = null;
        boolean bl = this.isEnableFolderKey(pSDataEntity);
        string = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_MOBINDEXTYPE) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"INDEXDETYPE", (String)pSDataEntity.getIndexDEType(), (String)"MOB");
        PSDEList pSDEList = new PSDEList();
        pSDEList.setPSDEListId(string);
        if (this.checkKey(pSDEList) == 0) {
            pSDEList.reset();
            pSDEList.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEList.setCodeName("MobIndexType");
            if (this.selectOne(pSDEList, true)) {
                return;
            }
            pSDEList.reset();
            pSDEList.setPSDEListId(string);
            pSDEList.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEList.setCodeName("MobIndexType");
            pSDEList.setPSDEListName("MOBINDEXTYPE");
            pSDEList.setLogicName("\u79fb\u52a8\u7aef\u7d22\u5f15\u5b9e\u4f53\u9009\u62e9\u5217\u8868");
            PSDEDataSet pSDEDataSet = pSDataEntityService.getDefaultPSDEDataSet(pSDataEntity, "INDEXDE");
            if (pSDEDataSet != null) {
                pSDEList.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
            }
            pSDEList.setCodeName("MobIndexType");
            this.autoFillCodeName(pSDEList);
            this.create(pSDEList);
            this.initMobListItems(pSDEList);
        }
    }

    protected void initMobMultiFormList(PSDataEntity pSDataEntity) throws Exception {
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        String string = null;
        boolean bl = this.isEnableFolderKey(pSDataEntity);
        string = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_MOBFORMTYPE) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"FORMTYPE", (String)"", (String)"MOB");
        PSDEList pSDEList = new PSDEList();
        pSDEList.setPSDEListId(string);
        if (this.checkKey(pSDEList) == 0) {
            pSDEList.reset();
            pSDEList.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEList.setCodeName("MobFormType");
            if (this.selectOne(pSDEList, true)) {
                return;
            }
            pSDEList.reset();
            pSDEList.setPSDEListId(string);
            pSDEList.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEList.setCodeName("MobFormType");
            pSDEList.setPSDEListName("MOBFORMTYPE");
            pSDEList.setLogicName("\u79fb\u52a8\u7aef\u8868\u5355\u9009\u62e9\u5217\u8868");
            PSDEDataSet pSDEDataSet = pSDataEntityService.getDefaultPSDEDataSet(pSDataEntity, "MULTIFORM");
            if (pSDEDataSet != null) {
                pSDEList.setPSDEDSId(pSDEDataSet.getPSDEDataSetId());
            }
            pSDEList.setCodeName("MobFormType");
            this.autoFillCodeName(pSDEList);
            this.create(pSDEList);
            this.initMobListItems(pSDEList);
        }
    }

    protected void autoFillCodeName(PSDEList pSDEList) throws Exception {
        PSDEList pSDEList2;
        String string = pSDEList.getCodeName();
        int n = 1;
        String string2 = string;
        do {
            if (n > 1) {
                string2 = StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 1 ? "" : Integer.valueOf(n)));
            }
            ++n;
            pSDEList2 = new PSDEList();
            pSDEList2.setPSDEId(pSDEList.getPSDEId());
            pSDEList2.setCodeName(string2);
        } while (this.select(pSDEList2, true));
        pSDEList.setCodeName(string2);
    }

    protected void initMobListItems(PSDEList pSDEList) throws Exception {
        PSDEListItem pSDEListItem;
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
        PSDEField pSDEField = new PSDEField();
        pSDEField.setPSDEId(pSDEList.getPSDEId());
        pSDEField.setPKey(1);
        if (pSDEFieldService.select(pSDEField, true)) {
            pSDEListItem = new PSDEListItem();
            pSDEListItem.setPSDEListItemName("srfkey");
            pSDEListItem.setPSDEListId(pSDEList.getPSDEListId());
            pSDEListItem.setPSDEListName(pSDEList.getPSDEListName());
            pSDEListItem.setItemType("DATAITEM");
            pSDEListItem.setDataItems(pSDEField.getPSDEFieldName().toLowerCase());
            pSDEListItemService.create(pSDEListItem);
        }
        pSDEField.reset();
        pSDEField.setPSDEId(pSDEList.getPSDEId());
        pSDEField.setMajorField(1);
        if (pSDEFieldService.select(pSDEField, true)) {
            pSDEListItem = new PSDEListItem();
            pSDEListItem.setPSDEListItemName("srfmajortext");
            pSDEListItem.setPSDEListId(pSDEList.getPSDEListId());
            pSDEListItem.setPSDEListName(pSDEList.getPSDEListName());
            pSDEListItem.setItemType("DATAITEM");
            pSDEListItem.setDataItems(pSDEField.getPSDEFieldName().toLowerCase());
            pSDEListItemService.create(pSDEListItem);
        }
    }

    @Override
    public void getDraftWithModel(PSDEList pSDEList) throws Exception {
        this.getDraftTempMajor(pSDEList);
        pSDEList.setListModel(this.getListModel(pSDEList));
    }

    @Override
    public void getWithModel(PSDEList pSDEList) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDEList.getPSDEListId())) {
            this.getTempMajor(pSDEList);
        } else {
            this.getTemp(pSDEList);
        }
        pSDEList.setListModel(this.getListModel(pSDEList));
    }

    protected String getListModel(PSDEList pSDEList) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DELISTCONFIG);
        xmlNode.setAttribute("PSDEID", pSDEList.getPSDEId());
        xmlNode.setAttribute("PSDELISTID", pSDEList.getPSDEListId());
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService((String)PSDEListItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList = pSDEListItemService.selectTempByPSDEList(pSDEList, "ORDER BY ORDERVALUE");
        for (PSDEListItem pSDEListItem : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_DELISTITEM);
            pSDEListItem.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void createWithModel(PSDEList pSDEList) throws Exception {
        final PSDEList pSDEList2 = pSDEList;
        pSDEList2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService((String)PSDEListItemService.class.getCanonicalName(), (SessionFactory)PSDEListService.this.getSessionFactory());
                ArrayList<PSDEListItem> arrayList = pSDEListItemService.selectTempByPSDEList(pSDEList2);
                HashMap<String, PSDEListItem> hashMap = new HashMap<String, PSDEListItem>();
                for (PSDEListItem pSDEListItem2 : arrayList) {
                    hashMap.put(pSDEListItem2.getPSDEListItemId(), pSDEListItem2);
                }
                String string = pSDEList2.getListModel();
                XmlNode listModel = XmlNode.loadFromXML(string);
                if (listModel != null) {
                    listModel.setAttribute("PSDEID", pSDEList2.getPSDEId());
                    listModel.setAttribute("PSDELISTID", pSDEList2.getPSDEListId());
                    PSDEListService.this.updatePSDEListModel(pSDEList2, listModel, hashMap);
                    pSDEList2.setListModel(XmlNode.export(listModel));
                } else {
                    pSDEList2.setListModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEListItem pSDEListItem3 : hashMap.values()) {
                        pSDEListItemService.removeTemp(pSDEListItem3);
                    }
                }
                PSDEListService.this.createTempMajor(pSDEList2);
            }
        });
    }

    @Override
    public void updateWithModel(PSDEList pSDEList) throws Exception {
        final PSDEList pSDEList2 = pSDEList;
        pSDEList2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService((String)PSDEListItemService.class.getCanonicalName(), (SessionFactory)PSDEListService.this.getSessionFactory());
                ArrayList<PSDEListItem> arrayList = pSDEListItemService.selectTempByPSDEList(pSDEList2, "ORDER BY ORDERVALUE");
                HashMap<String, PSDEListItem> hashMap = new HashMap<String, PSDEListItem>();
                for (PSDEListItem pSDEListItem : arrayList) {
                    hashMap.put(pSDEListItem.getPSDEListItemId(), pSDEListItem);
                }
                XmlNode listModel = XmlNode.loadFromXML(pSDEList2.getListModel());
                if (listModel != null) {
                    listModel.setAttribute("PSDEID", pSDEList2.getPSDEId());
                    listModel.setAttribute("PSDELISTID", pSDEList2.getPSDEListId());
                    PSDEListService.this.updatePSDEListModel(pSDEList2, listModel, hashMap);
                    pSDEList2.setListModel(XmlNode.export(listModel));
                } else {
                    pSDEList2.setListModel(null);
                }
                boolean bl = false;
                if (hashMap.size() > 0) {
                    for (PSDEListItem pSDEListItem2 : hashMap.values()) {
                        pSDEListItemService.removeTemp(pSDEListItem2);
                        bl = true;
                    }
                }
                PSDEListService.this.updateTempMajor(pSDEList2);
            }
        });
    }

    protected void updatePSDEListModel(PSDEList pSDEList, XmlNode xmlNode, HashMap<String, PSDEListItem> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService((String)PSDEListItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            HashMap<String, Integer> hashMap2 = new HashMap<String, Integer>();
            while (iterator.hasNext()) {
                Integer n;
                PSDEListItem pSDEListItem;
                String object;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DELISTITEM, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(object = xmlNode2.getAttribute("PSDELISTITEMID", ""))) || (pSDEListItem = hashMap.remove(object)) == null) continue;
                boolean bl = false;
                if (StringHelper.compare((String)pSDEListItem.getPSDEListId(), (String)pSDEList.getPSDEListId(), (boolean)false) != 0) {
                    pSDEListItem.setPSDEListId(pSDEList.getPSDEListId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDEListItem.getPSDEListName(), (String)pSDEList.getPSDEListName(), (boolean)false) != 0) {
                    pSDEListItem.setPSDEListName(pSDEList.getPSDEListName());
                    bl = true;
                }
                if ((n = (Integer)hashMap2.get("ROOT")) == null) {
                    n = 0;
                }
                n = n + 10;
                hashMap2.put("ROOT", n);
                if (pSDEListItem.getOrderValue() == null || pSDEListItem.getOrderValue() != n) {
                    pSDEListItem.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDEListItemService.updateTemp(pSDEListItem);
                }
                xmlNode2.resetAttributes();
                pSDEListItem.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void getDraftFromWithModel(PSDEList pSDEList) throws Exception {
        super.getDraftTempMajorFrom(pSDEList);
        pSDEList.setListModel(this.getListModel(pSDEList));
    }
}
