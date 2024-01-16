package ru.belkacar.pumper.tvdash.rent

data class GetHabitsResponse(
    val appVersion: String,
    val `data`: List<HabTask>,
    val success: Boolean
) {

    data class HabTask(

        val id: String,
        val text: String,
        val up: Boolean,
        val down: Boolean,
        val completed: Boolean,
        val frequency: String?,

        val _id: String,
        val attribute: String?,
        val byHabitica: Boolean,
        val counterDown: Int?,
        val counterUp: Int?,
        val createdAt: String?,
        val priority: Int?,
        val reminders: List<Any>?,
        val tags: List<Any>?,
        val updatedAt: String?,
        val userId: String,
        val value: Double?
    )
}
