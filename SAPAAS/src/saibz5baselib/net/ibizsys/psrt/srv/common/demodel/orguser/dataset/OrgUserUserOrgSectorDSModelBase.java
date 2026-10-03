/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orguser.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="740CA3CE-B8A7-4C95-9274-5F9708D5E939",name="UserOrgSector",queries= {
    @DEDataSetQuery(queryid="4B265798-E90E-4DE7-B2E7-7F577A1FEF99",queryname="UserOrgSector")
})

/**
 *  实体数据集合[用户所在部门用户]模型基类
 */
public abstract class OrgUserUserOrgSectorDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgUserUserOrgSectorDSModelBase() {
        super();

        this.initAnnotation(OrgUserUserOrgSectorDSModelBase.class);
    }




}