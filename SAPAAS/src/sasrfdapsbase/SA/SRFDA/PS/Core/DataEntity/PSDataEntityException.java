/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSException;
import SA.SRFDA.PS.Data.PSDEACMode;
import SA.SRFDA.PS.Data.PSDEAction;
import SA.SRFDA.PS.Data.PSDEActionGroup;
import SA.SRFDA.PS.Data.PSDEActionWizard;
import SA.SRFDA.PS.Data.PSDEDataExport;
import SA.SRFDA.PS.Data.PSDEDataImport;
import SA.SRFDA.PS.Data.PSDEDataSync;
import SA.SRFDA.PS.Data.PSDEFGroup;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.PS.Data.PSDEGroup;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDEMap;
import SA.SRFDA.PS.Data.PSDER;
import SA.SRFDA.PS.Data.PSDERGroup;
import SA.SRFDA.PS.Data.PSDEServiceAPI;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.PS.Data.PSDEUIActionGroup;
import SA.SRFDA.PS.Data.PSDEUserRole;
import SA.SRFDA.PS.Data.PSDEWizard;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class PSDataEntityException
extends PSException {
    private static final long serialVersionUID = -5795579993124268119L;
    public static final int ERROR_DEFIELDNOTFOUND = 20000;
    public static final int ERROR_DEACTIONNOTFOUND = 20001;
    public static final int ERROR_DEUIACTIONNOTFOUND = 20002;
    public static final int ERROR_DEUIACTIONGROUPNOTFOUND = 20003;
    public static final int ERROR_DEACMODENOTFOUND = 20004;
    public static final int ERROR_DEMAPNOTFOUND = 20005;
    public static final int ERROR_DEDATASYNCNOTFOUND = 20006;
    public static final int ERROR_MAJORDERNOTFOUND = 20007;
    public static final int ERROR_MINORDERNOTFOUND = 20008;
    public static final int ERROR_DEWIZARDNOTFOUND = 20009;
    public static final int ERROR_DEWIZARDSTEPNOTFOUND = 20010;
    public static final int ERROR_DEDATAQUERYNOTFOUND = 20011;
    public static final int ERROR_DEDATASETNOTFOUND = 20012;
    public static final int ERROR_DEDATAQUERYPUBFAILED = 20013;
    public static final int ERROR_KEYFIELDNOTFOUND = 20014;
    public static final int ERROR_MAJORFIELDNOTFOUND = 20015;
    public static final int ERROR_DEDATAEXPORTNOTFOUND = 20016;
    public static final int ERROR_DEDATAIMPORTNOTFOUND = 20017;
    public static final int ERROR_DEACTIONWIZARDNOTFOUND = 20018;
    public static final int ERROR_DESERVICEAPINOTFOUND = 20019;
    public static final int ERROR_DESERVICEAPIMETHODNOTFOUND = 20020;
    public static final int ERROR_DELOGICNOTFOUND = 20021;
    public static final int ERROR_DEUAGROUPNOTFOUND = 20022;
    public static final int ERROR_DESERVICEAPIFIELDNOTFOUND = 20023;
    public static final int ERROR_DEFGROUPNOTFOUND = 20024;
    public static final int ERROR_DEGROUPNOTFOUND = 20025;
    public static final int ERROR_DERGROUPNOTFOUND = 20026;
    public static final int ERROR_DEACTIONGROUPNOTFOUND = 20027;
    public static final int ERROR_DEUSERROLENOTFOUND = 20028;
    public static final int ERROR_DEUILOGICGROUPNOTFOUND = 20029;
    public static final int ERROR_DENOTIFYNOTFOUND = 20030;
    public static final int ERROR_DEPRINTNOTFOUND = 20031;
    private IPSDataEntity iPSDataEntity = null;

    public PSDataEntityException(IPSDataEntity iPSDataEntity, int nErrorCode, String strErrorInfo) {
        super(nErrorCode, strErrorInfo);
        this.setPSDataEntity(iPSDataEntity);
    }

    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    public static PSDataEntityException create(IPSDataEntity iPSDataEntity, int nErrorCode) throws Exception {
        return PSDataEntityException.create(iPSDataEntity, nErrorCode, null, null);
    }

    public static PSDataEntityException create(IPSDataEntity iPSDataEntity, int nErrorCode, Object objArg) throws Exception {
        return PSDataEntityException.create(iPSDataEntity, nErrorCode, objArg, null);
    }

    public static PSDataEntityException create(IPSDataEntity iPSDataEntity, int nErrorCode, Object objArg, Object objArg2) throws Exception {
        switch (nErrorCode) {
            case 20000: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEField psDEField = new PSDEField();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEField((String)objArg, psDEField);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEField.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5c5e\u6027[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEField.getPSDEFIELDNAME(), (Object)psDEField.getPSDENAME()));
                    }
                    if (psDEField.GetParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSDataEntity.getFullName(), (Object)psDEField.getPSDEFIELDNAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5c5e\u6027[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEField.getPSDEFIELDNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5c5e\u6027[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20001: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEAction psDEAction = new PSDEAction();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEAction((String)objArg, psDEAction);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEAction.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEAction.getPSDEACTIONNAME(), (Object)psDEAction.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEAction.getPSDEACTIONNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20002: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEUIAction psDEUIAction = new PSDEUIAction();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEUIAction((String)objArg, psDEUIAction);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEUIAction.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIAction.getPSDEUIACTIONNAME(), (Object)psDEUIAction.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIAction.getPSDEUIACTIONNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20003: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEUIActionGroup psDEUIActionGroup = new PSDEUIActionGroup();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEUIActionGroup((String)objArg, psDEUIActionGroup);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEUIActionGroup.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIActionGroup.getPSDEUAGROUPNAME(), (Object)psDEUIActionGroup.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIActionGroup.getPSDEUAGROUPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20004: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEACMode psDEACMode = new PSDEACMode();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEACMode((String)objArg, psDEACMode);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEACMode.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEACMode.getPSDEACMODENAME(), (Object)psDEACMode.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEACMode.getPSDEACMODENAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20005: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEMap psDEMap = new PSDEMap();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEMap((String)objArg, psDEMap);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEMap.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6620\u5c04[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEMap.getPSDEMAPNAME(), (Object)psDEMap.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6620\u5c04[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEMap.getPSDEMAPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6620\u5c04[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20006: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEDataSync psDEDataSync = new PSDEDataSync();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEDataSync((String)objArg, psDEDataSync);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEDataSync.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEDataSync.getPSDEDATASYNCNAME(), (Object)psDEDataSync.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEDataSync.getPSDEDATASYNCNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u540c\u6b65[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20007: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDER psDER = new PSDER();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDER((String)objArg, psDER);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDER.getMAJORPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4e3b\u5173\u7cfb[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME(), (Object)psDER.getMAJORPSDENAME()));
                    }
                    if (psDER.GetParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e3b\u5173\u7cfb[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4e3b\u5173\u7cfb[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4e3b\u5173\u7cfb[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20008: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDER psDER = new PSDER();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDER((String)objArg, psDER);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDER.getMINORPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4ece\u5173\u7cfb[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME(), (Object)psDER.getMINORPSDENAME()));
                    }
                    if (psDER.GetParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4ece\u5173\u7cfb[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4ece\u5173\u7cfb[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4ece\u5173\u7cfb[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20009: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEWizard psDEWizard = new PSDEWizard();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEWizard((String)objArg, psDEWizard);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEWizard.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEWizard.getPSDEWIZARDNAME(), (Object)psDEWizard.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEWizard.getPSDEWIZARDNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20016: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEDataExport psDEDataExport = new PSDEDataExport();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEDataExport((String)objArg, psDEDataExport);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEDataExport.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEDataExport.getPSDEDATAEXPNAME(), (Object)psDEDataExport.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEDataExport.getPSDEDATAEXPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20017: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEDataImport psDEDataImport = new PSDEDataImport();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEDataImport((String)objArg, psDEDataImport);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEDataImport.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u5165[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEDataImport.getPSDEDATAIMPNAME(), (Object)psDEDataImport.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u5165[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEDataImport.getPSDEDATAIMPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u5165[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20014: {
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e3b\u952e\u4e0d\u5b58\u5728", (Object)iPSDataEntity.getFullName()));
            }
            case 20015: {
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e3b\u5c5e\u6027\u4e0d\u5b58\u5728", (Object)iPSDataEntity.getFullName()));
            }
            case 20018: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEActionWizard psDEActionWizard = new PSDEActionWizard();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEActionWizard((String)objArg, psDEActionWizard);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEActionWizard.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEActionWizard.getPSDEACTIONWIZARDNAME(), (Object)psDEActionWizard.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEActionWizard.getPSDEACTIONWIZARDNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20019: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEServiceAPI psDEServiceAPI = new PSDEServiceAPI();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEServiceAPI((String)objArg, psDEServiceAPI);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEServiceAPI.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEServiceAPI.getPSDESERVICEAPINAME(), (Object)psDEServiceAPI.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEServiceAPI.getPSDESERVICEAPINAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20021: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDELogic psDELogic = new PSDELogic();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDELogic((String)objArg, psDELogic);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDELogic.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDELogic.getPSDELOGICNAME(), (Object)psDELogic.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDELogic.getPSDELOGICNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20022: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEUIActionGroup psDEUIActionGroup = new PSDEUIActionGroup();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEUIActionGroup((String)objArg, psDEUIActionGroup);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEUIActionGroup.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIActionGroup.getPSDEUAGROUPNAME(), (Object)psDEUIActionGroup.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIActionGroup.getPSDEUAGROUPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20024: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEFGroup psDEFGroup = new PSDEFGroup();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEFGroup((String)objArg, psDEFGroup);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEFGroup.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u7ec4[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEFGroup.getPSDEFGROUPNAME(), (Object)psDEFGroup.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEFGroup.getPSDEFGROUPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20025: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEGroup psDEGroup = new PSDEGroup();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEGroup((String)objArg, psDEGroup);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEGroup.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u7ec4[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEGroup.getPSDEGROUPNAME(), (Object)psDEGroup.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEGroup.getPSDEGROUPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20026: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDERGroup psDERGroup = new PSDERGroup();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDERGroup((String)objArg, psDERGroup);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDERGroup.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7ec4[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDERGroup.getPSDERGROUPNAME(), (Object)psDERGroup.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDERGroup.getPSDERGROUPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20027: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEActionGroup psDEActionGroup = new PSDEActionGroup();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEActionGroup((String)objArg, psDEActionGroup);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEActionGroup.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u7ec4[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEActionGroup.getPSDEACTIONGROUPNAME(), (Object)psDEActionGroup.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEActionGroup.getPSDEACTIONGROUPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20028: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEUserRole psDEUserRole = new PSDEUserRole();
                CallResult callResult = PSDataEntityException.getPSModelHelper(iPSDataEntity).getPSDEUserRole((String)objArg, psDEUserRole);
                if (callResult.isOk()) {
                    if (StringHelper.Compare((String)iPSDataEntity.getId(), (String)psDEUserRole.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUserRole.getPSDEUSERROLENAME(), (Object)psDEUserRole.getPSDENAME()));
                    }
                    if (psDEUserRole.GetParamIntValue("VALIDFLAG", 1) != 1) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u64cd\u4f5c\u89d2\u8272[%2$s]\u6ca1\u6709\u542f\u7528", (Object)iPSDataEntity.getFullName(), (Object)psDEUserRole.getPSDEUSERROLENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUserRole.getPSDEUSERROLENAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u64cd\u4f5c\u89d2\u8272[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
        }
        if (objArg != null && objArg instanceof String) {
            return new PSDataEntityException(iPSDataEntity, nErrorCode, (String)objArg);
        }
        return new PSDataEntityException(iPSDataEntity, nErrorCode, null);
    }
}

