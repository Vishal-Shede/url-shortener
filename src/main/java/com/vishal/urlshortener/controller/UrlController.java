package com.vishal.urlshortener.controller;

import com.vishal.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    // 1. API to shorten long URL
    @PostMapping("/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(@RequestBody Map<String, String> request) {
        String longUrl = request.get("longUrl");

        String shortCode = urlService.createShortUrl(longUrl);

        return ResponseEntity.ok(Map.of(
                "shortUrl", "http://localhost:8080/" + shortCode
        ));
    }

    // 2. API to redirect from short URL → long URL
    @GetMapping("/{shortCode}")
    public ResponseEntity<Object> redirectToLongUrl(@PathVariable String shortCode) {
        Optional<String> longUrl = urlService.getLongUrl(shortCode);

        return longUrl
                .map(url -> ResponseEntity.status(301).location(URI.create(url)).build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
