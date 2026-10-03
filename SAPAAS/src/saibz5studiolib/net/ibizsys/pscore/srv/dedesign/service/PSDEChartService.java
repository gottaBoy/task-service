/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.EntityBase
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
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxes;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEChartService
extends PSDEChartServiceBase {
    private static final Log log = LogFactory.getLog(PSDEChartService.class);
    public static final String XMLNODE_DECHARTCONFIG = "DECHARTCONFIG";
    public static final String XMLNODE_DECHARTAXES = "DECHARTAXES";
    public static final String XMLNODE_DECHARTPARAM = "DECHARTPARAM";

    @Override
    public void getDraftWithModel(PSDEChart pSDEChart) throws Exception {
        this.getDraftTempMajor(pSDEChart);
        pSDEChart.setChartModel(this.getChartModel(pSDEChart));
    }

    @Override
    public void getWithModel(PSDEChart pSDEChart) throws Exception {
        if (!KeyValueHelper.isTempKey((String)pSDEChart.getPSDEChartId())) {
            this.getTempMajor(pSDEChart);
        } else {
            this.getTemp(pSDEChart);
        }
        pSDEChart.setChartModel(this.getChartModel(pSDEChart));
    }

    protected String getChartModel(PSDEChart pSDEChart) throws Exception {
        XmlNode xmlNode = new XmlNode();
        xmlNode.setNodeName(XMLNODE_DECHARTCONFIG);
        pSDEChart.fillXmlNode(xmlNode, true);
        xmlNode.setAttribute("PSDEID", pSDEChart.getPSDEId());
        xmlNode.setAttribute("PSDECHARTID", pSDEChart.getPSDEChartId());
        PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService((String)PSDEChartAxesService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartAxes> arrayList = pSDEChartAxesService.selectTempByPSDEChart(pSDEChart, "ORDER BY ORDERVALUE");
        for (PSDEChartAxes serializable2 : arrayList) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName(XMLNODE_DECHARTAXES);
            serializable2.fillXmlNode(xmlNode2, true);
            xmlNode.addNode(xmlNode2);
        }
        PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService((String)PSDEChartParamService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEChartParam> arrayList2 = pSDEChartParamService.selectTempByPSDEChart(pSDEChart, "ORDER BY ORDERVALUE");
        for (PSDEChartParam pSDEChartParam : arrayList2) {
            XmlNode xmlNode3 = new XmlNode();
            xmlNode3.setNodeName(XMLNODE_DECHARTPARAM);
            pSDEChartParam.fillXmlNode(xmlNode3, true);
            xmlNode.addNode(xmlNode3);
        }
        return XmlNode.export((XmlNode)xmlNode);
    }

    @Override
    public void createWithModel(PSDEChart pSDEChart) throws Exception {
        final PSDEChart pSDEChart2 = pSDEChart;
        pSDEChart2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[createWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService((String)PSDEChartAxesService.class.getCanonicalName(), (SessionFactory)PSDEChartService.this.getSessionFactory());
                ArrayList<PSDEChartAxes> arrayList = pSDEChartAxesService.selectTempByPSDEChart(pSDEChart2);
                HashMap<String, PSDEChartAxes> hashMap = new HashMap<String, PSDEChartAxes>();
                for (PSDEChartAxes serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSDEChartAxesId(), serializable2);
                }
                PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService((String)PSDEChartParamService.class.getCanonicalName(), (SessionFactory)PSDEChartService.this.getSessionFactory());
                ArrayList<PSDEChartParam> arrayList2 = pSDEChartParamService.selectTempByPSDEChart(pSDEChart2);
                HashMap<String, PSDEChartParam> hashMap2 = new HashMap<String, PSDEChartParam>();
                for (PSDEChartParam pSDEChartParam2 : arrayList2) {
                    hashMap2.put(pSDEChartParam2.getPSDEChartParamId(), pSDEChartParam2);
                }
                String string = pSDEChart2.getChartModel();
                XmlNode chartModel = XmlNode.loadFromXML(string);
                if (chartModel != null) {
                    chartModel.setAttribute("PSDEID", pSDEChart2.getPSDEId());
                    chartModel.setAttribute("PSDECHARTID", pSDEChart2.getPSDEChartId());
                    PSDEChartService.this.updatePSDEChartModel(pSDEChart2, chartModel, hashMap, hashMap2);
                    pSDEChart2.setChartModel(XmlNode.export(chartModel));
                } else {
                    pSDEChart2.setChartModel(null);
                }
                if (hashMap2.size() > 0) {
                    for (PSDEChartParam chartParam : hashMap2.values()) {
                        pSDEChartParamService.removeTemp(chartParam);
                    }
                }
                if (hashMap.size() > 0) {
                    for (PSDEChartAxes chartAxes : hashMap.values()) {
                        pSDEChartAxesService.removeTemp(chartAxes);
                    }
                }
                PSDEChartService.this.createTempMajor(pSDEChart2);
            }
        });
    }

    @Override
    public void updateWithModel(PSDEChart pSDEChart) throws Exception {
        final PSDEChart pSDEChart2 = pSDEChart;
        pSDEChart2.setSessionFactory(this.getSessionFactory());
        log.debug((Object)"\u5f00\u59cb[updateWithModel]\u4f5c\u4e1a");
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService((String)PSDEChartAxesService.class.getCanonicalName(), (SessionFactory)PSDEChartService.this.getSessionFactory());
                ArrayList<PSDEChartAxes> arrayList = pSDEChartAxesService.selectTempByPSDEChart(pSDEChart2);
                HashMap<String, PSDEChartAxes> hashMap = new HashMap<String, PSDEChartAxes>();
                for (PSDEChartAxes serializable2 : arrayList) {
                    hashMap.put(serializable2.getPSDEChartAxesId(), serializable2);
                }
                PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService((String)PSDEChartParamService.class.getCanonicalName(), (SessionFactory)PSDEChartService.this.getSessionFactory());
                ArrayList<PSDEChartParam> arrayList2 = pSDEChartParamService.selectTempByPSDEChart(pSDEChart2);
                HashMap<String, PSDEChartParam> hashMap2 = new HashMap<String, PSDEChartParam>();
                for (PSDEChartParam pSDEChartParam : arrayList2) {
                    hashMap2.put(pSDEChartParam.getPSDEChartParamId(), pSDEChartParam);
                }
                XmlNode chartModel = XmlNode.loadFromXML(pSDEChart2.getChartModel());
                if (chartModel != null) {
                    chartModel.setAttribute("PSDEID", pSDEChart2.getPSDEId());
                    chartModel.setAttribute("PSDECHARTID", pSDEChart2.getPSDEChartId());
                    PSDEChartService.this.updatePSDEChartModel(pSDEChart2, chartModel, hashMap, hashMap2);
                    pSDEChart2.setChartModel(XmlNode.export(chartModel));
                } else {
                    pSDEChart2.setChartModel(null);
                }
                boolean bl = false;
                if (hashMap2.size() > 0) {
                    for (PSDEChartParam chartParam : hashMap2.values()) {
                        pSDEChartParamService.removeTemp(chartParam);
                        bl = true;
                    }
                }
                if (hashMap.size() > 0) {
                    for (PSDEChartAxes chartAxes : hashMap.values()) {
                        pSDEChartAxesService.removeTemp(chartAxes);
                        bl = true;
                    }
                }
                PSDEChartService.this.updateTempMajor(pSDEChart2);
            }
        });
    }

    protected void updatePSDEChartModel(PSDEChart pSDEChart, XmlNode xmlNode, HashMap<String, PSDEChartAxes> hashMap, HashMap<String, PSDEChartParam> hashMap2) throws Exception {
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            ArrayList<XmlNode> arrayList = new ArrayList<XmlNode>();
            ArrayList<XmlNode> arrayList2 = new ArrayList<XmlNode>();
            PSDEChartAxesService pSDEChartAxesService = (PSDEChartAxesService)ServiceGlobal.getService((String)PSDEChartAxesService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            PSDEChartParamService pSDEChartParamService = (PSDEChartParamService)ServiceGlobal.getService((String)PSDEChartParamService.class.getCanonicalName(), (SessionFactory)this.getSessionFactory());
            HashMap<String, Integer> hashMap3 = new HashMap<String, Integer>();
            while (iterator.hasNext()) {
                String string;
                Integer n;
                boolean bl;
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DECHARTAXES, (boolean)true) == 0) {
                    String string2 = xmlNode2.getAttribute("PSDECHARTAXESID", "");
                    if (StringHelper.isNullOrEmpty((String)string2)) continue;
                    PSDEChartAxes chartAxes = hashMap.remove(string2);
                    if (chartAxes == null) continue;
                    bl = false;
                    if (StringHelper.compare((String)chartAxes.getPSDEChartId(), (String)pSDEChart.getPSDEChartId(), (boolean)false) != 0) {
                        chartAxes.setPSDEChartId(pSDEChart.getPSDEChartId());
                        bl = true;
                    }
                    if (StringHelper.compare((String)chartAxes.getPSDEChartName(), (String)pSDEChart.getPSDEChartName(), (boolean)false) != 0) {
                        chartAxes.setPSDEChartName(pSDEChart.getPSDEChartName());
                        bl = true;
                    }
                    if ((n = (Integer)hashMap3.get("PSDECHARTAXES")) == null) {
                        n = 0;
                    }
                    n = n + 10;
                    hashMap3.put("PSDECHARTAXES", n);
                    if (chartAxes.getOrderValue() == null || !chartAxes.getOrderValue().equals(n)) {
                        chartAxes.setOrderValue(n);
                        bl = true;
                    }
                    if (bl) {
                        pSDEChartAxesService.updateTemp(chartAxes);
                    }
                    xmlNode2.resetAttributes();
                    chartAxes.fillXmlNode(xmlNode2, false);
                    arrayList.add(xmlNode2);
                    continue;
                }
                if (StringHelper.compare((String)xmlNode2.getNodeName(), (String)XMLNODE_DECHARTPARAM, (boolean)true) != 0 || StringHelper.isNullOrEmpty((String)(string = xmlNode2.getAttribute("PSDECHARTPARAMID", "")))) continue;
                PSDEChartParam chartParam = hashMap2.remove(string);
                if (chartParam == null) continue;
                bl = false;
                if (StringHelper.compare((String)chartParam.getPSDEChartId(), (String)pSDEChart.getPSDEChartId(), (boolean)false) != 0) {
                    chartParam.setPSDEChartId(pSDEChart.getPSDEChartId());
                    bl = true;
                }
                if (StringHelper.compare((String)chartParam.getPSDEChartName(), (String)pSDEChart.getPSDEChartName(), (boolean)false) != 0) {
                    chartParam.setPSDEChartName(pSDEChart.getPSDEChartName());
                    bl = true;
                }
                if ((n = (Integer)hashMap3.get("PSDECHARTPARAM")) == null) {
                    n = 0;
                }
                n = n + 10;
                hashMap3.put("PSDECHARTPARAM", n);
                if (chartParam.getOrderValue() == null || !chartParam.getOrderValue().equals(n)) {
                    chartParam.setOrderValue(n);
                    bl = true;
                }
                if (bl) {
                    pSDEChartParamService.updateTemp(chartParam);
                }
                xmlNode2.resetAttributes();
                chartParam.fillXmlNode(xmlNode2, false);
                arrayList2.add(xmlNode2);
            }
            xmlNode.resetChildNodes();
            for (XmlNode xmlNode2 : arrayList) {
                xmlNode.addNode(xmlNode2);
            }
            for (XmlNode xmlNode3 : arrayList2) {
                xmlNode.addNode(xmlNode3);
            }
        }
    }

    @Override
    public void getDraftFromWithModel(PSDEChart pSDEChart) throws Exception {
        super.getDraftTempMajorFrom(pSDEChart);
        pSDEChart.setChartModel(this.getChartModel(pSDEChart));
    }
}
