/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysContent;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysContent;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysContentImpl
extends PSSystemObjectImpl
implements IPSSysContent {
    private static final Log log = LogFactory.getLog(PSSysContentImpl.class);
    protected PSSysContent psSysContent = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysContentCat iPSSysContentCat = null;
    public static final String MODELREFTYPE_SYSCONTENTCAT = "SYSCONTENTCAT";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysContentCat iPSSysContentCat, PSSysContent psSysContent) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysContentCat = iPSSysContentCat;
            this.setPSSystem(this.getPSSysContentCat().getPSSystem());
            this.psSysContent = psSysContent;
            this.setId(this.psSysContent.getPSSYSCONTENTID());
            this.setName(this.psSysContent.getPSSYSCONTENTNAME());
            this.setPSObjectData(this.psSysContent);
            if (!StringHelper.isNullOrEmpty((String)this.psSysContent.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysContent.getPSMODULEID());
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
    @PSModelRTMeta(description="\u5185\u5bb9\u5206\u7c7b")
    public IPSSysContentCat getPSSysContentCat() {
        return this.iPSSysContentCat;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", codelist="SysContentType", group="\u57fa\u672c", order=125)
    public String getContentType() {
        return this.psSysContent.getCONTENTTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysContent.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSCONTENT";
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9", group="\u57fa\u672c", order=135, doctype="code")
    public String getContent() {
        if (StringHelper.compare((String)this.getContentType(), (String)"HTML", (boolean)true) == 0) {
            return this.psSysContent.getHTMLCONTENT();
        }
        if (StringHelper.compare((String)this.getContentType(), (String)"RAW", (boolean)true) == 0) {
            return this.psSysContent.getRAWCONTENT();
        }
        return this.psSysContent.getRAWCONTENT();
    }

    @Override
    public String getModelId() {
        if (this.getPSSysContentCat() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysContentCat().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u6807\u8bb0")
    public String getContentTag() {
        return this.psSysContent.getCONTENTTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u6807\u8bb02")
    public String getContentTag2() {
        return this.psSysContent.getCONTENTTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u6807\u8bb03")
    public String getContentTag3() {
        return this.psSysContent.getCONTENTTAG3();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u6807\u8bb04")
    public String getContentTag4() {
        return this.psSysContent.getCONTENTTAG4();
    }

    @Override
    public String getDynaModelFolder() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u8def\u5f84", fields={"CONTENTPATH"})
    public String getContentPath() {
        return this.psSysContent.getCONTENTPATH();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"SUBJECT"})
    public String getSubject() {
        return this.psSysContent.getSUBJECT();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSSysContentCat() != null) {
            return this.getPSSysContentCat();
        }
        return super.onGetParentModel();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        if (this.getPSSysContentCat() != null) {
            return this.getPSSysContentCat();
        }
        return super.onGetScopeModel();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSSysContentCat() != null) {
            return String.format("%1$s/%2$s", this.getPSSysContentCat().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysContentCat() != null) {
            return String.format("%1$s/%2$s", this.getPSSysContentCat().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

