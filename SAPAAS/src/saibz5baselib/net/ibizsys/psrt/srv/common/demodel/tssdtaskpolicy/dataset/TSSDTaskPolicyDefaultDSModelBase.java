/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtaskpolicy.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="7fbddaf527849efd537411955e65800d",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="68B1EB5E-1467-484F-AFA4-0A0C1960D0C6",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class TSSDTaskPolicyDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public TSSDTaskPolicyDefaultDSModelBase() {
        super();

        this.initAnnotation(TSSDTaskPolicyDefaultDSModelBase.class);
    }




}