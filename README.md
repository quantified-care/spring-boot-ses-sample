Spring Boot SES Sample
======

Sample application for sending email via AWS SES in a Spring Boot app.

## Instructions

Modify `application.yml` to include a valid AWS SES access key:

```yaml
ses:
  access-key: <KEY HERE>
  secret-key: <SECRET HERE>
```

Run the application:

```
./gradlew run
```

Navigate to http://localhost:8080 to test
