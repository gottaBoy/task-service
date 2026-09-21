/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl2;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode2;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PF.PSPFCtrlTemplDetail2Impl;
import SA.SRFDA.PS.Core.PF.PSPFStyleObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisher2Impl;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCtrlTempl2Impl
extends PSPFStyleObjectImpl
implements IPSPFCtrlTempl2 {
    protected PSPFCtrlTempl psPFCtrlTempl = null;
    private static final Log log = LogFactory.getLog(PSPFCtrlTempl2Impl.class);
    protected ArrayList<IPSPFCtrlCodePublisher> psPFCtrlCodePublisher = new ArrayList();
    private IPSControlType iPSControlType = null;
    protected HashMap<String, IPSPFCtrlTemplDetail> psPFCtrlTemplDetailMap = new HashMap();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;
    private IPSPFPubCode iPSPFPubCode = null;
    private File templFile = null;
    private String strTemplFilePath = null;
    private boolean bSubTypeTempl = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, IPSPFPubCode iPSPFPubCode, PSPFCtrlTempl psPFCtrlTempl) throws Exception {
        IPSPFPubCode2 iPSPFPubCode2;
        this.psPFCtrlTempl = psPFCtrlTempl;
        this.setPSPF(iPSPF);
        this.setPSPFStyle(iPSPFStyle);
        this.iPSPFPubCode = iPSPFPubCode;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psPFCtrlTempl.getPSPFCTRLTEMPLID());
        this.setName(this.psPFCtrlTempl.getPSPFCTRLTEMPLNAME());
        this.setPSObjectData(this.psPFCtrlTempl);
        try {
            this.iPSControlType = this.getPSModelStorage().getPSControlType(this.psPFCtrlTempl.getPSCTRLTYPEID());
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u90e8\u4ef6\u7c7b\u578b[%1$s]", (Object)this.psPFCtrlTempl.getPSCTRLTYPEID()));
        }
        this.templFile = new File(this.psPFCtrlTempl.getTEMPLCODE2());
        if (!this.templFile.exists()) {
            throw new Exception(StringHelper.Format((String)"\u6a21\u677f\u6587\u4ef6[%1$s]\u4e0d\u5b58\u5728", (Object)this.getName()));
        }
        this.psPFCtrlTempl.setTEMPLCODE2("");
        this.strTemplFilePath = this.psPFCtrlTempl.getTEMPLFILEPATH();
        String strCtrlTypeName = this.psPFCtrlTempl.getPSCTRLTYPENAME();
        if (strCtrlTypeName != null && strCtrlTypeName.indexOf("#") != -1) {
            this.bSubTypeTempl = true;
        }
        if (iPSPFStyle.getPFEngineVer() < 20 && iPSPFPubCode instanceof IPSPFPubCode2 && (iPSPFPubCode2 = (IPSPFPubCode2)iPSPFPubCode).getOriginPSPFPubCode() != null) {
            String strNewCode = StringHelper.Format((String)"<#if (ctrl.getPSSysPFPlugin()??)&&(ctrl.getPSSysPFPlugin().hasCode('%1$s','%3$s'))>${ctrl.getPSSysPFPlugin().getCode('%1$s','%3$s')}<#else>%2$s</#if>", (Object)iPSPFPubCode2.getOriginPSPFPubCode().getPluginTemplCode(), (Object)this.psPFCtrlTempl.getTEMPLCODE(), (Object)iPSPFPubCode2.getOriginPSPFPubCode().getId());
            this.psPFCtrlTempl.set("TEMPLCODE", strNewCode);
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSPFCtrlTemplDetails();
        super.onInit();
    }

    protected void onPreparePSPFCtrlTemplDetails() throws Exception {
        File[] files;
        File rootFolder = new File(((IPSPFStyle2)this.getPSPFStyle()).getRealLocalPath());
        String strTemplFilePath = this.templFile.getCanonicalPath();
        strTemplFilePath = String.valueOf(strTemplFilePath.substring(0, strTemplFilePath.length() - 4)) + "#";
        HashMap<String, PSPFCtrlTemplDetail> psPFCtrlTemplDetailMap2 = new HashMap<String, PSPFCtrlTemplDetail>();
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
                    this.psPFCtrlTempl.setTEMPLCODE2(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE3", (boolean)true) == 0) {
                    this.psPFCtrlTempl.setTEMPLCODE3(strContent);
                } else if (StringHelper.Compare((String)strTag, (String)"CODE4", (boolean)true) == 0) {
                    this.psPFCtrlTempl.setTEMPLCODE4(strContent);
                } else {
                    String[] tags;
                    PSPFCtrlTemplDetail psPFCtrlTemplDetail;
                    Properties macroParams2;
                    String strPubObj = null;
                    if (!StringHelper.IsNullOrEmpty((String)strTemplate) && !StringHelper.IsNullOrEmpty((String)(strPubObj = PropertiesHelper.getProperty((Properties)(macroParams2 = PropertiesHelper.load((String)strTemplate)), (String)"PUBOBJ", strPubObj)))) {
                        strPubObj = "SA.SRFDA.PS.Core.Pub." + strPubObj + "PublisherImpl";
                    }
                    if ((psPFCtrlTemplDetail = (PSPFCtrlTemplDetail)((Object)psPFCtrlTemplDetailMap2.get(strTag = (tags = strTag.split("[#]"))[0]))) == null) {
                        psPFCtrlTemplDetail = new PSPFCtrlTemplDetail();
                        psPFCtrlTemplDetail.setPSPFCTDETAILID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strTag));
                        psPFCtrlTemplDetail.setPSPFCTDETAILNAME(strTag);
                        psPFCtrlTemplDetailMap2.put(strTag, psPFCtrlTemplDetail);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strPubObj)) {
                        psPFCtrlTemplDetail.setPUBOBJ(strPubObj);
                    }
                    if (tags.length < 2) {
                        psPFCtrlTemplDetail.setTEMPLCODE(strContent);
                    } else if (StringHelper.Compare((String)tags[1], (String)"CODE2", (boolean)true) == 0) {
                        psPFCtrlTemplDetail.setTEMPLCODE2(strContent);
                    } else if (StringHelper.Compare((String)tags[1], (String)"CODE3", (boolean)true) == 0) {
                        psPFCtrlTemplDetail.setTEMPLCODE3(strContent);
                    } else if (StringHelper.Compare((String)tags[1], (String)"CODE4", (boolean)true) == 0) {
                        psPFCtrlTemplDetail.setTEMPLCODE4(strContent);
                    }
                }
            }
            ++n2;
        }
        for (Map.Entry entry : psPFCtrlTemplDetailMap2.entrySet()) {
            PSPFCtrlTemplDetail2Impl psPFCtrlTemplDetailImpl = new PSPFCtrlTemplDetail2Impl();
            psPFCtrlTemplDetailImpl.init(this.getDAGlobalHelper(), this, (PSPFCtrlTemplDetail)((Object)entry.getValue()));
            this.psPFCtrlTemplDetailMap.put((String)entry.getKey(), psPFCtrlTemplDetailImpl);
        }
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() throws Exception {
        return this.iPSPFPubCode;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSPFCtrlCodePublisher getPSPFCtrlCodePublisher() throws Exception {
        ArrayList<IPSPFCtrlCodePublisher> arrayList = this.psPFCtrlCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psPFCtrlCodePublisher.clear();
            } else if (this.psPFCtrlCodePublisher.size() > 0) {
                return this.psPFCtrlCodePublisher.remove(0);
            }
        }
        IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher = this.createPSPFCtrlCodePublisher();
        iPSPFCtrlCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSPFCtrlCodePublisher;
    }

    protected IPSPFCtrlCodePublisher createPSPFCtrlCodePublisher() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psPFCtrlTempl.getPUBOBJ())) {
            return (IPSPFCtrlCodePublisher)ObjectHelper.Create((String)this.psPFCtrlTempl.getPUBOBJ());
        }
        if (this.getPSPFStyle() != null && this.getPSPFStyle().getPFEngineVer() < 20) {
            return this.getPSPF().createPSPFCtrlCodePublisher();
        }
        return new PSPFCtrlCodePublisher2Impl();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSPFCtrlCodePublisher(IPSPFCtrlCodePublisher iPSPFCtrlCodePublisher) {
        ArrayList<IPSPFCtrlCodePublisher> arrayList = this.psPFCtrlCodePublisher;
        synchronized (arrayList) {
            this.psPFCtrlCodePublisher.add(iPSPFCtrlCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSPFCtrlCodePublishers() {
        ArrayList<IPSPFCtrlCodePublisher> arrayList = this.psPFCtrlCodePublisher;
        synchronized (arrayList) {
            this.psPFCtrlCodePublisher.clear();
        }
    }

    @Override
    public PSPFCtrlTempl getPSPFCtrlTemplData() {
        return this.psPFCtrlTempl;
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(String strName) throws Exception {
        return this.getPSPFCtrlTemplDetail(strName, false);
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(String strName, boolean bTryMode) throws Exception {
        IPSPFCtrlTempl iPSPFCtrlTempl;
        IPSPFCtrlTemplDetail iPSPFCtrlTemplDetail = this.psPFCtrlTemplDetailMap.get(strName);
        if (iPSPFCtrlTemplDetail == null && this.bSubTypeTempl && (iPSPFCtrlTempl = this.getPSPFStyle().getPSPFCtrlTempl(this.getPSControlType(), this.getPSPFPubCode())) != null && (iPSPFCtrlTemplDetail = iPSPFCtrlTempl.getPSPFCtrlTemplDetail(strName, true)) != null) {
            PSPFCtrlTemplDetail psPFCtrlTemplDetail = new PSPFCtrlTemplDetail();
            iPSPFCtrlTemplDetail.getPSPFCtrlTemplDetailData().CopyTo(psPFCtrlTemplDetail, false);
            psPFCtrlTemplDetail.setPSPFCTDETAILID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strName));
            psPFCtrlTemplDetail.setPSPFCTDETAILNAME(strName);
            PSPFCtrlTemplDetail2Impl psPFCtrlTemplDetailImpl = new PSPFCtrlTemplDetail2Impl();
            psPFCtrlTemplDetailImpl.init(this.getDAGlobalHelper(), this, psPFCtrlTemplDetail);
            this.psPFCtrlTemplDetailMap.put(strName, psPFCtrlTemplDetailImpl);
            iPSPFCtrlTemplDetail = psPFCtrlTemplDetailImpl;
        }
        if (iPSPFCtrlTemplDetail == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u90e8\u4ef6\u6a21\u677f[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6210\u5458[%2$s][%3$s]\u6a21\u677f", (Object)this.getName(), (Object)strName, (Object)this.getPSPFPubCode().getName()));
        }
        return iPSPFCtrlTemplDetail;
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail2(String strName, boolean bTryMode) throws Exception {
        return this.getPSPFCtrlTemplDetail(strName, bTryMode);
    }

    @Override
    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail2(String strName) throws Exception {
        return this.getPSPFCtrlTemplDetail(strName, false);
    }

    @Override
    public IPSControlType getPSControlType() {
        return this.iPSControlType;
    }

    @Override
    public String getTemplDocUrl() {
        return "http://www.ibizsys.net";
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, IPSPFStyle iPSPFStyle, PSPFCtrlTempl psPFCtrlTempl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getTemplFilePath() {
        return this.strTemplFilePath;
    }
}

