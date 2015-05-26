package relation.util;


public class SetContactStatus {


	public String stringContactStatus;
	public Integer intContactStatus;

	/**
	 * String型のcontactStatusをInteger型に変換する
	 * @param contact
	 * @return
	 */
	public Integer changeContactStatusStrToInteger(String contact) {
		Integer contactStatus = 0;
		if (contact.equals("0")) {
			contactStatus = 0;
		} else if (contact.equals("1")) {
			contactStatus = 1;
		}
		return contactStatus;
	}

	/**
	 * String型のcontactStatusをInteger型に変換する
	 * @param contact
	 * @return
	 */
	public String replaceContactStatusIntToStr(Integer contact) {
		String strContactStatus = null;
		if (contact == 0) {
			strContactStatus = "0";
		} else if (contact == 1) {
			stringContactStatus = "1";
		}
		return strContactStatus;
	}

	/**
	 * Integer型のcontactStatusをString型に変換する
	 * @param contact
	 * @return
	 */
	public String changeContactStatusIntegerToStr(Integer contact) {
		String strContactStatus = null;
		if (contact == 0) {
			strContactStatus = "ある";
		} else if (contact == 1) {
			strContactStatus = "ない";
		}
		return strContactStatus;
	}

	/**
	 * 「0・1」を「ある・ない」に変換する
	 * @param contactStatus
	 * @return
	 */
	public String setContactSatus(Integer contactStatus) {

		if (contactStatus == 0) {
			stringContactStatus = "ある";
		} else if (contactStatus == 1) {
			stringContactStatus = "ない";
		}

		return stringContactStatus;
	}

	/**
	 * 「ある・ない」を「0・1」に変換する
	 * @param contactStatus
	 * @return
	 */
	public Integer replaceContactSatus(String contactStatus) {

		if (contactStatus.equals("ある")) {
			intContactStatus = 0;
		} else if (contactStatus.equals("ない")) {
			intContactStatus = 1;
		}

		return intContactStatus;
	}

}
