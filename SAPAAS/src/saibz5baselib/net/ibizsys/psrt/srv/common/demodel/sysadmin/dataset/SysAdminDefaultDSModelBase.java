/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.sysadmin.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="089885ec20e095e248e78d49d3153815",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="E569F918-C2CF-4BC5-8F13-60FCE083A83C",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class SysAdminDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public SysAdminDefaultDSModelBase() {
        super();

        this.initAnnotation(SysAdminDefaultDSModelBase.class);
    }




}