/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSF2;
import SA.SRFDA.PS.Core.SF.IPSSFACHandler;
import SA.SRFDA.PS.Core.SF.IPSSFPkg;
import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.IPSSFPubObj;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleParam;
import SA.SRFDA.PS.Core.SF.PSSFACHandlerGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFPkgGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFPkgVerGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFPubObjGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFStyleGlobalModel;
import SA.SRFDA.PS.Core.SF.PSSFStyleParamGlobalModel;
import SA.SRFDA.PS.Data.PSSF;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFImpl
extends PSObjectImpl
implements IPSSF,
IPSSF2 {
    protected PSSF psSF = null;
    private static final Log log = LogFactory.getLog(PSSFImpl.class);
    protected PSSFStyleGlobalModel psSFStyleGlobalModel = new PSSFStyleGlobalModel();
    protected PSSFACHandlerGlobalModel psSFACHandlerGlobalModel = new PSSFACHandlerGlobalModel();
    protected PSSFPkgVerGlobalModel psSFPkgVerGlobalModel = new PSSFPkgVerGlobalModel();
    protected PSSFPkgGlobalModel psSFPkgGlobalModel = new PSSFPkgGlobalModel();
    protected PSSFPubObjGlobalModel psSFPubObjGlobalModel = new PSSFPubObjGlobalModel();
    protected PSSFStyleParamGlobalModel psSFStyleParamGlobalModel = new PSSFStyleParamGlobalModel();
    private boolean bPkgNameLowerCase = false;
    public static final String DEFAULT_DOCURL = "http://www.ibizsys.net";
    private Properties classPkgParamsMap = null;
    private boolean bCodeFramework = true;
    private boolean bDocFramework = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSF psSF) throws Exception {
        this.psSF = psSF;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psSF.getPSSFID());
        this.setName(psSF.getPSSFNAME());
        this.setPSObjectData(this.psSF);
        if (!this.psSF.isPKGLOWERCASENull()) {
            this.bPkgNameLowerCase = this.psSF.getPKGLOWERCASE();
        }
        this.classPkgParamsMap = PropertiesHelper.Load((String)psSF.getCLSPKGPARAMS());
        if (!this.psSF.isDOCFLAGNull()) {
            this.bCodeFramework = this.psSF.getCODEFLAG();
        }
        if (!this.psSF.isDOCFLAGNull()) {
            this.bDocFramework = this.psSF.getDOCFLAG();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.psSFPubObjGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSFPkgGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSFPkgVerGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSFStyleGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSFACHandlerGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psSFStyleParamGlobalModel.Init(this.getDAGlobalHelper(), this);
    }

    @Override
    public IPSSFStyle getPSSFStyle(String strSFStyleId) throws Exception {
        return (IPSSFStyle)this.psSFStyleGlobalModel.FindModelHelper(strSFStyleId);
    }

    @Override
    public IPSSFStyle getPSSFStyle(String strSFStyleId, boolean bTryMode) throws Exception {
        return this.psSFStyleGlobalModel.FindModelHelper(strSFStyleId, bTryMode);
    }

    @Override
    public void resetPSSFStyle(String strSFStyleId) throws Exception {
        this.psSFStyleGlobalModel.ResetModel(strSFStyleId);
    }

    @Override
    public IPSSFACHandler getPSSFACHandler(String strSFACHandlerId) throws Exception {
        return (IPSSFACHandler)this.psSFACHandlerGlobalModel.FindModelHelper(strSFACHandlerId);
    }

    @Override
    public void resetPSSFACHandler(String strSFACHandlerId) throws Exception {
        this.psSFACHandlerGlobalModel.ResetModel(strSFACHandlerId);
    }

    @Override
    public IPSSFPkgVer getPSSFPkgVer(String strSFPkgVerId) throws Exception {
        return (IPSSFPkgVer)this.psSFPkgVerGlobalModel.FindModelHelper(strSFPkgVerId);
    }

    @Override
    public void resetPSSFPkgVer(String strSFPkgVerId) throws Exception {
        this.psSFPkgVerGlobalModel.ResetModel(strSFPkgVerId);
    }

    @Override
    public IPSSFPkg getPSSFPkg(String strSFPkgId) throws Exception {
        return (IPSSFPkg)this.psSFPkgGlobalModel.FindModelHelper(strSFPkgId);
    }

    @Override
    public void resetPSSFPkg(String strSFPkgId) throws Exception {
        this.psSFPkgGlobalModel.ResetModel(strSFPkgId);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public boolean isPkgLowercase() {
        return this.bPkgNameLowerCase;
    }

    @Override
    public IPSSFStyleParam getPSSFStyleParam(String strSFStyleParamId) throws Exception {
        return (IPSSFStyleParam)this.psSFStyleParamGlobalModel.FindModelHelper(strSFStyleParamId);
    }

    @Override
    public void resetPSSFStyleParam(String strSFStyleParamId) throws Exception {
        this.psSFStyleParamGlobalModel.ResetModel(strSFStyleParamId);
    }

    public static String getDefaultValueFormat(String strPSSFId) {
        if (strPSSFId.indexOf("J2EE") != -1) {
            return "%1$s";
        }
        if (strPSSFId.indexOf("DOTNET") != -1) {
            return "{0}";
        }
        return "%1$s";
    }

    @Override
    public IPSSFPubObj getPSSFPubObj(String strSFPubObjId, boolean bTryMode) throws Exception {
        return (IPSSFPubObj)this.psSFPubObjGlobalModel.FindModelHelper(strSFPubObjId, bTryMode);
    }

    @Override
    public IPSSFPubObj getPSSFPubObjByTarget(String strTarget, boolean bTryMode) throws Exception {
        if (strTarget == null) {
            strTarget = "";
        }
        String strSFPubObjId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strTarget.toUpperCase());
        return this.getPSSFPubObj(strSFPubObjId, bTryMode);
    }

    @Override
    public void resetPSSFPubObj(String strSFPubObjId) throws Exception {
        this.psSFPubObjGlobalModel.ResetModel(strSFPubObjId);
    }

    @Override
    public String getClassOrPkgName(String strCodeType) throws Exception {
        String strClassOrPkgName = PropertiesHelper.GetProperty((Properties)this.classPkgParamsMap, (String)strCodeType);
        if (!StringHelper.IsNullOrEmpty((String)strClassOrPkgName)) {
            strClassOrPkgName = strClassOrPkgName.trim();
        }
        return strClassOrPkgName;
    }

    @Override
    public boolean isCodeFramework() {
        return this.bCodeFramework;
    }

    @Override
    public boolean isDocFramework() {
        return this.bDocFramework;
    }
}

