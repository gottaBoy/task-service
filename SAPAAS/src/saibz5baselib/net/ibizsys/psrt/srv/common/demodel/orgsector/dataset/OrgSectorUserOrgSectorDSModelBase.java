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

@DEDataSet(id="EAC0B91E-2364-435A-B160-ED3D73E7AC3D",name="UserOrgSector",queries= {
    @DEDataSetQuery(queryid="483F5C10-A1FB-45CC-810F-DFBB9E379404",queryname="UserOrgSector")
})

/**
 *  实体数据集合[用户部门子部门]模型基类
 */
public abstract class OrgSectorUserOrgSectorDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgSectorUserOrgSectorDSModelBase() {
        super();

        this.initAnnotation(OrgSectorUserOrgSectorDSModelBase.class);
    }




}