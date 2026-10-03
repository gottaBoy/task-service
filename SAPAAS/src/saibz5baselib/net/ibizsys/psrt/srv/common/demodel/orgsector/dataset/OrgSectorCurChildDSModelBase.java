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

@DEDataSet(id="E5E5A412-51BA-44A0-AF07-6F4C28C75C2E",name="CurChild",queries= {
    @DEDataSetQuery(queryid="737DF19D-614C-4DFE-9E6A-277CFC934EF8",queryname="CurChild")
})

/**
 *  实体数据集合[当前部门子部门]模型基类
 */
public abstract class OrgSectorCurChildDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public OrgSectorCurChildDSModelBase() {
        super();

        this.initAnnotation(OrgSectorCurChildDSModelBase.class);
    }




}