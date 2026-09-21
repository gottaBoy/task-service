/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.dataentity;

import net.ibizsys.model.PSException;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.entity.PSDEACMode;
import net.ibizsys.model.entity.PSDEAction;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.entity.PSDELogic;
import net.ibizsys.model.entity.PSDER;
import net.ibizsys.model.entity.PSDEUIAction;
import net.ibizsys.model.entity.PSDEUIActionGroup;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;

public class PSDataEntityException
extends PSException {
    private static final long serialVersionUID = -5795579993124268119L;
    public static final int ERROR_DEFIELDNOTFOUND = 20000;
    public static final int ERROR_DEACTIONNOTFOUND = 20001;
    public static final int ERROR_DEUIACTIONNOTFOUND = 20002;
    public static final int ERROR_DEACMODENOTFOUND = 20003;
    public static final int ERROR_DEMAPNOTFOUND = 20004;
    public static final int ERROR_DEDATASYNCNOTFOUND = 20005;
    public static final int ERROR_MAJORDERNOTFOUND = 20006;
    public static final int ERROR_MINORDERNOTFOUND = 20007;
    public static final int ERROR_DEWIZARDNOTFOUND = 20008;
    public static final int ERROR_DEWIZARDSTEPNOTFOUND = 20009;
    public static final int ERROR_DEDATAQUERYNOTFOUND = 20010;
    public static final int ERROR_DEDATASETNOTFOUND = 20011;
    public static final int ERROR_DEDATAQUERYPUBFAILED = 20012;
    public static final int ERROR_KEYFIELDNOTFOUND = 20013;
    public static final int ERROR_MAJORFIELDNOTFOUND = 20014;
    public static final int ERROR_DEDATAEXPORTNOTFOUND = 20015;
    public static final int ERROR_DEDATAIMPORTNOTFOUND = 20016;
    public static final int ERROR_DEACTIONWIZARDNOTFOUND = 20017;
    public static final int ERROR_DESERVICEAPINOTFOUND = 20018;
    public static final int ERROR_DESERVICEAPIMETHODNOTFOUND = 20019;
    public static final int ERROR_DELOGICNOTFOUND = 20020;
    public static final int ERROR_DEUAGROUPNOTFOUND = 20021;
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
                CallResult callResult = PSDataEntityException.getPSModelQueryHelper((IPSModelObject)iPSDataEntity).getPSDEField((String)objArg, psDEField);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSDataEntity.getId(), (String)psDEField.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5c5e\u6027[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEField.getPSDEFIELDNAME(), (Object)psDEField.getPSDENAME()));
                    }
                    if (psDEField.getParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSDataEntity.getFullName(), (Object)psDEField.getPSDEFIELDNAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5c5e\u6027[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEField.getPSDEFIELDNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5c5e\u6027[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20001: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEAction psDEAction = new PSDEAction();
                CallResult callResult = PSDataEntityException.getPSModelQueryHelper((IPSModelObject)iPSDataEntity).getPSDEAction((String)objArg, psDEAction);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSDataEntity.getId(), (String)psDEAction.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEAction.getPSDEACTIONNAME(), (Object)psDEAction.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEAction.getPSDEACTIONNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u884c\u4e3a[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20002: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEUIAction psDEUIAction = new PSDEUIAction();
                CallResult callResult = PSDataEntityException.getPSModelQueryHelper((IPSModelObject)iPSDataEntity).getPSDEUIAction((String)objArg, psDEUIAction);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSDataEntity.getId(), (String)psDEUIAction.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIAction.getPSDEUIACTIONNAME(), (Object)psDEUIAction.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIAction.getPSDEUIACTIONNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20003: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEACMode psDEACMode = new PSDEACMode();
                CallResult callResult = PSDataEntityException.getPSModelQueryHelper((IPSModelObject)iPSDataEntity).getPSDEACMode((String)objArg, psDEACMode);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSDataEntity.getId(), (String)psDEACMode.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEACMode.getPSDEACMODENAME(), (Object)psDEACMode.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEACMode.getPSDEACMODENAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20006: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDER psDER = new PSDER();
                CallResult callResult = PSDataEntityException.getPSModelQueryHelper((IPSModelObject)iPSDataEntity).getPSDER((String)objArg, psDER);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSDataEntity.getId(), (String)psDER.getMAJORPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4e3b\u5173\u7cfb[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME(), (Object)psDER.getMAJORPSDENAME()));
                    }
                    if (psDER.getParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e3b\u5173\u7cfb[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4e3b\u5173\u7cfb[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4e3b\u5173\u7cfb[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20007: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDER psDER = new PSDER();
                CallResult callResult = PSDataEntityException.getPSModelQueryHelper((IPSModelObject)iPSDataEntity).getPSDER((String)objArg, psDER);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSDataEntity.getId(), (String)psDER.getMINORPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4ece\u5173\u7cfb[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME(), (Object)psDER.getMINORPSDENAME()));
                    }
                    if (psDER.getParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4ece\u5173\u7cfb[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4ece\u5173\u7cfb[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDER.getPSDERNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u4ece\u5173\u7cfb[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20013: {
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e3b\u952e\u4e0d\u5b58\u5728", (Object)iPSDataEntity.getFullName()));
            }
            case 20014: {
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e3b\u5c5e\u6027\u4e0d\u5b58\u5728", (Object)iPSDataEntity.getFullName()));
            }
            case 20020: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDELogic psDELogic = new PSDELogic();
                CallResult callResult = PSDataEntityException.getPSModelQueryHelper((IPSModelObject)iPSDataEntity).getPSDELogic((String)objArg, psDELogic);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSDataEntity.getId(), (String)psDELogic.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDELogic.getPSDELOGICNAME(), (Object)psDELogic.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDELogic.getPSDELOGICNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u903b\u8f91[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
            case 20021: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDEUIActionGroup psDEUIActionGroup = new PSDEUIActionGroup();
                CallResult callResult = PSDataEntityException.getPSModelQueryHelper((IPSModelObject)iPSDataEntity).getPSDEUIActionGroup((String)objArg, psDEUIActionGroup);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSDataEntity.getId(), (String)psDEUIActionGroup.getPSDEID(), (boolean)false) != 0) {
                        return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4[%2$s]\uff0c\u9519\u8bef\u7684\u5b9e\u4f53[%3$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIActionGroup.getPSDEUAGROUPNAME(), (Object)psDEUIActionGroup.getPSDENAME()));
                    }
                    return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)psDEUIActionGroup.getPSDEUAGROUPNAME()));
                }
                return new PSDataEntityException(iPSDataEntity, nErrorCode, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4[%2$s]", (Object)iPSDataEntity.getFullName(), (Object)objArg));
            }
        }
        if (objArg != null && objArg instanceof String) {
            return new PSDataEntityException(iPSDataEntity, nErrorCode, (String)objArg);
        }
        return new PSDataEntityException(iPSDataEntity, nErrorCode, null);
    }
}

