package ru.belkacar.pumper.tvdash.rent

data class GetDailyResponse(
    val appVersion: String,
    val `data`: List<HabTask>,
    val success: Boolean
){

    data class HabTask(
        val _id: String,
        val attribute: String,
        val byHabitica: Boolean,
        val checklist: List<Checklist>,
        val collapseChecklist: Boolean,
        val completed: Boolean,
        val createdAt: String,
        val daysOfMonth: List<Any>,
        val everyX: Int,
        val frequency: String,
        val id: String,
        val isDue: Boolean,
        val nextDue: List<String>,
        val notes: String,
        val priority: Double,
        val reminders: List<Any>,
        val repeat: Repeat,
        val startDate: String,
        val streak: Int,
        val tags: List<String>,
        val text: String,
        val updatedAt: String,
        val userId: String,
        val value: Double,
        val weeksOfMonth: List<Any>,
        val yesterDaily: Boolean
    )
    data class Checklist(
        val completed: Boolean,
        val id: String,
        val text: String
    )

    data class Repeat(
        val f: Boolean,
        val m: Boolean,
        val s: Boolean,
        val su: Boolean,
        val t: Boolean,
        val th: Boolean,
        val w: Boolean
    )

}
