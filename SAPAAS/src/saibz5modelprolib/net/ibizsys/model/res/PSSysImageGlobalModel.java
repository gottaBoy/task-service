/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSSysImage;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.PSSysImageImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysImageGlobalModel
extends PSSystemGlobalModelBase<String, PSSysImage, IPSSysImage> {
    private static final Log log = LogFactory.getLog(PSSysImageGlobalModel.class);

    @Override
    protected PSSysImage getObject(String strPSSysImageId) {
        PSSysImage psSysImage = new PSSysImage();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysImage(strPSSysImageId, psSysImage);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u56fe\u7247\u8d44\u6e90[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysImageId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysImage;
    }

    @Override
    protected IPSSysImage onCreateModelHelper(PSSysImage vt) throws Exception {
        PSSysImageImpl iPSSysImage = null;
        iPSSysImage = new PSSysImageImpl();
        iPSSysImage.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysImage;
    }

    @Override
    protected Boolean testObjectRenew(PSSysImage obj) {
        return false;
    }

    @Override
    protected IPSSysImage registerModel(PSSysImage vt) throws Exception {
        IPSSysImage iIPSSysImage = (IPSSysImage)this.internalGetModelHelper(vt.getPSSYSIMAGEID());
        if (iIPSSysImage != null) {
            return iIPSSysImage;
        }
        this.setModel(vt.getPSSYSIMAGEID(), vt, null);
        return (IPSSysImage)this.findModelHelper(vt.getPSSYSIMAGEID());
    }

    @Override
    protected Vector<PSSysImage> getAllModels() throws Exception {
        Vector<PSSysImage> list = new Vector<PSSysImage>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysImages(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u56fe\u7247\u8d44\u6e90\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysImage vt) {
        return vt.getPSSYSIMAGEID();
    }
}

