/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSFSysCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeTempl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Core.SF.PSSFCodeTemplImpl;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Data.PSSFCodeTempl;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFCodeType2Impl
extends PSObjectImpl
implements IPSSFCodeType2 {
    private static final Log log = LogFactory.getLog(PSSFCodeType2Impl.class);
    protected PSSFCodeType psSFCodeType = new PSSFCodeType();
    protected IPSSFCodeFolder iPSSFCodeFolder = null;
    protected ArrayList<IPSSFSysCodePublisher> psSFSysCodePublisher = new ArrayList();
    private boolean bGlobalCodeType = false;
    private String strFileName = null;
    private String strFileExt = null;
    private HashMap<String, String> psModelMap = null;
    private boolean bDebugModeOnly = false;
    private boolean bRemoveMode = false;
    private boolean bDefaultPub = true;
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;
    private File templFile = null;
    private String strPubParam = null;
    private boolean bCheckModelOnly = false;
    private boolean bRemoveEmptyFile = true;
    private HashMap<String, IPSSFCodeTempl> psSFCodeTemplMap = null;

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
        this.templFile = new File(psSFCodeType.getTEMPLCODE2());
        if (!this.templFile.exists()) {
            throw new Exception(StringHelper.Format((String)"\u6a21\u677f\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)this.getTypeCode()));
        }
        this.strPubParam = psSFCodeType.getParamStringValue("PUBPARAM", "");
        this.bCheckModelOnly = this.psSFCodeType.getCHECKMODELONLY();
        if (!this.psSFCodeType.isREMOVEEMPTYFILENull()) {
            this.bRemoveEmptyFile = this.psSFCodeType.getREMOVEEMPTYFILE();
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSSFCodeTempls();
    }

    protected void onPreparePSSFCodeTempls() throws Exception {
        File[] files;
        File rootFolder = new File(((IPSSFStyle2)this.getPSSFCodeFolder().getPSSFStyle()).getRealLocalPath());
        String strTemplFilePath = this.templFile.getCanonicalPath();
        strTemplFilePath = String.valueOf(strTemplFilePath.substring(0, strTemplFilePath.length() - 4)) + "#";
        File[] fileArray = files = this.templFile.getParentFile().listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            String strSuffix;
            String strFilePath2;
            int nPos;
            String strFilePath;
            File file = fileArray[n2];
            if (!file.isDirectory() && (strFilePath = file.getCanonicalPath()).indexOf(strTemplFilePath) == 0 && (nPos = (strFilePath2 = strFilePath.substring(strTemplFilePath.length())).lastIndexOf(".")) > 0 && (strSuffix = strFilePath2.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                String strTag = strFilePath2.substring(0, strFilePath2.length() - 4);
                TemplFileHelper templFileHelper = new TemplFileHelper();
                BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file, rootFolder);
                String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                String strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                PSSFCodeTempl psSFCodeTempl = new PSSFCodeTempl();
                psSFCodeTempl.setTEMPLCODE(strContent);
                psSFCodeTempl.setPSSFCODETEMPLID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strTag));
                psSFCodeTempl.setPSSFCODETEMPLNAME(strTag);
                PSSFCodeTemplImpl psSFCodeTemplImpl = new PSSFCodeTemplImpl();
                psSFCodeTemplImpl.init(this.getDAGlobalHelper(), this, psSFCodeTempl);
                if (this.psSFCodeTemplMap == null) {
                    this.psSFCodeTemplMap = new HashMap();
                }
                this.psSFCodeTemplMap.put(psSFCodeTemplImpl.getId(), psSFCodeTemplImpl);
                this.psSFCodeTemplMap.put(strTag, psSFCodeTemplImpl);
            }
            ++n2;
        }
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTempl(String strSFCodeTemplId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTempl(String strSFCodeTemplId, boolean bTryMode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void resetPSSFCodeTempl(String strSFCodeTemplId) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public Iterator<IPSSFCodeTempl> getPSSFCodeTempls() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSSFCodeTempl getPSSFCodeTemplByTag(String strSFCodeTemplTag) throws Exception {
        Iterator<IPSSFCodeFolder> psSFCodeFolders;
        IPSSFCodeTempl iPSSFCodeTempl;
        if (this.psSFCodeTemplMap != null && (iPSSFCodeTempl = this.psSFCodeTemplMap.get(strSFCodeTemplTag)) != null) {
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
        IPSSFCodeTempl iPSSFCodeTempl;
        if (this.psSFCodeTemplMap != null && (iPSSFCodeTempl = this.psSFCodeTemplMap.get(strSFCodeTemplTag)) != null) {
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
        if (iPSSFSysCodePublisher == null) {
            throw new Exception(String.format("\u65e0\u6cd5\u5efa\u7acb\u53d1\u5e03\u5bf9\u8c61[%1$s]", this.psSFCodeType.getPUBOBJ()));
        }
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
    public String getPubParam() {
        return this.strPubParam;
    }

    @Override
    public boolean isDefaultPub() {
        return this.bDefaultPub;
    }

    @Override
    public boolean isCheckModelOnly() {
        return this.bCheckModelOnly;
    }

    @Override
    public boolean isRemoveEmptyFile() {
        return this.bRemoveEmptyFile;
    }
}

