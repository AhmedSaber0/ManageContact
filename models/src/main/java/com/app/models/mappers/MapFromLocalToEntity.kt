package com.app.models.mappers

import com.app.models.EntityModel

/**
 * Created at Tito on 3/15/19
 *
 * Map from remote to entity use case model.
 */

interface MapFromLocalToEntity<L, E : EntityModel> {

    fun mapFromLocalToEntity(localModel: L): E
    fun mapFromLocalToEntity(localModels: List<L>): List<E>

}