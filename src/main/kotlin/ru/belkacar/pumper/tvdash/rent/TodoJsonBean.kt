package ru.belkacar.pumper.tvdash.rent

data class GetTodoResponse(
    val appVersion: String,
    val `data`: List<HabTask>,
    val success: Boolean
){

    data class HabTask(
        val id: String,
        val text: String,


        val _id: String,
        val attribute: String,
        val byHabitica: Boolean,
        val checklist: List<Any>,
        val collapseChecklist: Boolean,
        val createdAt: String,
        val notes: String?,
        val priority: Double,
        val reminders: List<Any>,
        val tags: List<Any>,
        val updatedAt: String,
        val userId: String,
        val value: Double
    )

}
