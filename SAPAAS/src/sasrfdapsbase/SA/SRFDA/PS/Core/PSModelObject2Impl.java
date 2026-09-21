/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSModelObject2;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFramework.DataEx.BaseDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSModelObject2Impl
extends PSObjectImpl
implements IPSModelObject2 {
    private String strPSSysReqItemId = null;
    private static final Log log = LogFactory.getLog(PSModelObject2Impl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.hasPSSysReqItem() && this.getPSSysReqItem() != null) {
            this.getPSSysReqItem().registerRefPSModelObject(this);
        }
    }

    @Override
    public IPSSysReqItem getPSSysReqItem() {
        return null;
    }

    @Override
    protected void setPSObjectData(BaseDataEntity baseDataEntity, boolean bCache) {
        if (baseDataEntity == null) {
            this.setPSSysReqItemId(null);
        } else {
            String strPSSysReqItemId = baseDataEntity.getParamStringValue("PSSYSREQITEMID", "");
            if (!StringHelper.isNullOrEmpty((String)strPSSysReqItemId)) {
                this.setPSSysReqItemId(strPSSysReqItemId);
            }
        }
        super.setPSObjectData(baseDataEntity, bCache);
    }

    @Override
    protected void setPSObjectData(IEntity iEntity, boolean bCache) {
        try {
            if (iEntity == null) {
                this.setPSSysReqItemId(null);
            } else {
                String strPSSysReqItemId = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSREQITEMID", (String)"");
                if (!StringHelper.isNullOrEmpty((String)strPSSysReqItemId)) {
                    this.setPSSysReqItemId(strPSSysReqItemId);
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        super.setPSObjectData(iEntity, bCache);
    }

    protected void setPSSysReqItemId(String strPSSysReqItemId) {
        this.strPSSysReqItemId = strPSSysReqItemId;
    }

    public String getPSSysReqItemId() {
        return this.strPSSysReqItemId;
    }

    protected IPSSysReqItem internalGetPSSysReqItem(String strPSSysReqItemId) throws Exception {
        throw new Exception(StringHelper.format((String)"\u6a21\u578b\u5bf9\u8c61[%1$s|%2$s]\u65e0\u6cd5\u83b7\u53d6\u9700\u6c42\u6a21\u578b\u5bf9\u8c61", (Object)this.getModelType(), (Object)this.getName()));
    }

    protected boolean hasPSSysReqItem() {
        return true;
    }
}

