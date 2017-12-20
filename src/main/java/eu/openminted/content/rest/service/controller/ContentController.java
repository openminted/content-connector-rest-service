package eu.openminted.content.rest.service.controller;

import eu.openminted.content.connector.ContentConnector;
import eu.openminted.content.connector.Query;
import eu.openminted.content.connector.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ContentController {

    @Autowired
    ContentConnector contentConnector;

    @RequestMapping(method = POST, value = "/search")
    public SearchResult search(@RequestBody Query query) throws IOException {

        return contentConnector.search(query);
    }

    @RequestMapping(method = GET, value = "/downloadFullText")
    public ResponseEntity<InputStreamResource> downloadFullText(@RequestParam(value = "documentId") String documentId) throws IOException {

        InputStream inputStream = contentConnector.downloadFullText(documentId);
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
        return new ResponseEntity<>(inputStreamResource, headers, HttpStatus.OK);
    }

    @RequestMapping(method = POST, value = "/fetchMetadata")
    public ResponseEntity<InputStreamResource> fetchMetadata(@RequestBody Query query) throws IOException, InterruptedException {

        InputStream inputStream = contentConnector.fetchMetadata(query);
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
        return new ResponseEntity<>(inputStreamResource, headers, HttpStatus.OK);
    }

    @RequestMapping(method = GET, value = "/getSourceName")
    public String getSourceName() {

        return contentConnector.getSourceName();
    }
}
