package org.gdq.learn.principles.ocp;

/**
 * @author God_q1
 * date 2020/4/29
 * description
 */
public class Windows {
	private AbstractSubject abstractSubject;

	public void display() {
		abstractSubject.display();
	}
}