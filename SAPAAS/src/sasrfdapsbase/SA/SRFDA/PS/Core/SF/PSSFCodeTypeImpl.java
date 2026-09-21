/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSFSysCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeTempl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.PSSFCodeTemplGlobalModel;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFCodeTypeImpl
extends PSObjectImpl
implements IPSSFCodeType {
    protected PSSFCodeType psSFCodeType = new PSSFCodeType();
    protected IPSSFCodeFolder iPSSFCodeFolder = null;
    private static final Log log = LogFactory.getLog(PSSFCodeTypeImpl.class);
    protected PSSFCodeTemplGlobalModel psSFCodeTemplGlobalModel = new PSSFCodeTemplGlobalModel();
    protected ArrayList<IPSSFSysCodePublisher> psSFSysCodePublisher = new ArrayList();
    private boolean bGlobalCodeType = false;
    private String strFileName = null;
    private String strFileExt = null;
    private HashMap<String, String> psModelMap = null;
    private boolean bDebugModeOnly = false;
    private boolean bRemoveMode = false;
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;
    private boolean bDefaultPub = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFCodeFolder iPSSFCodeFolder, PSSFCodeType psSFCodeType) throws Exception {
        this.iPSSFCodeFolder = iPSSFCodeFolder;
        psSFCodeType.CopyTo(this.psSFCodeType, false);
        String strTemplCode = this.psSFCodeType.getCODETEMPL();
        if (!StringHelper.IsNullOrEmpty((String)iPSSFCodeFolder.getHeaderCode())) {
            strTemplCode = String.valueOf(iPSSFCodeFolder.getHeaderCode()) + strTemplCode;
        }
        if (!StringHelper.IsNullOrEmpty((String)iPSSFCodeFolder.getBottomCode())) {
            strTemplCode = String.valueOf(strTemplCode) + iPSSFCodeFolder.getBottomCode();
        }
        this.psSFCodeType.setCODETEMPL(strTemplCode);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psSFCodeType.getPSSFCODETYPEID());
        this.setName(psSFCodeType.getPSSFCODETYPENAME());
        this.setPSObjectData(this.psSFCodeType);
        if (!this.psSFCodeType.isGLOBALFLAGNull()) {
            this.bGlobalCodeType = this.psSFCodeType.getGLOBALFLAG();
        }
        this.strFileName = this.psSFCodeType.getFILENAME();
        this.strFileExt = this.psSFCodeType.getFILEEXT();
        if (!StringHelper.IsNullOrEmpty((String)this.psSFCodeType.getPSMODELID()) || !StringHelper.IsNullOrEmpty((String)this.psSFCodeType.getMODELLIST())) {
            this.psModelMap = new HashMap();
            if (!StringHelper.IsNullOrEmpty((String)this.psSFCodeType.getPSMODELID())) {
                this.psModelMap.put(this.psSFCodeType.getPSMODELID(), "");
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psSFCodeType.getMODELLIST())) {
                String[] models;
                String[] stringArray = models = this.psSFCodeType.getMODELLIST().toUpperCase().split("[;]");
                int n = models.length;
                int n2 = 0;
                while (n2 < n) {
                    String strModel = stringArray[n2];
                    String strModel2 = strModel.trim();
                    if (!StringHelper.IsNullOrEmpty((String)strModel2)) {
                        this.psModelMap.put(strModel2, "");
                    }
                    ++n2;
                }
            }
        }
        if (!this.psSFCodeType.isDEBUGMODENull()) {
            this.bDebugModeOnly = this.psSFCodeType.getDEBUGMODE();
        }
        if (this.psSFCodeType.getVALIDFLAG() == 2) {
            this.bRemoveMode = true;
        }
        if (!this.psSFCodeType.isDEFAULTPUBNull()) {
            this.bDefaultPub = this.psSFCodeType.getDEFAULTPUB();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.psSFCodeTemplGlobalModel.Init(this.getDAGlobalHelper(), this);
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTempl(String strSFCodeTemplId) throws Exception {
        return (IPSSFCodeTempl)this.psSFCodeTemplGlobalModel.FindModelHelper(strSFCodeTemplId);
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTempl(String strSFCodeTemplId, boolean bTryMode) throws Exception {
        return (IPSSFCodeTempl)this.psSFCodeTemplGlobalModel.FindModelHelper(strSFCodeTemplId, bTryMode);
    }

    @Override
    public void resetPSSFCodeTempl(String strSFCodeTemplId) throws Exception {
        this.psSFCodeTemplGlobalModel.ResetModel(strSFCodeTemplId);
    }

    @Override
    public Iterator<IPSSFCodeTempl> getPSSFCodeTempls() throws Exception {
        return this.psSFCodeTemplGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTemplByTag(String strSFCodeTemplTag) throws Exception {
        Iterator<IPSSFCodeFolder> psSFCodeFolders;
        String strSFCodeTemplId = Helper.GenUniqueId((String)this.getId(), (String)strSFCodeTemplTag);
        IPSSFCodeTempl iPSSFCodeTempl = this.getPSSFCodeTempl(strSFCodeTemplId, true);
        if (iPSSFCodeTempl != null) {
            return iPSSFCodeTempl;
        }
        if (this.getPSSFStyle().getTemplPSSFStyle() != null && (psSFCodeFolders = this.getPSSFStyle().getTemplPSSFStyle().getPSSFCodeFolders(false)) != null) {
            while (psSFCodeFolders.hasNext()) {
                IPSSFCodeFolder iPSSFCodeFolder = psSFCodeFolders.next();
                IPSSFCodeType iPSSFCodeType = iPSSFCodeFolder.getPSSFCodeType(this.getTypeCode(), true);
                if (iPSSFCodeType == null) continue;
                return iPSSFCodeType.getPSSFCodeTemplByTag(strSFCodeTemplTag);
            }
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6807\u8bc6[%1$s:%2$s]\u540e\u53f0\u670d\u52a1\u4ee3\u7801\u6a21\u677f", (Object)this.getTypeCode(), (Object)strSFCodeTemplTag));
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTemplByTag(String strSFCodeTemplTag, boolean bTryMode) throws Exception {
        Iterator<IPSSFCodeFolder> psSFCodeFolders;
        String strSFCodeTemplId = Helper.GenUniqueId((String)this.getId(), (String)strSFCodeTemplTag);
        IPSSFCodeTempl iPSSFCodeTempl = this.getPSSFCodeTempl(strSFCodeTemplId, true);
        if (iPSSFCodeTempl != null) {
            return iPSSFCodeTempl;
        }
        if (this.getPSSFStyle().getTemplPSSFStyle() != null && (psSFCodeFolders = this.getPSSFStyle().getTemplPSSFStyle().getPSSFCodeFolders(false)) != null) {
            while (psSFCodeFolders.hasNext()) {
                IPSSFCodeFolder iPSSFCodeFolder = psSFCodeFolders.next();
                IPSSFCodeType iPSSFCodeType = iPSSFCodeFolder.getPSSFCodeType(this.getTypeCode(), true);
                if (iPSSFCodeType == null) continue;
                return iPSSFCodeType.getPSSFCodeTemplByTag(strSFCodeTemplTag, bTryMode);
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6807\u8bc6[%1$s:%2$s]\u540e\u53f0\u670d\u52a1\u4ee3\u7801\u6a21\u677f", (Object)this.getTypeCode(), (Object)strSFCodeTemplTag));
    }

    @Override
    public String getTypeCode() {
        return this.psSFCodeType.getTYPECODE();
    }

    @Override
    public IPSSFCodeFolder getPSSFCodeFolder() {
        return this.iPSSFCodeFolder;
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
        IPSSFSysCodePublisher iPSSFSysCodePublisher = (IPSSFSysCodePublisher)ObjectHelper.Create((String)this.psSFCodeType.getPUBOBJ());
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
        return this.bGlobalCodeType;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSFCodeFolder.getPSSysModelInstId();
    }

    @Override
    public String getFileName() {
        return this.strFileName;
    }

    @Override
    public String getFileExt() {
        return this.strFileExt;
    }

    @Override
    public boolean testPubPSModelCode(String strPSModelName) {
        if (this.psModelMap == null) {
            return false;
        }
        return this.psModelMap.containsKey(strPSModelName);
    }

    @Override
    public String getTemplDocUrl() {
        if (StringHelper.IsNullOrEmpty((String)this.getPSSFStyle().getTemplDocRootUrl())) {
            return "http://www.ibizsys.net";
        }
        String strFileName = null;
        strFileName = StringHelper.IsNullOrEmpty((String)this.getFileExt()) ? StringHelper.Format((String)"%1$s", (Object)"MAIN") : StringHelper.Format((String)"%1$s.%2$s", (Object)"MAIN", (Object)this.getFileExt());
        return StringHelper.Format((String)"%1$s%2$s%3$s%2$s%4$s", (Object)this.getPSSFStyle().getTemplDocRootUrl(), (Object)"/", (Object)this.getTypeCode(), (Object)strFileName);
    }

    @Override
    public IPSSFStyle getPSSFStyle() {
        return this.getPSSFCodeFolder().getPSSFStyle();
    }

    @Override
    public boolean isDebugModeOnly() {
        return this.bDebugModeOnly;
    }

    @Override
    public boolean isRemoveMode() {
        return this.bRemoveMode;
    }

    @Override
    public boolean isDefaultPub() {
        return this.bDefaultPub;
    }
}

