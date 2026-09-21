/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFSysCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeTempl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Core.SF.IPSSFVerCodeItem;
import SA.SRFDA.PS.Core.SF.PSSFObjectImpl;
import SA.SRFDA.PS.Core.SF.PSSFVerCodeItemGlobalModel;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.PS.Data.PSSFVerCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSSFVerCodeImpl
extends PSSFObjectImpl
implements IPSSFVerCode {
    private IPSSFStyleVer iPSSFStyleVer = null;
    private PSSFVerCode psSFVerCode = null;
    private IPSSFCodeFolder iPSSFCodeFolder = null;
    private IPSSFCodeType iPSSFCodeType = null;
    private PSSFCodeType psSFCodeType = new PSSFCodeType();
    private PSSFVerCodeItemGlobalModel psSFVerCodeItemGlobalModel = new PSSFVerCodeItemGlobalModel();
    protected ArrayList<IPSSFSysCodePublisher> psSFSysCodePublisher = new ArrayList();
    private IPSSFStyle realPSSFStyle = null;
    private String strCustomTypeCode = null;
    private String strCustomFileName = null;
    private String strCustomFileExt = null;
    private boolean bRemoveMode = false;
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFStyleVer iPSSFStyleVer, PSSFVerCode psSFVerCode) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSFStyleVer = iPSSFStyleVer;
        this.psSFVerCode = psSFVerCode;
        this.setPSSF(this.getPSSFStyleVer().getPSSF());
        this.setId(this.psSFVerCode.getPSSFVERCODEID());
        this.setName(this.psSFVerCode.getPSSFVERCODENAME());
        this.setPSObjectData(psSFVerCode);
        if (!StringHelper.isNullOrEmpty((String)this.psSFVerCode.getREALPSSFSTYLEID())) {
            this.realPSSFStyle = StringHelper.compare((String)this.iPSSFStyleVer.getPSSFStyle().getId(), (String)this.psSFVerCode.getREALPSSFSTYLEID(), (boolean)false) == 0 ? this.iPSSFStyleVer.getPSSFStyle() : this.iPSSFStyleVer.getPSSFStyle().getPSSF().getPSSFStyle(this.psSFVerCode.getREALPSSFSTYLEID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSFVerCode.getPSSFCODEFOLDERID())) {
            this.iPSSFCodeFolder = this.getPSSFStyle().getPSSFCodeFolder(this.psSFVerCode.getPSSFCODEFOLDERID());
            if (!StringHelper.isNullOrEmpty((String)this.psSFVerCode.getPSSFCODETYPEID())) {
                this.iPSSFCodeType = this.iPSSFCodeFolder.getPSSFCodeType(this.psSFVerCode.getPSSFCODETYPEID());
                this.iPSSFCodeType.getPSSFCodeTypeData().CopyTo(this.psSFCodeType, true);
            }
        }
        this.psSFVerCode.CopyTo(this.psSFCodeType, false);
        if (!psSFVerCode.isENABLECUSTOMTYPECODENull() && psSFVerCode.getENABLECUSTOMTYPECODE()) {
            this.strCustomTypeCode = this.psSFVerCode.getCUSTOMTYPECODE();
            this.psSFCodeType.setTYPECODE(this.strCustomTypeCode);
        } else if (this.iPSSFCodeType != null) {
            this.strCustomTypeCode = this.iPSSFCodeType.getTypeCode();
        }
        if (!psSFVerCode.isENABLECUSTOMFILENAMENull() && psSFVerCode.getENABLECUSTOMFILENAME()) {
            this.strCustomFileName = this.psSFVerCode.getFILENAME();
            this.strCustomFileExt = this.psSFVerCode.getFILEEXT();
            this.psSFCodeType.setFILENAME(this.strCustomFileName);
            this.psSFCodeType.setFILEEXT(this.strCustomFileExt);
        } else if (this.iPSSFCodeType != null) {
            this.strCustomFileName = this.iPSSFCodeType.getFileName();
            this.strCustomFileExt = this.iPSSFCodeType.getFileExt();
        }
        if (!psSFVerCode.isENABLECUSTOMCODEPATHNull() && psSFVerCode.getENABLECUSTOMCODEPATH()) {
            this.psSFCodeType.setCODEPATH(this.psSFVerCode.getCODEPATH());
        }
        if (this.psSFVerCode.getVALIDFLAG() == 2) {
            this.bRemoveMode = true;
        }
        this.psSFVerCodeItemGlobalModel.Init(iDAGlobalHelper, this);
        this.onInit();
    }

    @Override
    public IPSSFCodeFolder getPSSFCodeFolder() {
        return this.iPSSFCodeFolder;
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTempl(String strSFCodeTemplId) throws Exception {
        return (IPSSFCodeTempl)this.psSFVerCodeItemGlobalModel.FindModelHelper(strSFCodeTemplId);
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTempl(String strSFCodeTemplId, boolean bTryMode) throws Exception {
        return (IPSSFCodeTempl)this.psSFVerCodeItemGlobalModel.FindModelHelper(strSFCodeTemplId, bTryMode);
    }

    @Override
    public void resetPSSFCodeTempl(String strSFCodeTemplId) throws Exception {
        this.psSFVerCodeItemGlobalModel.ResetModel(strSFCodeTemplId);
    }

    @Override
    public Iterator<IPSSFCodeTempl> getPSSFCodeTempls() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTemplByTag(String strSFCodeTemplTag) throws Exception {
        String strSFCodeTemplId = Helper.GenUniqueId((String)this.getId(), (String)strSFCodeTemplTag);
        IPSSFCodeTempl iPSSFCodeTempl = (IPSSFCodeTempl)this.psSFVerCodeItemGlobalModel.FindModelHelper(strSFCodeTemplId, true);
        if (iPSSFCodeTempl != null) {
            return iPSSFCodeTempl;
        }
        return this.getPSSFCodeType().getPSSFCodeTemplByTag(strSFCodeTemplTag);
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTemplByTag(String strSFCodeTemplTag, boolean bTryMode) throws Exception {
        String strSFCodeTemplId = Helper.GenUniqueId((String)this.getId(), (String)strSFCodeTemplTag);
        IPSSFCodeTempl iPSSFCodeTempl = (IPSSFCodeTempl)this.psSFVerCodeItemGlobalModel.FindModelHelper(strSFCodeTemplId, true);
        if (iPSSFCodeTempl != null) {
            return iPSSFCodeTempl;
        }
        return this.getPSSFCodeType().getPSSFCodeTemplByTag(strSFCodeTemplTag, bTryMode);
    }

    @Override
    public String getTypeCode() {
        return this.strCustomTypeCode;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSSFSysCodePublisher getPSSFSysCodePublisher() throws Exception {
        ArrayList<IPSSFSysCodePublisher> arrayList = this.psSFSysCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psSFSysCodePublisher.clear();
            } else if (this.psSFSysCodePublisher.size() > 0) {
                return this.psSFSysCodePublisher.remove(0);
            }
        }
        IPSSFSysCodePublisher iPSSFSysCodePublisher = (IPSSFSysCodePublisher)ObjectHelper.Create((String)this.iPSSFCodeType.getPSSFCodeTypeData().getPUBOBJ());
        iPSSFSysCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSSFSysCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSSFSysCodePublisher(IPSSFSysCodePublisher iPSSFSysCodePublisher) {
        ArrayList<IPSSFSysCodePublisher> arrayList = this.psSFSysCodePublisher;
        synchronized (arrayList) {
            this.psSFSysCodePublisher.add(iPSSFSysCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSSFSysCodePublishers() {
        ArrayList<IPSSFSysCodePublisher> arrayList = this.psSFSysCodePublisher;
        synchronized (arrayList) {
            this.psSFSysCodePublisher.clear();
        }
    }

    @Override
    public PSSFCodeType getPSSFCodeTypeData() {
        return this.psSFCodeType;
    }

    @Override
    public boolean isGlobalCodeType() {
        return this.iPSSFCodeType.isGlobalCodeType();
    }

    @Override
    public String getFileName() {
        return this.strCustomFileName;
    }

    @Override
    public String getFileExt() {
        return this.strCustomFileExt;
    }

    @Override
    public IPSSFStyleVer getPSSFStyleVer() {
        return this.iPSSFStyleVer;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSF().getPSSysModelInstId();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFCodeFolder iPSSFCodeFolder, PSSFCodeType psSFCodeType) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSSFCodeType getPSSFCodeType() {
        return this.iPSSFCodeType;
    }

    @Override
    public IPSSFVerCodeItem getPSSFVerCodeItem(String strSFVerCodeItemId) throws Exception {
        return (IPSSFVerCodeItem)this.psSFVerCodeItemGlobalModel.FindModelHelper(strSFVerCodeItemId);
    }

    @Override
    public void resetPSSFVerCodeItem(String strSFVerCodeItemId) throws Exception {
        this.psSFVerCodeItemGlobalModel.ResetModel(strSFVerCodeItemId);
    }

    @Override
    public Iterator<IPSSFVerCodeItem> getPSSFVerCodeItems() throws Exception {
        return this.psSFVerCodeItemGlobalModel.getAllModelHelpers();
    }

    @Override
    public boolean testPubPSModelCode(String strPSModelName) {
        return false;
    }

    @Override
    public IPSSFStyle getPSSFStyle() {
        return this.realPSSFStyle;
    }

    @Override
    public String getTemplDocUrl() {
        if (this.iPSSFCodeType != null) {
            return this.iPSSFCodeType.getTemplDocUrl();
        }
        return "http://www.ibizsys.net";
    }

    @Override
    public boolean isDebugModeOnly() {
        if (this.iPSSFCodeType != null) {
            return this.iPSSFCodeType.isDebugModeOnly();
        }
        return false;
    }

    @Override
    public boolean isRemoveMode() {
        return this.bRemoveMode;
    }

    @Override
    public boolean isDefaultPub() {
        if (this.iPSSFCodeType != null) {
            return this.iPSSFCodeType.isDefaultPub();
        }
        return true;
    }
}

