package com.social.beans.util;

import java.util.Comparator;

import com.social.beans.Message;

public class MsgTimestampComparator implements Comparator<Message> {

	@Override
	public int compare(Message o1, Message o2) {
		return o2.getMessageTimeStamp().compareTo(o1.getMessageTimeStamp());
	}

}
