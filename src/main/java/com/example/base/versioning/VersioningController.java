package com.example.base.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
    @GetMapping("/v1/person")
    public PersonV1 personOfFirstVersion(){
        return new PersonV1("Anuma Reddy");
    }

    @GetMapping("/v2/person")
    public PersonV2 personOfSecondVersion(){
        return new PersonV2(new Name("Anuma","Ponagandla"));
    }

    @GetMapping(path="/person", params = "version=1")
    public PersonV1 personOfFirstVersionRequestParameters(){
        return new PersonV1("Anuma Reddy");
    }

    @GetMapping(path="/person", params = "version=2")
    public PersonV2 personOfSecondVersionRequestParameters(){
        return new PersonV2(new Name("Anuma","Ponagandla"));
    }

    @GetMapping(path="/person/header", headers = "X-API-VERSION=1")
    public PersonV1 personOfFirstVersionRequestHeader(){
        return new PersonV1("Anuma Reddy");
    }

    @GetMapping(path="/person/header", headers = "X-API-VERSION=2")
    public PersonV2 personOfSecondVersionRequestHeader(){
        return new PersonV2(new Name("Anuma","Ponagandla"));
    }
    @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 personOfFirstVersionAcceptHeader(){
        return new PersonV1("Anuma Reddy");
    }
    @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 personOfSecondVersionAcceptHeader(){
        return new PersonV2(new Name("Anuma","Ponagandla"));
    }


}
