/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.DefaultValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.pswf.core.IWFActionContext
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFProcess
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package net.ibizsys.pswf.core;

import java.util.Iterator;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.core.IWFActionContext;
import net.ibizsys.pswf.core.IWFLinkCondModel;
import net.ibizsys.pswf.core.IWFLinkGroupCondModel;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFLinkSingleCondModel;
import net.ibizsys.pswf.core.IWFProcess;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFRouteLinkModel;

public abstract class WFProcessBase
implements IWFProcess {
    private IWFProcessModel iWFProcessModel = null;

    public void init(IWFProcessModel iWFProcessModel) throws Exception {
        this.iWFProcessModel = iWFProcessModel;
    }

    public void execute(IWFActionContext iWFActionContext) throws Exception {
        Iterator wfLinkModels = this.getWFProcessModel().getWFLinkModels();
        if (wfLinkModels != null) {
            while (wfLinkModels.hasNext()) {
                IWFLinkModel iWFLinkModel = (IWFLinkModel)wfLinkModels.next();
                if (!(iWFLinkModel instanceof IWFRouteLinkModel) || !this.testWFRouteLinkModel((IWFRouteLinkModel)iWFLinkModel, iWFActionContext)) continue;
                iWFActionContext.setCurNext(iWFLinkModel.getNext());
                break;
            }
        }
    }

    public void executeBefore(IWFActionContext iWFActionContext) throws Exception {
    }

    public void executeAfter(IWFActionContext iWFActionContext) throws Exception {
    }

    public IWFProcessModel getWFProcessModel() {
        return this.iWFProcessModel;
    }

    protected boolean testWFRouteLinkModel(IWFRouteLinkModel iWFRouteLinkModel, IWFActionContext iWFActionContext) throws Exception {
        if (iWFRouteLinkModel.isDefault()) {
            return true;
        }
        IWFLinkGroupCondModel iWFLinkGroupCondModel = iWFRouteLinkModel.getWFLinkGroupCondModel();
        return this.testWFLinkGroupCondModel(iWFLinkGroupCondModel, iWFActionContext);
    }

    protected boolean testWFLinkSingleCondModel(IWFLinkSingleCondModel iWFLinkSingleCondModel, IWFActionContext iWFActionContext) throws Exception {
        String strOP = iWFLinkSingleCondModel.getCondOP();
        Object objSrcValue = iWFActionContext.getActiveEntity().get(iWFLinkSingleCondModel.getFieldName());
        if (StringHelper.compare((String)strOP, (String)"ISNULL", (boolean)true) == 0) {
            return objSrcValue == null;
        }
        if (StringHelper.compare((String)strOP, (String)"ISNOTNULL", (boolean)true) == 0) {
            return objSrcValue != null;
        }
        int nDataType = DataTypeHelper.getObjectDataType((Object)objSrcValue);
        Object objDstValue = DefaultValueHelper.getValue((IWebContext)WebContext.getCurrent(), (String)iWFLinkSingleCondModel.getParamType(), (String)iWFLinkSingleCondModel.getParamValue(), (int)nDataType, (IDataObject)iWFActionContext.getActiveEntity());
        long nRet = DataTypeHelper.compare((int)nDataType, (Object)objSrcValue, (Object)objDstValue);
        if (StringHelper.compare((String)strOP, (String)"EQ", (boolean)true) == 0) {
            return nRet == 0L;
        }
        if (StringHelper.compare((String)strOP, (String)"NOTEQ", (boolean)true) == 0) {
            return nRet != 0L;
        }
        if (StringHelper.compare((String)strOP, (String)"GT", (boolean)true) == 0) {
            return nRet > 0L;
        }
        if (StringHelper.compare((String)strOP, (String)"GTANDEQ", (boolean)true) == 0) {
            return nRet >= 0L;
        }
        if (StringHelper.compare((String)strOP, (String)"LT", (boolean)true) == 0) {
            return nRet < 0L;
        }
        if (StringHelper.compare((String)strOP, (String)"LTANDEQ", (boolean)true) == 0) {
            return nRet <= 0L;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8868\u8fbe\u5f0f[%1$s]", (Object)strOP));
    }

    protected boolean testWFLinkGroupCondModel(IWFLinkGroupCondModel iWFLinkGroupCondModel, IWFActionContext iWFActionContext) throws Exception {
        boolean bAndMode = StringHelper.compare((String)iWFLinkGroupCondModel.getGroupOP(), (String)"AND", (boolean)true) == 0;
        Iterator<IWFLinkCondModel> wfLinkCondModels = iWFLinkGroupCondModel.getWFLinkCondModels();
        if (wfLinkCondModels == null) {
            return true;
        }
        boolean bRet = false;
        if (bAndMode) {
            bRet = true;
        }
        boolean bHasChild = false;
        while (wfLinkCondModels.hasNext()) {
            bHasChild = true;
            IWFLinkCondModel iWFLinkCondModel = wfLinkCondModels.next();
            if (iWFLinkCondModel instanceof IWFLinkGroupCondModel) {
                if (this.testWFLinkGroupCondModel((IWFLinkGroupCondModel)iWFLinkCondModel, iWFActionContext)) {
                    if (bAndMode) continue;
                    bRet = true;
                    break;
                }
                if (!bAndMode) continue;
                bRet = false;
                break;
            }
            if (!(iWFLinkCondModel instanceof IWFLinkSingleCondModel)) continue;
            if (this.testWFLinkSingleCondModel((IWFLinkSingleCondModel)iWFLinkCondModel, iWFActionContext)) {
                if (bAndMode) continue;
                bRet = true;
                break;
            }
            if (!bAndMode) continue;
            bRet = false;
            break;
        }
        if (!bHasChild) {
            bRet = true;
        }
        if (iWFLinkGroupCondModel.isNotMode()) {
            return !bRet;
        }
        return bRet;
    }
}

