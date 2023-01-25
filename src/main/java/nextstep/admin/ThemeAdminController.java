package nextstep.admin;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import nextstep.theme.ThemeService;
import nextstep.theme.dto.ThemeRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/themes")
@RequiredArgsConstructor
public class ThemeAdminController {
    private final ThemeService themeService;

    @PostMapping
    public ResponseEntity<Void> createTheme(@RequestBody ThemeRequestDto themeRequestDto) {
        Long id = themeService.create(themeRequestDto);
        return ResponseEntity.created(URI.create("/themes/" + id))
            .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable Long id) {
        themeService.delete(id);

        return ResponseEntity.noContent()
            .build();
    }
}
