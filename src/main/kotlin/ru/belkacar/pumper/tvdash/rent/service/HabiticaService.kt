package ru.belkacar.pumper.tvdash.rent.service

import org.springframework.stereotype.Service
import ru.belkacar.pumper.tvdash.rent.GetDailyResponse
import ru.belkacar.pumper.tvdash.rent.GetHabitsResponse
import ru.belkacar.pumper.tvdash.rent.service.domain.BroTasks
import java.time.DayOfWeek
import java.time.LocalDateTime

@Service
class HabiticaService(val habiticaClient: HabiticaClient) {

    fun getTasks(): BroTasks {
        val habits = habiticaClient.getHabits()
            .let { resp ->
                resp.data.map { item ->
                    BroTasks.BroHabit(
                        item.id,
                        item.text,
                        item.completed,
                        status = habitStatus(item),
                    )
                }
            }

        val dailys = habiticaClient.getDaily()
            .let { resp ->
                resp.data
                    .filter { isToday(it) }
                    .map { item ->
                        BroTasks.BroDaily(
                            item.id,
                            item.text,
                            item.completed,
                            status = dailyStatus(item),
                        )
                    }
            }

        val todos = habiticaClient.getTodos()
            .let { resp ->
                resp.data.map { item ->
                    BroTasks.BroTodo(item.id, item.text, "&#9634;")
                }
            }

        return BroTasks(habits, dailys, todos)
    }

    private fun habitStatus(item: GetHabitsResponse.HabTask): String {
        if (item.up && item.down) {
            if ((item.counterUp ?: 0) > 0) {
                return "&#9989;" //green done
            }
            if ((item.counterDown ?: 0) > 0) {
                return "&#10060;" // red cross
            }
        }

        if (item.up) {
            if ((item.counterUp ?: 0) > 0) {
                return "&#9989;" //green done
            }
            return "&#9634;" //squar
        }

        if (item.down) {
            if ((item.counterDown ?: 0) > 0) {
                return "&#10060;" // red cross
            }
            return "&#9989;" // green done
        }

        return "&#9650;"// hui
    }

    private fun dailyStatus(item: GetDailyResponse.HabTask): String {
        return if (item.completed)
            "&#9989;" // green done
        else
            "&#9634;" //squar

    }

    private fun isToday(item: GetDailyResponse.HabTask): Boolean {
        when (item.frequency) {
            "weekly" -> {
                return when (LocalDateTime.now().dayOfWeek) {
                    DayOfWeek.MONDAY -> item.repeat.m
                    DayOfWeek.TUESDAY -> item.repeat.t
                    DayOfWeek.WEDNESDAY -> item.repeat.w
                    DayOfWeek.THURSDAY -> item.repeat.th
                    DayOfWeek.FRIDAY -> item.repeat.f
                    DayOfWeek.SATURDAY -> item.repeat.s
                    DayOfWeek.SUNDAY -> item.repeat.su
                }
            }

            "daily" -> {
                return true
            }

            else -> {
                return false
            }
        }
    }
}
