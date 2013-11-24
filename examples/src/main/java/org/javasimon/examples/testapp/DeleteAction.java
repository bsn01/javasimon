package org.javasimon.examples.testapp;

import java.sql.Connection;
import java.sql.SQLException;

import org.javasimon.SimonManager;
import org.javasimon.Split;
import org.javasimon.examples.testapp.model.TupleDAO;
import org.javasimon.examples.testapp.test.Action;

/**
 * Class DeleteAction.
 *
 * @author Radovan Sninsky
 * @since 2.0
 */
public class DeleteAction implements Action {

	private RandomNumberDataProvider provider;
	private Connection conn;

	/**
	 * Delete action constructor.
	 *
	 * @param provider random number data provider
	 * @param conn SQL connection
	 */
	public DeleteAction(RandomNumberDataProvider provider, Connection conn) {
		this.provider = provider;
		this.conn = conn;
	}

	/**
	 * Deletes random record.
	 *
	 * @param runno run number
	 */
	public void perform(int runno) {
		Split split = SimonManager.getStopwatch("org.javasimon.examples.testapp.action.delete").start();

		int no = provider.no();
		try {
			int deleted = new TupleDAO(conn, "tuple").deleteByUnique1(no);
			System.out.println("Run: " + runno + ", DeleteAction [unique1: " + no + ", deleted: " + deleted + "]");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		split.stop();
	}
}
