package com.app.models.mappers

import com.app.models.UiModel

/**
 * Created at Tito on 3/15/19
 *
 * Map from entity use case to ui model.
 */

interface MapFromEntityToUi<E, U : UiModel> {
    fun mapToUiModel(uiModel: E): U
    fun mapToUiModelList(uiModels: List<E>): List<U>
}