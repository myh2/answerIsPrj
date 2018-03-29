package net.answeris.web.controller.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 이메일 주소가 올바른 주소인지 확인하는 클래스
// 사용법 : MailAddressValidator객체.validate(email주소)
public class MailAddressValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public MailAddressValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	/**
	 * 정규표현식으로 email 검증
	 * 
	 * @param email
	 *            인증할 email주소
	 * @return true 올바른 email, false 올바르지 않은 email
	 */
	public boolean validate(final String email) {

		matcher = pattern.matcher(email);
		return matcher.matches();

	}
}