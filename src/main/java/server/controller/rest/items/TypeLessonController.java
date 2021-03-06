package server.controller.rest.items;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import server.domain.items.TypeLesson;
import server.domain.security.User;
import server.repo.items.TypeLessonRepo;

import java.util.List;

@RestController
@RequestMapping("/type-lesson")
public class TypeLessonController {

    private final TypeLessonRepo typeLessonRepo;

    public TypeLessonController(TypeLessonRepo typeLessonRepo) {
        this.typeLessonRepo = typeLessonRepo;
    }

    @GetMapping()
    public List<TypeLesson> getByUser(@AuthenticationPrincipal User user) {
        return typeLessonRepo.findByUser(user);
    }

    @PostMapping()
    public TypeLesson add(@AuthenticationPrincipal User user, @RequestBody TypeLesson typeLesson) {
        typeLesson.setUser(user);
        return typeLessonRepo.save(typeLesson);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") TypeLesson typeLesson) {
        typeLessonRepo.delete(typeLesson);
    }
}
