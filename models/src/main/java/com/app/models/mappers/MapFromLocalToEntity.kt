package

/**
 * Created at Tito on 3/15/19
 *
 * Map from remote to entity use case model.
 */

interface MapFromLocalToEntity<L, E : EntityModel> {

    fun mapFromLocalToEntity(model: L): E

}