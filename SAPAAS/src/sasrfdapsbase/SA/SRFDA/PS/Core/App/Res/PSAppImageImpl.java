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
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.Res.IPSAppImage;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
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

@PSModelRTIgnoreMeta
public class PSAppImageImpl
extends PSApplicationObjectImpl
implements IPSAppImage {
    private static final Log log = LogFactory.getLog(PSAppImageImpl.class);
    private IPSSysImage iPSSysImage = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSysImage iPSSysImage) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSysImage = iPSSysImage;
            this.setId(iPSSysImage.getId());
            this.setName(iPSSysImage.getName());
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
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysImage psSysImage) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247", dump=false)
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public String getModelType() {
        return "PSAPPIMAGE";
    }

    @Override
    public String getPSImageTemplId() {
        return this.getPSSysImage().getPSImageTemplId();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u8def\u5f84", fields={"IMAGEPATH"})
    public String getImagePath() {
        return this.getPSSysImage().getImagePath();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u6837\u5f0f", fields={"CSSCLASS"})
    public String getCssClass() {
        return this.getPSSysImage().getCssClass();
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u4f53\u6807\u8bc6", fields={"GLYPH"})
    public String getGlyph() {
        return this.getPSSysImage().getGlyph();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u8def\u5f84\uff08X\uff09", fields={"IMAGEPATHX"})
    public String getImagePathX() {
        return this.getPSSysImage().getImagePathX();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u6837\u5f0f\uff08X\uff09", fields={"CSSCLASSX"})
    public String getCssClassX() {
        return this.getPSSysImage().getCssClassX();
    }

    @Override
    public String getImagePath(int nX) {
        return this.getPSSysImage().getImagePath(nX);
    }

    @Override
    public String getCssClass(int nX) {
        return this.getPSSysImage().getCssClass(nX);
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u5bbd\u5ea6", ignoredumpvalues="0", outputdoc="(%1$s.getWidth() gt 0)", fields={"WIDTH"})
    public int getWidth() {
        return this.getPSSysImage().getWidth();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u5bbd\u5ea6", ignoredumpvalues="0", outputdoc="(%1$s.getHeight() gt 0)", fields={"HEIGHT"})
    public int getHeight() {
        return this.getPSSysImage().getHeight();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.getPSSysImage().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.getPSSysImage().getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9", fields={"RAWCONTENT"})
    public String getRawContent() {
        return this.getPSSysImage().getRawContent();
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
                    PSAppImageImpl.putJsonProperty(paramNode, (String)objKey, objValue);
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

