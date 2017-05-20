package com.quantifiedcare;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author jlouns
 */
@Service
public class SesEmailService implements EmailService {
	private final String from;
	private final AmazonSimpleEmailService client;

	@Autowired
	public SesEmailService(AWSCredentials credentials, @Value("${mail.from}") String from) {
		this.client = AmazonSimpleEmailServiceClient.builder()
			.withRegion(Regions.US_EAST_1)
			.withCredentials(new AWSStaticCredentialsProvider(credentials))
			.build();
		this.from = from;
	}

	@Override
	public void send(EmailDetails details) {
		// Construct an object to contain the recipient address.
		Destination destination = new Destination().withToAddresses(details.getTo());

		// Create the subject and body of the message.
		Content subject = new Content(details.getSubject());
		Content textBody = new Content(details.getBody());
		Body body = new Body(textBody);

		// Create a message with the specified subject and body.
		Message message = new Message()
			.withSubject(subject)
			.withBody(body);

		// Assemble the email.
		SendEmailRequest request = new SendEmailRequest()
			.withSource(from)
			.withDestination(destination)
			.withMessage(message);

		client.sendEmail(request);
	}
}
