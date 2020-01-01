package com.app.models.mappers

import com.app.models.UiModel

/**
 * Created at Tito on 3/15/19
 *
 * Map from entity use case to ui model.
 */

interface MapFromEntityToUi<E, U : UiModel> {
    fun mapToUiModel(model: E): U
    fun mapToUiModelList(model: List<E>): List<U>
}