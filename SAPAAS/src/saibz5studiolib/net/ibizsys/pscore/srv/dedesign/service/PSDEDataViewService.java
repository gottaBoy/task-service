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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEDataViewService
extends PSDEDataViewServiceBase
implements IPSModelService<PSDEDataView> {
    private static final Log log = LogFactory.getLog(PSDEDataViewService.class);
    public static final String RESERVERTAG_DEFAULT = "R1";
    public static final String RESERVERTAG_INDEXTYPE = "R2";
    public static final String RESERVERTAG_FORMTYPE = "R3";
    public static final String XMLNODE_DEDATAVIEW = "DEDATAVIEW";
    public static final String XMLNODE_DEDATAVIEWITEM = "DEDATAVIEWITEM";

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDataEntity.getPSDataEntityId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreUIModel(), (boolean)false)) {
                return;
            }
            String string3 = pSDataEntity.getIndexDEType();
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                this.initIndexDEDataView(pSDataEntity);
            }
            if (DataObject.getIntegerValue((Object)pSDataEntity.getEnaMultiForm(), (Integer)0) > 0) {
                this.initMultiFormDataView(pSDataEntity);
            }
            return;
        }
    }

    protected void initIndexDEDataView(PSDataEntity pSDataEntity) throws Exception {
        boolean bl = this.isEnableFolderKey(pSDataEntity);
        String string = null;
        string = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_INDEXTYPE) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"INDEXDETYPE", (String)pSDataEntity.getIndexDEType());
        PSDEDataView pSDEDataView = new PSDEDataView();
        pSDEDataView.setPSDEDataViewId(string);
        if (this.checkKey(pSDEDataView) == 0) {
            pSDEDataView.reset();
            pSDEDataView.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEDataView.setCodeName("IndexType");
            if (this.selectOne(pSDEDataView, true)) {
                return;
            }
            pSDEDataView.reset();
            pSDEDataView.setPSDEDataViewId(string);
            pSDEDataView.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEDataView.setCodeName("IndexType");
            pSDEDataView.setPSDEDataViewName("\u7d22\u5f15\u5b9e\u4f53\u9009\u62e9\u6570\u636e\u89c6\u56fe");
            pSDEDataView.setEnablePagingBar(0);
            this.create(pSDEDataView);
        }
    }

    protected void initMultiFormDataView(PSDataEntity pSDataEntity) throws Exception {
        boolean bl = this.isEnableFolderKey(pSDataEntity);
        String string = null;
        string = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDataEntity.getPSDataEntityId(), (Object)RESERVERTAG_FORMTYPE) : KeyValueHelper.genUniqueId((String)pSDataEntity.getPSDataEntityId(), (String)"FORMTYPE", (String)"");
        PSDEDataView pSDEDataView = new PSDEDataView();
        pSDEDataView.setPSDEDataViewId(string);
        if (this.checkKey(pSDEDataView) == 0) {
            pSDEDataView.reset();
            pSDEDataView.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEDataView.setCodeName("FormType");
            if (this.selectOne(pSDEDataView, true)) {
                return;
            }
            pSDEDataView.reset();
            pSDEDataView.setPSDEDataViewId(string);
            pSDEDataView.setPSDEId(pSDataEntity.getPSDataEntityId());
            pSDEDataView.setCodeName("FormType");
            pSDEDataView.setPSDEDataViewName("\u8868\u5355\u9009\u62e9\u6570\u636e\u89c6\u56fe");
            pSDEDataView.setEnablePagingBar(0);
            this.create(pSDEDataView);
        }
    }

    @Override
    public void getDraftWithModel(PSDEDataView pSDEDataView) throws Exception {
        this.getDraftTempMajor(pSDEDataView);
        pSDEDataView.setViewModel(this.getViewModel(pSDEDataView));
    }

    @Override
    public void getWithModel(PSDEDataView pSDEDataView) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDEDataView.getPSDEDataViewId())) {
            this.getTempMajor(pSDEDataView);
        } else {
            this.getTemp(pSDEDataView);
        }
        pSDEDataView.setViewModel(this.getViewModel(pSDEDataView));
    }

    protected String getViewModel(PSDEDataView pSDEDataView) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DEDATAVIEW);
        xmlNode.setAttribute("PSDEID", pSDEDataView.getPSDEId());
        xmlNode.setAttribute("PSDEDATAVIEWID", pSDEDataView.getPSDEDataViewId());
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService((String)PSDEListItemService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList = pSDEListItemService.selectTempByPSDEDataView(pSDEDataView, "ORDER BY ORDERVALUE");
        for (PSDEListItem pSDEListItem : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_DEDATAVIEWITEM);
            pSDEListItem.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void createWithModel(PSDEDataView pSDEDataView) throws Exception {
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        pSDEDataView2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService((String)PSDEListItemService.class.getCanonicalName(), (SessionFactory)PSDEDataViewService.this.getSessionFactory());
                ArrayList<PSDEListItem> arrayList = pSDEListItemService.selectTempByPSDEDataView(pSDEDataView2);
                HashMap<String, PSDEListItem> hashMap = new HashMap<String, PSDEListItem>();
                for (PSDEListItem pSDEListItem2 : arrayList) {
                    hashMap.put(pSDEListItem2.getPSDEListItemId(), pSDEListItem2);
                }
                String string = pSDEDataView2.getViewModel();
                XmlNode viewModel = XmlNode.loadFromXML(string);
                if (viewModel != null) {
                    viewModel.setAttribute("PSDEID", pSDEDataView2.getPSDEId());
                    viewModel.setAttribute("PSDEDATAVIEWID", pSDEDataView2.getPSDEDataViewId());
                    PSDEDataViewService.this.updatePSDEDataViewModel(pSDEDataView2, viewModel, hashMap);
                    pSDEDataView2.setViewModel(XmlNode.export(viewModel));
                } else {
                    pSDEDataView2.setViewModel(null);
                }
                if (hashMap.size() > 0) {
                    for (PSDEListItem pSDEListItem3 : hashMap.values()) {
                        pSDEListItemService.removeTemp(pSDEListItem3);
                    }
                }
                PSDEDataViewService.this.createTempMajor(pSDEDataView2);
            }
        });
    }

    @Override
    public void updateWithModel(PSDEDataView pSDEDataView) throws Exception {
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        pSDEDataView2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService((String)PSDEListItemService.class.getCanonicalName(), (SessionFactory)PSDEDataViewService.this.getSessionFactory());
                ArrayList<PSDEListItem> arrayList = pSDEListItemService.selectTempByPSDEDataView(pSDEDataView2);
                HashMap<String, PSDEListItem> hashMap = new HashMap<String, PSDEListItem>();
                for (PSDEListItem pSDEListItem : arrayList) {
                    hashMap.put(pSDEListItem.getPSDEListItemId(), pSDEListItem);
                }
                XmlNode viewModel = XmlNode.loadFromXML(pSDEDataView2.getViewModel());
                if (viewModel != null) {
                    viewModel.setAttribute("PSDEID", pSDEDataView2.getPSDEId());
                    viewModel.setAttribute("PSDEDATAVIEWID", pSDEDataView2.getPSDEDataViewId());
                    PSDEDataViewService.this.updatePSDEDataViewModel(pSDEDataView2, viewModel, hashMap);
                    pSDEDataView2.setViewModel(XmlNode.export(viewModel));
                } else {
                    pSDEDataView2.setViewModel(null);
                }
                boolean bl = false;
                if (hashMap.size() > 0) {
                    for (PSDEListItem pSDEListItem2 : hashMap.values()) {
                        pSDEListItemService.removeTemp(pSDEListItem2);
                        bl = true;
                    }
                }
                PSDEDataViewService.this.updateTempMajor(pSDEDataView2);
            }
        });
    }

    protected void updatePSDEDataViewModel(PSDEDataView pSDEDataView, XmlNode xmlNode, HashMap<String, PSDEListItem> hashMap) throws Exception {
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
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DEDATAVIEWITEM, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(object = xmlNode2.getAttribute("PSDELISTITEMID", ""))) || (pSDEListItem = hashMap.remove(object)) == null) continue;
                boolean bl = false;
                if (StringHelper.compare((String)pSDEListItem.getPSDEDataViewId(), (String)pSDEDataView.getPSDEDataViewId(), (boolean)false) != 0) {
                    pSDEListItem.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDEListItem.getPSDEDataViewName(), (String)pSDEDataView.getPSDEDataViewName(), (boolean)false) != 0) {
                    pSDEListItem.setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
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
    public void getDraftFromWithModel(PSDEDataView pSDEDataView) throws Exception {
        super.getDraftTempMajorFrom(pSDEDataView);
        pSDEDataView.setViewModel(this.getViewModel(pSDEDataView));
    }
}
