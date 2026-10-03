/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.layout.ThicknessImpl
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysCss;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Map;
import java.util.TreeMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.layout.ThicknessImpl;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCssImpl
extends PSSystemObjectImpl
implements IPSSysCss {
    private static final Log log = LogFactory.getLog(PSSysCssImpl.class);
    protected PSSysCss psSysCss = null;
    private String strRawCssStyle = null;
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysCss psSysCss) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysCss = psSysCss;
            this.setId(this.psSysCss.getPSSYSCSSID());
            this.setName(this.psSysCss.getPSSYSCSSNAME());
            this.setPSObjectData(this.psSysCss);
            if (!StringHelper.isNullOrEmpty((String)this.psSysCss.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysCss.getPSMODULEID());
            }
            this.strRawCssStyle = this.calcRawCssStyle(this.psSysCss);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSCssTemplId() {
        return this.psSysCss.getPSCSSTEMPLID();
    }

    @Override
    @PSModelRTMeta(description="\u6837\u5f0f\u540d\u79f0")
    public String getCssName() {
        return this.psSysCss.getCSSNAME();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u6837\u5f0f\u5185\u5bb9")
    public String getCssStyle() {
        return this.psSysCss.getCSSSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u914d\u7f6e\u6837\u5f0f\u5185\u5bb9")
    public String getDesignCssStyle() {
        return this.getRawCssStyle();
    }

    @Override
    public String getModelType() {
        return "PSSYSCSS";
    }

    @Override
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
            catch (Exception ignored) {
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

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysCss.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    protected ObjectNode toModelRefNode(String strType) {
        try {
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            if (!StringHelper.isNullOrEmpty((String)this.getCssName())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"cssName", (Object)this.getCssName());
            }
            return objectNode;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5bfc\u51fa\u6a21\u578b\u53d1\u751f\u5f02\u5e38\u5f15\u7528\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            objectNode.put("error", 1);
            objectNode.put("msg", ex.getMessage());
            return objectNode;
        }
    }
}

