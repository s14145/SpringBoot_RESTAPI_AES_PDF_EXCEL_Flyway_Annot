 ![GitHub repo size](https://img.shields.io/github/repo-size/s14145/SpringBoot_RESTAPI_AES_PDF_EXCEL_Flyway_Annot)
 ![GitHub last commit](https://img.shields.io/github/last-commit/s14145/SpringBoot_RESTAPI_AES_PDF_EXCEL_Flyway_Annot)
 ![GitHub followers](https://img.shields.io/github/followers/s14145?style=social)
 ![GitHub](https://img.shields.io/github/license/s14145/SpringBoot_RESTAPI_AES_PDF_EXCEL_Flyway_Annot)
 ![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/s14145/SpringBoot_RESTAPI_AES_PDF_EXCEL_Flyway_Annot)
 ![Generic badge](https://img.shields.io/badge/completion-65%25-green)

# Spring Boot REST API Using AES, PDF, EXCEL, Flyway, Custom Annotation

This application starts on port 7070.

The technologies used in this application are:

1. Spring Boot Web
2. Spring Boot Data JPA
3. Spring Boot Devtools
4. Lombok
5. Hibernate
6. H2 Database
7. Spring Boot Actuator
8. Flyway Database Migration Tool
9. Jackson Library
10. Masking PII (Personally Identifiable Information)/PCI (Payment Card Information) Data
11. Java Version 20

H2 Database URI: http://localhost:7070/h2-console

The REST endpoints exposed by this application are:

1. GET Card Details : http://localhost:7070/api/v1/cards
2. GET Card Detail : http://localhost:7070/api/v1/cards/{cardId}
3. POST Card Detail : http://localhost:7070/api/v1/cards
4. UPDATE Card Detail : http://localhost:7070/api/v1/cards/{cardId}
5. DELETE Card Detail : http://localhost:7070/api/v1/cards/{cardId}

Spring Boot Actuator Endpoints:

1. Health : http://localhost:7070/actuator/health
2. Metrics : http://localhost:7070/actuator/metrics
3. Env : http://localhost:7070/actuator/env
4. Beans : http://localhost:7070/actuator/beans
5. Threaddump : http://localhost:7070/actuator/threaddump
6. Heapdump : http://localhost:7070/actuator/threaddump

Sample REST API POST Request payload:

{

    "cardNumber": "78965435678923",
    "cvv": "200",
    "amount": 4000,
    "isActive": true
    
}

Sample REST API POST Response Payload:

{

    "cardId": 1,
    "cardNumber": "xxxxxxxxxx8923",
    "cvv": "xxx",
    "amount": 4000.0,
    "isActive": true
    
}
