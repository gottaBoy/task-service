/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.res.IPSSysEditorStyle
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.res;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSSysEditorStyle;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.model.res.PSSysEditorStyleImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEditorStyleGlobalModel
extends PSSystemGlobalModelBase<String, PSSysEditorStyle, IPSSysEditorStyle> {
    private static final Log log = LogFactory.getLog(PSSysEditorStyleGlobalModel.class);

    @Override
    protected void onInit() throws Exception {
        this.bEnableEmptyMap = true;
        super.onInit();
    }

    @Override
    protected PSSysEditorStyle getObject(String strPSSysEditorStyleId) {
        return null;
    }

    @Override
    protected IPSSysEditorStyle onCreateModelHelper(PSSysEditorStyle vt) throws Exception {
        PSSysEditorStyleImpl iPSSysEditorStyle = new PSSysEditorStyleImpl();
        iPSSysEditorStyle.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysEditorStyle;
    }

    @Override
    protected Boolean testObjectRenew(PSSysEditorStyle obj) {
        return false;
    }

    @Override
    protected IPSSysEditorStyle registerModel(PSSysEditorStyle vt) throws Exception {
        IPSSysEditorStyle iPSSysEditorStyle = (IPSSysEditorStyle)this.internalGetModelHelper(vt.getPSSYSEDITORSTYLEID());
        if (iPSSysEditorStyle != null) {
            return iPSSysEditorStyle;
        }
        this.setModel(vt.getPSSYSEDITORSTYLEID(), vt, null);
        iPSSysEditorStyle = (IPSSysEditorStyle)this.findModelHelper(vt.getPSSYSEDITORSTYLEID());
        return iPSSysEditorStyle;
    }

    @Override
    protected Vector<PSSysEditorStyle> getAllModels() throws Exception {
        Vector<PSSysEditorStyle> list = new Vector<PSSysEditorStyle>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysEditorStyles(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u4e91\u5e73\u53f0\u7cfb\u7edf\u5168\u90e8\u7f16\u8f91\u5668\u6837\u5f0f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysEditorStyle vt) {
        return vt.getPSSYSEDITORSTYLEID();
    }
}

