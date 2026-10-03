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

@DEDataSet(id="FB398E8D-1228-4C95-8341-5DF7973C2128",name="CurOrg",queries= {
    @DEDataSetQuery(queryid="D0497225-1A76-456E-B856-BA3EE26806FA",queryname="CurOrg")
})

/**
 *  实体数据集合[当前组织]模型基类
 */
public abstract class OrgSectorCurOrgDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgSectorCurOrgDSModelBase() {
        super();

        this.initAnnotation(OrgSectorCurOrgDSModelBase.class);
    }




}