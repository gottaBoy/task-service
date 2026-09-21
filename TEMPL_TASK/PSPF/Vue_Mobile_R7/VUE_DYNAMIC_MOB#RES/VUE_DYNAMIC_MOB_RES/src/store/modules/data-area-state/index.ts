import { dataAreaState } from './state';
import * as mutations from './mutations';
import * as getters from './getters';

const state = {
    ...dataAreaState
}

export default {
    namespaced: true,
    state,
    getters,
    mutations
}