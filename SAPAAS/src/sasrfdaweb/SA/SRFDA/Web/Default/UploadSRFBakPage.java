/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.XMLNode
 *  com.jspsmart.upload.SmartFile
 *  com.jspsmart.upload.SmartUpload
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.XMLNode;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;

public class UploadSRFBakPage
extends BaseMainPage {
    protected StringBuilderEx processInfo = new StringBuilderEx();

    protected void OnInitComponents() {
        block22: {
            super.OnInitComponents();
            try {
                XMLNode rootNode;
                String strActionMode = this.getWebContext().GetParamValue("SRFACTIONMODE");
                SmartUpload su = new SmartUpload();
                su.initialize(this.pageContext);
                su.upload();
                int nCount = su.getFiles().getCount();
                if (nCount == 0) {
                    return;
                }
                String strTempId = Helper.GenGuidEx();
                String strTempFilePath = StringHelper.Format((String)"%1$s%2$s.srfbak", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)strTempId);
                int i = 0;
                if (i < nCount) {
                    SmartFile file = su.getFiles().getFile(i);
                    file.saveAs(strTempFilePath);
                }
                if ((rootNode = XMLNode.Load((String)strTempFilePath)) == null) {
                    this.processInfo.Append("<SPAN class='sx-normaltext-red'>\u6570\u636e\u6587\u4ef6\u65e0\u6548\uff01</SPAN><BR>");
                    return;
                }
                if (rootNode.getChildNodes() == null) break block22;
                int nIndex = 0;
                for (XMLNode xmlNode : rootNode.getChildNodes()) {
                    String strCustomCall;
                    CallResult callResult;
                    IDEHelper iDEHelper;
                    block23: {
                        ++nIndex;
                        String strDEId = xmlNode.GetExtValue("SRFDEID", "");
                        if (StringHelper.IsNullOrEmpty((String)strDEId)) {
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u6ca1\u6709\u6307\u5b9a\u5bf9\u5e94\u7684\u6570\u636e\u5bf9\u8c61</SPAN><BR>", (Object)nIndex);
                            continue;
                        }
                        iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
                        if (iDEHelper == null) {
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%2$s]\u8f85\u52a9\u5bf9\u8c61</SPAN><BR>", (Object)nIndex, (Object)strDEId);
                            continue;
                        }
                        IDEDataCtrl deDataCtrl = iDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
                        if (deDataCtrl == null) {
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%2$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61</SPAN><BR>", (Object)nIndex, (Object)strDEId);
                            continue;
                        }
                        callResult = null;
                        try {
                            xmlNode.SetValue("SRFACTIONMODE", strActionMode);
                            callResult = deDataCtrl.Import(xmlNode);
                            if (callResult.IsError()) {
                                this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u5bfc\u5165\u6570\u636e\u5931\u8d25\uff1a%2$s</SPAN><BR>", (Object)nIndex, (Object)callResult.getErrorInfo());
                            }
                            break block23;
                        }
                        catch (Exception ex) {
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>\u5bfc\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff1a%2$s</SPAN><BR>", (Object)nIndex, (Object)ex.getMessage());
                        }
                        continue;
                    }
                    BaseDataEntity dataEntity = null;
                    if (callResult.getUserObject() != null && callResult.getUserObject() instanceof BaseDataEntity) {
                        dataEntity = (BaseDataEntity)callResult.getUserObject();
                    }
                    if (StringHelper.IsNullOrEmpty((String)(strCustomCall = xmlNode.GetExtValue("SRFCUSTOMCALL", "")))) {
                        String strRemoveCall = xmlNode.GetExtValue("SRFREMOVE", "");
                        if (StringHelper.Compare((String)strRemoveCall, (String)"TRUE", (boolean)true) == 0) {
                            String strKeyData = xmlNode.GetExtValue("SRFARG", "");
                            if (callResult.getRetCode() == 0) {
                                this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext'>[%2$s:%3$s]\u5220\u9664\u6570\u636e[%4$s]\u6210\u529f!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)strKeyData);
                                continue;
                            }
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>[%2$s:%3$s]\u5220\u9664\u6570\u636e[%4$s]\u5931\u8d25\uff1a%5$s!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)strKeyData, (Object)callResult.getErrorInfo());
                            continue;
                        }
                        String strSqlPatch = xmlNode.GetExtValue("SRFSQLPATCH", "");
                        if (StringHelper.Compare((String)strSqlPatch, (String)"TRUE", (boolean)true) == 0) {
                            String strPatchName = xmlNode.GetExtValue("SQLPATCHNAME", "");
                            if (callResult.getRetCode() == 0) {
                                this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext'>[%2$s:%3$s]\u6267\u884c\u6570\u636e\u5e93\u8865\u4e01[%4$s]\u6210\u529f!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)strPatchName);
                                continue;
                            }
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>[%2$s:%3$s]\u6267\u884c\u6570\u636e\u5e93\u8865\u4e01[%4$s]\u5931\u8d25\uff1a%5$s!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)strPatchName, (Object)callResult.getErrorInfo());
                            continue;
                        }
                        String strDER1NSYNC = xmlNode.GetExtValue("SRFDER1NSYNC", "");
                        if (StringHelper.Compare((String)strDER1NSYNC, (String)"TRUE", (boolean)true) == 0) {
                            String strDER1NID = xmlNode.GetExtValue("SRFDER1NID", "");
                            if (callResult.getRetCode() == 0) {
                                this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext'>[%2$s:%3$s]\u540c\u6b651:N\u5173\u7cfb\u6570\u636e[%4$s]\u6210\u529f!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)strDER1NID);
                                continue;
                            }
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>[%2$s:%3$s]\u540c\u6b651:N\u5173\u7cfb\u6570\u636e[%4$s]\u5931\u8d25\uff1a%5$s!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)strDER1NID, (Object)callResult.getErrorInfo());
                            continue;
                        }
                        if (callResult.getRetCode() == 0) {
                            this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext'>[%2$s:%3$s]\u5bfc\u5165\u6570\u636e[%4$s]\u6210\u529f!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)(dataEntity == null ? "\u672a\u77e5" : iDEHelper.GetDataInfo(dataEntity)));
                            continue;
                        }
                        this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>[%2$s:%3$s]\u5bfc\u5165\u6570\u636e[%4$s]\u5931\u8d25\uff1a%5$s!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)(dataEntity == null ? "\u672a\u77e5" : iDEHelper.GetDataInfo(dataEntity)), (Object)callResult.getErrorInfo());
                        continue;
                    }
                    if (callResult.getRetCode() == 0) {
                        this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext'>[%2$s:%3$s]\u6267\u884c\u81ea\u5b9a\u4e49\u64cd\u4f5c[%5$s](%4$s)\u6210\u529f!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)(dataEntity == null ? "\u672a\u77e5" : iDEHelper.GetDataInfo(dataEntity)), (Object)strCustomCall);
                        continue;
                    }
                    this.processInfo.Append("[%1$s] <SPAN class='sx-normaltext-red'>[%2$s:%3$s]\u6267\u884c\u81ea\u5b9a\u4e49\u64cd\u4f5c[%5$s](%4$s)\u5931\u8d25\uff1a%5$s!</SPAN><BR>", (Object)nIndex, (Object)iDEHelper.getName(), (Object)iDEHelper.getLogicName(this.getLanguage()), (Object)(dataEntity == null ? "\u672a\u77e5" : iDEHelper.GetDataInfo(dataEntity)), (Object)callResult.getErrorInfo(), (Object)strCustomCall);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getProcessInfo() {
        return this.processInfo.toString();
    }
}

