package net.answeris.web.controller.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// �̸��� �ּҰ� �ùٸ� �ּ����� Ȯ���ϴ� Ŭ����
// ���� : MailAddressValidator��ü.validate(email�ּ�)
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
	 * ����ǥ�������� email ����
	 * 
	 * @param email
	 *            ������ email�ּ�
	 * @return true �ùٸ� email, false �ùٸ��� ���� email
	 */
	public boolean validate(final String email) {

		matcher = pattern.matcher(email);
		return matcher.matches();

	}
}