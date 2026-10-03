/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.orguserlevel.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="e6c870c62a861cfd5593212fa41d6f88",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="9EEB916C-70EB-4590-B9EA-236FAF5B5694",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class OrgUserLevelDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgUserLevelDefaultDSModelBase() {
        super();

        this.initAnnotation(OrgUserLevelDefaultDSModelBase.class);
    }




}