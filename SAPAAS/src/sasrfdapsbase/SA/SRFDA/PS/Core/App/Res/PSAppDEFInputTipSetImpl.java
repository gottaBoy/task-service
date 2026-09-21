/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Res;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.App.Res.IPSAppDEFInputTipSet;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSDEFInputTipSet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEFInputTipSetImpl
extends PSApplicationObjectImpl
implements IPSAppDEFInputTipSet {
    private static final Log log = LogFactory.getLog(PSAppDEFInputTipSetImpl.class);
    private IPSDEFInputTipSet iPSDEFInputTipSet = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEDataSet iPSAppDEDataSet = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSDEFInputTipSet iPSDEFInputTipSet) throws Exception {
        try {
            IPSAppDEMethod iPSAppDEMethod;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSDEFInputTipSet = iPSDEFInputTipSet;
            this.setId(iPSDEFInputTipSet.getId());
            this.setName(iPSDEFInputTipSet.getName());
            if (this.getPSDataEntity() != null) {
                this.iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), true);
            }
            if (this.getPSAppDataEntity() != null && this.getPSDEDataSet() != null && (iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod(this.getPSDEDataSet(), true)) instanceof IPSAppDEDataSet) {
                this.iPSAppDEDataSet = (IPSAppDEDataSet)iPSAppDEMethod;
            }
            if (this.getPSDEFInputTipSet().getPSSysPFPlugin() != null) {
                this.iPSSysPFPlugin = this.getPSApplication().getPSSysPFPlugin(this.getPSDEFInputTipSet().getPSSysPFPlugin().getId(), "DEFINPUTTIPSET", null, null);
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.iPSXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u5b9e\u4f53\u5c5e\u6027\u8f93\u5165\u63d0\u793a", dump=false)
    public IPSDEFInputTipSet getPSDEFInputTipSet() {
        return this.iPSDEFInputTipSet;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u5408", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEDATASETID"})
    public IPSAppDEDataSet getPSAppDEDataSet() {
        return this.iPSAppDEDataSet;
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
        return this.getPSDEFInputTipSet().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getPSDataEntity() {
        return this.getPSDEFInputTipSet().getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true)
    public IPSDEDataSet getPSDEDataSet() {
        return this.getPSDEFInputTipSet().getPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", hideempty=true, outputdoc="false")
    public IPSSystemModule getPSSystemModule() {
        return this.getPSDEFInputTipSet().getPSSystemModule();
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0\u5c5e\u6027")
    public IPSDEField getUniqueTagPSDEField() {
        return this.getPSDEFInputTipSet().getUniqueTagPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u5c5e\u6027")
    public IPSDEField getLinkPSDEField() {
        return this.getPSDEFInputTipSet().getLinkPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u95ed\u6807\u5fd7\u5c5e\u6027")
    public IPSDEField getEnableClosePSDEField() {
        return this.getPSDEFInputTipSet().getEnableClosePSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5c5e\u6027")
    public IPSDEField getContentPSDEField() {
        return this.getPSDEFInputTipSet().getContentPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"UNIQUETAGPSDEFID"})
    public IPSAppDEField getUniqueTagPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getUniqueTagPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getUniqueTagPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"LINKPSDEFID"})
    public IPSAppDEField getLinkPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getLinkPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getLinkPSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u95ed\u6807\u5fd7\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"ECPSDEFID"})
    public IPSAppDEField getEnableClosePSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getEnableClosePSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getEnableClosePSDEField(), true);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty2=true, dumpref=true, from="IPSAppDataEntity", fields={"CONTENTPSDEFID"})
    public IPSAppDEField getContentPSAppDEField() throws Exception {
        if (this.getPSAppDataEntity() != null && this.getContentPSDEField() != null) {
            return this.getPSAppDataEntity().getPSAppDEField(this.getContentPSDEField(), true);
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSAPPDEFINPUTTIPSET";
    }

    @Override
    public String getModelId() {
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public String getMemo() {
        return this.getPSDEFInputTipSet().getMemo();
    }

    @Override
    public String getModelName() {
        return this.getName();
    }

    @Override
    public String getFullModelName() {
        return this.getPSDEFInputTipSet().getFullModelName();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSDEFInputTipSet psDEFInputTipSet) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSDEFInputTipSet();
    }

    @Override
    protected int onGetDynaInstMode() {
        return this.getPSDEFInputTipSet().getDynaInstMode();
    }

    @Override
    protected String onGetDynaInstTag() {
        return this.getPSDEFInputTipSet().getDynaInstTag();
    }

    @Override
    protected String onGetDynaInstTag2() {
        return this.getPSDEFInputTipSet().getDynaInstTag2();
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
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        return this.getPSDEFInputTipSet().getUniqueTag();
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        if (!StringHelper.isNullOrEmpty((String)strModelRefType)) {
            "APPLICATION".equals(strModelRefType);
        }
    }

    public String getDEName() {
        return this.getPSDEFInputTipSet().getDEName();
    }

    public String getDEDataSetName() {
        return this.getPSDEFInputTipSet().getDEDataSetName();
    }

    public String getEnableCloseField() {
        return this.getPSDEFInputTipSet().getEnableCloseField();
    }

    public String getContentField() {
        return this.getPSDEFInputTipSet().getContentField();
    }

    public String getUniqueTagField() {
        return this.getPSDEFInputTipSet().getUniqueTagField();
    }

    public String getLinkField() {
        return this.getPSDEFInputTipSet().getLinkField();
    }
}

