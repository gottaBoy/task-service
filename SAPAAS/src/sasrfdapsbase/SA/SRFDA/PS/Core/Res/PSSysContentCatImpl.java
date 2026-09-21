/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysContent;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.Res.PSSysContentCatGlobalModel;
import SA.SRFDA.PS.Core.Res.PSSysContentGlobalModel;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysContentCat;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysContentCatImpl
extends PSSystemObjectImpl
implements IPSSysContentCat {
    private static final Log log = LogFactory.getLog(PSSysContentCatImpl.class);
    protected PSSysContentCat psSysContentCat = null;
    private IPSSystemModule iPSSystemModule = null;
    private PSSysContentCatGlobalModel psSysContentCatGlobalModel = new PSSysContentCatGlobalModel();
    private PSSysContentGlobalModel psSysContentGlobalModel = new PSSysContentGlobalModel();
    private IPSSysContentCat parentPSSysContentCat = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, IPSSysContentCat parentPSSysContentCat, PSSysContentCat psSysContentCat) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysContentCat = psSysContentCat;
            this.parentPSSysContentCat = parentPSSysContentCat;
            this.setId(this.psSysContentCat.getPSSYSCONTENTCATID());
            this.setName(this.psSysContentCat.getPSSYSCONTENTCATNAME());
            this.setPSObjectData(this.psSysContentCat);
            if (!StringHelper.isNullOrEmpty((String)this.psSysContentCat.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysContentCat.getPSMODULEID());
            }
            this.psSysContentCatGlobalModel.Init(this.getDAGlobalHelper(), this);
            this.psSysContentGlobalModel.Init(this.getDAGlobalHelper(), this);
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
        this.getPSSysContentCats();
        this.getPSSysContents();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u5206\u7c7b", hideempty=true)
    public IPSSysContentCat getParentPSSysContentCat() {
        return this.parentPSSysContentCat;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysContentCat.getCODENAME();
    }

    @Override
    public String getModelType() {
        return "PSSYSCONTENTCAT";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true, dumpref=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7c7b\u6807\u8bb0")
    public String getCatTag() {
        return this.psSysContentCat.getCATTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7c7b\u6807\u8bb02")
    public String getCatTag2() {
        return this.psSysContentCat.getCATTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5206\u7c7b\u96c6\u5408")
    public Iterator<IPSSysContentCat> getPSSysContentCats() throws Exception {
        return this.psSysContentCatGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysContentCat getPSSysContentCat(String strSysContentCatId) throws Exception {
        return (IPSSysContentCat)this.psSysContentCatGlobalModel.FindModelHelper(strSysContentCatId);
    }

    @Override
    public IPSSysContentCat getPSSysContentCat(String strSysContentCatId, boolean bTryMode) throws Exception {
        return (IPSSysContentCat)this.psSysContentCatGlobalModel.FindModelHelper(strSysContentCatId, bTryMode);
    }

    @Override
    public void resetPSSysContentCat(String strSysContentCatId) {
        this.psSysContentCatGlobalModel.ResetModel(strSysContentCatId);
    }

    @Override
    public void resetPSSysContentCats() {
        this.psSysContentCatGlobalModel.ResetAll();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u96c6\u5408", child=true, modelreftype="SYSCONTENTCAT")
    public Iterator<IPSSysContent> getPSSysContents() throws Exception {
        return this.psSysContentGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSysContent getPSSysContent(String strSysContentId) throws Exception {
        return (IPSSysContent)this.psSysContentGlobalModel.FindModelHelper(strSysContentId);
    }

    @Override
    public IPSSysContent getPSSysContent(String strSysContentId, boolean bTryMode) throws Exception {
        return (IPSSysContent)this.psSysContentGlobalModel.FindModelHelper(strSysContentId, bTryMode);
    }

    @Override
    public void resetPSSysContent(String strSysContentId) {
        this.psSysContentGlobalModel.ResetModel(strSysContentId);
    }

    @Override
    public void resetPSSysContents() {
        this.psSysContentGlobalModel.ResetAll();
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
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
    }
}

