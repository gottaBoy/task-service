/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.layout.ThicknessImpl
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Map;
import java.util.TreeMap;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.entity.PSSysCss;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.layout.ThicknessImpl;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCssImpl
extends PSSystemObjectImpl
implements IPSSysCss {
    public static final int INT_BOLD = 1;
    public static final Integer ITALIC = 2;
    public static final int INT_ITALIC = 2;
    public static final Integer UNDERLINE = 4;
    public static final int INT_UNDERLINE = 4;
    protected PSSysCss psSysCss = null;
    private static final Log log = LogFactory.getLog(PSSysCssImpl.class);
    private String strRawCssStyle = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysCss psSysCss) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psSysCss = psSysCss;
            this.setId(this.psSysCss.getPSSYSCSSID());
            this.setName(this.psSysCss.getPSSYSCSSNAME());
            this.setPSObjectData(this.psSysCss);
            this.strRawCssStyle = this.calcRawCssStyle(this.psSysCss);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public String getPSCssTemplId() {
        return this.psSysCss.getPSCSSTEMPLID();
    }

    @PSModelRTMeta(description="\u6837\u5f0f\u8868\u540d\u79f0")
    public String getCssName() {
        return this.psSysCss.getCSSNAME();
    }

    public String getCssStyle() {
        return this.psSysCss.getCSSSTYLE();
    }

    public String getRawCssStyle() {
        return this.strRawCssStyle;
    }

    protected String calcRawCssStyle(PSSysCss psSysCss) throws Exception {
        ThicknessImpl thicknessImpl2;
        TreeMap<String, String> styleMap = new TreeMap<String, String>();
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getPADDING())) {
            try {
                thicknessImpl2 = new ThicknessImpl(psSysCss.getPADDING());
                styleMap.put("padding", thicknessImpl2.toString(" "));
            }
            catch (Exception ex) {
                // empty catch block
            }
        }
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getMARGIN())) {
            try {
                thicknessImpl2 = new ThicknessImpl(psSysCss.getMARGIN());
                styleMap.put("margin", thicknessImpl2.toString(" "));
            }
            catch (Exception thicknessImpl3) {
                // empty catch block
            }
        }
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getBORDER())) {
            try {
                thicknessImpl2 = new ThicknessImpl(psSysCss.getBORDER());
                styleMap.put("border-width", thicknessImpl2.toString(" "));
            }
            catch (Exception thicknessImpl4) {
                // empty catch block
            }
        }
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getBORDERCOLOR())) {
            styleMap.put("border-color", psSysCss.getBORDERCOLOR());
        }
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getBORDERSTYLE())) {
            styleMap.put("border-style", psSysCss.getBORDERSTYLE().toLowerCase());
        }
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getBKCOLOR())) {
            styleMap.put("background-color", psSysCss.getBKCOLOR());
        }
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getFONTFAMILY())) {
            JSONArray ja = JSONArray.fromString((String)psSysCss.getFONTFAMILY());
            String strFonts = "";
            int i = 0;
            while (i < ja.length()) {
                String strFontName;
                JSONObject jo = ja.optJSONObject(i);
                if (jo != null && !StringHelper.isNullOrEmpty((String)(strFontName = jo.optString("srfmajortext")))) {
                    if (!StringHelper.isNullOrEmpty((String)strFonts)) {
                        strFonts = String.valueOf(strFonts) + ",";
                    }
                    strFonts = String.valueOf(strFonts) + StringHelper.format((String)"\"%1$s\"", (Object)strFontName);
                }
                ++i;
            }
            styleMap.put("font-family", strFonts);
        }
        if (DataObject.getIntegerValue((Object)psSysCss.getFONTSIZE(), (Integer)0) > 0) {
            styleMap.put("font-size", StringHelper.format((String)"%1$spx", (Object)psSysCss.getFONTSIZE()));
        }
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getFONTCOLOR())) {
            styleMap.put("color", psSysCss.getFONTCOLOR());
        }
        if (DataObject.getIntegerValue((Object)psSysCss.getFONTSTYLE(), (Integer)0) > 0) {
            int nFontStyle = psSysCss.getFONTSTYLE();
            if ((nFontStyle & 1) == 1) {
                styleMap.put("font-weight", "bold");
            }
            if ((nFontStyle & 2) == 2) {
                styleMap.put("font-style", "italic");
            }
            if ((nFontStyle & 4) == 4) {
                styleMap.put("text-decoration", "underline");
            }
        }
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getHALIGN())) {
            styleMap.put("text-align", psSysCss.getHALIGN().toLowerCase());
        }
        if (!StringHelper.isNullOrEmpty((String)psSysCss.getVALIGN())) {
            styleMap.put("vertical-align", psSysCss.getVALIGN().toLowerCase());
        }
        String strStyle = "";
        for (Map.Entry entry : styleMap.entrySet()) {
            if (!StringHelper.isNullOrEmpty((String)strStyle)) {
                strStyle = String.valueOf(strStyle) + ";";
            }
            strStyle = String.valueOf(strStyle) + StringHelper.format((String)"%1$s:%2$s", entry.getKey(), entry.getValue());
        }
        return strStyle;
    }
}
