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

@DEDataSet(id="AEC66BA3-42AF-4C62-B8F9-8E2452D207FF",name="UserOrg",queries= {
    @DEDataSetQuery(queryid="930FE9D9-C1A7-4ECE-9D12-167D9A06D693",queryname="UserOrg")
})

/**
 *  实体数据集合[用户所在组织范围]模型基类
 */
public abstract class OrgUserUserOrgDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgUserUserOrgDSModelBase() {
        super();

        this.initAnnotation(OrgUserUserOrgDSModelBase.class);
    }




}