package ru.belkacar.pumper.tvdash.rent.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import ru.belkacar.pumper.tvdash.rent.GetDailyResponse
import ru.belkacar.pumper.tvdash.rent.GetHabitsResponse
import ru.belkacar.pumper.tvdash.rent.GetTodoResponse


@Component
class HabiticaClient(
    val restTemplate: RestTemplate,
    val objectMapper: ObjectMapper,
) {

    fun getHabits(): GetHabitsResponse {
        val result = getTasks("habits")
        return objectMapper.readValue(result, GetHabitsResponse::class.java)
    }

    fun getDaily(): GetDailyResponse {
        val result = getTasks("dailys")
        return objectMapper.readValue(result, GetDailyResponse::class.java)
    }

    fun getTodos(): GetTodoResponse {
        val result = getTasks("todos")
        return objectMapper.readValue(result, GetTodoResponse::class.java)
    }

    private fun getTasks(type: String): String? {
        return restTemplate.getForObject(
            "https://habitica.com/api/v3/tasks/user?type=${type}",
            String::class.java
        )
    }



}

