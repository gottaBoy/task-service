/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.entity.PSSysImage;
import net.ibizsys.model.res.IPSSysImage;
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

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysImage psSysImage) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
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

    public String getPSImageTemplId() {
        return this.psSysImage.getPSIMAGETEMPLID();
    }

    @PSModelRTMeta(description="\u56fe\u7247\u8def\u5f84")
    public String getImagePath() {
        return this.strImagePath;
    }

    @PSModelRTMeta(description="\u56fe\u7247\u6837\u5f0f")
    public String getCssClass() {
        return this.psSysImage.getCSSCLASS();
    }

    @PSModelRTMeta(description="\u5b57\u4f53\u6807\u8bc6")
    public String getGlyph() {
        return this.psSysImage.getGLYPH();
    }

    @PSModelRTMeta(description="\u56fe\u7247\u8def\u5f84\uff08X\uff09")
    public String getImagePathX() {
        return this.strImagePathX;
    }

    @PSModelRTMeta(description="\u56fe\u7247\u6837\u5f0f\uff08X\uff09")
    public String getCssClassX() {
        return this.psSysImage.getCSSCLASSX();
    }

    public String getImagePath(int nX) {
        if (nX == 1 || StringHelper.isNullOrEmpty((String)this.getImagePathX())) {
            return this.getImagePath();
        }
        return this.getImagePathX().replace("{0}", StringHelper.format((String)"%1$s", (Object)nX));
    }

    public String getCssClass(int nX) {
        if (nX == 1 || StringHelper.isNullOrEmpty((String)this.getCssClass())) {
            return this.getCssClass();
        }
        return this.getCssClassX().replace("{0}", StringHelper.format((String)"%1$s", (Object)nX));
    }

    @PSModelRTMeta(description="\u56fe\u7247\u5bbd\u5ea6")
    public int getWidth() {
        return this.nWidth;
    }

    @PSModelRTMeta(description="\u56fe\u7247\u5bbd\u5ea6")
    public int getHeight() {
        return this.nHeight;
    }
}

