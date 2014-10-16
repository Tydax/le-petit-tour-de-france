package test.tydax.models;

import main.tydax.models.Stage;
import main.tydax.models.exceptions.StageNotYetRunException;

import org.junit.Before;
import org.junit.Test;

public class StageTest {

	private Stage mStage;
	
	@Before
	public void initialiseField() {
		mStage = Stage.createStage();
	}
	
	@Test(expected=StageNotYetRunException.class)
	public void testResultsThrowExceptionWhenStageNotRun() throws Exception {
		mStage.results();
	}
	
	@Test(expected=StageNotYetRunException.class)
	public void testWithdrawalsThrowExceptionWhenStageNotRun() throws Exception {
		mStage.withdrawals();
	}
}
