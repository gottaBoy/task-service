/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
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
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEGridService
extends PSDEGridServiceBase
implements IPSModelService<PSDEGrid> {
    private static final Log log = LogFactory.getLog(PSDEGridService.class);
    public static final String XMLNODE_DEGRID = "DEGRID";
    public static final String RESERVERTAG_DEFAULT = "R1";

    @Override
    public void getWithModel(PSDEGrid pSDEGrid) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDEGrid.getPSDEGridId())) {
            this.getTempMajor(pSDEGrid);
        } else {
            this.getTemp((IEntity)pSDEGrid);
        }
        pSDEGrid.setGridModel(this.getGridModel(pSDEGrid));
    }

    protected String getGridModel(PSDEGrid pSDEGrid) throws Exception {
        Object object;
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService((String)PSDEGridColService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridCol> arrayList = pSDEGridColService.selectTempByPSDEGrid(pSDEGrid, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSDEGridCol entityBase2 : arrayList) {
            object = new XmlNode();
            object.setNodeName(entityBase2.getGridColType());
            entityBase2.fillXmlNode((XmlNode)object, true);
            hashMap.put(entityBase2.getPSDEGridColId(), (XmlNode)object);
        }
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DEGRID);
        PSSystem pSSystem = pSDEGrid.getPSDE().getPSSystem();
        xmlNode.setAttribute("PSSYSTEMID", pSSystem.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)pSSystem.getPSDevSlnSysId())) {
            xmlNode.setAttribute("PSDEVSLNSYSID", pSSystem.getPSDevSlnSysId());
            xmlNode.setAttribute("TASKSERVERURL", pSSystem.getPSDevCenterTS().getPSTaskServer().getServerUrl());
        } else {
            xmlNode.setAttribute("PSDEVSLNSYSID", "");
            xmlNode.setAttribute("TASKSERVERURL", "http://lionlau-w530:8000/SAEAM/");
        }
        xmlNode.setAttribute("PSDEID", pSDEGrid.getPSDEId());
        xmlNode.setAttribute("PSDEGRIDID", pSDEGrid.getPSDEGridId());
        object = (PSDEFieldService)ServiceGlobal.getService((String)PSDEFieldService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEField> arrayList2 = ((PSDEFieldService)object).selectByDataEntity(pSDEGrid.getPSDEId());
        XmlNode xmlNode2 = new XmlNode();
        xmlNode2.setNodeName("DEFIELDS");
        xmlNode.addNode(xmlNode2);
        for (PSDEField pSDEField : arrayList2) {
            if (DataObject.getIntegerValue((Object)pSDEField.getDEFType(), (Integer)0) == 4) continue;
            XmlNode xmlNode3 = new XmlNode();
            xmlNode3.setNodeName("DEFIELD");
            xmlNode3.setAttribute("PSDEFID", pSDEField.getPSDEFieldId());
            xmlNode3.setAttribute("PSDEFNAME", pSDEField.getPSDEFieldName().toLowerCase());
            xmlNode3.setAttribute("LOGICNAME", pSDEField.getLogicName());
            xmlNode2.addNode(xmlNode3);
        }
        for (PSDEGridCol pSDEGridCol : arrayList) {
            xmlNode2 = (XmlNode)hashMap.get(pSDEGridCol.getPSDEGridColId());
            if (StringHelper.isNullOrEmpty((String)pSDEGridCol.getPPSDEGridColId())) {
                xmlNode.addNode(xmlNode2);
                continue;
            }
            XmlNode xmlNode4 = (XmlNode)hashMap.get(pSDEGridCol.getPPSDEGridColId());
            if (xmlNode4 != null) {
                xmlNode4.addNode(xmlNode2);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u8868\u683c\u5217[%1$s], \u5f53\u524d[%2$s]", (Object)pSDEGridCol.getPPSDEGridColId(), (Object)pSDEGridCol.getPSDEGridColName()));
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void updateWithModel(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridCol pSDEGridCol2;
                PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService((String)PSDEGridColService.class.getCanonicalName(), (SessionFactory)PSDEGridService.this.getSessionFactory());
                ArrayList<PSDEGridCol> arrayList = pSDEGridColService.selectTempByPSDEGrid(pSDEGrid2);
                HashMap<String, PSDEGridCol> hashMap = new HashMap<String, PSDEGridCol>();
                for (PSDEGridCol pSDEGridCol2 : arrayList) {
                    hashMap.put(pSDEGridCol2.getPSDEGridColId(), pSDEGridCol2);
                }
                String string = pSDEGrid2.getGridModel();
                pSDEGridCol2 = XmlNode.loadFromXML((String)string);
                if (pSDEGridCol2 != null) {
                    pSDEGridCol2.setAttribute("PSDEID", pSDEGrid2.getPSDEId());
                    pSDEGridCol2.setAttribute("PSDEGRIDID", pSDEGrid2.getPSDEGridId());
                    PSDEGridService.this.updatePSDEGridCols(pSDEGrid2, null, (XmlNode)pSDEGridCol2, hashMap);
                    pSDEGrid2.setGridModel(XmlNode.export((XmlNode)pSDEGridCol2));
                } else {
                    pSDEGrid2.setGridModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEGridCol pSDEGridCol3 : hashMap.values()) {
                        pSDEGridColService.removeTemp((IEntity)pSDEGridCol3);
                    }
                }
                PSDEGridService.this.updateTempMajor(pSDEGrid2);
            }
        });
    }

    protected void updatePSDEGridCols(PSDEGrid pSDEGrid, PSDEGridCol pSDEGridCol, XmlNode xmlNode, HashMap<String, PSDEGridCol> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService((String)PSDEGridColService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSDEGridCol pSDEGridCol2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string = xmlNode2.getAttribute("PSDEGRIDCOLID", "");
                if (StringHelper.isNullOrEmpty((String)string) || (pSDEGridCol2 = hashMap.remove(string)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSDEGridCol2.getPSDEGridId(), (String)pSDEGrid.getPSDEGridId(), (boolean)false) != 0) {
                    pSDEGridCol2.setPSDEGridId(pSDEGrid.getPSDEGridId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDEGridCol2.getPSDEGridName(), (String)pSDEGrid.getPSDEGridName(), (boolean)false) != 0) {
                    pSDEGridCol2.setPSDEGridName(pSDEGrid.getPSDEGridName());
                    bl = true;
                }
                if (pSDEGridCol != null) {
                    if (StringHelper.compare((String)pSDEGridCol2.getPPSDEGridColId(), (String)pSDEGridCol.getPSDEGridColId(), (boolean)false) != 0) {
                        pSDEGridCol2.setPPSDEGridColId(pSDEGridCol.getPSDEGridColId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSDEGridCol2.getPPSDEGridColName(), (String)pSDEGridCol.getPSDEGridColName(), (boolean)false) != 0) {
                        pSDEGridCol2.setPPSDEGridColName(pSDEGridCol.getPSDEGridColName());
                        bl = true;
                    }
                }
                if (pSDEGridCol2.getOrderValue() == null || pSDEGridCol2.getOrderValue() != n) {
                    pSDEGridCol2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDEGridColService.updateTemp((IEntity)pSDEGridCol2);
                }
                xmlNode2.resetAttributes();
                pSDEGridCol2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSDEGridCols(pSDEGrid, pSDEGridCol2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridCol pSDEGridCol2;
                PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService((String)PSDEGridColService.class.getCanonicalName(), (SessionFactory)PSDEGridService.this.getSessionFactory());
                ArrayList<PSDEGridCol> arrayList = pSDEGridColService.selectTempByPSDEGrid(pSDEGrid2);
                HashMap<String, PSDEGridCol> hashMap = new HashMap<String, PSDEGridCol>();
                for (PSDEGridCol pSDEGridCol2 : arrayList) {
                    hashMap.put(pSDEGridCol2.getPSDEGridColId(), pSDEGridCol2);
                }
                String string = pSDEGrid2.getGridModel();
                pSDEGridCol2 = XmlNode.loadFromXML((String)string);
                if (pSDEGridCol2 != null) {
                    pSDEGridCol2.setAttribute("PSDEID", pSDEGrid2.getPSDEId());
                    pSDEGridCol2.setAttribute("PSDEGRIDID", pSDEGrid2.getPSDEGridId());
                    PSDEGridService.this.updatePSDEGridCols(pSDEGrid2, null, (XmlNode)pSDEGridCol2, hashMap);
                    pSDEGrid2.setGridModel(XmlNode.export((XmlNode)pSDEGridCol2));
                } else {
                    pSDEGrid2.setGridModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEGridCol pSDEGridCol3 : hashMap.values()) {
                        pSDEGridColService.removeTemp((IEntity)pSDEGridCol3);
                    }
                }
                PSDEGridService.this.createTempMajor((IEntity)pSDEGrid2);
            }
        });
    }

    @Override
    public void previewSave(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        log.debug((Object)"\u5f00\u59cb[previewSave]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridCol pSDEGridCol2;
                PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService((String)PSDEGridColService.class.getCanonicalName(), (SessionFactory)PSDEGridService.this.getSessionFactory());
                ArrayList<PSDEGridCol> arrayList = pSDEGridColService.selectTempByPSDEGrid(pSDEGrid2);
                HashMap<String, PSDEGridCol> hashMap = new HashMap<String, PSDEGridCol>();
                for (PSDEGridCol pSDEGridCol2 : arrayList) {
                    hashMap.put(pSDEGridCol2.getPSDEGridColId(), pSDEGridCol2);
                }
                Object object = pSDEGrid2.getGridModel();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = WebContext.getCurrent().getPostValue("formmodel");
                }
                if ((pSDEGridCol2 = XmlNode.loadFromXML((String)object)) != null) {
                    PSDEGridService.this.updatePSDEGridCols(pSDEGrid2, null, (XmlNode)pSDEGridCol2, hashMap);
                    pSDEGrid2.setGridModel(XmlNode.export((XmlNode)pSDEGridCol2));
                } else {
                    pSDEGrid2.setGridModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEGridCol pSDEGridCol3 : hashMap.values()) {
                        pSDEGridColService.removeTemp((IEntity)pSDEGridCol3);
                    }
                }
            }
        });
    }

    @Override
    public void getDraftWithModel(PSDEGrid pSDEGrid) throws Exception {
        this.getDraftTempMajor((IEntity)pSDEGrid);
        pSDEGrid.setGridModel(this.getGridModel(pSDEGrid));
    }

    @Override
    protected void onBeforeCreate(PSDEGrid pSDEGrid) throws Exception {
        pSDEGrid.setGridModel(null);
        super.onBeforeCreate(pSDEGrid);
    }

    @Override
    protected void onBeforeUpdate(PSDEGrid pSDEGrid) throws Exception {
        pSDEGrid.setGridModel(null);
        super.onBeforeUpdate(pSDEGrid);
    }

    @Override
    public void getDraftFromWithModel(PSDEGrid pSDEGrid) throws Exception {
        this.getDraftTempMajorFrom(pSDEGrid);
        pSDEGrid.setGridModel(this.getGridModel(pSDEGrid));
    }

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDataEntity.getPSDataEntityId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreUIModel(), (boolean)false)) {
                return;
            }
            this.initDefaultGrid(pSDataEntity);
            return;
        }
    }

    protected void initDefaultGrid(PSDataEntity pSDataEntity) throws Exception {
        String string = null;
        string = this.isEnableFolderKey((IEntity)pSDataEntity) ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_DEFAULT) : pSDataEntity.getPSDataEntityId();
        PSDEGrid pSDEGrid = new PSDEGrid();
        pSDEGrid.setPSDEGridId(string);
        if (this.checkKey(pSDEGrid) == 0) {
            PSDEField pSDEField;
            PSDEGridCol pSDEGridCol;
            PSDEField pSDEField2;
            pSDEGrid.reset();
            pSDEGrid.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEGrid.setCodeName("Main");
            if (this.selectOne((IEntity)pSDEGrid, true)) {
                return;
            }
            pSDEGrid.reset();
            pSDEGrid.setPSDEGridId(string);
            pSDEGrid.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEGrid.setCodeName("Main");
            pSDEGrid.setPSDEGridName("\u4e3b\u8868\u683c");
            pSDEGrid.setEnablePagingBar(1);
            pSDEGrid.setPagingSize(20);
            this.create(pSDEGrid);
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSDEField> arrayList = pSDEFieldService.selectByPSDE(pSDataEntity);
            HashMap<String, PSDEField> hashMap = new HashMap<String, PSDEField>();
            PSDEField entityBase2 = null;
            for (PSDEField entityBase3 : arrayList) {
                hashMap.put(entityBase3.getPSDEFieldName(), entityBase3);
                if (!DataObject.getBoolValue((Integer)entityBase3.getMajorField(), (boolean)false)) continue;
                entityBase2 = entityBase3;
            }
            PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
            if (entityBase2 != null) {
                PSDEGridCol pSDEGridCol2 = new PSDEGridCol();
                pSDEGridCol2.setPSDEGridId(pSDEGrid.getPSDEGridId());
                pSDEGridCol2.setPSDEGridColName(entityBase2.getPSDEFieldName().toLowerCase());
                pSDEGridCol2.setGridColType("DEFGRIDCOLUMN");
                pSDEGridCol2.setOrderValue(1);
                pSDEGridCol2.setWidth(150);
                pSDEGridCol2.setPSDEFId(entityBase2.getPSDEFieldId());
                pSDEGridCol2.setPSDEFName(entityBase2.getPSDEFieldName());
                pSDEGridColService.create(pSDEGridCol2);
            }
            if ((pSDEField2 = (PSDEField)hashMap.get("UPDATEMAN")) != null) {
                pSDEGridCol = new PSDEGridCol();
                pSDEGridCol.setPSDEGridId(pSDEGrid.getPSDEGridId());
                pSDEGridCol.setPSDEGridColName(pSDEField2.getPSDEFieldName().toLowerCase());
                pSDEGridCol.setGridColType("DEFGRIDCOLUMN");
                pSDEGridCol.setOrderValue(3);
                pSDEGridCol.setWidth(150);
                pSDEGridCol.setPSDEFId(pSDEField2.getPSDEFieldId());
                pSDEGridCol.setPSDEFName(pSDEField2.getPSDEFieldName());
                pSDEGridColService.create(pSDEGridCol);
            }
            if ((pSDEField = (PSDEField)hashMap.get("UPDATEDATE")) != null) {
                pSDEGridCol = new PSDEGridCol();
                pSDEGridCol.setPSDEGridId(pSDEGrid.getPSDEGridId());
                pSDEGridCol.setPSDEGridColName(pSDEField.getPSDEFieldName().toLowerCase());
                pSDEGridCol.setGridColType("DEFGRIDCOLUMN");
                pSDEGridCol.setOrderValue(4);
                pSDEGridCol.setWidth(150);
                pSDEGridCol.setPSDEFId(pSDEField.getPSDEFieldId());
                pSDEGridCol.setPSDEFName(pSDEField.getPSDEFieldName());
                pSDEGridColService.create(pSDEGridCol);
            }
        }
    }

    @Override
    protected void onAfterUpdate(PSDEGrid pSDEGrid) throws Exception {
        super.onAfterUpdate(pSDEGrid);
    }

    @Override
    public void getDraftTempMajorFrom(PSDEGrid pSDEGrid) throws Exception {
        Object object = EntityBase.getOriginKey((IEntity)pSDEGrid);
        if (StringHelper.isNullOrEmpty((Object)object)) {
            object = pSDEGrid.getPSDEGridId();
        }
        super.getDraftTempMajorFrom(pSDEGrid);
        if (!StringHelper.isNullOrEmpty((Object)object)) {
            PSDEGrid pSDEGrid2;
            PSDEGrid pSDEGrid3 = new PSDEGrid();
            pSDEGrid3.setSessionFactory(this.getSessionFactory());
            pSDEGrid3.setPSDEGridId((String)object);
            if (!pSDEGrid3.get(true)) {
                return;
            }
            int n = 2;
            while (true) {
                pSDEGrid2 = new PSDEGrid();
                pSDEGrid2.setSessionFactory(this.getSessionFactory());
                pSDEGrid2.setPSDEId(pSDEGrid3.getPSDEId());
                pSDEGrid2.setPSDEGridName(StringHelper.format((String)"%1$s(%2$s)", (Object)pSDEGrid3.getPSDEGridName(), (Object)n));
                if (!pSDEGrid2.select(true)) break;
                ++n;
            }
            pSDEGrid.setPSDEGridName(pSDEGrid2.getPSDEGridName());
            n = 2;
            while (true) {
                pSDEGrid2 = new PSDEGrid();
                pSDEGrid2.setSessionFactory(this.getSessionFactory());
                pSDEGrid2.setPSDEId(pSDEGrid3.getPSDEId());
                pSDEGrid2.setCodeName(StringHelper.format((String)"%1$s_%2$s", (Object)pSDEGrid3.getCodeName(), (Object)n));
                if (!pSDEGrid2.select(true)) {
                    pSDEGrid.setCodeName(pSDEGrid2.getCodeName());
                    break;
                }
                ++n;
            }
        }
    }
}

