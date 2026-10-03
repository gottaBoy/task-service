/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceBase
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.JIT.DAO.PSJITDAO;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import SA.SRFDA.PS.Core.JIT.Entity.PSJITEntity;
import SA.SRFDA.PS.Core.JIT.Service.IPSJITService;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;

public class PSJITService
extends ServiceBase<PSJITEntity>
implements IPSJITService<PSJITEntity> {
    private IPSJITDEModel<PSJITEntity> iPSJITDEModel = null;
    private PSJITDAO psJITDAO = null;

    public void init(IPSJITDEModel<PSJITEntity> iPSJITDEModel) throws Exception {
        this.iPSJITDEModel = iPSJITDEModel;
        this.psJITDAO = new PSJITDAO();
        this.psJITDAO.setSessionFactory(iPSJITDEModel.getPSJITSystemModel().getSessionFactory());
        this.psJITDAO.setDBDialect(iPSJITDEModel.getPSJITSystemModel().getDBDialect());
        this.psJITDAO.init(iPSJITDEModel);
    }

    public IPSJITSystemModel getPSJITSystemModel() {
        return this.iPSJITDEModel.getPSJITSystemModel();
    }

    public IPSDataEntity getPSDataEntity() {
        return this.iPSJITDEModel.getPSDataEntity();
    }

    public IDataEntityModel<PSJITEntity> getDEModel() {
        return this.iPSJITDEModel;
    }

    public IDAO getDAO() {
        return this.psJITDAO;
    }

    protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, strDataSetName, false);
        return dbFetchResult;
    }

    protected DBFetchResult onfetchDataSetTemp(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dbFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, strDataSetName, true);
        return dbFetchResult;
    }

    protected void onExecuteAction(String strAction, IEntity entity) throws Exception {
        super.onExecuteAction(strAction, entity);
    }

    protected void onFillParentInfo(PSJITEntity et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
        Iterator<IPSDERBase> psDERBases = this.getPSDataEntity().getPSDERs(false);
        while (psDERBases.hasNext()) {
            IPSDERBase iPSDERBase = psDERBases.next();
            if (StringHelper.compare((String)iPSDERBase.getDERType(), (String)"DER1N", (boolean)false) != 0 && StringHelper.compare((String)iPSDERBase.getDERType(), (String)"DER11", (boolean)false) != 0 || StringHelper.compare((String)strParentType, (String)"DER1N", (boolean)true) != 0 && StringHelper.compare((String)strParentType, (String)"SYSDER1N", (boolean)true) != 0 && StringHelper.compare((String)strParentType, (String)"DER11", (boolean)true) != 0 && StringHelper.compare((String)strParentType, (String)"SYSDER11", (boolean)true) != 0 || StringHelper.compare((String)strTypeParam, (String)iPSDERBase.getName(), (boolean)true) != 0) continue;
            IService iService = this.getPSJITSystemModel().getService(iPSDERBase.getMajorDEName(), this.getSessionFactory());
            IEntity parentEntity = iService.getDEModel().createEntity();
            parentEntity.set(iService.getDEModel().getKeyDEField().getName(), DataTypeHelper.parse((int)iService.getDEModel().getKeyDEField().getStdDataType(), (String)strParentKey));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity);
            } else {
                iService.get(parentEntity);
            }
            this.onFillParentInfo_DER1N((IPSDER1N)iPSDERBase, et, parentEntity);
            return;
        }
        super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
    }

    protected void onFillParentInfo_DER1N(IPSDER1N iPSDER1N, PSJITEntity et, IEntity parentEntity) throws Exception {
        Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            if (!iPSDEField.isLinkDEField() || StringHelper.compare((String)((IPSLinkDEField)iPSDEField).getPSDER().getId(), (String)iPSDER1N.getId(), (boolean)false) != 0) continue;
            et.set(iPSDEField.getCodeName(), parentEntity.get(((IPSLinkDEField)iPSDEField).getRelatedPSDEField().getCodeName()));
        }
        if (iPSDER1N.isEnablePDEREQ() && parentEntity.get(iPSDER1N.getMajorPPSDER1N().getCodeName()) != null) {
            String strParentKey = DataObject.getStringValue((Object)parentEntity.get(iPSDER1N.getMajorPPSDER1N().getCodeName()));
            IService iService = this.getPSJITSystemModel().getService(iPSDER1N.getMajorPPSDER1N().getMajorDEName(), this.getSessionFactory());
            IEntity parentEntity2 = iService.getDEModel().createEntity();
            parentEntity2.set(iService.getDEModel().getKeyDEField().getName(), parentEntity.get(iPSDER1N.getMajorPPSDER1N().getCodeName()));
            if (strParentKey.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(parentEntity2);
            } else {
                iService.get(parentEntity2);
            }
            this.onFillParentInfo_DER1N(iPSDER1N.getMinorPPSDER1N(), et, parentEntity2);
        }
    }

    protected boolean onFillEntityKeyValue(PSJITEntity et, boolean bTempMode) throws Exception {
        if (this.getPSDataEntity().getUnionKeyValuePSDEFields() != null) {
            StringBuilderEx sb = new StringBuilderEx();
            Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getUnionKeyValuePSDEFields();
            boolean bFirst = true;
            while (psDEFields.hasNext()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sb.append("||");
                }
                IPSDEField iPSDEField = psDEFields.next();
                Object objValue = et.get(iPSDEField.getCodeName().toUpperCase());
                if (objValue == null) {
                    objValue = "__EMTPY__";
                }
                sb.append("%1$s", objValue);
            }
            String strValue = sb.toString();
            if (this.getPSDataEntity().getKeyPSDEField().isPhisicalDEField()) {
                et.set(this.getDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)strValue));
            } else {
                et.set(this.getDEModel().getKeyDEField().getName(), strValue);
            }
            return true;
        }
        return super.onFillEntityKeyValue(et, bTempMode);
    }
}
