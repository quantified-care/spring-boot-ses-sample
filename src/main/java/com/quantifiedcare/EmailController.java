package com.quantifiedcare;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author jlouns
 */
@Controller
@RequestMapping("/email")
public class EmailController {
	private final EmailService service;

	public EmailController(EmailService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String viewForm(@ModelAttribute("details") EmailDetailsForm details) {
		return "email";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String send(@Valid @ModelAttribute("details") EmailDetailsForm details) {
		service.send(details);

		return viewForm(new EmailDetailsForm());
	}
}
