/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.demodel.IDEDataExportModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

public class DEDataExportItemModel
extends DataItemModel
implements IDEDataExportItem {
    private IDEDataExport iDEDataExport = null;
    private IDEDataExportModel iDEDataExportModel = null;
    private String strPrivilegeId = null;
    private String strCaption = null;
    private String strCapLanResTag = null;

    public void init(IDEDataExport iDEDataExport) throws Exception {
        this.setDEDataExport(iDEDataExport);
        this.onInit();
    }

    @Override
    public IDEDataExport getDEDataExport() {
        return this.iDEDataExport;
    }

    protected IDEDataExportModel getDEDataExportModel() {
        return this.iDEDataExportModel;
    }

    protected void setDEDataExport(IDEDataExport iDEDataExport) {
        this.iDEDataExport = iDEDataExport;
        if (this.iDEDataExport == null) {
            this.iDEDataExportModel = null;
        } else if (this.iDEDataExport instanceof IDEDataExportModel) {
            this.iDEDataExportModel = (IDEDataExportModel)this.iDEDataExport;
        }
    }

    @Override
    public ISystem getCurSystem(IActionContext iActionContext) throws Exception {
        return this.getDEDataExport().getDataEntity().getSystem();
    }

    @Override
    protected IDataEntityModel getDEModel() throws Exception {
        return (IDataEntityModel)this.getDEDataExport().getDataEntity();
    }

    @Override
    public String getPrivilegeId() {
        return this.strPrivilegeId;
    }

    public void setPrivilegeId(String strPrivilegeId) {
        this.strPrivilegeId = strPrivilegeId;
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    @Override
    public String getCapLanResTag() {
        return this.strCapLanResTag;
    }

    public void setCapLanResTag(String strCapLanResTag) {
        this.strCapLanResTag = strCapLanResTag;
    }

    @Override
    public String getText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
        ICodeList iCodeListModel;
        Object objValue;
        block12: {
            block11: {
                String strPrivilegeId;
                if (!bEnableItemPrivilege || StringHelper.isNullOrEmpty(strPrivilegeId = this.getPrivilegeId()) || (iWebContext.getUserPrivilegeMgr().testDEField(iWebContext, strPrivilegeId) & 1) != 0) break block11;
                return "";
            }
            try {
                objValue = this.getValue(iWebContext, object);
                iCodeListModel = null;
                if (!StringHelper.isNullOrEmpty(this.getCodeListId())) {
                    boolean bConvertCL = true;
                    if (this.getDataItemParams() != null) {
                        IDataItemParam[] iDataItemParamArray = this.getDataItemParams();
                        int n = iDataItemParamArray.length;
                        int n2 = 0;
                        while (n2 < n) {
                            IDataItemParam iDataItemParam = iDataItemParamArray[n2];
                            if (!StringHelper.isNullOrEmpty(iDataItemParam.getCodeListId())) {
                                bConvertCL = false;
                                break;
                            }
                            ++n2;
                        }
                    }
                    if (bConvertCL) {
                        iCodeListModel = (ICodeListModel)CodeListGlobal.getCodeList(this.getCodeListId());
                    }
                }
                if (objValue != null) break block12;
                if (iCodeListModel != null) {
                    return iCodeListModel.getEmptyText();
                }
                return "";
            }
            catch (Exception ex) {
                return ex.getMessage();
            }
        }
        if (iCodeListModel != null) {
            return iCodeListModel.getCodeListText(objValue.toString(), true);
        }
        return objValue.toString();
    }
}

