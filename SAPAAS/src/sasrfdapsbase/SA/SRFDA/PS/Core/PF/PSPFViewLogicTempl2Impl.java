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
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode2;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl2;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTemplDetail;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.PF.PSPFViewLogicTemplDetailImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPFViewLogicCodePublisher2Impl;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.PS.Data.PSPFViewLogicTemplDetail;
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

public class PSPFViewLogicTempl2Impl
extends PSPFStyleObjectImpl
implements IPSPFViewLogicTempl2 {
    protected PSPFViewLogicTempl psPFViewLogicTempl = null;
    private static final Log log = LogFactory.getLog(PSPFViewLogicTempl2Impl.class);
    protected ArrayList<IPSPFViewLogicCodePublisher> psPFViewLogicCodePublisher = new ArrayList();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;
    private IPSPFPubCode2 iPSPFPubCode2 = null;
    private File templFile = null;
    private String strTemplFilePath = null;
    protected HashMap<String, IPSPFViewLogicTemplDetail> psPFViewLogicTemplDetailMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFPubCode2 iPSPFPubCode2, PSPFViewLogicTempl psPFViewLogicTempl) throws Exception {
        this.psPFViewLogicTempl = psPFViewLogicTempl;
        this.iPSPFPubCode2 = iPSPFPubCode2;
        this.setPSPF(this.iPSPFPubCode2.getPSPF());
        this.setPSPFStyle(this.iPSPFPubCode2.getPSPFStyle2());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFViewLogicTempl.getPSPFVLTEMPLID());
        this.setName(this.psPFViewLogicTempl.getPSPFVLTEMPLNAME());
        this.setPSObjectData(this.psPFViewLogicTempl);
        if (this.isFromTemplFile()) {
            this.templFile = new File(this.psPFViewLogicTempl.getTEMPLCODE2());
            if (!this.templFile.exists()) {
                throw new Exception(StringHelper.Format((String)"\u6a21\u677f\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)this.getName()));
            }
            this.psPFViewLogicTempl.setTEMPLCODE2("");
            this.strTemplFilePath = this.psPFViewLogicTempl.getTEMPLFILEPATH();
        }
        this.onInit();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFViewLogicTempl psPFViewLogicTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected boolean isFromTemplFile() {
        return true;
    }

    @Override
    protected void onInit() throws Exception {
        if (this.isFromTemplFile()) {
            this.onPreparePSPFViewLogicTemplDetails();
        }
        super.onInit();
    }

    protected void onPreparePSPFViewLogicTemplDetails() throws Exception {
        File[] files;
        File rootFolder = new File(((IPSPFStyle2)this.getPSPFStyle()).getRealLocalPath());
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
                    this.psPFViewLogicTempl.setTEMPLCODE2(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE3", (boolean)true) == 0) {
                    this.psPFViewLogicTempl.setTEMPLCODE3(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE4", (boolean)true) == 0) {
                    this.psPFViewLogicTempl.setTEMPLCODE4(strContent);
                } else {
                    PSPFViewLogicTemplDetail psPFViewLogicTemplDetail = new PSPFViewLogicTemplDetail();
                    psPFViewLogicTemplDetail.setTEMPLCODE(strContent);
                    psPFViewLogicTemplDetail.setPSPFVLDETAILID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strTag));
                    psPFViewLogicTemplDetail.setPSPFVLDETAILNAME(strTag);
                    PSPFViewLogicTemplDetailImpl psPFViewLogicTemplDetailImpl = new PSPFViewLogicTemplDetailImpl();
                    psPFViewLogicTemplDetailImpl.init(this.getDAGlobalHelper(), this, psPFViewLogicTemplDetail);
                    this.psPFViewLogicTemplDetailMap.put(strTag, psPFViewLogicTemplDetailImpl);
                }
            }
            ++n2;
        }
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.iPSPFPubCode2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFViewLogicCodePublisher getPSPFViewLogicCodePublisher() throws Exception {
        ArrayList<IPSPFViewLogicCodePublisher> arrayList = this.psPFViewLogicCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFViewLogicCodePublisher.clear();
            } else if (this.psPFViewLogicCodePublisher.size() > 0) {
                return this.psPFViewLogicCodePublisher.remove(0);
            }
        }
        IPSPFViewLogicCodePublisher iPSPFViewLogicCodePublisher = this.createPSPFViewLogicCodePublisher();
        iPSPFViewLogicCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFViewLogicCodePublisher;
    }

    protected IPSPFViewLogicCodePublisher createPSPFViewLogicCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFViewLogicTempl.getPUBOBJ())) {
            return (IPSPFViewLogicCodePublisher)ObjectHelper.Create((String)this.psPFViewLogicTempl.getPUBOBJ());
        }
        return new PSPFViewLogicCodePublisher2Impl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFViewLogicCodePublisher(IPSPFViewLogicCodePublisher iPSPFViewLogicCodePublisher) {
        ArrayList<IPSPFViewLogicCodePublisher> arrayList = this.psPFViewLogicCodePublisher;
        synchronized (arrayList) {
            this.psPFViewLogicCodePublisher.add(iPSPFViewLogicCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFViewLogicCodePublishers() {
        ArrayList<IPSPFViewLogicCodePublisher> arrayList = this.psPFViewLogicCodePublisher;
        synchronized (arrayList) {
            this.psPFViewLogicCodePublisher.clear();
        }
    }

    @Override
    public PSPFViewLogicTempl getPSPFViewLogicTemplData() {
        return this.psPFViewLogicTempl;
    }

    @Override
    public IPSViewLogicType getPSViewLogicType() {
        return null;
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
    public IPSPFViewLogicTemplDetail getPSPFViewLogicTemplDetail(String strName) throws Exception {
        return this.getPSPFViewLogicTemplDetail(strName, false);
    }

    @Override
    public IPSPFViewLogicTemplDetail getPSPFViewLogicTemplDetail(String strName, boolean bTryMode) throws Exception {
        IPSPFViewLogicTemplDetail iPSPFViewLogicTemplDetail = this.psPFViewLogicTemplDetailMap.get(strName);
        if (iPSPFViewLogicTemplDetail == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u903b\u8f91\u6a21\u677f[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6210\u5458[%2$s][%3$s]\u6a21\u677f", (Object)this.getName(), (Object)strName, (Object)this.getPSPFPubCode().getName()));
        }
        return iPSPFViewLogicTemplDetail;
    }

    @Override
    public IPSPFViewLogicTemplDetail getPSPFViewLogicTemplDetail2(String strName, boolean bTryMode) throws Exception {
        return this.getPSPFViewLogicTemplDetail(strName, bTryMode);
    }

    @Override
    public IPSPFViewLogicTemplDetail getPSPFViewLogicTemplDetail2(String strName) throws Exception {
        return this.getPSPFViewLogicTemplDetail(strName, false);
    }
}

