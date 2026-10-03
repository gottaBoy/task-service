/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.layout.ThicknessImpl
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.Map;
import java.util.TreeMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.layout.ThicknessImpl;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysCssService
extends PSSysCssServiceBase {
    private static final Log log = LogFactory.getLog(PSSysCssService.class);

    @Override
    protected void onBeforeCreate(PSSysCss pSSysCss) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysCss.getPSSystemId())) {
            pSSysCss.setPSSystemId(this.getCurrentPSSystemId(pSSysCss, false));
        }
        this.onCalcSampleContent(pSSysCss);
        super.onBeforeCreate(pSSysCss);
    }

    @Override
    protected void onBeforeUpdate(PSSysCss pSSysCss) throws Exception {
        this.onCalcSampleContent(pSSysCss);
        super.onBeforeUpdate(pSSysCss);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onCalcSampleContent(PSSysCss pSSysCss) throws Exception {
        ThicknessImpl thicknessImpl;
        PSSysCss pSSysCss2 = pSSysCss;
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getPadding())) {
            try {
                thicknessImpl = new ThicknessImpl(pSSysCss2.getPadding());
                treeMap.put("padding", thicknessImpl.toString(" "));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getMargin())) {
            try {
                thicknessImpl = new ThicknessImpl(pSSysCss2.getMargin());
                treeMap.put("margin", thicknessImpl.toString(" "));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getBorder())) {
            try {
                thicknessImpl = new ThicknessImpl(pSSysCss2.getBorder());
                treeMap.put("border-width", thicknessImpl.toString(" "));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getBorderColor())) {
            treeMap.put("border-color", pSSysCss2.getBorderColor());
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getBorderStyle())) {
            treeMap.put("border-style", pSSysCss2.getBorderStyle().toLowerCase());
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getBKColor())) {
            treeMap.put("background-color", pSSysCss2.getBKColor());
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getFontFamily())) {
            int entry = 0;
            JSONArray fontFamilyArray = JSONArray.fromString((String)pSSysCss2.getFontFamily());
            String fontFamily = "";
            while (entry < fontFamilyArray.length()) {
                JSONObject fontObject = fontFamilyArray.optJSONObject(entry);
                if (fontObject != null) {
                    String fontName = fontObject.optString("srfmajortext");
                    if (!StringHelper.isNullOrEmpty(fontName)) {
                        if (!StringHelper.isNullOrEmpty(fontFamily)) {
                            fontFamily += ",";
                        }
                        fontFamily += StringHelper.format("\"%1$s\"", fontName);
                    }
                }
                ++entry;
            }
            treeMap.put("font-family", fontFamily);
        }
        if (DataObject.getIntegerValue((Object)pSSysCss2.getFontSize(), (Integer)0) > 0) {
            treeMap.put("font-size", StringHelper.format((String)"%1$spx", (Object)pSSysCss2.getFontSize()));
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getFontColor())) {
            treeMap.put("color", pSSysCss2.getFontColor());
        }
        if (DataObject.getIntegerValue((Object)pSSysCss2.getFontStyle(), (Integer)0) > 0) {
            int n = pSSysCss2.getFontStyle();
            if ((n & 1) == 1) {
                treeMap.put("font-weight", "bold");
            }
            if ((n & 2) == 2) {
                treeMap.put("font-style", "italic");
            }
            if ((n & 4) == 4) {
                treeMap.put("text-decoration", "underline");
            }
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getHAlign())) {
            treeMap.put("text-align", pSSysCss2.getHAlign().toLowerCase());
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss2.getVAlign())) {
            treeMap.put("vertical-align", pSSysCss2.getVAlign().toLowerCase());
        }
        String string = "";
        for (Map.Entry entry : treeMap.entrySet()) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string = string + ";";
            }
            string = string + StringHelper.format((String)"%1$s:%2$s", entry.getKey(), entry.getValue());
        }
        pSSysCss.setSampleContent(StringHelper.format((String)"<div style='%1$s'>\u793a\u4f8b\u5185\u5bb9 SampleData</div>", (Object)string));
    }

    @Override
    protected void onGetFDL(PSSysCss pSSysCss) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
        String string = pSSysCss.getPSSysCssId();
        pSDEFormDetail.setPSDEFormDetailId(string);
        pSDEFormDetailService.autoGet(pSDEFormDetail, false);
        String string2 = pSDEFormDetail.getLabelPSSysCssId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = pSDEFormDetail.getLabelCssId();
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            this.getDraft(pSSysCss);
        } else {
            pSSysCss.setPSSysCssId(string2);
            this.get(pSSysCss);
        }
        pSSysCss.setPSSysCssId(string);
    }

    @Override
    protected void onGetFD(PSSysCss pSSysCss) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
        String string = pSSysCss.getPSSysCssId();
        pSDEFormDetail.setPSDEFormDetailId(string);
        pSDEFormDetailService.autoGet(pSDEFormDetail, false);
        String string2 = pSDEFormDetail.getPSSysCssId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = pSDEFormDetail.getCssId();
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            this.getDraft(pSSysCss);
        } else {
            pSSysCss.setPSSysCssId(string2);
            this.get(pSSysCss);
        }
        pSSysCss.setPSSysCssId(string);
    }

    @Override
    protected void onGetPIL(PSSysCss pSSysCss) throws Exception {
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
        String string = pSSysCss.getPSSysCssId();
        pSSysViewPanelItem.setPSSysViewPanelItemId(string);
        pSSysViewPanelItemService.autoGet(pSSysViewPanelItem, false);
        String string2 = pSSysViewPanelItem.getLabelPSSysCssId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = pSSysViewPanelItem.getLableCssId();
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            this.getDraft(pSSysCss);
        } else {
            pSSysCss.setPSSysCssId(string2);
            this.get(pSSysCss);
        }
        pSSysCss.setPSSysCssId(string);
    }

    @Override
    protected void onGetPI(PSSysCss pSSysCss) throws Exception {
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
        String string = pSSysCss.getPSSysCssId();
        pSSysViewPanelItem.setPSSysViewPanelItemId(string);
        pSSysViewPanelItemService.autoGet(pSSysViewPanelItem, false);
        String string2 = pSSysViewPanelItem.getPSSysCssId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = pSSysViewPanelItem.getCssId();
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            this.getDraft(pSSysCss);
        } else {
            pSSysCss.setPSSysCssId(string2);
            this.get(pSSysCss);
        }
        pSSysCss.setPSSysCssId(string);
    }

    @Override
    protected void onUpdateFDL(PSSysCss pSSysCss) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
        String string = pSSysCss.getPSSysCssId();
        pSDEFormDetail.setPSDEFormDetailId(string);
        pSDEFormDetailService.autoGet(pSDEFormDetail, false);
        String string2 = pSDEFormDetail.getLabelPSSysCssId();
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u4e0d\u80fd\u66f4\u65b0\u516c\u5171\u6837\u5f0f"));
        }
        string2 = pSDEFormDetail.getLabelCssId();
        pSSysCss.setPSSysCssId(string2);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            pSSysCss.setPublicFlag(0);
            pSSysCss.setOwnerType("PSDEFORMDETAIL");
            pSSysCss.setOwnerTag("LABELCSSID");
            this.create(pSSysCss);
        } else {
            this.update(pSSysCss);
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            pSDEFormDetail.reset();
            pSDEFormDetail.setPSDEFormDetailId(string);
            pSDEFormDetail.setLabelCssId(pSSysCss.getPSSysCssId());
            if (KeyValueHelper.isTempKey((String)string)) {
                pSDEFormDetailService.sysUpdateTemp(pSDEFormDetail, false);
            } else {
                pSDEFormDetailService.sysUpdate(pSDEFormDetail, false);
            }
        }
        pSSysCss.setPSSysCssId(string);
    }

    @Override
    protected void onUpdateFD(PSSysCss pSSysCss) throws Exception {
        PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
        String string = pSSysCss.getPSSysCssId();
        pSDEFormDetail.setPSDEFormDetailId(string);
        pSDEFormDetailService.autoGet(pSDEFormDetail, false);
        String string2 = pSDEFormDetail.getPSSysCssId();
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u4e0d\u80fd\u66f4\u65b0\u516c\u5171\u6837\u5f0f"));
        }
        string2 = pSDEFormDetail.getCssId();
        pSSysCss.setPSSysCssId(string2);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            pSSysCss.setPublicFlag(0);
            pSSysCss.setOwnerType("PSDEFORMDETAIL");
            pSSysCss.setOwnerTag("CSSID");
            this.create(pSSysCss);
        } else {
            this.update(pSSysCss);
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            pSDEFormDetail.reset();
            pSDEFormDetail.setPSDEFormDetailId(string);
            pSDEFormDetail.setCssId(pSSysCss.getPSSysCssId());
            if (KeyValueHelper.isTempKey((String)string)) {
                pSDEFormDetailService.sysUpdateTemp(pSDEFormDetail, false);
            } else {
                pSDEFormDetailService.sysUpdate(pSDEFormDetail, false);
            }
        }
        pSSysCss.setPSSysCssId(string);
    }

    @Override
    protected void onUpdatePI(PSSysCss pSSysCss) throws Exception {
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
        String string = pSSysCss.getPSSysCssId();
        pSSysViewPanelItem.setPSSysViewPanelItemId(string);
        pSSysViewPanelItemService.autoGet(pSSysViewPanelItem, false);
        String string2 = pSSysViewPanelItem.getPSSysCssId();
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u4e0d\u80fd\u66f4\u65b0\u516c\u5171\u6837\u5f0f"));
        }
        string2 = pSSysViewPanelItem.getCssId();
        pSSysCss.setPSSysCssId(string2);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            pSSysCss.setPublicFlag(0);
            pSSysCss.setOwnerType("PSSYSVIEWPANELITEM");
            pSSysCss.setOwnerTag("CSSID");
            this.create(pSSysCss);
        } else {
            this.update(pSSysCss);
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            pSSysViewPanelItem.reset();
            pSSysViewPanelItem.setPSSysViewPanelItemId(string);
            pSSysViewPanelItem.setCssId(pSSysCss.getPSSysCssId());
            if (KeyValueHelper.isTempKey((String)string)) {
                pSSysViewPanelItemService.sysUpdateTemp(pSSysViewPanelItem, false);
            } else {
                pSSysViewPanelItemService.sysUpdate(pSSysViewPanelItem, false);
            }
        }
        pSSysCss.setPSSysCssId(string);
    }

    @Override
    protected void onUpdatePIL(PSSysCss pSSysCss) throws Exception {
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
        String string = pSSysCss.getPSSysCssId();
        pSSysViewPanelItem.setPSSysViewPanelItemId(string);
        pSSysViewPanelItemService.autoGet(pSSysViewPanelItem, false);
        String string2 = pSSysViewPanelItem.getLabelPSSysCssId();
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception(StringHelper.format((String)"\u4e0d\u80fd\u66f4\u65b0\u516c\u5171\u6837\u5f0f"));
        }
        string2 = pSSysViewPanelItem.getLableCssId();
        pSSysCss.setPSSysCssId(string2);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            pSSysCss.setPublicFlag(0);
            pSSysCss.setOwnerType("PSSYSVIEWPANELITEM");
            pSSysCss.setOwnerTag("LABLECSSID");
            this.create(pSSysCss);
        } else {
            this.update(pSSysCss);
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            pSSysViewPanelItem.reset();
            pSSysViewPanelItem.setPSSysViewPanelItemId(string);
            pSSysViewPanelItem.setLableCssId(pSSysCss.getPSSysCssId());
            if (KeyValueHelper.isTempKey((String)string)) {
                pSSysViewPanelItemService.sysUpdateTemp(pSSysViewPanelItem, false);
            } else {
                pSSysViewPanelItemService.sysUpdate(pSSysViewPanelItem, false);
            }
        }
        pSSysCss.setPSSysCssId(string);
    }
}
