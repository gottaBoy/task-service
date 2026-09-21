/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import java.util.HashMap;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSFormDetailType;
import net.ibizsys.model.entity.PSDEFormDetail;
import net.ibizsys.model.entity.PSFormDetailType;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFormDetailTypeImpl
extends PSObjectImpl
implements IPSFormDetailType {
    protected PSFormDetailType psFormDetailType = null;
    private static final Log log = LogFactory.getLog(PSFormDetailTypeImpl.class);
    private HashMap<String, String> parentFDTypeMap = new HashMap();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSFormDetailType psFormDetailType) throws Exception {
        this.psFormDetailType = psFormDetailType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psFormDetailType.getPSFORMDETAILTYPEID());
        this.setName(psFormDetailType.getPSFORMDETAILTYPENAME());
        String strPFDTypes = this.psFormDetailType.getPFDTYPE();
        if (!StringHelper.isNullOrEmpty((String)strPFDTypes)) {
            String[] items = strPFDTypes.split("[;]");
            int i = 0;
            while (i < items.length) {
                this.parentFDTypeMap.put(items[i], "");
                ++i;
            }
        }
        this.onInit();
    }

    @Override
    public IPSDEFormDetail createPSDEFormDetail(PSDEFormDetail psDEFormDetail) throws Exception {
        String strDetailObj = this.psFormDetailType.getDETAILOBJ();
        strDetailObj = strDetailObj.replace("SA.SRFDA.PS.Core.Control.Form", "net.ibizsys.model.control.form");
        return (IPSDEFormDetail)this.getPSModelStorageContext().createObject(strDetailObj);
    }

    @Override
    public boolean isRootFDType() {
        return this.parentFDTypeMap.size() == 0;
    }

    @Override
    public boolean isSupportPFDType(String strPFDType) {
        return this.parentFDTypeMap.containsKey(strPFDType);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

