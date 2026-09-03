package Api.Constructor.Version1.dto;

import java.util.Map;

public record ErrorDto(Map<String, String> errors) {
}
