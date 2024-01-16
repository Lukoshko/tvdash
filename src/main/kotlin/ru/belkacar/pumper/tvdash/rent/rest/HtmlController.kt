package ru.belkacar.pumper.tvdash.rent.rest

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import ru.belkacar.pumper.tvdash.rent.service.HabiticaService
import java.time.LocalDateTime

@Controller
class HtmlController(
    val habiticaService: HabiticaService,
) {

    @GetMapping("/")
    private fun static(model: Model): String {
        val now = LocalDateTime.now()
        model.addAttribute("date", now.toLocalDate())
        model.addAttribute("dayOfWeek", now.toLocalDate().dayOfWeek)
        model.addAttribute("time", "${now.hour}:${now.minute}")

        val tasks = habiticaService.getTasks()
        model.addAttribute("habits", tasks.habits)
        model.addAttribute("dailys", tasks.dailys)
        model.addAttribute("todos", tasks.todos)

        return "static"
    }
}
