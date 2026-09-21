/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.codelist.ICodeItem
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.CodeList;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeItem;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPFLogicCodeObject;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSysRef;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppCodeListImpl
extends PSApplicationObjectImpl
implements IPSAppCodeList,
IPSPFLogicCodeObject {
    private static final Log log = LogFactory.getLog(PSAppCodeListImpl.class);
    private IPSCodeList iPSCodeList = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSCodeList iPSCodeList) throws Exception {
        try {
            Iterator<IPSCodeItem> psCodeItems;
            IPSAppDEMethod iPSAppDEMethod;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSCodeList = iPSCodeList;
            iPSCodeList.markSysRef(null, null);
            this.setId(iPSCodeList.getId());
            this.setName(iPSCodeList.getName());
            if (this.getPSDataEntity() != null) {
                this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), true);
            }
            if (this.getPSAppDataEntity() != null && this.getPSDEDataSet() != null && (iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod(this.getPSDEDataSet(), true)) instanceof IPSAppDEDataSet) {
                this.iPSAppDEDataSet = (IPSAppDEDataSet)iPSAppDEMethod;
            }
            if (this.getEmptyTextPSLanguageRes() != null) {
                this.getPSApplication().getPSLanguageRes(this.getEmptyTextPSLanguageRes().getId());
            }
            if (this.getPSCodeList().getPSSysPFPlugin() != null) {
                this.iPSSysPFPlugin = this.getPSApplication().getPSSysPFPlugin(this.getPSCodeList().getPSSysPFPlugin().getId(), "CODELIST", null, null);
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.iPSXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
                }
            }
            if ((psCodeItems = this.getAllPSCodeItems()) != null) {
                while (psCodeItems.hasNext()) {
                    IPSCodeItem iPSCodeItem = psCodeItems.next();
                    if (iPSCodeItem.getTextPSLanguageRes() != null) {
                        this.getPSApplication().getPSLanguageRes(iPSCodeItem.getTextPSLanguageRes().getId());
                    }
                    if (iPSCodeItem.getTooltipPSLanguageRes() == null) continue;
                    this.getPSApplication().getPSLanguageRes(iPSCodeItem.getTooltipPSLanguageRes().getId());
                }
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
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", hideempty=true, dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4ee3\u7801\u8868", dump=false)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u5408", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEDSID"})
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
    }

    @Override
    public String getPSCodeListTemplId() {
        return this.getPSCodeList().getPSCodeListTemplId();
    }

    public String getCodeListText(String strValue, boolean bRecursion) throws Exception {
        return this.getPSCodeList().getCodeListText(strValue, bRecursion);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u7c7b\u578b", codelist="CodeListType", group="\u57fa\u672c", order=125)
    public String getCodeListType() {
        return this.getPSCodeList().getCodeListType();
    }

    @Override
    public String getHandler() {
        return this.getPSCodeList().getHandler();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u8303\u56f4", ignoredumpvalues="false", ignorert=2, fields={"USERSCOPE"})
    public boolean isUserScope() {
        return this.getPSCodeList().isUserScope();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        if (this.getPSApplication().isEnableUIModelEx()) {
            return this.getPSCodeList().getCodeListTag();
        }
        return this.getPSCodeList().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getPSDataEntity() throws Exception {
        return this.getPSCodeList().getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true)
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        return this.getPSCodeList().getPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u4e3b\u72b6\u6001\u903b\u8f91\u5bf9\u8c61", hideempty=true)
    public IPSDEMSLogic getPSDEMSLogic() throws Exception {
        return this.getPSCodeList().getPSDEMSLogic();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", codelist="DynaSysMode", ignoredumpvalues="0")
    public int getDynaSysMode() {
        return this.getPSCodeList().getDynaSysMode();
    }

    @Override
    @PSModelRTMeta(description="\u591a\u9879\u4ee3\u7801\u8868\u6216\u6a21\u5f0f", hideempty2=true, codelist="CodeListOrMode", fields={"ORMODE"})
    public String getOrMode() {
        return this.getPSCodeList().getOrMode();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5206\u9694\u7b26", hideempty2=true, fields={"VALUESEPERATOR"})
    public String getValueSeparator() {
        return this.getPSCodeList().getValueSeparator();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5206\u9694\u7b26", hideempty2=true, fields={"SEPERATOR"})
    public String getTextSeparator() {
        return this.getPSCodeList().getTextSeparator();
    }

    @Override
    @PSModelRTMeta(description="\u7a7a\u767d\u663e\u793a\u6587\u672c", fields={"EMPTYTEXT"})
    public String getEmptyText() {
        return this.getPSCodeList().getEmptyText();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u9879\u503c\u4e3a\u6570\u503c", ignoredumpvalues="false", fields={"NUMBERITEM"})
    public boolean isCodeItemValueNumber() {
        return this.getPSCodeList().isCodeItemValueNumber();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u4ee3\u7801\u8868\u7c7b\u578b", codelist="PredefinedCLType", hideempty2=true, fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.getPSCodeList().getPredefinedType();
    }

    public String getGlobalId() {
        return this.getPSCodeList().getGlobalId();
    }

    public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
        return this.getPSCodeList().getCodeListText(strValue, bRecursion, activeData, iWebContext);
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u4ee3\u7801\u8868", ignoredumpvalues="false", ignorert=3)
    public boolean isSubSysCodeList() {
        return this.getPSCodeList().isSubSysCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u4ee5\u4e91\u670d\u52a1\u65b9\u5f0f\u63d0\u4f9b", ignoredumpvalues="false")
    public boolean isSubSysAsCloud() {
        return this.getPSCodeList().isSubSysAsCloud();
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        return this.getPSCodeList().getClassOrPkgName(strCodeType, iPSSysSFPub);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true, outputdoc="false")
    public IPSSystemModule getPSSystemModule() {
        return this.getPSCodeList().getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6587\u672c\u5c5e\u6027", hideempty=true)
    public IPSDEField getTextPSDEField() throws Exception {
        return this.getPSCodeList().getTextPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5c5e\u6027", hideempty=true)
    public IPSDEField getValuePSDEField() throws Exception {
        return this.getPSCodeList().getValuePSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5c5e\u6027", hideempty=true)
    public IPSDEField getDataPSDEField() throws Exception {
        return this.getPSCodeList().getDataPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u5c5e\u6027", hideempty=true)
    public IPSDEField getMinorSortPSDEField() throws Exception {
        return this.getPSCodeList().getMinorSortPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u65b9\u5411", codelist="SortDir", hideempty2=true, fields={"MINORSORTDIR"})
    public String getMinorSortDir() {
        return this.getPSCodeList().getMinorSortDir();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f\u5c5e\u6027", hideempty2=true)
    public IPSDEField getIconClsPSDEField() throws Exception {
        return this.getPSCodeList().getIconClsPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"TEXTPSDEFID"})
    public IPSAppDEField getTextPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getTextPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getTextPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"VALUEPSDEFID"})
    public IPSAppDEField getValuePSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getValuePSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getValuePSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"DATAPSDEFID"})
    public IPSAppDEField getDataPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getDataPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getDataPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"MINORSORTPSDEFID"})
    public IPSAppDEField getMinorSortPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getMinorSortPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getMinorSortPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"ICONCLSPSDEFID"})
    public IPSAppDEField getIconClsPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getIconClsPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getIconClsPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f\uff08\u500d\u6570\uff09\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"ICONCLSXPSDEFID"})
    public IPSAppDEField getIconClsXPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getIconClsPSAppDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getIconClsPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, from="IPSAppDataEntity", dumpref=true, fields={"ICONPATHPSDEFID"})
    public IPSAppDEField getIconPathPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getIconPathPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getIconPathPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84\uff08\u500d\u6570\uff09\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"ICONPATHXPSDEFID"})
    public IPSAppDEField getIconPathXPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getIconPathXPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getIconPathXPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"PVALUEPSDEFID"})
    public IPSAppDEField getPValuePSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getPValuePSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getPValuePSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7981\u7528\u6807\u5fd7\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"DISABLEPSDEFID"})
    public IPSAppDEField getDisablePSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getDisablePSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getDisablePSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84\u5c5e\u6027", hideempty2=true)
    public IPSDEField getIconPathPSDEField() throws Exception {
        return this.getPSCodeList().getIconPathPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f(x)\u5c5e\u6027", hideempty2=true)
    public IPSDEField getIconClsXPSDEField() throws Exception {
        return this.getPSCodeList().getIconClsXPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84(x)\u5c5e\u6027", hideempty2=true)
    public IPSDEField getIconPathXPSDEField() throws Exception {
        return this.getPSCodeList().getIconPathXPSDEField();
    }

    @Override
    public String getModelType() {
        return "PSAPPCODELIST";
    }

    @Override
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public boolean isUserRef() {
        return this.getPSCodeList().isUserRef();
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u88ab\u5f15\u7528", dump=false)
    public boolean getRefFlag() {
        return this.getPSCodeList().getRefFlag();
    }

    @Override
    public void markSysRef(Object objRef, String strMemo) {
        this.getPSCodeList().markSysRef(objRef, strMemo);
    }

    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e", hideempty2=true)
    public String getUserData() {
        return this.getPSCodeList().getUserData();
    }

    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e2", hideempty2=true)
    public String getUserData2() {
        return this.getPSCodeList().getUserData2();
    }

    @Override
    public String getFetchCondition() {
        return this.getPSCodeList().getFetchCondition();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u503c\u5c5e\u6027", hideempty2=true)
    public IPSDEField getPValuePSDEField() throws Exception {
        return this.getPSCodeList().getPValuePSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u7981\u7528\u503c\u5c5e\u6027", hideempty2=true)
    public IPSDEField getDisablePSDEField() throws Exception {
        return this.getPSCodeList().getDisablePSDEField();
    }

    @Override
    public int getExtendMode() {
        return this.getPSCodeList().getExtendMode();
    }

    @Override
    @PSModelRTMeta(description="\u7a7a\u767d\u663e\u793a\u6587\u672c\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        return this.getPSCodeList().getEmptyTextPSLanguageRes();
    }

    @Override
    public String getMemo() {
        return this.getPSCodeList().getMemo();
    }

    public String getIconCls() {
        return this.getPSCodeList().getIconCls();
    }

    public String getIconPathX() {
        return this.getPSCodeList().getIconPathX();
    }

    public String getIconPath(int nX) {
        return this.getPSCodeList().getIconPath(nX);
    }

    public String getIconClsX() {
        return this.getPSCodeList().getIconClsX();
    }

    public String getIconCls(int nX) {
        return this.getPSCodeList().getIconCls(nX);
    }

    public boolean isDisableSelect() {
        return this.getPSCodeList().isDisableSelect();
    }

    public String getTextLanResTag() {
        return this.getPSCodeList().getTextLanResTag();
    }

    @Override
    public boolean isEnableDynaSys() {
        return this.getPSCodeList().isEnableDynaSys();
    }

    @Override
    public String getModelName() {
        return this.getName();
    }

    @Override
    public String getFullModelName() {
        return this.getPSCodeList().getFullModelName();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        return this.getPSCodeList().getPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u522b", dump=false)
    public String getPFLogicCodeCat() {
        return this.getPSCodeList().getPFLogicCodeCat();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        return this.getPSCodeList().getPFLogicCodeType();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u5f15\u7528", hideempty=true)
    public IPSSysRef getPSSysRef() {
        return this.getPSCodeList().getPSSysRef();
    }

    @Override
    @PSModelRTMeta(description="\u6240\u5c5e\u7cfb\u7edf\u6807\u8bc6", dump=false)
    public String getSystemTag() {
        return this.getPSCodeList().getSystemTag();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u4ee3\u7801\u9879\u96c6\u5408", group="\u57fa\u672c", order=145, outputdoc="item.codeListType=='STATIC'")
    public Iterator<IPSCodeItem> getAllPSCodeItems() {
        return this.getPSCodeList().getAllPSCodeItems();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSCodeList psCodeList) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u9879\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<IPSCodeItem> getPSCodeItems() throws Exception {
        return this.getPSCodeList().getPSCodeItems();
    }

    public ICodeList getCodeList() {
        return this.getPSCodeList().getCodeList();
    }

    public ICodeItem getParentCodeItem() {
        return this.getPSCodeList().getParentCodeItem();
    }

    public Iterator<ICodeItem> getCodeItems() throws Exception {
        return this.getPSCodeList().getCodeItems();
    }

    public String getRealText() {
        return this.getPSCodeList().getRealText();
    }

    public String getText() {
        return this.getPSCodeList().getText();
    }

    public String getValue() {
        return this.getPSCodeList().getValue();
    }

    public String getColor() {
        return this.getPSCodeList().getColor();
    }

    public String getIconPath() {
        return this.getPSCodeList().getIconPath();
    }

    public String getTextCls() {
        return this.getPSCodeList().getTextCls();
    }

    public ICodeItem getCodeItemByText(String strText, boolean bRecursion) throws Exception {
        return this.getPSCodeList().getCodeItemByText(strText, bRecursion);
    }

    public ICodeItem getCodeItem(String strValue, boolean bRecursion) throws Exception {
        return this.getPSCodeList().getCodeItem(strValue, bRecursion);
    }

    public ICodeItem getCodeItemByText(String strText) throws Exception {
        return this.getPSCodeList().getCodeItemByText(strText);
    }

    public ICodeItem getCodeItem(String strValue) throws Exception {
        return this.getPSCodeList().getCodeItem(strValue);
    }

    public String getParentValue() {
        return this.getPSCodeList().getParentValue();
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return this.getPSCodeList().getPSPFPlugin();
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSCodeList();
    }

    @Override
    public String getLinkPSDEViewId() {
        return this.getPSCodeList().getLinkPSDEViewId();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7f13\u5b58", ignoredumpvalues="false", fields={"ENABLECACHE"})
    public boolean isEnableCache() {
        return this.getPSCodeList().isEnableCache();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6\u65f6\u957f", ignoredumpvalues="-1", fields={"CACHETIMEOUT"})
    public int getCacheTimeout() {
        return this.getPSCodeList().getCacheTimeout();
    }

    @Override
    protected int onGetDynaInstMode() {
        return this.getPSCodeList().getDynaInstMode();
    }

    @Override
    protected String onGetDynaInstTag() {
        return this.getPSCodeList().getDynaInstTag();
    }

    @Override
    protected String onGetDynaInstTag2() {
        return this.getPSCodeList().getDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u5757\u5b9e\u4f8b\u4ee3\u7801\u8868", ignoredumpvalues="false", ignorert=3)
    public boolean isModuleInstCodeList() {
        return this.getPSCodeList().isModuleInstCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f", codelist="DynaInstMode3")
    public int getDynaInstMode() {
        return super.getDynaInstMode();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0")
    public String getDynaInstTag() {
        return super.getDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb02")
    public String getDynaInstTag2() {
        return super.getDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6761\u4ef6", fields={"CUSTOMCOND"})
    public String getCustomCond() {
        return this.getPSCodeList().getCustomCond();
    }

    @Override
    @PSModelRTMeta(description="\u9608\u503c\u7ec4", ignoredumpvalues="false", fields={"THRESHOLDGROUPFLAG"})
    public boolean isThresholdGroup() {
        return this.getPSCodeList().isThresholdGroup();
    }

    @Override
    public IPSDEField getBeginValuePSDEField() throws Exception {
        return this.getPSCodeList().getBeginValuePSDEField();
    }

    @Override
    public IPSDEField getEndValuePSDEField() throws Exception {
        return this.getPSCodeList().getEndValuePSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u5f00\u59cb\u503c\u6a21\u5f0f", ignoredumpvalues="0", codelist="ThresholdIncValueMode", fields={"INCBEGINVALUE"})
    public int getIncBeginValueMode() {
        return this.getPSCodeList().getIncBeginValueMode();
    }

    @Override
    @PSModelRTMeta(description="\u5305\u542b\u7ed3\u675f\u503c\u6a21\u5f0f", ignoredumpvalues="0", codelist="ThresholdIncValueMode", fields={"INCENDVALUE"})
    public int getIncEndValueMode() {
        return this.getPSCodeList().getIncEndValueMode();
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"BEGINVALUEPSDEFID"})
    public IPSAppDEField getBeginValuePSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getBeginValuePSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getBeginValuePSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"ENDVALUEPSDEFID"})
    public IPSAppDEField getEndValuePSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getEndValuePSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getEndValuePSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u6807\u8bb0")
    public String getCodeListTag() {
        return this.getPSCodeList().getCodeListTag();
    }

    @Override
    public IPSDEField getClsPSDEField() throws Exception {
        return this.getPSCodeList().getClsPSDEField();
    }

    @Override
    public IPSDEField getColorPSDEField() throws Exception {
        return this.getPSCodeList().getColorPSDEField();
    }

    @Override
    public IPSDEField getBKColorPSDEField() throws Exception {
        return this.getPSCodeList().getBKColorPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u6837\u5f0f\u8868\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"CLSPSDEFID"})
    public IPSAppDEField getClsPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getClsPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getClsPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u666f\u989c\u8272\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"COLORPSDEFID"})
    public IPSAppDEField getColorPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getColorPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getColorPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u80cc\u666f\u989c\u8272\u503c\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"BKCOLORPSDEFID"})
    public IPSAppDEField getBKColorPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getBKColorPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getBKColorPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u663e\u793a\u6587\u672c", fields={"ALLTEXT"})
    public String getAllText() {
        return this.getPSCodeList().getAllText();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u663e\u793a\u6587\u672c\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getAllTextPSLanguageRes() {
        return this.getPSCodeList().getAllTextPSLanguageRes();
    }

    @Override
    protected String onGetMOSFilePath() {
        return this.getPSCodeList().getMOSFilePath();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        if (!StringHelper.isNullOrEmpty((String)strModelRefType) && "APPLICATION".equals(strModelRefType) && this.getDynaSysMode() > 0) {
            objectNode.put("dynaSysMode", this.getDynaSysMode());
        }
    }
}

