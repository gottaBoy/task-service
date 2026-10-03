/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orgsector.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="094DC7A4-D4F5-495F-B721-EABF4EC3C034",name="UserOrg",queries= {
    @DEDataSetQuery(queryid="5B383DBE-5B1F-40EF-8F40-8FD4E62525A9",queryname="UserOrg")
})

/**
 *  实体数据集合[用户组织部门]模型基类
 */
public abstract class OrgSectorUserOrgDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgSectorUserOrgDSModelBase() {
        super();

        this.initAnnotation(OrgSectorUserOrgDSModelBase.class);
    }




}