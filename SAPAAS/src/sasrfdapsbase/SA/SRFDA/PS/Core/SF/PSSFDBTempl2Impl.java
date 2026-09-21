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

import SA.SRFDA.PS.Core.Pub.IPSSFDBCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSSFDBCodePublisher2Impl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFDBTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFDBTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Core.SF.PSSFDBTemplDetailImpl;
import SA.SRFDA.PS.Core.SF.PSSFStyleObjectImpl;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Data.PSSFDBTempl;
import SA.SRFDA.PS.Data.PSSFDBTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFDBTempl2Impl
extends PSSFStyleObjectImpl
implements IPSSFDBTempl2 {
    protected PSSFDBTempl psPFDBTempl = null;
    private static final Log log = LogFactory.getLog(PSSFDBTempl2Impl.class);
    protected ArrayList<IPSSFDBCodePublisher> psPFDBCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;
    private IPSSFPubCode2 iPSSFPubCode2 = null;
    private File templFile = null;
    private String strTemplFilePath = null;
    private boolean bCheckModelOnly = false;
    protected HashMap<String, IPSSFDBTemplDetail> psSFDBTemplDetailMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFPubCode2 iPSSFPubCode2, PSSFDBTempl psPFDBTempl) throws Exception {
        this.psPFDBTempl = psPFDBTempl;
        this.iPSSFPubCode2 = iPSSFPubCode2;
        this.setPSSF(this.iPSSFPubCode2.getPSSF());
        this.setPSSFStyle(this.iPSSFPubCode2.getPSSFStyle2());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFDBTempl.getPSSFDBTEMPLID());
        this.setName(this.psPFDBTempl.getPSSFDBTEMPLNAME());
        this.setPSObjectData(this.psPFDBTempl);
        this.templFile = new File(this.psPFDBTempl.getTEMPLCODE2());
        if (!this.templFile.exists()) {
            throw new Exception(StringHelper.Format((String)"\u6a21\u677f\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)this.getName()));
        }
        this.psPFDBTempl.setTEMPLCODE2("");
        this.strTemplFilePath = this.psPFDBTempl.getTEMPLFILEPATH();
        this.bCheckModelOnly = this.psPFDBTempl.getCHECKMODELONLY();
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF, IPSSFStyle iPSSFStyle, PSSFDBTempl psPFDBTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSSFDBTemplDetails();
        super.onInit();
    }

    protected void onPreparePSSFDBTemplDetails() throws Exception {
        File[] files;
        File rootFolder = new File(((IPSSFStyle2)this.getPSSFStyle()).getRealLocalPath());
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
                if (StringHelper.Compare((String)(strTag = strTag.toUpperCase()), (String)"CODE2", (boolean)true) == 0) {
                    this.psPFDBTempl.setTEMPLCODE2(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE3", (boolean)true) == 0) {
                    this.psPFDBTempl.setTEMPLCODE3(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE4", (boolean)true) == 0) {
                    this.psPFDBTempl.setTEMPLCODE4(strContent);
                } else {
                    PSSFDBTemplDetail psSFDBTemplDetail = new PSSFDBTemplDetail();
                    psSFDBTemplDetail.setTEMPLCODE(strContent);
                    psSFDBTemplDetail.setPSSFDBDETAILID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strTag));
                    psSFDBTemplDetail.setPSSFDBDETAILNAME(strTag);
                    PSSFDBTemplDetailImpl psSFDBTemplDetailImpl = new PSSFDBTemplDetailImpl();
                    psSFDBTemplDetailImpl.init(this.getDAGlobalHelper(), this, psSFDBTemplDetail);
                    this.psSFDBTemplDetailMap.put(strTag, psSFDBTemplDetailImpl);
                }
            }
            ++n2;
        }
    }

    @Override
    public IPSSFPubCode getPSSFPubCode() throws Exception {
        return this.iPSSFPubCode2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSSFDBCodePublisher getPSSFDBCodePublisher() throws Exception {
        ArrayList<IPSSFDBCodePublisher> arrayList = this.psPFDBCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFDBCodePublisher.clear();
            } else if (this.psPFDBCodePublisher.size() > 0) {
                return this.psPFDBCodePublisher.remove(0);
            }
        }
        IPSSFDBCodePublisher iPSSFDBCodePublisher = this.createPSSFDBCodePublisher();
        iPSSFDBCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSSFDBCodePublisher;
    }

    protected IPSSFDBCodePublisher createPSSFDBCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFDBTempl.getPUBOBJ())) {
            return (IPSSFDBCodePublisher)ObjectHelper.Create((String)this.psPFDBTempl.getPUBOBJ());
        }
        return new PSSFDBCodePublisher2Impl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSSFDBCodePublisher(IPSSFDBCodePublisher iPSSFDBCodePublisher) {
        ArrayList<IPSSFDBCodePublisher> arrayList = this.psPFDBCodePublisher;
        synchronized (arrayList) {
            this.psPFDBCodePublisher.add(iPSSFDBCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSSFDBCodePublishers() {
        ArrayList<IPSSFDBCodePublisher> arrayList = this.psPFDBCodePublisher;
        synchronized (arrayList) {
            this.psPFDBCodePublisher.clear();
        }
    }

    @Override
    public PSSFDBTempl getPSSFDBTemplData() {
        return this.psPFDBTempl;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public String getTemplFilePath() {
        return this.strTemplFilePath;
    }

    @Override
    public IPSSFDBTemplDetail getPSSFDBTemplDetail(String strName) throws Exception {
        return this.getPSSFDBTemplDetail(strName, false);
    }

    @Override
    public IPSSFDBTemplDetail getPSSFDBTemplDetail(String strName, boolean bTryMode) throws Exception {
        IPSSFDBTemplDetail iPSSFDBTemplDetail = this.psSFDBTemplDetailMap.get(strName);
        if (iPSSFDBTemplDetail == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u90e8\u4ef6\u6a21\u677f[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6210\u5458[%2$s][%3$s]\u6a21\u677f", (Object)this.getName(), (Object)strName, (Object)this.getPSSFPubCode().getName()));
        }
        return iPSSFDBTemplDetail;
    }

    @Override
    public IPSSFDBTemplDetail getPSSFDBTemplDetail2(String strName, boolean bTryMode) throws Exception {
        return this.getPSSFDBTemplDetail(strName, bTryMode);
    }

    @Override
    public IPSSFDBTemplDetail getPSSFDBTemplDetail2(String strName) throws Exception {
        return this.getPSSFDBTemplDetail(strName, false);
    }

    @Override
    public boolean isCheckModelOnly() {
        return this.bCheckModelOnly;
    }
}

