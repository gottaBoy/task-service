/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSDEFInputTipSet;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSDEFInputTipSet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFInputTipSetImpl
extends PSSystemObjectImpl
implements IPSDEFInputTipSet {
    private static final Log log = LogFactory.getLog(PSDEFInputTipSetImpl.class);
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEField uniqueTagPSDEField = null;
    private IPSDEField linkPSDEField = null;
    private IPSDEField enableClosePSDEField = null;
    private IPSDEField contentPSDEField = null;
    protected PSDEFInputTipSet psDEFInputTipSet = null;
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSDEFInputTipSet psDEFInputTipSet) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psDEFInputTipSet = psDEFInputTipSet;
            this.setId(this.psDEFInputTipSet.getPSDEFINPUTTIPSETID());
            this.setName(this.psDEFInputTipSet.getPSDEFINPUTTIPSETNAME());
            this.setPSObjectData(this.psDEFInputTipSet);
            if (!StringHelper.isNullOrEmpty((String)this.psDEFInputTipSet.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psDEFInputTipSet.getPSMODULEID());
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
    public String getModelType() {
        return "PSDEFINPUTTIPSET";
    }

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDEFInputTipSet.getPSDEID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027\u8f93\u5165\u63d0\u793a\u96c6\u6240\u5f15\u7528\u7684\u5b9e\u4f53");
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFInputTipSet.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEFInputTipSet.getPSSYSPFPLUGINID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFInputTipSet.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEFInputTipSet.getPSSYSSFPLUGINID());
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDEFInputTipSet.getPSDEID());
        this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDEFInputTipSet.getPSDEDATASETID());
        if (!StringHelper.isNullOrEmpty((String)this.psDEFInputTipSet.getUNIQUETAGPSDEFID())) {
            this.uniqueTagPSDEField = this.getPSDataEntity().getPSDEField(this.psDEFInputTipSet.getUNIQUETAGPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFInputTipSet.getLINKPSDEFID())) {
            this.linkPSDEField = this.getPSDataEntity().getPSDEField(this.psDEFInputTipSet.getLINKPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFInputTipSet.getECPSDEFID())) {
            this.enableClosePSDEField = this.getPSDataEntity().getPSDEField(this.psDEFInputTipSet.getECPSDEFID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFInputTipSet.getCONTENTPSDEFID())) {
            this.contentPSDEField = this.getPSDataEntity().getPSDEField(this.psDEFInputTipSet.getCONTENTPSDEFID());
        }
        super.onInit();
    }

    public String getDEName() {
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().getName();
        }
        return null;
    }

    public String getDEDataSetName() {
        if (this.getPSDEDataSet() != null) {
            return this.getPSDEDataSet().getName();
        }
        return null;
    }

    public String getUniqueTagField() {
        if (this.getUniqueTagPSDEField() != null) {
            return this.getUniqueTagPSDEField().getName();
        }
        return null;
    }

    public String getLinkField() {
        if (this.getLinkPSDEField() != null) {
            return this.getLinkPSDEField().getName();
        }
        return null;
    }

    public String getEnableCloseField() {
        if (this.getEnableClosePSDEField() != null) {
            return this.getEnableClosePSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5408")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0\u5c5e\u6027")
    public IPSDEField getUniqueTagPSDEField() {
        return this.uniqueTagPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u94fe\u63a5\u5c5e\u6027")
    public IPSDEField getLinkPSDEField() {
        return this.linkPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u95ed\u6807\u5fd7\u5c5e\u6027")
    public IPSDEField getEnableClosePSDEField() {
        return this.enableClosePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u5c5e\u6027")
    public IPSDEField getContentPSDEField() {
        return this.contentPSDEField;
    }

    public String getContentField() {
        if (this.getContentPSDEField() == null) {
            return null;
        }
        return this.getContentPSDEField().getName();
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
        return this.psDEFInputTipSet.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u96c6\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            if (this.getPSSystemModule().getPSSysRef() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
        }
        return this.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, ignorepf=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }
}

