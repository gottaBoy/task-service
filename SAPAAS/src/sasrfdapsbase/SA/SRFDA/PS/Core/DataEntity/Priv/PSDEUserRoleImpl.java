/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Priv;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPrivRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRoleOPPriv;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import SA.SRFDA.PS.Data.PSDEUserRole;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEUserRoleImpl
extends PSDataEntityObjectImpl
implements IPSDEUserRole,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEUserRoleImpl.class);
    protected PSDEUserRole psDEUserRole;
    private String strRoleTag = null;
    private boolean bEnableOrgDR = false;
    private boolean bEnableSecDR = false;
    private boolean bEnableSecBC = false;
    private long nOrgDR = 0L;
    private long nSecDR = 0L;
    private String strSecBC = "";
    private boolean bEnableUserDR = false;
    private String strUserDRAction = "READ";
    private String strCustomDRModeParam = "";
    private String strCustomDRMode2Param = "";
    private IPSSysUserDR iPSSysUserDR = null;
    private IPSSysUserDR iPSSysUserDR2 = null;
    private List<IPSDEOPPriv> psDEOPPrivList = null;
    private List<IPSDEUserRoleOPPriv> psDEUserRoleOPPrivList = null;
    private boolean bDefaultMode = false;
    private IPSDEDataSet iPSDEDataSet = null;
    private boolean bSystemReserved = false;
    private boolean bAllDataMode = false;
    private IPSDEFGroup iPSDEFGroup = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEUserRole psDEUserRole) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEUserRole = psDEUserRole;
            this.setId(psDEUserRole.getPSDEUSERROLEID());
            this.setName(psDEUserRole.getPSDEUSERROLENAME());
            this.setPSObjectData(this.psDEUserRole);
            this.strRoleTag = this.psDEUserRole.getUSERROLETAG();
            if (!this.psDEUserRole.isENABLEORGDRNull()) {
                this.bEnableOrgDR = this.psDEUserRole.getENABLEORGDR();
                if (this.bEnableOrgDR) {
                    this.nOrgDR = this.psDEUserRole.getORGDR();
                }
            }
            if (!this.psDEUserRole.isENABLESECDRNull()) {
                this.bEnableSecDR = this.psDEUserRole.getENABLESECDR();
                if (this.bEnableSecDR) {
                    this.nSecDR = this.psDEUserRole.getSECDR();
                }
            }
            if (!this.psDEUserRole.isENABLESECBCNull()) {
                this.bEnableSecBC = this.psDEUserRole.getENABLESECBC();
                if (this.bEnableSecBC) {
                    this.strSecBC = this.psDEUserRole.getSECBC();
                }
            }
            if (!this.psDEUserRole.isENABLEUSERDRNull()) {
                this.bEnableUserDR = this.psDEUserRole.getENABLEUSERDR();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUserRole.getPSSYSUSERDRID())) {
                this.iPSSysUserDR = this.getPSSystem().getPSSysUserDR(this.psDEUserRole.getPSSYSUSERDRID());
                this.strCustomDRModeParam = this.psDEUserRole.getSYSUSERDRPARAM();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUserRole.getPSSYSUSERDRID2())) {
                this.iPSSysUserDR2 = this.getPSSystem().getPSSysUserDR(this.psDEUserRole.getPSSYSUSERDRID2());
                this.strCustomDRMode2Param = this.psDEUserRole.getSYSUSERDR2PARAM();
            }
            if (!this.psDEUserRole.isDEFAULTFLAGNull()) {
                this.bDefaultMode = this.psDEUserRole.getDEFAULTFLAG();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEUserRole.getPSDEDSID())) {
                this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDEUserRole.getPSDEDSID());
            }
            if (!this.psDEUserRole.isSYSTEMFLAGNull()) {
                this.bSystemReserved = this.psDEUserRole.getSYSTEMFLAG();
            }
            if (!this.psDEUserRole.isALLDATAFLAGNull()) {
                this.bAllDataMode = this.psDEUserRole.getALLDATAFLAG();
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
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u89d2\u8272\u6807\u8bb0", group="\u57fa\u672c", order=105, fields={"USERROLETAG"})
    public String getRoleTag() {
        return this.strRoleTag;
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getModelType() {
        return "PSDEUSERROLE";
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u673a\u6784\u6570\u636e\u8303\u56f4", ignoredumpvalues="false", fields={"ENABLEORGDR"})
    public boolean isEnableOrgDR() {
        return this.bEnableOrgDR;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u90e8\u95e8\u6570\u636e\u8303\u56f4", ignoredumpvalues="false", fields={"ENABLESECDR"})
    public boolean isEnableSecDR() {
        return this.bEnableSecDR;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u90e8\u95e8\u4e1a\u52a1\u6761\u7ebf", ignoredumpvalues="false", fields={"ENABLESECBC"})
    public boolean isEnableSecBC() {
        return this.bEnableSecBC;
    }

    @Override
    @PSModelRTMeta(description="\u673a\u6784\u6570\u636e\u8303\u56f4", codelist="ACHOrgDR", ignoredumpvalues="0", fields={"ORGDR"})
    public long getOrgDR() {
        return this.nOrgDR;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u95e8\u6570\u636e\u8303\u56f4", codelist="ACHSecDR", ignoredumpvalues="0", fields={"SECDR"})
    public long getSecDR() {
        return this.nSecDR;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u95e8\u4e1a\u52a1\u6761\u4ef6", fields={"SECBC"})
    public String getSecBC() {
        return this.strSecBC;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7528\u6237\u6570\u636e\u8303\u56f4", ignoredumpvalues="false", fields={"ENABLEUSERDR"})
    public boolean isEnableUserDR() {
        return this.bEnableUserDR;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u4f7f\u7528\u64cd\u4f5c\u6807\u8bc6")
    public String getUserDRAction() {
        return this.strUserDRAction;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f4\u6a21\u5f0f", doc="\u7b49\u540c\u8c03\u7528{@link #getPSSysUserDR}.getCustomMode()")
    public String getCustomDRMode() {
        if (this.getPSSysUserDR() != null) {
            return this.getPSSysUserDR().getCustomMode();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f4\u6a21\u5f0f2", doc="\u7b49\u540c\u8c03\u7528{@link #getPSSysUserDR2}.getCustomMode()")
    public String getCustomDRMode2() {
        if (this.getPSSysUserDR2() != null) {
            return this.getPSSysUserDR2().getCustomMode();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f4\u53c2\u6570", fields={"SYSUSERDRPARAM"})
    public String getCustomDRModeParam() {
        return this.strCustomDRModeParam;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f42\u53c2\u6570", fields={"SYSUSERDR2PARAM"})
    public String getCustomDRMode2Param() {
        return this.strCustomDRMode2Param;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u8303\u56f4\u5bf9\u8c61", dumpref=true, from="IPSSystem", fields={"PSSYSUSERDRID"})
    public IPSSysUserDR getPSSysUserDR() {
        return this.iPSSysUserDR;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u8303\u56f4\u5bf9\u8c612", dumpref=true, from="IPSSystem", fields={"PSSYSUSERDRID2"})
    public IPSSysUserDR getPSSysUserDR2() {
        return this.iPSSysUserDR2;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEOPPriv> getPSDEOPPrivs() throws Exception {
        if (this.psDEOPPrivList == null) {
            ArrayList<IPSDEOPPriv> psDEOPPrivList = new ArrayList<IPSDEOPPriv>();
            Iterator<IPSDEOPPrivRole> psDEOPPrivRoles = this.getPSDataEntity().getAllPSDEOPPrivRoles();
            if (psDEOPPrivRoles != null) {
                LinkedHashMap<String, IPSDEOPPriv> psDEOPPrivMap = new LinkedHashMap<String, IPSDEOPPriv>();
                while (psDEOPPrivRoles.hasNext()) {
                    IPSDEOPPrivRole iPSDEOPPrivRole = psDEOPPrivRoles.next();
                    if (iPSDEOPPrivRole.getPSDEUserRole() == null || iPSDEOPPrivRole.getPSDEOPPriv() == null || StringHelper.compare((String)iPSDEOPPrivRole.getPSDEUserRole().getId(), (String)this.getId(), (boolean)false) != 0 || psDEOPPrivMap.containsKey(iPSDEOPPrivRole.getPSDEOPPriv().getId())) continue;
                    psDEOPPrivList.add(iPSDEOPPrivRole.getPSDEOPPriv());
                    psDEOPPrivMap.put(iPSDEOPPrivRole.getPSDEOPPriv().getId(), iPSDEOPPrivRole.getPSDEOPPriv());
                }
            }
            if (this.psDEOPPrivList == null) {
                this.psDEOPPrivList = psDEOPPrivList;
            }
        }
        if (this.psDEOPPrivList == null || this.psDEOPPrivList.size() == 0) {
            return null;
        }
        return this.psDEOPPrivList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6388\u6743\u64cd\u4f5c\u6807\u8bc6\u96c6\u5408", child=true, group="\u57fa\u672c", order=140)
    public Iterator<IPSDEUserRoleOPPriv> getPSDEUserRoleOPPrivs() throws Exception {
        if (this.psDEUserRoleOPPrivList == null) {
            ArrayList<IPSDEUserRoleOPPriv> psDEUserRoleOPPrivList = new ArrayList<IPSDEUserRoleOPPriv>();
            Iterator<IPSDEOPPrivRole> psDEOPPrivRoles = this.getPSDataEntity().getAllPSDEOPPrivRoles();
            if (psDEOPPrivRoles != null) {
                while (psDEOPPrivRoles.hasNext()) {
                    IPSDEOPPrivRole iPSDEOPPrivRole = psDEOPPrivRoles.next();
                    if (iPSDEOPPrivRole.getPSDEUserRole() == null || iPSDEOPPrivRole.getPSDEOPPriv() == null || StringHelper.compare((String)iPSDEOPPrivRole.getPSDEUserRole().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psDEUserRoleOPPrivList.add(iPSDEOPPrivRole);
                }
            }
            if (this.psDEUserRoleOPPrivList == null) {
                this.psDEUserRoleOPPrivList = psDEUserRoleOPPrivList;
            }
        }
        if (this.psDEUserRoleOPPrivList == null || this.psDEUserRoleOPPrivList.size() == 0) {
            return null;
        }
        return this.psDEUserRoleOPPrivList.iterator();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    public String getCodeName() {
        return this.getRoleTag();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6761\u4ef6")
    public String getCustomCond() {
        return this.psDEUserRole.getCUSTOMCOND();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u89d2\u8272", ignoredumpvalues="false")
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6", dumpref=true, from="IPSDataEntity")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u4fdd\u7559", ignoredumpvalues="false")
    public boolean isSystemReserved() {
        return this.bSystemReserved;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u6570\u636e", ignoredumpvalues="false")
    public boolean isAllData() {
        return this.bAllDataMode;
    }
}

