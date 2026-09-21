/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Security;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Core.Security.IPSSysUserRoleData;
import SA.SRFDA.PS.Core.Security.IPSSysUserRoleRes;
import SA.SRFDA.PS.Core.Security.PSSysUserRoleDataImpl;
import SA.SRFDA.PS.Core.Security.PSSysUserRoleResImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysUserRole;
import SA.SRFDA.PS.Data.PSSysUserRoleData;
import SA.SRFDA.PS.Data.PSSysUserRoleRes;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUserRoleImpl
extends PSSystemObjectImpl
implements IPSSysUserRole {
    private static final Log log = LogFactory.getLog(PSSysUserRoleImpl.class);
    protected PSSysUserRole psSysUserRole = null;
    private String strRoleTag = null;
    private String strRoleType = "CUSTOM";
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEField userIdPSDEField = null;
    private IPSDEField roleTagPSDEField = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private ArrayList<IPSSysUserRoleRes> psSysUserRoleResList = new ArrayList();
    private ArrayList<IPSSysUserRoleData> psSysUserRoleDataList = new ArrayList();
    private ArrayList<String> uniResTagList = new ArrayList();
    private IPSSystemModule iPSSystemModule = null;
    private String strDefaultUser = "NONE";
    private boolean bSystemReserved = false;
    private boolean bGlobalUser = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysUserRole psSysUserRole) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysUserRole = psSysUserRole;
            this.setId(this.psSysUserRole.getPSSYSOPPRIVID());
            this.setName(this.psSysUserRole.getPSSYSOPPRIVNAME());
            this.setPSObjectData(this.psSysUserRole);
            this.strRoleTag = this.psSysUserRole.getPRIVID();
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserRole.getPRIVTYPE())) {
                this.strRoleType = this.psSysUserRole.getPRIVTYPE();
            }
            if (StringHelper.compare((String)this.getRoleType(), (String)"DEDATASET", (boolean)false) == 0) {
                if (!StringHelper.isNullOrEmpty((String)this.psSysUserRole.getPSDEID())) {
                    this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysUserRole.getPSDEID());
                    if (!StringHelper.isNullOrEmpty((String)this.psSysUserRole.getPSDEDATASETID())) {
                        this.iPSDEDataSet = this.getPSDE().getPSDEDataSet(this.psSysUserRole.getPSDEDATASETID());
                    }
                    if (!StringHelper.isNullOrEmpty((String)this.psSysUserRole.getUSERIDPSDEFID())) {
                        this.userIdPSDEField = this.getPSDE().getPSDEField(this.psSysUserRole.getUSERIDPSDEFID());
                    }
                    if (!StringHelper.isNullOrEmpty((String)this.psSysUserRole.getROLETAGPSDEFID())) {
                        this.roleTagPSDEField = this.getPSDE().getPSDEField(this.psSysUserRole.getROLETAGPSDEFID());
                    }
                }
                if (this.getPSDE() == null) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u96c6\u5408\u5b9e\u4f53\u5bf9\u8c61");
                }
                if (this.getPSDEDataSet() == null) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u5bf9\u8c61");
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserRole.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysUserRole.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysUserRole.getDEFAULTMODE())) {
                this.strDefaultUser = this.psSysUserRole.getDEFAULTMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.getDefaultUser()) && ("USER".equals(this.getDefaultUser()) || "ADMIN".equals(this.getDefaultUser()))) {
                this.bSystemReserved = true;
            } else if (!this.psSysUserRole.isSYSTEMFLAGNull()) {
                this.bSystemReserved = this.psSysUserRole.getSYSTEMFLAG();
            }
            if (!StringHelper.isNullOrEmpty((String)this.getDefaultUser()) && !"NONE".equals(this.getDefaultUser())) {
                this.bGlobalUser = false;
            }
            if (!this.isSystemReserved() && !this.psSysUserRole.isGLOBALFLAGNull()) {
                this.bGlobalUser = this.psSysUserRole.getGLOBALFLAG();
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
    protected void onInit() throws Exception {
        String strPSSysSFPluginId = this.psSysUserRole.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        this.onPreparePSSysUserRoleReses();
        this.onPreparePSSysUserRoleDatas();
        super.onInit();
    }

    protected void onPreparePSSysUserRoleReses() throws Exception {
        this.psSysUserRoleResList.clear();
        this.uniResTagList.clear();
        Vector<PSSysUserRoleRes> psSysUserRoleResList = new Vector<PSSysUserRoleRes>();
        CallResult callResult = this.getPSModelHelper().getPSSysUserRoleReses(this.getId(), psSysUserRoleResList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u89d2\u8272\u7edf\u4e00\u8d44\u6e90\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysUserRoleRes psSysUserRoleRes : psSysUserRoleResList) {
            if (!psSysUserRoleRes.isVALIDFLAGNull() && !psSysUserRoleRes.getVALIDFLAG()) continue;
            PSSysUserRoleResImpl iPSSysUserRoleRes = new PSSysUserRoleResImpl();
            iPSSysUserRoleRes.init(this.getDAGlobalHelper(), this, psSysUserRoleRes);
            this.psSysUserRoleResList.add(iPSSysUserRoleRes);
            this.uniResTagList.add(iPSSysUserRoleRes.getPSSysUniRes().getResCode());
        }
    }

    protected void onPreparePSSysUserRoleDatas() throws Exception {
        this.psSysUserRoleDataList.clear();
        Vector<PSSysUserRoleData> psSysUserRoleDataList = new Vector<PSSysUserRoleData>();
        CallResult callResult = this.getPSModelHelper().getPSSysUserRoleDatas(this.getId(), psSysUserRoleDataList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u89d2\u8272\u6570\u636e\u80fd\u529b\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysUserRoleData psSysUserRoleData : psSysUserRoleDataList) {
            if (!psSysUserRoleData.isVALIDFLAGNull() && !psSysUserRoleData.getVALIDFLAG()) continue;
            PSSysUserRoleDataImpl iPSSysUserRoleData = new PSSysUserRoleDataImpl();
            iPSSysUserRoleData.init(this.getDAGlobalHelper(), this, psSysUserRoleData);
            this.psSysUserRoleDataList.add(iPSSysUserRoleData);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSUSERROLE";
    }

    @Override
    @PSModelRTMeta(description="\u89d2\u8272\u6807\u8bb0", group="\u57fa\u672c", order=106, fields={"PRIVID"})
    public String getRoleTag() {
        return this.strRoleTag;
    }

    @Override
    @PSModelRTMeta(description="\u89d2\u8272\u7c7b\u578b", codelist="SysUserRoleType", group="\u57fa\u672c", order=125, fields={"PRIVTYPE"})
    public String getRoleType() {
        return this.strRoleType;
    }

    @Override
    public IPSDataEntity getPSDE() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", dumpref=true, from="__self__", from_method="getPSDataEntityMust().getPSDEDataSet", fields={"PSDEDATASETID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bc6\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", dumpref=true, from="__self__", from_method="getPSDataEntityMust().getPSDEField", fields={"USERIDPSDEFID"})
    public IPSDEField getUserIdPSDEField() {
        return this.userIdPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u89d2\u8272\u6807\u8bb0\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", dumpref=true, from="__self__", from_method="getPSDataEntityMust().getPSDEField", fields={"ROLETAGPSDEFID"})
    public IPSDEField getRoleTagPSDEField() {
        return this.roleTagPSDEField;
    }

    @PSModelRTMeta(description="\u7edf\u4e00\u8d44\u6e90\u6807\u8bb0\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<String> getUniResTags() {
        if (this.uniResTagList.size() == 0) {
            return null;
        }
        return this.uniResTagList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7edf\u4e00\u8d44\u6e90\u96c6\u5408", child=true)
    public Iterator<IPSSysUserRoleRes> getPSSysUserRoleReses() {
        return this.psSysUserRoleResList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u80fd\u529b\u96c6\u5408", child=true)
    public Iterator<IPSSysUserRoleData> getPSSysUserRoleDatas() {
        return this.psSysUserRoleDataList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psSysUserRole.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u7528\u6237", codelist="SysRoleDefaultUser", ignoredumpvalues="NONE", fields={"DEFAULTMODE"})
    public String getDefaultUser() {
        return this.strDefaultUser;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4fdd\u7559", ignoredumpvalues="false", fields={"SYSTEMFLAG"}, doc="\u663e\u5f0f\u5b9a\u4e49\u6216\u9ed8\u8ba4\u7528\u6237{@link #getDefaultUser}\u4e3a[USER,ADMIN]")
    public boolean isSystemReserved() {
        return this.bSystemReserved;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u5c40\u89d2\u8272", ignoredumpvalues="false", fields={"GLOBALFLAG"}, doc="\u975e\u7cfb\u7edf\u4fdd\u7559\u7528\u6237{@link #isSystemReserved}\u4e14\u663e\u5f0f\u5b9a\u4e49")
    public boolean isGlobalRole() {
        return this.bGlobalUser;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }
}

