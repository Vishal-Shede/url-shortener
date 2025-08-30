package com.vishal.urlshortener.service;

import com.vishal.urlshortener.model.Url;
import com.vishal.urlshortener.repository.UrlRepository;
import com.vishal.urlshortener.util.Base62Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    // 1. Create a short URL
    public String createShortUrl(String longUrl) {
        // Step 1: Save long URL (initially without shortCode)
        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setShortCode(null);

        url = urlRepository.save(url);  // saves and generates auto-incremented ID

        // Step 2: Convert ID to short code using base62
        String shortCode = Base62Encoder.encode(url.getId());

        // Step 3: Save short code
        url.setShortCode(shortCode);
        urlRepository.save(url);  // update the record

        return shortCode;
    }

    // 2. Get original long URL
    public Optional<String> getLongUrl(String shortCode) {
        Optional<Url> url = urlRepository.findByShortCode(shortCode);
        return url.map(Url::getLongUrl);
    }
}
