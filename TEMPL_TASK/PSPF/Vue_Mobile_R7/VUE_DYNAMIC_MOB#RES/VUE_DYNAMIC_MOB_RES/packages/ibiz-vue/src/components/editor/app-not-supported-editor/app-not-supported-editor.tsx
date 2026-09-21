import { Vue, Component } from 'vue-property-decorator';
import { VueLifeCycleProcessing } from '../../../decorators';
import { EditorBase } from '../editor-base/editor-base';

/**
 *  
 *
 * @export
 * @class DataPickerEditor
 * @extends {EditorBase}
 */
@Component({})
@VueLifeCycleProcessing()
export default class AppNotSupportedEditor extends EditorBase {


    render(){
        return <div>暂不支持该编辑器</div>;
    }
}
