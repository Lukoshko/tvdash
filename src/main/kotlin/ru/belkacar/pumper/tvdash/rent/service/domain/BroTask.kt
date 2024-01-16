package ru.belkacar.pumper.tvdash.rent.service.domain

data class BroTasks(
    val habits: List<BroHabit>,
    val dailys: List<BroDaily>,
    val todos: List<BroTodo>
) {
    data class BroHabit(
        val id: String,
        val text: String,
        val completed: Boolean,
        val status: String,
    )

    data class BroDaily(
        val id: String,
        val text: String,
        val completed: Boolean,
        val status: String,
    )

    data class BroTodo(
        val id: String,
        val text: String,
        val status: String,
    )

}

