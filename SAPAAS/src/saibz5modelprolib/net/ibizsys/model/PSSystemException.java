/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSException;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSCodeList;
import net.ibizsys.model.entity.PSDataEntity;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;

public class PSSystemException
extends PSException {
    public static final int ERROR_MODULENOTFOUND = 10000;
    public static final int ERROR_CODELISTNOTFOUND = 10001;
    public static final int ERROR_DATAENTITYNOTFOUND = 10002;
    public static final int ERROR_SYSBACKSERVICENOTFOUND = 10003;
    public static final int ERROR_DERNOTFOUND = 10004;
    private IPSSystem iPSSystem = null;

    public PSSystemException(IPSSystem iPSSystem, int nErrorCode, String strErrorInfo) {
        super(nErrorCode, strErrorInfo);
        this.setPSSystem(iPSSystem);
    }

    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    protected void setPSSystem(IPSSystem iPSSystem) {
        this.iPSSystem = iPSSystem;
    }

    public static PSSystemException create(IPSSystem iPSSystem, int nErrorCode, Object objArg) throws Exception {
        return PSSystemException.create(iPSSystem, nErrorCode, objArg, null);
    }

    public static PSSystemException create(IPSSystem iPSSystem, int nErrorCode, Object objArg, Object objArg2) throws Exception {
        switch (nErrorCode) {
            case 10001: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSCodeList psCodeList = new PSCodeList();
                CallResult callResult = PSSystemException.getPSModelQueryHelper((IPSModelObject)iPSSystem).getPSCodeList((String)objArg, psCodeList);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSSystem.getId(), (String)psCodeList.getPSSYSTEMID(), (boolean)false) != 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u4ee3\u7801\u8868[%2$s]\uff0c\u9519\u8bef\u7684\u7cfb\u7edf[%3$s]", (Object)iPSSystem.getName(), (Object)psCodeList.getPSCODELISTNAME(), (Object)psCodeList.getPSSYSTEMNAME()));
                    }
                    return new PSSystemException(iPSSystem, nErrorCode, StringHelper.format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u4ee3\u7801\u8868[%2$s]", (Object)iPSSystem.getName(), (Object)psCodeList.getPSCODELISTNAME()));
                }
                return new PSSystemException(iPSSystem, nErrorCode, StringHelper.format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u4ee3\u7801\u8868[%2$s]", (Object)iPSSystem.getName(), (Object)objArg));
            }
            case 10002: {
                if (objArg == null || !(objArg instanceof String)) break;
                PSDataEntity psDataEntity = new PSDataEntity();
                CallResult callResult = PSSystemException.getPSModelQueryHelper((IPSModelObject)iPSSystem).getPSDataEntity((String)objArg, psDataEntity);
                if (callResult.isOk()) {
                    if (StringHelper.compare((String)iPSSystem.getId(), (String)psDataEntity.getPSSYSTEMID(), (boolean)false) != 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53[%2$s]\uff0c\u9519\u8bef\u7684\u7cfb\u7edf[%3$s]", (Object)iPSSystem.getName(), (Object)psDataEntity.getPSDATAENTITYNAME(), (Object)psDataEntity.getPSSYSTEMNAME()));
                    }
                    if (psDataEntity.getParamIntValue("VALIDFLAG", 1) == 0) {
                        return new PSSystemException(iPSSystem, nErrorCode, StringHelper.format((String)"\u7cfb\u7edf[%1$s]\u5b9e\u4f53[%2$s]\u6ca1\u6709\u88ab\u542f\u7528", (Object)iPSSystem.getName(), (Object)psDataEntity.getPSDATAENTITYNAME()));
                    }
                    return new PSSystemException(iPSSystem, nErrorCode, StringHelper.format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53[%2$s]", (Object)iPSSystem.getName(), (Object)psDataEntity.getPSDATAENTITYNAME()));
                }
                return new PSSystemException(iPSSystem, nErrorCode, StringHelper.format((String)"\u7cfb\u7edf[%1$s]\u4e0d\u5b58\u5728\u6307\u5b9a\u7cfb\u7edf\u5b9e\u4f53[%2$s]", (Object)iPSSystem.getName(), (Object)objArg));
            }
        }
        if (objArg != null && objArg instanceof String) {
            return new PSSystemException(iPSSystem, nErrorCode, (String)objArg);
        }
        return new PSSystemException(iPSSystem, nErrorCode, null);
    }
}

