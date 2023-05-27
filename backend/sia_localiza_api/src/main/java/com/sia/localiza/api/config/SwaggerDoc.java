package com.sia.localiza.api.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;

// @RestController
// @RequestMapping("/api-docs")
public class SwaggerDoc {
@GetMapping()
  public ResponseEntity<String> handle() {
    ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true); // implicit
    parseOptions.setResolveFully(true);
    final OpenAPI openAPI = new OpenAPIV3Parser().read("./docs/a.yaml", null, parseOptions);
    return ResponseEntity.ok(openAPI.toString());
  }
}
