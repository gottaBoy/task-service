/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.CloneSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSDEFTypeBase;
import net.ibizsys.pscore.srv.config.entity.PSVarSampleValue;
import net.ibizsys.pscore.srv.config.service.PSVarSampleValueService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFSFItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFSFItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFormDetailService
extends PSDEFormDetailServiceBase {
    private static final Log log = LogFactory.getLog(PSDEFormDetailService.class);

    @Override
    public void updateWithModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        final PSDEFormDetail pSDEFormDetail2 = pSDEFormDetail;
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService((String)PSDEFDLogicService.class.getCanonicalName(), (SessionFactory)PSDEFormDetailService.this.getSessionFactory());
                ArrayList<PSDEFDLogic> arrayList = pSDEFDLogicService.selectTempByPSDEFormDetail(pSDEFormDetail2);
                HashMap<String, PSDEFDLogic> hashMap = new HashMap<String, PSDEFDLogic>();
                for (PSDEFDLogic pSDEFDLogic2 : arrayList) {
                    hashMap.put(pSDEFDLogic2.getPSDEFDLogicId(), pSDEFDLogic2);
                }
                int n = DataObject.getIntegerValue((Object)pSDEFormDetail2.getModelState(), (Integer)0);
                XmlNode rootNode = new XmlNode();
                rootNode.setNodeName("DEFDLOGIC");
                rootNode.setAttribute("PSDEFORMDETAILID", pSDEFormDetail2.getPSDEFormDetailId());
                rootNode.setAttribute("PSDEFORMID", pSDEFormDetail2.getPSDEFormId());
                String emptyLogic = XmlNode.export(rootNode);
                if (StringHelper.compare((String)pSDEFormDetail2.getDetailType(), (String)"FORMITEM", (boolean)true) == 0) {
                    XmlNode xmlNode = XmlNode.loadFromXML(pSDEFormDetail2.getEnableLogic());
                    if (xmlNode != null) {
                        PSDEFormDetailService.this.updatePSDEFDLogics(pSDEFormDetail2, "ITEMENABLE", null, xmlNode, hashMap);
                        xmlNode.setAttribute("PSDEFORMDETAILID", pSDEFormDetail2.getPSDEFormDetailId());
                        xmlNode.setAttribute("PSDEFORMID", pSDEFormDetail2.getPSDEFormId());
                        pSDEFormDetail2.setEnableLogic(XmlNode.export((XmlNode)xmlNode));
                        n |= 0x400;
                    } else {
                        pSDEFormDetail2.setEnableLogic(emptyLogic);
                        n ^= 0x400;
                    }
                    XmlNode blankNode = XmlNode.loadFromXML(pSDEFormDetail2.getBlankLogic());
                    if (blankNode != null) {
                        PSDEFormDetailService.this.updatePSDEFDLogics(pSDEFormDetail2, "ITEMBLANK", null, blankNode, hashMap);
                        blankNode.setAttribute("PSDEFORMDETAILID", pSDEFormDetail2.getPSDEFormDetailId());
                        blankNode.setAttribute("PSDEFORMID", pSDEFormDetail2.getPSDEFormId());
                        pSDEFormDetail2.setBlankLogic(XmlNode.export(blankNode));
                        n |= 0x1000;
                    } else {
                        pSDEFormDetail2.setBlankLogic(emptyLogic);
                        n ^= 0x1000;
                    }
                } else {
                    pSDEFormDetail2.setEnableLogic(emptyLogic);
                    pSDEFormDetail2.setBlankLogic(emptyLogic);
                    n ^= 0x400;
                    n ^= 0x1000;
                }
                XmlNode visibleNode = XmlNode.loadFromXML(pSDEFormDetail2.getVisibleLogic());
                if (visibleNode != null) {
                    PSDEFormDetailService.this.updatePSDEFDLogics(pSDEFormDetail2, "PANELVISIBLE", null, visibleNode, hashMap);
                    visibleNode.setAttribute("PSDEFORMDETAILID", pSDEFormDetail2.getPSDEFormDetailId());
                    visibleNode.setAttribute("PSDEFORMID", pSDEFormDetail2.getPSDEFormId());
                    pSDEFormDetail2.setVisibleLogic(XmlNode.export(visibleNode));
                    n |= 0x800;
                } else {
                    pSDEFormDetail2.setVisibleLogic(emptyLogic);
                    n ^= 0x800;
                }
                if (hashMap.size() > 0) {
                    for (PSDEFDLogic pSDEFDLogic3 : hashMap.values()) {
                        pSDEFDLogicService.removeTemp(pSDEFDLogic3);
                    }
                }
                PSDEFormDetailService.this.updateTemp(pSDEFormDetail2);
            }
        });
    }

    protected void updatePSDEFDLogics(PSDEFormDetail pSDEFormDetail, String string, PSDEFDLogic pSDEFDLogic, XmlNode xmlNode, HashMap<String, PSDEFDLogic> hashMap) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService((String)PSDEFDLogicService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                PSDEFDLogic pSDEFDLogic2;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                String string2 = xmlNode2.getAttribute("PSDEFDLOGICID", "");
                if (StringHelper.isNullOrEmpty((String)string2) || (pSDEFDLogic2 = hashMap.remove(string2)) == null) continue;
                ++n;
                boolean bl = false;
                if (StringHelper.compare((String)pSDEFDLogic2.getLogicCat(), (String)string, (boolean)false) != 0) {
                    pSDEFDLogic2.setLogicCat(string);
                    bl = true;
                }
                if (StringHelper.compare((String)pSDEFDLogic2.getPSDEFormDetailId(), (String)pSDEFormDetail.getPSDEFormDetailId(), (boolean)false) != 0) {
                    pSDEFDLogic2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
                    bl = true;
                }
                if (StringHelper.compare((String)pSDEFDLogic2.getPSDEFormDetailName(), (String)pSDEFormDetail.getPSDEFormDetailName(), (boolean)false) != 0) {
                    pSDEFDLogic2.setPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName());
                    bl = true;
                }
                if (pSDEFDLogic != null) {
                    if (StringHelper.compare((String)pSDEFDLogic2.getPPSDEFDLogicId(), (String)pSDEFDLogic.getPSDEFDLogicId(), (boolean)false) != 0) {
                        pSDEFDLogic2.setPPSDEFDLogicId(pSDEFDLogic.getPSDEFDLogicId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)pSDEFDLogic2.getPPSDEFDLogicName(), (String)pSDEFDLogic.getPSDEFDLogicName(), (boolean)false) != 0) {
                        pSDEFDLogic2.setPPSDEFDLogicName(pSDEFDLogic.getPSDEFDLogicName());
                        bl = true;
                    }
                }
                if (pSDEFDLogic2.getOrderValue() == null || pSDEFDLogic2.getOrderValue() != n) {
                    pSDEFDLogic2.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDEFDLogicService.updateTemp(pSDEFDLogic2);
                }
                xmlNode2.resetAttributes();
                pSDEFDLogic2.fillXmlNode(xmlNode2, false);
                arrayList.add(xmlNode2);
                this.updatePSDEFDLogics(pSDEFormDetail, string, pSDEFDLogic2, xmlNode2, hashMap);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
        }
    }

    protected void createPSDEFDLogics(PSDEFormDetail pSDEFormDetail, String string, PSDEFDLogic pSDEFDLogic, XmlNode xmlNode) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService((String)PSDEFDLogicService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            int n = 0;
            while (iterator.hasNext()) {
                ++n;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEFDLogic pSDEFDLogic2 = new PSDEFDLogic();
                DataObject.fromXmlNode((IDataObject)pSDEFDLogic2, (XmlNode)xmlNode2);
                pSDEFDLogic2.resetPSDEFDLogicId();
                pSDEFDLogic2.resetPPSDEFDLogicId();
                pSDEFDLogic2.resetPPSDEFDLogicName();
                pSDEFDLogic2.setLogicCat(string);
                pSDEFDLogic2.setPSDEFormDetailId(pSDEFormDetail.getPSDEFormDetailId());
                pSDEFDLogic2.setPSDEFormDetailName(pSDEFormDetail.getPSDEFormDetailName());
                if (pSDEFDLogic != null) {
                    pSDEFDLogic2.setPPSDEFDLogicId(pSDEFDLogic.getPSDEFDLogicId());
                    pSDEFDLogic2.setPPSDEFDLogicName(pSDEFDLogic.getPSDEFDLogicName());
                }
                pSDEFDLogic2.setOrderValue(n);
                pSDEFDLogicService.create(pSDEFDLogic2);
                this.createPSDEFDLogics(pSDEFormDetail, string, pSDEFDLogic2, xmlNode2);
            }
        }
    }

    @Override
    public void createWithModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        this.updateWithModel(pSDEFormDetail);
    }

    @Override
    protected void getRelatedDataTempMajor_PSDEFDLogic(PSDEFormDetail pSDEFormDetail) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEFORM", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSDEFDLogic(pSDEFormDetail);
    }

    @Override
    protected void getRelatedDataTempMajor_PSDEFormDetail(PSDEFormDetail pSDEFormDetail) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEFORM", (boolean)true) == 0) {
            return;
        }
        super.getRelatedDataTempMajor_PSDEFormDetail(pSDEFormDetail);
    }

    @Override
    public void getWithModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        this.getTemp(pSDEFormDetail);
        if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getBlankLogic()) || StringHelper.isNullOrEmpty((String)pSDEFormDetail.getVisibleLogic()) || StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEnableLogic())) {
            this.fillFormDetailModel(pSDEFormDetail);
            this.updateTemp(pSDEFormDetail);
        }
    }

    public void getTemp(PSDEFormDetail pSDEFormDetail) throws Exception {
        super.getTemp(pSDEFormDetail);
        if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"RAWITEM", (boolean)false) == 0 && StringHelper.isNullOrEmpty((String)pSDEFormDetail.getContentType())) {
            pSDEFormDetail.setContentType("RAW");
        }
        if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"FORMPART", (boolean)false) == 0 && StringHelper.isNullOrEmpty((String)pSDEFormDetail.getContentType())) {
            pSDEFormDetail.setContentType("FORMRF");
        }
    }

    public void get(PSDEFormDetail pSDEFormDetail) throws Exception {
        super.get(pSDEFormDetail);
        if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"RAWITEM", (boolean)false) == 0 && StringHelper.isNullOrEmpty((String)pSDEFormDetail.getContentType())) {
            pSDEFormDetail.setContentType("RAW");
        }
    }

    protected void fillFormDetailModel(PSDEFormDetail pSDEFormDetail) throws Exception {
        XmlNode xmlNode;
        XmlNode xmlNode2;
        XmlNode xmlNode3;
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService((String)PSDEFDLogicService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEFDLogic> arrayList = pSDEFDLogicService.selectTempByPSDEFormDetail(pSDEFormDetail, "ORDER BY ORDERVALUE");
        HashMap<String, XmlNode> hashMap = new HashMap<String, XmlNode>();
        for (PSDEFDLogic object22 : arrayList) {
            XmlNode node = new XmlNode();
            node.setNodeName(object22.getLogicType());
            object22.fillXmlNode(node, false);
            hashMap.put(object22.getPSDEFDLogicId(), node);
        }
        HashMap hashMap2 = new HashMap();
        if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"FORMITEM", (boolean)true) == 0) {
            XmlNode xmlNode4 = new XmlNode();
            xmlNode4.setNodeName("DEFDLOGIC");
            xmlNode4.setAttribute("PSDEFORMDETAILID", pSDEFormDetail.getPSDEFormDetailId());
            xmlNode4.setAttribute("PSDEFORMID", pSDEFormDetail.getPSDEFormId());
            hashMap2.put("ITEMENABLE", xmlNode4);
        }
        if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"FORMITEM", (boolean)true) == 0) {
            XmlNode xmlNode5 = new XmlNode();
            xmlNode5.setNodeName("DEFDLOGIC");
            xmlNode5.setAttribute("PSDEFORMDETAILID", pSDEFormDetail.getPSDEFormDetailId());
            xmlNode5.setAttribute("PSDEFORMID", pSDEFormDetail.getPSDEFormId());
            hashMap2.put("ITEMBLANK", xmlNode5);
        }
        XmlNode xmlNode6 = new XmlNode();
        xmlNode6.setNodeName("DEFDLOGIC");
        xmlNode6.setAttribute("PSDEFORMDETAILID", pSDEFormDetail.getPSDEFormDetailId());
        xmlNode6.setAttribute("PSDEFORMID", pSDEFormDetail.getPSDEFormId());
        hashMap2.put("PANELVISIBLE", xmlNode6);
        for (Object object : arrayList) {
            XmlNode xmlNode7;
            XmlNode xmlNode8 = (XmlNode)hashMap.get(((PSDEFDLogicBase)object).getPSDEFDLogicId());
            if (StringHelper.isNullOrEmpty((String)((PSDEFDLogicBase)object).getPPSDEFDLogicId())) {
                xmlNode7 = (XmlNode)hashMap2.get(((PSDEFDLogicBase)object).getLogicCat());
                if (xmlNode7 == null) continue;
                xmlNode7.addNode(xmlNode8);
                continue;
            }
            xmlNode7 = (XmlNode)hashMap.get(((PSDEFDLogicBase)object).getPPSDEFDLogicId());
            if (xmlNode7 != null) {
                xmlNode7.addNode(xmlNode8);
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u6210\u5458\u7236\u903b\u8f91[%1$s], \u5f53\u524d[%2$s]", (Object)((PSDEFDLogicBase)object).getPPSDEFDLogicId(), (Object)((PSDEFDLogicBase)object).getPSDEFDLogicName()));
        }
        if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"FORMITEM", (boolean)true) == 0 && (xmlNode3 = (XmlNode)hashMap2.get("ITEMENABLE")) != null) {
            pSDEFormDetail.setEnableLogic(XmlNode.export((XmlNode)xmlNode3));
        }
        if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"FORMITEM", (boolean)true) == 0 && (xmlNode2 = (XmlNode)hashMap2.get("ITEMBLANK")) != null) {
            pSDEFormDetail.setBlankLogic(XmlNode.export((XmlNode)xmlNode2));
        }
        if ((xmlNode = (XmlNode)hashMap2.get("PANELVISIBLE")) != null) {
            pSDEFormDetail.setVisibleLogic(XmlNode.export((XmlNode)xmlNode));
        }
    }

    @Override
    protected void onBeforeGetDraftTemp(PSDEFormDetail pSDEFormDetail) throws Exception {
        super.onBeforeGetDraftTemp(pSDEFormDetail);
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName("DEFDLOGIC");
        xmlNode.setAttribute("PSDEFORMDETAILID", pSDEFormDetail.getPSDEFormDetailId());
        xmlNode.setAttribute("PSDEFORMID", pSDEFormDetail.getPSDEFormId());
        String string = XmlNode.export((XmlNode)xmlNode);
        pSDEFormDetail.setEnableLogic(string);
        pSDEFormDetail.setBlankLogic(string);
        pSDEFormDetail.setVisibleLogic(string);
        String string2 = pSDEFormDetail.getPSDEFormDetailName();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            this.fillPSDEFormDetailDefaultName(pSDEFormDetail);
        }
    }

    protected void fillPSDEFormDetailDefaultName(PSDEFormDetail pSDEFormDetail) throws Exception {
        String string;
        int n = 1;
        String string2 = string = pSDEFormDetail.getDetailType();
        if (StringHelper.compare((String)string, (String)"FORMITEM", (boolean)true) == 0) {
            n = 0;
            string2 = pSDEFormDetail.getPSDEFName();
            if (StringHelper.compare((String)pSDEFormDetail.getFormType(), (String)"SEARCHFORM", (boolean)true) == 0) {
                string2 = pSDEFormDetail.getPSDEFSFItemName();
            }
            if (StringHelper.isNullOrEmpty((String)string2)) {
                string2 = pSDEFormDetail.getDetailType();
            }
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSDEForm pSDEForm = new PSDEForm();
        pSDEForm.setPSDEFormId(pSDEFormDetail.getPSDEFormId());
        ArrayList<PSDEFormDetail> arrayList = null;
        arrayList = pSDEForm.getPSDEFormId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSDEForm(pSDEForm) : this.selectByPSDEForm(pSDEForm);
        HashMap<String, PSDEFormDetail> hashMap = new HashMap<String, PSDEFormDetail>();
        for (PSDEFormDetail pSDEFormDetail2 : arrayList) {
            if (StringHelper.isNullOrEmpty((String)pSDEFormDetail2.getPSDEFormDetailName())) continue;
            hashMap.put(pSDEFormDetail2.getPSDEFormDetailName().toLowerCase(), pSDEFormDetail2);
        }
        String name;
        while (hashMap.containsKey(name = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) {
            ++n;
        }
        pSDEFormDetail.setPSDEFormDetailName(name);
        if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption())) {
            if (StringHelper.compare((String)string, (String)"FORMPAGE", (boolean)true) == 0) {
                pSDEFormDetail.setCaption("\u8868\u5355\u5206\u9875");
            }
            if (StringHelper.compare((String)string, (String)"GROUPPANEL", (boolean)true) == 0) {
                pSDEFormDetail.setCaption("\u5206\u7ec4\u9762\u677f");
            }
            if (StringHelper.compare((String)string, (String)"TABPAGE", (boolean)true) == 0) {
                pSDEFormDetail.setCaption("\u5206\u9875\u9762\u677f");
            }
        }
    }

    @Override
    protected void onBeforeCreate(PSDEFormDetail pSDEFormDetail) throws Exception {
        pSDEFormDetail.setVisibleLogic(null);
        pSDEFormDetail.setBlankLogic(null);
        pSDEFormDetail.setEnableLogic(null);
        super.onBeforeCreate(pSDEFormDetail);
    }

    @Override
    protected void onBeforeUpdate(PSDEFormDetail pSDEFormDetail) throws Exception {
        pSDEFormDetail.setVisibleLogic(null);
        pSDEFormDetail.setBlankLogic(null);
        pSDEFormDetail.setEnableLogic(null);
        super.onBeforeUpdate(pSDEFormDetail);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEFormDetail pSDEFormDetail) throws Exception {
        pSDEFormDetail.setLogicName(this.calcPSDEFormDetailLogicName(pSDEFormDetail));
        if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPSDEFormDetailName())) {
            this.fillPSDEFormDetailDefaultName(pSDEFormDetail);
        }
        super.onBeforeCreateTemp(pSDEFormDetail);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEFormDetail pSDEFormDetail) throws Exception {
        pSDEFormDetail.setLogicName(this.calcPSDEFormDetailLogicName(pSDEFormDetail));
        super.onBeforeUpdateTemp(pSDEFormDetail);
    }

    protected String calcPSDEFormDetailLogicName(PSDEFormDetail pSDEFormDetail) throws Exception {
        String string = pSDEFormDetail.getDetailType();
        if (StringHelper.compare((String)string, (String)"FORMITEM", (boolean)true) == 0 && pSDEFormDetail.getPSDEF() != null) {
            if (StringHelper.compare((String)pSDEFormDetail.getFormType(), (String)"SEARCHFORM", (boolean)true) == 0) {
                PSDEFSFItem pSDEFSFItem = pSDEFormDetail.getPSDEFSFItem();
                if (pSDEFSFItem != null && !StringHelper.isNullOrEmpty((String)pSDEFSFItem.getPSDBValueOPName())) {
                    return StringHelper.format((String)"%1$s[%2$s]", (Object)pSDEFormDetail.getPSDEF().getLogicName(), (Object)pSDEFSFItem.getPSDBValueOPName());
                }
            } else {
                return pSDEFormDetail.getPSDEF().getLogicName();
            }
        }
        return pSDEFormDetail.getLogicName();
    }

    @Override
    protected ArrayList<PSDEFDLogic> updateRelatedDataTempMajor_removePSDEFDLogic(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEFORM", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSDEFDLogic(pSDEFormDetail, pSDEFormDetail2);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSDEFDLogic(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2, ArrayList<PSDEFDLogic> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEFORM", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSDEFDLogic(pSDEFormDetail, pSDEFormDetail2, arrayList);
    }

    @Override
    protected ArrayList<PSDEFormDetail> updateRelatedDataTempMajor_removePSDEFormDetail(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEFORM", (boolean)true) == 0) {
            return null;
        }
        return super.updateRelatedDataTempMajor_removePSDEFormDetail(pSDEFormDetail, pSDEFormDetail2);
    }

    @Override
    protected void updateRelatedDataTempMajor_updatePSDEFormDetail(PSDEFormDetail pSDEFormDetail, PSDEFormDetail pSDEFormDetail2, ArrayList<PSDEFormDetail> arrayList) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        if (cloneSession != null && StringHelper.compare((String)cloneSession.getOwner(), (String)"PSDEFORM", (boolean)true) == 0) {
            return;
        }
        super.updateRelatedDataTempMajor_updatePSDEFormDetail(pSDEFormDetail, pSDEFormDetail2, arrayList);
    }

    @Override
    public PSDEFormDetail importXmlModel(PSDEFormDetail pSDEFormDetail, XmlNode xmlNode) throws Exception {
        PSDEFormDetail pSDEFormDetail2 = super.importXmlModel(pSDEFormDetail, xmlNode);
        pSDEFormDetail2.setVisibleLogic(null);
        pSDEFormDetail2.setBlankLogic(null);
        pSDEFormDetail2.setEnableLogic(null);
        if (pSDEFormDetail2.getPSDEFormDetailId().indexOf("SRFTEMPKEY:") == 0) {
            this.sysUpdateTemp(pSDEFormDetail2, false);
        } else {
            this.sysUpdate(pSDEFormDetail2, false);
        }
        return pSDEFormDetail2;
    }

    @Override
    protected void onAjaxFillCreateDVT(PSDEFormDetail pSDEFormDetail) throws Exception {
        this.onAjaxFillDVT(pSDEFormDetail, true);
    }

    @Override
    protected void onAjaxFillUpdateDVT(PSDEFormDetail pSDEFormDetail) throws Exception {
        this.onAjaxFillDVT(pSDEFormDetail, false);
    }

    protected void onAjaxFillDVT(PSDEFormDetail pSDEFormDetail, boolean bl) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("srfkey");
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        PSVarSampleValueService pSVarSampleValueService = (PSVarSampleValueService)ServiceGlobal.getService(PSVarSampleValueService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSVarSampleValue pSVarSampleValue = new PSVarSampleValue();
        pSVarSampleValue.setPSVarSampleValueId(string2);
        if (pSVarSampleValueService.get(pSVarSampleValue, true)) {
            if (bl) {
                pSDEFormDetail.setCreateDVT(pSVarSampleValue.getVarType());
                pSDEFormDetail.setCreateDV(pSVarSampleValue.getValue());
            } else {
                pSDEFormDetail.setUpdateDVT(pSVarSampleValue.getVarType());
                pSDEFormDetail.setUpdateDV(pSVarSampleValue.getValue());
            }
        }
    }

    @Override
    protected void onImportCurXmlModel(PSDEFormDetail pSDEFormDetail, XmlNode xmlNode) throws Exception {
        PSDEForm pSDEForm;
        pSDEFormDetail.set("PSDEFFORMITEMID", pSDEFormDetail.get("PSDEFUIMODEID"));
        pSDEFormDetail.set("PSDEFFORMITEMNAME", pSDEFormDetail.get("PSDEFUIMODENAME"));
        if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPSDEFId())) {
            PSDEForm pSDEForm2 = pSDEFormDetail.getPSDEForm();
            if (pSDEForm2 != null && StringHelper.compare((String)pSDEFormDetail.getPSDEF().getPSDEId(), (String)pSDEForm2.getPSDEId(), (boolean)false) != 0) {
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEId(pSDEForm2.getPSDEId());
                pSDEField.setPSDEFieldName(pSDEFormDetail.getPSDEF().getPSDEFieldName());
                if (pSDEFieldService.select(pSDEField, true)) {
                    pSDEFormDetail.setPSDEFId(pSDEField.getPSDEFieldId());
                    pSDEFormDetail.setPSDEFName(pSDEField.getPSDEFieldName());
                } else {
                    pSDEFormDetail.setPSDEFId(null);
                    pSDEFormDetail.setPSDEFName(null);
                }
                pSDEFormDetail.setPSDEFUIModeId(null);
                pSDEFormDetail.setPSDEFUIModeName(null);
            }
        } else if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPSDEFName()) && (pSDEForm = pSDEFormDetail.getPSDEForm()) != null) {
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = new PSDEField();
            pSDEField.setPSDEId(pSDEForm.getPSDEId());
            pSDEField.setPSDEFieldName(pSDEFormDetail.getPSDEFName());
            if (pSDEFieldService.select(pSDEField, true)) {
                pSDEFormDetail.setPSDEFId(pSDEField.getPSDEFieldId());
                pSDEFormDetail.setPSDEFName(pSDEField.getPSDEFieldName());
            } else {
                pSDEFormDetail.setPSDEFId(null);
                pSDEFormDetail.setPSDEFName(null);
            }
            pSDEFormDetail.setPSDEFUIModeId(null);
            pSDEFormDetail.setPSDEFUIModeName(null);
        }
        super.onImportCurXmlModel(pSDEFormDetail, xmlNode);
    }

    @Override
    protected void onChangeDRItem(PSDEFormDetail pSDEFormDetail) throws Exception {
        String string = this.getWebContext().getPostValue("srfactionparam");
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        JSONObject jSONObject = JSONObject.fromString((String)string);
        String string2 = jSONObject.optString("psdedritemid");
        String string3 = jSONObject.optString("psdedritemname");
        pSDEFormDetail.setPSDEDRItemId("");
        pSDEFormDetail.setPSDEDRItemName("");
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            pSDEFormDetail.setPSDEDRItemId(string2);
            pSDEFormDetail.setPSDEDRItemName(string3);
            if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPSDEDRItemName())) {
                pSDEFormDetail.setSessionFactory(this.getSessionFactory());
                pSDEFormDetail.setPSDEDRItemName(pSDEFormDetail.getPSDEDRItem().getPSDEDRItemName());
            }
        }
    }

    @Override
    public void getTempWithPreview(PSDEFormDetail pSDEFormDetail) throws Exception {
        super.getTemp(pSDEFormDetail);
        this.fillPreviewHtml(pSDEFormDetail);
    }

    @Override
    public void updateTempWithPreview(PSDEFormDetail pSDEFormDetail) throws Exception {
        pSDEFormDetail.resetPreviewHtml();
        super.updateTemp(pSDEFormDetail, true);
        this.fillPreviewHtml(pSDEFormDetail);
    }

    @Override
    public void createTempWithPreview(PSDEFormDetail pSDEFormDetail) throws Exception {
        pSDEFormDetail.resetPreviewHtml();
        super.createTemp(pSDEFormDetail);
        this.fillPreviewHtml(pSDEFormDetail);
    }

    public void fillPreviewHtml(PSDEFormDetail pSDEFormDetail) throws Exception {
        this.fillPreviewHtml(pSDEFormDetail, true);
    }

    public void fillPreviewHtml(final PSDEFormDetail pSDEFormDetail, final boolean bl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPSDEFormId()) || StringHelper.isNullOrEmpty((String)pSDEFormDetail.getDetailType())) {
            return;
        }
        if (StringHelper.compare((String)pSDEFormDetail.getDetailType(), (String)"FORMITEM", (boolean)true) == 0) {
            this.doServiceWork(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDEForm pSDEForm = PSDEFormDetailService.this.getPSDEForm(pSDEFormDetail);
                    if (pSDEForm == null) {
                        return;
                    }
                    if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getPSDEFId())) {
                        return;
                    }
                    if (pSDEFormDetail.getLabelWidth() == null) {
                        pSDEFormDetail.setLabelWidth(pSDEForm.getLabelWidth());
                    }
                    if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption()) && !StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType())) {
                        return;
                    }
                    if (StringHelper.compare((String)pSDEForm.getFormType(), (String)"EDITFORM", (boolean)true) == 0) {
                        Object object;
                        PSDEFUIMode pSDEFUIMode;
                        Map<String, PSDEFUIMode> map = null;
                        map = bl ? PSDEFormDetailService.this.getPSDEFUIModeMap(pSDEFormDetail.getPSDEFId()) : PSDEFormDetailService.this.getPSDEFUIModeMap(pSDEForm);
                        if (map == null) {
                            return;
                        }
                        String string = pSDEFormDetail.getPSDEFUIModeId();
                        if (StringHelper.isNullOrEmpty((String)string)) {
                            string = !DataObject.getBoolValue((Integer)pSDEForm.getMobFlag(), (boolean)false) ? StringHelper.format((String)"%1$s#%2$s", (Object)pSDEFormDetail.getPSDEFId(), (Object)"DEFAULT") : StringHelper.format((String)"%1$s#%2$s", (Object)pSDEFormDetail.getPSDEFId(), (Object)"MOBILEDEFAULT");
                        }
                        if ((pSDEFUIMode = map.get(string)) != null) {
                            if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption())) {
                                pSDEFormDetail.setCaption(pSDEFUIMode.getCaption());
                            }
                            if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType())) {
                                pSDEFormDetail.setEditorType(pSDEFUIMode.getEditorType());
                            }
                            if (pSDEFormDetail.getCtrlHeight() == null) {
                                pSDEFormDetail.setCtrlHeight(pSDEFUIMode.getHeight());
                            }
                            if (pSDEFormDetail.getCtrlWidth() == null) {
                                pSDEFormDetail.setCtrlWidth(pSDEFUIMode.getWidth());
                            }
                            if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption()) && !StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType())) {
                                return;
                            }
                        }
                        PSDEField pSDEField = null;
                        if (bl) {
                            pSDEField = pSDEFormDetail.getPSDEF();
                        } else {
                            pSDEField = PSDEFormDetailService.this.getPSDEFieldMap(pSDEForm).get(pSDEFormDetail.getPSDEFId());
                        }
                        if (pSDEField == null) {
                            return;
                        }
                        if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption())) {
                            pSDEFormDetail.setCaption(pSDEField.getLogicName());
                            if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption()) && !StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType())) {
                                return;
                            }
                        }
                        if ((object = PSModelGlobal.getPSDEFType(pSDEField, null)) != null) {
                            if (DataObject.getBoolValue((Integer)pSDEForm.getMobFlag(), (boolean)false)) {
                                pSDEFormDetail.setEditorType(((PSDEFTypeBase)object).getMBEditorType());
                                if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType())) {
                                    if (StringHelper.compare((String)((PSDEFTypeBase)object).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) {
                                        pSDEFormDetail.setEditorType(((PSDEFTypeBase)object).getEditorType());
                                    }
                                } else {
                                    if (pSDEFormDetail.getCtrlHeight() == null) {
                                        pSDEFormDetail.setCtrlHeight(((PSDEFTypeBase)object).getMBEditorHeight());
                                    }
                                    if (pSDEFormDetail.getCtrlWidth() == null) {
                                        pSDEFormDetail.setCtrlWidth(((PSDEFTypeBase)object).getMBEditorWidth());
                                    }
                                }
                            } else {
                                pSDEFormDetail.setEditorType(((PSDEFTypeBase)object).getEditorType());
                                if (pSDEFormDetail.getCtrlHeight() == null) {
                                    pSDEFormDetail.setCtrlHeight(((PSDEFTypeBase)object).getEditorHeight());
                                }
                                if (pSDEFormDetail.getCtrlWidth() == null) {
                                    pSDEFormDetail.setCtrlWidth(((PSDEFTypeBase)object).getEditorWidth());
                                }
                            }
                        }
                    } else {
                        Object object;
                        Map<String, PSDEFSFItem> map = null;
                        map = bl ? PSDEFormDetailService.this.getPSDEFSFItemMap(pSDEFormDetail.getPSDEFId()) : PSDEFormDetailService.this.getPSDEFSFItemMap(pSDEForm);
                        if (map == null) {
                            return;
                        }
                        String string = pSDEFormDetail.getPSDEFSFItemId();
                        PSDEFSFItem pSDEFSFItem = map.get(string);
                        if (pSDEFSFItem != null) {
                            if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption())) {
                                pSDEFormDetail.setCaption(pSDEFSFItem.getCaption());
                            }
                            if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType())) {
                                pSDEFormDetail.setEditorType(pSDEFSFItem.getEditorType());
                            }
                            if (pSDEFormDetail.getCtrlHeight() == null) {
                                pSDEFormDetail.setCtrlHeight(pSDEFSFItem.getHeight());
                            }
                            if (pSDEFormDetail.getCtrlWidth() == null) {
                                pSDEFormDetail.setCtrlWidth(pSDEFSFItem.getWidth());
                            }
                            if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption()) && !StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType())) {
                                return;
                            }
                        }
                        PSDEField pSDEField = null;
                        if (bl) {
                            pSDEField = pSDEFormDetail.getPSDEF();
                        } else {
                            pSDEField = PSDEFormDetailService.this.getPSDEFieldMap(pSDEForm).get(pSDEFormDetail.getPSDEFId());
                        }
                        if (pSDEField == null) {
                            return;
                        }
                        if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption())) {
                            if (pSDEFSFItem != null && !StringHelper.isNullOrEmpty((String)pSDEFSFItem.getPSDBValueOPName())) {
                                pSDEFormDetail.setCaption(StringHelper.format((String)"%1$s[%2$s]", (Object)pSDEField.getLogicName(), (Object)pSDEFSFItem.getPSDBValueOPName()));
                            } else {
                                pSDEFormDetail.setCaption(pSDEField.getLogicName());
                            }
                            if (!StringHelper.isNullOrEmpty((String)pSDEFormDetail.getCaption()) && !StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType())) {
                                return;
                            }
                        }
                        if ((object = PSModelGlobal.getPSDEFType(pSDEField, null)) != null) {
                            if (DataObject.getBoolValue((Integer)pSDEForm.getMobFlag(), (boolean)false)) {
                                pSDEFormDetail.setEditorType(((PSDEFTypeBase)object).getSearchMBEditorType());
                                if (StringHelper.isNullOrEmpty((String)pSDEFormDetail.getEditorType())) {
                                    if (StringHelper.compare((String)((PSDEFTypeBase)object).getEditorType(), (String)"HIDDEN", (boolean)true) == 0) {
                                        pSDEFormDetail.setEditorType(((PSDEFTypeBase)object).getSearchEditorType());
                                    }
                                } else {
                                    if (pSDEFormDetail.getCtrlHeight() == null) {
                                        pSDEFormDetail.setCtrlHeight(((PSDEFTypeBase)object).getSearchMBEditorHeight());
                                    }
                                    if (pSDEFormDetail.getCtrlWidth() == null) {
                                        pSDEFormDetail.setCtrlWidth(((PSDEFTypeBase)object).getSearchMBEditorWidth());
                                    }
                                }
                            } else {
                                pSDEFormDetail.setEditorType(((PSDEFTypeBase)object).getSearchEditorType());
                                if (pSDEFormDetail.getCtrlHeight() == null) {
                                    pSDEFormDetail.setCtrlHeight(((PSDEFTypeBase)object).getSearchEditorHeight());
                                }
                                if (pSDEFormDetail.getCtrlWidth() == null) {
                                    pSDEFormDetail.setCtrlWidth(((PSDEFTypeBase)object).getSearchEditorWidth());
                                }
                            }
                        }
                    }
                }
            }, false);
        }
    }

    protected PSDEForm getPSDEForm(PSDEFormDetail pSDEFormDetail) throws Exception {
        PSDEForm pSDEForm = null;
        Object object = ActionSessionManager.getCurrentSession().getActionParam("PSDEFORM|" + pSDEFormDetail.getPSDEFormId());
        if (object == null) {
            pSDEForm = pSDEFormDetail.getPSDEForm();
            ActionSessionManager.getCurrentSession().setActionParam("PSDEFORM|" + pSDEFormDetail.getPSDEFormId(), (Object)pSDEForm);
            return pSDEForm;
        }
        if (object instanceof PSDEForm) {
            pSDEForm = (PSDEForm)object;
        }
        return pSDEForm;
    }

    protected Map<String, PSDEFUIMode> getPSDEFUIModeMap(PSDEForm pSDEForm) throws Exception {
        HashMap<String, PSDEFUIMode> hashMap = null;
        Object object = ActionSessionManager.getCurrentSession().getActionParam("PSDEFUIMODEMAP|" + pSDEForm.getPSDEId());
        if (object == null) {
            hashMap = new HashMap<String, PSDEFUIMode>();
            PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = new SelectContext();
            selectContext.set("PSDEID", (Object)pSDEForm.getPSDEId());
            ArrayList<PSDEFUIMode> arrayList = pSDEFUIModeService.select((ISelectCond)selectContext);
            for (PSDEFUIMode pSDEFUIMode : arrayList) {
                hashMap.put(pSDEFUIMode.getPSDEFUIModeId(), pSDEFUIMode);
                if (StringHelper.compare((String)pSDEFUIMode.getFTMode(), (String)"DEFAULT", (boolean)true) != 0 && StringHelper.compare((String)pSDEFUIMode.getFTMode(), (String)"MOBILEDEFAULT", (boolean)true) != 0) continue;
                hashMap.put(StringHelper.format((String)"%1$s#%2$s", (Object)pSDEFUIMode.getPSDEFId(), (Object)pSDEFUIMode.getFTMode()), pSDEFUIMode);
            }
            ActionSessionManager.getCurrentSession().setActionParam("PSDEFUIMODEMAP|" + pSDEForm.getPSDEId(), hashMap);
            return hashMap;
        }
        return (Map)object;
    }

    protected Map<String, PSDEFUIMode> getPSDEFUIModeMap(String string) throws Exception {
        HashMap<String, PSDEFUIMode> hashMap = null;
        Object object = ActionSessionManager.getCurrentSession().getActionParam("PSDEFUIMODEMAP|" + string);
        if (object == null) {
            hashMap = new HashMap<String, PSDEFUIMode>();
            PSDEFUIModeService pSDEFUIModeService = (PSDEFUIModeService)ServiceGlobal.getService(PSDEFUIModeService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = new SelectContext();
            selectContext.set("PSDEFID", (Object)string);
            ArrayList<PSDEFUIMode> arrayList = pSDEFUIModeService.select((ISelectCond)selectContext);
            for (PSDEFUIMode pSDEFUIMode : arrayList) {
                hashMap.put(pSDEFUIMode.getPSDEFUIModeId(), pSDEFUIMode);
                if (StringHelper.compare((String)pSDEFUIMode.getFTMode(), (String)"DEFAULT", (boolean)true) != 0 && StringHelper.compare((String)pSDEFUIMode.getFTMode(), (String)"MOBILEDEFAULT", (boolean)true) != 0) continue;
                hashMap.put(StringHelper.format((String)"%1$s#%2$s", (Object)pSDEFUIMode.getPSDEFId(), (Object)pSDEFUIMode.getFTMode()), pSDEFUIMode);
            }
            ActionSessionManager.getCurrentSession().setActionParam("PSDEFUIMODEMAP|" + string, hashMap);
            return hashMap;
        }
        return (Map)object;
    }

    protected Map<String, PSDEField> getPSDEFieldMap(PSDEForm pSDEForm) throws Exception {
        HashMap<String, PSDEField> hashMap = null;
        Object object = ActionSessionManager.getCurrentSession().getActionParam("PSDEFIELDMAP|" + pSDEForm.getPSDEId());
        if (object == null) {
            hashMap = new HashMap<String, PSDEField>();
            PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = new SelectContext();
            selectContext.set("PSDEID", (Object)pSDEForm.getPSDEId());
            ArrayList<PSDEField> arrayList = pSDEFieldService.select((ISelectCond)selectContext);
            for (PSDEField pSDEField : arrayList) {
                hashMap.put(pSDEField.getPSDEFieldId(), pSDEField);
            }
            ActionSessionManager.getCurrentSession().setActionParam("PSDEFIELDMAP|" + pSDEForm.getPSDEId(), hashMap);
            return hashMap;
        }
        return (Map)object;
    }

    protected Map<String, PSDEFSFItem> getPSDEFSFItemMap(PSDEForm pSDEForm) throws Exception {
        HashMap<String, PSDEFSFItem> hashMap = null;
        Object object = ActionSessionManager.getCurrentSession().getActionParam("PSDEFSFITEMMAP|" + pSDEForm.getPSDEId());
        if (object == null) {
            hashMap = new HashMap<String, PSDEFSFItem>();
            PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = new SelectContext();
            selectContext.set("PSDEID", (Object)pSDEForm.getPSDEId());
            ArrayList<PSDEFSFItem> arrayList = pSDEFSFItemService.select((ISelectCond)selectContext);
            for (PSDEFSFItem pSDEFSFItem : arrayList) {
                hashMap.put(pSDEFSFItem.getPSDEFSFItemId(), pSDEFSFItem);
            }
            ActionSessionManager.getCurrentSession().setActionParam("PSDEFSFITEMMAP|" + pSDEForm.getPSDEId(), hashMap);
            return hashMap;
        }
        return (Map)object;
    }

    protected Map<String, PSDEFSFItem> getPSDEFSFItemMap(String string) throws Exception {
        HashMap<String, PSDEFSFItem> hashMap = null;
        Object object = ActionSessionManager.getCurrentSession().getActionParam("PSDEFSFITEMMAP|" + string);
        if (object == null) {
            hashMap = new HashMap<String, PSDEFSFItem>();
            PSDEFSFItemService pSDEFSFItemService = (PSDEFSFItemService)ServiceGlobal.getService(PSDEFSFItemService.class, (SessionFactory)this.getSessionFactory());
            SelectContext selectContext = new SelectContext();
            selectContext.set("PSDEFID", (Object)string);
            ArrayList<PSDEFSFItem> arrayList = pSDEFSFItemService.select((ISelectCond)selectContext);
            for (PSDEFSFItem pSDEFSFItem : arrayList) {
                hashMap.put(pSDEFSFItem.getPSDEFSFItemId(), pSDEFSFItem);
            }
            ActionSessionManager.getCurrentSession().setActionParam("PSDEFSFITEMMAP|" + string, hashMap);
            return hashMap;
        }
        return (Map)object;
    }
}
