/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysImage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Enumeration;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysImageImpl
extends PSSystemObjectImpl
implements IPSSysImage {
    private static final Log log = LogFactory.getLog(PSSysImageImpl.class);
    protected PSSysImage psSysImage = null;
    private String strImagePath = "";
    private String strImagePathX = "";
    private int nWidth = 0;
    private int nHeight = 0;
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysImage psSysImage) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysImage = psSysImage;
            this.setId(this.psSysImage.getPSSYSIMAGEID());
            this.setName(this.psSysImage.getPSSYSIMAGENAME());
            this.setPSObjectData(this.psSysImage);
            this.strImagePath = this.psSysImage.getIMAGEPATH();
            if (StringHelper.compare((String)this.strImagePath, (String)"#", (boolean)true) == 0) {
                this.strImagePath = "";
            }
            this.strImagePathX = this.psSysImage.getIMAGEPATHX();
            if (!StringHelper.isNullOrEmpty((String)this.strImagePathX) && StringHelper.isNullOrEmpty((String)this.strImagePath)) {
                this.strImagePath = this.strImagePathX.replace("@{0}x", "");
            }
            if (!this.psSysImage.isWIDTHNull()) {
                this.nWidth = this.psSysImage.getWIDTH();
            }
            if (!this.psSysImage.isHEIGHTNull()) {
                this.nHeight = this.psSysImage.getHEIGHT();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysImage.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysImage.getPSMODULEID());
            }
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
    public String getPSImageTemplId() {
        return this.psSysImage.getPSIMAGETEMPLID();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u8def\u5f84")
    public String getImagePath() {
        return this.strImagePath;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u6837\u5f0f")
    public String getCssClass() {
        return this.psSysImage.getCSSCLASS();
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u4f53\u6807\u8bc6")
    public String getGlyph() {
        return this.psSysImage.getGLYPH();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u8def\u5f84\uff08X\uff09")
    public String getImagePathX() {
        return this.strImagePathX;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u6837\u5f0f\uff08X\uff09")
    public String getCssClassX() {
        return this.psSysImage.getCSSCLASSX();
    }

    @Override
    public String getModelType() {
        return "PSSYSIMAGE";
    }

    @Override
    public String getImagePath(int nX) {
        if (nX == 1 || StringHelper.isNullOrEmpty((String)this.getImagePathX())) {
            return this.getImagePath();
        }
        return this.getImagePathX().replace("{0}", StringHelper.format((String)"%1$s", (Object)nX));
    }

    @Override
    public String getCssClass(int nX) {
        if (nX == 1 || StringHelper.isNullOrEmpty((String)this.getCssClass())) {
            return this.getCssClass();
        }
        return this.getCssClassX().replace("{0}", StringHelper.format((String)"%1$s", (Object)nX));
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u5bbd\u5ea6", ignoredumpvalues="0")
    public int getWidth() {
        return this.nWidth;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u5bbd\u5ea6", ignoredumpvalues="0")
    public int getHeight() {
        return this.nHeight;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysImage.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9")
    public String getRawContent() {
        return this.psSysImage.getRAWCONTENT();
    }

    @Override
    protected ObjectNode toModelRefNode(String strType) {
        try {
            Enumeration<Object> keys;
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            if (!StringHelper.isNullOrEmpty((String)this.getGlyph())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"glyph", (Object)this.getGlyph());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getCssClass())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"cssClass", (Object)this.getCssClass());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getCssClassX())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"cssClassX", (Object)this.getCssClassX());
            }
            if (StringHelper.isNullOrEmpty((String)this.getCssClass())) {
                if (!StringHelper.isNullOrEmpty((String)this.getImagePath())) {
                    JsonNodeHelper.put((ObjectNode)objectNode, (String)"imagePath", (Object)this.getImagePath());
                }
                if (!StringHelper.isNullOrEmpty((String)this.getImagePathX())) {
                    JsonNodeHelper.put((ObjectNode)objectNode, (String)"imagePathX", (Object)this.getImagePathX());
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.getRawContent())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"rawContent", (Object)this.getRawContent());
            }
            if (this.getHeight() > 0) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"height", (Object)this.getHeight());
            }
            if (this.getWidth() > 0) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"width", (Object)this.getWidth());
            }
            if (!objectNode.has("getUserParam") && (keys = this.getUserParamNames()) != null) {
                ObjectNode paramNode = JsonNodeHelper.createObjectNode();
                while (keys.hasMoreElements()) {
                    Object objKey = keys.nextElement();
                    Object objValue = this.getUserParam((String)objKey);
                    if (objValue == null) continue;
                    PSSysImageImpl.putJsonProperty(paramNode, (String)objKey, objValue);
                }
                if (paramNode.size() != 0) {
                    objectNode.put("getUserParam", (JsonNode)paramNode);
                }
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

