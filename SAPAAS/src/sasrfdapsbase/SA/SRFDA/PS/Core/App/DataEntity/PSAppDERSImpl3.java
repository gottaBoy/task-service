/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIRS;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppDERS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSAppDERSImpl3
extends PSApplicationObjectImpl
implements IPSAppDERS,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSAppDERSImpl3.class);
    private IPSAppDataEntity majorPSAppDataEntity = null;
    private IPSAppDataEntity minorPSAppDataEntity = null;
    private IPSDERBase iPSDERBase = null;
    private int nDataRSMode = IPSAppDERS.DATARSMODE_NONE;
    private int nActionRSMode = IPSAppDERS.ACTIONRSMODE_INHERIT;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSDERBase iPSDERBase, IPSAppDataEntity majorPSAppDataEntity, IPSAppDataEntity minorPSAppDataEntity) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSDERBase = iPSDERBase;
            this.setId(this.getPSDER().getId());
            this.setName(this.getPSDER().getName());
            this.majorPSAppDataEntity = majorPSAppDataEntity;
            this.minorPSAppDataEntity = minorPSAppDataEntity;
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
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppDERS psAppDERS) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", dump=false)
    public int getOrderValue() {
        if (this.getPSDER() instanceof IPSDERCustom) {
            return ((IPSDERCustom)this.getPSDER()).getOrderValue();
        }
        if (this.getPSDER() instanceof IPSDER1N) {
            return ((IPSDER1N)this.getPSDER()).getOrderValue();
        }
        return 99999;
    }

    @Override
    public String getPPSAppDataEntityId() {
        return this.majorPSAppDataEntity.getId();
    }

    @Override
    public String getCPSAppDataEntityId() {
        return this.minorPSAppDataEntity.getId();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, group="\u57fa\u672c", order=126)
    public IPSAppDataEntity getMajorPSAppDataEntity() throws Exception {
        return this.majorPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, group="\u57fa\u672c", order=127, ignorert=3)
    public IPSAppDataEntity getMinorPSAppDataEntity() throws Exception {
        return this.minorPSAppDataEntity;
    }

    @Override
    public String getModelType() {
        return "PSAPPDERS";
    }

    @Override
    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSApplication().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getModelName() {
        try {
            return StringHelper.format((String)"%1$s-%2$s", (Object)this.getMajorPSAppDataEntity().getModelName(), (Object)this.getMinorPSAppDataEntity().getModelName());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return super.getModelName();
        }
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u9879")
    public String getParentFilter() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="1:N\u5173\u7cfb\u5bf9\u8c61")
    public IPSDER1N getPSDER1N() {
        if (this.getPSDER() instanceof IPSDER1N) {
            return (IPSDER1N)this.getPSDER();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5bf9\u8c61")
    public IPSDERBase getPSDER() {
        return this.iPSDERBase;
    }

    @Override
    @PSModelRTMeta(description="\u4e34\u65f6\u6570\u636e\u6b21\u5e8f", ignoredumpvalues="-1")
    public int getTempDataOrder() {
        if (this.getPSDER1N() != null) {
            return this.getPSDER1N().getTempDataOrder();
        }
        return -1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5b9e\u4f53\u884c\u4e3a", ignoredumpvalues="false", dump=false)
    public boolean isEnableDEAction() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7b80\u5355\u67e5\u8be2", ignoredumpvalues="false", dump=false)
    public boolean isEnableSelect() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u96c6\u5408", ignoredumpvalues="false", dump=false)
    public boolean isEnableDEDataSet() {
        return false;
    }

    @Override
    public boolean testDataRSMode(int nDataRSMode) {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5173\u7cfb\u6a21\u5f0f", codelist="DESADataRSMode")
    public int getDataRSMode() {
        return this.nDataRSMode;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u5173\u7cfb\u6a21\u5f0f", codelist="DESAActionRSMode")
    public int getActionRSMode() {
        return this.nActionRSMode;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5efa\u7acb\u5173\u8054\u8f93\u51fa", ignoredumpvalues="false")
    public boolean isEnableCreateDataRS() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u66f4\u65b0\u5173\u8054\u8f93\u51fa", ignoredumpvalues="false")
    public boolean isEnableUpdateDataRS() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u83b7\u53d6\u5173\u8054\u8f93\u51fa", ignoredumpvalues="false")
    public boolean isEnableGetDataRS() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u67e5\u8be2\u5173\u8054\u8f93\u51fa", ignoredumpvalues="false")
    public boolean isEnableSelectDataRS() {
        return false;
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSDER();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSDER().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f02", hideempty2=true)
    public String getCodeName2() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6a21\u5f0f", codelist="AppDERSMode")
    public int getRSMode() {
        return RSMODE_LOCAL;
    }

    @Override
    public boolean isEnableDynaModel() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u5173\u7cfb\u8fde\u63a5\u5c5e\u6027", dumpref=true, from="__self__", from_method="getMinorPSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getParentPSAppDEField() throws Exception {
        IPSDERCustom iPSDERCustom;
        if (this.getMinorPSAppDataEntity() == null) {
            return null;
        }
        IPSDEField pickupPSDEField = null;
        if (this.getPSDER1N() != null) {
            pickupPSDEField = this.getPSDER1N().getPSPickupDEField();
        } else if (this.getPSDER() instanceof IPSDERCustom && "DER1N".equals((iPSDERCustom = (IPSDERCustom)this.getPSDER()).getDERSubType())) {
            pickupPSDEField = iPSDERCustom.getPickupPSDEField();
        }
        if (pickupPSDEField == null) {
            return null;
        }
        return this.getMinorPSAppDataEntity().getPSAppDEField(pickupPSDEField.getName(), true);
    }

    @Override
    @PSModelRTMeta(description="\u7236\u5173\u7cfb\u8fde\u63a5\u6587\u672c\u5c5e\u6027", dumpref=true, from="__self__", from_method="getMinorPSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getParentTextPSAppDEField() throws Exception {
        IPSDERCustom iPSDERCustom;
        if (this.getMinorPSAppDataEntity() == null) {
            return null;
        }
        IPSDEField pickupTextPSDEField = null;
        if (this.getPSDER1N() != null) {
            if (this.getPSDER1N().getPSPickupDEField() != null) {
                pickupTextPSDEField = this.getPSDER1N().getPSPickupTextDEField();
            }
        } else if (this.getPSDER() instanceof IPSDERCustom && "DER1N".equals((iPSDERCustom = (IPSDERCustom)this.getPSDER()).getDERSubType())) {
            pickupTextPSDEField = iPSDERCustom.getPickupTextPSDEField();
        }
        if (pickupTextPSDEField == null) {
            return null;
        }
        return this.getMinorPSAppDataEntity().getPSAppDEField(pickupTextPSDEField.getName(), true);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u7ec4\u6a21\u5f0f", ignoredumpvalues="true", ignorert=3)
    public boolean isArray() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u540d\u79f0", ignorert=3)
    public String getMajorDEName() throws Exception {
        return this.getMajorPSAppDataEntity().getName();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u4ee3\u7801\u6807\u8bc6", ignorert=3)
    public String getMajorDECodeName() throws Exception {
        return this.getMajorPSAppDataEntity().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u540d\u79f0", ignorert=3)
    public String getMinorDEName() throws Exception {
        return this.getMinorPSAppDataEntity().getName();
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u4ee3\u7801\u6807\u8bc6", ignorert=3)
    public String getMinorDECodeName() throws Exception {
        return this.getMinorPSAppDataEntity().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u4ee3\u7801\u6807\u8bc62", ignorert=3)
    public String getMajorDECodeName2() throws Exception {
        return this.getMajorPSAppDataEntity().getCodeName2();
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5b9e\u4f53\u4e3b\u6a21\u5f0f", ignoredumpvalues="true", ignorert=3)
    public boolean isMajorDEMajor() throws Exception {
        return this.getMajorPSAppDataEntity().isMajor();
    }

    @Override
    @PSModelRTMeta(description="\u4ece\u5b9e\u4f53\u4ee3\u7801\u6807\u8bc62", ignorert=3)
    public String getMinorDECodeName2() throws Exception {
        return this.getMinorPSAppDataEntity().getCodeName2();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u7c7b\u578b", codelist="DERType")
    public String getRSType() {
        if (this.getPSDER() instanceof IPSDERCustom) {
            return ((IPSDERCustom)this.getPSDER()).getDERSubType();
        }
        return this.getPSDER().getDERType();
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u6b21\u5e8f", ignoredumpvalues="0")
    public int getRemoveOrder() {
        if (this.getPSDER() instanceof IPSDERCustom) {
            return ((IPSDERCustom)this.getPSDER()).getRemoveOrder();
        }
        if (this.getPSDER() instanceof IPSDER1N) {
            return ((IPSDER1N)this.getPSDER()).getRemoveOrder();
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u65b9\u5f0f", codelist="RemoveActionType", ignoredumpvalues="-1")
    public int getRemoveActionType() {
        if (this.getPSDER() instanceof IPSDERCustom) {
            return ((IPSDERCustom)this.getPSDER()).getRemoveActionType();
        }
        if (this.getPSDER() instanceof IPSDER1N) {
            return ((IPSDER1N)this.getPSDER()).getRemoveActionType();
        }
        return -1;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u62d2\u7edd\u6d88\u606f")
    public String getRemoveRejectMsg() {
        if (this.getPSDER() instanceof IPSDERCustom) {
            return ((IPSDERCustom)this.getPSDER()).getRemoveRejectMsg();
        }
        if (this.getPSDER() instanceof IPSDER1N) {
            return ((IPSDER1N)this.getPSDER()).getRemoveRejectMsg();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5220\u9664\u62d2\u7edd\u6d88\u606f\u8bed\u8a00\u6807\u8bb0")
    public String getRRMLanResTag() {
        if (this.getPSDER() instanceof IPSDERCustom) {
            return ((IPSDERCustom)this.getPSDER()).getRRMLanResTag();
        }
        if (this.getPSDER() instanceof IPSDER1N) {
            return ((IPSDER1N)this.getPSDER()).getRRMLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6570\u636e\u7ed3\u679c\u96c6", dumpref=true, from="__self__", from_method="getMinorPSAppDataEntityMust().getPSAppDEDataSet")
    public IPSAppDEDataSet getNestedPSAppDEDataSet() throws Exception {
        if (this.getPSDER() instanceof IPSDERCustom) {
            IPSDEDataSet nestedPSAppDEDataSet = ((IPSDERCustom)this.getPSDER()).getNestedPSDEDataSet();
            if (nestedPSAppDEDataSet != null) {
                return this.getMinorPSAppDataEntity().getPSAppDEDataSet(nestedPSAppDEDataSet, true);
            }
            return null;
        }
        if (this.getPSDER() instanceof IPSDER1N) {
            IPSDEDataSet nestedPSAppDEDataSet = ((IPSDER1N)this.getPSDER()).getNestedPSDEDataSet();
            if (nestedPSAppDEDataSet != null) {
                return this.getMinorPSAppDataEntity().getPSAppDEDataSet(nestedPSAppDEDataSet, true);
            }
            return null;
        }
        return null;
    }

    @Override
    public IPSDEServiceAPIRS getPSDEServiceAPIRS() {
        return null;
    }
}

