/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfworklist.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="c93ef4408352303441d2f73e0e4990a2",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="D38F06FD-408B-47C3-ABA6-94899C66529C",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class WFWorkListDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public WFWorkListDefaultDSModelBase() {
        super();

        this.initAnnotation(WFWorkListDefaultDSModelBase.class);
    }




}