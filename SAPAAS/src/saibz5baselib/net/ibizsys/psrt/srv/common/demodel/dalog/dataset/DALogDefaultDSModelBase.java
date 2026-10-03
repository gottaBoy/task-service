/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.dalog.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="4f42003f518ff9e8ba0c1d582a3b70d5",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="75321108-277E-4E54-8CDD-C088F3F87263",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class DALogDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public DALogDefaultDSModelBase() {
        super();

        this.initAnnotation(DALogDefaultDSModelBase.class);
    }




}